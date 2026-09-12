package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes7.dex */
public abstract /* synthetic */ class b {
    public static c a() {
        return EmptyDisposable.INSTANCE;
    }

    public static c b(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
