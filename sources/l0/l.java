package l0;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes2.dex */
public final class l extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    private final int f68563a;

    /* renamed from: b, reason: collision with root package name */
    private final float f68564b;

    /* renamed from: c, reason: collision with root package name */
    private final float f68565c;

    /* renamed from: d, reason: collision with root package name */
    private final float f68566d;

    public l(int i11, float f11, float f12, float f13) {
        this.f68563a = i11;
        this.f68564b = f11;
        this.f68565c = f12;
        this.f68566d = f13;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f68566d, this.f68564b, this.f68565c, this.f68563a);
    }
}
