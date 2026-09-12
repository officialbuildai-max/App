package com.transsion.baseui.util;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c0;
import com.transsion.baseui.R$plurals;
import com.transsion.baseui.R$string;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public abstract class TimeUtilKt {
    public static final String a(Integer num) {
        String str;
        String valueOf;
        String valueOf2;
        if (num == null) {
            return "00:00";
        }
        if (num.intValue() <= 0) {
            return "00:01";
        }
        int intValue = num.intValue() / 3600;
        int intValue2 = (num.intValue() / 60) % 60;
        int intValue3 = num.intValue() % 60;
        if (intValue > 0) {
            str = intValue + ":";
        } else {
            str = "";
        }
        if (intValue2 < 10) {
            valueOf = "0" + intValue2;
        } else {
            valueOf = String.valueOf(intValue2);
        }
        if (intValue3 < 10) {
            valueOf2 = "0" + intValue3;
        } else {
            valueOf2 = String.valueOf(intValue3);
        }
        return str + valueOf + ":" + valueOf2;
    }

    public static final t1 b(int i11, n0 scope, Function1 onTick, Function0 function0) {
        Intrinsics.h(scope, "scope");
        Intrinsics.h(onTick, "onTick");
        return kotlinx.coroutines.flow.d.v(kotlinx.coroutines.flow.d.z(kotlinx.coroutines.flow.d.A(kotlinx.coroutines.flow.d.u(kotlinx.coroutines.flow.d.s(new TimeUtilKt$countdownByFlow$1(i11, null)), y0.c()), new TimeUtilKt$countdownByFlow$2(onTick, null)), new TimeUtilKt$countdownByFlow$3(function0, null)), scope);
    }

    public static final int c() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static final int d(long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j11);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static final String e(long j11) {
        String j12 = c0.j(j11, c0.d("yyyy/MM/dd HH:mm:ss"));
        Intrinsics.g(j12, "millis2String(...)");
        return j12;
    }

    public static final String f(int i11) {
        int i12 = i11 / 3600;
        int i13 = (i11 % 3600) / 60;
        StringBuilder sb2 = new StringBuilder();
        if (i12 > 0) {
            sb2.append(i12);
            sb2.append("h");
        }
        if (i13 > 0) {
            sb2.append(i13);
            sb2.append("m");
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public static final String g(long j11) {
        long j12 = j11 / 1000;
        long j13 = 60;
        long j14 = j12 % j13;
        long j15 = (j12 / j13) % j13;
        long j16 = j12 / 3600;
        if (j16 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16), Long.valueOf(j15), Long.valueOf(j14)}, 3));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j15), Long.valueOf(j14)}, 2));
        Intrinsics.g(format2, "format(...)");
        return format2;
    }

    private static final String h(long j11, Integer num) {
        long currentTimeMillis = System.currentTimeMillis() - j11;
        Application a11 = Utils.a();
        if (currentTimeMillis < TimeUnit.MINUTES.toMillis(1L)) {
            String string = a11.getString(R$string.time_just_now);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (currentTimeMillis < TimeUnit.HOURS.toMillis(1L)) {
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis);
            String quantityString = a11.getResources().getQuantityString(R$plurals.time_minutes_ago, minutes, Integer.valueOf(minutes));
            Intrinsics.e(quantityString);
            return quantityString;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (currentTimeMillis < timeUnit.toMillis(1L)) {
            int hours = (int) TimeUnit.MILLISECONDS.toHours(currentTimeMillis);
            String quantityString2 = a11.getResources().getQuantityString(R$plurals.time_hours_ago, hours, Integer.valueOf(hours));
            Intrinsics.e(quantityString2);
            return quantityString2;
        }
        if (currentTimeMillis < timeUnit.toMillis(7L)) {
            int days = (int) TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
            String quantityString3 = a11.getResources().getQuantityString(R$plurals.time_days_ago, days, Integer.valueOf(days));
            Intrinsics.e(quantityString3);
            return quantityString3;
        }
        if (currentTimeMillis < timeUnit.toMillis(30L)) {
            int days2 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 7);
            String quantityString4 = a11.getResources().getQuantityString(R$plurals.time_weeks_ago, days2, Integer.valueOf(days2));
            Intrinsics.e(quantityString4);
            return quantityString4;
        }
        int days3 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 30);
        if (num != null) {
            days3 = RangesKt.i(days3, num.intValue());
        }
        String quantityString5 = a11.getResources().getQuantityString(R$plurals.time_months_ago, days3, Integer.valueOf(days3));
        Intrinsics.e(quantityString5);
        return quantityString5;
    }

    public static final String i(long j11) {
        long currentTimeMillis = System.currentTimeMillis() - j11;
        Application a11 = Utils.a();
        if (currentTimeMillis < TimeUnit.MINUTES.toMillis(1L)) {
            String string = a11.getString(R$string.time_just_now);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (currentTimeMillis < TimeUnit.HOURS.toMillis(1L)) {
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis);
            String quantityString = a11.getResources().getQuantityString(R$plurals.time_minutes_ago, minutes, Integer.valueOf(minutes));
            Intrinsics.e(quantityString);
            return quantityString;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        if (currentTimeMillis < timeUnit.toMillis(1L)) {
            int hours = (int) TimeUnit.MILLISECONDS.toHours(currentTimeMillis);
            String quantityString2 = a11.getResources().getQuantityString(R$plurals.time_hours_ago, hours, Integer.valueOf(hours));
            Intrinsics.e(quantityString2);
            return quantityString2;
        }
        if (currentTimeMillis < timeUnit.toMillis(7L)) {
            int days = (int) TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
            String quantityString3 = a11.getResources().getQuantityString(R$plurals.time_days_ago, days, Integer.valueOf(days));
            Intrinsics.e(quantityString3);
            return quantityString3;
        }
        if (currentTimeMillis < timeUnit.toMillis(30L)) {
            int days2 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 7);
            String quantityString4 = a11.getResources().getQuantityString(R$plurals.time_weeks_ago, days2, Integer.valueOf(days2));
            Intrinsics.e(quantityString4);
            return quantityString4;
        }
        if (currentTimeMillis < timeUnit.toMillis(365L)) {
            int days3 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 30);
            String quantityString5 = a11.getResources().getQuantityString(R$plurals.time_months_ago, days3, Integer.valueOf(days3));
            Intrinsics.e(quantityString5);
            return quantityString5;
        }
        int days4 = (int) (TimeUnit.MILLISECONDS.toDays(currentTimeMillis) / 365);
        String quantityString6 = a11.getResources().getQuantityString(R$plurals.time_years_ago, days4, Integer.valueOf(days4));
        Intrinsics.e(quantityString6);
        return quantityString6;
    }

    public static final String j(long j11) {
        return h(j11, 6);
    }

    public static final String k(long j11) {
        int i11 = Calendar.getInstance().get(1);
        String j12 = c0.j(j11, c0.d("yyyy-MM-dd HH:mm:ss"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(c0.k(j12));
        if (i11 == calendar.get(1)) {
            String j13 = c0.j(j11, c0.d("MM-dd"));
            Intrinsics.e(j13);
            return j13;
        }
        String j14 = c0.j(j11, c0.d("yyyy-MM-dd"));
        Intrinsics.e(j14);
        return j14;
    }

    public static final String l(String str) {
        long parseLong;
        if (str != null) {
            try {
                parseLong = Long.parseLong(str);
            } catch (Exception unused) {
                return "0";
            }
        } else {
            parseLong = 0;
        }
        return k(parseLong);
    }

    public static final String m(long j11) {
        String j12 = c0.j(j11, c0.d("yyyy-MM-dd"));
        Intrinsics.g(j12, "millis2String(...)");
        return j12;
    }

    public static final String n(long j11) {
        if (j11 == 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = j11 >= 3600000 ? new SimpleDateFormat("HH:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j11));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public static final String o(long j11) {
        StringBuilder sb2 = new StringBuilder();
        if (j11 > 3600) {
            long j12 = 3600;
            long j13 = j11 / j12;
            j11 -= j12 * j13;
            if (j13 < 10) {
                sb2.append("0");
            }
            sb2.append(j13);
            sb2.append(":");
        }
        if (j11 > 60) {
            long j14 = 60;
            long j15 = j11 / j14;
            j11 -= j14 * j15;
            if (j15 < 10) {
                sb2.append("0");
            }
            sb2.append(j15);
            sb2.append(":");
        } else {
            sb2.append("00:");
        }
        if (j11 <= 0) {
            sb2.append("00");
        } else if (j11 > 60) {
            sb2.append("59");
        } else if (j11 < 10) {
            sb2.append("0" + j11);
        } else {
            sb2.append(j11);
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    public static final int p(long j11) {
        long currentTimeMillis = j11 - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            return -1;
        }
        return (int) TimeUnit.MILLISECONDS.toDays(currentTimeMillis);
    }

    public static final String q(long j11) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j11);
        long j12 = 60;
        long minutes = timeUnit.toMinutes(j11) % j12;
        long j13 = j11 % j12;
        if (hours > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(Locale.ROOT, "%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(j13)}, 3));
            Intrinsics.g(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f67412a;
        String format2 = String.format(Locale.ROOT, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(j13)}, 2));
        Intrinsics.g(format2, "format(...)");
        return format2;
    }
}
