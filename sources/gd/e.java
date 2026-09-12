package gd;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import com.google.zxing.client.android.R$raw;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    private static final String f63659d = "e";

    /* renamed from: a, reason: collision with root package name */
    private final Context f63660a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f63661b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f63662c = false;

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f63660a = activity.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(MediaPlayer mediaPlayer, int i11, int i12) {
        Log.w(f63659d, "Failed to beep " + i11 + ", " + i12);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: gd.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                e.c(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: gd.d
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i11, int i12) {
                boolean d11;
                d11 = e.d(mediaPlayer2, i11, i12);
                return d11;
            }
        });
        try {
            AssetFileDescriptor openRawResourceFd = this.f63660a.getResources().openRawResourceFd(R$raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th2) {
                openRawResourceFd.close();
                throw th2;
            }
        } catch (IOException e11) {
            Log.w(f63659d, e11);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    public synchronized void f() {
        Vibrator vibrator;
        try {
            if (this.f63661b) {
                e();
            }
            if (this.f63662c && (vibrator = (Vibrator) this.f63660a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void g(boolean z10) {
        this.f63661b = z10;
    }
}
