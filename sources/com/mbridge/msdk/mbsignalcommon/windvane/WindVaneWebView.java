package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;

/* loaded from: classes5.dex */
public class WindVaneWebView extends BaseWebView {

    /* renamed from: d, reason: collision with root package name */
    protected j f36579d;

    /* renamed from: e, reason: collision with root package name */
    protected b f36580e;

    /* renamed from: f, reason: collision with root package name */
    protected e f36581f;

    /* renamed from: g, reason: collision with root package name */
    private Object f36582g;

    /* renamed from: h, reason: collision with root package name */
    private Object f36583h;

    /* renamed from: i, reason: collision with root package name */
    private String f36584i;

    /* renamed from: j, reason: collision with root package name */
    private c f36585j;

    /* renamed from: k, reason: collision with root package name */
    private String f36586k;

    /* renamed from: l, reason: collision with root package name */
    private String f36587l;

    /* renamed from: m, reason: collision with root package name */
    private CampaignEx f36588m;

    /* renamed from: n, reason: collision with root package name */
    private int f36589n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f36590o;

    /* renamed from: p, reason: collision with root package name */
    private float f36591p;

    /* renamed from: q, reason: collision with root package name */
    private float f36592q;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WindVaneWebView.this.f36590o = true;
            WindVaneWebView.this.destroy();
        }
    }

    public WindVaneWebView(Context context) {
        super(context);
        this.f36590o = false;
        this.f36591p = 0.0f;
        this.f36592q = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36590o = false;
        this.f36591p = 0.0f;
        this.f36592q = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36590o = false;
        this.f36591p = 0.0f;
        this.f36592q = 0.0f;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.BaseWebView
    protected void a() {
        super.a();
        getSettings().setSavePassword(false);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f36579d == null) {
            this.f36579d = new j(this);
        }
        setWebViewChromeClient(this.f36579d);
        k kVar = new k();
        this.mWebViewClient = kVar;
        setWebViewClient(kVar);
        if (this.f36580e == null) {
            b hVar = new h(this.f36479a);
            this.f36580e = hVar;
            setSignalCommunication(hVar);
        }
        this.f36581f = new e(this.f36479a, this);
    }

    public void clearWebView() {
        if (this.f36590o) {
            return;
        }
        loadUrl(TmcConstants.LOAD_BASE_DATA_URL);
    }

    public CampaignEx getCampaignEx() {
        return this.f36588m;
    }

    public String getCampaignId() {
        return this.f36584i;
    }

    public Object getJsObject(String str) {
        e eVar = this.f36581f;
        if (eVar == null) {
            return null;
        }
        return eVar.a(str);
    }

    public String getLocalRequestId() {
        return this.f36587l;
    }

    public Object getMraidObject() {
        return this.f36583h;
    }

    public Object getObject() {
        return this.f36582g;
    }

    public String getRid() {
        return this.f36586k;
    }

    public b getSignalCommunication() {
        return this.f36580e;
    }

    public c getWebViewListener() {
        return this.f36585j;
    }

    public boolean isDestoryed() {
        return this.f36590o;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.a() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f36591p = motionEvent.getRawX();
                    this.f36592q = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.f36591p;
                    float y10 = motionEvent.getY() - this.f36592q;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48) && ((rawX <= 0.0f || rawX <= 48) && ((y10 >= 0.0f || (-1.0f) * y10 <= 48) && (y10 <= 0.0f || y10 <= 48)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        e eVar = this.f36581f;
        if (eVar == null) {
            return;
        }
        eVar.a(cls.getSimpleName(), cls);
    }

    public void release() {
        try {
            if (!this.f36590o) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(this.f36589n));
                if (this.f36588m != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000135", this.f36588m, eVar);
                }
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener(null);
            this.f36582g = null;
            if (t0.b(getContext()) == 0) {
                this.f36590o = true;
                destroy();
            } else {
                new Handler().postDelayed(new a(), r0 * 1000);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        e eVar = this.f36581f;
        if (eVar != null) {
            eVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        e eVar = this.f36581f;
        if (eVar != null) {
            eVar.a(obj);
        }
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.f36588m = campaignEx;
    }

    public void setCampaignId(String str) {
        this.f36584i = str;
    }

    public void setLocalRequestId(String str) {
        this.f36587l = str;
    }

    public void setMraidObject(Object obj) {
        this.f36583h = obj;
    }

    public void setObject(Object obj) {
        this.f36582g = obj;
    }

    public void setRid(String str) {
        this.f36586k = str;
    }

    public void setSignalCommunication(b bVar) {
        this.f36580e = bVar;
        bVar.a(this);
    }

    public void setTempTypeForMetrics(int i11) {
        this.f36589n = i11;
    }

    public void setWebViewChromeClient(j jVar) {
        this.f36579d = jVar;
        setWebChromeClient(jVar);
    }

    public void setWebViewListener(c cVar) {
        this.f36585j = cVar;
        j jVar = this.f36579d;
        if (jVar != null) {
            jVar.a(cVar);
        }
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(cVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }
}
