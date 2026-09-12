package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public abstract class i extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    private final p f9190b;

    /* renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f9189a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    private short f9191c = -1;

    /* renamed from: d, reason: collision with root package name */
    private short f9192d = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f9193e = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(p pVar) {
        androidx.core.util.i.h(pVar, "rasterizer cannot be null");
        this.f9190b = pVar;
    }

    public final p a() {
        return this.f9190b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f9191c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f9189a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f9189a;
        this.f9193e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f9190b.e();
        this.f9192d = (short) (this.f9190b.e() * this.f9193e);
        short i13 = (short) (this.f9190b.i() * this.f9193e);
        this.f9191c = i13;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f9189a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i13;
    }
}
