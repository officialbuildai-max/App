package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class TransferUtility {

    /* renamed from: g, reason: collision with root package name */
    private static final Log f18607g = LogFactory.b(TransferUtility.class);

    /* renamed from: h, reason: collision with root package name */
    private static final Object f18608h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static String f18609i = "";

    /* renamed from: a, reason: collision with root package name */
    private TransferStatusUpdater f18610a;

    /* renamed from: b, reason: collision with root package name */
    private TransferDBUtil f18611b;

    /* renamed from: c, reason: collision with root package name */
    final ConnectivityManager f18612c;

    /* renamed from: d, reason: collision with root package name */
    private final AmazonS3 f18613d;

    /* renamed from: e, reason: collision with root package name */
    private final String f18614e;

    /* renamed from: f, reason: collision with root package name */
    private final TransferUtilityOptions f18615f;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private AmazonS3 f18616a;

        /* renamed from: b, reason: collision with root package name */
        private Context f18617b;

        /* renamed from: c, reason: collision with root package name */
        private String f18618c;

        /* renamed from: d, reason: collision with root package name */
        private TransferUtilityOptions f18619d;

        protected Builder() {
        }

        public TransferUtility a() {
            if (this.f18616a == null) {
                throw new IllegalArgumentException("AmazonS3 client is required please set using .s3Client(yourClient)");
            }
            if (this.f18617b == null) {
                throw new IllegalArgumentException("Context is required please set using .context(applicationContext)");
            }
            if (this.f18619d == null) {
                this.f18619d = new TransferUtilityOptions();
            }
            return new TransferUtility(this.f18616a, this.f18617b, this.f18618c, this.f18619d);
        }

        public Builder b(Context context) {
            this.f18617b = context.getApplicationContext();
            return this;
        }

        public Builder c(AmazonS3 amazonS3) {
            this.f18616a = amazonS3;
            return this;
        }
    }

    private TransferUtility(AmazonS3 amazonS3, Context context, String str, TransferUtilityOptions transferUtilityOptions) {
        this.f18613d = amazonS3;
        this.f18614e = str;
        this.f18615f = transferUtilityOptions;
        this.f18611b = new TransferDBUtil(context.getApplicationContext());
        this.f18610a = TransferStatusUpdater.c(context.getApplicationContext());
        TransferThreadPool.b(transferUtilityOptions.getTransferThreadPoolSize());
        this.f18612c = (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AmazonWebServiceRequest a(AmazonWebServiceRequest amazonWebServiceRequest) {
        amazonWebServiceRequest.getRequestClientOptions().a("TransferService_multipart/" + f() + VersionInfoUtils.c());
        return amazonWebServiceRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AmazonWebServiceRequest b(AmazonWebServiceRequest amazonWebServiceRequest) {
        amazonWebServiceRequest.getRequestClientOptions().a("TransferService/" + f() + VersionInfoUtils.c());
        return amazonWebServiceRequest;
    }

    public static Builder c() {
        return new Builder();
    }

    private int e(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        long length = file.length();
        double d11 = length;
        long max = (long) Math.max(Math.ceil(d11 / 10000.0d), 5242880.0d);
        int ceil = ((int) Math.ceil(d11 / max)) + 1;
        ContentValues[] contentValuesArr = new ContentValues[ceil];
        contentValuesArr[0] = this.f18611b.d(str, str2, file, 0L, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList, this.f18615f);
        int i11 = 1;
        long j11 = 0;
        for (int i12 = 1; i12 < ceil; i12++) {
            long min = Math.min(max, length);
            length -= max;
            contentValuesArr[i12] = this.f18611b.d(str, str2, file, j11, i11, "", min, length <= 0 ? 1 : 0, objectMetadata, cannedAccessControlList, this.f18615f);
            j11 += max;
            i11++;
        }
        return this.f18611b.a(contentValuesArr);
    }

    private static String f() {
        synchronized (f18608h) {
            try {
                String str = f18609i;
                if (str != null && !str.trim().isEmpty()) {
                    return f18609i.trim() + "/";
                }
                return "";
            } finally {
            }
        }
    }

    private boolean g(File file) {
        return file != null && file.length() > 5242880;
    }

    private synchronized void h(String str, int i11) {
        S3ClientReference.b(Integer.valueOf(i11), this.f18613d);
        TransferRecord d11 = this.f18610a.d(i11);
        if (d11 == null) {
            d11 = this.f18611b.j(i11);
            if (d11 == null) {
                f18607g.f("Cannot find transfer with id: " + i11);
                return;
            }
            this.f18610a.b(d11);
        } else if ("add_transfer".equals(str)) {
            f18607g.j("Transfer has already been added: " + i11);
            return;
        }
        if (!"add_transfer".equals(str) && !"resume_transfer".equals(str)) {
            if ("pause_transfer".equals(str)) {
                d11.g(this.f18613d, this.f18610a);
            } else if ("cancel_transfer".equals(str)) {
                d11.b(this.f18613d, this.f18610a);
            } else {
                f18607g.f("Unknown action: " + str);
            }
        }
        d11.i(this.f18613d, this.f18611b, this.f18610a, this.f18612c);
    }

    public boolean d(int i11) {
        h("cancel_transfer", i11);
        return true;
    }

    public TransferObserver i(String str, String str2, File file) {
        return j(str, str2, file, new ObjectMetadata());
    }

    public TransferObserver j(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return k(str, str2, file, objectMetadata, null);
    }

    public TransferObserver k(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return l(str, str2, file, objectMetadata, cannedAccessControlList, null);
    }

    public TransferObserver l(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        if (file == null || file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        int e11 = g(file) ? e(str, str2, file, objectMetadata, cannedAccessControlList) : Integer.parseInt(this.f18611b.k(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList, this.f18615f).getLastPathSegment());
        TransferObserver transferObserver = new TransferObserver(e11, this.f18611b, str, str2, file, transferListener);
        h("add_transfer", e11);
        return transferObserver;
    }
}
