package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.l;
import androidx.compose.ui.R$string;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes.dex */
public abstract class m {
    public static final String a(int i11, androidx.compose.runtime.i iVar, int i12) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-726638443, i12, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        iVar.l(AndroidCompositionLocals_androidKt.f());
        Resources resources = ((Context) iVar.l(AndroidCompositionLocals_androidKt.g())).getResources();
        l.a aVar = l.f3495a;
        String string = l.i(i11, aVar.e()) ? resources.getString(R$string.navigation_menu) : l.i(i11, aVar.a()) ? resources.getString(R$string.close_drawer) : l.i(i11, aVar.b()) ? resources.getString(R$string.close_sheet) : l.i(i11, aVar.c()) ? resources.getString(R$string.default_error_message) : l.i(i11, aVar.d()) ? resources.getString(R$string.dropdown_menu) : l.i(i11, aVar.g()) ? resources.getString(R$string.range_start) : l.i(i11, aVar.f()) ? resources.getString(R$string.range_end) : "";
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return string;
    }
}
