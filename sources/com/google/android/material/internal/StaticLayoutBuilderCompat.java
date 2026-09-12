package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes4.dex */
final class StaticLayoutBuilderCompat {

    /* renamed from: n, reason: collision with root package name */
    static final int f29174n = 1;

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f29175a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f29176b;

    /* renamed from: c, reason: collision with root package name */
    private final int f29177c;

    /* renamed from: e, reason: collision with root package name */
    private int f29179e;

    /* renamed from: l, reason: collision with root package name */
    private boolean f29186l;

    /* renamed from: d, reason: collision with root package name */
    private int f29178d = 0;

    /* renamed from: f, reason: collision with root package name */
    private Layout.Alignment f29180f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    private int f29181g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private float f29182h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f29183i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private int f29184j = f29174n;

    /* renamed from: k, reason: collision with root package name */
    private boolean f29185k = true;

    /* renamed from: m, reason: collision with root package name */
    private TextUtils.TruncateAt f29187m = null;

    /* loaded from: classes4.dex */
    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th2) {
            super("Error thrown initializing StaticLayout " + th2.getMessage(), th2);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i11) {
        this.f29175a = charSequence;
        this.f29176b = textPaint;
        this.f29177c = i11;
        this.f29179e = charSequence.length();
    }

    public static StaticLayoutBuilderCompat b(CharSequence charSequence, TextPaint textPaint, int i11) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i11);
    }

    public StaticLayout a() {
        if (this.f29175a == null) {
            this.f29175a = "";
        }
        int max = Math.max(0, this.f29177c);
        CharSequence charSequence = this.f29175a;
        if (this.f29181g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f29176b, max, this.f29187m);
        }
        int min = Math.min(charSequence.length(), this.f29179e);
        this.f29179e = min;
        if (this.f29186l && this.f29181g == 1) {
            this.f29180f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f29178d, min, this.f29176b, max);
        obtain.setAlignment(this.f29180f);
        obtain.setIncludePad(this.f29185k);
        obtain.setTextDirection(this.f29186l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f29187m;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f29181g);
        float f11 = this.f29182h;
        if (f11 != 0.0f || this.f29183i != 1.0f) {
            obtain.setLineSpacing(f11, this.f29183i);
        }
        if (this.f29181g > 1) {
            obtain.setHyphenationFrequency(this.f29184j);
        }
        return obtain.build();
    }

    public StaticLayoutBuilderCompat c(Layout.Alignment alignment) {
        this.f29180f = alignment;
        return this;
    }

    public StaticLayoutBuilderCompat d(TextUtils.TruncateAt truncateAt) {
        this.f29187m = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat e(int i11) {
        this.f29184j = i11;
        return this;
    }

    public StaticLayoutBuilderCompat f(boolean z10) {
        this.f29185k = z10;
        return this;
    }

    public StaticLayoutBuilderCompat g(boolean z10) {
        this.f29186l = z10;
        return this;
    }

    public StaticLayoutBuilderCompat h(float f11, float f12) {
        this.f29182h = f11;
        this.f29183i = f12;
        return this;
    }

    public StaticLayoutBuilderCompat i(int i11) {
        this.f29181g = i11;
        return this;
    }

    public StaticLayoutBuilderCompat j(x xVar) {
        return this;
    }
}
