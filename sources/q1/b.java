package q1;

import kotlin.NotImplementedError;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.y0;

/* loaded from: classes2.dex */
public abstract class b {
    public static final a a() {
        CoroutineContext coroutineContext;
        try {
            coroutineContext = y0.c().q();
        } catch (IllegalStateException unused) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        } catch (NotImplementedError unused2) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return new a(coroutineContext.plus(l2.b(null, 1, null)));
    }
}
