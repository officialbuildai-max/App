package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* loaded from: classes5.dex */
final class VorbisUtil {
    private static final String TAG = "VorbisUtil";

    /* loaded from: classes5.dex */
    public static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i11, int i12, long[] jArr, int i13, boolean z10) {
            this.dimensions = i11;
            this.entries = i12;
            this.lengthMap = jArr;
            this.lookupType = i13;
            this.isOrdered = z10;
        }
    }

    /* loaded from: classes5.dex */
    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i11) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i11;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z10, int i11, int i12, int i13) {
            this.blockFlag = z10;
            this.windowType = i11;
            this.transformType = i12;
            this.mapping = i13;
        }
    }

    /* loaded from: classes5.dex */
    public static final class VorbisIdHeader {
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long j11, int i11, long j12, int i12, int i13, int i14, int i15, int i16, boolean z10, byte[] bArr) {
            this.version = j11;
            this.channels = i11;
            this.sampleRate = j12;
            this.bitrateMax = i12;
            this.bitrateNominal = i13;
            this.bitrateMin = i14;
            this.blockSize0 = i15;
            this.blockSize1 = i16;
            this.framingFlag = z10;
            this.data = bArr;
        }

        public int getApproximateBitrate() {
            int i11 = this.bitrateNominal;
            return i11 == 0 ? (this.bitrateMin + this.bitrateMax) / 2 : i11;
        }
    }

    private VorbisUtil() {
    }

    public static int iLog(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    private static long mapType1QuantValues(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.readBits(24) != 5653314) {
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.getPosition());
        }
        int readBits = vorbisBitArray.readBits(16);
        int readBits2 = vorbisBitArray.readBits(24);
        long[] jArr = new long[readBits2];
        boolean readBit = vorbisBitArray.readBit();
        long j11 = 0;
        if (readBit) {
            int readBits3 = vorbisBitArray.readBits(5) + 1;
            int i11 = 0;
            while (i11 < readBits2) {
                int readBits4 = vorbisBitArray.readBits(iLog(readBits2 - i11));
                for (int i12 = 0; i12 < readBits4 && i11 < readBits2; i12++) {
                    jArr[i11] = readBits3;
                    i11++;
                }
                readBits3++;
            }
        } else {
            boolean readBit2 = vorbisBitArray.readBit();
            for (int i13 = 0; i13 < readBits2; i13++) {
                if (!readBit2) {
                    jArr[i13] = vorbisBitArray.readBits(5) + 1;
                } else if (vorbisBitArray.readBit()) {
                    jArr[i13] = vorbisBitArray.readBits(5) + 1;
                } else {
                    jArr[i13] = 0;
                }
            }
        }
        int readBits5 = vorbisBitArray.readBits(4);
        if (readBits5 > 2) {
            throw new ParserException("lookup type greater than 2 not decodable: " + readBits5);
        }
        if (readBits5 == 1 || readBits5 == 2) {
            vorbisBitArray.skipBits(32);
            vorbisBitArray.skipBits(32);
            int readBits6 = vorbisBitArray.readBits(4) + 1;
            vorbisBitArray.skipBits(1);
            if (readBits5 != 1) {
                j11 = readBits2 * readBits;
            } else if (readBits != 0) {
                j11 = mapType1QuantValues(readBits2, readBits);
            }
            vorbisBitArray.skipBits((int) (j11 * readBits6));
        }
        return new CodeBook(readBits, readBits2, jArr, readBits5, readBit);
    }

    private static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i11 = 0; i11 < readBits; i11++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int readBits3 = vorbisBitArray.readBits(4) + 1;
                for (int i12 = 0; i12 < readBits3; i12++) {
                    vorbisBitArray.skipBits(8);
                }
            } else {
                if (readBits2 != 1) {
                    throw new ParserException("floor type greater than 1 not decodable: " + readBits2);
                }
                int readBits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[readBits4];
                int i13 = -1;
                for (int i14 = 0; i14 < readBits4; i14++) {
                    int readBits5 = vorbisBitArray.readBits(4);
                    iArr[i14] = readBits5;
                    if (readBits5 > i13) {
                        i13 = readBits5;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = vorbisBitArray.readBits(3) + 1;
                    int readBits6 = vorbisBitArray.readBits(2);
                    if (readBits6 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i17 = 0; i17 < (1 << readBits6); i17++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int readBits7 = vorbisBitArray.readBits(4);
                int i18 = 0;
                int i19 = 0;
                for (int i20 = 0; i20 < readBits4; i20++) {
                    i18 += iArr2[iArr[i20]];
                    while (i19 < i18) {
                        vorbisBitArray.skipBits(readBits7);
                        i19++;
                    }
                }
            }
        }
    }

    private static void readMappings(int i11, VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i12 = 0; i12 < readBits; i12++) {
            int readBits2 = vorbisBitArray.readBits(16);
            if (readBits2 != 0) {
                Log.e(TAG, "mapping type other than 0 not supported: " + readBits2);
            } else {
                int readBits3 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                if (vorbisBitArray.readBit()) {
                    int readBits4 = vorbisBitArray.readBits(8) + 1;
                    for (int i13 = 0; i13 < readBits4; i13++) {
                        int i14 = i11 - 1;
                        vorbisBitArray.skipBits(iLog(i14));
                        vorbisBitArray.skipBits(iLog(i14));
                    }
                }
                if (vorbisBitArray.readBits(2) != 0) {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
                if (readBits3 > 1) {
                    for (int i15 = 0; i15 < i11; i15++) {
                        vorbisBitArray.skipBits(4);
                    }
                }
                for (int i16 = 0; i16 < readBits3; i16++) {
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                }
            }
        }
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int readBits = vorbisBitArray.readBits(6) + 1;
        Mode[] modeArr = new Mode[readBits];
        for (int i11 = 0; i11 < readBits; i11++) {
            modeArr[i11] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i11 = 0; i11 < readBits; i11++) {
            if (vorbisBitArray.readBits(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            int readBits2 = vorbisBitArray.readBits(6) + 1;
            vorbisBitArray.skipBits(8);
            int[] iArr = new int[readBits2];
            for (int i12 = 0; i12 < readBits2; i12++) {
                iArr[i12] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
            }
            for (int i13 = 0; i13 < readBits2; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        vorbisBitArray.skipBits(8);
                    }
                }
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        String readString = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = readString.length();
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[(int) readLittleEndianUnsignedInt];
        int i11 = length + 15;
        for (int i12 = 0; i12 < readLittleEndianUnsignedInt; i12++) {
            String readString2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i12] = readString2;
            i11 = i11 + 4 + readString2.length();
        }
        if ((parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(readString, strArr, i11 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        long readLittleEndianUnsignedInt2 = parsableByteArray.readLittleEndianUnsignedInt();
        int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        return new VorbisIdHeader(readLittleEndianUnsignedInt, readUnsignedByte, readLittleEndianUnsignedInt2, readLittleEndianInt, readLittleEndianInt2, readLittleEndianInt3, (int) Math.pow(2.0d, readUnsignedByte2 & 15), (int) Math.pow(2.0d, (readUnsignedByte2 & 240) >> 4), (parsableByteArray.readUnsignedByte() & 1) > 0, Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i11) throws ParserException {
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int readUnsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i12 = 0; i12 < readUnsignedByte; i12++) {
            readBook(vorbisBitArray);
        }
        int readBits = vorbisBitArray.readBits(6) + 1;
        for (int i13 = 0; i13 < readBits; i13++) {
            if (vorbisBitArray.readBits(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i11, vorbisBitArray);
        Mode[] readModes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return readModes;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i11, ParsableByteArray parsableByteArray, boolean z10) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z10) {
                return false;
            }
            throw new ParserException("too short header: " + parsableByteArray.bytesLeft());
        }
        if (parsableByteArray.readUnsignedByte() != i11) {
            if (z10) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i11));
        }
        if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw new ParserException("expected characters 'vorbis'");
    }
}
