package jt;

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
    private Uri f66402a;

    /* renamed from: b, reason: collision with root package name */
    private int f66403b;

    /* renamed from: c, reason: collision with root package name */
    private Context f66404c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference f66405d;

    /* renamed from: e, reason: collision with root package name */
    private int f66406e;

    /* renamed from: f, reason: collision with root package name */
    private int f66407f;

    /* renamed from: g, reason: collision with root package name */
    private int f66408g;

    /* renamed from: h, reason: collision with root package name */
    private int f66409h;

    /* renamed from: i, reason: collision with root package name */
    private int f66410i;

    /* renamed from: j, reason: collision with root package name */
    private int f66411j;

    /* renamed from: k, reason: collision with root package name */
    private final float f66412k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f66413l;

    public a(Context context, int i11, int i12, int i13, float f11, int i14, boolean z10) {
        this.f66404c = context;
        this.f66403b = i11;
        this.f66406e = i13;
        this.f66407f = i12;
        this.f66408g = a(context, i14);
        this.f66410i = a(context, 1.0f);
        this.f66411j = a(context, 1.0f);
        this.f66409h = a(context, 4.0f);
        this.f66412k = f11;
        this.f66413l = z10;
    }

    private static int a(Context context, float f11) {
        return a0.a(f11);
    }

    private Drawable b() {
        WeakReference weakReference = this.f66405d;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable c11 = c();
        this.f66405d = new WeakReference(c11);
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
            if (this.f66402a != null) {
                InputStream openInputStream = this.f66404c.getContentResolver().openInputStream(this.f66402a);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f66404c.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else if (this.f66403b != -111) {
                drawable = this.f66404c.getResources().getDrawable(this.f66403b);
                drawable.setColorFilter(this.f66407f, PorterDuff.Mode.SRC_IN);
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
        paint.setColor(this.f66406e);
        boolean z10 = this.f66413l;
        int i16 = z10 ? 0 : 6;
        int i17 = z10 ? 6 : 0;
        float f12 = i16;
        float size = f11 + getSize(paint, charSequence, i11, i12, paint.getFontMetricsInt());
        RectF rectF = new RectF(f11 + f12, i13 + this.f66410i, size - i17, i15 - this.f66411j);
        int i18 = this.f66409h;
        canvas.drawRoundRect(rectF, i18, i18, paint);
        paint.setColor(this.f66407f);
        paint.setTextSize(this.f66412k);
        canvas.drawText(charSequence, i11, i12, f11 + this.f66408g, i14 - ((this.f66410i + this.f66411j) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Drawable b11 = b();
        if (b11 == null || i12 - i11 <= 2) {
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i19 = (i14 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (b11.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(((size - this.f66408g) - d()) + f12, i19);
        b11.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f66412k);
        int measureText = ((int) paint.measureText(charSequence, i11, i12)) + (this.f66408g * 2) + d();
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSize(this.f66412k * textPaint.density);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSize(this.f66412k * textPaint.density);
    }
}
