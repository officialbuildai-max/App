package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.tools.k0;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class d implements com.mbridge.msdk.tracker.d {
    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    private static StringBuilder a(List<com.mbridge.msdk.tracker.i> list) {
        com.mbridge.msdk.tracker.e a11;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.tracker.i iVar = list.get(i11);
            if (iVar != null && (a11 = iVar.a()) != null) {
                JSONObject d11 = a11.d();
                c.a(d11);
                if (d11 == null) {
                    d11 = new JSONObject();
                }
                try {
                    try {
                        d11.put("ts", a11.g());
                        d11.put("rts", System.currentTimeMillis());
                        String d12 = iVar.d();
                        if (!TextUtils.isEmpty(d12)) {
                            d11.put("reason_lib", d12);
                        }
                        int c11 = iVar.c() - 1;
                        if (c11 >= 1) {
                            d11.put("retryed", c11);
                        }
                        long a12 = a11.a();
                        if (a12 > 0) {
                            d11.put("duration", a12);
                        }
                    } catch (Exception e11) {
                        if (com.mbridge.msdk.tracker.a.f38550a) {
                            Log.e("TrackManager", "decorateRequestParams: ", e11);
                        }
                    }
                    sb2.append(b(d11));
                    if (i11 < list.size() - 1) {
                        sb2.append("\n");
                    }
                } catch (Throwable th2) {
                    sb2.append(b(d11));
                    throw th2;
                }
            }
        }
        return sb2;
    }

    static Map<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, StringBuilder sb2) {
    }

    static String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        int i11 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            i11++;
            if (i11 <= jSONObject.length() - 1) {
                sb2.append(next);
                sb2.append(UrlUtils.EQUAL_MARK);
                sb2.append(a(String.valueOf(jSONObject.opt(next))));
                sb2.append(UrlUtils.AND_MARK);
            } else {
                sb2.append(next);
                sb2.append(UrlUtils.EQUAL_MARK);
                sb2.append(a(String.valueOf(jSONObject.opt(next))));
            }
        }
        return sb2.toString();
    }

    @Override // com.mbridge.msdk.tracker.d
    public Map<String, String> a(com.mbridge.msdk.tracker.m mVar, List<com.mbridge.msdk.tracker.i> list, JSONObject jSONObject) {
        StringBuilder sb2;
        Map<String, String> map;
        if (list != null && !list.isEmpty()) {
            try {
                c.a(jSONObject);
                map = a(jSONObject);
                if (map == null) {
                    try {
                        map = new HashMap();
                    } catch (Exception unused) {
                        sb2 = null;
                        a(map, sb2);
                        return null;
                    } catch (Throwable unused2) {
                        sb2 = null;
                        a(map, sb2);
                        return null;
                    }
                }
                sb2 = a(list);
            } catch (Exception unused3) {
                sb2 = null;
                map = null;
            } catch (Throwable unused4) {
                sb2 = null;
                map = null;
            }
            try {
                map.put("tun", String.valueOf(k0.z()));
                map.put("data", sb2.toString());
                return map;
            } catch (Exception unused5) {
                a(map, sb2);
                return null;
            } catch (Throwable unused6) {
                a(map, sb2);
                return null;
            }
        }
        return null;
    }
}
