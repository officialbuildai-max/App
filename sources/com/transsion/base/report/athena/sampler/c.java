package com.transsion.base.report.athena.sampler;

import android.os.Bundle;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f43064a = new c();

    private c() {
    }

    public final Bundle a(Bundle bundle) {
        Intrinsics.h(bundle, "<this>");
        Bundle bundle2 = new Bundle();
        for (String str : bundle.keySet()) {
            bundle2.putString(str, bundle.getString(str));
        }
        return bundle2;
    }

    public final boolean b(String event, Bundle bundle, String deviceId) {
        Intrinsics.h(event, "event");
        Intrinsics.h(bundle, "bundle");
        Intrinsics.h(deviceId, "deviceId");
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "sampler", "ReportInterception --> intercept() --> 开始处理埋点拦截逻辑 --> event = " + event, false, 4, null);
        Triple a11 = a.f43062a.a(event, a(bundle));
        boolean z10 = false;
        if (Intrinsics.c(a11.getFirst(), Boolean.TRUE)) {
            a.C0856a.f(c0856a, "sampler", "ReportInterception --> intercept() --> 事件表达式 命中 --> 下一步采样率判断", false, 4, null);
            b bVar = b.f43063a;
            double intValue = ((Integer) a11.getSecond()) != null ? r4.intValue() : 100.0d;
            String str = (String) a11.getThird();
            if (str == null) {
                str = "";
            }
            boolean a12 = bVar.a(intValue, deviceId, str, 100);
            a.C0856a.f(c0856a, "sampler", "ReportInterception --> intercept() --> 采样率命中 = " + a12, false, 4, null);
            if (a12) {
                bundle.putString("sampling_rate", String.valueOf(a11.getSecond()));
                EventConfig eventConfig = EventConfig.f43057a;
                eventConfig.i(event);
                eventConfig.h(event);
            } else {
                if (Intrinsics.a(((Integer) a11.getSecond()) != null ? Double.valueOf(r3.intValue()) : null, 0.0d)) {
                    EventConfig.f43057a.a(event);
                } else {
                    EventConfig.f43057a.b(event);
                }
            }
            if (!a12) {
                z10 = true;
            }
        } else {
            a.C0856a.f(c0856a, "sampler", "ReportInterception --> intercept() --> 事件表达式 没有命中 --> 不需要处理采样率 --> 直接上报埋点 --> event = " + event, false, 4, null);
        }
        if (z10) {
            a.C0856a.f(c0856a, "sampler", "埋点拒绝上报 --> event = " + event, false, 4, null);
        } else {
            EventConfig eventConfig2 = EventConfig.f43057a;
            bundle.putString("close_event", eventConfig2.c().toString());
            bundle.putString("miss_event", eventConfig2.d().toString());
            a.C0856a.f(c0856a, "sampler", "track: 日志上报 --> bundle = " + bundle, false, 4, null);
        }
        return z10;
    }
}
