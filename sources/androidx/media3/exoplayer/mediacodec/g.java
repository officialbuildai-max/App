package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.util.a1;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements v {

    /* renamed from: g, reason: collision with root package name */
    private static final ArrayDeque f12277g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f12278h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f12279a;

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f12280b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f12281c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference f12282d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.common.util.l f12283e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12284f;

    /* loaded from: classes2.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            g.this.j(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f12286a;

        /* renamed from: b, reason: collision with root package name */
        public int f12287b;

        /* renamed from: c, reason: collision with root package name */
        public int f12288c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f12289d = new MediaCodec.CryptoInfo();

        /* renamed from: e, reason: collision with root package name */
        public long f12290e;

        /* renamed from: f, reason: collision with root package name */
        public int f12291f;

        b() {
        }

        public void a(int i11, int i12, int i13, long j11, int i14) {
            this.f12286a = i11;
            this.f12287b = i12;
            this.f12288c = i13;
            this.f12290e = j11;
            this.f12291f = i14;
        }
    }

    public g(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new androidx.media3.common.util.l());
    }

    g(MediaCodec mediaCodec, HandlerThread handlerThread, androidx.media3.common.util.l lVar) {
        this.f12279a = mediaCodec;
        this.f12280b = handlerThread;
        this.f12283e = lVar;
        this.f12282d = new AtomicReference();
    }

    private void e() {
        this.f12283e.d();
        ((Handler) androidx.media3.common.util.a.e(this.f12281c)).obtainMessage(3).sendToTarget();
        this.f12283e.a();
    }

    private static void g(androidx.media3.decoder.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f11034f;
        cryptoInfo.numBytesOfClearData = i(cVar.f11032d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = i(cVar.f11033e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) androidx.media3.common.util.a.e(h(cVar.f11030b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) androidx.media3.common.util.a.e(h(cVar.f11029a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f11031c;
        if (a1.f10432a >= 24) {
            f.a();
            cryptoInfo.setPattern(androidx.media3.decoder.d.a(cVar.f11035g, cVar.f11036h));
        }
    }

    private static byte[] h(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] i(int[] iArr, int[] iArr2) {
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
    public void j(Message message) {
        b bVar;
        int i11 = message.what;
        if (i11 == 1) {
            bVar = (b) message.obj;
            k(bVar.f12286a, bVar.f12287b, bVar.f12288c, bVar.f12290e, bVar.f12291f);
        } else if (i11 != 2) {
            bVar = null;
            if (i11 == 3) {
                this.f12283e.f();
            } else if (i11 != 4) {
                androidx.compose.animation.core.j0.a(this.f12282d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                m((Bundle) message.obj);
            }
        } else {
            bVar = (b) message.obj;
            l(bVar.f12286a, bVar.f12287b, bVar.f12289d, bVar.f12290e, bVar.f12291f);
        }
        if (bVar != null) {
            p(bVar);
        }
    }

    private void k(int i11, int i12, int i13, long j11, int i14) {
        try {
            this.f12279a.queueInputBuffer(i11, i12, i13, j11, i14);
        } catch (RuntimeException e11) {
            androidx.compose.animation.core.j0.a(this.f12282d, null, e11);
        }
    }

    private void l(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        try {
            synchronized (f12278h) {
                this.f12279a.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
            }
        } catch (RuntimeException e11) {
            androidx.compose.animation.core.j0.a(this.f12282d, null, e11);
        }
    }

    private void m(Bundle bundle) {
        try {
            this.f12279a.setParameters(bundle);
        } catch (RuntimeException e11) {
            androidx.compose.animation.core.j0.a(this.f12282d, null, e11);
        }
    }

    private void n() {
        ((Handler) androidx.media3.common.util.a.e(this.f12281c)).removeCallbacksAndMessages(null);
        e();
    }

    private static b o() {
        ArrayDeque arrayDeque = f12277g;
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

    private static void p(b bVar) {
        ArrayDeque arrayDeque = f12277g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void a(int i11, int i12, int i13, long j11, int i14) {
        c();
        b o11 = o();
        o11.a(i11, i12, i13, j11, i14);
        ((Handler) a1.i(this.f12281c)).obtainMessage(1, o11).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void b(Bundle bundle) {
        c();
        ((Handler) a1.i(this.f12281c)).obtainMessage(4, bundle).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void c() {
        RuntimeException runtimeException = (RuntimeException) this.f12282d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        c();
        b o11 = o();
        o11.a(i11, i12, 0, j11, i13);
        g(cVar, o11.f12289d);
        ((Handler) a1.i(this.f12281c)).obtainMessage(2, o11).sendToTarget();
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void flush() {
        if (this.f12284f) {
            try {
                n();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void shutdown() {
        if (this.f12284f) {
            flush();
            this.f12280b.quit();
        }
        this.f12284f = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void start() {
        if (this.f12284f) {
            return;
        }
        this.f12280b.start();
        this.f12281c = new a(this.f12280b.getLooper());
        this.f12284f = true;
    }
}
