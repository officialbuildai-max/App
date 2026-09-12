package androidx.work;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class m0 {
    private static final s c(Context context, String str, WorkerParameters workerParameters) {
        String str2;
        try {
            Object newInstance = d(str).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            Intrinsics.e(newInstance);
            return (s) newInstance;
        } catch (Throwable th2) {
            t e11 = t.e();
            str2 = n0.f16113a;
            e11.d(str2, "Could not instantiate " + str, th2);
            throw th2;
        }
    }

    private static final Class d(String str) {
        String str2;
        try {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(s.class);
            Intrinsics.e(asSubclass);
            return asSubclass;
        } catch (Throwable th2) {
            t e11 = t.e();
            str2 = n0.f16113a;
            e11.d(str2, "Invalid class: " + str, th2);
            throw th2;
        }
    }

    public abstract s a(Context context, String str, WorkerParameters workerParameters);

    public final s b(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Intrinsics.h(appContext, "appContext");
        Intrinsics.h(workerClassName, "workerClassName");
        Intrinsics.h(workerParameters, "workerParameters");
        s a11 = a(appContext, workerClassName, workerParameters);
        if (a11 == null) {
            a11 = c(appContext, workerClassName, workerParameters);
        }
        if (!a11.i()) {
            return a11;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + workerClassName + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
