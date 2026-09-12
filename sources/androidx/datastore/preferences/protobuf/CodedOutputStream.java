package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends h {

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f8755c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f8756d = k1.I();

    /* renamed from: a, reason: collision with root package name */
    k f8757a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8758b;

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }

        OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        final byte[] f8759e;

        /* renamed from: f, reason: collision with root package name */
        final int f8760f;

        /* renamed from: g, reason: collision with root package name */
        int f8761g;

        /* renamed from: h, reason: collision with root package name */
        int f8762h;

        b(int i11) {
            super();
            if (i11 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i11, 20)];
            this.f8759e = bArr;
            this.f8760f = bArr.length;
        }

        final void Y0(byte b11) {
            byte[] bArr = this.f8759e;
            int i11 = this.f8761g;
            this.f8761g = i11 + 1;
            bArr[i11] = b11;
            this.f8762h++;
        }

        final void Z0(int i11) {
            byte[] bArr = this.f8759e;
            int i12 = this.f8761g;
            int i13 = i12 + 1;
            this.f8761g = i13;
            bArr[i12] = (byte) (i11 & 255);
            int i14 = i12 + 2;
            this.f8761g = i14;
            bArr[i13] = (byte) ((i11 >> 8) & 255);
            int i15 = i12 + 3;
            this.f8761g = i15;
            bArr[i14] = (byte) ((i11 >> 16) & 255);
            this.f8761g = i12 + 4;
            bArr[i15] = (byte) ((i11 >> 24) & 255);
            this.f8762h += 4;
        }

        final void a1(long j11) {
            byte[] bArr = this.f8759e;
            int i11 = this.f8761g;
            int i12 = i11 + 1;
            this.f8761g = i12;
            bArr[i11] = (byte) (j11 & 255);
            int i13 = i11 + 2;
            this.f8761g = i13;
            bArr[i12] = (byte) ((j11 >> 8) & 255);
            int i14 = i11 + 3;
            this.f8761g = i14;
            bArr[i13] = (byte) ((j11 >> 16) & 255);
            int i15 = i11 + 4;
            this.f8761g = i15;
            bArr[i14] = (byte) (255 & (j11 >> 24));
            int i16 = i11 + 5;
            this.f8761g = i16;
            bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
            int i17 = i11 + 6;
            this.f8761g = i17;
            bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
            int i18 = i11 + 7;
            this.f8761g = i18;
            bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
            this.f8761g = i11 + 8;
            bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
            this.f8762h += 8;
        }

        final void b1(int i11) {
            if (i11 >= 0) {
                d1(i11);
            } else {
                e1(i11);
            }
        }

        final void c1(int i11, int i12) {
            d1(WireFormat.c(i11, i12));
        }

        final void d1(int i11) {
            if (!CodedOutputStream.f8756d) {
                while ((i11 & (-128)) != 0) {
                    byte[] bArr = this.f8759e;
                    int i12 = this.f8761g;
                    this.f8761g = i12 + 1;
                    bArr[i12] = (byte) ((i11 | 128) & 255);
                    this.f8762h++;
                    i11 >>>= 7;
                }
                byte[] bArr2 = this.f8759e;
                int i13 = this.f8761g;
                this.f8761g = i13 + 1;
                bArr2[i13] = (byte) i11;
                this.f8762h++;
                return;
            }
            long j11 = this.f8761g;
            while ((i11 & (-128)) != 0) {
                byte[] bArr3 = this.f8759e;
                int i14 = this.f8761g;
                this.f8761g = i14 + 1;
                k1.P(bArr3, i14, (byte) ((i11 | 128) & 255));
                i11 >>>= 7;
            }
            byte[] bArr4 = this.f8759e;
            int i15 = this.f8761g;
            this.f8761g = i15 + 1;
            k1.P(bArr4, i15, (byte) i11);
            this.f8762h += (int) (this.f8761g - j11);
        }

        final void e1(long j11) {
            if (!CodedOutputStream.f8756d) {
                while ((j11 & (-128)) != 0) {
                    byte[] bArr = this.f8759e;
                    int i11 = this.f8761g;
                    this.f8761g = i11 + 1;
                    bArr[i11] = (byte) ((((int) j11) | 128) & 255);
                    this.f8762h++;
                    j11 >>>= 7;
                }
                byte[] bArr2 = this.f8759e;
                int i12 = this.f8761g;
                this.f8761g = i12 + 1;
                bArr2[i12] = (byte) j11;
                this.f8762h++;
                return;
            }
            long j12 = this.f8761g;
            while ((j11 & (-128)) != 0) {
                byte[] bArr3 = this.f8759e;
                int i13 = this.f8761g;
                this.f8761g = i13 + 1;
                k1.P(bArr3, i13, (byte) ((((int) j11) | 128) & 255));
                j11 >>>= 7;
            }
            byte[] bArr4 = this.f8759e;
            int i14 = this.f8761g;
            this.f8761g = i14 + 1;
            k1.P(bArr4, i14, (byte) j11);
            this.f8762h += (int) (this.f8761g - j12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int f0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        private final byte[] f8763e;

        /* renamed from: f, reason: collision with root package name */
        private final int f8764f;

        /* renamed from: g, reason: collision with root package name */
        private final int f8765g;

        /* renamed from: h, reason: collision with root package name */
        private int f8766h;

        c(byte[] bArr, int i11, int i12) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i13 = i11 + i12;
            if ((i11 | i12 | (bArr.length - i13)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            this.f8763e = bArr;
            this.f8764f = i11;
            this.f8766h = i11;
            this.f8765g = i13;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void B0(int i11, int i12) {
            T0(i11, 0);
            C0(i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void C0(int i11) {
            if (i11 >= 0) {
                V0(i11);
            } else {
                X0(i11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        final void F0(int i11, n0 n0Var, b1 b1Var) {
            T0(i11, 2);
            V0(((androidx.datastore.preferences.protobuf.a) n0Var).d(b1Var));
            b1Var.b(n0Var, this.f8757a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void G0(n0 n0Var) {
            V0(n0Var.getSerializedSize());
            n0Var.a(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void H0(int i11, n0 n0Var) {
            T0(1, 3);
            U0(2, i11);
            a1(3, n0Var);
            T0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void I0(int i11, ByteString byteString) {
            T0(1, 3);
            U0(2, i11);
            l0(3, byteString);
            T0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void R0(int i11, String str) {
            T0(i11, 2);
            S0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void S0(String str) {
            int i11 = this.f8766h;
            try {
                int U = CodedOutputStream.U(str.length() * 3);
                int U2 = CodedOutputStream.U(str.length());
                if (U2 == U) {
                    int i12 = i11 + U2;
                    this.f8766h = i12;
                    int i13 = Utf8.i(str, this.f8763e, i12, f0());
                    this.f8766h = i11;
                    V0((i13 - i11) - U2);
                    this.f8766h = i13;
                } else {
                    V0(Utf8.j(str));
                    this.f8766h = Utf8.i(str, this.f8763e, this.f8766h, f0());
                }
            } catch (Utf8.UnpairedSurrogateException e11) {
                this.f8766h = i11;
                a0(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException(e12);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void T0(int i11, int i12) {
            V0(WireFormat.c(i11, i12));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void U0(int i11, int i12) {
            T0(i11, 0);
            V0(i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void V0(int i11) {
            while ((i11 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f8763e;
                    int i12 = this.f8766h;
                    this.f8766h = i12 + 1;
                    bArr[i12] = (byte) ((i11 | 128) & 255);
                    i11 >>>= 7;
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), 1), e11);
                }
            }
            byte[] bArr2 = this.f8763e;
            int i13 = this.f8766h;
            this.f8766h = i13 + 1;
            bArr2[i13] = (byte) i11;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void W0(int i11, long j11) {
            T0(i11, 0);
            X0(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void X0(long j11) {
            if (CodedOutputStream.f8756d && f0() >= 10) {
                while ((j11 & (-128)) != 0) {
                    byte[] bArr = this.f8763e;
                    int i11 = this.f8766h;
                    this.f8766h = i11 + 1;
                    k1.P(bArr, i11, (byte) ((((int) j11) | 128) & 255));
                    j11 >>>= 7;
                }
                byte[] bArr2 = this.f8763e;
                int i12 = this.f8766h;
                this.f8766h = 1 + i12;
                k1.P(bArr2, i12, (byte) j11);
                return;
            }
            while ((j11 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f8763e;
                    int i13 = this.f8766h;
                    this.f8766h = i13 + 1;
                    bArr3[i13] = (byte) ((((int) j11) | 128) & 255);
                    j11 >>>= 7;
                } catch (IndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), 1), e11);
                }
            }
            byte[] bArr4 = this.f8763e;
            int i14 = this.f8766h;
            this.f8766h = i14 + 1;
            bArr4[i14] = (byte) j11;
        }

        public final void Y0(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f8763e, this.f8766h, remaining);
                this.f8766h += remaining;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), Integer.valueOf(remaining)), e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void Z() {
        }

        public final void Z0(byte[] bArr, int i11, int i12) {
            try {
                System.arraycopy(bArr, i11, this.f8763e, this.f8766h, i12);
                this.f8766h += i12;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), Integer.valueOf(i12)), e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final void a(ByteBuffer byteBuffer) {
            Y0(byteBuffer);
        }

        public final void a1(int i11, n0 n0Var) {
            T0(i11, 2);
            G0(n0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.h
        public final void b(byte[] bArr, int i11, int i12) {
            Z0(bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int f0() {
            return this.f8765g - this.f8766h;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g0(byte b11) {
            try {
                byte[] bArr = this.f8763e;
                int i11 = this.f8766h;
                this.f8766h = i11 + 1;
                bArr[i11] = b11;
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), 1), e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void h0(int i11, boolean z10) {
            T0(i11, 0);
            g0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(byte[] bArr, int i11, int i12) {
            V0(i12);
            Z0(bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void l0(int i11, ByteString byteString) {
            T0(i11, 2);
            m0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void m0(ByteString byteString) {
            V0(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void r0(int i11, int i12) {
            T0(i11, 5);
            s0(i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void s0(int i11) {
            try {
                byte[] bArr = this.f8763e;
                int i12 = this.f8766h;
                int i13 = i12 + 1;
                this.f8766h = i13;
                bArr[i12] = (byte) (i11 & 255);
                int i14 = i12 + 2;
                this.f8766h = i14;
                bArr[i13] = (byte) ((i11 >> 8) & 255);
                int i15 = i12 + 3;
                this.f8766h = i15;
                bArr[i14] = (byte) ((i11 >> 16) & 255);
                this.f8766h = i12 + 4;
                bArr[i15] = (byte) ((i11 >> 24) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), 1), e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void t0(int i11, long j11) {
            T0(i11, 1);
            u0(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void u0(long j11) {
            try {
                byte[] bArr = this.f8763e;
                int i11 = this.f8766h;
                int i12 = i11 + 1;
                this.f8766h = i12;
                bArr[i11] = (byte) (((int) j11) & 255);
                int i13 = i11 + 2;
                this.f8766h = i13;
                bArr[i12] = (byte) (((int) (j11 >> 8)) & 255);
                int i14 = i11 + 3;
                this.f8766h = i14;
                bArr[i13] = (byte) (((int) (j11 >> 16)) & 255);
                int i15 = i11 + 4;
                this.f8766h = i15;
                bArr[i14] = (byte) (((int) (j11 >> 24)) & 255);
                int i16 = i11 + 5;
                this.f8766h = i16;
                bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
                int i17 = i11 + 6;
                this.f8766h = i17;
                bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
                int i18 = i11 + 7;
                this.f8766h = i18;
                bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
                this.f8766h = i11 + 8;
                bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f8766h), Integer.valueOf(this.f8765g), 1), e11);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends b {

        /* renamed from: i, reason: collision with root package name */
        private final OutputStream f8767i;

        d(OutputStream outputStream, int i11) {
            super(i11);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f8767i = outputStream;
        }

        private void f1() {
            this.f8767i.write(this.f8759e, 0, this.f8761g);
            this.f8761g = 0;
        }

        private void g1(int i11) {
            if (this.f8760f - this.f8761g < i11) {
                f1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void B0(int i11, int i12) {
            g1(20);
            c1(i11, 0);
            b1(i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void C0(int i11) {
            if (i11 >= 0) {
                V0(i11);
            } else {
                X0(i11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        void F0(int i11, n0 n0Var, b1 b1Var) {
            T0(i11, 2);
            k1(n0Var, b1Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void G0(n0 n0Var) {
            V0(n0Var.getSerializedSize());
            n0Var.a(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void H0(int i11, n0 n0Var) {
            T0(1, 3);
            U0(2, i11);
            j1(3, n0Var);
            T0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void I0(int i11, ByteString byteString) {
            T0(1, 3);
            U0(2, i11);
            l0(3, byteString);
            T0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void R0(int i11, String str) {
            T0(i11, 2);
            S0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void S0(String str) {
            int j11;
            try {
                int length = str.length() * 3;
                int U = CodedOutputStream.U(length);
                int i11 = U + length;
                int i12 = this.f8760f;
                if (i11 > i12) {
                    byte[] bArr = new byte[length];
                    int i13 = Utf8.i(str, bArr, 0, length);
                    V0(i13);
                    b(bArr, 0, i13);
                    return;
                }
                if (i11 > i12 - this.f8761g) {
                    f1();
                }
                int U2 = CodedOutputStream.U(str.length());
                int i14 = this.f8761g;
                try {
                    if (U2 == U) {
                        int i15 = i14 + U2;
                        this.f8761g = i15;
                        int i16 = Utf8.i(str, this.f8759e, i15, this.f8760f - i15);
                        this.f8761g = i14;
                        j11 = (i16 - i14) - U2;
                        d1(j11);
                        this.f8761g = i16;
                    } else {
                        j11 = Utf8.j(str);
                        d1(j11);
                        this.f8761g = Utf8.i(str, this.f8759e, this.f8761g, j11);
                    }
                    this.f8762h += j11;
                } catch (Utf8.UnpairedSurrogateException e11) {
                    this.f8762h -= this.f8761g - i14;
                    this.f8761g = i14;
                    throw e11;
                } catch (ArrayIndexOutOfBoundsException e12) {
                    throw new OutOfSpaceException(e12);
                }
            } catch (Utf8.UnpairedSurrogateException e13) {
                a0(str, e13);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void T0(int i11, int i12) {
            V0(WireFormat.c(i11, i12));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void U0(int i11, int i12) {
            g1(20);
            c1(i11, 0);
            d1(i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void V0(int i11) {
            g1(5);
            d1(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void W0(int i11, long j11) {
            g1(20);
            c1(i11, 0);
            e1(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void X0(long j11) {
            g1(10);
            e1(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void Z() {
            if (this.f8761g > 0) {
                f1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public void a(ByteBuffer byteBuffer) {
            h1(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.h
        public void b(byte[] bArr, int i11, int i12) {
            i1(bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void g0(byte b11) {
            if (this.f8761g == this.f8760f) {
                f1();
            }
            Y0(b11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void h0(int i11, boolean z10) {
            g1(11);
            c1(i11, 0);
            Y0(z10 ? (byte) 1 : (byte) 0);
        }

        public void h1(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i11 = this.f8760f;
            int i12 = this.f8761g;
            if (i11 - i12 >= remaining) {
                byteBuffer.get(this.f8759e, i12, remaining);
                this.f8761g += remaining;
                this.f8762h += remaining;
                return;
            }
            int i13 = i11 - i12;
            byteBuffer.get(this.f8759e, i12, i13);
            int i14 = remaining - i13;
            this.f8761g = this.f8760f;
            this.f8762h += i13;
            f1();
            while (true) {
                int i15 = this.f8760f;
                if (i14 <= i15) {
                    byteBuffer.get(this.f8759e, 0, i14);
                    this.f8761g = i14;
                    this.f8762h += i14;
                    return;
                } else {
                    byteBuffer.get(this.f8759e, 0, i15);
                    this.f8767i.write(this.f8759e, 0, this.f8760f);
                    int i16 = this.f8760f;
                    i14 -= i16;
                    this.f8762h += i16;
                }
            }
        }

        public void i1(byte[] bArr, int i11, int i12) {
            int i13 = this.f8760f;
            int i14 = this.f8761g;
            if (i13 - i14 >= i12) {
                System.arraycopy(bArr, i11, this.f8759e, i14, i12);
                this.f8761g += i12;
                this.f8762h += i12;
                return;
            }
            int i15 = i13 - i14;
            System.arraycopy(bArr, i11, this.f8759e, i14, i15);
            int i16 = i11 + i15;
            int i17 = i12 - i15;
            this.f8761g = this.f8760f;
            this.f8762h += i15;
            f1();
            if (i17 <= this.f8760f) {
                System.arraycopy(bArr, i16, this.f8759e, 0, i17);
                this.f8761g = i17;
            } else {
                this.f8767i.write(bArr, i16, i17);
            }
            this.f8762h += i17;
        }

        public void j1(int i11, n0 n0Var) {
            T0(i11, 2);
            G0(n0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void k0(byte[] bArr, int i11, int i12) {
            V0(i12);
            i1(bArr, i11, i12);
        }

        void k1(n0 n0Var, b1 b1Var) {
            V0(((androidx.datastore.preferences.protobuf.a) n0Var).d(b1Var));
            b1Var.b(n0Var, this.f8757a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void l0(int i11, ByteString byteString) {
            T0(i11, 2);
            m0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void m0(ByteString byteString) {
            V0(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void r0(int i11, int i12) {
            g1(14);
            c1(i11, 5);
            Z0(i12);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void s0(int i11) {
            g1(4);
            Z0(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void t0(int i11, long j11) {
            g1(18);
            c1(i11, 1);
            a1(j11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void u0(long j11) {
            g1(8);
            a1(j11);
        }
    }

    private CodedOutputStream() {
    }

    public static int A(int i11, a0 a0Var) {
        return S(i11) + B(a0Var);
    }

    public static int B(a0 a0Var) {
        return C(a0Var.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(int i11) {
        return U(i11) + i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i11, n0 n0Var, b1 b1Var) {
        return S(i11) + F(n0Var, b1Var);
    }

    public static int E(n0 n0Var) {
        return C(n0Var.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(n0 n0Var, b1 b1Var) {
        return C(((androidx.datastore.preferences.protobuf.a) n0Var).d(b1Var));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i11) {
        if (i11 > 4096) {
            return 4096;
        }
        return i11;
    }

    public static int H(int i11, ByteString byteString) {
        return (S(1) * 2) + T(2, i11) + h(3, byteString);
    }

    public static int I(int i11, int i12) {
        return S(i11) + J(i12);
    }

    public static int J(int i11) {
        return 4;
    }

    public static int K(int i11, long j11) {
        return S(i11) + L(j11);
    }

    public static int L(long j11) {
        return 8;
    }

    public static int M(int i11, int i12) {
        return S(i11) + N(i12);
    }

    public static int N(int i11) {
        return U(X(i11));
    }

    public static int O(int i11, long j11) {
        return S(i11) + P(j11);
    }

    public static int P(long j11) {
        return W(Y(j11));
    }

    public static int Q(int i11, String str) {
        return S(i11) + R(str);
    }

    public static int R(String str) {
        int length;
        try {
            length = Utf8.j(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(w.f8998b).length;
        }
        return C(length);
    }

    public static int S(int i11) {
        return U(WireFormat.c(i11, 0));
    }

    public static int T(int i11, int i12) {
        return S(i11) + U(i12);
    }

    public static int U(int i11) {
        return (352 - (Integer.numberOfLeadingZeros(i11) * 9)) >>> 6;
    }

    public static int V(int i11, long j11) {
        return S(i11) + W(j11);
    }

    public static int W(long j11) {
        return (640 - (Long.numberOfLeadingZeros(j11) * 9)) >>> 6;
    }

    public static int X(int i11) {
        return (i11 >> 31) ^ (i11 << 1);
    }

    public static long Y(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }

    public static CodedOutputStream c0(OutputStream outputStream, int i11) {
        return new d(outputStream, i11);
    }

    public static CodedOutputStream d0(byte[] bArr) {
        return e0(bArr, 0, bArr.length);
    }

    public static int e(int i11, boolean z10) {
        return S(i11) + f(z10);
    }

    public static CodedOutputStream e0(byte[] bArr, int i11, int i12) {
        return new c(bArr, i11, i12);
    }

    public static int f(boolean z10) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return C(bArr.length);
    }

    public static int h(int i11, ByteString byteString) {
        return S(i11) + i(byteString);
    }

    public static int i(ByteString byteString) {
        return C(byteString.size());
    }

    public static int j(int i11, double d11) {
        return S(i11) + k(d11);
    }

    public static int k(double d11) {
        return 8;
    }

    public static int l(int i11, int i12) {
        return S(i11) + m(i12);
    }

    public static int m(int i11) {
        return x(i11);
    }

    public static int n(int i11, int i12) {
        return S(i11) + o(i12);
    }

    public static int o(int i11) {
        return 4;
    }

    public static int p(int i11, long j11) {
        return S(i11) + q(j11);
    }

    public static int q(long j11) {
        return 8;
    }

    public static int r(int i11, float f11) {
        return S(i11) + s(f11);
    }

    public static int s(float f11) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(int i11, n0 n0Var, b1 b1Var) {
        return (S(i11) * 2) + v(n0Var, b1Var);
    }

    public static int u(n0 n0Var) {
        return n0Var.getSerializedSize();
    }

    static int v(n0 n0Var, b1 b1Var) {
        return ((androidx.datastore.preferences.protobuf.a) n0Var).d(b1Var);
    }

    public static int w(int i11, int i12) {
        return S(i11) + x(i12);
    }

    public static int x(int i11) {
        return W(i11);
    }

    public static int y(int i11, long j11) {
        return S(i11) + z(j11);
    }

    public static int z(long j11) {
        return W(j11);
    }

    final void A0(n0 n0Var, b1 b1Var) {
        b1Var.b(n0Var, this.f8757a);
    }

    public abstract void B0(int i11, int i12);

    public abstract void C0(int i11);

    public final void D0(int i11, long j11) {
        W0(i11, j11);
    }

    public final void E0(long j11) {
        X0(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void F0(int i11, n0 n0Var, b1 b1Var);

    public abstract void G0(n0 n0Var);

    public abstract void H0(int i11, n0 n0Var);

    public abstract void I0(int i11, ByteString byteString);

    public final void J0(int i11, int i12) {
        r0(i11, i12);
    }

    public final void K0(int i11) {
        s0(i11);
    }

    public final void L0(int i11, long j11) {
        t0(i11, j11);
    }

    public final void M0(long j11) {
        u0(j11);
    }

    public final void N0(int i11, int i12) {
        U0(i11, X(i12));
    }

    public final void O0(int i11) {
        V0(X(i11));
    }

    public final void P0(int i11, long j11) {
        W0(i11, Y(j11));
    }

    public final void Q0(long j11) {
        X0(Y(j11));
    }

    public abstract void R0(int i11, String str);

    public abstract void S0(String str);

    public abstract void T0(int i11, int i12);

    public abstract void U0(int i11, int i12);

    public abstract void V0(int i11);

    public abstract void W0(int i11, long j11);

    public abstract void X0(long j11);

    public abstract void Z();

    final void a0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) {
        f8755c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(w.f8998b);
        try {
            V0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException(e11);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h
    public abstract void b(byte[] bArr, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b0() {
        return this.f8758b;
    }

    public final void d() {
        if (f0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int f0();

    public abstract void g0(byte b11);

    public abstract void h0(int i11, boolean z10);

    public final void i0(boolean z10) {
        g0(z10 ? (byte) 1 : (byte) 0);
    }

    public final void j0(byte[] bArr) {
        k0(bArr, 0, bArr.length);
    }

    abstract void k0(byte[] bArr, int i11, int i12);

    public abstract void l0(int i11, ByteString byteString);

    public abstract void m0(ByteString byteString);

    public final void n0(int i11, double d11) {
        t0(i11, Double.doubleToRawLongBits(d11));
    }

    public final void o0(double d11) {
        u0(Double.doubleToRawLongBits(d11));
    }

    public final void p0(int i11, int i12) {
        B0(i11, i12);
    }

    public final void q0(int i11) {
        C0(i11);
    }

    public abstract void r0(int i11, int i12);

    public abstract void s0(int i11);

    public abstract void t0(int i11, long j11);

    public abstract void u0(long j11);

    public final void v0(int i11, float f11) {
        r0(i11, Float.floatToRawIntBits(f11));
    }

    public final void w0(float f11) {
        s0(Float.floatToRawIntBits(f11));
    }

    public final void x0(int i11, n0 n0Var) {
        T0(i11, 3);
        z0(n0Var);
        T0(i11, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y0(int i11, n0 n0Var, b1 b1Var) {
        T0(i11, 3);
        A0(n0Var, b1Var);
        T0(i11, 4);
    }

    public final void z0(n0 n0Var) {
        n0Var.a(this);
    }
}
