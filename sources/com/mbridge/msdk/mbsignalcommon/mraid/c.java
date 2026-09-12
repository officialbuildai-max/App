package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f36560a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<String> f36561b = new ArrayList<>();

    public static com.mbridge.msdk.mbsignalcommon.windvane.a a(WindVaneWebView windVaneWebView, String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = new com.mbridge.msdk.mbsignalcommon.windvane.a();
        aVar.f36597d = i0.a("n+ztLkxpVTzBLkxgHN==");
        aVar.f36598e = parse.getHost();
        if (f36561b.size() == 0) {
            a();
        }
        if (!f36561b.contains(aVar.f36598e) && windVaneWebView != null) {
            a(windVaneWebView.getCampaignId(), aVar.f36598e);
            a.a().b(windVaneWebView, aVar.f36598e);
            a.a().a(windVaneWebView, aVar.f36598e, "Specified command is not implemented");
            return null;
        }
        Set<String> a11 = a(parse);
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : a11) {
                jSONObject.put(str2, parse.getQueryParameter(str2));
            }
            aVar.f36599f = jSONObject.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return aVar;
    }

    private static Set<String> a(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i11 = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i11);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i11);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i11, indexOf2)));
            i11 = indexOf + 1;
        } while (i11 < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static void a() {
        for (Method method : b.class.getDeclaredMethods()) {
            f36561b.add(method.getName());
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f36560a.remove(str);
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!f36560a.containsKey(str)) {
            f36560a.put(str, str2);
            return;
        }
        String str3 = f36560a.get(str);
        if (TextUtils.isEmpty(str2) || str3.contains(str2)) {
            return;
        }
        if (str3.length() > 0) {
            str3 = str3.concat(",");
        }
        f36560a.put(str, str3.concat(str2));
    }

    public static String b(String str) {
        if (f36560a.containsKey(str)) {
            return f36560a.get(str);
        }
        return null;
    }
}
