package com.tn.tranpay;

import android.content.Context;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.tn.tranpay.activity.TranPayTransparentActivity;
import com.tn.tranpay.fragment.PayLoadingFragment;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class TranPayClient {

    /* renamed from: a, reason: collision with root package name */
    public static final TranPayClient f41542a = new TranPayClient();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f41543b;

    private TranPayClient() {
    }

    public final void b(Context context, BillingParams params, d callback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
        Intrinsics.h(callback, "callback");
        if (!Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            ai.a.e(ai.a.f694a, "TranPayClient: launchBillingFlow(context) must be called on the main thread, call ignored", null, 2, null);
            return;
        }
        if (!TranPayConfiguration.f41544a.q()) {
            ai.a.e(ai.a.f694a, "TranPay must be initialized!", null, 2, null);
            callback.a(new b(-1, "TranPay must be initialized!"), null);
            return;
        }
        if (!com.tn.tranpay.helper.b.f41705a.a()) {
            ai.a.e(ai.a.f694a, "Network is not available!", null, 2, null);
            callback.a(new b(-2, "Network is not available. Please check your network connection."), null);
        } else {
            if (f41543b) {
                return;
            }
            ai.a.g(ai.a.f694a, "launchBillingFlow with context and params is " + params, null, 2, null);
            f41543b = true;
            TranPayTransparentActivity.INSTANCE.a(context, params, callback);
        }
    }

    public final void c(AppCompatActivity activity, BillingParams params, d callback) {
        Object m1185constructorimpl;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(params, "params");
        Intrinsics.h(callback, "callback");
        if (!Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            ai.a.e(ai.a.f694a, "TranPayClient: launchBillingFlow(activity) must be called on the main thread, call ignored", null, 2, null);
            return;
        }
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f41544a;
        if (!tranPayConfiguration.q()) {
            ai.a.e(ai.a.f694a, "TranPay must be initialized!", null, 2, null);
            callback.a(new b(-1, "TranPay must be initialized!"), null);
            return;
        }
        if (!com.tn.tranpay.helper.b.f41705a.a()) {
            ai.a.e(ai.a.f694a, "Network is not available!", null, 2, null);
            callback.a(new b(-2, "Network is not available. Please check your network connection."), null);
            return;
        }
        if (f41543b || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        ai.a.g(ai.a.f694a, "launchBillingFlow and params is " + params, null, 2, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            PayLoadingFragment a11 = PayLoadingFragment.INSTANCE.a(params, callback);
            a11.show(activity.getSupportFragmentManager(), "pay_loading_fragment");
            f41543b = true;
            a11.n0(new Function0<Unit>() { // from class: com.tn.tranpay.TranPayClient$launchBillingFlow$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m861invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m861invoke() {
                    TranPayClient.f41543b = false;
                }
            });
            tranPayConfiguration.D(params);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            ai.a.e(ai.a.f694a, "launchBillingFlow(activity) failed: " + m1188exceptionOrNullimpl.getMessage(), null, 2, null);
            f41543b = false;
            callback.a(new b(-1, "Failed to show payment dialog"), null);
        }
    }

    public final void d(final AppCompatActivity activity, BillingParams params, d callback) {
        Object m1185constructorimpl;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(params, "params");
        Intrinsics.h(callback, "callback");
        if (activity.isFinishing() || activity.isDestroyed()) {
            e();
            return;
        }
        ai.a.g(ai.a.f694a, "launchBillingFlowInternal and params is " + params, null, 2, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            PayLoadingFragment a11 = PayLoadingFragment.INSTANCE.a(params, callback);
            a11.setCancelable(false);
            a11.m0(new Function0<Unit>() { // from class: com.tn.tranpay.TranPayClient$launchBillingFlowInternal$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m862invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m862invoke() {
                    AppCompatActivity.this.getOnBackPressedDispatcher().l();
                }
            });
            a11.show(activity.getSupportFragmentManager(), "pay_loading_fragment");
            a11.n0(new Function0<Unit>() { // from class: com.tn.tranpay.TranPayClient$launchBillingFlowInternal$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m863invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m863invoke() {
                    TranPayClient.f41543b = false;
                }
            });
            TranPayConfiguration.f41544a.D(params);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            ai.a.e(ai.a.f694a, "launchBillingFlowInternal failed: " + m1188exceptionOrNullimpl.getMessage(), null, 2, null);
            f41542a.e();
            callback.a(new b(-1, "Failed to show payment dialog"), null);
        }
    }

    public final void e() {
        f41543b = false;
    }
}
