package ab;

/* loaded from: classes4.dex */
public final class h extends g {

    /* renamed from: a, reason: collision with root package name */
    private final float f546a;

    public h(float f11) {
        this.f546a = f11 - 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ab.g
    public boolean a() {
        return true;
    }

    @Override // ab.g
    public void b(float f11, float f12, float f13, p pVar) {
        float sqrt = (float) ((this.f546a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.f546a, 2.0d) - Math.pow(sqrt, 2.0d));
        pVar.n(f12 - sqrt, ((float) (-((this.f546a * Math.sqrt(2.0d)) - this.f546a))) + sqrt2);
        pVar.m(f12, (float) (-((this.f546a * Math.sqrt(2.0d)) - this.f546a)));
        pVar.m(f12 + sqrt, ((float) (-((this.f546a * Math.sqrt(2.0d)) - this.f546a))) + sqrt2);
    }
}
