package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class UploadTask implements Callable<Boolean> {

    /* renamed from: g, reason: collision with root package name */
    private static final Log f18629g = LogFactory.b(UploadTask.class);

    /* renamed from: h, reason: collision with root package name */
    private static final Map f18630h = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final AmazonS3 f18631a;

    /* renamed from: b, reason: collision with root package name */
    private final TransferRecord f18632b;

    /* renamed from: c, reason: collision with root package name */
    private final TransferDBUtil f18633c;

    /* renamed from: d, reason: collision with root package name */
    private final TransferStatusUpdater f18634d;

    /* renamed from: e, reason: collision with root package name */
    Map f18635e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private List f18636f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class UploadPartTaskMetadata {

        /* renamed from: a, reason: collision with root package name */
        UploadPartRequest f18637a;

        /* renamed from: b, reason: collision with root package name */
        Future f18638b;

        /* renamed from: c, reason: collision with root package name */
        long f18639c;

        /* renamed from: d, reason: collision with root package name */
        TransferState f18640d;

        UploadPartTaskMetadata() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class UploadTaskProgressListener implements ProgressListener {

        /* renamed from: a, reason: collision with root package name */
        private long f18642a;

        UploadTaskProgressListener(TransferRecord transferRecord) {
            this.f18642a = transferRecord.f18571i;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void a(ProgressEvent progressEvent) {
        }

        public synchronized void b(int i11, long j11) {
            UploadPartTaskMetadata uploadPartTaskMetadata = (UploadPartTaskMetadata) UploadTask.this.f18635e.get(Integer.valueOf(i11));
            if (uploadPartTaskMetadata == null) {
                UploadTask.f18629g.d("Update received for unknown part. Ignoring.");
                return;
            }
            uploadPartTaskMetadata.f18639c = j11;
            Iterator it = UploadTask.this.f18635e.entrySet().iterator();
            long j12 = 0;
            while (it.hasNext()) {
                j12 += ((UploadPartTaskMetadata) ((Map.Entry) it.next()).getValue()).f18639c;
            }
            if (j12 > this.f18642a) {
                UploadTask.this.f18634d.k(UploadTask.this.f18632b.f18563a, j12, UploadTask.this.f18632b.f18570h, true);
                this.f18642a = j12;
            }
        }
    }

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            f18630h.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.f18632b = transferRecord;
        this.f18631a = amazonS3;
        this.f18633c = transferDBUtil;
        this.f18634d = transferStatusUpdater;
    }

    private void a(int i11, String str, String str2, String str3) {
        Log log = f18629g;
        log.d("Aborting the multipart since complete multipart failed.");
        try {
            this.f18631a.e(new AbortMultipartUploadRequest(str, str2, str3));
            log.a("Successfully aborted multipart upload: " + i11);
        } catch (AmazonClientException e11) {
            f18629g.g("Failed to abort the multipart upload: " + i11, e11);
        }
    }

    private void f(int i11, String str, String str2, String str3) {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.f18633c.m(i11));
        TransferUtility.a(completeMultipartUploadRequest);
        this.f18631a.b(completeMultipartUploadRequest);
    }

    private PutObjectRequest g(TransferRecord transferRecord) {
        File file = new File(transferRecord.f18581s);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.f18578p, transferRecord.f18579q, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        String str = transferRecord.f18588z;
        if (str != null) {
            objectMetadata.setCacheControl(str);
        }
        String str2 = transferRecord.f18586x;
        if (str2 != null) {
            objectMetadata.setContentDisposition(str2);
        }
        String str3 = transferRecord.f18587y;
        if (str3 != null) {
            objectMetadata.setContentEncoding(str3);
        }
        String str4 = transferRecord.f18584v;
        if (str4 != null) {
            objectMetadata.setContentType(str4);
        } else {
            objectMetadata.setContentType(Mimetypes.a().b(file));
        }
        String str5 = transferRecord.B;
        if (str5 != null) {
            putObjectRequest.setStorageClass(str5);
        }
        String str6 = transferRecord.D;
        if (str6 != null) {
            objectMetadata.setExpirationTimeRuleId(str6);
        }
        if (transferRecord.E != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.E).longValue()));
        }
        String str7 = transferRecord.F;
        if (str7 != null) {
            objectMetadata.setSSEAlgorithm(str7);
        }
        Map<String, String> map = transferRecord.C;
        if (map != null) {
            objectMetadata.setUserMetadata(map);
            String str8 = (String) transferRecord.C.get("x-amz-tagging");
            if (str8 != null) {
                try {
                    String[] split = str8.split(UrlUtils.AND_MARK);
                    ArrayList arrayList = new ArrayList();
                    for (String str9 : split) {
                        String[] split2 = str9.split(UrlUtils.EQUAL_MARK);
                        arrayList.add(new Tag(split2[0], split2[1]));
                    }
                    putObjectRequest.setTagging(new ObjectTagging(arrayList));
                } catch (Exception e11) {
                    f18629g.e("Error in passing the object tags as request headers.", e11);
                }
            }
            String str10 = (String) transferRecord.C.get("x-amz-website-redirect-location");
            if (str10 != null) {
                putObjectRequest.setRedirectLocation(str10);
            }
            String str11 = (String) transferRecord.C.get("x-amz-request-payer");
            if (str11 != null) {
                putObjectRequest.setRequesterPays("requester".equals(str11));
            }
        }
        String str12 = transferRecord.H;
        if (str12 != null) {
            objectMetadata.setContentMD5(str12);
        }
        String str13 = transferRecord.G;
        if (str13 != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(str13));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(h(transferRecord.I));
        return putObjectRequest;
    }

    private static CannedAccessControlList h(String str) {
        if (str == null) {
            return null;
        }
        return (CannedAccessControlList) f18630h.get(str);
    }

    private String i(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest withTagging = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams()).withTagging(putObjectRequest.getTagging());
        TransferUtility.a(withTagging);
        return this.f18631a.c(withTagging).a();
    }

    private Boolean j() {
        long j11;
        String str = this.f18632b.f18582t;
        if (str == null || str.isEmpty()) {
            PutObjectRequest g11 = g(this.f18632b);
            TransferUtility.a(g11);
            try {
                this.f18632b.f18582t = i(g11);
                TransferDBUtil transferDBUtil = this.f18633c;
                TransferRecord transferRecord = this.f18632b;
                transferDBUtil.r(transferRecord.f18563a, transferRecord.f18582t);
                j11 = 0;
            } catch (AmazonClientException e11) {
                f18629g.e("Error initiating multipart upload: " + this.f18632b.f18563a + " due to " + e11.getMessage(), e11);
                this.f18634d.i(this.f18632b.f18563a, e11);
                this.f18634d.l(this.f18632b.f18563a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } else {
            long l11 = this.f18633c.l(this.f18632b.f18563a);
            if (l11 > 0) {
                f18629g.d(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.f18632b.f18563a), Long.valueOf(l11)));
            }
            j11 = l11;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(this.f18632b);
        TransferStatusUpdater transferStatusUpdater = this.f18634d;
        TransferRecord transferRecord2 = this.f18632b;
        transferStatusUpdater.k(transferRecord2.f18563a, j11, transferRecord2.f18570h, false);
        TransferDBUtil transferDBUtil2 = this.f18633c;
        TransferRecord transferRecord3 = this.f18632b;
        this.f18636f = transferDBUtil2.g(transferRecord3.f18563a, transferRecord3.f18582t);
        f18629g.d("Multipart upload " + this.f18632b.f18563a + " in " + this.f18636f.size() + " parts.");
        for (UploadPartRequest uploadPartRequest : this.f18636f) {
            TransferUtility.a(uploadPartRequest);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata();
            uploadPartTaskMetadata.f18637a = uploadPartRequest;
            uploadPartTaskMetadata.f18639c = 0L;
            uploadPartTaskMetadata.f18640d = TransferState.WAITING;
            this.f18635e.put(Integer.valueOf(uploadPartRequest.getPartNumber()), uploadPartTaskMetadata);
            uploadPartTaskMetadata.f18638b = TransferThreadPool.c(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener, uploadPartRequest, this.f18631a, this.f18633c));
        }
        try {
            Iterator it = this.f18635e.values().iterator();
            boolean z10 = true;
            while (it.hasNext()) {
                z10 &= ((Boolean) ((UploadPartTaskMetadata) it.next()).f18638b.get()).booleanValue();
            }
            if (!z10) {
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        f18629g.d("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.f18634d.l(this.f18632b.f18563a, TransferState.WAITING_FOR_NETWORK);
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e12) {
                    f18629g.f("TransferUtilityException: [" + e12 + "]");
                }
            }
            f18629g.d("Completing the multi-part upload transfer for " + this.f18632b.f18563a);
            try {
                TransferRecord transferRecord4 = this.f18632b;
                f(transferRecord4.f18563a, transferRecord4.f18578p, transferRecord4.f18579q, transferRecord4.f18582t);
                TransferStatusUpdater transferStatusUpdater2 = this.f18634d;
                TransferRecord transferRecord5 = this.f18632b;
                int i11 = transferRecord5.f18563a;
                long j12 = transferRecord5.f18570h;
                transferStatusUpdater2.k(i11, j12, j12, true);
                this.f18634d.l(this.f18632b.f18563a, TransferState.COMPLETED);
                return Boolean.TRUE;
            } catch (AmazonClientException e13) {
                f18629g.e("Failed to complete multipart: " + this.f18632b.f18563a + " due to " + e13.getMessage(), e13);
                TransferRecord transferRecord6 = this.f18632b;
                a(transferRecord6.f18563a, transferRecord6.f18578p, transferRecord6.f18579q, transferRecord6.f18582t);
                this.f18634d.i(this.f18632b.f18563a, e13);
                this.f18634d.l(this.f18632b.f18563a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } catch (Exception e14) {
            f18629g.f("Upload resulted in an exception. " + e14);
            Iterator it2 = this.f18635e.values().iterator();
            while (it2.hasNext()) {
                ((UploadPartTaskMetadata) it2.next()).f18638b.cancel(true);
            }
            if (TransferState.PENDING_CANCEL.equals(this.f18632b.f18577o)) {
                TransferStatusUpdater transferStatusUpdater3 = this.f18634d;
                int i12 = this.f18632b.f18563a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater3.l(i12, transferState);
                f18629g.d("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.f18632b.f18577o)) {
                TransferStatusUpdater transferStatusUpdater4 = this.f18634d;
                int i13 = this.f18632b.f18563a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater4.l(i13, transferState2);
                f18629g.d("Transfer is " + transferState2);
                return Boolean.FALSE;
            }
            for (UploadPartTaskMetadata uploadPartTaskMetadata2 : this.f18635e.values()) {
                TransferState transferState3 = TransferState.WAITING_FOR_NETWORK;
                if (transferState3.equals(uploadPartTaskMetadata2.f18640d)) {
                    f18629g.d("Individual part is WAITING_FOR_NETWORK.");
                    this.f18634d.l(this.f18632b.f18563a, transferState3);
                    return Boolean.FALSE;
                }
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    f18629g.d("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                    this.f18634d.l(this.f18632b.f18563a, TransferState.WAITING_FOR_NETWORK);
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e15) {
                f18629g.f("TransferUtilityException: [" + e15 + "]");
            }
            if (RetryUtils.b(e14)) {
                f18629g.d("Transfer is interrupted. " + e14);
                this.f18634d.l(this.f18632b.f18563a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            f18629g.e("Error encountered during multi-part upload: " + this.f18632b.f18563a + " due to " + e14.getMessage(), e14);
            this.f18634d.i(this.f18632b.f18563a, e14);
            this.f18634d.l(this.f18632b.f18563a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }

    private Boolean k() {
        PutObjectRequest g11 = g(this.f18632b);
        ProgressListener f11 = this.f18634d.f(this.f18632b.f18563a);
        long length = g11.getFile().length();
        TransferUtility.b(g11);
        g11.setGeneralProgressListener(f11);
        try {
            this.f18631a.f(g11);
            this.f18634d.k(this.f18632b.f18563a, length, length, true);
            this.f18634d.l(this.f18632b.f18563a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e11) {
            if (TransferState.PENDING_CANCEL.equals(this.f18632b.f18577o)) {
                TransferStatusUpdater transferStatusUpdater = this.f18634d;
                int i11 = this.f18632b.f18563a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.l(i11, transferState);
                f18629g.d("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.f18632b.f18577o)) {
                TransferStatusUpdater transferStatusUpdater2 = this.f18634d;
                int i12 = this.f18632b.f18563a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.l(i12, transferState2);
                f18629g.d("Transfer is " + transferState2);
                new ProgressEvent(0L).c(32);
                f11.a(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    Log log = f18629g;
                    log.d("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.f18634d.l(this.f18632b.f18563a, TransferState.WAITING_FOR_NETWORK);
                    log.a("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).c(32);
                    f11.a(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e12) {
                f18629g.f("TransferUtilityException: [" + e12 + "]");
            }
            if (RetryUtils.b(e11)) {
                f18629g.d("Transfer is interrupted. " + e11);
                this.f18634d.l(this.f18632b.f18563a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            f18629g.a("Failed to upload: " + this.f18632b.f18563a + " due to " + e11.getMessage());
            this.f18634d.i(this.f18632b.f18563a, e11);
            this.f18634d.l(this.f18632b.f18563a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                f18629g.d("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.f18634d.l(this.f18632b.f18563a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e11) {
            f18629g.f("TransferUtilityException: [" + e11 + "]");
        }
        this.f18634d.l(this.f18632b.f18563a, TransferState.IN_PROGRESS);
        TransferRecord transferRecord = this.f18632b;
        int i11 = transferRecord.f18566d;
        return (i11 == 1 && transferRecord.f18569g == 0) ? j() : i11 == 0 ? k() : Boolean.FALSE;
    }
}
