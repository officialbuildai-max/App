package bi;

import android.os.SystemClock;
import androidx.core.view.PointerIconCompat;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;

/* loaded from: classes5.dex */
public final class f extends EventListener implements i {

    /* renamed from: a, reason: collision with root package name */
    private final EventListener f16586a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16587b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16588c;

    /* renamed from: d, reason: collision with root package name */
    private final String f16589d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f16590e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f16591f;

    /* renamed from: g, reason: collision with root package name */
    private long f16592g;

    /* renamed from: h, reason: collision with root package name */
    private long f16593h;

    /* renamed from: i, reason: collision with root package name */
    private long f16594i;

    /* renamed from: j, reason: collision with root package name */
    private long f16595j;

    /* renamed from: k, reason: collision with root package name */
    private long f16596k;

    /* renamed from: l, reason: collision with root package name */
    private long f16597l;

    /* renamed from: m, reason: collision with root package name */
    private long f16598m;

    /* renamed from: n, reason: collision with root package name */
    private long f16599n;

    /* renamed from: o, reason: collision with root package name */
    private final e f16600o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f16601p;

    /* renamed from: q, reason: collision with root package name */
    private long f16602q;

    /* renamed from: r, reason: collision with root package name */
    private int f16603r;

    /* renamed from: s, reason: collision with root package name */
    private int f16604s;

    /* renamed from: t, reason: collision with root package name */
    private String f16605t;

    /* renamed from: u, reason: collision with root package name */
    private final int f16606u;

    public f(EventListener eventListener, int i11, boolean z10, String str, boolean z11, String str2, boolean z12, boolean z13) {
        this.f16586a = eventListener;
        this.f16587b = i11;
        this.f16588c = z10;
        this.f16589d = str2;
        this.f16590e = z12;
        this.f16591f = z13;
        this.f16600o = e.J.a(i11, str);
        this.f16601p = z10 || z11;
        this.f16603r = 480;
        this.f16604s = 480;
        this.f16605t = "Unknown";
        this.f16606u = RangesKt.q(new IntRange(1, 10), Random.INSTANCE);
    }

    private final boolean b() {
        k kVar = k.f16616a;
        return kVar.f() || SystemClock.uptimeMillis() - kVar.b() > 3000;
    }

