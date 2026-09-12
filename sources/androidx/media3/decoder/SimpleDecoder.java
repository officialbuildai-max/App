package androidx.media3.decoder;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayDeque;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public abstract class SimpleDecoder implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Thread f11006a;

    /* renamed from: e, reason: collision with root package name */
    private final DecoderInputBuffer[] f11010e;

    /* renamed from: f, reason: collision with root package name */
    private final h[] f11011f;

    /* renamed from: g, reason: collision with root package name */
    private int f11012g;

    /* renamed from: h, reason: collision with root package name */
    private int f11013h;

    /* renamed from: i, reason: collision with root package name */
    private DecoderInputBuffer f11014i;

    /* renamed from: j, reason: collision with root package name */
    private DecoderException f11015j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11016k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f11017l;

    /* renamed from: m, reason: collision with root package name */
    private int f11018m;

    /* renamed from: b, reason: collision with root package name */
    private final Object f11007b = new Object();

    /* renamed from: n, reason: collision with root package name */
    private long f11019n = C.TIME_UNSET;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f11008c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque f11009d = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, h[] hVarArr) {
        this.f11010e = decoderInputBufferArr;
        this.f11012g = decoderInputBufferArr.length;
        for (int i11 = 0; i11 < this.f11012g; i11++) {
            this.f11010e[i11] = e();
        }
        this.f11011f = hVarArr;
        this.f11013h = hVarArr.length;
        for (int i12 = 0; i12 < this.f11013h; i12++) {
            this.f11011f[i12] = f();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: androidx.media3.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.r();
            }
        };
        this.f11006a = thread;
        thread.start();
    }

    private boolean d() {
        return !this.f11008c.isEmpty() && this.f11013h > 0;
    }

    private boolean i() {
        DecoderException g11;
        synchronized (this.f11007b) {
            while (!this.f11017l && !d()) {
                try {
                    this.f11007b.wait();
                } finally {
                }
            }
            if (this.f11017l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f11008c.removeFirst();
            h[] hVarArr = this.f11011f;
            int i11 = this.f11013h - 1;
            this.f11013h = i11;
            h hVar = hVarArr[i11];
            boolean z10 = this.f11016k;
            this.f11016k = false;
            if (decoderInputBuffer.isEndOfStream()) {
                hVar.addFlag(4);
            } else {
                hVar.timeUs = decoderInputBuffer.f11002e;
                if (decoderInputBuffer.isFirstSample()) {
                    hVar.addFlag(ASTNode.NOJIT);
                }
                if (!l(decoderInputBuffer.f11002e)) {
                    hVar.shouldBeSkipped = true;
                }
                try {
                    g11 = h(decoderInputBuffer, hVar, z10);
                } catch (OutOfMemoryError e11) {
                    g11 = g(e11);
                } catch (RuntimeException e12) {
                    g11 = g(e12);
                }
                if (g11 != null) {
                    synchronized (this.f11007b) {
                        this.f11015j = g11;
                    }
                    return false;
                }
            }
            synchronized (this.f11007b) {
                try {
                    if (this.f11016k) {
                        hVar.release();
                    } else if (hVar.shouldBeSkipped) {
                        this.f11018m++;
                        hVar.release();
                    } else {
                        hVar.skippedOutputBufferCount = this.f11018m;
                        this.f11018m = 0;
                        this.f11009d.addLast(hVar);
                    }
                    o(decoderInputBuffer);
                } finally {
                }
            }
            return true;
        }
    }

    private void m() {
        if (d()) {
            this.f11007b.notify();
        }
    }

    private void n() {
        DecoderException decoderException = this.f11015j;
        if (decoderException != null) {
            throw decoderException;
        }
    }

    private void o(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.clear();
        DecoderInputBuffer[] decoderInputBufferArr = this.f11010e;
        int i11 = this.f11012g;
        this.f11012g = i11 + 1;
        decoderInputBufferArr[i11] = decoderInputBuffer;
    }

    private void q(h hVar) {
        hVar.clear();
        h[] hVarArr = this.f11011f;
        int i11 = this.f11013h;
        this.f11013h = i11 + 1;
        hVarArr[i11] = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (i());
    }

    @Override // androidx.media3.decoder.g
    public final void a(long j11) {
        boolean z10;
        synchronized (this.f11007b) {
            try {
                if (this.f11012g != this.f11010e.length && !this.f11016k) {
                    z10 = false;
                    androidx.media3.common.util.a.g(z10);
                    this.f11019n = j11;
                }
                z10 = true;
                androidx.media3.common.util.a.g(z10);
                this.f11019n = j11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.media3.decoder.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.f11007b) {
            n();
            androidx.media3.common.util.a.a(decoderInputBuffer == this.f11014i);
            this.f11008c.addLast(decoderInputBuffer);
            m();
            this.f11014i = null;
        }
    }

    protected abstract DecoderInputBuffer e();

    protected abstract h f();

    @Override // androidx.media3.decoder.g
    public final void flush() {
        synchronized (this.f11007b) {
            try {
                this.f11016k = true;
                this.f11018m = 0;
                DecoderInputBuffer decoderInputBuffer = this.f11014i;
                if (decoderInputBuffer != null) {
                    o(decoderInputBuffer);
                    this.f11014i = null;
                }
                while (!this.f11008c.isEmpty()) {
                    o((DecoderInputBuffer) this.f11008c.removeFirst());
                }
                while (!this.f11009d.isEmpty()) {
                    ((h) this.f11009d.removeFirst()).release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    protected abstract DecoderException g(Throwable th2);

    protected abstract DecoderException h(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z10);

    @Override // androidx.media3.decoder.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final DecoderInputBuffer dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.f11007b) {
            n();
            androidx.media3.common.util.a.g(this.f11014i == null);
            int i11 = this.f11012g;
            if (i11 == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.f11010e;
                int i12 = i11 - 1;
                this.f11012g = i12;
                decoderInputBuffer = decoderInputBufferArr[i12];
            }
            this.f11014i = decoderInputBuffer;
        }
        return decoderInputBuffer;
    }

    @Override // androidx.media3.decoder.g
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final h dequeueOutputBuffer() {
        synchronized (this.f11007b) {
            try {
                n();
                if (this.f11009d.isEmpty()) {
                    return null;
                }
                return (h) this.f11009d.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean l(long j11) {
        boolean z10;
        synchronized (this.f11007b) {
            long j12 = this.f11019n;
            z10 = j12 == C.TIME_UNSET || j11 >= j12;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(h hVar) {
        synchronized (this.f11007b) {
            q(hVar);
            m();
        }
    }

    @Override // androidx.media3.decoder.g
    public void release() {
        synchronized (this.f11007b) {
            this.f11017l = true;
            this.f11007b.notify();
        }
        try {
            this.f11006a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(int i11) {
        androidx.media3.common.util.a.g(this.f11012g == this.f11010e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.f11010e) {
            decoderInputBuffer.b(i11);
        }
    }
}
