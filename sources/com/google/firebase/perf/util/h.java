package com.google.firebase.perf.util;

import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.g;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final sc.a f32432a = sc.a.e();

    public static Trace a(Trace trace, g.a aVar) {
        if (aVar.d() > 0) {
            trace.putMetric(Constants$CounterNames.FRAMES_TOTAL.toString(), aVar.d());
        }
        if (aVar.c() > 0) {
            trace.putMetric(Constants$CounterNames.FRAMES_SLOW.toString(), aVar.c());
        }
        if (aVar.b() > 0) {
            trace.putMetric(Constants$CounterNames.FRAMES_FROZEN.toString(), aVar.b());
        }
        f32432a.a("Screen trace: " + trace.getName() + " _fr_tot:" + aVar.d() + " _fr_slo:" + aVar.c() + " _fr_fzn:" + aVar.b());
        return trace;
    }
}
