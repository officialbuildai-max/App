package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.blankj.utilcode.util.a0;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import com.transsion.shorttv_pugc.base.widget.toast.core.ToastImpl;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ToastImpl {

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f53997g = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final lt.a f53998a;

    /* renamed from: b, reason: collision with root package name */
    private final i f53999b;

    /* renamed from: c, reason: collision with root package name */
    private final String f54000c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f54001d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f54002e = new AnonymousClass1();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f54003f = new Runnable() { // from class: com.transsion.shorttv_pugc.base.widget.toast.core.ToastImpl.2
        @Override // java.lang.Runnable
        public void run() {
            Activity a11;
            WindowManager windowManager;
            try {
                try {
                    a11 = ToastImpl.this.f53999b.a();
                } catch (IllegalArgumentException e11) {
                    e11.printStackTrace();
                }
                if (a11 != null && (windowManager = (WindowManager) a11.getSystemService("window")) != null) {
                    windowManager.removeViewImmediate(ToastImpl.this.f53998a.getView());
                }
            } finally {
                ToastImpl.this.f53999b.c();
                ToastImpl.this.g(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.transsion.shorttv_pugc.base.widget.toast.core.ToastImpl$1, reason: invalid class name */
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
            Activity a11 = ToastImpl.this.f53999b.a();
            if (a11 == null || a11.isFinishing() || a11.isDestroyed()) {
                return;
            }
            int a12 = (ToastImpl.this.f53998a.getView() == null || !(ToastImpl.this.f53998a.getView().getTag() instanceof Integer)) ? -2 : a0.a(((Integer) ToastImpl.this.f53998a.getView().getTag()).intValue());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = a12;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            if (ToastImpl.this.f53998a.a()) {
                layoutParams.flags = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
            } else {
                layoutParams.flags = 152;
            }
            layoutParams.packageName = ToastImpl.this.f54000c;
            layoutParams.gravity = ToastImpl.this.f53998a.getGravity();
            layoutParams.x = ToastImpl.this.f53998a.getXOffset();
            layoutParams.y = ToastImpl.this.f53998a.getYOffset();
            layoutParams.verticalMargin = ToastImpl.this.f53998a.getVerticalMargin();
            layoutParams.horizontalMargin = ToastImpl.this.f53998a.getHorizontalMargin();
            WindowManager windowManager = (WindowManager) a11.getSystemService("window");
            if (windowManager == null) {
                return;
            }
            try {
                windowManager.addView(ToastImpl.this.f53998a.getView(), layoutParams);
                ToastImpl.f53997g.postDelayed(new Runnable() { // from class: com.transsion.shorttv_pugc.base.widget.toast.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToastImpl.AnonymousClass1.this.lambda$run$0();
                    }
                }, ToastImpl.this.f53998a.getDuration() == 1 ? ToastStrategy.LONG_DURATION_TIMEOUT : 2000L);
                ToastImpl.this.f53999b.b(ToastImpl.this);
                ToastImpl.this.g(true);
            } catch (WindowManager.BadTokenException | IllegalStateException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToastImpl(Activity activity, lt.a aVar) {
        this.f53998a = aVar;
        this.f54000c = activity.getPackageName();
        this.f53999b = new i(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            Handler handler = f53997g;
            handler.removeCallbacks(this.f54003f);
            handler.post(this.f54003f);
        }
    }

    boolean f() {
        return this.f54001d;
    }

    void g(boolean z10) {
        this.f54001d = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (f()) {
            return;
        }
        Handler handler = f53997g;
        handler.removeCallbacks(this.f54002e);
        handler.post(this.f54002e);
    }
}
