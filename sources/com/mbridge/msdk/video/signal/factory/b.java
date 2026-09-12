package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.impl.i;
import com.mbridge.msdk.video.signal.impl.j;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.video.signal.impl.m;
import com.mbridge.msdk.video.signal.impl.n;
import com.mbridge.msdk.video.signal.impl.o;
import com.mbridge.msdk.video.signal.impl.q;
import java.util.List;

/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: h, reason: collision with root package name */
    private Activity f39857h;

    /* renamed from: i, reason: collision with root package name */
    private WebView f39858i;

    /* renamed from: j, reason: collision with root package name */
    private MBridgeVideoView f39859j;

    /* renamed from: k, reason: collision with root package name */
    private MBridgeContainerView f39860k;

    /* renamed from: l, reason: collision with root package name */
    private CampaignEx f39861l;

    /* renamed from: m, reason: collision with root package name */
    private MBridgeBTContainer f39862m;

    /* renamed from: n, reason: collision with root package name */
    private a.InterfaceC0571a f39863n;

    /* renamed from: o, reason: collision with root package name */
    private String f39864o;

    /* renamed from: p, reason: collision with root package name */
    private List<CampaignEx> f39865p;

    public b(Activity activity) {
        this.f39857h = activity;
    }

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, a.InterfaceC0571a interfaceC0571a) {
        this.f39857h = activity;
        this.f39858i = webView;
        this.f39859j = mBridgeVideoView;
        this.f39860k = mBridgeContainerView;
        this.f39861l = campaignEx;
        this.f39863n = interfaceC0571a;
        this.f39864o = mBridgeVideoView.getUnitId();
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.f39857h = activity;
        this.f39862m = mBridgeBTContainer;
        this.f39858i = webView;
    }

    public void a(k kVar) {
        this.f39851b = kVar;
    }

    public void a(List<CampaignEx> list) {
        this.f39865p = list;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getActivityProxy() {
        WebView webView = this.f39858i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.f39850a == null) {
            this.f39850a = new i(webView);
        }
        return this.f39850a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.i getIJSRewardVideoV1() {
        Activity activity;
        MBridgeContainerView mBridgeContainerView = this.f39860k;
        if (mBridgeContainerView == null || (activity = this.f39857h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f39855f == null) {
            this.f39855f = new o(activity, mBridgeContainerView);
        }
        return this.f39855f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSBTModule() {
        if (this.f39857h == null || this.f39862m == null) {
            return super.getJSBTModule();
        }
        if (this.f39856g == null) {
            this.f39856g = new j(this.f39857h, this.f39862m);
        }
        return this.f39856g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        CampaignEx campaignEx;
        List<CampaignEx> list;
        Activity activity = this.f39857h;
        if (activity == null || (campaignEx = this.f39861l) == null) {
            return super.getJSCommon();
        }
        if (this.f39851b == null) {
            this.f39851b = new k(activity, campaignEx);
        }
        if (this.f39861l.getDynamicTempCode() == 5 && (list = this.f39865p) != null) {
            d dVar = this.f39851b;
            if (dVar instanceof k) {
                ((k) dVar).a(list);
            }
        }
        this.f39851b.setActivity(this.f39857h);
        this.f39851b.setUnitId(this.f39864o);
        this.f39851b.a(this.f39863n);
        return this.f39851b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        MBridgeContainerView mBridgeContainerView = this.f39860k;
        if (mBridgeContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.f39854e == null) {
            this.f39854e = new m(mBridgeContainerView);
        }
        return this.f39854e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        WebView webView = this.f39858i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.f39853d == null) {
            this.f39853d = new n(webView);
        }
        return this.f39853d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.j getJSVideoModule() {
        MBridgeVideoView mBridgeVideoView = this.f39859j;
        if (mBridgeVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.f39852c == null) {
            this.f39852c = new q(mBridgeVideoView);
        }
        return this.f39852c;
    }
}
