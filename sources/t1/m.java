package t1;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static AudioManager f76110a;

    /* renamed from: b, reason: collision with root package name */
    private static Context f76111b;

    public static int b(AudioManager audioManager, g gVar) {
        int abandonAudioFocusRequest;
        if (a1.f10432a < 26) {
            return audioManager.abandonAudioFocus(gVar.f());
        }
        abandonAudioFocusRequest = audioManager.abandonAudioFocusRequest(gVar.c());
        return abandonAudioFocusRequest;
    }

    public static synchronized AudioManager c(Context context) {
        synchronized (m.class) {
            try {
                final Context applicationContext = context.getApplicationContext();
                if (f76111b != applicationContext) {
                    f76110a = null;
                }
                AudioManager audioManager = f76110a;
                if (audioManager != null) {
                    return audioManager;
                }
                Looper myLooper = Looper.myLooper();
                if (myLooper != null && myLooper != Looper.getMainLooper()) {
                    final androidx.media3.common.util.l lVar = new androidx.media3.common.util.l();
                    androidx.media3.common.util.c.a().execute(new Runnable() { // from class: t1.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            m.h(applicationContext, lVar);
                        }
                    });
                    lVar.c();
                    return (AudioManager) androidx.media3.common.util.a.e(f76110a);
                }
                AudioManager audioManager2 = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                f76110a = audioManager2;
                return (AudioManager) androidx.media3.common.util.a.e(audioManager2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static int d(AudioManager audioManager, int i11) {
        return audioManager.getStreamMaxVolume(i11);
    }

    public static int e(AudioManager audioManager, int i11) {
        int streamMinVolume;
        if (a1.f10432a < 28) {
            return 0;
        }
        streamMinVolume = audioManager.getStreamMinVolume(i11);
        return streamMinVolume;
    }

    public static int f(AudioManager audioManager, int i11) {
        try {
            return audioManager.getStreamVolume(i11);
        } catch (RuntimeException e11) {
            u.i("AudioManagerCompat", "Could not retrieve stream volume for stream type " + i11, e11);
            return audioManager.getStreamMaxVolume(i11);
        }
    }

    public static boolean g(AudioManager audioManager, int i11) {
        return a1.f10432a >= 23 ? audioManager.isStreamMute(i11) : f(audioManager, i11) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Context context, androidx.media3.common.util.l lVar) {
        f76110a = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        lVar.f();
    }

    public static int i(AudioManager audioManager, g gVar) {
        int requestAudioFocus;
        if (a1.f10432a < 26) {
            return audioManager.requestAudioFocus(gVar.f(), gVar.b().b(), gVar.e());
        }
        requestAudioFocus = audioManager.requestAudioFocus(gVar.c());
        return requestAudioFocus;
    }
}
