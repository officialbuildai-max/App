package com.mbridge.msdk.advanced.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b extends c {

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f34285c;

    /* renamed from: d, reason: collision with root package name */
    private List<CampaignEx> f34286d;

    /* renamed from: e, reason: collision with root package name */
    private String f34287e;

    /* renamed from: f, reason: collision with root package name */
    private String f34288f;

    /* renamed from: g, reason: collision with root package name */
    private int f34289g;

    /* renamed from: h, reason: collision with root package name */
    private int f34290h;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.advanced.middle.a f34292j;

    /* renamed from: k, reason: collision with root package name */
    private NativeAdvancedExpandDialog f34293k;

    /* renamed from: b, reason: collision with root package name */
    private String f34284b = "NativeAdvancedJSBridgeImpl";

    /* renamed from: i, reason: collision with root package name */
    private int f34291i = 5;

    /* loaded from: classes5.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f34294a;

        a(ArrayList arrayList) {
            this.f34294a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a11 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                Iterator it = this.f34294a.iterator();
                while (it.hasNext()) {
                    a11.b((String) it.next());
                }
            } catch (Exception unused) {
                o0.b(b.this.f34284b, "campain can't insert db");
            }
        }
    }

    public b(Context context, String str, String str2) {
        this.f34288f = str;
        this.f34287e = str2;
        this.f34285c = new WeakReference<>(context);
    }

    public List<CampaignEx> a() {
        return this.f34286d;
    }

    public void a(int i11) {
        this.f34290h = i11;
    }

    public void a(com.mbridge.msdk.advanced.middle.a aVar) {
        if (aVar != null) {
            this.f34292j = aVar;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i11 = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
            if (aVar != null) {
                aVar.a(i11);
            }
        } catch (JSONException e11) {
            o0.b(this.f34284b, "resetCountdown", e11);
        }
    }

    public void a(List<CampaignEx> list) {
        this.f34286d = list;
    }

    public void b(int i11) {
        this.f34291i = i11;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public void c(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                f.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b);
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "onSignalCommunicationConnect", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void click(Object obj, String str) {
        try {
            List<CampaignEx> list = this.f34286d;
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f34286d.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = campaignEx != null ? CampaignEx.campaignToJsonObject(campaignEx) : new JSONObject();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    campaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                String optString = campaignToJsonObject.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                }
                campaignEx = parseCampaignWithBackData;
            } catch (JSONException e11) {
                o0.b(this.f34284b, e11.getMessage());
            }
            com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "click", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        o0.b(this.f34284b, "close");
        try {
            com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
            if (aVar != null) {
                aVar.close();
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "close", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void d(Object obj, String str) {
        o0.a(this.f34284b, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string = jSONArray.getString(i11);
                for (CampaignEx campaignEx : this.f34286d) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.f34287e, campaignEx, "h5_native");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new a(arrayList)).start();
        } catch (Throwable th2) {
            o0.b(this.f34284b, "sendImpressions", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z10) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z10);
            WeakReference<Context> weakReference = this.f34285c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            NativeAdvancedExpandDialog nativeAdvancedExpandDialog = this.f34293k;
            if (nativeAdvancedExpandDialog == null || !nativeAdvancedExpandDialog.isShowing()) {
                NativeAdvancedExpandDialog nativeAdvancedExpandDialog2 = new NativeAdvancedExpandDialog(this.f34285c.get(), bundle, this.f34292j);
                this.f34293k = nativeAdvancedExpandDialog2;
                nativeAdvancedExpandDialog2.setCampaignList(this.f34287e, this.f34286d);
                this.f34293k.show();
                com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.advanced.report.a.a(this.f34287e, getMraidCampaign(), str);
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "expand", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is empty");
            return;
        }
        try {
            com.mbridge.msdk.advanced.signal.a.a(obj, new JSONObject(str));
        } catch (Throwable th2) {
            o0.a(this.f34284b, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f34286d;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.f34286d.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.advanced.common.b bVar = new com.mbridge.msdk.advanced.common.b(com.mbridge.msdk.foundation.controller.c.m().d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f34289g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.b());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f34286d));
            l a11 = h.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f34287e);
            if (a11 == null) {
                a11 = l.k(this.f34287e);
            }
            if (!TextUtils.isEmpty(this.f34288f)) {
                a11.d(this.f34288f);
            }
            a11.e(this.f34287e);
            a11.j(this.f34291i);
            a11.a(this.f34290h);
            jSONObject.put("unitSetting", a11.M());
            String e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e11)) {
                jSONObject.put("appSetting", new JSONObject(e11));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f36485a);
            o0.b(this.f34284b, "init" + jSONObject.toString());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th2) {
            o0.b(this.f34284b, "init", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.b
    public void install(Object obj, String str) {
        o0.b(this.f34284b, "install");
        try {
            List<CampaignEx> list = this.f34286d;
            CampaignEx campaignEx = (list == null || list.size() <= 0) ? null : this.f34286d.get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = campaignEx != null ? CampaignEx.campaignToJsonObject(campaignEx) : new JSONObject();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    campaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                String optString = campaignToJsonObject.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                }
                campaignEx = parseCampaignWithBackData;
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "install", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void readyStatus(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) == null) {
                return;
            }
            try {
                windVaneWebView.getWebViewListener().a(windVaneWebView, new JSONObject(str).getInt("isReady"));
            } catch (Exception unused) {
                windVaneWebView.getWebViewListener().a(windVaneWebView, 2);
            }
        } catch (Throwable th2) {
            o0.a(this.f34284b, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void reportUrls(Object obj, String str) {
        o0.a(this.f34284b, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
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
                    Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list = this.f34286d;
                    com.mbridge.msdk.click.a.a(d11, list != null ? list.get(0) : null, "", a11, false, optInt != 0);
                } else {
                    Context d12 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.f34286d;
                    com.mbridge.msdk.click.a.a(d12, list2 != null ? list2.get(0) : null, "", a11, false, optInt != 0, optInt2);
                }
            }
            f.a().b(obj, d.a(0));
        } catch (Throwable th2) {
            o0.b(this.f34284b, "reportUrls", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
            if (aVar != null) {
                aVar.toggleCloseBtn(optInt);
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void triggerCloseBtn(Object obj, String str) {
        if (this.f34292j != null) {
            com.mbridge.msdk.advanced.signal.a.a(obj);
            this.f34292j.triggerCloseBtn(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z10) {
        try {
            if (this.f34290h == -1) {
                int i11 = z10 ? 2 : 1;
                com.mbridge.msdk.advanced.middle.a aVar = this.f34292j;
                if (aVar != null) {
                    aVar.toggleCloseBtn(i11);
                }
            }
        } catch (Throwable th2) {
            o0.b(this.f34284b, "useCustomClose", th2);
        }
    }
}
