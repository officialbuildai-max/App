package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract /* synthetic */ class o {

    /* loaded from: classes7.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f67947a;

        public a(Object obj) {
            this.f67947a = obj;
        }

        @Override // kotlinx.coroutines.flow.b
        public Object a(c cVar, Continuation continuation) {
            Object emit = cVar.emit(this.f67947a, continuation);
            return emit == IntrinsicsKt.f() ? emit : Unit.f67184a;
        }
    }

    public static final b a(Function2 function2) {
        return new CallbackFlowBuilder(function2, null, 0, null, 14, null);
    }

    public static final b b(Function2 function2) {
        return new b1(function2);
    }

    public static final b c(Object obj) {
        return new a(obj);
    }
}
