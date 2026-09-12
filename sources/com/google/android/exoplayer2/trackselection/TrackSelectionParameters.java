package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import la.o;

/* loaded from: classes3.dex */
public class TrackSelectionParameters implements k {
    public static final TrackSelectionParameters A;
    public static final TrackSelectionParameters B;
    public static final k.a C;

    /* renamed from: a, reason: collision with root package name */
    public final int f26782a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26783b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26784c;

    /* renamed from: d, reason: collision with root package name */
    public final int f26785d;

    /* renamed from: e, reason: collision with root package name */
    public final int f26786e;

    /* renamed from: f, reason: collision with root package name */
    public final int f26787f;

    /* renamed from: g, reason: collision with root package name */
    public final int f26788g;

    /* renamed from: h, reason: collision with root package name */
    public final int f26789h;

    /* renamed from: i, reason: collision with root package name */
    public final int f26790i;

    /* renamed from: j, reason: collision with root package name */
    public final int f26791j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f26792k;

    /* renamed from: l, reason: collision with root package name */
    public final ImmutableList f26793l;

    /* renamed from: m, reason: collision with root package name */
    public final int f26794m;

    /* renamed from: n, reason: collision with root package name */
    public final ImmutableList f26795n;

    /* renamed from: o, reason: collision with root package name */
    public final int f26796o;

    /* renamed from: p, reason: collision with root package name */
    public final int f26797p;

    /* renamed from: q, reason: collision with root package name */
    public final int f26798q;

    /* renamed from: r, reason: collision with root package name */
    public final ImmutableList f26799r;

    /* renamed from: s, reason: collision with root package name */
    public final ImmutableList f26800s;

    /* renamed from: t, reason: collision with root package name */
    public final int f26801t;

    /* renamed from: u, reason: collision with root package name */
    public final int f26802u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f26803v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f26804w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f26805x;

    /* renamed from: y, reason: collision with root package name */
    public final ImmutableMap f26806y;

    /* renamed from: z, reason: collision with root package name */
    public final ImmutableSet f26807z;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f26808a;

        /* renamed from: b, reason: collision with root package name */
        private int f26809b;

        /* renamed from: c, reason: collision with root package name */
        private int f26810c;

        /* renamed from: d, reason: collision with root package name */
        private int f26811d;

        /* renamed from: e, reason: collision with root package name */
        private int f26812e;

        /* renamed from: f, reason: collision with root package name */
        private int f26813f;

        /* renamed from: g, reason: collision with root package name */
        private int f26814g;

        /* renamed from: h, reason: collision with root package name */
        private int f26815h;

        /* renamed from: i, reason: collision with root package name */
        private int f26816i;

        /* renamed from: j, reason: collision with root package name */
        private int f26817j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f26818k;

        /* renamed from: l, reason: collision with root package name */
        private ImmutableList f26819l;

        /* renamed from: m, reason: collision with root package name */
        private int f26820m;

        /* renamed from: n, reason: collision with root package name */
        private ImmutableList f26821n;

        /* renamed from: o, reason: collision with root package name */
        private int f26822o;

        /* renamed from: p, reason: collision with root package name */
        private int f26823p;

        /* renamed from: q, reason: collision with root package name */
        private int f26824q;

        /* renamed from: r, reason: collision with root package name */
        private ImmutableList f26825r;

        /* renamed from: s, reason: collision with root package name */
        private ImmutableList f26826s;

        /* renamed from: t, reason: collision with root package name */
        private int f26827t;

        /* renamed from: u, reason: collision with root package name */
        private int f26828u;

        /* renamed from: v, reason: collision with root package name */
        private boolean f26829v;

        /* renamed from: w, reason: collision with root package name */
        private boolean f26830w;

        /* renamed from: x, reason: collision with root package name */
        private boolean f26831x;

        /* renamed from: y, reason: collision with root package name */
        private HashMap f26832y;

        /* renamed from: z, reason: collision with root package name */
        private HashSet f26833z;

