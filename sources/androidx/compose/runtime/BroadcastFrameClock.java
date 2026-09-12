package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.u0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
public final class BroadcastFrameClock implements u0 {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f3626a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3627b;

    /* renamed from: c, reason: collision with root package name */
    private Throwable f3628c;

    /* renamed from: d, reason: collision with root package name */
    private List f3629d;

    /* renamed from: e, reason: collision with root package name */
    private List f3630e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInt f3631f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Function1 f3632a;

        /* renamed from: b, reason: collision with root package name */
        private final Continuation f3633b;

        public a(Function1 function1, Continuation continuation) {
            this.f3632a = function1;
            this.f3633b = continuation;
        }

        public final Continuation a() {
            return this.f3633b;
        }

        public final void b(long j11) {
            Object m1185constructorimpl;
            Continuation continuation = this.f3633b;
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(this.f3632a.invoke(Long.valueOf(j11)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            continuation.resumeWith(m1185constructorimpl);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BroadcastFrameClock(Function0 function0) {
        this.f3626a = function0;
        this.f3627b = new Object();
        this.f3629d = new ArrayList();
        this.f3630e = new ArrayList();
        this.f3631f = new AtomicInt(0);
    }

    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Throwable th2) {
        synchronized (this.f3627b) {
            try {
                if (this.f3628c != null) {
                    return;
                }
                this.f3628c = th2;
                List list = this.f3629d;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Continuation a11 = ((a) list.get(i11)).a();
                    Result.Companion companion = Result.INSTANCE;
                    a11.resumeWith(Result.m1185constructorimpl(ResultKt.a(th2)));
                }
                this.f3629d.clear();
                this.f3631f.set(0);
                Unit unit = Unit.f67184a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return u0.a.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return u0.a.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public /* synthetic */ CoroutineContext.Key getKey() {
        return t0.a(this);
    }

    @Override // androidx.compose.runtime.u0
    public Object l(Function1 function1, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final a aVar = new a(function1, cancellableContinuationImpl);
        synchronized (this.f3627b) {
            Throwable th2 = this.f3628c;
            if (th2 != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m1185constructorimpl(ResultKt.a(th2)));
            } else {
                boolean isEmpty = this.f3629d.isEmpty();
                this.f3629d.add(aVar);
                if (isEmpty) {
                    this.f3631f.set(1);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.f67184a;
                    }

                    public final void invoke(Throwable th3) {
                        Object obj = BroadcastFrameClock.this.f3627b;
                        BroadcastFrameClock broadcastFrameClock = BroadcastFrameClock.this;
                        BroadcastFrameClock.a aVar2 = aVar;
                        synchronized (obj) {
                            try {
                                broadcastFrameClock.f3629d.remove(aVar2);
                                if (broadcastFrameClock.f3629d.isEmpty()) {
                                    broadcastFrameClock.f3631f.set(0);
                                }
                                Unit unit = Unit.f67184a;
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                    }
                });
                if (isEmpty && this.f3626a != null) {
                    try {
                        this.f3626a.invoke();
                    } catch (Throwable th3) {
                        j(th3);
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return u0.a.c(this, key);
    }

    public final boolean p() {
        return this.f3631f.get() != 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return u0.a.d(this, coroutineContext);
    }

    public final void q(long j11) {
        synchronized (this.f3627b) {
            try {
                List list = this.f3629d;
                this.f3629d = this.f3630e;
                this.f3630e = list;
                this.f3631f.set(0);
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((a) list.get(i11)).b(j11);
                }
                list.clear();
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
