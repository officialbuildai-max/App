package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.e0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final x f6249a = b0.a();

    public e0 a(d0 d0Var, u uVar, Function1 function1, Function1 function12) {
        Typeface a11;
        h c11 = d0Var.c();
        if (c11 == null ? true : c11 instanceof f) {
            a11 = this.f6249a.b(d0Var.e(), d0Var.d());
        } else {
            if (!(c11 instanceof s)) {
                return null;
            }
            a11 = this.f6249a.a((s) d0Var.c(), d0Var.e(), d0Var.d());
        }
        return new e0.a(a11, false, 2, null);
    }
}
