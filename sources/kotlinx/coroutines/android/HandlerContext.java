package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.n;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class HandlerContext extends e implements t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f67753a;

    /* renamed from: b, reason: collision with root package name */
    private final String f67754b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f67755c;

    /* renamed from: d, reason: collision with root package name */
    private final HandlerContext f67756d;

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i11 & 2) != 0 ? null : str);
    }

    private HandlerContext(Handler handler, String str, boolean z10) {
        super(null);
        this.f67753a = handler;
        this.f67754b = str;
        this.f67755c = z10;
        this.f67756d = z10 ? this : new HandlerContext(handler, str, true);
    }

    private final void u(CoroutineContext coroutineContext, Runnable runnable) {
        v1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        y0.b().dispatch(coroutineContext, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f67753a.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(HandlerContext handlerContext, Runnable runnable, Throwable th2) {
        handlerContext.f67753a.removeCallbacks(runnable);
        return Unit.f67184a;
    }

    @Override // kotlinx.coroutines.i0
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f67753a.post(runnable)) {
            return;
        }
        u(coroutineContext, runnable);
    }

    public boolean equals(Object obj) {
        if (obj instanceof HandlerContext) {
            HandlerContext handlerContext = (HandlerContext) obj;
            if (handlerContext.f67753a == this.f67753a && handlerContext.f67755c == this.f67755c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f67753a) ^ (this.f67755c ? 1231 : 1237);
    }

    @Override // kotlinx.coroutines.t0
    public a1 invokeOnTimeout(long j11, final Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f67753a.postDelayed(runnable, RangesKt.j(j11, 4611686018427387903L))) {
            return new a1() { // from class: kotlinx.coroutines.android.c
                @Override // kotlinx.coroutines.a1
                public final void dispose() {
                    HandlerContext.w(HandlerContext.this, runnable);
                }
            };
        }
        u(coroutineContext, runnable);
        return d2.f67825a;
    }

    @Override // kotlinx.coroutines.i0
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.f67755c && Intrinsics.c(Looper.myLooper(), this.f67753a.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.t0
    public void scheduleResumeAfterDelay(long j11, final n nVar) {
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.resumeUndispatched(this, Unit.f67184a);
            }
        };
        if (this.f67753a.postDelayed(runnable, RangesKt.j(j11, 4611686018427387903L))) {
            nVar.invokeOnCancellation(new Function1() { // from class: kotlinx.coroutines.android.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit x10;
                    x10 = HandlerContext.x(HandlerContext.this, runnable, (Throwable) obj);
                    return x10;
                }
            });
        } else {
            u(nVar.getF67151a(), runnable);
        }
    }

    @Override // kotlinx.coroutines.a2, kotlinx.coroutines.i0
    public String toString() {
        String p11 = p();
        if (p11 != null) {
            return p11;
        }
        String str = this.f67754b;
        if (str == null) {
            str = this.f67753a.toString();
        }
        if (!this.f67755c) {
            return str;
        }
        return str + ".immediate";
    }

    @Override // kotlinx.coroutines.android.e
    /* renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public HandlerContext q() {
        return this.f67756d;
    }
}
