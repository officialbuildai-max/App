package j4;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m1;

/* loaded from: classes2.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final SerialExecutorImpl f66063a;

    /* renamed from: b, reason: collision with root package name */
    private final i0 f66064b;

    /* renamed from: c, reason: collision with root package name */
    final Handler f66065c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private final Executor f66066d = new a();

    /* loaded from: classes2.dex */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            d.this.f66065c.post(runnable);
        }
    }

    public d(Executor executor) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executor);
        this.f66063a = serialExecutorImpl;
        this.f66064b = m1.b(serialExecutorImpl);
    }

    @Override // j4.c
    public Executor a() {
        return this.f66066d;
    }

    @Override // j4.c
    public i0 b() {
        return this.f66064b;
    }

    @Override // j4.c
    public /* synthetic */ void d(Runnable runnable) {
        b.a(this, runnable);
    }

    @Override // j4.c
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public SerialExecutorImpl c() {
        return this.f66063a;
    }
}
