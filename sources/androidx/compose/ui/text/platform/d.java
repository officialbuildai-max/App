package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.style.j;
import androidx.compose.ui.text.u;
import androidx.compose.ui.text.w;
import androidx.core.text.v;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class d {
    public static final androidx.compose.ui.text.o a(String str, d0 d0Var, List list, List list2, o0.e eVar, h.b bVar) {
        return new AndroidParagraphIntrinsics(str, d0Var, list, list2, bVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(d0 d0Var) {
        u a11;
        w w11 = d0Var.w();
        return !(((w11 == null || (a11 = w11.a()) == null) ? null : androidx.compose.ui.text.e.d(a11.a())) == null ? false : androidx.compose.ui.text.e.g(r1.j(), androidx.compose.ui.text.e.f6167b.c()));
    }

    public static final int d(int i11, n0.i iVar) {
        Locale locale;
        j.a aVar = androidx.compose.ui.text.style.j.f6489b;
        if (androidx.compose.ui.text.style.j.j(i11, aVar.b())) {
            return 2;
        }
        if (!androidx.compose.ui.text.style.j.j(i11, aVar.c())) {
            if (androidx.compose.ui.text.style.j.j(i11, aVar.d())) {
                return 0;
            }
            if (androidx.compose.ui.text.style.j.j(i11, aVar.e())) {
                return 1;
            }
            if (!(androidx.compose.ui.text.style.j.j(i11, aVar.a()) ? true : androidx.compose.ui.text.style.j.j(i11, aVar.f()))) {
                throw new IllegalStateException("Invalid TextDirection.");
            }
            if (iVar == null || (locale = iVar.e(0).a()) == null) {
                locale = Locale.getDefault();
            }
            int a11 = v.a(locale);
            if (a11 == 0 || a11 != 1) {
                return 2;
            }
        }
        return 3;
    }
}
