package g9;

import com.google.android.exoplayer2.o1;
import java.util.Arrays;

/* loaded from: classes3.dex */
public interface e0 {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f63513a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f63514b;

        /* renamed from: c, reason: collision with root package name */
        public final int f63515c;

        /* renamed from: d, reason: collision with root package name */
        public final int f63516d;

        public a(int i11, byte[] bArr, int i12, int i13) {
            this.f63513a = i11;
            this.f63514b = bArr;
            this.f63515c = i12;
            this.f63516d = i13;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f63513a == aVar.f63513a && this.f63515c == aVar.f63515c && this.f63516d == aVar.f63516d && Arrays.equals(this.f63514b, aVar.f63514b);
        }

        public int hashCode() {
            return (((((this.f63513a * 31) + Arrays.hashCode(this.f63514b)) * 31) + this.f63515c) * 31) + this.f63516d;
        }
    }

    int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10, int i12);

    int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10);

    void c(com.google.android.exoplayer2.util.d0 d0Var, int i11);

    void d(long j11, int i11, int i12, int i13, a aVar);

    void e(o1 o1Var);

    void f(com.google.android.exoplayer2.util.d0 d0Var, int i11, int i12);
}
