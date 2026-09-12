package com.mbridge.msdk.video.module;

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
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.video.module.listener.impl.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeVideoEndCoverView extends MBridgeBaseView {

    /* renamed from: m, reason: collision with root package name */
    private final String f39400m;

    /* renamed from: n, reason: collision with root package name */
    private View f39401n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f39402o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f39403p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f39404q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f39405r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f39406s;

    /* renamed from: t, reason: collision with root package name */
    private com.mbridge.msdk.video.signal.factory.b f39407t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.notifyListener.a(104, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeVideoEndCoverView.this.g();
        }
    }

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
        this.f39400m = "MBridgeVideoEndCoverView";
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39400m = "MBridgeVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.f39402o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.f39403p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.f39404q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.f39405r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.f39406s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th2) {
            o0.b("MBridgeVideoEndCoverView", th2.getMessage());
            return false;
        }
    }

    private void e() {
        ImageView imageView;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.f39402o) != null) {
                com.mbridge.msdk.foundation.same.image.b.a(this.f39279a.getApplicationContext()).a(this.f39280b.getIconUrl(), new j(imageView, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 8.0f)));
            }
            TextView textView = this.f39404q;
            if (textView != null) {
                textView.setText(this.f39280b.getAppName());
            }
            TextView textView2 = this.f39406s;
            if (textView2 != null) {
                textView2.setText(this.f39280b.getAdCall());
            }
            TextView textView3 = this.f39405r;
            if (textView3 != null) {
                textView3.setText(this.f39280b.getAppDesc());
            }
        }
    }

    private void f() {
        View view = this.f39401n;
        if (view == null) {
            init(this.f39279a);
            preLoadData(this.f39407t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f39401n.getParent()).removeView(this.f39401n);
        }
        addView(this.f39401n);
        a(this.f39401n);
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void d() {
        super.d();
        this.f39403p.setOnClickListener(new a());
        this.f39402o.setOnClickListener(new b());
        this.f39406s.setOnClickListener(new c());
    }

    protected void g() {
        JSONException e11;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONException e12;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35390h, t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39284f));
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35391i, t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39285g));
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35395m, 0);
                    try {
                        this.f39282d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e13) {
                        e13.printStackTrace();
                    }
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35393k, this.f39282d);
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35394l, t0.d(getContext()));
                } catch (JSONException e14) {
                    e12 = e14;
                    o0.b("MBridgeVideoEndCoverView", e12.getMessage());
                    jSONObject = new JSONObject();
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, jSONObject2);
                    this.notifyListener.a(105, jSONObject);
                }
            } catch (JSONException e15) {
                jSONObject2 = jSONObject3;
                e12 = e15;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, jSONObject2);
            } catch (JSONException e16) {
                e11 = e16;
                e11.printStackTrace();
                this.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e17) {
            e11 = e17;
            jSONObject = null;
        }
        this.notifyListener.a(105, jSONObject);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoend_cover");
        if (g0.a(findLayout)) {
            View inflate = this.f39281c.inflate(findLayout, (ViewGroup) null);
            this.f39401n = inflate;
            if (inflate != null) {
                this.f39283e = a(inflate);
                addView(this.f39401n, -1, -1);
                d();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f39284f = motionEvent.getRawX();
        this.f39285g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f39282d = configuration.orientation;
        removeView(this.f39401n);
        f();
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f39407t = bVar;
        try {
            if (this.f39280b == null || !this.f39283e) {
                return;
            }
            e();
        } catch (Throwable th2) {
            o0.a("MBridgeVideoEndCoverView", th2.getMessage());
        }
    }
}
