package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes4.dex */
class r {

    /* renamed from: c, reason: collision with root package name */
    private static final r f28964c = new r(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Long f28965a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeZone f28966b;

    private r(Long l11, TimeZone timeZone) {
        this.f28965a = l11;
        this.f28966b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r c() {
        return f28964c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f28966b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l11 = this.f28965a;
        if (l11 != null) {
            calendar.setTimeInMillis(l11.longValue());
        }
        return calendar;
    }
}
