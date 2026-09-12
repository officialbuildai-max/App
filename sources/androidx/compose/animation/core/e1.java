package androidx.compose.animation.core;

/* loaded from: classes.dex */
public final class e1 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    private final float f2498a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2499b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ c1 f2500c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e1(float r1, float r2, androidx.compose.animation.core.o r3) {
        /*
            r0 = this;
            androidx.compose.animation.core.q r3 = androidx.compose.animation.core.w0.a(r3, r1, r2)
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.e1.<init>(float, float, androidx.compose.animation.core.o):void");
    }

    private e1(float f11, float f12, q qVar) {
        this.f2498a = f11;
        this.f2499b = f12;
        this.f2500c = new c1(qVar);
    }

    @Override // androidx.compose.animation.core.v0
    public boolean a() {
        return this.f2500c.a();
    }

    @Override // androidx.compose.animation.core.v0
    public o c(o oVar, o oVar2, o oVar3) {
        return this.f2500c.c(oVar, oVar2, oVar3);
    }

    @Override // androidx.compose.animation.core.v0
    public o e(long j11, o oVar, o oVar2, o oVar3) {
        return this.f2500c.e(j11, oVar, oVar2, oVar3);
    }

    @Override // androidx.compose.animation.core.v0
    public long f(o oVar, o oVar2, o oVar3) {
        return this.f2500c.f(oVar, oVar2, oVar3);
    }

    @Override // androidx.compose.animation.core.v0
    public o g(long j11, o oVar, o oVar2, o oVar3) {
        return this.f2500c.g(j11, oVar, oVar2, oVar3);
    }
}
