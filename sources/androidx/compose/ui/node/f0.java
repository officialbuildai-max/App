package androidx.compose.ui.node;

import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a */
    private static final o0.e f5461a = o0.g.b(1.0f, 0.0f, 2, null);

    public static final /* synthetic */ o0.e a() {
        return f5461a;
    }

    public static final y0 b(LayoutNode layoutNode) {
        y0 g02 = layoutNode.g0();
        if (g02 != null) {
            return g02;
        }
        g0.a.c("LayoutNode should be attached to an owner");
        throw new KotlinNothingValueException();
    }
}
