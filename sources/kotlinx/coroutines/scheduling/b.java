package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.i0;

/* loaded from: classes7.dex */
public final class b extends e {

    /* renamed from: g, reason: collision with root package name */
    public static final b f68056g = new b();

    private b() {
        super(g.f68065c, g.f68066d, g.f68067e, g.f68063a);
    }

    @Override // kotlinx.coroutines.scheduling.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.i0
    public i0 limitedParallelism(int i11, String str) {
        kotlinx.coroutines.internal.i.a(i11);
        return i11 >= g.f68065c ? kotlinx.coroutines.internal.i.b(this, str) : super.limitedParallelism(i11, str);
    }

    @Override // kotlinx.coroutines.i0
    public String toString() {
        return "Dispatchers.Default";
    }
}
