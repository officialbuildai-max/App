package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9228a = false;

    /* renamed from: b, reason: collision with root package name */
    private Spannable f9229b;

    /* loaded from: classes.dex */
    private static class a {
        static IntStream a(CharSequence charSequence) {
            IntStream chars;
            chars = charSequence.chars();
            return chars;
        }

        static IntStream b(CharSequence charSequence) {
            IntStream codePoints;
            codePoints = charSequence.codePoints();
            return codePoints;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.t.b
        boolean a(CharSequence charSequence) {
            return androidx.core.text.d.a(charSequence) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Spannable spannable) {
        this.f9229b = spannable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(CharSequence charSequence) {
        this.f9229b = new SpannableString(charSequence);
    }

    private void a() {
        Spannable spannable = this.f9229b;
        if (!this.f9228a && c().a(spannable)) {
            this.f9229b = new SpannableString(spannable);
        }
        this.f9228a = true;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spannable b() {
        return this.f9229b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i11) {
        return this.f9229b.charAt(i11);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f9229b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f9229b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f9229b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f9229b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f9229b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i11, int i12, Class cls) {
        return this.f9229b.getSpans(i11, i12, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f9229b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.f9229b.nextSpanTransition(i11, i12, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f9229b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i11, int i12, int i13) {
        a();
        this.f9229b.setSpan(obj, i11, i12, i13);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i11, int i12) {
        return this.f9229b.subSequence(i11, i12);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f9229b.toString();
    }
}
