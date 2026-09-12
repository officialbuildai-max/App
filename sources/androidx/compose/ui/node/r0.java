package androidx.compose.ui.node;

import androidx.compose.ui.f;

/* loaded from: classes.dex */
public abstract class r0 {
    public static final /* synthetic */ f.c a(f fVar, int i11, int i12) {
        return b(fVar, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f.c b(f fVar, int i11, int i12) {
        f.c b12 = fVar.getNode().b1();
        if (b12 == null || (b12.a1() & i11) == 0) {
            return null;
        }
        while (b12 != null) {
            int f12 = b12.f1();
            if ((f12 & i12) != 0) {
                return null;
            }
            if ((f12 & i11) != 0) {
                return b12;
            }
            b12 = b12.b1();
        }
        return null;
    }
}
