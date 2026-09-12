package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.UploadTask;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class UploadPartTask implements Callable<Boolean> {

    /* renamed from: f, reason: collision with root package name */
    private static final Log f18620f = LogFactory.b(UploadPartTask.class);

    /* renamed from: a, reason: collision with root package name */
    private final UploadTask.UploadPartTaskMetadata f18621a;

    /* renamed from: b, reason: collision with root package name */
    private final UploadTask.UploadTaskProgressListener f18622b;

    /* renamed from: c, reason: collision with root package name */
    private final UploadPartRequest f18623c;

    /* renamed from: d, reason: collision with root package name */
    private final AmazonS3 f18624d;

    /* renamed from: e, reason: collision with root package name */
    private final TransferDBUtil f18625e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class UploadPartTaskProgressListener implements ProgressListener {

        /* renamed from: a, reason: collision with root package name */
        private UploadTask.UploadTaskProgressListener f18626a;

        /* renamed from: b, reason: collision with root package name */
        private long f18627b;

        public UploadPartTaskProgressListener(UploadTask.UploadTaskProgressListener uploadTaskProgressListener) {
            this.f18626a = uploadTaskProgressListener;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void a(ProgressEvent progressEvent) {
            if (32 == progressEvent.b()) {
                UploadPartTask.f18620f.d("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.f18627b = 0L;
            } else {
                this.f18627b += progressEvent.a();
            }
            this.f18626a.b(UploadPartTask.this.f18623c.getPartNumber(), this.f18627b);
        }
    }

    public UploadPartTask(UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata, UploadTask.UploadTaskProgressListener uploadTaskProgressListener, UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.f18621a = uploadPartTaskMetadata;
        this.f18622b = uploadTaskProgressListener;
        this.f18623c = uploadPartRequest;
        this.f18624d = amazonS3;
        this.f18625e = transferDBUtil;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        try {
            this.f18621a.f18640d = TransferState.IN_PROGRESS;
            this.f18623c.setGeneralProgressListener(new UploadPartTaskProgressListener(this.f18622b));
            UploadPartResult a11 = this.f18624d.a(this.f18623c);
            UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata = this.f18621a;
            TransferState transferState = TransferState.PART_COMPLETED;
            uploadPartTaskMetadata.f18640d = transferState;
            this.f18625e.s(this.f18623c.getId(), transferState);
            this.f18625e.q(this.f18623c.getId(), a11.getETag());
            return Boolean.TRUE;
        } catch (Exception e11) {
            Log log = f18620f;
            log.f("Upload part interrupted: " + e11);
            new ProgressEvent(0L).c(32);
            this.f18622b.a(new ProgressEvent(0L));
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    log.d("Thread: [" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata2 = this.f18621a;
                    TransferState transferState2 = TransferState.WAITING_FOR_NETWORK;
                    uploadPartTaskMetadata2.f18640d = transferState2;
                    this.f18625e.s(this.f18623c.getId(), transferState2);
                    log.d("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e12) {
                f18620f.f("TransferUtilityException: [" + e12 + "]");
            }
            UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata3 = this.f18621a;
            TransferState transferState3 = TransferState.FAILED;
            uploadPartTaskMetadata3.f18640d = transferState3;
            this.f18625e.s(this.f18623c.getId(), transferState3);
            f18620f.e("Encountered error uploading part ", e11);
            throw e11;
        }
    }
}
