package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class q implements e, k0 {

    /* renamed from: p, reason: collision with root package name */
    public static final ImmutableList f27520p = ImmutableList.of(4800000L, 3100000L, 2100000L, 1500000L, 800000L);

    /* renamed from: q, reason: collision with root package name */
    public static final ImmutableList f27521q = ImmutableList.of(1500000L, 1000000L, 730000L, 440000L, 170000L);

    /* renamed from: r, reason: collision with root package name */
    public static final ImmutableList f27522r = ImmutableList.of(2200000L, 1400000L, 1100000L, 910000L, 620000L);

    /* renamed from: s, reason: collision with root package name */
    public static final ImmutableList f27523s = ImmutableList.of(3000000L, 1900000L, 1400000L, 1000000L, 660000L);

    /* renamed from: t, reason: collision with root package name */
    public static final ImmutableList f27524t = ImmutableList.of(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);

    /* renamed from: u, reason: collision with root package name */
    public static final ImmutableList f27525u = ImmutableList.of(2800000L, 2400000L, 1600000L, 1100000L, 950000L);

    /* renamed from: v, reason: collision with root package name */
    private static q f27526v;

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableMap f27527a;

    /* renamed from: b, reason: collision with root package name */
    private final e.a.C0382a f27528b;

    /* renamed from: c, reason: collision with root package name */
    private final h0 f27529c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f27530d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f27531e;

    /* renamed from: f, reason: collision with root package name */
    private int f27532f;

    /* renamed from: g, reason: collision with root package name */
    private long f27533g;

    /* renamed from: h, reason: collision with root package name */
    private long f27534h;

    /* renamed from: i, reason: collision with root package name */
    private int f27535i;

    /* renamed from: j, reason: collision with root package name */
    private long f27536j;

    /* renamed from: k, reason: collision with root package name */
    private long f27537k;

    /* renamed from: l, reason: collision with root package name */
    private long f27538l;

    /* renamed from: m, reason: collision with root package name */
    private long f27539m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f27540n;

    /* renamed from: o, reason: collision with root package name */
    private int f27541o;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f27542a;

        /* renamed from: b, reason: collision with root package name */
        private Map f27543b;

        /* renamed from: c, reason: collision with root package name */
        private int f27544c;

        /* renamed from: d, reason: collision with root package name */
        private com.google.android.exoplayer2.util.e f27545d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f27546e;

        public b(Context context) {
            this.f27542a = context == null ? null : context.getApplicationContext();
            this.f27543b = b(p0.N(context));
            this.f27544c = 2000;
            this.f27545d = com.google.android.exoplayer2.util.e.f27621a;
            this.f27546e = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Map b(String str) {
            int[] k11 = q.k(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            ImmutableList immutableList = q.f27520p;
            hashMap.put(2, (Long) immutableList.get(k11[0]));
            hashMap.put(3, (Long) q.f27521q.get(k11[1]));
            hashMap.put(4, (Long) q.f27522r.get(k11[2]));
            hashMap.put(5, (Long) q.f27523s.get(k11[3]));
            hashMap.put(10, (Long) q.f27524t.get(k11[4]));
            hashMap.put(9, (Long) q.f27525u.get(k11[5]));
            hashMap.put(7, (Long) immutableList.get(k11[0]));
            return hashMap;
        }

        public q a() {
            return new q(this.f27542a, this.f27543b, this.f27544c, this.f27545d, this.f27546e);
        }
    }

    @Deprecated
    public q() {
        this(null, ImmutableMap.of(), 2000, com.google.android.exoplayer2.util.e.f27621a, false);
    }

    private q(Context context, Map map, int i11, com.google.android.exoplayer2.util.e eVar, boolean z10) {
        this.f27527a = ImmutableMap.copyOf(map);
        this.f27528b = new e.a.C0382a();
        this.f27529c = new h0(i11);
        this.f27530d = eVar;
        this.f27531e = z10;
        if (context == null) {
            this.f27535i = 0;
            this.f27538l = l(0);
            return;
        }
        com.google.android.exoplayer2.util.z d11 = com.google.android.exoplayer2.util.z.d(context);
        int f11 = d11.f();
        this.f27535i = f11;
        this.f27538l = l(f11);
        d11.i(new z.c() { // from class: com.google.android.exoplayer2.upstream.p
            @Override // com.google.android.exoplayer2.util.z.c
            public final void a(int i12) {
                q.this.p(i12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1019:0x0ceb, code lost:
    
        if (r8.equals("AD") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] k(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 8086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.q.k(java.lang.String):int[]");
    }

    private long l(int i11) {
        Long l11 = (Long) this.f27527a.get(Integer.valueOf(i11));
        if (l11 == null) {
            l11 = (Long) this.f27527a.get(0);
        }
        if (l11 == null) {
            l11 = 1000000L;
        }
        return l11.longValue();
    }

    public static synchronized q m(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f27526v == null) {
                    f27526v = new b(context).a();
                }
                qVar = f27526v;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return qVar;
    }

    private static boolean n(n nVar, boolean z10) {
        return z10 && !nVar.d(8);
    }

    private void o(int i11, long j11, long j12) {
        if (i11 == 0 && j11 == 0 && j12 == this.f27539m) {
            return;
        }
        this.f27539m = j12;
        this.f27528b.c(i11, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i11) {
        int i12 = this.f27535i;
        if (i12 == 0 || this.f27531e) {
            if (this.f27540n) {
                i11 = this.f27541o;
            }
            if (i12 == i11) {
                return;
            }
            this.f27535i = i11;
            if (i11 != 1 && i11 != 0 && i11 != 8) {
                this.f27538l = l(i11);
                long elapsedRealtime = this.f27530d.elapsedRealtime();
                o(this.f27532f > 0 ? (int) (elapsedRealtime - this.f27533g) : 0, this.f27534h, this.f27538l);
                this.f27533g = elapsedRealtime;
                this.f27534h = 0L;
                this.f27537k = 0L;
                this.f27536j = 0L;
                this.f27529c.i();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public /* synthetic */ long a() {
        return c.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public k0 b() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public synchronized void c(k kVar, n nVar, boolean z10) {
        try {
            if (n(nVar, z10)) {
                com.google.android.exoplayer2.util.a.g(this.f27532f > 0);
                long elapsedRealtime = this.f27530d.elapsedRealtime();
                int i11 = (int) (elapsedRealtime - this.f27533g);
                this.f27536j += i11;
                long j11 = this.f27537k;
                long j12 = this.f27534h;
                this.f27537k = j11 + j12;
                if (i11 > 0) {
                    this.f27529c.c((int) Math.sqrt(j12), (((float) j12) * 8000.0f) / i11);
                    if (this.f27536j < 2000) {
                        if (this.f27537k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        }
                        o(i11, this.f27534h, this.f27538l);
                        this.f27533g = elapsedRealtime;
                        this.f27534h = 0L;
                    }
                    this.f27538l = this.f27529c.f(0.5f);
                    o(i11, this.f27534h, this.f27538l);
                    this.f27533g = elapsedRealtime;
                    this.f27534h = 0L;
                }
                this.f27532f--;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void d(e.a aVar) {
        this.f27528b.e(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public synchronized void e(k kVar, n nVar, boolean z10, int i11) {
        if (n(nVar, z10)) {
            this.f27534h += i11;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void f(Handler handler, e.a aVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f27528b.b(handler, aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public synchronized void g(k kVar, n nVar, boolean z10) {
        try {
            if (n(nVar, z10)) {
                if (this.f27532f == 0) {
                    this.f27533g = this.f27530d.elapsedRealtime();
                }
                this.f27532f++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public synchronized long getBitrateEstimate() {
        return this.f27538l;
    }

    @Override // com.google.android.exoplayer2.upstream.k0
    public void h(k kVar, n nVar, boolean z10) {
    }
}
