package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayDeque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f25421b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f25422c;

    /* renamed from: h, reason: collision with root package name */
    private MediaFormat f25427h;

    /* renamed from: i, reason: collision with root package name */
    private MediaFormat f25428i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec.CodecException f25429j;

    /* renamed from: k, reason: collision with root package name */
    private long f25430k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f25431l;

    /* renamed from: m, reason: collision with root package name */
    private IllegalStateException f25432m;

    /* renamed from: a, reason: collision with root package name */
    private final Object f25420a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final k f25423d = new k();

    /* renamed from: e, reason: collision with root package name */
    private final k f25424e = new k();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f25425f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque f25426g = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HandlerThread handlerThread) {
        this.f25421b = handlerThread;
    }

    private void b(MediaFormat mediaFormat) {
        this.f25424e.a(-2);
        this.f25426g.add(mediaFormat);
    }

    private void f() {
        if (!this.f25426g.isEmpty()) {
            this.f25428i = (MediaFormat) this.f25426g.getLast();
        }
        this.f25423d.b();
        this.f25424e.b();
        this.f25425f.clear();
        this.f25426g.clear();
        this.f25429j = null;
    }

    private boolean i() {
        return this.f25430k > 0 || this.f25431l;
    }

    private void j() {
        k();
        l();
    }

    private void k() {
        IllegalStateException illegalStateException = this.f25432m;
        if (illegalStateException == null) {
            return;
        }
        this.f25432m = null;
        throw illegalStateException;
    }

    private void l() {
        MediaCodec.CodecException codecException = this.f25429j;
        if (codecException == null) {
            return;
        }
        this.f25429j = null;
        throw codecException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        synchronized (this.f25420a) {
            try {
                if (this.f25431l) {
                    return;
                }
                long j11 = this.f25430k - 1;
                this.f25430k = j11;
                if (j11 > 0) {
                    return;
                }
                if (j11 < 0) {
                    n(new IllegalStateException());
                } else {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void n(IllegalStateException illegalStateException) {
        synchronized (this.f25420a) {
            this.f25432m = illegalStateException;
        }
    }

    public int c() {
        synchronized (this.f25420a) {
            try {
                int i11 = -1;
                if (i()) {
                    return -1;
                }
                j();
                if (!this.f25423d.d()) {
                    i11 = this.f25423d.e();
                }
                return i11;
            } finally {
            }
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f25420a) {
            try {
                if (i()) {
                    return -1;
                }
                j();
                if (this.f25424e.d()) {
                    return -1;
                }
                int e11 = this.f25424e.e();
                if (e11 >= 0) {
                    com.google.android.exoplayer2.util.a.i(this.f25427h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f25425f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (e11 == -2) {
                    this.f25427h = (MediaFormat) this.f25426g.remove();
                }
                return e11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e() {
        synchronized (this.f25420a) {
            this.f25430k++;
            ((Handler) p0.j(this.f25422c)).post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.m();
                }
            });
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f25420a) {
            try {
                mediaFormat = this.f25427h;
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
        com.google.android.exoplayer2.util.a.g(this.f25422c == null);
        this.f25421b.start();
        Handler handler = new Handler(this.f25421b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f25422c = handler;
    }

    public void o() {
        synchronized (this.f25420a) {
            this.f25431l = true;
            this.f25421b.quit();
            f();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f25420a) {
            this.f25429j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
        synchronized (this.f25420a) {
            this.f25423d.a(i11);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f25420a) {
            try {
                MediaFormat mediaFormat = this.f25428i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f25428i = null;
                }
                this.f25424e.a(i11);
                this.f25425f.add(bufferInfo);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f25420a) {
            b(mediaFormat);
            this.f25428i = null;
        }
    }
}
