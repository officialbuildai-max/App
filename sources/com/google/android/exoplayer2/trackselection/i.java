package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.a3;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.y2;
import com.google.android.exoplayer2.z2;
import java.util.Arrays;
import la.m;
import la.q;
import la.r;
import t9.x;

/* loaded from: classes3.dex */
public abstract class i extends q {

    /* renamed from: c, reason: collision with root package name */
    private a f26928c;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f26929a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f26930b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f26931c;

        /* renamed from: d, reason: collision with root package name */
        private final x[] f26932d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f26933e;

        /* renamed from: f, reason: collision with root package name */
        private final int[][][] f26934f;

        /* renamed from: g, reason: collision with root package name */
        private final x f26935g;

        a(String[] strArr, int[] iArr, x[] xVarArr, int[] iArr2, int[][][] iArr3, x xVar) {
            this.f26930b = strArr;
            this.f26931c = iArr;
            this.f26932d = xVarArr;
            this.f26934f = iArr3;
            this.f26933e = iArr2;
            this.f26935g = xVar;
            this.f26929a = iArr.length;
        }

        public int a(int i11, int i12, boolean z10) {
            int i13 = this.f26932d[i11].b(i12).f25727a;
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
                String str2 = this.f26932d[i11].b(i12).c(iArr[i13]).f25550l;
                int i16 = i15 + 1;
                if (i15 == 0) {
                    str = str2;
                } else {
                    z10 |= !p0.c(str, str2);
                }
                i14 = Math.min(i14, y2.d(this.f26934f[i11][i12][i13]));
                i13++;
                i15 = i16;
            }
            return z10 ? Math.min(i14, this.f26933e[i11]) : i14;
        }

        public int c(int i11, int i12, int i13) {
            return this.f26934f[i11][i12][i13];
        }

        public int d() {
            return this.f26929a;
        }

        public int e(int i11) {
            return this.f26931c[i11];
        }

        public x f(int i11) {
            return this.f26932d[i11];
        }

        public int g(int i11, int i12, int i13) {
            return y2.f(c(i11, i12, i13));
        }

        public x h() {
            return this.f26935g;
        }
    }

    private static int k(z2[] z2VarArr, TrackGroup trackGroup, int[] iArr, boolean z10) {
        int length = z2VarArr.length;
        int i11 = 0;
        boolean z11 = true;
        for (int i12 = 0; i12 < z2VarArr.length; i12++) {
            z2 z2Var = z2VarArr[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < trackGroup.f25727a; i14++) {
                i13 = Math.max(i13, y2.f(z2Var.a(trackGroup.c(i14))));
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

    private static int[] l(z2 z2Var, TrackGroup trackGroup) {
        int[] iArr = new int[trackGroup.f25727a];
        for (int i11 = 0; i11 < trackGroup.f25727a; i11++) {
            iArr[i11] = z2Var.a(trackGroup.c(i11));
        }
        return iArr;
    }

    private static int[] m(z2[] z2VarArr) {
        int length = z2VarArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = z2VarArr[i11].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // la.q
    public final void f(Object obj) {
        this.f26928c = (a) obj;
    }

    @Override // la.q
    public final r h(z2[] z2VarArr, x xVar, o.b bVar, k3 k3Var) {
        int[] iArr = new int[z2VarArr.length + 1];
        int length = z2VarArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length];
        int[][][] iArr2 = new int[z2VarArr.length + 1][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = xVar.f76288a;
            trackGroupArr[i11] = new TrackGroup[i12];
            iArr2[i11] = new int[i12];
        }
        int[] m11 = m(z2VarArr);
        for (int i13 = 0; i13 < xVar.f76288a; i13++) {
            TrackGroup b11 = xVar.b(i13);
            int k11 = k(z2VarArr, b11, iArr, b11.f25729c == 5);
            int[] l11 = k11 == z2VarArr.length ? new int[b11.f25727a] : l(z2VarArr[k11], b11);
            int i14 = iArr[k11];
            trackGroupArr[k11][i14] = b11;
            iArr2[k11][i14] = l11;
            iArr[k11] = i14 + 1;
        }
        x[] xVarArr = new x[z2VarArr.length];
        String[] strArr = new String[z2VarArr.length];
        int[] iArr3 = new int[z2VarArr.length];
        for (int i15 = 0; i15 < z2VarArr.length; i15++) {
            int i16 = iArr[i15];
            xVarArr[i15] = new x((TrackGroup[]) p0.G0(trackGroupArr[i15], i16));
            iArr2[i15] = (int[][]) p0.G0(iArr2[i15], i16);
            strArr[i15] = z2VarArr[i15].getName();
            iArr3[i15] = z2VarArr[i15].getTrackType();
        }
        a aVar = new a(strArr, iArr3, xVarArr, m11, iArr2, new x((TrackGroup[]) p0.G0(trackGroupArr[z2VarArr.length], iArr[z2VarArr.length])));
        Pair n11 = n(aVar, iArr2, m11, bVar, k3Var);
        return new r((a3[]) n11.first, (h[]) n11.second, j.b(aVar, (m[]) n11.second), aVar);
    }

    protected abstract Pair n(a aVar, int[][][] iArr, int[] iArr2, o.b bVar, k3 k3Var);
}
