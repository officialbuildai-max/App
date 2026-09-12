package androidx.media3.container;

import androidx.media3.common.r;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f10675a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f10676b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    private static final Object f10677c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static int[] f10678d = new int[10];

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f10679a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10680b;

        public a(int i11, int i12) {
            this.f10679a = i11;
            this.f10680b = i12;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10681a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10682b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10683c;

        public b(int i11, int i12, int i13) {
            this.f10681a = i11;
            this.f10682b = i12;
            this.f10683c = i13;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f10684a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10685b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10686c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10687d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f10688e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10689f;

        public c(int i11, boolean z10, int i12, int i13, int[] iArr, int i14) {
            this.f10684a = i11;
            this.f10685b = z10;
            this.f10686c = i12;
            this.f10687d = i13;
            this.f10688e = iArr;
            this.f10689f = i14;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableList f10690a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10691b;

        public d(List list, int[] iArr) {
            this.f10690a = ImmutableList.copyOf((Collection) list);
            this.f10691b = iArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f10692a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10693b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10694c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10695d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10696e;

        public e(int i11, int i12, int i13, int i14, int i15) {
            this.f10692a = i11;
            this.f10693b = i12;
            this.f10694c = i13;
            this.f10695d = i14;
            this.f10696e = i15;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableList f10697a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10698b;

        public f(List list, int[] iArr) {
            this.f10697a = ImmutableList.copyOf((Collection) list);
            this.f10698b = iArr;
        }
    }

    /* renamed from: androidx.media3.container.g$g, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0098g {

        /* renamed from: a, reason: collision with root package name */
        public final int f10699a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10700b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10701c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10702d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10703e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10704f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10705g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10706h;

        /* renamed from: i, reason: collision with root package name */
        public final int f10707i;

        public C0098g(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
            this.f10699a = i11;
            this.f10700b = i12;
            this.f10701c = i13;
            this.f10702d = i14;
            this.f10703e = i15;
            this.f10704f = i16;
            this.f10705g = i17;
            this.f10706h = i18;
            this.f10707i = i19;
        }
    }

    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final b f10708a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10709b;

        /* renamed from: c, reason: collision with root package name */
        public final c f10710c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10711d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10712e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10713f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10714g;

        /* renamed from: h, reason: collision with root package name */
        public final int f10715h;

        /* renamed from: i, reason: collision with root package name */
        public final int f10716i;

        /* renamed from: j, reason: collision with root package name */
        public final float f10717j;

        /* renamed from: k, reason: collision with root package name */
        public final int f10718k;

        /* renamed from: l, reason: collision with root package name */
        public final int f10719l;

        /* renamed from: m, reason: collision with root package name */
        public final int f10720m;

        /* renamed from: n, reason: collision with root package name */
        public final int f10721n;

        public h(b bVar, int i11, c cVar, int i12, int i13, int i14, int i15, int i16, int i17, float f11, int i18, int i19, int i20, int i21) {
            this.f10708a = bVar;
            this.f10709b = i11;
            this.f10710c = cVar;
            this.f10711d = i12;
            this.f10712e = i13;
            this.f10713f = i14;
            this.f10714g = i15;
            this.f10715h = i16;
            this.f10716i = i17;
            this.f10717j = f11;
            this.f10718k = i18;
            this.f10719l = i19;
            this.f10720m = i20;
            this.f10721n = i21;
        }
    }

    /* loaded from: classes2.dex */
    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        public final int f10722a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10723b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10724c;

        public i(int i11, int i12, int i13) {
            this.f10722a = i11;
            this.f10723b = i12;
            this.f10724c = i13;
        }
    }

    /* loaded from: classes2.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableList f10725a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f10726b;

        public j(List list, int[] iArr) {
            this.f10725a = ImmutableList.copyOf((Collection) list);
            this.f10726b = iArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public final b f10727a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f10728b;

        /* renamed from: c, reason: collision with root package name */
        public final d f10729c;

        /* renamed from: d, reason: collision with root package name */
        public final f f10730d;

        /* renamed from: e, reason: collision with root package name */
        public final j f10731e;

        public k(b bVar, List list, d dVar, f fVar, j jVar) {
            this.f10727a = bVar;
            this.f10728b = list != null ? ImmutableList.copyOf((Collection) list) : ImmutableList.of();
            this.f10729c = dVar;
            this.f10730d = fVar;
            this.f10731e = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class l {

        /* renamed from: a, reason: collision with root package name */
        public final int f10732a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10733b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10734c;

        public l(int i11, int i12, boolean z10) {
            this.f10732a = i11;
            this.f10733b = i12;
            this.f10734c = z10;
        }
    }

    /* loaded from: classes2.dex */
    public static final class m {

        /* renamed from: a, reason: collision with root package name */
        public final int f10735a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10736b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10737c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10738d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10739e;

        /* renamed from: f, reason: collision with root package name */
        public final int f10740f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10741g;

        /* renamed from: h, reason: collision with root package name */
        public final float f10742h;

        /* renamed from: i, reason: collision with root package name */
        public final int f10743i;

        /* renamed from: j, reason: collision with root package name */
        public final int f10744j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f10745k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f10746l;

        /* renamed from: m, reason: collision with root package name */
        public final int f10747m;

        /* renamed from: n, reason: collision with root package name */
        public final int f10748n;

        /* renamed from: o, reason: collision with root package name */
        public final int f10749o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f10750p;

        /* renamed from: q, reason: collision with root package name */
        public final int f10751q;

        /* renamed from: r, reason: collision with root package name */
        public final int f10752r;

        /* renamed from: s, reason: collision with root package name */
        public final int f10753s;

        /* renamed from: t, reason: collision with root package name */
        public final int f10754t;

        public m(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11, int i18, int i19, boolean z10, boolean z11, int i20, int i21, int i22, boolean z12, int i23, int i24, int i25, int i26) {
            this.f10735a = i11;
            this.f10736b = i12;
            this.f10737c = i13;
            this.f10738d = i14;
            this.f10739e = i15;
            this.f10740f = i16;
            this.f10741g = i17;
            this.f10742h = f11;
            this.f10743i = i18;
            this.f10744j = i19;
            this.f10745k = z10;
            this.f10746l = z11;
            this.f10747m = i20;
            this.f10748n = i21;
            this.f10749o = i22;
            this.f10750p = z12;
            this.f10751q = i23;
            this.f10752r = i24;
            this.f10753s = i25;
            this.f10754t = i26;
        }
    }

    public static l A(byte[] bArr, int i11, int i12) {
        return B(bArr, i11 + 1, i12);
    }

    public static l B(byte[] bArr, int i11, int i12) {
        androidx.media3.container.h hVar = new androidx.media3.container.h(bArr, i11, i12);
        int i13 = hVar.i();
        int i14 = hVar.i();
        hVar.l();
        return new l(i13, i14, hVar.e());
    }

    public static m C(byte[] bArr, int i11, int i12) {
        return D(bArr, i11 + 1, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.container.g.m D(byte[] r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.g.D(byte[], int, int):androidx.media3.container.g$m");
    }

    private static void E(androidx.media3.container.h hVar, int i11, int[] iArr, int[] iArr2, boolean[][] zArr) {
        for (int i12 = 1; i12 < i11; i12++) {
            boolean e11 = hVar.e();
            int i13 = 0;
            while (i13 < iArr[i12]) {
                if ((i13 <= 0 || !e11) ? i13 == 0 : hVar.e()) {
                    for (int i14 = 0; i14 < iArr2[i12]; i14++) {
                        if (zArr[i12][i14]) {
                            hVar.i();
                        }
                    }
                    hVar.i();
                    hVar.i();
                }
                i13++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    private static void F(androidx.media3.container.h hVar, boolean z10, int i11) {
        ?? r92;
        ?? r12;
        boolean z11;
        boolean e11;
        if (z10) {
            boolean e12 = hVar.e();
            boolean e13 = hVar.e();
            if (e12 || e13) {
                z11 = hVar.e();
                if (z11) {
                    hVar.m(19);
                }
                hVar.m(8);
                if (z11) {
                    hVar.m(4);
                }
                hVar.m(15);
                r12 = e13;
                r92 = e12;
            } else {
                z11 = false;
                r12 = e13;
                r92 = e12;
            }
        } else {
            r92 = 0;
            r12 = 0;
            z11 = false;
        }
        for (int i12 = 0; i12 <= i11; i12++) {
            boolean e14 = hVar.e();
            if (!e14) {
                e14 = hVar.e();
            }
            if (e14) {
                hVar.i();
                e11 = false;
            } else {
                e11 = hVar.e();
            }
            int i13 = !e11 ? hVar.i() : 0;
            int i14 = r92 + r12;
            for (int i15 = 0; i15 < i14; i15++) {
                for (int i16 = 0; i16 <= i13; i16++) {
                    hVar.i();
                    hVar.i();
                    if (z11) {
                        hVar.i();
                        hVar.i();
                    }
                    hVar.l();
                }
            }
        }
    }

    private static void G(androidx.media3.container.h hVar) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (hVar.e()) {
                    int min = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        hVar.h();
                    }
                    for (int i14 = 0; i14 < min; i14++) {
                        hVar.h();
                    }
                } else {
                    hVar.i();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    private static void H(androidx.media3.container.h hVar) {
        int i11 = hVar.i();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i14 == 0 || !hVar.e()) {
                int i15 = hVar.i();
                int i16 = hVar.i();
                int[] iArr3 = new int[i15];
                int i17 = 0;
                while (i17 < i15) {
                    iArr3[i17] = (i17 > 0 ? iArr3[i17 - 1] : 0) - (hVar.i() + 1);
                    hVar.l();
                    i17++;
                }
                int[] iArr4 = new int[i16];
                int i18 = 0;
                while (i18 < i16) {
                    iArr4[i18] = (i18 > 0 ? iArr4[i18 - 1] : 0) + hVar.i() + 1;
                    hVar.l();
                    i18++;
                }
                i12 = i15;
                iArr = iArr3;
                i13 = i16;
                iArr2 = iArr4;
            } else {
                int i19 = i12 + i13;
                int i20 = (1 - ((hVar.e() ? 1 : 0) * 2)) * (hVar.i() + 1);
                int i21 = i19 + 1;
                boolean[] zArr = new boolean[i21];
                for (int i22 = 0; i22 <= i19; i22++) {
                    if (hVar.e()) {
                        zArr[i22] = true;
                    } else {
                        zArr[i22] = hVar.e();
                    }
                }
                int[] iArr5 = new int[i21];
                int[] iArr6 = new int[i21];
                int i23 = 0;
                for (int i24 = i13 - 1; i24 >= 0; i24--) {
                    int i25 = iArr2[i24] + i20;
                    if (i25 < 0 && zArr[i12 + i24]) {
                        iArr5[i23] = i25;
                        i23++;
                    }
                }
                if (i20 < 0 && zArr[i19]) {
                    iArr5[i23] = i20;
                    i23++;
                }
                for (int i26 = 0; i26 < i12; i26++) {
                    int i27 = iArr[i26] + i20;
                    if (i27 < 0 && zArr[i26]) {
                        iArr5[i23] = i27;
                        i23++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr5, i23);
                int i28 = 0;
                for (int i29 = i12 - 1; i29 >= 0; i29--) {
                    int i30 = iArr[i29] + i20;
                    if (i30 > 0 && zArr[i29]) {
                        iArr6[i28] = i30;
                        i28++;
                    }
                }
                if (i20 > 0 && zArr[i19]) {
                    iArr6[i28] = i20;
                    i28++;
                }
                for (int i31 = 0; i31 < i13; i31++) {
                    int i32 = iArr2[i31] + i20;
                    if (i32 > 0 && zArr[i12 + i31]) {
                        iArr6[i28] = i32;
                        i28++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr6, i28);
                iArr = copyOf;
                i12 = i23;
                i13 = i28;
            }
        }
    }

    private static void I(androidx.media3.container.h hVar) {
        int i11 = hVar.i() + 1;
        hVar.m(8);
        for (int i12 = 0; i12 < i11; i12++) {
            hVar.i();
            hVar.i();
            hVar.l();
        }
        hVar.m(20);
    }

    private static void J(androidx.media3.container.h hVar, int i11) {
        int i12 = 8;
        int i13 = 8;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != 0) {
                i12 = ((hVar.h() + i13) + 256) % 256;
            }
            if (i12 != 0) {
                i13 = i12;
            }
        }
    }

    private static void K(androidx.media3.container.h hVar, int i11, boolean[][] zArr) {
        int i12 = hVar.i() + 2;
        if (hVar.e()) {
            hVar.m(i12);
        } else {
            for (int i13 = 1; i13 < i11; i13++) {
                for (int i14 = 0; i14 < i13; i14++) {
                    if (zArr[i13][i14]) {
                        hVar.m(i12);
                    }
                }
            }
        }
        int i15 = hVar.i();
        for (int i16 = 1; i16 <= i15; i16++) {
            hVar.m(8);
        }
    }

    public static int L(byte[] bArr, int i11) {
        int i12;
        synchronized (f10677c) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                try {
                    i13 = g(bArr, i13, i11);
                    if (i13 < i11) {
                        int[] iArr = f10678d;
                        if (iArr.length <= i14) {
                            f10678d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f10678d[i14] = i13;
                        i13 += 3;
                        i14++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i12 = i11 - i14;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                int i18 = f10678d[i17] - i16;
                System.arraycopy(bArr, i16, bArr, i15, i18);
                int i19 = i15 + i18;
                int i20 = i19 + 1;
                bArr[i19] = 0;
                i15 = i19 + 2;
                bArr[i20] = 0;
                i16 += i18 + 3;
            }
            System.arraycopy(bArr, i16, bArr, i15, i12 - i15);
        }
        return i12;
    }

    private static int a(int i11, int i12, int i13, int i14) {
        return i11 - ((i12 == 1 ? 2 : 1) * (i13 + i14));
    }

    private static int b(int i11, int i12, int i13, int i14) {
        int i15 = 2;
        if (i12 != 1 && i12 != 2) {
            i15 = 1;
        }
        return i11 - (i15 * (i13 + i14));
    }

    public static void c(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static String d(androidx.media3.container.h hVar) {
        hVar.m(4);
        int f11 = hVar.f(3);
        hVar.l();
        c q11 = q(hVar, true, f11, null);
        return androidx.media3.common.util.j.f(q11.f10684a, q11.f10685b, q11.f10686c, q11.f10687d, q11.f10688e, q11.f10689f);
    }

    public static int e(byte[] bArr, int i11, int i12, boolean[] zArr) {
        int i13 = i12 - i11;
        androidx.media3.common.util.a.g(i13 >= 0);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            c(zArr);
            return i11 - 3;
        }
        if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            c(zArr);
            return i11 - 2;
        }
        if (i13 > 2 && zArr[2] && bArr[i11] == 0 && bArr[i11 + 1] == 1) {
            c(zArr);
            return i11 - 1;
        }
        int i14 = i12 - 1;
        int i15 = i11 + 2;
        while (i15 < i14) {
            byte b11 = bArr[i15];
            if ((b11 & 254) == 0) {
                int i16 = i15 - 2;
                if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && b11 == 1) {
                    c(zArr);
                    return i16;
                }
                i15 -= 2;
            }
            i15 += 3;
        }
        zArr[0] = i13 <= 2 ? !(i13 != 2 ? !(zArr[1] && bArr[i14] == 1) : !(zArr[2] && bArr[i12 + (-2)] == 0 && bArr[i14] == 1)) : bArr[i12 + (-3)] == 0 && bArr[i12 + (-2)] == 0 && bArr[i14] == 1;
        zArr[1] = i13 <= 1 ? zArr[2] && bArr[i14] == 0 : bArr[i12 + (-2)] == 0 && bArr[i14] == 0;
        zArr[2] = bArr[i14] == 0;
        return i12;
    }

    private static ImmutableList f(byte[] bArr) {
        boolean[] zArr = new boolean[3];
        ImmutableList.a builder = ImmutableList.builder();
        int i11 = 0;
        while (i11 < bArr.length) {
            int e11 = e(bArr, i11, bArr.length, zArr);
            if (e11 != bArr.length) {
                builder.a(Integer.valueOf(e11));
            }
            i11 = e11 + 3;
        }
        return builder.e();
    }

    private static int g(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String h(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            byte[] bArr = (byte[]) list.get(i11);
            int length = bArr.length;
            if (length > 3) {
                ImmutableList f11 = f(bArr);
                for (int i12 = 0; i12 < f11.size(); i12++) {
                    if (((Integer) f11.get(i12)).intValue() + 3 < length) {
                        androidx.media3.container.h hVar = new androidx.media3.container.h(bArr, ((Integer) f11.get(i12)).intValue() + 3, length);
                        b p11 = p(hVar);
                        if (p11.f10681a == 33 && p11.f10682b == 0) {
                            return d(hVar);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static int i(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    public static int j(byte[] bArr, int i11) {
        return bArr[i11 + 3] & 31;
    }

    public static boolean k(byte[] bArr, int i11, int i12, r rVar) {
        if (Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H264)) {
            return l(bArr[i11]);
        }
        if (Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H265)) {
            return m(bArr, i11, i12, rVar);
        }
        return true;
    }

    public static boolean l(byte b11) {
        if (((b11 & 96) >> 5) != 0) {
            return true;
        }
        int i11 = b11 & 31;
        return (i11 == 1 || i11 == 9 || i11 == 14) ? false : true;
    }

    private static boolean m(byte[] bArr, int i11, int i12, r rVar) {
        b p11 = p(new androidx.media3.container.h(bArr, i11, i12 + i11));
        int i13 = p11.f10681a;
        if (i13 == 35) {
            return false;
        }
        return (i13 <= 14 && i13 % 2 == 0 && p11.f10683c == rVar.D - 1) ? false : true;
    }

    public static boolean n(r rVar, byte b11) {
        if ((Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H264) || y.b(rVar.f10239k, MimeTypes.VIDEO_H264)) && (b11 & 31) == 6) {
            return true;
        }
        return (Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H265) || y.b(rVar.f10239k, MimeTypes.VIDEO_H265)) && ((b11 & 126) >> 1) == 39;
    }

    public static int o(r rVar) {
        if (Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H264)) {
            return 1;
        }
        return (Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H265) || y.b(rVar.f10239k, MimeTypes.VIDEO_H265)) ? 2 : 0;
    }

    private static b p(androidx.media3.container.h hVar) {
        hVar.l();
        return new b(hVar.f(6), hVar.f(6), hVar.f(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.media3.container.g.c q(androidx.media3.container.h r19, boolean r20, int r21, androidx.media3.container.g.c r22) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = 6
            int[] r4 = new int[r3]
            r5 = 2
            r6 = 8
            r7 = 0
            if (r20 == 0) goto L42
            int r2 = r0.f(r5)
            boolean r8 = r19.e()
            r9 = 5
            int r9 = r0.f(r9)
            r10 = r7
            r11 = r10
        L1e:
            r12 = 32
            if (r10 >= r12) goto L2e
            boolean r12 = r19.e()
            if (r12 == 0) goto L2b
            r12 = 1
            int r12 = r12 << r10
            r11 = r11 | r12
        L2b:
            int r10 = r10 + 1
            goto L1e
        L2e:
            r10 = r7
        L2f:
            if (r10 >= r3) goto L3a
            int r12 = r0.f(r6)
            r4[r10] = r12
            int r10 = r10 + 1
            goto L2f
        L3a:
            r13 = r2
        L3b:
            r17 = r4
            r14 = r8
            r15 = r9
            r16 = r11
            goto L57
        L42:
            if (r2 == 0) goto L50
            int r3 = r2.f10684a
            boolean r8 = r2.f10685b
            int r9 = r2.f10686c
            int r11 = r2.f10687d
            int[] r4 = r2.f10688e
            r13 = r3
            goto L3b
        L50:
            r17 = r4
            r13 = r7
            r14 = r13
            r15 = r14
            r16 = r15
        L57:
            int r18 = r0.f(r6)
            r2 = r7
        L5c:
            if (r7 >= r1) goto L71
            boolean r3 = r19.e()
            if (r3 == 0) goto L66
            int r2 = r2 + 88
        L66:
            boolean r3 = r19.e()
            if (r3 == 0) goto L6e
            int r2 = r2 + 8
        L6e:
            int r7 = r7 + 1
            goto L5c
        L71:
            r0.m(r2)
            if (r1 <= 0) goto L7b
            int r6 = r6 - r1
            int r6 = r6 * r5
            r0.m(r6)
        L7b:
            androidx.media3.container.g$c r0 = new androidx.media3.container.g$c
            r12 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.g.q(androidx.media3.container.h, boolean, int, androidx.media3.container.g$c):androidx.media3.container.g$c");
    }

    private static e r(androidx.media3.container.h hVar) {
        int i11;
        int i12;
        int i13;
        int f11 = hVar.f(16);
        int f12 = hVar.f(16);
        if (hVar.e()) {
            int f13 = hVar.f(2);
            if (f13 == 3) {
                hVar.l();
            }
            int f14 = hVar.f(4);
            i13 = hVar.f(4);
            i12 = f14;
            i11 = f13;
        } else {
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        if (hVar.e()) {
            int i14 = hVar.i();
            int i15 = hVar.i();
            int i16 = hVar.i();
            int i17 = hVar.i();
            f11 = b(f11, i11, i14, i15);
            f12 = a(f12, i11, i16, i17);
        }
        return new e(i11, i12, i13, f11, f12);
    }

    private static f s(androidx.media3.container.h hVar, int i11) {
        int i12 = hVar.i();
        int i13 = i12 + 1;
        ImmutableList.a builderWithExpectedSize = ImmutableList.builderWithExpectedSize(i13);
        int[] iArr = new int[i11];
        for (int i14 = 0; i14 < i13; i14++) {
            builderWithExpectedSize.a(r(hVar));
        }
        int i15 = 1;
        if (i13 <= 1 || !hVar.e()) {
            while (i15 < i11) {
                iArr[i15] = Math.min(i15, i12);
                i15++;
            }
        } else {
            int d11 = com.google.common.math.b.d(i13, RoundingMode.CEILING);
            while (i15 < i11) {
                iArr[i15] = hVar.f(d11);
                i15++;
            }
        }
        return new f(builderWithExpectedSize.e(), iArr);
    }

    public static C0098g t(byte[] bArr, int i11, int i12) {
        byte b11;
        int i13 = i11 + 2;
        do {
            i12--;
            b11 = bArr[i12];
            if (b11 != 0) {
                break;
            }
        } while (i12 > i13);
        if (b11 != 0 && i12 > i13) {
            androidx.media3.container.h hVar = new androidx.media3.container.h(bArr, i13, i12 + 1);
            while (hVar.c(16)) {
                int f11 = hVar.f(8);
                int i14 = 0;
                while (f11 == 255) {
                    i14 += 255;
                    f11 = hVar.f(8);
                }
                int i15 = i14 + f11;
                int f12 = hVar.f(8);
                int i16 = 0;
                while (f12 == 255) {
                    i16 += 255;
                    f12 = hVar.f(8);
                }
                int i17 = i16 + f12;
                if (i17 == 0 || !hVar.c(i17)) {
                    break;
                }
                if (i15 == 176) {
                    int i18 = hVar.i();
                    boolean e11 = hVar.e();
                    int i19 = e11 ? hVar.i() : 0;
                    int i20 = hVar.i();
                    int i21 = -1;
                    int i22 = -1;
                    int i23 = -1;
                    int i24 = -1;
                    int i25 = -1;
                    int i26 = -1;
                    for (int i27 = 0; i27 <= i20; i27++) {
                        i21 = hVar.i();
                        i22 = hVar.i();
                        i23 = hVar.f(6);
                        if (i23 == 63) {
                            return null;
                        }
                        i24 = hVar.f(i23 == 0 ? Math.max(0, i18 - 30) : Math.max(0, (i23 + i18) - 31));
                        if (e11) {
                            i25 = hVar.f(6);
                            if (i25 == 63) {
                                return null;
                            }
                            i26 = hVar.f(i25 == 0 ? Math.max(0, i19 - 30) : Math.max(0, (i25 + i19) - 31));
                        }
                        if (hVar.e()) {
                            hVar.m(10);
                        }
                    }
                    return new C0098g(i18, i19, i20 + 1, i21, i22, i23, i24, i25, i26);
                }
            }
        }
        return null;
    }

    public static h u(byte[] bArr, int i11, int i12, k kVar) {
        return v(bArr, i11 + 2, i12, p(new androidx.media3.container.h(bArr, i11, i12)), kVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.container.g.h v(byte[] r22, int r23, int r24, androidx.media3.container.g.b r25, androidx.media3.container.g.k r26) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.g.v(byte[], int, int, androidx.media3.container.g$b, androidx.media3.container.g$k):androidx.media3.container.g$h");
    }

    private static i w(androidx.media3.container.h hVar) {
        hVar.m(3);
        int i11 = hVar.e() ? 1 : 2;
        int j11 = androidx.media3.common.i.j(hVar.f(8));
        int k11 = androidx.media3.common.i.k(hVar.f(8));
        hVar.m(8);
        return new i(j11, i11, k11);
    }

    private static j x(androidx.media3.container.h hVar, int i11, int i12, int[] iArr) {
        if (!hVar.e() ? hVar.e() : true) {
            hVar.l();
        }
        boolean e11 = hVar.e();
        boolean e12 = hVar.e();
        if (e11 || e12) {
            for (int i13 = 0; i13 < i12; i13++) {
                for (int i14 = 0; i14 < iArr[i13]; i14++) {
                    boolean e13 = e11 ? hVar.e() : false;
                    boolean e14 = e12 ? hVar.e() : false;
                    if (e13) {
                        hVar.m(32);
                    }
                    if (e14) {
                        hVar.m(18);
                    }
                }
            }
        }
        boolean e15 = hVar.e();
        int f11 = e15 ? hVar.f(4) + 1 : i11;
        ImmutableList.a builderWithExpectedSize = ImmutableList.builderWithExpectedSize(f11);
        int[] iArr2 = new int[i11];
        for (int i15 = 0; i15 < f11; i15++) {
            builderWithExpectedSize.a(w(hVar));
        }
        if (e15 && f11 > 1) {
            for (int i16 = 0; i16 < i11; i16++) {
                iArr2[i16] = hVar.f(4);
            }
        }
        return new j(builderWithExpectedSize.e(), iArr2);
    }

    public static k y(byte[] bArr, int i11, int i12) {
        androidx.media3.container.h hVar = new androidx.media3.container.h(bArr, i11, i12);
        return z(hVar, p(hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static k z(androidx.media3.container.h hVar, b bVar) {
        int[][] iArr;
        int i11;
        int i12;
        int i13;
        j jVar;
        int i14;
        int i15;
        boolean[][] zArr;
        int i16;
        boolean[][] zArr2;
        int[] iArr2;
        int i17;
        int[] iArr3;
        hVar.m(4);
        boolean e11 = hVar.e();
        boolean e12 = hVar.e();
        int f11 = hVar.f(6);
        int i18 = f11 + 1;
        int f12 = hVar.f(3);
        hVar.m(17);
        boolean z10 = true;
        c q11 = q(hVar, true, f12, null);
        for (int i19 = hVar.e() ? 0 : f12; i19 <= f12; i19++) {
            hVar.i();
            hVar.i();
            hVar.i();
        }
        int f13 = hVar.f(6);
        int i20 = hVar.i() + 1;
        d dVar = new d(ImmutableList.of(q11), new int[1]);
        Object[] objArr = i18 >= 2 && i20 >= 2;
        Object[] objArr2 = e11 && e12;
        int i21 = f13 + 1;
        Object[] objArr3 = i21 >= i18;
        if (objArr != true || objArr2 != true || objArr3 != true) {
            return new k(bVar, null, dVar, null, null);
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i20, i21);
        int[] iArr5 = new int[i20];
        int[] iArr6 = new int[i20];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        for (int i22 = 1; i22 < i20; i22++) {
            int i23 = 0;
            for (int i24 = 0; i24 <= f13; i24++) {
                if (hVar.e()) {
                    iArr4[i22][i23] = i24;
                    iArr6[i22] = i24;
                    i23++;
                }
                iArr5[i22] = i23;
            }
        }
        if (hVar.e()) {
            hVar.m(64);
            if (hVar.e()) {
                hVar.i();
            }
            int i25 = hVar.i();
            int i26 = 0;
            while (i26 < i25) {
                hVar.i();
                if (i26 != 0 && !hVar.e()) {
                    z10 = false;
                }
                F(hVar, z10, f12);
                i26++;
                z10 = true;
            }
        }
        if (!hVar.e()) {
            return new k(bVar, null, dVar, null, null);
        }
        hVar.b();
        c q12 = q(hVar, false, f12, q11);
        boolean e13 = hVar.e();
        boolean[] zArr3 = new boolean[16];
        int i27 = 0;
        for (int i28 = 0; i28 < 16; i28++) {
            boolean e14 = hVar.e();
            zArr3[i28] = e14;
            if (e14) {
                i27++;
            }
        }
        if (i27 == 0 || !zArr3[1]) {
            return new k(bVar, null, dVar, null, null);
        }
        int[] iArr7 = new int[i27];
        for (int i29 = 0; i29 < i27 - (e13 ? 1 : 0); i29++) {
            iArr7[i29] = hVar.f(3);
        }
        int[] iArr8 = new int[i27 + 1];
        if (e13) {
            int i30 = 1;
            while (i30 < i27) {
                int[][] iArr9 = iArr4;
                for (int i31 = 0; i31 < i30; i31++) {
                    iArr8[i30] = iArr8[i30] + iArr7[i31] + 1;
                }
                i30++;
                iArr4 = iArr9;
            }
            iArr = iArr4;
            iArr8[i27] = 6;
        } else {
            iArr = iArr4;
        }
        int[][] iArr10 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i18, i27);
        int[] iArr11 = new int[i18];
        iArr11[0] = 0;
        boolean e15 = hVar.e();
        int i32 = 1;
        while (i32 < i18) {
            if (e15) {
                i17 = f12;
                iArr11[i32] = hVar.f(6);
            } else {
                i17 = f12;
                iArr11[i32] = i32;
            }
            if (e13) {
                iArr3 = iArr7;
                for (int i33 = 0; i33 < i27; i33++) {
                    iArr10[i32][i33] = (iArr11[i32] & ((1 << iArr8[r32]) - 1)) >> iArr8[i33];
                }
            } else {
                int i34 = 0;
                while (i34 < i27) {
                    iArr10[i32][i34] = hVar.f(iArr7[i34] + 1);
                    i34++;
                    iArr7 = iArr7;
                }
                iArr3 = iArr7;
            }
            i32++;
            f12 = i17;
            iArr7 = iArr3;
        }
        int i35 = f12;
        int[] iArr12 = new int[i21];
        int i36 = 1;
        for (int i37 = 0; i37 < i18; i37++) {
            iArr12[iArr11[i37]] = -1;
            int i38 = 0;
            for (int i39 = 0; i39 < 16; i39++) {
                if (zArr3[i39]) {
                    if (i39 == 1) {
                        iArr12[iArr11[i37]] = iArr10[i37][i38];
                    }
                    i38++;
                }
            }
            if (i37 > 0) {
                int i40 = 0;
                while (true) {
                    if (i40 >= i37) {
                        i36++;
                        break;
                    }
                    if (iArr12[iArr11[i37]] == iArr12[iArr11[i40]]) {
                        break;
                    }
                    i40++;
                }
            }
        }
        int f14 = hVar.f(4);
        if (i36 < 2 || f14 == 0) {
            return new k(bVar, null, dVar, null, null);
        }
        int[] iArr13 = new int[i36];
        for (int i41 = 0; i41 < i36; i41++) {
            iArr13[i41] = hVar.f(f14);
        }
        int[] iArr14 = new int[i21];
        for (int i42 = 0; i42 < i18; i42++) {
            iArr14[Math.min(iArr11[i42], f13)] = i42;
        }
        ImmutableList.a builder = ImmutableList.builder();
        int i43 = 0;
        while (i43 <= f13) {
            int min = Math.min(iArr12[i43], i36 - 1);
            builder.a(new a(iArr14[i43], min >= 0 ? iArr13[min] : -1));
            i43++;
            iArr12 = iArr12;
        }
        ImmutableList e16 = builder.e();
        if (((a) e16.get(0)).f10680b == -1) {
            return new k(bVar, null, dVar, null, null);
        }
        int i44 = 1;
        while (true) {
            if (i44 > f13) {
                i11 = -1;
                i12 = -1;
                break;
            }
            i11 = -1;
            if (((a) e16.get(i44)).f10680b != -1) {
                i12 = i44;
                break;
            }
            i44++;
        }
        if (i12 == i11) {
            return new k(bVar, null, dVar, null, null);
        }
        Class cls = Boolean.TYPE;
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) cls, i18, i18);
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) cls, i18, i18);
        for (int i45 = 1; i45 < i18; i45++) {
            for (int i46 = 0; i46 < i45; i46++) {
                boolean[] zArr6 = zArr4[i45];
                boolean[] zArr7 = zArr5[i45];
                boolean e17 = hVar.e();
                zArr7[i46] = e17;
                zArr6[i46] = e17;
            }
        }
        for (int i47 = 1; i47 < i18; i47++) {
            for (int i48 = 0; i48 < f11; i48++) {
                int i49 = 0;
                while (true) {
                    if (i49 < i47) {
                        boolean[] zArr8 = zArr5[i47];
                        if (zArr8[i49] && zArr5[i49][i48]) {
                            zArr8[i48] = true;
                            break;
                        }
                        i49++;
                    }
                }
            }
        }
        int[] iArr15 = new int[i21];
        for (int i50 = 0; i50 < i18; i50++) {
            int i51 = 0;
            for (int i52 = 0; i52 < i50; i52++) {
                i51 += zArr4[i50][i52] ? 1 : 0;
            }
            iArr15[iArr11[i50]] = i51;
        }
        int i53 = 0;
        for (int i54 = 0; i54 < i18; i54++) {
            if (iArr15[iArr11[i54]] == 0) {
                i53++;
            }
        }
        if (i53 > 1) {
            return new k(bVar, null, dVar, null, null);
        }
        int[] iArr16 = new int[i18];
        int[] iArr17 = new int[i20];
        if (hVar.e()) {
            for (int i55 = 0; i55 < i18; i55++) {
                iArr16[i55] = hVar.f(3);
            }
            i13 = i35;
        } else {
            i13 = i35;
            Arrays.fill(iArr16, 0, i18, i13);
        }
        int i56 = 0;
        while (i56 < i20) {
            boolean[][] zArr9 = zArr5;
            int[] iArr18 = iArr15;
            int[] iArr19 = iArr11;
            int i57 = 0;
            for (int i58 = 0; i58 < iArr5[i56]; i58++) {
                i57 = Math.max(i57, iArr16[((a) e16.get(iArr[i56][i58])).f10679a]);
            }
            iArr17[i56] = i57 + 1;
            i56++;
            iArr11 = iArr19;
            iArr15 = iArr18;
            zArr5 = zArr9;
        }
        boolean[][] zArr10 = zArr5;
        int[] iArr20 = iArr15;
        int[] iArr21 = iArr11;
        if (hVar.e()) {
            int i59 = 0;
            while (i59 < f11) {
                int i60 = i59 + 1;
                for (int i61 = i60; i61 < i18; i61++) {
                    if (zArr4[i61][i59]) {
                        hVar.m(3);
                    }
                }
                i59 = i60;
            }
        }
        hVar.l();
        int i62 = hVar.i() + 1;
        ImmutableList.a builder2 = ImmutableList.builder();
        builder2.a(q11);
        if (i62 > 1) {
            c cVar = q12;
            builder2.a(cVar);
            for (int i63 = 2; i63 < i62; i63++) {
                cVar = q(hVar, hVar.e(), i13, cVar);
                builder2.a(cVar);
            }
        }
        ImmutableList e18 = builder2.e();
        int i64 = hVar.i() + i20;
        if (i64 > i20) {
            return new k(bVar, null, dVar, null, null);
        }
        int f15 = hVar.f(2);
        boolean[][] zArr11 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i64, i21);
        int[] iArr22 = new int[i64];
        int[] iArr23 = new int[i64];
        int i65 = 0;
        while (i65 < i20) {
            int i66 = i20;
            iArr22[i65] = 0;
            iArr23[i65] = iArr6[i65];
            if (f15 == 0) {
                zArr2 = zArr4;
                iArr2 = iArr17;
                i16 = i18;
                Arrays.fill(zArr11[i65], 0, iArr5[i65], true);
                iArr22[i65] = iArr5[i65];
            } else {
                i16 = i18;
                zArr2 = zArr4;
                iArr2 = iArr17;
                if (f15 == 1) {
                    int i67 = iArr6[i65];
                    for (int i68 = 0; i68 < iArr5[i65]; i68++) {
                        zArr11[i65][i68] = iArr[i65][i68] == i67;
                    }
                    iArr22[i65] = 1;
                } else {
                    zArr11[0][0] = true;
                    iArr22[0] = 1;
                    i65++;
                    i20 = i66;
                    zArr4 = zArr2;
                    iArr17 = iArr2;
                    i18 = i16;
                }
            }
            i65++;
            i20 = i66;
            zArr4 = zArr2;
            iArr17 = iArr2;
            i18 = i16;
        }
        int i69 = i18;
        boolean[][] zArr12 = zArr4;
        int[] iArr24 = iArr17;
        int i70 = i20;
        int[] iArr25 = new int[i21];
        int i71 = 2;
        boolean[][] zArr13 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i64, i21);
        int i72 = 1;
        int i73 = 0;
        while (i72 < i64) {
            if (f15 == i71) {
                for (int i74 = 0; i74 < iArr5[i72]; i74++) {
                    zArr11[i72][i74] = hVar.e();
                    int i75 = iArr22[i72];
                    boolean z11 = zArr11[i72][i74];
                    iArr22[i72] = i75 + (z11 ? 1 : 0);
                    if (z11) {
                        iArr23[i72] = iArr[i72][i74];
                    }
                }
            }
            if (i73 == 0 && iArr[i72][0] == 0 && zArr11[i72][0]) {
                for (int i76 = 1; i76 < iArr5[i72]; i76++) {
                    if (iArr[i72][i76] == i12 && zArr11[i72][i12]) {
                        i73 = i72;
                    }
                }
            }
            int i77 = 0;
            while (i77 < iArr5[i72]) {
                if (i62 > 1) {
                    zArr13[i72][i77] = zArr11[i72][i77];
                    zArr = zArr11;
                    i14 = i62;
                    int d11 = com.google.common.math.b.d(i62, RoundingMode.CEILING);
                    if (!zArr13[i72][i77]) {
                        int i78 = ((a) e16.get(iArr[i72][i77])).f10679a;
                        int i79 = 0;
                        while (i79 < i77) {
                            i15 = i12;
                            if (zArr10[i78][((a) e16.get(iArr[i72][i79])).f10679a]) {
                                zArr13[i72][i77] = true;
                                break;
                            }
                            i79++;
                            i12 = i15;
                        }
                    }
                    i15 = i12;
                    if (zArr13[i72][i77]) {
                        if (i73 <= 0 || i72 != i73) {
                            hVar.m(d11);
                        } else {
                            iArr25[i77] = hVar.f(d11);
                        }
                    }
                } else {
                    i14 = i62;
                    i15 = i12;
                    zArr = zArr11;
                }
                i77++;
                zArr11 = zArr;
                i62 = i14;
                i12 = i15;
            }
            int i80 = i62;
            int i81 = i12;
            boolean[][] zArr14 = zArr11;
            if (iArr22[i72] == 1 && iArr20[iArr23[i72]] > 0) {
                hVar.l();
            }
            i72++;
            zArr11 = zArr14;
            i62 = i80;
            i12 = i81;
            i71 = 2;
        }
        if (i73 == 0) {
            return new k(bVar, null, dVar, null, null);
        }
        f s11 = s(hVar, i69);
        hVar.m(2);
        for (int i82 = 1; i82 < i69; i82++) {
            if (iArr20[iArr21[i82]] == 0) {
                hVar.l();
            }
        }
        E(hVar, i64, iArr24, iArr5, zArr13);
        K(hVar, i69, zArr12);
        if (hVar.e()) {
            hVar.b();
            jVar = x(hVar, i69, i70, iArr24);
        } else {
            jVar = null;
        }
        return new k(bVar, e16, new d(e18, iArr25), s11, jVar);
    }
}
