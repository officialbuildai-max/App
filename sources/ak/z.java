package ak;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class z {

    /* renamed from: b, reason: collision with root package name */
    public static final a f734b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f735c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: ak.y
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            z b11;
            b11 = z.b();
            return b11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f736a = Executors.newFixedThreadPool(3);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final z a() {
            return (z) z.f735c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final z b() {
        return new z();
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.f736a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
