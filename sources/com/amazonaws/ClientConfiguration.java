package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import javax.net.ssl.TrustManager;

/* loaded from: classes2.dex */
public class ClientConfiguration {

    /* renamed from: u, reason: collision with root package name */
    public static final String f18364u = VersionInfoUtils.b();

    /* renamed from: v, reason: collision with root package name */
    public static final RetryPolicy f18365v = PredefinedRetryPolicies.f18652b;

    /* renamed from: b, reason: collision with root package name */
    private String f18367b;

    /* renamed from: q, reason: collision with root package name */
    private String f18382q;

    /* renamed from: a, reason: collision with root package name */
    private String f18366a = f18364u;

    /* renamed from: c, reason: collision with root package name */
    private int f18368c = -1;

    /* renamed from: d, reason: collision with root package name */
    private RetryPolicy f18369d = f18365v;

    /* renamed from: e, reason: collision with root package name */
    private Protocol f18370e = Protocol.HTTPS;

    /* renamed from: f, reason: collision with root package name */
    private String f18371f = null;

    /* renamed from: g, reason: collision with root package name */
    private int f18372g = -1;

    /* renamed from: h, reason: collision with root package name */
    private String f18373h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f18374i = null;

    /* renamed from: j, reason: collision with root package name */
    private String f18375j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f18376k = null;

    /* renamed from: l, reason: collision with root package name */
    private int f18377l = 10;

    /* renamed from: m, reason: collision with root package name */
    private int f18378m = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* renamed from: n, reason: collision with root package name */
    private int f18379n = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* renamed from: o, reason: collision with root package name */
    private int f18380o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f18381p = 0;

    /* renamed from: r, reason: collision with root package name */
    private TrustManager f18383r = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f18384s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f18385t = false;

    public int a() {
        return this.f18379n;
    }

    public int b() {
        return this.f18368c;
    }

    public Protocol c() {
        return this.f18370e;
    }

    public RetryPolicy d() {
        return this.f18369d;
    }

    public String e() {
        return this.f18382q;
    }

    public int f() {
        return this.f18378m;
    }

    public TrustManager g() {
        return this.f18383r;
    }

    public String h() {
        return this.f18366a;
    }

    public String i() {
        return this.f18367b;
    }

    public boolean j() {
        return this.f18384s;
    }

    public boolean k() {
        return this.f18385t;
    }
}
