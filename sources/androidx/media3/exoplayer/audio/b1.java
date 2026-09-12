package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: classes2.dex */
public final class b1 {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f11213d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, Byte.MIN_VALUE, -69, 0, 0, 0, 0, 0};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f11214e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f11215a = AudioProcessor.f9897a;

    /* renamed from: c, reason: collision with root package name */
    private int f11217c = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f11216b = 2;

    private ByteBuffer b(ByteBuffer byteBuffer, byte[] bArr) {
        int i11;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i12 = limit - position;
        int i13 = (i12 + 255) / 255;
        int i14 = i13 + 27 + i12;
        if (this.f11216b == 2) {
            int length = bArr != null ? bArr.length + 28 : f11213d.length;
            i14 += f11214e.length + length;
            i11 = length;
        } else {
            i11 = 0;
        }
        ByteBuffer c11 = c(i14);
        if (this.f11216b == 2) {
            if (bArr != null) {
                e(c11, bArr);
            } else {
                c11.put(f11213d);
            }
            c11.put(f11214e);
        }
        int j11 = this.f11217c + l2.k0.j(byteBuffer);
        this.f11217c = j11;
        f(c11, j11, this.f11216b, i13, false);
        for (int i15 = 0; i15 < i13; i15++) {
            if (i12 >= 255) {
                c11.put((byte) -1);
                i12 -= 255;
            } else {
                c11.put((byte) i12);
                i12 = 0;
            }
        }
        while (position < limit) {
            c11.put(byteBuffer.get(position));
            position++;
        }
        byteBuffer.position(byteBuffer.limit());
        c11.flip();
        if (this.f11216b == 2) {
            byte[] array = c11.array();
            int arrayOffset = c11.arrayOffset() + i11;
            byte[] bArr2 = f11214e;
            c11.putInt(i11 + bArr2.length + 22, androidx.media3.common.util.a1.x(array, arrayOffset + bArr2.length, c11.limit() - c11.position(), 0));
        } else {
            c11.putInt(22, androidx.media3.common.util.a1.x(c11.array(), c11.arrayOffset(), c11.limit() - c11.position(), 0));
        }
        this.f11216b++;
        return c11;
    }

    private ByteBuffer c(int i11) {
        if (this.f11215a.capacity() < i11) {
            this.f11215a = ByteBuffer.allocate(i11).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f11215a.clear();
        }
        return this.f11215a;
    }

    private void e(ByteBuffer byteBuffer, byte[] bArr) {
        f(byteBuffer, 0L, 0, 1, true);
        byteBuffer.put(com.google.common.primitives.e.a(bArr.length));
        byteBuffer.put(bArr);
        byteBuffer.putInt(22, androidx.media3.common.util.a1.x(byteBuffer.array(), byteBuffer.arrayOffset(), bArr.length + 28, 0));
        byteBuffer.position(bArr.length + 28);
    }

    private void f(ByteBuffer byteBuffer, long j11, int i11, int i12, boolean z10) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z10 ? (byte) 2 : (byte) 0);
        byteBuffer.putLong(j11);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i11);
        byteBuffer.putInt(0);
        byteBuffer.put(com.google.common.primitives.e.a(i12));
    }

    public void a(DecoderInputBuffer decoderInputBuffer, List list) {
        androidx.media3.common.util.a.e(decoderInputBuffer.f11000c);
        if (decoderInputBuffer.f11000c.limit() - decoderInputBuffer.f11000c.position() == 0) {
            return;
        }
        this.f11215a = b(decoderInputBuffer.f11000c, (this.f11216b == 2 && (list.size() == 1 || list.size() == 3)) ? (byte[]) list.get(0) : null);
        decoderInputBuffer.clear();
        decoderInputBuffer.b(this.f11215a.remaining());
        decoderInputBuffer.f11000c.put(this.f11215a);
        decoderInputBuffer.d();
    }

    public void d() {
        this.f11215a = AudioProcessor.f9897a;
        this.f11217c = 0;
        this.f11216b = 2;
    }
}
