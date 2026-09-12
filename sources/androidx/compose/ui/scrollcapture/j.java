package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.layout.l;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import o0.r;
import o0.s;

/* loaded from: classes.dex */
public abstract class j {
    private static final boolean a(SemanticsNode semanticsNode) {
        Function2 c11 = c(semanticsNode);
        androidx.compose.ui.semantics.g gVar = (androidx.compose.ui.semantics.g) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f5994a.H());
        return (c11 == null || gVar == null || ((Number) gVar.a().invoke()).floatValue() <= 0.0f) ? false : true;
    }

    private static final List b(SemanticsNode semanticsNode) {
        return semanticsNode.l(false, false, false);
    }

    public static final Function2 c(SemanticsNode semanticsNode) {
        return (Function2) SemanticsConfigurationKt.a(semanticsNode.w(), androidx.compose.ui.semantics.h.f6051a.t());
    }

    private static final boolean d(SemanticsNode semanticsNode) {
        return (semanticsNode.z() || semanticsNode.w().e(SemanticsProperties.f5994a.n())) ? false : true;
    }

    private static final void e(SemanticsNode semanticsNode, int i11, Function1 function1) {
        SemanticsNode semanticsNode2;
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new SemanticsNode[16], 0);
        List b11 = b(semanticsNode);
        while (true) {
            bVar.e(bVar.n(), b11);
            while (bVar.q()) {
                semanticsNode2 = (SemanticsNode) bVar.v(bVar.n() - 1);
                if (d(semanticsNode2) && !semanticsNode2.w().e(SemanticsProperties.f5994a.f())) {
                    NodeCoordinator e11 = semanticsNode2.e();
                    if (e11 == null) {
                        g0.a.c("Expected semantics node to have a coordinator.");
                        throw new KotlinNothingValueException();
                    }
                    l X0 = e11.X0();
                    r b12 = s.b(m.c(X0));
                    if (b12.k()) {
                        continue;
                    } else {
                        if (!a(semanticsNode2)) {
                            break;
                        }
                        int i12 = i11 + 1;
                        function1.invoke(new i(semanticsNode2, i12, b12, X0));
                        e(semanticsNode2, i12, function1);
                    }
                }
            }
            return;
            b11 = b(semanticsNode2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(SemanticsNode semanticsNode, int i11, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        e(semanticsNode, i11, function1);
    }
}
