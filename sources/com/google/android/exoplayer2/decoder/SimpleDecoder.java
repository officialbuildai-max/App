package com.google.android.exoplayer2.decoder;

import java.util.ArrayDeque;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public abstract class SimpleDecoder implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Thread f24903a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f24904b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque f24905c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque f24906d = new ArrayDeque();

    /* renamed from: e, reason: collision with root package name */
    private final DecoderInputBuffer[] f24907e;

    /* renamed from: f, reason: collision with root package name */
    private final f[] f24908f;

    /* renamed from: g, reason: collision with root package name */
    private int f24909g;

    /* renamed from: h, reason: collision with root package name */
    private int f24910h;

    /* renamed from: i, reason: collision with root package name */
    private DecoderInputBuffer f24911i;

    /* renamed from: j, reason: collision with root package name */
    private DecoderException f24912j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f24913k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f24914l;

    /* renamed from: m, reason: collision with root package name */
    private int f24915m;

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, f[] fVarArr) {
        this.f24907e = decoderInputBufferArr;
        this.f24909g = decoderInputBufferArr.length;
        for (int i11 = 0; i11 < this.f24909g; i11++) {
            this.f24907e[i11] = c();
        }
        this.f24908f = fVarArr;
        this.f24910h = fVarArr.length;
        for (int i12 = 0; i12 < this.f24910h; i12++) {
            this.f24908f[i12] = d();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: com.google.android.exoplayer2.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.p();
            }
        };
        this.f24903a = thread;
        thread.start();
    }

    private boolean b() {
        return !this.f24905c.isEmpty() && this.f24910h > 0;
    }

    private boolean g() {
        DecoderException e11;
        synchronized (this.f24904b) {
            while (!this.f24914l && !b()) {
                try {
                    this.f24904b.wait();
                } finally {
                }
            }
            if (this.f24914l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f24905c.removeFirst();
            f[] fVarArr = this.f24908f;
            int i11 = this.f24910h - 1;
            this.f24910h = i11;
            f fVar = fVarArr[i11];
            boolean z10 = this.f24913k;
            this.f24913k = false;
            if (decoderInputBuffer.h()) {
                fVar.a(4);
            } else {
                if (decoderInputBuffer.g()) {
                    fVar.a(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer.i()) {
                    fVar.a(ASTNode.NOJIT);
                }
                try {
                    e11 = f(decoderInputBuffer, fVar, z10);
                } catch (OutOfMemoryError e12) {
                    e11 = e(e12);
                } catch (RuntimeException e13) {
                    e11 = e(e13);
                }
                if (e11 != null) {
                    synchronized (this.f24904b) {
                        this.f24912j = e11;
                    }
                    return false;
                }
            }
            synchronized (this.f24904b) {
                try {
                    if (this.f24913k) {
                        fVar.l();
                    } else if (fVar.g()) {
                        this.f24915m++;
                        fVar.l();
                    } else {
                        fVar.f24942c = this.f24915m;
                        this.f24915m = 0;
                        this.f24906d.addLast(fVar);
                    }
                    m(decoderInputBuffer);
                } finally {
                }
            }
            return true;
        }
    }

    private void j() {
        if (b()) {
            this.f24904b.notify();
        }
    }

    private void k() {
        DecoderException decoderException = this.f24912j;
        if (decoderException != null) {
            throw decoderException;
        }
    }

    private void m(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.b();
        DecoderInputBuffer[] decoderInputBufferArr = this.f24907e;
        int i11 = this.f24909g;
        this.f24909g = i11 + 1;
        decoderInputBufferArr[i11] = decoderInputBuffer;
    }

    private void o(f fVar) {
        fVar.b();
        f[] fVarArr = this.f24908f;
        int i11 = this.f24910h;
        this.f24910h = i11 + 1;
        fVarArr[i11] = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (g());
    }

    protected abstract DecoderInputBuffer c();

    protected abstract f d();

    protected abstract DecoderException e(Throwable th2);

    protected abstract DecoderException f(DecoderInputBuffer decoderInputBuffer, f fVar, boolean z10);

    @Override // com.google.android.exoplayer2.decoder.d
    public final void flush() {
        synchronized (this.f24904b) {
            try {
                this.f24913k = true;
                this.f24915m = 0;
                DecoderInputBuffer decoderInputBuffer = this.f24911i;
                if (decoderInputBuffer != null) {
                    m(decoderInputBuffer);
                    this.f24911i = null;
                }
                while (!this.f24905c.isEmpty()) {
                    m((DecoderInputBuffer) this.f24905c.removeFirst());
                }
                while (!this.f24906d.isEmpty()) {
                    ((f) this.f24906d.removeFirst()).l();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final DecoderInputBuffer dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.f24904b) {
            k();
            com.google.android.exoplayer2.util.a.g(this.f24911i == null);
            int i11 = this.f24909g;
            if (i11 == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.f24907e;
                int i12 = i11 - 1;
                this.f24909g = i12;
                decoderInputBuffer = decoderInputBufferArr[i12];
            }
            this.f24911i = decoderInputBuffer;
        }
        return decoderInputBuffer;
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final f dequeueOutputBuffer() {
        synchronized (this.f24904b) {
            try {
                k();
                if (this.f24906d.isEmpty()) {
                    return null;
                }
                return (f) this.f24906d.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.d
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.f24904b) {
            k();
            com.google.android.exoplayer2.util.a.a(decoderInputBuffer == this.f24911i);
            this.f24905c.addLast(decoderInputBuffer);
            j();
            this.f24911i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(f fVar) {
        synchronized (this.f24904b) {
            o(fVar);
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(int i11) {
        com.google.android.exoplayer2.util.a.g(this.f24909g == this.f24907e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.f24907e) {
            decoderInputBuffer.m(i11);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.d
    public void release() {
        synchronized (this.f24904b) {
            this.f24914l = true;
            this.f24904b.notify();
        }
        try {
            this.f24903a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
