package ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends CharacterStyle implements UpdateAppearance {

    /* renamed from: a, reason: collision with root package name */
    private final int f76879a;

    /* renamed from: b, reason: collision with root package name */
    private final int f76880b;

    /* renamed from: c, reason: collision with root package name */
    private final String f76881c;

    public b(int i11, int i12, String gradientText) {
        Intrinsics.h(gradientText, "gradientText");
        this.f76879a = i11;
        this.f76880b = i12;
        this.f76881c = gradientText;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp2) {
        Intrinsics.h(tp2, "tp");
        tp2.setShader(new LinearGradient(0.0f, 0.0f, tp2.measureText(this.f76881c), 0.0f, this.f76879a, this.f76880b, Shader.TileMode.CLAMP));
    }
}
