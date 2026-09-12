package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.m1;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class DecoderInputBuffer extends a {

    /* renamed from: b, reason: collision with root package name */
    public final c f24896b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f24897c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f24898d;

    /* renamed from: e, reason: collision with root package name */
    public long f24899e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f24900f;

    /* renamed from: g, reason: collision with root package name */
    private final int f24901g;

    /* renamed from: h, reason: collision with root package name */
    private final int f24902h;

    /* loaded from: classes3.dex */
    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i11, int i12) {
            super("Buffer too small (" + i11 + " < " + i12 + ")");
            this.currentCapacity = i11;
            this.requiredCapacity = i12;
        }
    }

    static {
        m1.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i11) {
        this(i11, 0);
    }

    public DecoderInputBuffer(int i11, int i12) {
        this.f24896b = new c();
        this.f24901g = i11;
        this.f24902h = i12;
    }

    private ByteBuffer l(int i11) {
        int i12 = this.f24901g;
        if (i12 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i12 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.f24897c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i11);
    }

    public static DecoderInputBuffer p() {
        return new DecoderInputBuffer(0);
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.f24897c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f24900f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f24898d = false;
    }

    public void m(int i11) {
        int i12 = i11 + this.f24902h;
        ByteBuffer byteBuffer = this.f24897c;
        if (byteBuffer == null) {
            this.f24897c = l(i12);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i13 = i12 + position;
        if (capacity >= i13) {
            this.f24897c = byteBuffer;
            return;
        }
        ByteBuffer l11 = l(i13);
        l11.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            l11.put(byteBuffer);
        }
        this.f24897c = l11;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.f24897c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f24900f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean o() {
        return e(1073741824);
    }

    public void q(int i11) {
        ByteBuffer byteBuffer = this.f24900f;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f24900f = ByteBuffer.allocate(i11);
        } else {
            this.f24900f.clear();
        }
    }
}
