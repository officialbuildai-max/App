package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b {
    public static int a(int i11) {
        if (2 <= i11 && i11 < 37) {
            return i11;
        }
        throw new IllegalArgumentException("radix " + i11 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c11, int i11) {
        return Character.digit((int) c11, i11);
    }

    public static boolean c(char c11) {
        return Character.isWhitespace(c11) || Character.isSpaceChar(c11);
    }

    public static String d(char c11, Locale locale) {
        Intrinsics.h(locale, "locale");
        String e11 = e(c11, locale);
        if (e11.length() <= 1) {
            String valueOf = String.valueOf(c11);
            Intrinsics.f(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            return !Intrinsics.c(e11, upperCase) ? e11 : String.valueOf(Character.toTitleCase(c11));
        }
        if (c11 == 329) {
            return e11;
        }
        char charAt = e11.charAt(0);
        Intrinsics.f(e11, "null cannot be cast to non-null type java.lang.String");
        String substring = e11.substring(1);
        Intrinsics.g(substring, "substring(...)");
        Intrinsics.f(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return charAt + lowerCase;
    }

    public static final String e(char c11, Locale locale) {
        Intrinsics.h(locale, "locale");
        String valueOf = String.valueOf(c11);
        Intrinsics.f(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
