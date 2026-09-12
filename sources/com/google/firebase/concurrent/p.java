package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class p extends AbstractResolvableFuture implements ScheduledFuture {

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledFuture f31181h;

    /* loaded from: classes4.dex */
    class a implements b {
        a() {
        }

        @Override // com.google.firebase.concurrent.p.b
        public void a(Throwable th2) {
            p.this.v(th2);
        }

        @Override // com.google.firebase.concurrent.p.b
        public void set(Object obj) {
            p.this.u(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void a(Throwable th2);

        void set(Object obj);
    }

    /* loaded from: classes4.dex */
    interface c {
        ScheduledFuture a(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.f31181h = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f31181h.compareTo(delayed);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    protected void d() {
        this.f31181h.cancel(x());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f31181h.getDelay(timeUnit);
    }
}
