package com.mbridge.msdk.splash.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f37470b;

    /* renamed from: c, reason: collision with root package name */
    protected MBSplashView f37471c;

    /* renamed from: d, reason: collision with root package name */
    protected com.mbridge.msdk.splash.middle.d f37472d;

    /* renamed from: e, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f37473e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f37474f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f37475g;

    /* renamed from: h, reason: collision with root package name */
    private View f37476h;

    /* renamed from: i, reason: collision with root package name */
    protected String f37477i;

    /* renamed from: j, reason: collision with root package name */
    private String f37478j;

    /* renamed from: k, reason: collision with root package name */
    protected MBridgeIds f37479k;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f37485q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f37486r;

    /* renamed from: s, reason: collision with root package name */
    protected Context f37487s;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f37489u;

    /* renamed from: v, reason: collision with root package name */
    private h f37490v;

    /* renamed from: w, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.b f37491w;

    /* renamed from: a, reason: collision with root package name */
    protected final String f37469a = "SplashShowManager";

    /* renamed from: l, reason: collision with root package name */
    protected int f37480l = 5;

    /* renamed from: m, reason: collision with root package name */
    protected String f37481m = "点击跳过|";

    /* renamed from: n, reason: collision with root package name */
    protected String f37482n = "点击跳过|";

    /* renamed from: o, reason: collision with root package name */
    protected String f37483o = "秒";

    /* renamed from: p, reason: collision with root package name */
    protected String f37484p = "秒后自动关闭";

    /* renamed from: t, reason: collision with root package name */
    protected boolean f37488t = true;

    /* renamed from: x, reason: collision with root package name */
    private View.OnClickListener f37492x = new a();

    /* renamed from: y, reason: collision with root package name */
    public Handler f37493y = new HandlerC0542b(Looper.getMainLooper());

    /* renamed from: z, reason: collision with root package name */
    protected j f37494z = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f37474f) {
                b.this.b(1);
                b.this.d(-1);
            }
        }
    }

    /* renamed from: com.mbridge.msdk.splash.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class HandlerC0542b extends Handler {
        HandlerC0542b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            MBSplashView mBSplashView;
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i11 = message.what;
            if (i11 == 1) {
                if (!b.this.f37486r) {
                    b.this.i();
                }
                b bVar = b.this;
                if (bVar.f37480l <= 0) {
                    bVar.b(2);
                    return;
                }
                if (!com.mbridge.msdk.foundation.feedback.b.f35343f) {
                    b bVar2 = b.this;
                    if (!bVar2.f37485q) {
                        int i12 = bVar2.f37480l - 1;
                        bVar2.f37480l = i12;
                        bVar2.d(i12);
                        b bVar3 = b.this;
                        if (!bVar3.f37488t) {
                            bVar3.g();
                        }
                        b.this.f37493y.removeMessages(1);
                        sendEmptyMessageDelayed(1, 1000L);
                        return;
                    }
                }
                b.this.f();
                b.this.f37493y.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            if (i11 != 2 || b.this.f37470b == null || !b.this.f37470b.isActiveOm() || (mBSplashView = b.this.f37471c) == null || (splashWebview = mBSplashView.getSplashWebview()) == null) {
                return;
            }
            try {
                b.this.f37491w = splashWebview.getAdSession();
                if (b.this.f37491w != null) {
                    com.iab.omid.library.mmadbridge.adsession.a a11 = com.iab.omid.library.mmadbridge.adsession.a.a(b.this.f37491w);
                    a11.c();
                    a11.b();
                }
                o0.a("OMSDK", "adSession.impressionOccurred()");
            } catch (Throwable th2) {
                o0.a("OMSDK", th2.getMessage());
                if (b.this.f37470b != null) {
                    String requestId = b.this.f37470b.getRequestId();
                    String requestIdNotice = b.this.f37470b.getRequestIdNotice();
                    String id2 = b.this.f37470b.getId();
                    new com.mbridge.msdk.foundation.same.report.h(splashWebview.getContext()).a(requestId, requestIdNotice, id2, b.this.f37477i, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            b.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b("SplashShowManager", th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.f37471c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            b.this.g();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b("SplashShowManager", th2.getMessage(), th2);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.f37471c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            b.this.g();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b("SplashShowManager", th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) b.this.f37471c.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* loaded from: classes5.dex */
    class d implements j {
        d() {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, b.this.f37471c);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            s0.a(campaign, b.this.f37471c);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            s0.b(campaign, b.this.f37471c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f37499a;

        e(int i11) {
            this.f37499a = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f37499a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37501a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37502b;

        f(Context context, CampaignEx campaignEx) {
            this.f37501a = context;
            this.f37502b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(this.f37501a)).b(this.f37502b.getId());
            } catch (Exception unused) {
                o0.b("SplashShowManager", "campain can't insert db");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements com.mbridge.msdk.foundation.feedback.a {
        g() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            b.this.f();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            b.this.g();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            b.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class h implements com.mbridge.msdk.splash.middle.a {
        private h() {
        }

        /* synthetic */ h(b bVar, a aVar) {
            this();
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(int i11) {
            o0.b("SplashShowManager", "resetCountdown" + i11);
            b bVar = b.this;
            bVar.f37480l = i11;
            bVar.f37493y.removeMessages(1);
            b.this.f37493y.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(int i11, int i12) {
            if (i11 == 1) {
                b.this.f37493y.removeMessages(1);
            }
            if (i11 == 2) {
                b bVar = b.this;
                bVar.f37480l = i12;
                bVar.f37493y.removeMessages(1);
                b.this.f37493y.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(CampaignEx campaignEx) {
            b.this.b(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(boolean z10) {
            if (z10) {
                b.this.f37493y.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void a(boolean z10, String str) {
            try {
                if (b.this.f37472d != null) {
                    if (TextUtils.isEmpty(str)) {
                        b bVar = b.this;
                        bVar.f37472d.a(bVar.f37479k);
                    } else {
                        CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(b.this.f37470b));
                        parseCampaignWithBackData.setClickTempSource(2);
                        parseCampaignWithBackData.setClickType(2);
                        parseCampaignWithBackData.setTriggerClickSource(2);
                        parseCampaignWithBackData.setClickURL(str);
                        b.this.b(parseCampaignWithBackData, true, str);
                    }
                }
            } catch (Exception e11) {
                o0.b("SplashShowManager", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void close() {
            b.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void toggleCloseBtn(int i11) {
            MBSplashView mBSplashView = b.this.f37471c;
            if (mBSplashView != null) {
                mBSplashView.changeCloseBtnState(i11);
            }
        }

        @Override // com.mbridge.msdk.splash.middle.a
        public void triggerCloseBtn(Object obj, String str) {
            b.this.b(1);
        }
    }

    public b(Context context, String str, String str2) {
        this.f37477i = str2;
        this.f37478j = str;
        this.f37479k = new MBridgeIds(str, str2);
        this.f37487s = context;
        if (this.f37475g == null) {
            TextView textView = new TextView(context);
            this.f37475g = textView;
            textView.setGravity(1);
            this.f37475g.setTextIsSelectable(false);
            this.f37475g.setPadding(t0.a(context, 5.0f), t0.a(context, 5.0f), t0.a(context, 5.0f), t0.a(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37475g.getLayoutParams();
            this.f37475g.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(t0.a(context, 100.0f), t0.a(context, 50.0f)) : layoutParams);
            e();
        }
    }

    private void a() {
        RelativeLayout.LayoutParams layoutParams;
        CampaignEx campaignEx = this.f37470b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f37477i);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f37477i, 3);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f37477i, this.f37470b);
        }
        if (com.mbridge.msdk.foundation.feedback.b.b().a()) {
            MBSplashView mBSplashView = this.f37471c;
            if (mBSplashView == null || !mBSplashView.isDynamicView()) {
                com.mbridge.msdk.foundation.feedback.b.b().a(this.f37477i, new c());
                FeedBackButton a11 = com.mbridge.msdk.foundation.feedback.b.b().a(this.f37477i);
                if (a11 != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) a11.getLayoutParams();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        layoutParams = null;
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.feedback.b.f35342e, com.mbridge.msdk.foundation.feedback.b.f35341d);
                    }
                    layoutParams.topMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    layoutParams.leftMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 10.0f);
                    ViewGroup viewGroup = (ViewGroup) a11.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(a11);
                    }
                    MBSplashView mBSplashView2 = this.f37471c;
                    if (mBSplashView2 != null) {
                        mBSplashView2.addView(a11, layoutParams);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11) {
        MBSplashView mBSplashView;
        try {
            com.mbridge.msdk.splash.middle.d dVar = this.f37472d;
            if (dVar != null) {
                dVar.a(this.f37479k, i11);
                this.f37472d = null;
                com.mbridge.msdk.splash.report.a.a(this.f37477i, this.f37470b);
            }
            ImageView imageView = this.f37489u;
            if (imageView != null && imageView.getParent() != null && (mBSplashView = this.f37471c) != null) {
                mBSplashView.removeView(this.f37489u);
                this.f37489u.setVisibility(8);
            }
            this.f37486r = false;
            com.mbridge.msdk.splash.report.a.a(this.f37477i, i11, this.f37470b);
            Handler handler = this.f37493y;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e11) {
            o0.b("SplashShowManager", e11.getMessage());
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.f37492x);
        }
    }

    private void a(CampaignEx campaignEx) {
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.f37477i, campaignEx, "splash");
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        com.mbridge.msdk.foundation.controller.c.m().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new f(context, campaignEx)).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.f34472m);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().k() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().k(), false, false);
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx.isHasMBTplMark()) {
            return;
        }
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.f37477i, campaignEx, "splash");
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.f34473n);
            } catch (Throwable th2) {
                o0.b("SplashShowManager", th2.getMessage());
            }
        }
    }

    private void c(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, str, it.next(), false, true);
                }
            } catch (Throwable th2) {
                o0.b("SplashShowManager", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i11) {
        MBSplashView mBSplashView = this.f37471c;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i11);
            if (this.f37471c.getSplashSignalCommunicationImpl() != null) {
                this.f37471c.getSplashSignalCommunicationImpl().c(i11);
            }
        }
        if (i11 < 0) {
            this.f37480l = i11;
            return;
        }
        com.mbridge.msdk.splash.middle.d dVar = this.f37472d;
        if (dVar != null) {
            dVar.a(this.f37479k, i11 * 1000);
        }
        if (this.f37476h == null) {
            j();
        }
    }

    private void e() {
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d11 != null) {
            String h11 = com.mbridge.msdk.foundation.controller.c.m().h();
            int identifier = d11.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", h11);
            int identifier2 = d11.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", h11);
            int identifier3 = d11.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", h11);
            this.f37482n = d11.getResources().getString(identifier);
            String string = d11.getResources().getString(identifier2);
            this.f37484p = string;
            this.f37481m = string;
            this.f37483o = d11.getResources().getString(identifier3);
            this.f37475g.setBackgroundResource(d11.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.f37475g.setTextColor(d11.getResources().getColor(d11.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", TtmlNode.ATTR_TTS_COLOR, h11)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        MBSplashView mBSplashView;
        try {
            if (this.f37470b == null) {
                return;
            }
            this.f37486r = true;
            if (this.f37472d != null && (mBSplashView = this.f37471c) != null) {
                if (mBSplashView.getContext() != null && (this.f37471c.getContext() instanceof Activity) && ((Activity) this.f37471c.getContext()).isFinishing()) {
                    o0.a("SplashShowManager", "Activity is finishing");
                }
                if (this.f37471c.isShown()) {
                    this.f37472d.b(this.f37479k);
                } else {
                    this.f37472d.a(this.f37479k, "SplashView or container is not visibility");
                }
            }
            if (!this.f37470b.isReport()) {
                MBSplashView mBSplashView2 = this.f37471c;
                if (mBSplashView2 == null || mBSplashView2.isDynamicView()) {
                    a(this.f37470b);
                } else {
                    b(this.f37470b);
                }
                com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37470b, this.f37477i);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void j() {
        String str;
        if (this.f37474f) {
            str = this.f37482n + this.f37480l + this.f37483o;
        } else {
            str = this.f37480l + this.f37484p;
        }
        this.f37475g.setText(str);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.f37492x);
        }
        this.f37476h = viewGroup;
    }

    public void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        MBSplashWebview splashWebview;
        a(this.f37474f);
        this.f37470b = campaignEx;
        this.f37471c = mBSplashView;
        com.mbridge.msdk.splash.signal.b splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl();
        if (splashSignalCommunicationImpl == null) {
            splashSignalCommunicationImpl = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), this.f37478j, this.f37477i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashSignalCommunicationImpl.a(arrayList);
        }
        splashSignalCommunicationImpl.b(this.f37480l);
        splashSignalCommunicationImpl.a(this.f37474f ? 1 : 0);
        a aVar = null;
        if (this.f37490v == null) {
            this.f37490v = new h(this, aVar);
        }
        splashSignalCommunicationImpl.a(this.f37490v);
        mBSplashView.setSplashSignalCommunicationImpl(splashSignalCommunicationImpl);
        boolean isHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.f37476h;
        if (view == null) {
            if (isHasMBTplMark) {
                this.f37475g.setVisibility(8);
            }
            j();
            a(this.f37475g);
            mBSplashView.setCloseView(this.f37475g);
        } else {
            if (isHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.f37476h);
            mBSplashView.setCloseView(this.f37476h);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.f37470b;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                com.iab.omid.library.mmadbridge.adsession.b a11 = com.mbridge.msdk.omsdk.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), splashWebview, splashWebview.getUrl(), this.f37470b);
                this.f37491w = a11;
                if (a11 != null) {
                    splashWebview.setAdSession(a11);
                    this.f37491w.d(splashWebview);
                    this.f37491w.g();
                }
                o0.a("OMSDK", "adSession.start()");
            } catch (Throwable th2) {
                o0.a("OMSDK", th2.getMessage());
                CampaignEx campaignEx3 = this.f37470b;
                if (campaignEx3 != null) {
                    String requestId = campaignEx3.getRequestId();
                    String requestIdNotice = this.f37470b.getRequestIdNotice();
                    String id2 = this.f37470b.getId();
                    new com.mbridge.msdk.foundation.same.report.h(splashWebview.getContext()).a(requestId, requestIdNotice, id2, this.f37477i, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
        com.mbridge.msdk.splash.manager.d.b(this.f37477i);
        this.f37493y.removeMessages(1);
        this.f37493y.sendEmptyMessageDelayed(1, 1000L);
        this.f37493y.sendEmptyMessageDelayed(2, 1000L);
        b();
        if (!this.f37470b.isMraid()) {
            a();
        }
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37470b.getMaitve(), this.f37470b.getMaitve_src());
        try {
            BitmapDrawable a12 = com.mbridge.msdk.foundation.controller.c.m().a(this.f37477i, this.f37470b.getAdType());
            if (a12 != null) {
                if (this.f37489u == null) {
                    this.f37489u = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                }
                if (this.f37489u.getVisibility() != 0) {
                    this.f37489u.setVisibility(0);
                }
                t0.a(this.f37489u, a12, mBSplashView.getResources().getDisplayMetrics());
                if (this.f37489u.getParent() == null) {
                    mBSplashView.addView(this.f37489u, new ViewGroup.LayoutParams(-1, -1));
                }
                com.iab.omid.library.mmadbridge.adsession.b bVar = this.f37491w;
                if (bVar != null) {
                    bVar.a(this.f37489u, FriendlyObstructionPurpose.OTHER, null);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CampaignEx campaignEx, boolean z10, String str) {
        if (this.f37473e == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37477i);
            this.f37473e = aVar;
            aVar.a(this.f37494z);
        }
        campaignEx.setCampaignUnitId(this.f37477i);
        this.f37473e.a(campaignEx);
        if (!this.f37470b.isReportClick()) {
            this.f37470b.setReportClick(true);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
        }
        com.mbridge.msdk.splash.middle.d dVar = this.f37472d;
        if (dVar != null) {
            dVar.a(this.f37479k);
            b(3);
        }
        if (!z10 || TextUtils.isEmpty(str)) {
            return;
        }
        com.mbridge.msdk.splash.report.a.a(campaignEx, this.f37477i, str);
    }

    public void a(com.mbridge.msdk.splash.middle.d dVar) {
        this.f37472d = dVar;
    }

    public void a(boolean z10) {
        this.f37474f = z10;
        if (z10) {
            this.f37481m = this.f37482n;
        } else {
            this.f37481m = this.f37484p;
        }
    }

    public void b() {
        MBSplashView mBSplashView;
        Context context;
        CampaignEx campaignEx = this.f37470b;
        if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() != 1 || (mBSplashView = this.f37471c) == null || mBSplashView.getSplashWebview() == null || this.f37471c.isDynamicView() || !this.f37470b.isMraid() || (context = this.f37471c.getContext()) == null) {
            return;
        }
        try {
            int a11 = g0.a(context, "mbridge_splash_notice", "drawable");
            int a12 = t0.a(context, 35.0f);
            int a13 = t0.a(context, 9.0f);
            ImageView imageView = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a12, a12);
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(a13, a13, a13, a13);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setBackgroundResource(a11);
            t0.a(3, imageView, this.f37470b, context, true, new g());
            this.f37471c.addView(imageView);
        } catch (Throwable th2) {
            o0.b("SplashShowManager", th2.getMessage());
        }
    }

    protected void b(int i11) {
        CampaignEx campaignEx;
        MBSplashWebview splashWebview;
        MBSplashView mBSplashView = this.f37471c;
        if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        if (this.f37493y == null || (campaignEx = this.f37470b) == null || !campaignEx.isActiveOm()) {
            a(i11);
        } else {
            this.f37493y.postDelayed(new e(i11), 1500L);
        }
    }

    public void b(CampaignEx campaignEx, boolean z10, String str) {
        throw null;
    }

    public String c() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.f37470b;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public void c(int i11) {
        this.f37480l = i11;
    }

    public String d() {
        CampaignEx campaignEx = this.f37470b;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.f37470b.getRequestId();
    }

    public void f() {
        Handler handler;
        this.f37488t = false;
        if (this.f37471c != null && this.f37480l > 0 && (handler = this.f37493y) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.f37471c;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.f37471c.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
        }
    }

    public void g() {
        MBSplashView mBSplashView;
        Handler handler;
        this.f37488t = true;
        if (this.f37471c != null && this.f37480l > 0 && (handler = this.f37493y) != null) {
            handler.removeMessages(1);
            this.f37493y.sendEmptyMessageDelayed(1, 1000L);
        }
        if (com.mbridge.msdk.foundation.feedback.b.f35343f || (mBSplashView = this.f37471c) == null) {
            return;
        }
        mBSplashView.onResume();
        MBSplashWebview splashWebview = this.f37471c.getSplashWebview();
        if (splashWebview == null || splashWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.splash.signal.c.a(splashWebview, "onSystemPause", "");
    }

    public void h() {
        if (this.f37472d != null) {
            this.f37472d = null;
        }
        if (this.f37490v != null) {
            this.f37490v = null;
        }
        if (this.f37492x != null) {
            this.f37492x = null;
        }
        MBSplashView mBSplashView = this.f37471c;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f37477i);
    }
}
