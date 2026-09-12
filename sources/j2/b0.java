package j2;

import android.util.Pair;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.x3;
import androidx.media3.exoplayer.y3;
import androidx.media3.exoplayer.z3;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class b0 extends e0 {

    /* renamed from: c, reason: collision with root package name */
    private a f65858c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f65859a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f65860b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f65861c;

        /* renamed from: d, reason: collision with root package name */
        private final g2.z[] f65862d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f65863e;

        /* renamed from: f, reason: collision with root package name */
        private final int[][][] f65864f;

        /* renamed from: g, reason: collision with root package name */
        private final g2.z f65865g;

        a(String[] strArr, int[] iArr, g2.z[] zVarArr, int[] iArr2, int[][][] iArr3, g2.z zVar) {
            this.f65860b = strArr;
            this.f65861c = iArr;
            this.f65862d = zVarArr;
            this.f65864f = iArr3;
            this.f65863e = iArr2;
            this.f65865g = zVar;
            this.f65859a = iArr.length;
        }

        public int a(int i11, int i12, boolean z10) {
            int i13 = this.f65862d[i11].b(i12).f10053a;
            int[] iArr = new int[i13];
            int i14 = 0;
            for (int i15 = 0; i15 < i13; i15++) {
                int g11 = g(i11, i12, i15);
                if (g11 == 4 || (z10 && g11 == 3)) {
                    iArr[i14] = i15;
                    i14++;
                }
            }
            return b(i11, i12, Arrays.copyOf(iArr, i14));
        }

        public int b(int i11, int i12, int[] iArr) {
            int i13 = 0;
            int i14 = 16;
            String str = null;
            boolean z10 = false;
            int i15 = 0;
            while (i13 < iArr.length) {
                String str2 = this.f65862d[i11].b(i12).a(iArr[i13]).f10243o;
                int i16 = i15 + 1;
                if (i15 == 0) {
                    str = str2;
                } else {
                    z10 |= !Objects.equals(str, str2);
                }
                i14 = Math.min(i14, x3.f(this.f65864f[i11][i12][i13]));
                i13++;
                i15 = i16;
            }
            return z10 ? Math.min(i14, this.f65863e[i11]) : i14;
        }

        public int c(int i11, int i12, int i13) {
            return this.f65864f[i11][i12][i13];
        }

        public int d() {
            return this.f65859a;
        }

        public int e(int i11) {
            return this.f65861c[i11];
        }

        public g2.z f(int i11) {
            return this.f65862d[i11];
        }

        public int g(int i11, int i12, int i13) {
            return x3.i(c(i11, i12, i13));
        }

        public g2.z h() {
            return this.f65865g;
        }
    }

    private static int n(y3[] y3VarArr, androidx.media3.common.f0 f0Var, int[] iArr, boolean z10) {
        int length = y3VarArr.length;
        int i11 = 0;
        boolean z11 = true;
        for (int i12 = 0; i12 < y3VarArr.length; i12++) {
            y3 y3Var = y3VarArr[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < f0Var.f10053a; i14++) {
                i13 = Math.max(i13, x3.i(y3Var.a(f0Var.a(i14))));
            }
            boolean z12 = iArr[i12] == 0;
            if (i13 > i11 || (i13 == i11 && z10 && !z11 && z12)) {
                length = i12;
                z11 = z12;
                i11 = i13;
            }
        }
        return length;
    }

    private static int[] o(y3 y3Var, androidx.media3.common.f0 f0Var) {
        int[] iArr = new int[f0Var.f10053a];
        for (int i11 = 0; i11 < f0Var.f10053a; i11++) {
            iArr[i11] = y3Var.a(f0Var.a(i11));
        }
        return iArr;
    }

    private static int[] p(y3[] y3VarArr) {
        int length = y3VarArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = y3VarArr[i11].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // j2.e0
    public final void i(Object obj) {
        this.f65858c = (a) obj;
    }

    @Override // j2.e0
    public final f0 k(y3[] y3VarArr, g2.z zVar, r.b bVar, androidx.media3.common.e0 e0Var) {
        int[] iArr = new int[y3VarArr.length + 1];
        int length = y3VarArr.length + 1;
        androidx.media3.common.f0[][] f0VarArr = new androidx.media3.common.f0[length];
        int[][][] iArr2 = new int[y3VarArr.length + 1][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = zVar.f63389a;
            f0VarArr[i11] = new androidx.media3.common.f0[i12];
            iArr2[i11] = new int[i12];
        }
        int[] p11 = p(y3VarArr);
        for (int i13 = 0; i13 < zVar.f63389a; i13++) {
            androidx.media3.common.f0 b11 = zVar.b(i13);
            int n11 = n(y3VarArr, b11, iArr, b11.f10055c == 5);
            int[] o11 = n11 == y3VarArr.length ? new int[b11.f10053a] : o(y3VarArr[n11], b11);
            int i14 = iArr[n11];
            f0VarArr[n11][i14] = b11;
            iArr2[n11][i14] = o11;
            iArr[n11] = i14 + 1;
        }
        g2.z[] zVarArr = new g2.z[y3VarArr.length];
        String[] strArr = new String[y3VarArr.length];
        int[] iArr3 = new int[y3VarArr.length];
        for (int i15 = 0; i15 < y3VarArr.length; i15++) {
            int i16 = iArr[i15];
            zVarArr[i15] = new g2.z((androidx.media3.common.f0[]) a1.X0(f0VarArr[i15], i16));
            iArr2[i15] = (int[][]) a1.X0(iArr2[i15], i16);
            strArr[i15] = y3VarArr[i15].getName();
            iArr3[i15] = y3VarArr[i15].getTrackType();
        }
        a aVar = new a(strArr, iArr3, zVarArr, p11, iArr2, new g2.z((androidx.media3.common.f0[]) a1.X0(f0VarArr[y3VarArr.length], iArr[y3VarArr.length])));
        Pair q11 = q(aVar, iArr2, p11, bVar, e0Var);
        return new f0((z3[]) q11.first, (z[]) q11.second, d0.a(aVar, (c0[]) q11.second), aVar);
    }

    protected abstract Pair q(a aVar, int[][][] iArr, int[] iArr2, r.b bVar, androidx.media3.common.e0 e0Var);
}
