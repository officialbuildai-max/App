package androidx.compose.foundation.relocation;

import androidx.compose.ui.layout.l;
import androidx.compose.ui.node.g;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import o0.u;
import y.i;
import y.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract /* synthetic */ class ScrollIntoView__ScrollIntoViewRequesterKt {
    public static final Object a(androidx.compose.ui.node.f fVar, final i iVar, Continuation continuation) {
        Object U;
        if (!fVar.getNode().k1()) {
            return Unit.f67184a;
        }
        final l k11 = g.k(fVar);
        a a11 = b.a(fVar);
        return (a11 != null && (U = a11.U(k11, new Function0<i>() { // from class: androidx.compose.foundation.relocation.ScrollIntoView__ScrollIntoViewRequesterKt$scrollIntoView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                i iVar2 = i.this;
                if (iVar2 != null) {
                    return iVar2;
                }
                l lVar = k11;
                if (!lVar.F()) {
                    lVar = null;
                }
                if (lVar != null) {
                    return n.c(u.d(lVar.k()));
                }
                return null;
            }
        }, continuation)) == IntrinsicsKt.f()) ? U : Unit.f67184a;
    }

    public static /* synthetic */ Object b(androidx.compose.ui.node.f fVar, i iVar, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            iVar = null;
        }
        return f.a(fVar, iVar, continuation);
    }
}
