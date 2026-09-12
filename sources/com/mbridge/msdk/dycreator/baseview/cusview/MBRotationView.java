package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes5.dex */
public class MBRotationView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private Camera f34624a;

    /* renamed from: b, reason: collision with root package name */
    private Matrix f34625b;

    /* renamed from: c, reason: collision with root package name */
    private int f34626c;

    /* renamed from: d, reason: collision with root package name */
    private int f34627d;

    /* renamed from: e, reason: collision with root package name */
    private int f34628e;

    /* renamed from: f, reason: collision with root package name */
    private int f34629f;

    /* renamed from: g, reason: collision with root package name */
    private int f34630g;

    /* renamed from: h, reason: collision with root package name */
    private int f34631h;

    /* renamed from: i, reason: collision with root package name */
    private int f34632i;

    /* renamed from: j, reason: collision with root package name */
    private int f34633j;

    /* renamed from: k, reason: collision with root package name */
    private float f34634k;

    /* renamed from: l, reason: collision with root package name */
    private float f34635l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f34636m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f34637n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f34638o;

    /* renamed from: p, reason: collision with root package name */
    Runnable f34639p;

    public MBRotationView(Context context) {
        super(context);
        this.f34628e = 40;
        this.f34629f = 20;
        this.f34630g = 0;
        this.f34631h = 0;
        this.f34633j = 0;
        this.f34634k = 0.5f;
        this.f34635l = 0.9f;
        this.f34636m = true;
        this.f34637n = false;
        this.f34638o = false;
        this.f34639p = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.this.b();
            }
        };
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34628e = 40;
        this.f34629f = 20;
        this.f34630g = 0;
        this.f34631h = 0;
        this.f34633j = 0;
        this.f34634k = 0.5f;
        this.f34635l = 0.9f;
        this.f34636m = true;
        this.f34637n = false;
        this.f34638o = false;
        this.f34639p = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.this.b();
            }
        };
        a();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34628e = 40;
        this.f34629f = 20;
        this.f34630g = 0;
        this.f34631h = 0;
        this.f34633j = 0;
        this.f34634k = 0.5f;
        this.f34635l = 0.9f;
        this.f34636m = true;
        this.f34637n = false;
        this.f34638o = false;
        this.f34639p = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView.1
            @Override // java.lang.Runnable
            public void run() {
                MBRotationView.this.b();
            }
        };
        a();
    }

    private void a() {
        this.f34624a = new Camera();
        this.f34625b = new Matrix();
        setWillNotDraw(false);
    }

    private void a(int i11) {
        int i12 = this.f34628e;
        int i13 = this.f34632i - (i11 / i12);
        this.f34630g = i11 % i12;
        b(i13);
        invalidate();
    }

    private void a(int i11, int i12, int i13) {
        if (i13 == 0) {
            float f11 = (-i11) / 2;
            this.f34624a.translate(f11, 0.0f, 0.0f);
            float f12 = -i12;
            this.f34624a.rotateY(f12);
            this.f34624a.translate(f11, 0.0f, 0.0f);
            this.f34624a.translate(f11, 0.0f, 0.0f);
            this.f34624a.rotateY(f12);
            this.f34624a.translate(f11, 0.0f, 0.0f);
            return;
        }
        if (i13 == 1) {
            float f13 = i11 / 2;
            this.f34624a.translate(f13, 0.0f, 0.0f);
            this.f34624a.rotateY(i12);
            this.f34624a.translate(f13, 0.0f, 0.0f);
            return;
        }
        if (i13 != 2) {
            if (i13 != 3) {
                return;
            }
            this.f34624a.rotateY(0.0f);
        } else {
            float f14 = (-i11) / 2;
            this.f34624a.translate(f14, 0.0f, 0.0f);
            this.f34624a.rotateY(-i12);
            this.f34624a.translate(f14, 0.0f, 0.0f);
        }
    }

    private void a(Canvas canvas) {
        int width = getWidth() / 2;
        int i11 = ((this.f34630g * this.f34627d) / 2) / this.f34628e;
        b(canvas, i11, width, 0);
        b(canvas, i11, width, 1);
        if (Math.abs(this.f34630g) > this.f34628e / 2) {
            b(canvas, i11, width, 3);
            b(canvas, i11, width, 2);
        } else {
            b(canvas, i11, width, 2);
            b(canvas, i11, width, 3);
        }
    }

    private void a(Canvas canvas, int i11, int i12, int i13) {
        canvas.save();
        this.f34624a.save();
        this.f34625b.reset();
        float f11 = i11;
        this.f34624a.translate(0.0f, f11, 0.0f);
        this.f34624a.rotateX(this.f34630g);
        this.f34624a.translate(0.0f, f11, 0.0f);
        if (i11 == 0) {
            if (this.f34638o) {
                b(this.f34626c, this.f34628e, i13);
            } else {
                b(-this.f34626c, -this.f34628e, i13);
            }
        } else if (i11 > 0) {
            b(this.f34626c, this.f34628e, i13);
        } else if (i11 < 0) {
            b(-this.f34626c, -this.f34628e, i13);
        }
        this.f34624a.getMatrix(this.f34625b);
        this.f34624a.restore();
        this.f34625b.preTranslate((-getWidth()) / 2, -i12);
        this.f34625b.postTranslate(getWidth() / 2, i12);
        canvas.concat(this.f34625b);
        View childAt = getChildAt(c(i13));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (getChildCount() == 0) {
            return;
        }
        int i11 = this.f34630g - 1;
        this.f34630g = i11;
        this.f34632i = this.f34631h;
        a(i11);
        if (this.f34636m) {
            postDelayed(this.f34639p, 1000 / this.f34629f);
        }
    }

    private void b(int i11) {
        this.f34631h = i11;
        int c11 = Math.abs(this.f34630g) > this.f34628e / 2 ? c(2) : c(3);
        if (this.f34633j != c11) {
            this.f34633j = c11;
        }
    }

    private void b(int i11, int i12, int i13) {
        float f11 = (-i11) / 2.0f;
        if (i13 == 0) {
            this.f34624a.translate(0.0f, f11, 0.0f);
            float f12 = -i12;
            this.f34624a.rotateX(f12);
            this.f34624a.translate(0.0f, f11, 0.0f);
            this.f34624a.translate(0.0f, f11, 0.0f);
            this.f34624a.rotateX(f12);
            this.f34624a.translate(0.0f, f11, 0.0f);
            return;
        }
        if (i13 == 1) {
            this.f34624a.translate(0.0f, f11, 0.0f);
            this.f34624a.rotateX(i12);
            this.f34624a.translate(0.0f, f11, 0.0f);
        } else if (i13 != 2) {
            if (i13 != 3) {
                return;
            }
            this.f34624a.rotateX(0.0f);
        } else {
            this.f34624a.translate(0.0f, f11, 0.0f);
            this.f34624a.rotateX(-i12);
            this.f34624a.translate(0.0f, f11, 0.0f);
        }
    }

    private void b(Canvas canvas) {
        int height = getHeight() / 2;
        int i11 = ((this.f34630g * this.f34626c) / 2) / this.f34628e;
        a(canvas, i11, height, 0);
        a(canvas, i11, height, 1);
        if (Math.abs(this.f34630g) > this.f34628e / 2) {
            a(canvas, i11, height, 3);
            a(canvas, i11, height, 2);
        } else {
            a(canvas, i11, height, 2);
            a(canvas, i11, height, 3);
        }
    }

    private void b(Canvas canvas, int i11, int i12, int i13) {
        canvas.save();
        this.f34624a.save();
        this.f34625b.reset();
        float f11 = i11;
        this.f34624a.translate(f11, 0.0f, 0.0f);
        this.f34624a.rotateY(this.f34630g);
        this.f34624a.translate(f11, 0.0f, 0.0f);
        if (i11 == 0) {
            if (this.f34638o) {
                a(this.f34627d, this.f34628e, i13);
            } else {
                a(-this.f34627d, -this.f34628e, i13);
            }
        } else if (i11 > 0) {
            a(this.f34627d, this.f34628e, i13);
        } else if (i11 < 0) {
            a(-this.f34627d, -this.f34628e, i13);
        }
        this.f34624a.getMatrix(this.f34625b);
        this.f34624a.restore();
        this.f34625b.preTranslate(-i12, (-getHeight()) / 2);
        this.f34625b.postTranslate(i12, getHeight() / 2);
        canvas.concat(this.f34625b);
        View childAt = getChildAt(c(i13));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    private int c(int i11) {
        int i12;
        int i13;
        int i14;
        if (i11 == 0) {
            i12 = this.f34638o ? this.f34631h - 2 : this.f34631h + 2;
        } else if (i11 != 1) {
            if (i11 != 2) {
                i12 = i11 != 3 ? 0 : this.f34631h;
            } else if (this.f34638o) {
                i13 = this.f34631h;
                i12 = i13 - 1;
            } else {
                i14 = this.f34631h;
                i12 = i14 + 1;
            }
        } else if (this.f34638o) {
            i14 = this.f34631h;
            i12 = i14 + 1;
        } else {
            i13 = this.f34631h;
            i12 = i13 - 1;
        }
        int childCount = i12 % getChildCount();
        return childCount >= 0 ? childCount : childCount + getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.f34637n) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        float f11 = i15;
        float f12 = this.f34634k;
        int i16 = (int) (((1.0f - f12) * f11) / 2.0f);
        int i17 = i14 - i12;
        float f13 = i17;
        float f14 = this.f34635l;
        int i18 = (int) (((1.0f - f14) * f13) / 2.0f);
        this.f34626c = (int) (f13 * f14);
        this.f34627d = (int) (f11 * f12);
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            childAt.layout(i16, i18, i15 - i16, i17 - i18);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i20 = layoutParams.width;
            int i21 = this.f34627d;
            if (i20 != i21) {
                layoutParams.width = i21;
                layoutParams.height = this.f34626c;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z10) {
        if (z10) {
            postDelayed(this.f34639p, 1000 / this.f34629f);
        }
        this.f34636m = z10;
    }

    public void setHeightRatio(float f11) {
        this.f34635l = f11;
    }

    public void setRotateV(boolean z10) {
        this.f34637n = z10;
        invalidate();
    }

    public void setWidthRatio(float f11) {
        this.f34634k = f11;
    }
}
