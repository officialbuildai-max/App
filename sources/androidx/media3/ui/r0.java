package androidx.media3.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.media3.ui.r0;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class r0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f13795a = Pattern.compile("(&#13;)?&#10;");

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f13796a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f13797b;

        private b(String str, Map map) {
            this.f13796a = str;
            this.f13797b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: e, reason: collision with root package name */
        private static final Comparator f13798e = new Comparator() { // from class: androidx.media3.ui.s0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e11;
                e11 = r0.c.e((r0.c) obj, (r0.c) obj2);
                return e11;
            }
        };

        /* renamed from: f, reason: collision with root package name */
        private static final Comparator f13799f = new Comparator() { // from class: androidx.media3.ui.t0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f11;
                f11 = r0.c.f((r0.c) obj, (r0.c) obj2);
                return f11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f13800a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13801b;

        /* renamed from: c, reason: collision with root package name */
        public final String f13802c;

        /* renamed from: d, reason: collision with root package name */
        public final String f13803d;

        private c(int i11, int i12, String str, String str2) {
            this.f13800a = i11;
            this.f13801b = i12;
            this.f13802c = str;
            this.f13803d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f13801b, cVar.f13801b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar.f13802c.compareTo(cVar2.f13802c);
            return compareTo != 0 ? compareTo : cVar.f13803d.compareTo(cVar2.f13803d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int f(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f13800a, cVar.f13800a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar2.f13802c.compareTo(cVar.f13802c);
            return compareTo != 0 ? compareTo : cVar2.f13803d.compareTo(cVar.f13803d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final List f13804a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List f13805b = new ArrayList();
    }

    public static b a(CharSequence charSequence, float f11) {
        int i11 = 0;
        if (charSequence == null) {
            return new b("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), ImmutableMap.of());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            hashMap.put(g.a("bg_" + intValue), androidx.media3.common.util.a1.G("background-color:%s;", g.b(intValue)));
        }
        SparseArray c11 = c(spanned, f11);
        StringBuilder sb2 = new StringBuilder(spanned.length());
        int i12 = 0;
        while (i11 < c11.size()) {
            int keyAt = c11.keyAt(i11);
            sb2.append(b(spanned.subSequence(i12, keyAt)));
            d dVar = (d) c11.get(keyAt);
            Collections.sort(dVar.f13805b, c.f13799f);
            Iterator it2 = dVar.f13805b.iterator();
            while (it2.hasNext()) {
                sb2.append(((c) it2.next()).f13803d);
            }
            Collections.sort(dVar.f13804a, c.f13798e);
            Iterator it3 = dVar.f13804a.iterator();
            while (it3.hasNext()) {
                sb2.append(((c) it3.next()).f13802c);
            }
            i11++;
            i12 = keyAt;
        }
        sb2.append(b(spanned.subSequence(i12, spanned.length())));
        return new b(sb2.toString(), hashMap);
    }

    private static String b(CharSequence charSequence) {
        return f13795a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray c(Spanned spanned, float f11) {
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e11 = e(obj, f11);
            String d11 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e11 != null) {
                androidx.media3.common.util.a.e(d11);
                c cVar = new c(spanStart, spanEnd, e11, d11);
                f(sparseArray, spanStart).f13804a.add(cVar);
                f(sparseArray, spanEnd).f13805b.add(cVar);
            }
        }
        return sparseArray;
    }

    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof u1.d) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof u1.h)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof u1.f) {
                return "<rt>" + b(((u1.f) obj).f76727a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    private static String e(Object obj, float f11) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return androidx.media3.common.util.a1.G("<span style='color:%s;'>", g.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return androidx.media3.common.util.a1.G("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof u1.d) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            return androidx.media3.common.util.a1.G("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r4.getSize() : r4.getSize() / f11));
        }
        if (obj instanceof RelativeSizeSpan) {
            return androidx.media3.common.util.a1.G("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return androidx.media3.common.util.a1.G("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof u1.f)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof u1.h)) {
                return null;
            }
            u1.h hVar = (u1.h) obj;
            return androidx.media3.common.util.a1.G("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(hVar.f76732a, hVar.f76733b), g(hVar.f76734c));
        }
        int i11 = ((u1.f) obj).f76728b;
        if (i11 == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i11 == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i11 != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    private static d f(SparseArray sparseArray, int i11) {
        d dVar = (d) sparseArray.get(i11);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i11, dVar2);
        return dVar2;
    }

    private static String g(int i11) {
        return i11 != 2 ? "over right" : "under left";
    }

    private static String h(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder();
        if (i12 == 1) {
            sb2.append("filled ");
        } else if (i12 == 2) {
            sb2.append("open ");
        }
        if (i11 == 0) {
            sb2.append("none");
        } else if (i11 == 1) {
            sb2.append("circle");
        } else if (i11 == 2) {
            sb2.append("dot");
        } else if (i11 != 3) {
            sb2.append("unset");
        } else {
            sb2.append("sesame");
        }
        return sb2.toString();
    }
}
