package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import kotlin.jvm.internal.Intrinsics;
import z.h;
import z.l;
import z.m;

/* loaded from: classes.dex */
public final class a extends CharacterStyle implements UpdateAppearance {

    /* renamed from: a, reason: collision with root package name */
    private final h f6418a;

    public a(h hVar) {
        this.f6418a = hVar;
    }

    private final Paint.Cap a(int i11) {
        c5.a aVar = c5.f4393a;
        return c5.e(i11, aVar.a()) ? Paint.Cap.BUTT : c5.e(i11, aVar.b()) ? Paint.Cap.ROUND : c5.e(i11, aVar.c()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    private final Paint.Join b(int i11) {
        d5.a aVar = d5.f4505a;
        return d5.e(i11, aVar.b()) ? Paint.Join.MITER : d5.e(i11, aVar.c()) ? Paint.Join.ROUND : d5.e(i11, aVar.a()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            h hVar = this.f6418a;
            if (Intrinsics.c(hVar, l.f79237a)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (hVar instanceof m) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((m) this.f6418a).f());
                textPaint.setStrokeMiter(((m) this.f6418a).d());
                textPaint.setStrokeJoin(b(((m) this.f6418a).c()));
                textPaint.setStrokeCap(a(((m) this.f6418a).b()));
                ((m) this.f6418a).e();
                textPaint.setPathEffect(null);
            }
        }
    }
}
