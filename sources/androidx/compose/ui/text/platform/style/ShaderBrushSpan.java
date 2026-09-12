package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.text.platform.f;
import kotlin.jvm.functions.Function0;
import y.m;

/* loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {

    /* renamed from: a, reason: collision with root package name */
    private final y4 f6414a;

    /* renamed from: b, reason: collision with root package name */
    private final float f6415b;

    /* renamed from: c, reason: collision with root package name */
    private final i1 f6416c;

    /* renamed from: d, reason: collision with root package name */
    private final a3 f6417d;

    public ShaderBrushSpan(y4 y4Var, float f11) {
        i1 c11;
        this.f6414a = y4Var;
        this.f6415b = f11;
        c11 = u2.c(m.c(m.f78614b.a()), null, 2, null);
        this.f6416c = c11;
        this.f6417d = r2.c(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.style.ShaderBrushSpan$shaderState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Shader invoke() {
                if (ShaderBrushSpan.this.b() == 9205357640488583168L || m.k(ShaderBrushSpan.this.b())) {
                    return null;
                }
                return ShaderBrushSpan.this.a().b(ShaderBrushSpan.this.b());
            }
        });
    }

    public final y4 a() {
        return this.f6414a;
    }

    public final long b() {
        return ((m) this.f6416c.getValue()).m();
    }

    public final void c(long j11) {
        this.f6416c.setValue(m.c(j11));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        f.a(textPaint, this.f6415b);
        textPaint.setShader((Shader) this.f6417d.getValue());
    }
}
