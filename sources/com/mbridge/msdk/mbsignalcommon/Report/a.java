package com.mbridge.msdk.mbsignalcommon.Report;

import android.content.Context;
import android.util.Base64;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f36474c = "a";

    /* renamed from: a, reason: collision with root package name */
    int f36475a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f36476b = 1;

    /* renamed from: com.mbridge.msdk.mbsignalcommon.Report.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C0514a {

        /* renamed from: a, reason: collision with root package name */
        private static a f36477a = new a();
    }

    public static a a() {
        return C0514a.f36477a;
    }

    public void a(int i11, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i11);
            jSONObject.put("message", str);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e11) {
            o0.a(f36474c, e11.getMessage());
        } catch (Throwable th2) {
            o0.a(f36474c, th2.getMessage());
        }
    }

    public void a(Object obj, String str, JSONArray jSONArray, int i11) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        JSONObject optJSONObject10;
        JSONObject optJSONObject11;
        int i12;
        try {
            if (jSONArray == null) {
                a(this.f36476b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                a(this.f36476b, "called reporter failed, params empty", obj);
                return;
            }
            int i13 = 0;
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    i12 = length - 1;
                    if (i13 >= i12) {
                        break;
                    }
                    JSONObject optJSONObject12 = jSONArray.optJSONObject(i13);
                    if (optJSONObject12 != null) {
                        stringBuffer.append(optJSONObject12.optString("key"));
                        stringBuffer.append(UrlUtils.EQUAL_MARK);
                        stringBuffer.append(optJSONObject12.opt(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                        stringBuffer.append(UrlUtils.AND_MARK);
                    }
                    i13++;
                }
                JSONObject optJSONObject13 = jSONArray.optJSONObject(i12);
                if (optJSONObject13 != null) {
                    stringBuffer.append(optJSONObject13.optString("key"));
                    stringBuffer.append(UrlUtils.EQUAL_MARK);
                    stringBuffer.append(optJSONObject13.opt(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                }
                a(stringBuffer.toString());
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String str2 = "";
                String string = (length <= 0 || (optJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : optJSONObject11.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i14 = (length <= 1 || (optJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : optJSONObject10.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i15 = (length <= 2 || (optJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : optJSONObject9.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i16 = (length <= 3 || (optJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : optJSONObject8.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i17 = (length <= 4 || (optJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : optJSONObject7.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string2 = (length <= 5 || (optJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : optJSONObject6.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string3 = (length <= 6 || (optJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : optJSONObject5.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i18 = (length <= 7 || (optJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : optJSONObject4.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                String string4 = (length <= 8 || (optJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : optJSONObject3.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                int i19 = (length <= 9 || (optJSONObject2 = jSONArray.optJSONObject(9)) == null) ? -1 : optJSONObject2.getInt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                if (length > 10 && (optJSONObject = jSONArray.optJSONObject(10)) != null) {
                    str2 = optJSONObject.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                }
                a(string, i14, i15, i16, i17, string2, string3, i18, string4, i19, str2);
            }
            a(this.f36475a, "called reporter success", obj);
        } catch (Throwable th2) {
            o0.a(f36474c, th2.getMessage());
            a(this.f36476b, "exception: " + th2.getMessage(), obj);
        }
    }

    public void a(String str) {
        d.b().d(str);
    }

    public void a(String str, int i11, int i12, int i13, int i14, String str2, String str3, int i15, String str4, int i16, String str5) {
        try {
            Context d11 = c.m().d();
            if (d11 != null) {
                n.a(g.a(d11)).a(new m(str, i11, i12, i13, i14, str2, str3, i15, str4, i16, str5));
            }
        } catch (Throwable th2) {
            o0.a(f36474c, th2.getMessage());
        }
    }
}
