package k0;

import android.os.Build;
import android.text.StaticLayout;

/* loaded from: classes2.dex */
final class n0 implements a1 {
    @Override // k0.a1
    public StaticLayout a(b1 b1Var) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(b1Var.r(), b1Var.q(), b1Var.e(), b1Var.o(), b1Var.u());
        obtain.setTextDirection(b1Var.s());
        obtain.setAlignment(b1Var.a());
        obtain.setMaxLines(b1Var.n());
        obtain.setEllipsize(b1Var.c());
        obtain.setEllipsizedWidth(b1Var.d());
        obtain.setLineSpacing(b1Var.l(), b1Var.m());
        obtain.setIncludePad(b1Var.g());
        obtain.setBreakStrategy(b1Var.b());
        obtain.setHyphenationFrequency(b1Var.f());
        obtain.setIndents(b1Var.i(), b1Var.p());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            p0.a(obtain, b1Var.h());
        }
        if (i11 >= 28) {
            r0.a(obtain, b1Var.t());
        }
        if (i11 >= 33) {
            y0.b(obtain, b1Var.j(), b1Var.k());
        }
        return obtain.build();
    }

    @Override // k0.a1
    public boolean b(StaticLayout staticLayout, boolean z10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            return y0.a(staticLayout);
        }
        if (i11 >= 28) {
            return z10;
        }
        return false;
    }
}
