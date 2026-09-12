package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import androidx.media3.exoplayer.audio.w0;
import com.google.android.exoplayer2.a3;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.a;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.y2;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.h2;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import la.o;
import t9.x;

/* loaded from: classes3.dex */
public class e extends com.google.android.exoplayer2.trackselection.i {

    /* renamed from: k, reason: collision with root package name */
    private static final Ordering f26859k = Ordering.from(new Comparator() { // from class: la.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int P;
            P = com.google.android.exoplayer2.trackselection.e.P((Integer) obj, (Integer) obj2);
            return P;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private static final Ordering f26860l = Ordering.from(new Comparator() { // from class: la.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int Q;
            Q = com.google.android.exoplayer2.trackselection.e.Q((Integer) obj, (Integer) obj2);
            return Q;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Object f26861d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f26862e;

    /* renamed from: f, reason: collision with root package name */
    private final h.b f26863f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f26864g;

    /* renamed from: h, reason: collision with root package name */
    private d f26865h;

    /* renamed from: i, reason: collision with root package name */
    private f f26866i;

    /* renamed from: j, reason: collision with root package name */
    private com.google.android.exoplayer2.audio.e f26867j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b extends h implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        private final int f26868e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f26869f;

        /* renamed from: g, reason: collision with root package name */
        private final String f26870g;

        /* renamed from: h, reason: collision with root package name */
        private final d f26871h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f26872i;

        /* renamed from: j, reason: collision with root package name */
        private final int f26873j;

        /* renamed from: k, reason: collision with root package name */
        private final int f26874k;

        /* renamed from: l, reason: collision with root package name */
        private final int f26875l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f26876m;

        /* renamed from: n, reason: collision with root package name */
        private final int f26877n;

        /* renamed from: o, reason: collision with root package name */
        private final int f26878o;

        /* renamed from: p, reason: collision with root package name */
        private final boolean f26879p;

        /* renamed from: q, reason: collision with root package name */
        private final int f26880q;

        /* renamed from: r, reason: collision with root package name */
        private final int f26881r;

        /* renamed from: s, reason: collision with root package name */
        private final int f26882s;

        /* renamed from: t, reason: collision with root package name */
        private final int f26883t;

        /* renamed from: u, reason: collision with root package name */
        private final boolean f26884u;

        /* renamed from: v, reason: collision with root package name */
        private final boolean f26885v;

        /* JADX WARN: Multi-variable type inference failed */
        public b(int i11, TrackGroup trackGroup, int i12, d dVar, int i13, boolean z10, n nVar) {
            super(i11, trackGroup, i12);
            int i14;
            int i15;
            int i16;
            this.f26871h = dVar;
            this.f26870g = e.T(this.f26910d.f25541c);
            this.f26872i = e.L(i13, false);
            int i17 = 0;
            while (true) {
                i14 = Integer.MAX_VALUE;
                if (i17 >= dVar.f26795n.size()) {
                    i15 = 0;
                    i17 = Integer.MAX_VALUE;
                    break;
                } else {
                    i15 = e.D(this.f26910d, (String) dVar.f26795n.get(i17), false);
                    if (i15 > 0) {
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            this.f26874k = i17;
            this.f26873j = i15;
            this.f26875l = e.H(this.f26910d.f25543e, dVar.f26796o);
            o1 o1Var = this.f26910d;
            int i18 = o1Var.f25543e;
            this.f26876m = i18 == 0 || (i18 & 1) != 0;
            this.f26879p = (o1Var.f25542d & 1) != 0;
            int i19 = o1Var.f25563y;
            this.f26880q = i19;
            this.f26881r = o1Var.f25564z;
            int i20 = o1Var.f25546h;
            this.f26882s = i20;
            this.f26869f = (i20 == -1 || i20 <= dVar.f26798q) && (i19 == -1 || i19 <= dVar.f26797p) && nVar.apply(o1Var);
            String[] i02 = p0.i0();
            int i21 = 0;
            while (true) {
                if (i21 >= i02.length) {
                    i16 = 0;
                    i21 = Integer.MAX_VALUE;
                    break;
                } else {
                    i16 = e.D(this.f26910d, i02[i21], false);
                    if (i16 > 0) {
                        break;
                    } else {
                        i21++;
                    }
                }
            }
            this.f26877n = i21;
            this.f26878o = i16;
            int i22 = 0;
            while (true) {
                if (i22 < dVar.f26799r.size()) {
                    String str = this.f26910d.f25550l;
                    if (str != null && str.equals(dVar.f26799r.get(i22))) {
                        i14 = i22;
                        break;
                    }
                    i22++;
                } else {
                    break;
                }
            }
            this.f26883t = i14;
            this.f26884u = y2.e(i13) == 128;
            this.f26885v = y2.g(i13) == 64;
            this.f26868e = g(i13, z10);
        }

        public static int d(List list, List list2) {
            return ((b) Collections.max(list)).compareTo((b) Collections.max(list2));
        }

        public static ImmutableList f(int i11, TrackGroup trackGroup, d dVar, int[] iArr, boolean z10, n nVar) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i12 = 0; i12 < trackGroup.f25727a; i12++) {
                builder.a(new b(i11, trackGroup, i12, dVar, iArr[i12], z10, nVar));
            }
            return builder.e();
        }

        private int g(int i11, boolean z10) {
            if (!e.L(i11, this.f26871h.N)) {
                return 0;
            }
            if (!this.f26869f && !this.f26871h.H) {
                return 0;
            }
            if (e.L(i11, false) && this.f26869f && this.f26910d.f25546h != -1) {
                d dVar = this.f26871h;
                if (!dVar.f26805x && !dVar.f26804w && (dVar.P || !z10)) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // com.google.android.exoplayer2.trackselection.e.h
        public int a() {
            return this.f26868e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            Ordering reverse = (this.f26869f && this.f26872i) ? e.f26859k : e.f26859k.reverse();
            h2 g11 = h2.k().h(this.f26872i, bVar.f26872i).g(Integer.valueOf(this.f26874k), Integer.valueOf(bVar.f26874k), Ordering.natural().reverse()).d(this.f26873j, bVar.f26873j).d(this.f26875l, bVar.f26875l).h(this.f26879p, bVar.f26879p).h(this.f26876m, bVar.f26876m).g(Integer.valueOf(this.f26877n), Integer.valueOf(bVar.f26877n), Ordering.natural().reverse()).d(this.f26878o, bVar.f26878o).h(this.f26869f, bVar.f26869f).g(Integer.valueOf(this.f26883t), Integer.valueOf(bVar.f26883t), Ordering.natural().reverse()).g(Integer.valueOf(this.f26882s), Integer.valueOf(bVar.f26882s), this.f26871h.f26804w ? e.f26859k.reverse() : e.f26860l).h(this.f26884u, bVar.f26884u).h(this.f26885v, bVar.f26885v).g(Integer.valueOf(this.f26880q), Integer.valueOf(bVar.f26880q), reverse).g(Integer.valueOf(this.f26881r), Integer.valueOf(bVar.f26881r), reverse);
            Integer valueOf = Integer.valueOf(this.f26882s);
            Integer valueOf2 = Integer.valueOf(bVar.f26882s);
            if (!p0.c(this.f26870g, bVar.f26870g)) {
                reverse = e.f26860l;
            }
            return g11.g(valueOf, valueOf2, reverse).j();
        }

        @Override // com.google.android.exoplayer2.trackselection.e.h
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean b(b bVar) {
            int i11;
            String str;
            int i12;
            d dVar = this.f26871h;
            if ((dVar.K || ((i12 = this.f26910d.f25563y) != -1 && i12 == bVar.f26910d.f25563y)) && (dVar.I || ((str = this.f26910d.f25550l) != null && TextUtils.equals(str, bVar.f26910d.f25550l)))) {
                d dVar2 = this.f26871h;
                if ((dVar2.J || ((i11 = this.f26910d.f25564z) != -1 && i11 == bVar.f26910d.f25564z)) && (dVar2.L || (this.f26884u == bVar.f26884u && this.f26885v == bVar.f26885v))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f26886a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f26887b;

        public c(o1 o1Var, int i11) {
            this.f26886a = (o1Var.f25542d & 1) != 0;
            this.f26887b = e.L(i11, false);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return h2.k().h(this.f26887b, cVar.f26887b).h(this.f26886a, cVar.f26886a).j();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends TrackSelectionParameters implements k {
        public static final d S;
        public static final d T;
        public static final k.a U;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final boolean N;
        public final boolean O;
        public final boolean P;
        private final SparseArray Q;
        private final SparseBooleanArray R;

        /* loaded from: classes3.dex */
        public static final class a extends TrackSelectionParameters.Builder {
            private boolean A;
            private boolean B;
            private boolean C;
            private boolean D;
            private boolean E;
            private boolean F;
            private boolean G;
            private boolean H;
            private boolean I;
            private boolean J;
            private boolean K;
            private boolean L;
            private boolean M;
            private final SparseArray N;
            private final SparseBooleanArray O;

            @Deprecated
            public a() {
                this.N = new SparseArray();
                this.O = new SparseBooleanArray();
                a0();
            }

            public a(Context context) {
                super(context);
                this.N = new SparseArray();
                this.O = new SparseBooleanArray();
                a0();
            }

            private a(Bundle bundle) {
                super(bundle);
                a0();
                d dVar = d.S;
                p0(bundle.getBoolean(TrackSelectionParameters.c(1000), dVar.D));
                j0(bundle.getBoolean(TrackSelectionParameters.c(1001), dVar.E));
                k0(bundle.getBoolean(TrackSelectionParameters.c(1002), dVar.F));
                i0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW), dVar.G));
                n0(bundle.getBoolean(TrackSelectionParameters.c(1003), dVar.H));
                f0(bundle.getBoolean(TrackSelectionParameters.c(1004), dVar.I));
                g0(bundle.getBoolean(TrackSelectionParameters.c(1005), dVar.J));
                d0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_CELL), dVar.K));
                e0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), dVar.L));
                l0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW), dVar.M));
                o0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_CROSSHAIR), dVar.N));
                t0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_TEXT), dVar.O));
                h0(bundle.getBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_VERTICAL_TEXT), dVar.P));
                this.N = new SparseArray();
                s0(bundle);
                this.O = b0(bundle.getIntArray(TrackSelectionParameters.c(PointerIconCompat.TYPE_ALL_SCROLL)));
            }

            private a(d dVar) {
                super(dVar);
                this.A = dVar.D;
                this.B = dVar.E;
                this.C = dVar.F;
                this.D = dVar.G;
                this.E = dVar.H;
                this.F = dVar.I;
                this.G = dVar.J;
                this.H = dVar.K;
                this.I = dVar.L;
                this.J = dVar.M;
                this.K = dVar.N;
                this.L = dVar.O;
                this.M = dVar.P;
                this.N = Z(dVar.Q);
                this.O = dVar.R.clone();
            }

            private static SparseArray Z(SparseArray sparseArray) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    sparseArray2.put(sparseArray.keyAt(i11), new HashMap((Map) sparseArray.valueAt(i11)));
                }
                return sparseArray2;
            }

            private void a0() {
                this.A = true;
                this.B = false;
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.H = false;
                this.I = false;
                this.J = true;
                this.K = true;
                this.L = false;
                this.M = true;
            }

            private SparseBooleanArray b0(int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int i11 : iArr) {
                    sparseBooleanArray.append(i11, true);
                }
                return sparseBooleanArray;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private void s0(Bundle bundle) {
                int[] intArray = bundle.getIntArray(TrackSelectionParameters.c(1010));
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.c(1011));
                ImmutableList of2 = parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(x.f76287e, parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(TrackSelectionParameters.c(1012));
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : com.google.android.exoplayer2.util.d.c(C0380e.f26888e, sparseParcelableArray);
                if (intArray == null || intArray.length != of2.size()) {
                    return;
                }
                for (int i11 = 0; i11 < intArray.length; i11++) {
                    r0(intArray[i11], (x) of2.get(i11), (C0380e) sparseArray.get(i11));
                }
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            /* renamed from: Y, reason: merged with bridge method [inline-methods] */
            public d A() {
                return new d(this);
            }

            protected a c0(TrackSelectionParameters trackSelectionParameters) {
                super.D(trackSelectionParameters);
                return this;
            }

            public a d0(boolean z10) {
                this.H = z10;
                return this;
            }

            public a e0(boolean z10) {
                this.I = z10;
                return this;
            }

            public a f0(boolean z10) {
                this.F = z10;
                return this;
            }

            public a g0(boolean z10) {
                this.G = z10;
                return this;
            }

            public a h0(boolean z10) {
                this.M = z10;
                return this;
            }

            public a i0(boolean z10) {
                this.D = z10;
                return this;
            }

            public a j0(boolean z10) {
                this.B = z10;
                return this;
            }

            public a k0(boolean z10) {
                this.C = z10;
                return this;
            }

            public a l0(boolean z10) {
                this.J = z10;
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            /* renamed from: m0, reason: merged with bridge method [inline-methods] */
            public a E(Set set) {
                super.E(set);
                return this;
            }

            public a n0(boolean z10) {
                this.E = z10;
                return this;
            }

            public a o0(boolean z10) {
                this.K = z10;
                return this;
            }

            public a p0(boolean z10) {
                this.A = z10;
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            /* renamed from: q0, reason: merged with bridge method [inline-methods] */
            public a F(Context context) {
                super.F(context);
                return this;
            }

            public a r0(int i11, x xVar, C0380e c0380e) {
                Map map = (Map) this.N.get(i11);
                if (map == null) {
                    map = new HashMap();
                    this.N.put(i11, map);
                }
                if (map.containsKey(xVar) && p0.c(map.get(xVar), c0380e)) {
                    return this;
                }
                map.put(xVar, c0380e);
                return this;
            }

            public a t0(boolean z10) {
                this.L = z10;
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            /* renamed from: u0, reason: merged with bridge method [inline-methods] */
            public a H(int i11, int i12, boolean z10) {
                super.H(i11, i12, z10);
                return this;
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters.Builder
            /* renamed from: v0, reason: merged with bridge method [inline-methods] */
            public a I(Context context, boolean z10) {
                super.I(context, z10);
                return this;
            }
        }

        static {
            d A = new a().A();
            S = A;
            T = A;
            U = new k.a() { // from class: la.i
                @Override // com.google.android.exoplayer2.k.a
                public final com.google.android.exoplayer2.k a(Bundle bundle) {
                    e.d p11;
                    p11 = e.d.p(bundle);
                    return p11;
                }
            };
        }

        private d(a aVar) {
            super(aVar);
            this.D = aVar.A;
            this.E = aVar.B;
            this.F = aVar.C;
            this.G = aVar.D;
            this.H = aVar.E;
            this.I = aVar.F;
            this.J = aVar.G;
            this.K = aVar.H;
            this.L = aVar.I;
            this.M = aVar.J;
            this.N = aVar.K;
            this.O = aVar.L;
            this.P = aVar.M;
            this.Q = aVar.N;
            this.R = aVar.O;
        }

        private static boolean g(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
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

        private static boolean h(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (indexOfKey < 0 || !i((Map) sparseArray.valueAt(i11), (Map) sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static boolean i(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                x xVar = (x) entry.getKey();
                if (!map2.containsKey(xVar) || !p0.c(entry.getValue(), map2.get(xVar))) {
                    return false;
                }
            }
            return true;
        }

        public static d k(Context context) {
            return new a(context).A();
        }

        private static int[] l(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i11 = 0; i11 < sparseBooleanArray.size(); i11++) {
                iArr[i11] = sparseBooleanArray.keyAt(i11);
            }
            return iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d p(Bundle bundle) {
            return new a(bundle).A();
        }

        private static void q(Bundle bundle, SparseArray sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                int keyAt = sparseArray.keyAt(i11);
                for (Map.Entry entry : ((Map) sparseArray.valueAt(i11)).entrySet()) {
                    C0380e c0380e = (C0380e) entry.getValue();
                    if (c0380e != null) {
                        sparseArray2.put(arrayList2.size(), c0380e);
                    }
                    arrayList2.add((x) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(TrackSelectionParameters.c(1010), Ints.o(arrayList));
                bundle.putParcelableArrayList(TrackSelectionParameters.c(1011), com.google.android.exoplayer2.util.d.d(arrayList2));
                bundle.putSparseParcelableArray(TrackSelectionParameters.c(1012), com.google.android.exoplayer2.util.d.e(sparseArray2));
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return super.equals(dVar) && this.D == dVar.D && this.E == dVar.E && this.F == dVar.F && this.G == dVar.G && this.H == dVar.H && this.I == dVar.I && this.J == dVar.J && this.K == dVar.K && this.L == dVar.L && this.M == dVar.M && this.N == dVar.N && this.O == dVar.O && this.P == dVar.P && g(this.R, dVar.R) && h(this.Q, dVar.Q);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0)) * 31) + (this.P ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a();
        }

        public boolean m(int i11) {
            return this.R.get(i11);
        }

        public C0380e n(int i11, x xVar) {
            Map map = (Map) this.Q.get(i11);
            if (map != null) {
                return (C0380e) map.get(xVar);
            }
            return null;
        }

        public boolean o(int i11, x xVar) {
            Map map = (Map) this.Q.get(i11);
            return map != null && map.containsKey(xVar);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = super.toBundle();
            bundle.putBoolean(TrackSelectionParameters.c(1000), this.D);
            bundle.putBoolean(TrackSelectionParameters.c(1001), this.E);
            bundle.putBoolean(TrackSelectionParameters.c(1002), this.F);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW), this.G);
            bundle.putBoolean(TrackSelectionParameters.c(1003), this.H);
            bundle.putBoolean(TrackSelectionParameters.c(1004), this.I);
            bundle.putBoolean(TrackSelectionParameters.c(1005), this.J);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_CELL), this.K);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), this.L);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW), this.M);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_CROSSHAIR), this.N);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_TEXT), this.O);
            bundle.putBoolean(TrackSelectionParameters.c(PointerIconCompat.TYPE_VERTICAL_TEXT), this.P);
            q(bundle, this.Q);
            bundle.putIntArray(TrackSelectionParameters.c(PointerIconCompat.TYPE_ALL_SCROLL), l(this.R));
            return bundle;
        }
    }

    /* renamed from: com.google.android.exoplayer2.trackselection.e$e, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0380e implements k {

        /* renamed from: e, reason: collision with root package name */
        public static final k.a f26888e = new k.a() { // from class: la.j
            @Override // com.google.android.exoplayer2.k.a
            public final com.google.android.exoplayer2.k a(Bundle bundle) {
                e.C0380e d11;
                d11 = e.C0380e.d(bundle);
                return d11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f26889a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f26890b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26891c;

        /* renamed from: d, reason: collision with root package name */
        public final int f26892d;

        public C0380e(int i11, int... iArr) {
            this(i11, iArr, 0);
        }

        public C0380e(int i11, int[] iArr, int i12) {
            this.f26889a = i11;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f26890b = copyOf;
            this.f26891c = iArr.length;
            this.f26892d = i12;
            Arrays.sort(copyOf);
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ C0380e d(Bundle bundle) {
            boolean z10 = false;
            int i11 = bundle.getInt(c(0), -1);
            int[] intArray = bundle.getIntArray(c(1));
            int i12 = bundle.getInt(c(2), -1);
            if (i11 >= 0 && i12 >= 0) {
                z10 = true;
            }
            com.google.android.exoplayer2.util.a.a(z10);
            com.google.android.exoplayer2.util.a.e(intArray);
            return new C0380e(i11, intArray, i12);
        }

        public boolean b(int i11) {
            for (int i12 : this.f26890b) {
                if (i12 == i11) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0380e.class != obj.getClass()) {
                return false;
            }
            C0380e c0380e = (C0380e) obj;
            return this.f26889a == c0380e.f26889a && Arrays.equals(this.f26890b, c0380e.f26890b) && this.f26892d == c0380e.f26892d;
        }

        public int hashCode() {
            return (((this.f26889a * 31) + Arrays.hashCode(this.f26890b)) * 31) + this.f26892d;
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.f26889a);
            bundle.putIntArray(c(1), this.f26890b);
            bundle.putInt(c(2), this.f26892d);
            return bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final Spatializer f26893a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f26894b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f26895c;

        /* renamed from: d, reason: collision with root package name */
        private Spatializer$OnSpatializerStateChangedListener f26896d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements Spatializer$OnSpatializerStateChangedListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f26897a;

            a(f fVar, e eVar) {
                this.f26897a = eVar;
            }

            public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z10) {
                this.f26897a.S();
            }

            public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z10) {
                this.f26897a.S();
            }
        }

        private f(Spatializer spatializer) {
            int immersiveAudioLevel;
            this.f26893a = spatializer;
            immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
            this.f26894b = immersiveAudioLevel != 0;
        }

        public static f g(Context context) {
            Spatializer spatializer;
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager == null) {
                return null;
            }
            spatializer = audioManager.getSpatializer();
            return new f(spatializer);
        }

        public boolean a(com.google.android.exoplayer2.audio.e eVar, o1 o1Var) {
            boolean canBeSpatialized;
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(p0.G((MimeTypes.AUDIO_E_AC3_JOC.equals(o1Var.f25550l) && o1Var.f25563y == 16) ? 12 : o1Var.f25563y));
            int i11 = o1Var.f25564z;
            if (i11 != -1) {
                channelMask.setSampleRate(i11);
            }
            canBeSpatialized = this.f26893a.canBeSpatialized(eVar.b().f24696a, channelMask.build());
            return canBeSpatialized;
        }

        public void b(e eVar, Looper looper) {
            if (this.f26896d == null && this.f26895c == null) {
                this.f26896d = new a(this, eVar);
                Handler handler = new Handler(looper);
                this.f26895c = handler;
                Spatializer spatializer = this.f26893a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new w0(handler), this.f26896d);
            }
        }

        public boolean c() {
            boolean isAvailable;
            isAvailable = this.f26893a.isAvailable();
            return isAvailable;
        }

        public boolean d() {
            boolean isEnabled;
            isEnabled = this.f26893a.isEnabled();
            return isEnabled;
        }

        public boolean e() {
            return this.f26894b;
        }

        public void f() {
            Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener = this.f26896d;
            if (spatializer$OnSpatializerStateChangedListener == null || this.f26895c == null) {
                return;
            }
            this.f26893a.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
            ((Handler) p0.j(this.f26895c)).removeCallbacksAndMessages(null);
            this.f26895c = null;
            this.f26896d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class g extends h implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        private final int f26898e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f26899f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f26900g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f26901h;

        /* renamed from: i, reason: collision with root package name */
        private final int f26902i;

        /* renamed from: j, reason: collision with root package name */
        private final int f26903j;

        /* renamed from: k, reason: collision with root package name */
        private final int f26904k;

        /* renamed from: l, reason: collision with root package name */
        private final int f26905l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f26906m;

        /* JADX WARN: Multi-variable type inference failed */
        public g(int i11, TrackGroup trackGroup, int i12, d dVar, int i13, String str) {
            super(i11, trackGroup, i12);
            int i14;
            int i15 = 0;
            this.f26899f = e.L(i13, false);
            int i16 = this.f26910d.f25542d & (~dVar.f26802u);
            this.f26900g = (i16 & 1) != 0;
            this.f26901h = (i16 & 2) != 0;
            ImmutableList of2 = dVar.f26800s.isEmpty() ? ImmutableList.of("") : dVar.f26800s;
            int i17 = 0;
            while (true) {
                if (i17 >= of2.size()) {
                    i17 = Integer.MAX_VALUE;
                    i14 = 0;
                    break;
                } else {
                    i14 = e.D(this.f26910d, (String) of2.get(i17), dVar.f26803v);
                    if (i14 > 0) {
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            this.f26902i = i17;
            this.f26903j = i14;
            int H = e.H(this.f26910d.f25543e, dVar.f26801t);
            this.f26904k = H;
            this.f26906m = (this.f26910d.f25543e & 1088) != 0;
            int D = e.D(this.f26910d, str, e.T(str) == null);
            this.f26905l = D;
            boolean z10 = i14 > 0 || (dVar.f26800s.isEmpty() && H > 0) || this.f26900g || (this.f26901h && D > 0);
            if (e.L(i13, dVar.N) && z10) {
                i15 = 1;
            }
            this.f26898e = i15;
        }

        public static int d(List list, List list2) {
            return ((g) list.get(0)).compareTo((g) list2.get(0));
        }

        public static ImmutableList f(int i11, TrackGroup trackGroup, d dVar, int[] iArr, String str) {
            ImmutableList.a builder = ImmutableList.builder();
            for (int i12 = 0; i12 < trackGroup.f25727a; i12++) {
                builder.a(new g(i11, trackGroup, i12, dVar, iArr[i12], str));
            }
            return builder.e();
        }

        @Override // com.google.android.exoplayer2.trackselection.e.h
        public int a() {
            return this.f26898e;
        }

        @Override // java.lang.Comparable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            h2 d11 = h2.k().h(this.f26899f, gVar.f26899f).g(Integer.valueOf(this.f26902i), Integer.valueOf(gVar.f26902i), Ordering.natural().reverse()).d(this.f26903j, gVar.f26903j).d(this.f26904k, gVar.f26904k).h(this.f26900g, gVar.f26900g).g(Boolean.valueOf(this.f26901h), Boolean.valueOf(gVar.f26901h), this.f26903j == 0 ? Ordering.natural() : Ordering.natural().reverse()).d(this.f26905l, gVar.f26905l);
            if (this.f26904k == 0) {
                d11 = d11.i(this.f26906m, gVar.f26906m);
            }
            return d11.j();
        }

        @Override // com.google.android.exoplayer2.trackselection.e.h
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean b(g gVar) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public final int f26907a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackGroup f26908b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26909c;

        /* renamed from: d, reason: collision with root package name */
        public final o1 f26910d;

        /* loaded from: classes3.dex */
        public interface a {
            List a(int i11, TrackGroup trackGroup, int[] iArr);
        }

        public h(int i11, TrackGroup trackGroup, int i12) {
            this.f26907a = i11;
            this.f26908b = trackGroup;
            this.f26909c = i12;
            this.f26910d = trackGroup.c(i12);
        }

        public abstract int a();

        public abstract boolean b(h hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class i extends h {

        /* renamed from: e, reason: collision with root package name */
        private final boolean f26911e;

        /* renamed from: f, reason: collision with root package name */
        private final d f26912f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f26913g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f26914h;

        /* renamed from: i, reason: collision with root package name */
        private final int f26915i;

        /* renamed from: j, reason: collision with root package name */
        private final int f26916j;

        /* renamed from: k, reason: collision with root package name */
        private final int f26917k;

        /* renamed from: l, reason: collision with root package name */
        private final int f26918l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f26919m;

        /* renamed from: n, reason: collision with root package name */
        private final boolean f26920n;

        /* renamed from: o, reason: collision with root package name */
        private final int f26921o;

        /* renamed from: p, reason: collision with root package name */
        private final boolean f26922p;

        /* renamed from: q, reason: collision with root package name */
        private final boolean f26923q;

        /* renamed from: r, reason: collision with root package name */
        private final int f26924r;

        /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00c8 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public i(int r5, com.google.android.exoplayer2.source.TrackGroup r6, int r7, com.google.android.exoplayer2.trackselection.e.d r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.e.i.<init>(int, com.google.android.exoplayer2.source.TrackGroup, int, com.google.android.exoplayer2.trackselection.e$d, int, int, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int f(i iVar, i iVar2) {
            h2 h11 = h2.k().h(iVar.f26914h, iVar2.f26914h).d(iVar.f26918l, iVar2.f26918l).h(iVar.f26919m, iVar2.f26919m).h(iVar.f26911e, iVar2.f26911e).h(iVar.f26913g, iVar2.f26913g).g(Integer.valueOf(iVar.f26917k), Integer.valueOf(iVar2.f26917k), Ordering.natural().reverse()).h(iVar.f26922p, iVar2.f26922p).h(iVar.f26923q, iVar2.f26923q);
            if (iVar.f26922p && iVar.f26923q) {
                h11 = h11.d(iVar.f26924r, iVar2.f26924r);
            }
            return h11.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int g(i iVar, i iVar2) {
            Ordering reverse = (iVar.f26911e && iVar.f26914h) ? e.f26859k : e.f26859k.reverse();
            return h2.k().g(Integer.valueOf(iVar.f26915i), Integer.valueOf(iVar2.f26915i), iVar.f26912f.f26804w ? e.f26859k.reverse() : e.f26860l).g(Integer.valueOf(iVar.f26916j), Integer.valueOf(iVar2.f26916j), reverse).g(Integer.valueOf(iVar.f26915i), Integer.valueOf(iVar2.f26915i), reverse).j();
        }

        public static int h(List list, List list2) {
            return h2.k().g((i) Collections.max(list, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f11;
                    f11 = e.i.f((e.i) obj, (e.i) obj2);
                    return f11;
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f11;
                    f11 = e.i.f((e.i) obj, (e.i) obj2);
                    return f11;
                }
            }), new Comparator() { // from class: com.google.android.exoplayer2.trackselection.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int f11;
                    f11 = e.i.f((e.i) obj, (e.i) obj2);
                    return f11;
                }
            }).d(list.size(), list2.size()).g((i) Collections.max(list, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.g
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g11;
                    g11 = e.i.g((e.i) obj, (e.i) obj2);
                    return g11;
                }
            }), (i) Collections.max(list2, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.g
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g11;
                    g11 = e.i.g((e.i) obj, (e.i) obj2);
                    return g11;
                }
            }), new Comparator() { // from class: com.google.android.exoplayer2.trackselection.g
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int g11;
                    g11 = e.i.g((e.i) obj, (e.i) obj2);
                    return g11;
                }
            }).j();
        }

        public static ImmutableList i(int i11, TrackGroup trackGroup, d dVar, int[] iArr, int i12) {
            int E = e.E(trackGroup, dVar.f26790i, dVar.f26791j, dVar.f26792k);
            ImmutableList.a builder = ImmutableList.builder();
            for (int i13 = 0; i13 < trackGroup.f25727a; i13++) {
                int f11 = trackGroup.c(i13).f();
                builder.a(new i(i11, trackGroup, i13, dVar, iArr[i13], i12, E == Integer.MAX_VALUE || (f11 != -1 && f11 <= E)));
            }
            return builder.e();
        }

        private int j(int i11, int i12) {
            if ((this.f26910d.f25543e & 16384) != 0 || !e.L(i11, this.f26912f.N)) {
                return 0;
            }
            if (!this.f26911e && !this.f26912f.D) {
                return 0;
            }
            if (e.L(i11, false) && this.f26913g && this.f26911e && this.f26910d.f25546h != -1) {
                d dVar = this.f26912f;
                if (!dVar.f26805x && !dVar.f26804w && (i11 & i12) != 0) {
                    return 2;
                }
            }
            return 1;
        }

        @Override // com.google.android.exoplayer2.trackselection.e.h
        public int a() {
            return this.f26921o;
        }

        @Override // com.google.android.exoplayer2.trackselection.e.h
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean b(i iVar) {
            return (this.f26920n || p0.c(this.f26910d.f25550l, iVar.f26910d.f25550l)) && (this.f26912f.G || (this.f26922p == iVar.f26922p && this.f26923q == iVar.f26923q));
        }
    }

    @Deprecated
    public e() {
        this(d.S, new a.b());
    }

    public e(Context context) {
        this(context, new a.b());
    }

    public e(Context context, TrackSelectionParameters trackSelectionParameters, h.b bVar) {
        this(trackSelectionParameters, bVar, context);
    }

    public e(Context context, h.b bVar) {
        this(context, d.k(context), bVar);
    }

    public e(TrackSelectionParameters trackSelectionParameters, h.b bVar) {
        this(trackSelectionParameters, bVar, (Context) null);
    }

    private e(TrackSelectionParameters trackSelectionParameters, h.b bVar, Context context) {
        this.f26861d = new Object();
        this.f26862e = context != null ? context.getApplicationContext() : null;
        this.f26863f = bVar;
        if (trackSelectionParameters instanceof d) {
            this.f26865h = (d) trackSelectionParameters;
        } else {
            this.f26865h = (context == null ? d.S : d.k(context)).a().c0(trackSelectionParameters).A();
        }
        this.f26867j = com.google.android.exoplayer2.audio.e.f24688g;
        boolean z10 = context != null && p0.x0(context);
        this.f26864g = z10;
        if (!z10 && context != null && p0.f27680a >= 32) {
            this.f26866i = f.g(context);
        }
        if (this.f26865h.M && context == null) {
            s.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    private static void A(i.a aVar, d dVar, h.a[] aVarArr) {
        int d11 = aVar.d();
        for (int i11 = 0; i11 < d11; i11++) {
            x f11 = aVar.f(i11);
            if (dVar.o(i11, f11)) {
                C0380e n11 = dVar.n(i11, f11);
                aVarArr[i11] = (n11 == null || n11.f26890b.length == 0) ? null : new h.a(f11.b(n11.f26889a), n11.f26890b, n11.f26892d);
            }
        }
    }

    private static void B(i.a aVar, TrackSelectionParameters trackSelectionParameters, h.a[] aVarArr) {
        int d11 = aVar.d();
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < d11; i11++) {
            C(aVar.f(i11), trackSelectionParameters, hashMap);
        }
        C(aVar.h(), trackSelectionParameters, hashMap);
        for (int i12 = 0; i12 < d11; i12++) {
            o oVar = (o) hashMap.get(Integer.valueOf(aVar.e(i12)));
            if (oVar != null) {
                aVarArr[i12] = (oVar.f68920b.isEmpty() || aVar.f(i12).c(oVar.f68919a) == -1) ? null : new h.a(oVar.f68919a, Ints.o(oVar.f68920b));
            }
        }
    }

    private static void C(x xVar, TrackSelectionParameters trackSelectionParameters, Map map) {
        o oVar;
        for (int i11 = 0; i11 < xVar.f76288a; i11++) {
            o oVar2 = (o) trackSelectionParameters.f26806y.get(xVar.b(i11));
            if (oVar2 != null && ((oVar = (o) map.get(Integer.valueOf(oVar2.b()))) == null || (oVar.f68920b.isEmpty() && !oVar2.f68920b.isEmpty()))) {
                map.put(Integer.valueOf(oVar2.b()), oVar2);
            }
        }
    }

    protected static int D(o1 o1Var, String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(o1Var.f25541c)) {
            return 4;
        }
        String T = T(str);
        String T2 = T(o1Var.f25541c);
        if (T2 == null || T == null) {
            return (z10 && T2 == null) ? 1 : 0;
        }
        if (T2.startsWith(T) || T.startsWith(T2)) {
            return 3;
        }
        return p0.T0(T2, "-")[0].equals(p0.T0(T, "-")[0]) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(TrackGroup trackGroup, int i11, int i12, boolean z10) {
        int i13;
        int i14 = Integer.MAX_VALUE;
        if (i11 != Integer.MAX_VALUE && i12 != Integer.MAX_VALUE) {
            for (int i15 = 0; i15 < trackGroup.f25727a; i15++) {
                o1 c11 = trackGroup.c(i15);
                int i16 = c11.f25555q;
                if (i16 > 0 && (i13 = c11.f25556r) > 0) {
                    Point F = F(z10, i11, i12, i16, i13);
                    int i17 = c11.f25555q;
                    int i18 = c11.f25556r;
                    int i19 = i17 * i18;
                    if (i17 >= ((int) (F.x * 0.98f)) && i18 >= ((int) (F.y * 0.98f)) && i19 < i14) {
                        i14 = i19;
                    }
                }
            }
        }
        return i14;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Point F(boolean r3, int r4, int r5, int r6, int r7) {
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
            int r4 = com.google.android.exoplayer2.util.p0.l(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.p0.l(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.e.F(boolean, int, int, int, int):android.graphics.Point");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(int i11, int i12) {
        if (i11 == 0 || i11 != i12) {
            return Integer.bitCount(i11 & i12);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1662735862:
                if (str.equals("video/av01")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.VIDEO_H265)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.VIDEO_H264)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.VIDEO_VP9)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 4;
            case 1:
                return 3;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(o1 o1Var) {
        boolean z10;
        f fVar;
        f fVar2;
        synchronized (this.f26861d) {
            try {
                if (this.f26865h.M) {
                    if (!this.f26864g) {
                        if (o1Var.f25563y > 2) {
                            if (K(o1Var)) {
                                if (p0.f27680a >= 32 && (fVar2 = this.f26866i) != null && fVar2.e()) {
                                }
                            }
                            if (p0.f27680a < 32 || (fVar = this.f26866i) == null || !fVar.e() || !this.f26866i.c() || !this.f26866i.d() || !this.f26866i.a(this.f26867j, o1Var)) {
                                z10 = false;
                            }
                        }
                    }
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    private static boolean K(o1 o1Var) {
        String str = o1Var.f25550l;
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

    protected static boolean L(int i11, boolean z10) {
        int f11 = y2.f(i11);
        return f11 == 4 || (z10 && f11 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List M(d dVar, boolean z10, int i11, TrackGroup trackGroup, int[] iArr) {
        return b.f(i11, trackGroup, dVar, iArr, z10, new n() { // from class: la.h
            @Override // com.google.common.base.n
            public final boolean apply(Object obj) {
                boolean J;
                J = com.google.android.exoplayer2.trackselection.e.this.J((o1) obj);
                return J;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List N(d dVar, String str, int i11, TrackGroup trackGroup, int[] iArr) {
        return g.f(i11, trackGroup, dVar, iArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List O(d dVar, int[] iArr, int i11, TrackGroup trackGroup, int[] iArr2) {
        return i.i(i11, trackGroup, dVar, iArr2, iArr[i11]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int P(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q(Integer num, Integer num2) {
        return 0;
    }

    private static void R(i.a aVar, int[][][] iArr, a3[] a3VarArr, com.google.android.exoplayer2.trackselection.h[] hVarArr) {
        boolean z10;
        boolean z11 = false;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < aVar.d(); i13++) {
            int e11 = aVar.e(i13);
            com.google.android.exoplayer2.trackselection.h hVar = hVarArr[i13];
            if ((e11 == 1 || e11 == 2) && hVar != null && U(iArr[i13], aVar.f(i13), hVar)) {
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
        if (i12 != -1 && i11 != -1) {
            z11 = true;
        }
        if (z10 && z11) {
            a3 a3Var = new a3(true);
            a3VarArr[i12] = a3Var;
            a3VarArr[i11] = a3Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean z10;
        f fVar;
        synchronized (this.f26861d) {
            try {
                z10 = this.f26865h.M && !this.f26864g && p0.f27680a >= 32 && (fVar = this.f26866i) != null && fVar.e();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            d();
        }
    }

    protected static String T(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    private static boolean U(int[][] iArr, x xVar, com.google.android.exoplayer2.trackselection.h hVar) {
        if (hVar == null) {
            return false;
        }
        int c11 = xVar.c(hVar.getTrackGroup());
        for (int i11 = 0; i11 < hVar.length(); i11++) {
            if (y2.h(iArr[c11][hVar.getIndexInTrackGroup(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private Pair Z(int i11, i.a aVar, int[][][] iArr, h.a aVar2, Comparator comparator) {
        int i12;
        RandomAccess randomAccess;
        i.a aVar3 = aVar;
        ArrayList arrayList = new ArrayList();
        int d11 = aVar.d();
        int i13 = 0;
        while (i13 < d11) {
            if (i11 == aVar3.e(i13)) {
                x f11 = aVar3.f(i13);
                for (int i14 = 0; i14 < f11.f76288a; i14++) {
                    TrackGroup b11 = f11.b(i14);
                    List a11 = aVar2.a(i13, b11, iArr[i13][i14]);
                    boolean[] zArr = new boolean[b11.f25727a];
                    int i15 = 0;
                    while (i15 < b11.f25727a) {
                        h hVar = (h) a11.get(i15);
                        int a12 = hVar.a();
                        if (zArr[i15] || a12 == 0) {
                            i12 = d11;
                        } else {
                            if (a12 == 1) {
                                randomAccess = ImmutableList.of(hVar);
                                i12 = d11;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(hVar);
                                int i16 = i15 + 1;
                                while (i16 < b11.f25727a) {
                                    h hVar2 = (h) a11.get(i16);
                                    int i17 = d11;
                                    if (hVar2.a() == 2 && hVar.b(hVar2)) {
                                        arrayList2.add(hVar2);
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
            iArr2[i18] = ((h) list.get(i18)).f26909c;
        }
        h hVar3 = (h) list.get(0);
        return Pair.create(new h.a(hVar3.f26908b, iArr2), Integer.valueOf(hVar3.f26907a));
    }

    private void b0(d dVar) {
        boolean equals;
        com.google.android.exoplayer2.util.a.e(dVar);
        synchronized (this.f26861d) {
            equals = this.f26865h.equals(dVar);
            this.f26865h = dVar;
        }
        if (equals) {
            return;
        }
        if (dVar.M && this.f26862e == null) {
            s.i("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        d();
    }

    @Override // la.q
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public d b() {
        d dVar;
        synchronized (this.f26861d) {
            dVar = this.f26865h;
        }
        return dVar;
    }

    protected h.a[] V(i.a aVar, int[][][] iArr, int[] iArr2, d dVar) {
        String str;
        int d11 = aVar.d();
        h.a[] aVarArr = new h.a[d11];
        Pair a02 = a0(aVar, iArr, iArr2, dVar);
        if (a02 != null) {
            aVarArr[((Integer) a02.second).intValue()] = (h.a) a02.first;
        }
        Pair W = W(aVar, iArr, iArr2, dVar);
        if (W != null) {
            aVarArr[((Integer) W.second).intValue()] = (h.a) W.first;
        }
        if (W == null) {
            str = null;
        } else {
            Object obj = W.first;
            str = ((h.a) obj).f26925a.c(((h.a) obj).f26926b[0]).f25541c;
        }
        Pair Y = Y(aVar, iArr, dVar, str);
        if (Y != null) {
            aVarArr[((Integer) Y.second).intValue()] = (h.a) Y.first;
        }
        for (int i11 = 0; i11 < d11; i11++) {
            int e11 = aVar.e(i11);
            if (e11 != 2 && e11 != 1 && e11 != 3) {
                aVarArr[i11] = X(e11, aVar.f(i11), iArr[i11], dVar);
            }
        }
        return aVarArr;
    }

    protected Pair W(i.a aVar, int[][][] iArr, int[] iArr2, final d dVar) {
        final boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 < aVar.d()) {
                if (2 == aVar.e(i11) && aVar.f(i11).f76288a > 0) {
                    z10 = true;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        return Z(1, aVar, iArr, new h.a() { // from class: la.f
            @Override // com.google.android.exoplayer2.trackselection.e.h.a
            public final List a(int i12, TrackGroup trackGroup, int[] iArr3) {
                List M;
                M = com.google.android.exoplayer2.trackselection.e.this.M(dVar, z10, i12, trackGroup, iArr3);
                return M;
            }
        }, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.b.d((List) obj, (List) obj2);
            }
        });
    }

    protected h.a X(int i11, x xVar, int[][] iArr, d dVar) {
        TrackGroup trackGroup = null;
        c cVar = null;
        int i12 = 0;
        for (int i13 = 0; i13 < xVar.f76288a; i13++) {
            TrackGroup b11 = xVar.b(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < b11.f25727a; i14++) {
                if (L(iArr2[i14], dVar.N)) {
                    c cVar2 = new c(b11.c(i14), iArr2[i14]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        trackGroup = b11;
                        i12 = i14;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new h.a(trackGroup, i12);
    }

    protected Pair Y(i.a aVar, int[][][] iArr, final d dVar, final String str) {
        return Z(3, aVar, iArr, new h.a() { // from class: la.g
            @Override // com.google.android.exoplayer2.trackselection.e.h.a
            public final List a(int i11, TrackGroup trackGroup, int[] iArr2) {
                List N;
                N = com.google.android.exoplayer2.trackselection.e.N(e.d.this, str, i11, trackGroup, iArr2);
                return N;
            }
        }, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.g.d((List) obj, (List) obj2);
            }
        });
    }

    protected Pair a0(i.a aVar, int[][][] iArr, final int[] iArr2, final d dVar) {
        return Z(2, aVar, iArr, new h.a() { // from class: la.e
            @Override // com.google.android.exoplayer2.trackselection.e.h.a
            public final List a(int i11, TrackGroup trackGroup, int[] iArr3) {
                List O;
                O = com.google.android.exoplayer2.trackselection.e.O(e.d.this, iArr2, i11, trackGroup, iArr3);
                return O;
            }
        }, new Comparator() { // from class: com.google.android.exoplayer2.trackselection.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.i.h((List) obj, (List) obj2);
            }
        });
    }

    @Override // la.q
    public boolean e() {
        return true;
    }

    @Override // la.q
    public void g() {
        f fVar;
        synchronized (this.f26861d) {
            try {
                if (p0.f27680a >= 32 && (fVar = this.f26866i) != null) {
                    fVar.f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        super.g();
    }

    @Override // la.q
    public void i(com.google.android.exoplayer2.audio.e eVar) {
        boolean equals;
        synchronized (this.f26861d) {
            equals = this.f26867j.equals(eVar);
            this.f26867j = eVar;
        }
        if (equals) {
            return;
        }
        S();
    }

    @Override // la.q
    public void j(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof d) {
            b0((d) trackSelectionParameters);
        }
        b0(new d.a().c0(trackSelectionParameters).A());
    }

    @Override // com.google.android.exoplayer2.trackselection.i
    protected final Pair n(i.a aVar, int[][][] iArr, int[] iArr2, o.b bVar, k3 k3Var) {
        d dVar;
        f fVar;
        synchronized (this.f26861d) {
            try {
                dVar = this.f26865h;
                if (dVar.M && p0.f27680a >= 32 && (fVar = this.f26866i) != null) {
                    fVar.b(this, (Looper) com.google.android.exoplayer2.util.a.i(Looper.myLooper()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int d11 = aVar.d();
        h.a[] V = V(aVar, iArr, iArr2, dVar);
        B(aVar, dVar, V);
        A(aVar, dVar, V);
        for (int i11 = 0; i11 < d11; i11++) {
            int e11 = aVar.e(i11);
            if (dVar.m(i11) || dVar.f26807z.contains(Integer.valueOf(e11))) {
                V[i11] = null;
            }
        }
        com.google.android.exoplayer2.trackselection.h[] a11 = this.f26863f.a(V, a(), bVar, k3Var);
        a3[] a3VarArr = new a3[d11];
        for (int i12 = 0; i12 < d11; i12++) {
            a3VarArr[i12] = (dVar.m(i12) || dVar.f26807z.contains(Integer.valueOf(aVar.e(i12))) || (aVar.e(i12) != -2 && a11[i12] == null)) ? null : a3.f24581b;
        }
        if (dVar.O) {
            R(aVar, iArr, a3VarArr, a11);
        }
        return Pair.create(a3VarArr, a11);
    }
}
