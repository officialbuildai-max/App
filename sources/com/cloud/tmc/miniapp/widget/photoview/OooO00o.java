package com.cloud.tmc.miniapp.widget.photoview;

import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.view.MotionEventCompat;
import com.cloud.tmc.miniapp.widget.photoview.OooOOOO;

/* loaded from: classes3.dex */
public class OooO00o {
    public final float OooO;
    public int OooO00o = -1;
    public int OooO0O0 = 0;
    public final ScaleGestureDetector OooO0OO;
    public VelocityTracker OooO0Oo;
    public float OooO0o;
    public boolean OooO0o0;
    public float OooO0oO;
    public final float OooO0oo;
    public OooO0O0 OooOO0;

    /* renamed from: com.cloud.tmc.miniapp.widget.photoview.OooO00o$OooO00o, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ScaleGestureDetectorOnScaleGestureListenerC0352OooO00o implements ScaleGestureDetector.OnScaleGestureListener {
        public float OooO00o;
        public float OooO0O0 = 0.0f;

        public ScaleGestureDetectorOnScaleGestureListenerC0352OooO00o() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            ((OooOOOO.OooO00o) OooO00o.this.OooOO0).OooO00o(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.OooO00o, scaleGestureDetector.getFocusY() - this.OooO0O0);
            this.OooO00o = scaleGestureDetector.getFocusX();
            this.OooO0O0 = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.OooO00o = scaleGestureDetector.getFocusX();
            this.OooO0O0 = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public OooO00o(Context context, OooO0O0 oooO0O0) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.OooO = viewConfiguration.getScaledMinimumFlingVelocity();
        this.OooO0oo = viewConfiguration.getScaledTouchSlop();
        this.OooOO0 = oooO0O0;
        this.OooO0OO = new ScaleGestureDetector(context, new ScaleGestureDetectorOnScaleGestureListenerC0352OooO00o());
    }

    public final float OooO00o(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.OooO0O0);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float OooO0O0(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.OooO0O0);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public final boolean OooO0OO(MotionEvent motionEvent) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.OooO00o = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.OooO0Oo = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.OooO0o = OooO00o(motionEvent);
            this.OooO0oO = OooO0O0(motionEvent);
            this.OooO0o0 = false;
        } else if (action == 1) {
            this.OooO00o = -1;
            if (this.OooO0o0 && this.OooO0Oo != null) {
                this.OooO0o = OooO00o(motionEvent);
                this.OooO0oO = OooO0O0(motionEvent);
                this.OooO0Oo.addMovement(motionEvent);
                this.OooO0Oo.computeCurrentVelocity(1000);
                float xVelocity = this.OooO0Oo.getXVelocity();
                float yVelocity = this.OooO0Oo.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.OooO) {
                    OooOOOO.OooO00o oooO00o = (OooOOOO.OooO00o) this.OooOO0;
                    OooOOOO oooOOOO = OooOOOO.this;
                    oooOOOO.OooOoO = new OooOOOO.OooOO0(oooOOOO.OooO.getContext());
                    OooOOOO oooOOOO2 = OooOOOO.this;
                    OooOOOO.OooOO0 oooOO0 = oooOOOO2.OooOoO;
                    int OooO0O0 = oooOOOO2.OooO0O0(oooOOOO2.OooO);
                    OooOOOO oooOOOO3 = OooOOOO.this;
                    int OooO00o = oooOOOO3.OooO00o(oooOOOO3.OooO);
                    int i16 = (int) (-xVelocity);
                    int i17 = (int) (-yVelocity);
                    RectF OooO0OO = OooOOOO.this.OooO0OO();
                    if (OooO0OO != null) {
                        int round = Math.round(-OooO0OO.left);
                        float f11 = OooO0O0;
                        if (f11 < OooO0OO.width()) {
                            i11 = Math.round(OooO0OO.width() - f11);
                            i12 = 0;
                        } else {
                            i11 = round;
                            i12 = i11;
                        }
                        int round2 = Math.round(-OooO0OO.top);
                        float f12 = OooO00o;
                        if (f12 < OooO0OO.height()) {
                            i13 = Math.round(OooO0OO.height() - f12);
                            i14 = 0;
                        } else {
                            i13 = round2;
                            i14 = i13;
                        }
                        oooOO0.OooO0O0 = round;
                        oooOO0.OooO0OO = round2;
                        if (round != i11 || round2 != i13) {
                            oooOO0.OooO00o.fling(round, round2, i16, i17, i12, i11, i14, i13, 0, 0);
                        }
                    }
                    OooOOOO oooOOOO4 = OooOOOO.this;
                    oooOOOO4.OooO.post(oooOOOO4.OooOoO);
                }
            }
            VelocityTracker velocityTracker = this.OooO0Oo;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.OooO0Oo = null;
            }
        } else if (action == 2) {
            float OooO00o2 = OooO00o(motionEvent);
            float OooO0O02 = OooO0O0(motionEvent);
            float f13 = OooO00o2 - this.OooO0o;
            float f14 = OooO0O02 - this.OooO0oO;
            if (!this.OooO0o0) {
                this.OooO0o0 = Math.sqrt((double) ((f14 * f14) + (f13 * f13))) >= ((double) this.OooO0oo);
            }
            if (this.OooO0o0) {
                OooOOOO.OooO00o oooO00o2 = (OooOOOO.OooO00o) this.OooOO0;
                if (!OooOOOO.this.OooOO0O.OooO0OO.isInProgress()) {
                    OooOOO0 oooOOO0 = OooOOOO.this.OooOoO0;
                    if (oooOOO0 != null) {
                        oooOOO0.OooO00o(f13, f14);
                    }
                    OooOOOO.this.OooOOO.postTranslate(f13, f14);
                    OooOOOO.this.OooO00o();
                    ViewParent parent = OooOOOO.this.OooO.getParent();
                    OooOOOO oooOOOO5 = OooOOOO.this;
                    if (oooOOOO5.OooO0o && !oooOOOO5.OooOO0O.OooO0OO.isInProgress()) {
                        OooOOOO oooOOOO6 = OooOOOO.this;
                        if (!oooOOOO6.OooO0oO && !oooOOOO6.OooO0oo) {
                            float abs = Math.abs(f13);
                            float abs2 = Math.abs(f14);
                            OooOOOO oooOOOO7 = OooOOOO.this;
                            int i18 = oooOOOO7.OooOoOO;
                            if (((i18 == 2 && abs > abs2) || ((i18 == 0 && f13 >= 1.0f && abs > abs2) || ((i18 == 1 && f13 <= -1.0f && abs > abs2) || (((i15 = oooOOOO7.OooOoo0) == 0 && f14 >= 1.0f && abs2 > abs) || ((i15 == 1 && f14 <= -1.0f && abs2 > abs) || (i15 == 2 && abs2 > abs)))))) && parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    }
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                this.OooO0o = OooO00o2;
                this.OooO0oO = OooO0O02;
                VelocityTracker velocityTracker2 = this.OooO0Oo;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.OooO00o = -1;
            VelocityTracker velocityTracker3 = this.OooO0Oo;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.OooO0Oo = null;
            }
        } else if (action == 6) {
            int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (motionEvent.getPointerId(action2) == this.OooO00o) {
                int i19 = action2 == 0 ? 1 : 0;
                this.OooO00o = motionEvent.getPointerId(i19);
                this.OooO0o = motionEvent.getX(i19);
                this.OooO0oO = motionEvent.getY(i19);
            }
        }
        int i20 = this.OooO00o;
        this.OooO0O0 = motionEvent.findPointerIndex(i20 != -1 ? i20 : 0);
        return true;
    }
}
