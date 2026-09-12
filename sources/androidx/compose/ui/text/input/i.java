package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo;
import kotlin.jvm.JvmStatic;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f6307a = new i();

    private i() {
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder a(CursorAnchorInfo.Builder builder, androidx.compose.ui.text.z zVar, y.i iVar) {
        int q11;
        int q12;
        if (!iVar.n() && (q11 = zVar.q(iVar.i())) <= (q12 = zVar.q(iVar.c()))) {
            while (true) {
                builder.addVisibleLineBounds(zVar.r(q11), zVar.u(q11), zVar.s(q11), zVar.l(q11));
                if (q11 == q12) {
                    break;
                }
                q11++;
            }
        }
        return builder;
    }
}
