package qh;

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
import java.io.InputStream;
import java.lang.ref.WeakReference;
import oh.h;

/* loaded from: classes4.dex */
public class a extends ReplacementSpan {

    /* renamed from: a, reason: collision with root package name */
    private Uri f73735a;

    /* renamed from: b, reason: collision with root package name */
    private int f73736b;

    /* renamed from: c, reason: collision with root package name */
    private Context f73737c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference f73738d;

    /* renamed from: e, reason: collision with root package name */
    private int f73739e;

    /* renamed from: f, reason: collision with root package name */
    private int f73740f;

    /* renamed from: g, reason: collision with root package name */
    private int f73741g;

    /* renamed from: h, reason: collision with root package name */
    private int f73742h;

    /* renamed from: i, reason: collision with root package name */
    private int f73743i;

    /* renamed from: j, reason: collision with root package name */
    private int f73744j;

    /* renamed from: k, reason: collision with root package name */
    private final float f73745k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f73746l;

    public a(Context context, int i11, int i12, int i13, float f11, int i14, boolean z10) {
        this.f73737c = context;
        this.f73736b = i11;
        this.f73739e = i13;
        this.f73740f = i12;
        this.f73741g = a(context, i14);
        this.f73743i = a(context, 1.0f);
        this.f73744j = a(context, 1.0f);
        this.f73742h = a(context, 4.0f);
        this.f73745k = f11;
        this.f73746l = z10;
    }

    private static int a(Context context, float f11) {
        return h.f71144a.a(context, f11);
    }

    private Drawable b() {
        WeakReference weakReference = this.f73738d;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable c11 = c();
        this.f73738d = new WeakReference(c11);
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
            if (this.f73735a != null) {
                InputStream openInputStream = this.f73737c.getContentResolver().openInputStream(this.f73735a);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f73737c.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else if (this.f73736b != -111) {
                drawable = this.f73737c.getResources().getDrawable(this.f73736b);
                drawable.setColorFilter(this.f73740f, PorterDuff.Mode.SRC_IN);
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
        paint.setColor(this.f73739e);
        boolean z10 = this.f73746l;
        int i16 = z10 ? 0 : 6;
        int i17 = z10 ? 6 : 0;
        float f12 = i16;
        float size = f11 + getSize(paint, charSequence, i11, i12, paint.getFontMetricsInt());
        RectF rectF = new RectF(f11 + f12, i13 + this.f73743i, size - i17, i15 - this.f73744j);
        int i18 = this.f73742h;
        canvas.drawRoundRect(rectF, i18, i18, paint);
        paint.setColor(this.f73740f);
        paint.setTextSize(this.f73745k);
        canvas.drawText(charSequence, i11, i12, f11 + this.f73741g, i14 - ((this.f73743i + this.f73744j) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Drawable b11 = b();
        if (b11 != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i19 = (i14 + ((fontMetricsInt.descent + fontMetricsInt.ascent) / 2)) - (b11.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(((size - this.f73741g) - d()) + f12, i19);
            b11.draw(canvas);
            canvas.restore();
        }
    }

    public int e(Paint paint, CharSequence charSequence, CharSequence charSequence2) {
        int d11 = (this.f73741g * 2) + d();
        if (!TextUtils.isEmpty(charSequence)) {
            d11 += (int) paint.measureText(charSequence, 0, charSequence.length());
        }
        if (TextUtils.isEmpty(charSequence2)) {
            return d11;
        }
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f73745k);
        int measureText = d11 + ((int) paint.measureText(charSequence2, 0, charSequence2.length()));
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.f73745k);
        int measureText = ((int) paint.measureText(charSequence, i11, i12)) + (this.f73741g * 2) + d();
        paint.setTextSize(textSize);
        return measureText;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSize(this.f73745k * textPaint.density);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSize(this.f73745k * textPaint.density);
    }
}
