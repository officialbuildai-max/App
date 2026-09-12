package com.transsion.shorttv.base.widget.toast.core;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.transsion.shorttv.base.widget.toast.core.ToastImpl;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ToastImpl {

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f53017g = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final gs.a f53018a;

    /* renamed from: b, reason: collision with root package name */
    private final i f53019b;

    /* renamed from: c, reason: collision with root package name */
    private final String f53020c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f53021d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f53022e = new AnonymousClass1();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f53023f = new Runnable() { // from class: com.transsion.shorttv.base.widget.toast.core.ToastImpl.2
        @Override // java.lang.Runnable
        public void run() {
            Activity a11;
            WindowManager windowManager;
            try {
                try {
                    a11 = ToastImpl.this.f53019b.a();
                } catch (IllegalArgumentException e11) {
                    e11.printStackTrace();
                }
                if (a11 != null && (windowManager = (WindowManager) a11.getSystemService("window")) != null) {
                    windowManager.removeViewImmediate(ToastImpl.this.f53018a.getView());
                }
            } finally {
                ToastImpl.this.f53019b.c();
                ToastImpl.this.g(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsion.shorttv.base.widget.toast.core.ToastImpl$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            ToastImpl.this.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity a11 = ToastImpl.this.f53019b.a();
            if (a11 == null || a11.isFinishing() || a11.isDestroyed()) {
                return;
            }
            int a12 = (ToastImpl.this.f53018a.getView() == null || !(ToastImpl.this.f53018a.getView().getTag() instanceof Integer)) ? -2 : a0.a(((Integer) ToastImpl.this.f53018a.getView().getTag()).intValue());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = a12;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            if (ToastImpl.this.f53018a.a()) {
                layoutParams.flags = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
            } else {
                layoutParams.flags = 152;
            }
            layoutParams.packageName = ToastImpl.this.f53020c;
            layoutParams.gravity = ToastImpl.this.f53018a.getGravity();
            layoutParams.x = ToastImpl.this.f53018a.getXOffset();
            layoutParams.y = ToastImpl.this.f53018a.getYOffset();
            layoutParams.verticalMargin = ToastImpl.this.f53018a.getVerticalMargin();
            layoutParams.horizontalMargin = ToastImpl.this.f53018a.getHorizontalMargin();
            WindowManager windowManager = (WindowManager) a11.getSystemService("window");
            if (windowManager == null) {
                return;
            }
            try {
                windowManager.addView(ToastImpl.this.f53018a.getView(), layoutParams);
                ToastImpl.f53017g.postDelayed(new Runnable() { // from class: com.transsion.shorttv.base.widget.toast.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToastImpl.AnonymousClass1.this.lambda$run$0();
                    }
                }, ToastImpl.this.f53018a.getDuration() == 1 ? ToastStrategy.LONG_DURATION_TIMEOUT : 2000L);
                ToastImpl.this.f53019b.b(ToastImpl.this);
                ToastImpl.this.g(true);
            } catch (WindowManager.BadTokenException | IllegalStateException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToastImpl(Activity activity, gs.a aVar) {
        this.f53018a = aVar;
        this.f53020c = activity.getPackageName();
        this.f53019b = new i(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            Handler handler = f53017g;
            handler.removeCallbacks(this.f53023f);
            handler.post(this.f53023f);
        }
    }

    boolean f() {
        return this.f53021d;
    }

    void g(boolean z10) {
        this.f53021d = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (f()) {
            return;
        }
        Handler handler = f53017g;
        handler.removeCallbacks(this.f53022e);
        handler.post(this.f53022e);
    }
}
