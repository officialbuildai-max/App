package com.transsion.push;

import android.app.Application;
import com.therouter.TheRouter;
import com.transsion.lib.push.R$mipmap;
import com.transsion.mpush.core.config.PushSdkConfig;
import com.transsion.mpush.core.features.FcmPushFeature;
import com.transsion.mpush.core.features.LocalPushFeature;
import com.transsion.mpush.core.features.PermanentPushFeature;
import com.transsion.mpush.core.trigger.PushTriggerManager;
import com.transsion.push.feature.activate.ActivatePushFeature;
import com.transsion.push.feature.seek.SeekPushFeature;
import com.transsion.push.feature.toolbar.NotificationReceiver;
import com.transsion.push.feature.toolbar.ToolbarNotificationUtils;
import com.transsion.push.feature.tpush.FcmPushInterceptor;
import com.transsion.pushapi.TriggerSource;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import dz.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class f implements dz.a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f50863d;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f50865f;

    /* renamed from: a, reason: collision with root package name */
    public static final f f50860a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f50861b = LazyKt.b(new Function0() { // from class: com.transsion.push.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean j11;
            j11 = f.j();
            return Boolean.valueOf(j11);
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f50862c = LazyKt.b(new Function0() { // from class: com.transsion.push.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi i11;
            i11 = f.i();
            return i11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Object f50864e = new Object();

    private f() {
    }

    private final ILoginApi e() {
        return (ILoginApi) f50862c.getValue();
    }

    private final boolean f() {
        return ((Boolean) f50861b.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h() {
        UserInfo i11;
        String userId;
        ILoginApi e11 = f50860a.e();
        return (e11 == null || (i11 = e11.i()) == null || (userId = i11.getUserId()) == null) ? "" : userId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi i() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j() {
        return !Intrinsics.c(sm.f.d(sm.f.f75530c.a(), "sa_notification_refresh", false, 2, null) != null ? r0.getValue() : null, "false");
    }

    private final void k() {
        if (f50865f) {
            return;
        }
        ILoginApi e11 = e();
        if (e11 != null) {
            e11.g(this);
        }
        f50865f = true;
    }

    public final void d() {
        com.transsion.mpush.core.fcm.m.f47565a.h();
    }

    public final void g(Application context) {
        Intrinsics.h(context, "context");
        if (f50863d) {
            k();
            return;
        }
        synchronized (f50864e) {
            if (f50863d) {
                f50860a.k();
                return;
            }
            ln.a a11 = ln.a.f69101a.j(context).a(new LocalPushFeature()).a(new PermanentPushFeature()).a(new SeekPushFeature()).a(new rp.a()).a(new ActivatePushFeature());
            FcmPushFeature fcmPushFeature = new FcmPushFeature();
            fcmPushFeature.d(new FcmPushInterceptor());
            ln.a p11 = a11.a(fcmPushFeature).o(new sp.a()).p(new qp.b("oneroom://com.community.oneroom?type=/main/tab"));
            int i11 = com.tn.lib.widget.R$drawable.push_small_logo;
            int i12 = R$mipmap.ic_default_push;
            f fVar = f50860a;
            p11.q(new PushSdkConfig(fVar.f(), i11, "oneroom://com.community.oneroom?type=/main/tab", i12, 0L, null, new com.transsion.push.utils.b().a(), 48, null));
            fVar.k();
            com.transsion.mpush.core.fcm.m.f47565a.r(context, new Function0() { // from class: com.transsion.push.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String h11;
                    h11 = f.h();
                    return h11;
                }
            });
            ToolbarNotificationUtils.f50888a.i();
            NotificationReceiver.INSTANCE.a(context);
            f50863d = true;
            Unit unit = Unit.f67184a;
        }
    }

    public final void l(TriggerSource triggerSource) {
        Intrinsics.h(triggerSource, "triggerSource");
        PushTriggerManager.f47648a.g("host_trigger_" + triggerSource.name(), triggerSource.ordinal());
    }

    @Override // dz.a
    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        a.C0761a.a(this, user);
        a.C0856a.f(lg.a.f68962a, "PushRegisterManager", "onLogin, " + user.getUserId(), false, 4, null);
        com.transsion.mpush.core.fcm.m.f47565a.h();
    }

    @Override // dz.a
    public void onLogout() {
        a.C0761a.b(this);
    }

    @Override // dz.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        a.C0761a.c(this, userInfo);
    }
}
