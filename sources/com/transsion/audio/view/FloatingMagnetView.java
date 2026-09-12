package com.transsion.audio.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.audio.view.EnFloatingView;

/* loaded from: classes5.dex */
public abstract class FloatingMagnetView extends FrameLayout {
    public static final int MARGIN_EDGE = 13;

    /* renamed from: a, reason: collision with root package name */
    protected MoveAnimator f42996a;

    /* renamed from: b, reason: collision with root package name */
    protected int f42997b;

    /* renamed from: c, reason: collision with root package name */
    private int f42998c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42999d;

    /* renamed from: e, reason: collision with root package name */
    private float f43000e;

    /* renamed from: f, reason: collision with root package name */
    float f43001f;

    /* renamed from: g, reason: collision with root package name */
    float f43002g;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public class MoveAnimator implements Runnable {
        private float destinationX;
        private float destinationY;
        private final Handler handler = new Handler(Looper.getMainLooper());
        private long startingTime;

        protected MoveAnimator() {
        }

        private void stop() {
            this.handler.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingMagnetView.this.getRootView() == null || FloatingMagnetView.this.getRootView().getParent() == null) {
                return;
            }
            float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.startingTime)) / 400.0f);
            FloatingMagnetView.this.g((this.destinationX - FloatingMagnetView.this.getX()) * min, (this.destinationY - FloatingMagnetView.this.getY()) * min);
            if (min < 1.0f) {
                this.handler.post(this);
            }
        }

        void start(float f11, float f12) {
            this.destinationX = f11;
            this.destinationY = f12;
            this.startingTime = System.currentTimeMillis();
            this.handler.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FloatingMagnetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected FloatingMagnetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42999d = true;
        this.f43001f = 0.0f;
        this.f43002g = 0.0f;
        d();
    }

    private void c() {
        this.f43000e = 0.0f;
    }

    private void d() {
        this.f42996a = new MoveAnimator();
        setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(boolean z10) {
        i();
        h(this.f42999d, z10);
    }

    private void f(boolean z10) {
        if (z10) {
            this.f43000e = getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f11, float f12) {
        setX(getX() + f11);
        setY(getY() + f12);
    }

    private void h(boolean z10, boolean z11) {
        float f11 = z10 ? 13.0f : this.f42997b - 13;
        float y10 = getY();
        if (!z11) {
            float f12 = this.f43000e;
            if (f12 != 0.0f) {
                c();
                y10 = f12;
            }
        }
        this.f42996a.start(f11, Math.min(Math.max(0.0f, y10), this.f42998c - getHeight()));
    }

    private void i() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            this.f42997b = viewGroup.getWidth() - getWidth();
            this.f42998c = viewGroup.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void attach(Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void expanded();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPackUp();

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getParent() != null) {
            final boolean z10 = configuration.orientation == 2;
            f(z10);
            ((ViewGroup) getParent()).post(new Runnable() { // from class: com.transsion.audio.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    FloatingMagnetView.this.e(z10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onProgress(int i11);

    abstract void onSlideTheLeft();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onStateChanged(int i11);

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f43001f = motionEvent.getRawX();
        } else if (action == 2) {
            float rawX = motionEvent.getRawX();
            this.f43002g = rawX;
            float f11 = this.f43001f;
            if (rawX < f11 && Math.abs(rawX - f11) > 50.0f) {
                onSlideTheLeft();
                return true;
            }
        } else if ((action == 1 || action == 3) && Math.abs(motionEvent.getRawX() - this.f43001f) < 10.0f) {
            onViewClick();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    abstract void onViewClick();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void packUp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void packUpAnimation();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void prepare();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setOnOptionListener(EnFloatingView.f fVar);
}
