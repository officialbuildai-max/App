package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.listener.impl.i;
import com.mbridge.msdk.video.module.listener.impl.k;
import com.mbridge.msdk.video.module.listener.impl.l;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.h;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class MBridgeContainerView extends MBridgeBaseView implements f, h {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private com.mbridge.msdk.video.signal.factory.b Q;
    private boolean R;
    private boolean S;
    private List<CampaignEx> T;

    /* renamed from: m, reason: collision with root package name */
    private MBridgePlayableView f39307m;

    /* renamed from: n, reason: collision with root package name */
    private MBridgeClickCTAView f39308n;

    /* renamed from: o, reason: collision with root package name */
    private MBridgeClickMiniCardView f39309o;

    /* renamed from: p, reason: collision with root package name */
    private MBridgeNativeEndCardView f39310p;

    /* renamed from: q, reason: collision with root package name */
    private MBridgeH5EndCardView f39311q;

    /* renamed from: r, reason: collision with root package name */
    private MBridgeVastEndCardView f39312r;

    /* renamed from: s, reason: collision with root package name */
    private MBridgeLandingPageView f39313s;

    /* renamed from: t, reason: collision with root package name */
    private MBridgeVideoEndCoverView f39314t;

    /* renamed from: u, reason: collision with root package name */
    private MBridgeAlertWebview f39315u;

    /* renamed from: v, reason: collision with root package name */
    private MBridgeOrderCampView f39316v;

    /* renamed from: w, reason: collision with root package name */
    private String f39317w;

    /* renamed from: x, reason: collision with root package name */
    private int f39318x;

    /* renamed from: y, reason: collision with root package name */
    private int f39319y;

    /* renamed from: z, reason: collision with root package name */
    private int f39320z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.video.signal.factory.b f39321a;

        a(com.mbridge.msdk.video.signal.factory.b bVar) {
            this.f39321a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
            mBridgeContainerView.a(this.f39321a, Integer.valueOf(mBridgeContainerView.f39280b.getVideo_end_type()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.video.signal.factory.b f39323a;

        b(com.mbridge.msdk.video.signal.factory.b bVar) {
            this.f39323a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
            mBridgeContainerView.a(this.f39323a, Integer.valueOf(mBridgeContainerView.f39280b.getVideo_end_type()));
        }
    }

    /* loaded from: classes5.dex */
    class c implements com.mbridge.msdk.video.dynview.listener.b {
        c() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.b
        public void a() {
            com.mbridge.msdk.video.module.listener.a aVar = MBridgeContainerView.this.notifyListener;
            if (aVar != null) {
                aVar.a(Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, "");
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.b
        public void b() {
            if (MBridgeContainerView.this.f39280b.getAdSpaceT() == 2) {
                MBridgeContainerView.this.showVideoEndCover();
            } else {
                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                mBridgeContainerView.showEndcard(mBridgeContainerView.f39280b.getVideo_end_type());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends i {
        d(com.mbridge.msdk.video.module.listener.a aVar) {
            super(aVar);
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.i, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
        public void a(int i11, Object obj) {
            super.a(i11, obj);
            if (i11 == 100) {
                MBridgeContainerView.this.webviewshow();
                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                m mVar = new m();
                mVar.n(MBridgeContainerView.this.f39280b.getRequestId());
                mVar.o(MBridgeContainerView.this.f39280b.getRequestIdNotice());
                mVar.b(MBridgeContainerView.this.f39280b.getId());
                mVar.b(MBridgeContainerView.this.f39280b.isMraid() ? m.N : m.O);
                MBridgeContainerView mBridgeContainerView2 = MBridgeContainerView.this;
                g.d(mVar, mBridgeContainerView2.f39279a, mBridgeContainerView2.f39317w);
            }
        }
    }

    public MBridgeContainerView(Context context) {
        super(context);
        this.f39319y = 1;
        this.f39320z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.I = false;
        this.J = false;
        this.R = false;
        this.S = false;
        this.T = new ArrayList();
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39319y = 1;
        this.f39320z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.I = false;
        this.J = false;
        this.R = false;
        this.S = false;
        this.T = new ArrayList();
    }

    private void a(Configuration configuration, MBridgeBaseView... mBridgeBaseViewArr) {
        for (MBridgeBaseView mBridgeBaseView : mBridgeBaseViewArr) {
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
            }
        }
    }

    private void a(com.mbridge.msdk.video.module.listener.a aVar, MBridgeBaseView... mBridgeBaseViewArr) {
        for (MBridgeBaseView mBridgeBaseView : mBridgeBaseViewArr) {
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.g(this.f39309o, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    private void a(com.mbridge.msdk.video.signal.factory.b bVar) {
        if (this.f39307m == null) {
            this.f39307m = new MBridgePlayableView(this.f39279a);
        }
        this.f39307m.setCloseDelayShowTime(this.f39320z);
        this.f39307m.setPlayCloseBtnTm(this.A);
        this.f39307m.setCampaign(this.f39280b);
        this.f39307m.setNotifyListener(new d(this.notifyListener));
        this.f39307m.preLoadData(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.video.signal.factory.b bVar, Integer num) {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.module.listener.a aVar;
        CampaignEx campaignEx2;
        this.Q = bVar;
        CampaignEx campaignEx3 = this.f39280b;
        if (campaignEx3 != null) {
            if (num == null) {
                num = Integer.valueOf(campaignEx3.getVideo_end_type());
            }
            if (!isLast()) {
                o();
            }
            int intValue = num.intValue();
            if (intValue != 1) {
                if (intValue == 3) {
                    if (this.f39312r == null) {
                        this.f39312r = new MBridgeVastEndCardView(this.f39279a);
                    }
                    this.f39312r.setCampaign(this.f39280b);
                    this.f39312r.setNotifyListener(new l(this.notifyListener));
                    this.f39312r.preLoadData(bVar);
                    return;
                }
                if (intValue == 4) {
                    if (this.f39313s == null) {
                        this.f39313s = new MBridgeLandingPageView(this.f39279a);
                    }
                    this.f39313s.setCampaign(this.f39280b);
                    this.f39313s.setNotifyListener(new i(this.notifyListener));
                    return;
                }
                if (intValue != 5) {
                    if (this.f39319y == 2) {
                        boolean isDynamicView = this.f39280b.isDynamicView();
                        boolean l11 = t0.l(this.f39280b.getendcard_url());
                        if ((isDynamicView && !l11 && (campaignEx2 = this.f39280b) != null && !campaignEx2.isMraid()) || (campaignEx = this.f39280b) == null || campaignEx.getAdSpaceT() == 2) {
                            return;
                        }
                        if (this.f39311q == null) {
                            this.f39311q = new MBridgeH5EndCardView(this.f39279a);
                            try {
                                e eVar = new e();
                                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", this.f39280b, eVar);
                            } catch (Throwable th2) {
                                o0.b(MBridgeBaseView.TAG, th2.getMessage());
                            }
                        }
                        if (this.f39280b.getDynamicTempCode() == 5 && (aVar = this.notifyListener) != null && (aVar instanceof k)) {
                            ((k) aVar).a(this.f39280b);
                        }
                        this.f39311q.setCampaign(this.f39280b);
                        this.f39311q.setCloseDelayShowTime(this.f39320z);
                        this.f39311q.setNotifyListener(new i(this.notifyListener));
                        this.f39311q.setUnitId(this.f39317w);
                        this.f39311q.setNotchValue(this.P, this.K, this.L, this.M, this.N);
                        this.f39311q.preLoadData(bVar);
                        if (this.D) {
                            return;
                        }
                        addView(this.f39311q);
                        return;
                    }
                    CampaignEx campaignEx4 = this.f39280b;
                    int b11 = (campaignEx4 == null || campaignEx4.getRewardTemplateMode() == null) ? 0 : this.f39280b.getRewardTemplateMode().b();
                    if (this.f39310p == null) {
                        CampaignEx campaignEx5 = this.f39280b;
                        if (campaignEx5 == null || !campaignEx5.isDynamicView()) {
                            Context context = this.f39279a;
                            CampaignEx campaignEx6 = this.f39280b;
                            boolean z10 = campaignEx6 != null && campaignEx6.getAdSpaceT() == 2;
                            CampaignEx campaignEx7 = this.f39280b;
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(context, null, false, -1, z10, b11, campaignEx7 != null ? campaignEx7.getMof_tplid() : 0);
                            this.f39310p = mBridgeNativeEndCardView;
                            mBridgeNativeEndCardView.setCampaign(this.f39280b);
                        } else {
                            p();
                        }
                    }
                    this.f39310p.setLayout();
                    if (this.f39280b.isDynamicView()) {
                        if (com.mbridge.msdk.video.dynview.moffer.a.a().b(this.f39280b.getRequestId() + "_" + this.f39280b.getId())) {
                            try {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f39310p, this.f39280b.getRequestId() + "_" + this.f39280b.getId(), new i(this.notifyListener));
                            } catch (Exception e11) {
                                o0.b(MBridgeBaseView.TAG, e11.getMessage());
                            }
                        } else {
                            try {
                                String a11 = z0.a(this.f39280b.getendcard_url(), "mof");
                                if (!TextUtils.isEmpty(a11) && Integer.parseInt(a11) == 1) {
                                    com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f39280b, this.f39310p, new i(this.notifyListener), 2);
                                }
                            } catch (Exception e12) {
                                o0.b(MBridgeBaseView.TAG, e12.getMessage());
                            }
                        }
                    }
                    this.f39310p.setUnitId(this.f39317w);
                    this.f39310p.setCloseBtnDelay(this.f39320z);
                    this.f39310p.setNotifyListener(new i(this.notifyListener));
                    this.f39310p.preLoadData(bVar);
                    this.f39310p.setNotchPadding(this.K, this.L, this.M, this.N);
                }
            }
        }
    }

    private void a(MBridgeH5EndCardView... mBridgeH5EndCardViewArr) {
        for (MBridgeH5EndCardView mBridgeH5EndCardView : mBridgeH5EndCardViewArr) {
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    private void addCTAView() {
        if (this.f39308n == null) {
            b(-1);
        }
        if (this.f39308n != null) {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || !campaignEx.isDynamicView()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                addView(this.f39308n, 0, layoutParams);
            }
        }
    }

    private void b(int i11) {
        if (i11 != -3) {
            if (i11 != -2) {
                if (this.f39308n == null) {
                    this.f39308n = new MBridgeClickCTAView(this.f39279a);
                }
                this.f39308n.setCampaign(this.f39280b);
                this.f39308n.setUnitId(this.f39317w);
                this.f39308n.setNotifyListener(new i(this.notifyListener));
                this.f39308n.preLoadData(this.Q);
                return;
            }
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || campaignEx.getVideo_end_type() != 2) {
                return;
            }
            if (this.f39309o == null) {
                this.f39309o = new MBridgeClickMiniCardView(this.f39279a);
            }
            this.f39309o.setCampaign(this.f39280b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
            mBridgeClickMiniCardView.setNotifyListener(new com.mbridge.msdk.video.module.listener.impl.g(mBridgeClickMiniCardView, this.notifyListener));
            this.f39309o.preLoadData(this.Q);
            setMatchParent();
            i();
            o();
        }
    }

    private void b(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.Q = bVar;
        if (this.f39314t == null) {
            MBridgeVideoEndCoverView mBridgeVideoEndCoverView = new MBridgeVideoEndCoverView(this.f39279a);
            this.f39314t = mBridgeVideoEndCoverView;
            mBridgeVideoEndCoverView.setCampaign(this.f39280b);
            this.f39314t.setNotifyListener(new i(this.notifyListener));
            this.f39314t.preLoadData(bVar);
        }
    }

    private void b(MBridgeH5EndCardView... mBridgeH5EndCardViewArr) {
        for (MBridgeH5EndCardView mBridgeH5EndCardView : mBridgeH5EndCardViewArr) {
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    private void e() {
        if (this.f39315u == null) {
            q();
        }
        MBridgeAlertWebview mBridgeAlertWebview = this.f39315u;
        if (mBridgeAlertWebview != null && mBridgeAlertWebview.getParent() != null) {
            removeView(this.f39315u);
        }
        addView(this.f39315u);
    }

    private void f() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            boolean isDynamicView = campaignEx.isDynamicView();
            boolean l11 = t0.l(this.f39280b.getendcard_url());
            if (isDynamicView && !l11 && !this.f39280b.isMraid()) {
                j();
                return;
            }
        }
        if (this.f39319y != 2 || this.I) {
            j();
        } else {
            g();
        }
    }

    private void g() {
        if (this.f39311q == null) {
            a(this.Q, (Integer) 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            j();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f39311q;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.f39311q.setError(true);
            }
        } else {
            this.I = true;
            addView(this.f39311q);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.f39311q.excuteTask();
            this.f39311q.setNotchValue(this.P, this.K, this.L, this.M, this.N);
            m mVar = new m();
            mVar.n(this.f39280b.getRequestId());
            mVar.o(this.f39280b.getRequestIdNotice());
            mVar.b(this.f39280b.getId());
            mVar.b(this.f39280b.isMraid() ? m.N : m.O);
            g.d(mVar, this.f39279a, this.f39317w);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.f39311q;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.f39317w);
        }
    }

    private void h() {
        if (this.f39313s == null) {
            a(this.Q, (Integer) 4);
        }
        this.f39313s.setUnitId(this.f39317w);
        this.f39313s.preLoadData(this.Q);
        addView(this.f39313s);
    }

    private void i() {
        if (this.f39309o == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.D && this.E) {
            this.E = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.f39309o, layoutParams);
    }

    private void j() {
        this.f39319y = 1;
        if (this.f39310p == null) {
            a(this.Q, (Integer) 2);
        }
        addView(this.f39310p);
        onConfigurationChanged(getResources().getConfiguration());
        this.f39310p.notifyShowListener();
        this.S = true;
        bringToFront();
    }

    private void k() {
        if (this.f39307m == null) {
            preLoadData(this.Q);
        }
        addView(this.f39307m);
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.setUnitId(this.f39317w);
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null && campaignEx.isMraid() && this.f39280b.getPlayable_ads_without_video() == 2) {
                this.f39307m.setCloseVisible(0);
            }
            this.f39307m.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
    }

    private void l() {
        if (this.f39312r == null) {
            a(this.Q, (Integer) 3);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        addView(this.f39312r, layoutParams);
        this.f39312r.notifyShowListener();
    }

    private void m() {
        if (this.f39314t == null) {
            b(this.Q);
        }
        addView(this.f39314t);
        onConfigurationChanged(getResources().getConfiguration());
        this.S = true;
        bringToFront();
    }

    private boolean n() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1;
    }

    private void o() {
        this.C = false;
        this.S = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i11 = 0;
            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof MBridgeContainerView) {
                    i11++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    private void p() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getendcard_url();
        boolean isEmpty = TextUtils.isEmpty(str);
        int i11 = TTAdConstant.DEEPLINK_FALLBACK_CODE;
        if (!isEmpty) {
            try {
                i11 = Integer.parseInt(z0.a(str, "ecid"));
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage());
            }
        }
        this.f39310p = new MBridgeNativeEndCardView(this.f39279a, null, true, i11, this.f39280b.getAdSpaceT() == 2, this.f39289k, this.f39280b.getMof_tplid());
        if (this.f39280b.getDynamicTempCode() != 5) {
            this.f39310p.setCampaign(this.f39280b);
            return;
        }
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.f39280b);
        }
        this.f39310p.setCampaign(this.f39280b);
    }

    private void q() {
        if (this.f39315u == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.f39279a);
            this.f39315u = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.f39317w);
            this.f39315u.setCampaign(this.f39280b);
        }
        this.f39315u.preLoadData(this.Q);
    }

    private void r() {
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list == null) {
            return;
        }
        this.T = list;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view == null) {
            o0.b(MBridgeBaseView.TAG, "view is null");
        } else {
            a(view);
            super.addView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            o0.b(MBridgeBaseView.TAG, "view is null");
        } else {
            a(view);
            super.addView(view, layoutParams);
        }
    }

    public boolean canBackPress() {
        if (this.f39310p != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f39313s;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void configurationChanged(int i11, int i12, int i13) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.f39309o.resizeMiniCard(i11, i12);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean endCardShowing() {
        return this.B;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        return mBridgeH5EndCardView != null && mBridgeH5EndCardView.isPlayable();
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        return mBridgeH5EndCardView == null ? this.f39307m : mBridgeH5EndCardView;
    }

    public CampaignEx getReSetCampaign() {
        if (!this.f39280b.isDynamicView() || !TextUtils.isEmpty(this.f39280b.getendcard_url())) {
            return null;
        }
        int size = this.T.size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 < size) {
                if (this.T.get(i12) != null && this.T.get(i12).getId() == this.f39280b.getId()) {
                    i11 = i12 - 1;
                    break;
                }
                i12++;
            } else {
                break;
            }
        }
        if (i11 < 0 || i11 >= size || this.T.get(i11) == null) {
            return null;
        }
        return this.T.get(i11);
    }

    public boolean getShowingTransparent() {
        return this.D;
    }

    public String getUnitID() {
        return this.f39317w;
    }

    public int getVideoInteractiveType() {
        return this.f39318x;
    }

    public int getVideoSkipTime() {
        return this.H;
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView == null) {
            f();
            return;
        }
        mBridgeH5EndCardView.handlerPlayableException(str);
        if (this.I) {
            f();
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.R && !this.S) {
            o();
            this.R = false;
        }
        MBridgeAlertWebview mBridgeAlertWebview = this.f39315u;
        if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.f39315u);
        MBridgeClickCTAView mBridgeClickCTAView = this.f39308n;
        if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
            return;
        }
        r();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        setVisibility(0);
    }

    public void install(CampaignEx campaignEx) {
        this.notifyListener.a(105, campaignEx);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup != null && viewGroup.indexOfChild(this) == 0;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void ivRewardAdsWithoutVideo(String str) {
        this.notifyListener.a(103, str);
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
        return mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.isLoadSuccess();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean miniCardShowing() {
        return this.C;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i11);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i11);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(configuration, this.f39307m, this.f39308n, this.f39309o, this.f39310p, this.f39311q, this.f39312r, this.f39313s, this.f39314t);
    }

    public void onEndcardBackPress() {
        if (this.f39310p != null || this.f39312r != null) {
            this.notifyListener.a(104, "");
            try {
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
                return;
            } catch (Exception e11) {
                o0.b(MBridgeBaseView.TAG, e11.getMessage());
                return;
            }
        }
        if (this.f39313s != null) {
            this.notifyListener.a(103, "");
            return;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.C) {
            this.notifyListener.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void orientation(Configuration configuration) {
        a(this.f39307m, this.f39309o, this.f39311q, this.f39315u);
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.Q = bVar;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                a(bVar);
            } else {
                b(this.f39318x);
                if (this.f39280b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.f39280b.getVideo_end_type()));
                    } catch (Throwable th2) {
                        o0.b(MBridgeBaseView.TAG, th2.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new a(bVar));
                    }
                    if (!t0.l(this.f39280b.getendcard_url())) {
                        try {
                            String a11 = z0.a(this.f39280b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a11) && Integer.parseInt(a11) == 1) {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f39280b, 2);
                            }
                        } catch (Exception e11) {
                            o0.b(MBridgeBaseView.TAG, e11.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new b(bVar), getVideoSkipTime());
                }
            }
            q();
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void readyStatus(int i11) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i11);
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.f39311q = null;
        }
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f39313s;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f39310p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.f39310p.release();
        }
        if (this.notifyListener != null) {
            this.notifyListener = null;
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void resizeMiniCard(int i11, int i12, int i13) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i11, i12);
            this.f39309o.setRadius(i13);
            removeAllViews();
            setMatchParent();
            this.S = true;
            bringToFront();
            i();
        }
    }

    public void setCloseDelayTime(int i11) {
        this.f39320z = i11;
    }

    public void setEndscreenType(int i11) {
        this.f39319y = i11;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.Q = bVar;
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.f39309o.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14, int i15) {
        o0.b(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i11)));
        this.O = i11;
        this.K = i12;
        this.L = i13;
        this.M = i14;
        this.N = i15;
        this.P = b0.a(i11, i12, i13, i14, i15);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f39310p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i12, i13, i14, i15);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.f39330p != null) {
            mBridgeH5EndCardView.setNotchValue(this.P, i12, i13, i14, i15);
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f39311q.f39330p, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null && mBridgePlayableView.f39330p != null) {
            mBridgePlayableView.setNotchValue(this.P, i12, i13, i14, i15);
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f39307m.f39330p, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.f39316v;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i12, i13, i14, i15);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setNotifyListener(com.mbridge.msdk.video.module.listener.a aVar) {
        super.setNotifyListener(aVar);
        a(aVar, this.f39307m, this.f39308n, this.f39309o, this.f39310p, this.f39311q, this.f39312r, this.f39313s, this.f39314t);
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f39310p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f39310p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i11) {
        this.A = i11;
    }

    public void setRewardStatus(boolean z10) {
        this.J = z10;
    }

    public void setShowingTransparent(boolean z10) {
        this.D = z10;
    }

    public void setUnitID(String str) {
        this.f39317w = str;
    }

    public void setVideoInteractiveType(int i11) {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            this.f39318x = i11;
            return;
        }
        int b11 = com.mbridge.msdk.video.dynview.util.a.b(this.f39280b);
        if (b11 == 100) {
            this.f39318x = i11;
        } else {
            this.f39318x = b11;
        }
    }

    public void setVideoSkipTime(int i11) {
        this.H = i11;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.f39315u;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        if (!n() && !this.S) {
            removeAllViews();
            bringToFront();
            this.R = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        e();
        setBackgroundColor(0);
        this.f39315u.webviewshow();
        return true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showEndcard(int i11) {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            if (i11 == 1) {
                this.notifyListener.a(104, "");
            } else if (i11 == 100) {
                if (campaignEx.getPlayable_ads_without_video() == 2) {
                    this.G = true;
                }
                a(this.f39307m);
                setMatchParent();
                j();
            } else if (i11 == 3) {
                removeAllViews();
                setMatchParent();
                l();
                this.S = true;
                bringToFront();
            } else if (i11 == 4) {
                this.notifyListener.a(113, "");
                removeAllViews();
                setMatchParent();
                h();
                this.S = true;
                bringToFront();
            } else if (i11 != 5) {
                removeAllViews();
                setMatchParent();
                this.S = true;
                bringToFront();
                f();
                this.notifyListener.a(Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, "");
            } else {
                this.notifyListener.a(106, "");
            }
        }
        this.B = true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showMiniCard(int i11, int i12, int i13, int i14, int i15) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i11, i12, i13, i14);
            this.f39309o.setRadius(i15);
            this.f39309o.setCloseVisible(8);
            this.f39309o.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.S = true;
            bringToFront();
            i();
            if (this.F) {
                return;
            }
            this.F = true;
            this.notifyListener.a(109, "");
            this.notifyListener.a(Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, "");
        }
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.f39279a);
        this.f39316v = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.T);
        com.mbridge.msdk.video.module.listener.a aVar = this.notifyListener;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.T);
        }
        this.f39316v.setNotifyListener(new i(this.notifyListener));
        this.f39316v.setRewarded(this.J);
        this.f39316v.setNotchPadding(this.K, this.L, this.M, this.N);
        this.f39316v.setCampOrderViewBuildCallback(new c());
        this.f39316v.createView(this);
    }

    public void showPlayableView() {
        if (this.f39280b == null || this.G) {
            return;
        }
        removeAllViews();
        setMatchParent();
        k();
        this.S = true;
        bringToFront();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoClickView(int i11) {
        if (this.f39280b != null) {
            if (i11 == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                o();
                return;
            }
            if (i11 == 1) {
                if (this.B) {
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
                if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getParent() != null) {
                    removeView(this.f39311q);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f39309o;
                if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
                    removeView(this.f39309o);
                }
                MBridgeClickCTAView mBridgeClickCTAView = this.f39308n;
                if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
                    try {
                        CampaignEx campaignEx = this.f39280b;
                        if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 1) {
                            this.S = true;
                            addCTAView();
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                    return;
                }
                return;
            }
            if (i11 != 2) {
                return;
            }
            MBridgeClickCTAView mBridgeClickCTAView2 = this.f39308n;
            if (mBridgeClickCTAView2 != null && mBridgeClickCTAView2.getParent() != null) {
                removeView(this.f39308n);
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.f39315u;
            if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f39309o;
                if (mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null) {
                    try {
                        CampaignEx campaignEx2 = this.f39280b;
                        if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 1) {
                            setMatchParent();
                            i();
                        }
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
                if (!miniCardLoaded()) {
                    o();
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f39311q;
                if (mBridgeH5EndCardView2 != null && mBridgeH5EndCardView2.getParent() != null) {
                    removeView(this.f39311q);
                }
                this.notifyListener.a(112, "");
                CampaignEx campaignEx3 = this.f39280b;
                if (campaignEx3 != null && !campaignEx3.isHasReportAdTrackPause()) {
                    this.f39280b.setHasReportAdTrackPause(true);
                    com.mbridge.msdk.video.module.report.b.c(this.f39279a, this.f39280b);
                }
                if (this.D) {
                    this.notifyListener.a(Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, "");
                } else {
                    this.S = true;
                    bringToFront();
                    webviewshow();
                    onConfigurationChanged(getResources().getConfiguration());
                }
                this.C = true;
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        m();
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        MBridgePlayableView mBridgePlayableView = this.f39307m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i11);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f39311q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i11);
        }
    }

    public void triggerCloseBtn(String str) {
        try {
            e eVar = new e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.f39280b);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
        if (this.f39280b != null) {
            this.notifyListener.a(Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, "");
            this.notifyListener.a(104, "");
        }
    }

    public void webviewshow() {
        try {
            e eVar = new e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000133", this.f39280b, eVar);
        } catch (Exception unused) {
        }
        b(this.f39307m, this.f39309o, this.f39311q, this.f39315u);
    }
}
