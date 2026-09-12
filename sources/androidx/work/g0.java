package androidx.work;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class g0 {
    public static final Object a(f0 f0Var, String label, Function0 block) {
        Intrinsics.h(f0Var, "<this>");
        Intrinsics.h(label, "label");
        Intrinsics.h(block, "block");
        boolean isEnabled = f0Var.isEnabled();
        if (isEnabled) {
            try {
                f0Var.a(label);
            } catch (Throwable th2) {
                InlineMarker.b(1);
                if (isEnabled) {
                    f0Var.d();
                }
                InlineMarker.a(1);
                throw th2;
            }
        }
        Object invoke = block.invoke();
        InlineMarker.b(1);
        if (isEnabled) {
            f0Var.d();
        }
        InlineMarker.a(1);
        return invoke;
    }
}
