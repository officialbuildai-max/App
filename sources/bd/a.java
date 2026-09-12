package bd;

/* loaded from: classes4.dex */
public final class a implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f16414a = new a();

    /* renamed from: bd.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0153a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0153a f16415a = new C0153a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f16416b = bc.b.d("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f16417c = bc.b.d("variantId");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f16418d = bc.b.d("parameterKey");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f16419e = bc.b.d("parameterValue");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f16420f = bc.b.d("templateVersion");

        private C0153a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d dVar, bc.d dVar2) {
            dVar2.e(f16416b, dVar.d());
            dVar2.e(f16417c, dVar.f());
            dVar2.e(f16418d, dVar.b());
            dVar2.e(f16419e, dVar.c());
            dVar2.a(f16420f, dVar.e());
        }
    }

    private a() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        C0153a c0153a = C0153a.f16415a;
        bVar.a(d.class, c0153a);
        bVar.a(b.class, c0153a);
    }
}
