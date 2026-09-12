package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f8826a = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f8827a;

        /* renamed from: b, reason: collision with root package name */
        public long f8828b;

        /* renamed from: c, reason: collision with root package name */
        public Object f8829c;

        /* renamed from: d, reason: collision with root package name */
        public final o f8830d;

        /* renamed from: e, reason: collision with root package name */
        public int f8831e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(o oVar) {
            oVar.getClass();
            this.f8830d = oVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        v vVar = (v) dVar;
        int I = I(bArr, i12, aVar);
        vVar.addInt(i.c(aVar.f8827a));
        while (I < i13) {
            int I2 = I(bArr, I, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            I = I(bArr, I2, aVar);
            vVar.addInt(i.c(aVar.f8827a));
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        f0 f0Var = (f0) dVar;
        int L = L(bArr, i12, aVar);
        f0Var.addLong(i.d(aVar.f8828b));
        while (L < i13) {
            int I = I(bArr, L, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            L = L(bArr, I, aVar);
            f0Var.addLong(i.d(aVar.f8828b));
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(byte[] bArr, int i11, a aVar) {
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 == 0) {
            aVar.f8829c = "";
            return I;
        }
        aVar.f8829c = new String(bArr, I, i12, w.f8998b);
        return I + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        int I = I(bArr, i12, aVar);
        int i14 = aVar.f8827a;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 == 0) {
            dVar.add("");
        } else {
            dVar.add(new String(bArr, I, i14, w.f8998b));
            I += i14;
        }
        while (I < i13) {
            int I2 = I(bArr, I, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i15 = aVar.f8827a;
            if (i15 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i15 == 0) {
                dVar.add("");
            } else {
                dVar.add(new String(bArr, I, i15, w.f8998b));
                I += i15;
            }
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        int I = I(bArr, i12, aVar);
        int i14 = aVar.f8827a;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 == 0) {
            dVar.add("");
        } else {
            int i15 = I + i14;
            if (!Utf8.s(bArr, I, i15)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            dVar.add(new String(bArr, I, i14, w.f8998b));
            I = i15;
        }
        while (I < i13) {
            int I2 = I(bArr, I, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i16 = aVar.f8827a;
            if (i16 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i16 == 0) {
                dVar.add("");
            } else {
                int i17 = I + i16;
                if (!Utf8.s(bArr, I, i17)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                dVar.add(new String(bArr, I, i16, w.f8998b));
                I = i17;
            }
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(byte[] bArr, int i11, a aVar) {
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 == 0) {
            aVar.f8829c = "";
            return I;
        }
        aVar.f8829c = Utf8.h(bArr, I, i12);
        return I + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i11, byte[] bArr, int i12, int i13, i1 i1Var, a aVar) {
        if (WireFormat.a(i11) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int b11 = WireFormat.b(i11);
        if (b11 == 0) {
            int L = L(bArr, i12, aVar);
            i1Var.n(i11, Long.valueOf(aVar.f8828b));
            return L;
        }
        if (b11 == 1) {
            i1Var.n(i11, Long.valueOf(j(bArr, i12)));
            return i12 + 8;
        }
        if (b11 == 2) {
            int I = I(bArr, i12, aVar);
            int i14 = aVar.f8827a;
            if (i14 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i14 > bArr.length - I) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i14 == 0) {
                i1Var.n(i11, ByteString.EMPTY);
            } else {
                i1Var.n(i11, ByteString.copyFrom(bArr, I, i14));
            }
            return I + i14;
        }
        if (b11 != 3) {
            if (b11 != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            i1Var.n(i11, Integer.valueOf(h(bArr, i12)));
            return i12 + 4;
        }
        i1 k11 = i1.k();
        int i15 = (i11 & (-8)) | 4;
        int i16 = aVar.f8831e + 1;
        aVar.f8831e = i16;
        a(i16);
        int i17 = 0;
        while (true) {
            if (i12 >= i13) {
                break;
            }
            int I2 = I(bArr, i12, aVar);
            int i18 = aVar.f8827a;
            if (i18 == i15) {
                i17 = i18;
                i12 = I2;
                break;
            }
            i17 = i18;
            i12 = G(i18, bArr, I2, i13, k11, aVar);
        }
        aVar.f8831e--;
        if (i12 > i13 || i17 != i15) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        i1Var.n(i11, k11);
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i11, byte[] bArr, int i12, a aVar) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            aVar.f8827a = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Byte.MAX_VALUE) << 7);
        int i16 = i12 + 2;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            aVar.f8827a = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Byte.MAX_VALUE) << 14);
        int i18 = i12 + 3;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            aVar.f8827a = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Byte.MAX_VALUE) << 21);
        int i20 = i12 + 4;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            aVar.f8827a = i19 | (b14 << 28);
            return i20;
        }
        int i21 = i19 | ((b14 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i22 = i20 + 1;
            if (bArr[i20] >= 0) {
                aVar.f8827a = i21;
                return i22;
            }
            i20 = i22;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(byte[] bArr, int i11, a aVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return H(b11, bArr, i12, aVar);
        }
        aVar.f8827a = b11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        v vVar = (v) dVar;
        int I = I(bArr, i12, aVar);
        vVar.addInt(aVar.f8827a);
        while (I < i13) {
            int I2 = I(bArr, I, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            I = I(bArr, I2, aVar);
            vVar.addInt(aVar.f8827a);
        }
        return I;
    }

    static int K(long j11, byte[] bArr, int i11, a aVar) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        long j12 = (j11 & 127) | ((b11 & Byte.MAX_VALUE) << 7);
        int i13 = 7;
        while (b11 < 0) {
            int i14 = i12 + 1;
            byte b12 = bArr[i12];
            i13 += 7;
            j12 |= (b12 & Byte.MAX_VALUE) << i13;
            i12 = i14;
            b11 = b12;
        }
        aVar.f8828b = j12;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(byte[] bArr, int i11, a aVar) {
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        if (j11 < 0) {
            return K(j11, bArr, i12, aVar);
        }
        aVar.f8828b = j11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        f0 f0Var = (f0) dVar;
        int L = L(bArr, i12, aVar);
        f0Var.addLong(aVar.f8828b);
        while (L < i13) {
            int I = I(bArr, L, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            L = L(bArr, I, aVar);
            f0Var.addLong(aVar.f8828b);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int N(Object obj, b1 b1Var, byte[] bArr, int i11, int i12, int i13, a aVar) {
        q0 q0Var = (q0) b1Var;
        int i14 = aVar.f8831e + 1;
        aVar.f8831e = i14;
        a(i14);
        int X = q0Var.X(obj, bArr, i11, i12, i13, aVar);
        aVar.f8831e--;
        aVar.f8829c = obj;
        return X;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int O(Object obj, b1 b1Var, byte[] bArr, int i11, int i12, a aVar) {
        int i13 = i11 + 1;
        int i14 = bArr[i11];
        if (i14 < 0) {
            i13 = H(i14, bArr, i13, aVar);
            i14 = aVar.f8827a;
        }
        int i15 = i13;
        if (i14 < 0 || i14 > i12 - i15) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i16 = aVar.f8831e + 1;
        aVar.f8831e = i16;
        a(i16);
        int i17 = i14 + i15;
        b1Var.c(obj, bArr, i15, i17, aVar);
        aVar.f8831e--;
        aVar.f8829c = obj;
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(int i11, byte[] bArr, int i12, int i13, a aVar) {
        if (WireFormat.a(i11) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int b11 = WireFormat.b(i11);
        if (b11 == 0) {
            return L(bArr, i12, aVar);
        }
        if (b11 == 1) {
            return i12 + 8;
        }
        if (b11 == 2) {
            return I(bArr, i12, aVar) + aVar.f8827a;
        }
        if (b11 != 3) {
            if (b11 == 5) {
                return i12 + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i14 = (i11 & (-8)) | 4;
        int i15 = 0;
        while (i12 < i13) {
            i12 = I(bArr, i12, aVar);
            i15 = aVar.f8827a;
            if (i15 == i14) {
                break;
            }
            i12 = P(i15, bArr, i12, i13, aVar);
        }
        if (i12 > i13 || i15 != i14) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i12;
    }

    private static void a(int i11) {
        if (i11 >= f8826a) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        f fVar = (f) dVar;
        int L = L(bArr, i12, aVar);
        fVar.addBoolean(aVar.f8828b != 0);
        while (L < i13) {
            int I = I(bArr, L, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            L = L(bArr, I, aVar);
            fVar.addBoolean(aVar.f8828b != 0);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(byte[] bArr, int i11, a aVar) {
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a;
        if (i12 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i12 > bArr.length - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i12 == 0) {
            aVar.f8829c = ByteString.EMPTY;
            return I;
        }
        aVar.f8829c = ByteString.copyFrom(bArr, I, i12);
        return I + i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        int I = I(bArr, i12, aVar);
        int i14 = aVar.f8827a;
        if (i14 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i14 > bArr.length - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i14 == 0) {
            dVar.add(ByteString.EMPTY);
        } else {
            dVar.add(ByteString.copyFrom(bArr, I, i14));
            I += i14;
        }
        while (I < i13) {
            int I2 = I(bArr, I, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            I = I(bArr, I2, aVar);
            int i15 = aVar.f8827a;
            if (i15 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i15 > bArr.length - I) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i15 == 0) {
                dVar.add(ByteString.EMPTY);
            } else {
                dVar.add(ByteString.copyFrom(bArr, I, i15));
                I += i15;
            }
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double e(byte[] bArr, int i11) {
        return Double.longBitsToDouble(j(bArr, i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        l lVar = (l) dVar;
        lVar.addDouble(e(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int I = I(bArr, i14, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            lVar.addDouble(e(bArr, I));
            i14 = I + 8;
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i11, byte[] bArr, int i12, int i13, Object obj, n0 n0Var, h1 h1Var, a aVar) {
        aVar.f8830d.a(n0Var, i11 >>> 3);
        return G(i11, bArr, i12, i13, q0.q(obj), aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        v vVar = (v) dVar;
        vVar.addInt(h(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int I = I(bArr, i14, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            vVar.addInt(h(bArr, I));
            i14 = I + 4;
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long j(byte[] bArr, int i11) {
        return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        f0 f0Var = (f0) dVar;
        f0Var.addLong(j(bArr, i12));
        int i14 = i12 + 8;
        while (i14 < i13) {
            int I = I(bArr, i14, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            f0Var.addLong(j(bArr, I));
            i14 = I + 8;
        }
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float l(byte[] bArr, int i11) {
        return Float.intBitsToFloat(h(bArr, i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        t tVar = (t) dVar;
        tVar.addFloat(l(bArr, i12));
        int i14 = i12 + 4;
        while (i14 < i13) {
            int I = I(bArr, i14, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            tVar.addFloat(l(bArr, I));
            i14 = I + 4;
        }
        return i14;
    }

    static int n(b1 b1Var, byte[] bArr, int i11, int i12, int i13, a aVar) {
        Object newInstance = b1Var.newInstance();
        int N = N(newInstance, b1Var, bArr, i11, i12, i13, aVar);
        b1Var.makeImmutable(newInstance);
        aVar.f8829c = newInstance;
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(b1 b1Var, int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        int i14 = (i11 & (-8)) | 4;
        int n11 = n(b1Var, bArr, i12, i13, i14, aVar);
        dVar.add(aVar.f8829c);
        while (n11 < i13) {
            int I = I(bArr, n11, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            n11 = n(b1Var, bArr, I, i13, i14, aVar);
            dVar.add(aVar.f8829c);
        }
        return n11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(b1 b1Var, byte[] bArr, int i11, int i12, a aVar) {
        Object newInstance = b1Var.newInstance();
        int O = O(newInstance, b1Var, bArr, i11, i12, aVar);
        b1Var.makeImmutable(newInstance);
        aVar.f8829c = newInstance;
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(b1 b1Var, int i11, byte[] bArr, int i12, int i13, w.d dVar, a aVar) {
        int p11 = p(b1Var, bArr, i12, i13, aVar);
        dVar.add(aVar.f8829c);
        while (p11 < i13) {
            int I = I(bArr, p11, aVar);
            if (i11 != aVar.f8827a) {
                break;
            }
            p11 = p(b1Var, bArr, I, i13, aVar);
            dVar.add(aVar.f8829c);
        }
        return p11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(byte[] bArr, int i11, w.d dVar, a aVar) {
        f fVar = (f) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            I = L(bArr, I, aVar);
            fVar.addBoolean(aVar.f8828b != 0);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(byte[] bArr, int i11, w.d dVar, a aVar) {
        l lVar = (l) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            lVar.addDouble(e(bArr, I));
            I += 8;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(byte[] bArr, int i11, w.d dVar, a aVar) {
        v vVar = (v) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            vVar.addInt(h(bArr, I));
            I += 4;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(byte[] bArr, int i11, w.d dVar, a aVar) {
        f0 f0Var = (f0) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            f0Var.addLong(j(bArr, I));
            I += 8;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(byte[] bArr, int i11, w.d dVar, a aVar) {
        t tVar = (t) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            tVar.addFloat(l(bArr, I));
            I += 4;
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(byte[] bArr, int i11, w.d dVar, a aVar) {
        v vVar = (v) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            I = I(bArr, I, aVar);
            vVar.addInt(i.c(aVar.f8827a));
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(byte[] bArr, int i11, w.d dVar, a aVar) {
        f0 f0Var = (f0) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            I = L(bArr, I, aVar);
            f0Var.addLong(i.d(aVar.f8828b));
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(byte[] bArr, int i11, w.d dVar, a aVar) {
        v vVar = (v) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            I = I(bArr, I, aVar);
            vVar.addInt(aVar.f8827a);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(byte[] bArr, int i11, w.d dVar, a aVar) {
        f0 f0Var = (f0) dVar;
        int I = I(bArr, i11, aVar);
        int i12 = aVar.f8827a + I;
        while (I < i12) {
            I = L(bArr, I, aVar);
            f0Var.addLong(aVar.f8828b);
        }
        if (I == i12) {
            return I;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
