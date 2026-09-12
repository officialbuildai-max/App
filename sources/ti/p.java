package ti;

import com.cloud.tmc.miniutils.constant.TimeConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f76389a = new p();

    private p() {
    }

    public static /* synthetic */ String b(p pVar, Long l11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "yyyy-MM-dd";
        }
        return pVar.a(l11, str);
    }

    public final String a(Long l11, String dateFormat) {
        Intrinsics.h(dateFormat, "dateFormat");
        String format = new SimpleDateFormat(dateFormat, Locale.getDefault()).format(new Date(l11 != null ? l11.longValue() : 0L));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final String c() {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final long d() {
        return new Date().getTime();
    }

    public final String e(long j11, long j12) {
        long abs = Math.abs(j12 - j11);
        long j13 = 60;
        return (abs / TimeConstants.DAY) + "天 " + ((abs / TimeConstants.HOUR) % 24) + "小时 " + ((abs / 60000) % j13) + "分钟 " + ((abs / 1000) % j13) + "秒";
    }
}
