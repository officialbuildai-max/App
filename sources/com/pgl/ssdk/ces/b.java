package com.pgl.ssdk.ces;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.pgl.ssdk.a0;
import com.pgl.ssdk.b0;
import com.pgl.ssdk.c0;
import com.pgl.ssdk.c1;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.d0;
import com.pgl.ssdk.e0;
import com.pgl.ssdk.f0;
import com.pgl.ssdk.g0;
import com.pgl.ssdk.h0;
import com.pgl.ssdk.i0;
import com.pgl.ssdk.j0;
import com.pgl.ssdk.k0;
import com.pgl.ssdk.l0;
import com.pgl.ssdk.o0;
import com.pgl.ssdk.s;
import com.pgl.ssdk.t;
import com.pgl.ssdk.t0;
import com.pgl.ssdk.u;
import com.pgl.ssdk.u0;
import com.pgl.ssdk.v;
import com.pgl.ssdk.v0;
import com.pgl.ssdk.w;
import com.pgl.ssdk.x;
import com.pgl.ssdk.y;
import com.pgl.ssdk.z;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f40152a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40153b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Object> f40154c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f40155d = 1;

    /* renamed from: e, reason: collision with root package name */
    private static t0.a f40156e;

    /* renamed from: g, reason: collision with root package name */
    public Context f40158g;

    /* renamed from: h, reason: collision with root package name */
    private String f40159h;

    /* renamed from: i, reason: collision with root package name */
    private int f40160i;

    /* renamed from: j, reason: collision with root package name */
    private String f40161j;

    /* renamed from: n, reason: collision with root package name */
    private String f40165n;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40157f = false;

    /* renamed from: k, reason: collision with root package name */
    private String f40162k = null;

    /* renamed from: l, reason: collision with root package name */
    private String f40163l = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f40164m = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f40166o = false;

    /* renamed from: p, reason: collision with root package name */
    public int f40167p = 2;

    /* loaded from: classes5.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.b(x.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.pgl.ssdk.ces.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0578b implements Runnable {
        RunnableC0578b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.a(b.this.f40158g).a();
        }
    }

    /* loaded from: classes5.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(b.this.f40158g);
        }
    }

    private b(Context context, String str) {
        this.f40158g = context;
        this.f40159h = str;
    }

    public static b a(Context context, String str, int i11, int i12, String str2) {
        if (f40152a == null) {
            synchronized (b.class) {
                try {
                    if (f40152a == null) {
                        if (context == null) {
                            context = z.a().getApplicationContext();
                        }
                        if (context == null) {
                            f40155d = 4;
                            return null;
                        }
                        a(i11);
                        t0.a b11 = t0.b(context, "nms");
                        if (b11 != null) {
                            f40155d = b11.f40263a;
                            f40156e = b11;
                            return null;
                        }
                        b bVar = new b(context, str);
                        f40152a = bVar;
                        bVar.f40160i = i12;
                        f40152a.f40161j = str2;
                        f40152a.b(context);
                        f40152a.d(a(context));
                        x.c(context);
                        f40155d = 0;
                        o0.b(new a());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f40152a;
    }

    private static String a(Context context) {
        String a11 = u0.a(context, "iid");
        if (!TextUtils.isEmpty(a11)) {
            return a11;
        }
        String uuid = UUID.randomUUID().toString();
        u0.b(context, "iid", uuid);
        return uuid;
    }

    private String a(Object obj) {
        Map<String, Object> map;
        if (!(obj instanceof String) || !"Start".equals((String) obj) || (map = f40154c) == null || map.isEmpty()) {
            return "{}";
        }
        try {
            return new JSONObject(f40154c).toString();
        } catch (Exception unused) {
            return "{}";
        }
    }

    public static void a(int i11) {
        k0.a(i11);
    }

    private void a(String str) {
        char c11;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                int hashCode = next.hashCode();
                if (hashCode != -93508180) {
                    if (hashCode == 944591168 && next.equals("report_ratio")) {
                        c11 = 1;
                    }
                    c11 = 65535;
                } else {
                    if (next.equals("autoctl_detect_enable")) {
                        c11 = 0;
                    }
                    c11 = 65535;
                }
                if (c11 != 0) {
                    if (c11 == 1 && (obj instanceof Integer) && ((Integer) obj).intValue() > 0) {
                        this.f40167p = ((Integer) obj).intValue();
                    }
                } else if (obj instanceof Boolean) {
                    h0.f40193b = ((Boolean) obj).booleanValue();
                }
            }
        } catch (JSONException unused) {
        }
    }

    private void b(Context context) {
        if (context == null || f40153b) {
            return;
        }
        try {
            com.pgl.ssdk.ces.a.meta(101, null, "1");
            com.pgl.ssdk.ces.a.meta(102, null, this.f40159h);
            com.pgl.ssdk.ces.a.meta(Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, null, Integer.valueOf(this.f40160i));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z.g(context));
            com.pgl.ssdk.ces.a.meta(105, null, sb2.toString());
            com.pgl.ssdk.ces.a.meta(106, null, z.e(context));
            com.pgl.ssdk.ces.a.meta(107, null, z.d(context));
            com.pgl.ssdk.ces.a.meta(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, null, z.c(context));
            com.pgl.ssdk.ces.a.meta(109, null, z.c());
            com.pgl.ssdk.ces.a.meta(110, null, z.b());
            com.pgl.ssdk.ces.a.meta(Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, null, this.f40161j);
            f40153b = true;
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        if (h() != null) {
            return h().f40159h;
        }
        return null;
    }

    public static String d() {
        if (h() != null) {
            return h().f40162k;
        }
        return null;
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f40165n = str;
        com.pgl.ssdk.ces.a.meta(104, null, str);
    }

    public static String f() {
        b h11 = h();
        if (h11 == null || !h11.f40164m || TextUtils.isEmpty(h11.f40163l)) {
            return null;
        }
        return h11.f40163l;
    }

    public static int g() {
        return f40155d;
    }

    public static b h() {
        return f40152a;
    }

    public static t0.a i() {
        return f40156e;
    }

    public Object a(int i11, Object obj) {
        Object valueOf;
        if (i11 == 123) {
            valueOf = d0.a(this.f40158g);
        } else if (i11 == 121) {
            valueOf = b0.a();
        } else if (i11 == 122) {
            valueOf = b0.b();
        } else if (i11 == 126) {
            valueOf = b0.b(this.f40158g);
        } else if (i11 == 128) {
            valueOf = b0.c(this.f40158g);
        } else if (i11 == 120) {
            valueOf = a0.c();
        } else if (i11 == 124) {
            valueOf = e0.c(this.f40158g);
        } else if (i11 == 130) {
            valueOf = e0.a(this.f40158g);
        } else if (i11 == 145) {
            valueOf = f0.b(this.f40158g);
        } else if (i11 == 125) {
            valueOf = e0.b(this.f40158g);
        } else if (i11 == 129) {
            valueOf = c0.e(this.f40158g);
        } else if (i11 == 141) {
            valueOf = c0.d(this.f40158g);
        } else if (i11 == 134) {
            valueOf = h0.a(this.f40158g).b();
        } else if (i11 == 140) {
            valueOf = i0.a(this.f40158g).e();
        } else if (i11 == 144) {
            valueOf = i0.a(this.f40158g).d();
        } else if (i11 == 133) {
            valueOf = a(obj);
        } else {
            if (i11 == 135) {
                return t.f();
            }
            if (i11 == 201) {
                valueOf = b0.a(this.f40158g);
            } else if (i11 == 202) {
                valueOf = b0.c();
            } else {
                if (i11 == 236) {
                    return v0.a((String) obj);
                }
                if (i11 == 142) {
                    valueOf = z.f(this.f40158g);
                } else if (i11 == 143) {
                    valueOf = f0.a(this.f40158g);
                } else {
                    if (i11 == 146) {
                        try {
                            return t.b();
                        } catch (Throwable unused) {
                            return null;
                        }
                    }
                    if (i11 == 147) {
                        valueOf = Boolean.valueOf(z.h(this.f40158g));
                    } else if (i11 == 148) {
                        valueOf = s.b(this.f40158g);
                    } else if (i11 == 149) {
                        valueOf = u.a(this.f40158g);
                    } else if (i11 == 150) {
                        valueOf = Integer.valueOf(v.a());
                    } else if (i11 == 151) {
                        valueOf = u.c();
                    } else if (i11 == 161) {
                        valueOf = Boolean.valueOf(t.g());
                    } else if (i11 == 169) {
                        valueOf = Boolean.valueOf(y.b(this.f40158g));
                    } else {
                        if (i11 != 170) {
                            return null;
                        }
                        valueOf = Integer.valueOf(w.b((String) obj));
                    }
                }
            }
        }
        return valueOf;
    }

    public Map<String, String> a(String str, byte[] bArr) {
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String str2 = (String) com.pgl.ssdk.ces.a.meta(224, this.f40158g, new Object[]{str, bArr});
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("X-Armors", str2);
        }
        return hashMap;
    }

    public void a() {
        o0.b(new RunnableC0578b());
    }

    public void a(MotionEvent motionEvent) {
        w.a(motionEvent, this.f40158g);
    }

    public void a(String str, String str2, String str3, String str4) {
        b(str2);
        c(str4);
        try {
            l();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            long j11 = "Start".equals(str) ? 10000L : 0L;
            Handler b11 = o0.b();
            if (b11 != null) {
                b11.postDelayed(new l0(this.f40158g, Sdk$SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, new Object[]{str, map}), j11);
            }
            a();
            x.a();
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Map<String, Object> map) {
        char c11;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    try {
                        for (String str : map.keySet()) {
                            Object obj = map.get(str);
                            if (obj != null) {
                                switch (str.hashCode()) {
                                    case -2021683300:
                                        if (str.equals(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST)) {
                                            c11 = 2;
                                            break;
                                        }
                                        break;
                                    case -1195280656:
                                        if (str.equals(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR)) {
                                            c11 = 5;
                                            break;
                                        }
                                        break;
                                    case 156851746:
                                        if (str.equals(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS)) {
                                            c11 = 3;
                                            break;
                                        }
                                        break;
                                    case 398905722:
                                        if (str.equals(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ)) {
                                            c11 = 0;
                                            break;
                                        }
                                        break;
                                    case 485444716:
                                        if (str.equals(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC)) {
                                            c11 = 4;
                                            break;
                                        }
                                        break;
                                    case 500804551:
                                        if (str.equals(PglSSConfig.CUSTOMINFO_KEY_IPV6)) {
                                            c11 = 1;
                                            break;
                                        }
                                        break;
                                }
                                c11 = 65535;
                                if (c11 != 0) {
                                    if (c11 != 1) {
                                        if (c11 != 2) {
                                            if (c11 != 3) {
                                                if (c11 != 4) {
                                                    if (c11 != 5) {
                                                        continue;
                                                    } else if (obj instanceof String) {
                                                        a((String) obj);
                                                    }
                                                } else if (obj instanceof String) {
                                                    k0.b((String) obj);
                                                }
                                            } else if (obj instanceof Set) {
                                                try {
                                                    Set set = (Set) obj;
                                                    com.pgl.ssdk.ces.a.meta(165, null, Boolean.valueOf(set.contains("boot")));
                                                    com.pgl.ssdk.ces.a.meta(166, null, Boolean.valueOf(set.contains("mnc")));
                                                    com.pgl.ssdk.ces.a.meta(167, null, Boolean.valueOf(set.contains("mcc")));
                                                    com.pgl.ssdk.ces.a.meta(168, null, Boolean.valueOf(set.contains(UrlKt.KEY_MINI_GAID)));
                                                    this.f40164m = set.contains(UrlKt.KEY_MINI_GAID);
                                                } catch (Throwable unused) {
                                                }
                                            }
                                        } else if (obj instanceof String) {
                                            k0.a((String) obj);
                                        }
                                    } else if (obj instanceof String) {
                                        String str2 = (String) obj;
                                        if (!TextUtils.isEmpty(str2)) {
                                            j0.a(str2);
                                        }
                                    }
                                } else if (obj instanceof String) {
                                    String a11 = g0.a((String) obj);
                                    if (!TextUtils.isEmpty(a11)) {
                                        com.pgl.ssdk.ces.a.meta(159, null, a11);
                                    }
                                }
                            }
                        }
                        if (f40154c == null) {
                            f40154c = new HashMap();
                        }
                        f40154c.putAll(map);
                    } catch (Throwable unused2) {
                    }
                }
            } finally {
            }
        }
    }

    public void b() {
        o0.b(new c());
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f40162k)) {
            this.f40162k = str;
            com.pgl.ssdk.ces.a.meta(103, null, str);
            c1.b();
        }
    }

    public synchronized void c(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f40163l)) {
            com.pgl.ssdk.ces.a.meta(111, null, str);
            this.f40163l = str;
            c1.b();
        }
    }

    public long e() {
        return x.a(this.f40158g);
    }

    public String j() {
        return x.c();
    }

    public String k() {
        return c1.a();
    }

    public void l() {
        this.f40166o = true;
        c1.a(this.f40158g, this.f40159h);
        a("Start", (Map<String, Object>) null);
    }
}
