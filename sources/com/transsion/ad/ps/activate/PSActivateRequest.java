package com.transsion.ad.ps.activate;

import android.os.SystemClock;
import com.transsion.ad.MBAd;
import com.transsion.ad.strategy.t;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import zg.c;

/* loaded from: classes5.dex */
public final class PSActivateRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final PSActivateRequest f42227a = new PSActivateRequest();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42228b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.activate.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qi.a j11;
            j11 = PSActivateRequest.j();
            return j11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f42229c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static long f42230d;

    private PSActivateRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        String simpleName = PSActivateRequest.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qi.a i() {
        return (qi.a) f42228b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.a j() {
        return (qi.a) c.f79537e.a().h(qi.a.class);
    }

    public final Object g(Continuation continuation) {
        Object h11 = h(false, continuation);
        return h11 == IntrinsicsKt.f() ? h11 : Unit.f67184a;
    }

    public final Object h(boolean z10, Continuation continuation) {
        MBAd mBAd = MBAd.f41805a;
        MBAd.a c11 = mBAd.c();
        if (c11 != null && !c11.j()) {
            oi.a aVar = oi.a.f71145a;
            String f11 = f();
            MBAd.a c12 = mBAd.c();
            oi.a.m(aVar, f11 + " --> getPsActivateList() --> openPsActivateAd = " + (c12 != null ? Boxing.a(c12.j()) : null) + " --> 没有开启PS激活广告，直接返回", 0, false, 6, null);
            return Unit.f67184a;
        }
        if (t.f42302a.a()) {
            oi.a.m(oi.a.f71145a, f() + " --> getPsActivateList() --> 青少年模式不请求激活广告", 0, false, 6, null);
            return Unit.f67184a;
        }
        AtomicBoolean atomicBoolean = f42229c;
        if (atomicBoolean.get()) {
            oi.a.m(oi.a.f71145a, f() + " --> getPsActivateList() --> isRequesting = " + atomicBoolean, 0, false, 6, null);
            return Unit.f67184a;
        }
        atomicBoolean.set(true);
        if (z10 || f42230d <= 0 || SystemClock.elapsedRealtime() - f42230d >= 7200000) {
            f42230d = SystemClock.elapsedRealtime();
            Object g11 = i.g(y0.b(), new PSActivateRequest$getPsActivateList$3(null), continuation);
            return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
        }
        oi.a.m(oi.a.f71145a, f() + " --> getPsActivateList() --> 两次请求小于2H，skipIntervalCheck = " + z10, 0, false, 6, null);
        atomicBoolean.set(false);
        return Unit.f67184a;
    }
}
