package com.google.android.exoplayer2;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes3.dex */
final class q3 {

    /* renamed from: a, reason: collision with root package name */
    private final PowerManager f25663a;

    /* renamed from: b, reason: collision with root package name */
    private PowerManager.WakeLock f25664b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f25665c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f25666d;

    public q3(Context context) {
        this.f25663a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    private void c() {
        PowerManager.WakeLock wakeLock = this.f25664b;
        if (wakeLock == null) {
            return;
        }
        if (this.f25665c && this.f25666d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void a(boolean z10) {
        if (z10 && this.f25664b == null) {
            PowerManager powerManager = this.f25663a;
            if (powerManager == null) {
                com.google.android.exoplayer2.util.s.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f25664b = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        }
        this.f25665c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f25666d = z10;
        c();
    }
}
