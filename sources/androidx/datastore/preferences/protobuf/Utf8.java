package androidx.datastore.preferences.protobuf;

import com.cloud.tmc.kernel.constants.TmcConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class Utf8 {

    /* renamed from: a, reason: collision with root package name */
    private static final b f8809a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i11, int i12) {
            super("Unpaired surrogate at index " + i11 + " of " + i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) {
            if (m(b12) || (((b11 << 28) + (b12 + 112)) >> 30) != 0 || m(b13) || m(b14)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int r11 = ((b11 & 7) << 18) | (r(b12) << 12) | (r(b13) << 6) | r(b14);
            cArr[i11] = l(r11);
            cArr[i11 + 1] = q(r11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b11, char[] cArr, int i11) {
            cArr[i11] = (char) b11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b11, byte b12, byte b13, char[] cArr, int i11) {
            if (m(b12) || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || m(b13)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i11] = (char) (((b11 & 15) << 12) | (r(b12) << 6) | r(b13));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b11, byte b12, char[] cArr, int i11) {
            if (b11 < -62 || m(b12)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i11] = (char) (((b11 & 31) << 6) | r(b12));
        }

        private static char l(int i11) {
            return (char) ((i11 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean m(byte b11) {
            return b11 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b11) {
            return b11 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b11) {
            return b11 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b11) {
            return b11 < -32;
        }

        private static char q(int i11) {
            return (char) ((i11 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int r(byte b11) {
            return b11 & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b {
        b() {
        }

        private static int j(ByteBuffer byteBuffer, int i11, int i12) {
            int l11 = i11 + Utf8.l(byteBuffer, i11, i12);
            while (l11 < i12) {
                int i13 = l11 + 1;
                byte b11 = byteBuffer.get(l11);
                if (b11 >= 0) {
                    l11 = i13;
                } else if (b11 < -32) {
                    if (i13 >= i12) {
                        return b11;
                    }
                    if (b11 < -62 || byteBuffer.get(i13) > -65) {
                        return -1;
                    }
                    l11 += 2;
                } else {
                    if (b11 >= -16) {
                        if (i13 >= i12 - 2) {
                            return Utf8.p(byteBuffer, b11, i13, i12 - i13);
                        }
                        int i14 = l11 + 2;
                        byte b12 = byteBuffer.get(i13);
                        if (b12 <= -65 && (((b11 << 28) + (b12 + 112)) >> 30) == 0) {
                            int i15 = l11 + 3;
                            if (byteBuffer.get(i14) <= -65) {
                                l11 += 4;
                                if (byteBuffer.get(i15) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i13 >= i12 - 1) {
                        return Utf8.p(byteBuffer, b11, i13, i12 - i13);
                    }
                    int i16 = l11 + 2;
                    byte b13 = byteBuffer.get(i13);
                    if (b13 > -65 || ((b11 == -32 && b13 < -96) || ((b11 == -19 && b13 >= -96) || byteBuffer.get(i16) > -65))) {
                        return -1;
                    }
                    l11 += 3;
                }
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i11, int i12) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i11, i12);
            }
            return byteBuffer.isDirect() ? d(byteBuffer, i11, i12) : c(byteBuffer, i11, i12);
        }

        abstract String b(byte[] bArr, int i11, int i12);

        final String c(ByteBuffer byteBuffer, int i11, int i12) {
            if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (i11 < i13) {
                byte b11 = byteBuffer.get(i11);
                if (!a.n(b11)) {
                    break;
                }
                i11++;
                a.i(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (i11 < i13) {
                int i16 = i11 + 1;
                byte b12 = byteBuffer.get(i11);
                if (a.n(b12)) {
                    int i17 = i15 + 1;
                    a.i(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = byteBuffer.get(i16);
                        if (!a.n(b13)) {
                            break;
                        }
                        i16++;
                        a.i(b13, cArr, i17);
                        i17++;
                    }
                    i15 = i17;
                    i11 = i16;
                } else if (a.p(b12)) {
                    if (i16 >= i13) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i11 += 2;
                    a.k(b12, byteBuffer.get(i16), cArr, i15);
                    i15++;
                } else if (a.o(b12)) {
                    if (i16 >= i13 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i18 = i11 + 2;
                    i11 += 3;
                    a.j(b12, byteBuffer.get(i16), byteBuffer.get(i18), cArr, i15);
                    i15++;
                } else {
                    if (i16 >= i13 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b14 = byteBuffer.get(i16);
                    int i19 = i11 + 3;
                    byte b15 = byteBuffer.get(i11 + 2);
                    i11 += 4;
                    a.h(b12, b14, b15, byteBuffer.get(i19), cArr, i15);
                    i15 += 2;
                }
            }
            return new String(cArr, 0, i15);
        }

        abstract String d(ByteBuffer byteBuffer, int i11, int i12);

        abstract int e(String str, byte[] bArr, int i11, int i12);

        final boolean f(ByteBuffer byteBuffer, int i11, int i12) {
            return h(0, byteBuffer, i11, i12) == 0;
        }

        final boolean g(byte[] bArr, int i11, int i12) {
            return i(0, bArr, i11, i12) == 0;
        }

        final int h(int i11, ByteBuffer byteBuffer, int i12, int i13) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? l(i11, byteBuffer, i12, i13) : k(i11, byteBuffer, i12, i13);
            }
            int arrayOffset = byteBuffer.arrayOffset();
            return i(i11, byteBuffer.array(), i12 + arrayOffset, arrayOffset + i13);
        }

        abstract int i(int i11, byte[] bArr, int i12, int i13);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int k(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = androidx.datastore.preferences.protobuf.Utf8.a(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = androidx.datastore.preferences.protobuf.Utf8.a(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = androidx.datastore.preferences.protobuf.Utf8.b(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = j(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.b.k(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int l(int i11, ByteBuffer byteBuffer, int i12, int i13);
    }

    /* loaded from: classes.dex */
    static final class c extends b {
        c() {
        }

        private static int m(byte[] bArr, int i11, int i12) {
            while (i11 < i12 && bArr[i11] >= 0) {
                i11++;
            }
            if (i11 >= i12) {
                return 0;
            }
            return n(bArr, i11, i12);
        }

        private static int n(byte[] bArr, int i11, int i12) {
            while (i11 < i12) {
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 < 0) {
                    if (b11 < -32) {
                        if (i13 >= i12) {
                            return b11;
                        }
                        if (b11 >= -62) {
                            i11 += 2;
                            if (bArr[i13] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b11 >= -16) {
                        if (i13 >= i12 - 2) {
                            return Utf8.q(bArr, i13, i12);
                        }
                        int i14 = i11 + 2;
                        byte b12 = bArr[i13];
                        if (b12 <= -65 && (((b11 << 28) + (b12 + 112)) >> 30) == 0) {
                            int i15 = i11 + 3;
                            if (bArr[i14] <= -65) {
                                i11 += 4;
                                if (bArr[i15] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i13 >= i12 - 1) {
                        return Utf8.q(bArr, i13, i12);
                    }
                    int i16 = i11 + 2;
                    byte b13 = bArr[i13];
                    if (b13 <= -65 && ((b11 != -32 || b13 >= -96) && (b11 != -19 || b13 < -96))) {
                        i11 += 3;
                        if (bArr[i16] > -65) {
                        }
                    }
                    return -1;
                }
                i11 = i13;
            }
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        String b(byte[] bArr, int i11, int i12) {
            if ((i11 | i12 | ((bArr.length - i11) - i12)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (i11 < i13) {
                byte b11 = bArr[i11];
                if (!a.n(b11)) {
                    break;
                }
                i11++;
                a.i(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (i11 < i13) {
                int i16 = i11 + 1;
                byte b12 = bArr[i11];
                if (a.n(b12)) {
                    int i17 = i15 + 1;
                    a.i(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = bArr[i16];
                        if (!a.n(b13)) {
                            break;
                        }
                        i16++;
                        a.i(b13, cArr, i17);
                        i17++;
                    }
                    i15 = i17;
                    i11 = i16;
                } else if (a.p(b12)) {
                    if (i16 >= i13) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i11 += 2;
                    a.k(b12, bArr[i16], cArr, i15);
                    i15++;
                } else if (a.o(b12)) {
                    if (i16 >= i13 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i18 = i11 + 2;
                    i11 += 3;
                    a.j(b12, bArr[i16], bArr[i18], cArr, i15);
                    i15++;
                } else {
                    if (i16 >= i13 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b14 = bArr[i16];
                    int i19 = i11 + 3;
                    byte b15 = bArr[i11 + 2];
                    i11 += 4;
                    a.h(b12, b14, b15, bArr[i19], cArr, i15);
                    i15 += 2;
                }
            }
            return new String(cArr, 0, i15);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        String d(ByteBuffer byteBuffer, int i11, int i12) {
            return c(byteBuffer, i11, i12);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int e(java.lang.String r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.c.e(java.lang.String, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int i(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = androidx.datastore.preferences.protobuf.Utf8.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = androidx.datastore.preferences.protobuf.Utf8.a(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = androidx.datastore.preferences.protobuf.Utf8.b(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.c.i(int, byte[], int, int):int");
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        int l(int i11, ByteBuffer byteBuffer, int i12, int i13) {
            return k(i11, byteBuffer, i12, i13);
        }
    }

    /* loaded from: classes.dex */
    static final class d extends b {
        d() {
        }

        static boolean m() {
            return k1.I() && k1.J();
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int n(long r10, int r12) {
            /*
                int r0 = p(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = androidx.datastore.preferences.protobuf.k1.w(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = androidx.datastore.preferences.protobuf.k1.w(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = r(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.k1.w(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = androidx.datastore.preferences.protobuf.k1.w(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = r(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = androidx.datastore.preferences.protobuf.k1.w(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = androidx.datastore.preferences.protobuf.k1.w(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = androidx.datastore.preferences.protobuf.k1.w(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.n(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int o(byte[] r10, long r11, int r13) {
            /*
                int r0 = q(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = androidx.datastore.preferences.protobuf.k1.x(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = androidx.datastore.preferences.protobuf.k1.x(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = s(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.k1.x(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = androidx.datastore.preferences.protobuf.k1.x(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = s(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.k1.x(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = androidx.datastore.preferences.protobuf.k1.x(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.datastore.preferences.protobuf.k1.x(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.o(byte[], long, int):int");
        }

        private static int p(long j11, int i11) {
            if (i11 < 16) {
                return 0;
            }
            int i12 = (int) ((-j11) & 7);
            int i13 = i12;
            while (i13 > 0) {
                long j12 = 1 + j11;
                if (k1.w(j11) < 0) {
                    return i12 - i13;
                }
                i13--;
                j11 = j12;
            }
            int i14 = i11 - i12;
            while (i14 >= 8 && (k1.D(j11) & (-9187201950435737472L)) == 0) {
                j11 += 8;
                i14 -= 8;
            }
            return i11 - i14;
        }

        private static int q(byte[] bArr, long j11, int i11) {
            int i12 = 0;
            if (i11 < 16) {
                return 0;
            }
            int i13 = 8 - (((int) j11) & 7);
            while (i12 < i13) {
                long j12 = 1 + j11;
                if (k1.x(bArr, j11) < 0) {
                    return i12;
                }
                i12++;
                j11 = j12;
            }
            while (true) {
                int i14 = i12 + 8;
                if (i14 > i11 || (k1.E(bArr, k1.f8938h + j11) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j11 += 8;
                i12 = i14;
            }
            while (i12 < i11) {
                long j13 = j11 + 1;
                if (k1.x(bArr, j11) < 0) {
                    return i12;
                }
                i12++;
                j11 = j13;
            }
            return i11;
        }

        private static int r(long j11, int i11, int i12) {
            if (i12 == 0) {
                return Utf8.m(i11);
            }
            if (i12 == 1) {
                return Utf8.n(i11, k1.w(j11));
            }
            if (i12 == 2) {
                return Utf8.o(i11, k1.w(j11), k1.w(j11 + 1));
            }
            throw new AssertionError();
        }

        private static int s(byte[] bArr, int i11, long j11, int i12) {
            if (i12 == 0) {
                return Utf8.m(i11);
            }
            if (i12 == 1) {
                return Utf8.n(i11, k1.x(bArr, j11));
            }
            if (i12 == 2) {
                return Utf8.o(i11, k1.x(bArr, j11), k1.x(bArr, j11 + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        String b(byte[] bArr, int i11, int i12) {
            Charset charset = w.f8998b;
            String str = new String(bArr, i11, i12, charset);
            if (str.indexOf(okio.Utf8.REPLACEMENT_CODE_POINT) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i11, i12 + i11))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        String d(ByteBuffer byteBuffer, int i11, int i12) {
            if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            long k11 = k1.k(byteBuffer) + i11;
            long j11 = i12 + k11;
            char[] cArr = new char[i12];
            int i13 = 0;
            while (k11 < j11) {
                byte w11 = k1.w(k11);
                if (!a.n(w11)) {
                    break;
                }
                k11++;
                a.i(w11, cArr, i13);
                i13++;
            }
            while (k11 < j11) {
                long j12 = k11 + 1;
                byte w12 = k1.w(k11);
                if (a.n(w12)) {
                    int i14 = i13 + 1;
                    a.i(w12, cArr, i13);
                    while (j12 < j11) {
                        byte w13 = k1.w(j12);
                        if (!a.n(w13)) {
                            break;
                        }
                        j12++;
                        a.i(w13, cArr, i14);
                        i14++;
                    }
                    i13 = i14;
                    k11 = j12;
                } else if (a.p(w12)) {
                    if (j12 >= j11) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    k11 += 2;
                    a.k(w12, k1.w(j12), cArr, i13);
                    i13++;
                } else if (a.o(w12)) {
                    if (j12 >= j11 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j13 = 2 + k11;
                    k11 += 3;
                    a.j(w12, k1.w(j12), k1.w(j13), cArr, i13);
                    i13++;
                } else {
                    if (j12 >= j11 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte w14 = k1.w(j12);
                    long j14 = k11 + 3;
                    byte w15 = k1.w(2 + k11);
                    k11 += 4;
                    a.h(w12, w14, w15, k1.w(j14), cArr, i13);
                    i13 += 2;
                }
            }
            return new String(cArr, 0, i13);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        int e(String str, byte[] bArr, int i11, int i12) {
            long j11;
            String str2;
            String str3;
            int i13;
            long j12;
            long j13;
            char charAt;
            long j14 = i11;
            long j15 = i12 + j14;
            int length = str.length();
            String str4 = " at index ";
            String str5 = "Failed writing ";
            if (length > i12 || bArr.length - i12 < i11) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i11 + i12));
            }
            int i14 = 0;
            while (true) {
                j11 = 1;
                if (i14 >= length || (charAt = str.charAt(i14)) >= 128) {
                    break;
                }
                k1.P(bArr, j14, (byte) charAt);
                i14++;
                j14 = 1 + j14;
            }
            if (i14 == length) {
                return (int) j14;
            }
            while (i14 < length) {
                char charAt2 = str.charAt(i14);
                if (charAt2 >= 128 || j14 >= j15) {
                    if (charAt2 >= 2048 || j14 > j15 - 2) {
                        str2 = str4;
                        str3 = str5;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || j14 > j15 - 3) {
                            if (j14 > j15 - 4) {
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i13 = i14 + 1) == length || !Character.isSurrogatePair(charAt2, str.charAt(i13)))) {
                                    throw new UnpairedSurrogateException(i14, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str3 + charAt2 + str2 + j14);
                            }
                            int i15 = i14 + 1;
                            if (i15 != length) {
                                char charAt3 = str.charAt(i15);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    j12 = 1;
                                    k1.P(bArr, j14, (byte) ((codePoint >>> 18) | 240));
                                    j13 = j15;
                                    k1.P(bArr, j14 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j16 = j14 + 3;
                                    k1.P(bArr, j14 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j14 += 4;
                                    k1.P(bArr, j16, (byte) ((codePoint & 63) | 128));
                                    i14 = i15;
                                } else {
                                    i14 = i15;
                                }
                            }
                            throw new UnpairedSurrogateException(i14 - 1, length);
                        }
                        k1.P(bArr, j14, (byte) ((charAt2 >>> '\f') | 480));
                        long j17 = j14 + 2;
                        k1.P(bArr, j14 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j14 += 3;
                        k1.P(bArr, j17, (byte) ((charAt2 & '?') | 128));
                    } else {
                        str2 = str4;
                        str3 = str5;
                        long j18 = j14 + j11;
                        k1.P(bArr, j14, (byte) ((charAt2 >>> 6) | 960));
                        j14 += 2;
                        k1.P(bArr, j18, (byte) ((charAt2 & '?') | 128));
                    }
                    j13 = j15;
                    j12 = 1;
                } else {
                    k1.P(bArr, j14, (byte) charAt2);
                    j13 = j15;
                    str3 = str5;
                    j12 = j11;
                    j14 += j11;
                    str2 = str4;
                }
                i14++;
                str4 = str2;
                str5 = str3;
                j11 = j12;
                j15 = j13;
            }
            return (int) j14;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (androidx.datastore.preferences.protobuf.k1.x(r13, r1) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.k1.x(r13, r1) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int i(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.i(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            if (androidx.datastore.preferences.protobuf.k1.w(r1) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (androidx.datastore.preferences.protobuf.k1.w(r1) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a3, code lost:
        
            if (androidx.datastore.preferences.protobuf.k1.w(r1) > (-65)) goto L57;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int l(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        f8809a = (!d.m() || androidx.datastore.preferences.protobuf.d.c()) ? new c() : new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(ByteBuffer byteBuffer, int i11, int i12) {
        return f8809a.a(byteBuffer, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(byte[] bArr, int i11, int i12) {
        return f8809a.b(bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(String str, byte[] bArr, int i11, int i12) {
        return f8809a.e(str, bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length && str.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 < length) {
                char charAt = str.charAt(i11);
                if (charAt >= 2048) {
                    i12 += k(str, i11);
                    break;
                }
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                break;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i12 + TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE));
    }

    private static int k(String str, int i11) {
        int length = str.length();
        int i12 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
            } else {
                i12 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(str, i11) < 65536) {
                        throw new UnpairedSurrogateException(i11, length);
                    }
                    i11++;
                }
            }
            i11++;
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(ByteBuffer byteBuffer, int i11, int i12) {
        int i13 = i12 - 7;
        int i14 = i11;
        while (i14 < i13 && (byteBuffer.getLong(i14) & (-9187201950435737472L)) == 0) {
            i14 += 8;
        }
        return i14 - i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i11) {
        if (i11 > -12) {
            return -1;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(ByteBuffer byteBuffer, int i11, int i12, int i13) {
        if (i13 == 0) {
            return m(i11);
        }
        if (i13 == 1) {
            return n(i11, byteBuffer.get(i12));
        }
        if (i13 == 2) {
            return o(i11, byteBuffer.get(i12), byteBuffer.get(i12 + 1));
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 == 0) {
            return m(b11);
        }
        if (i13 == 1) {
            return n(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return o(b11, bArr[i11], bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(ByteBuffer byteBuffer) {
        return f8809a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(byte[] bArr, int i11, int i12) {
        return f8809a.g(bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(int i11, ByteBuffer byteBuffer, int i12, int i13) {
        return f8809a.h(i11, byteBuffer, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i11, byte[] bArr, int i12, int i13) {
        return f8809a.i(i11, bArr, i12, i13);
    }
}
