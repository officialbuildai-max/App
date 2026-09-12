package bi;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Request;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f16615a = new h();

    private h() {
    }

    private final i b(Interceptor.Chain chain) {
        m mVar = m.f16625a;
        Call call = chain.call();
        Intrinsics.g(call, "chain.call()");
        Object a11 = mVar.a(call, "eventListener");
        if (a11 instanceof i) {
            return (i) a11;
        }
        return null;
    }

    public final void a(Interceptor.Chain chain, Request buildRequest, int i11) {
        Intrinsics.h(chain, "chain");
        Intrinsics.h(buildRequest, "buildRequest");
        i b11 = b(chain);
        if (b11 != null) {
            b11.a(buildRequest, i11);
        }
    }
}
