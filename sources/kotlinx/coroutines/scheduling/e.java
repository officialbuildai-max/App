package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k1;

/* loaded from: classes7.dex */
public class e extends k1 {

    /* renamed from: b, reason: collision with root package name */
    private final int f68058b;

    /* renamed from: c, reason: collision with root package name */
    private final int f68059c;

    /* renamed from: d, reason: collision with root package name */
    private final long f68060d;

    /* renamed from: e, reason: collision with root package name */
    private final String f68061e;

    /* renamed from: f, reason: collision with root package name */
    private CoroutineScheduler f68062f;

    public e() {
        this(0, 0, 0L, null, 15, null);
    }

    public e(int i11, int i12, long j11, String str) {
        this.f68058b = i11;
        this.f68059c = i12;
        this.f68060d = j11;
        this.f68061e = str;
        this.f68062f = p();
    }

    public /* synthetic */ e(int i11, int i12, long j11, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? g.f68065c : i11, (i13 & 2) != 0 ? g.f68066d : i12, (i13 & 4) != 0 ? g.f68067e : j11, (i13 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    private final CoroutineScheduler p() {
        return new CoroutineScheduler(this.f68058b, this.f68059c, this.f68060d, this.f68061e);
    }

    public void close() {
        this.f68062f.close();
    }

    @Override // kotlinx.coroutines.k1
    public Executor d() {
        return this.f68062f;
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.o(this.f68062f, runnable, false, false, 6, null);
    }

    @Override // kotlinx.coroutines.i0
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.o(this.f68062f, runnable, false, true, 2, null);
    }

    public final void q(Runnable runnable, boolean z10, boolean z11) {
        this.f68062f.n(runnable, z10, z11);
    }
}
