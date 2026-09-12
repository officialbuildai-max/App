package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes7.dex */
public final class d extends Scheduler {

    /* renamed from: d, reason: collision with root package name */
    private static final RxThreadFactory f65641d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.newthread-priority", 5).intValue())));

    /* renamed from: c, reason: collision with root package name */
    final ThreadFactory f65642c;

    public d() {
        this(f65641d);
    }

    public d(ThreadFactory threadFactory) {
        this.f65642c = threadFactory;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker c() {
        return new e(this.f65642c);
    }
}
