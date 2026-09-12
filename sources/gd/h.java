package gd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import gd.h;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f63674a;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f63678e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f63679f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f63676c = false;

    /* renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f63675b = new b();

    /* renamed from: d, reason: collision with root package name */
    private Handler f63677d = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z10) {
            h.this.f(z10);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z10 = intent.getIntExtra("plugged", -1) <= 0;
                h.this.f63677d.post(new Runnable() { // from class: gd.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.b.this.b(z10);
                    }
                });
            }
        }
    }

    public h(Context context, Runnable runnable) {
        this.f63674a = context;
        this.f63678e = runnable;
    }

    private void e() {
        this.f63677d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z10) {
        this.f63679f = z10;
        if (this.f63676c) {
            c();
        }
    }

    private void g() {
        if (this.f63676c) {
            return;
        }
        this.f63674a.registerReceiver(this.f63675b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f63676c = true;
    }

    private void i() {
        if (this.f63676c) {
            this.f63674a.unregisterReceiver(this.f63675b);
            this.f63676c = false;
        }
    }

    public void c() {
        e();
        if (this.f63679f) {
            this.f63677d.postDelayed(this.f63678e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public void h() {
        g();
        c();
    }
}
