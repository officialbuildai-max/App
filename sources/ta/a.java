package ta;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R$attr;
import xa.b;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final int f76291f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f76292a;

    /* renamed from: b, reason: collision with root package name */
    private final int f76293b;

    /* renamed from: c, reason: collision with root package name */
    private final int f76294c;

    /* renamed from: d, reason: collision with root package name */
    private final int f76295d;

    /* renamed from: e, reason: collision with root package name */
    private final float f76296e;

    public a(Context context) {
        this(b.b(context, R$attr.elevationOverlayEnabled, false), com.google.android.material.color.b.b(context, R$attr.elevationOverlayColor, 0), com.google.android.material.color.b.b(context, R$attr.elevationOverlayAccentColor, 0), com.google.android.material.color.b.b(context, R$attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public a(boolean z10, int i11, int i12, int i13, float f11) {
        this.f76292a = z10;
        this.f76293b = i11;
        this.f76294c = i12;
        this.f76295d = i13;
        this.f76296e = f11;
    }

    private boolean f(int i11) {
        return z0.b.p(i11, 255) == this.f76295d;
    }

    public float a(float f11) {
        if (this.f76296e <= 0.0f || f11 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f11 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i11, float f11) {
        int i12;
        float a11 = a(f11);
        int alpha = Color.alpha(i11);
        int j11 = com.google.android.material.color.b.j(z0.b.p(i11, 255), this.f76293b, a11);
        if (a11 > 0.0f && (i12 = this.f76294c) != 0) {
            j11 = com.google.android.material.color.b.i(j11, z0.b.p(i12, f76291f));
        }
        return z0.b.p(j11, alpha);
    }

    public int c(int i11, float f11) {
        return (this.f76292a && f(i11)) ? b(i11, f11) : i11;
    }

    public int d(float f11) {
        return c(this.f76295d, f11);
    }

    public boolean e() {
        return this.f76292a;
    }
}
