package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public abstract class y3 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4980a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final short f4981b = b(5120);

    /* renamed from: c, reason: collision with root package name */
    private static final short f4982c = b(-1025);

    /* renamed from: d, reason: collision with root package name */
    private static final short f4983d = b(31743);

    /* renamed from: e, reason: collision with root package name */
    private static final short f4984e = b(1024);

    /* renamed from: f, reason: collision with root package name */
    private static final short f4985f = b(1);

    /* renamed from: g, reason: collision with root package name */
    private static final short f4986g = b(32256);

    /* renamed from: h, reason: collision with root package name */
    private static final short f4987h = b(-1024);

    /* renamed from: i, reason: collision with root package name */
    private static final short f4988i = b(Short.MIN_VALUE);

    /* renamed from: j, reason: collision with root package name */
    private static final short f4989j = b(31744);

    /* renamed from: k, reason: collision with root package name */
    private static final short f4990k = b(0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static short a(float f11) {
        int i11;
        int floatToRawIntBits = Float.floatToRawIntBits(f11);
        int i12 = floatToRawIntBits >>> 31;
        int i13 = (floatToRawIntBits >>> 23) & 255;
        int i14 = 8388607 & floatToRawIntBits;
        int i15 = 31;
        int i16 = 0;
        if (i13 != 255) {
            int i17 = i13 - 112;
            if (i17 >= 31) {
                i15 = 49;
            } else if (i17 > 0) {
                i16 = i14 >> 13;
                if ((floatToRawIntBits & 4096) != 0) {
                    i11 = (((i17 << 10) | i16) + 1) | (i12 << 15);
                    return b((short) i11);
                }
                i15 = i17;
            } else if (i17 >= -10) {
                int i18 = (8388608 | i14) >> (1 - i17);
                if ((i18 & 4096) != 0) {
                    i18 += 8192;
                }
                i15 = 0;
                i16 = i18 >> 13;
            } else {
                i15 = 0;
            }
        } else if (i14 != 0) {
            i16 = 512;
        }
        i11 = (i12 << 15) | (i15 << 10) | i16;
        return b((short) i11);
    }

    public static short b(short s11) {
        return s11;
    }
}
