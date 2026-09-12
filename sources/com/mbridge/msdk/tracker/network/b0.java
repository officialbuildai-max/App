package com.mbridge.msdk.tracker.network;

/* loaded from: classes5.dex */
public abstract class b0 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final q f38614a;

    /* renamed from: b, reason: collision with root package name */
    private long f38615b;

    /* renamed from: c, reason: collision with root package name */
    private int f38616c;

    /* renamed from: d, reason: collision with root package name */
    private String f38617d;

    public b0() {
        this.f38616c = 0;
        this.f38617d = "";
        this.f38614a = null;
    }

    public b0(q qVar) {
        this.f38616c = 0;
        this.f38617d = "";
        this.f38614a = qVar;
    }

    public b0(String str) {
        super(str);
        this.f38616c = 0;
        this.f38617d = "";
        this.f38614a = null;
    }

    public b0(Throwable th2) {
        super(th2);
        this.f38616c = 0;
        this.f38617d = "";
        this.f38614a = null;
    }

    public abstract int a();

    public void a(int i11) {
        this.f38616c = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j11) {
        this.f38615b = j11;
    }

    public int b() {
        return this.f38616c;
    }
}
