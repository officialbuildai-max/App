package l0;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: classes2.dex */
public final class g implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final float f68538a;

    public g(float f11) {
        this.f68538a = f11;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i11, int i12, int i13, int i14, Paint.FontMetricsInt fontMetricsInt) {
        if (i.a(fontMetricsInt) <= 0) {
            return;
        }
        int ceil = (int) Math.ceil(fontMetricsInt.descent * ((r4 * 1.0f) / r3));
        fontMetricsInt.descent = ceil;
        fontMetricsInt.ascent = ceil - ((int) Math.ceil(this.f68538a));
    }
}
