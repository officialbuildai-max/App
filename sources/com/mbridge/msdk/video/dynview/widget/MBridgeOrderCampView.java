package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.video.bt.module.orglistener.f;
import com.mbridge.msdk.video.dynview.listener.h;
import com.mbridge.msdk.video.module.MBridgeBaseView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class MBridgeOrderCampView extends MBridgeBaseView {

    /* renamed from: m, reason: collision with root package name */
    private MBridgeOrderCampView f39178m;

    /* renamed from: n, reason: collision with root package name */
    private List<CampaignEx> f39179n;

    /* renamed from: o, reason: collision with root package name */
    private int f39180o;

    /* renamed from: p, reason: collision with root package name */
    private int f39181p;

    /* renamed from: q, reason: collision with root package name */
    private int f39182q;

    /* renamed from: r, reason: collision with root package name */
    private int f39183r;

    /* renamed from: s, reason: collision with root package name */
    private String f39184s;

    /* renamed from: t, reason: collision with root package name */
    private FeedBackButton f39185t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f39186u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f39187v;

    /* renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.c f39188w;

    /* renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.listener.b f39189x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f39190y;

    /* loaded from: classes5.dex */
    class a implements com.mbridge.msdk.video.dynview.listener.c {
        a() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.c
        public void a(CampaignEx campaignEx, int i11) {
            if (campaignEx != null) {
                try {
                    MBridgeOrderCampView.this.setCampaign(campaignEx);
                    campaignEx.setClickTempSource(2);
                    campaignEx.setTriggerClickSource(2);
                    MBridgeOrderCampView.this.a(campaignEx, 0, i11);
                } catch (Exception e11) {
                    o0.b(MBridgeBaseView.TAG, e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.c
        public void close() {
            MBridgeOrderCampView.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f39192a;

        b(ViewGroup viewGroup) {
            this.f39192a = viewGroup;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                try {
                    MBridgeOrderCampView.this.f39178m.addView(aVar.b());
                    MBridgeOrderCampView.this.f39187v = aVar.c();
                    this.f39192a.removeAllViews();
                    this.f39192a.addView(MBridgeOrderCampView.this.f39178m);
                    f.a(com.mbridge.msdk.foundation.controller.c.m().d(), (List<CampaignEx>) MBridgeOrderCampView.this.f39179n, ((CampaignEx) MBridgeOrderCampView.this.f39179n.get(0)).getCampaignUnitId());
                    MBridgeOrderCampView.this.setViewStatus();
                    if (MBridgeOrderCampView.this.f39189x != null) {
                        MBridgeOrderCampView.this.f39189x.a();
                    }
                } catch (Exception e11) {
                    o0.b(MBridgeBaseView.TAG, e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            try {
                f.a(com.mbridge.msdk.foundation.controller.c.m().d(), (List<CampaignEx>) MBridgeOrderCampView.this.f39179n, ((CampaignEx) MBridgeOrderCampView.this.f39179n.get(0)).getCampaignUnitId(), aVar.c());
                if (MBridgeOrderCampView.this.f39189x != null) {
                    MBridgeOrderCampView.this.f39189x.b();
                }
            } catch (Exception e11) {
                o0.b(MBridgeBaseView.TAG, e11.getMessage());
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
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39195a;

        d(String str) {
            this.f39195a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.mbridge.msdk.click.c.e(((MBridgeBaseView) MBridgeOrderCampView.this).f39279a, this.f39195a);
        }
    }

    public MBridgeOrderCampView(Context context) {
        super(context);
        this.f39187v = false;
        this.f39188w = new a();
        this.f39190y = false;
    }

    public MBridgeOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39187v = false;
        this.f39188w = new a();
        this.f39190y = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10, int r11) {
        /*
            r8 = this;
            if (r9 == 0) goto L61
            boolean r0 = r9.isDynamicView()
            if (r0 == 0) goto L61
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r9.getRewardTemplateMode()     // Catch: java.lang.Exception -> L25
            java.lang.String r1 = ""
            if (r0 == 0) goto L23
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L25
            r2.<init>()     // Catch: java.lang.Exception -> L25
            int r0 = r0.f()     // Catch: java.lang.Exception -> L25
            r2.append(r0)     // Catch: java.lang.Exception -> L25
            r2.append(r1)     // Catch: java.lang.Exception -> L25
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L25
        L23:
            r7 = r1
            goto L27
        L25:
            r9 = move-exception
            goto L58
        L27:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L25
            android.content.Context r0 = r0.d()     // Catch: java.lang.Exception -> L25
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L25
            r1.<init>()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = "order_view_click"
            r1.append(r2)     // Catch: java.lang.Exception -> L25
            r1.append(r7)     // Catch: java.lang.Exception -> L25
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = r9.getCampaignUnitId()     // Catch: java.lang.Exception -> L25
            boolean r3 = r9.isBidCampaign()     // Catch: java.lang.Exception -> L25
            java.lang.String r4 = r9.getRequestId()     // Catch: java.lang.Exception -> L25
            java.lang.String r5 = r9.getRequestIdNotice()     // Catch: java.lang.Exception -> L25
            java.lang.String r6 = r9.getId()     // Catch: java.lang.Exception -> L25
            com.mbridge.msdk.foundation.same.report.j.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L25
            goto L61
        L58:
            java.lang.String r9 = r9.getMessage()
            java.lang.String r0 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.o0.b(r0, r9)
        L61:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> L77
            r9.<init>()     // Catch: org.json.JSONException -> L77
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f35392j     // Catch: org.json.JSONException -> L75
            org.json.JSONObject r10 = r8.a(r10)     // Catch: org.json.JSONException -> L75
            r9.put(r0, r10)     // Catch: org.json.JSONException -> L75
            java.lang.String r10 = "camp_position"
            r9.put(r10, r11)     // Catch: org.json.JSONException -> L75
            goto L7d
        L75:
            r10 = move-exception
            goto L7a
        L77:
            r9 = move-exception
            r10 = r9
            r9 = 0
        L7a:
            r10.printStackTrace()
        L7d:
            com.mbridge.msdk.video.module.listener.a r10 = r8.notifyListener
            if (r10 == 0) goto L86
            r11 = 105(0x69, float:1.47E-43)
            r10.a(r11, r9)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.a(com.mbridge.msdk.foundation.entity.CampaignEx, int, int):void");
    }

    private void e() {
        List<CampaignEx> list = this.f39179n;
        if (list == null || list.get(0) == null) {
            FeedBackButton feedBackButton = this.f39185t;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.f39184s = this.f39179n.get(0).getCampaignUnitId();
        this.f39280b = this.f39179n.get(0);
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f39184s + "_2", this.f39280b);
        if (this.f39185t == null) {
            return;
        }
        if (!com.mbridge.msdk.foundation.feedback.b.b().a()) {
            this.f39185t.setVisibility(8);
            return;
        }
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f39184s + "_2", new c());
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f39184s + "_2", this.f39185t);
    }

    private void f() {
        if (this.f39186u == null) {
            return;
        }
        g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            this.f39186u.setVisibility(8);
            return;
        }
        String c11 = d11.c();
        if (TextUtils.isEmpty(c11)) {
            this.f39186u.setVisibility(8);
        }
        this.f39186u.setOnClickListener(new d(c11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            e eVar = new e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.f39280b);
        } catch (Throwable th2) {
            o0.a(MBridgeBaseView.TAG, th2.getMessage());
        }
        try {
            com.mbridge.msdk.video.dynview.moffer.a.a().b();
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    public void createView(ViewGroup viewGroup) {
        if (this.f39179n == null) {
            com.mbridge.msdk.video.dynview.listener.b bVar = this.f39189x;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("order_view_callback", this.f39188w);
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.wrapper.c().b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39179n), new b(viewGroup), hashMap);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        this.f39178m = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r4.f39179n
            if (r0 != 0) goto L8
            return
        L8:
            r0 = 0
        L9:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r4.f39179n
            int r1 = r1.size()
            if (r0 >= r1) goto L30
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1e
            r1.<init>()     // Catch: org.json.JSONException -> L1e
            java.lang.String r2 = "camp_position"
            r1.put(r2, r0)     // Catch: org.json.JSONException -> L1c
            goto L24
        L1c:
            r2 = move-exception
            goto L21
        L1e:
            r1 = move-exception
            r2 = r1
            r1 = 0
        L21:
            r2.printStackTrace()
        L24:
            com.mbridge.msdk.video.module.listener.a r2 = r4.notifyListener
            if (r2 == 0) goto L2d
            r3 = 110(0x6e, float:1.54E-43)
            r2.a(r3, r1)
        L2d:
            int r0 = r0 + 1
            goto L9
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.onAttachedToWindow():void");
    }

    public void setCampOrderViewBuildCallback(com.mbridge.msdk.video.dynview.listener.b bVar) {
        this.f39189x = bVar;
    }

    public void setCampaignExes(List<CampaignEx> list) {
        this.f39179n = list;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        this.f39180o = i11;
        this.f39181p = i12;
        this.f39182q = i13;
        this.f39183r = i14;
        setViewStatus();
    }

    public void setRewarded(boolean z10) {
        this.f39190y = z10;
    }

    public void setViewStatus() {
        MBridgeOrderCampView mBridgeOrderCampView = this.f39178m;
        if (mBridgeOrderCampView == null || !this.f39190y) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) mBridgeOrderCampView.findViewById(filterFindViewId(this.f39187v, "mbridge_native_order_camp_controller"));
        this.f39185t = (FeedBackButton) this.f39178m.findViewById(filterFindViewId(this.f39187v, "mbridge_native_order_camp_feed_btn"));
        this.f39186u = (ImageView) this.f39178m.findViewById(filterFindViewId(this.f39187v, "mbridge_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.f39180o, this.f39182q, this.f39181p, this.f39183r);
        }
        if (this.f39185t != null) {
            try {
                e();
            } catch (Exception e11) {
                o0.b(MBridgeBaseView.TAG, e11.getMessage());
            }
        }
        if (this.f39186u != null) {
            try {
                f();
            } catch (Exception e12) {
                o0.b(MBridgeBaseView.TAG, e12.getMessage());
            }
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.f39178m.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.f39178m.startAnimation(translateAnimation);
    }
}
