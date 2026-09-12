package c00;

import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
final class a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final a f17055a = new a();

    private a() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
