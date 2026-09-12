package com.mbridge.msdk.foundation.same.buffer;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35414a = "b";

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, c>> f35418e;

    /* renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f35419f;

    /* renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f35420g;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35415b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35416c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35417d = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35421h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35422i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35423j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35424k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, Long> f35425l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35426m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> f35427n = new HashMap();

    public static String a(String str, String str2) {
        List<com.mbridge.msdk.foundation.same.metadata.a> list;
        JSONArray jSONArray = new JSONArray();
        Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> a11 = TextUtils.isEmpty(str2) ? a(str) : b(str2);
        if (a11 != null) {
            try {
                if (y0.b(str) && a11.containsKey(str) && (list = a11.get(str)) != null && list.size() > 0) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", list.get(i11).a());
                        jSONObject.put("1", list.get(i11).c());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    private static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> a(String str) {
        if (f35423j.containsKey(str)) {
            return f35423j;
        }
        if (f35424k.containsKey(str)) {
            return f35424k;
        }
        if (f35421h.containsKey(str)) {
            return f35421h;
        }
        if (f35427n.containsKey(str)) {
            return f35427n;
        }
        if (f35422i.containsKey(str)) {
            return f35422i;
        }
        if (f35416c.containsKey(str)) {
            return f35416c;
        }
        if (f35426m.containsKey(str)) {
            return f35426m;
        }
        if (f35417d.containsKey(str)) {
            return f35417d;
        }
        return null;
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> b11 = b(str2);
        if (campaignEx == null || b11 == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(campaignEx.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.metadata.a aVar = new com.mbridge.msdk.foundation.same.metadata.a(campaignEx.getId(), campaignEx.getRequestIdNotice());
            if (!b11.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                b11.put(str, arrayList);
                return;
            }
            List<com.mbridge.msdk.foundation.same.metadata.a> list = b11.get(str);
            if (list != null && list.size() == 20) {
                list.remove(0);
            }
            if (list != null) {
                list.add(aVar);
            }
        } catch (Throwable th2) {
            o0.b(f35414a, th2.getMessage(), th2);
        }
    }

    public static void a(String str, String str2, int i11) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f35420g == null) {
            f35420g = new ConcurrentHashMap<>();
        }
        try {
            if (f35420g.containsKey(str)) {
                copyOnWriteArrayList = f35420g.get(str);
                copyOnWriteArrayList.add(str2);
            } else {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(str2);
                f35420g.put(str, copyOnWriteArrayList2);
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
            int size = copyOnWriteArrayList.size() - i11;
            if (size >= 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    copyOnWriteArrayList.remove(i12);
                }
            }
        } catch (Exception e11) {
            o0.a(f35414a, e11.getMessage());
        }
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (f35419f == null) {
                f35419f = new ConcurrentHashMap<>();
            }
            if (!f35419f.containsKey(str)) {
                ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, str3);
                f35419f.put(str, concurrentHashMap);
            } else if (f35419f.get(str) == null) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(str2, str3);
                f35419f.put(str, concurrentHashMap2);
            }
        } catch (Exception e11) {
            o0.a(f35414a, e11.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, long j11, long j12, long j13, String str4) {
        if (f35418e == null) {
            f35418e = new ConcurrentHashMap<>();
        }
        try {
            if (!f35418e.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                ConcurrentHashMap<String, c> concurrentHashMap = new ConcurrentHashMap<>();
                c cVar = new c();
                cVar.a(arrayList);
                cVar.a(j11);
                cVar.b(j12);
                cVar.c(j13);
                cVar.c(str4);
                concurrentHashMap.put(str2, cVar);
                f35418e.put(str, concurrentHashMap);
                return;
            }
            ConcurrentHashMap<String, c> concurrentHashMap2 = f35418e.get(str);
            if (concurrentHashMap2 != null) {
                c cVar2 = concurrentHashMap2.get(str2);
                if (cVar2 != null) {
                    if (cVar2.c() != null) {
                        cVar2.a(j11);
                        cVar2.b(j12);
                        cVar2.c(j13);
                        cVar2.c().add(str3);
                        cVar2.c(str4);
                        return;
                    }
                    return;
                }
                c cVar3 = new c();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                cVar3.a(arrayList2);
                cVar3.a(j11);
                cVar3.b(j12);
                cVar3.c(j13);
                cVar3.c(str4);
                concurrentHashMap2.put(str2, cVar3);
            }
        } catch (Throwable th2) {
            o0.b(f35414a, th2.getMessage());
        }
    }

    public static d b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        d dVar = new d();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return dVar;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f35419f;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f35419f.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                dVar.a(1);
                dVar.c(concurrentHashMap.get(str2));
            }
        } catch (Exception e11) {
            o0.a(f35414a, e11.getMessage());
        }
        return dVar;
    }

    private static Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> b(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    c11 = 1;
                    break;
                }
                break;
            case -934326481:
                if (str.equals("reward")) {
                    c11 = 2;
                    break;
                }
                break;
            case -895866265:
                if (str.equals("splash")) {
                    c11 = 3;
                    break;
                }
                break;
            case 538816457:
                if (str.equals("h5_native")) {
                    c11 = 4;
                    break;
                }
                break;
            case 604727084:
                if (str.equals(com.vungle.ads.internal.b.PLACEMENT_TYPE_INTERSTITIAL)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1844104930:
                if (str.equals("interactive")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return f35416c;
            case 1:
                return f35423j;
            case 2:
                return f35424k;
            case 3:
                return f35426m;
            case 4:
                return f35417d;
            case 5:
                return f35422i;
            case 6:
                return f35421h;
            default:
                return null;
        }
    }

    public static ConcurrentHashMap<String, c> c(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap = f35418e;
        if (concurrentHashMap == null) {
            e a11 = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
            if (a11 != null) {
                a11.b(str, "");
                f35418e = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f35418e.get(str);
        }
        return null;
    }

    public static void c(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap;
        c remove;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f35418e) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f35418e.remove(str);
            return;
        }
        ConcurrentHashMap<String, c> concurrentHashMap2 = f35418e.get(str);
        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str2) || (remove = concurrentHashMap2.remove(str2)) == null) {
            return;
        }
        try {
            String d11 = remove.d();
            if (TextUtils.isEmpty(d11)) {
                return;
            }
            Iterator<Map.Entry<String, c>> it = concurrentHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                if (d11.equals(it.next().getValue().d())) {
                    it.remove();
                }
            }
        } catch (Exception e11) {
            o0.a(f35414a, e11.getMessage());
        }
    }

    public static String d(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        return (TextUtils.isEmpty(str) || (concurrentHashMap = f35420g) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f35420g.get(str)) == null || copyOnWriteArrayList.size() <= 0) ? "" : copyOnWriteArrayList.get(0);
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f35419f;
            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str) || (concurrentHashMap = f35419f.get(str2)) == null || !concurrentHashMap.containsKey(str2)) {
                return;
            }
            concurrentHashMap.remove(str2);
        } catch (Exception e11) {
            o0.a(f35414a, e11.getMessage());
        }
    }

    public static void e(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f35420g) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f35420g.get(str)) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        copyOnWriteArrayList.remove(0);
    }
}
