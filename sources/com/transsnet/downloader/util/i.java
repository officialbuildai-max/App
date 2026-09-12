package com.transsnet.downloader.util;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    private static long f60064c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f60065d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f60066e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f60067f;

    /* renamed from: a, reason: collision with root package name */
    public static final i f60062a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static String f60063b = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f60068g = "";

    /* renamed from: h, reason: collision with root package name */
    private static final ConcurrentHashMap f60069h = new ConcurrentHashMap();

    private i() {
    }

    public final Map a() {
        if (f60065d) {
            c(PrepareException.ERROR_NO_URL);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ConcurrentHashMap concurrentHashMap = f60069h;
        linkedHashMap.putAll(concurrentHashMap);
        concurrentHashMap.clear();
        f60066e = false;
        f60067f = false;
        return linkedHashMap;
    }

    public final void b(String step) {
        Intrinsics.h(step, "step");
        if (f60065d && !Intrinsics.c(f60068g, step)) {
            if (Intrinsics.c(step, "4")) {
                if (f60066e) {
                    return;
                } else {
                    f60066e = true;
                }
            }
            if (Intrinsics.c(step, "3")) {
                if (f60067f) {
                    return;
                } else {
                    f60067f = true;
                }
            }
            f60068g = step;
            a.C0856a.f(lg.a.f68962a, "DownloadProxyLog", "logPoint, step = " + step, false, 4, null);
            long currentTimeMillis = System.currentTimeMillis();
            f60069h.put("delay_step_" + f60063b + "_" + step, Long.valueOf(currentTimeMillis - f60064c));
            f60063b = step;
            f60064c = currentTimeMillis;
        }
    }

    public final void c(String step) {
        Intrinsics.h(step, "step");
        a.C0856a.v(lg.a.f68962a, "DownloadProxyLog", "onFinish, step = " + step, false, 4, null);
        b(step);
        f60065d = false;
        f60064c = 0L;
    }

    public final void d(String step) {
        Intrinsics.h(step, "step");
        a.C0856a.v(lg.a.f68962a, "DownloadProxyLog", "onStart, step = " + step, false, 4, null);
        f60065d = true;
        f60063b = step;
        f60064c = System.currentTimeMillis();
        f60069h.clear();
    }
}
