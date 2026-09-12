package yg;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import yg.b;

/* loaded from: classes3.dex */
public final class c implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final String f79138a = "HeaderInterceptor";

    private final Request a(Request request, String str) {
        b.a aVar = b.f79132a;
        String c11 = aVar.c();
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.addHeader("X-Client-Info", c11);
        newBuilder.addHeader("X-Client-Status", String.valueOf(!Intrinsics.c(aVar.d(), Boolean.TRUE) ? 1 : 0));
        return newBuilder.build();
    }

    private final Request b(Request request) {
        Map f11 = b.f79132a.f();
        if (f11.isEmpty()) {
            return request;
        }
        Request.Builder newBuilder = request.newBuilder();
        for (Map.Entry entry : f11.entrySet()) {
            newBuilder.header((String) entry.getKey(), (String) entry.getValue());
        }
        return newBuilder.build();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        return chain.proceed(a(b(chain.request()), ""));
    }
}
