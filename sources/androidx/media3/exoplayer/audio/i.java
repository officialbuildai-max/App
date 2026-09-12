package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11263a;

    /* renamed from: b, reason: collision with root package name */
    private final f f11264b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f11265c;

    /* renamed from: d, reason: collision with root package name */
    private final c f11266d;

    /* renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f11267e;

    /* renamed from: f, reason: collision with root package name */
    private final d f11268f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.media3.exoplayer.audio.e f11269g;

    /* renamed from: h, reason: collision with root package name */
    private j f11270h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.media3.common.c f11271i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11272j;

    /* loaded from: classes2.dex */
    private static final class b {
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            t1.m.c(context).registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            t1.m.c(context).unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    /* loaded from: classes2.dex */
    private final class c extends AudioDeviceCallback {
        private c() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            i iVar = i.this;
            iVar.f(androidx.media3.exoplayer.audio.e.f(iVar.f11263a, i.this.f11271i, i.this.f11270h));
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (androidx.media3.common.util.a1.s(audioDeviceInfoArr, i.this.f11270h)) {
                i.this.f11270h = null;
            }
            i iVar = i.this;
            iVar.f(androidx.media3.exoplayer.audio.e.f(iVar.f11263a, i.this.f11271i, i.this.f11270h));
        }
    }

    /* loaded from: classes2.dex */
    private final class d extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f11274a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f11275b;

        public d(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f11274a = contentResolver;
            this.f11275b = uri;
        }

        public void a() {
            this.f11274a.registerContentObserver(this.f11275b, false, this);
        }

        public void b() {
            this.f11274a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            i iVar = i.this;
            iVar.f(androidx.media3.exoplayer.audio.e.f(iVar.f11263a, i.this.f11271i, i.this.f11270h));
        }
    }

    /* loaded from: classes2.dex */
    private final class e extends BroadcastReceiver {
        private e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            i iVar = i.this;
            iVar.f(androidx.media3.exoplayer.audio.e.e(context, intent, iVar.f11271i, i.this.f11270h));
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(androidx.media3.exoplayer.audio.e eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public i(Context context, f fVar, androidx.media3.common.c cVar, j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.f11263a = applicationContext;
        this.f11264b = (f) androidx.media3.common.util.a.e(fVar);
        this.f11271i = cVar;
        this.f11270h = jVar;
        Handler C = androidx.media3.common.util.a1.C();
        this.f11265c = C;
        Object[] objArr = 0;
        this.f11266d = androidx.media3.common.util.a1.f10432a >= 23 ? new c() : null;
        this.f11267e = new e();
        Uri i11 = androidx.media3.exoplayer.audio.e.i();
        this.f11268f = i11 != null ? new d(C, applicationContext.getContentResolver(), i11) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(androidx.media3.exoplayer.audio.e eVar) {
        if (!this.f11272j || eVar.equals(this.f11269g)) {
            return;
        }
        this.f11269g = eVar;
        this.f11264b.a(eVar);
    }

    public androidx.media3.exoplayer.audio.e g() {
        c cVar;
        if (this.f11272j) {
            return (androidx.media3.exoplayer.audio.e) androidx.media3.common.util.a.e(this.f11269g);
        }
        this.f11272j = true;
        d dVar = this.f11268f;
        if (dVar != null) {
            dVar.a();
        }
        if (androidx.media3.common.util.a1.f10432a >= 23 && (cVar = this.f11266d) != null) {
            b.a(this.f11263a, cVar, this.f11265c);
        }
        androidx.media3.exoplayer.audio.e e11 = androidx.media3.exoplayer.audio.e.e(this.f11263a, this.f11263a.registerReceiver(this.f11267e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.f11265c), this.f11271i, this.f11270h);
        this.f11269g = e11;
        return e11;
    }

    public void h(androidx.media3.common.c cVar) {
        this.f11271i = cVar;
        f(androidx.media3.exoplayer.audio.e.f(this.f11263a, cVar, this.f11270h));
    }

    public void i(AudioDeviceInfo audioDeviceInfo) {
        j jVar = this.f11270h;
        if (Objects.equals(audioDeviceInfo, jVar == null ? null : jVar.f11278a)) {
            return;
        }
        j jVar2 = audioDeviceInfo != null ? new j(audioDeviceInfo) : null;
        this.f11270h = jVar2;
        f(androidx.media3.exoplayer.audio.e.f(this.f11263a, this.f11271i, jVar2));
    }

    public void j() {
        c cVar;
        if (this.f11272j) {
            this.f11269g = null;
            if (androidx.media3.common.util.a1.f10432a >= 23 && (cVar = this.f11266d) != null) {
                b.b(this.f11263a, cVar);
            }
            this.f11263a.unregisterReceiver(this.f11267e);
            d dVar = this.f11268f;
            if (dVar != null) {
                dVar.b();
            }
            this.f11272j = false;
        }
    }
}
