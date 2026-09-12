package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class c extends SequenceScope implements Iterator, Continuation, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private int f67597a;

    /* renamed from: b, reason: collision with root package name */
    private Object f67598b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator f67599c;

    /* renamed from: d, reason: collision with root package name */
    private Continuation f67600d;

    private final Throwable f() {
        int i11 = this.f67597a;
        if (i11 == 4) {
            return new NoSuchElementException();
        }
        if (i11 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f67597a);
    }

    private final Object h() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.SequenceScope
    public Object a(Object obj, Continuation continuation) {
        this.f67598b = obj;
        this.f67597a = 3;
        this.f67600d = continuation;
        Object f11 = IntrinsicsKt.f();
        if (f11 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f11 == IntrinsicsKt.f() ? f11 : Unit.f67184a;
    }

    @Override // kotlin.sequences.SequenceScope
    public Object c(Iterator it, Continuation continuation) {
        if (!it.hasNext()) {
            return Unit.f67184a;
        }
        this.f67599c = it;
        this.f67597a = 2;
        this.f67600d = continuation;
        Object f11 = IntrinsicsKt.f();
        if (f11 == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return f11 == IntrinsicsKt.f() ? f11 : Unit.f67184a;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext getF67151a() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i11 = this.f67597a;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2 || i11 == 3) {
                        return true;
                    }
                    if (i11 == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator it = this.f67599c;
                Intrinsics.e(it);
                if (it.hasNext()) {
                    this.f67597a = 2;
                    return true;
                }
                this.f67599c = null;
            }
            this.f67597a = 5;
            Continuation continuation = this.f67600d;
            Intrinsics.e(continuation);
            this.f67600d = null;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
        }
    }

    public final void i(Continuation continuation) {
        this.f67600d = continuation;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i11 = this.f67597a;
        if (i11 == 0 || i11 == 1) {
            return h();
        }
        if (i11 == 2) {
            this.f67597a = 1;
            Iterator it = this.f67599c;
            Intrinsics.e(it);
            return it.next();
        }
        if (i11 != 3) {
            throw f();
        }
        this.f67597a = 0;
        Object obj = this.f67598b;
        this.f67598b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        ResultKt.b(obj);
        this.f67597a = 4;
    }
}
