package com.mbridge.msdk.interstitial.signalcommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class interstitial extends AbsFeedBackForH5 {

    /* renamed from: h, reason: collision with root package name */
    private static final String f35997h = "com.mbridge.msdk.interstitial.signalcommon.interstitial";

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f35998i = 0;

    /* renamed from: g, reason: collision with root package name */
    private Object f35999g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f36000a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f36001b;

        a(List list, String str) {
            this.f36000a = list;
            this.f36001b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.interstitial.cache.a a11 = com.mbridge.msdk.interstitial.cache.a.a();
            if (a11 != null) {
                a11.a(this.f36000a, this.f36001b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f36003a;

        b(List list) {
            this.f36003a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i11 = 0; i11 < this.f36003a.size(); i11++) {
                CampaignEx campaignEx = (CampaignEx) this.f36003a.get(i11);
                if (campaignEx != null) {
                    j.a(g.a(((com.mbridge.msdk.mbsignalcommon.windvane.g) interstitial.this).f36618a)).b(campaignEx.getId());
                }
            }
        }
    }

    private int a(Context context) {
        return (context == null || !(context instanceof MBInterstitialActivity)) ? -1 : 1;
    }

    private String a() {
        Context context;
        String str = null;
        try {
            context = this.f36618a;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (context == null) {
            return null;
        }
        if (a(context) == 1) {
            try {
                Context context2 = this.f36618a;
                if (context2 != null && (context2 instanceof MBInterstitialActivity)) {
                    str = ((MBInterstitialActivity) context2).mUnitid;
                    return str;
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        return str;
    }

    private String a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray parseCamplistToJson = CampaignEx.parseCamplistToJson(list);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("campaignList", parseCamplistToJson);
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        return Base64.encodeToString(jSONObject2.getBytes(), 2);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    private List<CampaignEx> a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && com.mbridge.msdk.interstitial.cache.a.a() != null) {
                return com.mbridge.msdk.interstitial.cache.a.a().a(str, 1);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    private void a(Object obj, String str) {
        try {
            b();
            d();
            Context context = this.f36618a;
            if (context == null) {
                c();
                return;
            }
            if (a(context) != 1) {
                c();
                return;
            }
            Context context2 = this.f36618a;
            if (context2 instanceof MBInterstitialActivity) {
                ((MBInterstitialActivity) context2).mIsMBPage = true;
            }
            String a11 = a();
            if (TextUtils.isEmpty(a11)) {
                c();
                return;
            }
            List<CampaignEx> a12 = a(a11);
            if (a12 == null) {
                c();
                return;
            }
            String a13 = a(a12);
            if (TextUtils.isEmpty(a13)) {
                c();
                return;
            }
            f.a().b(obj, a13);
            a(a11, a12);
            b(a11, a12);
            a(a12, a11);
        } catch (Exception e11) {
            e11.printStackTrace();
            c();
        }
    }

    private void a(String str, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    CampaignEx campaignEx = list.get(i11);
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(str, campaignEx, com.vungle.ads.internal.b.PLACEMENT_TYPE_INTERSTITIAL);
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(List<CampaignEx> list, String str) {
        try {
            new Thread(new a(list, str)).start();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void b() {
        try {
            Context context = this.f36618a;
            if (context == null) {
                return;
            }
            if (a(context) == 1) {
                try {
                    MBInterstitialActivity mBInterstitialActivity = (MBInterstitialActivity) this.f36618a;
                    if (mBInterstitialActivity != null) {
                        mBInterstitialActivity.hideLoading();
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    private void b(String str, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                new Thread(new b(list)).start();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void c() {
        try {
            f.a().b(this.f35999g, "");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void d() {
        MBInterstitialActivity mBInterstitialActivity;
        try {
            Context context = this.f36618a;
            if (context == null || a(context) != 1 || (mBInterstitialActivity = (MBInterstitialActivity) this.f36618a) == null) {
                return;
            }
            mBInterstitialActivity.showWebView();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public List<String> getExcludeIdList(String str) {
        Exception e11;
        ArrayList arrayList;
        try {
        } catch (Exception e12) {
            e11 = e12;
            arrayList = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String optString = new JSONObject(str).optString(e.f35555h);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(optString);
        if (jSONArray.length() <= 0) {
            return null;
        }
        arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                if (!TextUtils.isEmpty(jSONArray.optString(i11))) {
                    arrayList.add(jSONArray.optString(i11));
                }
            } catch (Exception e13) {
                e11 = e13;
                e11.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public void getInfo(Object obj, String str) {
        try {
            this.f35999g = obj;
            Context context = this.f36618a;
            if (context == null) {
                c();
                return;
            }
            int a11 = a(context);
            if (TextUtils.isEmpty(a())) {
                c();
            } else if (a11 == 1) {
                a(obj, str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            c();
        }
    }

    public void install(Object obj, String str) {
        try {
            Context context = this.f36618a;
            if (context != null && (context instanceof MBInterstitialActivity)) {
                ((MBInterstitialActivity) context).clickTracking();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void openURL(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
            if (optInt == 1) {
                c.c(this.f36618a, optString);
            } else if (optInt == 2) {
                c.e(this.f36618a, optString);
            }
        } catch (JSONException e11) {
            o0.b(f35997h, e11.getMessage());
        } catch (Throwable th2) {
            o0.b(f35997h, th2.getMessage());
        }
    }
}
