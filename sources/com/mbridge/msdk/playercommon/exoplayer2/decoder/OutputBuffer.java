package com.mbridge.msdk.playercommon.exoplayer2.decoder;

/* loaded from: classes5.dex */
public abstract class OutputBuffer extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public abstract void release();
}
