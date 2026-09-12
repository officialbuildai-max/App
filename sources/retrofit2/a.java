package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
final class a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f74461a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f74461a.post(runnable);
    }
}
