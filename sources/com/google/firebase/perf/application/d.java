package com.google.firebase.perf.application;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.core.app.g;
import androidx.fragment.app.Fragment;
import com.google.firebase.perf.metrics.g;
import com.google.firebase.perf.util.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private static final sc.a f32274e = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final Activity f32275a;

    /* renamed from: b, reason: collision with root package name */
    private final g f32276b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f32277c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32278d;

    public d(Activity activity) {
        this(activity, new g(), new HashMap());
    }

    d(Activity activity, g gVar, Map map) {
        this.f32278d = false;
        this.f32275a = activity;
        this.f32276b = gVar;
        this.f32277c = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return true;
    }

    private e b() {
        if (!this.f32278d) {
            f32274e.a("No recording has been started.");
            return e.a();
        }
        SparseIntArray[] b11 = this.f32276b.b();
        if (b11 == null) {
            f32274e.a("FrameMetricsAggregator.mMetrics is uninitialized.");
            return e.a();
        }
        if (b11[0] != null) {
            return e.e(com.google.firebase.perf.metrics.g.a(b11));
        }
        f32274e.a("FrameMetricsAggregator.mMetrics[TOTAL_INDEX] is uninitialized.");
        return e.a();
    }

    public void c() {
        if (this.f32278d) {
            f32274e.b("FrameMetricsAggregator is already recording %s", this.f32275a.getClass().getSimpleName());
        } else {
            this.f32276b.a(this.f32275a);
            this.f32278d = true;
        }
    }

    public void d(Fragment fragment) {
        if (!this.f32278d) {
            f32274e.a("Cannot start sub-recording because FrameMetricsAggregator is not recording");
            return;
        }
        if (this.f32277c.containsKey(fragment)) {
            f32274e.b("Cannot start sub-recording because one is already ongoing with the key %s", fragment.getClass().getSimpleName());
            return;
        }
        e b11 = b();
        if (b11.d()) {
            this.f32277c.put(fragment, (g.a) b11.c());
        } else {
            f32274e.b("startFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
        }
    }

    public e e() {
        if (!this.f32278d) {
            f32274e.a("Cannot stop because no recording was started");
            return e.a();
        }
        if (!this.f32277c.isEmpty()) {
            f32274e.a("Sub-recordings are still ongoing! Sub-recordings should be stopped first before stopping Activity screen trace.");
            this.f32277c.clear();
        }
        e b11 = b();
        try {
            this.f32276b.c(this.f32275a);
        } catch (IllegalArgumentException | NullPointerException e11) {
            if ((e11 instanceof NullPointerException) && Build.VERSION.SDK_INT > 28) {
                throw e11;
            }
            f32274e.k("View not hardware accelerated. Unable to collect FrameMetrics. %s", e11.toString());
            b11 = e.a();
        }
        this.f32276b.d();
        this.f32278d = false;
        return b11;
    }

    public e f(Fragment fragment) {
        if (!this.f32278d) {
            f32274e.a("Cannot stop sub-recording because FrameMetricsAggregator is not recording");
            return e.a();
        }
        if (!this.f32277c.containsKey(fragment)) {
            f32274e.b("Sub-recording associated with key %s was not started or does not exist", fragment.getClass().getSimpleName());
            return e.a();
        }
        g.a aVar = (g.a) this.f32277c.remove(fragment);
        e b11 = b();
        if (b11.d()) {
            return e.e(((g.a) b11.c()).a(aVar));
        }
        f32274e.b("stopFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
        return e.a();
    }
}
