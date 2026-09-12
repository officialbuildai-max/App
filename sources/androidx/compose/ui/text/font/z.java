package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class z implements x {
    private final Typeface c(String str, p pVar, int i11) {
        Typeface create;
        n.a aVar = n.f6214b;
        if (n.f(i11, aVar.b()) && Intrinsics.c(pVar, p.f6224b.a()) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        create = Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), pVar.h(), n.f(i11, aVar.a()));
        return create;
    }

    @Override // androidx.compose.ui.text.font.x
    public Typeface a(s sVar, p pVar, int i11) {
        return c(sVar.c(), pVar, i11);
    }

    @Override // androidx.compose.ui.text.font.x
    public Typeface b(p pVar, int i11) {
        return c(null, pVar, i11);
    }
}
