package g9;

import android.support.v4.media.session.PlaybackStateCompat;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f63582a;

    /* renamed from: b, reason: collision with root package name */
    public final int f63583b;

    /* renamed from: c, reason: collision with root package name */
    public final int f63584c;

    /* renamed from: d, reason: collision with root package name */
    public final int f63585d;

    /* renamed from: e, reason: collision with root package name */
    public final int f63586e;

    /* renamed from: f, reason: collision with root package name */
    public final int f63587f;

    /* renamed from: g, reason: collision with root package name */
    public final int f63588g;

    /* renamed from: h, reason: collision with root package name */
    public final int f63589h;

    /* renamed from: i, reason: collision with root package name */
    public final int f63590i;

    /* renamed from: j, reason: collision with root package name */
    public final long f63591j;

    /* renamed from: k, reason: collision with root package name */
    public final a f63592k;

    /* renamed from: l, reason: collision with root package name */
    private final Metadata f63593l;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f63594a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f63595b;

        public a(long[] jArr, long[] jArr2) {
            this.f63594a = jArr;
            this.f63595b = jArr2;
        }
    }

    private v(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, a aVar, Metadata metadata) {
        this.f63582a = i11;
        this.f63583b = i12;
        this.f63584c = i13;
        this.f63585d = i14;
        this.f63586e = i15;
        this.f63587f = j(i15);
        this.f63588g = i16;
        this.f63589h = i17;
        this.f63590i = e(i17);
        this.f63591j = j11;
        this.f63592k = aVar;
        this.f63593l = metadata;
    }

    public v(byte[] bArr, int i11) {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(bArr);
        c0Var.p(i11 * 8);
        this.f63582a = c0Var.h(16);
        this.f63583b = c0Var.h(16);
        this.f63584c = c0Var.h(24);
        this.f63585d = c0Var.h(24);
        int h11 = c0Var.h(20);
        this.f63586e = h11;
        this.f63587f = j(h11);
        this.f63588g = c0Var.h(3) + 1;
        int h12 = c0Var.h(5) + 1;
        this.f63589h = h12;
        this.f63590i = e(h12);
        this.f63591j = c0Var.j(36);
        this.f63592k = null;
        this.f63593l = null;
    }

    private static int e(int i11) {
        if (i11 == 8) {
            return 1;
        }
        if (i11 == 12) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 != 20) {
            return i11 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int j(int i11) {
        switch (i11) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case RecorderConstants.RECORD_SAMPLE_RATE_22050 /* 22050 */:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case RecorderConstants.RECORD_SAMPLE_RATE_44100 /* 44100 */:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case RecorderConstants.RECORD_ENCODING_BITRATE_96000 /* 96000 */:
                return 11;
            case 176400:
                return 2;
            case RecorderConstants.RECORD_ENCODING_BITRATE_192000 /* 192000 */:
                return 3;
            default:
                return -1;
        }
    }

    public v a(List list) {
        return new v(this.f63582a, this.f63583b, this.f63584c, this.f63585d, this.f63586e, this.f63588g, this.f63589h, this.f63591j, this.f63592k, h(new Metadata((List<? extends Metadata.Entry>) list)));
    }

    public v b(a aVar) {
        return new v(this.f63582a, this.f63583b, this.f63584c, this.f63585d, this.f63586e, this.f63588g, this.f63589h, this.f63591j, aVar, this.f63593l);
    }

    public v c(List list) {
        return new v(this.f63582a, this.f63583b, this.f63584c, this.f63585d, this.f63586e, this.f63588g, this.f63589h, this.f63591j, this.f63592k, h(h0.c(list)));
    }

    public long d() {
        long j11;
        long j12;
        int i11 = this.f63585d;
        if (i11 > 0) {
            j11 = (i11 + this.f63584c) / 2;
            j12 = 1;
        } else {
            int i12 = this.f63582a;
            j11 = ((((i12 != this.f63583b || i12 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i12) * this.f63588g) * this.f63589h) / 8;
            j12 = 64;
        }
        return j11 + j12;
    }

    public long f() {
        long j11 = this.f63591j;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / this.f63586e;
    }

    public o1 g(byte[] bArr, Metadata metadata) {
        bArr[4] = Byte.MIN_VALUE;
        int i11 = this.f63585d;
        if (i11 <= 0) {
            i11 = -1;
        }
        return new o1.b().e0(MimeTypes.AUDIO_FLAC).W(i11).H(this.f63588g).f0(this.f63586e).T(Collections.singletonList(bArr)).X(h(metadata)).E();
    }

    public Metadata h(Metadata metadata) {
        Metadata metadata2 = this.f63593l;
        return metadata2 == null ? metadata : metadata2.copyWithAppendedEntriesFrom(metadata);
    }

    public long i(long j11) {
        return p0.r((j11 * this.f63586e) / 1000000, 0L, this.f63591j - 1);
    }
}
