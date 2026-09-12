package com.mbridge.msdk.video.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.tn.lib.view.FlowLayout;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeNativeEndCardView extends MBridgeNativeEndCardViewDiff {
    private LinearLayout A;
    private Runnable B;
    private Runnable C;
    private RelativeLayout D;
    private com.mbridge.msdk.video.signal.factory.b E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private AlphaAnimation K;
    private int L;
    private int M;
    private int N;
    private int O;
    private Bitmap P;
    private View Q;
    private FeedBackButton R;
    private String S;
    private CampaignUnit T;
    private MBShakeView U;
    private com.mbridge.msdk.shake.b V;
    private MBridgeBaitClickView W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f39359a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f39360b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f39361c0;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f39362m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup f39363n;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout f39364o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f39365p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f39366q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f39367r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f39368s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f39369t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f39370u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f39371v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f39372w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f39373x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f39374y;

    /* renamed from: z, reason: collision with root package name */
    private LinearLayout f39375z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends com.mbridge.msdk.widget.a {
        a() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (MBridgeNativeEndCardView.this.ctaView != null) {
                if (!com.mbridge.msdk.util.b.a()) {
                    MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
                    MBridgeNativeEndCardView.this.c(0);
                } else if (MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                    MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
                    MBridgeNativeEndCardView.this.c(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBridgeNativeEndCardView.this.D != null) {
                CampaignEx campaignEx = MBridgeNativeEndCardView.this.f39280b;
                if (campaignEx != null && !campaignEx.isDynamicView() && MBridgeNativeEndCardView.this.f39280b.getAdSpaceT() != 2) {
                    MBridgeNativeEndCardView.this.D.setPadding(MBridgeNativeEndCardView.this.L, MBridgeNativeEndCardView.this.N, MBridgeNativeEndCardView.this.M, MBridgeNativeEndCardView.this.O);
                    MBridgeNativeEndCardView.this.D.startAnimation(MBridgeNativeEndCardView.this.K);
                }
                MBridgeNativeEndCardView.this.D.setVisibility(0);
            }
            if (MBridgeNativeEndCardView.this.Q != null && MBridgeNativeEndCardView.this.Q.getVisibility() != 0 && MBridgeNativeEndCardView.this.G) {
                MBridgeNativeEndCardView.this.Q.setVisibility(0);
            }
            MBridgeNativeEndCardView.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            MBridgeNativeEndCardView.this.I = true;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            MBridgeNativeEndCardView.this.I = false;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            MBridgeNativeEndCardView.this.I = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(5);
            MBridgeNativeEndCardView.this.c(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends com.mbridge.msdk.shake.b {
        e(int i11, int i12) {
            super(i11, i12);
        }

        @Override // com.mbridge.msdk.shake.b
        public void a() {
            if ((com.mbridge.msdk.util.b.a() && MBridgeNativeEndCardView.this.checkChinaShakeState()) || MBridgeNativeEndCardView.this.I || !MBridgeNativeEndCardView.this.H) {
                return;
            }
            MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
            mBridgeNativeEndCardView.f39284f = 0.0f;
            mBridgeNativeEndCardView.f39285g = 0.0f;
            mBridgeNativeEndCardView.f39280b.setTriggerClickSource(5);
            MBridgeNativeEndCardView.this.c(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
            MBridgeNativeEndCardView.this.c(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
            MBridgeNativeEndCardView.this.f39280b.setClickType(1);
            MBridgeNativeEndCardView.this.c(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
            MBridgeNativeEndCardView.this.f39280b.setClickType(1);
            MBridgeNativeEndCardView.this.c(2);
        }
    }

    /* loaded from: classes5.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeNativeEndCardView.this.G = true;
            if (MBridgeNativeEndCardView.this.Q != null) {
                MBridgeNativeEndCardView.this.Q.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements com.mbridge.msdk.video.dynview.listener.h {
        j() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                MBridgeNativeEndCardView.this.addView(aVar.b());
                MBridgeNativeEndCardView.this.f39359a0 = aVar.c();
                if (MBridgeNativeEndCardView.this.ctaViewCanGet(aVar.b(), MBridgeNativeEndCardView.this.f39359a0)) {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                    mBridgeNativeEndCardView.f39283e = mBridgeNativeEndCardView.a(aVar.b());
                    MBridgeNativeEndCardView.this.l();
                } else {
                    MBridgeNativeEndCardView.this.f39359a0 = false;
                    MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                    mBridgeNativeEndCardView2.f39286h = false;
                    mBridgeNativeEndCardView2.j();
                }
                MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                CampaignEx campaignEx = mBridgeNativeEndCardView3.f39280b;
                if (campaignEx != null) {
                    campaignEx.setECTemplateRenderSucc(mBridgeNativeEndCardView3.f39359a0);
                }
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            o0.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class k implements com.mbridge.msdk.foundation.same.image.c {
        k() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                if (MBridgeNativeEndCardView.this.f39366q != null) {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                    if (mBridgeNativeEndCardView.f39286h) {
                        mBridgeNativeEndCardView.f39366q.setBackground(null);
                    }
                    MBridgeNativeEndCardView.this.f39366q.setImageBitmap(bitmap);
                }
                MBridgeNativeEndCardView.this.setBannerBackGroundBlurBimap(bitmap);
            } catch (Throwable unused) {
                if (MBridgeNativeEndCardView.this.f39365p != null) {
                    MBridgeNativeEndCardView.this.f39365p.setVisibility(4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l implements com.mbridge.msdk.foundation.feedback.a {
        l() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            MBridgeNativeEndCardView.this.I = true;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            MBridgeNativeEndCardView.this.I = false;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            MBridgeNativeEndCardView.this.I = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f39388a;

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                if (mBridgeNativeEndCardView.f39286h) {
                    mBridgeNativeEndCardView.f39365p.setBackground(null);
                }
                o0.b(TmcConstants.KEY_ASYNC, "执行异步加载图");
                MBridgeNativeEndCardView.this.f39365p.setImageBitmap(MBridgeNativeEndCardView.this.P);
            }
        }

        m(Bitmap bitmap) {
            this.f39388a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
            mBridgeNativeEndCardView.P = mBridgeNativeEndCardView.blurBitmap(this.f39388a);
            if (MBridgeNativeEndCardView.this.P == null || MBridgeNativeEndCardView.this.P.isRecycled() || MBridgeNativeEndCardView.this.f39365p == null) {
                return;
            }
            MBridgeNativeEndCardView.this.f39365p.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeNativeEndCardView.this.F) {
                MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
                MBridgeNativeEndCardView.this.c(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeNativeEndCardView.this.f39286h) {
                try {
                    com.mbridge.msdk.video.dynview.moffer.a.a().b();
                } catch (Exception e11) {
                    o0.b(MBridgeBaseView.TAG, e11.getMessage());
                }
                try {
                    CampaignEx campaignEx = MBridgeNativeEndCardView.this.f39280b;
                    if (campaignEx != null) {
                        String a11 = z0.a(campaignEx.getendcard_url(), "ecid");
                        String a12 = z0.a(MBridgeNativeEndCardView.this.f39280b.getendcard_url(), "mof");
                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                        eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "choseFromTwoClose");
                        eVar.a("endcard_id", a11);
                        eVar.a("mof", a12);
                        com.mbridge.msdk.video.module.report.a.a("2000103", MBridgeNativeEndCardView.this.f39280b, eVar);
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        e12.printStackTrace();
                    }
                }
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar2 = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar2.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", MBridgeNativeEndCardView.this.f39280b);
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
            MBridgeNativeEndCardView.this.notifyListener.a(104, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class p extends com.mbridge.msdk.widget.a {
        p() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(1);
            MBridgeNativeEndCardView.this.c(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class q extends com.mbridge.msdk.widget.a {
        q() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            if (MBridgeNativeEndCardView.this.ctaView != null) {
                if (!com.mbridge.msdk.util.b.a()) {
                    MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
                    MBridgeNativeEndCardView.this.c(0);
                } else if (MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                    MBridgeNativeEndCardView.this.f39280b.setTriggerClickSource(2);
                    MBridgeNativeEndCardView.this.c(0);
                }
            }
        }
    }

    public MBridgeNativeEndCardView(Context context) {
        super(context);
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.f39359a0 = false;
        this.f39360b0 = 1;
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.f39359a0 = false;
        this.f39360b0 = 1;
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z10, int i11, boolean z11, int i12, int i13) {
        super(context, attributeSet, z10, i11, z11, i12, i13);
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.f39359a0 = false;
        this.f39360b0 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(View view) {
        try {
            this.f39364o = (RelativeLayout) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_native_ec_layout"));
            this.f39366q = (ImageView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_adbanner"));
            this.f39367r = (ImageView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_icon"));
            this.f39368s = (ImageView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_flag"));
            this.f39369t = (TextView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_tv_flag"));
            this.f39370u = (ImageView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_logo"));
            this.f39371v = (ImageView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_link"));
            this.f39372w = (TextView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_tv_apptitle"));
            this.f39375z = (LinearLayout) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_sv_starlevel"));
            this.A = (LinearLayout) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_sv_heat_count_level"));
            this.Q = view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_close"));
            this.ctaView = (TextView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_tv_cta"));
            this.R = (FeedBackButton) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_native_endcard_feed_btn"));
            this.D = (RelativeLayout) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_native_ec_controller"));
            this.f39365p = (ImageView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_iv_adbanner_bg"));
            this.W = (MBridgeBaitClickView) findViewById(filterFindViewId(this.f39359a0, "mbridge_animation_click_view"));
            this.f39373x = (TextView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_tv_appdesc"));
            if (!this.f39286h) {
                TextView textView = (TextView) view.findViewById(filterFindViewId(this.f39359a0, "mbridge_tv_number"));
                this.f39374y = textView;
                return isNotNULL(this.f39366q, this.f39367r, this.f39372w, this.f39373x, textView, this.f39375z, this.Q, this.ctaView);
            }
            ImageView imageView = this.f39366q;
            if (imageView != null && (imageView instanceof RoundImageView)) {
                ((RoundImageView) imageView).setBorderRadius(10);
            }
            ImageView imageView2 = this.f39367r;
            if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                ((RoundImageView) imageView2).setBorderRadius(10);
            }
            return isNotNULL(this.f39366q, this.f39367r, this.f39372w, this.f39375z, this.Q, this.ctaView);
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    private void b(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.E);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            a(view);
            d();
        }
        o();
    }

    private boolean b(int i11) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f39281c.inflate(i11, (ViewGroup) null);
            this.f39363n = viewGroup;
            addView(viewGroup);
            return a(this.f39363n);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f39281c.inflate(i11, (ViewGroup) null);
        this.f39362m = viewGroup2;
        addView(viewGroup2);
        return a(this.f39362m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i11) {
        JSONObject jSONObject;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = this.f39280b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                com.mbridge.msdk.foundation.same.report.j.a(com.mbridge.msdk.foundation.controller.c.m().d(), "end_card_click", this.f39280b.getCampaignUnitId(), this.f39280b.isBidCampaign(), this.f39280b.getRequestId(), this.f39280b.getRequestIdNotice(), this.f39280b.getId(), str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, a(i11));
                if (this.f39280b.getDynamicTempCode() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e12) {
                e = e12;
                e.printStackTrace();
                this.f39280b.setClickTempSource(2);
                this.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e13) {
            e = e13;
            jSONObject = null;
        }
        this.f39280b.setClickTempSource(2);
        this.notifyListener.a(105, jSONObject);
    }

    private void e() {
        int i11;
        MBridgeBaitClickView mBridgeBaitClickView;
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || !campaignEx.isDynamicView()) {
                return;
            }
            String str = this.f39280b.getendcard_url();
            if (TextUtils.isEmpty(str)) {
                str = this.f39280b.getEndScreenUrl();
            }
            String a11 = z0.a(str, "bait_click");
            try {
                i11 = Integer.parseInt(a11);
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage());
                i11 = 1;
            }
            if (TextUtils.isEmpty(a11) || i11 == 0 || (mBridgeBaitClickView = this.W) == null) {
                return;
            }
            mBridgeBaitClickView.setVisibility(0);
            this.W.init(1342177280, i11);
            if (this.f39280b.getEcTemplateId() == 1302) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(1342177280);
                gradientDrawable.setStroke(0, FlowLayout.SPACING_AUTO);
                gradientDrawable.setCornerRadius(25.0f);
                this.W.setBackground(gradientDrawable);
            }
            this.W.startAnimation();
            this.W.setOnClickListener(new f());
        } catch (Throwable th3) {
            o0.b(MBridgeBaseView.TAG, th3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.S);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.S + "_2", this.f39280b);
        }
        if (!com.mbridge.msdk.foundation.feedback.b.b().a()) {
            FeedBackButton feedBackButton = this.R;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.feedback.b.b().a(this.S + "_2", new c());
        com.mbridge.msdk.foundation.feedback.b.b().d(this.S + "_1");
        if (this.R != null) {
            com.mbridge.msdk.foundation.feedback.b.b().a(this.S + "_2", this.R);
        }
    }

    private void g() {
        int parseInt;
        int parseInt2;
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || !campaignEx.isDynamicView()) {
                return;
            }
            String str = this.f39280b.getendcard_url();
            if (TextUtils.isEmpty(str)) {
                str = this.f39280b.getEndScreenUrl();
            }
            String a11 = z0.a(str, "shake_show");
            String a12 = z0.a(str, "shake_strength");
            String a13 = z0.a(str, "shake_time");
            if (!TextUtils.isEmpty(a11) && a11.equals("1") && this.U == null) {
                MBridgeBaitClickView mBridgeBaitClickView = this.W;
                if (mBridgeBaitClickView != null) {
                    mBridgeBaitClickView.setVisibility(8);
                }
                MBShakeView mBShakeView = new MBShakeView(getContext());
                this.U = mBShakeView;
                mBShakeView.initView(this.f39280b.getAdCall(), true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (isLandscape()) {
                    layoutParams.addRule(13);
                } else {
                    layoutParams.addRule(2, filterFindViewId(this.f39359a0, "mbridge_iv_logo"));
                    layoutParams.addRule(14);
                    this.U.setPadding(0, 0, 0, t0.a(getContext(), 20.0f));
                }
                this.U.setLayoutParams(layoutParams);
                RelativeLayout relativeLayout = this.f39364o;
                if (relativeLayout != null && relativeLayout.isShown()) {
                    this.f39364o.addView(this.U);
                    TextView textView = this.ctaView;
                    if (textView != null) {
                        textView.setVisibility(4);
                    }
                    this.U.setOnClickListener(new d());
                    int i11 = 10;
                    if (!TextUtils.isEmpty(a12) && (parseInt2 = Integer.parseInt(a12)) > 0) {
                        i11 = parseInt2;
                    }
                    int i12 = 5000;
                    if (!TextUtils.isEmpty(a13) && (parseInt = Integer.parseInt(a13)) > 0) {
                        i12 = parseInt * 1000;
                    }
                    this.V = new e(i11, i12);
                    com.mbridge.msdk.shake.a.a().a(this.V);
                }
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    private void h() {
        com.mbridge.msdk.foundation.same.image.b.a(this.f39279a.getApplicationContext()).a(this.f39280b.getImageUrl(), new k());
        com.mbridge.msdk.foundation.same.image.b.a(this.f39279a.getApplicationContext()).a(this.f39280b.getIconUrl(), new com.mbridge.msdk.video.module.listener.impl.j(this.f39367r, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 8.0f)));
        this.f39372w.setText(this.f39280b.getAppName());
        TextView textView = this.ctaView;
        if (textView != null) {
            textView.setText(this.f39280b.getAdCall());
        }
        TextView textView2 = this.f39373x;
        if (textView2 != null) {
            textView2.setText(this.f39280b.getAppDesc());
        }
        TextView textView3 = this.f39374y;
        if (textView3 != null) {
            textView3.setText(this.f39280b.getNumberRating() + ")");
        }
        this.f39375z.removeAllViews();
        double rating = this.f39280b.getRating();
        if (rating <= 0.0d) {
            rating = 5.0d;
        }
        LinearLayout linearLayout = this.f39375z;
        if (linearLayout instanceof StarLevelView) {
            ((StarLevelView) linearLayout).initScore(rating);
        }
        LinearLayout linearLayout2 = this.f39375z;
        if (linearLayout2 instanceof MBridgeLevelLayoutView) {
            ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, this.f39280b.getNumberRating());
        }
        LinearLayout linearLayout3 = this.f39375z;
        if (linearLayout3 instanceof MBStarLevelLayoutView) {
            ((MBStarLevelLayoutView) linearLayout3).setRating((int) rating);
        }
        LinearLayout linearLayout4 = this.A;
        if (linearLayout4 != null && (linearLayout4 instanceof MBHeatLevelLayoutView)) {
            ((MBHeatLevelLayoutView) linearLayout4).setHeatCount(this.f39280b.getNumberRating());
        }
        if (!TextUtils.isEmpty(this.f39280b.getendcard_url()) && this.f39280b.getendcard_url().contains("alecfc=1")) {
            this.F = true;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.f39368s.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
            this.f39361c0 = "AD";
        } else {
            this.f39368s.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().h())));
            this.f39361c0 = "广告";
        }
        if (this.f39360b0 == 0) {
            ImageView imageView = this.f39368s;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            ImageView imageView2 = this.f39370u;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            TextView textView4 = this.f39369t;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.f39369t.setText(this.f39361c0);
            }
        }
        t0.a(2, this.f39371v, this.f39280b, this.f39279a, true, new l());
        if (this.G) {
            return;
        }
        this.Q.setVisibility(8);
    }

    private void i() {
        com.mbridge.msdk.video.dynview.c a11 = new com.mbridge.msdk.video.dynview.wrapper.c().a(getContext(), this.f39280b, this.f39287i, com.mbridge.msdk.util.b.a() ? "cn_" : "en_");
        this.f39360b0 = a11.o();
        com.mbridge.msdk.video.dynview.b.a().a(a11, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int k11 = k();
        if (g0.a(k11)) {
            this.f39283e = b(k11);
            l();
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null) {
                campaignEx.setECTemplateRenderSucc(false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        r1 = "mbridge_reward_endcard_native_half_landscape";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r6.f39288j != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r6.f39288j != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int k() {
        /*
            r6 = this;
            int r0 = r6.f39289k
            java.lang.String r1 = "mbridge_reward_endcard_native_land"
            java.lang.String r2 = "mbridge_reward_endcard_native_half_landscape"
            java.lang.String r3 = "mbridge_reward_endcard_native_hor"
            java.lang.String r4 = "mbridge_reward_endcard_native_half_portrait"
            if (r0 != 0) goto L1f
            boolean r0 = r6.f39288j
            if (r0 == 0) goto L11
            r3 = r4
        L11:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L1d
            boolean r0 = r6.f39288j
            if (r0 == 0) goto L32
        L1b:
            r1 = r2
            goto L32
        L1d:
            r1 = r3
            goto L32
        L1f:
            r5 = 1
            if (r0 != r5) goto L28
            boolean r5 = r6.f39288j
            if (r5 == 0) goto L2a
            r3 = r4
            goto L2a
        L28:
            java.lang.String r3 = ""
        L2a:
            r4 = 2
            if (r0 != r4) goto L1d
            boolean r0 = r6.f39288j
            if (r0 == 0) goto L32
            goto L1b
        L32:
            int r0 = r6.findLayout(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.k():int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        d();
        if (!this.f39283e) {
            this.notifyListener.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.K = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private void m() {
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || !campaignEx.isDynamicView()) {
                return;
            }
            String str = this.f39280b.getendcard_url();
            if (TextUtils.isEmpty(str)) {
                str = this.f39280b.getEndScreenUrl();
            }
            String a11 = z0.a(str, "alac");
            if (TextUtils.isEmpty(a11) || !a11.equals("1") || this.f39280b.getAutoShowStoreMiniCard() == 1) {
                return;
            }
            postDelayed(new g(), 1000L);
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    private void n() {
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx == null || campaignEx.getAutoShowStoreMiniCard() == 0 || TextUtils.isEmpty(this.f39280b.getDeepLinkURL())) {
                return;
            }
            long showStoreMiniCardDelayTime = this.f39280b.getShowStoreMiniCardDelayTime();
            if (showStoreMiniCardDelayTime == 0) {
                showStoreMiniCardDelayTime = 1;
            }
            if (this.C == null) {
                this.C = new h();
            }
            postDelayed(this.C, showStoreMiniCardDelayTime * 1000);
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    private void o() {
        RelativeLayout relativeLayout;
        if (!this.f39283e || (relativeLayout = this.D) == null) {
            return;
        }
        relativeLayout.postDelayed(new b(), 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBannerBackGroundBlurBimap(Bitmap bitmap) {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.a().execute(new m(bitmap));
        } catch (Exception e11) {
            o0.a(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(this.f39279a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean canBackPress() {
        View view = this.Q;
        return view != null && view.getVisibility() == 0;
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView() || (campaignUnit = this.T) == null || campaignUnit.getAds() == null || this.T.getAds().size() <= 0) {
            return;
        }
        Iterator<CampaignEx> it = this.T.getAds().iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (!TextUtils.isEmpty(next.getIconUrl())) {
                com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(next.getIconUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void d() {
        if (this.f39283e) {
            this.f39364o.setOnClickListener(new n());
            this.Q.setOnClickListener(new o());
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setOnClickListener(new p());
            }
            this.f39367r.setOnClickListener(new q());
            this.f39366q.setOnClickListener(new a());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.f39359a0;
    }

    public void notifyShowListener() {
        this.notifyListener.a(110, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.B == null) {
            this.B = new i();
        }
        Runnable runnable = this.B;
        if (runnable != null) {
            postDelayed(runnable, this.J * 1000);
            if (!this.H) {
                this.H = true;
            }
            m();
        }
        e();
        g();
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.B;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.C;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        if (this.V != null) {
            com.mbridge.msdk.shake.a.a().b(this.V);
            this.V = null;
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            RelativeLayout relativeLayout = this.D;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            int i11 = configuration.orientation;
            this.f39282d = i11;
            if (i11 == 2) {
                removeView(this.f39362m);
                b(this.f39363n);
            } else {
                removeView(this.f39363n);
                b(this.f39362m);
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeNativeEndCardViewDiff
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.E = bVar;
        try {
            if (this.f39280b == null || !this.f39283e) {
                return;
            }
            h();
        } catch (Throwable th2) {
            o0.a(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    public void release() {
        try {
            removeAllViews();
            AlphaAnimation alphaAnimation = this.K;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.B = null;
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void setCloseBtnDelay(int i11) {
        this.J = i11;
    }

    public void setLayout() {
        if (this.f39286h) {
            i();
        } else {
            j();
        }
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        MBShakeView mBShakeView;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            return;
        }
        this.T = campaignUnit;
        if (campaignUnit == null || campaignUnit.getAds() == null || this.T.getAds().size() <= 5 || (mBShakeView = this.U) == null) {
            return;
        }
        mBShakeView.setPadding(0, 0, 0, t0.a(getContext(), 5.0f));
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        o0.b(MBridgeBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
        this.L = i11;
        this.M = i12;
        this.N = i13;
        this.O = i14;
        o();
    }

    public void setOnPause() {
        this.H = false;
    }

    public void setOnResume() {
        this.H = true;
    }

    public void setUnitId(String str) {
        this.S = str;
    }
}
