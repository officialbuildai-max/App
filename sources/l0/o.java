package l0;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes2.dex */
public final class o extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f68570a;

    public o(Typeface typeface) {
        this.f68570a = typeface;
    }

    private final void a(Paint paint) {
        paint.setTypeface(this.f68570a);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
