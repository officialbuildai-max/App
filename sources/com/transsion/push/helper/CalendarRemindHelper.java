package com.transsion.push.helper;

import android.app.Application;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Log;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.u;
import com.google.android.gms.common.util.GmsVersion;
import com.google.gson.Gson;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.mmkv.MMKV;
import com.transsion.mbtools.MD5HashProvider;
import com.transsion.push.bean.CalendarData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class CalendarRemindHelper {

    /* renamed from: b, reason: collision with root package name */
    private static HashMap f50903b;

    /* renamed from: a, reason: collision with root package name */
    public static final CalendarRemindHelper f50902a = new CalendarRemindHelper();

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f50904c = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV u11;
            u11 = CalendarRemindHelper.u();
            return u11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f50905d = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String t11;
            t11 = CalendarRemindHelper.t();
            return t11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a implements PermissionUtils.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f50906a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f50907b;

        a(Function0 function0, Function0 function02) {
            this.f50906a = function0;
            this.f50907b = function02;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            this.f50907b.invoke();
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            this.f50906a.invoke();
        }
    }

    private CalendarRemindHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(CalendarData calendarData, Function1 function1, Function0 function0) {
        String lastPathSegment;
        CalendarRemindHelper calendarRemindHelper = f50902a;
        if (calendarRemindHelper.r(calendarData)) {
            function1.invoke("Appointment has added");
            return Unit.f67184a;
        }
        Long o11 = calendarRemindHelper.o();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calendarId ");
        sb2.append(o11);
        ContentValues contentValues = new ContentValues();
        String id2 = TimeZone.getDefault().getID();
        contentValues.put("dtstart", calendarData.getStartTime());
        Long startTime = calendarData.getStartTime();
        Intrinsics.e(startTime);
        contentValues.put("dtend", Long.valueOf(startTime.longValue() + GmsVersion.VERSION_PARMESAN));
        contentValues.put(CampaignEx.JSON_KEY_TITLE, calendarData.getTitle());
        contentValues.put(TrackingKey.DESCRIPTION, calendarData.getDes());
        contentValues.put("eventLocation", calendarData.getLocation());
        contentValues.put("calendar_id", o11);
        String timeZone = calendarData.getTimeZone();
        if (timeZone == null) {
            timeZone = id2;
        }
        contentValues.put("eventTimezone", timeZone);
        String endTimeZone = calendarData.getEndTimeZone();
        if (endTimeZone != null) {
            id2 = endTimeZone;
        }
        contentValues.put("eventEndTimezone", id2);
        contentValues.put("hasAlarm", (Integer) 1);
        Application a11 = Utils.a();
        Uri insert = a11.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
        if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
            ContentValues contentValues2 = new ContentValues();
            Integer remindTime = calendarData.getRemindTime();
            contentValues2.put("minutes", Integer.valueOf(remindTime != null ? remindTime.intValue() : 0));
            contentValues2.put("event_id", lastPathSegment);
            contentValues2.put("method", (Integer) 1);
            a11.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
        }
        String a12 = MD5HashProvider.f46278a.a(String.valueOf(calendarData.getCalendarId()));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("md5 :");
        sb3.append(a12);
        function0.invoke();
        HashMap hashMap = f50903b;
        if (hashMap != null) {
        }
        calendarRemindHelper.w();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1) {
        function1.invoke("checkPermission-onDenied");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(CalendarData calendarData, String str, Function1 function1, Function0 function0) {
        Uri withAppendedId;
        Application a11 = Utils.a();
        CalendarRemindHelper calendarRemindHelper = f50902a;
        Long o11 = calendarRemindHelper.o();
        if (o11 == null) {
            function1.invoke("getDefaultCalendarId failed");
            return Unit.f67184a;
        }
        long longValue = o11.longValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calendarId ");
        sb2.append(longValue);
        Intrinsics.e(a11);
        List v11 = calendarRemindHelper.v(a11, calendarData, longValue, str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("eventIds  ");
        sb3.append(v11);
        if (v11.isEmpty()) {
            function1.invoke("No matched event found");
            return Unit.f67184a;
        }
        Iterator it = v11.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            long longValue2 = ((Number) it.next()).longValue();
            try {
                a11.getContentResolver().delete(CalendarContract.Reminders.CONTENT_URI, "event_id = ?", new String[]{String.valueOf(longValue2)});
                withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, longValue2);
                Intrinsics.g(withAppendedId, "withAppendedId(...)");
            } catch (Exception e11) {
                Log.e("CalendarRemindHelper", "delete event error:" + e11.getMessage(), e11);
            }
            if (a11.getContentResolver().delete(withAppendedId, null, null) <= 0) {
                z10 = false;
            }
        }
        if (z10) {
            HashMap hashMap = f50903b;
            if (hashMap != null) {
            }
            f50902a.w();
            function0.invoke();
        } else {
            function1.invoke("Delete event failed");
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke("checkPermission-onDenied");
        return Unit.f67184a;
    }

    private final void n(Function0 function0, Function0 function02) {
        if (PermissionUtils.s("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR", "android.permission.POST_NOTIFICATIONS")) {
            function0.invoke();
        } else {
            PermissionUtils.x("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR").m(new a(function0, function02)).y();
        }
    }

    private final Long o() {
        Cursor query = Utils.a().getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName"}, "visible = 1 AND sync_events = 1", null, null);
        if (query != null) {
            long j11 = -1;
            while (query.moveToNext()) {
                try {
                    long j12 = query.getLong(0);
                    if (u.b(query.getString(1))) {
                        j11 = j12;
                    }
                } finally {
                }
            }
            if (j11 > 0) {
                Long valueOf = Long.valueOf(j11);
                CloseableKt.a(query, null);
                return valueOf;
            }
            if (query.moveToFirst()) {
                Long valueOf2 = Long.valueOf(query.getLong(0));
                CloseableKt.a(query, null);
                return valueOf2;
            }
            Unit unit = Unit.f67184a;
            CloseableKt.a(query, null);
        }
        return null;
    }

    private final String p() {
        return (String) f50905d.getValue();
    }

    private final void s() {
        Object m1185constructorimpl;
        if (f50903b == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl((HashMap) new Gson().fromJson(p(), HashMap.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            HashMap hashMap = (HashMap) m1185constructorimpl;
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            f50903b = hashMap;
            String p11 = p();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("md5Json：");
            sb2.append(p11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t() {
        return f50902a.q().getString("calendar_md5_list", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV u() {
        MMKV I = MMKV.I("kv_calendar");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    private final List v(Context context, CalendarData calendarData, long j11, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"_id"};
        String Q = StringsKt.Q("description = ? \nAND  dtstart BETWEEN ? AND ? \nAND calendar_id = ?", "\n", "", false, 4, null);
        HashMap hashMap = f50903b;
        String str2 = hashMap != null ? (String) hashMap.get(str) : null;
        Long startTime = calendarData.getStartTime();
        Intrinsics.e(startTime);
        long j12 = 60000;
        String valueOf = String.valueOf(startTime.longValue() - j12);
        Long startTime2 = calendarData.getStartTime();
        Intrinsics.e(startTime2);
        Cursor query = context.getContentResolver().query(CalendarContract.Events.CONTENT_URI, strArr, Q, new String[]{str2, valueOf, String.valueOf(startTime2.longValue() + j12), String.valueOf(j11)}, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    arrayList.add(Long.valueOf(query.getLong(query.getColumnIndexOrThrow("_id"))));
                } finally {
                }
            }
            Unit unit = Unit.f67184a;
            CloseableKt.a(query, null);
        }
        return arrayList;
    }

    private final void w() {
        k.d(n1.f68024a, y0.b(), null, new CalendarRemindHelper$saveMd5$1(null), 2, null);
    }

    public final void h(final CalendarData bean, final Function0 success, final Function1 error) {
        String title;
        Intrinsics.h(bean, "bean");
        Intrinsics.h(success, "success");
        Intrinsics.h(error, "error");
        if (bean.getStartTime() != null && (title = bean.getTitle()) != null && title.length() != 0) {
            n(new Function0() { // from class: com.transsion.push.helper.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit i11;
                    i11 = CalendarRemindHelper.i(CalendarData.this, error, success);
                    return i11;
                }
            }, new Function0() { // from class: com.transsion.push.helper.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit j11;
                    j11 = CalendarRemindHelper.j(Function1.this);
                    return j11;
                }
            });
            return;
        }
        error.invoke("bean is null, startTime:" + bean.getStartTime() + ", title:" + bean.getTitle());
    }

    public final void k(final CalendarData bean, final Function0 success, final Function1 error) {
        String title;
        Intrinsics.h(bean, "bean");
        Intrinsics.h(success, "success");
        Intrinsics.h(error, "error");
        if (bean.getStartTime() == null || (title = bean.getTitle()) == null || title.length() == 0) {
            error.invoke("bean is null, startTime:" + bean.getStartTime() + ", title:" + bean.getTitle());
            return;
        }
        s();
        final String a11 = MD5HashProvider.f46278a.a(String.valueOf(bean.getCalendarId()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("md5 : ");
        sb2.append(a11);
        sb2.append(" ");
        HashMap hashMap = f50903b;
        Boolean valueOf = hashMap != null ? Boolean.valueOf(hashMap.containsKey(a11)) : null;
        Intrinsics.e(valueOf);
        if (valueOf.booleanValue()) {
            n(new Function0() { // from class: com.transsion.push.helper.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit l11;
                    l11 = CalendarRemindHelper.l(CalendarData.this, a11, error, success);
                    return l11;
                }
            }, new Function0() { // from class: com.transsion.push.helper.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit m11;
                    m11 = CalendarRemindHelper.m(Function1.this);
                    return m11;
                }
            });
        } else {
            error.invoke("Appointment not exists");
        }
    }

    public final MMKV q() {
        return (MMKV) f50904c.getValue();
    }

    public final boolean r(CalendarData bean) {
        Intrinsics.h(bean, "bean");
        s();
        String a11 = MD5HashProvider.f46278a.a(String.valueOf(bean.getCalendarId()));
        HashMap hashMap = f50903b;
        return hashMap != null && hashMap.containsKey(a11);
    }
}
