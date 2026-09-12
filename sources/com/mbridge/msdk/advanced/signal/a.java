package com.mbridge.msdk.advanced.signal;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f34283a = "NativeAdvancedJsUtils";

    public static void a(WebView webView) {
        o0.b(f34283a, "fireOnJSBridgeConnected");
        f.a().a(webView);
    }

    public static void a(WebView webView, String str, String str2) {
        f.a().a(webView, str, str2);
    }

    public static void a(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sq", 1);
            jSONObject.put(EventConstants.KEY_ACTION, str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            f.a().a(webView, "thirdPartyCalled", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e11) {
            o0.b(f34283a, e11.getMessage());
        }
    }

    public static void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", d.f36550b);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            o0.a(f34283a, e11.getMessage());
        }
    }

    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        JSONArray jSONArray;
        String str2;
        String str3;
        JSONArray jSONArray2;
        int i11;
        boolean z10;
        String str4;
        File file;
        String str5 = "";
        JSONObject jSONObject2 = new JSONObject();
        String str6 = "message";
        int i12 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e11) {
                o0.a(f34283a, e11.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            jSONArray = jSONObject.getJSONArray("resource");
        } catch (Throwable th2) {
            th = th2;
            str = "message";
        }
        try {
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        int length = jSONArray.length();
                        int i13 = 0;
                        while (i13 < length) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i13);
                            String optString = jSONObject3.optString("ref", str5);
                            int i14 = jSONObject3.getInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                            JSONObject jSONObject4 = new JSONObject();
                            if (i14 != i12 || TextUtils.isEmpty(optString)) {
                                str3 = str5;
                                str2 = str6;
                                jSONArray2 = jSONArray;
                                i11 = length;
                                z10 = false;
                                if (i14 == 2 && !TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                                    jSONObject5.put("path", H5DownLoadManager.getInstance().getH5ResAddress(optString) == null ? str3 : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                                    jSONObject4.put(optString, jSONObject5);
                                    jSONArray3.put(jSONObject4);
                                } else if (i14 == 3 && !TextUtils.isEmpty(optString)) {
                                    try {
                                        file = new File(optString);
                                    } catch (Throwable th3) {
                                        o0.b(f34283a, th3.getMessage());
                                    }
                                    if (file.exists() && file.isFile() && file.canRead()) {
                                        o0.a(f34283a, "getFileInfo Mraid file " + optString);
                                        str4 = "file:////" + optString;
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                                        jSONObject6.put("path", str4);
                                        jSONObject4.put(optString, jSONObject6);
                                        jSONArray3.put(jSONObject4);
                                    }
                                    str4 = str3;
                                    JSONObject jSONObject62 = new JSONObject();
                                    jSONObject62.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                                    jSONObject62.put("path", str4);
                                    jSONObject4.put(optString, jSONObject62);
                                    jSONArray3.put(jSONObject4);
                                } else if (i14 == 4 && !TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject7 = new JSONObject();
                                    jSONObject7.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 4);
                                    jSONObject7.put("path", s0.a(optString) == null ? str3 : s0.a(optString));
                                    jSONObject4.put(optString, jSONObject7);
                                    jSONArray3.put(jSONObject4);
                                }
                            } else {
                                JSONObject jSONObject8 = new JSONObject();
                                l b11 = m.a(g.a(c.m().d())).b(optString);
                                if (b11 != null) {
                                    jSONArray2 = jSONArray;
                                    i11 = length;
                                    o0.a(f34283a, "VideoBean not null");
                                    jSONObject8.put(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                                    jSONObject8.put("videoDataLength", b11.d());
                                    String e12 = b11.e();
                                    str2 = str6;
                                    if (TextUtils.isEmpty(e12)) {
                                        o0.a(f34283a, "VideoPath null");
                                        jSONObject8.put("path", str5);
                                        jSONObject8.put("path4Web", str5);
                                        str3 = str5;
                                    } else {
                                        str3 = str5;
                                        o0.a(f34283a, "VideoPath not null");
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
                                    jSONArray3.put(jSONObject4);
                                } else {
                                    str3 = str5;
                                    str2 = str6;
                                    jSONArray2 = jSONArray;
                                    i11 = length;
                                    z10 = false;
                                    o0.a(f34283a, "VideoBean null");
                                }
                            }
                            i13++;
                            jSONArray = jSONArray2;
                            length = i11;
                            str6 = str2;
                            str5 = str3;
                            i12 = 1;
                        }
                        jSONObject2.put("resource", jSONArray3);
                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str2 = str6;
                    str = str2;
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject2.put(str, th.getLocalizedMessage());
                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (JSONException e13) {
                        o0.a(f34283a, e13.getMessage());
                        return;
                    }
                }
            }
            str = 1;
            try {
                try {
                    jSONObject2.put("code", 1);
                    str = "message";
                    try {
                        jSONObject2.put(str, "resource is null");
                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (JSONException e14) {
                        e = e14;
                        o0.a(f34283a, e.getMessage());
                    }
                } catch (Throwable th5) {
                    th = th5;
                    jSONObject2.put("code", 1);
                    jSONObject2.put(str, th.getLocalizedMessage());
                    f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                }
            } catch (JSONException e15) {
                e = e15;
                str = "message";
            }
        } catch (Throwable th6) {
            th = th6;
            str = str2;
            jSONObject2.put("code", 1);
            jSONObject2.put(str, th.getLocalizedMessage());
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        }
    }
}
