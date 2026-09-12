package k0;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;

/* loaded from: classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f66661a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f66662b;

    /* renamed from: c, reason: collision with root package name */
    private final int f66663c;

    /* renamed from: d, reason: collision with root package name */
    private float f66664d = Float.NaN;

    /* renamed from: e, reason: collision with root package name */
    private float f66665e = Float.NaN;

    /* renamed from: f, reason: collision with root package name */
    private BoringLayout.Metrics f66666f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f66667g;

    public g0(CharSequence charSequence, TextPaint textPaint, int i11) {
        this.f66661a = charSequence;
        this.f66662b = textPaint;
        this.f66663c = i11;
    }

    public final BoringLayout.Metrics a() {
        if (!this.f66667g) {
            this.f66666f = e.f66630a.c(this.f66661a, this.f66662b, f1.k(this.f66663c));
            this.f66667g = true;
        }
        return this.f66666f;
    }

    public final float b() {
        boolean e11;
        if (!Float.isNaN(this.f66664d)) {
            return this.f66664d;
        }
        BoringLayout.Metrics a11 = a();
        float f11 = a11 != null ? a11.width : -1;
        if (f11 < 0.0f) {
            CharSequence charSequence = this.f66661a;
            f11 = (float) Math.ceil(Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.f66662b));
        }
        e11 = i0.e(f11, this.f66661a, this.f66662b);
        if (e11) {
            f11 += 0.5f;
        }
        this.f66664d = f11;
        return f11;
    }

    public final float c() {
        if (!Float.isNaN(this.f66665e)) {
            return this.f66665e;
        }
        float c11 = i0.c(this.f66661a, this.f66662b);
        this.f66665e = c11;
        return c11;
    }
}
