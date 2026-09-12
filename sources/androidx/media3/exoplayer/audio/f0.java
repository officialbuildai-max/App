package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.k;

/* loaded from: classes2.dex */
public final class f0 implements DefaultAudioSink.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11254a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f11255b;

    /* loaded from: classes2.dex */
    private static final class a {
        public static k a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z10) {
            boolean isOffloadedPlaybackSupported;
            isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes);
            return !isOffloadedPlaybackSupported ? k.f11279d : new k.b().e(true).g(z10).d();
        }
    }

    /* loaded from: classes2.dex */
    private static final class b {
        public static k a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z10) {
            int playbackOffloadSupport;
            playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            if (playbackOffloadSupport == 0) {
                return k.f11279d;
            }
            return new k.b().e(true).f(androidx.media3.common.util.a1.f10432a > 32 && playbackOffloadSupport == 2).g(z10).d();
        }
    }

    public f0() {
        this(null);
    }

    public f0(Context context) {
        this.f11254a = context;
    }

    private boolean b(Context context) {
        Boolean bool = this.f11255b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context != null) {
            String parameters = t1.m.c(context).getParameters("offloadVariableRateSupported");
            this.f11255b = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
        } else {
            this.f11255b = Boolean.FALSE;
        }
        return this.f11255b.booleanValue();
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.d
    public k a(androidx.media3.common.r rVar, androidx.media3.common.c cVar) {
        androidx.media3.common.util.a.e(rVar);
        androidx.media3.common.util.a.e(cVar);
        int i11 = androidx.media3.common.util.a1.f10432a;
        if (i11 < 29 || rVar.F == -1) {
            return k.f11279d;
        }
        boolean b11 = b(this.f11254a);
        int f11 = androidx.media3.common.y.f((String) androidx.media3.common.util.a.e(rVar.f10243o), rVar.f10239k);
        if (f11 == 0 || i11 < androidx.media3.common.util.a1.K(f11)) {
            return k.f11279d;
        }
        int M = androidx.media3.common.util.a1.M(rVar.E);
        if (M == 0) {
            return k.f11279d;
        }
        try {
            AudioFormat L = androidx.media3.common.util.a1.L(rVar.F, M, f11);
            return i11 >= 31 ? b.a(L, cVar.a().f10001a, b11) : a.a(L, cVar.a().f10001a, b11);
        } catch (IllegalArgumentException unused) {
            return k.f11279d;
        }
    }
}
