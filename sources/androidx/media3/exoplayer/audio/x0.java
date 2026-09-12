package androidx.media3.exoplayer.audio;

import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;

/* loaded from: classes2.dex */
public class x0 implements DefaultAudioSink.e {

    /* renamed from: b, reason: collision with root package name */
    protected final int f11327b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f11328c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f11329d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f11330e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f11331f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11332g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11333h;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f11334a = 250000;

        /* renamed from: b, reason: collision with root package name */
        private int f11335b = 750000;

        /* renamed from: c, reason: collision with root package name */
        private int f11336c = 4;

        /* renamed from: d, reason: collision with root package name */
        private int f11337d = 250000;

        /* renamed from: e, reason: collision with root package name */
        private int f11338e = 50000000;

        /* renamed from: f, reason: collision with root package name */
        private int f11339f = 2;

        /* renamed from: g, reason: collision with root package name */
        private int f11340g = 4;

        public x0 h() {
            return new x0(this);
        }
    }

    protected x0(a aVar) {
        this.f11327b = aVar.f11334a;
        this.f11328c = aVar.f11335b;
        this.f11329d = aVar.f11336c;
        this.f11330e = aVar.f11337d;
        this.f11331f = aVar.f11338e;
        this.f11332g = aVar.f11339f;
        this.f11333h = aVar.f11340g;
    }

    protected static int b(int i11, int i12, int i13) {
        return Ints.d(((i11 * i12) * i13) / 1000000);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i11) {
        if (i11 == 20) {
            return 63750;
        }
        if (i11 == 30) {
            return 2250000;
        }
        switch (i11) {
            case 5:
                return 80000;
            case 6:
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
            default:
                switch (i11) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return RecorderConstants.RECORD_ENCODING_BITRATE_256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.e
    public int a(int i11, int i12, int i13, int i14, int i15, int i16, double d11) {
        return (((Math.max(i11, (int) (c(i11, i12, i13, i14, i15, i16) * d11)) + i14) - 1) / i14) * i14;
    }

    protected int c(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i13 == 0) {
            return g(i11, i15, i14);
        }
        if (i13 == 1) {
            return e(i12);
        }
        if (i13 == 2) {
            return f(i12, i16);
        }
        throw new IllegalArgumentException();
    }

    protected int e(int i11) {
        return Ints.d((this.f11331f * d(i11)) / 1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int f(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.f11330e
            r1 = 5
            r2 = 8
            if (r4 != r1) goto Lb
            int r1 = r3.f11332g
        L9:
            int r0 = r0 * r1
            goto L10
        Lb:
            if (r4 != r2) goto L10
            int r1 = r3.f11333h
            goto L9
        L10:
            r1 = -1
            if (r5 == r1) goto L1a
            java.math.RoundingMode r4 = java.math.RoundingMode.CEILING
            int r4 = com.google.common.math.d.c(r5, r2, r4)
            goto L1e
        L1a:
            int r4 = d(r4)
        L1e:
            long r0 = (long) r0
            long r4 = (long) r4
            long r0 = r0 * r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            int r4 = com.google.common.primitives.Ints.d(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.x0.f(int, int):int");
    }

    protected int g(int i11, int i12, int i13) {
        return androidx.media3.common.util.a1.p(i11 * this.f11329d, b(this.f11327b, i12, i13), b(this.f11328c, i12, i13));
    }
}
