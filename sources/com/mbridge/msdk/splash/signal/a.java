package com.mbridge.msdk.splash.signal;

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
import com.mbridge.msdk.mbsignalcommon.base.d;
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
public class a implements com.mbridge.msdk.mbsignalcommon.mraid.b {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f37660b;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f37661c;

    /* renamed from: d, reason: collision with root package name */
    private String f37662d;

    /* renamed from: e, reason: collision with root package name */
    private String f37663e;

    /* renamed from: f, reason: collision with root package name */
    private int f37664f;

    /* renamed from: g, reason: collision with root package name */
    private int f37665g;

    /* renamed from: i, reason: collision with root package name */
    private int f37667i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.splash.middle.a f37668j;

    /* renamed from: k, reason: collision with root package name */
    private SplashExpandDialog f37669k;

    /* renamed from: a, reason: collision with root package name */
    protected String f37659a = "SplashSignalCommunicationImpl";

    /* renamed from: h, reason: collision with root package name */
    private int f37666h = 5;

    /* renamed from: com.mbridge.msdk.splash.signal.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0546a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f37670a;

        RunnableC0546a(ArrayList arrayList) {
            this.f37670a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a11 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                Iterator it = this.f37670a.iterator();
                while (it.hasNext()) {
                    a11.b((String) it.next());
                }
            } catch (Exception unused) {
                o0.b(a.this.f37659a, "campain can't insert db");
            }
        }
    }

    public a(Context context, String str, String str2) {
        this.f37663e = str;
        this.f37662d = str2;
        this.f37660b = new WeakReference<>(context);
    }

    public com.mbridge.msdk.splash.middle.a a() {
        return this.f37668j;
    }

    public void a(int i11) {
        this.f37665g = i11;
    }

    public void a(Context context) {
        this.f37660b = new WeakReference<>(context);
    }

    public void a(com.mbridge.msdk.splash.middle.a aVar) {
        if (aVar != null) {
            this.f37668j = aVar;
        }
    }

    public void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i11 = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
            if (aVar != null) {
                aVar.a(i11);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void a(List<CampaignEx> list) {
        this.f37661c = list;
    }

    public List<CampaignEx> b() {
        return this.f37661c;
    }

    public void b(int i11) {
        this.f37666h = i11;
    }

    public void c(int i11) {
        this.f37667i = i11;
    }

    public void c(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                f.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b);
            }
        } catch (Throwable th2) {
            o0.b(this.f37659a, "onJSBridgeConnect", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        o0.b(this.f37659a, "close");
        try {
            com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
            if (aVar != null) {
                aVar.close();
            }
        } catch (Throwable th2) {
            o0.b(this.f37659a, "close", th2);
        }
    }

    public void d(Object obj, String str) {
        o0.a(this.f37659a, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string = jSONArray.getString(i11);
                for (CampaignEx campaignEx : this.f37661c) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.f37662d, campaignEx, "splash");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new RunnableC0546a(arrayList)).start();
        } catch (Throwable th2) {
            o0.b(this.f37659a, "sendImpressions", th2);
        }
    }

    public void e(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.f37667i);
            jSONObject.put("data", jSONObject2);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            o0.b(this.f37659a, e11.getMessage());
        }
        com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z10) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z10);
            WeakReference<Context> weakReference = this.f37660b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            SplashExpandDialog splashExpandDialog = this.f37669k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                SplashExpandDialog splashExpandDialog2 = new SplashExpandDialog(this.f37660b.get(), bundle, this.f37668j);
                this.f37669k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.f37662d, this.f37661c);
                this.f37669k.show();
                com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.splash.report.a.a(this.f37662d, getMraidCampaign(), str);
            }
        } catch (Throwable th2) {
            o0.b(this.f37659a, "expand", th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.lang.Object r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L2c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L22
            r0.<init>(r4)     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = "countdown"
            int r4 = r0.optInt(r4)     // Catch: java.lang.Exception -> L22
            com.mbridge.msdk.mbsignalcommon.windvane.f r0 = com.mbridge.msdk.mbsignalcommon.windvane.f.a()     // Catch: java.lang.Exception -> L1f
            java.lang.String r1 = com.mbridge.msdk.splash.signal.c.a(r1)     // Catch: java.lang.Exception -> L1f
            r0.b(r3, r1)     // Catch: java.lang.Exception -> L1f
            r1 = r4
            goto L2c
        L1f:
            r3 = move-exception
            r1 = r4
            goto L23
        L22:
            r3 = move-exception
        L23:
            java.lang.String r4 = r2.f37659a
            java.lang.String r3 = r3.getMessage()
            com.mbridge.msdk.foundation.tools.o0.b(r4, r3)
        L2c:
            com.mbridge.msdk.splash.middle.a r3 = r2.f37668j
            if (r3 == 0) goto L34
            r4 = 2
            r3.a(r4, r1)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.signal.a.f(java.lang.Object, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f37661c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f37661c.get(0);
    }

    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.splash.common.b bVar = new com.mbridge.msdk.splash.common.b(com.mbridge.msdk.foundation.controller.c.m().d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f37664f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.b());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f37661c));
            l e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37662d);
            if (e11 == null) {
                e11 = l.i(this.f37662d);
            }
            if (!TextUtils.isEmpty(this.f37663e)) {
                e11.d(this.f37663e);
            }
            e11.e(this.f37662d);
            e11.j(this.f37666h);
            e11.a(this.f37665g);
            jSONObject.put("unitSetting", e11.M());
            String e12 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e12)) {
                jSONObject.put("appSetting", new JSONObject(e12));
            }
            jSONObject.put("sdk_info", d.f36485a);
            o0.b(this.f37659a, "init" + jSONObject.toString());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th2) {
            o0.b(this.f37659a, "init", th2);
        }
    }

    public void install(Object obj, String str) {
        o0.b(this.f37659a, "install");
        try {
            List<CampaignEx> list = this.f37661c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = list.size() > 0 ? this.f37661c.get(0) : null;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
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
            com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            o0.b(this.f37659a, "click", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o0.b(this.f37659a, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
            return;
        }
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d11 == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b) != null) {
                    d11 = windVaneWebView.getContext();
                }
            } catch (Exception e11) {
                o0.b(this.f37659a, e11.getMessage());
            }
        }
        if (d11 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
            if (optInt == 1) {
                com.mbridge.msdk.click.c.c(d11, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.e(d11, optString);
            }
        } catch (JSONException e12) {
            o0.b(this.f37659a, e12.getMessage());
        } catch (Throwable th2) {
            o0.b(this.f37659a, th2.getMessage());
        }
    }

    public void reportUrls(Object obj, String str) {
        o0.a(this.f37659a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.d.a(obj, "params is null");
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
                    List<CampaignEx> list = this.f37661c;
                    com.mbridge.msdk.click.a.a(d11, list != null ? list.get(0) : null, "", a11, false, optInt != 0);
                } else {
                    Context d12 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.f37661c;
                    com.mbridge.msdk.click.a.a(d12, list2 != null ? list2.get(0) : null, "", a11, false, optInt != 0, optInt2);
                }
            }
            f.a().b(obj, c.a(0));
        } catch (Throwable th2) {
            o0.b(this.f37659a, "reportUrls", th2);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
            if (aVar != null) {
                aVar.toggleCloseBtn(optInt);
            }
        } catch (Throwable th2) {
            o0.b(this.f37659a, "toggleCloseBtn", th2);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
        if (aVar != null) {
            aVar.triggerCloseBtn(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z10) {
        int i11 = z10 ? 2 : 1;
        try {
            com.mbridge.msdk.splash.middle.a aVar = this.f37668j;
            if (aVar != null) {
                aVar.toggleCloseBtn(i11);
            }
        } catch (Throwable th2) {
            o0.b(this.f37659a, "useCustomClose", th2);
        }
    }
}
