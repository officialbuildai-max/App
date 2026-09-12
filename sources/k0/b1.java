package k0;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes2.dex */
final class b1 {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f66597a;

    /* renamed from: b, reason: collision with root package name */
    private final int f66598b;

    /* renamed from: c, reason: collision with root package name */
    private final int f66599c;

    /* renamed from: d, reason: collision with root package name */
    private final TextPaint f66600d;

    /* renamed from: e, reason: collision with root package name */
    private final int f66601e;

    /* renamed from: f, reason: collision with root package name */
    private final TextDirectionHeuristic f66602f;

    /* renamed from: g, reason: collision with root package name */
    private final Layout.Alignment f66603g;

    /* renamed from: h, reason: collision with root package name */
    private final int f66604h;

    /* renamed from: i, reason: collision with root package name */
    private final TextUtils.TruncateAt f66605i;

    /* renamed from: j, reason: collision with root package name */
    private final int f66606j;

    /* renamed from: k, reason: collision with root package name */
    private final float f66607k;

    /* renamed from: l, reason: collision with root package name */
    private final float f66608l;

    /* renamed from: m, reason: collision with root package name */
    private final int f66609m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f66610n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f66611o;

    /* renamed from: p, reason: collision with root package name */
    private final int f66612p;

    /* renamed from: q, reason: collision with root package name */
    private final int f66613q;

    /* renamed from: r, reason: collision with root package name */
    private final int f66614r;

    /* renamed from: s, reason: collision with root package name */
    private final int f66615s;

    /* renamed from: t, reason: collision with root package name */
    private final int[] f66616t;

    /* renamed from: u, reason: collision with root package name */
    private final int[] f66617u;

    public b1(CharSequence charSequence, int i11, int i12, TextPaint textPaint, int i13, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i14, TextUtils.TruncateAt truncateAt, int i15, float f11, float f12, int i16, boolean z10, boolean z11, int i17, int i18, int i19, int i20, int[] iArr, int[] iArr2) {
        this.f66597a = charSequence;
        this.f66598b = i11;
        this.f66599c = i12;
        this.f66600d = textPaint;
        this.f66601e = i13;
        this.f66602f = textDirectionHeuristic;
        this.f66603g = alignment;
        this.f66604h = i14;
        this.f66605i = truncateAt;
        this.f66606j = i15;
        this.f66607k = f11;
        this.f66608l = f12;
        this.f66609m = i16;
        this.f66610n = z10;
        this.f66611o = z11;
        this.f66612p = i17;
        this.f66613q = i18;
        this.f66614r = i19;
        this.f66615s = i20;
        this.f66616t = iArr;
        this.f66617u = iArr2;
        if (i11 < 0 || i11 > i12) {
            throw new IllegalArgumentException("invalid start value");
        }
        int length = charSequence.length();
        if (i12 < 0 || i12 > length) {
            throw new IllegalArgumentException("invalid end value");
        }
        if (i14 < 0) {
            throw new IllegalArgumentException("invalid maxLines value");
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("invalid width value");
        }
        if (i15 < 0) {
            throw new IllegalArgumentException("invalid ellipsizedWidth value");
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("invalid lineSpacingMultiplier value");
        }
    }

    public final Layout.Alignment a() {
        return this.f66603g;
    }

    public final int b() {
        return this.f66612p;
    }

    public final TextUtils.TruncateAt c() {
        return this.f66605i;
    }

    public final int d() {
        return this.f66606j;
    }

    public final int e() {
        return this.f66599c;
    }

    public final int f() {
        return this.f66615s;
    }

    public final boolean g() {
        return this.f66610n;
    }

    public final int h() {
        return this.f66609m;
    }

    public final int[] i() {
        return this.f66616t;
    }

    public final int j() {
        return this.f66613q;
    }

    public final int k() {
        return this.f66614r;
    }

    public final float l() {
        return this.f66608l;
    }

    public final float m() {
        return this.f66607k;
    }

    public final int n() {
        return this.f66604h;
    }

    public final TextPaint o() {
        return this.f66600d;
    }

    public final int[] p() {
        return this.f66617u;
    }

    public final int q() {
        return this.f66598b;
    }

    public final CharSequence r() {
        return this.f66597a;
    }

    public final TextDirectionHeuristic s() {
        return this.f66602f;
    }

    public final boolean t() {
        return this.f66611o;
    }

    public final int u() {
        return this.f66601e;
    }
}
