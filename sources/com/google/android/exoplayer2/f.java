package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final AudioManager f25126a;

    /* renamed from: b, reason: collision with root package name */
    private final a f25127b;

    /* renamed from: c, reason: collision with root package name */
    private b f25128c;

    /* renamed from: d, reason: collision with root package name */
    private com.google.android.exoplayer2.audio.e f25129d;

    /* renamed from: f, reason: collision with root package name */
    private int f25131f;

    /* renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f25133h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f25134i;

    /* renamed from: g, reason: collision with root package name */
    private float f25132g = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private int f25130e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f25135a;

        public a(Handler handler) {
            this.f25135a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i11) {
            f.this.h(i11);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i11) {
            this.f25135a.post(new Runnable() { // from class: com.google.android.exoplayer2.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.a.this.b(i11);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void s(float f11);

        void u(int i11);
    }

    public f(Context context, Handler handler, b bVar) {
        this.f25126a = (AudioManager) com.google.android.exoplayer2.util.a.e((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f25128c = bVar;
        this.f25127b = new a(handler);
    }

    private void a() {
        this.f25126a.abandonAudioFocus(this.f25127b);
    }

    private void b() {
        if (this.f25130e == 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.p0.f27680a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f25133h;
        if (audioFocusRequest != null) {
            this.f25126a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(com.google.android.exoplayer2.audio.e eVar) {
        if (eVar == null) {
            return 0;
        }
        switch (eVar.f24692c) {
            case 0:
                com.google.android.exoplayer2.util.s.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (eVar.f24690a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                com.google.android.exoplayer2.util.s.i("AudioFocusManager", "Unidentified audio usage: " + eVar.f24692c);
                return 0;
            case 16:
                return com.google.android.exoplayer2.util.p0.f27680a >= 19 ? 4 : 2;
        }
    }

    private void f(int i11) {
        b bVar = this.f25128c;
        if (bVar != null) {
            bVar.u(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i11) {
        if (i11 == -3 || i11 == -2) {
            if (i11 != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i11 == -1) {
            f(-1);
            b();
        } else if (i11 == 1) {
            n(1);
            f(1);
        } else {
            com.google.android.exoplayer2.util.s.i("AudioFocusManager", "Unknown focus change type: " + i11);
        }
    }

    private int j() {
        if (this.f25130e == 1) {
            return 1;
        }
        if ((com.google.android.exoplayer2.util.p0.f27680a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.f25126a.requestAudioFocus(this.f25127b, com.google.android.exoplayer2.util.p0.g0(((com.google.android.exoplayer2.audio.e) com.google.android.exoplayer2.util.a.e(this.f25129d)).f24692c), this.f25131f);
    }

    private int l() {
        AudioFocusRequest.Builder a11;
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        int requestAudioFocus;
        AudioFocusRequest audioFocusRequest = this.f25133h;
        if (audioFocusRequest == null || this.f25134i) {
            if (audioFocusRequest == null) {
                c.a();
                a11 = t1.a.a(this.f25131f);
            } else {
                c.a();
                a11 = com.google.android.exoplayer2.b.a(this.f25133h);
            }
            boolean q11 = q();
            audioAttributes = a11.setAudioAttributes(((com.google.android.exoplayer2.audio.e) com.google.android.exoplayer2.util.a.e(this.f25129d)).b().f24696a);
            willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(q11);
            onAudioFocusChangeListener = willPauseWhenDucked.setOnAudioFocusChangeListener(this.f25127b);
            build = onAudioFocusChangeListener.build();
            this.f25133h = build;
            this.f25134i = false;
        }
        requestAudioFocus = this.f25126a.requestAudioFocus(this.f25133h);
        return requestAudioFocus;
    }

    private void n(int i11) {
        if (this.f25130e == i11) {
            return;
        }
        this.f25130e = i11;
        float f11 = i11 == 3 ? 0.2f : 1.0f;
        if (this.f25132g == f11) {
            return;
        }
        this.f25132g = f11;
        b bVar = this.f25128c;
        if (bVar != null) {
            bVar.s(f11);
        }
    }

    private boolean o(int i11) {
        return i11 == 1 || this.f25131f != 1;
    }

    private boolean q() {
        com.google.android.exoplayer2.audio.e eVar = this.f25129d;
        return eVar != null && eVar.f24690a == 1;
    }

    public float g() {
        return this.f25132g;
    }

    public void i() {
        this.f25128c = null;
        b();
    }

    public void m(com.google.android.exoplayer2.audio.e eVar) {
        if (com.google.android.exoplayer2.util.p0.c(this.f25129d, eVar)) {
            return;
        }
        this.f25129d = eVar;
        int e11 = e(eVar);
        this.f25131f = e11;
        boolean z10 = true;
        if (e11 != 1 && e11 != 0) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.b(z10, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int p(boolean z10, int i11) {
        if (o(i11)) {
            b();
            return z10 ? 1 : -1;
        }
        if (z10) {
            return j();
        }
        return -1;
    }
}
