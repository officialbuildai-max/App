package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref;

/* loaded from: classes7.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f68070b = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f68071c = AtomicIntegerFieldUpdater.newUpdater(i.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f68072d = AtomicIntegerFieldUpdater.newUpdater(i.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f68073e = AtomicIntegerFieldUpdater.newUpdater(i.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray f68074a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    private final Task b(Task task) {
        if (e() == 127) {
            return task;
        }
        if (task.taskContext) {
            f68073e.incrementAndGet(this);
        }
        int i11 = f68071c.get(this) & 127;
        while (this.f68074a.get(i11) != null) {
            Thread.yield();
        }
        this.f68074a.lazySet(i11, task);
        f68071c.incrementAndGet(this);
        return null;
    }

    private final void c(Task task) {
        if (task == null || !task.taskContext) {
            return;
        }
        f68073e.decrementAndGet(this);
    }

    private final int e() {
        return f68071c.get(this) - f68072d.get(this);
    }

    private final Task m() {
        Task task;
        while (true) {
            int i11 = f68072d.get(this);
            if (i11 - f68071c.get(this) == 0) {
                return null;
            }
            int i12 = i11 & 127;
            if (f68072d.compareAndSet(this, i11, i11 + 1) && (task = (Task) this.f68074a.getAndSet(i12, null)) != null) {
                c(task);
                return task;
            }
        }
    }

    private final boolean o(c cVar) {
        Task m11 = m();
        if (m11 == null) {
            return false;
        }
        cVar.a(m11);
        return true;
    }

    private final Task p(boolean z10) {
        Task task;
        do {
            task = (Task) f68070b.get(this);
            if (task == null || task.taskContext != z10) {
                int i11 = f68072d.get(this);
                int i12 = f68071c.get(this);
                while (i11 != i12) {
                    if (z10 && f68073e.get(this) == 0) {
                        return null;
                    }
                    i12--;
                    Task r11 = r(i12, z10);
                    if (r11 != null) {
                        return r11;
                    }
                }
                return null;
            }
        } while (!androidx.concurrent.futures.a.a(f68070b, this, task, null));
        return task;
    }

    private final Task q(int i11) {
        int i12 = f68072d.get(this);
        int i13 = f68071c.get(this);
        boolean z10 = i11 == 1;
        while (i12 != i13) {
            if (z10 && f68073e.get(this) == 0) {
                return null;
            }
            int i14 = i12 + 1;
            Task r11 = r(i12, z10);
            if (r11 != null) {
                return r11;
            }
            i12 = i14;
        }
        return null;
    }

    private final Task r(int i11, boolean z10) {
        int i12 = i11 & 127;
        Task task = (Task) this.f68074a.get(i12);
        if (task == null || task.taskContext != z10 || !kotlinx.coroutines.channels.i.a(this.f68074a, i12, task, null)) {
            return null;
        }
        if (z10) {
            f68073e.decrementAndGet(this);
        }
        return task;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, kotlinx.coroutines.scheduling.Task, java.lang.Object] */
    private final long t(int i11, Ref.ObjectRef objectRef) {
        ?? r02;
        do {
            r02 = (Task) f68070b.get(this);
            if (r02 == 0) {
                return -2L;
            }
            if (((r02.taskContext ? 1 : 2) & i11) == 0) {
                return -2L;
            }
            long a11 = g.f68068f.a() - r02.submissionTime;
            long j11 = g.f68064b;
            if (a11 < j11) {
                return j11 - a11;
            }
        } while (!androidx.concurrent.futures.a.a(f68070b, this, r02, null));
        objectRef.element = r02;
        return -1L;
    }

    public final Task a(Task task, boolean z10) {
        if (z10) {
            return b(task);
        }
        Task task2 = (Task) f68070b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final int i() {
        return f68070b.get(this) != null ? e() + 1 : e();
    }

    public final void j(c cVar) {
        Task task = (Task) f68070b.getAndSet(this, null);
        if (task != null) {
            cVar.a(task);
        }
        do {
        } while (o(cVar));
    }

    public final Task k() {
        Task task = (Task) f68070b.getAndSet(this, null);
        return task == null ? m() : task;
    }

    public final Task l() {
        return p(true);
    }

    public final Task n() {
        return p(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long s(int i11, Ref.ObjectRef objectRef) {
        T m11 = i11 == 3 ? m() : q(i11);
        if (m11 == 0) {
            return t(i11, objectRef);
        }
        objectRef.element = m11;
        return -1L;
    }
}
