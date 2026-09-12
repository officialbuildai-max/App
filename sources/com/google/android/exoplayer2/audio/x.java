package com.google.android.exoplayer2.audio;

import androidx.media3.common.PlaybackException;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.util.p0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;

/* loaded from: classes3.dex */
public class x implements DefaultAudioSink.c {

    /* renamed from: b, reason: collision with root package name */
    protected final int f24839b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f24840c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f24841d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f24842e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f24843f;

    /* renamed from: g, reason: collision with root package name */
    public final int f24844g;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f24845a = 250000;

        /* renamed from: b, reason: collision with root package name */
        private int f24846b = 750000;

        /* renamed from: c, reason: collision with root package name */
        private int f24847c = 4;

        /* renamed from: d, reason: collision with root package name */
        private int f24848d = 250000;

        /* renamed from: e, reason: collision with root package name */
        private int f24849e = 50000000;

        /* renamed from: f, reason: collision with root package name */
        private int f24850f = 2;

        public x g() {
            return new x(this);
        }
    }

    protected x(a aVar) {
        this.f24839b = aVar.f24845a;
        this.f24840c = aVar.f24846b;
        this.f24841d = aVar.f24847c;
        this.f24842e = aVar.f24848d;
        this.f24843f = aVar.f24849e;
        this.f24844g = aVar.f24850f;
    }

    protected static int b(int i11, int i12, int i13) {
        return Ints.d(((i11 * i12) * i13) / 1000000);
    }

    protected static int d(int i11) {
        switch (i11) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return RecorderConstants.RECORD_ENCODING_BITRATE_192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return DefaultOggSeeker.MATCH_BYTE_RANGE;
            case 11:
                return 16000;
            case 12:
                return PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return RecorderConstants.RECORD_ENCODING_BITRATE_256000;
            case 17:
                return 336000;
        }
    }

    @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.c
    public int a(int i11, int i12, int i13, int i14, int i15, double d11) {
        return (((Math.max(i11, (int) (c(i11, i12, i13, i14, i15) * d11)) + i14) - 1) / i14) * i14;
    }

    protected int c(int i11, int i12, int i13, int i14, int i15) {
        if (i13 == 0) {
            return g(i11, i15, i14);
        }
        if (i13 == 1) {
            return e(i12);
        }
        if (i13 == 2) {
            return f(i12);
        }
        throw new IllegalArgumentException();
    }

    protected int e(int i11) {
        return Ints.d((this.f24843f * d(i11)) / 1000000);
    }

    protected int f(int i11) {
        int i12 = this.f24842e;
        if (i11 == 5) {
            i12 *= this.f24844g;
        }
        return Ints.d((i12 * d(i11)) / 1000000);
    }

    protected int g(int i11, int i12, int i13) {
        return p0.q(i11 * this.f24841d, b(this.f24839b, i12, i13), b(this.f24840c, i12, i13));
    }
}
