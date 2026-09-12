package com.mbridge.msdk.video.signal.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.setting.c;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* renamed from: a, reason: collision with root package name */
    private int f39833a;

    /* renamed from: b, reason: collision with root package name */
    private int f39834b;

    /* renamed from: c, reason: collision with root package name */
    protected Activity f39835c;

    /* renamed from: d, reason: collision with root package name */
    protected String f39836d;

    /* renamed from: e, reason: collision with root package name */
    protected String f39837e;

    /* renamed from: f, reason: collision with root package name */
    protected c f39838f;

    /* renamed from: g, reason: collision with root package name */
    protected String f39839g;

    /* renamed from: h, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.entity.c f39840h;

    /* renamed from: i, reason: collision with root package name */
    protected String f39841i;

    /* renamed from: j, reason: collision with root package name */
    protected int f39842j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f39843k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f39844l;

    /* renamed from: m, reason: collision with root package name */
    protected int f39845m;

    /* renamed from: n, reason: collision with root package name */
    protected int f39846n;

    /* renamed from: o, reason: collision with root package name */
    protected int f39847o;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f39848p;

    /* renamed from: q, reason: collision with root package name */
    protected IJSFactory f39849q;

    public AbstractJSContainer(Context context) {
        super(context);
        this.f39833a = 0;
        this.f39834b = 1;
        this.f39842j = 2;
        this.f39843k = false;
        this.f39844l = false;
        this.f39848p = false;
        this.f39849q = new a();
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39833a = 0;
        this.f39834b = 1;
        this.f39842j = 2;
        this.f39843k = false;
        this.f39844l = false;
        this.f39848p = false;
        this.f39849q = new a();
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private boolean i(int i11) {
        try {
        } catch (Throwable th2) {
            o0.b("AbstractJSContainer", th2.getMessage(), th2);
        }
        if (i11 != 1) {
            if (i11 == 2) {
                this.f39835c.setRequestedOrientation(11);
            }
            return false;
        }
        this.f39835c.setRequestedOrientation(12);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(CampaignEx campaignEx) {
        k b11 = b(campaignEx);
        if (b11 != null) {
            return b11.n();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar, CampaignEx campaignEx) {
        CampaignEx.c rewardTemplateMode;
        if (a(campaignEx) == 1) {
            return;
        }
        if (((campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) ? false : i(rewardTemplateMode.b())) || cVar == null) {
            return;
        }
        i(this.f39838f.y());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
        f.a().b(obj, h(this.f39833a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj, String str) {
        f.a().a(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        a.C0573a a11 = com.mbridge.msdk.videocommon.a.a(this.f39843k ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, campaignEx);
        if (a11 != null && a11.c()) {
            WindVaneWebView b11 = a11.b();
            if (b11.getObject() instanceof k) {
                return (k) b11.getObject();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object obj, String str) {
        f.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        o0.b("AbstractJSContainer", str);
        Activity activity = this.f39835c;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public b getActivityProxy() {
        return this.f39849q.getActivityProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.f39849q.getIJSRewardVideoV1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getInnerPlacementId() {
        c cVar;
        return (!TextUtils.isEmpty(this.f39837e) || (cVar = this.f39838f) == null || TextUtils.isEmpty(cVar.t())) ? this.f39837e : this.f39838f.t();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.c getJSBTModule() {
        return this.f39849q.getJSBTModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        return this.f39849q.getJSCommon();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.f getJSContainerModule() {
        return this.f39849q.getJSContainerModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.f39849q.getJSNotifyProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        return this.f39849q.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.f39837e;
    }

    public String getUnitId() {
        return this.f39836d;
    }

    protected String h(int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i11);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
        } catch (Throwable unused) {
            o0.b("AbstractJSContainer", "code to string is error");
        }
        return "";
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().a()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().a()) {
            getActivityProxy().b();
        }
    }

    public void onPause() {
        if (getJSCommon().a()) {
            getActivityProxy().g();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().a()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.mbridge.msdk.foundation.feedback.b.f35343f) {
            return;
        }
        if (getJSCommon().a()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().a()) {
            getActivityProxy().h();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().a()) {
            getActivityProxy().c();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.f39849q = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.f39835c = activity;
    }

    public void setBidCampaign(boolean z10) {
        this.f39844l = z10;
    }

    public void setBigOffer(boolean z10) {
        this.f39848p = z10;
    }

    public void setIV(boolean z10) {
        this.f39843k = z10;
    }

    public void setIVRewardEnable(int i11, int i12, int i13) {
        this.f39845m = i11;
        this.f39846n = i12;
        this.f39847o = i13;
    }

    public void setMute(int i11) {
        this.f39842j = i11;
    }

    public void setPlacementId(String str) {
        this.f39837e = str;
    }

    public void setReward(com.mbridge.msdk.videocommon.entity.c cVar) {
        this.f39840h = cVar;
    }

    public void setRewardId(String str) {
        this.f39841i = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f39838f = cVar;
    }

    public void setUnitId(String str) {
        this.f39836d = str;
    }

    public void setUserId(String str) {
        this.f39839g = str;
    }
}
