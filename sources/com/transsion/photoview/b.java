package com.transsion.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f47938a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f47939b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f47940c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f47941d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f47942e;

    /* renamed from: f, reason: collision with root package name */
    private float f47943f;

    /* renamed from: g, reason: collision with root package name */
    private float f47944g;

    /* renamed from: h, reason: collision with root package name */
    private final float f47945h;

    /* renamed from: i, reason: collision with root package name */
    private final float f47946i;

    /* renamed from: j, reason: collision with root package name */
    private final c f47947j;

    /* renamed from: k, reason: collision with root package name */
    private float f47948k;

    /* renamed from: l, reason: collision with root package name */
    private float f47949l;

    /* renamed from: m, reason: collision with root package name */
    private float f47950m;

    /* renamed from: n, reason: collision with root package name */
    private float f47951n;

    /* loaded from: classes6.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private float f47952a;

        /* renamed from: b, reason: collision with root package name */
        private float f47953b = 0.0f;

        a() {
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
            b.this.f47947j.c(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.f47952a, scaleGestureDetector.getFocusY() - this.f47953b);
            this.f47952a = scaleGestureDetector.getFocusX();
            this.f47953b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f47952a = scaleGestureDetector.getFocusX();
            this.f47953b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f47946i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f47945h = viewConfiguration.getScaledTouchSlop();
        this.f47947j = cVar;
        this.f47940c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f47939b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f47939b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean i(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f47938a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f47941d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f47943f = b(motionEvent);
            this.f47944g = c(motionEvent);
            this.f47942e = false;
            this.f47948k = motionEvent.getRawY();
            this.f47949l = motionEvent.getRawX();
        } else if (action == 1) {
            this.f47938a = -1;
            if (this.f47942e && this.f47941d != null) {
                this.f47943f = b(motionEvent);
                this.f47944g = c(motionEvent);
                this.f47941d.addMovement(motionEvent);
                this.f47941d.computeCurrentVelocity(1000);
                float xVelocity = this.f47941d.getXVelocity();
                float yVelocity = this.f47941d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f47946i) {
                    this.f47947j.e(this.f47943f, this.f47944g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f47941d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f47941d = null;
            }
        } else if (action == 2) {
            this.f47950m = motionEvent.getRawY() - this.f47948k;
            this.f47951n = motionEvent.getRawX() - this.f47949l;
            float b11 = b(motionEvent);
            float c11 = c(motionEvent);
            float f11 = b11 - this.f47943f;
            float f12 = c11 - this.f47944g;
            if (!this.f47942e) {
                this.f47942e = Math.sqrt((double) ((f11 * f11) + (f12 * f12))) >= ((double) this.f47945h);
            }
            if (this.f47942e) {
                this.f47947j.b(f11, f12);
                this.f47943f = b11;
                this.f47944g = c11;
                VelocityTracker velocityTracker2 = this.f47941d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f47938a = -1;
            VelocityTracker velocityTracker3 = this.f47941d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f47941d = null;
            }
        } else if (action == 6) {
            int b12 = o.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b12) == this.f47938a) {
                int i11 = b12 == 0 ? 1 : 0;
                this.f47938a = motionEvent.getPointerId(i11);
                this.f47943f = motionEvent.getX(i11);
                this.f47944g = motionEvent.getY(i11);
            }
        }
        int i12 = this.f47938a;
        this.f47939b = motionEvent.findPointerIndex(i12 != -1 ? i12 : 0);
        return true;
    }

    public float d() {
        return this.f47951n;
    }

    public float e() {
        return this.f47950m;
    }

    public boolean f() {
        return this.f47942e;
    }

    public boolean g() {
        return this.f47940c.isInProgress();
    }

    public boolean h(MotionEvent motionEvent) {
        try {
            this.f47940c.onTouchEvent(motionEvent);
            return i(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
