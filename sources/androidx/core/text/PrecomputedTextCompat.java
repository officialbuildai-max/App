package androidx.core.text;

import android.os.Build;
import android.os.LocaleList;
import android.os.Trace;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f8300e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Spannable f8301a;

    /* renamed from: b, reason: collision with root package name */
    private final b f8302b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f8303c;

    /* renamed from: d, reason: collision with root package name */
    private final PrecomputedText f8304d;

    /* loaded from: classes.dex */
    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        /* loaded from: classes.dex */
        private static class a implements Callable {

            /* renamed from: a, reason: collision with root package name */
            private b f8305a;

            /* renamed from: b, reason: collision with root package name */
            private CharSequence f8306b;

            a(b bVar, CharSequence charSequence) {
                this.f8305a = bVar;
                this.f8306b = charSequence;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.a(this.f8306b, this.f8305a);
            }
        }

        PrecomputedTextFutureTask(b bVar, CharSequence charSequence) {
            super(new a(bVar, charSequence));
        }
    }

    /* loaded from: classes.dex */
    static class a {
        static Spannable a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f8307a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f8308b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8309c;

        /* renamed from: d, reason: collision with root package name */
        private final int f8310d;

        /* renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f8311e;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private final TextPaint f8312a;

            /* renamed from: c, reason: collision with root package name */
            private int f8314c = 1;

            /* renamed from: d, reason: collision with root package name */
            private int f8315d = 1;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f8313b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public a(TextPaint textPaint) {
                this.f8312a = textPaint;
            }

            public b a() {
                return new b(this.f8312a, this.f8313b, this.f8314c, this.f8315d);
            }

            public a b(int i11) {
                this.f8314c = i11;
                return this;
            }

            public a c(int i11) {
                this.f8315d = i11;
                return this;
            }

            public a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f8313b = textDirectionHeuristic;
                return this;
            }
        }

        public b(PrecomputedText.Params params) {
            TextPaint textPaint;
            TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.f8307a = textPaint;
            textDirection = params.getTextDirection();
            this.f8308b = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.f8309c = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.f8310d = hyphenationFrequency;
            this.f8311e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        b(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i11, int i12) {
            PrecomputedText.Params.Builder breakStrategy;
            PrecomputedText.Params.Builder hyphenationFrequency;
            PrecomputedText.Params.Builder textDirection;
            PrecomputedText.Params build;
            if (Build.VERSION.SDK_INT >= 29) {
                breakStrategy = j.a(textPaint).setBreakStrategy(i11);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(i12);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                build = textDirection.build();
                this.f8311e = build;
            } else {
                this.f8311e = null;
            }
            this.f8307a = textPaint;
            this.f8308b = textDirectionHeuristic;
            this.f8309c = i11;
            this.f8310d = i12;
        }

        public boolean a(b bVar) {
            LocaleList textLocales;
            LocaleList textLocales2;
            boolean equals;
            int i11 = Build.VERSION.SDK_INT;
            if (this.f8309c != bVar.b() || this.f8310d != bVar.c() || this.f8307a.getTextSize() != bVar.e().getTextSize() || this.f8307a.getTextScaleX() != bVar.e().getTextScaleX() || this.f8307a.getTextSkewX() != bVar.e().getTextSkewX() || this.f8307a.getLetterSpacing() != bVar.e().getLetterSpacing() || !TextUtils.equals(this.f8307a.getFontFeatureSettings(), bVar.e().getFontFeatureSettings()) || this.f8307a.getFlags() != bVar.e().getFlags()) {
                return false;
            }
            if (i11 >= 24) {
                textLocales = this.f8307a.getTextLocales();
                textLocales2 = bVar.e().getTextLocales();
                equals = textLocales.equals(textLocales2);
                if (!equals) {
                    return false;
                }
            } else if (!this.f8307a.getTextLocale().equals(bVar.e().getTextLocale())) {
                return false;
            }
            return this.f8307a.getTypeface() == null ? bVar.e().getTypeface() == null : this.f8307a.getTypeface().equals(bVar.e().getTypeface());
        }

        public int b() {
            return this.f8309c;
        }

        public int c() {
            return this.f8310d;
        }

        public TextDirectionHeuristic d() {
            return this.f8308b;
        }

        public TextPaint e() {
            return this.f8307a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return a(bVar) && this.f8308b == bVar.d();
        }

        public int hashCode() {
            LocaleList textLocales;
            if (Build.VERSION.SDK_INT < 24) {
                return androidx.core.util.d.b(Float.valueOf(this.f8307a.getTextSize()), Float.valueOf(this.f8307a.getTextScaleX()), Float.valueOf(this.f8307a.getTextSkewX()), Float.valueOf(this.f8307a.getLetterSpacing()), Integer.valueOf(this.f8307a.getFlags()), this.f8307a.getTextLocale(), this.f8307a.getTypeface(), Boolean.valueOf(this.f8307a.isElegantTextHeight()), this.f8308b, Integer.valueOf(this.f8309c), Integer.valueOf(this.f8310d));
            }
            Float valueOf = Float.valueOf(this.f8307a.getTextSize());
            Float valueOf2 = Float.valueOf(this.f8307a.getTextScaleX());
            Float valueOf3 = Float.valueOf(this.f8307a.getTextSkewX());
            Float valueOf4 = Float.valueOf(this.f8307a.getLetterSpacing());
            Integer valueOf5 = Integer.valueOf(this.f8307a.getFlags());
            textLocales = this.f8307a.getTextLocales();
            return androidx.core.util.d.b(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, textLocales, this.f8307a.getTypeface(), Boolean.valueOf(this.f8307a.isElegantTextHeight()), this.f8308b, Integer.valueOf(this.f8309c), Integer.valueOf(this.f8310d));
        }

        public String toString() {
            String fontVariationSettings;
            LocaleList textLocales;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f8307a.getTextSize());
            sb2.append(", textScaleX=" + this.f8307a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f8307a.getTextSkewX());
            int i11 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f8307a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f8307a.isElegantTextHeight());
            if (i11 >= 24) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(", textLocale=");
                textLocales = this.f8307a.getTextLocales();
                sb3.append(textLocales);
                sb2.append(sb3.toString());
            } else {
                sb2.append(", textLocale=" + this.f8307a.getTextLocale());
            }
            sb2.append(", typeface=" + this.f8307a.getTypeface());
            if (i11 >= 26) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(", variationSettings=");
                fontVariationSettings = this.f8307a.getFontVariationSettings();
                sb4.append(fontVariationSettings);
                sb2.append(sb4.toString());
            }
            sb2.append(", textDir=" + this.f8308b);
            sb2.append(", breakStrategy=" + this.f8309c);
            sb2.append(", hyphenationFrequency=" + this.f8310d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, b bVar) {
        this.f8301a = a.a(precomputedText);
        this.f8302b = bVar;
        this.f8303c = null;
        this.f8304d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    private PrecomputedTextCompat(CharSequence charSequence, b bVar, int[] iArr) {
        this.f8301a = new SpannableString(charSequence);
        this.f8302b = bVar;
        this.f8303c = iArr;
        this.f8304d = null;
    }

    public static PrecomputedTextCompat a(CharSequence charSequence, b bVar) {
        PrecomputedText.Params params;
        PrecomputedText create;
        androidx.core.util.i.g(charSequence);
        androidx.core.util.i.g(bVar);
        try {
            Trace.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params = bVar.f8311e) != null) {
                create = PrecomputedText.create(charSequence, params);
                return new PrecomputedTextCompat(create, bVar);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i11 = 0;
            while (i11 < length) {
                int indexOf = TextUtils.indexOf(charSequence, '\n', i11, length);
                i11 = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i11));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
            }
            StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), bVar.e(), Integer.MAX_VALUE).setBreakStrategy(bVar.b()).setHyphenationFrequency(bVar.c()).setTextDirection(bVar.d()).build();
            return new PrecomputedTextCompat(charSequence, bVar, iArr);
        } finally {
            Trace.endSection();
        }
    }

    public b b() {
        return this.f8302b;
    }

    public PrecomputedText c() {
        if (d.a(this.f8301a)) {
            return e.a(this.f8301a);
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i11) {
        return this.f8301a.charAt(i11);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f8301a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f8301a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f8301a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i11, int i12, Class cls) {
        Object[] spans;
        if (Build.VERSION.SDK_INT < 29) {
            return this.f8301a.getSpans(i11, i12, cls);
        }
        spans = this.f8304d.getSpans(i11, i12, cls);
        return spans;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f8301a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.f8301a.nextSpanTransition(i11, i12, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f8304d.removeSpan(obj);
        } else {
            this.f8301a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i11, int i12, int i13) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f8304d.setSpan(obj, i11, i12, i13);
        } else {
            this.f8301a.setSpan(obj, i11, i12, i13);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i11, int i12) {
        return this.f8301a.subSequence(i11, i12);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f8301a.toString();
    }
}
