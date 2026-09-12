package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.n;
import androidx.compose.ui.text.font.o;
import androidx.compose.ui.text.font.p;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.m;
import androidx.compose.ui.text.style.o;
import androidx.compose.ui.text.x;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import n0.i;
import o0.w;
import o0.y;

/* loaded from: classes.dex */
public abstract class f {
    public static final x a(AndroidTextPaint androidTextPaint, x xVar, Function4 function4, o0.e eVar, boolean z10) {
        long g11 = w.g(xVar.k());
        y.a aVar = y.f70755b;
        if (y.g(g11, aVar.b())) {
            androidTextPaint.setTextSize(eVar.h0(xVar.k()));
        } else if (y.g(g11, aVar.a())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * w.h(xVar.k()));
        }
        if (d(xVar)) {
            h i11 = xVar.i();
            p n11 = xVar.n();
            if (n11 == null) {
                n11 = p.f6224b.a();
            }
            n l11 = xVar.l();
            n c11 = n.c(l11 != null ? l11.i() : n.f6214b.b());
            o m11 = xVar.m();
            androidTextPaint.setTypeface((Typeface) function4.invoke(i11, n11, c11, o.e(m11 != null ? m11.k() : o.f6218b.a())));
        }
        if (xVar.p() != null && !Intrinsics.c(xVar.p(), i.f70184c.a())) {
            if (Build.VERSION.SDK_INT >= 24) {
                d.f6396a.b(androidTextPaint, xVar.p());
            } else {
                androidTextPaint.setTextLocale((xVar.p().isEmpty() ? n0.h.f70182b.a() : xVar.p().e(0)).a());
            }
        }
        if (xVar.j() != null && !Intrinsics.c(xVar.j(), "")) {
            androidTextPaint.setFontFeatureSettings(xVar.j());
        }
        if (xVar.u() != null && !Intrinsics.c(xVar.u(), m.f6500c.a())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * xVar.u().b());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + xVar.u().c());
        }
        androidTextPaint.f(xVar.g());
        androidTextPaint.e(xVar.f(), y.m.f78614b.a(), xVar.c());
        androidTextPaint.h(xVar.r());
        androidTextPaint.i(xVar.s());
        androidTextPaint.g(xVar.h());
        if (y.g(w.g(xVar.o()), aVar.b()) && w.h(xVar.o()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float h02 = eVar.h0(xVar.o());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(h02 / textSize);
            }
        } else if (y.g(w.g(xVar.o()), aVar.a())) {
            androidTextPaint.setLetterSpacing(w.h(xVar.o()));
        }
        return c(xVar.o(), z10, xVar.d(), xVar.e());
    }

    public static final float b(float f11) {
        if (f11 == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f11;
    }

    private static final x c(long j11, boolean z10, long j12, androidx.compose.ui.text.style.a aVar) {
        long j13 = j12;
        boolean z11 = false;
        boolean z12 = z10 && y.g(w.g(j11), y.f70755b.b()) && w.h(j11) != 0.0f;
        u1.a aVar2 = u1.f4733b;
        boolean z13 = (u1.m(j13, aVar2.e()) || u1.m(j13, aVar2.d())) ? false : true;
        if (aVar != null) {
            if (!androidx.compose.ui.text.style.a.e(aVar.h(), androidx.compose.ui.text.style.a.f6429b.a())) {
                z11 = true;
            }
        }
        if (!z12 && !z13 && !z11) {
            return null;
        }
        long a11 = z12 ? j11 : w.f70751b.a();
        if (!z13) {
            j13 = aVar2.e();
        }
        return new x(0L, 0L, null, null, null, null, null, a11, z11 ? aVar : null, null, null, j13, null, null, null, null, 63103, null);
    }

    public static final boolean d(x xVar) {
        return (xVar.i() == null && xVar.l() == null && xVar.n() == null) ? false : true;
    }

    public static final void e(AndroidTextPaint androidTextPaint, androidx.compose.ui.text.style.o oVar) {
        if (oVar == null) {
            oVar = androidx.compose.ui.text.style.o.f6508c.a();
        }
        androidTextPaint.setFlags(oVar.c() ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int b11 = oVar.b();
        o.b.a aVar = o.b.f6513a;
        if (o.b.e(b11, aVar.b())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (o.b.e(b11, aVar.a())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!o.b.e(b11, aVar.c())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
