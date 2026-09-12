package androidx.view;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class b extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Application f9659a;

    public b(Application application) {
        Intrinsics.h(application, "application");
        this.f9659a = application;
    }

    public Application b() {
        Application application = this.f9659a;
        Intrinsics.f(application, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return application;
    }
}
