package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class c extends e {
    public static c i(ByteBuffer byteBuffer) {
        return j(byteBuffer, new c());
    }

    public static c j(ByteBuffer byteBuffer, c cVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return cVar.g(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public c g(int i11, ByteBuffer byteBuffer) {
        h(i11, byteBuffer);
        return this;
    }

    public void h(int i11, ByteBuffer byteBuffer) {
        c(i11, byteBuffer);
    }

    public b k(b bVar, int i11) {
        int b11 = b(6);
        if (b11 != 0) {
            return bVar.g(a(d(b11) + (i11 * 4)), this.f9168b);
        }
        return null;
    }

    public int l() {
        int b11 = b(6);
        if (b11 != 0) {
            return e(b11);
        }
        return 0;
    }

    public int m() {
        int b11 = b(4);
        if (b11 != 0) {
            return this.f9168b.getInt(b11 + this.f9167a);
        }
        return 0;
    }
}
