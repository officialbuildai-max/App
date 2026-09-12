package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.f;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes.dex */
final class LazyLayoutSemanticsModifierNode extends f.c implements i1 {

    /* renamed from: n, reason: collision with root package name */
    private Function0 f3069n;

    /* renamed from: o, reason: collision with root package name */
    private z f3070o;

    /* renamed from: p, reason: collision with root package name */
    private Orientation f3071p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3072q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3073r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.compose.ui.semantics.g f3074s;

    /* renamed from: t, reason: collision with root package name */
    private final Function1 f3075t = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$indexForKeyMapping$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(Object obj) {
            Function0 function0;
            function0 = LazyLayoutSemanticsModifierNode.this.f3069n;
            m mVar = (m) function0.invoke();
            int itemCount = mVar.getItemCount();
            int i11 = 0;
            while (true) {
                if (i11 >= itemCount) {
                    i11 = -1;
                    break;
                }
                if (Intrinsics.c(mVar.b(i11), obj)) {
                    break;
                }
                i11++;
            }
            return Integer.valueOf(i11);
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private Function1 f3076u;

    public LazyLayoutSemanticsModifierNode(Function0 function0, z zVar, Orientation orientation, boolean z10, boolean z11) {
        this.f3069n = function0;
        this.f3070o = zVar;
        this.f3071p = orientation;
        this.f3072q = z10;
        this.f3073r = z11;
        I1();
    }

    private final androidx.compose.ui.semantics.b F1() {
        return this.f3070o.d();
    }

    private final boolean G1() {
        return this.f3071p == Orientation.Vertical;
    }

    private final void I1() {
        this.f3074s = new androidx.compose.ui.semantics.g(new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                z zVar;
                zVar = LazyLayoutSemanticsModifierNode.this.f3070o;
                return Float.valueOf(zVar.f());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                z zVar;
                zVar = LazyLayoutSemanticsModifierNode.this.f3070o;
                return Float.valueOf(zVar.b());
            }
        }, this.f3073r);
        this.f3076u = this.f3072q ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2", f = "LazyLayoutSemantics.kt", l = {Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE}, m = "invokeSuspend")
            /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $index;
                int label;
                final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i11, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = lazyLayoutSemanticsModifierNode;
                    this.$index = i11;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$index, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    z zVar;
                    Object f11 = IntrinsicsKt.f();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        zVar = this.this$0.f3070o;
                        int i12 = this.$index;
                        this.label = 1;
                        if (zVar.c(i12, this) == f11) {
                            return f11;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f67184a;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(int i11) {
                Function0 function0;
                function0 = LazyLayoutSemanticsModifierNode.this.f3069n;
                m mVar = (m) function0.invoke();
                if (i11 >= 0 && i11 < mVar.getItemCount()) {
                    kotlinx.coroutines.k.d(LazyLayoutSemanticsModifierNode.this.d1(), null, null, new AnonymousClass2(LazyLayoutSemanticsModifierNode.this, i11, null), 3, null);
                    return Boolean.TRUE;
                }
                throw new IllegalArgumentException(("Can't scroll to index " + i11 + ", it is out of bounds [0, " + mVar.getItemCount() + ')').toString());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        } : null;
    }

    public final void H1(Function0 function0, z zVar, Orientation orientation, boolean z10, boolean z11) {
        this.f3069n = function0;
        this.f3070o = zVar;
        if (this.f3071p != orientation) {
            this.f3071p = orientation;
            j1.b(this);
        }
        if (this.f3072q == z10 && this.f3073r == z11) {
            return;
        }
        this.f3072q = z10;
        this.f3073r = z11;
        I1();
        j1.b(this);
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean O() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public void R0(androidx.compose.ui.semantics.n nVar) {
        SemanticsPropertiesKt.J(nVar, true);
        SemanticsPropertiesKt.k(nVar, this.f3075t);
        if (G1()) {
            androidx.compose.ui.semantics.g gVar = this.f3074s;
            if (gVar == null) {
                Intrinsics.z("scrollAxisRange");
                gVar = null;
            }
            SemanticsPropertiesKt.K(nVar, gVar);
        } else {
            androidx.compose.ui.semantics.g gVar2 = this.f3074s;
            if (gVar2 == null) {
                Intrinsics.z("scrollAxisRange");
                gVar2 = null;
            }
            SemanticsPropertiesKt.x(nVar, gVar2);
        }
        Function1 function1 = this.f3076u;
        if (function1 != null) {
            SemanticsPropertiesKt.t(nVar, null, function1, 1, null);
        }
        SemanticsPropertiesKt.h(nVar, null, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$applySemantics$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                z zVar;
                z zVar2;
                zVar = LazyLayoutSemanticsModifierNode.this.f3070o;
                int e11 = zVar.e();
                zVar2 = LazyLayoutSemanticsModifierNode.this.f3070o;
                return Float.valueOf(e11 - zVar2.a());
            }
        }, 1, null);
        SemanticsPropertiesKt.u(nVar, F1());
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean W0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return false;
    }
}
