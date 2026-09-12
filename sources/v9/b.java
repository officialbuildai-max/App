package v9;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class b implements o {

    /* renamed from: b, reason: collision with root package name */
    private final long f77232b;

    /* renamed from: c, reason: collision with root package name */
    private final long f77233c;

    /* renamed from: d, reason: collision with root package name */
    private long f77234d;

    public b(long j11, long j12) {
        this.f77232b = j11;
        this.f77233c = j12;
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        long j11 = this.f77234d;
        if (j11 < this.f77232b || j11 > this.f77233c) {
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long d() {
        return this.f77234d;
    }

    public boolean e() {
        return this.f77234d > this.f77233c;
    }

    public void f() {
        this.f77234d = this.f77232b - 1;
    }

    @Override // v9.o
    public boolean next() {
        this.f77234d++;
        return !e();
    }
}
