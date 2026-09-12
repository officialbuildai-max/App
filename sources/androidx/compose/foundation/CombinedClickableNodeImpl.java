package androidx.compose.foundation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.node.e1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CombinedClickableNodeImpl extends AbstractClickableNode implements e1 {
    private String J;
    private Function0 K;
    private Function0 L;

    private CombinedClickableNodeImpl(Function0 function0, String str, Function0 function02, Function0 function03, p.i iVar, b0 b0Var, boolean z10, String str2, androidx.compose.ui.semantics.f fVar) {
        super(iVar, b0Var, z10, str2, fVar, function0, null);
        this.J = str;
        this.K = function02;
        this.L = function03;
    }

    public /* synthetic */ CombinedClickableNodeImpl(Function0 function0, String str, Function0 function02, Function0 function03, p.i iVar, b0 b0Var, boolean z10, String str2, androidx.compose.ui.semantics.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function02, function03, iVar, b0Var, z10, str2, fVar);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void P1(androidx.compose.ui.semantics.n nVar) {
        if (this.K != null) {
            SemanticsPropertiesKt.m(nVar, this.J, new Function0<Boolean>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$applyAdditionalSemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    Function0 function0;
                    function0 = CombinedClickableNodeImpl.this.K;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object Q1(androidx.compose.ui.input.pointer.e0 e0Var, Continuation continuation) {
        Object i11 = TapGestureDetectorKt.i(e0Var, (!V1() || this.L == null) ? null : new Function1<y.g, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m23invokek4lQ0M(((y.g) obj).v());
                return Unit.f67184a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m23invokek4lQ0M(long j11) {
                Function0 function0;
                function0 = CombinedClickableNodeImpl.this.L;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, (!V1() || this.K == null) ? null : new Function1<y.g, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m24invokek4lQ0M(((y.g) obj).v());
                return Unit.f67184a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m24invokek4lQ0M(long j11) {
                Function0 function0;
                function0 = CombinedClickableNodeImpl.this.K;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, new CombinedClickableNodeImpl$clickPointerInput$4(this, null), new Function1<y.g, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m26invokek4lQ0M(((y.g) obj).v());
                return Unit.f67184a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m26invokek4lQ0M(long j11) {
                if (CombinedClickableNodeImpl.this.V1()) {
                    CombinedClickableNodeImpl.this.W1().invoke();
                }
            }
        }, continuation);
        return i11 == IntrinsicsKt.f() ? i11 : Unit.f67184a;
    }

    public void e2(Function0 function0, String str, Function0 function02, Function0 function03, p.i iVar, b0 b0Var, boolean z10, String str2, androidx.compose.ui.semantics.f fVar) {
        boolean z11;
        if (!Intrinsics.c(this.J, str)) {
            this.J = str;
            j1.b(this);
        }
        if ((this.K == null) != (function02 == null)) {
            S1();
            j1.b(this);
            z11 = true;
        } else {
            z11 = false;
        }
        this.K = function02;
        if ((this.L == null) != (function03 == null)) {
            z11 = true;
        }
        this.L = function03;
        boolean z12 = V1() != z10 ? true : z11;
        b2(iVar, b0Var, z10, str2, fVar, function0);
        if (z12) {
            Z1();
        }
    }
}
