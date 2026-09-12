package androidx.media3.decoder;

import androidx.media3.decoder.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class SimpleDecoderOutputBuffer extends h {

    /* renamed from: a, reason: collision with root package name */
    private final h.a f11020a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f11021b;

    public SimpleDecoderOutputBuffer(h.a aVar) {
        this.f11020a = aVar;
    }

    public ByteBuffer a(int i11) {
        ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(this.f11021b);
        androidx.media3.common.util.a.a(i11 >= byteBuffer.limit());
        ByteBuffer order = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        int position = byteBuffer.position();
        byteBuffer.position(0);
        order.put(byteBuffer);
        order.position(position);
        order.limit(i11);
        this.f11021b = order;
        return order;
    }

    public ByteBuffer b(long j11, int i11) {
        this.timeUs = j11;
        ByteBuffer byteBuffer = this.f11021b;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f11021b = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        }
        this.f11021b.position(0);
        this.f11021b.limit(i11);
        return this.f11021b;
    }

    @Override // androidx.media3.decoder.h, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f11021b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // androidx.media3.decoder.h
    public void release() {
        this.f11020a.a(this);
    }
}
