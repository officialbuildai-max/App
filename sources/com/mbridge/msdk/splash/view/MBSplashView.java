package com.mbridge.msdk.splash.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBSplashView extends RelativeLayout {

    /* renamed from: r, reason: collision with root package name */
    private static String f37746r = "MBSplashView";

    /* renamed from: a, reason: collision with root package name */
    private int f37747a;

    /* renamed from: b, reason: collision with root package name */
    private MBSplashWebview f37748b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.splash.view.a f37749c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f37750d;

    /* renamed from: e, reason: collision with root package name */
    private View f37751e;

    /* renamed from: f, reason: collision with root package name */
    private View f37752f;

    /* renamed from: g, reason: collision with root package name */
    private int f37753g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f37754h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f37755i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f37756j;

    /* renamed from: k, reason: collision with root package name */
    private ViewGroup f37757k;

    /* renamed from: l, reason: collision with root package name */
    private View f37758l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f37759m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f37760n;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout.LayoutParams f37761o;

    /* renamed from: p, reason: collision with root package name */
    private com.mbridge.msdk.splash.signal.b f37762p;

    /* renamed from: q, reason: collision with root package name */
    private DyCountDownListener f37763q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0.a(MBSplashView.f37746r, "webviewshow");
                String str = "";
                try {
                    int[] iArr = new int[2];
                    MBSplashView.this.f37748b.getLocationOnScreen(iArr);
                    o0.b(MBSplashView.f37746r, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), (float) iArr[0]));
                    jSONObject.put("startY", t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), (float) iArr[1]));
                    str = jSONObject.toString();
                } catch (Throwable th2) {
                    o0.b(MBSplashView.f37746r, th2.getMessage(), th2);
                }
                int[] iArr2 = new int[2];
                MBSplashView.this.f37748b.getLocationInWindow(iArr2);
                MBSplashView.transInfoForMraid(MBSplashView.this.f37748b, iArr2[0], iArr2[1], MBSplashView.this.f37748b.getWidth(), MBSplashView.this.f37748b.getHeight());
                f.a().a((WebView) MBSplashView.this.f37748b, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37765a;

        b(boolean z10) {
            this.f37765a = z10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return !this.f37765a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f37767a;

        c(boolean z10) {
            this.f37767a = z10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return !this.f37767a;
        }
    }

    public MBSplashView(Context context) {
        this(context, null);
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    private void b() {
        setBackgroundColor(0);
        this.f37747a = getResources().getConfiguration().orientation;
    }

    private void c() {
        View view;
        View view2;
        View view3;
        if (this.f37752f != null) {
            if (this.f37750d == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.f37750d = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.f37747a == 2) {
                this.f37753g = t0.g(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f37750d.getId());
                if (!this.f37759m || (view2 = this.f37758l) == null) {
                    MBSplashWebview mBSplashWebview = this.f37748b;
                    if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                        addView(this.f37748b, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        c1.a(this.f37758l);
                    }
                    addView(this.f37758l, layoutParams);
                }
                ViewGroup viewGroup = this.f37750d;
                if (viewGroup != null && viewGroup.getParent() == null) {
                    int i11 = this.f37761o.width;
                    c1.a(this.f37752f);
                    int i12 = this.f37753g / 4;
                    if (i11 > i12) {
                        this.f37750d.addView(this.f37752f, i12, -1);
                        i11 = i12;
                    } else {
                        this.f37750d.addView(this.f37752f, i11, -1);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i11, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f37750d, layoutParams2);
                }
            } else {
                this.f37753g = t0.f(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f37750d.getId());
                if (!this.f37759m || (view = this.f37758l) == null) {
                    MBSplashWebview mBSplashWebview2 = this.f37748b;
                    if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                        addView(this.f37748b, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        c1.a(this.f37758l);
                    }
                    addView(this.f37758l, layoutParams3);
                }
                ViewGroup viewGroup2 = this.f37750d;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i13 = this.f37761o.height;
                    int i14 = this.f37753g / 4;
                    if (i13 > i14) {
                        i13 = i14;
                    }
                    c1.a(this.f37752f);
                    this.f37750d.addView(this.f37752f, -1, i13);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i13);
                    layoutParams4.addRule(12);
                    addView(this.f37750d, layoutParams4);
                }
            }
        } else if (!this.f37759m || (view3 = this.f37758l) == null) {
            MBSplashWebview mBSplashWebview3 = this.f37748b;
            if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                addView(this.f37748b, new ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                c1.a(this.f37758l);
            }
            addView(this.f37758l, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.f37751e;
        if (view4 != null) {
            if (view4.getParent() != null) {
                bringChildToFront(this.f37751e);
                return;
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(t0.a(getContext(), 100.0f), t0.a(getContext(), 30.0f));
            layoutParams5.addRule(10);
            layoutParams5.addRule(11);
            layoutParams5.rightMargin = t0.a(getContext(), 10.0f);
            layoutParams5.topMargin = t0.a(getContext(), 10.0f);
            addView(this.f37751e, layoutParams5);
        }
    }

    private void d() {
        MBSplashWebview mBSplashWebview = this.f37748b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(this.f37762p);
            this.f37748b.post(new a());
        }
    }

    public static void transInfoForMraid(WebView webView, int i11, int i12, int i13, int i14) {
        o0.b(f37746r, "transInfoForMraid");
        try {
            int i15 = com.mbridge.msdk.foundation.controller.c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i15 == 2 ? TmcStartParams.KEY_LANDSCAPE : i15 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            float n11 = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());
            float m11 = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());
            HashMap v11 = k0.v(com.mbridge.msdk.foundation.controller.c.m().d());
            int intValue = ((Integer) v11.get("width")).intValue();
            int intValue2 = ((Integer) v11.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "Interstitial");
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
            o0.b(f37746r, "transInfoForMraid", th2);
        }
    }

    public void changeCloseBtnState(int i11) {
        View view = this.f37751e;
        if (view != null) {
            if (i11 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f37756j = false;
        this.f37755i = false;
        this.f37754h = false;
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.f37757k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.f37748b;
        if (mBSplashWebview == null || mBSplashWebview.isDestoryed()) {
            return;
        }
        this.f37748b.finishAdSession();
        com.mbridge.msdk.splash.signal.c.a(this.f37748b, "onSystemDestory", "");
        this.f37748b.release();
        this.f37748b = null;
    }

    public View getCloseView() {
        return this.f37751e;
    }

    public ViewGroup getDevContainer() {
        return this.f37757k;
    }

    public View getIconVg() {
        return this.f37752f;
    }

    public com.mbridge.msdk.splash.signal.b getSplashSignalCommunicationImpl() {
        return this.f37762p;
    }

    public MBSplashWebview getSplashWebview() {
        return this.f37748b;
    }

    public boolean isAttach() {
        return this.f37760n;
    }

    public boolean isDynamicView() {
        return this.f37759m;
    }

    public boolean isH5Ready() {
        return this.f37754h;
    }

    public boolean isImageReady() {
        return this.f37756j;
    }

    public boolean isVideoReady() {
        return this.f37755i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f37760n = true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void onPause() {
        View view = this.f37758l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.f37758l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.f37755i = false;
        this.f37754h = false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAllowClickSplash(boolean z10) {
        MBSplashWebview mBSplashWebview = this.f37748b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new b(z10));
        }
        setOnTouchListener(new c(z10));
    }

    public void setCloseView(View view) {
        this.f37751e = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.f37757k = viewGroup;
    }

    public void setDyCountDownListener(DyCountDownListener dyCountDownListener) {
        this.f37763q = dyCountDownListener;
    }

    public void setDynamicView(boolean z10) {
        this.f37759m = z10;
    }

    public void setH5Ready(boolean z10) {
        this.f37754h = z10;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f37752f = view;
        this.f37761o = layoutParams;
    }

    public void setImageReady(boolean z10) {
        this.f37756j = z10;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        View view = this.f37758l;
        if (view != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).setNotchPadding(i11, i12, i13, i14);
        }
        if (this.f37748b != null) {
            f.a().a((WebView) this.f37748b, "oncutoutfetched", Base64.encodeToString(b0.a(-999, i11, i12, i13, i14).getBytes(), 0));
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.f37758l = view;
        }
    }

    public void setSplashSignalCommunicationImpl(com.mbridge.msdk.splash.signal.b bVar) {
        this.f37762p = bVar;
        MBSplashWebview mBSplashWebview = this.f37748b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(bVar);
        }
    }

    public void setSplashWebView() {
        if (this.f37748b == null) {
            try {
                MBSplashWebview mBSplashWebview = new MBSplashWebview(getContext());
                this.f37748b = mBSplashWebview;
                com.mbridge.msdk.splash.signal.b bVar = this.f37762p;
                if (bVar != null) {
                    mBSplashWebview.setObject(bVar);
                }
                com.mbridge.msdk.splash.view.a aVar = this.f37749c;
                if (aVar != null) {
                    this.f37748b.setWebViewClient(aVar);
                    return;
                }
                com.mbridge.msdk.splash.view.a aVar2 = new com.mbridge.msdk.splash.view.a();
                this.f37749c = aVar2;
                this.f37748b.setWebViewClient(aVar2);
            } catch (Throwable th2) {
                o0.b(f37746r, th2.getMessage());
            }
        }
    }

    public void setVideoReady(boolean z10) {
        this.f37755i = z10;
    }

    public void show() {
        ViewGroup viewGroup;
        if (this.f37762p != null && (viewGroup = this.f37757k) != null && (viewGroup.getContext() instanceof Activity)) {
            this.f37762p.a(this.f37757k.getContext());
            com.mbridge.msdk.splash.view.a aVar = this.f37749c;
            if (aVar != null) {
                aVar.a(this.f37762p.a());
            }
        }
        c();
        clearResState();
    }

    public void updateCountdown(int i11) {
        DyCountDownListener dyCountDownListener;
        View view;
        if (this.f37748b != null && !this.f37759m) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i11);
                f.a().a((WebView) this.f37748b, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        if (this.f37759m && (view = this.f37758l) != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).updateCountDown(i11);
        }
        if (!this.f37759m || (dyCountDownListener = this.f37763q) == null) {
            return;
        }
        dyCountDownListener.getCountDownValue(i11);
    }
}
