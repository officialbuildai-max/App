package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/h;", "", "<anonymous>", "(Landroidx/compose/foundation/gestures/h;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", l = {782}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* loaded from: classes.dex */
    public static final class a implements k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScrollingLogic f2779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f2780b;

        a(ScrollingLogic scrollingLogic, h hVar) {
            this.f2779a = scrollingLogic;
            this.f2780b = hVar;
        }

        @Override // androidx.compose.foundation.gestures.k
        public float a(float f11) {
            ScrollingLogic scrollingLogic = this.f2779a;
            return scrollingLogic.t(scrollingLogic.A(this.f2780b.a(scrollingLogic.u(scrollingLogic.B(f11)), androidx.compose.ui.input.nestedscroll.e.f5014a.a())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref.LongRef longRef, long j11, Continuation<? super ScrollingLogic$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
        this.$result = longRef;
        this.$available = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, continuation);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(h hVar, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic$doFlingAnimation$2) create(hVar, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        g gVar;
        float z10;
        Ref.LongRef longRef;
        ScrollingLogic scrollingLogic2;
        long j11;
        long D;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            a aVar = new a(this.this$0, (h) this.L$0);
            scrollingLogic = this.this$0;
            Ref.LongRef longRef2 = this.$result;
            long j12 = this.$available;
            gVar = scrollingLogic.f2770c;
            long j13 = longRef2.element;
            z10 = scrollingLogic.z(j12);
            float t11 = scrollingLogic.t(z10);
            this.L$0 = scrollingLogic;
            this.L$1 = scrollingLogic;
            this.L$2 = longRef2;
            this.J$0 = j13;
            this.label = 1;
            Object a11 = gVar.a(aVar, t11, this);
            if (a11 == f11) {
                return f11;
            }
            longRef = longRef2;
            obj = a11;
            scrollingLogic2 = scrollingLogic;
            j11 = j13;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j11 = this.J$0;
            longRef = (Ref.LongRef) this.L$2;
            scrollingLogic = (ScrollingLogic) this.L$1;
            scrollingLogic2 = (ScrollingLogic) this.L$0;
            ResultKt.b(obj);
        }
        D = scrollingLogic.D(j11, scrollingLogic2.t(((Number) obj).floatValue()));
        longRef.element = D;
        return Unit.f67184a;
    }
}
