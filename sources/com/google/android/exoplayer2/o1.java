package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class o1 implements k {
    private static final o1 G = new b().E();
    public static final k.a H = new k.a() { // from class: com.google.android.exoplayer2.n1
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            o1 e11;
            e11 = o1.e(bundle);
            return e11;
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    private int F;

    /* renamed from: a, reason: collision with root package name */
    public final String f25539a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25540b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25541c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25542d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25543e;

    /* renamed from: f, reason: collision with root package name */
    public final int f25544f;

    /* renamed from: g, reason: collision with root package name */
    public final int f25545g;

    /* renamed from: h, reason: collision with root package name */
    public final int f25546h;

    /* renamed from: i, reason: collision with root package name */
    public final String f25547i;

    /* renamed from: j, reason: collision with root package name */
    public final Metadata f25548j;

    /* renamed from: k, reason: collision with root package name */
    public final String f25549k;

    /* renamed from: l, reason: collision with root package name */
    public final String f25550l;

    /* renamed from: m, reason: collision with root package name */
    public final int f25551m;

    /* renamed from: n, reason: collision with root package name */
    public final List f25552n;

    /* renamed from: o, reason: collision with root package name */
    public final DrmInitData f25553o;

    /* renamed from: p, reason: collision with root package name */
    public final long f25554p;

    /* renamed from: q, reason: collision with root package name */
    public final int f25555q;

    /* renamed from: r, reason: collision with root package name */
    public final int f25556r;

    /* renamed from: s, reason: collision with root package name */
    public final float f25557s;

    /* renamed from: t, reason: collision with root package name */
    public final int f25558t;

    /* renamed from: u, reason: collision with root package name */
    public final float f25559u;

    /* renamed from: v, reason: collision with root package name */
    public final byte[] f25560v;

    /* renamed from: w, reason: collision with root package name */
    public final int f25561w;

    /* renamed from: x, reason: collision with root package name */
    public final com.google.android.exoplayer2.video.c f25562x;

    /* renamed from: y, reason: collision with root package name */
    public final int f25563y;

    /* renamed from: z, reason: collision with root package name */
    public final int f25564z;

    /* loaded from: classes3.dex */
    public static final class b {
        private int A;
        private int B;
        private int C;
        private int D;

        /* renamed from: a, reason: collision with root package name */
        private String f25565a;

        /* renamed from: b, reason: collision with root package name */
        private String f25566b;

        /* renamed from: c, reason: collision with root package name */
        private String f25567c;

        /* renamed from: d, reason: collision with root package name */
        private int f25568d;

        /* renamed from: e, reason: collision with root package name */
        private int f25569e;

        /* renamed from: f, reason: collision with root package name */
        private int f25570f;

        /* renamed from: g, reason: collision with root package name */
        private int f25571g;

        /* renamed from: h, reason: collision with root package name */
        private String f25572h;

        /* renamed from: i, reason: collision with root package name */
        private Metadata f25573i;

        /* renamed from: j, reason: collision with root package name */
        private String f25574j;

        /* renamed from: k, reason: collision with root package name */
        private String f25575k;

        /* renamed from: l, reason: collision with root package name */
        private int f25576l;

        /* renamed from: m, reason: collision with root package name */
        private List f25577m;

        /* renamed from: n, reason: collision with root package name */
        private DrmInitData f25578n;

        /* renamed from: o, reason: collision with root package name */
        private long f25579o;

        /* renamed from: p, reason: collision with root package name */
        private int f25580p;

        /* renamed from: q, reason: collision with root package name */
        private int f25581q;

        /* renamed from: r, reason: collision with root package name */
        private float f25582r;

        /* renamed from: s, reason: collision with root package name */
        private int f25583s;

        /* renamed from: t, reason: collision with root package name */
        private float f25584t;

        /* renamed from: u, reason: collision with root package name */
        private byte[] f25585u;

        /* renamed from: v, reason: collision with root package name */
        private int f25586v;

        /* renamed from: w, reason: collision with root package name */
        private com.google.android.exoplayer2.video.c f25587w;

        /* renamed from: x, reason: collision with root package name */
        private int f25588x;

        /* renamed from: y, reason: collision with root package name */
        private int f25589y;

        /* renamed from: z, reason: collision with root package name */
        private int f25590z;

        public b() {
            this.f25570f = -1;
            this.f25571g = -1;
            this.f25576l = -1;
            this.f25579o = Long.MAX_VALUE;
            this.f25580p = -1;
            this.f25581q = -1;
            this.f25582r = -1.0f;
            this.f25584t = 1.0f;
            this.f25586v = -1;
            this.f25588x = -1;
            this.f25589y = -1;
            this.f25590z = -1;
            this.C = -1;
            this.D = 0;
        }

        private b(o1 o1Var) {
            this.f25565a = o1Var.f25539a;
            this.f25566b = o1Var.f25540b;
            this.f25567c = o1Var.f25541c;
            this.f25568d = o1Var.f25542d;
            this.f25569e = o1Var.f25543e;
            this.f25570f = o1Var.f25544f;
            this.f25571g = o1Var.f25545g;
            this.f25572h = o1Var.f25547i;
            this.f25573i = o1Var.f25548j;
            this.f25574j = o1Var.f25549k;
            this.f25575k = o1Var.f25550l;
            this.f25576l = o1Var.f25551m;
            this.f25577m = o1Var.f25552n;
            this.f25578n = o1Var.f25553o;
            this.f25579o = o1Var.f25554p;
            this.f25580p = o1Var.f25555q;
            this.f25581q = o1Var.f25556r;
            this.f25582r = o1Var.f25557s;
            this.f25583s = o1Var.f25558t;
            this.f25584t = o1Var.f25559u;
            this.f25585u = o1Var.f25560v;
            this.f25586v = o1Var.f25561w;
            this.f25587w = o1Var.f25562x;
            this.f25588x = o1Var.f25563y;
            this.f25589y = o1Var.f25564z;
            this.f25590z = o1Var.A;
            this.A = o1Var.B;
            this.B = o1Var.C;
            this.C = o1Var.D;
            this.D = o1Var.E;
        }

        public o1 E() {
            return new o1(this);
        }

        public b F(int i11) {
            this.C = i11;
            return this;
        }

        public b G(int i11) {
            this.f25570f = i11;
            return this;
        }

        public b H(int i11) {
            this.f25588x = i11;
            return this;
        }

        public b I(String str) {
            this.f25572h = str;
            return this;
        }

        public b J(com.google.android.exoplayer2.video.c cVar) {
            this.f25587w = cVar;
            return this;
        }

        public b K(String str) {
            this.f25574j = str;
            return this;
        }

        public b L(int i11) {
            this.D = i11;
            return this;
        }

        public b M(DrmInitData drmInitData) {
            this.f25578n = drmInitData;
            return this;
        }

        public b N(int i11) {
            this.A = i11;
            return this;
        }

        public b O(int i11) {
            this.B = i11;
            return this;
        }

        public b P(float f11) {
            this.f25582r = f11;
            return this;
        }

        public b Q(int i11) {
            this.f25581q = i11;
            return this;
        }

        public b R(int i11) {
            this.f25565a = Integer.toString(i11);
            return this;
        }

        public b S(String str) {
            this.f25565a = str;
            return this;
        }

        public b T(List list) {
            this.f25577m = list;
            return this;
        }

        public b U(String str) {
            this.f25566b = str;
            return this;
        }

        public b V(String str) {
            this.f25567c = str;
            return this;
        }

        public b W(int i11) {
            this.f25576l = i11;
            return this;
        }

        public b X(Metadata metadata) {
            this.f25573i = metadata;
            return this;
        }

        public b Y(int i11) {
            this.f25590z = i11;
            return this;
        }

        public b Z(int i11) {
            this.f25571g = i11;
            return this;
        }

        public b a0(float f11) {
            this.f25584t = f11;
            return this;
        }

        public b b0(byte[] bArr) {
            this.f25585u = bArr;
            return this;
        }

        public b c0(int i11) {
            this.f25569e = i11;
            return this;
        }

        public b d0(int i11) {
            this.f25583s = i11;
            return this;
        }

        public b e0(String str) {
            this.f25575k = str;
            return this;
        }

        public b f0(int i11) {
            this.f25589y = i11;
            return this;
        }

        public b g0(int i11) {
            this.f25568d = i11;
            return this;
        }

        public b h0(int i11) {
            this.f25586v = i11;
            return this;
        }

        public b i0(long j11) {
            this.f25579o = j11;
            return this;
        }

        public b j0(int i11) {
            this.f25580p = i11;
            return this;
        }
    }

    private o1(b bVar) {
        this.f25539a = bVar.f25565a;
        this.f25540b = bVar.f25566b;
        this.f25541c = com.google.android.exoplayer2.util.p0.D0(bVar.f25567c);
        this.f25542d = bVar.f25568d;
        this.f25543e = bVar.f25569e;
        int i11 = bVar.f25570f;
        this.f25544f = i11;
        int i12 = bVar.f25571g;
        this.f25545g = i12;
        this.f25546h = i12 != -1 ? i12 : i11;
        this.f25547i = bVar.f25572h;
        this.f25548j = bVar.f25573i;
        this.f25549k = bVar.f25574j;
        this.f25550l = bVar.f25575k;
        this.f25551m = bVar.f25576l;
        this.f25552n = bVar.f25577m == null ? Collections.emptyList() : bVar.f25577m;
        DrmInitData drmInitData = bVar.f25578n;
        this.f25553o = drmInitData;
        this.f25554p = bVar.f25579o;
        this.f25555q = bVar.f25580p;
        this.f25556r = bVar.f25581q;
        this.f25557s = bVar.f25582r;
        this.f25558t = bVar.f25583s == -1 ? 0 : bVar.f25583s;
        this.f25559u = bVar.f25584t == -1.0f ? 1.0f : bVar.f25584t;
        this.f25560v = bVar.f25585u;
        this.f25561w = bVar.f25586v;
        this.f25562x = bVar.f25587w;
        this.f25563y = bVar.f25588x;
        this.f25564z = bVar.f25589y;
        this.A = bVar.f25590z;
        this.B = bVar.A == -1 ? 0 : bVar.A;
        this.C = bVar.B != -1 ? bVar.B : 0;
        this.D = bVar.C;
        if (bVar.D != 0 || drmInitData == null) {
            this.E = bVar.D;
        } else {
            this.E = 1;
        }
    }

    private static Object d(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o1 e(Bundle bundle) {
        b bVar = new b();
        com.google.android.exoplayer2.util.d.a(bundle);
        int i11 = 0;
        String string = bundle.getString(h(0));
        o1 o1Var = G;
        bVar.S((String) d(string, o1Var.f25539a)).U((String) d(bundle.getString(h(1)), o1Var.f25540b)).V((String) d(bundle.getString(h(2)), o1Var.f25541c)).g0(bundle.getInt(h(3), o1Var.f25542d)).c0(bundle.getInt(h(4), o1Var.f25543e)).G(bundle.getInt(h(5), o1Var.f25544f)).Z(bundle.getInt(h(6), o1Var.f25545g)).I((String) d(bundle.getString(h(7)), o1Var.f25547i)).X((Metadata) d((Metadata) bundle.getParcelable(h(8)), o1Var.f25548j)).K((String) d(bundle.getString(h(9)), o1Var.f25549k)).e0((String) d(bundle.getString(h(10)), o1Var.f25550l)).W(bundle.getInt(h(11), o1Var.f25551m));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(i(i11));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i11++;
        }
        b M = bVar.T(arrayList).M((DrmInitData) bundle.getParcelable(h(13)));
        String h11 = h(14);
        o1 o1Var2 = G;
        M.i0(bundle.getLong(h11, o1Var2.f25554p)).j0(bundle.getInt(h(15), o1Var2.f25555q)).Q(bundle.getInt(h(16), o1Var2.f25556r)).P(bundle.getFloat(h(17), o1Var2.f25557s)).d0(bundle.getInt(h(18), o1Var2.f25558t)).a0(bundle.getFloat(h(19), o1Var2.f25559u)).b0(bundle.getByteArray(h(20))).h0(bundle.getInt(h(21), o1Var2.f25561w));
        Bundle bundle2 = bundle.getBundle(h(22));
        if (bundle2 != null) {
            bVar.J((com.google.android.exoplayer2.video.c) com.google.android.exoplayer2.video.c.f27879f.a(bundle2));
        }
        bVar.H(bundle.getInt(h(23), o1Var2.f25563y)).f0(bundle.getInt(h(24), o1Var2.f25564z)).Y(bundle.getInt(h(25), o1Var2.A)).N(bundle.getInt(h(26), o1Var2.B)).O(bundle.getInt(h(27), o1Var2.C)).F(bundle.getInt(h(28), o1Var2.D)).L(bundle.getInt(h(29), o1Var2.E));
        return bVar.E();
    }

    private static String h(int i11) {
        return Integer.toString(i11, 36);
    }

    private static String i(int i11) {
        return h(12) + "_" + Integer.toString(i11, 36);
    }

    public b b() {
        return new b();
    }

    public o1 c(int i11) {
        return b().L(i11).E();
    }

    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || o1.class != obj.getClass()) {
            return false;
        }
        o1 o1Var = (o1) obj;
        int i12 = this.F;
        if (i12 == 0 || (i11 = o1Var.F) == 0 || i12 == i11) {
            return this.f25542d == o1Var.f25542d && this.f25543e == o1Var.f25543e && this.f25544f == o1Var.f25544f && this.f25545g == o1Var.f25545g && this.f25551m == o1Var.f25551m && this.f25554p == o1Var.f25554p && this.f25555q == o1Var.f25555q && this.f25556r == o1Var.f25556r && this.f25558t == o1Var.f25558t && this.f25561w == o1Var.f25561w && this.f25563y == o1Var.f25563y && this.f25564z == o1Var.f25564z && this.A == o1Var.A && this.B == o1Var.B && this.C == o1Var.C && this.D == o1Var.D && this.E == o1Var.E && Float.compare(this.f25557s, o1Var.f25557s) == 0 && Float.compare(this.f25559u, o1Var.f25559u) == 0 && com.google.android.exoplayer2.util.p0.c(this.f25539a, o1Var.f25539a) && com.google.android.exoplayer2.util.p0.c(this.f25540b, o1Var.f25540b) && com.google.android.exoplayer2.util.p0.c(this.f25547i, o1Var.f25547i) && com.google.android.exoplayer2.util.p0.c(this.f25549k, o1Var.f25549k) && com.google.android.exoplayer2.util.p0.c(this.f25550l, o1Var.f25550l) && com.google.android.exoplayer2.util.p0.c(this.f25541c, o1Var.f25541c) && Arrays.equals(this.f25560v, o1Var.f25560v) && com.google.android.exoplayer2.util.p0.c(this.f25548j, o1Var.f25548j) && com.google.android.exoplayer2.util.p0.c(this.f25562x, o1Var.f25562x) && com.google.android.exoplayer2.util.p0.c(this.f25553o, o1Var.f25553o) && g(o1Var);
        }
        return false;
    }

    public int f() {
        int i11;
        int i12 = this.f25555q;
        if (i12 == -1 || (i11 = this.f25556r) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public boolean g(o1 o1Var) {
        if (this.f25552n.size() != o1Var.f25552n.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f25552n.size(); i11++) {
            if (!Arrays.equals((byte[]) this.f25552n.get(i11), (byte[]) o1Var.f25552n.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.F == 0) {
            String str = this.f25539a;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f25540b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f25541c;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f25542d) * 31) + this.f25543e) * 31) + this.f25544f) * 31) + this.f25545g) * 31;
            String str4 = this.f25547i;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f25548j;
            int hashCode5 = (hashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f25549k;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f25550l;
            this.F = ((((((((((((((((((((((((((((((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f25551m) * 31) + ((int) this.f25554p)) * 31) + this.f25555q) * 31) + this.f25556r) * 31) + Float.floatToIntBits(this.f25557s)) * 31) + this.f25558t) * 31) + Float.floatToIntBits(this.f25559u)) * 31) + this.f25561w) * 31) + this.f25563y) * 31) + this.f25564z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E;
        }
        return this.F;
    }

    public o1 j(o1 o1Var) {
        String str;
        if (this == o1Var) {
            return this;
        }
        int l11 = com.google.android.exoplayer2.util.w.l(this.f25550l);
        String str2 = o1Var.f25539a;
        String str3 = o1Var.f25540b;
        if (str3 == null) {
            str3 = this.f25540b;
        }
        String str4 = this.f25541c;
        if ((l11 == 3 || l11 == 1) && (str = o1Var.f25541c) != null) {
            str4 = str;
        }
        int i11 = this.f25544f;
        if (i11 == -1) {
            i11 = o1Var.f25544f;
        }
        int i12 = this.f25545g;
        if (i12 == -1) {
            i12 = o1Var.f25545g;
        }
        String str5 = this.f25547i;
        if (str5 == null) {
            String L = com.google.android.exoplayer2.util.p0.L(o1Var.f25547i, l11);
            if (com.google.android.exoplayer2.util.p0.U0(L).length == 1) {
                str5 = L;
            }
        }
        Metadata metadata = this.f25548j;
        Metadata copyWithAppendedEntriesFrom = metadata == null ? o1Var.f25548j : metadata.copyWithAppendedEntriesFrom(o1Var.f25548j);
        float f11 = this.f25557s;
        if (f11 == -1.0f && l11 == 2) {
            f11 = o1Var.f25557s;
        }
        return b().S(str2).U(str3).V(str4).g0(this.f25542d | o1Var.f25542d).c0(this.f25543e | o1Var.f25543e).G(i11).Z(i12).I(str5).X(copyWithAppendedEntriesFrom).M(DrmInitData.createSessionCreationData(o1Var.f25553o, this.f25553o)).P(f11).E();
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(h(0), this.f25539a);
        bundle.putString(h(1), this.f25540b);
        bundle.putString(h(2), this.f25541c);
        bundle.putInt(h(3), this.f25542d);
        bundle.putInt(h(4), this.f25543e);
        bundle.putInt(h(5), this.f25544f);
        bundle.putInt(h(6), this.f25545g);
        bundle.putString(h(7), this.f25547i);
        bundle.putParcelable(h(8), this.f25548j);
        bundle.putString(h(9), this.f25549k);
        bundle.putString(h(10), this.f25550l);
        bundle.putInt(h(11), this.f25551m);
        for (int i11 = 0; i11 < this.f25552n.size(); i11++) {
            bundle.putByteArray(i(i11), (byte[]) this.f25552n.get(i11));
        }
        bundle.putParcelable(h(13), this.f25553o);
        bundle.putLong(h(14), this.f25554p);
        bundle.putInt(h(15), this.f25555q);
        bundle.putInt(h(16), this.f25556r);
        bundle.putFloat(h(17), this.f25557s);
        bundle.putInt(h(18), this.f25558t);
        bundle.putFloat(h(19), this.f25559u);
        bundle.putByteArray(h(20), this.f25560v);
        bundle.putInt(h(21), this.f25561w);
        if (this.f25562x != null) {
            bundle.putBundle(h(22), this.f25562x.toBundle());
        }
        bundle.putInt(h(23), this.f25563y);
        bundle.putInt(h(24), this.f25564z);
        bundle.putInt(h(25), this.A);
        bundle.putInt(h(26), this.B);
        bundle.putInt(h(27), this.C);
        bundle.putInt(h(28), this.D);
        bundle.putInt(h(29), this.E);
        return bundle;
    }

    public String toString() {
        return "Format(" + this.f25539a + ", " + this.f25540b + ", " + this.f25549k + ", " + this.f25550l + ", " + this.f25547i + ", " + this.f25546h + ", " + this.f25541c + ", [" + this.f25555q + ", " + this.f25556r + ", " + this.f25557s + "], [" + this.f25563y + ", " + this.f25564z + "])";
    }
}
