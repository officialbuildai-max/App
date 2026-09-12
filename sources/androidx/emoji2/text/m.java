package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
abstract class m {

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f9209a;

        a(ByteBuffer byteBuffer) {
            this.f9209a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.m.c
        public int a() {
            return this.f9209a.getInt();
        }

        @Override // androidx.emoji2.text.m.c
        public long b() {
            return m.c(this.f9209a.getInt());
        }

        @Override // androidx.emoji2.text.m.c
        public long getPosition() {
            return this.f9209a.position();
        }

        @Override // androidx.emoji2.text.m.c
        public int readUnsignedShort() {
            return m.d(this.f9209a.getShort());
        }

        @Override // androidx.emoji2.text.m.c
        public void skip(int i11) {
            ByteBuffer byteBuffer = this.f9209a;
            byteBuffer.position(byteBuffer.position() + i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f9210a;

        /* renamed from: b, reason: collision with root package name */
        private final long f9211b;

        b(long j11, long j12) {
            this.f9210a = j11;
            this.f9211b = j12;
        }

        long a() {
            return this.f9210a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a();

        long b();

        long getPosition();

        int readUnsignedShort();

        void skip(int i11);
    }

    private static b a(c cVar) {
        long j11;
        cVar.skip(4);
        int readUnsignedShort = cVar.readUnsignedShort();
        if (readUnsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.skip(6);
        int i11 = 0;
        while (true) {
            if (i11 >= readUnsignedShort) {
                j11 = -1;
                break;
            }
            int a11 = cVar.a();
            cVar.skip(4);
            j11 = cVar.b();
            cVar.skip(4);
            if (1835365473 == a11) {
                break;
            }
            i11++;
        }
        if (j11 != -1) {
            cVar.skip((int) (j11 - cVar.getPosition()));
            cVar.skip(12);
            long b11 = cVar.b();
            for (int i12 = 0; i12 < b11; i12++) {
                int a12 = cVar.a();
                long b12 = cVar.b();
                long b13 = cVar.b();
                if (1164798569 == a12 || 1701669481 == a12) {
                    return new b(b12 + j11, b13);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.emoji2.text.flatbuffer.c b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return androidx.emoji2.text.flatbuffer.c.i(duplicate);
    }

    static long c(int i11) {
        return i11 & 4294967295L;
    }

    static int d(short s11) {
        return s11 & 65535;
    }
}
