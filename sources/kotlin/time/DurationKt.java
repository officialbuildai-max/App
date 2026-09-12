package kotlin.time;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;

@Metadata(d1 = {"\u00000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0016\u001a\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0016\u001a\u001f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0016\u001a\u0017\u0010\"\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0016¨\u0006#"}, d2 = {"", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "s", "(ILkotlin/time/DurationUnit;)J", "", "t", "(JLkotlin/time/DurationUnit;)J", "", CampaignEx.JSON_KEY_AD_R, "(DLkotlin/time/DurationUnit;)J", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "strictIso", TtmlNode.TAG_P, "(Ljava/lang/String;Z)J", CampaignEx.JSON_KEY_AD_Q, "(Ljava/lang/String;)J", "nanos", "o", "(J)J", "millis", "n", "normalNanos", "l", "normalMillis", j.f35620b, "normalValue", "unitDiscriminator", "i", "(JI)J", "m", CampaignEx.JSON_KEY_AD_K, "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DurationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j11, int i11) {
        return Duration.j((j11 << 1) + i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j11) {
        return Duration.j((j11 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j11) {
        return (-4611686018426L > j11 || j11 >= 4611686018427L) ? j(RangesKt.n(j11, -4611686018427387903L, 4611686018427387903L)) : l(n(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j11) {
        return Duration.j(j11 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j11) {
        return (-4611686018426999999L > j11 || j11 >= 4611686018427000000L) ? j(o(j11)) : l(j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j11) {
        return j11 * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j11) {
        return j11 / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p(String str, boolean z10) {
        long j11;
        char charAt;
        char charAt2;
        int i11;
        char charAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        Duration.Companion companion = Duration.INSTANCE;
        long c11 = companion.c();
        char charAt4 = str.charAt(0);
        boolean z11 = true;
        int i12 = (charAt4 == '+' || charAt4 == '-') ? 1 : 0;
        boolean z12 = i12 > 0;
        boolean z13 = z12 && StringsKt.V0(str, '-', false, 2, null);
        if (length <= i12) {
            throw new IllegalArgumentException("No components");
        }
        char c12 = ':';
        char c13 = '0';
        if (str.charAt(i12) == 'P') {
            int i13 = i12 + 1;
            if (i13 == length) {
                throw new IllegalArgumentException();
            }
            DurationUnit durationUnit = null;
            boolean z14 = false;
            while (i13 < length) {
                if (str.charAt(i13) != 'T') {
                    int i14 = i13;
                    while (i14 < str.length() && ((c13 <= (charAt3 = str.charAt(i14)) && charAt3 < c12) || StringsKt.b0("+-.", charAt3, false, 2, null))) {
                        i14++;
                        c12 = ':';
                        c13 = '0';
                    }
                    Intrinsics.f(str, "null cannot be cast to non-null type java.lang.String");
                    String substring = str.substring(i13, i14);
                    Intrinsics.g(substring, "substring(...)");
                    if (substring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = i13 + substring.length();
                    if (length2 < 0 || length2 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + substring);
                    }
                    char charAt5 = str.charAt(length2);
                    int i15 = length2 + 1;
                    DurationUnit d11 = DurationUnitKt__DurationUnitKt.d(charAt5, z14);
                    if (durationUnit != null && durationUnit.compareTo(d11) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int n02 = StringsKt.n0(substring, '.', 0, false, 6, null);
                    if (d11 != DurationUnit.SECONDS || n02 <= 0) {
                        i11 = i15;
                        c11 = Duration.G(c11, t(q(substring), d11));
                    } else {
                        Intrinsics.f(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring2 = substring.substring(0, n02);
                        Intrinsics.g(substring2, "substring(...)");
                        i11 = i15;
                        long G = Duration.G(c11, t(q(substring2), d11));
                        Intrinsics.f(substring, "null cannot be cast to non-null type java.lang.String");
                        String substring3 = substring.substring(n02);
                        Intrinsics.g(substring3, "substring(...)");
                        c11 = Duration.G(G, r(Double.parseDouble(substring3), d11));
                    }
                    i13 = i11;
                    durationUnit = d11;
                    c12 = ':';
                    c13 = '0';
                    z11 = true;
                } else {
                    if (z14 || (i13 = i13 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z14 = z11;
                }
            }
        } else {
            if (z10) {
                throw new IllegalArgumentException();
            }
            String str2 = "Unexpected order of duration components";
            if (StringsKt.K(str, i12, "Infinity", 0, Math.max(length - i12, 8), true)) {
                c11 = companion.a();
            } else {
                boolean z15 = !z12;
                if (z12 && str.charAt(i12) == '(' && StringsKt.w1(str) == ')') {
                    i12++;
                    length--;
                    if (i12 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    j11 = c11;
                    z15 = true;
                } else {
                    j11 = c11;
                }
                DurationUnit durationUnit2 = null;
                boolean z16 = false;
                while (i12 < length) {
                    if (z16 && z15) {
                        while (i12 < str.length() && str.charAt(i12) == ' ') {
                            i12++;
                        }
                    }
                    int i16 = i12;
                    while (i16 < str.length() && (('0' <= (charAt2 = str.charAt(i16)) && charAt2 < ':') || charAt2 == '.')) {
                        i16++;
                    }
                    Intrinsics.f(str, "null cannot be cast to non-null type java.lang.String");
                    String substring4 = str.substring(i12, i16);
                    Intrinsics.g(substring4, "substring(...)");
                    if (substring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i12 + substring4.length();
                    int i17 = length3;
                    while (i17 < str.length() && 'a' <= (charAt = str.charAt(i17)) && charAt < '{') {
                        i17++;
                    }
                    Intrinsics.f(str, "null cannot be cast to non-null type java.lang.String");
                    String substring5 = str.substring(length3, i17);
                    Intrinsics.g(substring5, "substring(...)");
                    i12 = length3 + substring5.length();
                    DurationUnit e11 = DurationUnitKt__DurationUnitKt.e(substring5);
                    if (durationUnit2 != null && durationUnit2.compareTo(e11) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    String str3 = str2;
                    int n03 = StringsKt.n0(substring4, '.', 0, false, 6, null);
                    if (n03 > 0) {
                        Intrinsics.f(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring6 = substring4.substring(0, n03);
                        Intrinsics.g(substring6, "substring(...)");
                        long G2 = Duration.G(j11, t(Long.parseLong(substring6), e11));
                        Intrinsics.f(substring4, "null cannot be cast to non-null type java.lang.String");
                        String substring7 = substring4.substring(n03);
                        Intrinsics.g(substring7, "substring(...)");
                        j11 = Duration.G(G2, r(Double.parseDouble(substring7), e11));
                        i12 = i12;
                        if (i12 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        j11 = Duration.G(j11, t(Long.parseLong(substring4), e11));
                    }
                    str2 = str3;
                    durationUnit2 = e11;
                    z16 = true;
                }
                c11 = j11;
            }
        }
        return z13 ? Duration.K(c11) : c11;
    }

    private static final long q(String str) {
        char charAt;
        int length = str.length();
        int i11 = (length <= 0 || !StringsKt.b0("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i11 > 16) {
            int i12 = i11;
            while (true) {
                if (i11 < length) {
                    char charAt2 = str.charAt(i11);
                    if (charAt2 != '0') {
                        if ('1' > charAt2 || charAt2 >= ':') {
                            break;
                        }
                    } else if (i12 == i11) {
                        i12++;
                    }
                    i11++;
                } else if (length - i12 > 16) {
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
            }
        }
        if (StringsKt.W(str, "+", false, 2, null) && length > 1 && '0' <= (charAt = str.charAt(1)) && charAt < ':') {
            str = StringsKt.t1(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long r(double d11, DurationUnit unit) {
        Intrinsics.h(unit, "unit");
        double a11 = DurationUnitKt__DurationUnitJvmKt.a(d11, unit, DurationUnit.NANOSECONDS);
        if (Double.isNaN(a11)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long e11 = MathKt.e(a11);
        return (-4611686018426999999L > e11 || e11 >= 4611686018427000000L) ? k(MathKt.e(DurationUnitKt__DurationUnitJvmKt.a(d11, unit, DurationUnit.MILLISECONDS))) : l(e11);
    }

    public static final long s(int i11, DurationUnit unit) {
        Intrinsics.h(unit, "unit");
        return unit.compareTo(DurationUnit.SECONDS) <= 0 ? l(DurationUnitKt__DurationUnitJvmKt.c(i11, unit, DurationUnit.NANOSECONDS)) : t(i11, unit);
    }

    public static final long t(long j11, DurationUnit unit) {
        Intrinsics.h(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long c11 = DurationUnitKt__DurationUnitJvmKt.c(4611686018426999999L, durationUnit, unit);
        return ((-c11) > j11 || j11 > c11) ? j(RangesKt.n(DurationUnitKt__DurationUnitJvmKt.b(j11, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L)) : l(DurationUnitKt__DurationUnitJvmKt.c(j11, unit, durationUnit));
    }
}
