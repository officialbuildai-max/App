package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataSource dataSource;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;
    private byte[] peekBuffer = new byte[65536];
    private final byte[] scratchSpace = new byte[4096];

    public DefaultExtractorInput(DataSource dataSource, long j11, long j12) {
        this.dataSource = dataSource;
        this.position = j11;
        this.streamLength = j12;
    }

    private void commitBytesRead(int i11) {
        if (i11 != -1) {
            this.position += i11;
        }
    }

    private void ensureSpaceForPeek(int i11) {
        int i12 = this.peekBufferPosition + i11;
        byte[] bArr = this.peekBuffer;
        if (i12 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    private int readFromDataSource(byte[] bArr, int i11, int i12, int i13, boolean z10) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int read = this.dataSource.read(bArr, i11 + i13, i12 - i13);
        if (read != -1) {
            return i13 + read;
        }
        if (i13 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    private int readFromPeekBuffer(byte[] bArr, int i11, int i12) {
        int i13 = this.peekBufferLength;
        if (i13 == 0) {
            return 0;
        }
        int min = Math.min(i13, i12);
        System.arraycopy(this.peekBuffer, 0, bArr, i11, min);
        updatePeekBuffer(min);
        return min;
    }

    private int skipFromPeekBuffer(int i11) {
        int min = Math.min(this.peekBufferLength, i11);
        updatePeekBuffer(min);
        return min;
    }

    private void updatePeekBuffer(int i11) {
        int i12 = this.peekBufferLength - i11;
        this.peekBufferLength = i12;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.peekBuffer = bArr2;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i11) throws IOException, InterruptedException {
        advancePeekPosition(i11, false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i11, boolean z10) throws IOException, InterruptedException {
        ensureSpaceForPeek(i11);
        int min = Math.min(this.peekBufferLength - this.peekBufferPosition, i11);
        while (min < i11) {
            min = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i11, min, z10);
            if (min == -1) {
                return false;
            }
        }
        int i12 = this.peekBufferPosition + i11;
        this.peekBufferPosition = i12;
        this.peekBufferLength = Math.max(this.peekBufferLength, i12);
        return true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.streamLength;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.position + this.peekBufferPosition;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.position;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i11, int i12) throws IOException, InterruptedException {
        peekFully(bArr, i11, i12, false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z10) throws IOException, InterruptedException {
        if (!advancePeekPosition(i12, z10)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i12, bArr, i11, i12);
        return true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int i11, int i12) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i11, i12);
        if (readFromPeekBuffer == 0) {
            readFromPeekBuffer = readFromDataSource(bArr, i11, i12, 0, true);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i11, int i12) throws IOException, InterruptedException {
        readFully(bArr, i11, i12, false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z10) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i11, i12);
        while (readFromPeekBuffer < i12 && readFromPeekBuffer != -1) {
            readFromPeekBuffer = readFromDataSource(bArr, i11, i12, readFromPeekBuffer, z10);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer != -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j11, E e11) throws Throwable {
        Assertions.checkArgument(j11 >= 0);
        this.position = j11;
        throw e11;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public int skip(int i11) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i11);
        if (skipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            skipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i11) throws IOException, InterruptedException {
        skipFully(i11, false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i11, boolean z10) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i11);
        while (skipFromPeekBuffer < i11 && skipFromPeekBuffer != -1) {
            skipFromPeekBuffer = readFromDataSource(this.scratchSpace, -skipFromPeekBuffer, Math.min(i11, this.scratchSpace.length + skipFromPeekBuffer), skipFromPeekBuffer, z10);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer != -1;
    }
}
