package eh;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class c implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f61993b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final c f61994c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f61995a = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.f61994c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            Handler handler = this.f61995a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: eh.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c(runnable);
                    }
                });
            }
        }
    }
}
