package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f8868f = 100;

    /* renamed from: a, reason: collision with root package name */
    int f8869a;

    /* renamed from: b, reason: collision with root package name */
    int f8870b;

    /* renamed from: c, reason: collision with root package name */
    int f8871c;

    /* renamed from: d, reason: collision with root package name */
    j f8872d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8873e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends i {

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f8874g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f8875h;

        /* renamed from: i, reason: collision with root package name */
        private int f8876i;

        /* renamed from: j, reason: collision with root package name */
        private int f8877j;

        /* renamed from: k, reason: collision with root package name */
        private int f8878k;

        /* renamed from: l, reason: collision with root package name */
        private int f8879l;

        /* renamed from: m, reason: collision with root package name */
        private int f8880m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f8881n;

        /* renamed from: o, reason: collision with root package name */
        private int f8882o;

        private b(byte[] bArr, int i11, int i12, boolean z10) {
            super();
            this.f8882o = Integer.MAX_VALUE;
            this.f8874g = bArr;
            this.f8876i = i12 + i11;
            this.f8878k = i11;
            this.f8879l = i11;
            this.f8875h = z10;
        }

        private void Q() {
            int i11 = this.f8876i + this.f8877j;
            this.f8876i = i11;
            int i12 = i11 - this.f8879l;
            int i13 = this.f8882o;
            if (i12 <= i13) {
                this.f8877j = 0;
                return;
            }
            int i14 = i12 - i13;
            this.f8877j = i14;
            this.f8876i = i11 - i14;
        }

        private void S() {
            if (this.f8876i - this.f8878k >= 10) {
                T();
            } else {
                U();
            }
        }

        private void T() {
            for (int i11 = 0; i11 < 10; i11++) {
                byte[] bArr = this.f8874g;
                int i12 = this.f8878k;
                this.f8878k = i12 + 1;
                if (bArr[i12] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void U() {
            for (int i11 = 0; i11 < 10; i11++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int A() {
            return i.c(N());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long B() {
            return i.d(O());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String C() {
            int N = N();
            if (N > 0) {
                int i11 = this.f8876i;
                int i12 = this.f8878k;
                if (N <= i11 - i12) {
                    String str = new String(this.f8874g, i12, N, w.f8998b);
                    this.f8878k += N;
                    return str;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String D() {
            int N = N();
            if (N > 0) {
                int i11 = this.f8876i;
                int i12 = this.f8878k;
                if (N <= i11 - i12) {
                    String h11 = Utf8.h(this.f8874g, i12, N);
                    this.f8878k += N;
                    return h11;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int E() {
            if (f()) {
                this.f8880m = 0;
                return 0;
            }
            int N = N();
            this.f8880m = N;
            if (WireFormat.a(N) != 0) {
                return this.f8880m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int F() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long G() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean H(int i11) {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                S();
                return true;
            }
            if (b11 == 1) {
                R(8);
                return true;
            }
            if (b11 == 2) {
                R(N());
                return true;
            }
            if (b11 == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (b11 == 4) {
                return false;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            R(4);
            return true;
        }

        public byte J() {
            int i11 = this.f8878k;
            if (i11 == this.f8876i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f8874g;
            this.f8878k = i11 + 1;
            return bArr[i11];
        }

        public byte[] K(int i11) {
            if (i11 > 0) {
                int i12 = this.f8876i;
                int i13 = this.f8878k;
                if (i11 <= i12 - i13) {
                    int i14 = i11 + i13;
                    this.f8878k = i14;
                    return Arrays.copyOfRange(this.f8874g, i13, i14);
                }
            }
            if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                return w.f9000d;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public int L() {
            int i11 = this.f8878k;
            if (this.f8876i - i11 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f8874g;
            this.f8878k = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public long M() {
            int i11 = this.f8878k;
            if (this.f8876i - i11 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f8874g;
            this.f8878k = i11 + 8;
            return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
        }

        public int N() {
            int i11;
            int i12 = this.f8878k;
            int i13 = this.f8876i;
            if (i13 != i12) {
                byte[] bArr = this.f8874g;
                int i14 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 >= 0) {
                    this.f8878k = i14;
                    return b11;
                }
                if (i13 - i14 >= 9) {
                    int i15 = i12 + 2;
                    int i16 = (bArr[i14] << 7) ^ b11;
                    if (i16 < 0) {
                        i11 = i16 ^ (-128);
                    } else {
                        int i17 = i12 + 3;
                        int i18 = (bArr[i15] << 14) ^ i16;
                        if (i18 >= 0) {
                            i11 = i18 ^ 16256;
                        } else {
                            int i19 = i12 + 4;
                            int i20 = i18 ^ (bArr[i17] << 21);
                            if (i20 < 0) {
                                i11 = (-2080896) ^ i20;
                            } else {
                                i17 = i12 + 5;
                                byte b12 = bArr[i19];
                                int i21 = (i20 ^ (b12 << 28)) ^ 266354560;
                                if (b12 < 0) {
                                    i19 = i12 + 6;
                                    if (bArr[i17] < 0) {
                                        i17 = i12 + 7;
                                        if (bArr[i19] < 0) {
                                            i19 = i12 + 8;
                                            if (bArr[i17] < 0) {
                                                i17 = i12 + 9;
                                                if (bArr[i19] < 0) {
                                                    int i22 = i12 + 10;
                                                    if (bArr[i17] >= 0) {
                                                        i15 = i22;
                                                        i11 = i21;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i21;
                                }
                                i11 = i21;
                            }
                            i15 = i19;
                        }
                        i15 = i17;
                    }
                    this.f8878k = i15;
                    return i11;
                }
            }
            return (int) P();
        }

        public long O() {
            long j11;
            long j12;
            long j13;
            int i11 = this.f8878k;
            int i12 = this.f8876i;
            if (i12 != i11) {
                byte[] bArr = this.f8874g;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.f8878k = i13;
                    return b11;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b11;
                    if (i15 < 0) {
                        j11 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << 14) ^ i15;
                        if (i17 >= 0) {
                            j11 = i17 ^ 16256;
                            i14 = i16;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                long j14 = (-2080896) ^ i19;
                                i14 = i18;
                                j11 = j14;
                            } else {
                                long j15 = i19;
                                i14 = i11 + 5;
                                long j16 = j15 ^ (bArr[i18] << 28);
                                if (j16 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    int i20 = i11 + 6;
                                    long j17 = j16 ^ (bArr[i14] << 35);
                                    if (j17 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i14 = i11 + 7;
                                        j16 = j17 ^ (bArr[i20] << 42);
                                        if (j16 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            i20 = i11 + 8;
                                            j17 = j16 ^ (bArr[i14] << 49);
                                            if (j17 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                i14 = i11 + 9;
                                                long j18 = (j17 ^ (bArr[i20] << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i14] >= 0) {
                                                        i14 = i21;
                                                    }
                                                }
                                                j11 = j18;
                                            }
                                        }
                                    }
                                    j11 = j17 ^ j12;
                                    i14 = i20;
                                }
                                j11 = j16 ^ j13;
                            }
                        }
                    }
                    this.f8878k = i14;
                    return j11;
                }
            }
            return P();
        }

        long P() {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((J() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void R(int i11) {
            if (i11 >= 0) {
                int i12 = this.f8876i;
                int i13 = this.f8878k;
                if (i11 <= i12 - i13) {
                    this.f8878k = i13 + i11;
                    return;
                }
            }
            if (i11 >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void a(int i11) {
            if (this.f8880m != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int e() {
            return this.f8878k - this.f8879l;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean f() {
            return this.f8878k == this.f8876i;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void n(int i11) {
            this.f8882o = i11;
            Q();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int o(int i11) {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int e11 = i11 + e();
            if (e11 < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i12 = this.f8882o;
            if (e11 > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8882o = e11;
            Q();
            return i12;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean p() {
            return O() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public ByteString q() {
            int N = N();
            if (N > 0) {
                int i11 = this.f8876i;
                int i12 = this.f8878k;
                if (N <= i11 - i12) {
                    ByteString wrap = (this.f8875h && this.f8881n) ? ByteString.wrap(this.f8874g, i12, N) : ByteString.copyFrom(this.f8874g, i12, N);
                    this.f8878k += N;
                    return wrap;
                }
            }
            return N == 0 ? ByteString.EMPTY : ByteString.wrap(K(N));
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public double r() {
            return Double.longBitsToDouble(M());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int s() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int t() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long u() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public float v() {
            return Float.intBitsToFloat(L());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int w() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long x() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int y() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long z() {
            return M();
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends i {

        /* renamed from: g, reason: collision with root package name */
        private final Iterable f8883g;

        /* renamed from: h, reason: collision with root package name */
        private final Iterator f8884h;

        /* renamed from: i, reason: collision with root package name */
        private ByteBuffer f8885i;

        /* renamed from: j, reason: collision with root package name */
        private final boolean f8886j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f8887k;

        /* renamed from: l, reason: collision with root package name */
        private int f8888l;

        /* renamed from: m, reason: collision with root package name */
        private int f8889m;

        /* renamed from: n, reason: collision with root package name */
        private int f8890n;

        /* renamed from: o, reason: collision with root package name */
        private int f8891o;

        /* renamed from: p, reason: collision with root package name */
        private int f8892p;

        /* renamed from: q, reason: collision with root package name */
        private int f8893q;

        /* renamed from: r, reason: collision with root package name */
        private long f8894r;

        /* renamed from: s, reason: collision with root package name */
        private long f8895s;

        /* renamed from: t, reason: collision with root package name */
        private long f8896t;

        /* renamed from: u, reason: collision with root package name */
        private long f8897u;

        private c(Iterable iterable, int i11, boolean z10) {
            super();
            this.f8890n = Integer.MAX_VALUE;
            this.f8888l = i11;
            this.f8883g = iterable;
            this.f8884h = iterable.iterator();
            this.f8886j = z10;
            this.f8892p = 0;
            this.f8893q = 0;
            if (i11 != 0) {
                X();
                return;
            }
            this.f8885i = w.f9001e;
            this.f8894r = 0L;
            this.f8895s = 0L;
            this.f8897u = 0L;
            this.f8896t = 0L;
        }

        private long J() {
            return this.f8897u - this.f8894r;
        }

        private void K() {
            if (!this.f8884h.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            X();
        }

        private void M(byte[] bArr, int i11, int i12) {
            if (i12 < 0 || i12 > T()) {
                if (i12 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i12 != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i13 = i12;
            while (i13 > 0) {
                if (J() == 0) {
                    K();
                }
                int min = Math.min(i13, (int) J());
                long j11 = min;
                k1.p(this.f8894r, bArr, (i12 - i13) + i11, j11);
                i13 -= min;
                this.f8894r += j11;
            }
        }

        private void S() {
            int i11 = this.f8888l + this.f8889m;
            this.f8888l = i11;
            int i12 = i11 - this.f8893q;
            int i13 = this.f8890n;
            if (i12 <= i13) {
                this.f8889m = 0;
                return;
            }
            int i14 = i12 - i13;
            this.f8889m = i14;
            this.f8888l = i11 - i14;
        }

        private int T() {
            return (int) (((this.f8888l - this.f8892p) - this.f8894r) + this.f8895s);
        }

        private void V() {
            for (int i11 = 0; i11 < 10; i11++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer W(int i11, int i12) {
            int position = this.f8885i.position();
            int limit = this.f8885i.limit();
            ByteBuffer byteBuffer = this.f8885i;
            try {
                try {
                    byteBuffer.position(i11);
                    byteBuffer.limit(i12);
                    return this.f8885i.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        private void X() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f8884h.next();
            this.f8885i = byteBuffer;
            this.f8892p += (int) (this.f8894r - this.f8895s);
            long position = byteBuffer.position();
            this.f8894r = position;
            this.f8895s = position;
            this.f8897u = this.f8885i.limit();
            long k11 = k1.k(this.f8885i);
            this.f8896t = k11;
            this.f8894r += k11;
            this.f8895s += k11;
            this.f8897u += k11;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int A() {
            return i.c(P());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long B() {
            return i.d(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String C() {
            int P = P();
            if (P > 0) {
                long j11 = P;
                long j12 = this.f8897u;
                long j13 = this.f8894r;
                if (j11 <= j12 - j13) {
                    byte[] bArr = new byte[P];
                    k1.p(j13, bArr, 0L, j11);
                    String str = new String(bArr, w.f8998b);
                    this.f8894r += j11;
                    return str;
                }
            }
            if (P > 0 && P <= T()) {
                byte[] bArr2 = new byte[P];
                M(bArr2, 0, P);
                return new String(bArr2, w.f8998b);
            }
            if (P == 0) {
                return "";
            }
            if (P < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String D() {
            int P = P();
            if (P > 0) {
                long j11 = P;
                long j12 = this.f8897u;
                long j13 = this.f8894r;
                if (j11 <= j12 - j13) {
                    String g11 = Utf8.g(this.f8885i, (int) (j13 - this.f8895s), P);
                    this.f8894r += j11;
                    return g11;
                }
            }
            if (P >= 0 && P <= T()) {
                byte[] bArr = new byte[P];
                M(bArr, 0, P);
                return Utf8.h(bArr, 0, P);
            }
            if (P == 0) {
                return "";
            }
            if (P <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int E() {
            if (f()) {
                this.f8891o = 0;
                return 0;
            }
            int P = P();
            this.f8891o = P;
            if (WireFormat.a(P) != 0) {
                return this.f8891o;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int F() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long G() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean H(int i11) {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                V();
                return true;
            }
            if (b11 == 1) {
                U(8);
                return true;
            }
            if (b11 == 2) {
                U(P());
                return true;
            }
            if (b11 == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (b11 == 4) {
                return false;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            U(4);
            return true;
        }

        public byte L() {
            if (J() == 0) {
                K();
            }
            long j11 = this.f8894r;
            this.f8894r = 1 + j11;
            return k1.w(j11);
        }

        public int N() {
            if (J() < 4) {
                return (L() & 255) | ((L() & 255) << 8) | ((L() & 255) << 16) | ((L() & 255) << 24);
            }
            long j11 = this.f8894r;
            this.f8894r = 4 + j11;
            return ((k1.w(j11 + 3) & 255) << 24) | (k1.w(j11) & 255) | ((k1.w(1 + j11) & 255) << 8) | ((k1.w(2 + j11) & 255) << 16);
        }

        public long O() {
            long L;
            byte L2;
            if (J() >= 8) {
                long j11 = this.f8894r;
                this.f8894r = 8 + j11;
                L = (k1.w(j11) & 255) | ((k1.w(1 + j11) & 255) << 8) | ((k1.w(2 + j11) & 255) << 16) | ((k1.w(3 + j11) & 255) << 24) | ((k1.w(4 + j11) & 255) << 32) | ((k1.w(5 + j11) & 255) << 40) | ((k1.w(6 + j11) & 255) << 48);
                L2 = k1.w(j11 + 7);
            } else {
                L = (L() & 255) | ((L() & 255) << 8) | ((L() & 255) << 16) | ((L() & 255) << 24) | ((L() & 255) << 32) | ((L() & 255) << 40) | ((L() & 255) << 48);
                L2 = L();
            }
            return ((L2 & 255) << 56) | L;
        }

        public int P() {
            int i11;
            long j11 = this.f8894r;
            if (this.f8897u != j11) {
                long j12 = j11 + 1;
                byte w11 = k1.w(j11);
                if (w11 >= 0) {
                    this.f8894r++;
                    return w11;
                }
                if (this.f8897u - this.f8894r >= 10) {
                    long j13 = 2 + j11;
                    int w12 = (k1.w(j12) << 7) ^ w11;
                    if (w12 < 0) {
                        i11 = w12 ^ (-128);
                    } else {
                        long j14 = 3 + j11;
                        int w13 = (k1.w(j13) << 14) ^ w12;
                        if (w13 >= 0) {
                            i11 = w13 ^ 16256;
                        } else {
                            long j15 = 4 + j11;
                            int w14 = w13 ^ (k1.w(j14) << 21);
                            if (w14 < 0) {
                                i11 = (-2080896) ^ w14;
                            } else {
                                j14 = 5 + j11;
                                byte w15 = k1.w(j15);
                                int i12 = (w14 ^ (w15 << 28)) ^ 266354560;
                                if (w15 < 0) {
                                    j15 = 6 + j11;
                                    if (k1.w(j14) < 0) {
                                        j14 = 7 + j11;
                                        if (k1.w(j15) < 0) {
                                            j15 = 8 + j11;
                                            if (k1.w(j14) < 0) {
                                                j14 = 9 + j11;
                                                if (k1.w(j15) < 0) {
                                                    long j16 = j11 + 10;
                                                    if (k1.w(j14) >= 0) {
                                                        i11 = i12;
                                                        j13 = j16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i12;
                                }
                                i11 = i12;
                            }
                            j13 = j15;
                        }
                        j13 = j14;
                    }
                    this.f8894r = j13;
                    return i11;
                }
            }
            return (int) R();
        }

        public long Q() {
            long j11;
            long j12;
            long j13;
            long j14 = this.f8894r;
            if (this.f8897u != j14) {
                long j15 = j14 + 1;
                byte w11 = k1.w(j14);
                if (w11 >= 0) {
                    this.f8894r++;
                    return w11;
                }
                if (this.f8897u - this.f8894r >= 10) {
                    long j16 = 2 + j14;
                    int w12 = (k1.w(j15) << 7) ^ w11;
                    if (w12 < 0) {
                        j11 = w12 ^ (-128);
                    } else {
                        long j17 = 3 + j14;
                        int w13 = (k1.w(j16) << 14) ^ w12;
                        if (w13 >= 0) {
                            j11 = w13 ^ 16256;
                            j16 = j17;
                        } else {
                            long j18 = 4 + j14;
                            int w14 = w13 ^ (k1.w(j17) << 21);
                            if (w14 < 0) {
                                j11 = (-2080896) ^ w14;
                                j16 = j18;
                            } else {
                                long j19 = 5 + j14;
                                long w15 = (k1.w(j18) << 28) ^ w14;
                                if (w15 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j20 = 6 + j14;
                                    long w16 = w15 ^ (k1.w(j19) << 35);
                                    if (w16 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j19 = 7 + j14;
                                        w15 = w16 ^ (k1.w(j20) << 42);
                                        if (w15 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j20 = 8 + j14;
                                            w16 = w15 ^ (k1.w(j19) << 49);
                                            if (w16 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                j19 = 9 + j14;
                                                long w17 = (w16 ^ (k1.w(j20) << 56)) ^ 71499008037633920L;
                                                if (w17 < 0) {
                                                    long j21 = j14 + 10;
                                                    if (k1.w(j19) >= 0) {
                                                        j11 = w17;
                                                        j16 = j21;
                                                    }
                                                } else {
                                                    j11 = w17;
                                                    j16 = j19;
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ w16;
                                    j16 = j20;
                                }
                                j11 = j13 ^ w15;
                                j16 = j19;
                            }
                        }
                    }
                    this.f8894r = j16;
                    return j11;
                }
            }
            return R();
        }

        long R() {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((L() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void U(int i11) {
            if (i11 < 0 || i11 > ((this.f8888l - this.f8892p) - this.f8894r) + this.f8895s) {
                if (i11 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i11 > 0) {
                if (J() == 0) {
                    K();
                }
                int min = Math.min(i11, (int) J());
                i11 -= min;
                this.f8894r += min;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void a(int i11) {
            if (this.f8891o != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int e() {
            return (int) (((this.f8892p - this.f8893q) + this.f8894r) - this.f8895s);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean f() {
            return (((long) this.f8892p) + this.f8894r) - this.f8895s == ((long) this.f8888l);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void n(int i11) {
            this.f8890n = i11;
            S();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int o(int i11) {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int e11 = i11 + e();
            int i12 = this.f8890n;
            if (e11 > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8890n = e11;
            S();
            return i12;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean p() {
            return Q() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public ByteString q() {
            int P = P();
            if (P > 0) {
                long j11 = P;
                long j12 = this.f8897u;
                long j13 = this.f8894r;
                if (j11 <= j12 - j13) {
                    if (this.f8886j && this.f8887k) {
                        int i11 = (int) (j13 - this.f8896t);
                        ByteString wrap = ByteString.wrap(W(i11, P + i11));
                        this.f8894r += j11;
                        return wrap;
                    }
                    byte[] bArr = new byte[P];
                    k1.p(j13, bArr, 0L, j11);
                    this.f8894r += j11;
                    return ByteString.wrap(bArr);
                }
            }
            if (P <= 0 || P > T()) {
                if (P == 0) {
                    return ByteString.EMPTY;
                }
                if (P < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.f8886j || !this.f8887k) {
                byte[] bArr2 = new byte[P];
                M(bArr2, 0, P);
                return ByteString.wrap(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (P > 0) {
                if (J() == 0) {
                    K();
                }
                int min = Math.min(P, (int) J());
                int i12 = (int) (this.f8894r - this.f8896t);
                arrayList.add(ByteString.wrap(W(i12, i12 + min)));
                P -= min;
                this.f8894r += min;
            }
            return ByteString.copyFrom(arrayList);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public double r() {
            return Double.longBitsToDouble(O());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int s() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int t() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long u() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public float v() {
            return Float.intBitsToFloat(N());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int w() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long x() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int y() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long z() {
            return O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends i {

        /* renamed from: g, reason: collision with root package name */
        private final InputStream f8898g;

        /* renamed from: h, reason: collision with root package name */
        private final byte[] f8899h;

        /* renamed from: i, reason: collision with root package name */
        private int f8900i;

        /* renamed from: j, reason: collision with root package name */
        private int f8901j;

        /* renamed from: k, reason: collision with root package name */
        private int f8902k;

        /* renamed from: l, reason: collision with root package name */
        private int f8903l;

        /* renamed from: m, reason: collision with root package name */
        private int f8904m;

        /* renamed from: n, reason: collision with root package name */
        private int f8905n;

        private d(InputStream inputStream, int i11) {
            super();
            this.f8905n = Integer.MAX_VALUE;
            w.b(inputStream, "input");
            this.f8898g = inputStream;
            this.f8899h = new byte[i11];
            this.f8900i = 0;
            this.f8902k = 0;
            this.f8904m = 0;
        }

        private static int J(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private static int K(InputStream inputStream, byte[] bArr, int i11, int i12) {
            try {
                return inputStream.read(bArr, i11, i12);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private ByteString L(int i11) {
            byte[] O = O(i11);
            if (O != null) {
                return ByteString.copyFrom(O);
            }
            int i12 = this.f8902k;
            int i13 = this.f8900i;
            int i14 = i13 - i12;
            this.f8904m += i13;
            this.f8902k = 0;
            this.f8900i = 0;
            List<byte[]> P = P(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f8899h, i12, bArr, 0, i14);
            for (byte[] bArr2 : P) {
                System.arraycopy(bArr2, 0, bArr, i14, bArr2.length);
                i14 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] N(int i11, boolean z10) {
            byte[] O = O(i11);
            if (O != null) {
                return z10 ? (byte[]) O.clone() : O;
            }
            int i12 = this.f8902k;
            int i13 = this.f8900i;
            int i14 = i13 - i12;
            this.f8904m += i13;
            this.f8902k = 0;
            this.f8900i = 0;
            List<byte[]> P = P(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f8899h, i12, bArr, 0, i14);
            for (byte[] bArr2 : P) {
                System.arraycopy(bArr2, 0, bArr, i14, bArr2.length);
                i14 += bArr2.length;
            }
            return bArr;
        }

        private byte[] O(int i11) {
            if (i11 == 0) {
                return w.f9000d;
            }
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = this.f8904m;
            int i13 = this.f8902k;
            int i14 = i12 + i13 + i11;
            if (i14 - this.f8871c > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i15 = this.f8905n;
            if (i14 > i15) {
                Y((i15 - i12) - i13);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i16 = this.f8900i - i13;
            int i17 = i11 - i16;
            if (i17 >= 4096 && i17 > J(this.f8898g)) {
                return null;
            }
            byte[] bArr = new byte[i11];
            System.arraycopy(this.f8899h, this.f8902k, bArr, 0, i16);
            this.f8904m += this.f8900i;
            this.f8902k = 0;
            this.f8900i = 0;
            while (i16 < i11) {
                int K = K(this.f8898g, bArr, i16, i11 - i16);
                if (K == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.f8904m += K;
                i16 += K;
            }
            return bArr;
        }

        private List P(int i11) {
            ArrayList arrayList = new ArrayList();
            while (i11 > 0) {
                int min = Math.min(i11, 4096);
                byte[] bArr = new byte[min];
                int i12 = 0;
                while (i12 < min) {
                    int read = this.f8898g.read(bArr, i12, min - i12);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.f8904m += read;
                    i12 += read;
                }
                i11 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void V() {
            int i11 = this.f8900i + this.f8901j;
            this.f8900i = i11;
            int i12 = this.f8904m + i11;
            int i13 = this.f8905n;
            if (i12 <= i13) {
                this.f8901j = 0;
                return;
            }
            int i14 = i12 - i13;
            this.f8901j = i14;
            this.f8900i = i11 - i14;
        }

        private void W(int i11) {
            if (d0(i11)) {
                return;
            }
            if (i11 <= (this.f8871c - this.f8904m) - this.f8902k) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        private static long X(InputStream inputStream, long j11) {
            try {
                return inputStream.skip(j11);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private void Z(int i11) {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = this.f8904m;
            int i13 = this.f8902k;
            int i14 = i12 + i13 + i11;
            int i15 = this.f8905n;
            if (i14 > i15) {
                Y((i15 - i12) - i13);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8904m = i12 + i13;
            int i16 = this.f8900i - i13;
            this.f8900i = 0;
            this.f8902k = 0;
            while (i16 < i11) {
                try {
                    long j11 = i11 - i16;
                    long X = X(this.f8898g, j11);
                    if (X < 0 || X > j11) {
                        throw new IllegalStateException(this.f8898g.getClass() + "#skip returned invalid result: " + X + "\nThe InputStream implementation is buggy.");
                    }
                    if (X == 0) {
                        break;
                    } else {
                        i16 += (int) X;
                    }
                } finally {
                    this.f8904m += i16;
                    V();
                }
            }
            if (i16 >= i11) {
                return;
            }
            int i17 = this.f8900i;
            int i18 = i17 - this.f8902k;
            this.f8902k = i17;
            W(1);
            while (true) {
                int i19 = i11 - i18;
                int i20 = this.f8900i;
                if (i19 <= i20) {
                    this.f8902k = i19;
                    return;
                } else {
                    i18 += i20;
                    this.f8902k = i20;
                    W(1);
                }
            }
        }

        private void a0() {
            if (this.f8900i - this.f8902k >= 10) {
                b0();
            } else {
                c0();
            }
        }

        private void b0() {
            for (int i11 = 0; i11 < 10; i11++) {
                byte[] bArr = this.f8899h;
                int i12 = this.f8902k;
                this.f8902k = i12 + 1;
                if (bArr[i12] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void c0() {
            for (int i11 = 0; i11 < 10; i11++) {
                if (M() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean d0(int i11) {
            int i12 = this.f8902k;
            int i13 = i12 + i11;
            int i14 = this.f8900i;
            if (i13 <= i14) {
                throw new IllegalStateException("refillBuffer() called when " + i11 + " bytes were already available in buffer");
            }
            int i15 = this.f8871c;
            int i16 = this.f8904m;
            if (i11 > (i15 - i16) - i12 || i16 + i12 + i11 > this.f8905n) {
                return false;
            }
            if (i12 > 0) {
                if (i14 > i12) {
                    byte[] bArr = this.f8899h;
                    System.arraycopy(bArr, i12, bArr, 0, i14 - i12);
                }
                this.f8904m += i12;
                this.f8900i -= i12;
                this.f8902k = 0;
            }
            InputStream inputStream = this.f8898g;
            byte[] bArr2 = this.f8899h;
            int i17 = this.f8900i;
            int K = K(inputStream, bArr2, i17, Math.min(bArr2.length - i17, (this.f8871c - this.f8904m) - i17));
            if (K == 0 || K < -1 || K > this.f8899h.length) {
                throw new IllegalStateException(this.f8898g.getClass() + "#read(byte[]) returned invalid result: " + K + "\nThe InputStream implementation is buggy.");
            }
            if (K <= 0) {
                return false;
            }
            this.f8900i += K;
            V();
            if (this.f8900i >= i11) {
                return true;
            }
            return d0(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int A() {
            return i.c(S());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long B() {
            return i.d(T());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String C() {
            int S = S();
            if (S > 0) {
                int i11 = this.f8900i;
                int i12 = this.f8902k;
                if (S <= i11 - i12) {
                    String str = new String(this.f8899h, i12, S, w.f8998b);
                    this.f8902k += S;
                    return str;
                }
            }
            if (S == 0) {
                return "";
            }
            if (S < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (S > this.f8900i) {
                return new String(N(S, false), w.f8998b);
            }
            W(S);
            String str2 = new String(this.f8899h, this.f8902k, S, w.f8998b);
            this.f8902k += S;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String D() {
            byte[] N;
            int S = S();
            int i11 = this.f8902k;
            int i12 = this.f8900i;
            if (S <= i12 - i11 && S > 0) {
                N = this.f8899h;
                this.f8902k = i11 + S;
            } else {
                if (S == 0) {
                    return "";
                }
                if (S < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                i11 = 0;
                if (S <= i12) {
                    W(S);
                    N = this.f8899h;
                    this.f8902k = S;
                } else {
                    N = N(S, false);
                }
            }
            return Utf8.h(N, i11, S);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int E() {
            if (f()) {
                this.f8903l = 0;
                return 0;
            }
            int S = S();
            this.f8903l = S;
            if (WireFormat.a(S) != 0) {
                return this.f8903l;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int F() {
            return S();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long G() {
            return T();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean H(int i11) {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                a0();
                return true;
            }
            if (b11 == 1) {
                Y(8);
                return true;
            }
            if (b11 == 2) {
                Y(S());
                return true;
            }
            if (b11 == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (b11 == 4) {
                return false;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            Y(4);
            return true;
        }

        public byte M() {
            if (this.f8902k == this.f8900i) {
                W(1);
            }
            byte[] bArr = this.f8899h;
            int i11 = this.f8902k;
            this.f8902k = i11 + 1;
            return bArr[i11];
        }

        public int Q() {
            int i11 = this.f8902k;
            if (this.f8900i - i11 < 4) {
                W(4);
                i11 = this.f8902k;
            }
            byte[] bArr = this.f8899h;
            this.f8902k = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        public long R() {
            int i11 = this.f8902k;
            if (this.f8900i - i11 < 8) {
                W(8);
                i11 = this.f8902k;
            }
            byte[] bArr = this.f8899h;
            this.f8902k = i11 + 8;
            return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
        }

        public int S() {
            int i11;
            int i12 = this.f8902k;
            int i13 = this.f8900i;
            if (i13 != i12) {
                byte[] bArr = this.f8899h;
                int i14 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 >= 0) {
                    this.f8902k = i14;
                    return b11;
                }
                if (i13 - i14 >= 9) {
                    int i15 = i12 + 2;
                    int i16 = (bArr[i14] << 7) ^ b11;
                    if (i16 < 0) {
                        i11 = i16 ^ (-128);
                    } else {
                        int i17 = i12 + 3;
                        int i18 = (bArr[i15] << 14) ^ i16;
                        if (i18 >= 0) {
                            i11 = i18 ^ 16256;
                        } else {
                            int i19 = i12 + 4;
                            int i20 = i18 ^ (bArr[i17] << 21);
                            if (i20 < 0) {
                                i11 = (-2080896) ^ i20;
                            } else {
                                i17 = i12 + 5;
                                byte b12 = bArr[i19];
                                int i21 = (i20 ^ (b12 << 28)) ^ 266354560;
                                if (b12 < 0) {
                                    i19 = i12 + 6;
                                    if (bArr[i17] < 0) {
                                        i17 = i12 + 7;
                                        if (bArr[i19] < 0) {
                                            i19 = i12 + 8;
                                            if (bArr[i17] < 0) {
                                                i17 = i12 + 9;
                                                if (bArr[i19] < 0) {
                                                    int i22 = i12 + 10;
                                                    if (bArr[i17] >= 0) {
                                                        i15 = i22;
                                                        i11 = i21;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i21;
                                }
                                i11 = i21;
                            }
                            i15 = i19;
                        }
                        i15 = i17;
                    }
                    this.f8902k = i15;
                    return i11;
                }
            }
            return (int) U();
        }

        public long T() {
            long j11;
            long j12;
            long j13;
            int i11 = this.f8902k;
            int i12 = this.f8900i;
            if (i12 != i11) {
                byte[] bArr = this.f8899h;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.f8902k = i13;
                    return b11;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b11;
                    if (i15 < 0) {
                        j11 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << 14) ^ i15;
                        if (i17 >= 0) {
                            j11 = i17 ^ 16256;
                            i14 = i16;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                long j14 = (-2080896) ^ i19;
                                i14 = i18;
                                j11 = j14;
                            } else {
                                long j15 = i19;
                                i14 = i11 + 5;
                                long j16 = j15 ^ (bArr[i18] << 28);
                                if (j16 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    int i20 = i11 + 6;
                                    long j17 = j16 ^ (bArr[i14] << 35);
                                    if (j17 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        i14 = i11 + 7;
                                        j16 = j17 ^ (bArr[i20] << 42);
                                        if (j16 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            i20 = i11 + 8;
                                            j17 = j16 ^ (bArr[i14] << 49);
                                            if (j17 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                i14 = i11 + 9;
                                                long j18 = (j17 ^ (bArr[i20] << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i14] >= 0) {
                                                        i14 = i21;
                                                    }
                                                }
                                                j11 = j18;
                                            }
                                        }
                                    }
                                    j11 = j17 ^ j12;
                                    i14 = i20;
                                }
                                j11 = j16 ^ j13;
                            }
                        }
                    }
                    this.f8902k = i14;
                    return j11;
                }
            }
            return U();
        }

        long U() {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((M() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void Y(int i11) {
            int i12 = this.f8900i;
            int i13 = this.f8902k;
            if (i11 > i12 - i13 || i11 < 0) {
                Z(i11);
            } else {
                this.f8902k = i13 + i11;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void a(int i11) {
            if (this.f8903l != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int e() {
            return this.f8904m + this.f8902k;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean f() {
            return this.f8902k == this.f8900i && !d0(1);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void n(int i11) {
            this.f8905n = i11;
            V();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int o(int i11) {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = i11 + this.f8904m + this.f8902k;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i13 = this.f8905n;
            if (i12 > i13) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8905n = i12;
            V();
            return i13;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean p() {
            return T() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public ByteString q() {
            int S = S();
            int i11 = this.f8900i;
            int i12 = this.f8902k;
            if (S <= i11 - i12 && S > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f8899h, i12, S);
                this.f8902k += S;
                return copyFrom;
            }
            if (S == 0) {
                return ByteString.EMPTY;
            }
            if (S >= 0) {
                return L(S);
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public double r() {
            return Double.longBitsToDouble(R());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int s() {
            return S();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int t() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long u() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public float v() {
            return Float.intBitsToFloat(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int w() {
            return S();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long x() {
            return T();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int y() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long z() {
            return R();
        }
    }

    /* loaded from: classes.dex */
    private static final class e extends i {

        /* renamed from: g, reason: collision with root package name */
        private final ByteBuffer f8906g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f8907h;

        /* renamed from: i, reason: collision with root package name */
        private final long f8908i;

        /* renamed from: j, reason: collision with root package name */
        private long f8909j;

        /* renamed from: k, reason: collision with root package name */
        private long f8910k;

        /* renamed from: l, reason: collision with root package name */
        private long f8911l;

        /* renamed from: m, reason: collision with root package name */
        private int f8912m;

        /* renamed from: n, reason: collision with root package name */
        private int f8913n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f8914o;

        /* renamed from: p, reason: collision with root package name */
        private int f8915p;

        private e(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.f8915p = Integer.MAX_VALUE;
            this.f8906g = byteBuffer;
            long k11 = k1.k(byteBuffer);
            this.f8908i = k11;
            this.f8909j = byteBuffer.limit() + k11;
            long position = k11 + byteBuffer.position();
            this.f8910k = position;
            this.f8911l = position;
            this.f8907h = z10;
        }

        private int J(long j11) {
            return (int) (j11 - this.f8908i);
        }

        static boolean K() {
            return k1.J();
        }

        private void R() {
            long j11 = this.f8909j + this.f8912m;
            this.f8909j = j11;
            int i11 = (int) (j11 - this.f8911l);
            int i12 = this.f8915p;
            if (i11 <= i12) {
                this.f8912m = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f8912m = i13;
            this.f8909j = j11 - i13;
        }

        private int S() {
            return (int) (this.f8909j - this.f8910k);
        }

        private void U() {
            if (S() >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() {
            for (int i11 = 0; i11 < 10; i11++) {
                long j11 = this.f8910k;
                this.f8910k = 1 + j11;
                if (k1.w(j11) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void W() {
            for (int i11 = 0; i11 < 10; i11++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer X(long j11, long j12) {
            int position = this.f8906g.position();
            int limit = this.f8906g.limit();
            ByteBuffer byteBuffer = this.f8906g;
            try {
                try {
                    byteBuffer.position(J(j11));
                    byteBuffer.limit(J(j12));
                    return this.f8906g.slice();
                } catch (IllegalArgumentException e11) {
                    InvalidProtocolBufferException truncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                    truncatedMessage.initCause(e11);
                    throw truncatedMessage;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int A() {
            return i.c(O());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long B() {
            return i.d(P());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String C() {
            int O = O();
            if (O <= 0 || O > S()) {
                if (O == 0) {
                    return "";
                }
                if (O < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[O];
            long j11 = O;
            k1.p(this.f8910k, bArr, 0L, j11);
            String str = new String(bArr, w.f8998b);
            this.f8910k += j11;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public String D() {
            int O = O();
            if (O > 0 && O <= S()) {
                String g11 = Utf8.g(this.f8906g, J(this.f8910k), O);
                this.f8910k += O;
                return g11;
            }
            if (O == 0) {
                return "";
            }
            if (O <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int E() {
            if (f()) {
                this.f8913n = 0;
                return 0;
            }
            int O = O();
            this.f8913n = O;
            if (WireFormat.a(O) != 0) {
                return this.f8913n;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int F() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long G() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean H(int i11) {
            int b11 = WireFormat.b(i11);
            if (b11 == 0) {
                U();
                return true;
            }
            if (b11 == 1) {
                T(8);
                return true;
            }
            if (b11 == 2) {
                T(O());
                return true;
            }
            if (b11 == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i11), 4));
                return true;
            }
            if (b11 == 4) {
                return false;
            }
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            T(4);
            return true;
        }

        public byte L() {
            long j11 = this.f8910k;
            if (j11 == this.f8909j) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8910k = 1 + j11;
            return k1.w(j11);
        }

        public int M() {
            long j11 = this.f8910k;
            if (this.f8909j - j11 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8910k = 4 + j11;
            return ((k1.w(j11 + 3) & 255) << 24) | (k1.w(j11) & 255) | ((k1.w(1 + j11) & 255) << 8) | ((k1.w(2 + j11) & 255) << 16);
        }

        public long N() {
            long j11 = this.f8910k;
            if (this.f8909j - j11 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8910k = 8 + j11;
            return ((k1.w(j11 + 7) & 255) << 56) | (k1.w(j11) & 255) | ((k1.w(1 + j11) & 255) << 8) | ((k1.w(2 + j11) & 255) << 16) | ((k1.w(3 + j11) & 255) << 24) | ((k1.w(4 + j11) & 255) << 32) | ((k1.w(5 + j11) & 255) << 40) | ((k1.w(6 + j11) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (androidx.datastore.preferences.protobuf.k1.w(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int O() {
            /*
                r9 = this;
                long r0 = r9.f8910k
                long r2 = r9.f8909j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.datastore.preferences.protobuf.k1.w(r0)
                if (r4 < 0) goto L16
                r9.f8910k = r2
                return r4
            L16:
                long r5 = r9.f8909j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.datastore.preferences.protobuf.k1.w(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.k1.w(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.k1.w(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.k1.w(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.k1.w(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.k1.w(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.k1.w(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = androidx.datastore.preferences.protobuf.k1.w(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.datastore.preferences.protobuf.k1.w(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.Q()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.f8910k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.i.e.O():int");
        }

        public long P() {
            long j11;
            long j12;
            long j13;
            int i11;
            long j14 = this.f8910k;
            if (this.f8909j != j14) {
                long j15 = 1 + j14;
                byte w11 = k1.w(j14);
                if (w11 >= 0) {
                    this.f8910k = j15;
                    return w11;
                }
                if (this.f8909j - j15 >= 9) {
                    long j16 = 2 + j14;
                    int w12 = (k1.w(j15) << 7) ^ w11;
                    if (w12 >= 0) {
                        long j17 = 3 + j14;
                        int w13 = w12 ^ (k1.w(j16) << 14);
                        if (w13 >= 0) {
                            j11 = w13 ^ 16256;
                            j16 = j17;
                        } else {
                            j16 = 4 + j14;
                            int w14 = w13 ^ (k1.w(j17) << 21);
                            if (w14 < 0) {
                                i11 = (-2080896) ^ w14;
                            } else {
                                long j18 = 5 + j14;
                                long w15 = w14 ^ (k1.w(j16) << 28);
                                if (w15 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j19 = 6 + j14;
                                    long w16 = w15 ^ (k1.w(j18) << 35);
                                    if (w16 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j18 = 7 + j14;
                                        w15 = w16 ^ (k1.w(j19) << 42);
                                        if (w15 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j19 = 8 + j14;
                                            w16 = w15 ^ (k1.w(j18) << 49);
                                            if (w16 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                long j20 = j14 + 9;
                                                long w17 = (w16 ^ (k1.w(j19) << 56)) ^ 71499008037633920L;
                                                if (w17 < 0) {
                                                    long j21 = j14 + 10;
                                                    if (k1.w(j20) >= 0) {
                                                        j16 = j21;
                                                        j11 = w17;
                                                    }
                                                } else {
                                                    j11 = w17;
                                                    j16 = j20;
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ w16;
                                    j16 = j19;
                                }
                                j11 = j13 ^ w15;
                                j16 = j18;
                            }
                        }
                        this.f8910k = j16;
                        return j11;
                    }
                    i11 = w12 ^ (-128);
                    j11 = i11;
                    this.f8910k = j16;
                    return j11;
                }
            }
            return Q();
        }

        long Q() {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((L() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void T(int i11) {
            if (i11 >= 0 && i11 <= S()) {
                this.f8910k += i11;
            } else {
                if (i11 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void a(int i11) {
            if (this.f8913n != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int e() {
            return (int) (this.f8910k - this.f8911l);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean f() {
            return this.f8910k == this.f8909j;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public void n(int i11) {
            this.f8915p = i11;
            R();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int o(int i11) {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int e11 = i11 + e();
            int i12 = this.f8915p;
            if (e11 > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f8915p = e11;
            R();
            return i12;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public boolean p() {
            return P() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public ByteString q() {
            int O = O();
            if (O <= 0 || O > S()) {
                if (O == 0) {
                    return ByteString.EMPTY;
                }
                if (O < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.f8907h && this.f8914o) {
                long j11 = this.f8910k;
                long j12 = O;
                ByteBuffer X = X(j11, j11 + j12);
                this.f8910k += j12;
                return ByteString.wrap(X);
            }
            byte[] bArr = new byte[O];
            long j13 = O;
            k1.p(this.f8910k, bArr, 0L, j13);
            this.f8910k += j13;
            return ByteString.wrap(bArr);
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public double r() {
            return Double.longBitsToDouble(N());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int s() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int t() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long u() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public float v() {
            return Float.intBitsToFloat(M());
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int w() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long x() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public int y() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.i
        public long z() {
            return N();
        }
    }

    private i() {
        this.f8870b = f8868f;
        this.f8871c = Integer.MAX_VALUE;
        this.f8873e = false;
    }

    public static int c(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long d(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static i g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static i h(InputStream inputStream, int i11) {
        if (i11 > 0) {
            return inputStream == null ? k(w.f9000d) : new d(inputStream, i11);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i i(Iterable iterable, boolean z10) {
        Iterator it = iterable.iterator();
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            i12 += byteBuffer.remaining();
            i11 = byteBuffer.hasArray() ? i11 | 1 : byteBuffer.isDirect() ? i11 | 2 : i11 | 4;
        }
        return i11 == 2 ? new c(iterable, i12, z10) : g(new x(iterable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i j(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return m(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z10);
        }
        if (byteBuffer.isDirect() && e.K()) {
            return new e(byteBuffer, z10);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return m(bArr, 0, remaining, true);
    }

    public static i k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static i l(byte[] bArr, int i11, int i12) {
        return m(bArr, i11, i12, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i m(byte[] bArr, int i11, int i12, boolean z10) {
        b bVar = new b(bArr, i11, i12, z10);
        try {
            bVar.o(i12);
            return bVar;
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public abstract int A();

    public abstract long B();

    public abstract String C();

    public abstract String D();

    public abstract int E();

    public abstract int F();

    public abstract long G();

    public abstract boolean H(int i11);

    public void I() {
        int E;
        do {
            E = E();
            if (E == 0) {
                return;
            }
            b();
            this.f8869a++;
            this.f8869a--;
        } while (H(E));
    }

    public abstract void a(int i11);

    public void b() {
        if (this.f8869a >= this.f8870b) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void n(int i11);

    public abstract int o(int i11);

    public abstract boolean p();

    public abstract ByteString q();

    public abstract double r();

    public abstract int s();

    public abstract int t();

    public abstract long u();

    public abstract float v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();
}
