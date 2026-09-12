package l0;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: classes2.dex */
public final class h implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f68539a;

    /* renamed from: b, reason: collision with root package name */
    private final int f68540b;

    /* renamed from: c, reason: collision with root package name */
    private final int f68541c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f68542d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f68543e;

    /* renamed from: f, reason: collision with root package name */
    private final float f68544f;

    /* renamed from: g, reason: collision with root package name */
    private int f68545g = Integer.MIN_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private int f68546h = Integer.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private int f68547i = Integer.MIN_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private int f68548j = Integer.MIN_VALUE;

    /* renamed from: k, reason: collision with root package name */
    private int f68549k;

    /* renamed from: l, reason: collision with root package name */
    private int f68550l;

    public h(float f11, int i11, int i12, boolean z10, boolean z11, float f12) {
        this.f68539a = f11;
        this.f68540b = i11;
        this.f68541c = i12;
        this.f68542d = z10;
        this.f68543e = z11;
        this.f68544f = f12;
        if ((0.0f > f12 || f12 > 1.0f) && f12 != -1.0f) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1");
        }
    }

    private final void a(Paint.FontMetricsInt fontMetricsInt) {
        int ceil = (int) Math.ceil(this.f68539a);
        int a11 = ceil - i.a(fontMetricsInt);
        float f11 = this.f68544f;
        if (f11 == -1.0f) {
            f11 = Math.abs(fontMetricsInt.ascent) / i.a(fontMetricsInt);
        }
        int ceil2 = (int) (a11 <= 0 ? Math.ceil(a11 * f11) : Math.ceil(a11 * (1.0f - f11)));
        int i11 = fontMetricsInt.descent;
        int i12 = ceil2 + i11;
        this.f68547i = i12;
        int i13 = i12 - ceil;
        this.f68546h = i13;
        if (this.f68542d) {
            i13 = fontMetricsInt.ascent;
        }
        this.f68545g = i13;
        if (this.f68543e) {
            i12 = i11;
        }
        this.f68548j = i12;
        this.f68549k = fontMetricsInt.ascent - i13;
        this.f68550l = i12 - i11;
    }

    public final h b(int i11, int i12, boolean z10) {
        return new h(this.f68539a, i11, i12, z10, this.f68543e, this.f68544f);
    }

    public final int c() {
        return this.f68549k;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i11, int i12, int i13, int i14, Paint.FontMetricsInt fontMetricsInt) {
        if (i.a(fontMetricsInt) <= 0) {
            return;
        }
        boolean z10 = i11 == this.f68540b;
        boolean z11 = i12 == this.f68541c;
        if (z10 && z11 && this.f68542d && this.f68543e) {
            return;
        }
        if (this.f68545g == Integer.MIN_VALUE) {
            a(fontMetricsInt);
        }
        fontMetricsInt.ascent = z10 ? this.f68545g : this.f68546h;
        fontMetricsInt.descent = z11 ? this.f68548j : this.f68547i;
    }

    public final int d() {
        return this.f68550l;
    }

    public final boolean e() {
        return this.f68543e;
    }
}
