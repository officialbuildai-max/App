package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes4.dex */
final class n extends p {

    /* renamed from: b, reason: collision with root package name */
    private final String f32987b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32988c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f32989d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i11, String str) {
        super(i11);
        this.f32987b = str;
        this.f32989d = false;
        this.f32988c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i11, String str, int i12) {
        super(i11);
        this.f32989d = true;
        this.f32988c = i12;
        this.f32987b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f32987b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f32988c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f32989d;
    }
}
