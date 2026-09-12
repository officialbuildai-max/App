package lx;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f69179a = new b();

    private b() {
    }

    public final String a(long j11) {
        SimpleDateFormat simpleDateFormat = j11 >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j11));
        Intrinsics.g(format, "format(...)");
        return format;
    }
}
