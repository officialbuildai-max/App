package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(androidx.compose.ui.semantics.a aVar, Object obj) {
        if (aVar == obj) {
            return true;
        }
        if (!(obj instanceof androidx.compose.ui.semantics.a)) {
            return false;
        }
        androidx.compose.ui.semantics.a aVar2 = (androidx.compose.ui.semantics.a) obj;
        if (!Intrinsics.c(aVar.b(), aVar2.b())) {
            return false;
        }
        if (aVar.a() != null || aVar2.a() == null) {
            return aVar.a() == null || aVar2.a() != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(SemanticsNode semanticsNode) {
        return !semanticsNode.n().e(SemanticsProperties.f5994a.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(SemanticsNode semanticsNode) {
        androidx.compose.ui.semantics.i w11 = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f5994a;
        if (w11.e(semanticsProperties.g()) && !Intrinsics.c(SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.i()), Boolean.TRUE)) {
            return true;
        }
        LayoutNode k11 = k(semanticsNode.q(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
            
                if (r3.e(androidx.compose.ui.semantics.SemanticsProperties.f5994a.g()) != false) goto L10;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r3) {
                /*
                    r2 = this;
                    androidx.compose.ui.semantics.i r3 = r3.F()
                    if (r3 == 0) goto L1a
                    boolean r0 = r3.o()
                    r1 = 1
                    if (r0 != r1) goto L1a
                    androidx.compose.ui.semantics.SemanticsProperties r0 = androidx.compose.ui.semantics.SemanticsProperties.f5994a
                    androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.g()
                    boolean r3 = r3.e(r0)
                    if (r3 == 0) goto L1a
                    goto L1b
                L1a:
                    r1 = 0
                L1b:
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
            }
        });
        if (k11 != null) {
            androidx.compose.ui.semantics.i F = k11.F();
            if (!(F != null ? Intrinsics.c(SemanticsConfigurationKt.a(F, semanticsProperties.i()), Boolean.TRUE) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode k(LayoutNode layoutNode, Function1 function1) {
        for (LayoutNode h02 = layoutNode.h0(); h02 != null; h02 = h02.h0()) {
            if (((Boolean) function1.invoke(h02)).booleanValue()) {
                return h02;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(SemanticsNode semanticsNode) {
        return semanticsNode.p().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(SemanticsNode semanticsNode) {
        return (semanticsNode.z() || semanticsNode.w().e(SemanticsProperties.f5994a.n())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(SemanticsNode semanticsNode, androidx.compose.ui.semantics.i iVar) {
        Iterator it = iVar.iterator();
        while (it.hasNext()) {
            if (!semanticsNode.n().e((SemanticsPropertyKey) ((Map.Entry) it.next()).getKey())) {
                return true;
            }
        }
        return false;
    }
}
