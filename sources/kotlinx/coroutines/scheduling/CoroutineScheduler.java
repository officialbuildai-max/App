package kotlinx.coroutines.scheduling;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.p0;

/* loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final a f68041h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f68042i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f68043j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f68044k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final z f68045l = new z("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f68046a;

    /* renamed from: b, reason: collision with root package name */
    public final int f68047b;

    /* renamed from: c, reason: collision with root package name */
    public final long f68048c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final String f68049d;

    /* renamed from: e, reason: collision with root package name */
    public final c f68050e;

    /* renamed from: f, reason: collision with root package name */
    public final c f68051f;

    /* renamed from: g, reason: collision with root package name */
    public final u f68052g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u0016J\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fJ\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0007¢\u0006\u0004\b(\u0010\tJ\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u0007¢\u0006\u0004\b-\u0010\u001aR*\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010F\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010/R\u0016\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010GR\u0012\u0010K\u001a\u00020H8Æ\u0002¢\u0006\u0006\u001a\u0004\bI\u0010JR\b\u0010M\u001a\u00020L8\u0006¨\u0006N"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "", "index", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "", "tryAcquireCpuPermit", "()Z", "", "runWorker", "()V", "tryPark", "inStack", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", PlaceTypes.PARK, "tryTerminateWorker", "findBlockingTask", "()Lkotlinx/coroutines/scheduling/Task;", "findCpuTask", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "pollGlobalQueues", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "trySteal", "(I)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "", "runSingleTask", "()J", "isIo", "upperBound", "nextInt", "(I)I", "mayHaveLocalTasks", "findTask", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "Lkotlinx/coroutines/scheduling/i;", "localQueue", "Lkotlinx/coroutines/scheduling/i;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @SourceDebugExtension
    /* loaded from: classes.dex */
    public final class Worker extends Thread {
        private static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        private volatile int indexInArray;

        @JvmField
        public final i localQueue;

        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;

        @JvmField
        public WorkerState state;
        private final Ref.ObjectRef<Task> stolenTask;
        private long terminationDeadline;
        private volatile /* synthetic */ int workerCtl$volatile;

        private Worker() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new i();
            this.stolenTask = new Ref.ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f68045l;
            int nanoTime = (int) System.nanoTime();
            this.rngState = nanoTime == 0 ? 42 : nanoTime;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i11) {
            this();
            setIndexInArray(i11);
        }

        private final void executeTask(Task task) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
            if (!task.taskContext) {
                CoroutineScheduler.this.w(task);
                return;
            }
            if (tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.U();
            }
            CoroutineScheduler.this.w(task);
            CoroutineScheduler.d().addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        private final Task findAnyTask(boolean scanLocalQueue) {
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (scanLocalQueue) {
                boolean z10 = nextInt(CoroutineScheduler.this.f68046a * 2) == 0;
                if (z10 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task k11 = this.localQueue.k();
                if (k11 != null) {
                    return k11;
                }
                if (!z10 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                    return pollGlobalQueues;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(3);
        }

        private final Task findBlockingTask() {
            Task l11 = this.localQueue.l();
            if (l11 != null) {
                return l11;
            }
            Task task = (Task) CoroutineScheduler.this.f68051f.e();
            return task == null ? trySteal(1) : task;
        }

        private final Task findCpuTask() {
            Task n11 = this.localQueue.n();
            if (n11 != null) {
                return n11;
            }
            Task task = (Task) CoroutineScheduler.this.f68051f.e();
            return task == null ? trySteal(2) : task;
        }

        private final /* synthetic */ int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.f68045l;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.f68048c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f68048c);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.f68050e.e();
                return task != null ? task : (Task) CoroutineScheduler.this.f68051f.e();
            }
            Task task2 = (Task) CoroutineScheduler.this.f68051f.e();
            return task2 != null ? task2 : (Task) CoroutineScheduler.this.f68050e.e();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (z10) {
                            tryReleaseCpu(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final /* synthetic */ void setWorkerCtl$volatile(int i11) {
            this.workerCtl$volatile = i11;
        }

        private final boolean tryAcquireCpuPermit() {
            long j11;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater d11 = CoroutineScheduler.d();
            do {
                j11 = d11.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j11) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.d().compareAndSet(coroutineScheduler, j11, j11 - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.u(this);
                return;
            }
            workerCtl$volatile$FU.set(this, -1);
            while (inStack() && workerCtl$volatile$FU.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(int stealingMode) {
            int i11 = (int) (CoroutineScheduler.d().get(CoroutineScheduler.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int nextInt = nextInt(i11);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j11 = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                nextInt++;
                if (nextInt > i11) {
                    nextInt = 1;
                }
                Worker worker = (Worker) coroutineScheduler.f68052g.b(nextInt);
                if (worker != null && worker != this) {
                    long s11 = worker.localQueue.s(stealingMode, this.stolenTask);
                    if (s11 == -1) {
                        Ref.ObjectRef<Task> objectRef = this.stolenTask;
                        Task task = objectRef.element;
                        objectRef.element = null;
                        return task;
                    }
                    if (s11 > 0) {
                        j11 = Math.min(j11, s11);
                    }
                }
            }
            if (j11 == Long.MAX_VALUE) {
                j11 = 0;
            }
            this.minDelayUntilStealableTaskNs = j11;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f68052g) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.d().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f68046a) {
                        return;
                    }
                    if (workerCtl$volatile$FU.compareAndSet(this, -1, 1)) {
                        int i11 = this.indexInArray;
                        setIndexInArray(0);
                        coroutineScheduler.v(this, i11, 0);
                        int andDecrement = (int) (CoroutineScheduler.d().getAndDecrement(coroutineScheduler) & 2097151);
                        if (andDecrement != i11) {
                            Object b11 = coroutineScheduler.f68052g.b(andDecrement);
                            Intrinsics.e(b11);
                            Worker worker = (Worker) b11;
                            coroutineScheduler.f68052g.c(i11, worker);
                            worker.setIndexInArray(i11);
                            coroutineScheduler.v(worker, andDecrement, i11);
                        }
                        coroutineScheduler.f68052g.c(andDecrement, null);
                        Unit unit = Unit.f67184a;
                        this.state = WorkerState.TERMINATED;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final Task findTask(boolean mayHaveLocalTasks) {
            return tryAcquireCpuPermit() ? findAnyTask(mayHaveLocalTasks) : findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final boolean isIo() {
            return this.state == WorkerState.BLOCKING;
        }

        public final int nextInt(int upperBound) {
            int i11 = this.rngState;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.rngState = i14;
            int i15 = upperBound - 1;
            return (i15 & upperBound) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % upperBound;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final long runSingleTask() {
            boolean z10 = this.state == WorkerState.CPU_ACQUIRED;
            Task findCpuTask = z10 ? findCpuTask() : findBlockingTask();
            if (findCpuTask == null) {
                long j11 = this.minDelayUntilStealableTaskNs;
                if (j11 == 0) {
                    return -1L;
                }
                return j11;
            }
            CoroutineScheduler.this.w(findCpuTask);
            if (!z10) {
                CoroutineScheduler.d().addAndGet(CoroutineScheduler.this, -2097152L);
            }
            return 0L;
        }

        public final void setIndexInArray(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f68049d);
            sb2.append("-worker-");
            sb2.append(i11 == 0 ? "TERMINATED" : String.valueOf(i11));
            setName(sb2.toString());
            this.indexInArray = i11;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState newState) {
            WorkerState workerState = this.state;
            boolean z10 = workerState == WorkerState.CPU_ACQUIRED;
            if (z10) {
                CoroutineScheduler.d().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z10;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    public static final class WorkerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WorkerState[] $VALUES;
        public static final WorkerState CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
        public static final WorkerState BLOCKING = new WorkerState("BLOCKING", 1);
        public static final WorkerState PARKING = new WorkerState("PARKING", 2);
        public static final WorkerState DORMANT = new WorkerState("DORMANT", 3);
        public static final WorkerState TERMINATED = new WorkerState("TERMINATED", 4);

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        static {
            WorkerState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private WorkerState(String str, int i11) {
        }

        public static EnumEntries<WorkerState> getEntries() {
            return $ENTRIES;
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f68053a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f68053a = iArr;
        }
    }

    public CoroutineScheduler(int i11, int i12, long j11, String str) {
        this.f68046a = i11;
        this.f68047b = i12;
        this.f68048c = j11;
        this.f68049d = str;
        if (i11 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i11 + " should be at least 1").toString());
        }
        if (i12 < i11) {
            throw new IllegalArgumentException(("Max pool size " + i12 + " should be greater than or equals to core pool size " + i11).toString());
        }
        if (i12 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i12 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j11 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j11 + " must be positive").toString());
        }
        this.f68050e = new c();
        this.f68051f = new c();
        this.f68052g = new u((i11 + 1) * 2);
        this.controlState$volatile = i11 << 42;
        this._isTerminated$volatile = 0;
    }

    private final void T(long j11, boolean z10) {
        if (z10 || c0() || Z(j11)) {
            return;
        }
        c0();
    }

    private final Task V(Worker worker, Task task, boolean z10) {
        WorkerState workerState;
        if (worker == null || (workerState = worker.state) == WorkerState.TERMINATED) {
            return task;
        }
        if (!task.taskContext && workerState == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.a(task, z10);
    }

    private final boolean Z(long j11) {
        if (RangesKt.f(((int) (2097151 & j11)) - ((int) ((j11 & 4398044413952L) >> 21)), 0) < this.f68046a) {
            int k11 = k();
            if (k11 == 1 && this.f68046a > 1) {
                k();
            }
            if (k11 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a0(CoroutineScheduler coroutineScheduler, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = f68043j.get(coroutineScheduler);
        }
        return coroutineScheduler.Z(j11);
    }

    private final boolean c0() {
        Worker t11;
        do {
            t11 = t();
            if (t11 == null) {
                return false;
            }
        } while (!Worker.workerCtl$volatile$FU.compareAndSet(t11, -1, 0));
        LockSupport.unpark(t11);
        return true;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater d() {
        return f68043j;
    }

    private final boolean h(Task task) {
        return task.taskContext ? this.f68051f.a(task) : this.f68050e.a(task);
    }

    private final int k() {
        synchronized (this.f68052g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j11 = f68043j.get(this);
                int i11 = (int) (j11 & 2097151);
                int f11 = RangesKt.f(i11 - ((int) ((j11 & 4398044413952L) >> 21)), 0);
                if (f11 >= this.f68046a) {
                    return 0;
                }
                if (i11 >= this.f68047b) {
                    return 0;
                }
                int i12 = ((int) (d().get(this) & 2097151)) + 1;
                if (i12 <= 0 || this.f68052g.b(i12) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(this, i12);
                this.f68052g.c(i12, worker);
                if (i12 != ((int) (2097151 & f68043j.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i13 = f11 + 1;
                worker.start();
                return i13;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final Worker m() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker == null || !Intrinsics.c(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public static /* synthetic */ void o(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        coroutineScheduler.n(runnable, z10, z11);
    }

    private final int s(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != f68045l) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final Worker t() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f68042i;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.f68052g.b((int) (2097151 & j11));
            if (worker == null) {
                return null;
            }
            long j12 = (2097152 + j11) & (-2097152);
            int s11 = s(worker);
            if (s11 >= 0 && f68042i.compareAndSet(this, j11, s11 | j12)) {
                worker.setNextParkedWorker(f68045l);
                return worker;
            }
        }
    }

    public final void U() {
        if (c0() || a0(this, 0L, 1, null)) {
            return;
        }
        c0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        x(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        o(this, runnable, false, false, 6, null);
    }

    public final boolean isTerminated() {
        return f68044k.get(this) != 0;
    }

    public final Task l(Runnable runnable, boolean z10) {
        long a11 = g.f68068f.a();
        if (!(runnable instanceof Task)) {
            return g.b(runnable, a11, z10);
        }
        Task task = (Task) runnable;
        task.submissionTime = a11;
        task.taskContext = z10;
        return task;
    }

    public final void n(Runnable runnable, boolean z10, boolean z11) {
        kotlinx.coroutines.b bVar;
        bVar = kotlinx.coroutines.c.f67766a;
        if (bVar != null) {
            bVar.d();
        }
        Task l11 = l(runnable, z10);
        boolean z12 = l11.taskContext;
        long addAndGet = z12 ? f68043j.addAndGet(this, 2097152L) : 0L;
        Worker m11 = m();
        Task V = V(m11, l11, z11);
        if (V != null && !h(V)) {
            throw new RejectedExecutionException(this.f68049d + " was terminated");
        }
        boolean z13 = z11 && m11 != null;
        if (z12) {
            T(addAndGet, z13);
        } else {
            if (z13) {
                return;
            }
            U();
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a11 = this.f68052g.a();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 1; i16 < a11; i16++) {
            Worker worker = (Worker) this.f68052g.b(i16);
            if (worker != null) {
                int i17 = worker.localQueue.i();
                int i18 = b.f68053a[worker.state.ordinal()];
                if (i18 == 1) {
                    i13++;
                } else if (i18 == 2) {
                    i12++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i17);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i18 == 3) {
                    i11++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i17);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i18 == 4) {
                    i14++;
                    if (i17 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i17);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (i18 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i15++;
                }
            }
        }
        long j11 = f68043j.get(this);
        return this.f68049d + '@' + p0.b(this) + "[Pool Size {core = " + this.f68046a + ", max = " + this.f68047b + "}, Worker States {CPU = " + i11 + ", blocking = " + i12 + ", parked = " + i13 + ", dormant = " + i14 + ", terminated = " + i15 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f68050e.c() + ", global blocking queue size = " + this.f68051f.c() + ", Control State {created workers= " + ((int) (2097151 & j11)) + ", blocking tasks = " + ((int) ((4398044413952L & j11) >> 21)) + ", CPUs acquired = " + (this.f68046a - ((int) ((9223367638808264704L & j11) >> 42))) + "}]";
    }

    public final boolean u(Worker worker) {
        long j11;
        int indexInArray;
        if (worker.getNextParkedWorker() != f68045l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f68042i;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.f68052g.b((int) (2097151 & j11)));
        } while (!f68042i.compareAndSet(this, j11, ((2097152 + j11) & (-2097152)) | indexInArray));
        return true;
    }

    public final void v(Worker worker, int i11, int i12) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f68042i;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            int i13 = (int) (2097151 & j11);
            long j12 = (2097152 + j11) & (-2097152);
            if (i13 == i11) {
                i13 = i12 == 0 ? s(worker) : i12;
            }
            if (i13 >= 0 && f68042i.compareAndSet(this, j11, j12 | i13)) {
                return;
            }
        }
    }

    public final void w(Task task) {
        kotlinx.coroutines.b bVar;
        kotlinx.coroutines.b bVar2;
        try {
            task.run();
        } catch (Throwable th2) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
                bVar2 = kotlinx.coroutines.c.f67766a;
                if (bVar2 == null) {
                }
            } finally {
                bVar = kotlinx.coroutines.c.f67766a;
                if (bVar != null) {
                    bVar.e();
                }
            }
        }
    }

    public final void x(long j11) {
        int i11;
        Task task;
        if (f68044k.compareAndSet(this, 0, 1)) {
            Worker m11 = m();
            synchronized (this.f68052g) {
                i11 = (int) (d().get(this) & 2097151);
            }
            if (1 <= i11) {
                int i12 = 1;
                while (true) {
                    Object b11 = this.f68052g.b(i12);
                    Intrinsics.e(b11);
                    Worker worker = (Worker) b11;
                    if (worker != m11) {
                        while (worker.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(worker);
                            worker.join(j11);
                        }
                        worker.localQueue.j(this.f68051f);
                    }
                    if (i12 == i11) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            this.f68051f.b();
            this.f68050e.b();
            while (true) {
                if (m11 != null) {
                    task = m11.findTask(true);
                    if (task != null) {
                        continue;
                        w(task);
                    }
                }
                task = (Task) this.f68050e.e();
                if (task == null && (task = (Task) this.f68051f.e()) == null) {
                    break;
                }
                w(task);
            }
            if (m11 != null) {
                m11.tryReleaseCpu(WorkerState.TERMINATED);
            }
            f68042i.set(this, 0L);
            f68043j.set(this, 0L);
        }
    }
}
