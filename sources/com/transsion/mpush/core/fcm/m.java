package com.transsion.mpush.core.fcm;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.transsion.push.PushManager;
import com.transsion.push.TPushListener;
import com.transsion.push.bean.PushMessage;
import com.transsion.push.bean.PushNotification;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f47566b;

    /* renamed from: g, reason: collision with root package name */
    private static Function0 f47571g;

    /* renamed from: a, reason: collision with root package name */
    public static final m f47565a = new m();

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f47567c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f47568d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f47569e = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.fcm.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FCMPushHelper k11;
            k11 = m.k();
            return k11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f47570f = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.fcm.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            OnCompleteListener i11;
            i11 = m.i();
            return i11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a implements TPushListener {
        a() {
        }

        @Override // com.transsion.push.TPushListener
        public void onClickException(long j11, String str) {
            lg.a.f68962a.c("FirebasePush", "onClickException msgId " + j11 + " reason " + str, true);
        }

        @Override // com.transsion.push.TPushListener
        public void onMessageReceive(long j11, String str, int i11) {
            ln.a.f69101a.l(String.valueOf(j11), str);
        }

        @Override // com.transsion.push.TPushListener
        public void onNotificationShow(long j11, String str) {
            a.C0856a.f(lg.a.f68962a, "FirebasePush", "onNotificationShow msgId " + j11 + " landingPage " + str, false, 4, null);
        }

        @Override // com.transsion.push.TPushListener
        public void onPushReceive(long j11, PushMessage pushMessage, int i11) {
        }

        @Override // com.transsion.push.TPushListener
        public void onSdkInitSuccess(String str, String str2) {
            a.C0856a.f(lg.a.f68962a, "FirebasePush", "onSdkInitSuccess clientId " + str + "  token " + str2, false, 4, null);
            m mVar = m.f47565a;
            mVar.u(str == null ? "" : str);
            mVar.v(str2 != null ? str2 : "");
            mVar.n().w(str, str2);
        }
    }

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnCompleteListener i() {
        return new OnCompleteListener() { // from class: com.transsion.mpush.core.fcm.j
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                m.j(task);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Task task) {
        Intrinsics.h(task, "task");
        if (!task.isSuccessful()) {
            a.C0856a.f(lg.a.f68962a, "FirebasePush", "firebase token getFailed " + task.getException(), false, 4, null);
            return;
        }
        String str = (String) task.getResult();
        if (str == null) {
            str = "";
        }
        f47568d = str;
        a.C0856a.f(lg.a.f68962a, "FirebasePush", "firebase token " + str, false, 4, null);
        f47565a.n().v(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FCMPushHelper k() {
        return new FCMPushHelper();
    }

    private final OnCompleteListener m() {
        return (OnCompleteListener) f47570f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FCMPushHelper n() {
        return (FCMPushHelper) f47569e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(String str, Function1 function1, Task task) {
        Intrinsics.h(task, "task");
        a.C0856a.f(lg.a.f68962a, "FirebasePush", "registerTopic " + str + " isSuccessful:" + task.isSuccessful(), false, 4, null);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(task.isSuccessful()));
        }
    }

    private final void w(Context context) {
        PushManager.getInstance().addCustomNotification(new PushNotification.Builder().setSmallIcon(ln.a.f69101a.i().getSmallIconRes()).setType(1).setShowDefaultLargeIcon(false).build());
        FirebaseMessaging.p().s().addOnCompleteListener(m());
        PushManager.getInstance().init(context);
        PushManager.getInstance().registerPushListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String str, Task task) {
        Intrinsics.h(task, "task");
        a.C0856a.f(lg.a.f68962a, "FirebasePush", "unregisterTopic " + str + " isSuccessful:" + task.isSuccessful(), false, 4, null);
    }

    public final void g(Function0 function0) {
        f47571g = function0;
    }

    public final void h() {
        n().p();
    }

    public final String l() {
        return f47567c;
    }

    public final String o() {
        return f47568d;
    }

    public final Function0 p() {
        return f47571g;
    }

    public final m q(Application context) {
        Object m1185constructorimpl;
        Intrinsics.h(context, "context");
        if (f47566b) {
            a.C0856a.f(lg.a.f68962a, "FirebasePush", "firebase already initialized", false, 4, null);
            return this;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            w(context);
            n().t(context);
            f47566b = true;
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.f(lg.a.f68962a, "FirebasePush", "firebase onFailure error " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
        return this;
    }

    public final m r(Application context, Function0 function0) {
        Intrinsics.h(context, "context");
        g(function0);
        return q(context);
    }

    public final void s(final String topic, final Function1 function1) {
        Intrinsics.h(topic, "topic");
        FirebaseMessaging.p().O(topic).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.mpush.core.fcm.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                m.t(topic, function1, task);
            }
        });
    }

    public final void u(String str) {
        Intrinsics.h(str, "<set-?>");
        f47567c = str;
    }

    public final void v(String str) {
        Intrinsics.h(str, "<set-?>");
        f47568d = str;
    }

    public final void x(final String topic) {
        Intrinsics.h(topic, "topic");
        FirebaseMessaging.p().R(topic).addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.mpush.core.fcm.k
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                m.y(topic, task);
            }
        });
    }
}
