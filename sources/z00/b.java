package z00;

/* loaded from: classes7.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private c f79278a;

    public b() {
    }

    public b(c cVar) {
        a(cVar);
    }

    public void a(c cVar) {
        if (this.f79278a != null) {
            throw new IllegalStateException("The Not ResourceSelector accepts a single nested ResourceSelector");
        }
        this.f79278a = cVar;
    }
}
