package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.a.a.a;
import com.bykv.vk.openvk.preload.geckox.b;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.File;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static File f20731a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f20732b;

    /* renamed from: c, reason: collision with root package name */
    private static String f20733c;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f20734g = new HashSet(Arrays.asList("js", "css", "html", "ico", "jpeg", "jpg", "png", "gif", "woff", "svg", "ttf", "woff2", "webp", "otf", "sfnt"));

    /* renamed from: d, reason: collision with root package name */
    private Map.Entry<String, JSONObject> f20735d;

    /* renamed from: e, reason: collision with root package name */
    private Map.Entry<String, JSONObject> f20736e;

    /* renamed from: f, reason: collision with root package name */
    private INetWork f20737f;

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static c f20738a = new c(0);
    }

    private c() {
    }

    /* synthetic */ c(byte b11) {
        this();
    }

    public static int a(ILoader iLoader, String str) {
        if (iLoader == null || str == null) {
            return 0;
        }
        try {
            return new com.bykv.vk.openvk.preload.falconx.loader.a(f20732b, "f36c832c8dbb162c49b46a7a6dd47fbd", f20731a).a(str + File.separator);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static c a() {
        return a.f20738a;
    }

    public static c a(Context context) {
        f20732b = context;
        if (f20731a == null) {
            f20731a = new File(f20732b.getCacheDir() + File.separator + "gecko");
        }
        return a.f20738a;
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject(str).getString("md5");
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONObject a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Map.Entry<String, JSONObject> entry = this.f20735d;
                if (entry == null || !str.equals(entry.getKey())) {
                    String a11 = com.bykv.vk.openvk.preload.geckox.utils.b.a(new com.bykv.vk.openvk.preload.falconx.loader.a(f20732b, "f36c832c8dbb162c49b46a7a6dd47fbd", f20731a).getInputStream(str + "/manifest.json"));
                    if (TextUtils.isEmpty(a11)) {
                        return null;
                    }
                    this.f20735d = new AbstractMap.SimpleEntry(str, new JSONObject(a11));
                }
                Map.Entry<String, JSONObject> entry2 = this.f20736e;
                if (entry2 == null || !str.equals(entry2.getKey())) {
                    String a12 = com.bykv.vk.openvk.preload.geckox.utils.b.a(new com.bykv.vk.openvk.preload.falconx.loader.a(f20732b, "f36c832c8dbb162c49b46a7a6dd47fbd", f20731a).getInputStream(str + "/md5_url_map.json"));
                    if (TextUtils.isEmpty(a12)) {
                        return null;
                    }
                    this.f20736e = new AbstractMap.SimpleEntry(str, new JSONObject(a12));
                }
                JSONObject value = this.f20735d.getValue();
                JSONObject value2 = this.f20736e.getValue();
                String a13 = a(str2, value2);
                if (value.has(a13)) {
                    JSONObject jSONObject = value.getJSONObject(a13);
                    a(value, a13, str2);
                    return jSONObject;
                }
                String b11 = b(str2);
                if (b11 == null) {
                    return null;
                }
                String a14 = a(b11, value2);
                if (value.has(a14)) {
                    JSONObject jSONObject2 = value.getJSONObject(a14);
                    a(value, a14, str2);
                    return jSONObject2;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void a(ILoader iLoader) {
        if (iLoader != null) {
            try {
                iLoader.release();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        f20733c = str;
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        try {
            if ("once".equals(jSONObject.getJSONObject(str).optJSONObject("cacheStrategy").optString("hitStrategy"))) {
                jSONObject.remove(str);
                c(str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bykv.vk.openvk.preload.falconx.loader.a b() {
        try {
            return new com.bykv.vk.openvk.preload.falconx.loader.a(f20732b, "f36c832c8dbb162c49b46a7a6dd47fbd", f20731a);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(UrlUtils.QUESTION_MARK);
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }

    private void c(String str) {
        try {
            if (this.f20737f == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f20737f.syncDoGet(str);
        } catch (Throwable unused) {
        }
    }

    public final WebResourceResponseModel a(ILoader iLoader, String str, String str2) {
        String optString;
        try {
            if (iLoader == null) {
                return new WebResourceResponseModel(-1, null);
            }
            if (!TextUtils.isEmpty(str2) && !str2.matches("^https?:\\/\\/www\\.google-analytics\\.com/(?:ga|urchin|analytics)\\.js") && !str2.matches("^https?:\\/\\/www\\.googletagmanager\\.com\\/(gtag\\/js|gtm\\.js)") && !str2.matches("^https?:\\/\\/analytics\\.tiktok\\.com\\/i18n\\/pixel") && !str2.matches("https?:\\/\\/connect\\.facebook\\.net\\/(.*)\\/fbevents\\.js") && !str2.matches("https?:\\/\\/mc\\.yandex\\.ru\\/") && !str2.contains("jsonp") && !str2.contains("Callback") && !str2.contains("analytics.tiktok.com/i18n/pixel") && !str2.contains("google-analytics.com/analytics") && !str2.contains("connect.facebook.net")) {
                JSONObject a11 = a(str, str2);
                Set<String> set = f20734g;
                String b11 = b(str2);
                int lastIndexOf = b11.lastIndexOf(".");
                int i11 = set.contains(lastIndexOf == -1 ? "" : b11.substring(lastIndexOf + 1)) ? 2 : -1;
                if (a11 != null && (optString = a11.optString("fileName", null)) != null) {
                    JSONObject jSONObject = a11.has("respHeader") ? a11.getJSONObject("respHeader") : null;
                    if (jSONObject == null) {
                        return new WebResourceResponseModel(i11, null);
                    }
                    String str3 = str + File.separator + optString;
                    InputStream inputStream = !iLoader.exist(str3) ? null : iLoader.getInputStream(str3);
                    if (inputStream == null) {
                        return new WebResourceResponseModel(i11, null);
                    }
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                    return new WebResourceResponseModel(i11, com.bykv.vk.openvk.preload.falconx.a.a.a(inputStream, hashMap));
                }
                return new WebResourceResponseModel(i11, null);
            }
            return new WebResourceResponseModel(1, null);
        } catch (Throwable unused) {
            return new WebResourceResponseModel(-1, null);
        }
    }

    public final void a(String str, IStatisticMonitor iStatisticMonitor, Set<String> set, INetWork iNetWork) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b(new b.a(f20732b).b("f36c832c8dbb162c49b46a7a6dd47fbd").a("f36c832c8dbb162c49b46a7a6dd47fbd").b().b(str).a("9999999.0.0").a(new a.C0200a().a().a(com.bykv.vk.openvk.preload.geckox.a.a.b.f20672b).b()).a(f20731a).a().c(f20733c).a(iStatisticMonitor).a(iNetWork).a(SystemClock.elapsedRealtime()), (byte) 0);
        this.f20737f = iNetWork;
        com.bykv.vk.openvk.preload.geckox.a a11 = com.bykv.vk.openvk.preload.geckox.a.a(bVar);
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            linkedList.add(new CheckRequestBodyModel.TargetChannel(it.next()));
        }
        hashMap.put("f36c832c8dbb162c49b46a7a6dd47fbd", linkedList);
        a11.a(hashMap);
    }
}
