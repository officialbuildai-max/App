package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* loaded from: classes5.dex */
public class c extends b {

    /* renamed from: j, reason: collision with root package name */
    private static volatile c f35086j;

    private c() {
        h();
    }

    public static void c(boolean z10) {
    }

    public static boolean l() {
        return true;
    }

    public static c m() {
        if (f35086j == null) {
            synchronized (c.class) {
                try {
                    if (f35086j == null) {
                        f35086j = new c();
                    }
                } finally {
                }
            }
        }
        return f35086j;
    }

    @Override // com.mbridge.msdk.foundation.controller.authoritycontroller.b
    public int a(g gVar, String str) {
        if (gVar == null) {
            gVar = h.b().a();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return gVar.t0();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return gVar.s0();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return gVar.u0();
        }
        return -1;
    }

    public boolean c(String str) {
        boolean z10;
        g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = h.b().a();
            z10 = true;
        } else {
            z10 = false;
        }
        int h02 = d11.h0();
        boolean z11 = h02 != 0 ? h02 == 1 && a(d11, str) == 1 : a(str) == 1 && a(d11, str) == 1;
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z11 = a(str) == 1;
        }
        return (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) && m().e() == 2) ? (d11.E0() || z10 || a(str) != 1) ? false : true : z11;
    }
}
