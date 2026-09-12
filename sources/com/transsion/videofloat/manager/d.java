package com.transsion.videofloat.manager;

import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final px.a f58059a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f58060b;

    /* renamed from: c, reason: collision with root package name */
    private long f58061c;

    /* renamed from: d, reason: collision with root package name */
    private long f58062d;

    /* renamed from: e, reason: collision with root package name */
    private long f58063e;

    /* renamed from: f, reason: collision with root package name */
    private long f58064f;

    /* renamed from: g, reason: collision with root package name */
    private long f58065g;

    /* renamed from: h, reason: collision with root package name */
    private int f58066h;

    /* renamed from: i, reason: collision with root package name */
    private long f58067i;

    /* renamed from: j, reason: collision with root package name */
    private long f58068j;

    /* renamed from: k, reason: collision with root package name */
    private long f58069k;

    /* renamed from: l, reason: collision with root package name */
    private int f58070l;

    /* renamed from: m, reason: collision with root package name */
    private long f58071m;

    /* renamed from: n, reason: collision with root package name */
    private long f58072n;

    /* renamed from: o, reason: collision with root package name */
    private long f58073o;

    /* renamed from: p, reason: collision with root package name */
    private Integer f58074p;

    /* renamed from: q, reason: collision with root package name */
    private String f58075q;

    /* renamed from: r, reason: collision with root package name */
    private String f58076r;

    /* renamed from: s, reason: collision with root package name */
    private String f58077s;

    /* renamed from: t, reason: collision with root package name */
    private yj.c f58078t;

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58079a;

        static {
            int[] iArr = new int[FloatPlayType.values().length];
            try {
                iArr[FloatPlayType.SHORT_TV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatPlayType.STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatPlayType.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f58079a = iArr;
        }
    }

    public d(px.a floatBean, boolean z10) {
        Intrinsics.h(floatBean, "floatBean");
        this.f58059a = floatBean;
        this.f58060b = z10;
        this.f58075q = "";
        if (z10) {
            q(floatBean.f().getDuration());
        }
    }

    private final yj.c c() {
        if (this.f58078t == null) {
            this.f58078t = (yj.c) yj.a.f79145a.a(yj.c.class);
        }
        return this.f58078t;
    }

    private final void o() {
        this.f58061c = 0L;
        this.f58062d = 0L;
        this.f58063e = 0L;
        this.f58064f = 0L;
        this.f58065g = 0L;
        this.f58066h = 0;
        this.f58067i = 0L;
        this.f58068j = 0L;
        this.f58069k = 0L;
        this.f58070l = 0;
        this.f58071m = 0L;
        this.f58072n = 0L;
        this.f58073o = 0L;
        this.f58076r = null;
    }

    public final void a() {
        this.f58062d = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "addSurface", false, 4, null);
    }

    public final void b() {
        String str;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_positive", String.valueOf(this.f58059a.w()));
        String m11 = this.f58059a.m();
        if (m11 == null) {
            m11 = "";
        }
        linkedHashMap.put("post_id", m11);
        linkedHashMap.put("subject_id", this.f58059a.r());
        String str4 = this.f58077s;
        linkedHashMap.put("play_type", str4 != null ? str4 : "");
        linkedHashMap.put("opt_type", "float");
        if (this.f58059a.q() > 0) {
            linkedHashMap.put("se", String.valueOf(this.f58059a.q()));
        }
        if (this.f58059a.c() > 0) {
            linkedHashMap.put("ep", String.valueOf(this.f58059a.c()));
        }
        String g11 = this.f58059a.g();
        if (g11 != null && g11.length() != 0) {
            String g12 = this.f58059a.g();
            Intrinsics.e(g12);
            linkedHashMap.put(WebConstants.PAGE_FROM, g12);
        }
        String e11 = this.f58059a.e();
        if (e11 != null && e11.length() != 0) {
            String e12 = this.f58059a.e();
            Intrinsics.e(e12);
            linkedHashMap.put("ops", e12);
        }
        if (this.f58059a.s() != null) {
            linkedHashMap.put("subject_type", String.valueOf(this.f58059a.s()));
        }
        if (this.f58063e > 0 || this.f58060b) {
            linkedHashMap.put("is_start", "1");
            long j11 = this.f58063e;
            if (j11 > 0) {
                long j12 = this.f58061c;
                linkedHashMap.put("delay_v", (j12 <= 0 || j11 <= 0) ? "0" : String.valueOf(j11 - j12));
                long j13 = this.f58062d;
                if (j13 > 0) {
                    long j14 = this.f58063e;
                    if (j14 > 0) {
                        str = String.valueOf(j14 - j13);
                        linkedHashMap.put("delay", str);
                    }
                }
                str = "0";
                linkedHashMap.put("delay", str);
            }
            linkedHashMap.put("buffer_time", String.valueOf(this.f58064f));
            linkedHashMap.put("buffer_count", String.valueOf(this.f58066h));
            linkedHashMap.put("play_complete", String.valueOf(((((float) this.f58067i) / ((float) this.f58073o)) * 100.0f) + (this.f58070l * 100.0f)));
            linkedHashMap.put("play_duration", String.valueOf(this.f58069k));
            linkedHashMap.put("pause_duration", String.valueOf(this.f58072n));
            linkedHashMap.put("completeCount", String.valueOf(this.f58070l));
            linkedHashMap.put("play_duration_float", String.valueOf(this.f58069k));
        } else {
            linkedHashMap.put("is_start", "0");
            linkedHashMap.put("delay_v", this.f58061c > 0 ? String.valueOf(System.currentTimeMillis() - this.f58061c) : "0");
            linkedHashMap.put("delay", this.f58062d > 0 ? String.valueOf(System.currentTimeMillis() - this.f58062d) : "0");
        }
        String str5 = this.f58076r;
        if (str5 != null) {
            linkedHashMap.put("is_preloaded", str5);
        }
        linkedHashMap.put("url", this.f58075q);
        linkedHashMap.put("builtin", this.f58059a.a() ? "1" : "0");
        long j15 = this.f58073o;
        if (j15 > 0) {
            linkedHashMap.put("total_duration", String.valueOf(j15));
        }
        linkedHashMap.put("player_type", "1");
        Integer num = this.f58074p;
        if (num != null) {
            linkedHashMap.put("error_code", String.valueOf(num));
        }
        yj.c c11 = c();
        if (c11 != null) {
            c11.b(this.f58069k);
        }
        int i11 = a.f58079a[this.f58059a.i().ordinal()];
        if (i11 != 1) {
            str3 = "long_video_play";
            if (i11 == 2) {
                str2 = "stream_detail";
            } else if (i11 != 3) {
                return;
            } else {
                str2 = "local_video_detail";
            }
        } else {
            str2 = "minitv_play";
            str3 = "video_play";
        }
        hj.i.f64628a.H(str2, str3, this.f58069k, linkedHashMap);
        o();
    }

    public final void d() {
        this.f58061c = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "initView", false, 4, null);
    }

    public final void e() {
        h(this.f58073o);
    }

    public final void f() {
        this.f58065g = System.currentTimeMillis();
    }

    public final void g() {
        if (this.f58065g > 0) {
            this.f58064f += System.currentTimeMillis() - this.f58065g;
            this.f58066h++;
            this.f58065g = 0L;
        }
    }

    public final void h(long j11) {
        long j12 = this.f58068j;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f58069k += j11 - j12;
        }
        this.f58068j = j11;
        if (j11 > this.f58067i) {
            this.f58067i = j11;
        }
        yj.c c11 = c();
        if (c11 != null) {
            c11.a(this.f58069k);
        }
    }

    public final void i() {
        q(this.f58059a.f().getDuration());
        a.C0856a.f(lg.a.f68962a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f58063e = System.currentTimeMillis();
    }

    public final void j() {
        this.f58071m = System.currentTimeMillis();
    }

    public final void k() {
        if (this.f58071m != 0) {
            this.f58072n += System.currentTimeMillis() - this.f58071m;
            this.f58071m = 0L;
        }
    }

    public final void l() {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.f58059a.r());
        hashMap.put(EventConstants.KEY_ACTION, "float_back_to_detail");
        String e11 = this.f58059a.e();
        if (e11 == null) {
            e11 = "";
        }
        hashMap.put("ops", e11);
        hj.i.f64628a.p(this.f58059a.h(), hashMap);
    }

    public final void m() {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.f58059a.r());
        hashMap.put(EventConstants.KEY_ACTION, "float_close");
        String e11 = this.f58059a.e();
        if (e11 == null) {
            e11 = "";
        }
        hashMap.put("ops", e11);
        hj.i.f64628a.p(this.f58059a.h(), hashMap);
    }

    public final void n() {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.f58059a.r());
        hashMap.put(EventConstants.KEY_ACTION, "float_show");
        hashMap.put("is_positive", String.valueOf(this.f58059a.w()));
        String e11 = this.f58059a.e();
        if (e11 == null) {
            e11 = "";
        }
        hashMap.put("ops", e11);
        hj.i.f64628a.D(this.f58059a.h(), hashMap);
    }

    public final void p(String type) {
        Intrinsics.h(type, "type");
        this.f58077s = type;
    }

    public final void q(long j11) {
        this.f58073o = j11;
    }

    public final void r(String url) {
        Intrinsics.h(url, "url");
        this.f58075q = url;
    }
}
