package com.google.firebase.perf.metrics;

import com.google.firebase.perf.util.Timer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import vc.k;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: f, reason: collision with root package name */
    private static final sc.a f32349f = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final i f32350a;

    /* renamed from: b, reason: collision with root package name */
    private final Timer f32351b;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32354e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32353d = false;

    /* renamed from: c, reason: collision with root package name */
    private final Map f32352c = new ConcurrentHashMap();

    public h(String str, String str2, k kVar, Timer timer) {
        this.f32354e = false;
        this.f32351b = timer;
        i f11 = i.b(kVar).q(str).f(str2);
        this.f32350a = f11;
        f11.h();
        if (com.google.firebase.perf.config.a.g().K()) {
            return;
        }
        f32349f.g("HttpMetric feature is disabled. URL %s", str);
        this.f32354e = true;
    }

    public void a(int i11) {
        this.f32350a.g(i11);
    }
}
