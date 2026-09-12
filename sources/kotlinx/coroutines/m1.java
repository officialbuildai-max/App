package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes7.dex */
public abstract class m1 {
    public static final Executor a(i0 i0Var) {
        Executor d11;
        k1 k1Var = i0Var instanceof k1 ? (k1) i0Var : null;
        return (k1Var == null || (d11 = k1Var.d()) == null) ? new x0(i0Var) : d11;
    }

    public static final i0 b(Executor executor) {
        i0 i0Var;
        x0 x0Var = executor instanceof x0 ? (x0) executor : null;
        return (x0Var == null || (i0Var = x0Var.f68127a) == null) ? new l1(executor) : i0Var;
    }

    public static final k1 c(ExecutorService executorService) {
        return new l1(executorService);
    }
}
