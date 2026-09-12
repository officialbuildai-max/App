package y8;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import z8.u;

/* loaded from: classes4.dex */
public final class i implements u8.b {

    /* renamed from: a, reason: collision with root package name */
    private final uz.a f79067a;

    /* renamed from: b, reason: collision with root package name */
    private final uz.a f79068b;

    /* renamed from: c, reason: collision with root package name */
    private final uz.a f79069c;

    /* renamed from: d, reason: collision with root package name */
    private final uz.a f79070d;

    public i(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4) {
        this.f79067a = aVar;
        this.f79068b = aVar2;
        this.f79069c = aVar3;
        this.f79070d = aVar4;
    }

    public static i a(uz.a aVar, uz.a aVar2, uz.a aVar3, uz.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static u c(Context context, a9.d dVar, SchedulerConfig schedulerConfig, c9.a aVar) {
        return (u) u8.d.d(h.a(context, dVar, schedulerConfig, aVar));
    }

    @Override // uz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((Context) this.f79067a.get(), (a9.d) this.f79068b.get(), (SchedulerConfig) this.f79069c.get(), (c9.a) this.f79070d.get());
    }
}
