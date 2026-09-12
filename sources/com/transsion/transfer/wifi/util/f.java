package com.transsion.transfer.wifi.util;

import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f56090a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static WifiManager.WifiLock f56091b;

    /* renamed from: c, reason: collision with root package name */
    private static PowerManager.WakeLock f56092c;

    private f() {
    }

    private final String b() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void a() {
        PowerManager.WakeLock wakeLock;
        WifiManager.WifiLock wifiLock;
        try {
            if (f56091b == null) {
                Object systemService = Utils.a().getApplicationContext().getSystemService("wifi");
                Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                f56091b = ((WifiManager) systemService).createWifiLock(3, "MB:Wifi-Connect");
            }
            if (f56092c == null) {
                Object systemService2 = Utils.a().getSystemService("power");
                Intrinsics.f(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                f56092c = ((PowerManager) systemService2).newWakeLock(1, "MB:Wifi-Connect");
            }
            WifiManager.WifiLock wifiLock2 = f56091b;
            if (wifiLock2 != null && !wifiLock2.isHeld() && (wifiLock = f56091b) != null) {
                wifiLock.acquire();
            }
            PowerManager.WakeLock wakeLock2 = f56092c;
            if (wakeLock2 == null || wakeLock2.isHeld() || (wakeLock = f56092c) == null) {
                return;
            }
            wakeLock.acquire(600000L);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = f56091b;
        if (wifiLock != null && wifiLock.isHeld()) {
            WifiManager.WifiLock wifiLock2 = f56091b;
            if (wifiLock2 != null) {
                wifiLock2.release();
            }
            f56091b = null;
            g.b(g.f56093a, b() + " --> release() --> mWifiLock?.release() --> success", false, 2, null);
        }
        PowerManager.WakeLock wakeLock = f56092c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        PowerManager.WakeLock wakeLock2 = f56092c;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        f56092c = null;
        g.b(g.f56093a, b() + " --> release() --> mWakeLock?.release() --> success", false, 2, null);
    }
}
