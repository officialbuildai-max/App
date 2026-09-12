package j2;

import android.os.SystemClock;
import androidx.media3.common.i0;
import androidx.media3.exoplayer.upstream.m;
import com.google.common.collect.ImmutableList;
import j2.b0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d0 {
    public static i0 a(b0.a aVar, c0[] c0VarArr) {
        List[] listArr = new List[c0VarArr.length];
        for (int i11 = 0; i11 < c0VarArr.length; i11++) {
            c0 c0Var = c0VarArr[i11];
            listArr[i11] = c0Var != null ? ImmutableList.of(c0Var) : ImmutableList.of();
        }
        return b(aVar, listArr);
    }

    public static i0 b(b0.a aVar, List[] listArr) {
        boolean z10;
        ImmutableList.a aVar2 = new ImmutableList.a();
        for (int i11 = 0; i11 < aVar.d(); i11++) {
            g2.z f11 = aVar.f(i11);
            List list = listArr[i11];
            for (int i12 = 0; i12 < f11.f63389a; i12++) {
                androidx.media3.common.f0 b11 = f11.b(i12);
                boolean z11 = aVar.a(i11, i12, false) != 0;
                int i13 = b11.f10053a;
                int[] iArr = new int[i13];
                boolean[] zArr = new boolean[i13];
                for (int i14 = 0; i14 < b11.f10053a; i14++) {
                    iArr[i14] = aVar.g(i11, i12, i14);
                    int i15 = 0;
                    while (true) {
                        if (i15 >= list.size()) {
                            z10 = false;
                            break;
                        }
                        c0 c0Var = (c0) list.get(i15);
                        if (c0Var.getTrackGroup().equals(b11) && c0Var.indexOf(i14) != -1) {
                            z10 = true;
                            break;
                        }
                        i15++;
                    }
                    zArr[i14] = z10;
                }
                aVar2.a(new i0.a(b11, z11, iArr, zArr));
            }
        }
        g2.z h11 = aVar.h();
        for (int i16 = 0; i16 < h11.f63389a; i16++) {
            androidx.media3.common.f0 b12 = h11.b(i16);
            int[] iArr2 = new int[b12.f10053a];
            Arrays.fill(iArr2, 0);
            aVar2.a(new i0.a(b12, false, iArr2, new boolean[b12.f10053a]));
        }
        return new i0(aVar2.e());
    }

    public static m.a c(z zVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = zVar.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (zVar.d(i12, elapsedRealtime)) {
                i11++;
            }
        }
        return new m.a(1, 0, length, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Point d(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = r0
            goto L9
        L8:
            r1 = r3
        L9:
            if (r4 <= r5) goto Lc
            r3 = r0
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = androidx.media3.common.util.a1.k(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = androidx.media3.common.util.a1.k(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.d0.d(boolean, int, int, int, int):android.graphics.Point");
    }
}
