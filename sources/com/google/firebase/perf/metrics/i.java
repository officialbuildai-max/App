package com.google.firebase.perf.metrics;

import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import vc.k;

/* loaded from: classes4.dex */
public final class i extends com.google.firebase.perf.application.b implements com.google.firebase.perf.session.a {

    /* renamed from: i, reason: collision with root package name */
    private static final sc.a f32355i = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final List f32356a;

    /* renamed from: b, reason: collision with root package name */
    private final GaugeManager f32357b;

    /* renamed from: c, reason: collision with root package name */
    private final k f32358c;

    /* renamed from: d, reason: collision with root package name */
    private final NetworkRequestMetric.b f32359d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference f32360e;

    /* renamed from: f, reason: collision with root package name */
    private String f32361f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32362g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f32363h;

    private i(k kVar) {
        this(kVar, com.google.firebase.perf.application.a.b(), GaugeManager.getInstance());
    }

    public i(k kVar, com.google.firebase.perf.application.a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.f32359d = NetworkRequestMetric.R();
        this.f32360e = new WeakReference(this);
        this.f32358c = kVar;
        this.f32357b = gaugeManager;
        this.f32356a = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }

    public static i b(k kVar) {
        return new i(kVar);
    }

    private static boolean e(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStarted() {
        return this.f32359d.k();
    }

    private boolean isStopped() {
        return this.f32359d.m();
    }

    public NetworkRequestMetric a() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.f32360e);
        unregisterForAppState();
        com.google.firebase.perf.v1.h[] buildAndSort = PerfSession.buildAndSort(getSessions());
        if (buildAndSort != null) {
            this.f32359d.d(Arrays.asList(buildAndSort));
        }
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) this.f32359d.build();
        if (!uc.f.c(this.f32361f)) {
            f32355i.a("Dropping network request from a 'User-Agent' that is not allowed");
            return networkRequestMetric;
        }
        if (this.f32362g) {
            if (this.f32363h) {
                f32355i.a("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return networkRequestMetric;
        }
        this.f32358c.B(networkRequestMetric, getAppState());
        this.f32362g = true;
        return networkRequestMetric;
    }

    public long c() {
        return this.f32359d.j();
    }

    public boolean d() {
        return this.f32359d.l();
    }

    public i f(String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c11 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals("TRACE")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c11 = '\b';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case '\b':
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.f32359d.o(httpMethod);
        }
        return this;
    }

    public i g(int i11) {
        this.f32359d.p(i11);
        return this;
    }

    List getSessions() {
        List unmodifiableList;
        synchronized (this.f32356a) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PerfSession perfSession : this.f32356a) {
                    if (perfSession != null) {
                        arrayList.add(perfSession);
                    }
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return unmodifiableList;
    }

    public void h() {
        this.f32363h = true;
    }

    public i i() {
        this.f32359d.q(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public i j(long j11) {
        this.f32359d.r(j11);
        return this;
    }

    public i k(long j11) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.f32360e);
        this.f32359d.n(j11);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.f32357b.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public i l(String str) {
        if (str == null) {
            this.f32359d.i();
            return this;
        }
        if (e(str)) {
            this.f32359d.s(str);
        } else {
            f32355i.j("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public i m(long j11) {
        this.f32359d.t(j11);
        return this;
    }

    public i n(long j11) {
        this.f32359d.u(j11);
        return this;
    }

    public i o(long j11) {
        this.f32359d.v(j11);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.f32357b.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public i p(long j11) {
        this.f32359d.w(j11);
        return this;
    }

    public i q(String str) {
        if (str != null) {
            this.f32359d.x(com.google.firebase.perf.util.k.e(com.google.firebase.perf.util.k.d(str), 2000));
        }
        return this;
    }

    public i r(String str) {
        this.f32361f = str;
        return this;
    }

    @Override // com.google.firebase.perf.session.a
    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            f32355i.j("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else {
            if (!hasStarted() || isStopped()) {
                return;
            }
            this.f32356a.add(perfSession);
        }
    }
}
