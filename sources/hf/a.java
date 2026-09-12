package hf;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final jf.a f64551a = new jf.a();

    /* renamed from: b, reason: collision with root package name */
    private int f64552b = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i11) {
        this.f64552b += i11;
    }

    public final int b() {
        int k11 = this.f64551a.k(this.f64552b);
        return k11 < 0 ? this.f64552b : this.f64551a.p(k11);
    }

    public final int c() {
        return this.f64552b;
    }

    public void d() {
        this.f64551a.e();
        this.f64552b = 0;
    }

    public final void e(int i11, int i12) {
        this.f64551a.n(i11, i12);
    }
}
