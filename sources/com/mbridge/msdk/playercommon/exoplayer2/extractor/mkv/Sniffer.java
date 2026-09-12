package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes5.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i11 = 0;
        extractorInput.peekFully(this.scratch.data, 0, 1);
        int i12 = this.scratch.data[0] & 255;
        if (i12 == 0) {
            return Long.MIN_VALUE;
        }
        int i13 = 128;
        int i14 = 0;
        while ((i12 & i13) == 0) {
            i13 >>= 1;
            i14++;
        }
        int i15 = i12 & (~i13);
        extractorInput.peekFully(this.scratch.data, 1, i14);
        while (i11 < i14) {
            i11++;
            i15 = (this.scratch.data[i11] & 255) + (i15 << 8);
        }
        this.peekLength += i14 + 1;
        return i15;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long length = extractorInput.getLength();
        long j11 = 1024;
        if (length != -1 && length <= 1024) {
            j11 = length;
        }
        int i11 = (int) j11;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i12 = this.peekLength + 1;
            this.peekLength = i12;
            if (i12 == i11) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & (-256)) | (this.scratch.data[0] & 255);
        }
        long readUint = readUint(extractorInput);
        long j12 = this.peekLength;
        if (readUint == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j12 + readUint >= length) {
            return false;
        }
        while (true) {
            long j13 = this.peekLength;
            long j14 = j12 + readUint;
            if (j13 >= j14) {
                return j13 == j14;
            }
            if (readUint(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long readUint2 = readUint(extractorInput);
            if (readUint2 < 0 || readUint2 > 2147483647L) {
                break;
            }
            if (readUint2 != 0) {
                int i13 = (int) readUint2;
                extractorInput.advancePeekPosition(i13);
                this.peekLength += i13;
            }
        }
        return false;
    }
}
