package com.mbridge.msdk.foundation.same.net.utils;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f35508a;

    /* renamed from: b, reason: collision with root package name */
    private int f35509b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f35510c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f35511d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f35512a;

        /* renamed from: b, reason: collision with root package name */
        public String f35513b;

        /* renamed from: c, reason: collision with root package name */
        public long f35514c;

        public b(long j11, int i11, String str) {
            this.f35514c = j11;
            this.f35512a = i11;
            this.f35513b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.mbridge.msdk.foundation.same.net.utils.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0491c {

        /* renamed from: a, reason: collision with root package name */
        private static final c f35515a = new c();
    }

    private c() {
        this.f35508a = "IDErrorUtil";
        this.f35510c = new ConcurrentHashMap<>();
        this.f35511d = new ArrayList<>();
        g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        d11 = d11 == null ? h.b().a() : d11;
        this.f35509b = d11.t() * 1000;
        if (d11.x() == null || d11.x().size() <= 0) {
            o0.b("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
            this.f35511d.addAll(a());
        } else {
            o0.b("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
            this.f35511d.addAll(d11.x());
        }
    }

    private e a(String str, String str2, String str3, String str4, String str5) {
        int parseInt;
        String str6 = str + "_" + str3 + "_" + str2 + "_" + str5;
        b a11 = a(str6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mbridge.msdk.tracker.network.g("data_res_type", "1"));
        if (a11 != null && !TextUtils.isEmpty(a11.f35513b)) {
            try {
                if (a11.f35512a != -1) {
                    return e.a(new JSONObject(a11.f35513b), new com.mbridge.msdk.foundation.same.net.toolbox.a(200, a11.f35513b.getBytes(), arrayList));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (str5 != null && !TextUtils.isEmpty(str5) && (parseInt = Integer.parseInt(str5)) != 287 && parseInt != 94) {
                    if (System.currentTimeMillis() < (h.b().c(str, str2).u() * 1000) + a11.f35514c) {
                        return e.a(new JSONObject(a11.f35513b), new com.mbridge.msdk.foundation.same.net.toolbox.a(200, a11.f35513b.getBytes(), arrayList));
                    }
                    this.f35510c.remove(str6);
                    return null;
                }
            } catch (Exception e11) {
                o0.b("IDErrorUtil", e11.getMessage());
            }
        }
        o0.b("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }

    private synchronized b a(String str) {
        b bVar;
        o0.b("IDErrorUtil", "getErrorInfo : " + str);
        if (!this.f35510c.containsKey(str) || (bVar = this.f35510c.get(str)) == null) {
            return null;
        }
        if (bVar.f35512a == -1) {
            return bVar;
        }
        if (System.currentTimeMillis() <= bVar.f35514c + this.f35509b) {
            o0.b("IDErrorUtil", "getErrorInfo : " + bVar.f35513b);
            return bVar;
        }
        this.f35510c.remove(str);
        if (this.f35510c.size() > 0) {
            for (Map.Entry<String, b> entry : this.f35510c.entrySet()) {
                o0.b("IDErrorUtil", "getErrorInfo : delete timeout entry");
                if (System.currentTimeMillis() - entry.getValue().f35514c > this.f35509b) {
                    this.f35510c.remove(entry.getKey());
                }
            }
        }
        return null;
    }

    private List<Integer> a() {
        return Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616);
    }

    public static c b() {
        return C0491c.f35515a;
    }

    public e a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar) {
        String str = eVar.a().get("app_id");
        String str2 = eVar.a().get("placement_id");
        String str3 = TextUtils.isEmpty(str2) ? "" : str2;
        String str4 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (TextUtils.isEmpty(str4)) {
            str4 = eVar.a().get("unit_ids");
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4.replace("[", "").replace("]", "");
            }
        }
        String str5 = str4;
        String str6 = eVar.a().get("ad_type");
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        return a(str, str5, str3, eVar.a().get("token"), str6);
    }

    public synchronized void a(String str, int i11, String str2, long j11) {
        if (this.f35510c.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f35511d.contains(Integer.valueOf(i11))) {
            o0.b("IDErrorUtil", "addErrorInfo : " + str + " " + str2);
            this.f35510c.put(str, new b(j11, i11, str2));
        }
    }
}
