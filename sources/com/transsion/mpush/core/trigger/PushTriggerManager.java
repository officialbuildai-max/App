package com.transsion.mpush.core.trigger;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class PushTriggerManager {

    /* renamed from: a, reason: collision with root package name */
    public static final PushTriggerManager f47648a = new PushTriggerManager();

    /* renamed from: b, reason: collision with root package name */
    private static n0 f47649b = o0.a(l2.b(null, 1, null).plus(y0.a()));

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f47650c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static PushTriggerReceiver f47651d;

    /* renamed from: e, reason: collision with root package name */
    private static b f47652e;

    /* renamed from: f, reason: collision with root package name */
    private static Context f47653f;

    private PushTriggerManager() {
    }

    private final void c(String str) {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.l(c0856a, "M_PUSH_SDK", "【触发管理】收到系统广播，动作：" + str, false, 4, null);
        int hashCode = str.hashCode();
        if (hashCode != -1454123155) {
            if (hashCode != 823795052) {
                a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【触发管理】检测到解锁事件，延迟2秒后触发"}, false, 4, null);
                k.d(f47649b, null, null, new PushTriggerManager$handleBroadcastAction$1(null), 3, null);
                return;
            } else {
                a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【触发管理】检测到解锁事件，延迟2秒后触发"}, false, 4, null);
                k.d(f47649b, null, null, new PushTriggerManager$handleBroadcastAction$1(null), 3, null);
                return;
            }
        }
        if (str.equals("android.intent.action.SCREEN_ON")) {
            a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【触发管理】检测到亮屏事件，触发推送检测"}, false, 4, null);
            g("亮屏", 1);
            return;
        }
        a.C0856a.f(c0856a, "M_PUSH_SDK", "【触发管理】忽略未知的广播动作：" + str, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String action) {
        Intrinsics.h(action, "action");
        f47648a.c(action);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        f47648a.g("网络可用", 3);
        return Unit.f67184a;
    }

    public final void d(Context context) {
        Intrinsics.h(context, "context");
        if (f47650c.compareAndSet(false, true)) {
            f47653f = context.getApplicationContext();
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【触发管理】开始初始化PushTriggerManager", false, 4, null);
            f47651d = new PushTriggerReceiver(new Function1() { // from class: com.transsion.mpush.core.trigger.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit e11;
                    e11 = PushTriggerManager.e((String) obj);
                    return e11;
                }
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                intentFilter.addAction("android.intent.action.USER_UNLOCKED");
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m1185constructorimpl(i11 >= 33 ? context.getApplicationContext().registerReceiver(f47651d, intentFilter, 2) : androidx.core.content.b.registerReceiver(context.getApplicationContext(), f47651d, intentFilter, 2));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            b bVar = new b(applicationContext, new Function0() { // from class: com.transsion.mpush.core.trigger.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit f11;
                    f11 = PushTriggerManager.f();
                    return f11;
                }
            });
            f47652e = bVar;
            bVar.e();
            a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【触发管理】PushTriggerManager初始化成功，广播接收器和网络监听器已注册"}, false, 4, null);
        }
    }

    public final void g(String reason, int i11) {
        Intrinsics.h(reason, "reason");
        if (!f47650c.get()) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【触发管理】triggerPull 忽略：SDK 未初始化或已销毁", false, 4, null);
            return;
        }
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【触发管理】触发推送拉取，原因：" + reason + "，触发源：" + i11}, false, 4, null);
        ln.a.f69101a.m(i11);
    }
}
