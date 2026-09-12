package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeVideoView extends MBridgeBaseView implements com.mbridge.msdk.video.signal.j {
    private static int R0;
    private static int S0;
    private static int T0;
    private static int U0;
    private static int V0;
    private static boolean W0;
    private static long X0;
    private boolean A;
    private int A0;
    private FrameLayout B;
    private int B0;
    private MBridgeClickCTAView C;
    private int C0;
    private com.mbridge.msdk.video.signal.factory.b D;
    private AcquireRewardPopViewParameters D0;
    private int E;
    private MBAcquireRewardPopView E0;
    private int F;
    private boolean F0;
    private RelativeLayout G;
    private RelativeLayout G0;
    private boolean H;
    private CollapsibleWebView H0;
    private boolean I;
    private RelativeLayout I0;
    private boolean J;
    private boolean J0;
    private String K;
    private int K0;
    private int L;
    private boolean L0;
    private int M;
    private boolean M0;
    private int N;
    private w N0;
    private MBAlertDialog O;
    private boolean O0;
    private com.mbridge.msdk.widget.dialog.b P;
    private Runnable P0;
    private String Q;
    private final Runnable Q0;
    private double R;
    private double S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f39411a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f39412b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f39413c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f39414d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f39415e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f39416f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f39417g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f39418h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.b f39419i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f39420j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f39421k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f39422l0;

    /* renamed from: m, reason: collision with root package name */
    private TextView f39423m;

    /* renamed from: m0, reason: collision with root package name */
    private int f39424m0;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;
    public PlayerView mPlayerView;
    public SoundImageView mSoundImageView;

    /* renamed from: n, reason: collision with root package name */
    private View f39425n;

    /* renamed from: n0, reason: collision with root package name */
    private int f39426n0;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout f39427o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f39428o0;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f39429p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f39430p0;

    /* renamed from: q, reason: collision with root package name */
    private ProgressBar f39431q;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f39432q0;

    /* renamed from: r, reason: collision with root package name */
    private FeedBackButton f39433r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f39434r0;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f39435s;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f39436s0;

    /* renamed from: t, reason: collision with root package name */
    private MBridgeSegmentsProgressBar f39437t;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f39438t0;
    public TextView tvFlag;

    /* renamed from: u, reason: collision with root package name */
    private com.mbridge.msdk.video.module.listener.a f39439u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f39440u0;

    /* renamed from: v, reason: collision with root package name */
    private u f39441v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f39442v0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f39443w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f39444w0;

    /* renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.a f39445x;

    /* renamed from: x0, reason: collision with root package name */
    private AlphaAnimation f39446x0;

    /* renamed from: y, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.f f39447y;

    /* renamed from: y0, reason: collision with root package name */
    private MBridgeBaitClickView f39448y0;

    /* renamed from: z, reason: collision with root package name */
    private int f39449z;

    /* renamed from: z0, reason: collision with root package name */
    private int f39450z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeVideoView.this.f39414d0 = true;
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f39452a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f39453b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f39454c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f39455d;

        b(int i11, int i12, int i13, int i14) {
            this.f39452a = i11;
            this.f39453b = i12;
            this.f39454c = i13;
            this.f39455d = i14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeVideoView.this.f39427o == null) {
                return;
            }
            MBridgeVideoView.this.f39427o.setVisibility(0);
            CampaignEx campaignEx = MBridgeVideoView.this.f39280b;
            if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
                return;
            }
            MBridgeVideoView.this.f39427o.setPadding(this.f39452a, this.f39453b, this.f39454c, this.f39455d);
            MBridgeVideoView.this.f39427o.startAnimation(MBridgeVideoView.this.f39446x0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.same.image.c {

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f39458a;

            /* renamed from: com.mbridge.msdk.video.module.MBridgeVideoView$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class RunnableC0569a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Bitmap f39460a;

                RunnableC0569a(Bitmap bitmap) {
                    this.f39460a = bitmap;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MBridgeVideoView.this.f39429p.setVisibility(0);
                    MBridgeVideoView.this.f39429p.setImageBitmap(this.f39460a);
                }
            }

            a(Bitmap bitmap) {
                this.f39458a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    MBridgeVideoView.this.f39429p.post(new RunnableC0569a(y.a(this.f39458a, 10)));
                } catch (Exception e11) {
                    o0.b(MBridgeBaseView.TAG, e11.getMessage());
                }
            }
        }

        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.b(MBridgeBaseView.TAG, str);
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled() || MBridgeVideoView.this.f39429p == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new a(bitmap));
                } catch (Throwable th2) {
                    o0.b(MBridgeBaseView.TAG, th2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements CollapsibleWebView.e {
        d() {
        }

        private void a(String str, String str2) {
            if (MBridgeVideoView.this.J0) {
                return;
            }
            MBridgeVideoView.this.J0 = true;
            if (str == null) {
                str = "";
            }
            if (MBridgeVideoView.this.G0 != null && MBridgeVideoView.this.G0.getVisibility() == 0) {
                MBridgeVideoView.this.G0.setVisibility(8);
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("result", 2);
            eVar.a("url", str);
            eVar.a("reason", str2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_render", MBridgeVideoView.this.f39280b, eVar);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void a(View view, String str) {
            JSONObject jSONObject;
            if (MBridgeVideoView.this.J0) {
                return;
            }
            MBridgeVideoView.this.J0 = true;
            if (MBridgeVideoView.this.G0 != null && MBridgeVideoView.this.G0.getVisibility() != 0) {
                MBridgeVideoView.this.G0.setVisibility(0);
            }
            Context context = MBridgeVideoView.this.getContext();
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            com.mbridge.msdk.click.a.a(context, mBridgeVideoView.f39280b, mBridgeVideoView.getUnitId(), MBridgeVideoView.this.f39280b.getNoticeUrl(), true, false, com.mbridge.msdk.click.retry.a.f34474o);
            com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d().getApplicationContext(), MBridgeVideoView.this.f39280b);
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("result", 1);
            if (MBridgeVideoView.this.f39439u != null) {
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, MBridgeVideoView.this.a(0));
                    } catch (JSONException e11) {
                        e = e11;
                        e.printStackTrace();
                        MBridgeVideoView.this.f39439u.a(Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, jSONObject);
                        MBridgeVideoView.this.f39280b.setClickType(1);
                        MBridgeVideoView.this.f39280b.setClickTempSource(1);
                        MBridgeVideoView.this.f39280b.setTriggerClickSource(2);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000149", MBridgeVideoView.this.f39280b);
                        eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 9);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("web_view");
                        eVar.a("click_path", arrayList.toString());
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", MBridgeVideoView.this.f39280b, eVar);
                        eVar.a("url", str);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_render", MBridgeVideoView.this.f39280b, eVar);
                    }
                } catch (JSONException e12) {
                    e = e12;
                    jSONObject = null;
                }
                MBridgeVideoView.this.f39439u.a(Sdk$SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, jSONObject);
                MBridgeVideoView.this.f39280b.setClickType(1);
                MBridgeVideoView.this.f39280b.setClickTempSource(1);
                MBridgeVideoView.this.f39280b.setTriggerClickSource(2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000149", MBridgeVideoView.this.f39280b);
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 9);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("web_view");
                eVar.a("click_path", arrayList2.toString());
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000150", MBridgeVideoView.this.f39280b, eVar);
            }
            eVar.a("url", str);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_render", MBridgeVideoView.this.f39280b, eVar);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void a(View view, Map<String, String> map) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void b(View view, String str) {
            a(str, "timeout");
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.e
        public void b(View view, Map<String, String> map) {
            String str;
            String str2;
            str = "";
            if (map != null) {
                String str3 = map.get("url");
                str = str3 != null ? str3 : "";
                str2 = map.get(TrackingKey.DESCRIPTION);
            } else {
                str2 = "";
            }
            a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends WebViewClient {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            o0.b(MBridgeBaseView.TAG, "WebView called onRenderProcessGone");
            if (webView != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    if (webView instanceof WindVaneWebView) {
                        ((WindVaneWebView) webView).release();
                    } else {
                        webView.destroy();
                    }
                } catch (Throwable th2) {
                    o0.b(MBridgeBaseView.TAG, th2.getMessage());
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements CommonWebView.h {
        f() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.h
        public void a() {
            if (MBridgeVideoView.this.I0 != null) {
                MBridgeVideoView.this.I0.setVisibility(0);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NotificationCompat.CATEGORY_STATUS, 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_zoom", MBridgeVideoView.this.f39280b, eVar);
            }
            if (MBridgeVideoView.this.H0 != null) {
                MBridgeVideoView.this.H0.setCustomizedToolBarMarginWidthPixel(0, 0, 0, 0);
            }
            MBridgeVideoView.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements CommonWebView.h {
        g() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.h
        public void a() {
            if (MBridgeVideoView.this.I0 != null) {
                MBridgeVideoView.this.I0.setVisibility(8);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NotificationCompat.CATEGORY_STATUS, 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_webview_zoom", MBridgeVideoView.this.f39280b, eVar);
            }
            if (MBridgeVideoView.this.H0 != null) {
                MBridgeVideoView.this.H0.setCustomizedToolBarMarginWidthPixel(0, MBridgeVideoView.this.K0, 0, 0);
            }
            MBridgeVideoView.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeVideoView.this.I0 != null) {
                MBridgeVideoView.this.I0.setVisibility(0);
            }
            if (MBridgeVideoView.this.G0 != null) {
                MBridgeVideoView.this.G0.setVisibility(8);
            }
            if (MBridgeVideoView.this.f39436s0) {
                return;
            }
            MBridgeVideoView.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            if (mBridgeVideoView.notifyListener != null) {
                mBridgeVideoView.f39280b.setTriggerClickSource(2);
                MBridgeVideoView.this.b("bait_click_clicked");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements AcquireRewardPopViewBehaviourListener {
        j() {
        }

        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
        public void onOutOfContentClicked(float f11, float f12) {
            if (MBridgeVideoView.this.f39439u != null) {
                MBridgeVideoView.this.f39439u.a(105, "");
            }
        }

        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
        public void onReceivedFail(String str) {
            MBridgeVideoView.this.J = false;
            if (com.mbridge.msdk.util.b.b()) {
                MBridgeVideoView.this.setCover(false);
            }
            MBridgeVideoView.this.p();
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView.f39280b, mBridgeVideoView.Q, MBridgeVideoView.this.f39450z0, 2, str);
        }

        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
        public void onReceivedSuccess(int i11) {
            MBridgeVideoView.this.J = false;
            if (com.mbridge.msdk.util.b.b()) {
                MBridgeVideoView.this.setCover(false);
            }
            int videoCompleteTime = MBridgeVideoView.this.getVideoCompleteTime() - i11;
            MBridgeVideoView.this.f39280b.setVideoCompleteTime(videoCompleteTime);
            MBridgeVideoView.this.p();
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
            if (aVar != null) {
                aVar.a(130, Integer.valueOf(videoCompleteTime));
            }
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView.f39280b, mBridgeVideoView.Q, MBridgeVideoView.this.f39450z0, 1, "");
        }
    }

    /* loaded from: classes5.dex */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeVideoView.this.B != null) {
                MBridgeVideoView.this.B.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l implements com.mbridge.msdk.video.dynview.listener.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f39470a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.video.dynview.c f39471b;

        /* loaded from: classes5.dex */
        class a extends com.mbridge.msdk.widget.a {
            a() {
            }

            @Override // com.mbridge.msdk.widget.a
            protected void a(View view) {
                if (view instanceof TextView) {
                    MBridgeVideoView.this.f39280b.setTriggerClickSource(1);
                } else {
                    MBridgeVideoView.this.f39280b.setTriggerClickSource(2);
                }
                if (MBridgeVideoView.this.f39280b.getRewardTemplateMode() == null || MBridgeVideoView.this.f39280b.getRewardTemplateMode().f() != 902) {
                    MBridgeVideoView.this.b("video_play_click");
                } else {
                    MBridgeVideoView.this.j();
                }
            }
        }

        l(ViewGroup viewGroup, com.mbridge.msdk.video.dynview.c cVar) {
            this.f39470a = viewGroup;
            this.f39471b = cVar;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                if (this.f39470a != null && aVar.b() != null) {
                    aVar.b().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.f39470a.addView(aVar.b());
                }
                if (aVar.a() != null) {
                    Iterator<View> it = aVar.a().iterator();
                    while (it.hasNext()) {
                        it.next().setOnClickListener(new a());
                    }
                }
                MBridgeVideoView.this.f39444w0 = aVar.c();
                MBridgeVideoView.this.n();
                boolean unused = MBridgeVideoView.W0 = false;
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                CampaignEx campaignEx = mBridgeVideoView.f39280b;
                if (campaignEx != null) {
                    campaignEx.setTemplateRenderSucc(mBridgeVideoView.f39444w0);
                }
                MBridgeVideoView.this.E = this.f39471b.j();
                MBridgeVideoView.this.F = this.f39471b.e();
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            o0.b(MBridgeBaseView.TAG, "errorMsg：" + aVar.c());
        }
    }

    /* loaded from: classes5.dex */
    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeVideoView.this.A0 <= 0) {
                MBridgeVideoView.this.showRewardPopView();
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                mBridgeVideoView.removeCallbacks(mBridgeVideoView.Q0);
            } else {
                MBridgeVideoView.W(MBridgeVideoView.this);
                MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                mBridgeVideoView2.postDelayed(mBridgeVideoView2.Q0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class n implements PlayerView.OnPlayerViewVisibleListener {
        n() {
        }

        @Override // com.mbridge.msdk.playercommon.PlayerView.OnPlayerViewVisibleListener
        public void playerViewVisibleCallback() {
            if (MBridgeVideoView.this.f39443w) {
                return;
            }
            MBridgeVideoView.this.f39443w = true;
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            if (mBridgeVideoView.notifyListener == null || mBridgeVideoView.f39441v == null) {
                return;
            }
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            mBridgeVideoView2.notifyListener.a(20, mBridgeVideoView2.f39441v);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeVideoView.this.notifyListener != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                MBridgeVideoView.this.f39280b.setClickTempSource(1);
                MBridgeVideoView.this.f39280b.setTriggerClickSource(2);
                MBridgeVideoView.this.notifyListener.a(1, jSONObject);
            }
            if (MBridgeVideoView.this.f39420j0 != null) {
                try {
                    MBridgeVideoView.this.f39420j0.a(InteractionType.CLICK);
                    o0.a("omsdk", "play video view:  click");
                } catch (Exception e12) {
                    o0.b("omsdk", e12.getMessage());
                }
            }
            MBridgeVideoView.this.setCTALayoutVisibleOrGone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoView.this.f39280b.setClickTempSource(1);
            MBridgeVideoView.this.f39280b.setTriggerClickSource(2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_player_click", MBridgeVideoView.this.f39280b);
            if (MBridgeVideoView.this.notifyListener != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                MBridgeVideoView.this.notifyListener.a(1, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            Integer num = 2;
            PlayerView playerView = MBridgeVideoView.this.mPlayerView;
            if (playerView != null) {
                eVar.a("mute_state", Boolean.valueOf(playerView.isSilent()));
                if (MBridgeVideoView.this.mPlayerView.isSilent()) {
                    num = 1;
                }
            }
            if (num.intValue() == 1) {
                MBridgeVideoView.this.mMuteSwitch = 2;
            } else {
                MBridgeVideoView.this.mMuteSwitch = 1;
            }
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
            if (aVar != null) {
                aVar.a(5, num);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_sound_click", MBridgeVideoView.this.f39280b, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000148", MBridgeVideoView.this.f39280b, eVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
            if (!MBridgeVideoView.this.f39417g0) {
                CampaignEx campaignEx = MBridgeVideoView.this.f39280b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || MBridgeVideoView.this.f39280b.getRewardTemplateMode().f() != 5002010 || !MBridgeVideoView.this.f39436s0) {
                    MBridgeVideoView.this.y();
                    return;
                }
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                if (mBridgeVideoView.notifyListener != null) {
                    mBridgeVideoView.L0 = true;
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.notifyListener.a(2, mBridgeVideoView2.c(mBridgeVideoView2.f39436s0));
                    return;
                }
                return;
            }
            MBridgeVideoView.this.f39442v0 = true;
            CampaignEx campaignEx2 = MBridgeVideoView.this.f39280b;
            if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && MBridgeVideoView.this.f39280b.getRewardTemplateMode().f() == 5002010 && MBridgeVideoView.this.f39436s0) {
                MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                if (mBridgeVideoView3.notifyListener != null) {
                    mBridgeVideoView3.L0 = true;
                    MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                    mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.c(mBridgeVideoView4.f39436s0));
                    return;
                }
                return;
            }
            if (MBridgeVideoView.this.f39434r0) {
                MBridgeVideoView.this.y();
                return;
            }
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
            if (aVar != null) {
                aVar.a(Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, "");
            }
        }
    }

    /* loaded from: classes5.dex */
    class s implements com.mbridge.msdk.widget.dialog.b {
        s() {
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void a() {
            MBridgeVideoView.this.I = false;
            MBridgeVideoView.this.f39432q0 = true;
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.I);
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView2.f39279a, mBridgeVideoView2.f39280b, mBridgeVideoView2.f39421k0, MBridgeVideoView.this.Q, 1, 1, 1);
            if (MBridgeVideoView.this.f39417g0 && MBridgeVideoView.this.f39422l0 == com.mbridge.msdk.foundation.same.a.H) {
                MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                if (mBridgeVideoView3.notifyListener != null) {
                    mBridgeVideoView3.L0 = true;
                    MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                    mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.c(mBridgeVideoView4.f39436s0));
                    return;
                }
                return;
            }
            if (MBridgeVideoView.this.f39417g0 && MBridgeVideoView.this.f39422l0 == com.mbridge.msdk.foundation.same.a.I) {
                MBridgeVideoView.this.p();
                return;
            }
            MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
            if (mBridgeVideoView5.notifyListener != null) {
                mBridgeVideoView5.L0 = true;
                MBridgeVideoView.this.notifyListener.a(2, "");
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void b() {
            MBridgeVideoView.this.I = false;
            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
            mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.I);
            if (MBridgeVideoView.this.f39417g0 && (MBridgeVideoView.this.f39422l0 == com.mbridge.msdk.foundation.same.a.I || MBridgeVideoView.this.f39422l0 == com.mbridge.msdk.foundation.same.a.H)) {
                MBridgeVideoView.this.f39430p0 = true;
                com.mbridge.msdk.video.module.listener.a aVar = MBridgeVideoView.this.notifyListener;
                if (aVar != null) {
                    aVar.a(Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, "");
                }
                MBridgeVideoView.this.f39440u0 = true;
                MBridgeVideoView.this.gonePlayingCloseView();
            }
            MBridgeVideoView.this.p();
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            com.mbridge.msdk.foundation.same.report.j.a(mBridgeVideoView2.f39279a, mBridgeVideoView2.f39280b, mBridgeVideoView2.f39421k0, MBridgeVideoView.this.Q, 1, 0, 1);
        }

        @Override // com.mbridge.msdk.widget.dialog.b
        public void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class t implements com.mbridge.msdk.foundation.feedback.a {
        t() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            MBridgeVideoView.this.o();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            MBridgeVideoView.this.p();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            MBridgeVideoView.this.p();
        }
    }

    /* loaded from: classes5.dex */
    public interface u {
        void a();
    }

    /* loaded from: classes5.dex */
    public static class v {

        /* renamed from: a, reason: collision with root package name */
        public int f39482a;

        /* renamed from: b, reason: collision with root package name */
        public int f39483b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f39484c;

        public String toString() {
            return "ProgressData{curPlayPosition=" + this.f39482a + ", allDuration=" + this.f39483b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class w extends DefaultVideoPlayerStatusListener {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeVideoView f39485a;

        /* renamed from: b, reason: collision with root package name */
        private int f39486b;

        /* renamed from: c, reason: collision with root package name */
        private int f39487c;

        /* renamed from: d, reason: collision with root package name */
        private int f39488d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f39489e;

        /* renamed from: f, reason: collision with root package name */
        private com.iab.omid.library.mmadbridge.adsession.media.a f39490f;

        /* renamed from: k, reason: collision with root package name */
        private boolean f39495k;

        /* renamed from: l, reason: collision with root package name */
        private String f39496l;

        /* renamed from: m, reason: collision with root package name */
        private CampaignEx f39497m;

        /* renamed from: n, reason: collision with root package name */
        private int f39498n;

        /* renamed from: o, reason: collision with root package name */
        private int f39499o;

        /* renamed from: g, reason: collision with root package name */
        private v f39491g = new v();

        /* renamed from: h, reason: collision with root package name */
        private boolean f39492h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f39493i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f39494j = false;

        /* renamed from: p, reason: collision with root package name */
        private boolean f39500p = false;

        public w(MBridgeVideoView mBridgeVideoView) {
            this.f39485a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.f39496l = mBridgeVideoView.getUnitId();
                this.f39497m = mBridgeVideoView.getCampaign();
            }
        }

        private void a(int i11) {
            if (i11 <= 0) {
                this.f39485a.f39423m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_shape_progress", "drawable"));
                return;
            }
            this.f39485a.f39423m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_time_count_num_bg", "drawable"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 30.0f));
            int a11 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f);
            layoutParams.addRule(1, g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_native_endcard_feed_btn", "id"));
            layoutParams.setMargins(a11, 0, 0, 0);
            this.f39485a.f39423m.setPadding(a11, 0, a11, 0);
            this.f39485a.f39423m.setLayoutParams(layoutParams);
        }

        private void a(int i11, int i12) {
            int i13;
            String str;
            int i14 = this.f39498n;
            if (i14 == 100 || this.f39500p || i14 == 0) {
                return;
            }
            if (this.f39499o > i14) {
                this.f39499o = i14 / 2;
            }
            int i15 = this.f39499o;
            if (i15 < 0 || i11 < (i13 = (i12 * i15) / 100)) {
                return;
            }
            if (this.f39497m.getAdType() == 94 || this.f39497m.getAdType() == 287) {
                str = this.f39497m.getRequestId() + this.f39497m.getId() + this.f39497m.getVideoUrlEncode();
            } else {
                str = this.f39497m.getId() + this.f39497m.getVideoUrlEncode() + this.f39497m.getBidToken();
            }
            com.mbridge.msdk.videocommon.download.a a11 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f39496l, str);
            if (a11 != null) {
                a11.v();
                this.f39500p = true;
                o0.b("DefaultVideoPlayerStatusListener", "CDRate is : " + i13 + " and start download !");
            }
        }

        private void a(int i11, int i12, int i13) {
            StringBuilder sb2;
            String str;
            String sb3;
            String str2;
            int i14 = 0;
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            if (mBridgeVideoView == null) {
                return;
            }
            if (this.f39495k) {
                str2 = String.format("%s", Integer.valueOf(i12 - i13));
            } else {
                if (i11 > i12) {
                    i11 = i12;
                }
                int i15 = i11 <= 0 ? i12 - i13 : i11 - i13;
                if (i15 <= 0) {
                    sb3 = i11 <= 0 ? "0" : (String) mBridgeVideoView.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
                } else {
                    if (i11 <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append(i15);
                        str = "";
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(i15);
                        str = (String) this.f39485a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left", "string"));
                    }
                    sb2.append(str);
                    sb3 = sb2.toString();
                    i14 = i15;
                }
                if (i14 < this.f39485a.C0 && this.f39485a.E0 != null && this.f39485a.J) {
                    this.f39485a.E0.onTimeLessThanReduce(i14);
                }
                str2 = sb3;
            }
            CampaignEx campaignEx = this.f39497m;
            if (campaignEx != null && campaignEx.getUseSkipTime() == 1) {
                int min = Math.min(this.f39485a.L, i12);
                if (min >= i11 || min < 0) {
                    int i16 = i11 - i13;
                    if (this.f39495k) {
                        if (i16 > 0) {
                            str2 = i16 + ((String) this.f39485a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                        } else if (i16 == 0) {
                            this.f39485a.f39423m.setVisibility(4);
                        }
                    }
                } else {
                    int i17 = min - i13;
                    if (i17 > 0) {
                        str2 = i17 + ((String) this.f39485a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                    } else if (this.f39495k && i17 == 0) {
                        this.f39485a.f39423m.setVisibility(4);
                    }
                }
            }
            this.f39485a.f39423m.setText(str2);
            if (this.f39485a.f39431q == null || this.f39485a.f39431q.getVisibility() != 0) {
                return;
            }
            this.f39485a.f39431q.setProgress(i13);
        }

        private void b(int i11) {
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            if (mBridgeVideoView == null || mBridgeVideoView.f39423m == null) {
                return;
            }
            String str = "mbridge_reward_video_time_count_num_bg";
            if (this.f39497m.getDynamicTempCode() == 5) {
                MBridgeVideoView mBridgeVideoView2 = this.f39485a;
                if (mBridgeVideoView2.mCurrPlayNum > 1 && i11 <= 0) {
                    mBridgeVideoView2.f39423m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                    e();
                    return;
                }
            }
            if (i11 <= 0) {
                str = "mbridge_reward_shape_progress";
            } else if (!this.f39495k || this.f39497m.getDynamicTempCode() == 5) {
                e();
            }
            CampaignEx campaignEx = this.f39497m;
            if (campaignEx != null && campaignEx.getUseSkipTime() == 1 && this.f39495k) {
                e();
            }
            this.f39485a.f39423m.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "drawable"));
        }

        private void b(int i11, int i12, int i13) {
            int i14;
            StringBuilder sb2;
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            if (mBridgeVideoView == null) {
                return;
            }
            String str = (String) mBridgeVideoView.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
            String str2 = (String) this.f39485a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left", "string"));
            if (i11 >= 0) {
                if (this.f39497m.getUseSkipTime() == 1) {
                    int min = Math.min(this.f39485a.L, i11);
                    if (min >= i11 || min <= 0) {
                        i14 = i11 - i13;
                        if (this.f39495k) {
                            if (i14 <= 0) {
                                this.f39485a.f39423m.setVisibility(4);
                            } else {
                                str2 = (String) this.f39485a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string"));
                            }
                        }
                    } else {
                        i14 = min - i13;
                        if (i14 <= 0) {
                            i14 = i11 - i13;
                            if (this.f39495k) {
                                this.f39485a.f39423m.setVisibility(4);
                            }
                        } else {
                            str2 = (String) this.f39485a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string"));
                        }
                    }
                } else {
                    i14 = i11 - i13;
                }
                if (i14 > 0) {
                    str = i14 + str2;
                }
            } else {
                i14 = i12 - i13;
                if (i14 > 0) {
                    if (i11 <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append(i14);
                        sb2.append("");
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(i14);
                        sb2.append(str2);
                    }
                    str = sb2.toString();
                } else if (i11 <= 0) {
                    str = "0";
                }
            }
            this.f39491g.f39482a = i13;
            this.f39485a.f39423m.setText(str);
            if (this.f39485a.f39431q != null && this.f39485a.f39431q.getVisibility() == 0) {
                this.f39485a.f39431q.setProgress(i13);
            }
            if (i14 >= this.f39485a.C0 || this.f39485a.E0 == null || !this.f39485a.J) {
                return;
            }
            this.f39485a.E0.onTimeLessThanReduce(i14);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0090 A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:15:0x0026, B:17:0x002e, B:20:0x0039, B:21:0x0084, B:23:0x0090, B:25:0x009a, B:30:0x0060), top: B:14:0x0026 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void c() {
            /*
                r4 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                com.mbridge.msdk.foundation.tools.q0 r1 = com.mbridge.msdk.foundation.tools.q0.a()
                java.lang.String r2 = "h_c_r_w_p_c"
                r3 = 0
                boolean r1 = r1.a(r2, r3)
                if (r1 != 0) goto L10
                return
            L10:
                int r1 = r4.f39498n
                r2 = 100
                if (r1 == r2) goto Lab
                int r2 = r4.f39499o
                if (r2 != 0) goto Lab
                boolean r2 = r4.f39500p
                if (r2 != 0) goto Lab
                if (r1 == 0) goto Lab
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r4.f39497m
                if (r1 != 0) goto L26
                goto Lab
            L26:
                int r1 = r1.getAdType()     // Catch: java.lang.Exception -> L5e
                r2 = 94
                if (r1 == r2) goto L60
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                int r1 = r1.getAdType()     // Catch: java.lang.Exception -> L5e
                r2 = 287(0x11f, float:4.02E-43)
                if (r1 != r2) goto L39
                goto L60
            L39:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
                r1.<init>()     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getId()     // Catch: java.lang.Exception -> L5e
                r1.append(r2)     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getVideoUrlEncode()     // Catch: java.lang.Exception -> L5e
                r1.append(r2)     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getBidToken()     // Catch: java.lang.Exception -> L5e
                r1.append(r2)     // Catch: java.lang.Exception -> L5e
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L5e
                goto L84
            L5e:
                r1 = move-exception
                goto La0
            L60:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
                r1.<init>()     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getRequestId()     // Catch: java.lang.Exception -> L5e
                r1.append(r2)     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getId()     // Catch: java.lang.Exception -> L5e
                r1.append(r2)     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r4.f39497m     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getVideoUrlEncode()     // Catch: java.lang.Exception -> L5e
                r1.append(r2)     // Catch: java.lang.Exception -> L5e
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L5e
            L84:
                com.mbridge.msdk.videocommon.download.b r2 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch: java.lang.Exception -> L5e
                java.lang.String r3 = r4.f39496l     // Catch: java.lang.Exception -> L5e
                com.mbridge.msdk.videocommon.download.a r1 = r2.a(r3, r1)     // Catch: java.lang.Exception -> L5e
                if (r1 == 0) goto Lab
                r1.v()     // Catch: java.lang.Exception -> L5e
                r1 = 1
                r4.f39500p = r1     // Catch: java.lang.Exception -> L5e
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Exception -> L5e
                if (r1 == 0) goto Lab
                java.lang.String r1 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.o0.b(r0, r1)     // Catch: java.lang.Exception -> L5e
                goto Lab
            La0:
                boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r2 == 0) goto Lab
                java.lang.String r1 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r1)
            Lab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.w.c():void");
        }

        private void e() {
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            if (mBridgeVideoView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.f39423m.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 25.0f);
                this.f39485a.f39423m.setLayoutParams(layoutParams);
            }
            int a11 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f);
            this.f39485a.f39423m.setPadding(a11, 0, a11, 0);
        }

        public int a() {
            return this.f39486b;
        }

        public void a(CampaignEx campaignEx) {
            this.f39497m = campaignEx;
        }

        public void a(String str) {
            this.f39496l = str;
        }

        public void a(boolean z10) {
            this.f39495k = z10;
        }

        public int b() {
            return this.f39488d;
        }

        public void b(int i11, int i12) {
            this.f39498n = i11;
            this.f39499o = i12;
            c();
        }

        public void d() {
            this.f39485a = null;
            boolean unused = MBridgeVideoView.W0 = false;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f39490f;
                if (aVar != null) {
                    aVar.b();
                    o0.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.f39485a.notifyListener.a(14, "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if (this.f39490f != null) {
                    o0.a("omsdk", "play:  videoEvents.bufferStart()");
                    this.f39490f.c();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingTimeOut(String str) {
            try {
                this.f39485a.notifyListener.a(13, "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayCompleted() {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            this.f39485a.f39436s0 = true;
            CampaignEx campaignEx = this.f39497m;
            if (campaignEx != null) {
                if (this.f39495k && campaignEx.getRewardTemplateMode() != null && this.f39497m.getRewardTemplateMode().f() == 5002010) {
                    this.f39485a.f39423m.setText("0");
                } else {
                    this.f39485a.f39423m.setText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
                }
                this.f39497m.setVideoPlayProgress(100);
                if (this.f39497m.getAdSpaceT() == 2) {
                    this.f39485a.f39425n.setVisibility(4);
                    if (this.f39485a.f39433r != null) {
                        this.f39485a.f39433r.setClickable(false);
                    }
                    SoundImageView soundImageView = this.f39485a.mSoundImageView;
                    if (soundImageView != null) {
                        soundImageView.setClickable(false);
                    }
                }
            } else {
                this.f39485a.f39423m.setText("0");
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f39490f;
            if (aVar != null) {
                aVar.d();
                o0.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f39485a.mPlayerView.setClickable(false);
            String c11 = this.f39485a.c(true);
            CampaignEx campaignEx2 = this.f39497m;
            if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && this.f39497m.getRewardTemplateMode().f() == 5002010) {
                this.f39485a.x();
            }
            CampaignEx campaignEx3 = this.f39497m;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (mBridgeVideoView = this.f39485a) != null && mBridgeVideoView.f39445x != null) {
                MBridgeVideoView mBridgeVideoView2 = this.f39485a;
                if (mBridgeVideoView2.mCampaignSize > mBridgeVideoView2.mCurrPlayNum) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(RequestParameters.POSITION, Integer.valueOf(this.f39485a.mCurrPlayNum));
                    int i11 = this.f39485a.mMuteSwitch;
                    if (i11 != 0) {
                        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i11));
                    }
                    this.f39485a.f39445x.a(hashMap);
                    return;
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f39485a;
            if (mBridgeVideoView3 != null) {
                mBridgeVideoView3.notifyListener.a(Sdk$SDKError.Reason.TPAT_ERROR_VALUE, "");
                this.f39485a.notifyListener.a(11, c11);
            }
            int i12 = this.f39487c;
            this.f39486b = i12;
            this.f39485a.mCurrentPlayProgressTime = i12;
            boolean unused = MBridgeVideoView.W0 = true;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayError(String str) {
            o0.b("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.notifyListener.a(12, str);
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayProgress(int i11, int i12) {
            CampaignEx campaignEx;
            int i13;
            super.onPlayProgress(i11, i12);
            if (MBridgeVideoView.X0 == 0) {
                long unused = MBridgeVideoView.X0 = System.currentTimeMillis();
            }
            if (!this.f39485a.M0 && this.f39485a.f39447y != null) {
                this.f39485a.M0 = true;
                this.f39485a.f39447y.a();
            }
            if (this.f39485a.f39283e) {
                CampaignEx campaignEx2 = this.f39497m;
                if (campaignEx2 != null) {
                    i13 = campaignEx2.getVideoCompleteTime();
                    if (i13 <= 0) {
                        i13 = i12;
                    }
                    com.mbridge.msdk.foundation.feedback.b.b().b(this.f39497m.getCampaignUnitId() + "_1", i11);
                } else {
                    i13 = 0;
                }
                CampaignEx campaignEx3 = this.f39497m;
                if (campaignEx3 != null && campaignEx3.isDynamicView() && this.f39497m.getDynamicTempCode() == 5) {
                    try {
                        b(i13, this.f39485a.f39449z, i11);
                    } catch (Exception e11) {
                        o0.b("DefaultVideoPlayerStatusListener", e11.getMessage());
                    }
                } else {
                    a(i13, i12, i11);
                    this.f39491g.f39482a = i11;
                }
            }
            this.f39487c = i12;
            v vVar = this.f39491g;
            vVar.f39483b = i12;
            vVar.f39484c = this.f39485a.f39440u0;
            this.f39486b = i11;
            if (this.f39485a.f39435s != null) {
                this.f39485a.f39435s.setTag("" + this.f39486b);
            }
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            mBridgeVideoView.mCurrentPlayProgressTime = i11;
            mBridgeVideoView.notifyListener.a(15, this.f39491g);
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f39490f;
            if (aVar != null) {
                int i14 = (i11 * 100) / i12;
                int i15 = ((i11 + 1) * 100) / i12;
                if (i14 <= 25 && 25 < i15 && !this.f39492h) {
                    this.f39492h = true;
                    aVar.h();
                    o0.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i14 <= 50 && 50 < i15 && !this.f39493i) {
                    this.f39493i = true;
                    aVar.i();
                    o0.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i14 <= 75 && 75 < i15 && !this.f39494j) {
                    this.f39494j = true;
                    aVar.o();
                    o0.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            if (this.f39485a.f39417g0 && !this.f39485a.f39428o0 && this.f39485a.f39422l0 == com.mbridge.msdk.foundation.same.a.I) {
                this.f39485a.y();
            }
            try {
                MBridgeVideoView mBridgeVideoView2 = this.f39485a;
                if (mBridgeVideoView2 != null && mBridgeVideoView2.f39437t != null) {
                    int i16 = (i11 * 100) / i12;
                    this.f39485a.f39437t.setProgress(i16, this.f39485a.mCurrPlayNum - 1);
                    this.f39497m.setVideoPlayProgress(i16);
                }
                MBridgeVideoView mBridgeVideoView3 = this.f39485a;
                if (mBridgeVideoView3 != null) {
                    int i17 = mBridgeVideoView3.F != -5 ? this.f39485a.F : this.f39485a.E;
                    if (i17 != -1 && i11 == i17 && (campaignEx = this.f39485a.f39280b) != null && campaignEx.isDynamicView()) {
                        this.f39485a.setCTALayoutVisibleOrGone();
                    }
                }
            } catch (Throwable th2) {
                o0.b("DefaultVideoPlayerStatusListener", th2.getMessage());
            }
            a(i11, i12);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayStarted(int i11) {
            PlayerView playerView;
            CampaignEx campaignEx;
            super.onPlayStarted(i11);
            MBridgeVideoView mBridgeVideoView = this.f39485a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.g();
            }
            if (!this.f39489e) {
                MBridgeVideoView mBridgeVideoView2 = this.f39485a;
                if (mBridgeVideoView2 != null) {
                    mBridgeVideoView2.A = true;
                    this.f39485a.notifyListener.a(10, this.f39491g);
                }
                this.f39489e = true;
            }
            this.f39488d = i11;
            CampaignEx campaignEx2 = this.f39497m;
            if (campaignEx2 != null) {
                int videoCompleteTime = campaignEx2.getVideoCompleteTime();
                if (videoCompleteTime <= 0) {
                    videoCompleteTime = i11;
                }
                if (this.f39497m.isDynamicView()) {
                    b(videoCompleteTime);
                } else {
                    a(videoCompleteTime);
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f39485a;
            if (mBridgeVideoView3 != null && mBridgeVideoView3.f39431q != null) {
                this.f39485a.f39431q.setMax(i11);
            }
            MBridgeVideoView mBridgeVideoView4 = this.f39485a;
            if (mBridgeVideoView4 != null && mBridgeVideoView4.f39427o != null && (campaignEx = this.f39497m) != null && campaignEx.getAdSpaceT() == 2) {
                this.f39485a.f39427o.setVisibility(0);
            }
            MBridgeVideoView mBridgeVideoView5 = this.f39485a;
            if (mBridgeVideoView5 != null && mBridgeVideoView5.f39423m != null && this.f39485a.f39423m.getVisibility() == 0) {
                this.f39485a.f();
            }
            boolean unused = MBridgeVideoView.W0 = false;
            if (this.f39485a != null && this.f39497m.isDynamicView()) {
                if (this.f39485a.F != -5) {
                    if (this.f39485a.F == 0) {
                        this.f39485a.setCTALayoutVisibleOrGone();
                    }
                } else if (this.f39485a.E == 0) {
                    this.f39485a.setCTALayoutVisibleOrGone();
                }
            }
            MBridgeVideoView mBridgeVideoView6 = this.f39485a;
            if (mBridgeVideoView6 != null) {
                mBridgeVideoView6.showMoreOfferInPlayTemplate();
                this.f39485a.showBaitClickView();
                this.f39485a.q();
            }
            if (this.f39490f != null) {
                try {
                    MBridgeVideoView mBridgeVideoView7 = this.f39485a;
                    this.f39490f.n(i11, (mBridgeVideoView7 == null || (playerView = mBridgeVideoView7.mPlayerView) == null) ? 0.0f : playerView.getVolume());
                    o0.a("omsdk", "play video view:  videoEvents.start");
                } catch (Exception e11) {
                    o0.b("omsdk", e11.getMessage());
                }
            }
        }
    }

    public MBridgeVideoView(Context context) {
        super(context);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.f39443w = false;
        this.f39449z = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.Q = "";
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f39411a0 = false;
        this.f39412b0 = false;
        this.f39413c0 = false;
        this.f39414d0 = false;
        this.f39415e0 = false;
        this.f39417g0 = false;
        this.f39418h0 = 2;
        this.f39428o0 = false;
        this.f39430p0 = false;
        this.f39432q0 = false;
        this.f39434r0 = true;
        this.f39436s0 = false;
        this.f39438t0 = false;
        this.f39440u0 = false;
        this.f39442v0 = false;
        this.f39444w0 = false;
        this.f39450z0 = 0;
        this.A0 = 5;
        this.B0 = 5;
        this.C0 = 5;
        this.F0 = false;
        this.J0 = false;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        this.N0 = new w(this);
        this.O0 = false;
        this.P0 = new k();
        this.Q0 = new m();
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.f39443w = false;
        this.f39449z = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.Q = "";
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f39411a0 = false;
        this.f39412b0 = false;
        this.f39413c0 = false;
        this.f39414d0 = false;
        this.f39415e0 = false;
        this.f39417g0 = false;
        this.f39418h0 = 2;
        this.f39428o0 = false;
        this.f39430p0 = false;
        this.f39432q0 = false;
        this.f39434r0 = true;
        this.f39436s0 = false;
        this.f39438t0 = false;
        this.f39440u0 = false;
        this.f39442v0 = false;
        this.f39444w0 = false;
        this.f39450z0 = 0;
        this.A0 = 5;
        this.B0 = 5;
        this.C0 = 5;
        this.F0 = false;
        this.J0 = false;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        this.N0 = new w(this);
        this.O0 = false;
        this.P0 = new k();
        this.Q0 = new m();
    }

    static /* synthetic */ int W(MBridgeVideoView mBridgeVideoView) {
        int i11 = mBridgeVideoView.A0;
        mBridgeVideoView.A0 = i11 - 1;
        return i11;
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).w();
    }

    private String a(int i11, int i12) {
        if (i12 != 0) {
            try {
                return t0.a(Double.valueOf(i11 / i12)) + "";
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return i12 + "";
    }

    private void a(ViewGroup viewGroup, CampaignEx campaignEx) {
        com.mbridge.msdk.video.dynview.c b11 = new com.mbridge.msdk.video.dynview.wrapper.c().b(viewGroup, campaignEx);
        com.mbridge.msdk.video.dynview.b.a().a(b11, new l(viewGroup, b11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            com.mbridge.msdk.video.module.listener.a r0 = r8.f39439u
            if (r0 == 0) goto L9a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f39280b
            if (r0 == 0) goto L55
            r1 = 1
            r0.setClickTempSource(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f39280b     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = ""
            if (r0 == 0) goto L29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2b
            r2.<init>()     // Catch: java.lang.Exception -> L2b
            int r0 = r0.f()     // Catch: java.lang.Exception -> L2b
            r2.append(r0)     // Catch: java.lang.Exception -> L2b
            r2.append(r1)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L2b
        L29:
            r7 = r1
            goto L2d
        L2b:
            r9 = move-exception
            goto L52
        L2d:
            android.content.Context r0 = r8.f39279a     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f39280b     // Catch: java.lang.Exception -> L2b
            java.lang.String r2 = r1.getCampaignUnitId()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f39280b     // Catch: java.lang.Exception -> L2b
            boolean r3 = r1.isBidCampaign()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f39280b     // Catch: java.lang.Exception -> L2b
            java.lang.String r4 = r1.getRequestId()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f39280b     // Catch: java.lang.Exception -> L2b
            java.lang.String r5 = r1.getRequestIdNotice()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f39280b     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = r1.getId()     // Catch: java.lang.Exception -> L2b
            r1 = r9
            com.mbridge.msdk.foundation.same.report.j.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L2b
            goto L55
        L52:
            r9.printStackTrace()
        L55:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> L67
            r9.<init>()     // Catch: org.json.JSONException -> L67
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f35392j     // Catch: org.json.JSONException -> L65
            r1 = 0
            org.json.JSONObject r1 = r8.a(r1)     // Catch: org.json.JSONException -> L65
            r9.put(r0, r1)     // Catch: org.json.JSONException -> L65
            goto L6d
        L65:
            r0 = move-exception
            goto L6a
        L67:
            r9 = move-exception
            r0 = r9
            r9 = 0
        L6a:
            r0.printStackTrace()
        L6d:
            com.mbridge.msdk.video.module.listener.a r0 = r8.f39439u
            r1 = 105(0x69, float:1.47E-43)
            r0.a(r1, r9)
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r9 = r9.d()
            if (r9 == 0) goto L9a
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L90
            android.content.Context r9 = r9.d()     // Catch: java.lang.Exception -> L90
            android.content.Context r9 = r9.getApplicationContext()     // Catch: java.lang.Exception -> L90
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f39280b     // Catch: java.lang.Exception -> L90
            com.mbridge.msdk.video.module.report.b.a(r9, r0)     // Catch: java.lang.Exception -> L90
            goto L9a
        L90:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            java.lang.String r0 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.o0.b(r0, r9)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.b(java.lang.String):void");
    }

    private boolean b(int i11, int i12) {
        return i11 > 0 && i12 > 0 && t0.g(this.f39279a) >= i11 && t0.f(this.f39279a) >= i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(boolean z10) {
        if (!this.f39417g0) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.f39428o0) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.F);
            }
            if (this.f39432q0) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.D);
            }
            if (this.f39430p0) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.E);
            }
            jSONObject.put("complete_info", z10 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            o0.b(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.Q);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.Q + "_1", this.f39280b);
        }
        if (!com.mbridge.msdk.foundation.feedback.b.b().a()) {
            FeedBackButton feedBackButton = this.f39433r;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f39433r != null) {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.Q + "_1", this.f39433r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        CollapsibleWebView collapsibleWebView = this.H0;
        if (collapsibleWebView == null || this.f39280b == null || !TextUtils.isEmpty(collapsibleWebView.getUrl())) {
            return;
        }
        this.H0.loadUrl(this.f39280b.getClickURL());
        this.H0.setToolBarTitle(this.f39280b.getAppName());
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = com.mbridge.msdk.setting.h.b().a();
        }
        this.H0.setPageLoadTimtout((int) d11.o0());
        this.H0.setPageLoadListener(new d());
        this.H0.setWebViewClient(new e());
        this.H0.setCollapseListener(new f());
        this.H0.setExpandListener(new g());
        this.H0.setExitsClickListener(new h());
    }

    private int getCDRate() {
        return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).g();
    }

    private int getVideoAllDuration() {
        try {
            w wVar = this.N0;
            int b11 = wVar != null ? wVar.b() : 0;
            return b11 == 0 ? this.f39280b.getVideoLength() : b11;
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getVideoCompleteTime() {
        int videoAllDuration;
        CampaignEx campaignEx;
        int i11 = 0;
        try {
            videoAllDuration = getVideoAllDuration();
            campaignEx = this.f39280b;
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
        if (campaignEx == null) {
            return videoAllDuration;
        }
        i11 = campaignEx.getVideoCompleteTime();
        if (this.f39280b.getDynamicTempCode() != 5 && i11 > videoAllDuration) {
            i11 = videoAllDuration;
        }
        if (i11 <= 0) {
            return videoAllDuration;
        }
        return i11;
    }

    private void h() {
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (g0.a(findLayout)) {
            this.f39281c.inflate(findLayout, this);
            n();
        }
        W0 = false;
        r();
    }

    private void i() {
        if (this.O0 || this.f39414d0 || this.f39412b0) {
            return;
        }
        this.O0 = true;
        int i11 = this.L;
        if (i11 < 0) {
            return;
        }
        if (i11 == 0) {
            this.f39414d0 = true;
        } else {
            new Handler().postDelayed(new a(), this.L * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.B == null) {
            return;
        }
        if (this.C == null) {
            addCTAView();
        }
        if (this.B.getVisibility() != 0) {
            this.B.setVisibility(0);
            postDelayed(this.P0, 3000L);
        } else {
            this.B.setVisibility(8);
            getHandler().removeCallbacks(this.P0);
        }
    }

    private void k() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !y0.b(campaignEx.getVideoResolution())) {
            return;
        }
        String videoResolution = this.f39280b.getVideoResolution();
        o0.c(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
        String[] split = videoResolution.split("x");
        if (split.length == 2) {
            if (t0.m(split[0]) > 0.0d) {
                this.R = t0.m(split[0]);
            }
            if (t0.m(split[1]) > 0.0d) {
                this.S = t0.m(split[1]);
            }
            o0.c(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.R + "  mVideoH:" + this.S);
        }
        if (this.R <= 0.0d) {
            this.R = 1280.0d;
        }
        if (this.S <= 0.0d) {
            this.S = 720.0d;
        }
    }

    private boolean l() {
        try {
            this.mPlayerView = (PlayerView) findViewById(filterFindViewId(this.f39444w0, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(filterFindViewId(this.f39444w0, "mbridge_sound_switch"));
            this.f39423m = (TextView) findViewById(filterFindViewId(this.f39444w0, "mbridge_tv_count"));
            View findViewById = findViewById(filterFindViewId(this.f39444w0, "mbridge_rl_playing_close"));
            this.f39425n = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            this.f39427o = (RelativeLayout) findViewById(filterFindViewId(this.f39444w0, "mbridge_top_control"));
            this.f39429p = (ImageView) findViewById(filterFindViewId(this.f39444w0, "mbridge_videoview_bg"));
            this.f39431q = (ProgressBar) findViewById(filterFindViewId(this.f39444w0, "mbridge_video_progress_bar"));
            this.f39433r = (FeedBackButton) findViewById(filterFindViewId(this.f39444w0, "mbridge_native_endcard_feed_btn"));
            this.f39435s = (ImageView) findViewById(filterFindViewId(this.f39444w0, "mbridge_iv_link"));
            this.G0 = (RelativeLayout) findViewById(filterFindViewId(this.f39444w0, "mbridge_reward_scale_webview_layout"));
            this.I0 = (RelativeLayout) findViewById(filterFindViewId(this.f39444w0, "mbridge_reward_header_layout"));
            if (this.G0 != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.H0 = collapsibleWebView;
                this.G0.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            t0.a(1, this.f39435s, this.f39280b, this.f39279a, false, new t());
            this.f39437t = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.f39444w0, "mbridge_reward_segment_progressbar"));
            this.B = (FrameLayout) findViewById(filterFindViewId(this.f39444w0, "mbridge_reward_cta_layout"));
            this.f39448y0 = (MBridgeBaitClickView) findViewById(filterFindViewId(this.f39444w0, "mbridge_animation_click_view"));
            this.G = (RelativeLayout) findViewById(filterFindViewId(this.f39444w0, "mbridge_reward_moreoffer_layout"));
            this.E0 = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.f39444w0, "mbridge_reward_popview"));
            this.tvFlag = (TextView) findViewById(filterFindViewId(this.f39444w0, "mbridge_tv_flag"));
            return isNotNULL(this.mPlayerView, this.mSoundImageView, this.f39423m, this.f39425n);
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    private boolean m() {
        int videoCompleteTime = getVideoCompleteTime();
        int curPosition = (this.mPlayerView.getCurPosition() / 1000) + 1;
        if (this.f39280b.getDynamicTempCode() != 5 || this.mCurrPlayNum <= 1) {
            if ((videoCompleteTime > 0 && curPosition < videoCompleteTime) || videoCompleteTime == 0) {
                return true;
            }
        } else if (videoCompleteTime != 0 && videoCompleteTime > 0 && curPosition < videoCompleteTime) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        PlayerView playerView;
        boolean l11 = l();
        this.f39283e = l11;
        if (!l11) {
            o0.b(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        if (q0.a().a("i_l_s_t_r_i", false) && (playerView = this.mPlayerView) != null) {
            playerView.setNotifyListener(new n());
        }
        d();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.f39446x0 = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z10;
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.onPause();
                CampaignEx campaignEx = this.f39280b;
                if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
                    removeCallbacks(this.Q0);
                }
                if (com.mbridge.msdk.util.b.a()) {
                    PlayerView playerView2 = this.mPlayerView;
                    if (!this.F0 && !this.I && !this.J) {
                        z10 = false;
                        playerView2.setIsCovered(z10);
                    }
                    z10 = true;
                    playerView2.setIsCovered(z10);
                }
                CampaignEx campaignEx2 = this.f39280b;
                if (campaignEx2 == null || campaignEx2.getNativeVideoTracking() == null || this.f39280b.isHasReportAdTrackPause()) {
                    return;
                }
                this.f39280b.setHasReportAdTrackPause(true);
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                CampaignEx campaignEx3 = this.f39280b;
                com.mbridge.msdk.click.a.a(d11, campaignEx3, this.Q, campaignEx3.getNativeVideoTracking().n(), false, false);
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        w wVar;
        RelativeLayout relativeLayout;
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f39280b.getRewardTemplateMode().f() != 5002010 || (relativeLayout = this.I0) == null || relativeLayout.getVisibility() == 0) {
                if (!this.U) {
                    boolean playVideo = this.mPlayerView.playVideo();
                    CampaignEx campaignEx2 = this.f39280b;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() != 2 && !playVideo && (wVar = this.N0) != null) {
                        wVar.onPlayError("play video failed");
                    }
                    this.U = true;
                    return;
                }
                MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
                if (mBAcquireRewardPopView != null && this.J) {
                    mBAcquireRewardPopView.onResume();
                }
                if (this.J) {
                    return;
                }
                if (!com.mbridge.msdk.util.b.a()) {
                    w();
                } else {
                    if (this.F0 || this.I) {
                        return;
                    }
                    this.mPlayerView.setIsCovered(false);
                    w();
                }
            }
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage(), e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        String e11;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.H) {
            return;
        }
        if (!TextUtils.isEmpty(this.f39280b.getMof_template_url())) {
            e11 = this.f39280b.getMof_template_url();
        } else if (this.f39280b.getRewardTemplateMode() == null) {
            return;
        } else {
            e11 = this.f39280b.getRewardTemplateMode().e();
        }
        if (TextUtils.isEmpty(e11)) {
            return;
        }
        try {
            String a11 = z0.a(e11, "guideShow");
            String a12 = z0.a(e11, "guideDelay");
            String a13 = z0.a(e11, "guideTime");
            String a14 = z0.a(e11, "guideRewardTime");
            if (!TextUtils.isEmpty(a11)) {
                this.f39450z0 = Integer.parseInt(a11);
            }
            if (!TextUtils.isEmpty(a12)) {
                int parseInt = Integer.parseInt(a12);
                this.A0 = parseInt;
                if (parseInt > 10 || parseInt < 3) {
                    this.A0 = 5;
                }
            }
            if (!TextUtils.isEmpty(a13)) {
                int parseInt2 = Integer.parseInt(a13);
                this.B0 = parseInt2;
                if (parseInt2 > 10 || parseInt2 < 3) {
                    this.B0 = 5;
                }
            }
            if (!TextUtils.isEmpty(a14)) {
                int parseInt3 = Integer.parseInt(a14);
                this.C0 = parseInt3;
                if (parseInt3 > 10 || parseInt3 < 5) {
                    this.C0 = 5;
                }
            }
            int i11 = this.f39450z0;
            if (i11 > 0 && i11 <= 2) {
                int videoCompleteTime = getVideoCompleteTime();
                if (videoCompleteTime == 0 || videoCompleteTime > this.A0) {
                    int i12 = videoCompleteTime - this.A0;
                    if (i12 >= 0 && this.C0 > i12) {
                        this.C0 = i12;
                    }
                    int videoAllDuration = getVideoAllDuration();
                    if (this.C0 >= videoAllDuration) {
                        this.C0 = videoAllDuration - this.A0;
                    }
                    if (this.A0 >= videoAllDuration) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.f39280b.getAppName());
                    com.mbridge.msdk.setting.g b11 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
                    this.D0 = new AcquireRewardPopViewParameters.Builder("", this.Q, this.f39450z0, b11 != null ? b11.k() : "US").setAutoDismissTime(this.B0).setReduceTime(this.C0).setBehaviourListener(new j()).setRightAnswerList(arrayList).build();
                    postDelayed(this.Q0, 1000L);
                }
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    private void r() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || campaignEx.getAdSpaceT() != 2 || this.tvFlag == null) {
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.tvFlag.setText("AD");
        } else {
            this.tvFlag.setText("广告");
        }
    }

    private void s() {
        int i11;
        int i12;
        float g11 = t0.g(this.f39279a);
        float f11 = t0.f(this.f39279a);
        double d11 = this.R;
        if (d11 > 0.0d) {
            double d12 = this.S;
            if (d12 > 0.0d && g11 > 0.0f && f11 > 0.0f) {
                double d13 = d11 / d12;
                double d14 = g11 / f11;
                o0.c(MBridgeBaseView.TAG, "videoWHDivide:" + d13 + "  screenWHDivide:" + d14);
                double a11 = t0.a(Double.valueOf(d13));
                double a12 = t0.a(Double.valueOf(d14));
                o0.c(MBridgeBaseView.TAG, "videoWHDivideFinal:" + a11 + "  screenWHDivideFinal:" + a12);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
                if (a11 > a12) {
                    double d15 = (g11 * this.S) / this.R;
                    layoutParams.width = -1;
                    layoutParams.height = (int) d15;
                    layoutParams.gravity = 17;
                } else if (a11 < a12) {
                    layoutParams.width = (int) (f11 * d13);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    CampaignEx campaignEx = this.f39280b;
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        if (this.f39280b.getRewardTemplateMode() != null) {
                            i12 = this.f39280b.getRewardTemplateMode().f();
                            i11 = this.f39280b.getRewardTemplateMode().b();
                        } else {
                            i11 = this.f39279a.getResources().getConfiguration().orientation;
                            i12 = 904;
                        }
                        if (i12 == 102 || i12 == 202) {
                            if (i11 == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.S / (this.R / g11));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (f11 * d13);
                            }
                        }
                        if (i12 == 202 && !TextUtils.isEmpty(this.f39280b.getImageUrl())) {
                            setBlurBackgroundImage(this.f39280b.getImageUrl());
                        }
                        if (i12 == 302 || i12 == 802 || i12 == 5002010) {
                            double d16 = this.R;
                            double d17 = this.S;
                            if (d16 / d17 > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((d17 * g11) / d16);
                            } else {
                                int a13 = t0.a(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.R * a13) / this.S);
                                layoutParams.height = a13;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    o0.b(MBridgeBaseView.TAG, th2.getMessage());
                }
                this.mPlayerView.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        v();
    }

    private void setBlurBackgroundImage(String str) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str, new c());
    }

    private void setPlayerViewRadius(int i11) {
        if (i11 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t0.a(getContext(), i11));
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(1, 0);
            setBackground(gradientDrawable);
            this.mPlayerView.setBackground(gradientDrawable);
            setClipToOutline(true);
            this.mPlayerView.setClipToOutline(true);
        }
    }

    private void t() {
    }

    private void u() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null) {
            return;
        }
        if (campaignEx.getAdSpaceT() == 2) {
            t();
        } else {
            s();
        }
    }

    private void v() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.f39283e) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
            int g11 = t0.g(this.f39279a);
            layoutParams.width = -1;
            layoutParams.height = (g11 * 9) / 16;
            layoutParams.gravity = 17;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void w() {
        if (this.f39436s0) {
            if (!this.f39438t0) {
                this.mPlayerView.seekToEndFrame();
            }
            this.f39438t0 = true;
        } else {
            this.mPlayerView.onResume();
        }
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || campaignEx.isRewardPopViewShowed) {
            return;
        }
        post(this.Q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!this.f39283e || this.f39425n.getVisibility() == 0) {
            return;
        }
        if (!this.f39286h) {
            this.f39425n.setVisibility(0);
        } else if (this.A) {
            this.f39425n.setVisibility(0);
        }
        this.f39411a0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        int i11;
        com.mbridge.msdk.video.module.listener.a aVar;
        boolean z10;
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f39280b.getRewardTemplateMode().f() == 5002010 && this.L0 && !(z10 = this.f39436s0)) {
                com.mbridge.msdk.video.module.listener.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.L0 = true;
                    aVar2.a(2, c(z10));
                    return;
                }
                return;
            }
            if (!this.f39417g0 || ((i11 = this.f39422l0) != com.mbridge.msdk.foundation.same.a.H && i11 != com.mbridge.msdk.foundation.same.a.I)) {
                CampaignEx campaignEx2 = this.f39280b;
                if (campaignEx2 == null || campaignEx2.getAdSpaceT() == 2) {
                    com.mbridge.msdk.video.module.listener.a aVar3 = this.notifyListener;
                    if (aVar3 != null) {
                        this.L0 = true;
                        aVar3.a(2, "");
                        return;
                    }
                    return;
                }
                boolean m11 = m();
                if (m11 && this.N == 1 && !this.f39415e0) {
                    o();
                    com.mbridge.msdk.video.module.listener.a aVar4 = this.notifyListener;
                    if (aVar4 != null) {
                        aVar4.a(8, "");
                        return;
                    }
                    return;
                }
                if (this.notifyListener != null) {
                    this.L0 = true;
                    if (this.f39280b.getAdType() == 94 && !m11) {
                        this.notifyListener.a(17, "");
                    }
                    this.notifyListener.a(2, c(!m11));
                    return;
                }
                return;
            }
            if (this.f39428o0) {
                if (i11 != com.mbridge.msdk.foundation.same.a.I || (aVar = this.notifyListener) == null) {
                    return;
                }
                this.L0 = true;
                aVar.a(2, c(this.f39436s0));
                return;
            }
            if (i11 == com.mbridge.msdk.foundation.same.a.I && this.f39442v0) {
                com.mbridge.msdk.video.module.listener.a aVar5 = this.notifyListener;
                if (aVar5 != null) {
                    this.L0 = true;
                    aVar5.a(2, c(this.f39436s0));
                    return;
                }
                return;
            }
            if (this.f39434r0) {
                int curPosition = this.mPlayerView.getCurPosition() / 1000;
                int videoLength = (int) ((curPosition / (this.mPlayerView.getDuration() == 0 ? this.f39280b.getVideoLength() : this.mPlayerView.getDuration())) * 100.0f);
                if (this.f39422l0 == com.mbridge.msdk.foundation.same.a.H) {
                    o();
                    int i12 = this.f39424m0;
                    if (i12 == com.mbridge.msdk.foundation.same.a.J && videoLength >= this.f39426n0) {
                        com.mbridge.msdk.video.module.listener.a aVar6 = this.notifyListener;
                        if (aVar6 != null) {
                            this.L0 = true;
                            aVar6.a(2, c(this.f39436s0));
                            return;
                        }
                        return;
                    }
                    if (i12 == com.mbridge.msdk.foundation.same.a.K && curPosition >= this.f39426n0) {
                        com.mbridge.msdk.video.module.listener.a aVar7 = this.notifyListener;
                        if (aVar7 != null) {
                            this.L0 = true;
                            aVar7.a(2, c(this.f39436s0));
                            return;
                        }
                        return;
                    }
                    com.mbridge.msdk.video.module.listener.a aVar8 = this.notifyListener;
                    if (aVar8 != null) {
                        aVar8.a(8, "");
                    }
                }
                if (this.f39422l0 == com.mbridge.msdk.foundation.same.a.I) {
                    int i13 = this.f39424m0;
                    if (i13 == com.mbridge.msdk.foundation.same.a.J && videoLength >= this.f39426n0) {
                        o();
                        com.mbridge.msdk.video.module.listener.a aVar9 = this.notifyListener;
                        if (aVar9 != null) {
                            aVar9.a(8, "");
                            return;
                        }
                        return;
                    }
                    if (i13 != com.mbridge.msdk.foundation.same.a.K || curPosition < this.f39426n0) {
                        return;
                    }
                    o();
                    com.mbridge.msdk.video.module.listener.a aVar10 = this.notifyListener;
                    if (aVar10 != null) {
                        aVar10.a(8, "");
                    }
                }
            }
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void addCTAView() {
        if (this.B == null) {
            return;
        }
        if (this.C == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
            this.C = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.f39280b);
            this.C.setUnitId(this.Q);
            com.mbridge.msdk.video.module.listener.a aVar = this.f39439u;
            if (aVar != null) {
                this.C.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.i(aVar));
            }
            this.C.preLoadData(this.D);
        }
        this.B.addView(this.C);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        this.I = true;
        setShowingAlertViewCover(true);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i11, int i12) {
        if (i11 == 1) {
            this.f39442v0 = true;
            if (getVisibility() == 0) {
                y();
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000148", this.f39280b, eVar);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.f39280b);
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
        if (i12 == 1) {
            gonePlayingCloseView();
        } else if (i12 == 2) {
            if (this.f39440u0 && getVisibility() == 0) {
                return;
            }
            x();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    protected void d() {
        super.d();
        if (this.f39283e) {
            if (!this.f39286h) {
                this.mPlayerView.setOnClickListener(new p());
            } else if (com.mbridge.msdk.video.dynview.util.a.b(this.f39280b) == -1 || com.mbridge.msdk.video.dynview.util.a.b(this.f39280b) == 100) {
                this.mPlayerView.setOnClickListener(new o());
            }
            SoundImageView soundImageView = this.mSoundImageView;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new q());
            }
            this.f39425n.setOnClickListener(new r());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
        this.T = true;
        showVideoLocation(0, 0, t0.g(this.f39279a), t0.f(this.f39279a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.L == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.O;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, "");
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        return V0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        return T0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        return R0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        return S0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        return U0;
    }

    public int getBufferTimeout() {
        return this.M;
    }

    public int getCloseAlert() {
        return this.N;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        try {
            int a11 = this.N0.a();
            CampaignEx campaignEx = this.f39280b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(a11, videoLength));
            jSONObject.put(EventConstants.KEY_TIME, a11);
            jSONObject.put("duration", videoLength + "");
            return jSONObject.toString();
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
            return "{}";
        }
    }

    public int getMute() {
        return this.f39418h0;
    }

    public String getPlayURL() {
        return this.K;
    }

    public String getUnitId() {
        return this.Q;
    }

    public int getVideoSkipTime() {
        return this.L;
    }

    public void gonePlayingCloseView() {
        if (this.f39283e && this.f39425n.getVisibility() != 8) {
            this.f39425n.setVisibility(8);
            this.f39411a0 = false;
        }
        i();
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i11) {
        if (this.I) {
            this.I = false;
            this.f39428o0 = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.foundation.same.report.j.a(this.f39279a, this.f39280b, com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).c(), this.Q, 1, i11, 1);
            if (i11 == 0) {
                p();
                if (this.f39417g0) {
                    int i12 = this.f39422l0;
                    if (i12 == com.mbridge.msdk.foundation.same.a.I || i12 == com.mbridge.msdk.foundation.same.a.H) {
                        this.f39430p0 = true;
                        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
                        if (aVar != null) {
                            aVar.a(Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, "");
                        }
                        CampaignEx campaignEx = this.f39280b;
                        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f39280b.getRewardTemplateMode().f() == 5002010) {
                            x();
                            return;
                        } else {
                            this.f39440u0 = true;
                            gonePlayingCloseView();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.f39432q0 = true;
            boolean z10 = this.f39417g0;
            if (z10 && this.f39422l0 == com.mbridge.msdk.foundation.same.a.I) {
                p();
                return;
            }
            if (z10 && this.f39422l0 == com.mbridge.msdk.foundation.same.a.H) {
                com.mbridge.msdk.video.module.listener.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.L0 = true;
                    aVar2.a(2, c(this.f39436s0));
                    return;
                }
                return;
            }
            com.mbridge.msdk.video.module.listener.a aVar3 = this.notifyListener;
            if (aVar3 != null) {
                this.L0 = true;
                aVar3.a(2, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    @Override // com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < t0.f(this.f39279a.getApplicationContext());
    }

    public boolean isInstDialogShowing() {
        return this.F0;
    }

    public boolean isMiniCardShowing() {
        return this.W;
    }

    public boolean isRewardPopViewShowing() {
        return this.J;
    }

    public boolean isShowingAlertView() {
        return this.I;
    }

    public boolean isShowingTransparent() {
        return this.f39415e0;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i11 = indexOfChild + 1;
        boolean z10 = false;
        while (i11 <= childCount - 1) {
            if (viewGroup.getChildAt(i11).getVisibility() == 0 && this.W) {
                return false;
            }
            i11++;
            z10 = true;
        }
        return z10;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void notifyCloseBtn(int i11) {
        if (i11 == 0) {
            this.f39412b0 = true;
            this.f39414d0 = false;
        } else if (i11 == 1) {
            this.f39413c0 = true;
        }
    }

    public void notifyVideoClose() {
        this.L0 = true;
        this.notifyListener.a(2, "");
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void onBackPress() {
        boolean z10;
        if (this.W || this.I || this.f39430p0) {
            return;
        }
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f39280b.getRewardTemplateMode().f() == 5002010 && (z10 = this.f39436s0)) {
            com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
            if (aVar != null) {
                this.L0 = true;
                aVar.a(2, c(z10));
                return;
            }
            return;
        }
        if (this.f39411a0) {
            y();
            return;
        }
        boolean z11 = this.f39412b0;
        if (z11 && this.f39413c0) {
            y();
        } else {
            if (z11 || !this.f39414d0) {
                return;
            }
            y();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f39280b;
        if ((campaignEx == null || !campaignEx.isDynamicView()) && this.f39283e && this.T) {
            u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.P0 != null) {
                getHandler().removeCallbacks(this.P0);
            }
            if (this.f39450z0 != 0) {
                removeCallbacks(this.Q0);
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.D = bVar;
        if (!this.f39283e) {
            com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
            if (aVar != null) {
                aVar.a(12, "MBridgeVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.K) && this.f39280b != null) {
            com.iab.omid.library.mmadbridge.adsession.b bVar2 = this.f39419i0;
            if (bVar2 != null) {
                bVar2.d(this.mPlayerView);
                SoundImageView soundImageView = this.mSoundImageView;
                if (soundImageView != null) {
                    this.f39419i0.a(soundImageView, FriendlyObstructionPurpose.OTHER, null);
                }
                this.f39419i0.a(this.f39423m, FriendlyObstructionPurpose.OTHER, null);
                this.f39419i0.a(this.f39425n, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
            }
            k();
            this.mPlayerView.initBufferIngParam(this.M);
            this.mPlayerView.initVFPData(this.K, this.f39280b.getVideoUrlEncode(), this.N0);
            soundOperate(this.f39418h0, -1, null);
        }
        W0 = false;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i11) {
        ProgressBar progressBar;
        if (this.f39283e) {
            if (i11 == 1) {
                ProgressBar progressBar2 = this.f39431q;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i11 != 2 || (progressBar = this.f39431q) == null) {
                return;
            }
            progressBar.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressOperate(int i11, int i12) {
        if (this.f39283e) {
            o0.c(MBridgeBaseView.TAG, "progressOperate progress:" + i11);
            CampaignEx campaignEx = this.f39280b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            if (i11 > 0 && i11 <= videoLength && this.mPlayerView != null) {
                o0.c(MBridgeBaseView.TAG, "progressOperate progress:" + i11);
                this.mPlayerView.seekTo(i11 * 1000);
            }
            if (i12 == 1) {
                this.f39423m.setVisibility(8);
            } else if (i12 == 2) {
                this.f39423m.setVisibility(0);
            }
            if (this.f39423m.getVisibility() == 0) {
                f();
            }
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null && !this.V) {
                playerView.release();
                if (!TextUtils.isEmpty(this.K)) {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    long j11 = X0;
                    if (j11 != 0) {
                        j11 = System.currentTimeMillis() - X0;
                    }
                    eVar.a("duration", Long.valueOf(j11));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.f39280b, eVar);
                }
            }
            w wVar = this.N0;
            if (wVar != null) {
                wVar.d();
            }
            if (this.f39439u != null) {
                this.f39439u = null;
            }
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.f39419i0 = bVar;
    }

    public void setBufferTimeout(int i11) {
        this.M = i11;
    }

    public void setCTALayoutVisibleOrGone() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || this.B == null) {
            return;
        }
        if (campaignEx.getRewardTemplateMode() == null || this.f39280b.getRewardTemplateMode().f() != 902) {
            int i11 = this.F;
            if (i11 != -5) {
                if (i11 == -3) {
                    return;
                }
                if (this.C == null) {
                    addCTAView();
                }
                if (this.F == -1) {
                    if (this.B.getVisibility() != 0) {
                        this.B.setVisibility(0);
                        postDelayed(this.P0, 3000L);
                    } else {
                        this.B.setVisibility(8);
                        getHandler().removeCallbacks(this.P0);
                    }
                }
                if (this.F >= 0) {
                    this.B.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.E < -1) {
                return;
            }
            if (this.C == null) {
                addCTAView();
            }
            int i12 = this.E;
            if (i12 >= 0) {
                this.B.setVisibility(0);
                return;
            }
            if (i12 == -1) {
                if (this.B.getVisibility() != 0) {
                    this.B.setVisibility(0);
                    postDelayed(this.P0, 3000L);
                } else {
                    this.B.setVisibility(8);
                    getHandler().removeCallbacks(this.P0);
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.listener.a aVar, List<CampaignEx> list, int i11, int i12) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.f39445x = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i11;
        this.f39449z = i12;
        this.mCampOrderViewData = list;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || campaignEx.getDynamicTempCode() != 5) {
            CampaignEx campaignEx2 = this.f39280b;
            if (campaignEx2 == null || campaignEx2.getProgressBarShow() != 1 || (mBridgeSegmentsProgressBar = this.f39437t) == null) {
                return;
            }
            mBridgeSegmentsProgressBar.init(1, 3);
            this.f39437t.setVisibility(0);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar2 = this.f39437t;
        if (mBridgeSegmentsProgressBar2 == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize > 1) {
            mBridgeSegmentsProgressBar2.setVisibility(0);
            this.f39437t.init(this.mCampaignSize, 2);
            for (int i13 = 0; i13 < this.mCampOrderViewData.size(); i13++) {
                int videoPlayProgress = this.mCampOrderViewData.get(i13).getVideoPlayProgress();
                if (videoPlayProgress > 0) {
                    this.f39437t.setProgress(videoPlayProgress, i13);
                }
                if (this.mCampOrderViewData.get(i13).isRewardPopViewShowed) {
                    this.H = true;
                }
            }
            return;
        }
        CampaignEx campaignEx3 = this.f39280b;
        if (campaignEx3 == null || campaignEx3.getProgressBarShow() != 1) {
            this.f39437t.setVisibility(8);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar3 = this.f39437t;
        if (mBridgeSegmentsProgressBar3 != null) {
            mBridgeSegmentsProgressBar3.init(1, 3);
            this.f39437t.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        w wVar = this.N0;
        if (wVar != null) {
            wVar.a(campaignEx);
            this.N0.b(a(campaignEx), getCDRate());
        }
    }

    public void setCloseAlert(int i11) {
        this.N = i11;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.listener.a aVar) {
        this.f39439u = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setCover(boolean z10) {
        if (this.f39283e) {
            this.mPlayerView.setIsCovered(z10);
        }
    }

    public void setDialogRole(int i11) {
        this.f39434r0 = i11 == 1;
        o0.b(MBridgeBaseView.TAG, i11 + " " + this.f39434r0);
    }

    public void setIPlayVideoViewLayoutCallBack(com.mbridge.msdk.video.dynview.listener.f fVar) {
        this.f39447y = fVar;
    }

    public void setIVRewardEnable(int i11, int i12, int i13) {
        this.f39422l0 = i11;
        this.f39424m0 = i12;
        this.f39426n0 = i13;
    }

    public void setInstDialogState(boolean z10) {
        PlayerView playerView;
        this.F0 = z10;
        if (!com.mbridge.msdk.util.b.a() || (playerView = this.mPlayerView) == null) {
            return;
        }
        playerView.setIsCovered(z10);
    }

    public void setIsIV(boolean z10) {
        this.f39417g0 = z10;
        w wVar = this.N0;
        if (wVar != null) {
            wVar.a(z10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z10) {
        this.W = z10;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        RelativeLayout relativeLayout;
        try {
            o0.b(MBridgeBaseView.TAG, "NOTCH VideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i15 = layoutParams.leftMargin;
            int i16 = layoutParams.rightMargin;
            int i17 = layoutParams.topMargin;
            int i18 = layoutParams.bottomMargin;
            this.K0 = i13;
            if (Math.max(Math.max(i15, i16), Math.max(i17, i18)) <= Math.max(Math.max(i11, i12), Math.max(i13, i14)) && (relativeLayout = this.f39427o) != null) {
                relativeLayout.postDelayed(new b(i11, i13, i12, i14), 200L);
            }
            if (this.f39423m.getVisibility() == 0) {
                f();
            }
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.K = str;
    }

    public void setPlayerViewAttachListener(u uVar) {
        this.f39441v = uVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i11) {
        this.f39416f0 = i11;
    }

    public void setShowingAlertViewCover(boolean z10) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z10 && (mBAcquireRewardPopView = this.E0) != null && this.J && this.I) {
            mBAcquireRewardPopView.onPause();
        }
        this.mPlayerView.setIsCovered(z10);
    }

    public void setShowingTransparent(boolean z10) {
        this.f39415e0 = z10;
    }

    public void setSoundState(int i11) {
        this.f39418h0 = i11;
    }

    public void setUnitId(String str) {
        this.Q = str;
        w wVar = this.N0;
        if (wVar != null) {
            wVar.a(str);
        }
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f39420j0 = aVar;
        w wVar = this.N0;
        if (wVar != null) {
            wVar.f39490f = aVar;
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setVideoEvents(aVar);
        }
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.f39280b = campaignEx;
            this.f39286h = campaignEx.isDynamicView();
        }
        if (this.f39286h) {
            a(this, campaignEx);
        } else {
            h();
        }
    }

    public void setVideoSkipTime(int i11) {
        this.L = i11;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setVisible(int i11) {
        setVisibility(i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        CampaignEx campaignEx;
        if (this.W) {
            return;
        }
        if (this.P == null) {
            this.P = new s();
        }
        if (this.O == null) {
            MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.P);
            this.O = mBAlertDialog;
            com.iab.omid.library.mmadbridge.adsession.b bVar = this.f39419i0;
            if (bVar != null) {
                bVar.a(mBAlertDialog.getWindow().getDecorView(), FriendlyObstructionPurpose.NOT_VISIBLE, null);
            }
        }
        if (this.f39417g0) {
            this.O.makeIVAlertView(this.f39422l0, this.Q);
        } else {
            this.O.makeRVAlertView(this.Q);
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (playerView.isComplete() && ((campaignEx = this.f39280b) == null || campaignEx.getRewardTemplateMode() == null || this.f39280b.getRewardTemplateMode().f() != 5002010)) {
                return;
            }
            this.O.show();
            this.f39428o0 = true;
            this.I = true;
            setShowingAlertViewCover(true);
            String c11 = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.Q, false).c();
            this.f39421k0 = c11;
            com.mbridge.msdk.foundation.same.report.j.a(this.f39279a, this.f39280b, c11, this.Q, 1, 1);
        }
    }

    public void showBaitClickView() {
        int parseInt;
        MBridgeBaitClickView mBridgeBaitClickView;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.f39280b.getRewardTemplateMode() == null) {
            return;
        }
        String e11 = this.f39280b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(e11)) {
            return;
        }
        try {
            String a11 = z0.a(e11, "bait_click");
            if (TextUtils.isEmpty(a11) || (parseInt = Integer.parseInt(a11)) == 0 || (mBridgeBaitClickView = this.f39448y0) == null) {
                return;
            }
            mBridgeBaitClickView.setVisibility(0);
            this.f39448y0.init(parseInt);
            this.f39448y0.startAnimation();
            this.f39448y0.setOnClickListener(new i());
        } catch (Exception e12) {
            o0.b(MBridgeBaseView.TAG, e12.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        this.notifyListener.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || this.G == null || !campaignEx.isDynamicView() || this.f39280b.getRewardTemplateMode() == null) {
            return;
        }
        String e11 = this.f39280b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(e11)) {
            return;
        }
        try {
            String a11 = z0.a(e11, "mof");
            if (TextUtils.isEmpty(a11) || Integer.parseInt(a11) != 1) {
                return;
            }
            com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f39280b, this, new com.mbridge.msdk.video.module.listener.impl.i(this.f39439u), 1);
        } catch (Exception e12) {
            o0.b(MBridgeBaseView.TAG, e12.getMessage());
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.E0;
        if (mBAcquireRewardPopView == null || (acquireRewardPopViewParameters = this.D0) == null) {
            return;
        }
        try {
            mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
            this.E0.setVisibility(0);
            setCover(true);
            o();
            this.J = true;
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null) {
                campaignEx.isRewardPopViewShowed = true;
            }
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        float f11;
        if (this.f39283e) {
            this.f39427o.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.f39427o.getVisibility() != 0) {
                this.f39427o.setVisibility(0);
            }
            if (this.f39423m.getVisibility() == 0) {
                f();
            }
            if (!b(i13, i14) || this.T) {
                u();
                return;
            }
            S0 = i16;
            T0 = i17;
            U0 = i18 + 4;
            V0 = i19 + 4;
            float f12 = i13 / i14;
            try {
                f11 = (float) (this.R / this.S);
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
                f11 = 0.0f;
            }
            if (i15 > 0) {
                R0 = i15;
                setPlayerViewRadius(i15);
            }
            if (Math.abs(f12 - f11) > 0.1f && this.f39416f0 != 1) {
                u();
                videoOperate(1);
                return;
            }
            u();
            if (!this.f39415e0) {
                setLayoutParam(i12, i11, i13, i14);
                return;
            }
            setLayoutCenter(i13, i14);
            if (W0) {
                this.notifyListener.a(Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, "");
            } else {
                this.notifyListener.a(Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i11, int i12) {
        soundOperate(i11, i12, "2");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i11, int i12, String str) {
        com.mbridge.msdk.video.module.listener.a aVar;
        SoundImageView soundImageView;
        if (this.f39283e) {
            this.f39418h0 = i11;
            if (i11 == 1) {
                this.D.getJSCommon().g(i11);
                SoundImageView soundImageView2 = this.mSoundImageView;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.mPlayerView.closeSound();
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar2 = this.f39420j0;
                    if (aVar2 != null) {
                        aVar2.p(0.0f);
                        o0.a("omsdk", "play video view:  mute");
                    }
                } catch (Exception e11) {
                    o0.a("OMSDK", e11.getMessage());
                }
            } else if (i11 == 2) {
                this.D.getJSCommon().g(i11);
                SoundImageView soundImageView3 = this.mSoundImageView;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.mPlayerView.openSound();
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar3 = this.f39420j0;
                    if (aVar3 != null) {
                        aVar3.p(1.0f);
                        o0.a("omsdk", "play video view:  unmute");
                    }
                } catch (Exception e12) {
                    o0.a("OMSDK", e12.getMessage());
                }
            }
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                SoundImageView soundImageView4 = this.mSoundImageView;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i12 == 1) {
                SoundImageView soundImageView5 = this.mSoundImageView;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i12 == 2 && (soundImageView = this.mSoundImageView) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || (aVar = this.notifyListener) == null) {
            return;
        }
        aVar.a(7, Integer.valueOf(i11));
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void videoOperate(int i11) {
        o0.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i11);
        if (this.f39283e) {
            if (i11 == 1) {
                if (getVisibility() == 0 && isfront()) {
                    o0.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                    RelativeLayout relativeLayout = this.I0;
                    if ((relativeLayout != null && relativeLayout.getVisibility() != 0) || this.I || com.mbridge.msdk.foundation.feedback.b.f35343f) {
                        return;
                    }
                    if (!com.mbridge.msdk.util.b.a()) {
                        p();
                        return;
                    } else {
                        if (this.W || this.F0) {
                            return;
                        }
                        p();
                        return;
                    }
                }
                return;
            }
            if (i11 == 2) {
                if (getVisibility() == 0 && isfront()) {
                    o0.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                    o();
                    return;
                }
                return;
            }
            if (i11 == 3) {
                if (this.V) {
                    return;
                }
                this.mPlayerView.stop();
                CampaignEx campaignEx = this.f39280b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f39280b.getRewardTemplateMode().f() != 5002010) {
                    this.mPlayerView.release();
                    this.V = true;
                    if (TextUtils.isEmpty(this.K)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    long j11 = X0;
                    if (j11 != 0) {
                        j11 = System.currentTimeMillis() - X0;
                    }
                    eVar.a("duration", Long.valueOf(j11));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.f39280b, eVar);
                    return;
                }
                return;
            }
            if (i11 == 5) {
                if (com.mbridge.msdk.util.b.a()) {
                    this.F0 = true;
                    if (this.V) {
                        return;
                    }
                    o();
                    return;
                }
                return;
            }
            if (i11 == 4) {
                if (com.mbridge.msdk.util.b.a()) {
                    this.F0 = false;
                    if (this.V || isMiniCardShowing()) {
                        return;
                    }
                    p();
                    return;
                }
                return;
            }
            if (i11 != 6 || this.V) {
                return;
            }
            this.mPlayerView.release();
            this.V = true;
            if (TextUtils.isEmpty(this.K)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
            long j12 = X0;
            if (j12 != 0) {
                j12 = System.currentTimeMillis() - X0;
            }
            eVar2.a("duration", Long.valueOf(j12));
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.f39280b, eVar2);
        }
    }
}
