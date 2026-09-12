package com.mbridge.msdk.mbbanner.common.communication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.setting.h;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b extends c {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f36084b;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f36085c;

    /* renamed from: d, reason: collision with root package name */
    private String f36086d;

    /* renamed from: e, reason: collision with root package name */
    private String f36087e;

    /* renamed from: f, reason: collision with root package name */
    private int f36088f;

    /* renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.listener.a f36089g;

    /* renamed from: h, reason: collision with root package name */
    private BannerExpandDialog f36090h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36091i = false;

    /* loaded from: classes5.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f36092a;

        a(ArrayList arrayList) {
            this.f36092a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a11 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                Iterator it = this.f36092a.iterator();
                while (it.hasNext()) {
                    a11.b((String) it.next());
                }
            } catch (Exception e11) {
                o0.b("BannerSignalCommunicationImpl", e11.getMessage());
            }
        }
    }

    public b(Context context, String str, String str2) {
        this.f36086d = str;
        this.f36087e = str2;
        this.f36084b = new WeakReference<>(context);
    }

    public static void a(Object obj, JSONObject jSONObject) {
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
                o0.a("BannerSignalCommunicationImpl", e11.getMessage());
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
                                    jSONObject5.put("path", H5DownLoadManager.getInstance().getResAddress(optString) == null ? "" : H5DownLoadManager.getInstance().getH5ResAddress(optString));
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
                                        o0.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + optString);
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
                                    o0.a("BannerSignalCommunicationImpl", "VideoBean not null");
                                    jSONObject8.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                                    str3 = str6;
                                    try {
                                        jSONObject8.put("videoDataLength", b11.d());
                                        String e12 = b11.e();
                                        str4 = str7;
                                        if (TextUtils.isEmpty(e12)) {
                                            try {
                                                o0.a("BannerSignalCommunicationImpl", "VideoPath null");
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
                                                    o0.a("BannerSignalCommunicationImpl", e13.getMessage());
                                                    return;
                                                }
                                            }
                                        } else {
                                            o0.a("BannerSignalCommunicationImpl", "VideoPath not null");
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
                                    o0.a("BannerSignalCommunicationImpl", "VideoBean null");
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
                    o0.a("BannerSignalCommunicationImpl", e.getMessage());
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

    public void a() {
        if (this.f36089g != null) {
            this.f36089g = null;
        }
        if (this.f36090h != null) {
            this.f36090h = null;
        }
    }

    public void a(int i11) {
        this.f36088f = i11;
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.a aVar) {
        if (aVar != null) {
            this.f36089g = aVar;
        }
    }

    public void a(List<CampaignEx> list) {
        this.f36085c = list;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void click(Object obj, String str) {
        o0.b("BannerSignalCommunicationImpl", "click");
        try {
            List<CampaignEx> list = this.f36085c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = list.size() > 0 ? this.f36085c.get(0) : null;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
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
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "click", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        o0.b("BannerSignalCommunicationImpl", "close");
        try {
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.close();
            }
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "close", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void d(Object obj, String str) {
        o0.a("BannerSignalCommunicationImpl", "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string = jSONArray.getString(i11);
                for (CampaignEx campaignEx : this.f36085c) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.f36087e, campaignEx, "banner");
                        arrayList.add(string);
                    }
                }
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(arrayList));
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "sendImpressions", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z10) {
        Context context;
        try {
            String str2 = "";
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().getBannerHtml())) {
                    str2 = getMraidCampaign().getBannerUrl();
                } else {
                    str2 = "file:////" + getMraidCampaign().getBannerHtml();
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            bundle.putString("url", str2);
            bundle.putBoolean("shouldUseCustomClose", z10);
            WeakReference<Context> weakReference = this.f36084b;
            if (weakReference != null && (context = weakReference.get()) != null) {
                BannerExpandDialog bannerExpandDialog = this.f36090h;
                if (bannerExpandDialog != null && bannerExpandDialog.isShowing()) {
                    return;
                }
                BannerExpandDialog bannerExpandDialog2 = new BannerExpandDialog(context, bundle, this.f36089g);
                this.f36090h = bannerExpandDialog2;
                bannerExpandDialog2.setCampaignList(this.f36087e, this.f36085c);
                this.f36090h.show();
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.a(true);
            }
            com.mbridge.msdk.mbbanner.common.report.a.a(this.f36087e, getMraidCampaign(), str);
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "expand", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th2) {
            o0.a("BannerSignalCommunicationImpl", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f36085c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f36085c.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void init(Object obj, String str) {
        o0.b("BannerSignalCommunicationImpl", "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            s sVar = new s(com.mbridge.msdk.foundation.controller.c.m().d());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f36088f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", sVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f36085c));
            com.mbridge.msdk.setting.l e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.f36087e);
            if (e11 == null) {
                e11 = com.mbridge.msdk.setting.l.i(this.f36087e);
            }
            if (!TextUtils.isEmpty(this.f36086d)) {
                e11.d(this.f36086d);
            }
            jSONObject.put("unitSetting", e11.M());
            String e12 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b());
            if (!TextUtils.isEmpty(e12)) {
                jSONObject.put("appSetting", new JSONObject(e12));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f36485a);
            o0.b("BannerSignalCommunicationImpl", "init" + jSONObject.toString());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "init", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        o0.b("BannerSignalCommunicationImpl", MRAIDPresenter.OPEN);
        try {
            o0.b("BannerSignalCommunicationImpl", str);
            if (this.f36085c.size() > 1) {
                com.mbridge.msdk.foundation.controller.c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", MRAIDPresenter.OPEN, th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                f.a().b(obj, d.a(0));
                com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
                if (aVar != null) {
                    aVar.readyStatus(optInt);
                }
            } catch (Throwable th2) {
                o0.b("BannerSignalCommunicationImpl", "readyStatus", th2);
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void reportUrls(Object obj, String str) {
        o0.a("BannerSignalCommunicationImpl", "reportUrls:" + str);
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
                    List<CampaignEx> list = this.f36085c;
                    com.mbridge.msdk.click.a.a(d11, list != null ? list.get(0) : null, "", a11, false, optInt != 0);
                } else {
                    Context d12 = com.mbridge.msdk.foundation.controller.c.m().d();
                    List<CampaignEx> list2 = this.f36085c;
                    com.mbridge.msdk.click.a.a(d12, list2 != null ? list2.get(0) : null, "", a11, false, optInt != 0, optInt2);
                }
            }
            f.a().b(obj, d.a(0));
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "reportUrls", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void toggleCloseBtn(Object obj, String str) {
        o0.b("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.toggleCloseBtn(optInt);
            }
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "toggleCloseBtn", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void triggerCloseBtn(Object obj, String str) {
        o0.b("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String optString = new JSONObject(str).optString("state");
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.triggerCloseBtn(optString);
            }
            f.a().b(obj, d.a(0));
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "triggerCloseBtn", th2);
            f.a().b(obj, d.a(-1));
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
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36089g;
            if (aVar != null) {
                aVar.toggleCloseBtn(i11);
            }
        } catch (Throwable th2) {
            o0.b("BannerSignalCommunicationImpl", "useCustomClose", th2);
        }
    }
}
