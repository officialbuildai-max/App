package w4;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f77709a;

    /* renamed from: b, reason: collision with root package name */
    private n4.a f77710b;

    /* renamed from: c, reason: collision with root package name */
    protected Object f77711c;

    public c() {
        this.f77709a = new b();
        this.f77711c = null;
    }

    public c(Object obj) {
        this.f77709a = new b();
        this.f77711c = obj;
    }

    public Object a(b bVar) {
        return this.f77711c;
    }

    public final Object b(float f11, float f12, Object obj, Object obj2, float f13, float f14, float f15) {
        return a(this.f77709a.h(f11, f12, obj, obj2, f13, f14, f15));
    }

    public final void c(n4.a aVar) {
        this.f77710b = aVar;
    }
}
