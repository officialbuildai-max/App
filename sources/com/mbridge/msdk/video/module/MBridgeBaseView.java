package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.module.listener.a;
import com.mbridge.msdk.video.module.listener.impl.f;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class MBridgeBaseView extends RelativeLayout {
    public static final String TAG = "MBridgeBaseView";

    /* renamed from: a, reason: collision with root package name */
    protected Context f39279a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f39280b;

    /* renamed from: c, reason: collision with root package name */
    protected LayoutInflater f39281c;

    /* renamed from: d, reason: collision with root package name */
    protected int f39282d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f39283e;

    /* renamed from: f, reason: collision with root package name */
    protected float f39284f;

    /* renamed from: g, reason: collision with root package name */
    protected float f39285g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f39286h;

    /* renamed from: i, reason: collision with root package name */
    protected int f39287i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f39288j;

    /* renamed from: k, reason: collision with root package name */
    protected int f39289k;

    /* renamed from: l, reason: collision with root package name */
    protected int f39290l;
    public a notifyListener;

    public MBridgeBaseView(Context context) {
        this(context, null);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39282d = 1;
        this.notifyListener = new f();
        this.f39283e = false;
        this.f39289k = 1;
        this.f39290l = 0;
        this.f39279a = context;
        this.f39281c = LayoutInflater.from(context);
        init(context);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet, boolean z10, int i11, boolean z11, int i12, int i13) {
        super(context, attributeSet);
        this.f39282d = 1;
        this.notifyListener = new f();
        this.f39283e = false;
        this.f39289k = 1;
        this.f39290l = 0;
        this.f39279a = context;
        this.f39281c = LayoutInflater.from(context);
        this.f39286h = z10;
        this.f39287i = i11;
        this.f39288j = z11;
        this.f39289k = i12;
        this.f39290l = i13;
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject a(int i11) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e11) {
            e = e11;
        }
        try {
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f35390h, t0.b(c.m().d(), this.f39284f));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f35391i, t0.b(c.m().d(), this.f39285g));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f35395m, i11);
            try {
                this.f39282d = getContext().getResources().getConfiguration().orientation;
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f35393k, this.f39282d);
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f35394l, t0.d(getContext()));
            return jSONObject;
        } catch (JSONException e13) {
            e = e13;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return a(0).toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    public void defaultShow() {
        o0.a(TAG, "defaultShow");
    }

    public int filterFindViewId(boolean z10, String str) {
        return z10 ? findDyID(str) : findID(str);
    }

    public int findColor(String str) {
        return g0.a(this.f39279a.getApplicationContext(), str, TtmlNode.ATTR_TTS_COLOR);
    }

    public int findDrawable(String str) {
        return g0.a(this.f39279a.getApplicationContext(), str, "drawable");
    }

    public int findDyID(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public int findID(String str) {
        return g0.a(this.f39279a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return g0.a(this.f39279a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f39280b;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.f39279a.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i11 = 0;
        boolean z10 = false;
        while (i11 < length) {
            if (viewArr[i11] == null) {
                return false;
            }
            i11++;
            z10 = true;
        }
        return z10;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.f39282d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onConfigurationChanged:");
        sb2.append(configuration.orientation);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f39284f = motionEvent.getRawX();
        this.f39285g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f39282d = configuration.orientation;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onSelfConfigurationChanged:");
        sb2.append(configuration.orientation);
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f39280b = campaignEx;
    }

    public void setLayoutCenter(int i11, int i12) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i11 != -999) {
                parentRelativeLayoutParams.width = i11;
            }
            if (i12 != -999) {
                parentRelativeLayoutParams.height = i12;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i11 != -999) {
                parentLinearLayoutParams.width = i11;
            }
            if (i12 != -999) {
                parentLinearLayoutParams.height = i12;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setLayoutParam(int i11, int i12, int i13, int i14) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i12;
            parentRelativeLayoutParams.leftMargin = i11;
            if (i13 != -999) {
                parentRelativeLayoutParams.width = i13;
            }
            if (i14 != -999) {
                parentRelativeLayoutParams.height = i14;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i12;
            parentLinearLayoutParams.leftMargin = i11;
            if (i13 != -999) {
                parentLinearLayoutParams.width = i13;
            }
            if (i14 != -999) {
                parentLinearLayoutParams.height = i14;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setNotifyListener(a aVar) {
        this.notifyListener = aVar;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
    }
}
