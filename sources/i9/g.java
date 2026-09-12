package i9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes4.dex */
final class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public final o1 f65200a;

    public g(o1 o1Var) {
        this.f65200a = o1Var;
    }

    private static String a(int i11) {
        switch (i11) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return MimeTypes.VIDEO_MP4V;
            case 826496577:
            case 828601953:
            case 875967048:
                return MimeTypes.VIDEO_H264;
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    private static String b(int i11) {
        if (i11 == 1) {
            return MimeTypes.AUDIO_RAW;
        }
        if (i11 == 85) {
            return MimeTypes.AUDIO_MPEG;
        }
        if (i11 == 255) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i11 == 8192) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i11 != 8193) {
            return null;
        }
        return MimeTypes.AUDIO_DTS;
    }

    private static a c(d0 d0Var) {
        d0Var.Q(4);
        int q11 = d0Var.q();
        int q12 = d0Var.q();
        d0Var.Q(4);
        int q13 = d0Var.q();
        String a11 = a(q13);
        if (a11 != null) {
            o1.b bVar = new o1.b();
            bVar.j0(q11).Q(q12).e0(a11);
            return new g(bVar.E());
        }
        s.i("StreamFormatChunk", "Ignoring track with unsupported compression " + q13);
        return null;
    }

    public static a d(int i11, d0 d0Var) {
        if (i11 == 2) {
            return c(d0Var);
        }
        if (i11 == 1) {
            return e(d0Var);
        }
        s.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + p0.m0(i11));
        return null;
    }

    private static a e(d0 d0Var) {
        int v11 = d0Var.v();
        String b11 = b(v11);
        if (b11 == null) {
            s.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + v11);
            return null;
        }
        int v12 = d0Var.v();
        int q11 = d0Var.q();
        d0Var.Q(6);
        int c02 = p0.c0(d0Var.J());
        int v13 = d0Var.v();
        byte[] bArr = new byte[v13];
        d0Var.j(bArr, 0, v13);
        o1.b bVar = new o1.b();
        bVar.e0(b11).H(v12).f0(q11);
        if (MimeTypes.AUDIO_RAW.equals(b11) && c02 != 0) {
            bVar.Y(c02);
        }
        if (MimeTypes.AUDIO_AAC.equals(b11) && v13 > 0) {
            bVar.T(ImmutableList.of(bArr));
        }
        return new g(bVar.E());
    }

    @Override // i9.a
    public int getType() {
        return 1718776947;
    }
}
