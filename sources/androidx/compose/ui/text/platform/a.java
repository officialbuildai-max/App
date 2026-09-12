package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.f;
import androidx.compose.ui.text.f0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.s;
import androidx.compose.ui.text.g0;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.i;
import androidx.compose.ui.text.x;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class a {
    private static final void a(SpannableString spannableString, x xVar, int i11, int i12, o0.e eVar, h.b bVar) {
        SpannableExtensions_androidKt.k(spannableString, xVar.g(), i11, i12);
        SpannableExtensions_androidKt.o(spannableString, xVar.k(), eVar, i11, i12);
        if (xVar.n() != null || xVar.l() != null) {
            androidx.compose.ui.text.font.p n11 = xVar.n();
            if (n11 == null) {
                n11 = androidx.compose.ui.text.font.p.f6224b.a();
            }
            androidx.compose.ui.text.font.n l11 = xVar.l();
            spannableString.setSpan(new StyleSpan(androidx.compose.ui.text.font.d.c(n11, l11 != null ? l11.i() : androidx.compose.ui.text.font.n.f6214b.b())), i11, i12, 33);
        }
        if (xVar.i() != null) {
            if (xVar.i() instanceof s) {
                spannableString.setSpan(new TypefaceSpan(((s) xVar.i()).c()), i11, i12, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                androidx.compose.ui.text.font.h i13 = xVar.i();
                androidx.compose.ui.text.font.o m11 = xVar.m();
                Object value = androidx.compose.ui.text.font.i.a(bVar, i13, null, 0, m11 != null ? m11.k() : androidx.compose.ui.text.font.o.f6218b.a(), 6, null).getValue();
                Intrinsics.f(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(g.f6397a.a((Typeface) value), i11, i12, 33);
            }
        }
        if (xVar.s() != null) {
            androidx.compose.ui.text.style.i s11 = xVar.s();
            i.a aVar = androidx.compose.ui.text.style.i.f6484b;
            if (s11.d(aVar.d())) {
                spannableString.setSpan(new UnderlineSpan(), i11, i12, 33);
            }
            if (xVar.s().d(aVar.b())) {
                spannableString.setSpan(new StrikethroughSpan(), i11, i12, 33);
            }
        }
        if (xVar.u() != null) {
            spannableString.setSpan(new ScaleXSpan(xVar.u().b()), i11, i12, 33);
        }
        SpannableExtensions_androidKt.s(spannableString, xVar.p(), i11, i12);
        SpannableExtensions_androidKt.h(spannableString, xVar.d(), i11, i12);
    }

    public static final SpannableString b(AnnotatedString annotatedString, o0.e eVar, h.b bVar, r rVar) {
        x a11;
        SpannableString spannableString = new SpannableString(annotatedString.i());
        List h11 = annotatedString.h();
        if (h11 != null) {
            int size = h11.size();
            for (int i11 = 0; i11 < size; i11++) {
                AnnotatedString.c cVar = (AnnotatedString.c) h11.get(i11);
                x xVar = (x) cVar.a();
                int b11 = cVar.b();
                int c11 = cVar.c();
                a11 = xVar.a((r38 & 1) != 0 ? xVar.g() : 0L, (r38 & 2) != 0 ? xVar.f6530b : 0L, (r38 & 4) != 0 ? xVar.f6531c : null, (r38 & 8) != 0 ? xVar.f6532d : null, (r38 & 16) != 0 ? xVar.f6533e : null, (r38 & 32) != 0 ? xVar.f6534f : null, (r38 & 64) != 0 ? xVar.f6535g : null, (r38 & 128) != 0 ? xVar.f6536h : 0L, (r38 & 256) != 0 ? xVar.f6537i : null, (r38 & 512) != 0 ? xVar.f6538j : null, (r38 & 1024) != 0 ? xVar.f6539k : null, (r38 & 2048) != 0 ? xVar.f6540l : 0L, (r38 & 4096) != 0 ? xVar.f6541m : null, (r38 & 8192) != 0 ? xVar.f6542n : null, (r38 & 16384) != 0 ? xVar.f6543o : null, (r38 & 32768) != 0 ? xVar.f6544p : null);
                a(spannableString, a11, b11, c11, eVar, bVar);
            }
        }
        List j11 = annotatedString.j(0, annotatedString.length());
        int size2 = j11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            AnnotatedString.c cVar2 = (AnnotatedString.c) j11.get(i12);
            spannableString.setSpan(androidx.compose.ui.text.platform.extensions.g.a((f0) cVar2.a()), cVar2.b(), cVar2.c(), 33);
        }
        List k11 = annotatedString.k(0, annotatedString.length());
        int size3 = k11.size();
        for (int i13 = 0; i13 < size3; i13++) {
            AnnotatedString.c cVar3 = (AnnotatedString.c) k11.get(i13);
            spannableString.setSpan(rVar.c((g0) cVar3.a()), cVar3.b(), cVar3.c(), 33);
        }
        List d11 = annotatedString.d(0, annotatedString.length());
        int size4 = d11.size();
        for (int i14 = 0; i14 < size4; i14++) {
            AnnotatedString.c cVar4 = (AnnotatedString.c) d11.get(i14);
            if (cVar4.f() != cVar4.d()) {
                androidx.compose.ui.text.f fVar = (androidx.compose.ui.text.f) cVar4.e();
                if (fVar instanceof f.b) {
                    fVar.a();
                    spannableString.setSpan(rVar.b(c(cVar4)), cVar4.f(), cVar4.d(), 33);
                } else {
                    spannableString.setSpan(rVar.a(cVar4), cVar4.f(), cVar4.d(), 33);
                }
            }
        }
        return spannableString;
    }

    private static final AnnotatedString.c c(AnnotatedString.c cVar) {
        Object e11 = cVar.e();
        Intrinsics.f(e11, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new AnnotatedString.c((f.b) e11, cVar.f(), cVar.d());
    }
}
