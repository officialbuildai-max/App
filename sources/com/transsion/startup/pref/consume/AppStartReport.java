package com.transsion.startup.pref.consume;

import android.app.ActivityManager;
import android.app.Application;
import android.os.SystemClock;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.miniapp.bridge.BluetoothBridge;
import com.transsion.baselib.report.h;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import my.f;

/* loaded from: classes.dex */
public final class AppStartReport {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f54572b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f54573c;

    /* renamed from: a, reason: collision with root package name */
    public static final AppStartReport f54571a = new AppStartReport();

    /* renamed from: d, reason: collision with root package name */
    private static final Map f54574d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final List f54575e = new ArrayList();

    private AppStartReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map g() {
        long j11;
        try {
            Result.Companion companion = Result.INSTANCE;
            HashMap hashMap = new HashMap();
            Map map = f54574d;
            AppStartDotState appStartDotState = (AppStartDotState) map.get(AppStartDotState.APP_START);
            AppStartDotState appStartDotState2 = (AppStartDotState) map.get(AppStartDotState.APP_END);
            AppStartDotState appStartDotState3 = (AppStartDotState) map.get(AppStartDotState.MAIN_CREATE);
            AppStartDotState appStartDotState4 = (AppStartDotState) map.get(AppStartDotState.TRENDING_END);
            long timestamp = appStartDotState3 != null ? appStartDotState3.getTimestamp() - (appStartDotState2 != null ? appStartDotState2.getTimestamp() : appStartDotState3.getTimestamp()) : 0L;
            String str = ((appStartDotState2 != null ? appStartDotState2.getTimestamp() : 0L) <= 0 || timestamp > 10000 || timestamp <= 0) ? "warm" : "cold";
            if (Intrinsics.c(str, "warm")) {
                j11 = appStartDotState4 != null ? appStartDotState4.getTimestamp() - (appStartDotState3 != null ? appStartDotState3.getTimestamp() : appStartDotState4.getTimestamp()) : 0L;
                hashMap.put("act_app_gap", "0");
            } else {
                long timestamp2 = appStartDotState4 != null ? appStartDotState4.getTimestamp() - (appStartDotState != null ? appStartDotState.getTimestamp() : appStartDotState4.getTimestamp()) : 0L;
                hashMap.put("act_app_gap", String.valueOf(timestamp));
                j11 = timestamp2;
            }
            if (j11 <= 0) {
                return null;
            }
            hashMap.put("total_time", String.valueOf(j11));
            hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, h.f43402a.e());
            hashMap.put("model", str);
            ih.b bVar = ih.b.f65364a;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            ActivityManager.MemoryInfo k11 = bVar.k(a11);
            hashMap.put("mem_size", String.valueOf(k11.totalMem));
            hashMap.put("low_memory", String.valueOf(k11.lowMemory));
            Iterator it = DownloadSDCardUtil.f60017a.b().iterator();
            long j12 = 0;
            while (it.hasNext()) {
                j12 += ((f) it.next()).a();
            }
            hashMap.put(BluetoothBridge.EXTEA_AVALIABLE, String.valueOf(j12));
            hashMap.put("cpu_size", String.valueOf(Runtime.getRuntime().availableProcessors()));
            boolean z10 = f54573c;
            if (z10) {
                hashMap.put("first_open", String.valueOf(z10));
            }
            final long timestamp3 = appStartDotState != null ? appStartDotState.getTimestamp() : 0L;
            Function1 function1 = new Function1() { // from class: com.transsion.startup.pref.consume.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long h11;
                    h11 = AppStartReport.h(timestamp3, (String) obj);
                    return Long.valueOf(h11);
                }
            };
            hashMap.put(AppStartDotState.APP_START, "0");
            hashMap.put(AppStartDotState.APP_END, String.valueOf(((Number) function1.invoke(AppStartDotState.APP_END)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.SPLASH_START, String.valueOf(((Number) function1.invoke(AppStartDotState.SPLASH_START)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.SPLASH_RESUME, String.valueOf(((Number) function1.invoke(AppStartDotState.SPLASH_RESUME)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.AD_LOADING, String.valueOf(((Number) function1.invoke(AppStartDotState.AD_LOADING)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.AD_END, String.valueOf(((Number) function1.invoke(AppStartDotState.AD_END)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.AD_RENDERING, String.valueOf(((Number) function1.invoke(AppStartDotState.AD_RENDERING)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.MAIN_CREATE, String.valueOf(((Number) function1.invoke(AppStartDotState.MAIN_CREATE)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.TRENDING_CREATE, String.valueOf(((Number) function1.invoke(AppStartDotState.TRENDING_CREATE)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.TRENDING_RENDER, String.valueOf(((Number) function1.invoke(AppStartDotState.TRENDING_RENDER)).longValue() - timestamp3));
            hashMap.put(AppStartDotState.TRENDING_END, String.valueOf(((Number) function1.invoke(AppStartDotState.TRENDING_END)).longValue() - timestamp3));
            for (Pair pair : f54575e) {
                hashMap.put("trace_" + ((String) pair.component1()), String.valueOf(((Number) pair.component2()).longValue() - timestamp3));
            }
            return hashMap;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            if (Result.m1188exceptionOrNullimpl(Result.m1185constructorimpl(ResultKt.a(th2))) == null) {
                throw new KotlinNothingValueException();
            }
            f54571a.i("error error error --- failed to obtain device information");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h(long j11, String dot) {
        Intrinsics.h(dot, "dot");
        AppStartDotState appStartDotState = (AppStartDotState) f54574d.get(dot);
        return appStartDotState != null ? appStartDotState.getTimestamp() : j11;
    }

    private final void i(String str) {
        Log.w("zxb_log_dot", str);
    }

    public final void f(AppStartDotState dot) {
        Intrinsics.h(dot, "dot");
        if (f54572b) {
            return;
        }
        Map map = f54574d;
        if (map.containsKey(dot.getState())) {
            return;
        }
        map.put(dot.getState(), dot);
        if (Intrinsics.c(dot.getState(), AppStartDotState.MAIN_CREATE)) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            f54573c = bVar.b().getBoolean("first_open", true);
            bVar.b().putBoolean("first_open", false);
        } else if (Intrinsics.c(dot.getState(), AppStartDotState.TRENDING_END)) {
            j();
        }
    }

    public final void j() {
        if (f54572b) {
            return;
        }
        k.d(o0.a(y0.b()), null, null, new AppStartReport$report$1(null), 3, null);
    }

    public final void k() {
        f54572b = false;
    }

    public final void l(String name) {
        Intrinsics.h(name, "name");
        if (f54572b) {
            return;
        }
        f54575e.add(TuplesKt.a(name, Long.valueOf(SystemClock.elapsedRealtime())));
    }
}
