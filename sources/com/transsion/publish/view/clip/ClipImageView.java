package com.transsion.publish.view.clip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* loaded from: classes6.dex */
public class ClipImageView extends BaseClipImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static float SCALE_MAX = 4.0f;

    /* renamed from: t, reason: collision with root package name */
    private static float f50762t = 2.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f50763d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f50764e;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f50765f;

    /* renamed from: g, reason: collision with root package name */
    private ScaleGestureDetector f50766g;

    /* renamed from: h, reason: collision with root package name */
    private final Matrix f50767h;

    /* renamed from: i, reason: collision with root package name */
    private GestureDetector f50768i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f50769j;

    /* renamed from: k, reason: collision with root package name */
    private int f50770k;

    /* renamed from: l, reason: collision with root package name */
    private float f50771l;

    /* renamed from: m, reason: collision with root package name */
    private float f50772m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f50773n;

    /* renamed from: o, reason: collision with root package name */
    private int f50774o;

    /* renamed from: p, reason: collision with root package name */
    private int f50775p;

    /* renamed from: q, reason: collision with root package name */
    private int f50776q;

    /* renamed from: r, reason: collision with root package name */
    private int f50777r;

    /* renamed from: s, reason: collision with root package name */
    private int f50778s;

    /* loaded from: classes6.dex */
    private class AutoScaleRunnable implements Runnable {
        static final float BIGGER = 1.07f;
        static final float SMALLER = 0.93f;
        private float mTargetScale;
        private float tmpScale;

        /* renamed from: x, reason: collision with root package name */
        private float f50779x;

        /* renamed from: y, reason: collision with root package name */
        private float f50780y;

        public AutoScaleRunnable(float f11, float f12, float f13) {
            this.mTargetScale = f11;
            this.f50779x = f12;
            this.f50780y = f13;
            if (ClipImageView.this.getScale() < this.mTargetScale) {
                this.tmpScale = BIGGER;
            } else {
                this.tmpScale = SMALLER;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = ClipImageView.this.f50767h;
            float f11 = this.tmpScale;
            matrix.postScale(f11, f11, this.f50779x, this.f50780y);
            ClipImageView.this.g();
            ClipImageView clipImageView = ClipImageView.this;
            clipImageView.setImageMatrix(clipImageView.f50767h);
            float scale = ClipImageView.this.getScale();
            float f12 = this.tmpScale;
            if ((f12 > 1.0f && scale < this.mTargetScale) || (f12 < 1.0f && this.mTargetScale < scale)) {
                ClipImageView.this.postDelayed(this, 16L);
                return;
            }
            float f13 = this.mTargetScale / scale;
            ClipImageView.this.f50767h.postScale(f13, f13, this.f50779x, this.f50780y);
            ClipImageView.this.g();
            ClipImageView clipImageView2 = ClipImageView.this;
            clipImageView2.setImageMatrix(clipImageView2.f50767h);
            ClipImageView.this.f50769j = false;
        }
    }

    /* loaded from: classes6.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ClipImageView.this.f50769j) {
                return true;
            }
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (ClipImageView.this.getScale() < ClipImageView.f50762t) {
                ClipImageView clipImageView = ClipImageView.this;
                clipImageView.postDelayed(new AutoScaleRunnable(ClipImageView.f50762t, x10, y10), 16L);
                ClipImageView.this.f50769j = true;
            } else {
                ClipImageView clipImageView2 = ClipImageView.this;
                clipImageView2.postDelayed(new AutoScaleRunnable(clipImageView2.f50763d, x10, y10), 16L);
                ClipImageView.this.f50769j = true;
            }
            return true;
        }
    }

    public ClipImageView(Context context) {
        this(context, null);
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50763d = 1.0f;
        this.f50764e = true;
        this.f50765f = new float[9];
        this.f50766g = null;
        this.f50767h = new Matrix();
        this.f50775p = 16;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f50768i = new GestureDetector(context, new a());
        this.f50766g = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        float f11;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        double width2 = matrixRectF.width() + 0.01d;
        int i11 = this.f50775p;
        if (width2 >= width - (i11 * 2)) {
            float f12 = matrixRectF.left;
            f11 = f12 > ((float) i11) ? (-f12) + i11 : 0.0f;
            float f13 = matrixRectF.right;
            if (f13 < width - i11) {
                f11 = (width - i11) - f13;
            }
        } else {
            f11 = 0.0f;
        }
        double height2 = matrixRectF.height() + 0.01d;
        int i12 = this.f50778s;
        if (height2 >= height - (i12 * 2)) {
            float f14 = matrixRectF.top;
            r4 = f14 > ((float) i12) ? (-f14) + i12 : 0.0f;
            float f15 = matrixRectF.bottom;
            if (f15 < height - i12) {
                r4 = (height - i12) - f15;
            }
        }
        this.f50767h.postTranslate(f11, r4);
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.f50767h;
        RectF rectF = new RectF();
        if (getDrawable() != null) {
            rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    private boolean h(float f11, float f12) {
        return Math.sqrt((double) ((f11 * f11) + (f12 * f12))) >= ((double) this.f50770k);
    }

    public Bitmap clip() {
        return clip(null);
    }

    public Bitmap clip(Rect rect) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        return rect == null ? Bitmap.createBitmap(createBitmap, this.f50775p, this.f50778s, getWidth() - (this.f50775p * 2), getWidth() - (this.f50775p * 2)) : (rect.width() <= 0 || rect.height() <= 0) ? createBitmap : Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
    }

    public final float getScale() {
        this.f50767h.getValues(this.f50765f);
        return this.f50765f[0];
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        if (!this.f50764e || (drawable = getDrawable()) == null) {
            return;
        }
        if (this.f50776q == 0) {
            this.f50778s = (getHeight() - (getWidth() - (this.f50775p * 2))) / 2;
        } else {
            this.f50775p = (getWidth() - this.f50776q) / 2;
            this.f50778s = (getHeight() - this.f50777r) / 2;
        }
        float width = getWidth();
        float height = getHeight();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float max = Math.max((getWidth() - (this.f50775p * 2)) / intrinsicWidth, (getHeight() - (this.f50778s * 2)) / intrinsicHeight);
        this.f50763d = max;
        f50762t = max * 2.0f;
        SCALE_MAX = 4.0f * max;
        this.f50767h.postTranslate((width - intrinsicWidth) / 2.0f, (height - intrinsicHeight) / 2.0f);
        this.f50767h.postScale(max, max, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.f50767h);
        this.f50764e = false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        float f11 = SCALE_MAX;
        if ((scale < f11 && scaleFactor > 1.0f) || (scale > this.f50763d && scaleFactor < 1.0f)) {
            float f12 = scaleFactor * scale;
            float f13 = this.f50763d;
            if (f12 < f13) {
                scaleFactor = f13 / scale;
            }
            if (scaleFactor * scale > f11) {
                scaleFactor = f11 / scale;
            }
            this.f50767h.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            g();
            setImageMatrix(this.f50767h);
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r10 != 3) goto L35;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            android.view.GestureDetector r10 = r9.f50768i
            boolean r10 = r10.onTouchEvent(r11)
            r0 = 1
            if (r10 == 0) goto La
            return r0
        La:
            android.view.ScaleGestureDetector r10 = r9.f50766g
            r10.onTouchEvent(r11)
            int r10 = r11.getPointerCount()
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r2
            r5 = r4
        L18:
            if (r3 >= r10) goto L27
            float r6 = r11.getX(r3)
            float r4 = r4 + r6
            float r6 = r11.getY(r3)
            float r5 = r5 + r6
            int r3 = r3 + 1
            goto L18
        L27:
            float r3 = (float) r10
            float r4 = r4 / r3
            float r5 = r5 / r3
            int r3 = r9.f50774o
            if (r10 == r3) goto L34
            r9.f50773n = r1
            r9.f50771l = r4
            r9.f50772m = r5
        L34:
            r9.f50774o = r10
            int r10 = r11.getAction()
            if (r10 == r0) goto L9a
            r11 = 2
            if (r10 == r11) goto L43
            r11 = 3
            if (r10 == r11) goto L9a
            goto L9c
        L43:
            float r10 = r9.f50771l
            float r10 = r4 - r10
            float r1 = r9.f50772m
            float r1 = r5 - r1
            boolean r3 = r9.f50773n
            if (r3 != 0) goto L55
            boolean r3 = r9.h(r10, r1)
            r9.f50773n = r3
        L55:
            boolean r3 = r9.f50773n
            if (r3 == 0) goto L95
            android.graphics.drawable.Drawable r3 = r9.getDrawable()
            if (r3 == 0) goto L95
            android.graphics.RectF r3 = r9.getMatrixRectF()
            float r6 = r3.width()
            int r7 = r9.getWidth()
            int r8 = r9.f50775p
            int r8 = r8 * r11
            int r7 = r7 - r8
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 > 0) goto L75
            r10 = r2
        L75:
            float r3 = r3.height()
            int r6 = r9.getHeight()
            int r7 = r9.f50778s
            int r7 = r7 * r11
            int r6 = r6 - r7
            float r11 = (float) r6
            int r11 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r11 > 0) goto L87
            goto L88
        L87:
            r2 = r1
        L88:
            android.graphics.Matrix r11 = r9.f50767h
            r11.postTranslate(r10, r2)
            r9.g()
            android.graphics.Matrix r10 = r9.f50767h
            r9.setImageMatrix(r10)
        L95:
            r9.f50771l = r4
            r9.f50772m = r5
            goto L9c
        L9a:
            r9.f50774o = r1
        L9c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.publish.view.clip.ClipImageView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setCropWH(int i11, int i12) {
        this.f50776q = i11;
        this.f50777r = i12;
    }
}
