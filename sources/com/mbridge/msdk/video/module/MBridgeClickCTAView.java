package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.video.dynview.listener.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeClickCTAView extends MBridgeClickCTAViewDiff {
    public f ctaClickCallBack;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f39291m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f39292n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f39293o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f39294p;

    /* renamed from: q, reason: collision with root package name */
    private String f39295q;

    /* renamed from: r, reason: collision with root package name */
    private float f39296r;

    /* renamed from: s, reason: collision with root package name */
    private float f39297s;

    /* renamed from: t, reason: collision with root package name */
    private int f39298t;

    /* renamed from: u, reason: collision with root package name */
    private ObjectAnimator f39299u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f39300a;

        a(ViewGroup viewGroup) {
            this.f39300a = viewGroup;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.a aVar) {
            if (aVar != null) {
                this.f39300a.addView(aVar.b());
                MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                mBridgeClickCTAView.f39283e = mBridgeClickCTAView.h();
                MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                mBridgeClickCTAView2.f39294p = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                MBridgeClickCTAView.this.d();
            }
        }

        @Override // com.mbridge.msdk.video.dynview.listener.h
        public void a(com.mbridge.msdk.video.dynview.error.a aVar) {
            o0.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends com.mbridge.msdk.widget.a {
        b() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeClickCTAView.this.getClass();
            MBridgeClickCTAView.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends com.mbridge.msdk.widget.a {
        c() {
        }

        @Override // com.mbridge.msdk.widget.a
        protected void a(View view) {
            MBridgeClickCTAView.this.getClass();
            MBridgeClickCTAView.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends com.mbridge.msdk.video.module.listener.impl.e {
        e(ImageView imageView, CampaignEx campaignEx, String str) {
            super(imageView, campaignEx, str);
        }

        @Override // com.mbridge.msdk.video.module.listener.impl.e, com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            super.onFailedLoad(str, str2);
            MBridgeClickCTAView.this.g();
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(ViewGroup viewGroup, CampaignEx campaignEx) {
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.wrapper.c().a(viewGroup, campaignEx), new a(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        JSONException e11;
        JSONObject jSONObject;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = this.f39280b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                j.a(com.mbridge.msdk.foundation.controller.c.m().d(), "cta_click", this.f39280b.getCampaignUnitId(), this.f39280b.isBidCampaign(), this.f39280b.getRequestId(), this.f39280b.getRequestIdNotice(), this.f39280b.getId(), str);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, a(0));
            } catch (JSONException e13) {
                e11 = e13;
                e11.printStackTrace();
                this.f39280b.setTriggerClickSource(1);
                this.f39280b.setClickTempSource(1);
                this.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e14) {
            e11 = e14;
            jSONObject = null;
        }
        this.f39280b.setTriggerClickSource(1);
        this.f39280b.setClickTempSource(1);
        this.notifyListener.a(105, jSONObject);
    }

    private void f() {
        int findLayout = findLayout("mbridge_reward_clickable_cta");
        if (g0.a(findLayout)) {
            this.f39281c.inflate(findLayout, this);
            this.f39283e = h();
            d();
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ImageView imageView = this.f39292n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        this.f39291m = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.f39292n = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.f39293o = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.ctaTv = textView;
        return isNotNULL(this.f39291m, this.f39292n, this.f39293o, textView);
    }

    private void i() {
        setWrapContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void d() {
        super.d();
        if (this.f39283e) {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                setOnClickListener(new b());
            }
            this.ctaTv.setOnClickListener(new c());
            ImageView imageView = this.f39292n;
            if (imageView != null) {
                imageView.setOnClickListener(new d());
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff, com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f39299u;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f39299u;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f39296r = motionEvent.getRawX();
        this.f39297s = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f39298t = configuration.orientation;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            if (campaignEx.isDynamicView()) {
                a(this, this.f39280b);
            } else {
                f();
            }
            if (this.f39283e) {
                if (com.mbridge.msdk.util.b.a()) {
                    setChinaCTAData();
                }
                this.ctaTv.setText(this.f39280b.getAdCall());
                if (TextUtils.isEmpty(this.f39280b.getIconUrl())) {
                    g();
                } else {
                    com.mbridge.msdk.foundation.same.image.b.a(this.f39279a.getApplicationContext()).a(this.f39280b.getIconUrl(), new e(this.f39292n, this.f39280b, this.f39295q));
                }
                if (this.f39293o != null && !TextUtils.isEmpty(this.f39280b.getAppName())) {
                    this.f39293o.setText(this.f39280b.getAppName());
                }
                if (this.f39294p == null || TextUtils.isEmpty(this.f39280b.getAppDesc())) {
                    return;
                }
                this.f39294p.setText(this.f39280b.getAppDesc());
            }
        }
    }

    public void setCtaClickCallBack(f fVar) {
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f39299u = objectAnimator;
    }

    public void setUnitId(String str) {
        this.f39295q = str;
    }
}
