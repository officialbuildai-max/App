package com.transsion.baselib.net;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.b0;
import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lh.a;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class i implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f43384b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f43385a = LazyKt.b(new Function0() { // from class: com.transsion.baselib.net.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi d11;
            d11 = i.d();
            return d11;
        }
    });

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String b() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String g11 = b0.g(valueOf);
        a.C0858a c0858a = lh.a.f68965a;
        Intrinsics.e(g11);
        return valueOf + "," + c0858a.a(g11);
    }

    private final ILoginApi c() {
        return (ILoginApi) this.f43385a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi d() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.h(chain, "chain");
        Request request = chain.request();
        ILoginApi c11 = c();
        UserInfo i11 = c11 != null ? c11.i() : null;
        if (i11 == null || TextUtils.isEmpty(i11.getToken())) {
            request = request.newBuilder().header("X-Client-Token", b()).build();
        } else {
            String token = i11.getToken();
            if (token != null) {
                request = request.newBuilder().header(HttpHeaders.AUTHORIZATION, tg.a.f76334a.a(token)).build();
            }
        }
        Response proceed = chain.proceed(request);
        ILoginApi c12 = c();
        if (c12 != null) {
            c12.h(proceed);
        }
        return proceed;
    }
}
