package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b extends e {
    public b g(int i11, ByteBuffer byteBuffer) {
        h(i11, byteBuffer);
        return this;
    }

    public void h(int i11, ByteBuffer byteBuffer) {
        c(i11, byteBuffer);
    }

    public int i(int i11) {
        int b11 = b(16);
        if (b11 != 0) {
            return this.f9168b.getInt(d(b11) + (i11 * 4));
        }
        return 0;
    }

    public int j() {
        int b11 = b(16);
        if (b11 != 0) {
            return e(b11);
        }
        return 0;
    }

    public boolean k() {
        int b11 = b(6);
        return (b11 == 0 || this.f9168b.get(b11 + this.f9167a) == 0) ? false : true;
    }

    public short l() {
        int b11 = b(14);
        if (b11 != 0) {
            return this.f9168b.getShort(b11 + this.f9167a);
        }
        return (short) 0;
    }

    public int m() {
        int b11 = b(4);
        if (b11 != 0) {
            return this.f9168b.getInt(b11 + this.f9167a);
        }
        return 0;
    }

    public short n() {
        int b11 = b(8);
        if (b11 != 0) {
            return this.f9168b.getShort(b11 + this.f9167a);
        }
        return (short) 0;
    }

    public short o() {
        int b11 = b(12);
        if (b11 != 0) {
            return this.f9168b.getShort(b11 + this.f9167a);
        }
        return (short) 0;
    }
}
