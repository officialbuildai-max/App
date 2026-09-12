package com.mbridge.msdk.video.bt.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.b0;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.bt.module.BTBaseView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import com.mbridge.msdk.video.bt.module.MBridgeBTWebView;
import com.mbridge.msdk.video.signal.impl.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f38824a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static LinkedHashMap<String, String> f38825b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static LinkedHashMap<String, CampaignEx> f38826c = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static LinkedHashMap<String, com.mbridge.msdk.videocommon.setting.c> f38827d = new LinkedHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static LinkedHashMap<String, String> f38828e = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static LinkedHashMap<String, Integer> f38829f = new LinkedHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private static LinkedHashMap<String, Activity> f38830g = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f38831h = 10000;

    /* renamed from: i, reason: collision with root package name */
    private static int f38832i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static int f38833j = 1;

    /* renamed from: k, reason: collision with root package name */
    private static String f38834k = "";

    /* renamed from: l, reason: collision with root package name */
    private static int f38835l;

    /* renamed from: m, reason: collision with root package name */
    private static int f38836m;

    /* renamed from: n, reason: collision with root package name */
    private static int f38837n;

    /* renamed from: o, reason: collision with root package name */
    private static int f38838o;

    /* renamed from: p, reason: collision with root package name */
    private static int f38839p;

    /* renamed from: com.mbridge.msdk.video.bt.component.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0556a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f38840a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38841b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f38842c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f38843d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f38844e;

        RunnableC0556a(Object obj, String str, Rect rect, int i11, int i12) {
            this.f38840a = obj;
            this.f38841b = str;
            this.f38842c = rect;
            this.f38843d = i11;
            this.f38844e = i12;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) this.f38840a).f36595b;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            } else {
                str = "";
                windVaneWebView = null;
            }
            LinkedHashMap<String, View> b11 = a.this.b(this.f38841b, str);
            String b12 = a.this.b();
            a.f38825b.put(b12, str);
            MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().d());
            b11.put(b12, mBridgeBTLayout);
            mBridgeBTLayout.setInstanceId(b12);
            mBridgeBTLayout.setUnitId(this.f38841b);
            mBridgeBTLayout.setWebView(windVaneWebView);
            mBridgeBTLayout.setRect(this.f38842c);
            int i11 = this.f38843d;
            if (i11 > 0 || this.f38844e > 0) {
                mBridgeBTLayout.setLayout(i11, this.f38844e);
            }
            a.this.b(this.f38840a, b12);
            o0.a("OperateViews", "create view instanceId = " + b12);
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f38846a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38847b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f38848c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f38849d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38850e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Rect f38851f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f38852g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38853h;

        b(Object obj, String str, String str2, String str3, String str4, Rect rect, int i11, int i12) {
            this.f38846a = obj;
            this.f38847b = str;
            this.f38848c = str2;
            this.f38849d = str3;
            this.f38850e = str4;
            this.f38851f = rect;
            this.f38852g = i11;
            this.f38853h = i12;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) this.f38846a).f36595b;
            if (windVaneWebView != null) {
                str = windVaneWebView.getRid();
            } else {
                str = "";
                windVaneWebView = null;
            }
            LinkedHashMap<String, View> b11 = a.this.b(this.f38847b, str);
            String b12 = a.this.b();
            a.f38825b.put(b12, str);
            MBridgeBTWebView mBridgeBTWebView = new MBridgeBTWebView(com.mbridge.msdk.foundation.controller.c.m().d());
            b11.put(b12, mBridgeBTWebView);
            mBridgeBTWebView.setInstanceId(b12);
            mBridgeBTWebView.setUnitId(this.f38847b);
            mBridgeBTWebView.setFileURL(this.f38848c);
            mBridgeBTWebView.setFilePath(this.f38849d);
            mBridgeBTWebView.setHtml(this.f38850e);
            mBridgeBTWebView.setRect(this.f38851f);
            mBridgeBTWebView.setWebViewRid(str);
            mBridgeBTWebView.setCreateWebView(windVaneWebView);
            int i11 = this.f38852g;
            if (i11 > 0 || this.f38853h > 0) {
                mBridgeBTWebView.setLayout(i11, this.f38853h);
            }
            mBridgeBTWebView.preload();
            a.this.b(this.f38846a, b12);
            o0.a("OperateViews", "createWebview instanceId = " + b12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f38855a;

        c(CampaignEx campaignEx) {
            this.f38855a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a11 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                if (a11 != null) {
                    if (a11.a(this.f38855a.getId())) {
                        a11.b(this.f38855a.getId());
                    } else {
                        com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                        gVar.a(this.f38855a.getId());
                        gVar.b(this.f38855a.getFca());
                        gVar.c(this.f38855a.getFcb());
                        gVar.a(0);
                        gVar.d(1);
                        gVar.a(System.currentTimeMillis());
                        a11.b(gVar);
                    }
                }
                a.this.a(this.f38855a.getCampaignUnitId(), this.f38855a);
            } catch (Throwable th2) {
                o0.b("OperateViews", th2.getMessage(), th2);
            }
        }
    }

    private MBridgeBTContainer a(String str, String str2) {
        LinkedHashMap<String, View> b11 = b(str, str2);
        if (b11.size() > 0) {
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTContainer) {
                    return (MBridgeBTContainer) view;
                }
            }
        }
        return null;
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new c(campaignEx)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.buffer.b.f35424k == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.buffer.b.a(str, campaignEx, "reward");
    }

    public void A(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                o0.a("OperateViews", "playerUnmute failed: instanceId not exit");
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerUnmute failed: instanceId is not player");
            } else if (!((MBridgeBTVideoView) view).playUnMute()) {
                b(obj, "set unmute failed");
                o0.a("OperateViews", "playerUnmute failed: set unmute failed");
            } else {
                b(obj, optString2);
                a(obj, "onUnmute", optString2);
                o0.a("OperateViews", "playerUnmute successed");
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerUnmute failed: " + th2.getMessage());
        }
    }

    public void B(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
        }
    }

    public void C(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBTempContainer)) {
                a(obj, "view not exist");
            } else {
                ((MBTempContainer) view).preload();
                b(obj, optString2);
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "preloadSubPlayTemplateView failed: " + th2.getMessage());
        }
    }

    public void D(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "params not enough");
                o0.a("OperateViews", "removeFromSuperView failed: params not enough instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view == null || view.getParent() == null) {
                a(obj, "view is null");
                o0.a("OperateViews", "removeFromSuperView failed: view is null instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                a(obj, "parent is null");
                o0.a("OperateViews", "removeFromSuperView failed: parent is null instanceId = " + optString2);
                return;
            }
            viewGroup.removeView(view);
            b(obj, optString2);
            a(obj, "onRemoveFromView", optString2);
            o0.a("OperateViews", "removeFromSuperView instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "removeFromSuperView failed: " + th2.getMessage());
        }
    }

    public void E(Object obj, JSONObject jSONObject) {
        com.mbridge.msdk.videocommon.entity.c cVar;
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
            String str = "";
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString3 = optJSONObject.optString("userId");
            boolean optBoolean = optJSONObject.optBoolean("expired");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
            String optString4 = optJSONObject.optString("extra");
            if (optJSONObject2 != null) {
                com.mbridge.msdk.videocommon.entity.c cVar2 = new com.mbridge.msdk.videocommon.entity.c(optJSONObject2.optString("name"), optJSONObject2.optInt(RewardPlus.AMOUNT));
                str = optJSONObject2.optString("id");
                cVar = cVar2;
            } else {
                cVar = null;
            }
            LinkedHashMap<String, View> b11 = b(optString, rid);
            if (b11.size() <= 0 || !f38828e.containsKey(optString2)) {
                a(obj, "unitId not exist");
                o0.a("OperateViews", "setSubPlayTemplateInfo failed: unitId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBTempContainer)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "setSubPlayTemplateInfo failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            MBTempContainer mBTempContainer = (MBTempContainer) view;
            mBTempContainer.setReward(cVar);
            mBTempContainer.setUserId(optString3);
            mBTempContainer.setRewardId(str);
            mBTempContainer.setCampaignExpired(optBoolean);
            if (!TextUtils.isEmpty(optString4)) {
                mBTempContainer.setDeveloperExtraData(optString4);
            }
            b(obj, optString2);
            o0.a("OperateViews", "setSubPlayTemplateInfo success instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "setSubPlayTemplateInfo failed: " + th2.getMessage());
        }
    }

    public void F(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "setViewAlpha failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "setViewAlpha failed: view not exist instanceId = " + optString2);
                return;
            }
            view.setAlpha((float) optDouble);
            b(obj, optString2);
            a(obj, "onViewAlphaChanged", optString2);
            o0.a("OperateViews", "setViewAlpha instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "setViewAlpha failed: " + th2.getMessage());
        }
    }

    public void G(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString(TtmlNode.ATTR_TTS_COLOR);
            if (TextUtils.isEmpty(optString3)) {
                a(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "setViewBgColor failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "setViewBgColor failed: view not exist instanceId = " + optString2);
                return;
            }
            b(obj, optString2);
            view.setBackgroundColor(Color.parseColor(optString3));
            a(obj, "onViewBgColorChanged", optString2);
            o0.a("OperateViews", "setViewBgColor instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "setViewBgColor failed: " + th2.getMessage());
        }
    }

    public void H(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            if (optJSONObject2 == null) {
                a(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            Rect rect = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
            int optInt = optJSONObject2.optInt("width");
            int optInt2 = optJSONObject2.optInt("height");
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "setViewRect failed: instanceId not exist");
                return;
            }
            View view = b11.get(optString2);
            if (view == null) {
                a(obj, "view is null");
                o0.a("OperateViews", "setViewRect failed: view is null");
                return;
            }
            if (view.getParent() != null) {
                view.setLayoutParams(a(view.getLayoutParams(), rect, optInt, optInt2));
                view.requestLayout();
            } else {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).setRect(rect);
                    ((MBridgeBTWebView) view).setLayout(optInt, optInt2);
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setRect(rect);
                    ((MBridgeBTVideoView) view).setLayout(optInt, optInt2);
                }
            }
            b(obj, optString2);
            a(obj, "onViewRectChanged", optString2);
            o0.a("OperateViews", "setViewRect instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "setViewRect failed: " + th2.getMessage());
        }
    }

    public void I(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("vertical", 1.0d);
            double optDouble2 = optJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "setViewScale failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "setViewScale failed: view not exist instanceId = " + optString2);
                return;
            }
            view.setScaleX((float) optDouble2);
            view.setScaleY((float) optDouble);
            b(obj, optString2);
            a(obj, "onViewScaleChanged", optString2);
            o0.a("OperateViews", "setViewScale instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "setViewScale failed: " + th2.getMessage());
        }
    }

    public void J(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "showView failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "showView failed: view not exist instanceId = " + optString2);
                return;
            }
            view.setVisibility(0);
            b(obj, optString2);
            a(obj, "onShowView", optString2);
            o0.a("OperateViews", "showView instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "showView failed: " + th2.getMessage());
        }
    }

    public void K(Object obj, JSONObject jSONObject) {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString3 = optJSONObject.optString(EventConstants.KEY_EVENT_NAME);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(IntegrationConstants.EVENT_DATA);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> b11 = b(optString, rid);
            if (b11.size() <= 0) {
                a(obj, "unitId not exist");
                o0.a("OperateViews", "webviewFireEvent failed: unitId not exist");
                return;
            }
            View view = b11.get(optString2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof WindVaneWebView) {
                        f.a().a((WebView) childAt, optString3, Base64.encodeToString(optJSONObject2.toString().getBytes(), 2));
                        b(obj, optString2);
                        o0.a("OperateViews", "webviewFireEvent instanceId = " + optString2);
                        return;
                    }
                }
            }
            a(obj, "instanceId not exist");
            o0.a("OperateViews", "webviewFireEvent failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "webviewFireEvent failed: " + th2.getMessage());
        }
    }

    public void L(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "webviewGoBack failed instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTWebView)) {
                a(obj, "view not exist");
                o0.a("OperateViews", "webviewGoBack failed view not exist instanceId = " + optString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewGoBack()) {
                b(obj, optString2);
                o0.a("OperateViews", "webviewGoBack instanceId = " + optString2);
                return;
            }
            a(obj, "webviewGoBack failed");
            o0.a("OperateViews", "webviewGoBack failed instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "webviewGoBack failed: " + th2.getMessage());
        }
    }

    public void M(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "webviewGoForward failed instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTWebView)) {
                a(obj, "view not exist");
                o0.a("OperateViews", "webviewGoForward failed view not exist instanceId = " + optString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewGoForward()) {
                b(obj, optString2);
                o0.a("OperateViews", "webviewGoForward instanceId = " + optString2);
                return;
            }
            a(obj, "webviewGoForward failed");
            o0.a("OperateViews", "webviewGoForward failed instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "webviewGoForward failed: " + th2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    public void N(Object obj, JSONObject jSONObject) {
        String str;
        Object obj2;
        String str2;
        int optInt;
        Rect rect;
        Object obj3;
        int i11;
        WindVaneWebView windVaneWebView;
        Object obj4 = obj;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj4).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj4, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("content");
            if (optJSONObject2 == null) {
                a(obj4, "content is empty");
                return;
            }
            String optString3 = optJSONObject2.optString("fileURL");
            String optString4 = optJSONObject2.optString(NativeRequestBridge.KEY_FILE_PATH);
            String optString5 = optJSONObject2.optString("html");
            if (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString4) && TextUtils.isEmpty(optString5)) {
                a(obj4, "url is empty");
                return;
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("campaigns");
            List<CampaignEx> arrayList = new ArrayList<>();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i12 = 0;
                while (i12 < length) {
                    JSONArray jSONArray = optJSONArray;
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONArray.getJSONObject(i12));
                    if (parseCampaignWithBackData != null) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        arrayList.add(parseCampaignWithBackData);
                    }
                    i12++;
                    optJSONArray = jSONArray;
                }
            }
            String optString6 = optJSONObject2.optString("unitId");
            com.mbridge.msdk.videocommon.setting.c a11 = com.mbridge.msdk.videocommon.setting.c.a(optJSONObject2.optJSONObject("unitSetting"));
            if (a11 != null) {
                a11.h(optString6);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (optJSONObject3 != null) {
                try {
                    str2 = "OperateViews";
                    try {
                        Rect rect3 = new Rect(optJSONObject3.optInt(TtmlNode.LEFT, -999), optJSONObject3.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject3.optInt(TtmlNode.RIGHT, -999), optJSONObject3.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                        int optInt2 = optJSONObject3.optInt("width");
                        optInt = optJSONObject3.optInt("height");
                        rect = rect3;
                        i11 = optInt2;
                    } catch (Throwable th2) {
                        th = th2;
                        obj3 = obj;
                        str = str2;
                        obj2 = obj3;
                        a(obj2, th.getMessage());
                        o0.a(str, "webviewLoad failed: " + th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "OperateViews";
                    obj3 = obj;
                    str = str2;
                    obj2 = obj3;
                    a(obj2, th.getMessage());
                    o0.a(str, "webviewLoad failed: " + th.getMessage());
                }
            } else {
                str2 = "OperateViews";
                optInt = 0;
                i11 = 0;
                rect = rect2;
            }
            int optInt3 = optJSONObject2.optInt("refreshCache", 0);
            LinkedHashMap<String, View> b11 = b(optString, e11);
            try {
                if (b11.containsKey(optString2)) {
                    View view = b11.get(optString2);
                    if (view instanceof MBridgeBTWebView) {
                        MBridgeBTWebView mBridgeBTWebView = (MBridgeBTWebView) view;
                        mBridgeBTWebView.setHtml(optString5);
                        mBridgeBTWebView.setFilePath(optString4);
                        mBridgeBTWebView.setFileURL(optString3);
                        mBridgeBTWebView.setRect(rect);
                        mBridgeBTWebView.setLayout(i11, optInt);
                        mBridgeBTWebView.setCampaigns(arrayList);
                        mBridgeBTWebView.setRewardUnitSetting(a11);
                        mBridgeBTWebView.webviewLoad(optInt3);
                        Object obj5 = obj;
                        try {
                            b(obj5, optString2);
                            String str3 = str2;
                            o0.a(str3, "webviewLoad instanceId = " + optString2);
                            i11 = obj5;
                            rect = str3;
                        } catch (Throwable th4) {
                            th = th4;
                            obj3 = obj5;
                            str = str2;
                            obj2 = obj3;
                            a(obj2, th.getMessage());
                            o0.a(str, "webviewLoad failed: " + th.getMessage());
                        }
                    } else {
                        Object obj6 = obj;
                        String str4 = str2;
                        a(obj6, "view not exist");
                        o0.a(str4, "webviewLoad failed: view not exist instanceId = " + optString2);
                        i11 = obj6;
                        rect = str4;
                    }
                } else {
                    Object obj7 = obj;
                    String str5 = str2;
                    a(obj7, "instanceId not exist");
                    o0.a(str5, "webviewLoad failed: instanceId not exist instanceId = " + optString2);
                    i11 = obj7;
                    rect = str5;
                }
            } catch (Throwable th5) {
                th = th5;
                obj2 = i11;
                str = rect;
                a(obj2, th.getMessage());
                o0.a(str, "webviewLoad failed: " + th.getMessage());
            }
        } catch (Throwable th6) {
            th = th6;
            str = "OperateViews";
            obj2 = obj4;
        }
    }

    public void O(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "webviewReload failed instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTWebView)) {
                a(obj, "view not exist");
                o0.a("OperateViews", "webviewReload failed view not exist instanceId = " + optString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewReload()) {
                b(obj, optString2);
                o0.a("OperateViews", "webviewReload instanceId = " + optString2);
                return;
            }
            a(obj, "reload failed");
            o0.a("OperateViews", "webviewReload failed reload failed instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "webviewReload failed: " + th2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.LinearLayout$LayoutParams] */
    public ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Rect rect, int i11, int i12) {
        if (rect == null) {
            rect = new Rect(-999, -999, -999, -999);
        }
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d11 == null) {
            return layoutParams;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int i13 = rect.left;
            if (i13 != -999) {
                layoutParams2.leftMargin = t0.a(d11, i13);
            }
            int i14 = rect.top;
            if (i14 != -999) {
                layoutParams2.topMargin = t0.a(d11, i14);
            }
            int i15 = rect.right;
            if (i15 != -999) {
                layoutParams2.rightMargin = t0.a(d11, i15);
            }
            int i16 = rect.bottom;
            if (i16 != -999) {
                layoutParams2.bottomMargin = t0.a(d11, i16);
            }
            if (i11 > 0) {
                layoutParams2.width = t0.a(d11, i11);
            }
            if (i12 > 0) {
                layoutParams2.height = t0.a(d11, i12);
            }
            return layoutParams2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            int i17 = rect.left;
            if (i17 != -999) {
                layoutParams3.leftMargin = t0.a(d11, i17);
            }
            int i18 = rect.top;
            if (i18 != -999) {
                layoutParams3.topMargin = t0.a(d11, i18);
            }
            int i19 = rect.right;
            if (i19 != -999) {
                layoutParams3.rightMargin = t0.a(d11, i19);
            }
            int i20 = rect.bottom;
            if (i20 != -999) {
                layoutParams3.bottomMargin = t0.a(d11, i20);
            }
            if (i11 > 0) {
                layoutParams3.width = t0.a(d11, i11);
            }
            if (i12 > 0) {
                layoutParams3.height = t0.a(d11, i12);
            }
            return layoutParams3;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            int i21 = rect.left;
            if (i21 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = t0.a(d11, i21);
            }
            int i22 = rect.top;
            if (i22 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = t0.a(d11, i22);
            }
            int i23 = rect.right;
            if (i23 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = t0.a(d11, i23);
            }
            int i24 = rect.bottom;
            if (i24 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = t0.a(d11, i24);
            }
            if (i11 > 0) {
                ((LinearLayout.LayoutParams) layoutParams).width = t0.a(d11, i11);
            }
            if (i12 > 0) {
                ((LinearLayout.LayoutParams) layoutParams).height = t0.a(d11, i12);
            }
        }
        return layoutParams;
    }

    public void a(int i11, int i12, int i13, int i14, int i15) {
        o0.a("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15)));
        f38834k = b0.a(i11, i12, i13, i14, i15);
        f38835l = i11;
        f38836m = i12;
        f38837n = i13;
        f38838o = i14;
        f38839p = i15;
    }

    public void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f38833j);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            f.a().b(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            o0.a("OperateViews", e11.getMessage());
        }
    }

    public void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f38832i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            f.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            a(webView, e11.getMessage());
            o0.a("OperateViews", e11.getMessage());
        }
    }

    public void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f38833j);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            o0.a("OperateViews", e11.getMessage());
        }
    }

    public void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f38832i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            f.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            a(obj, e11.getMessage());
            o0.a("OperateViews", e11.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e1, code lost:
    
        com.mbridge.msdk.foundation.tools.c1.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e4, code lost:
    
        r0 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r9;
        r6 = (com.mbridge.msdk.video.signal.impl.k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) r18).f36595b.getObject();
        r0.setAdEvents(r6.j());
        r0.setAdSession(r6.k());
        r0.setVideoEvents(r6.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0108, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0109, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b("OperateViews", r0.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.Object r18, org.json.JSONObject r19) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.component.a.a(java.lang.Object, org.json.JSONObject):void");
    }

    public void a(Object obj, JSONObject jSONObject, boolean z10) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2) || !b11.containsKey(optString3)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            View view2 = b11.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                optInt = ((BTBaseView) view).getViewWidth();
                optInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                rect = null;
                optInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a11 = a(layoutParams, rect, optInt, optInt2);
            if (z10) {
                c1.a(view);
            }
            viewGroup.addView(view, indexOfChild + 1, a11);
            b(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            o0.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "insertViewAbove failed: " + th2.getMessage());
        }
    }

    public void a(String str) {
        if (f38828e.containsKey(str)) {
            f38828e.remove(str);
        }
        if (f38827d.containsKey(str)) {
            f38827d.remove(str);
        }
        if (f38826c.containsKey(str)) {
            f38826c.remove(str);
        }
        if (f38825b.containsKey(str)) {
            f38825b.remove(str);
        }
    }

    public void a(String str, int i11) {
        f38829f.put(str, Integer.valueOf(i11));
    }

    public void a(String str, Activity activity) {
        f38830g.put(str, activity);
    }

    public String b() {
        f38831h++;
        return String.valueOf(f38831h);
    }

    public synchronized LinkedHashMap<String, View> b(String str, String str2) {
        if (f38824a.containsKey(str + "_" + str2)) {
            return f38824a.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        f38824a.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public void b(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f38832i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            a(obj, e11.getMessage());
            o0.a("OperateViews", e11.getMessage());
        }
    }

    public void b(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String optString3 = optJSONObject.optString("id");
                LinkedHashMap<String, View> b11 = b(optString, e11);
                if (!b11.containsKey(optString2) || !b11.containsKey(optString3)) {
                    a(obj, "instanceId is not exist");
                    o0.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) b11.get(optString3);
                View view = b11.get(optString2);
                c1.a(view);
                if (viewGroup != null && view != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        Iterator<View> it = b11.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                c1.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject2 != null) {
                            Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                            optInt = optJSONObject2.optInt("width");
                            optInt2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            optInt = ((BTBaseView) view).getViewWidth();
                            optInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            optInt = 0;
                            rect = null;
                            optInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams a11 = a(layoutParams, rect, optInt, optInt2);
                        c1.a(view);
                        viewGroup.addView(view, a11);
                    }
                    b(obj, optString2);
                    a(obj, "onAppendViewTo", optString2);
                    o0.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                    return;
                }
                a(obj, "view is not exist");
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "appendViewTo failed: " + th2.getMessage());
        }
    }

    public void b(Object obj, JSONObject jSONObject, boolean z10) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2) || !b11.containsKey(optString3)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "insertViewBelow failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            View view2 = b11.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "insertViewBelow failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                optInt = ((BTBaseView) view).getViewWidth();
                optInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                rect = null;
                optInt = 0;
                optInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a11 = a(layoutParams, rect, optInt, optInt2);
            if (z10) {
                c1.a(view);
            }
            int i11 = indexOfChild - 1;
            viewGroup.addView(view, i11 > -1 ? i11 : 0, a11);
            b(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
            o0.a("OperateViews", "insertViewBelow instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "insertViewBelow failed: " + th2.getMessage());
        }
    }

    public void b(String str) {
        if (f38829f.containsKey(str)) {
            f38829f.remove(str);
        }
    }

    public CampaignEx c(String str) {
        if (f38826c.containsKey(str)) {
            return f38826c.get(str);
        }
        return null;
    }

    public void c(Object obj, String str) {
        o0.a("OperateViews", "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                String a11 = t0.a(jSONObject.optString("url"), "&tun=", k0.y() + "");
                int optInt2 = jSONObject.optInt("report");
                if (optInt2 == 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), (CampaignEx) null, "", a11, false, optInt != 0);
                } else {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), (CampaignEx) null, "", a11, false, optInt != 0, optInt2);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            b(obj, "");
        } catch (Throwable th3) {
            th = th3;
            o0.b("OperateViews", "reportUrls", th);
        }
    }

    public void c(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId is not exist");
                o0.a("OperateViews", "bringViewToFront failed: instanceId is not exist");
                return;
            }
            View view = b11.get(optString2);
            if (view == null || view.getParent() == null) {
                a(obj, "view is null");
                o0.a("OperateViews", "bringViewToFront failed: view is null");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                a(obj, "parent is null");
                o0.a("OperateViews", "bringViewToFront failed: parent is null");
                return;
            }
            viewGroup.bringChildToFront(view);
            b(obj, optString2);
            a(obj, "onBringViewToFront", optString2);
            o0.a("OperateViews", "bringViewToFront instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "bringViewToFront failed: " + th2.getMessage());
        }
    }

    public void c(String str, String str2) {
        try {
            LinkedHashMap<String, View> b11 = b(str, str2);
            if (b11 != null && !b11.isEmpty()) {
                for (View view : b11.values()) {
                    if (view instanceof MBridgeBTContainer) {
                        ((MBridgeBTContainer) view).addNativeCloseButtonWhenWebViewCrash();
                    }
                }
            }
        } catch (Throwable th2) {
            o0.b("OperateViews", th2.getMessage());
        }
    }

    public com.mbridge.msdk.videocommon.setting.c d(String str) {
        if (f38827d.containsKey(str)) {
            return f38827d.get(str);
        }
        return null;
    }

    public void d(Object obj, JSONObject jSONObject) {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString(EventConstants.KEY_EVENT_NAME);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            LinkedHashMap<String, View> b11 = b(optString, rid);
            if (b11 == null || b11.size() <= 0) {
                a(obj, "unitId not exist");
                return;
            }
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).broadcast(optString2, optJSONObject);
                }
                if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).broadcast(optString2, optJSONObject);
                }
            }
            b(obj, "");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "broadcast failed: " + th2.getMessage());
        }
    }

    public void d(String str, String str2) {
        f38825b.put(str, str2);
    }

    public String e(String str) {
        return f38825b.containsKey(str) ? f38825b.get(str) : "";
    }

    public void e(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (b11.size() <= 0) {
                a(obj, "unitId or instanceId not exist");
                o0.a("OperateViews", "closeAd failed: unitId or instanceId not exist unitId = " + optString);
                return;
            }
            MBridgeBTContainer mBridgeBTContainer = null;
            for (View view : b11.values()) {
                if (view instanceof MBridgeBTContainer) {
                    mBridgeBTContainer = (MBridgeBTContainer) view;
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                } else if (view instanceof MBridgeBTVideoView) {
                    com.mbridge.msdk.video.bt.component.b.a().a(((MBridgeBTVideoView) view).getInstanceId());
                    ((MBridgeBTVideoView) view).onDestory();
                } else if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
            }
            if (mBridgeBTContainer == null) {
                a(obj, "not found MBridgeBTContainer");
                o0.a("OperateViews", "closeAd successed");
                return;
            }
            mBridgeBTContainer.onAdClose();
            f38824a.remove(b11);
            b11.clear();
            f38824a.remove(optString + "_" + e11);
            b(obj, optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "closeAd failed: " + th2.getMessage());
        }
    }

    public String f(String str) {
        return f38828e.containsKey(str) ? f38828e.get(str) : "";
    }

    public void f(Object obj, JSONObject jSONObject) {
        o0.a("OperateViews", "createNativeEC:" + jSONObject);
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String str = "";
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject(MBInterstitialActivity.INTENT_CAMAPIGN));
                if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                    str = parseCampaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.setting.c a11 = com.mbridge.msdk.videocommon.setting.c.a(optJSONObject.optJSONObject("unitSetting"));
                if (a11 != null) {
                    a11.h(optString);
                }
                MBridgeBTNativeEC mBridgeBTNativeEC = new MBridgeBTNativeEC(com.mbridge.msdk.foundation.controller.c.m().d());
                mBridgeBTNativeEC.setCampaign(parseCampaignWithBackData);
                k kVar = new k(null, parseCampaignWithBackData);
                kVar.setUnitId(optString);
                mBridgeBTNativeEC.setJSCommon(kVar);
                mBridgeBTNativeEC.setUnitId(optString);
                mBridgeBTNativeEC.setRewardUnitSetting(a11);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
                if (windVaneWebView != null) {
                    str = windVaneWebView.getRid();
                    mBridgeBTNativeEC.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> b11 = b(optString, str);
                String b12 = b();
                f38825b.put(b12, str);
                mBridgeBTNativeEC.setInstanceId(b12);
                b11.put(b12, mBridgeBTNativeEC);
                mBridgeBTNativeEC.preLoadData();
                if (parseCampaignWithBackData == null) {
                    a(obj, "campaign is null");
                    o0.a("OperateViews", "createNativeEC failed");
                    return;
                }
                b(obj, b12);
                o0.a("OperateViews", "createNativeEC instanceId = " + b12);
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "createNativeEC failed：" + th2.getMessage());
        }
    }

    public int g(String str) {
        if (f38829f.containsKey(str)) {
            return f38829f.get(str).intValue();
        }
        return 2;
    }

    public void g(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String str = "";
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject(MBInterstitialActivity.INTENT_CAMAPIGN));
                if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                    str = parseCampaignWithBackData.getRequestId();
                }
                int optInt = optJSONObject.optInt(TrackingKey.SHOW_TIME, 0);
                int optInt2 = optJSONObject.optInt("show_mute", 0);
                int optInt3 = optJSONObject.optInt("show_close", 0);
                int optInt4 = optJSONObject.optInt("orientation", 1);
                int optInt5 = optJSONObject.optInt("show_pgb", 0);
                MBridgeBTVideoView mBridgeBTVideoView = new MBridgeBTVideoView(com.mbridge.msdk.foundation.controller.c.m().d());
                try {
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b.getObject();
                    mBridgeBTVideoView.setAdEvents(kVar.j());
                    mBridgeBTVideoView.setAdSession(kVar.k());
                    mBridgeBTVideoView.setVideoEvents(kVar.o());
                } catch (Exception e11) {
                    o0.b("OperateViews", e11.getMessage());
                }
                mBridgeBTVideoView.setCampaign(parseCampaignWithBackData);
                mBridgeBTVideoView.setUnitId(optString);
                mBridgeBTVideoView.setShowMute(optInt2);
                mBridgeBTVideoView.setShowTime(optInt);
                mBridgeBTVideoView.setShowClose(optInt3);
                mBridgeBTVideoView.setOrientation(optInt4);
                mBridgeBTVideoView.setProgressBarState(optInt5);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
                if (windVaneWebView != null) {
                    str = windVaneWebView.getRid();
                    mBridgeBTVideoView.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> b11 = b(optString, str);
                String b12 = b();
                f38825b.put(b12, str);
                mBridgeBTVideoView.setInstanceId(b12);
                b11.put(b12, mBridgeBTVideoView);
                mBridgeBTVideoView.preLoadData();
                if (parseCampaignWithBackData == null) {
                    a(obj, "campaign is null");
                    o0.a("OperateViews", "createPlayerView failed");
                } else {
                    b(obj, b12);
                    o0.a("OperateViews", "createPlayerView instanceId = " + b12);
                }
                com.mbridge.msdk.video.bt.component.b.a().a(b12, mBridgeBTVideoView);
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "createPlayerView failed：" + th2.getMessage());
        }
    }

    public void h(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                int optInt = optJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                String str = "";
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject(MBInterstitialActivity.INTENT_CAMAPIGN));
                if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                    str = parseCampaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.setting.c a11 = com.mbridge.msdk.videocommon.setting.c.a(optJSONObject.optJSONObject("unitSetting"));
                if (a11 != null) {
                    a11.h(optString);
                }
                String optString2 = optJSONObject.optString("userId");
                if (TextUtils.isEmpty(str) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                    str = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> b11 = b(optString, str);
                String b12 = b();
                f38825b.put(b12, str);
                MBTempContainer mBTempContainer = new MBTempContainer(com.mbridge.msdk.foundation.controller.c.m().d());
                try {
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b.getObject();
                    mBTempContainer.setAdEvents(kVar.j());
                    mBTempContainer.setAdSession(kVar.k());
                    mBTempContainer.setVideoEvents(kVar.o());
                } catch (Exception e11) {
                    o0.b("OperateViews", e11.getMessage());
                }
                mBTempContainer.setInstanceId(b12);
                mBTempContainer.setUnitId(optString);
                mBTempContainer.setCampaign(parseCampaignWithBackData);
                mBTempContainer.setRewardUnitSetting(a11);
                mBTempContainer.setBigOffer(true);
                if (!TextUtils.isEmpty(optString2)) {
                    mBTempContainer.setUserId(optString2);
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
                if (optJSONObject2 != null) {
                    String optString3 = optJSONObject2.optString("id");
                    com.mbridge.msdk.videocommon.entity.c cVar = new com.mbridge.msdk.videocommon.entity.c(optJSONObject2.optString("name"), optJSONObject2.optInt(RewardPlus.AMOUNT));
                    if (!TextUtils.isEmpty(optString3)) {
                        mBTempContainer.setRewardId(optString3);
                    }
                    if (!TextUtils.isEmpty(cVar.c())) {
                        mBTempContainer.setReward(cVar);
                    }
                }
                String optString4 = optJSONObject.optString("extra");
                if (!TextUtils.isEmpty(optString4)) {
                    mBTempContainer.setDeveloperExtraData(optString4);
                }
                mBTempContainer.setMute(optInt);
                b11.put(b12, mBTempContainer);
                f38828e.put(b12, optString);
                f38826c.put(b12, parseCampaignWithBackData);
                f38827d.put(b12, a11);
                b(obj, b12);
                o0.a("OperateViews", "createSubPlayTemplateView instanceId = " + b12);
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "createSubPlayTemplateView failed：" + th2.getMessage());
        }
    }

    public void h(String str) {
        f38830g.remove(str);
    }

    public void i(Object obj, JSONObject jSONObject) {
        int i11;
        int i12;
        Rect rect;
        try {
            String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                a(obj, "unitId is empty");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            int optInt = optJSONObject.optInt("delay", 0);
            optJSONObject.optString("fileURL");
            optJSONObject.optString(NativeRequestBridge.KEY_FILE_PATH);
            optJSONObject.optString("html");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (optJSONObject2 != null) {
                Rect rect3 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                int optInt2 = optJSONObject2.optInt("width");
                i12 = optJSONObject2.optInt("height");
                rect = rect3;
                i11 = optInt2;
            } else {
                i11 = 0;
                i12 = 0;
                rect = rect2;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0556a(obj, optString, rect, i11, i12), optInt);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "create view failed：" + th2.getMessage());
        }
    }

    public void j(Object obj, JSONObject jSONObject) {
        int i11;
        int i12;
        Rect rect;
        try {
            String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                a(obj, "unitId is empty");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            int optInt = optJSONObject.optInt("delay", 0);
            String optString2 = optJSONObject.optString("fileURL");
            String optString3 = optJSONObject.optString(NativeRequestBridge.KEY_FILE_PATH);
            String optString4 = optJSONObject.optString("html");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (optJSONObject2 != null) {
                Rect rect3 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                int optInt2 = optJSONObject2.optInt("width");
                i12 = optJSONObject2.optInt("height");
                rect = rect3;
                i11 = optInt2;
            } else {
                i11 = 0;
                i12 = 0;
                rect = rect2;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new b(obj, optString, optString2, optString3, optString4, rect, i11, i12), optInt);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "createWebview failed：" + th2.getMessage());
        }
    }

    public void k(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") != null && !TextUtils.isEmpty(optString)) {
                String e11 = e(optString2);
                if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                    e11 = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> b11 = b(optString, e11);
                if (b11 == null || !b11.containsKey(optString2)) {
                    a(obj, "unitId or instanceId not exist");
                    o0.a("OperateViews", "destroyComponent failed");
                    return;
                }
                View view = b11.get(optString2);
                b11.remove(optString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view;
                        if (viewGroup2.getChildCount() > 0) {
                            int childCount = viewGroup2.getChildCount();
                            for (int i11 = 0; i11 < childCount; i11++) {
                                View childAt = viewGroup2.getChildAt(i11);
                                if (childAt instanceof MBridgeBTWebView) {
                                    b11.remove(((MBridgeBTWebView) childAt).getInstanceId());
                                    ((MBridgeBTWebView) childAt).onDestory();
                                } else if (childAt instanceof MBridgeBTVideoView) {
                                    b11.remove(((MBridgeBTVideoView) childAt).getInstanceId());
                                    ((MBridgeBTVideoView) childAt).onDestory();
                                } else if (childAt instanceof MBTempContainer) {
                                    b11.remove(((MBTempContainer) childAt).getInstanceId());
                                    ((MBTempContainer) childAt).onDestroy();
                                }
                            }
                        }
                    }
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onDestory();
                }
                b(obj, optString2);
                a(obj, "onComponentDestroy", optString2);
                o0.a("OperateViews", "destroyComponent instanceId = " + optString2);
                return;
            }
            a(obj, "unidId or data is empty");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "destroyComponent failed");
        }
    }

    public void l(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            String optString = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            } else {
                b(obj, optString);
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
        }
    }

    public void m(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        int i11;
        boolean z10;
        String str5;
        File file;
        JSONObject jSONObject2 = new JSONObject();
        String str6 = "message";
        String str7 = "code";
        int i12 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e11) {
                o0.a("OperateViews", e11.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        int length = jSONArray.length();
                        int i13 = 0;
                        while (i13 < length) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i13);
                            String optString = jSONObject3.optString("ref", "");
                            int i14 = jSONObject3.getInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                            JSONObject jSONObject4 = new JSONObject();
                            JSONArray jSONArray3 = jSONArray;
                            if (i14 != i12 || TextUtils.isEmpty(optString)) {
                                str3 = str6;
                                str4 = str7;
                                i11 = length;
                                z10 = false;
                                if (i14 == 2 && !TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                                    jSONObject5.put("path", H5DownLoadManager.getInstance().getH5ResAddress(optString) == null ? "" : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                                    jSONObject4.put(optString, jSONObject5);
                                    jSONArray2.put(jSONObject4);
                                } else if (i14 == 3 && !TextUtils.isEmpty(optString)) {
                                    try {
                                        file = new File(optString);
                                    } catch (Throwable th2) {
                                        if (MBridgeConstans.DEBUG) {
                                            th2.printStackTrace();
                                        }
                                    }
                                    if (file.exists() && file.isFile() && file.canRead()) {
                                        o0.a("OperateViews", "getFileInfo Mraid file " + optString);
                                        str5 = "file:////" + optString;
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                                        jSONObject6.put("path", str5);
                                        jSONObject4.put(optString, jSONObject6);
                                        jSONArray2.put(jSONObject4);
                                    }
                                    str5 = "";
                                    JSONObject jSONObject62 = new JSONObject();
                                    jSONObject62.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                                    jSONObject62.put("path", str5);
                                    jSONObject4.put(optString, jSONObject62);
                                    jSONArray2.put(jSONObject4);
                                } else if (i14 == 4 && !TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject7 = new JSONObject();
                                    jSONObject7.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 4);
                                    jSONObject7.put("path", s0.a(optString) == null ? "" : s0.a(optString));
                                    jSONObject4.put(optString, jSONObject7);
                                    jSONArray2.put(jSONObject4);
                                }
                                i13++;
                                jSONArray = jSONArray3;
                                length = i11;
                                str6 = str3;
                                str7 = str4;
                                i12 = 1;
                            } else {
                                JSONObject jSONObject8 = new JSONObject();
                                l b11 = m.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(optString);
                                if (b11 != null) {
                                    i11 = length;
                                    o0.a("OperateViews", "VideoBean not null");
                                    jSONObject8.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                                    str3 = str6;
                                    try {
                                        jSONObject8.put("videoDataLength", b11.d());
                                        String e12 = b11.e();
                                        str4 = str7;
                                        if (TextUtils.isEmpty(e12)) {
                                            try {
                                                o0.a("OperateViews", "VideoPath null");
                                                jSONObject8.put("path", "");
                                                jSONObject8.put("path4Web", "");
                                            } catch (Throwable th3) {
                                                th = th3;
                                                str = str3;
                                                str2 = str4;
                                                try {
                                                    jSONObject2.put(str2, 1);
                                                    jSONObject2.put(str, th.getLocalizedMessage());
                                                    f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                                } catch (JSONException e13) {
                                                    o0.a("OperateViews", e13.getMessage());
                                                    return;
                                                }
                                            }
                                        } else {
                                            o0.a("OperateViews", "VideoPath not null");
                                            jSONObject8.put("path", e12);
                                            jSONObject8.put("path4Web", e12);
                                        }
                                        if (b11.b() == 5) {
                                            jSONObject8.put("downloaded", 1);
                                            z10 = false;
                                        } else {
                                            z10 = false;
                                            jSONObject8.put("downloaded", 0);
                                        }
                                        jSONObject4.put(optString, jSONObject8);
                                        jSONArray2.put(jSONObject4);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str4 = str7;
                                        str = str3;
                                        str2 = str4;
                                        jSONObject2.put(str2, 1);
                                        jSONObject2.put(str, th.getLocalizedMessage());
                                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                    }
                                } else {
                                    str3 = str6;
                                    str4 = str7;
                                    i11 = length;
                                    z10 = false;
                                    o0.a("OperateViews", "VideoBean null");
                                }
                                i13++;
                                jSONArray = jSONArray3;
                                length = i11;
                                str6 = str3;
                                str7 = str4;
                                i12 = 1;
                            }
                        }
                        str3 = str6;
                        str4 = str7;
                        jSONObject2.put("resource", jSONArray2);
                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str3 = str6;
                }
            }
            str2 = "code";
            str = 1;
        } catch (Throwable th6) {
            th = th6;
            str = "message";
            str2 = "code";
        }
        try {
            try {
                jSONObject2.put(str2, 1);
                str = "message";
                try {
                    jSONObject2.put(str, "resource is null");
                    f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                } catch (JSONException e14) {
                    e = e14;
                    o0.a("OperateViews", e.getMessage());
                }
            } catch (Throwable th7) {
                th = th7;
                jSONObject2.put(str2, 1);
                jSONObject2.put(str, th.getLocalizedMessage());
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (JSONException e15) {
            e = e15;
            str = "message";
        } catch (Throwable th8) {
            th = th8;
            str = "message";
            jSONObject2.put(str2, 1);
            jSONObject2.put(str, th.getLocalizedMessage());
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        }
    }

    public void n(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "hideView failed: instanceId not exist");
                return;
            }
            View view = b11.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "hideView failed: view not exist");
                return;
            }
            view.setVisibility(8);
            b(obj, optString2);
            a(obj, "onHideView", optString2);
            o0.a("OperateViews", "hideView instanceId = " + optString2);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "hideView failed: + " + th2.getMessage());
        }
    }

    public void o(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                a(obj, "data camapign is empty");
            } else {
                a(parseCampaignWithBackData);
                b(obj, "");
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
        }
    }

    public void p(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString3) || !b11.containsKey(optString2)) {
                a(obj, "instanceId is not exist");
                o0.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b11.get(optString2);
            View view = b11.get(optString3);
            if (viewGroup != null && view != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                if (view instanceof MBTempContainer) {
                    o0.b("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(f38835l), Integer.valueOf(f38836m), Integer.valueOf(f38837n), Integer.valueOf(f38838o), Integer.valueOf(f38839p)));
                    ((MBTempContainer) view).setNotchPadding(f38835l, f38836m, f38837n, f38838o, f38839p);
                    Iterator<View> it = b11.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View next = it.next();
                        if (next instanceof MBridgeBTContainer) {
                            c1.a(view);
                            ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (optJSONObject2 != null) {
                        Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                        optInt = optJSONObject2.optInt("width");
                        optInt2 = optJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        optInt = ((BTBaseView) view).getViewWidth();
                        optInt2 = ((BTBaseView) view).getViewHeight();
                    } else {
                        rect = null;
                        optInt = 0;
                        optInt2 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, optInt, optInt2));
                }
                b(obj, optString2);
                a(obj, "onAppendView", optString2);
                o0.a("OperateViews", "appendSubView parentId = " + optString2 + " childId = " + optString3);
                return;
            }
            a(obj, "view is not exist");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "appendSubView failed: " + th2.getMessage());
        }
    }

    public void q(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String optString3 = optJSONObject.optString("id");
                LinkedHashMap<String, View> b11 = b(optString, e11);
                if (!b11.containsKey(optString2) || !b11.containsKey(optString3)) {
                    a(obj, "instanceId is not exist");
                    o0.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) b11.get(optString3);
                View view = b11.get(optString2);
                if (viewGroup != null && view != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        Iterator<View> it = b11.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                c1.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject2 != null) {
                            Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                            optInt = optJSONObject2.optInt("width");
                            optInt2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            optInt = ((BTBaseView) view).getViewWidth();
                            optInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            optInt = 0;
                            rect = null;
                            optInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, optInt, optInt2));
                    }
                    b(obj, optString2);
                    a(obj, "onAppendViewTo", optString2);
                    o0.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                    return;
                }
                a(obj, "view is not exist");
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "appendViewTo failed: " + th2.getMessage());
        }
    }

    public void r(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2) || !b11.containsKey(optString3)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            View view2 = b11.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                a(obj, "view not exist");
                o0.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt(TtmlNode.LEFT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_TOP, -999), optJSONObject2.optInt(TtmlNode.RIGHT, -999), optJSONObject2.optInt(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, -999));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                optInt = ((BTBaseView) view).getViewWidth();
                optInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                rect = null;
                optInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild + 1, a(layoutParams, rect, optInt, optInt2));
            b(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            o0.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "insertViewAbove failed: " + th2.getMessage());
        }
    }

    public void s(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "playerGetMuteState failed instanceId not exist");
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerGetMuteState failed instanceId is not player");
                return;
            }
            int mute = ((MBridgeBTVideoView) view).getMute();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f38832i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", optString2);
            jSONObject3.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, mute);
            jSONObject2.put("data", jSONObject3);
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            o0.a("OperateViews", "playerGetMuteState successed mute = " + mute);
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerGetMuteState failed: " + th2.getMessage());
        }
    }

    public void t(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                o0.a("OperateViews", "playerMute failed: instanceId is not exist");
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerMute failed: instanceId is not player");
            } else if (((MBridgeBTVideoView) view).playMute()) {
                b(obj, optString2);
                o0.a("OperateViews", "playerMute success");
            } else {
                a(obj, "set mute failed");
                o0.a("OperateViews", "playerMute failed set mute failed");
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerMute failed: " + th2.getMessage());
        }
    }

    public void u(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                o0.a("OperateViews", "playerPause failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).pause();
                b(obj, optString2);
                o0.a("OperateViews", "playerPause success");
            } else {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerPause failed instanceId is not player instanceId = " + optString2);
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerPause failed: " + th2.getMessage());
        }
    }

    public void v(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                o0.a("OperateViews", "playerPlay failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerPlay failed instanceId is not player instanceId = " + optString2);
                return;
            }
            MBridgeBTVideoView mBridgeBTVideoView = (MBridgeBTVideoView) view;
            MBridgeBTContainer a11 = a(optString, e11);
            if (a11 != null) {
                mBridgeBTVideoView.setAdEvents(a11.getAdEvents());
                mBridgeBTVideoView.setAdSession(a11.getAdSession());
                mBridgeBTVideoView.setVideoEvents(a11.getVideoEvents());
            }
            mBridgeBTVideoView.play();
            b(obj, optString2);
            o0.a("OperateViews", "playerPlay success");
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerPlay failed: " + th2.getMessage());
        }
    }

    public void w(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                o0.a("OperateViews", "playerResume failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).resume();
                b(obj, optString2);
                o0.a("OperateViews", "playerResume success");
            } else {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerResume failed instanceId is not player instanceId = " + optString2);
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerResume failed: " + th2.getMessage());
        }
    }

    public void x(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            } else {
                a(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
        }
    }

    public void y(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
        }
    }

    public void z(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e11 = e(optString2);
            if (TextUtils.isEmpty(e11) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                e11 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b11 = b(optString, e11);
            if (!b11.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                o0.a("OperateViews", "playerStop failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b11.get(optString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).stop();
                b(obj, optString2);
                o0.a("OperateViews", "playerStop success");
            } else {
                a(obj, "instanceId is not player");
                o0.a("OperateViews", "playerStop failed instanceId is not player instanceId = " + optString2);
            }
        } catch (Throwable th2) {
            a(obj, th2.getMessage());
            o0.a("OperateViews", "playerStop failed: " + th2.getMessage());
        }
    }
}
