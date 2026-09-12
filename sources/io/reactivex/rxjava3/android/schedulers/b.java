package io.reactivex.rxjava3.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.rxjava3.android.schedulers.b;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.Callable;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Scheduler f65431a = jz.a.d(new Callable() { // from class: io.reactivex.rxjava3.android.schedulers.a
        @Override // java.util.concurrent.Callable
        public final Object call() {
            Scheduler scheduler;
            scheduler = b.a.f65432a;
            return scheduler;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final Scheduler f65432a = new HandlerScheduler(new Handler(Looper.getMainLooper()), true);
    }

    public static Scheduler c() {
        return jz.a.e(f65431a);
    }
}
