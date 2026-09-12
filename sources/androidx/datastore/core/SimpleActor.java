package androidx.datastore.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class SimpleActor {

    /* renamed from: a, reason: collision with root package name */
    private final n0 f8664a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f8665b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.channels.d f8666c;

    /* renamed from: d, reason: collision with root package name */
    private final a f8667d;

    public SimpleActor(n0 scope, final Function1 onComplete, final Function2 onUndeliveredElement, Function2 consumeMessage) {
        Intrinsics.h(scope, "scope");
        Intrinsics.h(onComplete, "onComplete");
        Intrinsics.h(onUndeliveredElement, "onUndeliveredElement");
        Intrinsics.h(consumeMessage, "consumeMessage");
        this.f8664a = scope;
        this.f8665b = consumeMessage;
        this.f8666c = kotlinx.coroutines.channels.g.b(Integer.MAX_VALUE, null, null, 6, null);
        this.f8667d = new a(0);
        t1 t1Var = (t1) scope.getCoroutineContext().get(t1.f68119l1);
        if (t1Var != null) {
            t1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.datastore.core.SimpleActor.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f67184a;
                }

                public final void invoke(Throwable th2) {
                    Unit unit;
                    onComplete.invoke(th2);
                    this.f8666c.j(th2);
                    do {
                        Object f11 = kotlinx.coroutines.channels.h.f(this.f8666c.e());
                        if (f11 != null) {
                            onUndeliveredElement.invoke(f11, th2);
                            unit = Unit.f67184a;
                        } else {
                            unit = null;
                        }
                    } while (unit != null);
                }
            });
        }
    }

    public final void e(Object obj) {
        Object c11 = this.f8666c.c(obj);
        if (c11 instanceof h.a) {
            Throwable e11 = kotlinx.coroutines.channels.h.e(c11);
            if (e11 != null) {
                throw e11;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!kotlinx.coroutines.channels.h.i(c11)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f8667d.c() == 0) {
            kotlinx.coroutines.k.d(this.f8664a, null, null, new SimpleActor$offer$2(this, null), 3, null);
        }
    }
}
