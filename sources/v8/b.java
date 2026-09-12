package v8;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static final b f77210b = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final d f77211a;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private d f77212a = null;

        a() {
        }

        public b a() {
            return new b(this.f77212a);
        }

        public a b(d dVar) {
            this.f77212a = dVar;
            return this;
        }
    }

    b(d dVar) {
        this.f77211a = dVar;
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return this.f77211a;
    }
}
