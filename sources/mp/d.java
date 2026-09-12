package mp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final a f69798e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private MediaPlayer f69799a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f69800b;

    /* renamed from: c, reason: collision with root package name */
    private String f69801c = "";

    /* renamed from: d, reason: collision with root package name */
    private boolean f69802d;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d dVar, MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = dVar.f69799a;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
    }

    public final boolean b() {
        try {
            MediaPlayer mediaPlayer = this.f69799a;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void c() {
        try {
            this.f69802d = true;
            MediaPlayer mediaPlayer = this.f69799a;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                a.C0856a.f(lg.a.f68962a, "MediaPlayerHelper", message, false, 4, null);
            }
        }
    }

    public final void d(Context context, String path, boolean z10, MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer;
        Intrinsics.h(context, "context");
        Intrinsics.h(path, "path");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f69802d = false;
        if (this.f69799a == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.f69799a = mediaPlayer2;
            mediaPlayer2.setLooping(z10);
        }
        try {
            MediaPlayer mediaPlayer3 = this.f69799a;
            if (mediaPlayer3 != null) {
                if (mediaPlayer3.isPlaying()) {
                    if (TextUtils.equals(this.f69801c, path)) {
                        MediaPlayer mediaPlayer4 = this.f69799a;
                        if (mediaPlayer4 != null) {
                            mediaPlayer4.pause();
                            return;
                        }
                        return;
                    }
                    MediaPlayer mediaPlayer5 = this.f69799a;
                    if (mediaPlayer5 != null) {
                        mediaPlayer5.stop();
                    }
                    MediaPlayer mediaPlayer6 = this.f69799a;
                    if (mediaPlayer6 != null) {
                        mediaPlayer6.reset();
                    }
                    MediaPlayer mediaPlayer7 = this.f69799a;
                    if (mediaPlayer7 != null) {
                        mediaPlayer7.release();
                    }
                    this.f69799a = null;
                    MediaPlayer mediaPlayer8 = new MediaPlayer();
                    this.f69799a = mediaPlayer8;
                    mediaPlayer8.setLooping(true);
                }
            }
        } catch (IllegalStateException unused) {
            this.f69799a = null;
            this.f69801c = path;
            this.f69799a = MediaPlayer.create(context, Uri.parse(path));
        }
        try {
            MediaPlayer mediaPlayer9 = this.f69799a;
            if (mediaPlayer9 != null) {
                mediaPlayer9.reset();
            }
            this.f69801c = path;
            MediaPlayer mediaPlayer10 = this.f69799a;
            if (mediaPlayer10 != null) {
                mediaPlayer10.setDataSource(context, Uri.parse(path));
            }
            MediaPlayer mediaPlayer11 = this.f69799a;
            if (mediaPlayer11 != null) {
                mediaPlayer11.prepareAsync();
            }
            MediaPlayer mediaPlayer12 = this.f69799a;
            if (mediaPlayer12 != null) {
                mediaPlayer12.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: mp.c
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer13) {
                        d.e(d.this, mediaPlayer13);
                    }
                });
            }
            if (onCompletionListener == null || (mediaPlayer = this.f69799a) == null) {
                return;
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        } catch (IOException e11) {
            String message = e11.getMessage();
            if (message != null) {
                a.C0856a.f(lg.a.f68962a, "MediaPlayerHelper", message, false, 4, null);
            }
        } catch (IllegalArgumentException e12) {
            String message2 = e12.getMessage();
            if (message2 != null) {
                a.C0856a.f(lg.a.f68962a, "MediaPlayerHelper", message2, false, 4, null);
            }
        } catch (IllegalStateException e13) {
            String message3 = e13.getMessage();
            if (message3 != null) {
                a.C0856a.f(lg.a.f68962a, "MediaPlayerHelper", message3, false, 4, null);
            }
        } catch (SecurityException e14) {
            String message4 = e14.getMessage();
            if (message4 != null) {
                a.C0856a.f(lg.a.f68962a, "MediaPlayerHelper", message4, false, 4, null);
            }
        }
    }

    public final void f() {
        try {
            MediaPlayer mediaPlayer = this.f69799a;
            if (mediaPlayer != null) {
                Intrinsics.e(mediaPlayer);
                if (mediaPlayer.isPlaying()) {
                    MediaPlayer mediaPlayer2 = this.f69799a;
                    Intrinsics.e(mediaPlayer2);
                    mediaPlayer2.stop();
                    MediaPlayer mediaPlayer3 = this.f69799a;
                    Intrinsics.e(mediaPlayer3);
                    mediaPlayer3.release();
                    this.f69800b = null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
