package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.impl.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class k extends l {

    /* renamed from: t, reason: collision with root package name */
    private Activity f39891t;

    /* renamed from: u, reason: collision with root package name */
    private String f39892u;

    /* renamed from: v, reason: collision with root package name */
    private String f39893v;

    /* renamed from: x, reason: collision with root package name */
    private CampaignEx f39895x;

    /* renamed from: y, reason: collision with root package name */
    private List<CampaignEx> f39896y;

    /* renamed from: z, reason: collision with root package name */
    private int f39897z;

    /* renamed from: w, reason: collision with root package name */
    private int f39894w = 0;
    private String A = "";
    private String B = "";
    private boolean C = false;
    private boolean D = false;

    /* loaded from: classes5.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39898a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39899b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f39900c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f39901d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f39902e;

        a(String str, String str2, String str3, String str4, int i11) {
            this.f39898a = str;
            this.f39899b = str2;
            this.f39900c = str3;
            this.f39901d = str4;
            this.f39902e = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(k.this.f39891t.getApplication())).a(new com.mbridge.msdk.foundation.entity.m("2000039", this.f39898a, this.f39899b, this.f39900c, this.f39901d, k.this.f39895x.getId(), this.f39902e, k0.a(k.this.f39891t.getApplication(), this.f39902e)));
        }
    }

    public k(Activity activity, CampaignEx campaignEx) {
        this.f39891t = activity;
        this.f39895x = campaignEx;
    }

    public k(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.f39891t = activity;
        this.f39895x = campaignEx;
        this.f39896y = list;
    }

    private String A() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f39875j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.A);
            jSONObject2.put("rootViewInstanceId", this.B);
            jSONObject2.put("isRootTemplateWebView", this.C);
            jSONObject.put("sdk_info", "MAL_16.9.71,3.0.1");
            jSONObject2.put("playVideoMute", this.f39879n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<CampaignEx> list = this.f39896y;
            if (list == null || list.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.f39895x));
            } else {
                for (CampaignEx campaignEx : this.f39896y) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(campaignEx, campaignEx.isReady(), b(campaignEx)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", x());
            String e11 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e11)) {
                JSONObject jSONObject3 = new JSONObject(e11);
                c(jSONObject3);
                String c11 = com.mbridge.msdk.setting.h.b().c(this.f39875j);
                if (!TextUtils.isEmpty(c11)) {
                    jSONObject3.put("ivreward", new JSONObject(c11));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", w());
            if (!TextUtils.isEmpty(this.f39875j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f39875j);
            }
            jSONObject.put("rw_plus", this.D ? "1" : "0");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f39875j)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f39875j);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.mbridge.msdk.videocommon.setting.c cVar = this.f39876k;
            if (cVar != null) {
                jSONObject.put("unitSetting", cVar.H());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private CampaignEx a(String str, CampaignEx campaignEx) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                b(jSONObject);
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        campaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception unused) {
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    campaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                a(campaignToJsonObject, parseCampaignWithBackData);
                return parseCampaignWithBackData;
            } catch (JSONException e11) {
                e11.printStackTrace();
                return campaignEx;
            }
        }
        try {
            JSONObject campaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            CampaignEx parseCampaignWithBackData2 = CampaignEx.parseCampaignWithBackData(campaignToJsonObject2);
            if (parseCampaignWithBackData2 == null) {
                parseCampaignWithBackData2 = campaignEx;
            }
            if (!TextUtils.isEmpty(str)) {
                a(campaignToJsonObject2, parseCampaignWithBackData2);
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.f35392j);
                if (optJSONObject != null) {
                    str2 = String.valueOf(t0.a(this.f39891t, Integer.valueOf(optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f35390h)).intValue()));
                    str3 = String.valueOf(t0.a(this.f39891t, Integer.valueOf(optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f35391i)).intValue()));
                } else {
                    str2 = "-999";
                    str3 = "-999";
                }
                parseCampaignWithBackData2.setClickURL(com.mbridge.msdk.click.c.a(parseCampaignWithBackData2.getClickURL(), str2, str3));
                String noticeUrl = parseCampaignWithBackData2.getNoticeUrl();
                if (optJSONObject != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    StringBuilder sb2 = new StringBuilder();
                    while (keys2.hasNext()) {
                        sb2.append(UrlUtils.AND_MARK);
                        String next2 = keys2.next();
                        String optString = optJSONObject.optString(next2);
                        if (com.mbridge.msdk.foundation.same.a.f35390h.equals(next2) || com.mbridge.msdk.foundation.same.a.f35391i.equals(next2)) {
                            optString = String.valueOf(t0.a(this.f39891t, Integer.valueOf(optString).intValue()));
                        }
                        sb2.append(next2);
                        sb2.append(UrlUtils.EQUAL_MARK);
                        sb2.append(optString);
                    }
                    parseCampaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb2));
                }
            }
            return parseCampaignWithBackData2;
        } catch (JSONException e12) {
            e12.printStackTrace();
            return campaignEx;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return campaignEx;
        }
    }

    private void a(CampaignEx campaignEx) {
        try {
            int i11 = this.f39894w;
            if (i11 == 3) {
                campaignEx.setClickTempSource(2);
                if (campaignEx.getTriggerClickSource() == 0) {
                    campaignEx.setTriggerClickSource(2);
                    return;
                }
                return;
            }
            if (i11 != 1 || campaignEx.getClickTempSource() == 2) {
                return;
            }
            campaignEx.setClickTempSource(1);
        } catch (Exception e11) {
            o0.b("DefaultJSCommon", e11.getMessage());
        }
    }

    private void b(String str) {
        List<CampaignEx> list;
        if (this.f39895x == null || (list = this.f39896y) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.f39895x = this.f39896y.get(jSONObject.getInt("camp_position"));
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private boolean b(CampaignEx campaignEx) {
        com.mbridge.msdk.setting.g d11;
        try {
            String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
            long a02 = (TextUtils.isEmpty(b11) || (d11 = com.mbridge.msdk.setting.h.b().d(b11)) == null) ? 0L : d11.a0() * 1000;
            com.mbridge.msdk.videocommon.setting.a c11 = com.mbridge.msdk.videocommon.setting.b.b().c();
            long e11 = c11 != null ? c11.e() : 0L;
            if (campaignEx != null) {
                return campaignEx.isSpareOffer(e11, a02);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            String obj = w0.a(d11, "MBridge_ConfirmTitle" + this.f39875j, "").toString();
            String obj2 = w0.a(d11, "MBridge_ConfirmContent" + this.f39875j, "").toString();
            String obj3 = w0.a(d11, "MBridge_CancelText" + this.f39875j, "").toString();
            String obj4 = w0.a(d11, "MBridge_ConfirmText" + this.f39875j, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put("confirm_title", obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("confirm_description", obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("confirm_t", obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_play", obj4);
            }
            if (TextUtils.isEmpty(obj4)) {
                return;
            }
            jSONObject.put("confirm_c_rv", obj4);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            String e11 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e11)) {
                jSONObject.put("appSetting", new JSONObject(e11));
            }
        } catch (JSONException e12) {
            e12.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f39879n);
            jSONObject.put("sdkSetting", jSONObject2);
            a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.f39895x));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", x());
            String e11 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e11)) {
                JSONObject jSONObject3 = new JSONObject(e11);
                c(jSONObject3);
                String c11 = com.mbridge.msdk.setting.h.b().c(this.f39875j);
                if (!TextUtils.isEmpty(c11)) {
                    jSONObject3.put("ivreward", c11);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", w());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.setting.a c11 = com.mbridge.msdk.videocommon.setting.b.b().c();
        return c11 != null ? c11.k() : jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.setting.c cVar = this.f39876k;
        return cVar != null ? cVar.H() : jSONObject;
    }

    private JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.9.71,3.0.1");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f39879n);
            jSONObject2.put("instanceId", this.A);
            jSONObject.put("sdkSetting", jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void a(int i11, String str) {
        super.a(i11, str);
        if (i11 != 2) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT), jSONObject.optString("template", TmcConstants.COLD_OPEN_TYPE), jSONObject.optString(TtmlNode.TAG_LAYOUT, TmcConstants.COLD_OPEN_TYPE), jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f39875j), k0.s(this.f39891t.getApplication()));
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
            } else {
                aVar.run();
            }
        } catch (Throwable th2) {
            o0.b("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39893v = str;
    }

    public void a(List<CampaignEx> list) {
        this.f39896y = list;
    }

    public void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            campaignEx.setCampaignUnitId(optString);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String c() {
        this.f39878m.onInitSuccess();
        this.f39866a = true;
        if (TextUtils.isEmpty(this.f39892u)) {
            this.f39892u = A();
        } else {
            this.f39892u = t0.b(this.f39892u, "tun", k0.y() + "");
        }
        return this.f39892u;
    }

    public void c(CampaignEx campaignEx) {
        this.f39895x = campaignEx;
    }

    public void c(String str) {
        this.A = str;
    }

    public void c(boolean z10) {
        this.C = z10;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.e
    public void click(int i11, String str) {
        AppletsModel appletsModel;
        List<CampaignEx> list;
        int i12;
        super.click(i11, str);
        CampaignEx campaignEx = this.f39895x;
        if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
            b(str);
        }
        try {
            if (i11 != 1) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return;
                    }
                    this.f39878m.a(true);
                    return;
                }
                CampaignEx campaignEx2 = this.f39895x;
                if (campaignEx2 == null || campaignEx2.getCbd() <= -2) {
                    com.mbridge.msdk.videocommon.setting.c cVar = this.f39876k;
                    i12 = cVar != null ? cVar.i() : 1;
                } else {
                    i12 = this.f39895x.getCbd();
                }
                if (i12 == -1) {
                    a(new a.b(this, this.f39878m));
                }
                this.f39894w = i11;
                click(1, str);
                return;
            }
            if (this.f39895x == null && (list = this.f39896y) != null && list.size() > 0) {
                this.f39895x = this.f39896y.get(0);
            }
            CampaignEx campaignEx3 = this.f39895x;
            if (campaignEx3 == null) {
                return;
            }
            CampaignEx a11 = a(str, campaignEx3);
            if (this.f39894w != 3) {
                this.f39894w = i11;
            }
            a(a11);
            if (a11 != null && (appletsModel = AppletModelManager.getInstance().get(a11)) != null) {
                appletsModel.setUserClick(true);
                AppletModelManager.getInstance().replace(appletsModel, a11);
            }
            a(a11, this.f39891t);
        } catch (Throwable th2) {
            o0.b("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    public void d(String str) {
        this.B = str;
    }

    public void d(boolean z10) {
        this.D = z10;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String e() {
        o0.a("DefaultJSCommon", "getNotchArea");
        return this.f39893v;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String f(int i11) {
        switch (i11) {
            case 1:
                return y().toString();
            case 2:
                return B().toString();
            case 3:
                return s().toString();
            case 4:
                return C().toString();
            case 5:
                return u().toString();
            case 6:
                return z().toString();
            default:
                return t().toString();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void f() {
        super.f();
        try {
            Activity activity = this.f39891t;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th2) {
            o0.b("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playVideoMute", this.f39879n);
            jSONObject.put("userVideoMute", this.f39880o);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void h() {
        super.h();
        a.InterfaceC0571a interfaceC0571a = this.f39878m;
        if (interfaceC0571a != null) {
            interfaceC0571a.a();
        }
    }

    public void h(int i11) {
        this.f39897z = i11;
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i11, String str) {
        super.handlerH5Exception(i11, str);
        try {
            this.f39878m.a(i11, str);
        } catch (Throwable th2) {
            o0.b("DefaultJSCommon", th2.getMessage(), th2);
        }
    }

    public void r() {
        this.f39892u = "";
    }

    @Override // com.mbridge.msdk.video.signal.impl.a, com.mbridge.msdk.video.signal.a
    public void setActivity(Activity activity) {
        this.f39891t = activity;
    }

    public int v() {
        return this.f39897z;
    }
}
