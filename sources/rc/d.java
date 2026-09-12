package rc;

/* loaded from: classes5.dex */
public final class d implements uz.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f74428a;

    public d(a aVar) {
        this.f74428a = aVar;
    }

    public static d a(a aVar) {
        return new d(aVar);
    }

    public static jc.e c(a aVar) {
        return (jc.e) hz.b.c(aVar.c());
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public jc.e get() {
        return c(this.f74428a);
    }
}
