package com.mbridge.msdk.mbnative.service;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbnative.controller.d;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private NativeController f36460a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f36461b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.mbnative.listener.a f36462c;

    /* renamed from: d, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f36463d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.mbnative.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0512a implements Runnable {
        RunnableC0512a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    public a() {
    }

    public a(com.mbridge.msdk.mbnative.listener.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f36462c = aVar;
        this.f36463d = nativeTrackingListener;
    }

    private void a(int i11, String str) {
        if (this.f36460a != null) {
            com.mbridge.msdk.mbnative.listener.a aVar = this.f36462c;
            if (aVar == null || !aVar.a()) {
                com.mbridge.msdk.mbnative.listener.a aVar2 = this.f36462c;
                if (aVar2 != null) {
                    aVar2.b();
                }
                this.f36460a.a(i11, str);
                return;
            }
            if (t0.h()) {
                f();
            } else {
                this.f36461b.post(new RunnableC0512a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f36462c.onAdLoadError("current request is loading");
        this.f36462c.b();
    }

    public static void preload(Map<String, Object> map, int i11) {
        o0.c("NativeProvider", "native provider preload");
        new d().a(map, i11);
    }

    public void a() {
        try {
            this.f36460a.d();
        } catch (Exception unused) {
            o0.b("NativeProvider", "clear cache failed");
        }
    }

    public void a(Context context, Resources resources, Map<String, Object> map) {
        this.f36460a = new NativeController(this.f36462c, this.f36463d, map, context);
    }

    public void a(View view, Campaign campaign) {
        o0.c("NativeProvider", "native provider registerView");
        NativeController nativeController = this.f36460a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view);
    }

    public void a(View view, List<View> list, Campaign campaign) {
        NativeController nativeController = this.f36460a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view, list);
    }

    public void a(com.mbridge.msdk.mbnative.listener.a aVar) {
        this.f36462c = aVar;
    }

    public void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f36463d = nativeTrackingListener;
    }

    public void a(String str) {
        a(0, str);
    }

    public String b() {
        NativeController nativeController = this.f36460a;
        return nativeController != null ? nativeController.e() : "";
    }

    public void b(View view, Campaign campaign) {
        o0.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.f36460a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view);
    }

    public void b(View view, List<View> list, Campaign campaign) {
        o0.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.f36460a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view, list);
    }

    public String c() {
        NativeController nativeController = this.f36460a;
        return nativeController != null ? nativeController.g() : "";
    }

    public void d() {
        a(0, "");
    }

    public void e() {
        a(1, "");
    }

    public void g() {
        try {
            this.f36460a.i();
        } catch (Exception unused) {
            o0.b("NativeProvider", "release failed");
        }
    }
}
