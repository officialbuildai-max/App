package xa;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import y0.h;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f78279a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f78280b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f78281c;

    /* renamed from: d, reason: collision with root package name */
    public final String f78282d;

    /* renamed from: e, reason: collision with root package name */
    public final int f78283e;

    /* renamed from: f, reason: collision with root package name */
    public final int f78284f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f78285g;

    /* renamed from: h, reason: collision with root package name */
    public final float f78286h;

    /* renamed from: i, reason: collision with root package name */
    public final float f78287i;

    /* renamed from: j, reason: collision with root package name */
    public final float f78288j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f78289k;

    /* renamed from: l, reason: collision with root package name */
    public final float f78290l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f78291m;

    /* renamed from: n, reason: collision with root package name */
    private float f78292n;

    /* renamed from: o, reason: collision with root package name */
    private final int f78293o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f78294p = false;

    /* renamed from: q, reason: collision with root package name */
    private Typeface f78295q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f78296a;

        a(f fVar) {
            this.f78296a = fVar;
        }

        @Override // y0.h.e
        /* renamed from: h */
        public void f(int i11) {
            d.this.f78294p = true;
            this.f78296a.a(i11);
        }

        @Override // y0.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            d dVar = d.this;
            dVar.f78295q = Typeface.create(typeface, dVar.f78283e);
            d.this.f78294p = true;
            this.f78296a.b(d.this.f78295q, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f78298a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f78299b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f78300c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f78298a = context;
            this.f78299b = textPaint;
            this.f78300c = fVar;
        }

        @Override // xa.f
        public void a(int i11) {
            this.f78300c.a(i11);
        }

        @Override // xa.f
        public void b(Typeface typeface, boolean z10) {
            d.this.p(this.f78298a, this.f78299b, typeface);
            this.f78300c.b(typeface, z10);
        }
    }

    public d(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i11, R$styleable.TextAppearance);
        l(obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f));
        k(c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor));
        this.f78279a = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.f78280b = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f78283e = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f78284f = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int g11 = c.g(obtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.f78293o = obtainStyledAttributes.getResourceId(g11, 0);
        this.f78282d = obtainStyledAttributes.getString(g11);
        this.f78285g = obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f78281c = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f78286h = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f78287i = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f78288j = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i11, R$styleable.MaterialTextAppearance);
        this.f78289k = obtainStyledAttributes2.hasValue(R$styleable.MaterialTextAppearance_android_letterSpacing);
        this.f78290l = obtainStyledAttributes2.getFloat(R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f78295q == null && (str = this.f78282d) != null) {
            this.f78295q = Typeface.create(str, this.f78283e);
        }
        if (this.f78295q == null) {
            int i11 = this.f78284f;
            if (i11 == 1) {
                this.f78295q = Typeface.SANS_SERIF;
            } else if (i11 == 2) {
                this.f78295q = Typeface.SERIF;
            } else if (i11 != 3) {
                this.f78295q = Typeface.DEFAULT;
            } else {
                this.f78295q = Typeface.MONOSPACE;
            }
            this.f78295q = Typeface.create(this.f78295q, this.f78283e);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i11 = this.f78293o;
        return (i11 != 0 ? y0.h.c(context, i11) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f78295q;
    }

    public Typeface f(Context context) {
        if (this.f78294p) {
            return this.f78295q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface g11 = y0.h.g(context, this.f78293o);
                this.f78295q = g11;
                if (g11 != null) {
                    this.f78295q = Typeface.create(g11, this.f78283e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error loading font ");
                sb2.append(this.f78282d);
            }
        }
        d();
        this.f78294p = true;
        return this.f78295q;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i11 = this.f78293o;
        if (i11 == 0) {
            this.f78294p = true;
        }
        if (this.f78294p) {
            fVar.b(this.f78295q, true);
            return;
        }
        try {
            y0.h.i(context, i11, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f78294p = true;
            fVar.a(1);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error loading font ");
            sb2.append(this.f78282d);
            this.f78294p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f78291m;
    }

    public float j() {
        return this.f78292n;
    }

    public void k(ColorStateList colorStateList) {
        this.f78291m = colorStateList;
    }

    public void l(float f11) {
        this.f78292n = f11;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f78291m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f11 = this.f78288j;
        float f12 = this.f78286h;
        float f13 = this.f78287i;
        ColorStateList colorStateList2 = this.f78281c;
        textPaint.setShadowLayer(f11, f12, f13, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface a11 = h.a(context, typeface);
        if (a11 != null) {
            typeface = a11;
        }
        textPaint.setTypeface(typeface);
        int i11 = this.f78283e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i11 & 1) != 0);
        textPaint.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f78292n);
        if (this.f78289k) {
            textPaint.setLetterSpacing(this.f78290l);
        }
    }
}
