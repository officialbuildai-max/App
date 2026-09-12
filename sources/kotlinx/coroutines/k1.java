package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k1;

/* loaded from: classes.dex */
public abstract class k1 extends i0 implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f68017a = new a(null);

    /* loaded from: classes.dex */
    public static final class a extends AbstractCoroutineContextKey {
        private a() {
            super(i0.Key, new Function1() { // from class: kotlinx.coroutines.j1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    k1 d11;
                    d11 = k1.a.d((CoroutineContext.Element) obj);
                    return d11;
                }
            });
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k1 d(CoroutineContext.Element element) {
            if (element instanceof k1) {
                return (k1) element;
            }
            return null;
        }
    }

    public abstract Executor d();
}
