package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes4.dex */
final class CurrentParsingState {

    /* renamed from: a, reason: collision with root package name */
    private int f32978a = 0;

    /* renamed from: b, reason: collision with root package name */
    private State f32979b = State.NUMERIC;

    /* loaded from: classes4.dex */
    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f32978a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i11) {
        this.f32978a += i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f32979b == State.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f32979b == State.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f32979b = State.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f32979b = State.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f32979b = State.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i11) {
        this.f32978a = i11;
    }
}
