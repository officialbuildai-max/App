package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    private boolean A;

    /* renamed from: j, reason: collision with root package name */
    private float f7191j;

    /* renamed from: k, reason: collision with root package name */
    private float f7192k;

    /* renamed from: l, reason: collision with root package name */
    private float f7193l;

    /* renamed from: m, reason: collision with root package name */
    ConstraintLayout f7194m;

    /* renamed from: n, reason: collision with root package name */
    private float f7195n;

    /* renamed from: o, reason: collision with root package name */
    private float f7196o;

    /* renamed from: p, reason: collision with root package name */
    protected float f7197p;

    /* renamed from: q, reason: collision with root package name */
    protected float f7198q;

    /* renamed from: r, reason: collision with root package name */
    protected float f7199r;

    /* renamed from: s, reason: collision with root package name */
    protected float f7200s;

    /* renamed from: t, reason: collision with root package name */
    protected float f7201t;

    /* renamed from: u, reason: collision with root package name */
    protected float f7202u;

    /* renamed from: v, reason: collision with root package name */
    boolean f7203v;

    /* renamed from: w, reason: collision with root package name */
    View[] f7204w;

    /* renamed from: x, reason: collision with root package name */
    private float f7205x;

    /* renamed from: y, reason: collision with root package name */
    private float f7206y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7207z;

    public Layer(Context context) {
        super(context);
        this.f7191j = Float.NaN;
        this.f7192k = Float.NaN;
        this.f7193l = Float.NaN;
        this.f7195n = 1.0f;
        this.f7196o = 1.0f;
        this.f7197p = Float.NaN;
        this.f7198q = Float.NaN;
        this.f7199r = Float.NaN;
        this.f7200s = Float.NaN;
        this.f7201t = Float.NaN;
        this.f7202u = Float.NaN;
        this.f7203v = true;
        this.f7204w = null;
        this.f7205x = 0.0f;
        this.f7206y = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7191j = Float.NaN;
        this.f7192k = Float.NaN;
        this.f7193l = Float.NaN;
        this.f7195n = 1.0f;
        this.f7196o = 1.0f;
        this.f7197p = Float.NaN;
        this.f7198q = Float.NaN;
        this.f7199r = Float.NaN;
        this.f7200s = Float.NaN;
        this.f7201t = Float.NaN;
        this.f7202u = Float.NaN;
        this.f7203v = true;
        this.f7204w = null;
        this.f7205x = 0.0f;
        this.f7206y = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7191j = Float.NaN;
        this.f7192k = Float.NaN;
        this.f7193l = Float.NaN;
        this.f7195n = 1.0f;
        this.f7196o = 1.0f;
        this.f7197p = Float.NaN;
        this.f7198q = Float.NaN;
        this.f7199r = Float.NaN;
        this.f7200s = Float.NaN;
        this.f7201t = Float.NaN;
        this.f7202u = Float.NaN;
        this.f7203v = true;
        this.f7204w = null;
        this.f7205x = 0.0f;
        this.f7206y = 0.0f;
    }

    private void m() {
        int i11;
        if (this.f7194m == null || (i11 = this.f7728b) == 0) {
            return;
        }
        View[] viewArr = this.f7204w;
        if (viewArr == null || viewArr.length != i11) {
            this.f7204w = new View[i11];
        }
        for (int i12 = 0; i12 < this.f7728b; i12++) {
            this.f7204w[i12] = this.f7194m.getViewById(this.f7727a[i12]);
        }
    }

    private void n() {
        if (this.f7194m == null) {
            return;
        }
        if (this.f7204w == null) {
            m();
        }
        l();
        double radians = Float.isNaN(this.f7193l) ? 0.0d : Math.toRadians(this.f7193l);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f11 = this.f7195n;
        float f12 = f11 * cos;
        float f13 = this.f7196o;
        float f14 = (-f13) * sin;
        float f15 = f11 * sin;
        float f16 = f13 * cos;
        for (int i11 = 0; i11 < this.f7728b; i11++) {
            View view = this.f7204w[i11];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f17 = left - this.f7197p;
            float f18 = top - this.f7198q;
            float f19 = (((f12 * f17) + (f14 * f18)) - f17) + this.f7205x;
            float f20 = (((f17 * f15) + (f16 * f18)) - f18) + this.f7206y;
            view.setTranslationX(f19);
            view.setTranslationY(f20);
            view.setScaleY(this.f7196o);
            view.setScaleX(this.f7195n);
            if (!Float.isNaN(this.f7193l)) {
                view.setRotation(this.f7193l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7731e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f7207z = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    protected void l() {
        if (this.f7194m == null) {
            return;
        }
        if (this.f7203v || Float.isNaN(this.f7197p) || Float.isNaN(this.f7198q)) {
            if (!Float.isNaN(this.f7191j) && !Float.isNaN(this.f7192k)) {
                this.f7198q = this.f7192k;
                this.f7197p = this.f7191j;
                return;
            }
            View[] j11 = j(this.f7194m);
            int left = j11[0].getLeft();
            int top = j11[0].getTop();
            int right = j11[0].getRight();
            int bottom = j11[0].getBottom();
            for (int i11 = 0; i11 < this.f7728b; i11++) {
                View view = j11[i11];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f7199r = right;
            this.f7200s = bottom;
            this.f7201t = left;
            this.f7202u = top;
            if (Float.isNaN(this.f7191j)) {
                this.f7197p = (left + right) / 2;
            } else {
                this.f7197p = this.f7191j;
            }
            if (Float.isNaN(this.f7192k)) {
                this.f7198q = (top + bottom) / 2;
            } else {
                this.f7198q = this.f7192k;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7194m = (ConstraintLayout) getParent();
        if (this.f7207z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i11 = 0; i11 < this.f7728b; i11++) {
                View viewById = this.f7194m.getViewById(this.f7727a[i11]);
                if (viewById != null) {
                    if (this.f7207z) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        d();
    }

    @Override // android.view.View
    public void setPivotX(float f11) {
        this.f7191j = f11;
        n();
    }

    @Override // android.view.View
    public void setPivotY(float f11) {
        this.f7192k = f11;
        n();
    }

    @Override // android.view.View
    public void setRotation(float f11) {
        this.f7193l = f11;
        n();
    }

    @Override // android.view.View
    public void setScaleX(float f11) {
        this.f7195n = f11;
        n();
    }

    @Override // android.view.View
    public void setScaleY(float f11) {
        this.f7196o = f11;
        n();
    }

    @Override // android.view.View
    public void setTranslationX(float f11) {
        this.f7205x = f11;
        n();
    }

    @Override // android.view.View
    public void setTranslationY(float f11) {
        this.f7206y = f11;
        n();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        d();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        m();
        this.f7197p = Float.NaN;
        this.f7198q = Float.NaN;
        ConstraintWidget b11 = ((ConstraintLayout.b) getLayoutParams()).b();
        b11.o1(0);
        b11.P0(0);
        l();
        layout(((int) this.f7201t) - getPaddingLeft(), ((int) this.f7202u) - getPaddingTop(), ((int) this.f7199r) + getPaddingRight(), ((int) this.f7200s) + getPaddingBottom());
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f7194m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f7193l = rotation;
        } else {
            if (Float.isNaN(this.f7193l)) {
                return;
            }
            this.f7193l = rotation;
        }
    }
}
