package ia;

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
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class f {
    public static void a(Spannable spannable, int i11, int i12, g gVar, d dVar, Map map, int i13) {
        d e11;
        g f11;
        int i14;
        if (gVar.l() != -1) {
            spannable.setSpan(new StyleSpan(gVar.l()), i11, i12, 33);
        }
        if (gVar.s()) {
            spannable.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (gVar.t()) {
            spannable.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (gVar.q()) {
            fa.d.a(spannable, new ForegroundColorSpan(gVar.c()), i11, i12, 33);
        }
        if (gVar.p()) {
            fa.d.a(spannable, new BackgroundColorSpan(gVar.b()), i11, i12, 33);
        }
        if (gVar.d() != null) {
            fa.d.a(spannable, new TypefaceSpan(gVar.d()), i11, i12, 33);
        }
        if (gVar.o() != null) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e(gVar.o());
            int i15 = bVar.f65207a;
            if (i15 == -1) {
                i15 = (i13 == 2 || i13 == 1) ? 3 : 1;
                i14 = 1;
            } else {
                i14 = bVar.f65208b;
            }
            int i16 = bVar.f65209c;
            if (i16 == -2) {
                i16 = 1;
            }
            fa.d.a(spannable, new fa.e(i15, i14, i16), i11, i12, 33);
        }
        int j11 = gVar.j();
        if (j11 == 2) {
            d d11 = d(dVar, map);
            if (d11 != null && (e11 = e(d11, map)) != null) {
                if (e11.g() != 1 || e11.f(0).f65228b == null) {
                    s.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) p0.j(e11.f(0).f65228b);
                    g f12 = f(e11.f65232f, e11.l(), map);
                    int i17 = f12 != null ? f12.i() : -1;
                    if (i17 == -1 && (f11 = f(d11.f65232f, d11.l(), map)) != null) {
                        i17 = f11.i();
                    }
                    spannable.setSpan(new fa.c(str, i17), i11, i12, 33);
                }
            }
        } else if (j11 == 3 || j11 == 4) {
            spannable.setSpan(new a(), i11, i12, 33);
        }
        if (gVar.n()) {
            fa.d.a(spannable, new fa.a(), i11, i12, 33);
        }
        int f13 = gVar.f();
        if (f13 == 1) {
            fa.d.a(spannable, new AbsoluteSizeSpan((int) gVar.e(), true), i11, i12, 33);
        } else if (f13 == 2) {
            fa.d.a(spannable, new RelativeSizeSpan(gVar.e()), i11, i12, 33);
        } else {
            if (f13 != 3) {
                return;
            }
            fa.d.a(spannable, new RelativeSizeSpan(gVar.e() / 100.0f), i11, i12, 33);
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

    private static d d(d dVar, Map map) {
        while (dVar != null) {
            g f11 = f(dVar.f65232f, dVar.l(), map);
            if (f11 != null && f11.j() == 1) {
                return dVar;
            }
            dVar = dVar.f65236j;
        }
        return null;
    }

    private static d e(d dVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(dVar);
        while (!arrayDeque.isEmpty()) {
            d dVar2 = (d) arrayDeque.pop();
            g f11 = f(dVar2.f65232f, dVar2.l(), map);
            if (f11 != null && f11.j() == 3) {
                return dVar2;
            }
            for (int g11 = dVar2.g() - 1; g11 >= 0; g11--) {
                arrayDeque.push(dVar2.f(g11));
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
