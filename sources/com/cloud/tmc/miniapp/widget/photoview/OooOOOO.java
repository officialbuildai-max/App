package com.cloud.tmc.miniapp.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes3.dex */
public class OooOOOO implements View.OnTouchListener, View.OnLayoutChangeListener {
    public final ImageView OooO;
    public GestureDetector OooOO0;
    public com.cloud.tmc.miniapp.widget.photoview.OooO00o OooOO0O;
    public com.cloud.tmc.miniapp.widget.photoview.OooO OooOOo;
    public com.cloud.tmc.miniapp.widget.photoview.OooO0OO OooOOo0;
    public com.cloud.tmc.miniapp.widget.photoview.OooO0o OooOOoo;
    public OooOO0O OooOo;
    public View.OnClickListener OooOo0;
    public OooOOO OooOo00;
    public View.OnLongClickListener OooOo0O;
    public com.cloud.tmc.miniapp.widget.photoview.OooOO0 OooOo0o;
    public OooOO0 OooOoO;
    public OooOOO0 OooOoO0;
    public Interpolator OooO00o = new AccelerateDecelerateInterpolator();
    public int OooO0O0 = 200;
    public float OooO0OO = 1.0f;
    public float OooO0Oo = 1.75f;
    public float OooO0o0 = 3.0f;
    public boolean OooO0o = true;
    public boolean OooO0oO = false;
    public boolean OooO0oo = false;
    public final Matrix OooOO0o = new Matrix();
    public final Matrix OooOOO0 = new Matrix();
    public final Matrix OooOOO = new Matrix();
    public final RectF OooOOOO = new RectF();
    public final float[] OooOOOo = new float[9];
    public int OooOoOO = 2;
    public int OooOoo0 = 2;
    public boolean OooOoo = true;
    public ImageView.ScaleType OooOooO = ImageView.ScaleType.FIT_CENTER;
    public com.cloud.tmc.miniapp.widget.photoview.OooO0O0 OooOooo = new OooO00o();

    /* loaded from: classes3.dex */
    public class OooO implements Runnable {
        public final float OooO00o;
        public final float OooO0O0;
        public final long OooO0OO = System.currentTimeMillis();
        public final float OooO0Oo;
        public final float OooO0o0;

