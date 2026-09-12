package l2;

import androidx.media3.common.ParserException;
import androidx.media3.container.g;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final List f68690a;

    /* renamed from: b, reason: collision with root package name */
    public final int f68691b;

    /* renamed from: c, reason: collision with root package name */
    public final int f68692c;

    /* renamed from: d, reason: collision with root package name */
    public final int f68693d;

    /* renamed from: e, reason: collision with root package name */
    public final int f68694e;

    /* renamed from: f, reason: collision with root package name */
    public final int f68695f;

    /* renamed from: g, reason: collision with root package name */
    public final int f68696g;

    /* renamed from: h, reason: collision with root package name */
    public final int f68697h;

    /* renamed from: i, reason: collision with root package name */
    public final int f68698i;

    /* renamed from: j, reason: collision with root package name */
    public final int f68699j;

    /* renamed from: k, reason: collision with root package name */
    public final int f68700k;

    /* renamed from: l, reason: collision with root package name */
    public final float f68701l;

    /* renamed from: m, reason: collision with root package name */
    public final int f68702m;

    /* renamed from: n, reason: collision with root package name */
    public final String f68703n;

    /* renamed from: o, reason: collision with root package name */
    public final g.k f68704o;

    private f0(List list, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, float f11, int i21, String str, g.k kVar) {
        this.f68690a = list;
        this.f68691b = i11;
        this.f68692c = i12;
        this.f68693d = i13;
        this.f68694e = i14;
        this.f68695f = i15;
        this.f68696g = i16;
        this.f68697h = i17;
        this.f68698i = i18;
        this.f68699j = i19;
        this.f68700k = i20;
        this.f68701l = f11;
        this.f68702m = i21;
        this.f68703n = str;
        this.f68704o = kVar;
    }

    public static f0 a(androidx.media3.common.util.j0 j0Var) {
        return b(j0Var, false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static f0 b(androidx.media3.common.util.j0 j0Var, boolean z10, g.k kVar) {
        int i11;
        int i12;
        g.C0098g t11;
        int i13;
        int i14;
        int i15;
        int i16;
        try {
            if (z10) {
                j0Var.X(4);
            } else {
                j0Var.X(21);
            }
            int H = j0Var.H() & 3;
            int H2 = j0Var.H();
            int f11 = j0Var.f();
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < H2; i19++) {
                j0Var.X(1);
                int P = j0Var.P();
                for (int i20 = 0; i20 < P; i20++) {
                    int P2 = j0Var.P();
                    i18 += P2 + 4;
                    j0Var.X(P2);
                }
            }
            j0Var.W(f11);
            byte[] bArr = new byte[i18];
            g.k kVar2 = kVar;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            int i24 = -1;
            int i25 = -1;
            int i26 = -1;
            int i27 = -1;
            int i28 = -1;
            int i29 = -1;
            int i30 = -1;
            float f12 = 1.0f;
            String str = null;
            int i31 = 0;
            int i32 = 0;
            while (i31 < H2) {
                int H3 = j0Var.H() & 63;
                int P3 = j0Var.P();
                int i33 = i17;
                g.k kVar3 = kVar2;
                while (i33 < P3) {
                    int P4 = j0Var.P();
                    byte[] bArr2 = androidx.media3.container.g.f10675a;
                    int i34 = H2;
                    System.arraycopy(bArr2, i17, bArr, i32, bArr2.length);
                    int length = i32 + bArr2.length;
                    System.arraycopy(j0Var.e(), j0Var.f(), bArr, length, P4);
                    if (H3 == 32 && i33 == 0) {
                        kVar3 = androidx.media3.container.g.y(bArr, length, length + P4);
                        i12 = i17;
                        i11 = P3;
                    } else if (H3 == 33 && i33 == 0) {
                        g.h u11 = androidx.media3.container.g.u(bArr, length, length + P4, kVar3);
                        int i35 = u11.f10709b + 1;
                        int i36 = u11.f10715h;
                        int i37 = u11.f10716i;
                        i24 = u11.f10712e + 8;
                        i25 = u11.f10713f + 8;
                        int i38 = u11.f10719l;
                        int i39 = u11.f10720m;
                        int i40 = u11.f10721n;
                        float f13 = u11.f10717j;
                        int i41 = u11.f10718k;
                        g.c cVar = u11.f10710c;
                        if (cVar != null) {
                            i13 = i41;
                            i14 = i35;
                            i11 = P3;
                            i15 = i37;
                            i16 = i36;
                            str = androidx.media3.common.util.j.f(cVar.f10684a, cVar.f10685b, cVar.f10686c, cVar.f10687d, cVar.f10688e, cVar.f10689f);
                        } else {
                            i13 = i41;
                            i14 = i35;
                            i11 = P3;
                            i15 = i37;
                            i16 = i36;
                        }
                        i21 = i14;
                        i22 = i16;
                        i12 = 0;
                        i26 = i38;
                        i23 = i15;
                        i30 = i13;
                        f12 = f13;
                        i28 = i40;
                        i27 = i39;
                    } else {
                        i11 = P3;
                        if (H3 != 39 || i33 != 0 || (t11 = androidx.media3.container.g.t(bArr, length, length + P4)) == null || kVar3 == null) {
                            i12 = 0;
                        } else {
                            i12 = 0;
                            i29 = t11.f10702d == ((g.a) kVar3.f10728b.get(0)).f10680b ? 4 : 5;
                        }
                    }
                    i32 = length + P4;
                    j0Var.X(P4);
                    i33++;
                    i17 = i12;
                    H2 = i34;
                    P3 = i11;
                }
                i31++;
                kVar2 = kVar3;
            }
            return new f0(i18 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), H + 1, i21, i22, i23, i24, i25, i26, i27, i28, i29, f12, i30, str, kVar2);
        } catch (ArrayIndexOutOfBoundsException e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error parsing");
            sb2.append(z10 ? "L-HEVC config" : "HEVC config");
            throw ParserException.createForMalformedContainer(sb2.toString(), e11);
        }
    }

    public static f0 c(androidx.media3.common.util.j0 j0Var, g.k kVar) {
        return b(j0Var, true, kVar);
    }
}
