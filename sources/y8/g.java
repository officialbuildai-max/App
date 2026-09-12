package y8;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* loaded from: classes4.dex */
public final class g implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f79066a;

    public g(uz.a aVar) {
        this.f79066a = aVar;
    }

    public static SchedulerConfig a(c9.a aVar) {
        return (SchedulerConfig) u8.d.d(f.a(aVar));
    }

    public static g b(uz.a aVar) {
        return new g(aVar);
    }

    @Override // uz.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a((c9.a) this.f79066a.get());
    }
}
