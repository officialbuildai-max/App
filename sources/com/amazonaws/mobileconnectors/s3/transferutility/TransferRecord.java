package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.util.json.JsonUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.Gson;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TransferRecord {
    private static final Log M = LogFactory.b(TransferRecord.class);
    public String A;
    public String B;
    public Map C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public TransferUtilityOptions J;
    private Future K;
    private Gson L = new Gson();

    /* renamed from: a, reason: collision with root package name */
    public int f18563a;

    /* renamed from: b, reason: collision with root package name */
    public int f18564b;

    /* renamed from: c, reason: collision with root package name */
    public int f18565c;

    /* renamed from: d, reason: collision with root package name */
    public int f18566d;

    /* renamed from: e, reason: collision with root package name */
    public int f18567e;

    /* renamed from: f, reason: collision with root package name */
    public int f18568f;

    /* renamed from: g, reason: collision with root package name */
    public int f18569g;

    /* renamed from: h, reason: collision with root package name */
    public long f18570h;

    /* renamed from: i, reason: collision with root package name */
    public long f18571i;

    /* renamed from: j, reason: collision with root package name */
    public long f18572j;

    /* renamed from: k, reason: collision with root package name */
    public long f18573k;

    /* renamed from: l, reason: collision with root package name */
    public long f18574l;

    /* renamed from: m, reason: collision with root package name */
    public long f18575m;

    /* renamed from: n, reason: collision with root package name */
    public TransferType f18576n;

    /* renamed from: o, reason: collision with root package name */
    public TransferState f18577o;

    /* renamed from: p, reason: collision with root package name */
    public String f18578p;

    /* renamed from: q, reason: collision with root package name */
    public String f18579q;

    /* renamed from: r, reason: collision with root package name */
    public String f18580r;

    /* renamed from: s, reason: collision with root package name */
    public String f18581s;

    /* renamed from: t, reason: collision with root package name */
    public String f18582t;

    /* renamed from: u, reason: collision with root package name */
    public String f18583u;

    /* renamed from: v, reason: collision with root package name */
    public String f18584v;

    /* renamed from: w, reason: collision with root package name */
    public String f18585w;

    /* renamed from: x, reason: collision with root package name */
    public String f18586x;

    /* renamed from: y, reason: collision with root package name */
    public String f18587y;

    /* renamed from: z, reason: collision with root package name */
    public String f18588z;

    public TransferRecord(int i11) {
        this.f18563a = i11;
    }

    private boolean c() {
        return this.f18569g == 0 && !TransferState.COMPLETED.equals(this.f18577o);
    }

    private boolean d(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions;
        if (connectivityManager == null || (transferUtilityOptions = this.J) == null || transferUtilityOptions.getTransferNetworkConnectionType().isConnected(connectivityManager)) {
            return true;
        }
        M.d("Network Connection " + this.J.getTransferNetworkConnectionType() + " is not available.");
        transferStatusUpdater.l(this.f18563a, TransferState.WAITING_FOR_NETWORK);
        return false;
    }

    private boolean e(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    public boolean b(final AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (e(this.f18577o)) {
            return false;
        }
        transferStatusUpdater.l(this.f18563a, TransferState.PENDING_CANCEL);
        if (f()) {
            this.K.cancel(true);
        }
        if (TransferType.UPLOAD.equals(this.f18576n) && this.f18566d == 1) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AmazonS3 amazonS32 = amazonS3;
                        TransferRecord transferRecord = TransferRecord.this;
                        amazonS32.e(new AbortMultipartUploadRequest(transferRecord.f18578p, transferRecord.f18579q, transferRecord.f18582t));
                        TransferRecord.M.a("Successfully clean up multipart upload: " + TransferRecord.this.f18563a);
                    } catch (AmazonClientException e11) {
                        TransferRecord.M.g("Failed to abort multiplart upload: " + TransferRecord.this.f18563a, e11);
                    }
                }
            }).start();
        } else if (TransferType.DOWNLOAD.equals(this.f18576n)) {
            new File(this.f18581s).delete();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        Future future = this.K;
        return (future == null || future.isDone()) ? false : true;
    }

    public boolean g(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (e(this.f18577o) || TransferState.PAUSED.equals(this.f18577o)) {
            return false;
        }
        TransferState transferState = TransferState.PENDING_PAUSE;
        if (transferState.equals(this.f18577o)) {
            return false;
        }
        transferStatusUpdater.l(this.f18563a, transferState);
        if (f()) {
            this.K.cancel(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean d11 = d(transferStatusUpdater, connectivityManager);
        boolean z10 = false;
        if (!d11 && !e(this.f18577o)) {
            z10 = true;
            if (f()) {
                this.K.cancel(true);
            }
        }
        return z10;
    }

    public boolean i(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (f() || !c() || !d(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.f18576n.equals(TransferType.DOWNLOAD)) {
            this.K = TransferThreadPool.c(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.K = TransferThreadPool.c(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public void j(Cursor cursor) {
        this.f18563a = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        this.f18564b = cursor.getInt(cursor.getColumnIndexOrThrow("main_upload_id"));
        this.f18576n = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow(NativeComponentConstants.KEY_COMPONENT_TYPE)));
        this.f18577o = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.f18578p = cursor.getString(cursor.getColumnIndexOrThrow("bucket_name"));
        this.f18579q = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        this.f18580r = cursor.getString(cursor.getColumnIndexOrThrow("version_id"));
        this.f18570h = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_total"));
        this.f18571i = cursor.getLong(cursor.getColumnIndexOrThrow("bytes_current"));
        this.f18572j = cursor.getLong(cursor.getColumnIndexOrThrow("speed"));
        this.f18565c = cursor.getInt(cursor.getColumnIndexOrThrow("is_requester_pays"));
        this.f18566d = cursor.getInt(cursor.getColumnIndexOrThrow("is_multipart"));
        this.f18567e = cursor.getInt(cursor.getColumnIndexOrThrow("is_last_part"));
        this.f18568f = cursor.getInt(cursor.getColumnIndexOrThrow("is_encrypted"));
        this.f18569g = cursor.getInt(cursor.getColumnIndexOrThrow("part_num"));
        this.f18583u = cursor.getString(cursor.getColumnIndexOrThrow(DownloadModel.ETAG));
        this.f18581s = cursor.getString(cursor.getColumnIndexOrThrow(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE));
        this.f18582t = cursor.getString(cursor.getColumnIndexOrThrow("multipart_id"));
        this.f18573k = cursor.getLong(cursor.getColumnIndexOrThrow("range_start"));
        this.f18574l = cursor.getLong(cursor.getColumnIndexOrThrow("range_last"));
        this.f18575m = cursor.getLong(cursor.getColumnIndexOrThrow("file_offset"));
        this.f18584v = cursor.getString(cursor.getColumnIndexOrThrow("header_content_type"));
        this.f18585w = cursor.getString(cursor.getColumnIndexOrThrow("header_content_language"));
        this.f18586x = cursor.getString(cursor.getColumnIndexOrThrow("header_content_disposition"));
        this.f18587y = cursor.getString(cursor.getColumnIndexOrThrow("header_content_encoding"));
        this.f18588z = cursor.getString(cursor.getColumnIndexOrThrow("header_cache_control"));
        this.A = cursor.getString(cursor.getColumnIndexOrThrow("header_expire"));
        this.C = JsonUtils.d(cursor.getString(cursor.getColumnIndexOrThrow("user_metadata")));
        this.D = cursor.getString(cursor.getColumnIndexOrThrow("expiration_time_rule_id"));
        this.E = cursor.getString(cursor.getColumnIndexOrThrow("http_expires_date"));
        this.F = cursor.getString(cursor.getColumnIndexOrThrow("sse_algorithm"));
        this.G = cursor.getString(cursor.getColumnIndexOrThrow("kms_key"));
        this.H = cursor.getString(cursor.getColumnIndexOrThrow("content_md5"));
        this.I = cursor.getString(cursor.getColumnIndexOrThrow("canned_acl"));
        this.B = cursor.getString(cursor.getColumnIndexOrThrow("header_storage_class"));
        this.J = (TransferUtilityOptions) this.L.fromJson(cursor.getString(cursor.getColumnIndexOrThrow("transfer_utility_options")), TransferUtilityOptions.class);
    }

    public String toString() {
        return "[id:" + this.f18563a + ",bucketName:" + this.f18578p + ",key:" + this.f18579q + ",file:" + this.f18581s + ",type:" + this.f18576n + ",bytesTotal:" + this.f18570h + ",bytesCurrent:" + this.f18571i + ",fileOffset:" + this.f18575m + ",state:" + this.f18577o + ",cannedAcl:" + this.I + ",mainUploadId:" + this.f18564b + ",isMultipart:" + this.f18566d + ",isLastPart:" + this.f18567e + ",partNumber:" + this.f18569g + ",multipartId:" + this.f18582t + ",eTag:" + this.f18583u + ",storageClass:" + this.B + ",userMetadata:" + this.C.toString() + ",transferUtilityOptions:" + this.L.toJson(this.J) + "]";
    }
}
