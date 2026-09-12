package r3;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f74209a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(j0 j0Var) {
        String s11;
        while (true) {
            String s12 = j0Var.s();
            if (s12 == null) {
                return null;
            }
            if (f74209a.matcher(s12).matches()) {
                do {
                    s11 = j0Var.s();
                    if (s11 != null) {
                    }
                } while (!s11.isEmpty());
            } else {
                Matcher matcher = e.f74183a.matcher(s12);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(j0 j0Var) {
        String s11 = j0Var.s();
        return s11 != null && s11.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] p12 = a1.p1(str, "\\.");
        long j11 = 0;
        for (String str2 : a1.o1(p12[0], ":")) {
            j11 = (j11 * 60) + Long.parseLong(str2);
        }
        long j12 = j11 * 1000;
        if (p12.length == 2) {
            String trim = p12[1].trim();
            if (trim.length() != 3) {
                throw new IllegalArgumentException("Expected 3 decimal places, got: " + trim);
            }
            j12 += Long.parseLong(trim);
        }
        return j12 * 1000;
    }

    public static void e(j0 j0Var) {
        int f11 = j0Var.f();
        if (b(j0Var)) {
            return;
        }
        j0Var.W(f11);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + j0Var.s(), null);
    }
}
