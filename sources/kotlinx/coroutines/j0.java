package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public interface j0 extends CoroutineContext.Element {

    /* renamed from: k1, reason: collision with root package name */
    public static final a f68015k1 = a.f68016a;

    /* loaded from: classes7.dex */
    public static final class a implements CoroutineContext.Key {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f68016a = new a();

        private a() {
        }
    }

    void o(CoroutineContext coroutineContext, Throwable th2);
}
