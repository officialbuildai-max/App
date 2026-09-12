package com.transsion.fission;

import com.therouter.TheRouter;
import com.transsnet.loginapi.ILoginApi;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    private static FissionConfig f44201c;

    /* renamed from: a, reason: collision with root package name */
    public static final k f44199a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final String f44200b = "FissionManager";

    /* renamed from: d, reason: collision with root package name */
    private static final n0 f44202d = o0.a(y0.b());

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f44203e = LazyKt.b(new Function0() { // from class: com.transsion.fission.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xk.a f11;
            f11 = k.f();
            return f11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f44204f = LazyKt.b(new Function0() { // from class: com.transsion.fission.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi e11;
            e11 = k.e();
            return e11;
        }
    });

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi e() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xk.a f() {
        return (xk.a) zg.c.f79537e.a().h(xk.a.class);
    }

    public final String c() {
        return l.f44205a.b();
    }

    public final FissionConfig d() {
        return f44201c;
    }
}
