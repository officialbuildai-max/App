package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.bt.component.d;
import com.mbridge.msdk.videocommon.setting.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";

    /* renamed from: n, reason: collision with root package name */
    protected static int f38863n = 0;

    /* renamed from: o, reason: collision with root package name */
    protected static int f38864o = 1;

    /* renamed from: a, reason: collision with root package name */
    protected Context f38865a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f38866b;

    /* renamed from: c, reason: collision with root package name */
    protected String f38867c;

    /* renamed from: d, reason: collision with root package name */
    protected String f38868d;

    /* renamed from: e, reason: collision with root package name */
    protected c f38869e;

    /* renamed from: f, reason: collision with root package name */
    protected LayoutInflater f38870f;

    /* renamed from: g, reason: collision with root package name */
    protected int f38871g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f38872h;

    /* renamed from: i, reason: collision with root package name */
    protected float f38873i;

    /* renamed from: j, reason: collision with root package name */
    protected float f38874j;

    /* renamed from: k, reason: collision with root package name */
    protected Rect f38875k;

    /* renamed from: l, reason: collision with root package name */
    protected int f38876l;

    /* renamed from: m, reason: collision with root package name */
    protected int f38877m;

    public BTBaseView(Context context) {
        this(context, null);
    }

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38868d = "";
        this.f38871g = 1;
        this.f38872h = false;
        this.f38865a = context;
        this.f38870f = LayoutInflater.from(context);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f38863n);
            jSONObject.put("id", str2);
            jSONObject.put("data", new JSONObject());
            f.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            d.c().a(webView, e11.getMessage());
            o0.a(TAG, e11.getMessage());
        }
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
            jSONObject.put(a.f35390h, t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f38873i));
            jSONObject.put(a.f35391i, t0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f38874j));
            jSONObject.put(a.f35395m, i11);
            try {
                this.f38871g = getContext().getResources().getConfiguration().orientation;
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            jSONObject.put(a.f35393k, this.f38871g);
            jSONObject.put(a.f35394l, t0.d(getContext()));
            return jSONObject;
        } catch (JSONException e13) {
            e = e13;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    public void defaultShow() {
        o0.a(TAG, "defaultShow");
    }

    public int findColor(String str) {
        return g0.a(this.f38865a.getApplicationContext(), str, TtmlNode.ATTR_TTS_COLOR);
    }

    public int findDrawable(String str) {
        return g0.a(this.f38865a.getApplicationContext(), str, "drawable");
    }

    public int findID(String str) {
        return g0.a(this.f38865a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return g0.a(this.f38865a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f38866b;
    }

    public String getInstanceId() {
        return this.f38868d;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
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

    public Rect getRect() {
        return this.f38875k;
    }

    public String getUnitId() {
        return this.f38867c;
    }

    public int getViewHeight() {
        return this.f38877m;
    }

    public int getViewWidth() {
        return this.f38876l;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.f38865a.getResources().getConfiguration().orientation == 2;
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
        this.f38871g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f38873i = motionEvent.getRawX();
        this.f38874j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f38871g = configuration.orientation;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f38866b = campaignEx;
    }

    public void setInstanceId(String str) {
        this.f38868d = str;
    }

    public void setLayout(int i11, int i12) {
        this.f38876l = i11;
        this.f38877m = i12;
    }

    public void setLayoutCenter(int i11, int i12) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
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
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i11 != -999) {
                parentFrameLayoutParams.width = i11;
            }
            if (i12 != -999) {
                parentFrameLayoutParams.height = i12;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i11, int i12, int i13, int i14) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
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
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i12;
            parentFrameLayoutParams.leftMargin = i11;
            if (i13 != -999) {
                parentFrameLayoutParams.width = i13;
            }
            if (i14 != -999) {
                parentFrameLayoutParams.height = i14;
            }
            setLayoutParams(parentFrameLayoutParams);
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

    public void setRect(Rect rect) {
        this.f38875k = rect;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f38869e = cVar;
    }

    public void setUnitId(String str) {
        this.f38867c = str;
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
