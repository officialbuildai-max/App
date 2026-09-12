package com.google.firebase.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class FirebaseExecutors {

    /* loaded from: classes.dex */
    private enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor b(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
