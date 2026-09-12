package h2;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class b implements n {

    /* renamed from: b, reason: collision with root package name */
    private final long f64393b;

    /* renamed from: c, reason: collision with root package name */
    private final long f64394c;

    /* renamed from: d, reason: collision with root package name */
    private long f64395d;

    public b(long j11, long j12) {
        this.f64393b = j11;
        this.f64394c = j12;
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        long j11 = this.f64395d;
        if (j11 < this.f64393b || j11 > this.f64394c) {
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long d() {
        return this.f64395d;
    }

    public boolean e() {
        return this.f64395d > this.f64394c;
    }

    public void f() {
        this.f64395d = this.f64393b - 1;
    }

    @Override // h2.n
    public boolean next() {
        this.f64395d++;
        return !e();
    }
}
