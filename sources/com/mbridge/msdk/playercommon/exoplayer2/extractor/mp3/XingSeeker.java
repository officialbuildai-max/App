package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: classes5.dex */
final class XingSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long j11, int i11, long j12) {
        this(j11, i11, j12, -1L, null);
    }

    private XingSeeker(long j11, int i11, long j12, long j13, long[] jArr) {
        this.dataStartPosition = j11;
        this.xingFrameSize = i11;
        this.durationUs = j12;
        this.dataSize = j13;
        this.tableOfContents = jArr;
    }

    public static XingSeeker create(long j11, long j12, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt;
        int i11 = mpegAudioHeader.samplesPerFrame;
        int i12 = mpegAudioHeader.sampleRate;
        int readInt = parsableByteArray.readInt();
        if ((readInt & 1) != 1 || (readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedIntToInt, i11 * 1000000, i12);
        if ((readInt & 6) != 6) {
            return new XingSeeker(j12, mpegAudioHeader.frameSize, scaleLargeTimestamp);
        }
        long readUnsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[100];
        for (int i13 = 0; i13 < 100; i13++) {
            jArr[i13] = parsableByteArray.readUnsignedByte();
        }
        if (j11 != -1) {
            long j13 = j12 + readUnsignedIntToInt2;
            if (j11 != j13) {
                Log.w(TAG, "XING data size mismatch: " + j11 + ", " + j13);
            }
        }
        return new XingSeeker(j12, mpegAudioHeader.frameSize, scaleLargeTimestamp, readUnsignedIntToInt2, jArr);
    }

    private long getTimeUsForTableIndex(int i11) {
        return (this.durationUs * i11) / 100;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j11) {
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.dataStartPosition + this.xingFrameSize));
        }
        long constrainValue = Util.constrainValue(j11, 0L, this.durationUs);
        double d11 = (constrainValue * 100.0d) / this.durationUs;
        double d12 = 0.0d;
        if (d11 > 0.0d) {
            if (d11 >= 100.0d) {
                d12 = 256.0d;
            } else {
                int i11 = (int) d11;
                double d13 = this.tableOfContents[i11];
                d12 = d13 + ((d11 - i11) * ((i11 == 99 ? 256.0d : r3[i11 + 1]) - d13));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(constrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d12 / 256.0d) * this.dataSize), this.xingFrameSize, this.dataSize - 1)));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j11) {
        long j12 = j11 - this.dataStartPosition;
        if (!isSeekable() || j12 <= this.xingFrameSize) {
            return 0L;
        }
        double d11 = (j12 * 256.0d) / this.dataSize;
        int binarySearchFloor = Util.binarySearchFloor(this.tableOfContents, (long) d11, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(binarySearchFloor);
        long j13 = this.tableOfContents[binarySearchFloor];
        int i11 = binarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i11);
        return timeUsForTableIndex + Math.round((j13 == (binarySearchFloor == 99 ? 256L : this.tableOfContents[i11]) ? 0.0d : (d11 - j13) / (r8 - j13)) * (timeUsForTableIndex2 - timeUsForTableIndex));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }
}
