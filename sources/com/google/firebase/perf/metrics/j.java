package com.google.firebase.perf.metrics;

import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.v1.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Trace f32364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Trace trace) {
        this.f32364a = trace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.perf.v1.i a() {
        i.b q11 = com.google.firebase.perf.v1.i.M().r(this.f32364a.getName()).p(this.f32364a.getStartTime().getMicros()).q(this.f32364a.getStartTime().getDurationMicros(this.f32364a.getEndTime()));
        for (Counter counter : this.f32364a.getCounters().values()) {
            q11.n(counter.getName(), counter.getCount());
        }
        List<Trace> subtraces = this.f32364a.getSubtraces();
        if (!subtraces.isEmpty()) {
            Iterator<Trace> it = subtraces.iterator();
            while (it.hasNext()) {
                q11.k(new j(it.next()).a());
            }
        }
        q11.m(this.f32364a.getAttributes());
        com.google.firebase.perf.v1.h[] buildAndSort = PerfSession.buildAndSort(this.f32364a.getSessions());
        if (buildAndSort != null) {
            q11.d(Arrays.asList(buildAndSort));
        }
        return (com.google.firebase.perf.v1.i) q11.build();
    }
}
