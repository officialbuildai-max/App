package ht;

import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public abstract class e {
    public static final String a(long j11) {
        if (j11 < 0) {
            a.C0856a.f(lg.a.f68962a, "error", "formatNumber count< 0", false, 4, null);
            return "0";
        }
        if (j11 < 1000) {
            return String.valueOf(j11);
        }
        if (j11 < 1000000) {
            BigDecimal divide = new BigDecimal(j11).divide(new BigDecimal(1000), 1, 4);
            Intrinsics.g(divide, "divide(...)");
            return divide + " k";
        }
        BigDecimal divide2 = new BigDecimal(j11).divide(new BigDecimal(1000000), 1, 4);
        Intrinsics.g(divide2, "divide(...)");
        return divide2 + " m";
    }
}
