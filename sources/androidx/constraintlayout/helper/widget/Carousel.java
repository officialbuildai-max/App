package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Carousel extends MotionHelper {
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private int A;
    private float B;
    private int C;
    private int D;
    int E;
    Runnable F;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayList f7165n;

    /* renamed from: o, reason: collision with root package name */
    private int f7166o;

    /* renamed from: p, reason: collision with root package name */
    private int f7167p;

    /* renamed from: q, reason: collision with root package name */
    private MotionLayout f7168q;

    /* renamed from: r, reason: collision with root package name */
    private int f7169r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7170s;

    /* renamed from: t, reason: collision with root package name */
    private int f7171t;

    /* renamed from: u, reason: collision with root package name */
    private int f7172u;

    /* renamed from: v, reason: collision with root package name */
    private int f7173v;

    /* renamed from: w, reason: collision with root package name */
    private int f7174w;

    /* renamed from: x, reason: collision with root package name */
    private float f7175x;

    /* renamed from: y, reason: collision with root package name */
    private int f7176y;

    /* renamed from: z, reason: collision with root package name */
    private int f7177z;

    /* loaded from: classes.dex */
    public interface a {
    }

    public Carousel(Context context) {
        super(context);
        this.f7165n = new ArrayList();
        this.f7166o = 0;
        this.f7167p = 0;
        this.f7169r = -1;
        this.f7170s = false;
        this.f7171t = -1;
        this.f7172u = -1;
        this.f7173v = -1;
        this.f7174w = -1;
        this.f7175x = 0.9f;
        this.f7176y = 0;
        this.f7177z = 4;
        this.A = 1;
        this.B = 2.0f;
        this.C = -1;
        this.D = 200;
        this.E = -1;
        this.F = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1

            /* renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC00611 implements Runnable {
                final /* synthetic */ float val$v;

                RunnableC00611(float f11) {
                    this.val$v = f11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Carousel.this.f7168q.touchAnimateTo(5, 1.0f, this.val$v);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f7168q.setProgress(0.0f);
                Carousel.this.q();
                Carousel.o(Carousel.this);
                int unused = Carousel.this.f7167p;
                throw null;
            }
        };
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7165n = new ArrayList();
        this.f7166o = 0;
        this.f7167p = 0;
        this.f7169r = -1;
        this.f7170s = false;
        this.f7171t = -1;
        this.f7172u = -1;
        this.f7173v = -1;
        this.f7174w = -1;
        this.f7175x = 0.9f;
        this.f7176y = 0;
        this.f7177z = 4;
        this.A = 1;
        this.B = 2.0f;
        this.C = -1;
        this.D = 200;
        this.E = -1;
        this.F = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1

            /* renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC00611 implements Runnable {
                final /* synthetic */ float val$v;

                RunnableC00611(float f11) {
                    this.val$v = f11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Carousel.this.f7168q.touchAnimateTo(5, 1.0f, this.val$v);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f7168q.setProgress(0.0f);
                Carousel.this.q();
                Carousel.o(Carousel.this);
                int unused = Carousel.this.f7167p;
                throw null;
            }
        };
        p(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7165n = new ArrayList();
        this.f7166o = 0;
        this.f7167p = 0;
        this.f7169r = -1;
        this.f7170s = false;
        this.f7171t = -1;
        this.f7172u = -1;
        this.f7173v = -1;
        this.f7174w = -1;
        this.f7175x = 0.9f;
        this.f7176y = 0;
        this.f7177z = 4;
        this.A = 1;
        this.B = 2.0f;
        this.C = -1;
        this.D = 200;
        this.E = -1;
        this.F = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1

            /* renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC00611 implements Runnable {
                final /* synthetic */ float val$v;

                RunnableC00611(float f11) {
                    this.val$v = f11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Carousel.this.f7168q.touchAnimateTo(5, 1.0f, this.val$v);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f7168q.setProgress(0.0f);
                Carousel.this.q();
                Carousel.o(Carousel.this);
                int unused = Carousel.this.f7167p;
                throw null;
            }
        };
        p(context, attributeSet);
    }

    static /* synthetic */ a o(Carousel carousel) {
        carousel.getClass();
        return null;
    }

    private void p(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.f7169r = obtainStyledAttributes.getResourceId(index, this.f7169r);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.f7171t = obtainStyledAttributes.getResourceId(index, this.f7171t);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.f7172u = obtainStyledAttributes.getResourceId(index, this.f7172u);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.f7177z = obtainStyledAttributes.getInt(index, this.f7177z);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.f7173v = obtainStyledAttributes.getResourceId(index, this.f7173v);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.f7174w = obtainStyledAttributes.getResourceId(index, this.f7174w);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f7175x = obtainStyledAttributes.getFloat(index, this.f7175x);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.A = obtainStyledAttributes.getInt(index, this.A);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.B = obtainStyledAttributes.getFloat(index, this.B);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.f7170s = obtainStyledAttributes.getBoolean(index, this.f7170s);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.f7167p;
    }

    public void jumpToIndex(int i11) {
        this.f7167p = Math.max(0, Math.min(getCount() - 1, i11));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i11 = 0; i11 < this.f7728b; i11++) {
                int i12 = this.f7727a[i11];
                View viewById = motionLayout.getViewById(i12);
                if (this.f7169r == i12) {
                    this.f7176y = i11;
                }
                this.f7165n.add(viewById);
            }
            this.f7168q = motionLayout;
            if (this.A == 2) {
                p.b transition = motionLayout.getTransition(this.f7172u);
                if (transition != null) {
                    transition.H(5);
                }
                p.b transition2 = this.f7168q.getTransition(this.f7171t);
                if (transition2 != null) {
                    transition2.H(5);
                }
            }
            q();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
        this.E = i11;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
        int i12 = this.f7167p;
        this.f7166o = i12;
        if (i11 == this.f7174w) {
            this.f7167p = i12 + 1;
        } else if (i11 == this.f7173v) {
            this.f7167p = i12 - 1;
        }
        if (!this.f7170s) {
            throw null;
        }
        throw null;
    }

    public void refresh() {
        if (this.f7165n.size() > 0) {
            throw null;
        }
        this.f7168q.rebuildScene();
        q();
    }

    public void setAdapter(a aVar) {
    }

    public void transitionToIndex(int i11, int i12) {
        this.C = Math.max(0, Math.min(getCount() - 1, i11));
        int max = Math.max(0, i12);
        this.D = max;
        this.f7168q.setTransitionDuration(max);
        if (i11 < this.f7167p) {
            this.f7168q.transitionToState(this.f7173v, this.D);
        } else {
            this.f7168q.transitionToState(this.f7174w, this.D);
        }
    }
}
