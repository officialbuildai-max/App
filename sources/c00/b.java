package c00;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.n;

/* loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements OnCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f17056a;

        a(n nVar) {
            this.f17056a = nVar;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public final void onComplete(Task task) {
            Exception exception = task.getException();
            if (exception != null) {
                n nVar = this.f17056a;
                Result.Companion companion = Result.INSTANCE;
                nVar.resumeWith(Result.m1185constructorimpl(ResultKt.a(exception)));
            } else {
                if (task.isCanceled()) {
                    n.a.a(this.f17056a, null, 1, null);
                    return;
                }
                n nVar2 = this.f17056a;
                Result.Companion companion2 = Result.INSTANCE;
                nVar2.resumeWith(Result.m1185constructorimpl(task.getResult()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c00.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0165b implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellationTokenSource f17057a;

        C0165b(CancellationTokenSource cancellationTokenSource) {
            this.f17057a = cancellationTokenSource;
        }

        public final void a(Throwable th2) {
            this.f17057a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.f67184a;
        }
    }

    public static final Object a(Task task, Continuation continuation) {
        return b(task, null, continuation);
    }

    private static final Object b(Task task, CancellationTokenSource cancellationTokenSource, Continuation continuation) {
        if (!task.isComplete()) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            task.addOnCompleteListener(c00.a.f17055a, new a(cancellableContinuationImpl));
            if (cancellationTokenSource != null) {
                cancellableContinuationImpl.invokeOnCancellation(new C0165b(cancellationTokenSource));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }
}
