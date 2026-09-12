package com.transsnet.downloader.util;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f60044a = new b0();

    private b0() {
    }

    public final int a(String str) {
        Integer num;
        if (str == null || StringsKt.q0(str)) {
            return 0;
        }
        String upperCase = StringsKt.n1(str).toString().toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        int hashCode = upperCase.hashCode();
        if (hashCode == 1625) {
            if (upperCase.equals("2K")) {
                num = 1440;
            }
            num = null;
        } else if (hashCode == 1687) {
            if (upperCase.equals("4K")) {
                num = 2160;
            }
            num = null;
        } else if (hashCode != 1718) {
            if (hashCode == 1811 && upperCase.equals("8K")) {
                num = 4320;
            }
            num = null;
        } else {
            if (upperCase.equals("5K")) {
                num = 2880;
            }
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        Integer v11 = StringsKt.v(StringsKt.J0(upperCase, "P"));
        if (v11 != null) {
            return v11.intValue();
        }
        return 0;
    }
}
