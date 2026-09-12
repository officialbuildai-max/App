package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes.dex */
public final class q extends i {

    /* renamed from: g, reason: collision with root package name */
    private static Paint f9226g;

    /* renamed from: f, reason: collision with root package name */
    private TextPaint f9227f;

    public q(p pVar) {
        super(pVar);
    }

    private TextPaint c(CharSequence charSequence, int i11, int i12, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i11, i12, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.f9227f;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.f9227f = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    private static Paint e() {
        if (f9226g == null) {
            TextPaint textPaint = new TextPaint();
            f9226g = textPaint;
            textPaint.setColor(EmojiCompat.c().d());
            f9226g.setStyle(Paint.Style.FILL);
        }
        return f9226g;
    }

    void d(Canvas canvas, TextPaint textPaint, float f11, float f12, float f13, float f14) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f11, f13, f12, f14, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Paint paint2 = paint;
        TextPaint c11 = c(charSequence, i11, i12, paint2);
        if (c11 != null && c11.bgColor != 0) {
            d(canvas, c11, f11, f11 + b(), i13, i15);
        }
        if (EmojiCompat.c().j()) {
            canvas.drawRect(f11, i13, f11 + b(), i15, e());
        }
        p a11 = a();
        float f12 = i14;
        if (c11 != null) {
            paint2 = c11;
        }
        a11.a(canvas, f11, f12, paint2);
    }
}
