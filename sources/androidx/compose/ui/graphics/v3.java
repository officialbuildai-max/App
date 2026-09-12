package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.Rgb;
import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v3 {

    /* renamed from: a, reason: collision with root package name */
    public static final v3 f4752a = new v3();

    private v3() {
    }

    @JvmStatic
    public static final ColorSpace e(androidx.compose.ui.graphics.colorspace.c cVar) {
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace.Rgb.TransferParameters transferParameters;
        ColorSpace.Rgb a11;
        ColorSpace.Named named2;
        ColorSpace colorSpace2;
        ColorSpace.Named named3;
        ColorSpace colorSpace3;
        ColorSpace.Named named4;
        ColorSpace colorSpace4;
        ColorSpace.Named named5;
        ColorSpace colorSpace5;
        ColorSpace.Named named6;
        ColorSpace colorSpace6;
        ColorSpace.Named named7;
        ColorSpace colorSpace7;
        ColorSpace.Named named8;
        ColorSpace colorSpace8;
        ColorSpace.Named named9;
        ColorSpace colorSpace9;
        ColorSpace.Named named10;
        ColorSpace colorSpace10;
        ColorSpace.Named named11;
        ColorSpace colorSpace11;
        ColorSpace.Named named12;
        ColorSpace colorSpace12;
        ColorSpace.Named named13;
        ColorSpace colorSpace13;
        ColorSpace.Named named14;
        ColorSpace colorSpace14;
        ColorSpace.Named named15;
        ColorSpace colorSpace15;
        ColorSpace.Named named16;
        ColorSpace colorSpace16;
        ColorSpace.Named named17;
        ColorSpace colorSpace17;
        androidx.compose.ui.graphics.colorspace.g gVar = androidx.compose.ui.graphics.colorspace.g.f4428a;
        if (Intrinsics.c(cVar, gVar.w())) {
            named17 = ColorSpace.Named.SRGB;
            colorSpace17 = ColorSpace.get(named17);
            return colorSpace17;
        }
        if (Intrinsics.c(cVar, gVar.e())) {
            named16 = ColorSpace.Named.ACES;
            colorSpace16 = ColorSpace.get(named16);
            return colorSpace16;
        }
        if (Intrinsics.c(cVar, gVar.f())) {
            named15 = ColorSpace.Named.ACESCG;
            colorSpace15 = ColorSpace.get(named15);
            return colorSpace15;
        }
        if (Intrinsics.c(cVar, gVar.g())) {
            named14 = ColorSpace.Named.ADOBE_RGB;
            colorSpace14 = ColorSpace.get(named14);
            return colorSpace14;
        }
        if (Intrinsics.c(cVar, gVar.h())) {
            named13 = ColorSpace.Named.BT2020;
            colorSpace13 = ColorSpace.get(named13);
            return colorSpace13;
        }
        if (Intrinsics.c(cVar, gVar.i())) {
            named12 = ColorSpace.Named.BT709;
            colorSpace12 = ColorSpace.get(named12);
            return colorSpace12;
        }
        if (Intrinsics.c(cVar, gVar.j())) {
            named11 = ColorSpace.Named.CIE_LAB;
            colorSpace11 = ColorSpace.get(named11);
            return colorSpace11;
        }
        if (Intrinsics.c(cVar, gVar.k())) {
            named10 = ColorSpace.Named.CIE_XYZ;
            colorSpace10 = ColorSpace.get(named10);
            return colorSpace10;
        }
        if (Intrinsics.c(cVar, gVar.m())) {
            named9 = ColorSpace.Named.DCI_P3;
            colorSpace9 = ColorSpace.get(named9);
            return colorSpace9;
        }
        if (Intrinsics.c(cVar, gVar.n())) {
            named8 = ColorSpace.Named.DISPLAY_P3;
            colorSpace8 = ColorSpace.get(named8);
            return colorSpace8;
        }
        if (Intrinsics.c(cVar, gVar.o())) {
            named7 = ColorSpace.Named.EXTENDED_SRGB;
            colorSpace7 = ColorSpace.get(named7);
            return colorSpace7;
        }
        if (Intrinsics.c(cVar, gVar.p())) {
            named6 = ColorSpace.Named.LINEAR_EXTENDED_SRGB;
            colorSpace6 = ColorSpace.get(named6);
            return colorSpace6;
        }
        if (Intrinsics.c(cVar, gVar.q())) {
            named5 = ColorSpace.Named.LINEAR_SRGB;
            colorSpace5 = ColorSpace.get(named5);
            return colorSpace5;
        }
        if (Intrinsics.c(cVar, gVar.r())) {
            named4 = ColorSpace.Named.NTSC_1953;
            colorSpace4 = ColorSpace.get(named4);
            return colorSpace4;
        }
        if (Intrinsics.c(cVar, gVar.u())) {
            named3 = ColorSpace.Named.PRO_PHOTO_RGB;
            colorSpace3 = ColorSpace.get(named3);
            return colorSpace3;
        }
        if (Intrinsics.c(cVar, gVar.v())) {
            named2 = ColorSpace.Named.SMPTE_C;
            colorSpace2 = ColorSpace.get(named2);
            return colorSpace2;
        }
        if (!(cVar instanceof Rgb)) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            return colorSpace;
        }
        Rgb rgb = (Rgb) cVar;
        float[] c11 = rgb.N().c();
        androidx.compose.ui.graphics.colorspace.x L = rgb.L();
        if (L != null) {
            f3.a();
            transferParameters = y1.a(L.a(), L.b(), L.c(), L.d(), L.e(), L.f(), L.g());
        } else {
            transferParameters = null;
        }
        if (transferParameters != null) {
            l3.a();
            a11 = j2.a(cVar.f(), rgb.K(), c11, transferParameters);
        } else {
            l3.a();
            String f11 = cVar.f();
            float[] K = rgb.K();
            final Function1 H = rgb.H();
            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.r3
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d11) {
                    double f12;
                    f12 = v3.f(Function1.this, d11);
                    return f12;
                }
            };
            final Function1 D = rgb.D();
            a11 = u2.a(f11, K, c11, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.s3
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d11) {
                    double g11;
                    g11 = v3.g(Function1.this, d11);
                    return g11;
                }
            }, cVar.d(0), cVar.c(0));
        }
        return i2.a(a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double f(Function1 function1, double d11) {
        return ((Number) function1.invoke(Double.valueOf(d11))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double g(Function1 function1, double d11) {
        return ((Number) function1.invoke(Double.valueOf(d11))).doubleValue();
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.c h(final ColorSpace colorSpace) {
        int id2;
        ColorSpace.Named named;
        int ordinal;
        ColorSpace.Named named2;
        int ordinal2;
        ColorSpace.Named named3;
        int ordinal3;
        ColorSpace.Named named4;
        int ordinal4;
        ColorSpace.Named named5;
        int ordinal5;
        ColorSpace.Named named6;
        int ordinal6;
        ColorSpace.Named named7;
        int ordinal7;
        ColorSpace.Named named8;
        int ordinal8;
        ColorSpace.Named named9;
        int ordinal9;
        ColorSpace.Named named10;
        int ordinal10;
        ColorSpace.Named named11;
        int ordinal11;
        ColorSpace.Named named12;
        int ordinal12;
        ColorSpace.Named named13;
        int ordinal13;
        ColorSpace.Named named14;
        int ordinal14;
        ColorSpace.Named named15;
        int ordinal15;
        ColorSpace.Named named16;
        int ordinal16;
        ColorSpace.Rgb.TransferParameters transferParameters;
        float[] whitePoint;
        androidx.compose.ui.graphics.colorspace.y yVar;
        float[] whitePoint2;
        float[] whitePoint3;
        androidx.compose.ui.graphics.colorspace.x xVar;
        String name;
        float[] primaries;
        float[] transform;
        float minValue;
        float maxValue;
        int id3;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        float[] whitePoint4;
        float[] whitePoint5;
        float[] whitePoint6;
        id2 = colorSpace.getId();
        named = ColorSpace.Named.SRGB;
        ordinal = named.ordinal();
        if (id2 == ordinal) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.w();
        }
        named2 = ColorSpace.Named.ACES;
        ordinal2 = named2.ordinal();
        if (id2 == ordinal2) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.e();
        }
        named3 = ColorSpace.Named.ACESCG;
        ordinal3 = named3.ordinal();
        if (id2 == ordinal3) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.f();
        }
        named4 = ColorSpace.Named.ADOBE_RGB;
        ordinal4 = named4.ordinal();
        if (id2 == ordinal4) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.g();
        }
        named5 = ColorSpace.Named.BT2020;
        ordinal5 = named5.ordinal();
        if (id2 == ordinal5) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.h();
        }
        named6 = ColorSpace.Named.BT709;
        ordinal6 = named6.ordinal();
        if (id2 == ordinal6) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.i();
        }
        named7 = ColorSpace.Named.CIE_LAB;
        ordinal7 = named7.ordinal();
        if (id2 == ordinal7) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.j();
        }
        named8 = ColorSpace.Named.CIE_XYZ;
        ordinal8 = named8.ordinal();
        if (id2 == ordinal8) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.k();
        }
        named9 = ColorSpace.Named.DCI_P3;
        ordinal9 = named9.ordinal();
        if (id2 == ordinal9) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.m();
        }
        named10 = ColorSpace.Named.DISPLAY_P3;
        ordinal10 = named10.ordinal();
        if (id2 == ordinal10) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.n();
        }
        named11 = ColorSpace.Named.EXTENDED_SRGB;
        ordinal11 = named11.ordinal();
        if (id2 == ordinal11) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.o();
        }
        named12 = ColorSpace.Named.LINEAR_EXTENDED_SRGB;
        ordinal12 = named12.ordinal();
        if (id2 == ordinal12) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.p();
        }
        named13 = ColorSpace.Named.LINEAR_SRGB;
        ordinal13 = named13.ordinal();
        if (id2 == ordinal13) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.q();
        }
        named14 = ColorSpace.Named.NTSC_1953;
        ordinal14 = named14.ordinal();
        if (id2 == ordinal14) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.r();
        }
        named15 = ColorSpace.Named.PRO_PHOTO_RGB;
        ordinal15 = named15.ordinal();
        if (id2 == ordinal15) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.u();
        }
        named16 = ColorSpace.Named.SMPTE_C;
        ordinal16 = named16.ordinal();
        if (id2 == ordinal16) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.v();
        }
        if (!p2.a(colorSpace)) {
            return androidx.compose.ui.graphics.colorspace.g.f4428a.w();
        }
        transferParameters = q2.a(colorSpace).getTransferParameters();
        whitePoint = q2.a(colorSpace).getWhitePoint();
        if (whitePoint.length == 3) {
            whitePoint4 = q2.a(colorSpace).getWhitePoint();
            float f11 = whitePoint4[0];
            whitePoint5 = q2.a(colorSpace).getWhitePoint();
            float f12 = whitePoint5[1];
            whitePoint6 = q2.a(colorSpace).getWhitePoint();
            yVar = new androidx.compose.ui.graphics.colorspace.y(f11, f12, whitePoint6[2]);
        } else {
            whitePoint2 = q2.a(colorSpace).getWhitePoint();
            float f13 = whitePoint2[0];
            whitePoint3 = q2.a(colorSpace).getWhitePoint();
            yVar = new androidx.compose.ui.graphics.colorspace.y(f13, whitePoint3[1]);
        }
        androidx.compose.ui.graphics.colorspace.y yVar2 = yVar;
        if (transferParameters != null) {
            d11 = transferParameters.g;
            d12 = transferParameters.a;
            d13 = transferParameters.b;
            d14 = transferParameters.c;
            d15 = transferParameters.d;
            d16 = transferParameters.e;
            d17 = transferParameters.f;
            xVar = new androidx.compose.ui.graphics.colorspace.x(d11, d12, d13, d14, d15, d16, d17);
        } else {
            xVar = null;
        }
        name = q2.a(colorSpace).getName();
        primaries = q2.a(colorSpace).getPrimaries();
        transform = q2.a(colorSpace).getTransform();
        androidx.compose.ui.graphics.colorspace.j jVar = new androidx.compose.ui.graphics.colorspace.j() { // from class: androidx.compose.ui.graphics.t3
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d18) {
                double i11;
                i11 = v3.i(colorSpace, d18);
                return i11;
            }
        };
        androidx.compose.ui.graphics.colorspace.j jVar2 = new androidx.compose.ui.graphics.colorspace.j() { // from class: androidx.compose.ui.graphics.u3
            @Override // androidx.compose.ui.graphics.colorspace.j
            public final double a(double d18) {
                double j11;
                j11 = v3.j(colorSpace, d18);
                return j11;
            }
        };
        minValue = colorSpace.getMinValue(0);
        maxValue = colorSpace.getMaxValue(0);
        id3 = q2.a(colorSpace).getId();
        return new Rgb(name, primaries, yVar2, transform, jVar, jVar2, minValue, maxValue, xVar, id3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double i(ColorSpace colorSpace, double d11) {
        DoubleUnaryOperator oetf;
        double applyAsDouble;
        oetf = q2.a(colorSpace).getOetf();
        applyAsDouble = oetf.applyAsDouble(d11);
        return applyAsDouble;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double j(ColorSpace colorSpace, double d11) {
        DoubleUnaryOperator eotf;
        double applyAsDouble;
        eotf = q2.a(colorSpace).getEotf();
        applyAsDouble = eotf.applyAsDouble(d11);
        return applyAsDouble;
    }
}
