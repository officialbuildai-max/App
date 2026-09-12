package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderException;

/* loaded from: classes2.dex */
public class MediaCodecDecoderException extends DecoderException {

    @Nullable
    public final w codecInfo;

    @Nullable
    public final String diagnosticInfo;
    public final int errorCode;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MediaCodecDecoderException(java.lang.Throwable r4, @androidx.annotation.Nullable androidx.media3.exoplayer.mediacodec.w r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Decoder failed: "
            r0.append(r1)
            r1 = 0
            if (r5 != 0) goto Lf
            r2 = r1
            goto L11
        Lf:
            java.lang.String r2 = r5.f12337a
        L11:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.codecInfo = r5
            boolean r5 = r4 instanceof android.media.MediaCodec.CodecException
            if (r5 == 0) goto L28
            r5 = r4
            android.media.MediaCodec$CodecException r5 = (android.media.MediaCodec.CodecException) r5
            java.lang.String r1 = r5.getDiagnosticInfo()
        L28:
            r3.diagnosticInfo = r1
            int r5 = androidx.media3.common.util.a1.f10432a
            r0 = 23
            if (r5 < r0) goto L35
            int r4 = getErrorCodeV23(r4)
            goto L39
        L35:
            int r4 = androidx.media3.common.util.a1.c0(r1)
        L39:
            r3.errorCode = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException.<init>(java.lang.Throwable, androidx.media3.exoplayer.mediacodec.w):void");
    }

    private static int getErrorCodeV23(Throwable th2) {
        if (th2 instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th2).getErrorCode();
        }
        return 0;
    }
}
