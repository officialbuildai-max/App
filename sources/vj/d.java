package vj;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.utils.i;
import com.blankj.utilcode.util.ThreadUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.mb.config.manager.ConfigBean;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import lg.a;
import sm.f;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f77456a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f77457b = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private d() {
    }

    private final boolean c() {
        MMKV o11 = MMKV.o();
        Intrinsics.g(o11, "defaultMMKV(...)");
        String format = f77457b.format(new Date());
        int g11 = Intrinsics.c(o11.l("app_exit_monitor_date", ""), format) ? o11.g("app_exit_monitor_count", 0) : 0;
        if (g11 >= 2) {
            return false;
        }
        o11.v("app_exit_monitor_date", format);
        o11.s("app_exit_monitor_count", g11 + 1);
        return true;
    }

    private final void d(Context context) {
        List historicalProcessExitReasons;
        Object obj;
        Object obj2;
        long pss;
        long rss;
        long timestamp;
        String description;
        String description2;
        String processName;
        int importance;
        InputStream traceInputStream;
        String str;
        int reason;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        if (activityManager == null) {
            return;
        }
        historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 5);
        Intrinsics.g(historicalProcessExitReasons, "getHistoricalProcessExitReasons(...)");
        Iterator it = historicalProcessExitReasons.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            reason = i.a(obj).getReason();
            if (reason == 6) {
                break;
            }
        }
        ApplicationExitInfo a11 = i.a(obj);
        if (a11 == null) {
            return;
        }
        if (!c()) {
            a.C0856a.f(lg.a.f68962a, "AppExitMonitor", "ANR report skipped: daily limit reached", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            traceInputStream = a11.getTraceInputStream();
            if (traceInputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(traceInputStream, Charsets.UTF_8), 8192);
                try {
                    str = TextStreamsKt.e(bufferedReader);
                    CloseableKt.a(bufferedReader, null);
                } finally {
                }
            } else {
                str = null;
            }
            obj2 = Result.m1185constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            obj2 = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        String str2 = (String) (Result.m1191isFailureimpl(obj2) ? null : obj2);
        String e11 = str2 != null ? e(str2) : "trace_unavailable";
        pss = a11.getPss();
        long j11 = 1024;
        long j12 = pss / j11;
        rss = a11.getRss();
        long j13 = rss / j11;
        a.C0856a c0856a = lg.a.f68962a;
        timestamp = a11.getTimestamp();
        description = a11.getDescription();
        a.C0856a.f(c0856a, "AppExitMonitor", "ANR detected | time=" + timestamp + " desc=" + description + " pss=" + j12 + "MB rss=" + j13 + AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_MB, false, 4, null);
        hj.i iVar = hj.i.f64628a;
        description2 = a11.getDescription();
        if (description2 == null) {
            description2 = "";
        }
        Pair a12 = TuplesKt.a(TrackingKey.DESCRIPTION, description2);
        processName = a11.getProcessName();
        Pair a13 = TuplesKt.a("process", processName);
        Pair a14 = TuplesKt.a("pss_mb", String.valueOf(j12));
        Pair a15 = TuplesKt.a("rss_mb", String.valueOf(j13));
        importance = a11.getImportance();
        iVar.s("/app/exit_monitor", "app_perf", MapsKt.j(a12, a13, a14, a15, TuplesKt.a("importance", String.valueOf(importance)), TuplesKt.a("trace", e11)));
    }

    private final String e(String str) {
        String str2;
        List a11;
        Integer valueOf = Integer.valueOf(StringsKt.o0(str, "\"main\"", 0, false, 6, null));
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf == null) {
            return StringsKt.y1(str, 1500);
        }
        int intValue = valueOf.intValue();
        Integer valueOf2 = Integer.valueOf(StringsKt.o0(str, "\n\n", intValue, false, 4, null));
        if (valueOf2.intValue() <= 0) {
            valueOf2 = null;
        }
        String substring = str.substring(intValue, Math.min(valueOf2 != null ? valueOf2.intValue() : str.length(), intValue + 4500));
        Intrinsics.g(substring, "substring(...)");
        MatchResult find$default = Regex.find$default(new Regex("\\|\\s+state=(\\S+)"), substring, 0, 2, null);
        if (find$default == null || (a11 = find$default.a()) == null || (str2 = (String) a11.get(1)) == null) {
            str2 = UrlUtils.QUESTION_MARK;
        }
        String str3 = (String) SequencesKt.t(StringsKt.x0(substring));
        if (str3 == null) {
            str3 = "";
        }
        return StringsKt.y1(str3 + " [state=" + str2 + "]\n" + SequencesKt.w(SequencesKt.p(SequencesKt.o(StringsKt.x0(substring), 1), new Function1() { // from class: vj.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean f11;
                f11 = d.f((String) obj);
                return Boolean.valueOf(f11);
            }
        }), "\n", null, null, 0, null, null, 62, null), 1500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(String line) {
        Intrinsics.h(line, "line");
        String obj = StringsKt.s1(line).toString();
        return StringsKt.W(obj, "at ", false, 2, null) || StringsKt.W(obj, "- ", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context) {
        Object m1185constructorimpl;
        d dVar = f77456a;
        try {
            Result.Companion companion = Result.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            dVar.d(applicationContext);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "AppExitMonitor", "AppExitMonitor init failed: " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
    }

    public final void g(final Context context) {
        Intrinsics.h(context, "context");
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        ConfigBean d11 = f.d(f.f75530c.a(), "app_exit_monitor_enable", false, 2, null);
        if (Intrinsics.c(d11 != null ? d11.getValue() : null, "false")) {
            return;
        }
        ThreadUtils.f().execute(new Runnable() { // from class: vj.b
            @Override // java.lang.Runnable
            public final void run() {
                d.h(context);
            }
        });
    }
}
