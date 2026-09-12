package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: classes5.dex */
final class WavHeader implements SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    public WavHeader(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.numChannels = i11;
        this.sampleRateHz = i12;
        this.averageBytesPerSecond = i13;
        this.blockAlignment = i14;
        this.bitsPerSample = i15;
        this.encoding = i16;
    }

    public int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public int getBytesPerFrame() {
        return this.blockAlignment;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return ((this.dataSize / this.blockAlignment) * 1000000) / this.sampleRateHz;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j11) {
        long j12 = this.blockAlignment;
        long constrainValue = Util.constrainValue((((this.averageBytesPerSecond * j11) / 1000000) / j12) * j12, 0L, this.dataSize - j12);
        long j13 = this.dataStartPosition + constrainValue;
        long timeUs = getTimeUs(j13);
        SeekPoint seekPoint = new SeekPoint(timeUs, j13);
        if (timeUs < j11) {
            long j14 = this.dataSize;
            long j15 = this.blockAlignment;
            if (constrainValue != j14 - j15) {
                long j16 = j13 + j15;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j16), j16));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUs(long j11) {
        return (Math.max(0L, j11 - this.dataStartPosition) * 1000000) / this.averageBytesPerSecond;
    }

    public boolean hasDataBounds() {
        return (this.dataStartPosition == 0 || this.dataSize == 0) ? false : true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public void setDataBounds(long j11, long j12) {
        this.dataStartPosition = j11;
        this.dataSize = j12;
    }
}
