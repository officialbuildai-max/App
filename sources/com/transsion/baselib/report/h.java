package com.transsion.baselib.report;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.meituan.android.walle.ChannelReader;
import com.transsion.mpush.core.config.PushMsgSource;
import com.transsion.startup.pref.consume.AppStartDotState;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f43402a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static String f43403b = "cold";

    /* renamed from: c, reason: collision with root package name */
    private static long f43404c = SystemClock.elapsedRealtime();

    /* renamed from: d, reason: collision with root package name */
    private static String f43405d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f43406e = "";

    /* renamed from: f, reason: collision with root package name */
    private static Uri f43407f;

    private h() {
    }

    private final int a(long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j11);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    private final String d(Uri uri) {
        return uri == null ? "launch" : Intrinsics.c(com.transsion.baselib.helper.b.f43318a.c(uri).getUtmSource(), PushMsgSource.SOURCE_PUSH) ? PushMsgSource.SOURCE_PUSH : "deeplink";
    }

    private final void g(long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put(EventConstants.KEY_SOURCE, f43405d);
        hashMap.put(ChannelReader.CHANNEL_KEY, f43406e);
        hashMap.put("duration", String.valueOf(j11));
        hj.i.f64628a.t("app_stop", hashMap);
    }

    private final void h(String str) {
        f43405d = d(f43407f);
        String utmSource = com.transsion.baselib.helper.b.f43318a.c(f43407f).getUtmSource();
        if (utmSource == null) {
            utmSource = "";
        }
        f43406e = utmSource;
        f43407f = null;
        HashMap hashMap = new HashMap();
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, str);
        hashMap.put(EventConstants.KEY_SOURCE, f43405d);
        hashMap.put(ChannelReader.CHANNEL_KEY, f43406e);
        hj.i iVar = hj.i.f64628a;
        iVar.t(AppStartDotState.APP_START, hashMap);
        if (Intrinsics.c(f43405d, "launch")) {
            iVar.t("app_launch_channel", hashMap);
            j(f43406e);
        }
    }

    private final void j(String str) {
        Long x10;
        try {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            bVar.b().putString("k_last_open_channel", str);
            String string = bVar.b().getString("k_last_open_time", "0");
            long longValue = (string == null || (x10 = StringsKt.x(string)) == null) ? 0L : x10.longValue();
            if (!DateUtils.isToday(longValue)) {
                int i11 = bVar.b().getInt("k_open_day_count", 0);
                int a11 = a(longValue);
                int a12 = a(System.currentTimeMillis());
                int i12 = a12 - a11 == 1 ? i11 + 1 : 1;
                bVar.b().putInt("k_open_day_count", i12);
                a.C0856a.f(lg.a.f68962a, "ReportLaunchManager", "openDayCount:" + i12 + ", lastDay:" + a11 + ", curDay:" + a12, false, 4, null);
                hj.i.f64628a.s("app_fg_alive", "app_perf", MapsKt.j(TuplesKt.a(EventConstants.KEY_SOURCE, f43405d), TuplesKt.a(ChannelReader.CHANNEL_KEY, str)));
            }
            bVar.b().putString("k_last_open_time", String.valueOf(System.currentTimeMillis()));
            bVar.b().putString("k_last_open_version", com.transsion.core.utils.a.c());
        } catch (Exception unused) {
        }
    }

    public final String b() {
        return f43406e;
    }

    public final Uri c() {
        return f43407f;
    }

    public final String e() {
        return TextUtils.isEmpty(f43405d) ? "launch" : f43405d;
    }

    public final void f(boolean z10) {
        if (z10) {
            f43403b = "warm";
            g(SystemClock.elapsedRealtime() - f43404c);
        } else {
            f43404c = SystemClock.elapsedRealtime();
            h(f43403b);
        }
    }

    public final void i(String shortUrl, String wholeUrl) {
        String str;
        String queryParameter;
        Intrinsics.h(shortUrl, "shortUrl");
        Intrinsics.h(wholeUrl, "wholeUrl");
        String str2 = "";
        Uri parse = !Intrinsics.c(wholeUrl, "") ? Uri.parse(wholeUrl) : Uri.parse(shortUrl);
        f43405d = d(parse);
        String utmSource = com.transsion.baselib.helper.b.f43318a.c(parse).getUtmSource();
        if (utmSource == null) {
            utmSource = "";
        }
        f43406e = utmSource;
        HashMap hashMap = new HashMap();
        hashMap.put(EventConstants.KEY_SOURCE, f43405d);
        hashMap.put(ChannelReader.CHANNEL_KEY, f43406e);
        if (parse == null || (str = parse.getQueryParameter("msgId")) == null) {
            str = "";
        }
        hashMap.put("msgId", str);
        if (parse != null && (queryParameter = parse.getQueryParameter("msg_type")) != null) {
            str2 = queryParameter;
        }
        hashMap.put("msg_type", str2);
        hashMap.put("url", wholeUrl);
        hashMap.put("surl", shortUrl);
        hj.i.f64628a.t("app_launch_channel", hashMap);
        j(f43406e);
    }

    public final void k(Uri uri) {
        f43407f = uri;
    }
}
