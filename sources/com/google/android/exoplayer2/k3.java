package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import u9.c;

/* loaded from: classes3.dex */
public abstract class k3 implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final k3 f25205a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final k.a f25206b = new k.a() { // from class: com.google.android.exoplayer2.j3
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            k3 b11;
            b11 = k3.b(bundle);
            return b11;
        }
    };

    /* loaded from: classes3.dex */
    class a extends k3 {
        a() {
        }

        @Override // com.google.android.exoplayer2.k3
        public int f(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.k3
        public b k(int i11, b bVar, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.k3
        public int m() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.k3
        public Object q(int i11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.k3
        public d s(int i11, d dVar, long j11) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.k3
        public int t() {
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements k {

        /* renamed from: h, reason: collision with root package name */
        public static final k.a f25207h = new k.a() { // from class: com.google.android.exoplayer2.l3
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                k3.b c11;
                c11 = k3.b.c(bundle);
                return c11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public Object f25208a;

        /* renamed from: b, reason: collision with root package name */
        public Object f25209b;

        /* renamed from: c, reason: collision with root package name */
        public int f25210c;

        /* renamed from: d, reason: collision with root package name */
        public long f25211d;

        /* renamed from: e, reason: collision with root package name */
        public long f25212e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f25213f;

        /* renamed from: g, reason: collision with root package name */
        private u9.c f25214g = u9.c.f76812g;

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Bundle bundle) {
            int i11 = bundle.getInt(u(0), 0);
            long j11 = bundle.getLong(u(1), C.TIME_UNSET);
            long j12 = bundle.getLong(u(2), 0L);
            boolean z10 = bundle.getBoolean(u(3));
            Bundle bundle2 = bundle.getBundle(u(4));
            u9.c cVar = bundle2 != null ? (u9.c) u9.c.f76814i.a(bundle2) : u9.c.f76812g;
            b bVar = new b();
            bVar.w(null, null, i11, j11, j12, cVar, z10);
            return bVar;
        }

        private static String u(int i11) {
            return Integer.toString(i11, 36);
        }

        public int d(int i11) {
            return this.f25214g.c(i11).f76823b;
        }

        public long e(int i11, int i12) {
            c.a c11 = this.f25214g.c(i11);
            return c11.f76823b != -1 ? c11.f76826e[i12] : C.TIME_UNSET;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return com.google.android.exoplayer2.util.p0.c(this.f25208a, bVar.f25208a) && com.google.android.exoplayer2.util.p0.c(this.f25209b, bVar.f25209b) && this.f25210c == bVar.f25210c && this.f25211d == bVar.f25211d && this.f25212e == bVar.f25212e && this.f25213f == bVar.f25213f && com.google.android.exoplayer2.util.p0.c(this.f25214g, bVar.f25214g);
        }

        public int f() {
            return this.f25214g.f76816b;
        }

        public int g(long j11) {
            return this.f25214g.d(j11, this.f25211d);
        }

        public int h(long j11) {
            return this.f25214g.e(j11, this.f25211d);
        }

        public int hashCode() {
            Object obj = this.f25208a;
            int hashCode = (Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f25209b;
            int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f25210c) * 31;
            long j11 = this.f25211d;
            int i11 = (hashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f25212e;
            return ((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f25213f ? 1 : 0)) * 31) + this.f25214g.hashCode();
        }

        public long i(int i11) {
            return this.f25214g.c(i11).f76822a;
        }

        public long j() {
            return this.f25214g.f76817c;
        }

        public int k(int i11, int i12) {
            c.a c11 = this.f25214g.c(i11);
            if (c11.f76823b != -1) {
                return c11.f76825d[i12];
            }
            return 0;
        }

        public long l(int i11) {
            return this.f25214g.c(i11).f76827f;
        }

        public long m() {
            return this.f25211d;
        }

        public int n(int i11) {
            return this.f25214g.c(i11).e();
        }

        public int o(int i11, int i12) {
            return this.f25214g.c(i11).f(i12);
        }

        public long p() {
            return com.google.android.exoplayer2.util.p0.e1(this.f25212e);
        }

        public long q() {
            return this.f25212e;
        }

        public int r() {
            return this.f25214g.f76819e;
        }

        public boolean s(int i11) {
            return !this.f25214g.c(i11).g();
        }

        public boolean t(int i11) {
            return this.f25214g.c(i11).f76828g;
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(u(0), this.f25210c);
            bundle.putLong(u(1), this.f25211d);
            bundle.putLong(u(2), this.f25212e);
            bundle.putBoolean(u(3), this.f25213f);
            bundle.putBundle(u(4), this.f25214g.toBundle());
            return bundle;
        }

        public b v(Object obj, Object obj2, int i11, long j11, long j12) {
            return w(obj, obj2, i11, j11, j12, u9.c.f76812g, false);
        }

        public b w(Object obj, Object obj2, int i11, long j11, long j12, u9.c cVar, boolean z10) {
            this.f25208a = obj;
            this.f25209b = obj2;
            this.f25210c = i11;
            this.f25211d = j11;
            this.f25212e = j12;
            this.f25214g = cVar;
            this.f25213f = z10;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends k3 {

        /* renamed from: c, reason: collision with root package name */
        private final ImmutableList f25215c;

        /* renamed from: d, reason: collision with root package name */
        private final ImmutableList f25216d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f25217e;

        /* renamed from: f, reason: collision with root package name */
        private final int[] f25218f;

        public c(ImmutableList immutableList, ImmutableList immutableList2, int[] iArr) {
            com.google.android.exoplayer2.util.a.a(immutableList.size() == iArr.length);
            this.f25215c = immutableList;
            this.f25216d = immutableList2;
            this.f25217e = iArr;
            this.f25218f = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.f25218f[iArr[i11]] = i11;
            }
        }

        @Override // com.google.android.exoplayer2.k3
        public int e(boolean z10) {
            if (u()) {
                return -1;
            }
            if (z10) {
                return this.f25217e[0];
            }
            return 0;
        }

        @Override // com.google.android.exoplayer2.k3
        public int f(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.k3
        public int g(boolean z10) {
            if (u()) {
                return -1;
            }
            return z10 ? this.f25217e[t() - 1] : t() - 1;
        }

        @Override // com.google.android.exoplayer2.k3
        public int i(int i11, int i12, boolean z10) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != g(z10)) {
                return z10 ? this.f25217e[this.f25218f[i11] + 1] : i11 + 1;
            }
            if (i12 == 2) {
                return e(z10);
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.k3
        public b k(int i11, b bVar, boolean z10) {
            b bVar2 = (b) this.f25216d.get(i11);
            bVar.w(bVar2.f25208a, bVar2.f25209b, bVar2.f25210c, bVar2.f25211d, bVar2.f25212e, bVar2.f25214g, bVar2.f25213f);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.k3
        public int m() {
            return this.f25216d.size();
        }

        @Override // com.google.android.exoplayer2.k3
        public int p(int i11, int i12, boolean z10) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != e(z10)) {
                return z10 ? this.f25217e[this.f25218f[i11] - 1] : i11 - 1;
            }
            if (i12 == 2) {
                return g(z10);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.k3
        public Object q(int i11) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.k3
        public d s(int i11, d dVar, long j11) {
            d dVar2 = (d) this.f25215c.get(i11);
            dVar.k(dVar2.f25223a, dVar2.f25225c, dVar2.f25226d, dVar2.f25227e, dVar2.f25228f, dVar2.f25229g, dVar2.f25230h, dVar2.f25231i, dVar2.f25233k, dVar2.f25235m, dVar2.f25236n, dVar2.f25237o, dVar2.f25238p, dVar2.f25239q);
            dVar.f25234l = dVar2.f25234l;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.k3
        public int t() {
            return this.f25215c.size();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements k {

        /* renamed from: r, reason: collision with root package name */
        public static final Object f25219r = new Object();

        /* renamed from: s, reason: collision with root package name */
        private static final Object f25220s = new Object();

        /* renamed from: t, reason: collision with root package name */
        private static final v1 f25221t = new v1.c().d("com.google.android.exoplayer2.Timeline").i(Uri.EMPTY).a();

        /* renamed from: u, reason: collision with root package name */
        public static final k.a f25222u = new k.a() { // from class: com.google.android.exoplayer2.m3
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                k3.d c11;
                c11 = k3.d.c(bundle);
                return c11;
            }
        };

        /* renamed from: b, reason: collision with root package name */
        public Object f25224b;

        /* renamed from: d, reason: collision with root package name */
        public Object f25226d;

        /* renamed from: e, reason: collision with root package name */
        public long f25227e;

        /* renamed from: f, reason: collision with root package name */
        public long f25228f;

        /* renamed from: g, reason: collision with root package name */
        public long f25229g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f25230h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f25231i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f25232j;

        /* renamed from: k, reason: collision with root package name */
        public v1.g f25233k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f25234l;

        /* renamed from: m, reason: collision with root package name */
        public long f25235m;

        /* renamed from: n, reason: collision with root package name */
        public long f25236n;

        /* renamed from: o, reason: collision with root package name */
        public int f25237o;

        /* renamed from: p, reason: collision with root package name */
        public int f25238p;

        /* renamed from: q, reason: collision with root package name */
        public long f25239q;

        /* renamed from: a, reason: collision with root package name */
        public Object f25223a = f25219r;

        /* renamed from: c, reason: collision with root package name */
        public v1 f25225c = f25221t;

        /* JADX INFO: Access modifiers changed from: private */
        public static d c(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(j(1));
            v1 v1Var = bundle2 != null ? (v1) v1.f27761j.a(bundle2) : null;
            long j11 = bundle.getLong(j(2), C.TIME_UNSET);
            long j12 = bundle.getLong(j(3), C.TIME_UNSET);
            long j13 = bundle.getLong(j(4), C.TIME_UNSET);
            boolean z10 = bundle.getBoolean(j(5), false);
            boolean z11 = bundle.getBoolean(j(6), false);
            Bundle bundle3 = bundle.getBundle(j(7));
            v1.g gVar = bundle3 != null ? (v1.g) v1.g.f27815g.a(bundle3) : null;
            boolean z12 = bundle.getBoolean(j(8), false);
            long j14 = bundle.getLong(j(9), 0L);
            long j15 = bundle.getLong(j(10), C.TIME_UNSET);
            int i11 = bundle.getInt(j(11), 0);
            int i12 = bundle.getInt(j(12), 0);
            long j16 = bundle.getLong(j(13), 0L);
            d dVar = new d();
            dVar.k(f25220s, v1Var, null, j11, j12, j13, z10, z11, gVar, j14, j15, i11, i12, j16);
            dVar.f25234l = z12;
            return dVar;
        }

        private static String j(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle l(boolean z10) {
            Bundle bundle = new Bundle();
            bundle.putBundle(j(1), (z10 ? v1.f27760i : this.f25225c).toBundle());
            bundle.putLong(j(2), this.f25227e);
            bundle.putLong(j(3), this.f25228f);
            bundle.putLong(j(4), this.f25229g);
            bundle.putBoolean(j(5), this.f25230h);
            bundle.putBoolean(j(6), this.f25231i);
            v1.g gVar = this.f25233k;
            if (gVar != null) {
                bundle.putBundle(j(7), gVar.toBundle());
            }
            bundle.putBoolean(j(8), this.f25234l);
            bundle.putLong(j(9), this.f25235m);
            bundle.putLong(j(10), this.f25236n);
            bundle.putInt(j(11), this.f25237o);
            bundle.putInt(j(12), this.f25238p);
            bundle.putLong(j(13), this.f25239q);
            return bundle;
        }

        public long d() {
            return com.google.android.exoplayer2.util.p0.b0(this.f25229g);
        }

        public long e() {
            return com.google.android.exoplayer2.util.p0.e1(this.f25235m);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return com.google.android.exoplayer2.util.p0.c(this.f25223a, dVar.f25223a) && com.google.android.exoplayer2.util.p0.c(this.f25225c, dVar.f25225c) && com.google.android.exoplayer2.util.p0.c(this.f25226d, dVar.f25226d) && com.google.android.exoplayer2.util.p0.c(this.f25233k, dVar.f25233k) && this.f25227e == dVar.f25227e && this.f25228f == dVar.f25228f && this.f25229g == dVar.f25229g && this.f25230h == dVar.f25230h && this.f25231i == dVar.f25231i && this.f25234l == dVar.f25234l && this.f25235m == dVar.f25235m && this.f25236n == dVar.f25236n && this.f25237o == dVar.f25237o && this.f25238p == dVar.f25238p && this.f25239q == dVar.f25239q;
        }

        public long f() {
            return this.f25235m;
        }

        public long g() {
            return com.google.android.exoplayer2.util.p0.e1(this.f25236n);
        }

        public long h() {
            return this.f25239q;
        }

        public int hashCode() {
            int hashCode = (((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f25223a.hashCode()) * 31) + this.f25225c.hashCode()) * 31;
            Object obj = this.f25226d;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            v1.g gVar = this.f25233k;
            int hashCode3 = (hashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j11 = this.f25227e;
            int i11 = (hashCode3 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f25228f;
            int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f25229g;
            int i13 = (((((((i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.f25230h ? 1 : 0)) * 31) + (this.f25231i ? 1 : 0)) * 31) + (this.f25234l ? 1 : 0)) * 31;
            long j14 = this.f25235m;
            int i14 = (i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
            long j15 = this.f25236n;
            int i15 = (((((i14 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.f25237o) * 31) + this.f25238p) * 31;
            long j16 = this.f25239q;
            return i15 + ((int) (j16 ^ (j16 >>> 32)));
        }

        public boolean i() {
            com.google.android.exoplayer2.util.a.g(this.f25232j == (this.f25233k != null));
            return this.f25233k != null;
        }

        public d k(Object obj, v1 v1Var, Object obj2, long j11, long j12, long j13, boolean z10, boolean z11, v1.g gVar, long j14, long j15, int i11, int i12, long j16) {
            v1.h hVar;
            this.f25223a = obj;
            this.f25225c = v1Var != null ? v1Var : f25221t;
            this.f25224b = (v1Var == null || (hVar = v1Var.f27763b) == null) ? null : hVar.f27833h;
            this.f25226d = obj2;
            this.f25227e = j11;
            this.f25228f = j12;
            this.f25229g = j13;
            this.f25230h = z10;
            this.f25231i = z11;
            this.f25232j = gVar != null;
            this.f25233k = gVar;
            this.f25235m = j14;
            this.f25236n = j15;
            this.f25237o = i11;
            this.f25238p = i12;
            this.f25239q = j16;
            this.f25234l = false;
            return this;
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            return l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static k3 b(Bundle bundle) {
        ImmutableList c11 = c(d.f25222u, com.google.android.exoplayer2.util.c.a(bundle, w(0)));
        ImmutableList c12 = c(b.f25207h, com.google.android.exoplayer2.util.c.a(bundle, w(1)));
        int[] intArray = bundle.getIntArray(w(2));
        if (intArray == null) {
            intArray = d(c11.size());
        }
        return new c(c11, c12, intArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ImmutableList c(k.a aVar, IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar2 = new ImmutableList.a();
        ImmutableList a11 = j.a(iBinder);
        for (int i11 = 0; i11 < a11.size(); i11++) {
            aVar2.a(aVar.a((Bundle) a11.get(i11)));
        }
        return aVar2.e();
    }

    private static int[] d(int i11) {
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = i12;
        }
        return iArr;
    }

    private static String w(int i11) {
        return Integer.toString(i11, 36);
    }

    public int e(boolean z10) {
        return u() ? -1 : 0;
    }

    public boolean equals(Object obj) {
        int g11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k3)) {
            return false;
        }
        k3 k3Var = (k3) obj;
        if (k3Var.t() != t() || k3Var.m() != m()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i11 = 0; i11 < t(); i11++) {
            if (!r(i11, dVar).equals(k3Var.r(i11, dVar2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < m(); i12++) {
            if (!k(i12, bVar, true).equals(k3Var.k(i12, bVar2, true))) {
                return false;
            }
        }
        int e11 = e(true);
        if (e11 != k3Var.e(true) || (g11 = g(true)) != k3Var.g(true)) {
            return false;
        }
        while (e11 != g11) {
            int i13 = i(e11, 0, true);
            if (i13 != k3Var.i(e11, 0, true)) {
                return false;
            }
            e11 = i13;
        }
        return true;
    }

    public abstract int f(Object obj);

    public int g(boolean z10) {
        if (u()) {
            return -1;
        }
        return t() - 1;
    }

    public final int h(int i11, b bVar, d dVar, int i12, boolean z10) {
        int i13 = j(i11, bVar).f25210c;
        if (r(i13, dVar).f25238p != i11) {
            return i11 + 1;
        }
        int i14 = i(i13, i12, z10);
        if (i14 == -1) {
            return -1;
        }
        return r(i14, dVar).f25237o;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int t11 = Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + t();
        for (int i11 = 0; i11 < t(); i11++) {
            t11 = (t11 * 31) + r(i11, dVar).hashCode();
        }
        int m11 = (t11 * 31) + m();
        for (int i12 = 0; i12 < m(); i12++) {
            m11 = (m11 * 31) + k(i12, bVar, true).hashCode();
        }
        int e11 = e(true);
        while (e11 != -1) {
            m11 = (m11 * 31) + e11;
            e11 = i(e11, 0, true);
        }
        return m11;
    }

    public int i(int i11, int i12, boolean z10) {
        if (i12 == 0) {
            if (i11 == g(z10)) {
                return -1;
            }
            return i11 + 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == g(z10) ? e(z10) : i11 + 1;
        }
        throw new IllegalStateException();
    }

    public final b j(int i11, b bVar) {
        return k(i11, bVar, false);
    }

    public abstract b k(int i11, b bVar, boolean z10);

    public b l(Object obj, b bVar) {
        return k(f(obj), bVar, true);
    }

    public abstract int m();

    public final Pair n(d dVar, b bVar, int i11, long j11) {
        return (Pair) com.google.android.exoplayer2.util.a.e(o(dVar, bVar, i11, j11, 0L));
    }

    public final Pair o(d dVar, b bVar, int i11, long j11, long j12) {
        com.google.android.exoplayer2.util.a.c(i11, 0, t());
        s(i11, dVar, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = dVar.f();
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = dVar.f25237o;
        j(i12, bVar);
        while (i12 < dVar.f25238p && bVar.f25212e != j11) {
            int i13 = i12 + 1;
            if (j(i13, bVar).f25212e > j11) {
                break;
            }
            i12 = i13;
        }
        k(i12, bVar, true);
        long j13 = j11 - bVar.f25212e;
        long j14 = bVar.f25211d;
        if (j14 != C.TIME_UNSET) {
            j13 = Math.min(j13, j14 - 1);
        }
        return Pair.create(com.google.android.exoplayer2.util.a.e(bVar.f25209b), Long.valueOf(Math.max(0L, j13)));
    }

    public int p(int i11, int i12, boolean z10) {
        if (i12 == 0) {
            if (i11 == e(z10)) {
                return -1;
            }
            return i11 - 1;
        }
        if (i12 == 1) {
            return i11;
        }
        if (i12 == 2) {
            return i11 == e(z10) ? g(z10) : i11 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object q(int i11);

    public final d r(int i11, d dVar) {
        return s(i11, dVar, 0L);
    }

    public abstract d s(int i11, d dVar, long j11);

    public abstract int t();

    @Override // com.google.android.exoplayer2.k
    public final Bundle toBundle() {
        return x(false);
    }

    public final boolean u() {
        return t() == 0;
    }

    public final boolean v(int i11, b bVar, d dVar, int i12, boolean z10) {
        return h(i11, bVar, dVar, i12, z10) == -1;
    }

    public final Bundle x(boolean z10) {
        ArrayList arrayList = new ArrayList();
        int t11 = t();
        d dVar = new d();
        for (int i11 = 0; i11 < t11; i11++) {
            arrayList.add(s(i11, dVar, 0L).l(z10));
        }
        ArrayList arrayList2 = new ArrayList();
        int m11 = m();
        b bVar = new b();
        for (int i12 = 0; i12 < m11; i12++) {
            arrayList2.add(k(i12, bVar, false).toBundle());
        }
        int[] iArr = new int[t11];
        if (t11 > 0) {
            iArr[0] = e(true);
        }
        for (int i13 = 1; i13 < t11; i13++) {
            iArr[i13] = i(iArr[i13 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        com.google.android.exoplayer2.util.c.c(bundle, w(0), new j(arrayList));
        com.google.android.exoplayer2.util.c.c(bundle, w(1), new j(arrayList2));
        bundle.putIntArray(w(2), iArr);
        return bundle;
    }
}
