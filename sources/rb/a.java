package rb;

/* loaded from: classes5.dex */
public final class a implements cc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final cc.a f74354a = new a();

    /* renamed from: rb.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C0932a implements bc.c {

        /* renamed from: a, reason: collision with root package name */
        static final C0932a f74355a = new C0932a();

        /* renamed from: b, reason: collision with root package name */
        private static final bc.b f74356b = bc.b.d("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        private static final bc.b f74357c = bc.b.d("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        private static final bc.b f74358d = bc.b.d("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        private static final bc.b f74359e = bc.b.d("variantId");

        /* renamed from: f, reason: collision with root package name */
        private static final bc.b f74360f = bc.b.d("templateVersion");

        private C0932a() {
        }

        @Override // bc.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i iVar, bc.d dVar) {
            dVar.e(f74356b, iVar.e());
            dVar.e(f74357c, iVar.c());
            dVar.e(f74358d, iVar.d());
            dVar.e(f74359e, iVar.g());
            dVar.a(f74360f, iVar.f());
        }
    }

    private a() {
    }

    @Override // cc.a
    public void a(cc.b bVar) {
        C0932a c0932a = C0932a.f74355a;
        bVar.a(i.class, c0932a);
        bVar.a(b.class, c0932a);
    }
}
