package com.mbridge.msdk.advanced.signal;

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
public class NativeAdvancedExpandDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final String f34267a;

    /* renamed from: b, reason: collision with root package name */
    private String f34268b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34269c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f34270d;

    /* renamed from: e, reason: collision with root package name */
    private WindVaneWebView f34271e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f34272f;

    /* renamed from: g, reason: collision with root package name */
    private String f34273g;

    /* renamed from: h, reason: collision with root package name */
    private List<CampaignEx> f34274h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.advanced.middle.a f34275i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.b f34276j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeAdvancedExpandDialog.this.dismiss();
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
            NativeAdvancedExpandDialog.this.c();
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
            NativeAdvancedExpandDialog.this.a();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            NativeAdvancedExpandDialog.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (NativeAdvancedExpandDialog.this.f34275i != null) {
                NativeAdvancedExpandDialog.this.f34275i.a(false);
            }
            NativeAdvancedExpandDialog.this.f34271e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            NativeAdvancedExpandDialog.this.f34270d.removeView(NativeAdvancedExpandDialog.this.f34271e);
            NativeAdvancedExpandDialog.this.f34271e.release();
            NativeAdvancedExpandDialog.this.f34271e = null;
            NativeAdvancedExpandDialog.this.f34275i = null;
        }
    }

    /* loaded from: classes5.dex */
    class e implements com.mbridge.msdk.mbsignalcommon.mraid.b {
        e() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void close() {
            NativeAdvancedExpandDialog.this.dismiss();
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
                if (NativeAdvancedExpandDialog.this.f34271e == null || System.currentTimeMillis() - NativeAdvancedExpandDialog.this.f34271e.lastTouchTime <= com.mbridge.msdk.click.utils.a.f34500c || !com.mbridge.msdk.click.utils.a.a((CampaignEx) NativeAdvancedExpandDialog.this.f34274h.get(0), NativeAdvancedExpandDialog.this.f34271e.getUrl(), com.mbridge.msdk.click.utils.a.f34498a)) {
                    o0.b("NativeAdvancedExpandDialog", str);
                    if (NativeAdvancedExpandDialog.this.f34274h.size() > 1) {
                        com.mbridge.msdk.foundation.controller.c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (NativeAdvancedExpandDialog.this.f34275i != null) {
                        NativeAdvancedExpandDialog.this.f34275i.a(true, str);
                    }
                }
            } catch (Throwable th2) {
                o0.b("NativeAdvancedExpandDialog", MRAIDPresenter.OPEN, th2);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void unload() {
            close();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void useCustomClose(boolean z10) {
            try {
                NativeAdvancedExpandDialog.this.f34272f.setVisibility(z10 ? 4 : 0);
            } catch (Throwable th2) {
                o0.b("NativeAdvancedExpandDialog", "useCustomClose", th2);
            }
        }
    }

    public NativeAdvancedExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.advanced.middle.a aVar) {
        super(context);
        this.f34267a = "NativeAdvancedExpandDialog";
        this.f34276j = new e();
        if (bundle != null) {
            this.f34268b = bundle.getString("url");
            this.f34269c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f34275i = aVar;
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
        this.f34270d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f34271e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f34270d.addView(this.f34271e);
        TextView textView = new TextView(getContext());
        this.f34272f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f34272f.setLayoutParams(layoutParams);
        this.f34272f.setVisibility(this.f34269c ? 4 : 0);
        this.f34272f.setOnClickListener(new a());
        this.f34270d.addView(this.f34272f);
        setContentView(this.f34270d);
        a();
        this.f34271e.setWebViewListener(new b());
        this.f34271e.setObject(this.f34276j);
        this.f34271e.loadUrl(this.f34268b);
        List<CampaignEx> list = this.f34274h;
        if (list != null && list.size() > 0 && (campaignEx = this.f34274h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().d());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f), t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new c());
            this.f34270d.addView(mBAdChoice, layoutParams2);
        }
        BitmapDrawable a11 = com.mbridge.msdk.foundation.controller.c.m().a(this.f34273g, 296);
        if (a11 != null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
            t0.a(imageView, a11, this.f34270d.getResources().getDisplayMetrics());
            this.f34270d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
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
            hashMap.put("placementType", "inline");
            hashMap.put("state", "expanded");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            this.f34271e.getLocationInWindow(new int[2]);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f34271e, r0[0], r0[1], r11.getWidth(), this.f34271e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f34271e, r0[0], r0[1], r5.getWidth(), this.f34271e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f34271e, n11, m11);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f34271e, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f34271e, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f34271e);
        } catch (Throwable th2) {
            o0.b("NativeAdvancedExpandDialog", "notifyMraid", th2);
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
        this.f34273g = str;
        this.f34274h = list;
    }
}