        @Deprecated
        public Builder() {
            this.f26808a = Integer.MAX_VALUE;
            this.f26809b = Integer.MAX_VALUE;
            this.f26810c = Integer.MAX_VALUE;
            this.f26811d = Integer.MAX_VALUE;
            this.f26816i = Integer.MAX_VALUE;
            this.f26817j = Integer.MAX_VALUE;
            this.f26818k = true;
            this.f26819l = ImmutableList.of();
            this.f26820m = 0;
            this.f26821n = ImmutableList.of();
            this.f26822o = 0;
            this.f26823p = Integer.MAX_VALUE;
            this.f26824q = Integer.MAX_VALUE;
            this.f26825r = ImmutableList.of();
            this.f26826s = ImmutableList.of();
            this.f26827t = 0;
            this.f26828u = 0;
            this.f26829v = false;
            this.f26830w = false;
            this.f26831x = false;
            this.f26832y = new HashMap();
            this.f26833z = new HashSet();
        }

        public Builder(Context context) {
            this();
            F(context);
            I(context, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        public Builder(Bundle bundle) {
            String c11 = TrackSelectionParameters.c(6);
            TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.A;
            this.f26808a = bundle.getInt(c11, trackSelectionParameters.f26782a);
            this.f26809b = bundle.getInt(TrackSelectionParameters.c(7), trackSelectionParameters.f26783b);
            this.f26810c = bundle.getInt(TrackSelectionParameters.c(8), trackSelectionParameters.f26784c);
            this.f26811d = bundle.getInt(TrackSelectionParameters.c(9), trackSelectionParameters.f26785d);
            this.f26812e = bundle.getInt(TrackSelectionParameters.c(10), trackSelectionParameters.f26786e);
            this.f26813f = bundle.getInt(TrackSelectionParameters.c(11), trackSelectionParameters.f26787f);
            this.f26814g = bundle.getInt(TrackSelectionParameters.c(12), trackSelectionParameters.f26788g);
            this.f26815h = bundle.getInt(TrackSelectionParameters.c(13), trackSelectionParameters.f26789h);
            this.f26816i = bundle.getInt(TrackSelectionParameters.c(14), trackSelectionParameters.f26790i);
            this.f26817j = bundle.getInt(TrackSelectionParameters.c(15), trackSelectionParameters.f26791j);
            this.f26818k = bundle.getBoolean(TrackSelectionParameters.c(16), trackSelectionParameters.f26792k);
            this.f26819l = ImmutableList.copyOf((String[]) com.google.common.base.h.a(bundle.getStringArray(TrackSelectionParameters.c(17)), new String[0]));
            this.f26820m = bundle.getInt(TrackSelectionParameters.c(25), trackSelectionParameters.f26794m);
            this.f26821n = C((String[]) com.google.common.base.h.a(bundle.getStringArray(TrackSelectionParameters.c(1)), new String[0]));
            this.f26822o = bundle.getInt(TrackSelectionParameters.c(2), trackSelectionParameters.f26796o);
            this.f26823p = bundle.getInt(TrackSelectionParameters.c(18), trackSelectionParameters.f26797p);
            this.f26824q = bundle.getInt(TrackSelectionParameters.c(19), trackSelectionParameters.f26798q);
            this.f26825r = ImmutableList.copyOf((String[]) com.google.common.base.h.a(bundle.getStringArray(TrackSelectionParameters.c(20)), new String[0]));
            this.f26826s = C((String[]) com.google.common.base.h.a(bundle.getStringArray(TrackSelectionParameters.c(3)), new String[0]));
            this.f26827t = bundle.getInt(TrackSelectionParameters.c(4), trackSelectionParameters.f26801t);
            this.f26828u = bundle.getInt(TrackSelectionParameters.c(26), trackSelectionParameters.f26802u);
            this.f26829v = bundle.getBoolean(TrackSelectionParameters.c(5), trackSelectionParameters.f26803v);
            this.f26830w = bundle.getBoolean(TrackSelectionParameters.c(21), trackSelectionParameters.f26804w);
            this.f26831x = bundle.getBoolean(TrackSelectionParameters.c(22), trackSelectionParameters.f26805x);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.c(23));
            ImmutableList of2 = parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(o.f68918c, parcelableArrayList);
            this.f26832y = new HashMap();
            for (int i11 = 0; i11 < of2.size(); i11++) {
                o oVar = (o) of2.get(i11);
                this.f26832y.put(oVar.f68919a, oVar);
            }
            int[] iArr = (int[]) com.google.common.base.h.a(bundle.getIntArray(TrackSelectionParameters.c(24)), new int[0]);
            this.f26833z = new HashSet();
            for (int i12 : iArr) {
                this.f26833z.add(Integer.valueOf(i12));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(TrackSelectionParameters trackSelectionParameters) {
            B(trackSelectionParameters);
        }

        private void B(TrackSelectionParameters trackSelectionParameters) {
            this.f26808a = trackSelectionParameters.f26782a;
            this.f26809b = trackSelectionParameters.f26783b;
            this.f26810c = trackSelectionParameters.f26784c;
            this.f26811d = trackSelectionParameters.f26785d;
            this.f26812e = trackSelectionParameters.f26786e;
            this.f26813f = trackSelectionParameters.f26787f;
            this.f26814g = trackSelectionParameters.f26788g;
            this.f26815h = trackSelectionParameters.f26789h;
            this.f26816i = trackSelectionParameters.f26790i;
            this.f26817j = trackSelectionParameters.f26791j;
            this.f26818k = trackSelectionParameters.f26792k;
            this.f26819l = trackSelectionParameters.f26793l;
            this.f26820m = trackSelectionParameters.f26794m;
            this.f26821n = trackSelectionParameters.f26795n;
            this.f26822o = trackSelectionParameters.f26796o;
            this.f26823p = trackSelectionParameters.f26797p;
            this.f26824q = trackSelectionParameters.f26798q;
            this.f26825r = trackSelectionParameters.f26799r;
            this.f26826s = trackSelectionParameters.f26800s;
            this.f26827t = trackSelectionParameters.f26801t;
            this.f26828u = trackSelectionParameters.f26802u;
            this.f26829v = trackSelectionParameters.f26803v;
            this.f26830w = trackSelectionParameters.f26804w;
            this.f26831x = trackSelectionParameters.f26805x;
            this.f26833z = new HashSet(trackSelectionParameters.f26807z);
            this.f26832y = new HashMap(trackSelectionParameters.f26806y);
        }

        private static ImmutableList C(String[] strArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (String str : (String[]) com.google.android.exoplayer2.util.a.e(strArr)) {
                builder.a(p0.D0((String) com.google.android.exoplayer2.util.a.e(str)));
            }
            return builder.e();
        }

        private void G(Context context) {
            CaptioningManager captioningManager;
            if ((p0.f27680a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f26827t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f26826s = ImmutableList.of(p0.Y(locale));
                }
            }
        }

        public TrackSelectionParameters A() {
            return new TrackSelectionParameters(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder D(TrackSelectionParameters trackSelectionParameters) {
            B(trackSelectionParameters);
            return this;
        }

        public Builder E(Set set) {
            this.f26833z.clear();
            this.f26833z.addAll(set);
            return this;
        }

        public Builder F(Context context) {
            if (p0.f27680a >= 19) {
                G(context);
            }
            return this;
        }

        public Builder H(int i11, int i12, boolean z10) {
            this.f26816i = i11;
            this.f26817j = i12;
            this.f26818k = z10;
            return this;
        }

        public Builder I(Context context, boolean z10) {
            Point O = p0.O(context);
            return H(O.x, O.y, z10);
        }
    }

    static {
        TrackSelectionParameters A2 = new Builder().A();
        A = A2;
        B = A2;
        C = new k.a() { // from class: la.p
            @Override // com.google.android.exoplayer2.k.a
            public final com.google.android.exoplayer2.k a(Bundle bundle) {
                return TrackSelectionParameters.b(bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrackSelectionParameters(Builder builder) {
        this.f26782a = builder.f26808a;
        this.f26783b = builder.f26809b;
        this.f26784c = builder.f26810c;
        this.f26785d = builder.f26811d;
        this.f26786e = builder.f26812e;
        this.f26787f = builder.f26813f;
        this.f26788g = builder.f26814g;
        this.f26789h = builder.f26815h;
        this.f26790i = builder.f26816i;
        this.f26791j = builder.f26817j;
        this.f26792k = builder.f26818k;
        this.f26793l = builder.f26819l;
        this.f26794m = builder.f26820m;
        this.f26795n = builder.f26821n;
        this.f26796o = builder.f26822o;
        this.f26797p = builder.f26823p;
        this.f26798q = builder.f26824q;
        this.f26799r = builder.f26825r;
        this.f26800s = builder.f26826s;
        this.f26801t = builder.f26827t;
        this.f26802u = builder.f26828u;
        this.f26803v = builder.f26829v;
        this.f26804w = builder.f26830w;
        this.f26805x = builder.f26831x;
        this.f26806y = ImmutableMap.copyOf((Map) builder.f26832y);
        this.f26807z = ImmutableSet.copyOf((Collection) builder.f26833z);
    }

    public static TrackSelectionParameters b(Bundle bundle) {
        return new Builder(bundle).A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public Builder a() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.f26782a == trackSelectionParameters.f26782a && this.f26783b == trackSelectionParameters.f26783b && this.f26784c == trackSelectionParameters.f26784c && this.f26785d == trackSelectionParameters.f26785d && this.f26786e == trackSelectionParameters.f26786e && this.f26787f == trackSelectionParameters.f26787f && this.f26788g == trackSelectionParameters.f26788g && this.f26789h == trackSelectionParameters.f26789h && this.f26792k == trackSelectionParameters.f26792k && this.f26790i == trackSelectionParameters.f26790i && this.f26791j == trackSelectionParameters.f26791j && this.f26793l.equals(trackSelectionParameters.f26793l) && this.f26794m == trackSelectionParameters.f26794m && this.f26795n.equals(trackSelectionParameters.f26795n) && this.f26796o == trackSelectionParameters.f26796o && this.f26797p == trackSelectionParameters.f26797p && this.f26798q == trackSelectionParameters.f26798q && this.f26799r.equals(trackSelectionParameters.f26799r) && this.f26800s.equals(trackSelectionParameters.f26800s) && this.f26801t == trackSelectionParameters.f26801t && this.f26802u == trackSelectionParameters.f26802u && this.f26803v == trackSelectionParameters.f26803v && this.f26804w == trackSelectionParameters.f26804w && this.f26805x == trackSelectionParameters.f26805x && this.f26806y.equals(trackSelectionParameters.f26806y) && this.f26807z.equals(trackSelectionParameters.f26807z);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.f26782a + 31) * 31) + this.f26783b) * 31) + this.f26784c) * 31) + this.f26785d) * 31) + this.f26786e) * 31) + this.f26787f) * 31) + this.f26788g) * 31) + this.f26789h) * 31) + (this.f26792k ? 1 : 0)) * 31) + this.f26790i) * 31) + this.f26791j) * 31) + this.f26793l.hashCode()) * 31) + this.f26794m) * 31) + this.f26795n.hashCode()) * 31) + this.f26796o) * 31) + this.f26797p) * 31) + this.f26798q) * 31) + this.f26799r.hashCode()) * 31) + this.f26800s.hashCode()) * 31) + this.f26801t) * 31) + this.f26802u) * 31) + (this.f26803v ? 1 : 0)) * 31) + (this.f26804w ? 1 : 0)) * 31) + (this.f26805x ? 1 : 0)) * 31) + this.f26806y.hashCode()) * 31) + this.f26807z.hashCode();
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(6), this.f26782a);
        bundle.putInt(c(7), this.f26783b);
        bundle.putInt(c(8), this.f26784c);
        bundle.putInt(c(9), this.f26785d);
        bundle.putInt(c(10), this.f26786e);
        bundle.putInt(c(11), this.f26787f);
        bundle.putInt(c(12), this.f26788g);
        bundle.putInt(c(13), this.f26789h);
        bundle.putInt(c(14), this.f26790i);
        bundle.putInt(c(15), this.f26791j);
        bundle.putBoolean(c(16), this.f26792k);
        bundle.putStringArray(c(17), (String[]) this.f26793l.toArray(new String[0]));
        bundle.putInt(c(25), this.f26794m);
        bundle.putStringArray(c(1), (String[]) this.f26795n.toArray(new String[0]));
        bundle.putInt(c(2), this.f26796o);
        bundle.putInt(c(18), this.f26797p);
        bundle.putInt(c(19), this.f26798q);
        bundle.putStringArray(c(20), (String[]) this.f26799r.toArray(new String[0]));
        bundle.putStringArray(c(3), (String[]) this.f26800s.toArray(new String[0]));
        bundle.putInt(c(4), this.f26801t);
        bundle.putInt(c(26), this.f26802u);
        bundle.putBoolean(c(5), this.f26803v);
        bundle.putBoolean(c(21), this.f26804w);
        bundle.putBoolean(c(22), this.f26805x);
        bundle.putParcelableArrayList(c(23), com.google.android.exoplayer2.util.d.d(this.f26806y.values()));
        bundle.putIntArray(c(24), Ints.o(this.f26807z));
        return bundle;
    }
}
