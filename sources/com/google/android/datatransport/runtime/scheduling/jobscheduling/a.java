package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Map;

/* loaded from: classes3.dex */
final class a extends SchedulerConfig {

    /* renamed from: a, reason: collision with root package name */
    private final c9.a f24477a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f24478b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c9.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f24477a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f24478b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    c9.a e() {
        return this.f24477a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f24477a.equals(schedulerConfig.e()) && this.f24478b.equals(schedulerConfig.h());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map h() {
        return this.f24478b;
    }

    public int hashCode() {
        return ((this.f24477a.hashCode() ^ 1000003) * 1000003) ^ this.f24478b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f24477a + ", values=" + this.f24478b + "}";
    }
}
