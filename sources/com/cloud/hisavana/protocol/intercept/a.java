package com.cloud.hisavana.protocol.intercept;

import bi.h;
import com.cloud.sdk.commonutil.util.c;
import java.net.UnknownHostException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public final class a implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final Map f21522a;

    public a(Map hostMap) {
        Intrinsics.h(hostMap, "hostMap");
        this.f21522a = hostMap;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        try {
            Response proceed = chain.proceed(chain.request());
            Intrinsics.g(proceed, "proceed(...)");
            return proceed;
        } catch (Exception e11) {
            HttpUrl url = chain.request().url();
            String str = (String) this.f21522a.get(url.host());
            if (str == null || !(e11 instanceof UnknownHostException)) {
                throw e11;
            }
            Request build = chain.request().newBuilder().url(url.newBuilder().host(str).build()).build();
            c.netLog("request downgrade, domain failed, failed url is:" + chain.request().url());
            h hVar = h.f16615a;
            Intrinsics.e(build);
            hVar.a(chain, build, 1005);
            Response proceed2 = chain.proceed(build);
            Intrinsics.g(proceed2, "proceed(...)");
            return proceed2;
        }
    }
}
