package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract /* synthetic */ class FlowKt__LimitKt {

    /* loaded from: classes7.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f67859a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f67860b;

        public a(b bVar, Function2 function2) {
            this.f67859a = bVar;
            this.f67860b = function2;
        }

        @Override // kotlinx.coroutines.flow.b
        public Object a(c cVar, Continuation continuation) {
            Object a11 = this.f67859a.a(new FlowKt__LimitKt$dropWhile$1$1(new Ref.BooleanRef(), cVar, this.f67860b), continuation);
            return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
        }
    }

    public static final b a(b bVar, Function2 function2) {
        return new a(bVar, function2);
    }

    public static final b b(b bVar, Function2 function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(bVar, function2);
    }
}