    @Override // bi.i
    public void a(Request request, int i11) {
        Intrinsics.h(request, "request");
        c.c("[onDowngrade]");
        if (!this.f16588c) {
            this.f16601p = false;
        }
        this.f16600o.d0(i11);
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.h(call, "call");
        super.callEnd(call);
        c.c("[callEnd]");
        e eVar = this.f16600o;
        eVar.I(1);
        eVar.c0(c.e(this.f16592g));
        eVar.S(this.f16603r);
        if (eVar.m() != 304 && !this.f16601p) {
            c.g(eVar);
        }
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(ioe, "ioe");
        super.callFailed(call, ioe);
        c.b("[callFailed]  " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        this.f16600o.I(2);
        if (b()) {
            k kVar = k.f16616a;
            if (!kVar.g()) {
                this.f16604s = PointerIconCompat.TYPE_GRAB;
                this.f16605t = "Network disconnect";
            } else if (kVar.e()) {
                this.f16604s = PointerIconCompat.TYPE_GRABBING;
                this.f16605t = "Fake Network";
            } else {
                this.f16604s = a.f16554a.a(this.f16603r, ioe);
            }
        } else {
            this.f16604s = a.f16554a.a(this.f16603r, ioe);
        }
        this.f16600o.S(this.f16604s);
        this.f16600o.T(Intrinsics.c(this.f16605t, "Unknown") ? c.f(ioe) : this.f16605t);
        if (!this.f16601p) {
            if ((this.f16591f && this.f16604s == 1020) ? false : (this.f16590e && this.f16604s == 1050) ? false : true) {
                c.g(this.f16600o);
            }
        }
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.callFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        int i11;
        Intrinsics.h(call, "call");
        super.callStart(call);
        c.c("[callStart]");
        try {
            String str = call.request().headers().get("isDownload");
            if (str != null) {
                e eVar = this.f16600o;
                if (!Intrinsics.c(str, "true") && !Intrinsics.c(str, "T")) {
                    i11 = 0;
                    eVar.l0(i11);
                }
                i11 = 1;
                eVar.l0(i11);
            }
            String str2 = call.request().headers().get("offlineAd");
            if (str2 != null) {
                this.f16600o.X(Integer.parseInt(str2));
            }
            String host = call.request().url().host();
            String encodedPath = call.request().url().encodedPath();
            e eVar2 = this.f16600o;
            String str3 = "";
            if (encodedPath == null) {
                encodedPath = "";
            }
            eVar2.Y(encodedPath);
            e eVar3 = this.f16600o;
            if (host == null) {
                host = "";
            }
            eVar3.U(host);
            String url = call.request().url().getUrl();
            Intrinsics.g(url, "call.request().url().toString()");
            this.f16600o.P(this.f16606u <= 2 ? url : "");
            e eVar4 = this.f16600o;
            if (this.f16587b == 0 && StringsKt.c0(url, UrlUtils.QUESTION_MARK, false, 2, null)) {
                url = url.substring(0, StringsKt.o0(url, UrlUtils.QUESTION_MARK, 0, false, 6, null));
                Intrinsics.g(url, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            eVar4.g0(url);
            String str4 = call.request().headers().get("infoeyes-tag");
            e eVar5 = this.f16600o;
            if (str4 != null || (str4 = this.f16589d) != null) {
                str3 = str4;
            }
            eVar5.O(str3);
        } catch (Exception e11) {
            c.b("[get header exception] " + e11.getClass().getSimpleName() + " : " + e11.getMessage());
        }
        this.f16592g = c.d();
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        String str;
        Intrinsics.h(call, "call");
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        c.c("[connectEnd] inetSocketAddress " + inetSocketAddress);
        this.f16600o.j0(c.e(this.f16595j));
        e eVar = this.f16600o;
        if (protocol == null || (str = protocol.name()) == null) {
            str = "";
        }
        eVar.Z(str);
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        String str;
        Intrinsics.h(call, "call");
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        Intrinsics.h(ioe, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        c.b("[connectFailed] " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        e eVar = this.f16600o;
        if (protocol == null || (str = protocol.name()) == null) {
            str = "";
        }
        eVar.Z(str);
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.h(call, "call");
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        this.f16595j = c.d();
        e eVar = this.f16600o;
        String hostAddress = inetSocketAddress.getAddress().getHostAddress();
        if (hostAddress == null) {
            hostAddress = "";
        }
        eVar.W(hostAddress);
        c.c("[connectStart] inetSocketAddress : " + inetSocketAddress + ", proxy : " + proxy);
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        String str;
        TlsVersion tlsVersion;
        Intrinsics.h(call, "call");
        Intrinsics.h(connection, "connection");
        super.connectionAcquired(call, connection);
        c.c("[connectionAcquired] connection: " + connection);
        e eVar = this.f16600o;
        Handshake handshake = connection.getHandshake();
        if (handshake == null || (tlsVersion = handshake.tlsVersion()) == null || (str = tlsVersion.name()) == null) {
            str = "";
        }
        eVar.k0(str);
        this.f16600o.Z(connection.protocol().name());
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.h(call, "call");
        Intrinsics.h(connection, "connection");
        super.connectionReleased(call, connection);
        c.c("[connectionReleased]");
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String domainName, List inetAddressList) {
        Intrinsics.h(call, "call");
        Intrinsics.h(domainName, "domainName");
        Intrinsics.h(inetAddressList, "inetAddressList");
        super.dnsEnd(call, domainName, inetAddressList);
        c.c("[dnsEnd] inetAddressList " + CollectionsKt.s0(inetAddressList, ",", "[", "]", 0, null, null, 56, null));
        this.f16600o.R(c.e(this.f16593h));
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.dnsEnd(call, domainName, inetAddressList);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String domainName) {
        Intrinsics.h(call, "call");
        Intrinsics.h(domainName, "domainName");
        super.dnsStart(call, domainName);
        c.c("[dnsStart] domainName: " + domainName);
        this.f16593h = c.d();
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.dnsStart(call, domainName);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j11) {
        Intrinsics.h(call, "call");
        super.requestBodyEnd(call, j11);
        c.c("[requestBodyEnd] byteCount: " + j11);
        this.f16598m = c.d();
        e eVar = this.f16600o;
        eVar.b0(j11);
        eVar.f0(this.f16598m - this.f16596k);
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j11);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.h(call, "call");
        super.requestBodyStart(call);
        c.c("[requestBodyStart]");
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(ioe, "ioe");
        super.requestFailed(call, ioe);
        c.b("[requestFailed] " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.requestFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.h(call, "call");
        Intrinsics.h(request, "request");
        super.requestHeadersEnd(call, request);
        c.c("[requestHeadersEnd] request :" + request);
        long d11 = c.d();
        this.f16597l = d11;
        this.f16600o.f0(d11 - this.f16596k);
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.h(call, "call");
        super.requestHeadersStart(call);
        c.c("[requestHeadersStart]");
        this.f16596k = c.d();
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j11) {
        Intrinsics.h(call, "call");
        super.responseBodyEnd(call, j11);
        c.c("[responseBodyEnd] byteCount: " + j11);
        e eVar = this.f16600o;
        eVar.e0(j11);
        eVar.a0(c.e(this.f16599n));
        eVar.J(c.e(this.f16602q));
        eVar.M(String.valueOf((((float) j11) / 1024.0f) / (((float) eVar.c()) / 1000.0f)));
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j11);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.h(call, "call");
        super.responseBodyStart(call);
        c.c("[responseBodyStart]");
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(ioe, "ioe");
        super.responseFailed(call, ioe);
        c.b("[responseFailed] " + ioe.getClass().getSimpleName() + " : " + ioe.getMessage());
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.responseFailed(call, ioe);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.h(call, "call");
        Intrinsics.h(response, "response");
        super.responseHeadersEnd(call, response);
        c.c("[responseHeadersEnd] code : " + response.code());
        String str = response.headers().get("x-response-cdn");
        if (str == null) {
            str = "";
        }
        String str2 = response.headers().get("server-time");
        if (str2 == null) {
            str2 = "0";
        }
        long parseLong = Long.parseLong(str2);
        c.c(str);
        this.f16600o.K(str);
        this.f16602q = c.d();
        this.f16600o.a0(c.e(this.f16599n));
        this.f16600o.L(c.e(this.f16592g));
        this.f16600o.h0(parseLong);
        this.f16603r = response.code();
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Intrinsics.h(call, "call");
        super.responseHeadersStart(call);
        c.c("[responseHeadersStart]");
        long d11 = c.d();
        this.f16599n = d11;
        this.f16600o.m0(d11 - Math.max(this.f16598m, this.f16597l));
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        String str;
        TlsVersion tlsVersion;
        Intrinsics.h(call, "call");
        super.secureConnectEnd(call, handshake);
        c.c("[secureConnectEnd]");
        e eVar = this.f16600o;
        if (handshake == null || (tlsVersion = handshake.tlsVersion()) == null || (str = tlsVersion.name()) == null) {
            str = "";
        }
        eVar.k0(str);
        this.f16600o.i0(c.e(this.f16594i));
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.h(call, "call");
        super.secureConnectStart(call);
        c.c("[secureConnectStart]");
        this.f16594i = c.d();
        EventListener eventListener = this.f16586a;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }
}
