package androidx.media3.exoplayer;

import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes2.dex */
public final class s3 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f12653a;

    /* renamed from: b, reason: collision with root package name */
    private Looper f12654b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f12655c;

    /* renamed from: d, reason: collision with root package name */
    private int f12656d;

    public s3() {
        this(null);
    }

    public s3(Looper looper) {
        this.f12653a = new Object();
        this.f12654b = looper;
        this.f12655c = null;
        this.f12656d = 0;
    }

    public Looper a() {
        Looper looper;
        synchronized (this.f12653a) {
            try {
                if (this.f12654b == null) {
                    androidx.media3.common.util.a.g(this.f12656d == 0 && this.f12655c == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f12655c = handlerThread;
                    handlerThread.start();
                    this.f12654b = this.f12655c.getLooper();
                }
                this.f12656d++;
                looper = this.f12654b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return looper;
    }

    public void b() {
        HandlerThread handlerThread;
        synchronized (this.f12653a) {
            try {
                androidx.media3.common.util.a.g(this.f12656d > 0);
                int i11 = this.f12656d - 1;
                this.f12656d = i11;
                if (i11 == 0 && (handlerThread = this.f12655c) != null) {
                    handlerThread.quit();
                    this.f12655c = null;
                    this.f12654b = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
