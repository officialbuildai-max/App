package com.tn.lib.widget.toast.core;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.tn.lib.widget.toast.core.ToastImpl;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class ToastImpl {

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f41506g = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final vh.a f41507a;

    /* renamed from: b, reason: collision with root package name */
    private final i f41508b;

    /* renamed from: c, reason: collision with root package name */
    private final String f41509c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f41510d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f41511e = new AnonymousClass1();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f41512f = new Runnable() { // from class: com.tn.lib.widget.toast.core.ToastImpl.2
        @Override // java.lang.Runnable
        public void run() {
            Activity a11;
            WindowManager windowManager;
            try {
                try {
                    a11 = ToastImpl.this.f41508b.a();
                } catch (IllegalArgumentException e11) {
                    e11.printStackTrace();
                }
                if (a11 != null && (windowManager = (WindowManager) a11.getSystemService("window")) != null) {
                    windowManager.removeViewImmediate(ToastImpl.this.f41507a.c());
                }
            } finally {
                ToastImpl.this.f41508b.c();
                ToastImpl.this.g(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tn.lib.widget.toast.core.ToastImpl$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            ToastImpl.this.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity a11 = ToastImpl.this.f41508b.a();
            if (a11 == null || a11.isFinishing() || a11.isDestroyed()) {
                return;
            }
            int a12 = (ToastImpl.this.f41507a.c() == null || !(ToastImpl.this.f41507a.c().getTag() instanceof Integer)) ? -2 : a0.a(((Integer) ToastImpl.this.f41507a.c().getTag()).intValue());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = a12;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            if (ToastImpl.this.f41507a.a()) {
                layoutParams.flags = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
            } else {
                layoutParams.flags = 152;
            }
            layoutParams.packageName = ToastImpl.this.f41509c;
            layoutParams.gravity = ToastImpl.this.f41507a.getGravity();
            layoutParams.x = ToastImpl.this.f41507a.getXOffset();
            layoutParams.y = ToastImpl.this.f41507a.getYOffset();
            layoutParams.verticalMargin = ToastImpl.this.f41507a.getVerticalMargin();
            layoutParams.horizontalMargin = ToastImpl.this.f41507a.getHorizontalMargin();
            WindowManager windowManager = (WindowManager) a11.getSystemService("window");
            if (windowManager == null) {
                return;
            }
            try {
                windowManager.addView(ToastImpl.this.f41507a.c(), layoutParams);
                ToastImpl.f41506g.postDelayed(new Runnable() { // from class: com.tn.lib.widget.toast.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToastImpl.AnonymousClass1.this.lambda$run$0();
                    }
                }, ToastImpl.this.f41507a.getDuration() == 1 ? ToastStrategy.LONG_DURATION_TIMEOUT : 2000L);
                ToastImpl.this.f41508b.b(ToastImpl.this);
                ToastImpl.this.g(true);
            } catch (WindowManager.BadTokenException | IllegalStateException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToastImpl(Activity activity, vh.a aVar) {
        this.f41507a = aVar;
        this.f41509c = activity.getPackageName();
        this.f41508b = new i(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            Handler handler = f41506g;
            handler.removeCallbacks(this.f41512f);
            handler.post(this.f41512f);
        }
    }

    boolean f() {
        return this.f41510d;
    }

    void g(boolean z10) {
        this.f41510d = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (f()) {
            return;
        }
        Handler handler = f41506g;
        handler.removeCallbacks(this.f41511e);
        handler.post(this.f41511e);
    }
}
