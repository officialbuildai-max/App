package com.transsion.mbtools;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.u;
import com.google.gson.Gson;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.mmkv.MMKV;
import java.util.HashSet;
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
import kotlinx.coroutines.k;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class CalendarRemindUtils {

    /* renamed from: b, reason: collision with root package name */
    private static HashSet f46271b;

    /* renamed from: a, reason: collision with root package name */
    public static final CalendarRemindUtils f46270a = new CalendarRemindUtils();

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f46272c = LazyKt.b(new Function0<MMKV>() { // from class: com.transsion.mbtools.CalendarRemindUtils$mmkv$2
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.I("kv_calendar");
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f46273d = LazyKt.b(new Function0<String>() { // from class: com.transsion.mbtools.CalendarRemindUtils$md5Json$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return CalendarRemindUtils.f46270a.h().getString("calendar_md5_list", "");
        }
    });

    /* loaded from: classes5.dex */
    public static final class a implements PermissionUtils.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f46274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f46275b;

        a(Function0 function0, Function0 function02) {
            this.f46274a = function0;
            this.f46275b = function02;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            this.f46275b.invoke();
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            this.f46274a.invoke();
        }
    }

    private CalendarRemindUtils() {
    }

    private final void e(Function0 function0, Function0 function02) {
        if (PermissionUtils.s("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR")) {
            function0.invoke();
        } else {
            PermissionUtils.x("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR").m(new a(function0, function02)).y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long f() {
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

    private final String g() {
        return (String) f46273d.getValue();
    }

    private final void j() {
        Object m1185constructorimpl;
        if (f46271b == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl((HashSet) new Gson().fromJson(f46270a.g(), HashSet.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            HashSet hashSet = (HashSet) m1185constructorimpl;
            if (hashSet == null) {
                hashSet = new HashSet();
            }
            f46271b = hashSet;
            String g11 = g();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("md5Json：");
            sb2.append(g11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        k.d(n1.f68024a, y0.b(), null, new CalendarRemindUtils$saveMd5$1(null), 2, null);
    }

    public final void d(final CalendarBean bean, final Function0 success, final Function1 error) {
        String title;
        Intrinsics.h(bean, "bean");
        Intrinsics.h(success, "success");
        Intrinsics.h(error, "error");
        if (i(bean)) {
            error.invoke("Appointment has added");
            return;
        }
        if (bean.getStartTime() != null && bean.getEndTime() != null && (title = bean.getTitle()) != null && title.length() != 0) {
            e(new Function0<Unit>() { // from class: com.transsion.mbtools.CalendarRemindUtils$addAppointment$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m867invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m867invoke() {
                    Long f11;
                    HashSet hashSet;
                    String lastPathSegment;
                    CalendarRemindUtils calendarRemindUtils = CalendarRemindUtils.f46270a;
                    f11 = calendarRemindUtils.f();
                    ContentValues contentValues = new ContentValues();
                    CalendarBean calendarBean = CalendarBean.this;
                    String id2 = TimeZone.getDefault().getID();
                    contentValues.put("dtstart", calendarBean.getStartTime());
                    contentValues.put("dtend", calendarBean.getEndTime());
                    contentValues.put(CampaignEx.JSON_KEY_TITLE, calendarBean.getTitle());
                    contentValues.put(TrackingKey.DESCRIPTION, calendarBean.getDes());
                    contentValues.put("eventLocation", calendarBean.getLocation());
                    contentValues.put("calendar_id", f11);
                    String timeZone = calendarBean.getTimeZone();
                    if (timeZone == null) {
                        timeZone = id2;
                    }
                    contentValues.put("eventTimezone", timeZone);
                    String endTimeZone = calendarBean.getEndTimeZone();
                    if (endTimeZone != null) {
                        id2 = endTimeZone;
                    }
                    contentValues.put("eventEndTimezone", id2);
                    contentValues.put("hasAlarm", (Integer) 1);
                    Application a11 = Utils.a();
                    Uri insert = a11.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
                    if (insert != null && (lastPathSegment = insert.getLastPathSegment()) != null) {
                        CalendarBean calendarBean2 = CalendarBean.this;
                        ContentValues contentValues2 = new ContentValues();
                        Integer remindTime = calendarBean2.getRemindTime();
                        contentValues2.put("minutes", Integer.valueOf(remindTime != null ? remindTime.intValue() : 0));
                        contentValues2.put("event_id", lastPathSegment);
                        contentValues2.put("method", (Integer) 1);
                        a11.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
                    }
                    String a12 = MD5HashProvider.f46278a.a(CalendarBean.this.toString());
                    success.invoke();
                    hashSet = CalendarRemindUtils.f46271b;
                    if (hashSet != null) {
                        hashSet.add(a12);
                    }
                    calendarRemindUtils.k();
                }
            }, new Function0<Unit>() { // from class: com.transsion.mbtools.CalendarRemindUtils$addAppointment$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m868invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m868invoke() {
                    error.invoke("checkPermission-onDenied");
                }
            });
            return;
        }
        error.invoke("bean is null, startTime:" + bean.getStartTime() + ",endTime:" + bean.getEndTime() + ", title:" + bean.getTitle());
    }

    public final MMKV h() {
        Object value = f46272c.getValue();
        Intrinsics.g(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final boolean i(CalendarBean bean) {
        Intrinsics.h(bean, "bean");
        j();
        String a11 = MD5HashProvider.f46278a.a(bean.toString());
        HashSet hashSet = f46271b;
        return hashSet != null && hashSet.contains(a11);
    }
}
