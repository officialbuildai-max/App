package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    static AtomicReference f28967a = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(long j11) {
        Calendar s11 = s();
        s11.setTimeInMillis(j11);
        return f(s11).getTimeInMillis();
    }

    private static int b(String str, String str2, int i11, int i12) {
        while (i12 >= 0 && i12 < str.length() && str2.indexOf(str.charAt(i12)) == -1) {
            if (str.charAt(i12) != '\'') {
                i12 += i11;
            }
            do {
                i12 += i11;
                if (i12 >= 0 && i12 < str.length()) {
                }
                i12 += i11;
            } while (str.charAt(i12) != '\'');
            i12 += i11;
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat c(Locale locale) {
        return d("MMMd", locale);
    }

    private static DateFormat d(String str, Locale locale) {
        DateFormat instanceForSkeleton;
        DisplayContext displayContext;
        instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(r());
        displayContext = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
        instanceForSkeleton.setContext(displayContext);
        return instanceForSkeleton;
    }

    static String e(String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar f(Calendar calendar) {
        Calendar t11 = t(calendar);
        Calendar s11 = s();
        s11.set(t11.get(1), t11.get(2), t11.get(5));
        return s11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(e(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(p());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R$string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R$string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R$string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    private static java.text.DateFormat i(int i11, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i11, locale);
        dateInstance.setTimeZone(p());
        return dateInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat j(Locale locale) {
        return i(0, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat k(Locale locale) {
        return i(2, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat l(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) k(locale);
        simpleDateFormat.applyPattern(x(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat m(Locale locale) {
        return d("MMMMEEEEd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat n(java.text.DateFormat dateFormat) {
        java.text.DateFormat dateFormat2 = (java.text.DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(p());
        return dateFormat2;
    }

    static r o() {
        r rVar = (r) f28967a.get();
        return rVar == null ? r.c() : rVar;
    }

    private static TimeZone p() {
        return TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar q() {
        Calendar a11 = o().a();
        a11.set(11, 0);
        a11.set(12, 0);
        a11.set(13, 0);
        a11.set(14, 0);
        a11.setTimeZone(p());
        return a11;
    }

    private static android.icu.util.TimeZone r() {
        android.icu.util.TimeZone timeZone;
        timeZone = android.icu.util.TimeZone.getTimeZone("UTC");
        return timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar s() {
        return t(null);
    }

    static Calendar t(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(p());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat u(Locale locale) {
        return d("yMMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat v(Locale locale) {
        return d("yMMMM", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat w(Locale locale) {
        return d("yMMMMEEEEd", locale);
    }

    private static String x(String str) {
        int b11 = b(str, "yY", 1, 0);
        if (b11 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b12 = b(str, "EMd", 1, b11);
        if (b12 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(b(str, str2, -1, b11) + 1, b12), " ").trim();
    }
}
