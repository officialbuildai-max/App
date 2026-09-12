package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class SchedulerConfig {

    /* loaded from: classes.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private c9.a f24475a;

        /* renamed from: b, reason: collision with root package name */
        private Map f24476b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.f24476b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f24475a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f24476b.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map map = this.f24476b;
            this.f24476b = new HashMap();
            return SchedulerConfig.d(this.f24475a, map);
        }

        public a c(c9.a aVar) {
            this.f24475a = aVar;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {

        /* loaded from: classes3.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j11);

            public abstract a c(Set set);

            public abstract a d(long j11);
        }

        public static a a() {
            return new b.C0363b().c(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    private long a(int i11, long j11) {
        return (long) (Math.pow(3.0d, i11 - 1) * j11 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j11 > 1 ? j11 : 2L) * r7)));
    }

    public static a b() {
        return new a();
    }

    static SchedulerConfig d(c9.a aVar, Map map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(aVar, map);
    }

    public static SchedulerConfig f(c9.a aVar) {
        return b().a(Priority.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(Flag.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static Set i(Object... objArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j11, int i11) {
        builder.setMinimumLatency(g(priority, j11, i11));
        j(builder, ((b) h().get(priority)).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract c9.a e();

    public long g(Priority priority, long j11, int i11) {
        long time = j11 - e().getTime();
        b bVar = (b) h().get(priority);
        return Math.min(Math.max(a(i11, bVar.b()), time), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map h();
}
