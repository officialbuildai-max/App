package eh;

import eh.f;
import java.lang.Thread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f62003a = new a(null);

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(dh.b bVar, String str, Thread thread, Throwable th2) {
            Intrinsics.e(th2);
            bVar.b(str, th2);
        }

        public final void b(Thread thread, final String name, final dh.b runnableCallback) {
            Intrinsics.h(thread, "thread");
            Intrinsics.h(name, "name");
            Intrinsics.h(runnableCallback, "runnableCallback");
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: eh.e
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th2) {
                    f.a.c(dh.b.this, name, thread2, th2);
                }
            });
            thread.setName(name);
        }
    }
}
