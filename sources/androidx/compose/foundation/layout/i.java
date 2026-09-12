package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.b;
import androidx.compose.ui.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.compose.ui.layout.t f2934a = new ColumnMeasurePolicy(b.f2911a.d(), androidx.compose.ui.b.f4162a.i());

    public static final androidx.compose.ui.layout.t a(b.k kVar, b.InterfaceC0044b interfaceC0044b, androidx.compose.runtime.i iVar, int i11) {
        androidx.compose.ui.layout.t tVar;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(1089876336, i11, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:106)");
        }
        if (Intrinsics.c(kVar, b.f2911a.d()) && Intrinsics.c(interfaceC0044b, androidx.compose.ui.b.f4162a.i())) {
            iVar.P(345962472);
            iVar.K();
            tVar = f2934a;
        } else {
            iVar.P(346016319);
            boolean z10 = ((((i11 & 14) ^ 6) > 4 && iVar.O(kVar)) || (i11 & 6) == 4) | ((((i11 & 112) ^ 48) > 32 && iVar.O(interfaceC0044b)) || (i11 & 48) == 32);
            Object y10 = iVar.y();
            if (z10 || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new ColumnMeasurePolicy(kVar, interfaceC0044b);
                iVar.p(y10);
            }
            tVar = (ColumnMeasurePolicy) y10;
            iVar.K();
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return tVar;
    }

    public static final long b(boolean z10, int i11, int i12, int i13, int i14) {
        return !z10 ? o0.c.a(i12, i14, i11, i13) : o0.b.f70719b.a(i12, i14, i11, i13);
    }
}
