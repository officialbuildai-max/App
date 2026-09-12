package com.google.android.exoplayer2.ui;

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
import com.google.android.exoplayer2.ui.k;
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
/* loaded from: classes3.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f27246a = Pattern.compile("(&#13;)?&#10;");

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f27247a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f27248b;

        private b(String str, Map map) {
            this.f27247a = str;
            this.f27248b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: e, reason: collision with root package name */
        private static final Comparator f27249e = new Comparator() { // from class: com.google.android.exoplayer2.ui.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e11;
                e11 = k.c.e((k.c) obj, (k.c) obj2);
                return e11;
            }
        };

        /* renamed from: f, reason: collision with root package name */
        private static final Comparator f27250f = new Comparator() { // from class: com.google.android.exoplayer2.ui.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f11;
                f11 = k.c.f((k.c) obj, (k.c) obj2);
                return f11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f27251a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27252b;

        /* renamed from: c, reason: collision with root package name */
        public final String f27253c;

        /* renamed from: d, reason: collision with root package name */
        public final String f27254d;

        private c(int i11, int i12, String str, String str2) {
            this.f27251a = i11;
            this.f27252b = i12;
            this.f27253c = str;
            this.f27254d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f27252b, cVar.f27252b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar.f27253c.compareTo(cVar2.f27253c);
            return compareTo != 0 ? compareTo : cVar.f27254d.compareTo(cVar2.f27254d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int f(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f27251a, cVar.f27251a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar2.f27253c.compareTo(cVar.f27253c);
            return compareTo != 0 ? compareTo : cVar2.f27254d.compareTo(cVar.f27254d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final List f27255a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List f27256b = new ArrayList();
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
            StringBuilder sb2 = new StringBuilder(14);
            sb2.append("bg_");
            sb2.append(intValue);
            hashMap.put(h.a(sb2.toString()), com.google.android.exoplayer2.util.p0.C("background-color:%s;", h.b(intValue)));
        }
        SparseArray c11 = c(spanned, f11);
        StringBuilder sb3 = new StringBuilder(spanned.length());
        int i12 = 0;
        while (i11 < c11.size()) {
            int keyAt = c11.keyAt(i11);
            sb3.append(b(spanned.subSequence(i12, keyAt)));
            d dVar = (d) c11.get(keyAt);
            Collections.sort(dVar.f27256b, c.f27250f);
            Iterator it2 = dVar.f27256b.iterator();
            while (it2.hasNext()) {
                sb3.append(((c) it2.next()).f27254d);
            }
            Collections.sort(dVar.f27255a, c.f27249e);
            Iterator it3 = dVar.f27255a.iterator();
            while (it3.hasNext()) {
                sb3.append(((c) it3.next()).f27253c);
            }
            i11++;
            i12 = keyAt;
        }
        sb3.append(b(spanned.subSequence(i12, spanned.length())));
        return new b(sb3.toString(), hashMap);
    }

    private static String b(CharSequence charSequence) {
        return f27246a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray c(Spanned spanned, float f11) {
        SparseArray sparseArray = new SparseArray();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e11 = e(obj, f11);
            String d11 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e11 != null) {
                com.google.android.exoplayer2.util.a.e(d11);
                c cVar = new c(spanStart, spanEnd, e11, d11);
                f(sparseArray, spanStart).f27255a.add(cVar);
                f(sparseArray, spanEnd).f27256b.add(cVar);
            }
        }
        return sparseArray;
    }

    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof fa.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof fa.e)) {
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
            if (obj instanceof fa.c) {
                String b11 = b(((fa.c) obj).f62485a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(b11).length() + 16);
                sb2.append("<rt>");
                sb2.append(b11);
                sb2.append("</rt></ruby>");
                return sb2.toString();
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
            return com.google.android.exoplayer2.util.p0.C("<span style='color:%s;'>", h.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return com.google.android.exoplayer2.util.p0.C("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof fa.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            return com.google.android.exoplayer2.util.p0.C("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r4.getSize() : r4.getSize() / f11));
        }
        if (obj instanceof RelativeSizeSpan) {
            return com.google.android.exoplayer2.util.p0.C("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return com.google.android.exoplayer2.util.p0.C("<span style='font-family:\"%s\";'>", family);
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
        if (!(obj instanceof fa.c)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof fa.e)) {
                return null;
            }
            fa.e eVar = (fa.e) obj;
            return com.google.android.exoplayer2.util.p0.C("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.f62487a, eVar.f62488b), g(eVar.f62489c));
        }
        int i11 = ((fa.c) obj).f62486b;
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
