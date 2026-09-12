package ln;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.transsion.mpush.api.IPushFeature;
import com.transsion.mpush.api.IPushImageLoader;
import com.transsion.mpush.api.IPushReportInterceptor;
import com.transsion.mpush.api.IPushRouteHandler;
import com.transsion.mpush.core.config.PushSdkConfig;
import com.transsion.mpush.core.db.PushDatabase;
import com.transsion.mpush.core.fcm.m;
import com.transsion.mpush.core.features.FcmPushFeature;
import com.transsion.mpush.core.service.SdkNotificationRefreshService;
import com.transsion.mpush.core.trigger.PushTriggerManager;
import com.transsion.mpush.core.trigger.PushWorker;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static Context f69102b;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f69104d;

    /* renamed from: e, reason: collision with root package name */
    private static IPushImageLoader f69105e;

    /* renamed from: f, reason: collision with root package name */
    private static IPushRouteHandler f69106f;

    /* renamed from: g, reason: collision with root package name */
    private static IPushReportInterceptor f69107g;

    /* renamed from: i, reason: collision with root package name */
    private static ServiceConnection f69109i;

    /* renamed from: a, reason: collision with root package name */
    public static final a f69101a = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList f69103c = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private static PushSdkConfig f69108h = new PushSdkConfig(false, 0, null, 0, 0, null, null, 127, null);

    /* renamed from: ln.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class ServiceConnectionC0859a implements ServiceConnection {
        ServiceConnectionC0859a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "SdkNotificationRefreshService connected", false, 4, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "SdkNotificationRefreshService disconnected", false, 4, null);
        }
    }

    private a() {
    }

    private final void b(Intent intent) {
        Context context = f69102b;
        if (context != null && Build.VERSION.SDK_INT >= 26) {
            if (f69109i == null) {
                f69109i = new ServiceConnectionC0859a();
            }
            ServiceConnection serviceConnection = f69109i;
            Intrinsics.e(serviceConnection);
            context.bindService(intent, serviceConnection, 1);
        }
    }

    private final void c() {
        Context context = f69102b;
        if (context == null) {
            return;
        }
        if (!f69108h.getEnableRefresh()) {
            try {
                context.stopService(new Intent(context, (Class<?>) SdkNotificationRefreshService.class));
                r();
                return;
            } catch (Exception e11) {
                a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "checkRefreshService: stop service failed " + e11, false, 4, null);
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) SdkNotificationRefreshService.class);
        try {
            context.startService(intent);
            b(intent);
        } catch (Exception e12) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "checkRefreshService: start/bind service failed " + e12, false, 4, null);
        }
    }

    private final void k() {
        FcmPushFeature fcmPushFeature;
        Context context = f69102b;
        if (context == null || (fcmPushFeature = (FcmPushFeature) e(FcmPushFeature.class)) == null) {
            return;
        }
        m mVar = m.f47565a;
        mVar.g(fcmPushFeature.b());
        Application application = context instanceof Application ? (Application) context : null;
        if (application == null) {
            a.C0856a.z(lg.a.f68962a, "M_PUSH_SDK", "initTPushIfNeeded: context is not Application, skip init", false, 4, null);
        } else {
            mVar.q(application);
        }
    }

    private final void r() {
        Context context;
        ServiceConnection serviceConnection = f69109i;
        if (serviceConnection == null || (context = f69102b) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
            f69109i = null;
        } catch (Exception e11) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "unbindRefreshService: failed " + e11, false, 4, null);
        }
    }

    public final a a(IPushFeature feature) {
        Intrinsics.h(feature, "feature");
        CopyOnWriteArrayList copyOnWriteArrayList = f69103c;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.c(((IPushFeature) it.next()).getClass(), feature.getClass())) {
                    a.C0856a.z(lg.a.f68962a, "M_PUSH_SDK", "[PushClient] addFeature -> 重复注册已忽略：" + feature.getClass().getSimpleName(), false, 4, null);
                    return this;
                }
            }
        }
        a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "[PushClient] addFeature -> " + feature.getClass().getSimpleName(), false, 4, null);
        f69103c.add(feature);
        Context context = f69102b;
        if (context != null) {
            feature.init(context);
            f69101a.k();
        }
        return this;
    }

    public final PushDatabase d() {
        if (f69102b == null) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "getDatabase: SDK not initialized", false, 4, null);
        }
        PushDatabase.Companion companion = PushDatabase.INSTANCE;
        Context context = f69102b;
        if (context == null) {
            return null;
        }
        return companion.b(context);
    }

    public final IPushFeature e(Class clazz) {
        Object obj;
        Intrinsics.h(clazz, "clazz");
        Iterator it = f69103c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (clazz.isInstance((IPushFeature) obj)) {
                break;
            }
        }
        if (obj instanceof IPushFeature) {
            return (IPushFeature) obj;
        }
        return null;
    }

    public final IPushImageLoader f() {
        IPushImageLoader iPushImageLoader = f69105e;
        return iPushImageLoader == null ? new nn.b() : iPushImageLoader;
    }

    public final IPushReportInterceptor g() {
        return f69107g;
    }

    public final IPushRouteHandler h() {
        return f69106f;
    }

    public final PushSdkConfig i() {
        return f69108h;
    }

    public final a j(Context context) {
        Intrinsics.h(context, "context");
        if (f69104d) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "init: already initialized", false, 4, null);
            return this;
        }
        a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "init: initializing SDK...", false, 4, null);
        f69102b = context.getApplicationContext();
        f69104d = true;
        for (IPushFeature iPushFeature : f69103c) {
            Context context2 = f69102b;
            if (context2 == null) {
                context2 = context;
            }
            iPushFeature.init(context2);
        }
        k();
        PushTriggerManager.f47648a.d(context);
        PushWorker.INSTANCE.a(context);
        c();
        a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "init end", false, 4, null);
        return this;
    }

    public final void l(String msgId, Object obj) {
        Object m1185constructorimpl;
        Intrinsics.h(msgId, "msgId");
        if (!f69104d) {
            a.C0856a.z(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】收到透传消息但 SDK 未初始化，消息ID：" + msgId + "，已忽略", false, 4, null);
            return;
        }
        a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】收到透传消息，消息ID：" + msgId + "，消息类型：" + (obj != null ? obj.getClass().getSimpleName() : null) + "，开始分发", false, 4, null);
        for (IPushFeature iPushFeature : f69103c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                iPushFeature.onMessageReceive(msgId, obj);
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】透传消息处理失败，消息ID：" + msgId + "，Feature：" + iPushFeature.getClass().getSimpleName() + "，异常：" + m1188exceptionOrNullimpl, false, 4, null);
                m1188exceptionOrNullimpl.printStackTrace();
            }
        }
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【PushClient】透传消息分发完成，消息ID：" + msgId}, false, 4, null);
    }

    public final void m(int i11) {
        Object m1185constructorimpl;
        a.C0856a c0856a = lg.a.f68962a;
        CopyOnWriteArrayList<IPushFeature> copyOnWriteArrayList = f69103c;
        a.C0856a.l(c0856a, "M_PUSH_SDK", "【PushClient】收到触发事件，触发源：" + i11 + "，开始分发给 " + copyOnWriteArrayList.size() + " 个Feature", false, 4, null);
        for (IPushFeature iPushFeature : copyOnWriteArrayList) {
            try {
                Result.Companion companion = Result.INSTANCE;
                iPushFeature.onTrigger(i11);
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】触发事件处理失败，Feature：" + iPushFeature.getClass().getSimpleName() + "，异常：" + m1188exceptionOrNullimpl, false, 4, null);
                m1188exceptionOrNullimpl.printStackTrace();
            }
        }
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【PushClient】触发事件分发完成，触发源：" + i11}, false, 4, null);
    }

    public final void n(Object message) {
        Object m1185constructorimpl;
        Intrinsics.h(message, "message");
        a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】开始刷新消息，消息类型：" + message.getClass().getSimpleName(), false, 4, null);
        for (IPushFeature iPushFeature : f69103c) {
            try {
                Result.Companion companion = Result.INSTANCE;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (iPushFeature.refreshMessage(message)) {
                a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】消息刷新成功，由Feature处理：" + iPushFeature.getClass().getSimpleName(), false, 4, null);
                return;
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【PushClient】消息刷新失败，Feature：" + iPushFeature.getClass().getSimpleName() + "，异常：" + m1188exceptionOrNullimpl, false, 4, null);
            }
        }
    }

    public final a o(IPushReportInterceptor iPushReportInterceptor) {
        f69107g = iPushReportInterceptor;
        return this;
    }

    public final a p(IPushRouteHandler iPushRouteHandler) {
        f69106f = iPushRouteHandler;
        return this;
    }

    public final a q(PushSdkConfig config) {
        Intrinsics.h(config, "config");
        f69108h = config;
        c();
        return this;
    }
}
