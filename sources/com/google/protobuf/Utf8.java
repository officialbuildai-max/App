package com.google.protobuf;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final b processor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i11, int i12) {
            super("Unpaired surrogate at index " + i11 + " of " + i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b12) || (((b11 << 28) + (b12 + 112)) >> 30) != 0 || isNotTrailingByte(b13) || isNotTrailingByte(b14)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b11 & 7) << 18) | (trailingByteValue(b12) << 12) | (trailingByteValue(b13) << 6) | trailingByteValue(b14);
            cArr[i11] = highSurrogate(trailingByteValue);
            cArr[i11 + 1] = lowSurrogate(trailingByteValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b11, char[] cArr, int i11) {
            cArr[i11] = (char) b11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b11, byte b12, byte b13, char[] cArr, int i11) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b12) || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || isNotTrailingByte(b13)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i11] = (char) (((b11 & 15) << 12) | (trailingByteValue(b12) << 6) | trailingByteValue(b13));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b11, byte b12, char[] cArr, int i11) throws InvalidProtocolBufferException {
            if (b11 < -62 || isNotTrailingByte(b12)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i11] = (char) (((b11 & 31) << 6) | trailingByteValue(b12));
        }

        private static char highSurrogate(int i11) {
            return (char) ((i11 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b11) {
            return b11 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b11) {
            return b11 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b11) {
            return b11 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b11) {
            return b11 < -32;
        }

        private static char lowSurrogate(int i11) {
            return (char) ((i11 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b11) {
            return b11 & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class b {
        b() {
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i11, int i12) {
            int estimateConsecutiveAscii = i11 + Utf8.estimateConsecutiveAscii(byteBuffer, i11, i12);
            while (estimateConsecutiveAscii < i12) {
                int i13 = estimateConsecutiveAscii + 1;
                byte b11 = byteBuffer.get(estimateConsecutiveAscii);
                if (b11 >= 0) {
                    estimateConsecutiveAscii = i13;
                } else if (b11 < -32) {
                    if (i13 >= i12) {
                        return b11;
                    }
                    if (b11 < -62 || byteBuffer.get(i13) > -65) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 2;
                } else {
                    if (b11 >= -16) {
                        if (i13 >= i12 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b11, i13, i12 - i13);
                        }
                        int i14 = estimateConsecutiveAscii + 2;
                        byte b12 = byteBuffer.get(i13);
                        if (b12 <= -65 && (((b11 << 28) + (b12 + 112)) >> 30) == 0) {
                            int i15 = estimateConsecutiveAscii + 3;
                            if (byteBuffer.get(i14) <= -65) {
                                estimateConsecutiveAscii += 4;
                                if (byteBuffer.get(i15) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i13 >= i12 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b11, i13, i12 - i13);
                    }
                    int i16 = estimateConsecutiveAscii + 2;
                    byte b13 = byteBuffer.get(i13);
                    if (b13 > -65 || ((b11 == -32 && b13 < -96) || ((b11 == -19 && b13 >= -96) || byteBuffer.get(i16) > -65))) {
                        return -1;
                    }
                    estimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i11, i12);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i11, i12) : decodeUtf8Default(byteBuffer, i11, i12);
        }

        abstract String decodeUtf8(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException;

        final String decodeUtf8Default(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (i11 < i13) {
                byte b11 = byteBuffer.get(i11);
                if (!a.isOneByte(b11)) {
                    break;
                }
                i11++;
                a.handleOneByte(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (i11 < i13) {
                int i16 = i11 + 1;
                byte b12 = byteBuffer.get(i11);
                if (a.isOneByte(b12)) {
                    int i17 = i15 + 1;
                    a.handleOneByte(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = byteBuffer.get(i16);
                        if (!a.isOneByte(b13)) {
                            break;
                        }
                        i16++;
                        a.handleOneByte(b13, cArr, i17);
                        i17++;
                    }
                    i15 = i17;
                    i11 = i16;
                } else if (a.isTwoBytes(b12)) {
                    if (i16 >= i13) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i11 += 2;
                    a.handleTwoBytes(b12, byteBuffer.get(i16), cArr, i15);
                    i15++;
                } else if (a.isThreeBytes(b12)) {
                    if (i16 >= i13 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i18 = i11 + 2;
                    i11 += 3;
                    a.handleThreeBytes(b12, byteBuffer.get(i16), byteBuffer.get(i18), cArr, i15);
                    i15++;
                } else {
                    if (i16 >= i13 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b14 = byteBuffer.get(i16);
                    int i19 = i11 + 3;
                    byte b15 = byteBuffer.get(i11 + 2);
                    i11 += 4;
                    a.handleFourBytes(b12, b14, b15, byteBuffer.get(i19), cArr, i15);
                    i15 += 2;
                }
            }
            return new String(cArr, 0, i15);
        }

        abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i11, int i12);

        final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                e0.position(byteBuffer, Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i11;
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i12 = 0;
            while (i12 < length) {
                try {
                    char charAt = charSequence.charAt(i12);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i12, (byte) charAt);
                    i12++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i12 == length) {
                e0.position(byteBuffer, position + i12);
                return;
            }
            position += i12;
            while (i12 < length) {
                char charAt2 = charSequence.charAt(i12);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i13 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | PsExtractor.AUDIO_STREAM));
                        byteBuffer.put(i13, (byte) ((charAt2 & '?') | 128));
                        position = i13;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i13;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                    }
                } else {
                    if (charAt2 >= 55296 && 57343 >= charAt2) {
                        int i14 = i12 + 1;
                        if (i14 != length) {
                            try {
                                char charAt3 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i15 = position + 1;
                                    try {
                                        byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                        i11 = position + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        position = i15;
                                        i12 = i14;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                                    }
                                    try {
                                        byteBuffer.put(i15, (byte) (((codePoint >>> 12) & 63) | 128));
                                        position += 3;
                                        byteBuffer.put(i11, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                        i12 = i14;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i12 = i14;
                                        position = i11;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                                    }
                                } else {
                                    i12 = i14;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i12, length);
                    }
                    int i16 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                    position += 2;
                    byteBuffer.put(i16, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                }
                i12++;
                position++;
            }
            e0.position(byteBuffer, position);
        }

        abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        final boolean isValidUtf8(ByteBuffer byteBuffer, int i11, int i12) {
            return partialIsValidUtf8(0, byteBuffer, i11, i12) == 0;
        }

        final boolean isValidUtf8(byte[] bArr, int i11, int i12) {
            return partialIsValidUtf8(0, bArr, i11, i12) == 0;
        }

        final int partialIsValidUtf8(int i11, ByteBuffer byteBuffer, int i12, int i13) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i11, byteBuffer, i12, i13) : partialIsValidUtf8Default(i11, byteBuffer, i12, i13);
            }
            int arrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i11, byteBuffer.array(), i12 + arrayOffset, arrayOffset + i13);
        }

        abstract int partialIsValidUtf8(int i11, byte[] bArr, int i12, int i13);

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
        final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
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
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
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
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
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
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r7)
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
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.b.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int partialIsValidUtf8Direct(int i11, ByteBuffer byteBuffer, int i12, int i13);
    }

    /* loaded from: classes4.dex */
    static final class c extends b {
        c() {
        }

        private static int partialIsValidUtf8(byte[] bArr, int i11, int i12) {
            while (i11 < i12 && bArr[i11] >= 0) {
                i11++;
            }
            if (i11 >= i12) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i11, i12);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i11, int i12) {
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
                            return Utf8.incompleteStateFor(bArr, i13, i12);
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
                        return Utf8.incompleteStateFor(bArr, i13, i12);
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

        @Override // com.google.protobuf.Utf8.b
        String decodeUtf8(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            if ((i11 | i12 | ((bArr.length - i11) - i12)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (i11 < i13) {
                byte b11 = bArr[i11];
                if (!a.isOneByte(b11)) {
                    break;
                }
                i11++;
                a.handleOneByte(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (i11 < i13) {
                int i16 = i11 + 1;
                byte b12 = bArr[i11];
                if (a.isOneByte(b12)) {
                    int i17 = i15 + 1;
                    a.handleOneByte(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = bArr[i16];
                        if (!a.isOneByte(b13)) {
                            break;
                        }
                        i16++;
                        a.handleOneByte(b13, cArr, i17);
                        i17++;
                    }
                    i15 = i17;
                    i11 = i16;
                } else if (a.isTwoBytes(b12)) {
                    if (i16 >= i13) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i11 += 2;
                    a.handleTwoBytes(b12, bArr[i16], cArr, i15);
                    i15++;
                } else if (a.isThreeBytes(b12)) {
                    if (i16 >= i13 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i18 = i11 + 2;
                    i11 += 3;
                    a.handleThreeBytes(b12, bArr[i16], bArr[i18], cArr, i15);
                    i15++;
                } else {
                    if (i16 >= i13 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b14 = bArr[i16];
                    int i19 = i11 + 3;
                    byte b15 = bArr[i11 + 2];
                    i11 += 4;
                    a.handleFourBytes(b12, b14, b15, bArr[i19], cArr, i15);
                    i15 += 2;
                }
            }
            return new String(cArr, 0, i15);
        }

        @Override // com.google.protobuf.Utf8.b
        String decodeUtf8Direct(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i11, i12);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int encodeUtf8(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.c.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.b
        void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
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
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
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
                int r7 = com.google.protobuf.Utf8.access$000(r0, r9)
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
                int r7 = com.google.protobuf.Utf8.access$000(r0, r1)
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
                int r7 = com.google.protobuf.Utf8.access$100(r0, r1, r7)
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
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.c.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.b
        int partialIsValidUtf8Direct(int i11, ByteBuffer byteBuffer, int i12, int i13) {
            return partialIsValidUtf8Default(i11, byteBuffer, i12, i13);
        }
    }

    /* loaded from: classes4.dex */
    static final class d extends b {
        d() {
        }

        static boolean isAvailable() {
            return s1.hasUnsafeArrayOperations() && s1.hasUnsafeByteBufferOperations();
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
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
                byte r1 = com.google.protobuf.s1.getByte(r10)
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
                byte r10 = com.google.protobuf.s1.getByte(r10)
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
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.s1.getByte(r10)
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
                byte r0 = com.google.protobuf.s1.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.s1.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.s1.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.s1.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.d.partialIsValidUtf8(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
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
                byte r1 = com.google.protobuf.s1.getByte(r10, r11)
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
                byte r11 = com.google.protobuf.s1.getByte(r10, r11)
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
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.s1.getByte(r10, r11)
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
                byte r0 = com.google.protobuf.s1.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.s1.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.s1.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.s1.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.d.partialIsValidUtf8(byte[], long, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j11, int i11) {
            if (i11 < 16) {
                return 0;
            }
            int i12 = (int) ((-j11) & 7);
            int i13 = i12;
            while (i13 > 0) {
                long j12 = 1 + j11;
                if (s1.getByte(j11) < 0) {
                    return i12 - i13;
                }
                i13--;
                j11 = j12;
            }
            int i14 = i11 - i12;
            while (i14 >= 8 && (s1.getLong(j11) & Utf8.ASCII_MASK_LONG) == 0) {
                j11 += 8;
                i14 -= 8;
            }
            return i11 - i14;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j11, int i11) {
            int i12 = 0;
            if (i11 < 16) {
                return 0;
            }
            int i13 = 8 - (((int) j11) & 7);
            while (i12 < i13) {
                long j12 = 1 + j11;
                if (s1.getByte(bArr, j11) < 0) {
                    return i12;
                }
                i12++;
                j11 = j12;
            }
            while (true) {
                int i14 = i12 + 8;
                if (i14 > i11 || (s1.getLong((Object) bArr, s1.BYTE_ARRAY_BASE_OFFSET + j11) & Utf8.ASCII_MASK_LONG) != 0) {
                    break;
                }
                j11 += 8;
                i12 = i14;
            }
            while (i12 < i11) {
                long j13 = j11 + 1;
                if (s1.getByte(bArr, j11) < 0) {
                    return i12;
                }
                i12++;
                j11 = j13;
            }
            return i11;
        }

        private static int unsafeIncompleteStateFor(long j11, int i11, int i12) {
            if (i12 == 0) {
                return Utf8.incompleteStateFor(i11);
            }
            if (i12 == 1) {
                return Utf8.incompleteStateFor(i11, s1.getByte(j11));
            }
            if (i12 == 2) {
                return Utf8.incompleteStateFor(i11, s1.getByte(j11), s1.getByte(j11 + 1));
            }
            throw new AssertionError();
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i11, long j11, int i12) {
            if (i12 == 0) {
                return Utf8.incompleteStateFor(i11);
            }
            if (i12 == 1) {
                return Utf8.incompleteStateFor(i11, s1.getByte(bArr, j11));
            }
            if (i12 == 2) {
                return Utf8.incompleteStateFor(i11, s1.getByte(bArr, j11), s1.getByte(bArr, j11 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.b
        String decodeUtf8(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            Charset charset = y.UTF_8;
            String str = new String(bArr, i11, i12, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i11, i12 + i11))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.protobuf.Utf8.b
        String decodeUtf8Direct(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)));
            }
            long addressOffset = s1.addressOffset(byteBuffer) + i11;
            long j11 = i12 + addressOffset;
            char[] cArr = new char[i12];
            int i13 = 0;
            while (addressOffset < j11) {
                byte b11 = s1.getByte(addressOffset);
                if (!a.isOneByte(b11)) {
                    break;
                }
                addressOffset++;
                a.handleOneByte(b11, cArr, i13);
                i13++;
            }
            while (addressOffset < j11) {
                long j12 = addressOffset + 1;
                byte b12 = s1.getByte(addressOffset);
                if (a.isOneByte(b12)) {
                    int i14 = i13 + 1;
                    a.handleOneByte(b12, cArr, i13);
                    while (j12 < j11) {
                        byte b13 = s1.getByte(j12);
                        if (!a.isOneByte(b13)) {
                            break;
                        }
                        j12++;
                        a.handleOneByte(b13, cArr, i14);
                        i14++;
                    }
                    i13 = i14;
                    addressOffset = j12;
                } else if (a.isTwoBytes(b12)) {
                    if (j12 >= j11) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    addressOffset += 2;
                    a.handleTwoBytes(b12, s1.getByte(j12), cArr, i13);
                    i13++;
                } else if (a.isThreeBytes(b12)) {
                    if (j12 >= j11 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j13 = 2 + addressOffset;
                    addressOffset += 3;
                    a.handleThreeBytes(b12, s1.getByte(j12), s1.getByte(j13), cArr, i13);
                    i13++;
                } else {
                    if (j12 >= j11 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b14 = s1.getByte(j12);
                    long j14 = addressOffset + 3;
                    byte b15 = s1.getByte(2 + addressOffset);
                    addressOffset += 4;
                    a.handleFourBytes(b12, b14, b15, s1.getByte(j14), cArr, i13);
                    i13 += 2;
                }
            }
            return new String(cArr, 0, i13);
        }

        @Override // com.google.protobuf.Utf8.b
        int encodeUtf8(CharSequence charSequence, byte[] bArr, int i11, int i12) {
            long j11;
            String str;
            String str2;
            int i13;
            long j12;
            long j13;
            char charAt;
            long j14 = i11;
            long j15 = i12 + j14;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length > i12 || bArr.length - i12 < i11) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i11 + i12));
            }
            int i14 = 0;
            while (true) {
                j11 = 1;
                if (i14 >= length || (charAt = charSequence.charAt(i14)) >= 128) {
                    break;
                }
                s1.putByte(bArr, j14, (byte) charAt);
                i14++;
                j14 = 1 + j14;
            }
            if (i14 == length) {
                return (int) j14;
            }
            while (i14 < length) {
                char charAt2 = charSequence.charAt(i14);
                if (charAt2 >= 128 || j14 >= j15) {
                    if (charAt2 >= 2048 || j14 > j15 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || j14 > j15 - 3) {
                            if (j14 > j15 - 4) {
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i13 = i14 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i13)))) {
                                    throw new UnpairedSurrogateException(i14, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j14);
                            }
                            int i15 = i14 + 1;
                            if (i15 != length) {
                                char charAt3 = charSequence.charAt(i15);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    j12 = 1;
                                    s1.putByte(bArr, j14, (byte) ((codePoint >>> 18) | 240));
                                    j13 = j15;
                                    s1.putByte(bArr, j14 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j16 = j14 + 3;
                                    s1.putByte(bArr, j14 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j14 += 4;
                                    s1.putByte(bArr, j16, (byte) ((codePoint & 63) | 128));
                                    i14 = i15;
                                } else {
                                    i14 = i15;
                                }
                            }
                            throw new UnpairedSurrogateException(i14 - 1, length);
                        }
                        s1.putByte(bArr, j14, (byte) ((charAt2 >>> '\f') | 480));
                        long j17 = j14 + 2;
                        s1.putByte(bArr, j14 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j14 += 3;
                        s1.putByte(bArr, j17, (byte) ((charAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j18 = j14 + j11;
                        s1.putByte(bArr, j14, (byte) ((charAt2 >>> 6) | 960));
                        j14 += 2;
                        s1.putByte(bArr, j18, (byte) ((charAt2 & '?') | 128));
                    }
                    j13 = j15;
                    j12 = 1;
                } else {
                    s1.putByte(bArr, j14, (byte) charAt2);
                    j13 = j15;
                    str2 = str4;
                    j12 = j11;
                    j14 += j11;
                    str = str3;
                }
                i14++;
                str3 = str;
                str4 = str2;
                j11 = j12;
                j15 = j13;
            }
            return (int) j14;
        }

        @Override // com.google.protobuf.Utf8.b
        void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j11;
            char c11;
            long j12;
            int i11;
            int i12;
            char c12;
            char charAt;
            long addressOffset = s1.addressOffset(byteBuffer);
            long position = byteBuffer.position() + addressOffset;
            long limit = byteBuffer.limit() + addressOffset;
            int length = charSequence.length();
            if (length > limit - position) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i13 = 0;
            while (true) {
                j11 = 1;
                c11 = 128;
                if (i13 >= length || (charAt = charSequence.charAt(i13)) >= 128) {
                    break;
                }
                s1.putByte(position, (byte) charAt);
                i13++;
                position = 1 + position;
            }
            if (i13 == length) {
                e0.position(byteBuffer, (int) (position - addressOffset));
                return;
            }
            while (i13 < length) {
                char charAt2 = charSequence.charAt(i13);
                if (charAt2 >= c11 || position >= limit) {
                    if (charAt2 >= 2048 || position > limit - 2) {
                        j12 = addressOffset;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || position > limit - 3) {
                            if (position > limit - 4) {
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i11 = i13 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i11)))) {
                                    throw new UnpairedSurrogateException(i13, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                            }
                            i12 = i13 + 1;
                            if (i12 != length) {
                                char charAt3 = charSequence.charAt(i12);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    s1.putByte(position, (byte) ((codePoint >>> 18) | 240));
                                    c12 = 128;
                                    s1.putByte(position + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j13 = position + 3;
                                    s1.putByte(position + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    position += 4;
                                    s1.putByte(j13, (byte) ((codePoint & 63) | 128));
                                } else {
                                    i13 = i12;
                                }
                            }
                            throw new UnpairedSurrogateException(i13 - 1, length);
                        }
                        long j14 = position + j11;
                        s1.putByte(position, (byte) ((charAt2 >>> '\f') | 480));
                        long j15 = position + 2;
                        s1.putByte(j14, (byte) (((charAt2 >>> 6) & 63) | 128));
                        position += 3;
                        s1.putByte(j15, (byte) ((charAt2 & '?') | 128));
                    } else {
                        j12 = addressOffset;
                        long j16 = position + j11;
                        s1.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                        position += 2;
                        s1.putByte(j16, (byte) ((charAt2 & '?') | 128));
                    }
                    i12 = i13;
                    c12 = 128;
                } else {
                    s1.putByte(position, (byte) charAt2);
                    j12 = addressOffset;
                    i12 = i13;
                    c12 = c11;
                    position += j11;
                }
                c11 = c12;
                addressOffset = j12;
                j11 = 1;
                i13 = i12 + 1;
            }
            e0.position(byteBuffer, (int) (position - addressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (com.google.protobuf.s1.getByte(r13, r1) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (com.google.protobuf.s1.getByte(r13, r1) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.d.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            if (com.google.protobuf.s1.getByte(r1) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (com.google.protobuf.s1.getByte(r1) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a3, code lost:
        
            if (com.google.protobuf.s1.getByte(r1) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8Direct(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.d.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        processor = (!d.isAvailable() || com.google.protobuf.d.isOnAndroidDevice()) ? new c() : new d();
    }

    private Utf8() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encode(CharSequence charSequence, byte[] bArr, int i11, int i12) {
        return processor.encodeUtf8(charSequence, bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 < length) {
                char charAt = charSequence.charAt(i11);
                if (charAt >= 2048) {
                    i12 += encodedLengthGeneral(charSequence, i11);
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

    private static int encodedLengthGeneral(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
            } else {
                i12 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i11) < 65536) {
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
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i11, int i12) {
        int i13 = i12 - 7;
        int i14 = i11;
        while (i14 < i13 && (byteBuffer.getLong(i14) & ASCII_MASK_LONG) == 0) {
            i14 += 8;
        }
        return i14 - i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i11) {
        if (i11 > -12) {
            return -1;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i11, int i12, int i13) {
        if (i13 == 0) {
            return incompleteStateFor(i11);
        }
        if (i13 == 1) {
            return incompleteStateFor(i11, byteBuffer.get(i12));
        }
        if (i13 == 2) {
            return incompleteStateFor(i11, byteBuffer.get(i12), byteBuffer.get(i12 + 1));
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 == 0) {
            return incompleteStateFor(b11);
        }
        if (i13 == 1) {
            return incompleteStateFor(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return incompleteStateFor(b11, bArr[i11], bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(byte[] bArr, int i11, int i12) {
        return processor.isValidUtf8(bArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int i11, ByteBuffer byteBuffer, int i12, int i13) {
        return processor.partialIsValidUtf8(i11, byteBuffer, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int i11, byte[] bArr, int i12, int i13) {
        return processor.partialIsValidUtf8(i11, bArr, i12, i13);
    }
}
