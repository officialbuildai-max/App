package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a, reason: collision with root package name */
    private ImageFilterView.c f7619a;

    /* renamed from: b, reason: collision with root package name */
    private float f7620b;

    /* renamed from: c, reason: collision with root package name */
    private float f7621c;

    /* renamed from: d, reason: collision with root package name */
    private float f7622d;

    /* renamed from: e, reason: collision with root package name */
    private Path f7623e;

    /* renamed from: f, reason: collision with root package name */
    ViewOutlineProvider f7624f;

    /* renamed from: g, reason: collision with root package name */
    RectF f7625g;

    /* renamed from: h, reason: collision with root package name */
    Drawable[] f7626h;

    /* renamed from: i, reason: collision with root package name */
    LayerDrawable f7627i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f7628j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f7629k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f7630l;

    /* renamed from: m, reason: collision with root package name */
    private float f7631m;

    /* renamed from: n, reason: collision with root package name */
    private float f7632n;

    /* renamed from: o, reason: collision with root package name */
    private float f7633o;

    /* renamed from: p, reason: collision with root package name */
    private float f7634p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.f7621c) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f7622d);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f7619a = new ImageFilterView.c();
        this.f7620b = 0.0f;
        this.f7621c = 0.0f;
        this.f7622d = Float.NaN;
        this.f7626h = new Drawable[2];
        this.f7628j = true;
        this.f7629k = null;
        this.f7630l = null;
        this.f7631m = Float.NaN;
        this.f7632n = Float.NaN;
        this.f7633o = Float.NaN;
        this.f7634p = Float.NaN;
        init(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7619a = new ImageFilterView.c();
        this.f7620b = 0.0f;
        this.f7621c = 0.0f;
        this.f7622d = Float.NaN;
        this.f7626h = new Drawable[2];
        this.f7628j = true;
        this.f7629k = null;
        this.f7630l = null;
        this.f7631m = Float.NaN;
        this.f7632n = Float.NaN;
        this.f7633o = Float.NaN;
        this.f7634p = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7619a = new ImageFilterView.c();
        this.f7620b = 0.0f;
        this.f7621c = 0.0f;
        this.f7622d = Float.NaN;
        this.f7626h = new Drawable[2];
        this.f7628j = true;
        this.f7629k = null;
        this.f7630l = null;
        this.f7631m = Float.NaN;
        this.f7632n = Float.NaN;
        this.f7633o = Float.NaN;
        this.f7634p = Float.NaN;
        init(context, attributeSet);
    }

    private void c() {
        if (Float.isNaN(this.f7631m) && Float.isNaN(this.f7632n) && Float.isNaN(this.f7633o) && Float.isNaN(this.f7634p)) {
            return;
        }
        float f11 = Float.isNaN(this.f7631m) ? 0.0f : this.f7631m;
        float f12 = Float.isNaN(this.f7632n) ? 0.0f : this.f7632n;
        float f13 = Float.isNaN(this.f7633o) ? 1.0f : this.f7633o;
        float f14 = Float.isNaN(this.f7634p) ? 0.0f : this.f7634p;
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
        if (Float.isNaN(this.f7631m) && Float.isNaN(this.f7632n) && Float.isNaN(this.f7633o) && Float.isNaN(this.f7634p)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            c();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f7629k = obtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f7620b = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f7628j));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f7631m));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f7632n));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f7634p));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f7633o));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f7630l = drawable;
            if (this.f7629k == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f7630l = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f7626h;
                    Drawable mutate = drawable2.mutate();
                    this.f7630l = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f7626h;
            Drawable mutate2 = getDrawable().mutate();
            this.f7630l = mutate2;
            drawableArr2[0] = mutate2;
            this.f7626h[1] = this.f7629k.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f7626h);
            this.f7627i = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f7620b * 255.0f));
            if (!this.f7628j) {
                this.f7627i.getDrawable(0).setAlpha((int) ((1.0f - this.f7620b) * 255.0f));
            }
            super.setImageDrawable(this.f7627i);
        }
    }

    private void setOverlay(boolean z10) {
        this.f7628j = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f7619a.f7660f;
    }

    public float getCrossfade() {
        return this.f7620b;
    }

    public float getImagePanX() {
        return this.f7631m;
    }

    public float getImagePanY() {
        return this.f7632n;
    }

    public float getImageRotate() {
        return this.f7634p;
    }

    public float getImageZoom() {
        return this.f7633o;
    }

    public float getRound() {
        return this.f7622d;
    }

    public float getRoundPercent() {
        return this.f7621c;
    }

    public float getSaturation() {
        return this.f7619a.f7659e;
    }

    public float getWarmth() {
        return this.f7619a.f7661g;
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        c();
    }

    public void setAltImageResource(int i11) {
        Drawable mutate = g.a.b(getContext(), i11).mutate();
        this.f7629k = mutate;
        Drawable[] drawableArr = this.f7626h;
        drawableArr[0] = this.f7630l;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7626h);
        this.f7627i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7620b);
    }

    public void setBrightness(float f11) {
        ImageFilterView.c cVar = this.f7619a;
        cVar.f7658d = f11;
        cVar.c(this);
    }

    public void setContrast(float f11) {
        ImageFilterView.c cVar = this.f7619a;
        cVar.f7660f = f11;
        cVar.c(this);
    }

    public void setCrossfade(float f11) {
        this.f7620b = f11;
        if (this.f7626h != null) {
            if (!this.f7628j) {
                this.f7627i.getDrawable(0).setAlpha((int) ((1.0f - this.f7620b) * 255.0f));
            }
            this.f7627i.getDrawable(1).setAlpha((int) (this.f7620b * 255.0f));
            super.setImageDrawable(this.f7627i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f7629k == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.f7630l = mutate;
        Drawable[] drawableArr = this.f7626h;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f7629k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7626h);
        this.f7627i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7620b);
    }

    public void setImagePanX(float f11) {
        this.f7631m = f11;
        d();
    }

    public void setImagePanY(float f11) {
        this.f7632n = f11;
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i11) {
        if (this.f7629k == null) {
            super.setImageResource(i11);
            return;
        }
        Drawable mutate = g.a.b(getContext(), i11).mutate();
        this.f7630l = mutate;
        Drawable[] drawableArr = this.f7626h;
        drawableArr[0] = mutate;
        drawableArr[1] = this.f7629k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f7626h);
        this.f7627i = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f7620b);
    }

    public void setImageRotate(float f11) {
        this.f7634p = f11;
        d();
    }

    public void setImageZoom(float f11) {
        this.f7633o = f11;
        d();
    }

    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7622d = f11;
            float f12 = this.f7621c;
            this.f7621c = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z10 = this.f7622d != f11;
        this.f7622d = f11;
        if (f11 != 0.0f) {
            if (this.f7623e == null) {
                this.f7623e = new Path();
            }
            if (this.f7625g == null) {
                this.f7625g = new RectF();
            }
            if (this.f7624f == null) {
                b bVar = new b();
                this.f7624f = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7625g.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7623e.reset();
            Path path = this.f7623e;
            RectF rectF = this.f7625g;
            float f13 = this.f7622d;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f11) {
        boolean z10 = this.f7621c != f11;
        this.f7621c = f11;
        if (f11 != 0.0f) {
            if (this.f7623e == null) {
                this.f7623e = new Path();
            }
            if (this.f7625g == null) {
                this.f7625g = new RectF();
            }
            if (this.f7624f == null) {
                a aVar = new a();
                this.f7624f = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f7621c) / 2.0f;
            this.f7625g.set(0.0f, 0.0f, width, height);
            this.f7623e.reset();
            this.f7623e.addRoundRect(this.f7625g, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        ImageFilterView.c cVar = this.f7619a;
        cVar.f7659e = f11;
        cVar.c(this);
    }

    public void setWarmth(float f11) {
        ImageFilterView.c cVar = this.f7619a;
        cVar.f7661g = f11;
        cVar.c(this);
    }
}
