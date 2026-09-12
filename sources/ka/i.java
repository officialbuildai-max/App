package ka;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f66857a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(d0 d0Var) {
        String p11;
        while (true) {
            String p12 = d0Var.p();
            if (p12 == null) {
                return null;
            }
            if (f66857a.matcher(p12).matches()) {
                do {
                    p11 = d0Var.p();
                    if (p11 != null) {
                    }
                } while (!p11.isEmpty());
            } else {
                Matcher matcher = f.f66831a.matcher(p12);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(d0 d0Var) {
        String p11 = d0Var.p();
        return p11 != null && p11.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] T0 = p0.T0(str, "\\.");
        long j11 = 0;
        for (String str2 : p0.S0(T0[0], ":")) {
            j11 = (j11 * 60) + Long.parseLong(str2);
        }
        long j12 = j11 * 1000;
        if (T0.length == 2) {
            j12 += Long.parseLong(T0[1]);
        }
        return j12 * 1000;
    }

    public static void e(d0 d0Var) {
        int e11 = d0Var.e();
        if (b(d0Var)) {
            return;
        }
        d0Var.P(e11);
        throw ParserException.createForMalformedContainer("Expected WEBVTT. Got " + d0Var.p(), null);
    }
}
