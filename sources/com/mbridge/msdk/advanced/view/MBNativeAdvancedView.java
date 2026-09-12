package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBNativeAdvancedView extends RelativeLayout {

    /* renamed from: i, reason: collision with root package name */
    private static String f34296i = "MBAdvancedNativeView";

    /* renamed from: a, reason: collision with root package name */
    private MBNativeAdvancedWebview f34297a;

    /* renamed from: b, reason: collision with root package name */
    private View f34298b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34299c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34300d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34301e;

    /* renamed from: f, reason: collision with root package name */
    MBAdChoice f34302f;

    /* renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.advanced.signal.b f34303g;

    /* renamed from: h, reason: collision with root package name */
    private Context f34304h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements com.mbridge.msdk.foundation.feedback.a {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBNativeAdvancedView.f34296i, th2.getMessage(), th2);
                str = "";
            }
            f.a().a((WebView) MBNativeAdvancedView.this.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBNativeAdvancedView.f34296i, th2.getMessage(), th2);
                str2 = "";
            }
            f.a().a((WebView) MBNativeAdvancedView.this.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBNativeAdvancedView.f34296i, th2.getMessage(), th2);
                str = "";
            }
            f.a().a((WebView) MBNativeAdvancedView.this.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0.a(MBNativeAdvancedView.f34296i, "webviewshow");
                String str = "";
                try {
                    int[] iArr = new int[2];
                    MBNativeAdvancedView.this.f34297a.getLocationOnScreen(iArr);
                    o0.b(MBNativeAdvancedView.f34296i, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", t0.b(c.m().d(), (float) iArr[0]));
                    jSONObject.put("startY", t0.b(c.m().d(), (float) iArr[1]));
                    str = jSONObject.toString();
                } catch (Throwable th2) {
                    o0.b(MBNativeAdvancedView.f34296i, th2.getMessage(), th2);
                }
                f.a().a((WebView) MBNativeAdvancedView.this.f34297a, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public MBNativeAdvancedView(Context context) {
        this(context, null);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34304h = context;
    }

    private void b() {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34297a;
        if (mBNativeAdvancedWebview != null && mBNativeAdvancedWebview.getParent() == null) {
            addView(this.f34297a, new ViewGroup.LayoutParams(-1, -1));
        }
        c();
        View view = this.f34298b;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(getContext(), 28.0f), t0.a(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = t0.a(getContext(), 2.0f);
                layoutParams.topMargin = t0.a(getContext(), 2.0f);
                addView(this.f34298b, layoutParams);
            } else {
                bringChildToFront(this.f34298b);
            }
        }
        if (this.f34302f == null) {
            MBAdChoice mBAdChoice = new MBAdChoice(getContext());
            this.f34302f = mBAdChoice;
            mBAdChoice.setFeedbackDialogEventListener(new a());
        }
    }

    private void c() {
        int[] iArr = new int[2];
        this.f34297a.getLocationInWindow(iArr);
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34297a;
        transInfoForMraid(mBNativeAdvancedWebview, iArr[0], iArr[1], mBNativeAdvancedWebview.getWidth(), this.f34297a.getHeight());
        MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.f34297a;
        if (mBNativeAdvancedWebview2 != null) {
            mBNativeAdvancedWebview2.setObject(this.f34303g);
            this.f34297a.post(new b());
        }
    }

    public static void transInfoForMraid(WebView webView, int i11, int i12, int i13, int i14) {
        o0.b(f34296i, "transInfoForMraid");
        try {
            int i15 = c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i15 == 2 ? TmcStartParams.KEY_LANDSCAPE : i15 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            float n11 = k0.n(c.m().d());
            float m11 = k0.m(c.m().d());
            HashMap v11 = k0.v(c.m().d());
            int intValue = ((Integer) v11.get("width")).intValue();
            int intValue2 = ((Integer) v11.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "inline");
            hashMap.put("state", "default");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f11 = i11;
            float f12 = i12;
            float f13 = i13;
            float f14 = i14;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f11, f12, f13, f14);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f11, f12, f13, f14);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, n11, m11);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th2) {
            o0.b(f34296i, "transInfoForMraid", th2);
        }
    }

    public void changeCloseBtnState(int i11) {
        View view = this.f34298b;
        if (view != null) {
            if (i11 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f34301e = false;
        this.f34300d = false;
        this.f34299c = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.f34298b;
        if (view != null && view.getParent() != null) {
            removeView(this.f34298b);
        }
        MBAdChoice mBAdChoice = this.f34302f;
        if (mBAdChoice == null || mBAdChoice.getParent() == null) {
            return;
        }
        removeView(this.f34302f);
    }

    public void destroy() {
        removeAllViews();
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34297a;
        if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
            this.f34297a.release();
            com.mbridge.msdk.advanced.signal.a.a(this.f34297a, "onSystemDestory", "");
        }
        if (this.f34304h != null) {
            this.f34304h = null;
        }
    }

    public com.mbridge.msdk.advanced.signal.b getAdvancedNativeSignalCommunicationImpl() {
        return this.f34303g;
    }

    public MBNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.f34297a;
    }

    public View getCloseView() {
        return this.f34298b;
    }

    public boolean isEndCardReady() {
        return this.f34301e;
    }

    public boolean isH5Ready() {
        return this.f34299c;
    }

    public boolean isVideoReady() {
        return this.f34300d;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void resetLoadState() {
        this.f34301e = false;
        this.f34300d = false;
        this.f34299c = false;
    }

    public void setAdChoiceCampaign(CampaignEx campaignEx) {
        MBAdChoice mBAdChoice = this.f34302f;
        if (mBAdChoice != null) {
            mBAdChoice.setCampaign(campaignEx);
            if (this.f34302f.getParent() != null) {
                bringChildToFront(this.f34302f);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t0.a(c.m().d(), 6.0f), t0.a(c.m().d(), 6.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            addView(this.f34302f, layoutParams);
        }
    }

    public void setAdvancedNativeSignalCommunicationImpl(com.mbridge.msdk.advanced.signal.b bVar) {
        this.f34303g = bVar;
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34297a;
        if (mBNativeAdvancedWebview != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void setAdvancedNativeWebview(MBNativeAdvancedWebview mBNativeAdvancedWebview) {
        this.f34297a = mBNativeAdvancedWebview;
        com.mbridge.msdk.advanced.signal.b bVar = this.f34303g;
        if (bVar != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void setCloseView(View view) {
        this.f34298b = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setEndCardReady(boolean z10) {
        this.f34301e = z10;
    }

    public void setH5Ready(boolean z10) {
        this.f34299c = z10;
    }

    public void setVideoReady(boolean z10) {
        this.f34300d = z10;
    }

    public void show() {
        b();
        clearResState();
    }
}
