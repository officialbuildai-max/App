package com.transsion.baseui.util;

import android.content.Context;
import com.transsion.baseui.R$plurals;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes5.dex */
public abstract class j {
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
            return divide + "K";
        }
        BigDecimal divide2 = new BigDecimal(j11).divide(new BigDecimal(1000000), 1, 4);
        Intrinsics.g(divide2, "divide(...)");
        return divide2 + "M";
    }

    public static final String b(Integer num) {
        if (num == null) {
            return "";
        }
        return (num.intValue() / 3600) + "h " + ((num.intValue() % 3600) / 60) + "m";
    }

    public static final String c(String str, Context context) {
        Long x10;
        Intrinsics.h(context, "context");
        long longValue = (str == null || (x10 = StringsKt.x(str)) == null) ? 0L : x10.longValue();
        String quantityString = context.getResources().getQuantityString(R$plurals.str_views, (int) longValue, a(longValue));
        Intrinsics.g(quantityString, "getQuantityString(...)");
        return quantityString;
    }
}
