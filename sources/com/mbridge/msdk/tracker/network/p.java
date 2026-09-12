package com.mbridge.msdk.tracker.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.transsion.push.PushConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class p {
    private volatile long A;
    private volatile long B;
    private volatile long C;
    private volatile long D;
    private volatile long E;
    private volatile long F;
    private volatile long G;
    private volatile long H;
    private volatile List<InetAddress> I;
    private volatile InetSocketAddress J;
    private volatile Proxy K;
    private volatile com.mbridge.msdk.thrid.okhttp.o L;
    private volatile com.mbridge.msdk.thrid.okhttp.u M;
    private volatile IOException N;
    private volatile Exception P;
    private long R;
    private long S;
    private long T;
    private long U;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f38646d;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f38648f;

    /* renamed from: j, reason: collision with root package name */
    private volatile String f38652j;

    /* renamed from: k, reason: collision with root package name */
    private volatile String f38653k;

    /* renamed from: s, reason: collision with root package name */
    private volatile long f38661s;

    /* renamed from: t, reason: collision with root package name */
    private volatile long f38662t;

    /* renamed from: u, reason: collision with root package name */
    private volatile IOException f38663u;

    /* renamed from: v, reason: collision with root package name */
    private volatile long f38664v;

    /* renamed from: w, reason: collision with root package name */
    private volatile long f38665w;

    /* renamed from: y, reason: collision with root package name */
    private volatile long f38667y;

    /* renamed from: z, reason: collision with root package name */
    private volatile long f38668z;

    /* renamed from: a, reason: collision with root package name */
    protected volatile String f38643a = "";

    /* renamed from: b, reason: collision with root package name */
    private volatile String f38644b = "";

    /* renamed from: c, reason: collision with root package name */
    private volatile String f38645c = "";

    /* renamed from: e, reason: collision with root package name */
    private volatile String f38647e = "";

    /* renamed from: g, reason: collision with root package name */
    private volatile int f38649g = -1;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f38650h = "";

    /* renamed from: i, reason: collision with root package name */
    private volatile int f38651i = -1;

    /* renamed from: l, reason: collision with root package name */
    private volatile String f38654l = "okhttp";

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38655m = false;

    /* renamed from: n, reason: collision with root package name */
    private final AtomicInteger f38656n = new AtomicInteger(0);

    /* renamed from: o, reason: collision with root package name */
    private volatile String f38657o = "";

    /* renamed from: p, reason: collision with root package name */
    private volatile long f38658p = 0;

    /* renamed from: q, reason: collision with root package name */
    private volatile long f38659q = 0;

    /* renamed from: r, reason: collision with root package name */
    private volatile long f38660r = 0;

    /* renamed from: x, reason: collision with root package name */
    private volatile String f38666x = "system";
    private volatile boolean O = false;
    private volatile boolean Q = false;

    public p(String str, String str2) {
        this.f38646d = "";
        this.f38652j = "un_known";
        this.f38653k = "";
        this.f38652j = str;
        this.f38653k = str2;
        this.f38646d = UUID.randomUUID().toString();
    }

    private void P() {
        try {
            JSONObject x10 = x();
            com.mbridge.msdk.tracker.e a11 = a(x10, "m_request_end");
            if (MBridgeConstans.DEBUG) {
                o0.a("NetworkMonitor_" + H(), "request  end  monitor = " + x10.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().d().d(a11);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NetworkMonitor", "reportRequestEnd ", th2);
            }
        }
    }

    private void Q() {
        try {
            JSONObject z10 = z();
            com.mbridge.msdk.tracker.e a11 = a(z10, "m_request_start");
            if (MBridgeConstans.DEBUG) {
                o0.a("NetworkMonitor_" + H(), "request start monitor = " + z10.toString());
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().d().d(a11);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NetworkMonitor", "reportRequestStart ", th2);
            }
        }
    }

    private void T() {
        this.N = null;
        this.f38663u = null;
        this.P = null;
        this.f38661s = 0L;
        this.f38662t = 0L;
        this.f38664v = 0L;
        this.f38665w = 0L;
        this.f38667y = 0L;
        this.f38668z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.f38659q = 0L;
        this.f38660r = 0L;
        this.f38655m = false;
        this.f38649g = -1;
        this.f38651i = -1;
        this.f38650h = "";
        this.f38657o = "";
        this.f38658p = 0L;
        this.Q = false;
    }

    private static com.mbridge.msdk.tracker.e a(JSONObject jSONObject, String str) {
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        eVar.a(0);
        eVar.b(0);
        eVar.a(com.mbridge.msdk.foundation.same.report.c.d());
        eVar.a(jSONObject);
        return eVar;
    }

    private static String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(str2)) {
            str2 = "IOException";
        }
        sb2.append(String.format(str, str2));
        sb2.append(TextUtils.isEmpty(str3) ? "" : str3.replaceAll("[\\n\\r]", " "));
        return sb2.toString();
    }

    private void a(IOException iOException, long j11) {
        if (iOException != null) {
            if (this.f38664v == 0) {
                this.f38664v = j11;
            }
            if (this.f38665w == 0) {
                this.f38665w = j11;
            }
            if (this.f38667y == 0) {
                this.f38667y = j11;
            }
            if (this.f38668z == 0) {
                this.f38668z = j11;
            }
            if (this.A == 0) {
                this.A = j11;
            }
            if (this.B == 0) {
                this.B = j11;
            }
            if (this.C == 0) {
                this.C = j11;
            }
            if (this.D == 0) {
                this.D = j11;
            }
            if (this.E == 0) {
                this.E = j11;
            }
            if (this.F == 0) {
                this.F = j11;
            }
            if (this.G == 0) {
                this.G = j11;
            }
            if (this.H == 0) {
                this.H = j11;
            }
        }
    }

    private JSONObject x() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "m_request_end");
        jSONObject.put("uuid", M());
        jSONObject.put("request_uuid", A());
        jSONObject.put("url", L());
        jSONObject.put("timeout", I());
        jSONObject.put("timeout_connection", e());
        jSONObject.put("timeout_read", s());
        jSONObject.put("timeout_write", N());
        jSONObject.put(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, H());
        jSONObject.put("lrid", n());
        jSONObject.put("method", o());
        jSONObject.put("adtp", b());
        jSONObject.put("http_stack", m());
        jSONObject.put(PushConstants.SP_KEY_RETRY_COUNT, v() - 1);
        jSONObject.put("request_wait_duration", this.f38648f);
        jSONObject.put("duration", j());
        jSONObject.put("request_duration", w());
        jSONObject.put("response_code", E());
        String h11 = h();
        jSONObject.put("dns_result", h11);
        jSONObject.put("dns_status", TextUtils.isEmpty(h11) ? 2 : 1);
        jSONObject.put("is_connection_acquired", O() ? 1 : 0);
        jSONObject.put(PlaceTypes.ADDRESS, c());
        jSONObject.put("port", p());
        jSONObject.put("proxy", r());
        jSONObject.put("protocol", q());
        jSONObject.put("tls_version", J());
        jSONObject.put("content_type", f());
        int G = G();
        jSONObject.put("result", G);
        if (G != 1) {
            jSONObject.put(TrackingKey.ERROR_TYPE, l());
            jSONObject.put("reason", k());
        }
        jSONObject.put("dns_duration", g());
        jSONObject.put("connect_duration", d());
        jSONObject.put("request_header_duration", y());
        jSONObject.put("request_body_duration", t());
        jSONObject.put("request_body_size", u());
        jSONObject.put("response_header_duration", F());
        jSONObject.put("response_body_duration", C());
        jSONObject.put("response_body_size", D());
        jSONObject.put("transmission_duration", K());
        jSONObject.put("current_response_body_size", B());
        jSONObject.put("dns_type", i());
        return jSONObject;
    }

    private JSONObject z() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", "m_request_start");
        jSONObject.put("uuid", M());
        jSONObject.put("request_uuid", A());
        jSONObject.put("lrid", n());
        jSONObject.put("url", L());
        jSONObject.put("timeout", I());
        jSONObject.put("timeout_connection", e());
        jSONObject.put("timeout_read", s());
        jSONObject.put("timeout_write", N());
        jSONObject.put(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, H());
        jSONObject.put("method", o());
        jSONObject.put("adtp", b());
        jSONObject.put("http_stack", m());
        jSONObject.put(PushConstants.SP_KEY_RETRY_COUNT, v() - 1);
        jSONObject.put("request_wait_duration", this.f38648f);
        return jSONObject;
    }

    public String A() {
        return TextUtils.isEmpty(this.f38647e) ? "" : this.f38647e;
    }

    public long B() {
        return this.f38660r;
    }

    public long C() {
        return this.H - this.G;
    }

    public long D() {
        return this.f38659q;
    }

    public int E() {
        return this.f38651i;
    }

    public long F() {
        return this.F - this.E;
    }

    public int G() {
        return this.f38649g;
    }

    public String H() {
        return TextUtils.isEmpty(this.f38652j) ? "un_known" : this.f38652j;
    }

    public long I() {
        return this.R;
    }

    public String J() {
        if (this.L != null) {
            try {
                com.mbridge.msdk.thrid.okhttp.b0 c11 = this.L.c();
                return c11 == null ? "" : c11.a();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "getTlsVersion ", e11);
                }
            }
        }
        return "";
    }

    public long K() {
        return this.E - this.A;
    }

    public String L() {
        return TextUtils.isEmpty(this.f38643a) ? "" : this.f38643a;
    }

    public String M() {
        return TextUtils.isEmpty(this.f38646d) ? "" : this.f38646d;
    }

    public long N() {
        return this.U;
    }

    public boolean O() {
        return this.f38655m;
    }

    public void R() {
        this.C = SystemClock.elapsedRealtime();
    }

    public void S() {
        this.A = SystemClock.elapsedRealtime();
    }

    public void U() {
        this.G = SystemClock.elapsedRealtime();
    }

    public void V() {
        this.E = SystemClock.elapsedRealtime();
    }

    public void W() {
    }

    public void a() {
        this.f38664v = SystemClock.elapsedRealtime();
    }

    public void a(int i11) {
        this.f38649g = i11;
        if (this.Q) {
            this.Q = false;
            P();
        }
    }

    public void a(long j11) {
        this.f38647e = UUID.randomUUID().toString();
        this.f38648f = j11;
        this.f38656n.addAndGet(1);
        T();
        this.Q = true;
        Q();
    }

    public void a(com.mbridge.msdk.thrid.okhttp.d dVar) {
        this.f38661s = SystemClock.elapsedRealtime();
    }

    public void a(com.mbridge.msdk.thrid.okhttp.g gVar) {
        this.f38655m = !this.O;
        if (!this.f38655m || gVar == null) {
            return;
        }
        try {
            this.M = gVar.a();
            com.mbridge.msdk.thrid.okhttp.a0 c11 = gVar.c();
            if (c11 != null) {
                this.J = c11.d();
                this.K = c11.b();
            }
            this.L = gVar.b();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("NetworkMonitor", "connectionAcquired ", e11);
            }
        }
    }

    public void a(com.mbridge.msdk.thrid.okhttp.o oVar) {
        this.L = oVar;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.u uVar, IOException iOException) {
        this.f38668z = SystemClock.elapsedRealtime();
        this.M = uVar;
        this.N = iOException;
    }

    public void a(com.mbridge.msdk.thrid.okhttp.w wVar) {
        this.B = SystemClock.elapsedRealtime();
    }

    public void a(com.mbridge.msdk.thrid.okhttp.y yVar) {
        this.F = SystemClock.elapsedRealtime();
        if (yVar != null) {
            try {
                com.mbridge.msdk.thrid.okhttp.p m11 = yVar.m();
                if (m11 != null) {
                    String b11 = m11.b(HttpHeaders.CONTENT_TYPE);
                    if (TextUtils.isEmpty(b11)) {
                        b11 = "";
                    }
                    b(b11);
                }
            } catch (Exception e11) {
                b(TmcConstants.ROUTE_UNKNOWN);
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "responseHeadersEnd ", e11);
                }
            }
        }
    }

    public void a(IOException iOException) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f38662t = elapsedRealtime;
        this.f38663u = iOException;
        a(iOException, elapsedRealtime);
    }

    public void a(Exception exc) {
        this.P = exc;
    }

    public void a(String str) {
        this.f38645c = str;
    }

    public void a(InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f38667y = SystemClock.elapsedRealtime();
        this.J = inetSocketAddress;
        this.K = proxy;
        this.O = true;
    }

    public void a(List<InetAddress> list) {
        this.f38665w = SystemClock.elapsedRealtime();
        this.I = list;
    }

    public String b() {
        return TextUtils.isEmpty(this.f38645c) ? "" : this.f38645c;
    }

    public void b(int i11) {
        this.f38651i = i11;
    }

    public void b(long j11) {
        this.D = SystemClock.elapsedRealtime();
    }

    public void b(com.mbridge.msdk.thrid.okhttp.g gVar) {
    }

    public void b(String str) {
        this.f38657o = str;
    }

    public String c() {
        if (this.J != null) {
            try {
                InetAddress address = this.J.getAddress();
                if (address == null) {
                    return "";
                }
                String hostAddress = address.getHostAddress();
                return TextUtils.isEmpty(hostAddress) ? "" : hostAddress;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "getAddress ", e11);
                }
            }
        }
        return "";
    }

    public void c(long j11) {
        this.f38660r = j11;
    }

    public void c(String str) {
        this.f38666x = str;
    }

    public long d() {
        return this.f38668z - this.f38667y;
    }

    public void d(long j11) {
        this.H = SystemClock.elapsedRealtime();
    }

    public void d(String str) {
        this.f38650h = str;
    }

    public long e() {
        return this.S;
    }

    public void e(long j11) {
        this.S = j11;
    }

    public void e(String str) {
        this.f38644b = str;
    }

    public String f() {
        return com.mbridge.msdk.foundation.same.d.a(this.f38657o);
    }

    public void f(long j11) {
        this.T = j11;
    }

    public void f(String str) {
        this.f38643a = str;
    }

    public long g() {
        return this.f38665w - this.f38664v;
    }

    public void g(long j11) {
        this.f38658p = j11;
    }

    public String h() {
        if (this.I == null || this.I.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < this.I.size(); i11++) {
            try {
                InetAddress inetAddress = this.I.get(i11);
                if (inetAddress != null) {
                    sb2.append(inetAddress.getHostAddress());
                    if (i11 != this.I.size() - 1) {
                        sb2.append(",");
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("NetworkMonitor", "getDnsResult ", e11);
                }
            }
        }
        return sb2.toString();
    }

    public void h(long j11) {
        this.f38659q = j11;
    }

    public String i() {
        return TextUtils.isEmpty(this.f38666x) ? "system" : this.f38666x;
    }

    public void i(long j11) {
        this.R = j11;
    }

    public long j() {
        return (this.f38662t - this.f38661s) + this.f38648f;
    }

    public void j(long j11) {
        this.U = j11;
    }

    public String k() {
        try {
            if (this.N != null) {
                String name = this.N.getClass().getName();
                String message = this.N.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    return a("connection: %s ", name, message);
                }
            }
            if (this.f38663u != null) {
                String name2 = this.f38663u.getClass().getName();
                String message2 = this.f38663u.getMessage();
                if (!TextUtils.isEmpty(message2)) {
                    return a("call: %s ", name2, message2);
                }
            }
            if (this.P == null) {
                return "un_known";
            }
            String name3 = this.P.getClass().getName();
            String message3 = this.P.getMessage();
            return !TextUtils.isEmpty(message3) ? a("error: %s ", name3, message3) : "un_known";
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return "un_known";
            }
            o0.b("NetworkMonitor", "getError ", e11);
            return "un_known";
        }
    }

    public String l() {
        return this.f38650h;
    }

    public String m() {
        return this.f38654l;
    }

    public String n() {
        return TextUtils.isEmpty(this.f38644b) ? "" : this.f38644b;
    }

    public String o() {
        return TextUtils.isEmpty(this.f38653k) ? "" : this.f38653k;
    }

    public int p() {
        if (this.J != null) {
            return this.J.getPort();
        }
        return -1;
    }

    public String q() {
        return this.M != null ? this.M.toString() : "";
    }

    public String r() {
        Proxy.Type type;
        return (this.K == null || (type = this.K.type()) == null) ? "" : type.toString();
    }

    public long s() {
        return this.T;
    }

    public long t() {
        return this.D - this.C;
    }

    public long u() {
        return this.f38658p;
    }

    public int v() {
        return this.f38656n.getAndAdd(0);
    }

    public long w() {
        return this.f38662t - this.f38661s;
    }

    public long y() {
        return this.B - this.A;
    }
}
