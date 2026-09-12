package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: q, reason: collision with root package name */
    public static final String f35047q = com.mbridge.msdk.foundation.controller.c.class.getSimpleName();

    /* renamed from: r, reason: collision with root package name */
    public static HashMap<String, String> f35048r = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected String f35050b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f35051c;

    /* renamed from: d, reason: collision with root package name */
    protected String f35052d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f35053e;

    /* renamed from: f, reason: collision with root package name */
    private String f35054f;

    /* renamed from: g, reason: collision with root package name */
    private int f35055g;

    /* renamed from: j, reason: collision with root package name */
    private String f35058j;

    /* renamed from: k, reason: collision with root package name */
    private String f35059k;

    /* renamed from: l, reason: collision with root package name */
    private int f35060l;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<Context> f35062n;

    /* renamed from: o, reason: collision with root package name */
    private JSONObject f35063o;

    /* renamed from: a, reason: collision with root package name */
    private final q f35049a = new q();

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f35056h = new JSONObject();

    /* renamed from: i, reason: collision with root package name */
    private boolean f35057i = false;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f35061m = new ConcurrentHashMap<>();

    /* renamed from: p, reason: collision with root package name */
    private int f35064p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.foundation.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0481a implements Runnable {
        RunnableC0481a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.report.crashreport.e.a(a.this.f35051c).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.report.crashreport.d.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.f35050b = (String) w0.a(aVar.f35051c, "sp_appId", "");
            } catch (Throwable th2) {
                o0.b(a.f35047q, th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.f35058j = (String) w0.a(aVar.f35051c, "sp_appKey", "");
            } catch (Throwable th2) {
                o0.b(a.f35047q, th2.getMessage());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
    }

    private void l() {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.i() && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                Object a11 = w0.a(this.f35051c, MBridgeConstans.SP_GA_ID, "");
                Object a12 = w0.a(this.f35051c, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                if (a11 instanceof String) {
                    String str = (String) a11;
                    if (TextUtils.isEmpty(str)) {
                        f.d();
                    } else {
                        f.a(str);
                    }
                    if (a12 instanceof Integer) {
                        f.a(((Integer) a12).intValue());
                    }
                }
            }
        } catch (Exception e11) {
            o0.b(f35047q, e11.getMessage());
        }
    }

    public BitmapDrawable a(String str, int i11) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f35061m) == null || !concurrentHashMap.containsKey(str) || !q0.a().a("w_m_r_l", true)) {
            return null;
        }
        String str2 = this.f35061m.get(str);
        BitmapDrawable n11 = t0.n(str2);
        j.a(str, i11, TextUtils.isEmpty(str2) ? 2 : 1, TextUtils.isEmpty(str2) ? "get watermark failed" : n11 != null ? "" : "str to bitmap failed", n11 == null ? 2 : 1, str2);
        return n11;
    }

    public WeakReference<Activity> a() {
        return this.f35053e;
    }

    public void a(int i11) {
        this.f35055g = i11;
    }

    public void a(Context context) {
        if (context instanceof Activity) {
            this.f35062n = new WeakReference<>(context);
        }
    }

    protected abstract void a(e eVar);

    public void a(String str) {
        try {
            if (this.f35061m != null && !TextUtils.isEmpty(str) && this.f35061m.containsKey(str)) {
                this.f35061m.remove(str);
            }
        } catch (Exception e11) {
            o0.b(f35047q, e11.getMessage());
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (q0.a().a("w_m_r_l", true)) {
            try {
                if (this.f35056h == null) {
                    this.f35056h = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.f35056h.put(next, jSONObject.get(next));
                    }
                }
                if (this.f35056h.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.f35061m == null) {
                        this.f35061m = new ConcurrentHashMap<>();
                    }
                    this.f35061m.put(str, this.f35056h.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e11) {
                o0.b(f35047q, e11.getMessage());
            }
        }
    }

    public void a(WeakReference<Activity> weakReference) {
        this.f35053e = weakReference;
    }

    public void a(JSONObject jSONObject) {
        this.f35063o = jSONObject;
    }

    public String b() {
        try {
            if (!TextUtils.isEmpty(this.f35050b)) {
                return this.f35050b;
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new c());
            return "";
        } catch (Exception e11) {
            o0.b(f35047q, e11.getMessage());
            return "";
        }
    }

    public void b(int i11) {
        this.f35060l = i11;
    }

    public void b(Context context) {
        this.f35051c = context;
    }

    public void b(e eVar) {
        try {
            k0.C(this.f35051c);
            a(eVar);
            h.a(this.f35051c, this.f35050b);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                try {
                    try {
                        k0.d(this.f35051c.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (Throwable th2) {
                        o0.b(f35047q, th2.getMessage());
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    k0.d(0);
                }
            }
            try {
                g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 == null) {
                    d11 = h.b().a();
                }
                q e11 = com.mbridge.msdk.foundation.controller.c.m().e();
                if (e11 != null && e11.b() && d11 != null && d11.E() == 1) {
                    com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0481a());
                }
                if (e11 == null || !e11.a()) {
                    return;
                }
                com.mbridge.msdk.foundation.same.threadpool.a.c().post(new b());
            } catch (Throwable th3) {
                o0.b(f35047q, th3.getMessage());
            }
        } catch (Exception e12) {
            o0.b(f35047q, e12.getMessage());
        }
    }

    public void b(String str) {
        Context context;
        try {
            this.f35054f = str;
            if (TextUtils.isEmpty(str) || (context = this.f35051c) == null) {
                return;
            }
            w0.b(context, "applicationIds", str);
        } catch (Exception e11) {
            o0.b(f35047q, e11.getMessage());
        }
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.f35058j)) {
                return this.f35058j;
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new d());
            return "";
        } catch (Throwable th2) {
            o0.b(f35047q, th2.getMessage());
            return "";
        }
    }

    public void c(int i11) {
        this.f35064p = i11;
    }

    public void c(e eVar) {
        if (this.f35057i) {
            return;
        }
        l();
        try {
            JSONObject jSONObject = new JSONObject();
            this.f35063o = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e11) {
            o0.b(f35047q, e11.getMessage());
        }
        b(eVar);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f35052d = str;
    }

    public Context d() {
        return this.f35051c;
    }

    public void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f35059k = str;
            Context context = this.f35051c;
            if (context != null) {
                w0.b(context, "sp_wx_appKey", str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public q e() {
        return this.f35049a;
    }

    public void e(String str) {
        Context context;
        try {
            this.f35050b = str;
            if (TextUtils.isEmpty(str) || (context = this.f35051c) == null) {
                return;
            }
            w0.b(context, "sp_appId", str);
        } catch (Exception e11) {
            o0.b(f35047q, e11.getMessage());
        }
    }

    public Context f() {
        WeakReference<Context> weakReference = this.f35062n;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void f(String str) {
        Context context;
        try {
            this.f35058j = str;
            if (TextUtils.isEmpty(str) || (context = this.f35051c) == null) {
                return;
            }
            w0.b(context, "sp_appKey", str);
        } catch (Exception e11) {
            o0.b(f35047q, e11.getMessage());
        }
    }

    public int g() {
        return this.f35055g;
    }

    public String h() {
        try {
            if (!TextUtils.isEmpty(this.f35052d)) {
                return this.f35052d;
            }
            Context context = this.f35051c;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.f35052d = packageName;
            return packageName;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public String i() {
        if (!TextUtils.isEmpty(this.f35059k)) {
            return this.f35059k;
        }
        Context context = this.f35051c;
        if (context != null) {
            return (String) w0.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public JSONObject j() {
        return this.f35063o;
    }

    public int k() {
        return this.f35064p;
    }
}
