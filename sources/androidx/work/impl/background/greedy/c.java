package androidx.work.impl.background.greedy;

import androidx.work.d0;
import androidx.work.impl.b1;
import androidx.work.impl.y;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f15649a;

    /* renamed from: b, reason: collision with root package name */
    private final b1 f15650b;

    /* renamed from: c, reason: collision with root package name */
    private final long f15651c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f15652d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f15653e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(d0 runnableScheduler, b1 launcher) {
        this(runnableScheduler, launcher, 0L, 4, null);
        Intrinsics.h(runnableScheduler, "runnableScheduler");
        Intrinsics.h(launcher, "launcher");
    }

    public c(d0 runnableScheduler, b1 launcher, long j11) {
        Intrinsics.h(runnableScheduler, "runnableScheduler");
        Intrinsics.h(launcher, "launcher");
        this.f15649a = runnableScheduler;
        this.f15650b = launcher;
        this.f15651c = j11;
        this.f15652d = new Object();
        this.f15653e = new LinkedHashMap();
    }

    public /* synthetic */ c(d0 d0Var, b1 b1Var, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(d0Var, b1Var, (i11 & 4) != 0 ? TimeUnit.MINUTES.toMillis(90L) : j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, y yVar) {
        cVar.f15650b.d(yVar, 3);
    }

    public final void b(y token) {
        Runnable runnable;
        Intrinsics.h(token, "token");
        synchronized (this.f15652d) {
            runnable = (Runnable) this.f15653e.remove(token);
        }
        if (runnable != null) {
            this.f15649a.a(runnable);
        }
    }

    public final void c(final y token) {
        Intrinsics.h(token, "token");
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(c.this, token);
            }
        };
        synchronized (this.f15652d) {
        }
        this.f15649a.b(this.f15651c, runnable);
    }
}
