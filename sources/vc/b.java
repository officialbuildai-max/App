package vc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    private static final sc.a f77329d = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final String f77330a;

    /* renamed from: b, reason: collision with root package name */
    private final ic.b f77331b;

    /* renamed from: c, reason: collision with root package name */
    private r8.h f77332c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ic.b bVar, String str) {
        this.f77330a = str;
        this.f77331b = bVar;
    }

    private boolean a() {
        if (this.f77332c == null) {
            r8.i iVar = (r8.i) this.f77331b.get();
            if (iVar != null) {
                this.f77332c = iVar.b(this.f77330a, com.google.firebase.perf.v1.g.class, r8.c.b("proto"), new r8.g() { // from class: vc.a
                    @Override // r8.g
                    public final Object apply(Object obj) {
                        return ((com.google.firebase.perf.v1.g) obj).toByteArray();
                    }
                });
            } else {
                f77329d.j("Flg TransportFactory is not available at the moment");
            }
        }
        return this.f77332c != null;
    }

    public void b(com.google.firebase.perf.v1.g gVar) {
        if (a()) {
            this.f77332c.b(r8.d.f(gVar));
        } else {
            f77329d.j("Unable to dispatch event because Flg Transport is not available");
        }
    }
}
