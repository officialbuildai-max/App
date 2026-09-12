package zv;

import android.util.Log;
import com.transsion.gslb.GslbSdk;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes7.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Response response;
        Intrinsics.h(chain, "chain");
        try {
            Request request = chain.request();
            String url = request.url().getUrl();
            Intrinsics.g(url, "toString(...)");
            yv.c.f79183d.a();
            Intrinsics.h(url, "url");
            if (GslbSdk.isInitSuccess(url)) {
                url = GslbSdk.getDomain(url, true);
                Intrinsics.e(url);
            }
            String msg = "replace gslb: " + url;
            Intrinsics.h("DomainChangeInterceptor", "tag");
            Intrinsics.h(msg, "msg");
            long currentTimeMillis = System.currentTimeMillis();
            if (!bw.g.f17021a && currentTimeMillis - bw.g.f17022b >= 5000) {
                bw.g.f17022b = currentTimeMillis;
                if (Log.isLoggable("upgradeSdkLog", 3)) {
                    bw.g.f17021a = true;
                }
                boolean z10 = bw.g.f17021a;
            }
            boolean z11 = yv.f.f79190o.a().f79195d;
            Request.Builder url2 = request.newBuilder().url(url);
            Intrinsics.g(url2, "url(...)");
            response = chain.withConnectTimeout(30, TimeUnit.SECONDS).proceed(url2.build());
        } catch (Exception e11) {
            String msg2 = "error1: " + e11;
            Intrinsics.h("DomainChangeInterceptor", "tag");
            Intrinsics.h(msg2, "msg");
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!bw.g.f17021a && currentTimeMillis2 - bw.g.f17022b >= 5000) {
                bw.g.f17022b = currentTimeMillis2;
                if (Log.isLoggable("upgradeSdkLog", 3)) {
                    bw.g.f17021a = true;
                }
                boolean z12 = bw.g.f17021a;
            }
            boolean z13 = yv.f.f79190o.a().f79195d;
            try {
                response = chain.proceed(chain.request());
            } catch (Exception unused) {
                response = null;
            }
        }
        if (response == null) {
            response = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(400).message("Internal Error").body(ResponseBody.create((MediaType) null, "The requested resource was not found.")).build();
        }
        Intrinsics.e(response);
        return response;
    }
}
