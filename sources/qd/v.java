package qd;

import com.google.zxing.ReaderException;

/* loaded from: classes5.dex */
final class v {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f73718c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    private final t f73719a = new t();

    /* renamed from: b, reason: collision with root package name */
    private final u f73720b = new u();

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.j a(int i11, id.a aVar, int i12) {
        int[] n11 = w.n(aVar, i12, false, f73718c);
        try {
            return this.f73720b.b(i11, aVar, n11);
        } catch (ReaderException unused) {
            return this.f73719a.b(i11, aVar, n11);
        }
    }
}
