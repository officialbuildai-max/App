package jn;

import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class f {
    public static final String a(int i11) {
        String format = new DecimalFormat("00").format(Integer.valueOf(i11));
        Intrinsics.g(format, "format(...)");
        return format;
    }
}
