package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.media3.exoplayer.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11697a;

    /* renamed from: b, reason: collision with root package name */
    private final a f11698b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.p f11699c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11700d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final b f11701a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.common.util.p f11702b;

        public a(androidx.media3.common.util.p pVar, b bVar) {
            this.f11702b = pVar;
            this.f11701a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (e.this.f11700d) {
                this.f11701a.m();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f11702b.post(new Runnable() { // from class: androidx.media3.exoplayer.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.this.b();
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void m();
    }

    public e(Context context, Looper looper, Looper looper2, b bVar, androidx.media3.common.util.i iVar) {
        this.f11697a = context.getApplicationContext();
        this.f11699c = iVar.createHandler(looper, null);
        this.f11698b = new a(iVar.createHandler(looper2, null), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f11697a.registerReceiver(this.f11698b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f11697a.unregisterReceiver(this.f11698b);
    }

    public void f(boolean z10) {
        if (z10 == this.f11700d) {
            return;
        }
        if (z10) {
            this.f11699c.post(new Runnable() { // from class: androidx.media3.exoplayer.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.d();
                }
            });
            this.f11700d = true;
        } else {
            this.f11699c.post(new Runnable() { // from class: androidx.media3.exoplayer.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.e();
                }
            });
            this.f11700d = false;
        }
    }
}
