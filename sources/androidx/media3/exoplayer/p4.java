package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p4 {

    /* renamed from: a, reason: collision with root package name */
    private final a f12531a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.p f12532b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12533c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12534d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f12535a;

        /* renamed from: b, reason: collision with root package name */
        private PowerManager.WakeLock f12536b;

        public a(Context context) {
            this.f12535a = context;
        }

        public void a(boolean z10, boolean z11) {
            if (z10 && this.f12536b == null) {
                PowerManager powerManager = (PowerManager) this.f12535a.getSystemService("power");
                if (powerManager == null) {
                    androidx.media3.common.util.u.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                    return;
                } else {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                    this.f12536b = newWakeLock;
                    newWakeLock.setReferenceCounted(false);
                }
            }
            PowerManager.WakeLock wakeLock = this.f12536b;
            if (wakeLock == null) {
                return;
            }
            if (z10 && z11) {
                wakeLock.acquire();
            } else {
                wakeLock.release();
            }
        }
    }

    public p4(Context context, Looper looper, androidx.media3.common.util.i iVar) {
        this.f12531a = new a(context.getApplicationContext());
        this.f12532b = iVar.createHandler(looper, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(boolean z10, boolean z11) {
        this.f12531a.a(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(boolean z10) {
        this.f12531a.a(true, z10);
    }

    public void e(final boolean z10) {
        if (this.f12533c == z10) {
            return;
        }
        this.f12533c = z10;
        final boolean z11 = this.f12534d;
        this.f12532b.post(new Runnable() { // from class: androidx.media3.exoplayer.o4
            @Override // java.lang.Runnable
            public final void run() {
                p4.this.c(z10, z11);
            }
        });
    }

    public void f(final boolean z10) {
        if (this.f12534d == z10) {
            return;
        }
        this.f12534d = z10;
        if (this.f12533c) {
            this.f12532b.post(new Runnable() { // from class: androidx.media3.exoplayer.n4
                @Override // java.lang.Runnable
                public final void run() {
                    p4.this.d(z10);
                }
            });
        }
    }
}
