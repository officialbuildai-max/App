package rc;

/* loaded from: classes5.dex */
public final class e implements uz.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f74429a;

    public e(a aVar) {
        this.f74429a = aVar;
    }

    public static e a(a aVar) {
        return new e(aVar);
    }

    public static ic.b c(a aVar) {
        return (ic.b) hz.b.c(aVar.d());
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ic.b get() {
        return c(this.f74429a);
    }
}
