package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final e f67762a;
    private static volatile Choreographer choreographer;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object m1185constructorimpl;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(new HandlerContext(c(Looper.getMainLooper(), true), objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        f67762a = (e) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
    }

    public static final Handler c(Looper looper, boolean z10) {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        Intrinsics.f(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }

    public static final e d(Handler handler, String str) {
        return new HandlerContext(handler, str);
    }

    private static final void e(Choreographer choreographer2, final n nVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j11) {
                g.f(n.this, j11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(n nVar, long j11) {
        nVar.resumeUndispatched(y0.c(), Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(n nVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            Intrinsics.e(choreographer2);
            choreographer = choreographer2;
        }
        e(choreographer2, nVar);
    }
}
