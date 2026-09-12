package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a0 implements x {
    private final Typeface c(String str, p pVar, int i11) {
        if (n.f(i11, n.f6214b.b()) && Intrinsics.c(pVar, p.f6224b.a()) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        int c11 = d.c(pVar, i11);
        return (str == null || str.length() == 0) ? Typeface.defaultFromStyle(c11) : Typeface.create(str, c11);
    }

    private final Typeface d(String str, p pVar, int i11) {
        if (str.length() == 0) {
            return null;
        }
        Typeface c11 = c(str, pVar, i11);
        if (Intrinsics.c(c11, Typeface.create(Typeface.DEFAULT, d.c(pVar, i11))) || Intrinsics.c(c11, c(null, pVar, i11))) {
            return null;
        }
        return c11;
    }

    @Override // androidx.compose.ui.text.font.x
    public Typeface a(s sVar, p pVar, int i11) {
        Typeface d11 = d(b0.b(sVar.c(), pVar), pVar, i11);
        return d11 == null ? c(sVar.c(), pVar, i11) : d11;
    }

    @Override // androidx.compose.ui.text.font.x
    public Typeface b(p pVar, int i11) {
        return c(null, pVar, i11);
    }
}
