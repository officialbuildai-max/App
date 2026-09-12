package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f3 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f25139a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f25140b;

    /* renamed from: c, reason: collision with root package name */
    private final b f25141c;

    /* renamed from: d, reason: collision with root package name */
    private final AudioManager f25142d;

    /* renamed from: e, reason: collision with root package name */
    private c f25143e;

    /* renamed from: f, reason: collision with root package name */
    private int f25144f;

    /* renamed from: g, reason: collision with root package name */
    private int f25145g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25146h;

    /* loaded from: classes3.dex */
    public interface b {
        void l(int i11);

        void r(int i11, boolean z10);
    }

    /* loaded from: classes3.dex */
    private final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = f3.this.f25140b;
            final f3 f3Var = f3.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.g3
                @Override // java.lang.Runnable
                public final void run() {
                    f3.b(f3.this);
                }
            });
        }
    }

    public f3(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f25139a = applicationContext;
        this.f25140b = handler;
        this.f25141c = bVar;
        AudioManager audioManager = (AudioManager) com.google.android.exoplayer2.util.a.i((AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f25142d = audioManager;
        this.f25144f = 3;
        this.f25145g = f(audioManager, 3);
        this.f25146h = e(audioManager, this.f25144f);
        c cVar = new c();
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f25143e = cVar;
        } catch (RuntimeException e11) {
            com.google.android.exoplayer2.util.s.j("StreamVolumeManager", "Error registering stream volume receiver", e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f3 f3Var) {
        f3Var.i();
    }

    private static boolean e(AudioManager audioManager, int i11) {
        return com.google.android.exoplayer2.util.p0.f27680a >= 23 ? audioManager.isStreamMute(i11) : f(audioManager, i11) == 0;
    }

    private static int f(AudioManager audioManager, int i11) {
        try {
            return audioManager.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            com.google.android.exoplayer2.util.s.j("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i11, e11);
            return audioManager.getStreamMaxVolume(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int f11 = f(this.f25142d, this.f25144f);
        boolean e11 = e(this.f25142d, this.f25144f);
        if (this.f25145g == f11 && this.f25146h == e11) {
            return;
        }
        this.f25145g = f11;
        this.f25146h = e11;
        this.f25141c.r(f11, e11);
    }

    public int c() {
        return this.f25142d.getStreamMaxVolume(this.f25144f);
    }

    public int d() {
        int streamMinVolume;
        if (com.google.android.exoplayer2.util.p0.f27680a < 28) {
            return 0;
        }
        streamMinVolume = this.f25142d.getStreamMinVolume(this.f25144f);
        return streamMinVolume;
    }

    public void g() {
        c cVar = this.f25143e;
        if (cVar != null) {
            try {
                this.f25139a.unregisterReceiver(cVar);
            } catch (RuntimeException e11) {
                com.google.android.exoplayer2.util.s.j("StreamVolumeManager", "Error unregistering stream volume receiver", e11);
            }
            this.f25143e = null;
        }
    }

    public void h(int i11) {
        if (this.f25144f == i11) {
            return;
        }
        this.f25144f = i11;
        i();
        this.f25141c.l(i11);
    }
}
