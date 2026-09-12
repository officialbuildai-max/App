package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.w;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class a0 {
    public static final w c(final f0 tracer, final String label, final Executor executor, final Function0 block) {
        Intrinsics.h(tracer, "tracer");
        Intrinsics.h(label, "label");
        Intrinsics.h(executor, "executor");
        Intrinsics.h(block, "block");
        final androidx.view.b0 b0Var = new androidx.view.b0(w.f16141b);
        com.google.common.util.concurrent.r a11 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.work.y
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                Unit d11;
                d11 = a0.d(executor, tracer, label, block, b0Var, aVar);
                return d11;
            }
        });
        Intrinsics.g(a11, "getFuture(...)");
        return new x(b0Var, a11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Executor executor, final f0 f0Var, final String str, final Function0 function0, final androidx.view.b0 b0Var, final CallbackToFutureAdapter.a completer) {
        Intrinsics.h(completer, "completer");
        executor.execute(new Runnable() { // from class: androidx.work.z
            @Override // java.lang.Runnable
            public final void run() {
                a0.e(f0.this, str, function0, b0Var, completer);
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(f0 f0Var, String str, Function0 function0, androidx.view.b0 b0Var, CallbackToFutureAdapter.a aVar) {
        boolean isEnabled = f0Var.isEnabled();
        if (isEnabled) {
            try {
                f0Var.a(str);
            } finally {
                if (isEnabled) {
                    f0Var.d();
                }
            }
        }
        try {
            function0.invoke();
            w.b.c cVar = w.f16140a;
            b0Var.n(cVar);
            aVar.c(cVar);
        } catch (Throwable th2) {
            b0Var.n(new w.b.a(th2));
            aVar.f(th2);
        }
        Unit unit = Unit.f67184a;
    }
}
