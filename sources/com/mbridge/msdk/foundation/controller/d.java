package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.j;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: l, reason: collision with root package name */
    private static volatile d f35090l;

    /* renamed from: a, reason: collision with root package name */
    private int f35091a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Object> f35092b;

    /* renamed from: c, reason: collision with root package name */
    private FastKV f35093c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f35094d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f35095e;

    /* renamed from: f, reason: collision with root package name */
    private String f35096f;

    /* renamed from: g, reason: collision with root package name */
    private String f35097g;

    /* renamed from: h, reason: collision with root package name */
    private Context f35098h;

    /* renamed from: i, reason: collision with root package name */
    private String f35099i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.preload.a f35100j;

    /* renamed from: k, reason: collision with root package name */
    private String f35101k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35102a;

        a(Context context) {
            this.f35102a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.h(this.f35102a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            d.this.g();
            d.this.d();
            Looper.loop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.a(dVar.f35095e);
            new h(d.this.f35098h).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.foundation.controller.d$d, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0484d implements a.e {
        C0484d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35107a;

        e(String str) {
            this.f35107a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(350L);
            } catch (InterruptedException e11) {
                o0.b("SDKController", e11.getMessage());
            }
            new j().b(d.this.f35098h, this.f35107a, d.this.f35096f);
        }
    }

    private d() {
    }

    public static d a() {
        if (f35090l == null) {
            synchronized (d.class) {
                try {
                    if (f35090l == null) {
                        f35090l = new d();
                    }
                } finally {
                }
            }
        }
        return f35090l;
    }

    private void a(Context context) {
        String str;
        try {
            if (e() && this.f35093c == null) {
                try {
                    this.f35093c = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), i0.a("H+tU+FeXHM==")).build();
                } catch (Exception unused) {
                    this.f35093c = null;
                }
            }
            FastKV fastKV = this.f35093c;
            String str2 = "";
            if (fastKV != null) {
                String string = fastKV.getString(i0.a("H+tU+bfPhM=="), "");
                String string2 = this.f35093c.getString(i0.a("H+tU+Fz8"), "");
                if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) {
                    com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    com.mbridge.msdk.foundation.same.a.f35389g = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c");
                }
                if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                    com.mbridge.msdk.foundation.same.a.V = string;
                    com.mbridge.msdk.foundation.same.a.f35389g = string2;
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.f35389g);
                    return;
                }
                if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) {
                    return;
                }
                this.f35093c.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                this.f35093c.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f35389g);
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(i0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences != null) {
                str2 = sharedPreferences.getString(i0.a("H+tU+bfPhM=="), "");
                str = sharedPreferences.getString(i0.a("H+tU+Fz8"), "");
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) {
                com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                com.mbridge.msdk.foundation.same.a.f35389g = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c");
            }
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                com.mbridge.msdk.foundation.same.a.V = str2;
                com.mbridge.msdk.foundation.same.a.f35389g = str;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.f35389g);
                return;
            }
            if ((TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(i0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
            edit.putString(i0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f35389g);
            edit.apply();
        } catch (Throwable th2) {
            o0.b("SDKController", th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (com.mbridge.msdk.setting.h.b() == null) {
            return;
        }
        com.mbridge.msdk.setting.h b11 = com.mbridge.msdk.setting.h.b();
        if (b11 != null) {
            g d11 = b11.d(str);
            if (d11 != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = d11.U();
                MBridgeConstans.OMID_JS_H5_URL = d11.T();
                if (!TextUtils.isEmpty(d11.u())) {
                    com.mbridge.msdk.foundation.same.net.utils.d.h().f35530i = d11.u();
                    com.mbridge.msdk.foundation.same.net.utils.d.h().e();
                }
                if (!TextUtils.isEmpty(d11.v())) {
                    com.mbridge.msdk.foundation.same.net.utils.d.h().f35534m = d11.v();
                    com.mbridge.msdk.foundation.same.net.utils.d.h().f();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.setting.net.b.f37392b;
                MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.setting.net.b.f37391a;
            }
        }
        if (com.mbridge.msdk.setting.h.b().f(str) && com.mbridge.msdk.setting.h.b().a(str, 1, (String) null)) {
            if (com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("is_first_init", 0) != 0) {
                new j().b(this.f35098h, str, this.f35096f);
                return;
            }
            try {
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().b("is_first_init", 1);
                if (TextUtils.isEmpty(f.d())) {
                    com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(str));
                } else {
                    new j().b(this.f35098h, str, this.f35096f);
                }
            } catch (Throwable unused) {
                new j().b(this.f35098h, str, this.f35096f);
            }
        }
    }

    private void c() {
        com.mbridge.msdk.foundation.controller.c.m().b(this.f35098h);
        com.mbridge.msdk.foundation.controller.c.m().e(this.f35095e);
        com.mbridge.msdk.foundation.controller.c.m().f(this.f35096f);
        com.mbridge.msdk.foundation.controller.c.m().d(this.f35101k);
        com.mbridge.msdk.foundation.controller.c.m().b(this.f35097g);
        com.mbridge.msdk.foundation.controller.c.m().c(new C0484d());
        try {
            com.mbridge.msdk.foundation.same.net.utils.d.h().j();
        } catch (Throwable th2) {
            o0.b("SDKController", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<com.mbridge.msdk.foundation.entity.a> g11;
        Object newInstance;
        Object newInstance2;
        try {
            g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null || (g11 = d11.g()) == null || g11.size() <= 0) {
                return;
            }
            for (com.mbridge.msdk.foundation.entity.a aVar : g11) {
                if (aVar.a() == 287) {
                    if (this.f35098h != null && (newInstance = MBInterstitialVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                        MBInterstitialVideoHandler.class.getMethod("loadFormSelfFilling", null).invoke(newInstance, null);
                    }
                } else if (aVar.a() == 94 && (newInstance2 = MBRewardVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                    MBRewardVideoHandler.class.getMethod("loadFormSelfFilling", null).invoke(newInstance2, null);
                }
            }
        } catch (Throwable th2) {
            o0.b("SDKController", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.mbridge.msdk.timer.b.class.getDeclaredMethod("start", null).invoke(com.mbridge.msdk.timer.b.class.getMethod("getInstance", null).invoke(null, null), null);
        } catch (Throwable th2) {
            o0.b("SDKController", th2.getMessage(), th2);
        }
    }

    public void a(Map<String, Object> map, int i11) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            o0.b("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.f35092b = map;
        this.f35091a = i11;
        String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
        if (map != null) {
            b(b11);
        }
    }

    public void a(Map map, Context context) {
        Object obj;
        if (context != null) {
            if (!TextUtils.isEmpty(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE)) {
                com.mbridge.msdk.foundation.controller.c.m().c(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE);
            } else if (map.containsKey(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME) && (obj = map.get(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME)) != null) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    com.mbridge.msdk.foundation.controller.c.m().c(str);
                }
            }
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.f35095e = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.f35096f = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.f35101k = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.f35097g = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.f35099i = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
            }
            this.f35098h = context.getApplicationContext();
            c();
            if (this.f35094d) {
                return;
            }
            b();
            k0.l(context);
            long x02 = com.mbridge.msdk.setting.h.b().b(this.f35095e).x0();
            if (x02 != 1300) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(context), x02);
            }
        }
    }

    public void b() {
        a(this.f35098h.getApplicationContext());
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new b());
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new c());
            com.mbridge.msdk.foundation.same.report.j.b();
        } catch (Exception unused) {
            o0.b("SDKController", "get app setting failed");
        }
        this.f35094d = true;
    }

    public void b(String str) {
        if (this.f35100j == null) {
            this.f35100j = new com.mbridge.msdk.preload.a();
        }
        try {
            Map<String, Object> map = this.f35092b;
            if (map == null || map.size() <= 0 || !this.f35092b.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                return;
            }
            int intValue = ((Integer) this.f35092b.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
            if (intValue == 0) {
                this.f35100j.a(this.f35092b, this.f35091a);
                return;
            }
            if (1 == intValue) {
                this.f35100j.a(this.f35092b);
            } else if (2 == intValue) {
                this.f35100j.b(this.f35092b);
            } else {
                o0.b("SDKController", "unknow layout type in preload");
            }
        } catch (Exception e11) {
            o0.b("SDKController", e11.getMessage());
        }
    }

    public boolean e() {
        return true;
    }

    public void f() {
    }
}
