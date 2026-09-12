package k0;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    private static final d1 f66658a = new d1();

    /* renamed from: b, reason: collision with root package name */
    private static final long f66659b = a(0, 0);

    public static final long a(int i11, int i12) {
        return g1.a((i12 & 4294967295L) | (i11 << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint.FontMetricsInt h(e1 e1Var, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, l0.h[] hVarArr) {
        StaticLayout a11;
        int l11 = e1Var.l() - 1;
        if (e1Var.h().getLineStart(l11) != e1Var.h().getLineEnd(l11) || hVarArr == null || hVarArr.length == 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString("\u200b");
        l0.h hVar = (l0.h) ArraysKt.V(hVarArr);
        spannableString.setSpan(hVar.b(0, spannableString.length(), (l11 == 0 || !hVar.e()) ? hVar.e() : false), 0, spannableString.length(), 33);
        a11 = z0.f66675a.a(spannableString, textPaint, Integer.MAX_VALUE, (r47 & 8) != 0 ? 0 : 0, (r47 & 16) != 0 ? spannableString.length() : spannableString.length(), (r47 & 32) != 0 ? d0.f66625a.b() : textDirectionHeuristic, (r47 & 64) != 0 ? d0.f66625a.a() : null, (r47 & 128) != 0 ? Integer.MAX_VALUE : 0, (r47 & 256) != 0 ? null : null, (r47 & 512) != 0 ? Integer.MAX_VALUE : 0, (r47 & 1024) != 0 ? 1.0f : 0.0f, (r47 & 2048) != 0 ? 0.0f : 0.0f, (r47 & 4096) != 0 ? 0 : 0, (r47 & 8192) != 0 ? false : e1Var.g(), (r47 & 16384) != 0 ? true : e1Var.d(), (32768 & r47) != 0 ? 0 : 0, (65536 & r47) != 0 ? 0 : 0, (131072 & r47) != 0 ? 0 : 0, (262144 & r47) != 0 ? 0 : 0, (524288 & r47) != 0 ? null : null, (r47 & 1048576) != 0 ? null : null);
        Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
        fontMetricsInt.ascent = a11.getLineAscent(0);
        fontMetricsInt.descent = a11.getLineDescent(0);
        fontMetricsInt.top = a11.getLineTop(0);
        fontMetricsInt.bottom = a11.getLineBottom(0);
        return fontMetricsInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(l0.h[] hVarArr) {
        int i11 = 0;
        int i12 = 0;
        for (l0.h hVar : hVarArr) {
            if (hVar.c() < 0) {
                i11 = Math.max(i11, Math.abs(hVar.c()));
            }
            if (hVar.d() < 0) {
                i12 = Math.max(i11, Math.abs(hVar.d()));
            }
        }
        return (i11 == 0 && i12 == 0) ? f66659b : a(i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l0.h[] j(e1 e1Var) {
        if (!(e1Var.C() instanceof Spanned)) {
            return null;
        }
        CharSequence C = e1Var.C();
        Intrinsics.f(C, "null cannot be cast to non-null type android.text.Spanned");
        if (!m0.a((Spanned) C, l0.h.class) && e1Var.C().length() > 0) {
            return null;
        }
        CharSequence C2 = e1Var.C();
        Intrinsics.f(C2, "null cannot be cast to non-null type android.text.Spanned");
        return (l0.h[]) ((Spanned) C2).getSpans(0, e1Var.C().length(), l0.h.class);
    }

    public static final TextDirectionHeuristic k(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.LOCALE : TextDirectionHeuristics.ANYRTL_LTR : TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(e1 e1Var) {
        if (e1Var.g() || e1Var.D()) {
            return f66659b;
        }
        TextPaint paint = e1Var.h().getPaint();
        CharSequence text = e1Var.h().getText();
        Rect c11 = l0.c(paint, text, e1Var.h().getLineStart(0), e1Var.h().getLineEnd(0));
        int lineAscent = e1Var.h().getLineAscent(0);
        int i11 = c11.top;
        int topPadding = i11 < lineAscent ? lineAscent - i11 : e1Var.h().getTopPadding();
        if (e1Var.l() != 1) {
            int l11 = e1Var.l() - 1;
            c11 = l0.c(paint, text, e1Var.h().getLineStart(l11), e1Var.h().getLineEnd(l11));
        }
        int lineDescent = e1Var.h().getLineDescent(e1Var.l() - 1);
        int i12 = c11.bottom;
        int bottomPadding = i12 > lineDescent ? i12 - lineDescent : e1Var.h().getBottomPadding();
        return (topPadding == 0 && bottomPadding == 0) ? f66659b : a(topPadding, bottomPadding);
    }

    public static final boolean m(Layout layout, int i11) {
        return layout.getEllipsisCount(i11) > 0;
    }
}
