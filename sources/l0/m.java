package l0;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes2.dex */
public class m extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f68567a;

    public m(float f11) {
        this.f68567a = f11;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSkewX(this.f68567a + textPaint.getTextSkewX());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSkewX(this.f68567a + textPaint.getTextSkewX());
    }
}
