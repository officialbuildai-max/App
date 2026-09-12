package com.google.zxing.pdf417.decoder;

/* loaded from: classes4.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f33021a;

    /* renamed from: b, reason: collision with root package name */
    private final int f33022b;

    /* renamed from: c, reason: collision with root package name */
    private final int f33023c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33024d;

    /* renamed from: e, reason: collision with root package name */
    private int f33025e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i11, int i12, int i13, int i14) {
        this.f33021a = i11;
        this.f33022b = i12;
        this.f33023c = i13;
        this.f33024d = i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f33023c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f33022b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f33025e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f33021a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f33024d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f33022b - this.f33021a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return h(this.f33025e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i11) {
        return i11 != -1 && this.f33023c == (i11 % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i11) {
        this.f33025e = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f33025e = ((this.f33024d / 30) * 3) + (this.f33023c / 3);
    }

    public String toString() {
        return this.f33025e + "|" + this.f33024d;
    }
}
