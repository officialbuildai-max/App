package l2;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f68624a;

    /* renamed from: b, reason: collision with root package name */
    public final int f68625b;

    /* renamed from: c, reason: collision with root package name */
    public final int f68626c;

    /* renamed from: d, reason: collision with root package name */
    public final int f68627d;

    /* renamed from: e, reason: collision with root package name */
    public final int f68628e;

    /* renamed from: f, reason: collision with root package name */
    public final int f68629f;

    /* renamed from: g, reason: collision with root package name */
    public final int f68630g;

    /* renamed from: h, reason: collision with root package name */
    public final int f68631h;

    /* renamed from: i, reason: collision with root package name */
    public final int f68632i;

    /* renamed from: j, reason: collision with root package name */
    public final long f68633j;

    /* renamed from: k, reason: collision with root package name */
    public final a f68634k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.media3.common.x f68635l;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f68636a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f68637b;

        public a(long[] jArr, long[] jArr2) {
            this.f68636a = jArr;
            this.f68637b = jArr2;
        }
    }

    private b0(int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, a aVar, androidx.media3.common.x xVar) {
        this.f68624a = i11;
        this.f68625b = i12;
        this.f68626c = i13;
        this.f68627d = i14;
        this.f68628e = i15;
        this.f68629f = j(i15);
        this.f68630g = i16;
        this.f68631h = i17;
        this.f68632i = e(i17);
        this.f68633j = j11;
        this.f68634k = aVar;
        this.f68635l = xVar;
    }

    public b0(byte[] bArr, int i11) {
        androidx.media3.common.util.i0 i0Var = new androidx.media3.common.util.i0(bArr);
        i0Var.p(i11 * 8);
        this.f68624a = i0Var.h(16);
        this.f68625b = i0Var.h(16);
        this.f68626c = i0Var.h(24);
        this.f68627d = i0Var.h(24);
        int h11 = i0Var.h(20);
        this.f68628e = h11;
        this.f68629f = j(h11);
        this.f68630g = i0Var.h(3) + 1;
        int h12 = i0Var.h(5) + 1;
        this.f68631h = h12;
        this.f68632i = e(h12);
        this.f68633j = i0Var.j(36);
        this.f68634k = null;
        this.f68635l = null;
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
        if (i11 == 20) {
            return 5;
        }
        if (i11 != 24) {
            return i11 != 32 ? -1 : 7;
        }
        return 6;
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

    public b0 a(List list) {
        return new b0(this.f68624a, this.f68625b, this.f68626c, this.f68627d, this.f68628e, this.f68630g, this.f68631h, this.f68633j, this.f68634k, h(new androidx.media3.common.x(list)));
    }

    public b0 b(a aVar) {
        return new b0(this.f68624a, this.f68625b, this.f68626c, this.f68627d, this.f68628e, this.f68630g, this.f68631h, this.f68633j, aVar, this.f68635l);
    }

    public b0 c(List list) {
        return new b0(this.f68624a, this.f68625b, this.f68626c, this.f68627d, this.f68628e, this.f68630g, this.f68631h, this.f68633j, this.f68634k, h(v0.d(list)));
    }

    public long d() {
        long j11;
        long j12;
        int i11 = this.f68627d;
        if (i11 > 0) {
            j11 = (i11 + this.f68626c) / 2;
            j12 = 1;
        } else {
            int i12 = this.f68624a;
            j11 = ((((i12 != this.f68625b || i12 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i12) * this.f68630g) * this.f68631h) / 8;
            j12 = 64;
        }
        return j11 + j12;
    }

    public long f() {
        long j11 = this.f68633j;
        return j11 == 0 ? C.TIME_UNSET : (j11 * 1000000) / this.f68628e;
    }

    public androidx.media3.common.r g(byte[] bArr, androidx.media3.common.x xVar) {
        bArr[4] = Byte.MIN_VALUE;
        int i11 = this.f68627d;
        if (i11 <= 0) {
            i11 = -1;
        }
        return new r.b().u0(MimeTypes.AUDIO_FLAC).k0(i11).R(this.f68630g).v0(this.f68628e).o0(a1.i0(this.f68631h)).g0(Collections.singletonList(bArr)).n0(h(xVar)).N();
    }

    public androidx.media3.common.x h(androidx.media3.common.x xVar) {
        androidx.media3.common.x xVar2 = this.f68635l;
        return xVar2 == null ? xVar : xVar2.b(xVar);
    }

    public long i(long j11) {
        return a1.q((j11 * this.f68628e) / 1000000, 0L, this.f68633j - 1);
    }
}
