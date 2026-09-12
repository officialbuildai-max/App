package es;

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
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import com.blankj.utilcode.util.a0;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class a extends ReplacementSpan {

    /* renamed from: a, reason: collision with root package name */
    private Uri f62099a;

    /* renamed from: b, reason: collision with root package name */
    private int f62100b;

    /* renamed from: c, reason: collision with root package name */
    private Context f62101c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference f62102d;

    /* renamed from: e, reason: collision with root package name */
    private int f62103e;

    /* renamed from: f, reason: collision with root package name */
    private int f62104f;

    /* renamed from: g, reason: collision with root package name */
    private int f62105g;

    /* renamed from: h, reason: collision with root package name */
    private int f62106h;

    /* renamed from: i, reason: collision with root package name */
    private int f62107i;

    /* renamed from: j, reason: collision with root package name */
    private int f62108j;

    /* renamed from: k, reason: collision with root package name */
    private final float f62109k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f62110l;

    /* renamed from: m, reason: collision with root package name */
    private int f62111m;

    public a(Context context, int i11, int i12, int i13, float f11, int i14, boolean z10, int i15) {
        this.f62101c = context;
        this.f62100b = i11;
        this.f62103e = i13;
        this.f62104f = i12;
        this.f62105g = a(context, i14);
        this.f62107i = a(context, 1.0f);
        this.f62108j = a(context, 1.0f);
        this.f62106h = a(context, 4.0f);
        this.f62109k = f11;
        this.f62110l = z10;
        this.f62111m = i15 > 0 ? a(context, i15) : 0;
    }

    private static int a(Context context, float f11) {
        return a0.a(f11);
    }

    private Drawable b() {
        WeakReference weakReference = this.f62102d;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable c11 = c();
        this.f62102d = new WeakReference(c11);
        return c11;
    }

    private int d() {
        int i11 = this.f62111m;
        if (i11 > 0) {
            return i11;
        }
        Drawable b11 = b();
        if (b11 == null) {
            return 0;
        }
        return b11.getIntrinsicWidth();
    }

    public Drawable c() {
        Drawable drawable = null;
        try {
            if (this.f62099a != null) {
                InputStream openInputStream = this.f62101c.getContentResolver().openInputStream(this.f62099a);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f62101c.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    int i11 = this.f62111m;
                    if (i11 <= 0) {
                        i11 = bitmapDrawable.getIntrinsicWidth();
                    }
                    int i12 = this.f62111m;
                    if (i12 <= 0) {
                        i12 = bitmapDrawable.getIntrinsicHeight();
                    }
                    bitmapDrawable.setBounds(0, 0, i11, i12);
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else if (this.f62100b != -111) {
                drawable = this.f62101c.getResources().getDrawable(this.f62100b);
                drawable.setColorFilter(this.f62104f, PorterDuff.Mode.SRC_IN);
                int i13 = this.f62111m;
                if (i13 <= 0) {
                    i13 = drawable.getIntrinsicWidth();
                }
                int i14 = this.f62111m;
                if (i14 <= 0) {
                    i14 = drawable.getIntrinsicHeight();
                }
                drawable.setBounds(0, 0, i13, i14);
            }
        } catch (Exception unused2) {
        }
        return drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setColor(this.f62103e);
        boolean z10 = this.f62110l;
        int i16 = z10 ? 0 : 6;
        int i17 = z10 ? 6 : 0;
        float f12 = i16;
        float size = f11 + getSize(paint, charSequence, i11, i12, paint.getFontMetricsInt());
        RectF rectF = new RectF(f11 + f12, i13 + this.f62107i, size - i17, i15 - this.f62108j);
        int i18 = this.f62106h;
        canvas.drawRoundRect(rectF, i18, i18, paint);
        paint.setColor(this.f62104f);
        paint.setTextSize(this.f62109k);
        canvas.drawText(charSequence, i11, i12, f11 + this.f62105g, i14 - ((this.f62107i + this.f62108j) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Drawable b11 = b();
        if (b11 != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i19 = (i14 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (b11.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(((size - this.f62105g) - d()) + f12, i19);
            b11.draw(canvas);
            canvas.restore();
        }
    }

    public int e(Paint paint, CharSequence charSequence, CharSequence charSequence2) {
        int d11 = (this.f62105g * 2) + d();
        if (!TextUtils.isEmpty(charSequence)) {
            d11 += (int) paint.measureText(charSequence, 0, charSequence.length());
        }
        if (TextUtils.isEmpty(charSequence2)) {
            return d11;
        }
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f62109k);
        int measureText = d11 + ((int) paint.measureText(charSequence2, 0, charSequence2.length()));
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f62109k);
        int measureText = ((int) paint.measureText(charSequence, i11, i12)) + (this.f62105g * 2) + d();
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSize(this.f62109k * textPaint.density);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSize(this.f62109k * textPaint.density);
    }
}
