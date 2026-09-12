package kotlin.text;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class r extends q {
    public static final Void u(String input) {
        Intrinsics.h(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Integer v(String str) {
        Intrinsics.h(str, "<this>");
        return w(str, 10);
    }

    public static final Integer w(String str, int i11) {
        boolean z10;
        int i12;
        int i13;
        Intrinsics.h(str, "<this>");
        CharsKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i14 = 0;
        char charAt = str.charAt(0);
        int i15 = -2147483647;
        if (Intrinsics.j(charAt, 48) < 0) {
            i12 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z10 = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i15 = Integer.MIN_VALUE;
                z10 = true;
            }
        } else {
            z10 = false;
            i12 = 0;
        }
        int i16 = -59652323;
        while (i12 < length) {
            int b11 = b.b(str.charAt(i12), i11);
            if (b11 < 0) {
                return null;
            }
            if ((i14 < i16 && (i16 != -59652323 || i14 < (i16 = i15 / i11))) || (i13 = i14 * i11) < i15 + b11) {
                return null;
            }
            i14 = i13 - b11;
            i12++;
        }
        return z10 ? Integer.valueOf(i14) : Integer.valueOf(-i14);
    }

    public static Long x(String str) {
        Intrinsics.h(str, "<this>");
        return y(str, 10);
    }

    public static final Long y(String str, int i11) {
        boolean z10;
        Intrinsics.h(str, "<this>");
        CharsKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str.charAt(0);
        int j11 = Intrinsics.j(charAt, 48);
        long j12 = C.TIME_UNSET;
        if (j11 < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z10 = false;
                i12 = 1;
            } else {
                if (charAt != '-') {
                    return null;
                }
                j12 = Long.MIN_VALUE;
                i12 = 1;
            }
        } else {
            z10 = false;
        }
        long j13 = -256204778801521550L;
        long j14 = 0;
        long j15 = -256204778801521550L;
        while (i12 < length) {
            int b11 = b.b(str.charAt(i12), i11);
            if (b11 < 0) {
                return null;
            }
            if (j14 < j15) {
                if (j15 == j13) {
                    j15 = j12 / i11;
                    if (j14 < j15) {
                    }
                }
                return null;
            }
            long j16 = j14 * i11;
            long j17 = b11;
            if (j16 < j12 + j17) {
                return null;
            }
            j14 = j16 - j17;
            i12++;
            j13 = -256204778801521550L;
        }
        return z10 ? Long.valueOf(j14) : Long.valueOf(-j14);
    }
}
