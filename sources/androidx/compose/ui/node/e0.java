package androidx.compose.ui.node;

import androidx.compose.ui.f;

/* loaded from: classes.dex */
public abstract class e0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final f.c b(f fVar) {
        int a11 = s0.a(4);
        int a12 = s0.a(2);
        f.c b12 = fVar.getNode().b1();
        if (b12 == null || (b12.a1() & a11) == 0) {
            return null;
        }
        while (b12 != null && (b12.f1() & a12) == 0) {
            if ((b12.f1() & a11) != 0) {
                return b12;
            }
            b12 = b12.b1();
        }
        return null;
    }
}
