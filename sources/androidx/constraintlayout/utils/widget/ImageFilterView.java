package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: d, reason: collision with root package name */
    private c f7637d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7638e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f7639f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f7640g;

    /* renamed from: h, reason: collision with root package name */
    private float f7641h;

    /* renamed from: i, reason: collision with root package name */
    private float f7642i;

    /* renamed from: j, reason: collision with root package name */
    private float f7643j;

    /* renamed from: k, reason: collision with root package name */
    private Path f7644k;

    /* renamed from: l, reason: collision with root package name */
    ViewOutlineProvider f7645l;

    /* renamed from: m, reason: collision with root package name */
    RectF f7646m;

    /* renamed from: n, reason: collision with root package name */
    Drawable[] f7647n;

    /* renamed from: o, reason: collision with root package name */
    LayerDrawable f7648o;

    /* renamed from: p, reason: collision with root package name */
    float f7649p;

    /* renamed from: q, reason: collision with root package name */
    float f7650q;

    /* renamed from: r, reason: collision with root package name */
    float f7651r;

    /* renamed from: s, reason: collision with root package name */
    float f7652s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f7642i) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f7643j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        float[] f7655a = new float[20];

        /* renamed from: b, reason: collision with root package name */
        ColorMatrix f7656b = new ColorMatrix();

        /* renamed from: c, reason: collision with root package name */
        ColorMatrix f7657c = new ColorMatrix();

        /* renamed from: d, reason: collision with root package name */
        float f7658d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        float f7659e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        float f7660f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        float f7661g = 1.0f;

        private void a(float f11) {
            float[] fArr = this.f7655a;
            fArr[0] = f11;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f11;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f11) {
            float f12 = 1.0f - f11;
            float f13 = 0.2999f * f12;
            float f14 = 0.587f * f12;
            float f15 = f12 * 0.114f;
            float[] fArr = this.f7655a;
            fArr[0] = f13 + f11;
            fArr[1] = f14;
            fArr[2] = f15;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f13;
            fArr[6] = f14 + f11;
            fArr[7] = f15;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f13;
            fArr[11] = f14;
            fArr[12] = f15 + f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f11) {
            float log;
            float f12;
            if (f11 <= 0.0f) {
                f11 = 0.01f;
            }
            float f13 = (5000.0f / f11) / 100.0f;
            if (f13 > 66.0f) {
                double d11 = f13 - 60.0f;
                f12 = ((float) Math.pow(d11, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d11, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f13)) * 99.4708f) - 161.11957f;
                f12 = 255.0f;
            }
            float log2 = f13 < 66.0f ? f13 > 19.0f ? (((float) Math.log(f13 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f12, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log2, 0.0f));
            float log3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log3, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max(log4, 0.0f));
            float[] fArr = this.f7655a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(ImageView imageView) {
            boolean z10;
            this.f7656b.reset();
            float f11 = this.f7659e;
            boolean z11 = true;
            if (f11 != 1.0f) {
                b(f11);
                this.f7656b.set(this.f7655a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f12 = this.f7660f;
            if (f12 != 1.0f) {
                this.f7657c.setScale(f12, f12, f12, 1.0f);
                this.f7656b.postConcat(this.f7657c);
                z10 = true;
            }
            float f13 = this.f7661g;
            if (f13 != 1.0f) {
                d(f13);
                this.f7657c.set(this.f7655a);
                this.f7656b.postConcat(this.f7657c);
                z10 = true;
            }
            float f14 = this.f7658d;
            if (f14 != 1.0f) {
                a(f14);
                this.f7657c.set(this.f7655a);
                this.f7656b.postConcat(this.f7657c);
            } else {
                z11 = z10;
            }
            if (z11) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f7656b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f7637d = new c();
        this.f7638e = true;
        this.f7639f = null;
        this.f7640g = null;
        this.f7641h = 0.0f;
        this.f7642i = 0.0f;
        this.f7643j = Float.NaN;
        this.f7647n = new Drawable[2];
        this.f7649p = Float.NaN;
        this.f7650q = Float.NaN;
        this.f7651r = Float.NaN;
        this.f7652s = Float.NaN;
        init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7637d = new c();
        this.f7638e = true;
        this.f7639f = null;
        this.f7640g = null;
        this.f7641h = 0.0f;
        this.f7642i = 0.0f;
        this.f7643j = Float.NaN;
        this.f7647n = new Drawable[2];
        this.f7649p = Float.NaN;
        this.f7650q = Float.NaN;
        this.f7651r = Float.NaN;
        this.f7652s = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7637d = new c();
        this.f7638e = true;
        this.f7639f = null;
        this.f7640g = null;
        this.f7641h = 0.0f;
        this.f7642i = 0.0f;
        this.f7643j = Float.NaN;
        this.f7647n = new Drawable[2];
        this.f7649p = Float.NaN;
        this.f7650q = Float.NaN;
        this.f7651r = Float.NaN;
        this.f7652s = Float.NaN;
        init(context, attributeSet);
    }

    private void c() {
        if (Float.isNaN(this.f7649p) && Float.isNaN(this.f7650q) && Float.isNaN(this.f7651r) && Float.isNaN(this.f7652s)) {
            return;
        }
        float f11 = Float.isNaN(this.f7649p) ? 0.0f : this.f7649p;
        float f12 = Float.isNaN(this.f7650q) ? 0.0f : this.f7650q;
        float f13 = Float.isNaN(this.f7651r) ? 1.0f : this.f7651r;
        float f14 = Float.isNaN(this.f7652s) ? 0.0f : this.f7652s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f15 = f13 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f15, f15);
        float f16 = intrinsicWidth * f15;
        float f17 = f15 * intrinsicHeight;
        matrix.postTranslate((((f11 * (width - f16)) + width) - f16) * 0.5f, (((f12 * (height - f17)) + height) - f17) * 0.5f);
        matrix.postRotate(f14, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void d() {
        if (Float.isNaN(this.f7649p) && Float.isNaN(this.f7650q) && Float.isNaN(this.f7651r) && Float.isNaN(this.f7652s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f7639f = obtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f7641h = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f7638e));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f7649p));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f7650q));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f7652s));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f7651r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f7640g = drawable;
            if (this.f7639f == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f7640g = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f7647n;
                    Drawable mutate = drawable2.mutate();
                    this.f7640g = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f7647n;
            Drawable mutate2 = getDrawable().mutate();
            this.f7640g = mutate2;
            drawableArr2[0] = mutate2;
            this.f7647n[1] = this.f7639f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f7647n);
            this.f7648o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f7641h * 255.0f));
            if (!this.f7638e) {
                this.f7648o.getDrawable(0).setAlpha((int) ((1.0f - this.f7641h) * 255.0f));
            }
            super.setImageDrawable(this.f7648o);
        }
    }

    private void setOverlay(boolean z10) {
        this.f7638e = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f7637d.f7658d;
    }

    public float getContrast() {
        return this.f7637d.f7660f;
    }

    public float getCrossfade() {
        return this.f7641h;
    }

    public float getImagePanX() {
        return this.f7649p;
    }

    public float getImagePanY() {
        return this.f7650q;
    }

    public float getImageRotate() {
        return this.f7652s;
    }

    public float getImageZoom() {
        return this.f7651r;
    }

    public float getRound() {
        return this.f7643j;
    }

    public float getRoundPercent() {
        return this.f7642i;
    }

    public float getSaturation() {
        return this.f7637d.f7659e;
    }

    public float getWarmth() {
        return this.f7637d.f7661g;
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        c();
    }

    public void setAltImageResource(int i11) {
        Drawable mutate = g.a.b(getContext(), i11).mutate();
        this.f7639f = mutate;
        Drawable[] drawableArr = this.f7647n;
        drawableArr[0] = this.f7640g;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7647n);
        this.f7648o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7641h);
    }

    public void setBrightness(float f11) {
        c cVar = this.f7637d;
        cVar.f7658d = f11;
        cVar.c(this);
    }

    public void setContrast(float f11) {
        c cVar = this.f7637d;
        cVar.f7660f = f11;
        cVar.c(this);
    }

    public void setCrossfade(float f11) {
        this.f7641h = f11;
        if (this.f7647n != null) {
            if (!this.f7638e) {
                this.f7648o.getDrawable(0).setAlpha((int) ((1.0f - this.f7641h) * 255.0f));
            }
            this.f7648o.getDrawable(1).setAlpha((int) (this.f7641h * 255.0f));
            super.setImageDrawable(this.f7648o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f7639f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f7640g = mutate;
        Drawable[] drawableArr = this.f7647n;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f7639f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7647n);
        this.f7648o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7641h);
    }

    public void setImagePanX(float f11) {
        this.f7649p = f11;
        d();
    }

    public void setImagePanY(float f11) {
        this.f7650q = f11;
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i11) {
        if (this.f7639f == null) {
            super.setImageResource(i11);
            return;
        }
        Drawable mutate = g.a.b(getContext(), i11).mutate();
        this.f7640g = mutate;
        Drawable[] drawableArr = this.f7647n;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f7639f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7647n);
        this.f7648o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7641h);
    }

    public void setImageRotate(float f11) {
        this.f7652s = f11;
        d();
    }

    public void setImageZoom(float f11) {
        this.f7651r = f11;
        d();
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7643j = f11;
            float f12 = this.f7642i;
            this.f7642i = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z10 = this.f7643j != f11;
        this.f7643j = f11;
        if (f11 != 0.0f) {
            if (this.f7644k == null) {
                this.f7644k = new Path();
            }
            if (this.f7646m == null) {
                this.f7646m = new RectF();
            }
            if (this.f7645l == null) {
                b bVar = new b();
                this.f7645l = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7646m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7644k.reset();
            Path path = this.f7644k;
            RectF rectF = this.f7646m;
            float f13 = this.f7643j;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z10 = this.f7642i != f11;
        this.f7642i = f11;
        if (f11 != 0.0f) {
            if (this.f7644k == null) {
                this.f7644k = new Path();
            }
            if (this.f7646m == null) {
                this.f7646m = new RectF();
            }
            if (this.f7645l == null) {
                a aVar = new a();
                this.f7645l = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f7642i) / 2.0f;
            this.f7646m.set(0.0f, 0.0f, width, height);
            this.f7644k.reset();
            this.f7644k.addRoundRect(this.f7646m, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        c cVar = this.f7637d;
        cVar.f7659e = f11;
        cVar.c(this);
    }

    public void setWarmth(float f11) {
        c cVar = this.f7637d;
        cVar.f7661g = f11;
        cVar.c(this);
    }
}
