package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l, reason: collision with root package name */
    private Paint f7708l;

    /* renamed from: m, reason: collision with root package name */
    MotionLayout f7709m;

    /* renamed from: n, reason: collision with root package name */
    float[] f7710n;

    /* renamed from: o, reason: collision with root package name */
    Matrix f7711o;

    /* renamed from: p, reason: collision with root package name */
    int f7712p;

    /* renamed from: q, reason: collision with root package name */
    int f7713q;

    /* renamed from: r, reason: collision with root package name */
    float f7714r;

    public MotionTelltales(Context context) {
        super(context);
        this.f7708l = new Paint();
        this.f7710n = new float[2];
        this.f7711o = new Matrix();
        this.f7712p = 0;
        this.f7713q = -65281;
        this.f7714r = 0.25f;
        a(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7708l = new Paint();
        this.f7710n = new float[2];
        this.f7711o = new Matrix();
        this.f7712p = 0;
        this.f7713q = -65281;
        this.f7714r = 0.25f;
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7708l = new Paint();
        this.f7710n = new float[2];
        this.f7711o = new Matrix();
        this.f7712p = 0;
        this.f7713q = -65281;
        this.f7714r = 0.25f;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.f7713q = obtainStyledAttributes.getColor(index, this.f7713q);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.f7712p = obtainStyledAttributes.getInt(index, this.f7712p);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.f7714r = obtainStyledAttributes.getFloat(index, this.f7714r);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f7708l.setColor(this.f7713q);
        this.f7708l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f7711o);
        if (this.f7709m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f7709m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i11 = 0; i11 < 5; i11++) {
            float f11 = fArr[i11];
            for (int i12 = 0; i12 < 5; i12++) {
                float f12 = fArr[i12];
                this.f7709m.getViewVelocity(this, f12, f11, this.f7710n, this.f7712p);
                this.f7711o.mapVectors(this.f7710n);
                float f13 = width * f12;
                float f14 = height * f11;
                float[] fArr2 = this.f7710n;
                float f15 = fArr2[0];
                float f16 = this.f7714r;
                float f17 = f14 - (fArr2[1] * f16);
                this.f7711o.mapVectors(fArr2);
                canvas.drawLine(f13, f14, f13 - (f15 * f16), f17, this.f7708l);
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f7667f = charSequence.toString();
        requestLayout();
    }
}
