package o3;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class f {
    public static void a(Spannable spannable, int i11, int i12, g gVar, c cVar, Map map, int i13) {
        c e11;
        g f11;
        int i14;
        if (gVar.n() != -1) {
            spannable.setSpan(new StyleSpan(gVar.n()), i11, i12, 33);
        }
        if (gVar.u()) {
            spannable.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (gVar.v()) {
            spannable.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (gVar.s()) {
            u1.g.b(spannable, new ForegroundColorSpan(gVar.d()), i11, i12, 33);
        }
        if (gVar.r()) {
            u1.g.b(spannable, new BackgroundColorSpan(gVar.b()), i11, i12, 33);
        }
        if (gVar.e() != null) {
            u1.g.b(spannable, new TypefaceSpan(gVar.e()), i11, i12, 33);
        }
        if (gVar.q() != null) {
            b bVar = (b) androidx.media3.common.util.a.e(gVar.q());
            int i15 = bVar.f70784a;
            if (i15 == -1) {
                i15 = (i13 == 2 || i13 == 1) ? 3 : 1;
                i14 = 1;
            } else {
                i14 = bVar.f70785b;
            }
            int i16 = bVar.f70786c;
            if (i16 == -2) {
                i16 = 1;
            }
            u1.g.b(spannable, new u1.h(i15, i14, i16), i11, i12, 33);
        }
        int l11 = gVar.l();
        if (l11 == 2) {
            c d11 = d(cVar, map);
            if (d11 != null && (e11 = e(d11, map)) != null) {
                if (e11.g() != 1 || e11.f(0).f70788b == null) {
                    u.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) a1.i(e11.f(0).f70788b);
                    g f12 = f(e11.f70792f, e11.l(), map);
                    int k11 = f12 != null ? f12.k() : -1;
                    if (k11 == -1 && (f11 = f(d11.f70792f, d11.l(), map)) != null) {
                        k11 = f11.k();
                    }
                    spannable.setSpan(new u1.f(str, k11), i11, i12, 33);
                }
            }
        } else if (l11 == 3 || l11 == 4) {
            spannable.setSpan(new a(), i11, i12, 33);
        }
        if (gVar.p()) {
            u1.g.b(spannable, new u1.d(), i11, i12, 33);
        }
        int g11 = gVar.g();
        if (g11 == 1) {
            u1.g.b(spannable, new AbsoluteSizeSpan((int) gVar.f(), true), i11, i12, 33);
        } else if (g11 == 2) {
            u1.g.b(spannable, new RelativeSizeSpan(gVar.f()), i11, i12, 33);
        } else {
            if (g11 != 3) {
                return;
            }
            u1.g.a(spannable, gVar.f() / 100.0f, i11, i12, 33);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static c d(c cVar, Map map) {
        while (cVar != null) {
            g f11 = f(cVar.f70792f, cVar.l(), map);
            if (f11 != null && f11.l() == 1) {
                return cVar;
            }
            cVar = cVar.f70796j;
        }
        return null;
    }

    private static c e(c cVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(cVar);
        while (!arrayDeque.isEmpty()) {
            c cVar2 = (c) arrayDeque.pop();
            g f11 = f(cVar2.f70792f, cVar2.l(), map);
            if (f11 != null && f11.l() == 3) {
                return cVar2;
            }
            for (int g11 = cVar2.g() - 1; g11 >= 0; g11--) {
                arrayDeque.push(cVar2.f(g11));
            }
        }
        return null;
    }

    public static g f(g gVar, String[] strArr, Map map) {
        int i11 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (g) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i11 < length) {
                    gVar2.a((g) map.get(strArr[i11]));
                    i11++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a((g) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i11 < length2) {
                    gVar.a((g) map.get(strArr[i11]));
                    i11++;
                }
            }
        }
        return gVar;
    }
}
