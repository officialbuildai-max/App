package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes3.dex */
final class b extends SchedulerConfig.b {

    /* renamed from: a, reason: collision with root package name */
    private final long f24479a;

    /* renamed from: b, reason: collision with root package name */
    private final long f24480b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f24481c;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0363b extends SchedulerConfig.b.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f24482a;

        /* renamed from: b, reason: collision with root package name */
        private Long f24483b;

        /* renamed from: c, reason: collision with root package name */
        private Set f24484c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f24482a == null) {
                str = " delta";
            }
            if (this.f24483b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f24484c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f24482a.longValue(), this.f24483b.longValue(), this.f24484c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j11) {
            this.f24482a = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f24484c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j11) {
            this.f24483b = Long.valueOf(j11);
            return this;
        }
    }

    private b(long j11, long j12, Set set) {
        this.f24479a = j11;
        this.f24480b = j12;
        this.f24481c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long b() {
        return this.f24479a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    Set c() {
        return this.f24481c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long d() {
        return this.f24480b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        return this.f24479a == bVar.b() && this.f24480b == bVar.d() && this.f24481c.equals(bVar.c());
    }

    public int hashCode() {
        long j11 = this.f24479a;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003;
        long j12 = this.f24480b;
        return ((i11 ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f24481c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f24479a + ", maxAllowedDelay=" + this.f24480b + ", flags=" + this.f24481c + "}";
    }
}
