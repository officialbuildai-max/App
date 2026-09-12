package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.mediacodec.t;
import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f12296b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f12297c;

    /* renamed from: h, reason: collision with root package name */
    private MediaFormat f12302h;

    /* renamed from: i, reason: collision with root package name */
    private MediaFormat f12303i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec.CodecException f12304j;

    /* renamed from: k, reason: collision with root package name */
    private MediaCodec.CryptoException f12305k;

    /* renamed from: l, reason: collision with root package name */
    private long f12306l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f12307m;

    /* renamed from: n, reason: collision with root package name */
    private IllegalStateException f12308n;

    /* renamed from: o, reason: collision with root package name */
    private t.c f12309o;

    /* renamed from: a, reason: collision with root package name */
    private final Object f12295a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.collection.f f12298d = new androidx.collection.f();

    /* renamed from: e, reason: collision with root package name */
    private final androidx.collection.f f12299e = new androidx.collection.f();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f12300f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque f12301g = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HandlerThread handlerThread) {
        this.f12296b = handlerThread;
    }

    private void b(MediaFormat mediaFormat) {
        this.f12299e.a(-2);
        this.f12301g.add(mediaFormat);
    }

    private void f() {
        if (!this.f12301g.isEmpty()) {
            this.f12303i = (MediaFormat) this.f12301g.getLast();
        }
        this.f12298d.b();
        this.f12299e.b();
        this.f12300f.clear();
        this.f12301g.clear();
    }

    private boolean i() {
        return this.f12306l > 0 || this.f12307m;
    }

    private void j() {
        k();
        m();
        l();
    }

    private void k() {
        IllegalStateException illegalStateException = this.f12308n;
        if (illegalStateException == null) {
            return;
        }
        this.f12308n = null;
        throw illegalStateException;
    }

    private void l() {
        MediaCodec.CryptoException cryptoException = this.f12305k;
        if (cryptoException == null) {
            return;
        }
        this.f12305k = null;
        throw cryptoException;
    }

    private void m() {
        MediaCodec.CodecException codecException = this.f12304j;
        if (codecException == null) {
            return;
        }
        this.f12304j = null;
        throw codecException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.f12295a) {
            try {
                if (this.f12307m) {
                    return;
                }
                long j11 = this.f12306l - 1;
                this.f12306l = j11;
                if (j11 > 0) {
                    return;
                }
                if (j11 < 0) {
                    o(new IllegalStateException());
                } else {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void o(IllegalStateException illegalStateException) {
        synchronized (this.f12295a) {
            this.f12308n = illegalStateException;
        }
    }

    public int c() {
        synchronized (this.f12295a) {
            try {
                j();
                int i11 = -1;
                if (i()) {
                    return -1;
                }
                if (!this.f12298d.d()) {
                    i11 = this.f12298d.e();
                }
                return i11;
            } finally {
            }
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f12295a) {
            try {
                j();
                if (i()) {
                    return -1;
                }
                if (this.f12299e.d()) {
                    return -1;
                }
                int e11 = this.f12299e.e();
                if (e11 >= 0) {
                    androidx.media3.common.util.a.i(this.f12302h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f12300f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (e11 == -2) {
                    this.f12302h = (MediaFormat) this.f12301g.remove();
                }
                return e11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e() {
        synchronized (this.f12295a) {
            this.f12306l++;
            ((Handler) a1.i(this.f12297c)).post(new Runnable() { // from class: androidx.media3.exoplayer.mediacodec.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.n();
                }
            });
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f12295a) {
            try {
                mediaFormat = this.f12302h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        androidx.media3.common.util.a.g(this.f12297c == null);
        this.f12296b.start();
        Handler handler = new Handler(this.f12296b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f12297c = handler;
    }

    @Override // android.media.MediaCodec.Callback
    public void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f12295a) {
            this.f12305k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f12295a) {
            this.f12304j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
        synchronized (this.f12295a) {
            try {
                this.f12298d.a(i11);
                t.c cVar = this.f12309o;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f12295a) {
            try {
                MediaFormat mediaFormat = this.f12303i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f12303i = null;
                }
                this.f12299e.a(i11);
                this.f12300f.add(bufferInfo);
                t.c cVar = this.f12309o;
                if (cVar != null) {
                    cVar.b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f12295a) {
            b(mediaFormat);
            this.f12303i = null;
        }
    }

    public void p(t.c cVar) {
        synchronized (this.f12295a) {
            this.f12309o = cVar;
        }
    }

    public void q() {
        synchronized (this.f12295a) {
            this.f12307m = true;
            this.f12296b.quit();
            f();
        }
    }
}
