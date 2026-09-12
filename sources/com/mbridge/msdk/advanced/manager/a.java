package com.mbridge.msdk.advanced.manager;

import android.content.Context;
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
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f34114b;

    /* renamed from: c, reason: collision with root package name */
    protected MBNativeAdvancedView f34115c;

    /* renamed from: d, reason: collision with root package name */
    protected com.mbridge.msdk.advanced.middle.d f34116d;

    /* renamed from: e, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f34117e;

    /* renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.advanced.middle.c f34118f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f34119g;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f34121i;

    /* renamed from: j, reason: collision with root package name */
    protected String f34122j;

    /* renamed from: k, reason: collision with root package name */
    private String f34123k;

    /* renamed from: l, reason: collision with root package name */
    protected MBridgeIds f34124l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f34125m;

    /* renamed from: a, reason: collision with root package name */
    private String f34113a = "NativeAdvancedShowManager";

    /* renamed from: h, reason: collision with root package name */
    private int f34120h = -1;

    /* renamed from: n, reason: collision with root package name */
    private View.OnClickListener f34126n = new ViewOnClickListenerC0467a();

    /* renamed from: o, reason: collision with root package name */
    public Handler f34127o = new b(Looper.getMainLooper());

    /* renamed from: p, reason: collision with root package name */
    private com.mbridge.msdk.advanced.middle.a f34128p = new c();

    /* renamed from: com.mbridge.msdk.advanced.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class ViewOnClickListenerC0467a implements View.OnClickListener {
        ViewOnClickListenerC0467a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f34119g) {
                a.this.a(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            CampaignEx campaignEx;
            MBNativeAdvancedView mBNativeAdvancedView;
            MBNativeAdvancedWebview advancedNativeWebview;
            super.handleMessage(message);
            if (message.what != 2 || (campaignEx = a.this.f34114b) == null || !campaignEx.isActiveOm() || (mBNativeAdvancedView = a.this.f34115c) == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null) {
                return;
            }
            try {
                com.iab.omid.library.mmadbridge.adsession.b adSession = advancedNativeWebview.getAdSession();
                if (adSession != null) {
                    com.iab.omid.library.mmadbridge.adsession.a a11 = com.iab.omid.library.mmadbridge.adsession.a.a(adSession);
                    a11.c();
                    a11.b();
                    o0.a("OMSDK", "adSession.impressionOccurred()");
                }
            } catch (Throwable th2) {
                o0.a("OMSDK", th2.getMessage());
                CampaignEx campaignEx2 = a.this.f34114b;
                if (campaignEx2 != null) {
                    String requestId = campaignEx2.getRequestId();
                    String requestIdNotice = a.this.f34114b.getRequestIdNotice();
                    String id2 = a.this.f34114b.getId();
                    new h(advancedNativeWebview.getContext()).a(requestId, requestIdNotice, id2, a.this.f34122j, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements com.mbridge.msdk.advanced.middle.a {
        c() {
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(int i11) {
            o0.b(a.this.f34113a, "resetCountdown" + i11);
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(CampaignEx campaignEx) {
            a.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(boolean z10) {
            a aVar = a.this;
            if (aVar.f34116d != null) {
                aVar.f34125m = z10;
                if (z10) {
                    a aVar2 = a.this;
                    aVar2.f34116d.f(aVar2.f34124l);
                } else {
                    a aVar3 = a.this;
                    aVar3.f34116d.a(aVar3.f34124l);
                }
            }
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void a(boolean z10, String str) {
            try {
                if (a.this.f34116d != null) {
                    if (TextUtils.isEmpty(str)) {
                        a aVar = a.this;
                        aVar.f34116d.b(aVar.f34124l);
                        a aVar2 = a.this;
                        aVar2.f34116d.d(aVar2.f34124l);
                    } else {
                        CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(a.this.f34114b));
                        parseCampaignWithBackData.setClickTempSource(2);
                        parseCampaignWithBackData.setClickType(2);
                        parseCampaignWithBackData.setTriggerClickSource(2);
                        parseCampaignWithBackData.setClickURL(str);
                        a.this.a(parseCampaignWithBackData, z10, str);
                    }
                }
            } catch (Exception e11) {
                o0.b(a.this.f34113a, e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void close() {
            a.this.a(1);
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void toggleCloseBtn(int i11) {
            a.this.f34120h = i11;
            MBNativeAdvancedView mBNativeAdvancedView = a.this.f34115c;
            if (mBNativeAdvancedView != null) {
                mBNativeAdvancedView.changeCloseBtnState(i11);
            }
        }

        @Override // com.mbridge.msdk.advanced.middle.a
        public void triggerCloseBtn(Object obj, String str) {
            MBNativeAdvancedView mBNativeAdvancedView = a.this.f34115c;
            if (mBNativeAdvancedView != null) {
                mBNativeAdvancedView.setVisibility(8);
            }
            a.this.a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements com.mbridge.msdk.foundation.feedback.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedView f34132a;

        d(MBNativeAdvancedView mBNativeAdvancedView) {
            this.f34132a = mBNativeAdvancedView;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            a.this.e();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(a.this.f34113a, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f34132a.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            a.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(a.this.f34113a, th2.getMessage(), th2);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f34132a.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            a.this.f();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(a.this.f34113a, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f34132a.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34134a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedView f34135b;

        e(CampaignEx campaignEx, MBNativeAdvancedView mBNativeAdvancedView) {
            this.f34134a = campaignEx;
            this.f34135b = mBNativeAdvancedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f34134a, this.f34135b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34137a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34138b;

        f(Context context, CampaignEx campaignEx) {
            this.f34137a = context;
            this.f34138b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.a(g.a(this.f34137a)).b(this.f34138b.getId());
            } catch (Exception unused) {
                o0.b(a.this.f34113a, "campain can't insert db");
            }
        }
    }

    public a(Context context, String str, String str2) {
        this.f34122j = str2;
        this.f34123k = str;
        this.f34124l = new MBridgeIds(str, str2);
        if (this.f34121i == null) {
            ImageView imageView = new ImageView(context);
            this.f34121i = imageView;
            imageView.setPadding(t0.a(context, 2.0f), t0.a(context, 2.0f), t0.a(context, 2.0f), t0.a(context, 2.0f));
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11) {
        com.mbridge.msdk.advanced.middle.d dVar = this.f34116d;
        if (dVar != null) {
            dVar.c(this.f34124l);
            this.f34116d = null;
            com.mbridge.msdk.advanced.report.a.a(this.f34122j, this.f34114b);
        }
        com.mbridge.msdk.advanced.report.a.a(this.f34122j, i11, this.f34114b);
        MBNativeAdvancedView mBNativeAdvancedView = this.f34115c;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.setVisibility(8);
            e();
            MBNativeAdvancedWebview advancedNativeWebview = this.f34115c.getAdvancedNativeWebview();
            if (advancedNativeWebview != null) {
                advancedNativeWebview.finishAdSession();
            }
        }
        Handler handler = this.f34127o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.f34126n);
        }
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx.isHasMBTplMark()) {
            return;
        }
        a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f34122j);
        campaignEx.setReport(true);
        com.mbridge.msdk.foundation.same.buffer.b.a(this.f34122j, campaignEx, "h5_native");
        b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f34122j);
        c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().d(), this.f34122j);
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

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.f34473n);
            } catch (Throwable th2) {
                o0.b(this.f34113a, th2.getMessage());
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
                o0.b(this.f34113a, th2.getMessage());
            }
        }
    }

    private void d() {
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        this.f34121i.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f34121i.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(t0.a(d11, 29.0f), t0.a(d11, 16.0f));
        }
        this.f34121i.setLayoutParams(layoutParams);
        this.f34121i.setImageResource(d11.getResources().getIdentifier("mbridge_native_advanced_close_icon", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
    }

    private void h() {
        if (this.f34114b.isReport()) {
            return;
        }
        a(this.f34114b);
        com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34114b, this.f34122j);
        com.mbridge.msdk.advanced.middle.d dVar = this.f34116d;
        if (dVar != null) {
            dVar.e(this.f34124l);
        }
    }

    private void i() {
        CampaignEx campaignEx;
        MBNativeAdvancedView mBNativeAdvancedView = this.f34115c;
        if (mBNativeAdvancedView == null || (campaignEx = this.f34114b) == null) {
            return;
        }
        mBNativeAdvancedView.setAdChoiceCampaign(campaignEx);
    }

    public String a() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.f34114b;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.c.b(arrayList);
    }

    public void a(com.mbridge.msdk.advanced.middle.c cVar) {
        this.f34118f = cVar;
    }

    public void a(com.mbridge.msdk.advanced.middle.d dVar) {
        this.f34116d = dVar;
    }

    public void a(CampaignEx campaignEx, MBNativeAdvancedView mBNativeAdvancedView, boolean z10) {
        MBNativeAdvancedWebview advancedNativeWebview;
        View a11;
        RelativeLayout.LayoutParams layoutParams;
        if (mBNativeAdvancedView == null) {
            return;
        }
        this.f34114b = campaignEx;
        this.f34115c = mBNativeAdvancedView;
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f34122j, new d(mBNativeAdvancedView));
        if (campaignEx.isMraid() && com.mbridge.msdk.foundation.feedback.b.b().a() && (a11 = com.mbridge.msdk.foundation.feedback.b.b().a(this.f34122j)) != null) {
            try {
                layoutParams = (RelativeLayout.LayoutParams) a11.getLayoutParams();
            } catch (Exception e11) {
                e11.printStackTrace();
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.feedback.b.f35342e, com.mbridge.msdk.foundation.feedback.b.f35341d);
            }
            layoutParams.addRule(12);
            ViewGroup viewGroup = (ViewGroup) a11.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(a11);
            }
            mBNativeAdvancedView.addView(a11, layoutParams);
        }
        a(this.f34119g);
        com.mbridge.msdk.advanced.signal.b advancedNativeSignalCommunicationImpl = mBNativeAdvancedView.getAdvancedNativeSignalCommunicationImpl();
        if (advancedNativeSignalCommunicationImpl == null) {
            advancedNativeSignalCommunicationImpl = new com.mbridge.msdk.advanced.signal.b(mBNativeAdvancedView.getContext(), this.f34123k, this.f34122j);
            List<CampaignEx> arrayList = new ArrayList<>();
            arrayList.add(campaignEx);
            advancedNativeSignalCommunicationImpl.a(arrayList);
        }
        advancedNativeSignalCommunicationImpl.a(this.f34119g ? 1 : 0);
        advancedNativeSignalCommunicationImpl.a(this.f34128p);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(advancedNativeSignalCommunicationImpl);
        if (campaignEx.isHasMBTplMark() || !this.f34119g) {
            this.f34121i.setVisibility(8);
        }
        a(this.f34121i);
        mBNativeAdvancedView.setCloseView(this.f34121i);
        if (mBNativeAdvancedView.getVisibility() != 0) {
            mBNativeAdvancedView.setVisibility(0);
        }
        boolean a12 = b1.a(mBNativeAdvancedView.getAdvancedNativeWebview(), 0);
        com.mbridge.msdk.advanced.middle.c cVar = this.f34118f;
        if (cVar == null || a12 || cVar.d() == null || this.f34118f.d().getAlpha() < 0.5f || this.f34118f.d().getVisibility() != 0 || this.f34125m) {
            if (z10) {
                mBNativeAdvancedView.postDelayed(new e(campaignEx, mBNativeAdvancedView), 200L);
                return;
            }
            return;
        }
        mBNativeAdvancedView.show();
        com.mbridge.msdk.foundation.controller.c.m().a(mBNativeAdvancedView.getContext());
        campaignEx.setCampaignUnitId(this.f34122j);
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f34122j, campaignEx);
        CampaignEx campaignEx2 = this.f34114b;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) != null) {
            try {
                com.iab.omid.library.mmadbridge.adsession.b a13 = com.mbridge.msdk.omsdk.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), advancedNativeWebview, advancedNativeWebview.getUrl(), this.f34114b);
                if (a13 != null) {
                    advancedNativeWebview.setAdSession(a13);
                    a13.d(advancedNativeWebview);
                    a13.g();
                    o0.a("OMSDK", "adSession.start()");
                }
            } catch (Throwable th2) {
                o0.a("OMSDK", th2.getMessage());
                CampaignEx campaignEx3 = this.f34114b;
                if (campaignEx3 != null) {
                    String requestId = campaignEx3.getRequestId();
                    String requestIdNotice = this.f34114b.getRequestIdNotice();
                    String id2 = this.f34114b.getId();
                    new h(com.mbridge.msdk.foundation.controller.c.m().d()).a(requestId, requestIdNotice, id2, this.f34122j, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
        h();
        if (campaignEx.isMraid()) {
            i();
        }
        int i11 = this.f34120h;
        if (i11 != -1) {
            mBNativeAdvancedView.changeCloseBtnState(i11);
        }
        com.mbridge.msdk.advanced.manager.d.b(this.f34122j);
        com.mbridge.msdk.advanced.common.c.b(this.f34123k + this.f34122j + campaignEx.getRequestId());
        this.f34127o.sendEmptyMessageDelayed(2, 1000L);
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34114b.getMaitve(), this.f34114b.getMaitve_src());
    }

    public void a(CampaignEx campaignEx, boolean z10, String str) {
        throw null;
    }

    public void a(boolean z10) {
        this.f34119g = z10;
    }

    public com.mbridge.msdk.advanced.middle.a b() {
        return this.f34128p;
    }

    public String c() {
        CampaignEx campaignEx = this.f34114b;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.f34114b.getRequestId();
    }

    public void e() {
        MBNativeAdvancedWebview advancedNativeWebview;
        MBNativeAdvancedView mBNativeAdvancedView = this.f34115c;
        if (mBNativeAdvancedView == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) advancedNativeWebview, "onViewDisappeared", "");
    }

    public void f() {
        MBNativeAdvancedWebview advancedNativeWebview;
        if (this.f34115c == null || com.mbridge.msdk.foundation.feedback.b.f35343f || (advancedNativeWebview = this.f34115c.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.advanced.signal.a.a(advancedNativeWebview, "onViewAppeared", "");
    }

    public void g() {
        if (this.f34116d != null) {
            this.f34116d = null;
        }
        if (this.f34128p != null) {
            this.f34128p = null;
        }
        if (this.f34126n != null) {
            this.f34126n = null;
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.f34115c;
        if (mBNativeAdvancedView != null) {
            MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
            if (advancedNativeWebview != null) {
                advancedNativeWebview.finishAdSession();
            }
            this.f34115c.destroy();
        }
        if (this.f34118f != null) {
            this.f34118f = null;
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f34122j);
    }
}
