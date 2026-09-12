package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.broadcast.NetWorkChangeReceiver;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35775a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.setting.j f35776b;

    /* renamed from: c, reason: collision with root package name */
    private long f35777c;

    /* renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f35778d;

    /* renamed from: e, reason: collision with root package name */
    IntentFilter f35779e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final e0 f35780a = new e0();
    }

    private e0() {
        this.f35775a = new JSONObject();
        this.f35778d = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        this.f35779e = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public static e0 a() {
        return b.f35780a;
    }

    public void a(String str) {
        if (this.f35775a == null) {
            this.f35775a = new JSONObject();
        }
        try {
            if (!this.f35775a.optString("KEY_INFO", "").equals(str)) {
                this.f35775a.put("KEY_INFO", str);
                c.b(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_INFO", str);
            }
        } catch (Exception e11) {
            o0.b("NetAddressManager", e11.getMessage());
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f35775a.put("KEY_TIME", currentTimeMillis);
            c.b(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_TIME", Long.valueOf(currentTimeMillis));
        } catch (Exception e12) {
            o0.b("NetAddressManager", e12.getMessage());
        }
    }

    public String b() {
        try {
            if (this.f35775a == null) {
                this.f35775a = new JSONObject();
            }
            if (this.f35775a.length() < 2) {
                try {
                    this.f35775a.put("KEY_INFO", (String) c.a(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_INFO", ""));
                } catch (Exception e11) {
                    o0.b("NetAddressManager", e11.getMessage());
                }
                try {
                    this.f35775a.put("KEY_TIME", ((Long) c.a(com.mbridge.msdk.foundation.controller.c.m().d(), "KEY_TIME", 0L)).longValue());
                } catch (Exception e12) {
                    o0.b("NetAddressManager", e12.getMessage());
                }
            }
            String optString = this.f35775a.optString("KEY_INFO");
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            com.mbridge.msdk.setting.g b11 = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
            return System.currentTimeMillis() - this.f35775a.optLong("KEY_TIME") > (b11 != null ? b11.R() : 3600L) * 1000 ? "" : optString;
        } catch (Exception e13) {
            o0.b("NetAddressManager", e13.getMessage());
            return "";
        }
    }

    public void c() {
        Context d11;
        try {
            if (com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b()).S() != 1 || (d11 = com.mbridge.msdk.foundation.controller.c.m().d()) == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            this.f35779e = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            d11.registerReceiver(this.f35778d, this.f35779e);
        } catch (Exception e11) {
            o0.b("NetAddressManager", e11.getMessage());
        }
    }

    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f35777c > 3000) {
            if (this.f35776b == null) {
                this.f35776b = new com.mbridge.msdk.setting.j();
            }
            this.f35776b.c(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
            this.f35777c = currentTimeMillis;
        }
    }

    public void e() {
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d11 != null) {
            try {
                d11.unregisterReceiver(this.f35778d);
            } catch (Exception e11) {
                o0.b("NetAddressManager", e11.getMessage());
            }
        }
    }
}
