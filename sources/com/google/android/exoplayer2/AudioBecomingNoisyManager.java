package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes3.dex */
final class AudioBecomingNoisyManager {

    /* renamed from: a, reason: collision with root package name */
    private final Context f24495a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioBecomingNoisyReceiver f24496b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f24497c;

    /* loaded from: classes3.dex */
    private final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {
        private final Handler eventHandler;
        private final a listener;

        public AudioBecomingNoisyReceiver(Handler handler, a aVar) {
            this.eventHandler = handler;
            this.listener = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.eventHandler.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioBecomingNoisyManager.this.f24497c) {
                this.listener.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void m();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, a aVar) {
        this.f24495a = context.getApplicationContext();
        this.f24496b = new AudioBecomingNoisyReceiver(handler, aVar);
    }

    public void b(boolean z10) {
        if (z10 && !this.f24497c) {
            this.f24495a.registerReceiver(this.f24496b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f24497c = true;
        } else {
            if (z10 || !this.f24497c) {
                return;
            }
            this.f24495a.unregisterReceiver(this.f24496b);
            this.f24497c = false;
        }
    }
}
