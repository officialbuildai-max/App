package com.transsion.player.orplayer;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final d f48481a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f48482b;

    /* renamed from: c, reason: collision with root package name */
    private String f48483c;

    /* renamed from: d, reason: collision with root package name */
    private final AudioManager f48484d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f48485e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f48486f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f48487g;

    /* renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f48488h;

    public c(d player, Function1 callback) {
        AudioFocusRequest build;
        Intrinsics.h(player, "player");
        Intrinsics.h(callback, "callback");
        this.f48481a = player;
        this.f48482b = callback;
        this.f48483c = "AudioFocusHelper";
        Object systemService = Utils.a().getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f48484d = (AudioManager) systemService;
        oo.e.b(oo.e.f71197a, this.f48483c, "AudioFocusHelper orPlayer " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest.Builder a11 = t1.a.a(1);
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setUsage(14);
            builder.setContentType(2);
            a11.setAudioAttributes(builder.build());
            a11.setAcceptsDelayedFocusGain(true);
            a11.setOnAudioFocusChangeListener(this);
            build = a11.build();
            this.f48488h = build;
        }
    }

    private final void c(int i11) {
        oo.e eVar = oo.e.f71197a;
        oo.e.b(eVar, this.f48483c, "handleAudioFocusChange ------------ " + this + ", focusChange = " + i11, false, 4, null);
        if (i11 == -3) {
            if (!this.f48487g || this.f48481a.isMute()) {
                return;
            }
            oo.e.b(eVar, this.f48483c, "handleAudioFocusChange AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK, focusChange = " + i11, false, 4, null);
            this.f48481a.setVolume(1.0f);
            return;
        }
        if (i11 == -2 || i11 == -1) {
            oo.e.i(eVar, this.f48483c, "handleAudioFocusChange LOSS, focusChange = " + i11 + ", isUserPause = " + this.f48486f, false, 4, null);
            this.f48482b.invoke(Boolean.TRUE);
            if (this.f48487g) {
                this.f48481a.pause();
                return;
            }
            return;
        }
        if (i11 == 1 || i11 == 2) {
            oo.e.b(eVar, this.f48483c, "handleAudioFocusChange GAIN, focusChange = " + i11 + "， mStartRequested = " + this.f48485e + ", isUserPause = " + this.f48486f, false, 4, null);
            this.f48482b.invoke(Boolean.FALSE);
            if (this.f48485e && !this.f48486f) {
                this.f48481a.play();
            }
            if (this.f48481a.isMute()) {
                return;
            }
            this.f48481a.setVolume(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, int i11) {
        cVar.c(i11);
    }

    public final void b() {
        oo.e.b(oo.e.f71197a, this.f48483c, "abandonFocus " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f48488h;
            if (audioFocusRequest != null) {
                this.f48484d.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.f48484d.abandonAudioFocus(this);
        }
        this.f48485e = false;
    }

    public final void e() {
        int requestAudioFocus;
        oo.e eVar = oo.e.f71197a;
        oo.e.b(eVar, this.f48483c, "requestFocus " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f48488h;
            if (audioFocusRequest != null) {
                requestAudioFocus = this.f48484d.requestAudioFocus(audioFocusRequest);
                oo.e.b(eVar, this.f48483c, "requestFocus, result:" + requestAudioFocus, false, 4, null);
            }
        } else {
            int requestAudioFocus2 = this.f48484d.requestAudioFocus(this, 3, 1);
            oo.e.b(eVar, this.f48483c, "requestFocus, result:" + requestAudioFocus2, false, 4, null);
        }
        this.f48485e = true;
    }

    public final void f(boolean z10) {
        this.f48487g = z10;
    }

    public final void g(boolean z10) {
        this.f48486f = z10;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int i11) {
        ThreadUtils.k(new Runnable() { // from class: com.transsion.player.orplayer.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, i11);
            }
        });
    }
}
