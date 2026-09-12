package v;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Object f77079a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f77080b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a() {
        /*
            r1 = this;
            w.c r0 = w.c.f77610a
            r1.<init>(r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.a.<init>():void");
    }

    public a(Object obj) {
        this(obj, w.c.f77610a);
    }

    public a(Object obj, Object obj2) {
        this.f77079a = obj;
        this.f77080b = obj2;
    }

    public final boolean a() {
        return this.f77080b != w.c.f77610a;
    }

    public final boolean b() {
        return this.f77079a != w.c.f77610a;
    }

    public final Object c() {
        return this.f77080b;
    }

    public final Object d() {
        return this.f77079a;
    }

    public final a e(Object obj) {
        return new a(this.f77079a, obj);
    }

    public final a f(Object obj) {
        return new a(obj, this.f77080b);
    }
}
