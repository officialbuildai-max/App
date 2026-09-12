package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public abstract class l0 extends AbstractCoroutineContextElement implements m2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f68019a = new a(null);

    /* loaded from: classes7.dex */
    public static final class a implements CoroutineContext.Key {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract long d();
}
