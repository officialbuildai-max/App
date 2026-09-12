package l2;

import java.util.Arrays;

/* loaded from: classes2.dex */
public interface s0 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f68802a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f68803b;

        /* renamed from: c, reason: collision with root package name */
        public final int f68804c;

        /* renamed from: d, reason: collision with root package name */
        public final int f68805d;

        public a(int i11, byte[] bArr, int i12, int i13) {
            this.f68802a = i11;
            this.f68803b = bArr;
            this.f68804c = i12;
            this.f68805d = i13;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f68802a == aVar.f68802a && this.f68804c == aVar.f68804c && this.f68805d == aVar.f68805d && Arrays.equals(this.f68803b, aVar.f68803b);
        }

        public int hashCode() {
            return (((((this.f68802a * 31) + Arrays.hashCode(this.f68803b)) * 31) + this.f68804c) * 31) + this.f68805d;
        }
    }

    void a(androidx.media3.common.util.j0 j0Var, int i11, int i12);

    void b(androidx.media3.common.util.j0 j0Var, int i11);

    void c(androidx.media3.common.r rVar);

    void d(long j11, int i11, int i12, int i13, a aVar);

    int e(androidx.media3.common.j jVar, int i11, boolean z10);

    void f(long j11);

    int g(androidx.media3.common.j jVar, int i11, boolean z10, int i12);
}
