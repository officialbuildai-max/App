package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class w1 {
    /* JADX WARN: Removed duplicated region for block: B:106:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long a(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.c r24) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.w1.a(float, float, float, float, androidx.compose.ui.graphics.colorspace.c):long");
    }

    public static final long b(int i11) {
        return u1.h(ULong.b(ULong.b(i11) << 32));
    }

    public static final long c(int i11, int i12, int i13, int i14) {
        return b(((i11 & 255) << 16) | ((i14 & 255) << 24) | ((i12 & 255) << 8) | (i13 & 255));
    }

    public static final long d(long j11) {
        return u1.h(ULong.b(j11 << 32));
    }

    public static /* synthetic */ long e(float f11, float f12, float f13, float f14, androidx.compose.ui.graphics.colorspace.c cVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            f14 = 1.0f;
        }
        if ((i11 & 16) != 0) {
            cVar = androidx.compose.ui.graphics.colorspace.g.f4428a.w();
        }
        return a(f11, f12, f13, f14, cVar);
    }

    public static /* synthetic */ long f(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 8) != 0) {
            i14 = 255;
        }
        return c(i11, i12, i13, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long g(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.c r21) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.w1.g(float, float, float, float, androidx.compose.ui.graphics.colorspace.c):long");
    }

    public static final long h(long j11, long j12) {
        long i11 = u1.i(j11, u1.p(j12));
        float n11 = u1.n(j12);
        float n12 = u1.n(i11);
        float f11 = 1.0f - n12;
        float f12 = (n11 * f11) + n12;
        return g(f12 == 0.0f ? 0.0f : ((u1.r(i11) * n12) + ((u1.r(j12) * n11) * f11)) / f12, f12 == 0.0f ? 0.0f : ((u1.q(i11) * n12) + ((u1.q(j12) * n11) * f11)) / f12, f12 != 0.0f ? ((u1.o(i11) * n12) + ((u1.o(j12) * n11) * f11)) / f12 : 0.0f, f12, u1.p(j12));
    }

    public static final float i(long j11) {
        androidx.compose.ui.graphics.colorspace.c p11 = u1.p(j11);
        if (!androidx.compose.ui.graphics.colorspace.b.e(p11.e(), androidx.compose.ui.graphics.colorspace.b.f4419a.b())) {
            h4.a("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) androidx.compose.ui.graphics.colorspace.b.h(p11.e())));
        }
        Intrinsics.f(p11, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        androidx.compose.ui.graphics.colorspace.j E = ((Rgb) p11).E();
        float a11 = (float) ((E.a(u1.r(j11)) * 0.2126d) + (E.a(u1.q(j11)) * 0.7152d) + (E.a(u1.o(j11)) * 0.0722d));
        if (a11 < 0.0f) {
            a11 = 0.0f;
        }
        if (a11 > 1.0f) {
            return 1.0f;
        }
        return a11;
    }

    public static final int j(long j11) {
        return (int) ULong.b(u1.i(j11, androidx.compose.ui.graphics.colorspace.g.f4428a.w()) >>> 32);
    }
}
