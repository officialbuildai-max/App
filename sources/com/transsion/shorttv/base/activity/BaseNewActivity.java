package com.transsion.shorttv.base.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.view.v;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.base.locale.d;
import com.transsion.shorttv.base.widget.NoNetworkBigView;
import com.transsion.shorttv.base.widget.k;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ds.e;
import g4.a;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nh.m;
import qs.j;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0006J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010 J\u000f\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010 J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0017H\u0016¢\u0006\u0004\b1\u0010 J\u000f\u00102\u001a\u00020\u0017H\u0016¢\u0006\u0004\b2\u0010 J\u000f\u00103\u001a\u00020\u0017H\u0016¢\u0006\u0004\b3\u0010 J\u000f\u00104\u001a\u00020\u0017H\u0016¢\u0006\u0004\b4\u0010 J\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010\u0006J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0007¢\u0006\u0004\b9\u0010\u0006J\r\u0010:\u001a\u00020\u0007¢\u0006\u0004\b:\u0010\u0006J\u000f\u0010<\u001a\u00020;H&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0007H&¢\u0006\u0004\b>\u0010\u0006J\u000f\u0010?\u001a\u00020\u0007H&¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010@\u001a\u00020\u0007H&¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010A\u001a\u00020\u0007H&¢\u0006\u0004\bA\u0010\u0006J\u000f\u0010B\u001a\u00020\u0007H&¢\u0006\u0004\bB\u0010\u0006R$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010N\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010E\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u001d\u0010^\u001a\u0004\u0018\u00010Y8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006_"}, d2 = {"Lcom/transsion/shorttv/base/activity/BaseNewActivity;", "Lg4/a;", "T", "Lcom/transsion/shorttv/base/activity/BaseMusicFloatActivity;", "Lds/e;", "<init>", "()V", "", "setStatusBar", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onStop", "onDestroy", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "setView", "Lcom/gyf/immersionbar/ImmersionBar;", "with", "n0", "(Lcom/gyf/immersionbar/ImmersionBar;)V", "setImmersionStatusBar", "()Z", "Landroid/app/Activity;", "context", "c0", "(Landroid/app/Activity;)V", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "g0", "isChangeStatusBar", "", "statusColor", "()I", "isStatusDark", "isTranslucent", "h0", "isAttach", "j0", "Landroid/view/View;", "Z", "()Landroid/view/View;", "l0", "m0", "", "Y", "()Ljava/lang/String;", "e0", "f0", "d0", "i0", "retryLoadData", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "getLlRootView", "()Landroid/widget/FrameLayout;", "setLlRootView", "(Landroid/widget/FrameLayout;)V", "llRootView", "e", "getFlStateView", "setFlStateView", "flStateView", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "progressBar", "", be.g.f16474b, "F", "downY", "h", "moveY", "Lhj/b;", "i", "Lkotlin/Lazy;", "getLogViewConfig", "()Lhj/b;", "logViewConfig", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public abstract class BaseNewActivity<T extends g4.a> extends BaseMusicFloatActivity<T> implements ds.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout llRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flStateView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float downY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float moveY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy logViewConfig = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.base.activity.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            hj.b k02;
            k02 = BaseNewActivity.k0(BaseNewActivity.this);
            return k02;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(BaseNewActivity baseNewActivity) {
        baseNewActivity.retryLoadData();
        k.b(baseNewActivity.getPageName());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(BaseNewActivity baseNewActivity) {
        k.c(baseNewActivity.getPageName());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hj.b k0(BaseNewActivity baseNewActivity) {
        return baseNewActivity.newLogViewConfig();
    }

    private final void setStatusBar() {
        if (setImmersionStatusBar()) {
            ImmersionBar with = ImmersionBar.with(this);
            if (isChangeStatusBar()) {
                with.statusBarColor(statusColor());
            }
            if (isTranslucent()) {
                with.statusBarAlpha(0.0f);
            } else {
                with.statusBarAlpha(1.0f);
            }
            if (isStatusDark()) {
                with.statusBarDarkFont(true);
            } else {
                with.statusBarDarkFont(false);
            }
            with.fitsSystemWindows(h0());
            Intrinsics.e(with);
            n0(with);
            with.init();
        }
    }

    public abstract String Y();

    public View Z() {
        NoNetworkBigView noNetworkBigView = new NoNetworkBigView(this);
        noNetworkBigView.showTitle(true, Y());
        noNetworkBigView.retry(new Function0() { // from class: com.transsion.shorttv.base.activity.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit a02;
                a02 = BaseNewActivity.a0(BaseNewActivity.this);
                return a02;
            }
        });
        noNetworkBigView.goToSetting(new Function0() { // from class: com.transsion.shorttv.base.activity.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit b02;
                b02 = BaseNewActivity.b0(BaseNewActivity.this);
                return b02;
            }
        });
        k.a(getPageName());
        return noNetworkBigView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        if (newBase == null) {
            super.attachBaseContext(newBase);
        } else {
            d.b bVar = com.transsion.shorttv.base.locale.d.f52853f;
            super.attachBaseContext(bVar.i(newBase, bVar.e().h()));
        }
    }

    public void c0(Activity context) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Result.m1185constructorimpl(Boolean.valueOf(((InputMethodManager) systemService).hideSoftInputFromWindow(context.getWindow().getDecorView().getWindowToken(), 0)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public abstract void d0();

    @Override // com.transsion.shorttv.base.activity.BaseMusicFloatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.downY = event.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float rawY = event.getRawY();
            this.moveY = rawY;
            if (Math.abs(rawY - this.downY) > 50.0f) {
                j T = T();
                if (T != null) {
                    T.b();
                }
                c0(this);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public abstract void e0();

    public abstract void f0();

    public boolean g0() {
        return true;
    }

    @Override // ds.e
    public hj.b getLogViewConfig() {
        return (hj.b) this.logViewConfig.getValue();
    }

    public boolean h0() {
        return true;
    }

    public abstract void i0();

    public boolean isAttach() {
        return true;
    }

    public boolean isChangeStatusBar() {
        return false;
    }

    public boolean isStatusDark() {
        return true;
    }

    public boolean isTranslucent() {
        return false;
    }

    public void j0() {
    }

    public final void l0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            yr.b.a(frameLayout);
        }
    }

    public final void m0() {
        FrameLayout frameLayout = this.flStateView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void n0(ImmersionBar with) {
        Intrinsics.h(with, "with");
    }

    public hj.b newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity, nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        super.onConnected(network, networkCapabilities);
        v.a(this).b(new BaseNewActivity$onConnected$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        e0();
        f0();
        d0();
        if (m.f70597a.e()) {
            i0();
        }
        j0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity, nh.n
    public void onDisconnected() {
        super.onDisconnected();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        j T;
        super.onResume();
        e.a.c(this);
        if (!isAttach() || (T = T()) == null) {
            return;
        }
        T.a(new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        j T;
        super.onStop();
        if (!isAttach() || (T = T()) == null) {
            return;
        }
        T.e(new WeakReference(this));
    }

    public abstract void retryLoadData();

    public boolean setImmersionStatusBar() {
        return true;
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    protected void setView() {
        setContentView(R$layout.short_tv_default_base_layout);
        this.llRootView = (FrameLayout) findViewById(R$id.llRootView);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.flContent);
        if (frameLayout != null) {
            frameLayout.addView(getMViewBinding().getRoot());
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.flStateView);
        if (frameLayout2 == null) {
            frameLayout2 = null;
        } else if (g0() && !m.f70597a.e()) {
            frameLayout2.setVisibility(0);
            frameLayout2.addView(Z());
        }
        this.flStateView = frameLayout2;
        this.progressBar = (ProgressBar) findViewById(R$id.progressBar);
    }

    public int statusColor() {
        return R$color.image_skeleton;
    }
}
