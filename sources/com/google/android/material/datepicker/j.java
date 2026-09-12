package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.util.e a(Long l11, Long l12) {
        return b(l11, l12, null);
    }

    static androidx.core.util.e b(Long l11, Long l12, SimpleDateFormat simpleDateFormat) {
        if (l11 == null && l12 == null) {
            return androidx.core.util.e.a(null, null);
        }
        if (l11 == null) {
            return androidx.core.util.e.a(null, d(l12.longValue(), simpleDateFormat));
        }
        if (l12 == null) {
            return androidx.core.util.e.a(d(l11.longValue(), simpleDateFormat), null);
        }
        Calendar q11 = x.q();
        Calendar s11 = x.s();
        s11.setTimeInMillis(l11.longValue());
        Calendar s12 = x.s();
        s12.setTimeInMillis(l12.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.util.e.a(simpleDateFormat.format(new Date(l11.longValue())), simpleDateFormat.format(new Date(l12.longValue())));
        }
        return s11.get(1) == s12.get(1) ? s11.get(1) == q11.get(1) ? androidx.core.util.e.a(g(l11.longValue(), Locale.getDefault()), g(l12.longValue(), Locale.getDefault())) : androidx.core.util.e.a(g(l11.longValue(), Locale.getDefault()), n(l12.longValue(), Locale.getDefault())) : androidx.core.util.e.a(n(l11.longValue(), Locale.getDefault()), n(l12.longValue(), Locale.getDefault()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j11) {
        return d(j11, null);
    }

    static String d(long j11, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j11)) : q(j11) ? f(j11) : m(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context, long j11, boolean z10, boolean z11, boolean z12) {
        String j12 = j(j11);
        if (z10) {
            j12 = String.format(context.getString(R$string.mtrl_picker_today_description), j12);
        }
        return z11 ? String.format(context.getString(R$string.mtrl_picker_start_date_description), j12) : z12 ? String.format(context.getString(R$string.mtrl_picker_end_date_description), j12) : j12;
    }

    static String f(long j11) {
        return g(j11, Locale.getDefault());
    }

    static String g(long j11, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return x.l(locale).format(new Date(j11));
        }
        format = x.c(locale).format(new Date(j11));
        return format;
    }

    static String h(long j11) {
        return i(j11, Locale.getDefault());
    }

    static String i(long j11, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return x.j(locale).format(new Date(j11));
        }
        format = x.m(locale).format(new Date(j11));
        return format;
    }

    static String j(long j11) {
        return q(j11) ? h(j11) : o(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k(Context context, int i11) {
        return x.q().get(1) == i11 ? String.format(context.getString(R$string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i11)) : String.format(context.getString(R$string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(long j11) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return DateUtils.formatDateTime(null, j11, 8228);
        }
        format = x.v(Locale.getDefault()).format(new Date(j11));
        return format;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(long j11) {
        return n(j11, Locale.getDefault());
    }

    static String n(long j11, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return x.k(locale).format(new Date(j11));
        }
        format = x.u(locale).format(new Date(j11));
        return format;
    }

    static String o(long j11) {
        return p(j11, Locale.getDefault());
    }

    static String p(long j11, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return x.j(locale).format(new Date(j11));
        }
        format = x.w(locale).format(new Date(j11));
        return format;
    }

    private static boolean q(long j11) {
        Calendar q11 = x.q();
        Calendar s11 = x.s();
        s11.setTimeInMillis(j11);
        return q11.get(1) == s11.get(1);
    }
}
