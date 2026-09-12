package com.amazonaws.mobileconnectors.s3.transferutility;

import java.io.File;

/* loaded from: classes2.dex */
public class TransferObserver {

    /* renamed from: a, reason: collision with root package name */
    private final int f18552a;

    /* renamed from: b, reason: collision with root package name */
    private final TransferDBUtil f18553b;

    /* renamed from: c, reason: collision with root package name */
    private String f18554c;

    /* renamed from: d, reason: collision with root package name */
    private String f18555d;

    /* renamed from: e, reason: collision with root package name */
    private long f18556e;

    /* renamed from: f, reason: collision with root package name */
    private long f18557f;

    /* renamed from: g, reason: collision with root package name */
    private TransferState f18558g;

    /* renamed from: h, reason: collision with root package name */
    private String f18559h;

    /* renamed from: i, reason: collision with root package name */
    private TransferListener f18560i;

    /* renamed from: j, reason: collision with root package name */
    private TransferStatusListener f18561j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TransferStatusListener implements TransferListener {
        private TransferStatusListener() {
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void a(int i11, TransferState transferState) {
            TransferObserver.this.f18558g = transferState;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void b(int i11, long j11, long j12) {
            TransferObserver.this.f18557f = j11;
            TransferObserver.this.f18556e = j12;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void c(int i11, Exception exc) {
        }
    }

    TransferObserver(int i11, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.f18552a = i11;
        this.f18553b = transferDBUtil;
        this.f18554c = str;
        this.f18555d = str2;
        this.f18559h = file.getAbsolutePath();
        this.f18556e = file.length();
        this.f18558g = TransferState.WAITING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransferObserver(int i11, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener) {
        this(i11, transferDBUtil, str, str2, file);
        g(transferListener);
    }

    public void d() {
        synchronized (this) {
            try {
                TransferListener transferListener = this.f18560i;
                if (transferListener != null) {
                    TransferStatusUpdater.j(this.f18552a, transferListener);
                    this.f18560i = null;
                }
                TransferStatusListener transferStatusListener = this.f18561j;
                if (transferStatusListener != null) {
                    TransferStatusUpdater.j(this.f18552a, transferStatusListener);
                    this.f18561j = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String e() {
        return this.f18554c;
    }

    public int f() {
        return this.f18552a;
    }

    public void g(TransferListener transferListener) {
        if (transferListener != null) {
            synchronized (this) {
                d();
                TransferStatusListener transferStatusListener = new TransferStatusListener();
                this.f18561j = transferStatusListener;
                TransferStatusUpdater.g(this.f18552a, transferStatusListener);
                this.f18560i = transferListener;
                TransferStatusUpdater.g(this.f18552a, transferListener);
            }
        }
    }

    public String toString() {
        return "TransferObserver{id=" + this.f18552a + ", bucket='" + this.f18554c + "', key='" + this.f18555d + "', bytesTotal=" + this.f18556e + ", bytesTransferred=" + this.f18557f + ", transferState=" + this.f18558g + ", filePath='" + this.f18559h + "'}";
    }
}