        public OooO(float f11, float f12, float f13, float f14) {
            this.OooO00o = f13;
            this.OooO0O0 = f14;
            this.OooO0Oo = f11;
            this.OooO0o0 = f12;
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolation = OooOOOO.this.OooO00o.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.OooO0OO)) * 1.0f) / OooOOOO.this.OooO0O0));
            float f11 = this.OooO0Oo;
            ((OooO00o) OooOOOO.this.OooOooo).OooO00o((((this.OooO0o0 - f11) * interpolation) + f11) / OooOOOO.this.OooO0o0(), this.OooO00o, this.OooO0O0, 0.0f, 0.0f);
            if (interpolation < 1.0f) {
                OooOOOO.this.OooO.postOnAnimation(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooO00o implements com.cloud.tmc.miniapp.widget.photoview.OooO0O0 {
        public OooO00o() {
        }

        public void OooO00o(float f11, float f12, float f13, float f14, float f15) {
            float OooO0o0 = OooOOOO.this.OooO0o0();
            OooOOOO oooOOOO = OooOOOO.this;
            if (OooO0o0 < oooOOOO.OooO0o0 || f11 < 1.0f) {
                com.cloud.tmc.miniapp.widget.photoview.OooOO0 oooOO0 = oooOOOO.OooOo0o;
                if (oooOO0 != null) {
                    oooOO0.OooO00o(f11, f12, f13);
                }
                OooOOOO.this.OooOOO.postScale(f11, f11, f12, f13);
                OooOOOO.this.OooOOO.postTranslate(f14, f15);
                OooOOOO.this.OooO00o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooO0O0 extends GestureDetector.SimpleOnGestureListener {
        public OooO0O0() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            OooOOOO oooOOOO = OooOOOO.this;
            if (oooOOOO.OooOo == null || oooOOOO.OooO0o0() > 1.0f || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            return OooOOOO.this.OooOo.onFling(motionEvent, motionEvent2, f11, f12);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            OooOOOO oooOOOO = OooOOOO.this;
            View.OnLongClickListener onLongClickListener = oooOOOO.OooOo0O;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(oooOOOO.OooO);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooO0OO implements GestureDetector.OnDoubleTapListener {
        public OooO0OO() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float OooO0o0 = OooOOOO.this.OooO0o0();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                OooOOOO oooOOOO = OooOOOO.this;
                float f11 = oooOOOO.OooO0Oo;
                if (OooO0o0 < f11) {
                    oooOOOO.OooO00o(f11, x10, y10, true);
                } else {
                    if (OooO0o0 >= f11) {
                        float f12 = oooOOOO.OooO0o0;
                        if (OooO0o0 < f12) {
                            oooOOOO.OooO00o(f12, x10, y10, true);
                        }
                    }
                    oooOOOO.OooO00o(oooOOOO.OooO0OO, x10, y10, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            OooOOOO oooOOOO = OooOOOO.this;
            View.OnClickListener onClickListener = oooOOOO.OooOo0;
            if (onClickListener != null) {
                onClickListener.onClick(oooOOOO.OooO);
            }
            RectF OooO0OO = OooOOOO.this.OooO0OO();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            OooOOOO oooOOOO2 = OooOOOO.this;
            OooOOO oooOOO = oooOOOO2.OooOo00;
            if (oooOOO != null) {
                oooOOO.OooO00o(oooOOOO2.OooO, x10, y10);
            }
            if (OooO0OO == null) {
                return false;
            }
            if (!OooO0OO.contains(x10, y10)) {
                OooOOOO oooOOOO3 = OooOOOO.this;
                com.cloud.tmc.miniapp.widget.photoview.OooO0o oooO0o = oooOOOO3.OooOOoo;
                if (oooO0o == null) {
                    return false;
                }
                oooO0o.OooO00o(oooOOOO3.OooO);
                return false;
            }
            float width = (x10 - OooO0OO.left) / OooO0OO.width();
            float height = (y10 - OooO0OO.top) / OooO0OO.height();
            OooOOOO oooOOOO4 = OooOOOO.this;
            com.cloud.tmc.miniapp.widget.photoview.OooO oooO = oooOOOO4.OooOOo;
            if (oooO == null) {
                return true;
            }
            oooO.OooO00o(oooOOOO4.OooO, width, height);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class OooO0o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            OooO00o = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OooO00o[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OooO00o[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                OooO00o[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class OooOO0 implements Runnable {
        public final OverScroller OooO00o;
        public int OooO0O0;
        public int OooO0OO;

        public OooOO0(Context context) {
            this.OooO00o = new OverScroller(context);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.OooO00o.isFinished() && this.OooO00o.computeScrollOffset()) {
                int currX = this.OooO00o.getCurrX();
                int currY = this.OooO00o.getCurrY();
                OooOOOO.this.OooOOO.postTranslate(this.OooO0O0 - currX, this.OooO0OO - currY);
                OooOOOO.this.OooO00o();
                this.OooO0O0 = currX;
                this.OooO0OO = currY;
                OooOOOO.this.OooO.postOnAnimation(this);
            }
        }
    }

    public OooOOOO(ImageView imageView) {
        this.OooO = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.OooOO0O = new com.cloud.tmc.miniapp.widget.photoview.OooO00o(imageView.getContext(), this.OooOooo);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new OooO0O0());
        this.OooOO0 = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new OooO0OO());
    }

    public final int OooO00o(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final RectF OooO00o(Matrix matrix) {
        if (this.OooO.getDrawable() == null) {
            return null;
        }
        this.OooOOOO.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.OooOOOO);
        return this.OooOOOO;
    }

    public final void OooO00o() {
        RectF OooO00o2;
        if (OooO0O0()) {
            Matrix OooO0Oo = OooO0Oo();
            this.OooO.setImageMatrix(OooO0Oo);
            if (this.OooOOo0 == null || (OooO00o2 = OooO00o(OooO0Oo)) == null) {
                return;
            }
            this.OooOOo0.OooO00o(OooO00o2);
        }
    }

    public void OooO00o(float f11, float f12, float f13, boolean z10) {
        if (f11 < this.OooO0OO || f11 > this.OooO0o0) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.OooO.post(new OooO(OooO0o0(), f11, f12, f13));
        } else {
            this.OooOOO.setScale(f11, f11, f12, f13);
            OooO00o();
        }
    }

    public final void OooO00o(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float OooO0O02 = OooO0O0(this.OooO);
        float OooO00o2 = OooO00o(this.OooO);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.OooOO0o.reset();
        float f11 = intrinsicWidth;
        float f12 = OooO0O02 / f11;
        float f13 = intrinsicHeight;
        float f14 = OooO00o2 / f13;
        ImageView.ScaleType scaleType = this.OooOooO;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.OooOO0o.postTranslate((OooO0O02 - f11) / 2.0f, (OooO00o2 - f13) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f12, f14);
            this.OooOO0o.postScale(max, max);
            this.OooOO0o.postTranslate((OooO0O02 - (f11 * max)) / 2.0f, (OooO00o2 - (f13 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f12, f14));
            this.OooOO0o.postScale(min, min);
            this.OooOO0o.postTranslate((OooO0O02 - (f11 * min)) / 2.0f, (OooO00o2 - (f13 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f11, f13);
            RectF rectF2 = new RectF(0.0f, 0.0f, OooO0O02, OooO00o2);
            if (((int) 0.0f) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f13, f11);
            }
            int i11 = OooO0o.OooO00o[this.OooOooO.ordinal()];
            if (i11 == 1) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i11 == 2) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i11 == 3) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i11 == 4) {
                this.OooOO0o.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        OooO0o();
    }

    public final int OooO0O0(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final boolean OooO0O0() {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        RectF OooO00o2 = OooO00o(OooO0Oo());
        if (OooO00o2 == null) {
            return false;
        }
        float height = OooO00o2.height();
        float width = OooO00o2.width();
        float OooO00o3 = OooO00o(this.OooO);
        float f16 = 0.0f;
        if (height <= OooO00o3) {
            int i11 = OooO0o.OooO00o[this.OooOooO.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f14 = (OooO00o3 - height) / 2.0f;
                    f15 = OooO00o2.top;
                } else {
                    f14 = OooO00o3 - height;
                    f15 = OooO00o2.top;
                }
                f11 = f14 - f15;
            } else {
                f11 = -OooO00o2.top;
            }
            this.OooOoo0 = 2;
        } else {
            float f17 = OooO00o2.top;
            if (f17 > 0.0f) {
                this.OooOoo0 = 0;
                f11 = -f17;
            } else {
                float f18 = OooO00o2.bottom;
                if (f18 < OooO00o3) {
                    this.OooOoo0 = 1;
                    f11 = OooO00o3 - f18;
                } else {
                    this.OooOoo0 = -1;
                    f11 = 0.0f;
                }
            }
        }
        float OooO0O02 = OooO0O0(this.OooO);
        if (width <= OooO0O02) {
            int i12 = OooO0o.OooO00o[this.OooOooO.ordinal()];
            if (i12 != 2) {
                if (i12 != 3) {
                    f12 = (OooO0O02 - width) / 2.0f;
                    f13 = OooO00o2.left;
                } else {
                    f12 = OooO0O02 - width;
                    f13 = OooO00o2.left;
                }
                f16 = f12 - f13;
            } else {
                f16 = -OooO00o2.left;
            }
            this.OooOoOO = 2;
        } else {
            float f19 = OooO00o2.left;
            if (f19 > 0.0f) {
                this.OooOoOO = 0;
                f16 = -f19;
            } else {
                float f20 = OooO00o2.right;
                if (f20 < OooO0O02) {
                    f16 = OooO0O02 - f20;
                    this.OooOoOO = 1;
                } else {
                    this.OooOoOO = -1;
                }
            }
        }
        this.OooOOO.postTranslate(f16, f11);
        return true;
    }

    public RectF OooO0OO() {
        OooO0O0();
        return OooO00o(OooO0Oo());
    }

    public final Matrix OooO0Oo() {
        this.OooOOO0.set(this.OooOO0o);
        this.OooOOO0.postConcat(this.OooOOO);
        return this.OooOOO0;
    }

    public final void OooO0o() {
        RectF OooO00o2;
        this.OooOOO.reset();
        this.OooOOO.postRotate(0.0f);
        OooO00o();
        Matrix OooO0Oo = OooO0Oo();
        this.OooO.setImageMatrix(OooO0Oo);
        if (this.OooOOo0 != null && (OooO00o2 = OooO00o(OooO0Oo)) != null) {
            this.OooOOo0.OooO00o(OooO00o2);
        }
        OooO0O0();
    }

    public float OooO0o0() {
        this.OooOOO.getValues(this.OooOOOo);
        float pow = (float) Math.pow(this.OooOOOo[0], 2.0d);
        this.OooOOO.getValues(this.OooOOOo);
        return (float) Math.sqrt(pow + ((float) Math.pow(this.OooOOOo[3], 2.0d)));
    }

    public void OooO0oO() {
        if (this.OooOoo) {
            OooO00o(this.OooO.getDrawable());
        } else {
            OooO0o();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 == i15 && i12 == i16 && i13 == i17 && i14 == i18) {
            return;
        }
        OooO00o(this.OooO.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.OooOoo
            r1 = 0
            if (r0 == 0) goto Ld3
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            if (r0 == 0) goto Ld3
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L83
        L1b:
            float r0 = r10.OooO0o0()
            float r3 = r10.OooO0OO
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L45
            android.graphics.RectF r0 = r10.OooO0OO()
            if (r0 == 0) goto L83
            com.cloud.tmc.miniapp.widget.photoview.OooOOOO$OooO r9 = new com.cloud.tmc.miniapp.widget.photoview.OooOOOO$OooO
            float r5 = r10.OooO0o0()
            float r6 = r10.OooO0OO
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L43:
            r11 = r2
            goto L84
        L45:
            float r0 = r10.OooO0o0()
            float r3 = r10.OooO0o0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.RectF r0 = r10.OooO0OO()
            if (r0 == 0) goto L83
            com.cloud.tmc.miniapp.widget.photoview.OooOOOO$OooO r9 = new com.cloud.tmc.miniapp.widget.photoview.OooOOOO$OooO
            float r5 = r10.OooO0o0()
            float r6 = r10.OooO0o0
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L43
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            com.cloud.tmc.miniapp.widget.photoview.OooOOOO$OooOO0 r11 = r10.OooOoO
            if (r11 == 0) goto L83
            android.widget.OverScroller r11 = r11.OooO00o
            r11.forceFinished(r2)
            r11 = 0
            r10.OooOoO = r11
        L83:
            r11 = r1
        L84:
            com.cloud.tmc.miniapp.widget.photoview.OooO00o r0 = r10.OooOO0O
            if (r0 == 0) goto Lbe
            android.view.ScaleGestureDetector r11 = r0.OooO0OO
            boolean r11 = r11.isInProgress()
            com.cloud.tmc.miniapp.widget.photoview.OooO00o r0 = r10.OooOO0O
            boolean r3 = r0.OooO0o0
            android.view.ScaleGestureDetector r4 = r0.OooO0OO     // Catch: java.lang.IllegalArgumentException -> L9a
            r4.onTouchEvent(r12)     // Catch: java.lang.IllegalArgumentException -> L9a
            r0.OooO0OO(r12)     // Catch: java.lang.IllegalArgumentException -> L9a
        L9a:
            if (r11 != 0) goto La8
            com.cloud.tmc.miniapp.widget.photoview.OooO00o r11 = r10.OooOO0O
            android.view.ScaleGestureDetector r11 = r11.OooO0OO
            boolean r11 = r11.isInProgress()
            if (r11 != 0) goto La8
            r11 = r2
            goto La9
        La8:
            r11 = r1
        La9:
            if (r3 != 0) goto Lb3
            com.cloud.tmc.miniapp.widget.photoview.OooO00o r0 = r10.OooOO0O
            boolean r0 = r0.OooO0o0
            if (r0 != 0) goto Lb3
            r0 = r2
            goto Lb4
        Lb3:
            r0 = r1
        Lb4:
            if (r11 == 0) goto Lba
            if (r0 == 0) goto Lba
            r11 = r2
            goto Lbb
        Lba:
            r11 = r1
        Lbb:
            r10.OooO0oO = r11
            r11 = r2
        Lbe:
            android.view.GestureDetector r0 = r10.OooOO0
            if (r0 == 0) goto Lc9
            boolean r0 = r0.onTouchEvent(r12)
            if (r0 == 0) goto Lc9
            r11 = r2
        Lc9:
            int r12 = r12.getPointerCount()
            if (r12 <= r2) goto Ld0
            r1 = r2
        Ld0:
            r10.OooO0oo = r1
            r1 = r11
        Ld3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.photoview.OooOOOO.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
