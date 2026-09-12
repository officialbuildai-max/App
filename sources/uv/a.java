package uv;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.blankj.utilcode.util.a0;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class a extends ReplacementSpan {

    /* renamed from: a, reason: collision with root package name */
    private Uri f77043a;

    /* renamed from: b, reason: collision with root package name */
    private int f77044b;

    /* renamed from: c, reason: collision with root package name */
    private Context f77045c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference f77046d;

    /* renamed from: e, reason: collision with root package name */
    private int f77047e;

    /* renamed from: f, reason: collision with root package name */
    private int f77048f;

    /* renamed from: g, reason: collision with root package name */
    private int f77049g;

    /* renamed from: h, reason: collision with root package name */
    private int f77050h;

    /* renamed from: i, reason: collision with root package name */
    private int f77051i;

    /* renamed from: j, reason: collision with root package name */
    private int f77052j;

    /* renamed from: k, reason: collision with root package name */
    private final float f77053k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f77054l;

    public a(Context context, int i11, int i12, int i13, float f11, int i14, boolean z10) {
        this.f77045c = context;
        this.f77044b = i11;
        this.f77047e = i13;
        this.f77048f = i12;
        this.f77049g = a(context, i14);
        this.f77051i = a(context, 1.0f);
        this.f77052j = a(context, 1.0f);
        this.f77050h = a(context, 4.0f);
        this.f77053k = f11;
        this.f77054l = z10;
    }

    private static int a(Context context, float f11) {
        return a0.a(f11);
    }

    private Drawable b() {
        WeakReference weakReference = this.f77046d;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable c11 = c();
        this.f77046d = new WeakReference(c11);
        return c11;
    }

    private int d() {
        Drawable b11 = b();
        if (b11 == null) {
            return 0;
        }
        return b11.getIntrinsicWidth();
    }

    public Drawable c() {
        Drawable drawable = null;
        try {
            if (this.f77043a != null) {
                InputStream openInputStream = this.f77045c.getContentResolver().openInputStream(this.f77043a);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f77045c.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else if (this.f77044b != -111) {
                drawable = this.f77045c.getResources().getDrawable(this.f77044b);
                drawable.setColorFilter(this.f77048f, PorterDuff.Mode.SRC_IN);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
        } catch (Exception unused2) {
        }
        return drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setColor(this.f77047e);
        boolean z10 = this.f77054l;
        int i16 = z10 ? 0 : 6;
        int i17 = z10 ? 6 : 0;
        float f12 = i16;
        float size = f11 + getSize(paint, charSequence, i11, i12, paint.getFontMetricsInt());
        RectF rectF = new RectF(f11 + f12, i13 + this.f77051i, size - i17, i15 - this.f77052j);
        int i18 = this.f77050h;
        canvas.drawRoundRect(rectF, i18, i18, paint);
        paint.setColor(this.f77048f);
        paint.setTextSize(this.f77053k);
        canvas.drawText(charSequence, i11, i12, f11 + this.f77049g, i14 - ((this.f77051i + this.f77052j) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Drawable b11 = b();
        if (b11 == null || i12 - i11 <= 2) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i19 = (i14 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (b11.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(((size - this.f77049g) - d()) + f12, i19);
        b11.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f77053k);
        int measureText = ((int) paint.measureText(charSequence, i11, i12)) + (this.f77049g * 2) + d();
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSize(this.f77053k * textPaint.density);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSize(this.f77053k * textPaint.density);
    }
}
