package f2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.scheduler.Requirements;
import f2.c;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f62255a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0778c f62256b;

    /* renamed from: c, reason: collision with root package name */
    private final Requirements f62257c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f62258d = a1.C();

    /* renamed from: e, reason: collision with root package name */
    private b f62259e;

    /* renamed from: f, reason: collision with root package name */
    private int f62260f;

    /* renamed from: g, reason: collision with root package name */
    private d f62261g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            c.this.e();
        }
    }

    /* renamed from: f2.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0778c {
        void a(c cVar, int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class d extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        private boolean f62263a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f62264b;

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (c.this.f62261g != null) {
                c.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (c.this.f62261g != null) {
                c.this.g();
            }
        }

        private void e() {
            c.this.f62258d.post(new Runnable() { // from class: f2.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.c();
                }
            });
        }

        private void f() {
            c.this.f62258d.post(new Runnable() { // from class: f2.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.d();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z10) {
            if (z10) {
                return;
            }
            f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (this.f62263a && this.f62264b == hasCapability) {
                if (hasCapability) {
                    f();
                }
            } else {
                this.f62263a = true;
                this.f62264b = hasCapability;
                e();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            e();
        }
    }

    public c(Context context, InterfaceC0778c interfaceC0778c, Requirements requirements) {
        this.f62255a = context.getApplicationContext();
        this.f62256b = interfaceC0778c;
        this.f62257c = requirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int notMetRequirements = this.f62257c.getNotMetRequirements(this.f62255a);
        if (this.f62260f != notMetRequirements) {
            this.f62260f = notMetRequirements;
            this.f62256b.a(this, notMetRequirements);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if ((this.f62260f & 3) == 0) {
            return;
        }
        e();
    }

    private void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) androidx.media3.common.util.a.e((ConnectivityManager) this.f62255a.getSystemService("connectivity"));
        d dVar = new d();
        this.f62261g = dVar;
        connectivityManager.registerDefaultNetworkCallback(dVar);
    }

    private void k() {
        ((ConnectivityManager) androidx.media3.common.util.a.e((ConnectivityManager) this.f62255a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) androidx.media3.common.util.a.e(this.f62261g));
        this.f62261g = null;
    }

    public Requirements f() {
        return this.f62257c;
    }

    public int i() {
        this.f62260f = this.f62257c.getNotMetRequirements(this.f62255a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f62257c.isNetworkRequired()) {
            if (a1.f10432a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f62257c.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f62257c.isIdleRequired()) {
            if (a1.f10432a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f62257c.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        b bVar = new b();
        this.f62259e = bVar;
        this.f62255a.registerReceiver(bVar, intentFilter, null, this.f62258d);
        return this.f62260f;
    }

    public void j() {
        this.f62255a.unregisterReceiver((BroadcastReceiver) androidx.media3.common.util.a.e(this.f62259e));
        this.f62259e = null;
        if (a1.f10432a < 24 || this.f62261g == null) {
            return;
        }
        k();
    }
}
