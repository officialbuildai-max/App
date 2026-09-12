package com.cloud.hisavana.protocol.intercept;

import bi.g;
import bi.h;
import com.cloud.sdk.commonutil.util.c;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.chromium.net.CronetEngine;
import w6.b;

/* loaded from: classes3.dex */
public final class CronetRetryInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final com.cloud.hisavana.protocol.okhttptransport.a f21512a;

    /* renamed from: b, reason: collision with root package name */
    private final w6.a f21513b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f21514c;

    /* renamed from: d, reason: collision with root package name */
    private g f21515d;

    /* renamed from: e, reason: collision with root package name */
    private b f21516e;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final com.cloud.hisavana.protocol.okhttptransport.a f21517a;

        /* renamed from: b, reason: collision with root package name */
        private final w6.a f21518b;

        /* renamed from: c, reason: collision with root package name */
        private Map f21519c;

        /* renamed from: d, reason: collision with root package name */
        private g f21520d;

        /* renamed from: e, reason: collision with root package name */
        private b f21521e;

        public a(CronetEngine engine) {
            Intrinsics.h(engine, "engine");
            Object a11 = com.cloud.hisavana.protocol.okhttptransport.a.i(engine).a();
            Intrinsics.g(a11, "build(...)");
            this.f21517a = (com.cloud.hisavana.protocol.okhttptransport.a) a11;
            this.f21518b = new w6.a();
        }

        public final CronetRetryInterceptor a() {
            return new CronetRetryInterceptor(this, null);
        }

        public final a b(g gVar) {
            if (gVar == null) {
                return this;
            }
            gVar.b(true);
            this.f21520d = gVar;
            return this;
        }

        public final com.cloud.hisavana.protocol.okhttptransport.a c() {
            return this.f21517a;
        }

        public final w6.a d() {
            return this.f21518b;
        }

        public final b e() {
            return this.f21521e;
        }

        public final g f() {
            return this.f21520d;
        }

        public final Map g() {
            return this.f21519c;
        }

        public final a h(b policy) {
            Intrinsics.h(policy, "policy");
            this.f21521e = policy;
            return this;
        }

        public final a i(Map map) {
            this.f21519c = map;
            return this;
        }
    }

    private CronetRetryInterceptor(a aVar) {
        this.f21512a = aVar.c();
        this.f21513b = aVar.d();
        this.f21514c = aVar.g();
        this.f21515d = aVar.f();
        this.f21516e = aVar.e();
    }

    public /* synthetic */ CronetRetryInterceptor(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    private final Request b(Request request) {
        HttpUrl url = request.url();
        String host = url.host();
        Map map = this.f21514c;
        String str = map != null ? (String) map.get(host) : null;
        if (str == null) {
            return request;
        }
        Request build = request.newBuilder().url(url.newBuilder().host(str).build()).build();
        Intrinsics.e(build);
        return build;
    }

    private final Response c(Response response, int i11, Interceptor.Chain chain) {
        if (!x6.a.a(response)) {
            return response;
        }
        h();
        return i11 != -1 ? f(chain, i11) : response;
    }

    private final Response d(Response response, Interceptor.Chain chain, int i11, b bVar) {
        if (i11 == -1 || !bVar.a(i11)) {
            return response;
        }
        h();
        return f(chain, i11);
    }

    private final Response e(Interceptor.Chain chain, int i11) {
        h();
        return f(chain, i11);
    }

    private final Response f(Interceptor.Chain chain, int i11) {
        Request request = chain.request();
        Intrinsics.g(request, "request(...)");
        Request b11 = b(request);
        h.f16615a.a(chain, b11, i11);
        Response proceed = chain.proceed(b11);
        Intrinsics.g(proceed, "proceed(...)");
        return proceed;
    }

    private final void g() {
        this.f21513b.b();
    }

    private final void h() {
        this.f21513b.c(new Function0<Unit>() { // from class: com.cloud.hisavana.protocol.intercept.CronetRetryInterceptor$triggerDownCount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m678invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m678invoke() {
                g gVar;
                gVar = CronetRetryInterceptor.this.f21515d;
                if (gVar != null) {
                    gVar.b(false);
                }
            }
        });
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        if (this.f21513b.a()) {
            c.netLog("request downgrade, cause failed count exceed limit, failed url is:" + chain.request().url());
            Request request = chain.request();
            Intrinsics.g(request, "request(...)");
            Response proceed = chain.proceed(b(request));
            Intrinsics.g(proceed, "proceed(...)");
            return proceed;
        }
        try {
            Response intercept = this.f21512a.intercept(chain);
            if (intercept.isSuccessful()) {
                g();
                Intrinsics.e(intercept);
                return intercept;
            }
            c.netLog("request downgrade, cause domain failed1, failed url is:" + chain.request().url());
            Intrinsics.e(intercept);
            int c11 = x6.a.c(intercept);
            b bVar = this.f21516e;
            return bVar != null ? d(intercept, chain, c11, bVar) : c(intercept, c11, chain);
        } catch (Exception e11) {
            int b11 = x6.a.b(e11);
            if (b11 == -1) {
                throw e11;
            }
            c.netLog("request downgrade, cause domain failed, failed url is:" + chain.request().url());
            b bVar2 = this.f21516e;
            if (bVar2 != null && !bVar2.a(b11)) {
                throw e11;
            }
            return e(chain, b11);
        }
    }
}
