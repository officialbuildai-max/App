package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import androidx.media3.common.util.a1;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f12274a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
            List supportedPerformancePoints;
            supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            y.a();
            int c11 = c(supportedPerformancePoints, x.a(i11, i12, (int) d11));
            if (c11 == 1 && c0.f12274a == null) {
                Boolean unused = c0.f12274a = Boolean.valueOf(d());
                if (c0.f12274a.booleanValue()) {
                    return 0;
                }
            }
            return c11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        
            r2 = ((androidx.media3.exoplayer.mediacodec.w) r4.get(r1)).f12340d.getVideoCapabilities().getSupportedPerformancePoints();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int b(boolean r4) {
            /*
                r0 = 0
                androidx.media3.common.r$b r1 = new androidx.media3.common.r$b     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                r1.<init>()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                java.lang.String r2 = "video/avc"
                androidx.media3.common.r$b r1 = r1.u0(r2)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                androidx.media3.common.r r1 = r1.N()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                java.lang.String r2 = r1.f10243o     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                if (r2 == 0) goto L66
                androidx.media3.exoplayer.mediacodec.h0 r2 = androidx.media3.exoplayer.mediacodec.h0.f12293a     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                java.util.List r4 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.m(r2, r1, r4, r0)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                r1 = r0
            L1b:
                int r2 = r4.size()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                if (r1 >= r2) goto L66
                java.lang.Object r2 = r4.get(r1)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                androidx.media3.exoplayer.mediacodec.w r2 = (androidx.media3.exoplayer.mediacodec.w) r2     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                android.media.MediaCodecInfo$CodecCapabilities r2 = r2.f12340d     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                if (r2 == 0) goto L63
                java.lang.Object r2 = r4.get(r1)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                androidx.media3.exoplayer.mediacodec.w r2 = (androidx.media3.exoplayer.mediacodec.w) r2     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                android.media.MediaCodecInfo$CodecCapabilities r2 = r2.f12340d     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                android.media.MediaCodecInfo$VideoCapabilities r2 = r2.getVideoCapabilities()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                if (r2 == 0) goto L63
                java.lang.Object r2 = r4.get(r1)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                androidx.media3.exoplayer.mediacodec.w r2 = (androidx.media3.exoplayer.mediacodec.w) r2     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                android.media.MediaCodecInfo$CodecCapabilities r2 = r2.f12340d     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                android.media.MediaCodecInfo$VideoCapabilities r2 = r2.getVideoCapabilities()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                java.util.List r2 = androidx.media3.exoplayer.mediacodec.z.a(r2)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                if (r2 == 0) goto L63
                boolean r3 = r2.isEmpty()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                if (r3 != 0) goto L63
                androidx.media3.exoplayer.mediacodec.y.a()     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                r4 = 720(0x2d0, float:1.009E-42)
                r1 = 60
                r3 = 1280(0x500, float:1.794E-42)
                android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = androidx.media3.exoplayer.mediacodec.x.a(r3, r4, r1)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                int r4 = c(r2, r4)     // Catch: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException -> L66
                return r4
            L63:
                int r1 = r1 + 1
                goto L1b
            L66:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.c0.a.b(boolean):int");
        }

        private static int c(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            boolean covers;
            for (int i11 = 0; i11 < list.size(); i11++) {
                covers = a0.a(list.get(i11)).covers(performancePoint);
                if (covers) {
                    return 2;
                }
            }
            return 1;
        }

        private static boolean d() {
            if (a1.f10432a >= 35) {
                return false;
            }
            int b11 = b(false);
            int b12 = b(true);
            if (b11 == 0) {
                return true;
            }
            return b12 == 0 ? b11 != 2 : (b11 == 2 && b12 == 2) ? false : true;
        }
    }

    public static int c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        if (a1.f10432a < 29) {
            return 0;
        }
        Boolean bool = f12274a;
        if (bool == null || !bool.booleanValue()) {
            return a.a(videoCapabilities, i11, i12, d11);
        }
        return 0;
    }
}
