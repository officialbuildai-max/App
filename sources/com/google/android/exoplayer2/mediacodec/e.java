package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.compose.animation.core.j0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
class e {

    /* renamed from: g, reason: collision with root package name */
    private static final ArrayDeque f25404g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f25405h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f25406a;

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f25407b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f25408c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference f25409d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.h f25410e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25411f;

    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.f(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f25413a;

        /* renamed from: b, reason: collision with root package name */
        public int f25414b;

        /* renamed from: c, reason: collision with root package name */
        public int f25415c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f25416d = new MediaCodec.CryptoInfo();

        /* renamed from: e, reason: collision with root package name */
        public long f25417e;

        /* renamed from: f, reason: collision with root package name */
        public int f25418f;

        b() {
        }

        public void a(int i11, int i12, int i13, long j11, int i14) {
            this.f25413a = i11;
            this.f25414b = i12;
            this.f25415c = i13;
            this.f25417e = j11;
            this.f25418f = i14;
        }
    }

    public e(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new com.google.android.exoplayer2.util.h());
    }

    e(MediaCodec mediaCodec, HandlerThread handlerThread, com.google.android.exoplayer2.util.h hVar) {
        this.f25406a = mediaCodec;
        this.f25407b = handlerThread;
        this.f25410e = hVar;
        this.f25409d = new AtomicReference();
    }

    private void b() {
        this.f25410e.d();
        ((Handler) com.google.android.exoplayer2.util.a.e(this.f25408c)).obtainMessage(2).sendToTarget();
        this.f25410e.a();
    }

    private static void c(com.google.android.exoplayer2.decoder.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f24922f;
        cryptoInfo.numBytesOfClearData = e(cVar.f24920d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(cVar.f24921e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) com.google.android.exoplayer2.util.a.e(d(cVar.f24918b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) com.google.android.exoplayer2.util.a.e(d(cVar.f24917a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f24919c;
        if (p0.f27680a >= 24) {
            androidx.media3.exoplayer.mediacodec.f.a();
            cryptoInfo.setPattern(androidx.media3.decoder.d.a(cVar.f24923g, cVar.f24924h));
        }
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] e(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        b bVar;
        int i11 = message.what;
        if (i11 == 0) {
            bVar = (b) message.obj;
            g(bVar.f25413a, bVar.f25414b, bVar.f25415c, bVar.f25417e, bVar.f25418f);
        } else if (i11 != 1) {
            bVar = null;
            if (i11 != 2) {
                j0.a(this.f25409d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f25410e.f();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.f25413a, bVar.f25414b, bVar.f25416d, bVar.f25417e, bVar.f25418f);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    private void g(int i11, int i12, int i13, long j11, int i14) {
        try {
            this.f25406a.queueInputBuffer(i11, i12, i13, j11, i14);
        } catch (RuntimeException e11) {
            j0.a(this.f25409d, null, e11);
        }
    }

    private void h(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        try {
            synchronized (f25405h) {
                this.f25406a.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
            }
        } catch (RuntimeException e11) {
            j0.a(this.f25409d, null, e11);
        }
    }

    private void j() {
        ((Handler) com.google.android.exoplayer2.util.a.e(this.f25408c)).removeCallbacksAndMessages(null);
        b();
    }

    private static b k() {
        ArrayDeque arrayDeque = f25404g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return (b) arrayDeque.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void l() {
        RuntimeException runtimeException = (RuntimeException) this.f25409d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private static void o(b bVar) {
        ArrayDeque arrayDeque = f25404g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public void i() {
        if (this.f25411f) {
            try {
                j();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public void m(int i11, int i12, int i13, long j11, int i14) {
        l();
        b k11 = k();
        k11.a(i11, i12, i13, j11, i14);
        ((Handler) p0.j(this.f25408c)).obtainMessage(0, k11).sendToTarget();
    }

    public void n(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13) {
        l();
        b k11 = k();
        k11.a(i11, i12, 0, j11, i13);
        c(cVar, k11.f25416d);
        ((Handler) p0.j(this.f25408c)).obtainMessage(1, k11).sendToTarget();
    }

    public void p() {
        if (this.f25411f) {
            i();
            this.f25407b.quit();
        }
        this.f25411f = false;
    }

    public void q() {
        if (this.f25411f) {
            return;
        }
        this.f25407b.start();
        this.f25408c = new a(this.f25407b.getLooper());
        this.f25411f = true;
    }

    public void r() {
        b();
    }
}
