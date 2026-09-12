package androidx.compose.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public interface u0 extends CoroutineContext.Element {
    public static final b Z0 = b.f4127a;

    /* loaded from: classes.dex */
    public static final class a {
        public static Object a(u0 u0Var, Object obj, Function2 function2) {
            return CoroutineContext.Element.DefaultImpls.a(u0Var, obj, function2);
        }

        public static CoroutineContext.Element b(u0 u0Var, CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.b(u0Var, key);
        }

        public static CoroutineContext c(u0 u0Var, CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.c(u0Var, key);
        }

        public static CoroutineContext d(u0 u0Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(u0Var, coroutineContext);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements CoroutineContext.Key {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f4127a = new b();

        private b() {
        }
    }

    Object l(Function1 function1, Continuation continuation);
}
