package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f67826b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    private final r0[] f67827a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class a extends w1 {

        /* renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f67828h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        private volatile /* synthetic */ Object _disposer$volatile;

        /* renamed from: e, reason: collision with root package name */
        private final n f67829e;

        /* renamed from: f, reason: collision with root package name */
        public a1 f67830f;

        public a(n nVar) {
            this.f67829e = nVar;
        }

        public final void A(b bVar) {
            f67828h.set(this, bVar);
        }

        public final void B(a1 a1Var) {
            this.f67830f = a1Var;
        }

        @Override // kotlinx.coroutines.w1
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.w1
        public void v(Throwable th2) {
            if (th2 != null) {
                Object tryResumeWithException = this.f67829e.tryResumeWithException(th2);
                if (tryResumeWithException != null) {
                    this.f67829e.completeResume(tryResumeWithException);
                    b x10 = x();
                    if (x10 != null) {
                        x10.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.b().decrementAndGet(e.this) == 0) {
                n nVar = this.f67829e;
                r0[] r0VarArr = e.this.f67827a;
                ArrayList arrayList = new ArrayList(r0VarArr.length);
                for (r0 r0Var : r0VarArr) {
                    arrayList.add(r0Var.h());
                }
                nVar.resumeWith(Result.m1185constructorimpl(arrayList));
            }
        }

        public final b x() {
            return (b) f67828h.get(this);
        }

        public final a1 y() {
            a1 a1Var = this.f67830f;
            if (a1Var != null) {
                return a1Var;
            }
            Intrinsics.z("handle");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class b implements m {

        /* renamed from: a, reason: collision with root package name */
        private final a[] f67832a;

        public b(a[] aVarArr) {
            this.f67832a = aVarArr;
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable th2) {
            b();
        }

        public final void b() {
            for (a aVar : this.f67832a) {
                aVar.y().dispose();
            }
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f67832a + ']';
        }
    }

    public e(r0[] r0VarArr) {
        this.f67827a = r0VarArr;
        this.notCompletedCount$volatile = r0VarArr.length;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater b() {
        return f67826b;
    }

    public final Object c(Continuation continuation) {
        a1 m11;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.f67827a.length;
        a[] aVarArr = new a[length];
        for (int i11 = 0; i11 < length; i11++) {
            r0 r0Var = this.f67827a[i11];
            r0Var.start();
            a aVar = new a(cancellableContinuationImpl);
            m11 = JobKt__JobKt.m(r0Var, false, aVar, 1, null);
            aVar.B(m11);
            Unit unit = Unit.f67184a;
            aVarArr[i11] = aVar;
        }
        b bVar = new b(aVarArr);
        for (int i12 = 0; i12 < length; i12++) {
            aVarArr[i12].A(bVar);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            bVar.b();
        } else {
            q.c(cancellableContinuationImpl, bVar);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }
}
