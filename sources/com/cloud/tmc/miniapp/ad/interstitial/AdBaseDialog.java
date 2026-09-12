package com.cloud.tmc.miniapp.ad.interstitial;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.Lifecycle;
import androidx.view.d0;
import androidx.view.t;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class AdBaseDialog extends OooO0O0.OooO00o<AdInterstitialHtmlView$Builder> implements t {
    public long OooO00o;
    public int OooO0O0;
    public boolean OooO0OO;
    public final Handler OooO0Oo;
    public final Runnable OooO0o;
    public boolean OooO0o0;

    /* loaded from: classes3.dex */
    public static final class OooO00o implements OooO0O0.OooOo00 {
        public final /* synthetic */ Context OooO0O0;

        public OooO00o(Context context) {
            this.OooO0O0 = context;
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
        public void onDismiss(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            AdBaseDialog adBaseDialog = AdBaseDialog.this;
            Context context = this.OooO0O0;
            adBaseDialog.getClass();
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getLifecycle().d(adBaseDialog);
            }
            AdBaseDialog adBaseDialog2 = AdBaseDialog.this;
            adBaseDialog2.OooO0Oo.removeCallbacks(adBaseDialog2.OooO0o);
            AdBaseDialog.this.OooO00o(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements OooO0O0.Oooo000 {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.Oooo000
        public void onShow(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            AdBaseDialog.this.OooO0OO();
            AdBaseDialog adBaseDialog = AdBaseDialog.this;
            AdShowBean adShowBean = new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
            AdBaseDialog adBaseDialog2 = AdBaseDialog.this;
            adShowBean.setImageWidth(adBaseDialog2.OooO0O0());
            adShowBean.setImageHeight(adBaseDialog2.OooO00o());
            adShowBean.setShowTs(adBaseDialog2.OooO00o);
            adShowBean.setEffectiveShow(adBaseDialog2.OooO0OO ? 1 : 0);
            adShowBean.setShowDuration(System.currentTimeMillis() - adBaseDialog2.OooO00o);
            adShowBean.setShowArea(adShowBean.getImageWidth() + "*" + adShowBean.getImageHeight());
            adShowBean.setShowReportTimeType(1);
            adShowBean.setShowTimes(adBaseDialog2.OooO0O0);
            adBaseDialog.OooO00o(adShowBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBaseDialog(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO0Oo = new Handler(Looper.getMainLooper());
        this.OooO0o = new Runnable() { // from class: com.cloud.tmc.miniapp.ad.interstitial.a
            @Override // java.lang.Runnable
            public final void run() {
                AdBaseDialog.OooO00o(AdBaseDialog.this);
            }
        };
        OooO00o(context);
        addOnDismissListener(new OooO00o(context));
        addOnShowListener(new OooO0O0());
    }

    public static final void OooO00o(AdBaseDialog this$0) {
        Intrinsics.h(this$0, "this$0");
        this$0.OooO0OO = true;
        AdShowBean adShowBean = new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
        adShowBean.setImageWidth(this$0.OooO0O0());
        adShowBean.setImageHeight(this$0.OooO00o());
        adShowBean.setShowTs(this$0.OooO00o);
        adShowBean.setEffectiveShow(this$0.OooO0OO ? 1 : 0);
        adShowBean.setShowDuration(System.currentTimeMillis() - this$0.OooO00o);
        adShowBean.setShowArea(adShowBean.getImageWidth() + "*" + adShowBean.getImageHeight());
        adShowBean.setShowReportTimeType(2);
        adShowBean.setShowTimes(this$0.OooO0O0);
        this$0.OooO00o(adShowBean);
    }

    public abstract int OooO00o();

    public final void OooO00o(Context context) {
        if (context instanceof AppCompatActivity) {
            ((AppCompatActivity) context).getLifecycle().a(this);
        }
    }

    public abstract void OooO00o(AdShowBean adShowBean);

    public final void OooO00o(boolean z10) {
        AdShowBean adShowBean = new AdShowBean(0, 0, 0L, 0, 0L, null, 0, 0, false, 511, null);
        adShowBean.setImageWidth(OooO0O0());
        adShowBean.setImageHeight(OooO00o());
        adShowBean.setShowTs(this.OooO00o);
        adShowBean.setEffectiveShow(this.OooO0OO ? 1 : 0);
        adShowBean.setShowDuration(System.currentTimeMillis() - this.OooO00o);
        adShowBean.setShowArea(adShowBean.getImageWidth() + "*" + adShowBean.getImageHeight());
        adShowBean.setShowReportTimeType(3);
        adShowBean.setShowTimes(this.OooO0O0);
        adShowBean.setClose(z10);
        OooO00o(adShowBean);
    }

    public abstract int OooO0O0();

    public final void OooO0OO() {
        this.OooO00o = System.currentTimeMillis();
        this.OooO0O0++;
        this.OooO0Oo.postDelayed(this.OooO0o, 1000L);
    }

    @d0(Lifecycle.Event.ON_PAUSE)
    public final void onLifeCycleOnPause() {
        if (isShowing()) {
            OooO00o(false);
        }
    }

    @d0(Lifecycle.Event.ON_RESUME)
    public final void onLifeCycleOnResume() {
        if (isShowing()) {
            OooO0OO();
        }
    }
}
