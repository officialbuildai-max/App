package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DownloadTask implements Callable<Boolean> {

    /* renamed from: d, reason: collision with root package name */
    private static final Log f18529d = LogFactory.b(DownloadTask.class);

    /* renamed from: a, reason: collision with root package name */
    private final AmazonS3 f18530a;

    /* renamed from: b, reason: collision with root package name */
    private final TransferRecord f18531b;

    /* renamed from: c, reason: collision with root package name */
    private final TransferStatusUpdater f18532c;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.f18531b = transferRecord;
        this.f18530a = amazonS3;
        this.f18532c = transferStatusUpdater;
    }

    private void b(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, file.length() > 0));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SocketTimeoutException e11) {
            e = e11;
        } catch (IOException e12) {
            e = e12;
        }
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e13) {
                        f18529d.i("got exception", e13);
                    }
                }
            }
            bufferedOutputStream.close();
            try {
                inputStream.close();
            } catch (IOException e14) {
                f18529d.i("got exception", e14);
            }
        } catch (SocketTimeoutException e15) {
            e = e15;
            String str = "SocketTimeoutException: Unable to retrieve contents over network: " + e.getMessage();
            f18529d.f(str);
            throw new AmazonClientException(str, e);
        } catch (IOException e16) {
            e = e16;
            throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e17) {
                    f18529d.i("got exception", e17);
                }
            }
            if (inputStream == null) {
                throw th;
            }
            try {
                inputStream.close();
                throw th;
            } catch (IOException e18) {
                f18529d.i("got exception", e18);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                f18529d.d("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.f18532c.l(this.f18531b.f18563a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e11) {
            f18529d.f("TransferUtilityException: [" + e11 + "]");
        }
        this.f18532c.l(this.f18531b.f18563a, TransferState.IN_PROGRESS);
        ProgressListener f11 = this.f18532c.f(this.f18531b.f18563a);
        try {
            TransferRecord transferRecord = this.f18531b;
            GetObjectRequest getObjectRequest = new GetObjectRequest(transferRecord.f18578p, transferRecord.f18579q);
            TransferUtility.b(getObjectRequest);
            File file = new File(this.f18531b.f18581s);
            long length = file.length();
            if (length > 0) {
                f18529d.a(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.f18531b.f18563a), Long.valueOf(length)));
                getObjectRequest.setRange(length, -1L);
            }
            getObjectRequest.setGeneralProgressListener(f11);
            S3Object d11 = this.f18530a.d(getObjectRequest);
            if (d11 == null) {
                this.f18532c.i(this.f18531b.f18563a, new IllegalStateException("AmazonS3.getObject returns null"));
                this.f18532c.l(this.f18531b.f18563a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            long instanceLength = d11.getObjectMetadata().getInstanceLength();
            this.f18532c.k(this.f18531b.f18563a, length, instanceLength, true);
            b(d11.getObjectContent(), file);
            this.f18532c.k(this.f18531b.f18563a, instanceLength, instanceLength, true);
            this.f18532c.l(this.f18531b.f18563a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e12) {
            if (TransferState.PENDING_CANCEL.equals(this.f18531b.f18577o)) {
                TransferStatusUpdater transferStatusUpdater = this.f18532c;
                int i11 = this.f18531b.f18563a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.l(i11, transferState);
                f18529d.d("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.f18531b.f18577o)) {
                TransferStatusUpdater transferStatusUpdater2 = this.f18532c;
                int i12 = this.f18531b.f18563a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.l(i12, transferState2);
                f18529d.d("Transfer is " + transferState2);
                new ProgressEvent(0L).c(32);
                f11.a(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    Log log = f18529d;
                    log.d("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.f18532c.l(this.f18531b.f18563a, TransferState.WAITING_FOR_NETWORK);
                    log.a("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).c(32);
                    f11.a(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e13) {
                f18529d.f("TransferUtilityException: [" + e13 + "]");
            }
            if (RetryUtils.b(e12)) {
                f18529d.d("Transfer is interrupted. " + e12);
                this.f18532c.l(this.f18531b.f18563a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            f18529d.a("Failed to download: " + this.f18531b.f18563a + " due to " + e12.getMessage());
            this.f18532c.i(this.f18531b.f18563a, e12);
            this.f18532c.l(this.f18531b.f18563a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }
}
