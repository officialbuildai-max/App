package com.google.protobuf;

import com.google.protobuf.s0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class i {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    j wrapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b extends i {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private b(byte[] bArr, int i11, int i12, boolean z10) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i12 + i11;
            this.pos = i11;
            this.startPos = i11;
            this.immutable = z10;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i11 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i11;
            int i12 = i11 - this.startPos;
            int i13 = this.currentLimit;
            if (i12 <= i13) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i14 = i12 - i13;
            this.bufferSizeAfterLimit = i14;
            this.limit = i11 - i14;
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                byte[] bArr = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                if (bArr[i12] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.i
        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.i
        public void enableAliasing(boolean z10) {
            this.enableAliasing = z10;
        }

        @Override // com.google.protobuf.i
        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.i
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.i
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.i
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.i
        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.i
        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i11 + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i12 = this.currentLimit;
            if (totalBytesRead > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i12;
        }

        @Override // com.google.protobuf.i
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.i
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    ByteBuffer wrap = (this.immutable || !this.enableAliasing) ? ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i12, i12 + readRawVarint32)) : ByteBuffer.wrap(this.buffer, i12, readRawVarint32).slice();
                    this.pos += readRawVarint32;
                    return wrap;
                }
            }
            if (readRawVarint32 == 0) {
                return y.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    ByteString wrap = (this.immutable && this.enableAliasing) ? ByteString.wrap(this.buffer, i12, readRawVarint32) : ByteString.copyFrom(this.buffer, i12, readRawVarint32);
                    this.pos += readRawVarint32;
                    return wrap;
                }
            }
            return readRawVarint32 == 0 ? ByteString.EMPTY : ByteString.wrap(readRawBytes(readRawVarint32));
        }

        @Override // com.google.protobuf.i
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.i
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readGroup(int i11, b1 b1Var, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readGroup(int i11, s0.a aVar, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.i
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readMessage(b1 b1Var, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readMessage(s0.a aVar, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.protobuf.i
        public byte readRawByte() throws IOException {
            int i11 = this.pos;
            if (i11 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 1;
            return bArr[i11];
        }

        @Override // com.google.protobuf.i
        public byte[] readRawBytes(int i11) throws IOException {
            if (i11 > 0) {
                int i12 = this.limit;
                int i13 = this.pos;
                if (i11 <= i12 - i13) {
                    int i14 = i11 + i13;
                    this.pos = i14;
                    return Arrays.copyOfRange(this.buffer, i13, i14);
                }
            }
            if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                return y.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.i
        public int readRawLittleEndian32() throws IOException {
            int i11 = this.pos;
            if (this.limit - i11 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        @Override // com.google.protobuf.i
        public long readRawLittleEndian64() throws IOException {
            int i11 = this.pos;
            if (this.limit - i11 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 8;
            return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
        }

        @Override // com.google.protobuf.i
        public int readRawVarint32() throws IOException {
            int i11;
            int i12 = this.pos;
            int i13 = this.limit;
            if (i13 != i12) {
                byte[] bArr = this.buffer;
                int i14 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 >= 0) {
                    this.pos = i14;
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
                    this.pos = i15;
                    return i11;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        public long readRawVarint64() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11 = this.pos;
            int i12 = this.limit;
            if (i12 != i11) {
                byte[] bArr = this.buffer;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.pos = i13;
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
                    this.pos = i14;
                    return j11;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((readRawByte() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.i
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public int readSInt32() throws IOException {
            return i.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public long readSInt64() throws IOException {
            return i.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.i
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    String str = new String(this.buffer, i12, readRawVarint32, y.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.limit;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i12, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.i
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        @Deprecated
        public void readUnknownGroup(int i11, s0.a aVar) throws IOException {
            readGroup(i11, aVar, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.i
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i11);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.protobuf.i
        public void skipRawBytes(int i11) throws IOException {
            if (i11 >= 0) {
                int i12 = this.limit;
                int i13 = this.pos;
                if (i11 <= i12 - i13) {
                    this.pos = i13 + i11;
                    return;
                }
            }
            if (i11 >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c extends i {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private c(Iterable<ByteBuffer> iterable, int i11, boolean z10) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i11;
            this.input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z10;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i11 != 0) {
                tryGetNextByteBuffer();
                return;
            }
            this.currentByteBuffer = y.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0L;
            this.currentByteBufferStartPos = 0L;
            this.currentByteBufferLimit = 0L;
            this.currentAddress = 0L;
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void readRawBytesTo(byte[] bArr, int i11, int i12) throws IOException {
            if (i12 < 0 || i12 > remaining()) {
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
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(i13, (int) currentRemaining());
                long j11 = min;
                s1.copyMemory(this.currentByteBufferPos, bArr, (i12 - i13) + i11, j11);
                i13 -= min;
                this.currentByteBufferPos += j11;
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i11 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i11;
            int i12 = i11 - this.startOffset;
            int i13 = this.currentLimit;
            if (i12 <= i13) {
                this.bufferSizeAfterCurrentLimit = 0;
                return;
            }
            int i14 = i12 - i13;
            this.bufferSizeAfterCurrentLimit = i14;
            this.totalBufferSize = i11 - i14;
        }

        private int remaining() {
            return (int) (((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(int i11, int i12) throws IOException {
            int position = this.currentByteBuffer.position();
            int limit = this.currentByteBuffer.limit();
            ByteBuffer byteBuffer = this.currentByteBuffer;
            try {
                try {
                    byteBuffer.position(i11);
                    byteBuffer.limit(i12);
                    return this.currentByteBuffer.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long position = next.position();
            this.currentByteBufferPos = position;
            this.currentByteBufferStartPos = position;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long addressOffset = s1.addressOffset(this.currentByteBuffer);
            this.currentAddress = addressOffset;
            this.currentByteBufferPos += addressOffset;
            this.currentByteBufferStartPos += addressOffset;
            this.currentByteBufferLimit += addressOffset;
        }

        @Override // com.google.protobuf.i
        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.i
        public void enableAliasing(boolean z10) {
            this.enableAliasing = z10;
        }

        @Override // com.google.protobuf.i
        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.i
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.i
        public int getTotalBytesRead() {
            return (int) (((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.i
        public boolean isAtEnd() throws IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.google.protobuf.i
        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.i
        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i11 + getTotalBytesRead();
            int i12 = this.currentLimit;
            if (totalBytesRead > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i12;
        }

        @Override // com.google.protobuf.i
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.i
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = readRawVarint32;
                if (j11 <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        s1.copyMemory(this.currentByteBufferPos, bArr, 0L, j11);
                        this.currentByteBufferPos += j11;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j12 = this.currentByteBufferPos + j11;
                    this.currentByteBufferPos = j12;
                    long j13 = this.currentAddress;
                    return slice((int) ((j12 - j13) - j11), (int) (j12 - j13));
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            }
            if (readRawVarint32 == 0) {
                return y.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = readRawVarint32;
                long j12 = this.currentByteBufferLimit;
                long j13 = this.currentByteBufferPos;
                if (j11 <= j12 - j13) {
                    if (this.immutable && this.enableAliasing) {
                        int i11 = (int) (j13 - this.currentAddress);
                        ByteString wrap = ByteString.wrap(slice(i11, readRawVarint32 + i11));
                        this.currentByteBufferPos += j11;
                        return wrap;
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    s1.copyMemory(j13, bArr, 0L, j11);
                    this.currentByteBufferPos += j11;
                    return ByteString.wrap(bArr);
                }
            }
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.immutable || !this.enableAliasing) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteString.wrap(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (readRawVarint32 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(readRawVarint32, (int) currentRemaining());
                int i12 = (int) (this.currentByteBufferPos - this.currentAddress);
                arrayList.add(ByteString.wrap(slice(i12, i12 + min)));
                readRawVarint32 -= min;
                this.currentByteBufferPos += min;
            }
            return ByteString.copyFrom(arrayList);
        }

        @Override // com.google.protobuf.i
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.i
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readGroup(int i11, b1 b1Var, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readGroup(int i11, s0.a aVar, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.i
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readMessage(b1 b1Var, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readMessage(s0.a aVar, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.protobuf.i
        public byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j11 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j11;
            return s1.getByte(j11);
        }

        @Override // com.google.protobuf.i
        public byte[] readRawBytes(int i11) throws IOException {
            if (i11 >= 0) {
                long j11 = i11;
                if (j11 <= currentRemaining()) {
                    byte[] bArr = new byte[i11];
                    s1.copyMemory(this.currentByteBufferPos, bArr, 0L, j11);
                    this.currentByteBufferPos += j11;
                    return bArr;
                }
            }
            if (i11 >= 0 && i11 <= remaining()) {
                byte[] bArr2 = new byte[i11];
                readRawBytesTo(bArr2, 0, i11);
                return bArr2;
            }
            if (i11 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                return y.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.i
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
            }
            long j11 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j11;
            return ((s1.getByte(j11 + 3) & 255) << 24) | (s1.getByte(j11) & 255) | ((s1.getByte(1 + j11) & 255) << 8) | ((s1.getByte(2 + j11) & 255) << 16);
        }

        @Override // com.google.protobuf.i
        public long readRawLittleEndian64() throws IOException {
            long readRawByte;
            byte readRawByte2;
            if (currentRemaining() >= 8) {
                long j11 = this.currentByteBufferPos;
                this.currentByteBufferPos = 8 + j11;
                readRawByte = (s1.getByte(j11) & 255) | ((s1.getByte(1 + j11) & 255) << 8) | ((s1.getByte(2 + j11) & 255) << 16) | ((s1.getByte(3 + j11) & 255) << 24) | ((s1.getByte(4 + j11) & 255) << 32) | ((s1.getByte(5 + j11) & 255) << 40) | ((s1.getByte(6 + j11) & 255) << 48);
                readRawByte2 = s1.getByte(j11 + 7);
            } else {
                readRawByte = (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48);
                readRawByte2 = readRawByte();
            }
            return ((readRawByte2 & 255) << 56) | readRawByte;
        }

        @Override // com.google.protobuf.i
        public int readRawVarint32() throws IOException {
            int i11;
            long j11 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j11) {
                long j12 = j11 + 1;
                byte b11 = s1.getByte(j11);
                if (b11 >= 0) {
                    this.currentByteBufferPos++;
                    return b11;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j13 = 2 + j11;
                    int i12 = (s1.getByte(j12) << 7) ^ b11;
                    if (i12 < 0) {
                        i11 = i12 ^ (-128);
                    } else {
                        long j14 = 3 + j11;
                        int i13 = (s1.getByte(j13) << 14) ^ i12;
                        if (i13 >= 0) {
                            i11 = i13 ^ 16256;
                        } else {
                            long j15 = 4 + j11;
                            int i14 = i13 ^ (s1.getByte(j14) << 21);
                            if (i14 < 0) {
                                i11 = (-2080896) ^ i14;
                            } else {
                                j14 = 5 + j11;
                                byte b12 = s1.getByte(j15);
                                int i15 = (i14 ^ (b12 << 28)) ^ 266354560;
                                if (b12 < 0) {
                                    j15 = 6 + j11;
                                    if (s1.getByte(j14) < 0) {
                                        j14 = 7 + j11;
                                        if (s1.getByte(j15) < 0) {
                                            j15 = 8 + j11;
                                            if (s1.getByte(j14) < 0) {
                                                j14 = 9 + j11;
                                                if (s1.getByte(j15) < 0) {
                                                    long j16 = j11 + 10;
                                                    if (s1.getByte(j14) >= 0) {
                                                        i11 = i15;
                                                        j13 = j16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i11 = i15;
                                }
                                i11 = i15;
                            }
                            j13 = j15;
                        }
                        j13 = j14;
                    }
                    this.currentByteBufferPos = j13;
                    return i11;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        public long readRawVarint64() throws IOException {
            long j11;
            long j12;
            long j13;
            long j14 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j14) {
                long j15 = j14 + 1;
                byte b11 = s1.getByte(j14);
                if (b11 >= 0) {
                    this.currentByteBufferPos++;
                    return b11;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j16 = 2 + j14;
                    int i11 = (s1.getByte(j15) << 7) ^ b11;
                    if (i11 < 0) {
                        j11 = i11 ^ (-128);
                    } else {
                        long j17 = 3 + j14;
                        int i12 = (s1.getByte(j16) << 14) ^ i11;
                        if (i12 >= 0) {
                            j11 = i12 ^ 16256;
                            j16 = j17;
                        } else {
                            long j18 = 4 + j14;
                            int i13 = i12 ^ (s1.getByte(j17) << 21);
                            if (i13 < 0) {
                                j11 = (-2080896) ^ i13;
                                j16 = j18;
                            } else {
                                long j19 = 5 + j14;
                                long j20 = (s1.getByte(j18) << 28) ^ i13;
                                if (j20 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j21 = 6 + j14;
                                    long j22 = j20 ^ (s1.getByte(j19) << 35);
                                    if (j22 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j19 = 7 + j14;
                                        j20 = j22 ^ (s1.getByte(j21) << 42);
                                        if (j20 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j21 = 8 + j14;
                                            j22 = j20 ^ (s1.getByte(j19) << 49);
                                            if (j22 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                j19 = 9 + j14;
                                                long j23 = (j22 ^ (s1.getByte(j21) << 56)) ^ 71499008037633920L;
                                                if (j23 < 0) {
                                                    long j24 = j14 + 10;
                                                    if (s1.getByte(j19) >= 0) {
                                                        j11 = j23;
                                                        j16 = j24;
                                                    }
                                                } else {
                                                    j11 = j23;
                                                    j16 = j19;
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ j22;
                                    j16 = j21;
                                }
                                j11 = j13 ^ j20;
                                j16 = j19;
                            }
                        }
                    }
                    this.currentByteBufferPos = j16;
                    return j11;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((readRawByte() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.i
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public int readSInt32() throws IOException {
            return i.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public long readSInt64() throws IOException {
            return i.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.i
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = readRawVarint32;
                long j12 = this.currentByteBufferLimit;
                long j13 = this.currentByteBufferPos;
                if (j11 <= j12 - j13) {
                    byte[] bArr = new byte[readRawVarint32];
                    s1.copyMemory(j13, bArr, 0L, j11);
                    String str = new String(bArr, y.UTF_8);
                    this.currentByteBufferPos += j11;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return new String(bArr2, y.UTF_8);
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j11 = readRawVarint32;
                long j12 = this.currentByteBufferLimit;
                long j13 = this.currentByteBufferPos;
                if (j11 <= j12 - j13) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j13 - this.currentByteBufferStartPos), readRawVarint32);
                    this.currentByteBufferPos += j11;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                readRawBytesTo(bArr, 0, readRawVarint32);
                return Utf8.decodeUtf8(bArr, 0, readRawVarint32);
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.i
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        @Deprecated
        public void readUnknownGroup(int i11, s0.a aVar) throws IOException {
            readGroup(i11, aVar, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.i
        public void resetSizeCounter() {
            this.startOffset = (int) ((this.totalBytesRead + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i11);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.protobuf.i
        public void skipRawBytes(int i11) throws IOException {
            if (i11 < 0 || i11 > ((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (i11 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i11 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int min = Math.min(i11, (int) currentRemaining());
                i11 -= min;
                this.currentByteBufferPos += min;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d extends i {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private a refillCallback;
        private int totalBytesRetired;

        /* loaded from: classes4.dex */
        private interface a {
        }

        private d(InputStream inputStream, int i11) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            y.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i11];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int available(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private static int read(InputStream inputStream, byte[] bArr, int i11, int i12) throws IOException {
            try {
                return inputStream.read(bArr, i11, i12);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private ByteString readBytesSlowPath(int i11) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i11);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i12 = this.pos;
            int i13 = this.bufferSize;
            int i14 = i13 - i12;
            this.totalBytesRetired += i13;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.buffer, i12, bArr, 0, i14);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i14, bArr2.length);
                i14 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i11, boolean z10) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i11);
            if (readRawBytesSlowPathOneChunk != null) {
                return z10 ? (byte[]) readRawBytesSlowPathOneChunk.clone() : readRawBytesSlowPathOneChunk;
            }
            int i12 = this.pos;
            int i13 = this.bufferSize;
            int i14 = i13 - i12;
            this.totalBytesRetired += i13;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i11 - i14);
            byte[] bArr = new byte[i11];
            System.arraycopy(this.buffer, i12, bArr, 0, i14);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i14, bArr2.length);
                i14 += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i11) throws IOException {
            if (i11 == 0) {
                return y.EMPTY_BYTE_ARRAY;
            }
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = this.totalBytesRetired;
            int i13 = this.pos;
            int i14 = i12 + i13 + i11;
            if (i14 - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i15 = this.currentLimit;
            if (i14 > i15) {
                skipRawBytes((i15 - i12) - i13);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i16 = this.bufferSize - i13;
            int i17 = i11 - i16;
            if (i17 >= 4096 && i17 > available(this.input)) {
                return null;
            }
            byte[] bArr = new byte[i11];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i16);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i16 < i11) {
                int read = read(this.input, bArr, i16, i11 - i16);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read;
                i16 += read;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i11) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i11 > 0) {
                int min = Math.min(i11, 4096);
                byte[] bArr = new byte[min];
                int i12 = 0;
                while (i12 < min) {
                    int read = this.input.read(bArr, i12, min - i12);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i12 += read;
                }
                i11 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i11 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i11;
            int i12 = this.totalBytesRetired + i11;
            int i13 = this.currentLimit;
            if (i12 <= i13) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i14 = i12 - i13;
            this.bufferSizeAfterLimit = i14;
            this.bufferSize = i11 - i14;
        }

        private void refillBuffer(int i11) throws IOException {
            if (tryRefillBuffer(i11)) {
                return;
            }
            if (i11 <= (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        private static long skip(InputStream inputStream, long j11) throws IOException {
            try {
                return inputStream.skip(j11);
            } catch (InvalidProtocolBufferException e11) {
                e11.setThrownFromInputStream();
                throw e11;
            }
        }

        private void skipRawBytesSlowPath(int i11) throws IOException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = this.totalBytesRetired;
            int i13 = this.pos;
            int i14 = i12 + i13 + i11;
            int i15 = this.currentLimit;
            if (i14 > i15) {
                skipRawBytes((i15 - i12) - i13);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.totalBytesRetired = i12 + i13;
            int i16 = this.bufferSize - i13;
            this.bufferSize = 0;
            this.pos = 0;
            while (i16 < i11) {
                try {
                    long j11 = i11 - i16;
                    long skip = skip(this.input, j11);
                    if (skip < 0 || skip > j11) {
                        throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                    if (skip == 0) {
                        break;
                    } else {
                        i16 += (int) skip;
                    }
                } finally {
                    this.totalBytesRetired += i16;
                    recomputeBufferSizeAfterLimit();
                }
            }
            if (i16 >= i11) {
                return;
            }
            int i17 = this.bufferSize;
            int i18 = i17 - this.pos;
            this.pos = i17;
            refillBuffer(1);
            while (true) {
                int i19 = i11 - i18;
                int i20 = this.bufferSize;
                if (i19 <= i20) {
                    this.pos = i19;
                    return;
                } else {
                    i18 += i20;
                    this.pos = i20;
                    refillBuffer(1);
                }
            }
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                byte[] bArr = this.buffer;
                int i12 = this.pos;
                this.pos = i12 + 1;
                if (bArr[i12] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i11) throws IOException {
            int i12 = this.pos;
            int i13 = i12 + i11;
            int i14 = this.bufferSize;
            if (i13 <= i14) {
                throw new IllegalStateException("refillBuffer() called when " + i11 + " bytes were already available in buffer");
            }
            int i15 = this.sizeLimit;
            int i16 = this.totalBytesRetired;
            if (i11 > (i15 - i16) - i12 || i16 + i12 + i11 > this.currentLimit) {
                return false;
            }
            if (i12 > 0) {
                if (i14 > i12) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i12, bArr, 0, i14 - i12);
                }
                this.totalBytesRetired += i12;
                this.bufferSize -= i12;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i17 = this.bufferSize;
            int read = read(inputStream, bArr2, i17, Math.min(bArr2.length - i17, (this.sizeLimit - this.totalBytesRetired) - i17));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            if (read <= 0) {
                return false;
            }
            this.bufferSize += read;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i11) {
                return true;
            }
            return tryRefillBuffer(i11);
        }

        @Override // com.google.protobuf.i
        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.i
        public void enableAliasing(boolean z10) {
        }

        @Override // com.google.protobuf.i
        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.protobuf.i
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.i
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // com.google.protobuf.i
        public boolean isAtEnd() throws IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.google.protobuf.i
        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.i
        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i12 = i11 + this.totalBytesRetired + this.pos;
            int i13 = this.currentLimit;
            if (i12 > i13) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i12;
            recomputeBufferSizeAfterLimit();
            return i13;
        }

        @Override // com.google.protobuf.i
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.i
        public byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i11 = this.bufferSize;
            int i12 = this.pos;
            if (readRawVarint32 > i11 - i12 || readRawVarint32 <= 0) {
                if (readRawVarint32 >= 0) {
                    return readRawBytesSlowPath(readRawVarint32, false);
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i12, i12 + readRawVarint32);
            this.pos += readRawVarint32;
            return copyOfRange;
        }

        @Override // com.google.protobuf.i
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i11 = this.bufferSize;
            int i12 = this.pos;
            if (readRawVarint32 <= i11 - i12 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i12, i12 + readRawVarint32));
                this.pos += readRawVarint32;
                return wrap;
            }
            if (readRawVarint32 == 0) {
                return y.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 >= 0) {
                return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32, true));
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.i
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i11 = this.bufferSize;
            int i12 = this.pos;
            if (readRawVarint32 <= i11 - i12 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i12, readRawVarint32);
                this.pos += readRawVarint32;
                return copyFrom;
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (readRawVarint32 >= 0) {
                return readBytesSlowPath(readRawVarint32);
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.protobuf.i
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.i
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readGroup(int i11, b1 b1Var, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readGroup(int i11, s0.a aVar, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.i
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readMessage(b1 b1Var, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readMessage(s0.a aVar, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.protobuf.i
        public byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            this.pos = i11 + 1;
            return bArr[i11];
        }

        @Override // com.google.protobuf.i
        public byte[] readRawBytes(int i11) throws IOException {
            int i12 = this.pos;
            if (i11 > this.bufferSize - i12 || i11 <= 0) {
                return readRawBytesSlowPath(i11, false);
            }
            int i13 = i11 + i12;
            this.pos = i13;
            return Arrays.copyOfRange(this.buffer, i12, i13);
        }

        @Override // com.google.protobuf.i
        public int readRawLittleEndian32() throws IOException {
            int i11 = this.pos;
            if (this.bufferSize - i11 < 4) {
                refillBuffer(4);
                i11 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 4;
            return ((bArr[i11 + 3] & 255) << 24) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
        }

        @Override // com.google.protobuf.i
        public long readRawLittleEndian64() throws IOException {
            int i11 = this.pos;
            if (this.bufferSize - i11 < 8) {
                refillBuffer(8);
                i11 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i11 + 8;
            return ((bArr[i11 + 7] & 255) << 56) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16) | ((bArr[i11 + 3] & 255) << 24) | ((bArr[i11 + 4] & 255) << 32) | ((bArr[i11 + 5] & 255) << 40) | ((bArr[i11 + 6] & 255) << 48);
        }

        @Override // com.google.protobuf.i
        public int readRawVarint32() throws IOException {
            int i11;
            int i12 = this.pos;
            int i13 = this.bufferSize;
            if (i13 != i12) {
                byte[] bArr = this.buffer;
                int i14 = i12 + 1;
                byte b11 = bArr[i12];
                if (b11 >= 0) {
                    this.pos = i14;
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
                    this.pos = i15;
                    return i11;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        public long readRawVarint64() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11 = this.pos;
            int i12 = this.bufferSize;
            if (i12 != i11) {
                byte[] bArr = this.buffer;
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 >= 0) {
                    this.pos = i13;
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
                    this.pos = i14;
                    return j11;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((readRawByte() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.i
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public int readSInt32() throws IOException {
            return i.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public long readSInt64() throws IOException {
            return i.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.i
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i11 = this.bufferSize;
                int i12 = this.pos;
                if (readRawVarint32 <= i11 - i12) {
                    String str = new String(this.buffer, i12, readRawVarint32, y.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (readRawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(readRawVarint32, false), y.UTF_8);
            }
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.pos, readRawVarint32, y.UTF_8);
            this.pos += readRawVarint32;
            return str2;
        }

        @Override // com.google.protobuf.i
        public String readStringRequireUtf8() throws IOException {
            byte[] readRawBytesSlowPath;
            int readRawVarint32 = readRawVarint32();
            int i11 = this.pos;
            int i12 = this.bufferSize;
            if (readRawVarint32 <= i12 - i11 && readRawVarint32 > 0) {
                readRawBytesSlowPath = this.buffer;
                this.pos = i11 + readRawVarint32;
            } else {
                if (readRawVarint32 == 0) {
                    return "";
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                i11 = 0;
                if (readRawVarint32 <= i12) {
                    refillBuffer(readRawVarint32);
                    readRawBytesSlowPath = this.buffer;
                    this.pos = readRawVarint32;
                } else {
                    readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(readRawBytesSlowPath, i11, readRawVarint32);
        }

        @Override // com.google.protobuf.i
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.i
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        @Deprecated
        public void readUnknownGroup(int i11, s0.a aVar) throws IOException {
            readGroup(i11, aVar, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.i
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i11);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.protobuf.i
        public void skipRawBytes(int i11) throws IOException {
            int i12 = this.bufferSize;
            int i13 = this.pos;
            if (i11 > i12 - i13 || i11 < 0) {
                skipRawBytesSlowPath(i11);
            } else {
                this.pos = i13 + i11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e extends i {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private e(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            long addressOffset = s1.addressOffset(byteBuffer);
            this.address = addressOffset;
            this.limit = byteBuffer.limit() + addressOffset;
            long position = addressOffset + byteBuffer.position();
            this.pos = position;
            this.startPos = position;
            this.immutable = z10;
        }

        private int bufferPos(long j11) {
            return (int) (j11 - this.address);
        }

        static boolean isSupported() {
            return s1.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j11 = this.limit + this.bufferSizeAfterLimit;
            this.limit = j11;
            int i11 = (int) (j11 - this.startPos);
            int i12 = this.currentLimit;
            if (i11 <= i12) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i13 = i11 - i12;
            this.bufferSizeAfterLimit = i13;
            this.limit = j11 - i13;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                long j11 = this.pos;
                this.pos = 1 + j11;
                if (s1.getByte(j11) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i11 = 0; i11 < 10; i11++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long j11, long j12) throws IOException {
            int position = this.buffer.position();
            int limit = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            try {
                try {
                    byteBuffer.position(bufferPos(j11));
                    byteBuffer.limit(bufferPos(j12));
                    return this.buffer.slice();
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

        @Override // com.google.protobuf.i
        public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
            if (this.lastTag != i11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.i
        public void enableAliasing(boolean z10) {
            this.enableAliasing = z10;
        }

        @Override // com.google.protobuf.i
        public int getBytesUntilLimit() {
            int i11 = this.currentLimit;
            if (i11 == Integer.MAX_VALUE) {
                return -1;
            }
            return i11 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.i
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.i
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.protobuf.i
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.i
        public void popLimit(int i11) {
            this.currentLimit = i11;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.i
        public int pushLimit(int i11) throws InvalidProtocolBufferException {
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i11 + getTotalBytesRead();
            int i12 = this.currentLimit;
            if (totalBytesRead > i12) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i12;
        }

        @Override // com.google.protobuf.i
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.i
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return y.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j11 = readRawVarint32;
                s1.copyMemory(this.pos, bArr, 0L, j11);
                this.pos += j11;
                return ByteBuffer.wrap(bArr);
            }
            long j12 = this.pos;
            long j13 = readRawVarint32;
            ByteBuffer slice = slice(j12, j12 + j13);
            this.pos += j13;
            return slice;
        }

        @Override // com.google.protobuf.i
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j11 = this.pos;
                long j12 = readRawVarint32;
                ByteBuffer slice = slice(j11, j11 + j12);
                this.pos += j12;
                return ByteString.wrap(slice);
            }
            byte[] bArr = new byte[readRawVarint32];
            long j13 = readRawVarint32;
            s1.copyMemory(this.pos, bArr, 0L, j13);
            this.pos += j13;
            return ByteString.wrap(bArr);
        }

        @Override // com.google.protobuf.i
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.i
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readGroup(int i11, b1 b1Var, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readGroup(int i11, s0.a aVar, o oVar) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(WireFormat.makeTag(i11, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.i
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        public <T extends s0> T readMessage(b1 b1Var, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (T) b1Var.parsePartialFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
            return t11;
        }

        @Override // com.google.protobuf.i
        public void readMessage(s0.a aVar, o oVar) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            aVar.mergeFrom(this, oVar);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(pushLimit);
        }

        @Override // com.google.protobuf.i
        public byte readRawByte() throws IOException {
            long j11 = this.pos;
            if (j11 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j11;
            return s1.getByte(j11);
        }

        @Override // com.google.protobuf.i
        public byte[] readRawBytes(int i11) throws IOException {
            if (i11 < 0 || i11 > remaining()) {
                if (i11 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i11 == 0) {
                    return y.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[i11];
            long j11 = this.pos;
            long j12 = i11;
            slice(j11, j11 + j12).get(bArr);
            this.pos += j12;
            return bArr;
        }

        @Override // com.google.protobuf.i
        public int readRawLittleEndian32() throws IOException {
            long j11 = this.pos;
            if (this.limit - j11 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + j11;
            return ((s1.getByte(j11 + 3) & 255) << 24) | (s1.getByte(j11) & 255) | ((s1.getByte(1 + j11) & 255) << 8) | ((s1.getByte(2 + j11) & 255) << 16);
        }

        @Override // com.google.protobuf.i
        public long readRawLittleEndian64() throws IOException {
            long j11 = this.pos;
            if (this.limit - j11 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + j11;
            return ((s1.getByte(j11 + 7) & 255) << 56) | (s1.getByte(j11) & 255) | ((s1.getByte(1 + j11) & 255) << 8) | ((s1.getByte(2 + j11) & 255) << 16) | ((s1.getByte(3 + j11) & 255) << 24) | ((s1.getByte(4 + j11) & 255) << 32) | ((s1.getByte(5 + j11) & 255) << 40) | ((s1.getByte(6 + j11) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.s1.getByte(r3) < 0) goto L34;
         */
        @Override // com.google.protobuf.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r9 = this;
                long r0 = r9.pos
                long r2 = r9.limit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.s1.getByte(r0)
                if (r4 < 0) goto L16
                r9.pos = r2
                return r4
            L16:
                long r5 = r9.limit
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.s1.getByte(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.s1.getByte(r5)
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
                byte r3 = com.google.protobuf.s1.getByte(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.s1.getByte(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.s1.getByte(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.s1.getByte(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.s1.getByte(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.s1.getByte(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.s1.getByte(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.pos = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.i.e.readRawVarint32():int");
        }

        @Override // com.google.protobuf.i
        public long readRawVarint64() throws IOException {
            long j11;
            long j12;
            long j13;
            int i11;
            long j14 = this.pos;
            if (this.limit != j14) {
                long j15 = 1 + j14;
                byte b11 = s1.getByte(j14);
                if (b11 >= 0) {
                    this.pos = j15;
                    return b11;
                }
                if (this.limit - j15 >= 9) {
                    long j16 = 2 + j14;
                    int i12 = (s1.getByte(j15) << 7) ^ b11;
                    if (i12 >= 0) {
                        long j17 = 3 + j14;
                        int i13 = i12 ^ (s1.getByte(j16) << 14);
                        if (i13 >= 0) {
                            j11 = i13 ^ 16256;
                            j16 = j17;
                        } else {
                            j16 = 4 + j14;
                            int i14 = i13 ^ (s1.getByte(j17) << 21);
                            if (i14 < 0) {
                                i11 = (-2080896) ^ i14;
                            } else {
                                long j18 = 5 + j14;
                                long j19 = i14 ^ (s1.getByte(j16) << 28);
                                if (j19 >= 0) {
                                    j13 = 266354560;
                                } else {
                                    long j20 = 6 + j14;
                                    long j21 = j19 ^ (s1.getByte(j18) << 35);
                                    if (j21 < 0) {
                                        j12 = -34093383808L;
                                    } else {
                                        j18 = 7 + j14;
                                        j19 = j21 ^ (s1.getByte(j20) << 42);
                                        if (j19 >= 0) {
                                            j13 = 4363953127296L;
                                        } else {
                                            j20 = 8 + j14;
                                            j21 = j19 ^ (s1.getByte(j18) << 49);
                                            if (j21 < 0) {
                                                j12 = -558586000294016L;
                                            } else {
                                                long j22 = j14 + 9;
                                                long j23 = (j21 ^ (s1.getByte(j20) << 56)) ^ 71499008037633920L;
                                                if (j23 < 0) {
                                                    long j24 = j14 + 10;
                                                    if (s1.getByte(j22) >= 0) {
                                                        j16 = j24;
                                                        j11 = j23;
                                                    }
                                                } else {
                                                    j11 = j23;
                                                    j16 = j22;
                                                }
                                            }
                                        }
                                    }
                                    j11 = j12 ^ j21;
                                    j16 = j20;
                                }
                                j11 = j13 ^ j19;
                                j16 = j18;
                            }
                        }
                        this.pos = j16;
                        return j11;
                    }
                    i11 = i12 ^ (-128);
                    j11 = i11;
                    this.pos = j16;
                    return j11;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.google.protobuf.i
        long readRawVarint64SlowPath() throws IOException {
            long j11 = 0;
            for (int i11 = 0; i11 < 64; i11 += 7) {
                j11 |= (r3 & Byte.MAX_VALUE) << i11;
                if ((readRawByte() & 128) == 0) {
                    return j11;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.i
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.i
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.i
        public int readSInt32() throws IOException {
            return i.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.i
        public long readSInt64() throws IOException {
            return i.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.i
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return "";
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[readRawVarint32];
            long j11 = readRawVarint32;
            s1.copyMemory(this.pos, bArr, 0L, j11);
            String str = new String(bArr, y.UTF_8);
            this.pos += j11;
            return str;
        }

        @Override // com.google.protobuf.i
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                String decodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), readRawVarint32);
                this.pos += readRawVarint32;
                return decodeUtf8;
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.i
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.i
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.i
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.i
        @Deprecated
        public void readUnknownGroup(int i11, s0.a aVar) throws IOException {
            readGroup(i11, aVar, o.getEmptyRegistry());
        }

        @Override // com.google.protobuf.i
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.google.protobuf.i
        public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i11);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            }
            if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i11);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i11);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i11), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeUInt32NoTag(i11);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }

        @Override // com.google.protobuf.i
        public void skipRawBytes(int i11) throws IOException {
            if (i11 >= 0 && i11 <= remaining()) {
                this.pos += i11;
            } else {
                if (i11 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }
    }

    private i() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static int decodeZigZag32(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long decodeZigZag64(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    public static i newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static i newInstance(InputStream inputStream, int i11) {
        if (i11 > 0) {
            return inputStream == null ? newInstance(y.EMPTY_BYTE_ARRAY) : new d(inputStream, i11);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static i newInstance(Iterable<ByteBuffer> iterable) {
        return !e.isSupported() ? newInstance(new d0(iterable)) : newInstance(iterable, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i newInstance(Iterable<ByteBuffer> iterable, boolean z10) {
        int i11 = 0;
        int i12 = 0;
        for (ByteBuffer byteBuffer : iterable) {
            i12 += byteBuffer.remaining();
            i11 = byteBuffer.hasArray() ? i11 | 1 : byteBuffer.isDirect() ? i11 | 2 : i11 | 4;
        }
        return i11 == 2 ? new c(iterable, i12, z10) : newInstance(new d0(iterable));
    }

    public static i newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i newInstance(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z10);
        }
        if (byteBuffer.isDirect() && e.isSupported()) {
            return new e(byteBuffer, z10);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, remaining, true);
    }

    public static i newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static i newInstance(byte[] bArr, int i11, int i12) {
        return newInstance(bArr, i11, i12, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i newInstance(byte[] bArr, int i11, int i12, boolean z10) {
        b bVar = new b(bArr, i11, i12, z10);
        try {
            bVar.pushLimit(i12);
            return bVar;
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int readRawVarint32(int i11, InputStream inputStream) throws IOException {
        if ((i11 & 128) == 0) {
            return i11;
        }
        int i12 = i11 & 127;
        int i13 = 7;
        while (i13 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i12 |= (read & 127) << i13;
            if ((read & 128) == 0) {
                return i12;
            }
            i13 += 7;
        }
        while (i13 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i12;
            }
            i13 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public abstract void checkLastTagWas(int i11) throws InvalidProtocolBufferException;

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z10);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i11);

    public abstract int pushLimit(int i11) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends s0> T readGroup(int i11, b1 b1Var, o oVar) throws IOException;

    public abstract void readGroup(int i11, s0.a aVar, o oVar) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends s0> T readMessage(b1 b1Var, o oVar) throws IOException;

    public abstract void readMessage(s0.a aVar, o oVar) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i11) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i11, s0.a aVar) throws IOException;

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i11) {
        if (i11 >= 0) {
            int i12 = this.recursionLimit;
            this.recursionLimit = i11;
            return i12;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i11);
    }

    public final int setSizeLimit(int i11) {
        if (i11 >= 0) {
            int i12 = this.sizeLimit;
            this.sizeLimit = i11;
            return i12;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i11) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException;

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            this.recursionDepth--;
        } while (skipField(readTag));
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            this.recursionDepth--;
        } while (skipField(readTag, codedOutputStream));
    }

    public abstract void skipRawBytes(int i11) throws IOException;

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }
}
