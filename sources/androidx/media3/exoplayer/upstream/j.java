package androidx.media3.exoplayer.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.z;
import androidx.media3.exoplayer.upstream.e;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j implements e, w1.n {

    /* renamed from: r, reason: collision with root package name */
    public static final ImmutableList f13056r = ImmutableList.of(4300000L, 3200000L, 2400000L, 1700000L, 860000L);

    /* renamed from: s, reason: collision with root package name */
    public static final ImmutableList f13057s = ImmutableList.of(1500000L, 980000L, 750000L, 520000L, 290000L);

    /* renamed from: t, reason: collision with root package name */
    public static final ImmutableList f13058t = ImmutableList.of(2000000L, 1300000L, 1000000L, 860000L, 610000L);

    /* renamed from: u, reason: collision with root package name */
    public static final ImmutableList f13059u = ImmutableList.of(2500000L, 1700000L, 1200000L, 970000L, 680000L);

    /* renamed from: v, reason: collision with root package name */
    public static final ImmutableList f13060v = ImmutableList.of(4700000L, 2800000L, 2100000L, 1700000L, 980000L);

    /* renamed from: w, reason: collision with root package name */
    public static final ImmutableList f13061w = ImmutableList.of(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);

    /* renamed from: x, reason: collision with root package name */
    private static j f13062x;

    /* renamed from: a, reason: collision with root package name */
    private final Context f13063a;

    /* renamed from: b, reason: collision with root package name */
    private final ImmutableMap f13064b;

    /* renamed from: c, reason: collision with root package name */
    private final e.a.C0110a f13065c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.util.i f13066d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f13067e;

    /* renamed from: f, reason: collision with root package name */
    private final t f13068f;

    /* renamed from: g, reason: collision with root package name */
    private int f13069g;

    /* renamed from: h, reason: collision with root package name */
    private long f13070h;

    /* renamed from: i, reason: collision with root package name */
    private long f13071i;

    /* renamed from: j, reason: collision with root package name */
    private long f13072j;

    /* renamed from: k, reason: collision with root package name */
    private long f13073k;

    /* renamed from: l, reason: collision with root package name */
    private long f13074l;

    /* renamed from: m, reason: collision with root package name */
    private long f13075m;

    /* renamed from: n, reason: collision with root package name */
    private int f13076n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f13077o;

    /* renamed from: p, reason: collision with root package name */
    private int f13078p;

    /* renamed from: q, reason: collision with root package name */
    private String f13079q;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f13080a;

        /* renamed from: b, reason: collision with root package name */
        private final Map f13081b;

        /* renamed from: c, reason: collision with root package name */
        private int f13082c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.common.util.i f13083d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f13084e;

        public b(Context context) {
            this.f13080a = context == null ? null : context.getApplicationContext();
            this.f13082c = 2000;
            this.f13083d = androidx.media3.common.util.i.f10469a;
            this.f13084e = true;
            HashMap hashMap = new HashMap(8);
            this.f13081b = hashMap;
            hashMap.put(0, 1000000L);
            hashMap.put(2, Long.valueOf(C.TIME_UNSET));
            hashMap.put(3, Long.valueOf(C.TIME_UNSET));
            hashMap.put(4, Long.valueOf(C.TIME_UNSET));
            hashMap.put(5, Long.valueOf(C.TIME_UNSET));
            hashMap.put(10, Long.valueOf(C.TIME_UNSET));
            hashMap.put(9, Long.valueOf(C.TIME_UNSET));
            hashMap.put(7, Long.valueOf(C.TIME_UNSET));
        }

        public j a() {
            return new j(this.f13080a, this.f13081b, this.f13082c, this.f13083d, this.f13084e);
        }
    }

    private j(Context context, Map map, int i11, androidx.media3.common.util.i iVar, boolean z10) {
        this.f13063a = context == null ? null : context.getApplicationContext();
        this.f13064b = ImmutableMap.copyOf(map);
        this.f13065c = new e.a.C0110a();
        this.f13068f = new t(i11);
        this.f13066d = iVar;
        this.f13067e = z10;
        if (context == null) {
            this.f13076n = 0;
            this.f13074l = 1000000L;
            return;
        }
        z e11 = z.e(context);
        int g11 = e11.g();
        this.f13076n = g11;
        this.f13074l = k(g11);
        e11.l(new z.c() { // from class: androidx.media3.exoplayer.upstream.i
            @Override // androidx.media3.common.util.z.c
            public final void a(int i12) {
                j.this.p(i12);
            }
        }, androidx.media3.common.util.c.a());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1041:0x0cd7, code lost:
    
        if (r8.equals("AI") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] j(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 8434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.j.j(java.lang.String):int[]");
    }

    private long k(int i11) {
        Long l11 = (Long) this.f13064b.get(Integer.valueOf(i11));
        if (l11 == null) {
            l11 = (Long) this.f13064b.get(0);
        } else if (l11.longValue() == C.TIME_UNSET) {
            l11 = Long.valueOf(l(this.f13079q, i11));
        }
        if (l11 == null) {
            l11 = 1000000L;
        }
        return l11.longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static long l(String str, int i11) {
        int[] j11 = j(com.google.common.base.p.e(str));
        if (i11 != 2) {
            if (i11 == 3) {
                return ((Long) f13057s.get(j11[1])).longValue();
            }
            if (i11 == 4) {
                return ((Long) f13058t.get(j11[2])).longValue();
            }
            if (i11 == 5) {
                return ((Long) f13059u.get(j11[3])).longValue();
            }
            if (i11 != 7) {
                if (i11 == 9) {
                    return ((Long) f13061w.get(j11[5])).longValue();
                }
                if (i11 != 10) {
                    return 1000000L;
                }
                return ((Long) f13060v.get(j11[4])).longValue();
            }
        }
        return ((Long) f13056r.get(j11[0])).longValue();
    }

    public static synchronized j m(Context context) {
        j jVar;
        synchronized (j.class) {
            try {
                if (f13062x == null) {
                    f13062x = new b(context).a();
                }
                jVar = f13062x;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jVar;
    }

    private static boolean n(w1.h hVar, boolean z10) {
        return z10 && !hVar.d(8);
    }

    private void o(int i11, long j11, long j12) {
        if (i11 == 0 && j11 == 0 && j12 == this.f13075m) {
            return;
        }
        this.f13075m = j12;
        this.f13065c.c(i11, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p(int i11) {
        int i12 = this.f13076n;
        if (i12 == 0 || this.f13067e) {
            if (this.f13077o) {
                i11 = this.f13078p;
            }
            if (i12 != i11 || this.f13079q == null) {
                this.f13076n = i11;
                if (i11 != 1 && i11 != 0 && i11 != 8) {
                    if (this.f13079q == null) {
                        this.f13079q = a1.U(this.f13063a);
                    }
                    this.f13074l = k(i11);
                    long elapsedRealtime = this.f13066d.elapsedRealtime();
                    o(this.f13069g > 0 ? (int) (elapsedRealtime - this.f13070h) : 0, this.f13071i, this.f13074l);
                    this.f13070h = elapsedRealtime;
                    this.f13071i = 0L;
                    this.f13073k = 0L;
                    this.f13072j = 0L;
                    this.f13068f.i();
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.upstream.e
    public /* synthetic */ long a() {
        return c.a(this);
    }

    @Override // androidx.media3.exoplayer.upstream.e
    public w1.n b() {
        return this;
    }

    @Override // androidx.media3.exoplayer.upstream.e
    public void c(e.a aVar) {
        this.f13065c.e(aVar);
    }

    @Override // androidx.media3.exoplayer.upstream.e
    public void d(Handler handler, e.a aVar) {
        androidx.media3.common.util.a.e(handler);
        androidx.media3.common.util.a.e(aVar);
        this.f13065c.b(handler, aVar);
    }

    @Override // w1.n
    public synchronized void e(androidx.media3.datasource.a aVar, w1.h hVar, boolean z10, int i11) {
        if (n(hVar, z10)) {
            this.f13071i += i11;
        }
    }

    @Override // w1.n
    public synchronized void f(androidx.media3.datasource.a aVar, w1.h hVar, boolean z10) {
        try {
            if (n(hVar, z10)) {
                androidx.media3.common.util.a.g(this.f13069g > 0);
                long elapsedRealtime = this.f13066d.elapsedRealtime();
                int i11 = (int) (elapsedRealtime - this.f13070h);
                this.f13072j += i11;
                long j11 = this.f13073k;
                long j12 = this.f13071i;
                this.f13073k = j11 + j12;
                if (i11 > 0) {
                    this.f13068f.c((int) Math.sqrt(j12), (((float) j12) * 8000.0f) / i11);
                    if (this.f13072j < 2000) {
                        if (this.f13073k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        }
                        o(i11, this.f13071i, this.f13074l);
                        this.f13070h = elapsedRealtime;
                        this.f13071i = 0L;
                    }
                    this.f13074l = this.f13068f.f(0.5f);
                    o(i11, this.f13071i, this.f13074l);
                    this.f13070h = elapsedRealtime;
                    this.f13071i = 0L;
                }
                this.f13069g--;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // w1.n
    public void g(androidx.media3.datasource.a aVar, w1.h hVar, boolean z10) {
    }

    @Override // androidx.media3.exoplayer.upstream.e
    public synchronized long getBitrateEstimate() {
        return this.f13074l;
    }

    @Override // w1.n
    public synchronized void h(androidx.media3.datasource.a aVar, w1.h hVar, boolean z10) {
        try {
            if (n(hVar, z10)) {
                if (this.f13069g == 0) {
                    this.f13070h = this.f13066d.elapsedRealtime();
                }
                this.f13069g++;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
