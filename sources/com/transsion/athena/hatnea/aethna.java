package com.transsion.athena.hatnea;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.integration.net.UrlKt;
import com.meituan.android.walle.ChannelReader;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class aethna extends anateh {

    /* renamed from: c, reason: collision with root package name */
    private final String f42814c;

    public aethna(Handler handler, String str) {
        super(handler);
        this.f42814c = str;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        byte[] bArr;
        Context J = AthenaAnalytics.J();
        boolean b11 = com.transsion.athena.taaneh.anehat.b(J);
        String a11 = com.transsion.athena.config.data.model.anehat.a(this.f42814c.getBytes(StandardCharsets.UTF_8));
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject put = new JSONObject().put(SafeStringUtils.SP_APPID, 9999).put("hostid", 9999).put(PushConstants.PROVIDER_FIELD_PKG, "").put("vn", "").put("vc", "").put("ins", "").put("sdkv", "3.1.1.4").put("isfl", b11).put("cnt", 1).put("events", new JSONArray().put(new JSONObject(this.f42814c)));
            try {
                PackageManager packageManager = J.getPackageManager();
                String packageName = J.getPackageName();
                JSONObject put2 = put.put(PushConstants.PROVIDER_FIELD_PKG, packageName == null ? "" : packageName);
                String installerPackageName = packageManager.getInstallerPackageName(packageName);
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                put2.put("ins", installerPackageName);
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "";
                    }
                    JSONObject put3 = put.put("vn", str);
                    String valueOf = String.valueOf(packageInfo.versionCode);
                    if (valueOf == null) {
                        valueOf = "";
                    }
                    put3.put("vc", valueOf);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            jSONArray.put(put);
        } catch (Exception e12) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e12));
        }
        String a12 = com.transsion.athena.taaneh.athena.a(J, 0);
        try {
            JSONObject jSONObject = new JSONObject();
            String g11 = com.transsion.athena.config.data.model.ehanat.g();
            if (g11 == null) {
                g11 = "";
            }
            JSONObject put4 = jSONObject.put(ChannelReader.CHANNEL_KEY, g11);
            String b12 = com.transsion.athena.taaneh.anehat.b(J, "opid");
            if (b12 == null) {
                b12 = "";
            }
            JSONObject put5 = put4.put("opid", b12);
            String b13 = com.transsion.athena.taaneh.anehat.b(J, "oneid");
            if (b13 == null) {
                b13 = "";
            }
            JSONObject put6 = put5.put("tsid", b13);
            String a13 = com.transsion.athena.taaneh.ehatna.a();
            if (a13 == null) {
                a13 = "";
            }
            JSONObject put7 = put6.put(PushConstants.PROVIDER_VAID, a13);
            JSONObject jSONObject2 = new JSONObject();
            String b14 = com.transsion.athena.taaneh.athena.b();
            if (b14 == null) {
                b14 = "";
            }
            JSONObject put8 = jSONObject2.put("tz", b14);
            String a14 = com.transsion.athena.taaneh.anehat.a();
            if (a14 == null) {
                a14 = "";
            }
            JSONObject put9 = put8.put(UrlKt.KEY_MINI_GAID, a14);
            String b15 = com.transsion.athena.config.data.model.ehanat.b();
            if (b15 == null) {
                b15 = "";
            }
            JSONObject put10 = put9.put("tuid", b15).put("actype", (int) com.transsion.athena.config.data.model.ehanat.c());
            String a15 = com.transsion.athena.taaneh.hatnea.a();
            if (a15 == null) {
                a15 = "";
            }
            JSONObject put11 = put10.put("osver", a15);
            String str2 = Build.VERSION.RELEASE;
            if (str2 == null) {
                str2 = "";
            }
            JSONObject put12 = put11.put("aver", str2);
            String str3 = Build.DISPLAY;
            if (str3 == null) {
                str3 = "";
            }
            JSONObject put13 = put12.put("build", str3);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = "";
            }
            JSONObject put14 = put13.put("lang", language);
            String str4 = Build.BRAND;
            if (str4 == null) {
                str4 = "";
            }
            JSONObject put15 = put14.put("brand", str4);
            String str5 = Build.MODEL;
            if (str5 == null) {
                str5 = "";
            }
            JSONObject put16 = put15.put("model", str5).put("net", com.transsion.athena.taaneh.aatnhe.b(J)).put("uts", System.currentTimeMillis()).put("try", 0);
            String f11 = com.transsion.athena.taaneh.athena.f(J);
            if (f11 == null) {
                f11 = "";
            }
            JSONObject put17 = put16.put("mcc", f11);
            String g12 = com.transsion.athena.taaneh.athena.g(J);
            if (g12 == null) {
                g12 = "";
            }
            JSONObject put18 = put17.put("mnc", g12).put("ekey", put7.toString()).put("appids", jSONArray);
            JSONObject h11 = com.transsion.athena.config.data.model.ehanat.h();
            if (h11 != null && h11.length() > 0) {
                int length = h11.toString().getBytes(StandardCharsets.UTF_8).length;
                if (length > 2000) {
                    String format = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                    com.transsion.athena.taaneh.aethna.b(format);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errorMsg", format);
                    put7.put("cparam", jSONObject3.toString());
                } else {
                    put7.put("cparam", h11.toString());
                }
            }
            if (com.transsion.athena.config.data.model.ehanat.C) {
                put18.put("iid", a12 == null ? "" : a12);
            }
            bArr = put18.toString().getBytes(StandardCharsets.UTF_8);
        } catch (Exception e13) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e13));
            bArr = null;
        }
        if (TextUtils.isEmpty(a12)) {
            a12 = com.transsion.athena.taaneh.anehat.a();
        }
        if (TextUtils.isEmpty(a12)) {
            a12 = com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J());
        }
        ehanat<aatnhe> a16 = anehat.a(TextUtils.isEmpty(null) ? GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.o(), true) : GslbSdk.getDomain(com.transsion.athena.config.data.model.ehanat.b((String) null), true), bArr, 1, Collections.singletonList(9999), a11, a12 + "_" + com.transsion.athena.data.athena.b());
        if (a16.f42830a == 0) {
            k4.a.a(J).g("gdpr_close", "");
        } else {
            com.transsion.athena.taaneh.aethna.b("PostGdprEventTask requestByPost error : %s", a16.f42831b.f42810d);
        }
        if (b11) {
            k4.a.a(J).g("first_launch", "false");
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "GDPR";
    }
}
