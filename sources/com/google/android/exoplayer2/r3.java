package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;

/* loaded from: classes3.dex */
final class r3 {

    /* renamed from: a, reason: collision with root package name */
    private final WifiManager f25676a;

    /* renamed from: b, reason: collision with root package name */
    private WifiManager.WifiLock f25677b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f25678c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f25679d;

    public r3(Context context) {
        this.f25676a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f25677b;
        if (wifiLock == null) {
            return;
        }
        if (this.f25678c && this.f25679d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void a(boolean z10) {
        if (z10 && this.f25677b == null) {
            WifiManager wifiManager = this.f25676a;
            if (wifiManager == null) {
                com.google.android.exoplayer2.util.s.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f25677b = createWifiLock;
                createWifiLock.setReferenceCounted(false);
            }
        }
        this.f25678c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f25679d = z10;
        c();
    }
}
