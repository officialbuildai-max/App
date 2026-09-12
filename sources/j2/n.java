package j2;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.accessibility.CaptioningManager;
import androidx.core.view.PointerIconCompat;
import androidx.media3.common.g0;
import androidx.media3.common.h0;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.audio.w0;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.w3;
import androidx.media3.exoplayer.x3;
import androidx.media3.exoplayer.y3;
import androidx.media3.exoplayer.z3;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.h2;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import j2.a;
import j2.b0;
import j2.n;
import j2.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public class n extends b0 implements y3.a {

    /* renamed from: j, reason: collision with root package name */
    private static final Ordering f65895j = Ordering.from(new Comparator() { // from class: j2.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int V;
            V = n.V((Integer) obj, (Integer) obj2);
            return V;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Object f65896d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f65897e;

    /* renamed from: f, reason: collision with root package name */
    private final z.b f65898f;

    /* renamed from: g, reason: collision with root package name */
    private e f65899g;

    /* renamed from: h, reason: collision with root package name */
    private g f65900h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.media3.common.c f65901i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends i implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        private final int f65902e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f65903f;

        /* renamed from: g, reason: collision with root package name */
        private final String f65904g;

        /* renamed from: h, reason: collision with root package name */
        private final e f65905h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f65906i;

        /* renamed from: j, reason: collision with root package name */
        private final int f65907j;

        /* renamed from: k, reason: collision with root package name */
        private final int f65908k;

        /* renamed from: l, reason: collision with root package name */
        private final int f65909l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f65910m;

        /* renamed from: n, reason: collision with root package name */
        private final boolean f65911n;

        /* renamed from: o, reason: collision with root package name */
        private final int f65912o;

        /* renamed from: p, reason: collision with root package name */
        private final int f65913p;

        /* renamed from: q, reason: collision with root package name */
        private final boolean f65914q;

        /* renamed from: r, reason: collision with root package name */
        private final int f65915r;

        /* renamed from: s, reason: collision with root package name */
        private final int f65916s;

        /* renamed from: t, reason: collision with root package name */
        private final int f65917t;

        /* renamed from: u, reason: collision with root package name */
        private final int f65918u;

        /* renamed from: v, reason: collision with root package name */
        private final boolean f65919v;

        /* renamed from: w, reason: collision with root package name */
        private final boolean f65920w;

        /* renamed from: x, reason: collision with root package name */
        private final boolean f65921x;

        /* JADX WARN: Multi-variable type inference failed */
        public b(int i11, androidx.media3.common.f0 f0Var, int i12, e eVar, int i13, boolean z10, com.google.common.base.n nVar, int i14) {
            super(i11, f0Var, i12);
            int i15;
            int i16;
            int i17;
            this.f65905h = eVar;
            int i18 = eVar.f65936y0 ? 24 : 16;
            this.f65910m = eVar.f65932u0 && (i14 & i18) != 0;
            this.f65904g = n.a0(this.f65956d.f10232d);
            this.f65906i = x3.l(i13, false);
            int i19 = 0;
            while (true) {
                i15 = Integer.MAX_VALUE;
                if (i19 >= eVar.f10098p.size()) {
                    i16 = 0;
                    i19 = Integer.MAX_VALUE;
                    break;
                } else {
                    i16 = n.H(this.f65956d, (String) eVar.f10098p.get(i19), false);
                    if (i16 > 0) {
                        break;
                    } else {
                        i19++;
                    }
                }
            }
            this.f65908k = i19;
            this.f65907j = i16;
            this.f65909l = n.L(this.f65956d.f10234f, eVar.f10099q);
            androidx.media3.common.r rVar = this.f65956d;
            int i20 = rVar.f10234f;
            this.f65911n = i20 == 0 || (i20 & 1) != 0;
            this.f65914q = (rVar.f10233e & 1) != 0;
            this.f65921x = n.P(rVar);
            androidx.media3.common.r rVar2 = this.f65956d;
            int i21 = rVar2.E;
            this.f65915r = i21;
            this.f65916s = rVar2.F;
            int i22 = rVar2.f10238j;
            this.f65917t = i22;
            this.f65903f = (i22 == -1 || i22 <= eVar.f10101s) && (i21 == -1 || i21 <= eVar.f10100r) && nVar.apply(rVar2);
            String[] p02 = a1.p0();
            int i23 = 0;
            while (true) {
                if (i23 >= p02.length) {
                    i17 = 0;
                    i23 = Integer.MAX_VALUE;
                    break;
                } else {
                    i17 = n.H(this.f65956d, p02[i23], false);
                    if (i17 > 0) {
                        break;
                    } else {
                        i23++;
                    }
                }
            }
            this.f65912o = i23;
            this.f65913p = i17;
            int i24 = 0;
            while (true) {
                if (i24 < eVar.f10102t.size()) {
                    String str = this.f65956d.f10243o;
                    if (str != null && str.equals(eVar.f10102t.get(i24))) {
                        i15 = i24;
                        break;
                    }
                    i24++;
                } else {
                    break;
                }
            }
            this.f65918u = i15;
            this.f65919v = x3.h(i13) == 128;
            this.f65920w = x3.j(i13) == 64;
            this.f65902e = g(i13, z10, i18);
        }

        public static int d(List list, List list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList f(int i11, androidx.media3.common.f0 f0Var, e eVar, int[] iArr, boolean z10, com.google.common.base.n nVar, int i12) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i13 = 0; i13 < f0Var.f10053a; i13++) {
                builder.a(new b(i11, f0Var, i13, eVar, iArr[i13], z10, nVar, i12));
            }
            return builder.e();
        }

        private int g(int i11, boolean z10, int i12) {
            if (!x3.l(i11, this.f65905h.A0)) {
                return 0;
            }
            if (!this.f65903f && !this.f65905h.f65931t0) {
                return 0;
            }
            e eVar = this.f65905h;
            if (eVar.f10103u.f10113a == 2 && !n.b0(eVar, i11, this.f65956d)) {
                return 0;
            }
            if (x3.l(i11, false) && this.f65903f && this.f65956d.f10238j != -1) {
                e eVar2 = this.f65905h;
                if (!eVar2.C && !eVar2.B && ((eVar2.C0 || !z10) && eVar2.f10103u.f10113a != 2 && (i11 & i12) != 0)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // j2.n.i
        public int a() {
            return this.f65902e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering reverse = (this.f65903f && this.f65906i) ? n.f65895j : n.f65895j.reverse();
            h2 g11 = h2.k().h(this.f65906i, bVar.f65906i).g(Integer.valueOf(this.f65908k), Integer.valueOf(bVar.f65908k), Ordering.natural().reverse()).d(this.f65907j, bVar.f65907j).d(this.f65909l, bVar.f65909l).h(this.f65914q, bVar.f65914q).h(this.f65911n, bVar.f65911n).g(Integer.valueOf(this.f65912o), Integer.valueOf(bVar.f65912o), Ordering.natural().reverse()).d(this.f65913p, bVar.f65913p).h(this.f65903f, bVar.f65903f).g(Integer.valueOf(this.f65918u), Integer.valueOf(bVar.f65918u), Ordering.natural().reverse());
            if (this.f65905h.B) {
                g11 = g11.g(Integer.valueOf(this.f65917t), Integer.valueOf(bVar.f65917t), n.f65895j.reverse());
            }
            h2 g12 = g11.h(this.f65919v, bVar.f65919v).h(this.f65920w, bVar.f65920w).h(this.f65921x, bVar.f65921x).g(Integer.valueOf(this.f65915r), Integer.valueOf(bVar.f65915r), reverse).g(Integer.valueOf(this.f65916s), Integer.valueOf(bVar.f65916s), reverse);
            if (Objects.equals(this.f65904g, bVar.f65904g)) {
                g12 = g12.g(Integer.valueOf(this.f65917t), Integer.valueOf(bVar.f65917t), reverse);
            }
            return g12.j();
        }

        @Override // j2.n.i
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i11;
            String str;
            int i12;
            if ((this.f65905h.f65934w0 || ((i12 = this.f65956d.E) != -1 && i12 == bVar.f65956d.E)) && (this.f65910m || ((str = this.f65956d.f10243o) != null && TextUtils.equals(str, bVar.f65956d.f10243o)))) {
                e eVar = this.f65905h;
                if ((eVar.f65933v0 || ((i11 = this.f65956d.F) != -1 && i11 == bVar.f65956d.F)) && (eVar.f65935x0 || (this.f65919v == bVar.f65919v && this.f65920w == bVar.f65920w))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends i implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        private final int f65922e;

        /* renamed from: f, reason: collision with root package name */
        private final int f65923f;

        public c(int i11, androidx.media3.common.f0 f0Var, int i12, e eVar, int i13) {
            super(i11, f0Var, i12);
            this.f65922e = x3.l(i13, eVar.A0) ? 1 : 0;
            this.f65923f = this.f65956d.e();
        }

        public static int d(List list, List list2) {
            return ((c) list.get(0)).compareTo((c) list2.get(0));
        }

        public static ImmutableList f(int i11, androidx.media3.common.f0 f0Var, e eVar, int[] iArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i12 = 0; i12 < f0Var.f10053a; i12++) {
                builder.a(new c(i11, f0Var, i12, eVar, iArr[i12]));
            }
            return builder.e();
        }

        @Override // j2.n.i
        public int a() {
            return this.f65922e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return Integer.compare(this.f65923f, cVar.f65923f);
        }

        @Override // j2.n.i
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(c cVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f65924a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f65925b;

        public d(androidx.media3.common.r rVar, int i11) {
            this.f65924a = (rVar.f10233e & 1) != 0;
            this.f65925b = x3.l(i11, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return h2.k().h(this.f65925b, dVar.f65925b).h(this.f65924a, dVar.f65924a).j();
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends h0 {
        public static final e G0;
        public static final e H0;
        private static final String I0;
        private static final String J0;
        private static final String K0;
        private static final String L0;
        private static final String M0;
        private static final String N0;
        private static final String O0;
        private static final String P0;
        private static final String Q0;
        private static final String R0;
        private static final String S0;
        private static final String T0;
        private static final String U0;
        private static final String V0;
        private static final String W0;
        private static final String X0;
        private static final String Y0;
        private static final String Z0;

        /* renamed from: a1, reason: collision with root package name */
        private static final String f65926a1;
        public final boolean A0;
        public final boolean B0;
        public final boolean C0;
        public final boolean D0;
        private final SparseArray E0;
        private final SparseBooleanArray F0;

        /* renamed from: p0, reason: collision with root package name */
        public final boolean f65927p0;

        /* renamed from: q0, reason: collision with root package name */
        public final boolean f65928q0;

        /* renamed from: r0, reason: collision with root package name */
        public final boolean f65929r0;

        /* renamed from: s0, reason: collision with root package name */
        public final boolean f65930s0;

        /* renamed from: t0, reason: collision with root package name */
        public final boolean f65931t0;

        /* renamed from: u0, reason: collision with root package name */
        public final boolean f65932u0;

        /* renamed from: v0, reason: collision with root package name */
        public final boolean f65933v0;

        /* renamed from: w0, reason: collision with root package name */
        public final boolean f65934w0;

        /* renamed from: x0, reason: collision with root package name */
        public final boolean f65935x0;

        /* renamed from: y0, reason: collision with root package name */
        public final boolean f65936y0;

        /* renamed from: z0, reason: collision with root package name */
        public final boolean f65937z0;

        /* loaded from: classes2.dex */
        public static final class a extends h0.c {
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private boolean N;
            private boolean O;
            private boolean P;
            private boolean Q;
            private boolean R;
            private boolean S;
            private boolean T;
            private final SparseArray U;
            private final SparseBooleanArray V;

            public a() {
                this.U = new SparseArray();
                this.V = new SparseBooleanArray();
                k0();
            }

            private a(e eVar) {
                super(eVar);
                this.F = eVar.f65927p0;
                this.G = eVar.f65928q0;
                this.H = eVar.f65929r0;
                this.I = eVar.f65930s0;
                this.J = eVar.f65931t0;
                this.K = eVar.f65932u0;
                this.L = eVar.f65933v0;
                this.M = eVar.f65934w0;
                this.N = eVar.f65935x0;
                this.O = eVar.f65936y0;
                this.P = eVar.f65937z0;
                this.Q = eVar.A0;
                this.R = eVar.B0;
                this.S = eVar.C0;
                this.T = eVar.D0;
                this.U = j0(eVar.E0);
                this.V = eVar.F0.clone();
            }

            private static SparseArray j0(SparseArray sparseArray) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    sparseArray2.put(sparseArray.keyAt(i11), new HashMap((Map) sparseArray.valueAt(i11)));
                }
                return sparseArray2;
            }

            private void k0() {
                this.F = true;
                this.G = false;
                this.H = true;
                this.I = false;
                this.J = true;
                this.K = false;
                this.L = false;
                this.M = false;
                this.N = false;
                this.O = true;
                this.P = true;
                this.Q = true;
                this.R = false;
                this.S = true;
                this.T = false;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: h0, reason: merged with bridge method [inline-methods] */
            public e F() {
                return new e(this);
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: i0, reason: merged with bridge method [inline-methods] */
            public a G(int i11) {
                super.G(i11);
                return this;
            }

            protected a l0(h0 h0Var) {
                super.J(h0Var);
                return this;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: m0, reason: merged with bridge method [inline-methods] */
            public a K(int i11) {
                super.K(i11);
                return this;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: n0, reason: merged with bridge method [inline-methods] */
            public a L(g0 g0Var) {
                super.L(g0Var);
                return this;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: o0, reason: merged with bridge method [inline-methods] */
            public a M(String str) {
                super.M(str);
                return this;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: p0, reason: merged with bridge method [inline-methods] */
            public a N(String... strArr) {
                super.N(strArr);
                return this;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: q0, reason: merged with bridge method [inline-methods] */
            public a O(int i11) {
                super.O(i11);
                return this;
            }

            @Override // androidx.media3.common.h0.c
            /* renamed from: r0, reason: merged with bridge method [inline-methods] */
            public a P(int i11, boolean z10) {
                super.P(i11, z10);
                return this;
            }
        }

        static {
            e F = new a().F();
            G0 = F;
            H0 = F;
            I0 = a1.C0(1000);
            J0 = a1.C0(1001);
            K0 = a1.C0(1002);
            L0 = a1.C0(1003);
            M0 = a1.C0(1004);
            N0 = a1.C0(1005);
            O0 = a1.C0(PointerIconCompat.TYPE_CELL);
            P0 = a1.C0(PointerIconCompat.TYPE_CROSSHAIR);
            Q0 = a1.C0(PointerIconCompat.TYPE_TEXT);
            R0 = a1.C0(PointerIconCompat.TYPE_VERTICAL_TEXT);
            S0 = a1.C0(1010);
            T0 = a1.C0(1011);
            U0 = a1.C0(1012);
            V0 = a1.C0(PointerIconCompat.TYPE_ALL_SCROLL);
            W0 = a1.C0(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW);
            X0 = a1.C0(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
            Y0 = a1.C0(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            Z0 = a1.C0(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW);
            f65926a1 = a1.C0(PointerIconCompat.TYPE_ZOOM_IN);
        }

        private e(a aVar) {
            super(aVar);
            this.f65927p0 = aVar.F;
            this.f65928q0 = aVar.G;
            this.f65929r0 = aVar.H;
            this.f65930s0 = aVar.I;
            this.f65931t0 = aVar.J;
            this.f65932u0 = aVar.K;
            this.f65933v0 = aVar.L;
            this.f65934w0 = aVar.M;
            this.f65935x0 = aVar.N;
            this.f65936y0 = aVar.O;
            this.f65937z0 = aVar.P;
            this.A0 = aVar.Q;
            this.B0 = aVar.R;
            this.C0 = aVar.S;
            this.D0 = aVar.T;
            this.E0 = aVar.U;
            this.F0 = aVar.V;
        }

        private static boolean d(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i11)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean e(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (indexOfKey < 0 || !f((Map) sparseArray.valueAt(i11), (Map) sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean f(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                g2.z zVar = (g2.z) entry.getKey();
                if (!map2.containsKey(zVar) || !Objects.equals(entry.getValue(), map2.get(zVar))) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.media3.common.h0
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return super.equals(eVar) && this.f65927p0 == eVar.f65927p0 && this.f65928q0 == eVar.f65928q0 && this.f65929r0 == eVar.f65929r0 && this.f65930s0 == eVar.f65930s0 && this.f65931t0 == eVar.f65931t0 && this.f65932u0 == eVar.f65932u0 && this.f65933v0 == eVar.f65933v0 && this.f65934w0 == eVar.f65934w0 && this.f65935x0 == eVar.f65935x0 && this.f65936y0 == eVar.f65936y0 && this.f65937z0 == eVar.f65937z0 && this.A0 == eVar.A0 && this.B0 == eVar.B0 && this.C0 == eVar.C0 && this.D0 == eVar.D0 && d(this.F0, eVar.F0) && e(this.E0, eVar.E0);
        }

        @Override // androidx.media3.common.h0
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        public boolean h(int i11) {
            return this.F0.get(i11);
        }

        @Override // androidx.media3.common.h0
        public int hashCode() {
            return ((((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f65927p0 ? 1 : 0)) * 31) + (this.f65928q0 ? 1 : 0)) * 31) + (this.f65929r0 ? 1 : 0)) * 31) + (this.f65930s0 ? 1 : 0)) * 31) + (this.f65931t0 ? 1 : 0)) * 31) + (this.f65932u0 ? 1 : 0)) * 31) + (this.f65933v0 ? 1 : 0)) * 31) + (this.f65934w0 ? 1 : 0)) * 31) + (this.f65935x0 ? 1 : 0)) * 31) + (this.f65936y0 ? 1 : 0)) * 31) + (this.f65937z0 ? 1 : 0)) * 31) + (this.A0 ? 1 : 0)) * 31) + (this.B0 ? 1 : 0)) * 31) + (this.C0 ? 1 : 0)) * 31) + (this.D0 ? 1 : 0);
        }

        public f i(int i11, g2.z zVar) {
            Map map = (Map) this.E0.get(i11);
            if (map == null) {
                return null;
            }
            android.support.v4.media.session.c.a(map.get(zVar));
            return null;
        }

        public boolean j(int i11, g2.z zVar) {
            Map map = (Map) this.E0.get(i11);
            return map != null && map.containsKey(zVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private final Spatializer f65938a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f65939b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f65940c;

        /* renamed from: d, reason: collision with root package name */
        private final Spatializer$OnSpatializerStateChangedListener f65941d;

        /* loaded from: classes2.dex */
        class a implements Spatializer$OnSpatializerStateChangedListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f65942a;

            a(n nVar) {
                this.f65942a = nVar;
            }

            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z10) {
                this.f65942a.Y();
            }

            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z10) {
                this.f65942a.Y();
            }
        }

        public g(Context context, n nVar) {
            Spatializer spatializer;
            int immersiveAudioLevel;
            AudioManager c11 = context == null ? null : t1.m.c(context);
            if (c11 == null || a1.K0((Context) androidx.media3.common.util.a.e(context))) {
                this.f65938a = null;
                this.f65939b = false;
                this.f65940c = null;
                this.f65941d = null;
                return;
            }
            spatializer = c11.getSpatializer();
            this.f65938a = spatializer;
            immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
            this.f65939b = immersiveAudioLevel != 0;
            a aVar = new a(nVar);
            this.f65941d = aVar;
            Handler handler = new Handler((Looper) androidx.media3.common.util.a.i(Looper.myLooper()));
            this.f65940c = handler;
            Objects.requireNonNull(handler);
            spatializer.addOnSpatializerStateChangedListener(new w0(handler), aVar);
        }

        public boolean a(androidx.media3.common.c cVar, androidx.media3.common.r rVar) {
            int i11;
            boolean canBeSpatialized;
            if (Objects.equals(rVar.f10243o, MimeTypes.AUDIO_E_AC3_JOC)) {
                i11 = rVar.E;
                if (i11 == 16) {
                    i11 = 12;
                }
            } else if (Objects.equals(rVar.f10243o, "audio/iamf")) {
                i11 = rVar.E;
                if (i11 == -1) {
                    i11 = 6;
                }
            } else if (Objects.equals(rVar.f10243o, "audio/ac4")) {
                i11 = rVar.E;
                if (i11 == 18 || i11 == 21) {
                    i11 = 24;
                }
            } else {
                i11 = rVar.E;
            }
            int M = a1.M(i11);
            if (M == 0) {
                return false;
            }
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(M);
            int i12 = rVar.F;
            if (i12 != -1) {
                channelMask.setSampleRate(i12);
            }
            canBeSpatialized = s.a(androidx.media3.common.util.a.e(this.f65938a)).canBeSpatialized(cVar.a().f10001a, channelMask.build());
            return canBeSpatialized;
        }

        public boolean b() {
            boolean isAvailable;
            isAvailable = s.a(androidx.media3.common.util.a.e(this.f65938a)).isAvailable();
            return isAvailable;
        }

        public boolean c() {
            boolean isEnabled;
            isEnabled = s.a(androidx.media3.common.util.a.e(this.f65938a)).isEnabled();
            return isEnabled;
        }

        public boolean d() {
            return this.f65939b;
        }

        public void e() {
            Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
            Spatializer spatializer = this.f65938a;
            if (spatializer == null || (spatializer$OnSpatializerStateChangedListener = this.f65941d) == null || this.f65940c == null) {
                return;
            }
            spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
            this.f65940c.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h extends i implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        private final int f65944e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f65945f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f65946g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f65947h;

        /* renamed from: i, reason: collision with root package name */
        private final int f65948i;

        /* renamed from: j, reason: collision with root package name */
        private final int f65949j;

        /* renamed from: k, reason: collision with root package name */
        private final int f65950k;

        /* renamed from: l, reason: collision with root package name */
        private final int f65951l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f65952m;

        /* JADX WARN: Multi-variable type inference failed */
        public h(int i11, androidx.media3.common.f0 f0Var, int i12, e eVar, int i13, String str, String str2) {
            super(i11, f0Var, i12);
            int i14;
            int i15 = 0;
            this.f65945f = x3.l(i13, false);
            int i16 = this.f65956d.f10233e & (~eVar.f10107y);
            this.f65946g = (i16 & 1) != 0;
            this.f65947h = (i16 & 2) != 0;
            ImmutableList of2 = str2 != null ? ImmutableList.of(str2) : eVar.f10104v.isEmpty() ? ImmutableList.of("") : eVar.f10104v;
            int i17 = 0;
            while (true) {
                if (i17 >= of2.size()) {
                    i17 = Integer.MAX_VALUE;
                    i14 = 0;
                    break;
                } else {
                    i14 = n.H(this.f65956d, (String) of2.get(i17), eVar.f10108z);
                    if (i14 > 0) {
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            this.f65948i = i17;
            this.f65949j = i14;
            int L = n.L(this.f65956d.f10234f, str2 != null ? 1088 : eVar.f10105w);
            this.f65950k = L;
            this.f65952m = (1088 & this.f65956d.f10234f) != 0;
            int H = n.H(this.f65956d, str, n.a0(str) == null);
            this.f65951l = H;
            boolean z10 = i14 > 0 || (eVar.f10104v.isEmpty() && L > 0) || this.f65946g || (this.f65947h && H > 0);
            if (x3.l(i13, eVar.A0) && z10) {
                i15 = 1;
            }
            this.f65944e = i15;
        }

        public static int d(List list, List list2) {
            return ((h) list.get(0)).compareTo((h) list2.get(0));
        }

        public static ImmutableList f(int i11, androidx.media3.common.f0 f0Var, e eVar, int[] iArr, String str, String str2) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i12 = 0; i12 < f0Var.f10053a; i12++) {
                builder.a(new h(i11, f0Var, i12, eVar, iArr[i12], str, str2));
            }
            return builder.e();
        }

        @Override // j2.n.i
        public int a() {
            return this.f65944e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            h2 d11 = h2.k().h(this.f65945f, hVar.f65945f).g(Integer.valueOf(this.f65948i), Integer.valueOf(hVar.f65948i), Ordering.natural().reverse()).d(this.f65949j, hVar.f65949j).d(this.f65950k, hVar.f65950k).h(this.f65946g, hVar.f65946g).g(Boolean.valueOf(this.f65947h), Boolean.valueOf(hVar.f65947h), this.f65949j == 0 ? Ordering.natural() : Ordering.natural().reverse()).d(this.f65951l, hVar.f65951l);
            if (this.f65950k == 0) {
                d11 = d11.i(this.f65952m, hVar.f65952m);
            }
            return d11.j();
        }

        @Override // j2.n.i
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(h hVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class i {

        /* renamed from: a, reason: collision with root package name */
        public final int f65953a;

        /* renamed from: b, reason: collision with root package name */
        public final androidx.media3.common.f0 f65954b;

        /* renamed from: c, reason: collision with root package name */
        public final int f65955c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.media3.common.r f65956d;

        /* loaded from: classes2.dex */
        public interface a {
            List a(int i11, androidx.media3.common.f0 f0Var, int[] iArr);
        }

        public i(int i11, androidx.media3.common.f0 f0Var, int i12) {
            this.f65953a = i11;
            this.f65954b = f0Var;
            this.f65955c = i12;
            this.f65956d = f0Var.a(i12);
        }

        public abstract int a();

        public abstract boolean b(i iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class j extends i {

        /* renamed from: e, reason: collision with root package name */
        private final boolean f65957e;

        /* renamed from: f, reason: collision with root package name */
        private final e f65958f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f65959g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f65960h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f65961i;

        /* renamed from: j, reason: collision with root package name */
        private final int f65962j;

        /* renamed from: k, reason: collision with root package name */
        private final int f65963k;

        /* renamed from: l, reason: collision with root package name */
        private final int f65964l;

        /* renamed from: m, reason: collision with root package name */
        private final int f65965m;

        /* renamed from: n, reason: collision with root package name */
        private final int f65966n;

        /* renamed from: o, reason: collision with root package name */
        private final int f65967o;

        /* renamed from: p, reason: collision with root package name */
        private final boolean f65968p;

        /* renamed from: q, reason: collision with root package name */
        private final int f65969q;

        /* renamed from: r, reason: collision with root package name */
        private final boolean f65970r;

        /* renamed from: s, reason: collision with root package name */
        private final int f65971s;

        /* renamed from: t, reason: collision with root package name */
        private final boolean f65972t;

        /* renamed from: u, reason: collision with root package name */
        private final boolean f65973u;

        /* renamed from: v, reason: collision with root package name */
        private final int f65974v;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0111 A[EDGE_INSN: B:89:0x0111->B:76:0x0111 BREAK  A[LOOP:1: B:68:0x00f2->B:87:0x010e], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x00bf A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public j(int r5, androidx.media3.common.f0 r6, int r7, j2.n.e r8, int r9, java.lang.String r10, int r11, boolean r12) {
            /*
                Method dump skipped, instructions count: 317
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j2.n.j.<init>(int, androidx.media3.common.f0, int, j2.n$e, int, java.lang.String, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(j jVar, j jVar2) {
            h2 h11 = h2.k().h(jVar.f65960h, jVar2.f65960h).g(Integer.valueOf(jVar.f65965m), Integer.valueOf(jVar2.f65965m), Ordering.natural().reverse()).d(jVar.f65966n, jVar2.f65966n).d(jVar.f65967o, jVar2.f65967o).h(jVar.f65968p, jVar2.f65968p).d(jVar.f65969q, jVar2.f65969q).h(jVar.f65961i, jVar2.f65961i).h(jVar.f65957e, jVar2.f65957e).h(jVar.f65959g, jVar2.f65959g).g(Integer.valueOf(jVar.f65964l), Integer.valueOf(jVar2.f65964l), Ordering.natural().reverse()).h(jVar.f65972t, jVar2.f65972t).h(jVar.f65973u, jVar2.f65973u);
            if (jVar.f65972t && jVar.f65973u) {
                h11 = h11.d(jVar.f65974v, jVar2.f65974v);
            }
            return h11.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int g(j jVar, j jVar2) {
            Ordering reverse = (jVar.f65957e && jVar.f65960h) ? n.f65895j : n.f65895j.reverse();
            h2 k11 = h2.k();
            if (jVar.f65958f.B) {
                k11 = k11.g(Integer.valueOf(jVar.f65962j), Integer.valueOf(jVar2.f65962j), n.f65895j.reverse());
            }
            return k11.g(Integer.valueOf(jVar.f65963k), Integer.valueOf(jVar2.f65963k), reverse).g(Integer.valueOf(jVar.f65962j), Integer.valueOf(jVar2.f65962j), reverse).j();
        }

        public static int h(List list, List list2) {
            return h2.k().g((j) Collections.max(list, new Comparator() { // from class: j2.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f11;
                    f11 = n.j.f((n.j) obj, (n.j) obj2);
                    return f11;
                }
            }), (j) Collections.max(list2, new Comparator() { // from class: j2.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f11;
                    f11 = n.j.f((n.j) obj, (n.j) obj2);
                    return f11;
                }
            }), new Comparator() { // from class: j2.w
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f11;
                    f11 = n.j.f((n.j) obj, (n.j) obj2);
                    return f11;
                }
            }).d(list.size(), list2.size()).g((j) Collections.max(list, new Comparator() { // from class: j2.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g11;
                    g11 = n.j.g((n.j) obj, (n.j) obj2);
                    return g11;
                }
            }), (j) Collections.max(list2, new Comparator() { // from class: j2.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g11;
                    g11 = n.j.g((n.j) obj, (n.j) obj2);
                    return g11;
                }
            }), new Comparator() { // from class: j2.x
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g11;
                    g11 = n.j.g((n.j) obj, (n.j) obj2);
                    return g11;
                }
            }).j();
        }

        public static ImmutableList i(int i11, androidx.media3.common.f0 f0Var, e eVar, int[] iArr, String str, int i12, Point point) {
            int I = n.I(f0Var, point != null ? point.x : eVar.f10091i, point != null ? point.y : eVar.f10092j, eVar.f10094l);
            ImmutableList.a builder = ImmutableList.builder();
            for (int i13 = 0; i13 < f0Var.f10053a; i13++) {
                int e11 = f0Var.a(i13).e();
                builder.a(new j(i11, f0Var, i13, eVar, iArr[i13], str, i12, I == Integer.MAX_VALUE || (e11 != -1 && e11 <= I)));
            }
            return builder.e();
        }

        private int j(int i11, int i12) {
            if ((this.f65956d.f10234f & 16384) != 0 || !x3.l(i11, this.f65958f.A0)) {
                return 0;
            }
            if (!this.f65957e && !this.f65958f.f65927p0) {
                return 0;
            }
            if (x3.l(i11, false) && this.f65959g && this.f65957e && this.f65956d.f10238j != -1) {
                e eVar = this.f65958f;
                if (!eVar.C && !eVar.B && (i11 & i12) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // j2.n.i
        public int a() {
            return this.f65971s;
        }

        @Override // j2.n.i
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean b(j jVar) {
            return (this.f65970r || Objects.equals(this.f65956d.f10243o, jVar.f65956d.f10243o)) && (this.f65958f.f65930s0 || (this.f65972t == jVar.f65972t && this.f65973u == jVar.f65973u));
        }
    }

    public n(Context context) {
        this(context, new a.b());
    }

    public n(Context context, h0 h0Var, z.b bVar) {
        this(h0Var, bVar, context);
    }

    public n(Context context, z.b bVar) {
        this(context, e.G0, bVar);
    }

    private n(h0 h0Var, z.b bVar, Context context) {
        this.f65896d = new Object();
        this.f65897e = context != null ? context.getApplicationContext() : null;
        this.f65898f = bVar;
        if (h0Var instanceof e) {
            this.f65899g = (e) h0Var;
        } else {
            this.f65899g = e.G0.a().l0(h0Var).F();
        }
        this.f65901i = androidx.media3.common.c.f9989g;
        if (this.f65899g.f65937z0 && context == null) {
            androidx.media3.common.util.u.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    private static void E(b0.a aVar, e eVar, z.a[] aVarArr) {
        int d11 = aVar.d();
        for (int i11 = 0; i11 < d11; i11++) {
            g2.z f11 = aVar.f(i11);
            if (eVar.j(i11, f11)) {
                eVar.i(i11, f11);
                aVarArr[i11] = null;
            }
        }
    }

    private static void F(b0.a aVar, h0 h0Var, z.a[] aVarArr) {
        int d11 = aVar.d();
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < d11; i11++) {
            G(aVar.f(i11), h0Var, hashMap);
        }
        G(aVar.h(), h0Var, hashMap);
        for (int i12 = 0; i12 < d11; i12++) {
            g0 g0Var = (g0) hashMap.get(Integer.valueOf(aVar.e(i12)));
            if (g0Var != null) {
                aVarArr[i12] = (g0Var.f10062b.isEmpty() || aVar.f(i12).d(g0Var.f10061a) == -1) ? null : new z.a(g0Var.f10061a, Ints.o(g0Var.f10062b));
            }
        }
    }

    private static void G(g2.z zVar, h0 h0Var, Map map) {
        g0 g0Var;
        for (int i11 = 0; i11 < zVar.f63389a; i11++) {
            g0 g0Var2 = (g0) h0Var.D.get(zVar.b(i11));
            if (g0Var2 != null && ((g0Var = (g0) map.get(Integer.valueOf(g0Var2.a()))) == null || (g0Var.f10062b.isEmpty() && !g0Var2.f10062b.isEmpty()))) {
                map.put(Integer.valueOf(g0Var2.a()), g0Var2);
            }
        }
    }

    protected static int H(androidx.media3.common.r rVar, String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(rVar.f10232d)) {
            return 4;
        }
        String a02 = a0(str);
        String a03 = a0(rVar.f10232d);
        if (a03 == null || a02 == null) {
            return (z10 && a03 == null) ? 1 : 0;
        }
        if (a03.startsWith(a02) || a02.startsWith(a03)) {
            return 3;
        }
        return a1.p1(a03, "-")[0].equals(a1.p1(a02, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(androidx.media3.common.f0 f0Var, int i11, int i12, boolean z10) {
        int i13;
        int i14 = Integer.MAX_VALUE;
        if (i11 != Integer.MAX_VALUE && i12 != Integer.MAX_VALUE) {
            for (int i15 = 0; i15 < f0Var.f10053a; i15++) {
                androidx.media3.common.r a11 = f0Var.a(i15);
                int i16 = a11.f10250v;
                if (i16 > 0 && (i13 = a11.f10251w) > 0) {
                    Point d11 = d0.d(z10, i11, i12, i16, i13);
                    int i17 = a11.f10250v;
                    int i18 = a11.f10251w;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (d11.x * 0.98f)) && i18 >= ((int) (d11.y * 0.98f)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
        }
        return i14;
    }

    private static String K(Context context) {
        CaptioningManager captioningManager;
        Locale locale;
        if (context == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            return null;
        }
        return a1.e0(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int L(int i11, int i12) {
        if (i11 == 0 || i11 != i12) {
            return Integer.bitCount(i11 & i12);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int M(String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals("video/dolby-vision")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 5;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public boolean Q(androidx.media3.common.r rVar, e eVar) {
        int i11;
        g gVar;
        g gVar2;
        return !eVar.f65937z0 || (i11 = rVar.E) == -1 || i11 <= 2 || (O(rVar) && (a1.f10432a < 32 || (gVar2 = this.f65900h) == null || !gVar2.d())) || (a1.f10432a >= 32 && (gVar = this.f65900h) != null && gVar.d() && this.f65900h.b() && this.f65900h.c() && this.f65900h.a(this.f65901i, rVar));
    }

    private static boolean O(androidx.media3.common.r rVar) {
        String str = rVar.f10243o;
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    c11 = 1;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(androidx.media3.common.r rVar) {
        String str = rVar.f10243o;
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c11 = 0;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1504698186:
                if (str.equals("audio/iamf")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List R(final e eVar, boolean z10, int[] iArr, int i11, androidx.media3.common.f0 f0Var, int[] iArr2) {
        return b.f(i11, f0Var, eVar, iArr2, z10, new com.google.common.base.n() { // from class: j2.m
            @Override // com.google.common.base.n
            public final boolean apply(Object obj) {
                boolean Q;
                Q = n.this.Q(eVar, (androidx.media3.common.r) obj);
                return Q;
            }
        }, iArr[i11]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List S(e eVar, int i11, androidx.media3.common.f0 f0Var, int[] iArr) {
        return c.f(i11, f0Var, eVar, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List T(e eVar, String str, String str2, int i11, androidx.media3.common.f0 f0Var, int[] iArr) {
        return h.f(i11, f0Var, eVar, iArr, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List U(e eVar, String str, int[] iArr, Point point, int i11, androidx.media3.common.f0 f0Var, int[] iArr2) {
        return j.i(i11, f0Var, eVar, iArr2, str, iArr[i11], point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int V(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    private static void W(e eVar, b0.a aVar, int[][][] iArr, z3[] z3VarArr, z[] zVarArr) {
        int i11 = -1;
        boolean z10 = false;
        int i12 = 0;
        for (int i13 = 0; i13 < aVar.d(); i13++) {
            int e11 = aVar.e(i13);
            z zVar = zVarArr[i13];
            if (e11 != 1 && zVar != null) {
                return;
            }
            if (e11 == 1 && zVar != null && zVar.length() == 1) {
                if (b0(eVar, iArr[i13][aVar.f(i13).d(zVar.getTrackGroup())][zVar.getIndexInTrackGroup(0)], zVar.getSelectedFormat())) {
                    i12++;
                    i11 = i13;
                }
            }
        }
        if (i12 == 1) {
            int i14 = eVar.f10103u.f10114b ? 1 : 2;
            z3 z3Var = z3VarArr[i11];
            if (z3Var != null && z3Var.f13482b) {
                z10 = true;
            }
            z3VarArr[i11] = new z3(i14, z10);
        }
    }

    private static void X(b0.a aVar, int[][][] iArr, z3[] z3VarArr, z[] zVarArr) {
        boolean z10;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < aVar.d(); i13++) {
            int e11 = aVar.e(i13);
            z zVar = zVarArr[i13];
            if ((e11 == 1 || e11 == 2) && zVar != null && c0(iArr[i13], aVar.f(i13), zVar)) {
                if (e11 == 1) {
                    if (i12 != -1) {
                        z10 = false;
                        break;
                    }
                    i12 = i13;
                } else {
                    if (i11 != -1) {
                        z10 = false;
                        break;
                    }
                    i11 = i13;
                }
            }
        }
        z10 = true;
        if (z10 && ((i12 == -1 || i11 == -1) ? false : true)) {
            z3 z3Var = new z3(0, true);
            z3VarArr[i12] = z3Var;
            z3VarArr[i11] = z3Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        boolean z10;
        g gVar;
        synchronized (this.f65896d) {
            try {
                z10 = this.f65899g.f65937z0 && a1.f10432a >= 32 && (gVar = this.f65900h) != null && gVar.d();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            f();
        }
    }

    private void Z(w3 w3Var) {
        boolean z10;
        synchronized (this.f65896d) {
            z10 = this.f65899g.D0;
        }
        if (z10) {
            g(w3Var);
        }
    }

    protected static String a0(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b0(e eVar, int i11, androidx.media3.common.r rVar) {
        if (x3.g(i11) == 0) {
            return false;
        }
        if (eVar.f10103u.f10115c && (x3.g(i11) & 2048) == 0) {
            return false;
        }
        if (eVar.f10103u.f10114b) {
            return !(rVar.H != 0 || rVar.I != 0) || ((x3.g(i11) & 1024) != 0);
        }
        return true;
    }

    private static boolean c0(int[][] iArr, g2.z zVar, z zVar2) {
        if (zVar2 == null) {
            return false;
        }
        int d11 = zVar.d(zVar2.getTrackGroup());
        for (int i11 = 0; i11 < zVar2.length(); i11++) {
            if (x3.k(iArr[d11][zVar2.getIndexInTrackGroup(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private Pair i0(int i11, b0.a aVar, int[][][] iArr, i.a aVar2, Comparator comparator) {
        int i12;
        RandomAccess randomAccess;
        b0.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int d11 = aVar.d();
        int i13 = 0;
        while (i13 < d11) {
            if (i11 == aVar3.e(i13)) {
                g2.z f11 = aVar3.f(i13);
                for (int i14 = 0; i14 < f11.f63389a; i14++) {
                    androidx.media3.common.f0 b11 = f11.b(i14);
                    List a11 = aVar2.a(i13, b11, iArr[i13][i14]);
                    boolean[] zArr = new boolean[b11.f10053a];
                    int i15 = 0;
                    while (i15 < b11.f10053a) {
                        i iVar = (i) a11.get(i15);
                        int a12 = iVar.a();
                        if (zArr[i15] || a12 == 0) {
                            i12 = d11;
                        } else {
                            if (a12 == 1) {
                                randomAccess = ImmutableList.of(iVar);
                                i12 = d11;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(iVar);
                                int i16 = i15 + 1;
                                while (i16 < b11.f10053a) {
                                    i iVar2 = (i) a11.get(i16);
                                    int i17 = d11;
                                    if (iVar2.a() == 2 && iVar.b(iVar2)) {
                                        arrayList2.add(iVar2);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    d11 = i17;
                                }
                                i12 = d11;
                                randomAccess = arrayList2;
                            }
                            arrayList.add(randomAccess);
                        }
                        i15++;
                        d11 = i12;
                    }
                }
            }
            i13++;
            aVar3 = aVar;
            d11 = d11;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i18 = 0; i18 < list.size(); i18++) {
            iArr2[i18] = ((i) list.get(i18)).f65955c;
        }
        i iVar3 = (i) list.get(0);
        return Pair.create(new z.a(iVar3.f65954b, iArr2), Integer.valueOf(iVar3.f65953a));
    }

    private void k0(e eVar) {
        boolean equals;
        androidx.media3.common.util.a.e(eVar);
        synchronized (this.f65896d) {
            equals = this.f65899g.equals(eVar);
            this.f65899g = eVar;
        }
        if (equals) {
            return;
        }
        if (eVar.f65937z0 && this.f65897e == null) {
            androidx.media3.common.util.u.h("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        f();
    }

    @Override // j2.e0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public e c() {
        e eVar;
        synchronized (this.f65896d) {
            eVar = this.f65899g;
        }
        return eVar;
    }

    @Override // androidx.media3.exoplayer.y3.a
    public void b(w3 w3Var) {
        Z(w3Var);
    }

    @Override // j2.e0
    public y3.a d() {
        return this;
    }

    protected z.a[] d0(b0.a aVar, int[][][] iArr, int[] iArr2, e eVar) {
        String str;
        int d11 = aVar.d();
        z.a[] aVarArr = new z.a[d11];
        Pair e02 = e0(aVar, iArr, iArr2, eVar);
        if (e02 != null) {
            aVarArr[((Integer) e02.second).intValue()] = (z.a) e02.first;
        }
        if (e02 == null) {
            str = null;
        } else {
            Object obj = e02.first;
            str = ((z.a) obj).f65975a.a(((z.a) obj).f65976b[0]).f10232d;
        }
        Pair j02 = j0(aVar, iArr, iArr2, eVar, str);
        Pair f02 = (eVar.A || j02 == null) ? f0(aVar, iArr, eVar) : null;
        if (f02 != null) {
            aVarArr[((Integer) f02.second).intValue()] = (z.a) f02.first;
        } else if (j02 != null) {
            aVarArr[((Integer) j02.second).intValue()] = (z.a) j02.first;
        }
        Pair h02 = h0(aVar, iArr, eVar, str);
        if (h02 != null) {
            aVarArr[((Integer) h02.second).intValue()] = (z.a) h02.first;
        }
        for (int i11 = 0; i11 < d11; i11++) {
            int e11 = aVar.e(i11);
            if (e11 != 2 && e11 != 1 && e11 != 3 && e11 != 4) {
                aVarArr[i11] = g0(e11, aVar.f(i11), iArr[i11], eVar);
            }
        }
        return aVarArr;
    }

    protected Pair e0(b0.a aVar, int[][][] iArr, final int[] iArr2, final e eVar) {
        final boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 < aVar.d()) {
                if (2 == aVar.e(i11) && aVar.f(i11).f63389a > 0) {
                    z10 = true;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        return i0(1, aVar, iArr, new i.a() { // from class: j2.i
            @Override // j2.n.i.a
            public final List a(int i12, androidx.media3.common.f0 f0Var, int[] iArr3) {
                List R;
                R = n.this.R(eVar, z10, iArr2, i12, f0Var, iArr3);
                return R;
            }
        }, new Comparator() { // from class: j2.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n.b.d((List) obj, (List) obj2);
            }
        });
    }

    protected Pair f0(b0.a aVar, int[][][] iArr, final e eVar) {
        if (eVar.f10103u.f10113a == 2) {
            return null;
        }
        return i0(4, aVar, iArr, new i.a() { // from class: j2.e
            @Override // j2.n.i.a
            public final List a(int i11, androidx.media3.common.f0 f0Var, int[] iArr2) {
                List S;
                S = n.S(n.e.this, i11, f0Var, iArr2);
                return S;
            }
        }, new Comparator() { // from class: j2.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n.c.d((List) obj, (List) obj2);
            }
        });
    }

    protected z.a g0(int i11, g2.z zVar, int[][] iArr, e eVar) {
        if (eVar.f10103u.f10113a == 2) {
            return null;
        }
        int i12 = 0;
        androidx.media3.common.f0 f0Var = null;
        d dVar = null;
        for (int i13 = 0; i13 < zVar.f63389a; i13++) {
            androidx.media3.common.f0 b11 = zVar.b(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < b11.f10053a; i14++) {
                if (x3.l(iArr2[i14], eVar.A0)) {
                    d dVar2 = new d(b11.a(i14), iArr2[i14]);
                    if (dVar == null || dVar2.compareTo(dVar) > 0) {
                        f0Var = b11;
                        i12 = i14;
                        dVar = dVar2;
                    }
                }
            }
        }
        if (f0Var == null) {
            return null;
        }
        return new z.a(f0Var, i12);
    }

    @Override // j2.e0
    public boolean h() {
        return true;
    }

    protected Pair h0(b0.a aVar, int[][][] iArr, final e eVar, final String str) {
        if (eVar.f10103u.f10113a == 2) {
            return null;
        }
        final String K = eVar.f10106x ? K(this.f65897e) : null;
        return i0(3, aVar, iArr, new i.a() { // from class: j2.k
            @Override // j2.n.i.a
            public final List a(int i11, androidx.media3.common.f0 f0Var, int[] iArr2) {
                List T;
                T = n.T(n.e.this, str, K, i11, f0Var, iArr2);
                return T;
            }
        }, new Comparator() { // from class: j2.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n.h.d((List) obj, (List) obj2);
            }
        });
    }

    @Override // j2.e0
    public void j() {
        g gVar;
        if (a1.f10432a >= 32 && (gVar = this.f65900h) != null) {
            gVar.e();
        }
        super.j();
    }

    protected Pair j0(b0.a aVar, int[][][] iArr, final int[] iArr2, final e eVar, final String str) {
        Context context;
        final Point point = null;
        if (eVar.f10103u.f10113a == 2) {
            return null;
        }
        if (eVar.f10093k && (context = this.f65897e) != null) {
            point = a1.V(context);
        }
        return i0(2, aVar, iArr, new i.a() { // from class: j2.g
            @Override // j2.n.i.a
            public final List a(int i11, androidx.media3.common.f0 f0Var, int[] iArr3) {
                List U;
                U = n.U(n.e.this, str, iArr2, point, i11, f0Var, iArr3);
                return U;
            }
        }, new Comparator() { // from class: j2.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n.j.h((List) obj, (List) obj2);
            }
        });
    }

    @Override // j2.e0
    public void l(androidx.media3.common.c cVar) {
        if (this.f65901i.equals(cVar)) {
            return;
        }
        this.f65901i = cVar;
        Y();
    }

    @Override // j2.e0
    public void m(h0 h0Var) {
        if (h0Var instanceof e) {
            k0((e) h0Var);
        }
        k0(new e.a().l0(h0Var).F());
    }

    @Override // j2.b0
    protected final Pair q(b0.a aVar, int[][][] iArr, int[] iArr2, r.b bVar, androidx.media3.common.e0 e0Var) {
        e eVar;
        synchronized (this.f65896d) {
            eVar = this.f65899g;
        }
        if (eVar.f65937z0 && a1.f10432a >= 32 && this.f65900h == null) {
            this.f65900h = new g(this.f65897e, this);
        }
        int d11 = aVar.d();
        z.a[] d02 = d0(aVar, iArr, iArr2, eVar);
        F(aVar, eVar, d02);
        E(aVar, eVar, d02);
        for (int i11 = 0; i11 < d11; i11++) {
            int e11 = aVar.e(i11);
            if (eVar.h(i11) || eVar.E.contains(Integer.valueOf(e11))) {
                d02[i11] = null;
            }
        }
        z[] a11 = this.f65898f.a(d02, a(), bVar, e0Var);
        z3[] z3VarArr = new z3[d11];
        for (int i12 = 0; i12 < d11; i12++) {
            z3VarArr[i12] = (eVar.h(i12) || eVar.E.contains(Integer.valueOf(aVar.e(i12))) || (aVar.e(i12) != -2 && a11[i12] == null)) ? null : z3.f13480c;
        }
        if (eVar.B0) {
            X(aVar, iArr, z3VarArr, a11);
        }
        if (eVar.f10103u.f10113a != 0) {
            W(eVar, aVar, iArr, z3VarArr, a11);
        }
        return Pair.create(z3VarArr, a11);
    }
}
