package l0;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes2.dex */
public final class n extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f68568a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f68569b;

    public n(boolean z10, boolean z11) {
        this.f68568a = z10;
        this.f68569b = z11;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(this.f68568a);
        textPaint.setStrikeThruText(this.f68569b);
    }
}
