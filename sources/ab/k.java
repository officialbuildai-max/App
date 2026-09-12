package ab;

/* loaded from: classes4.dex */
public final class k extends g {

    /* renamed from: a, reason: collision with root package name */
    private final g f597a;

    /* renamed from: b, reason: collision with root package name */
    private final float f598b;

    public k(g gVar, float f11) {
        this.f597a = gVar;
        this.f598b = f11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ab.g
    public boolean a() {
        return this.f597a.a();
    }

    @Override // ab.g
    public void b(float f11, float f12, float f13, p pVar) {
        this.f597a.b(f11, f12 - this.f598b, f13, pVar);
    }
}
