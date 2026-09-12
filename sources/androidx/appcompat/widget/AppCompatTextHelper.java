package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;
import y0.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatTextHelper {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f1792a;

    /* renamed from: b, reason: collision with root package name */
    private h0 f1793b;

    /* renamed from: c, reason: collision with root package name */
    private h0 f1794c;

    /* renamed from: d, reason: collision with root package name */
    private h0 f1795d;

    /* renamed from: e, reason: collision with root package name */
    private h0 f1796e;

    /* renamed from: f, reason: collision with root package name */
    private h0 f1797f;

    /* renamed from: g, reason: collision with root package name */
    private h0 f1798g;

    /* renamed from: h, reason: collision with root package name */
    private h0 f1799h;

    /* renamed from: i, reason: collision with root package name */
    private final p f1800i;

    /* renamed from: j, reason: collision with root package name */
    private int f1801j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f1802k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f1803l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1804m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1805a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1806b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f1807c;

        a(int i11, int i12, WeakReference weakReference) {
            this.f1805a = i11;
            this.f1806b = i12;
            this.f1807c = weakReference;
        }

        @Override // y0.h.e
        /* renamed from: h */
        public void f(int i11) {
        }

        @Override // y0.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            int i11;
            if (Build.VERSION.SDK_INT >= 28 && (i11 = this.f1805a) != -1) {
                typeface = e.a(typeface, i11, (this.f1806b & 2) != 0);
            }
            AppCompatTextHelper.this.n(this.f1807c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i11, int i12, int i13, int i14) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i11, i12, i13, i14);
        }

        static void c(TextView textView, int[] iArr, int i11) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i11);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {
        static Typeface a(Typeface typeface, int i11, boolean z10) {
            return Typeface.create(typeface, i11, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextHelper(TextView textView) {
        this.f1792a = textView;
        this.f1800i = new p(textView);
    }

    private void B(int i11, float f11) {
        this.f1800i.t(i11, f11);
    }

    private void C(Context context, j0 j0Var) {
        String o11;
        this.f1801j = j0Var.k(R$styleable.TextAppearance_android_textStyle, this.f1801j);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int k11 = j0Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1802k = k11;
            if (k11 != -1) {
                this.f1801j &= 2;
            }
        }
        if (!j0Var.s(R$styleable.TextAppearance_android_fontFamily) && !j0Var.s(R$styleable.TextAppearance_fontFamily)) {
            if (j0Var.s(R$styleable.TextAppearance_android_typeface)) {
                this.f1804m = false;
                int k12 = j0Var.k(R$styleable.TextAppearance_android_typeface, 1);
                if (k12 == 1) {
                    this.f1803l = Typeface.SANS_SERIF;
                    return;
                } else if (k12 == 2) {
                    this.f1803l = Typeface.SERIF;
                    return;
                } else {
                    if (k12 != 3) {
                        return;
                    }
                    this.f1803l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1803l = null;
        int i12 = j0Var.s(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
        int i13 = this.f1802k;
        int i14 = this.f1801j;
        if (!context.isRestricted()) {
            try {
                Typeface j11 = j0Var.j(i12, this.f1801j, new a(i13, i14, new WeakReference(this.f1792a)));
                if (j11 != null) {
                    if (i11 < 28 || this.f1802k == -1) {
                        this.f1803l = j11;
                    } else {
                        this.f1803l = e.a(Typeface.create(j11, 0), this.f1802k, (this.f1801j & 2) != 0);
                    }
                }
                this.f1804m = this.f1803l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1803l != null || (o11 = j0Var.o(i12)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1802k == -1) {
            this.f1803l = Typeface.create(o11, this.f1801j);
        } else {
            this.f1803l = e.a(Typeface.create(o11, 0), this.f1802k, (this.f1801j & 2) != 0);
        }
    }

    private void a(Drawable drawable, h0 h0Var) {
        if (drawable == null || h0Var == null) {
            return;
        }
        f.i(drawable, h0Var, this.f1792a.getDrawableState());
    }

    private static h0 d(Context context, f fVar, int i11) {
        ColorStateList f11 = fVar.f(context, i11);
        if (f11 == null) {
            return null;
        }
        h0 h0Var = new h0();
        h0Var.f2112d = true;
        h0Var.f2109a = f11;
        return h0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1792a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f1792a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f1792a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f1792a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f1792a.getCompoundDrawables();
        TextView textView2 = this.f1792a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        h0 h0Var = this.f1799h;
        this.f1793b = h0Var;
        this.f1794c = h0Var;
        this.f1795d = h0Var;
        this.f1796e = h0Var;
        this.f1797f = h0Var;
        this.f1798g = h0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i11, float f11) {
        if (u0.f2198c || l()) {
            return;
        }
        B(i11, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1793b != null || this.f1794c != null || this.f1795d != null || this.f1796e != null) {
            Drawable[] compoundDrawables = this.f1792a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1793b);
            a(compoundDrawables[1], this.f1794c);
            a(compoundDrawables[2], this.f1795d);
            a(compoundDrawables[3], this.f1796e);
        }
        if (this.f1797f == null && this.f1798g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1792a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f1797f);
        a(compoundDrawablesRelative[2], this.f1798g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1800i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1800i.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1800i.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1800i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f1800i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1800i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        h0 h0Var = this.f1799h;
        if (h0Var != null) {
            return h0Var.f2109a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        h0 h0Var = this.f1799h;
        if (h0Var != null) {
            return h0Var.f2110b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f1800i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r17, int r18) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference weakReference, final Typeface typeface) {
        if (this.f1804m) {
            this.f1803l = typeface;
            final TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (!textView.isAttachedToWindow()) {
                    textView.setTypeface(typeface, this.f1801j);
                } else {
                    final int i11 = this.f1801j;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i11);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z10, int i11, int i12, int i13, int i14) {
        if (u0.f2198c) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i11) {
        String o11;
        j0 t11 = j0.t(context, i11, R$styleable.TextAppearance);
        if (t11.s(R$styleable.TextAppearance_textAllCaps)) {
            s(t11.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (t11.s(R$styleable.TextAppearance_android_textSize) && t11.f(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1792a.setTextSize(0, 0.0f);
        }
        C(context, t11);
        if (i12 >= 26 && t11.s(R$styleable.TextAppearance_fontVariationSettings) && (o11 = t11.o(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            d.d(this.f1792a, o11);
        }
        t11.x();
        Typeface typeface = this.f1803l;
        if (typeface != null) {
            this.f1792a.setTypeface(typeface, this.f1801j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f1792a.setAllCaps(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i11, int i12, int i13, int i14) {
        this.f1800i.p(i11, i12, i13, i14);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int[] iArr, int i11) {
        this.f1800i.q(iArr, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i11) {
        this.f1800i.r(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f1799h == null) {
            this.f1799h = new h0();
        }
        h0 h0Var = this.f1799h;
        h0Var.f2109a = colorStateList;
        h0Var.f2112d = colorStateList != null;
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f1799h == null) {
            this.f1799h = new h0();
        }
        h0 h0Var = this.f1799h;
        h0Var.f2110b = mode;
        h0Var.f2111c = mode != null;
        z();
    }
}
