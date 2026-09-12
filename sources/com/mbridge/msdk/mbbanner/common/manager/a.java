package com.mbridge.msdk.mbbanner.common.manager;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static final String f36108g = "a";

    /* renamed from: h, reason: collision with root package name */
    private static volatile a f36109h;

    /* renamed from: a, reason: collision with root package name */
    private Context f36110a = com.mbridge.msdk.foundation.controller.c.m().d();

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.util.a f36111b = new com.mbridge.msdk.mbbanner.common.util.a();

    /* renamed from: c, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.mbbanner.common.data.b> f36112c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Boolean> f36113d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Handler> f36114e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Integer> f36115f = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.mbbanner.common.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0500a implements com.mbridge.msdk.mbbanner.common.listener.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a f36116a;

        C0500a(com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.f36116a = aVar;
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.d
        public void a(String str) {
            synchronized (a.b()) {
                this.f36116a.a("");
                a.this.f36113d.put(str, Boolean.FALSE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36118a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MBridgeIds f36119b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f36120c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f36121d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a f36122e;

        b(String str, MBridgeIds mBridgeIds, com.mbridge.msdk.mbbanner.common.listener.b bVar, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.f36118a = str;
            this.f36119b = mBridgeIds;
            this.f36120c = bVar;
            this.f36121d = str2;
            this.f36122e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Boolean bool;
            if (a.this.f36113d == null || !a.this.f36113d.containsKey(this.f36118a) || (bool = (Boolean) a.this.f36113d.get(this.f36118a)) == null || !bool.booleanValue()) {
                if (a.this.f36115f.containsKey(this.f36118a)) {
                    Integer num = (Integer) a.this.f36115f.get(this.f36118a);
                    int intValue = num != null ? num.intValue() : 0;
                    if (intValue == 2 || intValue == 4) {
                        o0.b(a.f36108g, "doUnitRotation: autoRotationStatus=" + intValue + " && unitId=" + this.f36118a);
                        if (a.this.f36111b != null) {
                            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880026);
                            bVar.a(this.f36119b);
                            a.this.f36111b.a(this.f36120c, bVar);
                            return;
                        }
                        return;
                    }
                }
                a.this.b(this.f36121d, this.f36118a, this.f36122e, this.f36120c);
            }
        }
    }

    private a() {
    }

    private com.mbridge.msdk.mbbanner.common.data.b a(String str) {
        if (this.f36112c.containsKey(str)) {
            return this.f36112c.get(str);
        }
        l e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str);
        if (e11 == null) {
            e11 = l.i(str);
        }
        com.mbridge.msdk.mbbanner.common.data.b bVar = new com.mbridge.msdk.mbbanner.common.data.b(str, "", 0, e11.y());
        this.f36112c.put(str, bVar);
        return bVar;
    }

    public static a b() {
        if (f36109h == null) {
            synchronized (a.class) {
                try {
                    if (f36109h == null) {
                        f36109h = new a();
                    }
                } finally {
                }
            }
        }
        return f36109h;
    }

    public void a(int i11, String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.b bVar) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Integer num;
        int intValue = (!this.f36115f.containsKey(str2) || (num = this.f36115f.get(str2)) == null) ? 0 : num.intValue();
        if (i11 == 1) {
            if (this.f36114e.containsKey(str2) && (handler = this.f36114e.get(str2)) != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f36115f.put(str2, Integer.valueOf(i11));
            return;
        }
        if (i11 == 2) {
            if (intValue == 1) {
                if (this.f36114e.containsKey(str2) && (handler2 = this.f36114e.get(str2)) != null) {
                    handler2.removeCallbacksAndMessages(null);
                }
                this.f36115f.put(str2, Integer.valueOf(i11));
                return;
            }
            return;
        }
        if (i11 == 3) {
            if (intValue == 2 || intValue == 4) {
                this.f36115f.put(str2, 1);
                a(str, str2, aVar, bVar);
                return;
            }
            return;
        }
        if (i11 != 4) {
            return;
        }
        if (intValue == 0) {
            this.f36115f.put(str2, 0);
            return;
        }
        if (this.f36114e.containsKey(str2) && (handler3 = this.f36114e.get(str2)) != null) {
            handler3.removeCallbacksAndMessages(null);
        }
        this.f36115f.put(str2, Integer.valueOf(i11));
    }

    public void a(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.b bVar) {
        Handler handler;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        if (aVar == null || aVar.d() <= 0) {
            o0.b(f36108g, "doUnitRotation: Illegal banner request parameters! && unitId=" + str2);
            return;
        }
        if (TextUtils.isEmpty(aVar.b())) {
            aVar.b(com.mbridge.msdk.mbbanner.common.report.a.b(""));
        }
        if (this.f36114e.containsKey(str2)) {
            handler = this.f36114e.get(str2);
        } else {
            handler = new Handler();
            this.f36114e.put(str2, handler);
        }
        Handler handler2 = handler;
        b bVar2 = new b(str2, mBridgeIds, bVar, str, aVar);
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            handler2.postDelayed(bVar2, aVar.d());
        }
    }

    public void b(String str) {
        if (this.f36114e.containsKey(str)) {
            Handler handler = this.f36114e.get(str);
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f36114e.remove(str);
        }
    }

    public void b(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.b bVar) {
        Boolean bool;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        String b11 = aVar.b();
        com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(str2, b11);
        a11.g(!TextUtils.isEmpty(aVar.a()) ? "1" : "0");
        a11.f(aVar.a());
        a11.e(aVar.f() ? "1" : "2");
        a11.b(aVar.f() ? 1 : 2);
        a11.c(aVar.d());
        com.mbridge.msdk.mbbanner.common.report.a.a("2000123", a11, (e) null);
        if (this.f36110a == null) {
            com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880025);
            bVar2.a(mBridgeIds);
            bVar2.b(b11);
            this.f36111b.a(bVar, bVar2);
            return;
        }
        if (bVar == null) {
            com.mbridge.msdk.foundation.error.b bVar3 = new com.mbridge.msdk.foundation.error.b(880001);
            bVar3.a(mBridgeIds);
            bVar3.b(b11);
            this.f36111b.a(bVar, bVar3);
            return;
        }
        Map<String, Boolean> map = this.f36113d;
        if (map != null && map.containsKey(str2) && (bool = this.f36113d.get(str2)) != null && bool.booleanValue()) {
            com.mbridge.msdk.foundation.error.b bVar4 = new com.mbridge.msdk.foundation.error.b(880016, "Current unit is loading!");
            bVar4.a(mBridgeIds);
            bVar4.b(b11);
            this.f36111b.a(bVar, bVar4);
            return;
        }
        this.f36113d.put(str2, Boolean.TRUE);
        com.mbridge.msdk.mbbanner.common.data.b a12 = a(str2);
        a12.a(b11);
        new com.mbridge.msdk.mbbanner.common.manager.b(this.f36110a, a12, bVar, this.f36111b).a(str, str2, aVar, new C0500a(aVar));
        com.mbridge.msdk.mbbanner.common.report.a.a("2000125", a11, (e) null);
    }

    public void c() {
        Map<String, com.mbridge.msdk.mbbanner.common.data.b> map = this.f36112c;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.f36113d;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f36114e;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f36114e.clear();
        }
        Map<String, Integer> map4 = this.f36115f;
        if (map4 != null) {
            map4.clear();
        }
    }
}
