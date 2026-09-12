package androidx.compose.ui.node;

import androidx.compose.ui.f;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public abstract class v0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(f.c cVar, Function0 function0) {
        ObserverNodeOwnerScope g12 = cVar.g1();
        if (g12 == null) {
            g12 = new ObserverNodeOwnerScope((u0) cVar);
            cVar.y1(g12);
        }
        g.n(cVar).getSnapshotObserver().i(g12, ObserverNodeOwnerScope.f5438b.a(), function0);
    }
}
