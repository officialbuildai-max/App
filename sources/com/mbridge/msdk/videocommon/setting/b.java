package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f40035c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static com.mbridge.msdk.videocommon.setting.a f40036d = null;

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f40037e;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f40038a = false;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f40039b = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f40040a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f40041b;

        a(String str, String str2) {
            this.f40040a = str;
            this.f40041b = str2;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            j.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f40040a, this.f40041b, 2, str2);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            j.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f40040a, this.f40041b, 1, "");
        }
    }

    private b() {
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            H5DownLoadManager.getInstance().downloadH5Res(new com.mbridge.msdk.foundation.same.report.metrics.c(true), str, new a(str, str2));
            return;
        }
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2, 2, "alert url is exception ,url:" + str);
    }

    private final boolean a(c cVar) {
        com.mbridge.msdk.videocommon.setting.a c11 = c();
        if (c11 == null || cVar == null) {
            return true;
        }
        return cVar.j() + c11.h() <= System.currentTimeMillis();
    }

    public static b b() {
        if (f40037e == null) {
            synchronized (b.class) {
                try {
                    if (f40037e == null) {
                        f40037e = new b();
                    }
                } finally {
                }
            }
        }
        return f40037e;
    }

    public static boolean c(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String optString = optJSONArray.optJSONObject(0).optString("unitId");
                if (optJSONArray.length() > 0) {
                    if (!TextUtils.isEmpty(optString)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final com.mbridge.msdk.videocommon.setting.a a() {
        com.mbridge.msdk.videocommon.setting.a aVar = new com.mbridge.msdk.videocommon.setting.a();
        HashMap hashMap = new HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put(PrepareException.ERROR_MINI_APP_CLOSE, 1000);
        hashMap.put(PrepareException.ERROR_MANIFEST_INFO, 1000);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("1", new com.mbridge.msdk.videocommon.entity.c("Virtual Item", 1));
        aVar.a(hashMap);
        aVar.b(hashMap2);
        aVar.c(43200L);
        aVar.e(5400L);
        aVar.d(3600L);
        aVar.b(3600L);
        aVar.f(5L);
        aVar.a(1);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mbridge.msdk.videocommon.setting.c a(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reward_"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.setting.c> r1 = com.mbridge.msdk.videocommon.setting.b.f40035c
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L3f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.setting.c> r7 = com.mbridge.msdk.videocommon.setting.b.f40035c     // Catch: java.lang.Exception -> L2f
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Exception -> L2f
            com.mbridge.msdk.videocommon.setting.c r7 = (com.mbridge.msdk.videocommon.setting.c) r7     // Catch: java.lang.Exception -> L2f
            boolean r0 = r4.a(r7)     // Catch: java.lang.Exception -> L30
            goto L31
        L2f:
            r7 = r2
        L30:
            r0 = 0
        L31:
            if (r0 == 0) goto L3e
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.c()
            r4.a(r5, r0, r6, r2)
        L3e:
            return r7
        L3f:
            com.mbridge.msdk.foundation.buffer.sharedperference.a r1 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b()
            java.lang.String r1 = r1.a(r0)
            com.mbridge.msdk.videocommon.setting.c r1 = com.mbridge.msdk.videocommon.setting.c.a(r1)
            boolean r3 = r4.a(r1)
            if (r3 == 0) goto L64
            if (r1 != 0) goto L63
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.c()
            r4.a(r5, r0, r6, r2)
            com.mbridge.msdk.videocommon.setting.c r5 = r4.a(r7)
            return r5
        L63:
            return r1
        L64:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.setting.c> r5 = com.mbridge.msdk.videocommon.setting.b.f40035c
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.setting.b.a(java.lang.String, java.lang.String, boolean):com.mbridge.msdk.videocommon.setting.c");
    }

    public c a(boolean z10) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.entity.b(1, 30, null));
            cVar.a((List<com.mbridge.msdk.videocommon.entity.b>) arrayList);
            cVar.b(1);
            cVar.e(1);
            cVar.E(1);
            cVar.h(1);
            cVar.u(1);
            cVar.n(1);
            cVar.D(3);
            cVar.C(80);
            cVar.y(100);
            cVar.i(0);
            cVar.o(2);
            cVar.G(-1);
            cVar.p(70);
            cVar.H(2);
            if (z10) {
                cVar.I(5);
            } else {
                cVar.I(-1);
            }
            cVar.m(0);
            cVar.A(0);
            cVar.k(1);
            cVar.B(1);
            cVar.f(3);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a(arrayList2);
            cVar.q(1);
            cVar.F(1);
            cVar.r(60);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return cVar;
    }

    public void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f40039b.add(str);
        } catch (Exception unused) {
        }
    }

    public void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str4, str3);
        c a11 = c.a(str3);
        f40035c.put(str4, a11);
        if (com.mbridge.msdk.util.b.a() || TextUtils.isEmpty(a11.c())) {
            return;
        }
        a(a11.c(), str2);
    }

    public void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.net.c cVar) {
        if (!TextUtils.isEmpty(str3) && !this.f40039b.contains(str3)) {
            a(str3);
            new com.mbridge.msdk.videocommon.net.a().a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2, str3, cVar);
            return;
        }
        o0.a("test_reward_unit_setting", "unitID: " + str3 + " is requesting");
    }

    public boolean a(com.mbridge.msdk.videocommon.setting.a aVar) {
        if (aVar != null) {
            return aVar.b() + aVar.d() <= System.currentTimeMillis();
        }
        return true;
    }

    public String b(String str, String str2) {
        return com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("reward_" + str + "_" + str2);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String c11 = b().a(com.mbridge.msdk.foundation.controller.c.m().b(), str, false).c();
        if (TextUtils.isEmpty(c11) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(c11))) {
            return;
        }
        a(c11, str);
    }

    public void b(boolean z10) {
        this.f40038a = z10;
    }

    public com.mbridge.msdk.videocommon.setting.a c() {
        com.mbridge.msdk.videocommon.setting.a aVar = f40036d;
        if (aVar != null) {
            return aVar;
        }
        String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("reward_" + com.mbridge.msdk.foundation.controller.c.m().b());
        if (TextUtils.isEmpty(a11)) {
            e(com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
            return a();
        }
        com.mbridge.msdk.videocommon.setting.a a12 = com.mbridge.msdk.videocommon.setting.a.a(a11);
        if (!a(a12)) {
            return a12;
        }
        e(com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
        return a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mbridge.msdk.videocommon.setting.c c(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "reward"
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r5)
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.setting.c> r1 = com.mbridge.msdk.videocommon.setting.b.f40035c
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L42
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.setting.c> r1 = com.mbridge.msdk.videocommon.setting.b.f40035c     // Catch: java.lang.Exception -> L32
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Exception -> L32
            com.mbridge.msdk.videocommon.setting.c r0 = (com.mbridge.msdk.videocommon.setting.c) r0     // Catch: java.lang.Exception -> L32
            boolean r1 = r4.a(r0)     // Catch: java.lang.Exception -> L33
            goto L34
        L32:
            r0 = r2
        L33:
            r1 = 0
        L34:
            if (r1 == 0) goto L41
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r1 = r1.c()
            r4.a(r5, r1, r6, r2)
        L41:
            return r0
        L42:
            com.mbridge.msdk.foundation.buffer.sharedperference.a r1 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b()
            java.lang.String r1 = r1.a(r0)
            com.mbridge.msdk.videocommon.setting.c r1 = com.mbridge.msdk.videocommon.setting.c.a(r1)
            boolean r3 = r4.a(r1)
            if (r3 == 0) goto L60
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r0 = r0.c()
            r4.a(r5, r0, r6, r2)
            return r2
        L60:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.setting.c> r5 = com.mbridge.msdk.videocommon.setting.b.f40035c
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.setting.b.c(java.lang.String, java.lang.String):com.mbridge.msdk.videocommon.setting.c");
    }

    public com.mbridge.msdk.videocommon.setting.a d() {
        String str = "reward_" + com.mbridge.msdk.foundation.controller.c.m().b();
        if (f40036d == null) {
            String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str);
            if (!TextUtils.isEmpty(a11)) {
                com.mbridge.msdk.videocommon.setting.a a12 = com.mbridge.msdk.videocommon.setting.a.a(a11);
                if (a12 != null) {
                    f40036d = a12;
                }
                return a12;
            }
        }
        return f40036d;
    }

    public c d(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f40035c.containsKey(str3)) {
            return f40035c.get(str3);
        }
        c a11 = c.a(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str3));
        if (a11 != null) {
            f40035c.put(str3, a11);
        }
        return a11;
    }

    public String d(String str) {
        return com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("reward_" + str);
    }

    public void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f40039b.remove(str);
        } catch (Exception unused) {
        }
    }

    public void e(String str, String str2) {
        if (this.f40038a) {
            return;
        }
        this.f40038a = true;
        new com.mbridge.msdk.videocommon.net.a().a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2);
    }

    public void f(String str) {
        try {
            String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("reward_" + str);
            if (TextUtils.isEmpty(a11)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a11);
            jSONObject.put("current_time", System.currentTimeMillis());
            f(str, jSONObject.toString());
        } catch (Throwable th2) {
            o0.b("RewardSettingManager", th2.getMessage());
        }
    }

    public void f(String str, String str2) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("reward_" + str, str2);
        f40036d = com.mbridge.msdk.videocommon.setting.a.a(str2);
    }

    public void g(String str, String str2) {
        try {
            String a11 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("reward_" + str + "_" + str2);
            if (TextUtils.isEmpty(a11)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a11);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th2) {
            o0.b("RewardSettingManager", th2.getMessage());
        }
    }
}
