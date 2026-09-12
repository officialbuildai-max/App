package androidx.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s4 {

    /* renamed from: a, reason: collision with root package name */
    private final a f12657a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.p f12658b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12659c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12660d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f12661a;

        /* renamed from: b, reason: collision with root package name */
        private WifiManager.WifiLock f12662b;

        public a(Context context) {
            this.f12661a = context;
        }

        public void a(boolean z10, boolean z11) {
            if (z10 && this.f12662b == null) {
                WifiManager wifiManager = (WifiManager) this.f12661a.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    androidx.media3.common.util.u.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                } else {
                    WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                    this.f12662b = createWifiLock;
                    createWifiLock.setReferenceCounted(false);
                }
            }
            WifiManager.WifiLock wifiLock = this.f12662b;
            if (wifiLock == null) {
                return;
            }
            if (z10 && z11) {
                wifiLock.acquire();
            } else {
                wifiLock.release();
            }
        }
    }

    public s4(Context context, Looper looper, androidx.media3.common.util.i iVar) {
        this.f12657a = new a(context.getApplicationContext());
        this.f12658b = iVar.createHandler(looper, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(boolean z10, boolean z11) {
        this.f12657a.a(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(boolean z10) {
        this.f12657a.a(true, z10);
    }

    public void e(final boolean z10) {
        if (this.f12659c == z10) {
            return;
        }
        this.f12659c = z10;
        final boolean z11 = this.f12660d;
        this.f12658b.post(new Runnable() { // from class: androidx.media3.exoplayer.q4
            @Override // java.lang.Runnable
            public final void run() {
                s4.this.c(z10, z11);
            }
        });
    }

    public void f(final boolean z10) {
        if (this.f12660d == z10) {
            return;
        }
        this.f12660d = z10;
        if (this.f12659c) {
            this.f12658b.post(new Runnable() { // from class: androidx.media3.exoplayer.r4
                @Override // java.lang.Runnable
                public final void run() {
                    s4.this.d(z10);
                }
            });
        }
    }
}
