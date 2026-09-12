package com.mbridge.msdk.splash.signal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.widget.MBAdChoice;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SplashExpandDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final String f37640a;

    /* renamed from: b, reason: collision with root package name */
    private String f37641b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37642c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f37643d;

    /* renamed from: e, reason: collision with root package name */
    private WindVaneWebView f37644e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f37645f;

    /* renamed from: g, reason: collision with root package name */
    private String f37646g;

    /* renamed from: h, reason: collision with root package name */
    private List<CampaignEx> f37647h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.splash.middle.a f37648i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.b f37649j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SplashExpandDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* loaded from: classes5.dex */
        class a implements ValueCallback<String> {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        b() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            webView.evaluateJavascript("javascript:" + com.mbridge.msdk.setting.util.a.a().b(), new a());
            SplashExpandDialog.this.c();
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
            SplashExpandDialog.this.a();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            SplashExpandDialog.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (SplashExpandDialog.this.f37648i != null) {
                SplashExpandDialog.this.f37648i.a(false);
                SplashExpandDialog.this.f37648i.close();
            }
            SplashExpandDialog.this.f37644e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            SplashExpandDialog.this.f37643d.removeView(SplashExpandDialog.this.f37644e);
            SplashExpandDialog.this.f37644e.release();
            SplashExpandDialog.this.f37644e = null;
            SplashExpandDialog.this.f37648i = null;
        }
    }

    /* loaded from: classes5.dex */
    class e implements com.mbridge.msdk.mbsignalcommon.mraid.b {
        e() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void close() {
            SplashExpandDialog.this.dismiss();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void expand(String str, boolean z10) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public CampaignEx getMraidCampaign() {
            return null;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void open(String str) {
            try {
                if (SplashExpandDialog.this.f37644e == null || System.currentTimeMillis() - SplashExpandDialog.this.f37644e.lastTouchTime <= com.mbridge.msdk.click.utils.a.f34500c || !com.mbridge.msdk.click.utils.a.a((CampaignEx) SplashExpandDialog.this.f37647h.get(0), SplashExpandDialog.this.f37644e.getUrl(), com.mbridge.msdk.click.utils.a.f34498a)) {
                    o0.b("SplashExpandDialog", str);
                    if (SplashExpandDialog.this.f37647h.size() > 1) {
                        com.mbridge.msdk.foundation.controller.c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (SplashExpandDialog.this.f37648i != null) {
                        SplashExpandDialog.this.f37648i.a(true, str);
                    }
                }
            } catch (Throwable th2) {
                o0.b("SplashExpandDialog", MRAIDPresenter.OPEN, th2);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void unload() {
            close();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void useCustomClose(boolean z10) {
            try {
                SplashExpandDialog.this.f37645f.setVisibility(z10 ? 4 : 0);
            } catch (Throwable th2) {
                o0.b("SplashExpandDialog", "useCustomClose", th2);
            }
        }
    }

    public SplashExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.splash.middle.a aVar) {
        super(context);
        this.f37640a = "SplashExpandDialog";
        this.f37649j = new e();
        if (bundle != null) {
            this.f37641b = bundle.getString("url");
            this.f37642c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f37648i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
    }

    private void b() {
        CampaignEx campaignEx;
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f37643d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f37644e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f37643d.addView(this.f37644e);
        TextView textView = new TextView(getContext());
        this.f37645f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f37645f.setLayoutParams(layoutParams);
        this.f37645f.setVisibility(this.f37642c ? 4 : 0);
        this.f37645f.setOnClickListener(new a());
        this.f37643d.addView(this.f37645f);
        setContentView(this.f37643d);
        a();
        this.f37644e.setWebViewListener(new b());
        this.f37644e.setObject(this.f37649j);
        this.f37644e.loadUrl(this.f37641b);
        List<CampaignEx> list = this.f37647h;
        if (list != null && !list.isEmpty() && (campaignEx = this.f37647h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().d());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f), t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new c());
            this.f37643d.addView(mBAdChoice, layoutParams2);
        }
        BitmapDrawable a11 = com.mbridge.msdk.foundation.controller.c.m().a(this.f37646g, 297);
        if (a11 != null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
            t0.a(imageView, a11, this.f37643d.getResources().getDisplayMetrics());
            this.f37643d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        setOnDismissListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            int i11 = com.mbridge.msdk.foundation.controller.c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i11 == 2 ? TmcStartParams.KEY_LANDSCAPE : i11 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            float n11 = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());
            float m11 = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());
            HashMap v11 = k0.v(com.mbridge.msdk.foundation.controller.c.m().d());
            int intValue = ((Integer) v11.get("width")).intValue();
            int intValue2 = ((Integer) v11.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "Interstitial");
            hashMap.put("state", "expanded");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            this.f37644e.getLocationInWindow(new int[2]);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f37644e, r0[0], r0[1], r11.getWidth(), this.f37644e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f37644e, r0[0], r0[1], r5.getWidth(), this.f37644e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f37644e, n11, m11);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f37644e, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f37644e, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f37644e);
        } catch (Throwable th2) {
            o0.b("SplashExpandDialog", "notifyMraid", th2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        b();
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f37646g = str;
        this.f37647h = list;
    }
}
