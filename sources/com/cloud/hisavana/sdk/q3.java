package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.bean.SSPWebPageReqInfo;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;

/* loaded from: classes3.dex */
public final class q3 {

    /* renamed from: a, reason: collision with root package name */
    private final long f22947a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22948b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f22949c;

    /* renamed from: d, reason: collision with root package name */
    private final int f22950d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f22951e;

    /* renamed from: f, reason: collision with root package name */
    private final int f22952f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f22953g;

    /* renamed from: h, reason: collision with root package name */
    private final int f22954h;

    /* renamed from: i, reason: collision with root package name */
    private final b7.b f22955i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f22956j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f22957k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f22958l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f22959m;

    /* renamed from: n, reason: collision with root package name */
    private final double f22960n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f22961o;

    /* renamed from: p, reason: collision with root package name */
    private final int f22962p;

    /* renamed from: q, reason: collision with root package name */
    private final String f22963q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f22964r;

    /* renamed from: s, reason: collision with root package name */
    private ConfigCodeSeatDTO f22965s;

    /* renamed from: t, reason: collision with root package name */
    private int f22966t;

    /* renamed from: u, reason: collision with root package name */
    private int f22967u;

    /* renamed from: v, reason: collision with root package name */
    private String f22968v;

    /* renamed from: w, reason: collision with root package name */
    private SSPWebPageReqInfo f22969w;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f22970a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f22971b;

        /* renamed from: c, reason: collision with root package name */
        private int f22972c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f22973d;

        /* renamed from: e, reason: collision with root package name */
        private int f22974e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f22975f;

        /* renamed from: g, reason: collision with root package name */
        private int f22976g;

        /* renamed from: h, reason: collision with root package name */
        private b7.b f22977h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f22978i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f22979j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f22980k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f22981l;

        /* renamed from: m, reason: collision with root package name */
        private double f22982m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f22983n;

        /* renamed from: o, reason: collision with root package name */
        private int f22984o;

        /* renamed from: p, reason: collision with root package name */
        private String f22985p;

        /* renamed from: q, reason: collision with root package name */
        private int f22986q;

        /* renamed from: r, reason: collision with root package name */
        private String f22987r;

        /* renamed from: s, reason: collision with root package name */
        private SSPWebPageReqInfo f22988s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f22989t;

        public b() {
            this("");
        }

        public b(String str) {
            this.f22974e = 1;
            this.f22978i = true;
            this.f22979j = false;
            this.f22980k = false;
            this.f22981l = false;
            this.f22983n = false;
            this.f22989t = false;
            this.f22985p = DeviceUtil.o();
            this.f22986q = 45000;
            if (TextUtils.isEmpty(str)) {
                this.f22987r = com.cloud.hisavana.sdk.common.util.m0.b();
            } else {
                this.f22987r = str;
            }
            this.f22984o = 1;
            this.f22977h = new b7.b(null, null, null);
        }

        public b a(int i11) {
            if (i11 < 1) {
                i11 = 1;
            }
            this.f22974e = i11;
            return this;
        }

        public b b(b7.a aVar) {
            if (aVar == null) {
                return this;
            }
            if (!this.f22989t) {
                String c11 = aVar.c();
                if (!TextUtils.isEmpty(c11)) {
                    this.f22985p = c11.replace("hisa-", "");
                }
            }
            if (aVar.e() > 0) {
                this.f22986q = aVar.e();
            }
            if (aVar.d() != -1) {
                this.f22984o = aVar.d();
            }
            this.f22983n = aVar.g();
            String f11 = aVar.f();
            if (!this.f22989t && !TextUtils.isEmpty(f11)) {
                this.f22987r = f11.replace("hisa-", "");
            }
            if (aVar.b() > 0.0d) {
                this.f22982m = aVar.b();
            }
            return this;
        }

        public b c(b7.b bVar) {
            if (bVar != null) {
                this.f22977h = bVar;
            }
            return this;
        }

        public b d(SSPWebPageReqInfo sSPWebPageReqInfo) {
            this.f22988s = sSPWebPageReqInfo;
            return this;
        }

        public b e(String str) {
            this.f22970a = str;
            return this;
        }

        public b f(boolean z10) {
            this.f22989t = z10;
            return this;
        }

        public q3 g() {
            return new q3(this);
        }

        public b i(int i11) {
            this.f22976g = i11;
            return this;
        }

        public b j(boolean z10) {
            this.f22973d = z10;
            return this;
        }

        public b l(int i11) {
            this.f22972c = i11;
            return this;
        }

        public b m(boolean z10) {
            this.f22981l = z10;
            return this;
        }

        public b o(boolean z10) {
            this.f22975f = z10;
            return this;
        }

        public b r(boolean z10) {
            this.f22971b = z10;
            return this;
        }

        public b s(boolean z10) {
            this.f22980k = z10;
            return this;
        }

        public b v(boolean z10) {
            this.f22979j = z10;
            return this;
        }
    }

    private q3(b bVar) {
        this.f22964r = false;
        this.f22948b = bVar.f22970a;
        this.f22949c = bVar.f22971b;
        this.f22950d = bVar.f22972c;
        this.f22951e = bVar.f22973d;
        this.f22952f = bVar.f22974e;
        this.f22953g = bVar.f22975f;
        this.f22954h = bVar.f22976g;
        this.f22955i = bVar.f22977h;
        this.f22956j = bVar.f22978i;
        this.f22957k = bVar.f22979j;
        this.f22958l = bVar.f22980k;
        this.f22959m = bVar.f22981l;
        this.f22960n = bVar.f22982m;
        this.f22961o = bVar.f22983n;
        this.f22962p = bVar.f22984o;
        this.f22968v = bVar.f22985p;
        this.f22963q = bVar.f22987r;
        this.f22967u = bVar.f22986q;
        this.f22947a = System.currentTimeMillis();
        this.f22969w = bVar.f22988s;
        this.f22964r = bVar.f22989t;
    }

    public int a() {
        return this.f22952f;
    }

    public void b(int i11) {
        this.f22966t = i11;
    }

    public void c(ConfigCodeSeatDTO configCodeSeatDTO) {
        this.f22965s = configCodeSeatDTO;
    }

    public void d(String str) {
        this.f22968v = str;
    }

    public int e() {
        return this.f22954h;
    }

    public ConfigCodeSeatDTO f() {
        ConfigCodeSeatDTO configCodeSeatDTO = this.f22965s;
        return configCodeSeatDTO == null ? new ConfigCodeSeatDTO() : configCodeSeatDTO;
    }

    public long g() {
        return this.f22947a;
    }

    public int h() {
        return this.f22950d;
    }

    public String i() {
        return this.f22948b;
    }

    public String j() {
        return this.f22968v;
    }

    public int k() {
        return this.f22962p;
    }

    public b7.b l() {
        return this.f22955i;
    }

    public int m() {
        return this.f22967u;
    }

    public String n() {
        return this.f22963q;
    }

    public int o() {
        return this.f22966t;
    }

    public SSPWebPageReqInfo p() {
        return this.f22969w;
    }

    public boolean q() {
        return this.f22956j;
    }

    public boolean r() {
        return this.f22964r;
    }

    public boolean s() {
        return this.f22951e;
    }

    public boolean t() {
        return this.f22959m;
    }

    public boolean u() {
        return this.f22953g;
    }

    public boolean v() {
        return this.f22949c;
    }

    public boolean w() {
        return this.f22958l;
    }

    public boolean x() {
        return this.f22957k;
    }

    public boolean y() {
        return this.f22961o;
    }
}
