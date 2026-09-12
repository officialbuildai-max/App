package com.bytedance.sdk.openadsdk.core.Ym.TKC;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class EjP {
    public static final List<String> Sj = Arrays.asList(MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_H263);

    private static double Sj(int i11) {
        int max = Math.max(i11, 0);
        if (700 > max || max > 1500) {
            return Math.min(Math.abs(700 - max) / 700.0f, Math.abs(1500 - max) / 1500.0f);
        }
        return 0.0d;
    }

    private static double Sj(int i11, double d11, int i12, int i13) {
        return (d11 > 0.0d ? Math.abs(d11 - (i13 > 0 ? i12 / i13 : 0.0d)) : 0.0d) + (i11 > 0 ? Math.abs((i11 - i12) / i11) : 0.0d);
    }

    public static double Sj(int i11, double d11, int i12, int i13, int i14, @Nullable String str) {
        double Sj2 = Sj(i11, d11, i12, i13);
        return Sj(str) * (1.0d / ((Sj2 + 1.0d) + Sj(i14)));
    }

    private static double Sj(String str) {
        if (str == null) {
            str = "";
        }
        int hashCode = str.hashCode();
        if (hashCode != -1664118616) {
            return (hashCode == 1331848029 && str.equals(MimeTypes.VIDEO_MP4)) ? 1.5d : 1.0d;
        }
        str.equals(MimeTypes.VIDEO_H263);
        return 1.0d;
    }
}
