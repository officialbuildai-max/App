package uj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.transsion.baselib.report.l;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f76883a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f76884b;

    /* renamed from: uj.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0964a implements ByteAppManager.MiniAppLifecycleListener {
        C0964a() {
        }

        @Override // com.cloud.tmc.miniapp.ByteAppManager.MiniAppLifecycleListener
        public void onCreate() {
        }

        @Override // com.cloud.tmc.miniapp.ByteAppManager.MiniAppLifecycleListener
        public void onDestroy() {
        }

        @Override // com.cloud.tmc.miniapp.ByteAppManager.MiniAppLifecycleListener
        public void onPause() {
        }

        @Override // com.cloud.tmc.miniapp.ByteAppManager.MiniAppLifecycleListener
        public void onResume() {
        }

        @Override // com.cloud.tmc.miniapp.ByteAppManager.MiniAppLifecycleListener
        public void onStart() {
            l.f43413a.h();
        }

        @Override // com.cloud.tmc.miniapp.ByteAppManager.MiniAppLifecycleListener
        public void onStop() {
            Log.e("yy", "onStop  activity:");
            l.f43413a.v();
        }
    }

    private a() {
    }

    public final void a(Application app) {
        Intrinsics.h(app, "app");
        ByteAppManager.init(app);
        ByteAppManager.INSTANCE.registerMiniAppLifecycleListener(new C0964a());
    }

    public final void b(Context context, String miniappDeeplink) {
        Intrinsics.h(context, "context");
        Intrinsics.h(miniappDeeplink, "miniappDeeplink");
        ByteAppManager.launchMiniAppDeeplink(context, miniappDeeplink);
    }

    public final void c(Activity activity, String appId, String sceneId) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(appId, "appId");
        Intrinsics.h(sceneId, "sceneId");
        ByteAppManager.launchMiniAppForId(activity, appId, sceneId);
    }

    public final void d(Context context) {
        Intrinsics.h(context, "context");
        if (f76884b) {
            return;
        }
        f76884b = true;
        ByteAppManager.warmupMiniapp(context);
    }
}
