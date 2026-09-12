package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.R$styleable;

/* loaded from: classes2.dex */
class a extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f15027a;

    /* renamed from: b, reason: collision with root package name */
    private int f15028b;

    /* renamed from: c, reason: collision with root package name */
    private int f15029c;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0131a extends OvalShape {

        /* renamed from: a, reason: collision with root package name */
        private Paint f15030a = new Paint();

        /* renamed from: b, reason: collision with root package name */
        private int f15031b;

        /* renamed from: c, reason: collision with root package name */
        private a f15032c;

        C0131a(a aVar, int i11) {
            this.f15032c = aVar;
            this.f15031b = i11;
            a((int) rect().width());
        }

        private void a(int i11) {
            float f11 = i11 / 2;
            this.f15030a.setShader(new RadialGradient(f11, f11, this.f15031b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = this.f15032c.getWidth() / 2;
            float height = this.f15032c.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f15030a);
            canvas.drawCircle(width, height, r0 - this.f15031b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f11, float f12) {
            super.onResize(f11, f12);
            a((int) f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f11 = getContext().getResources().getDisplayMetrics().density;
        int i11 = (int) (1.75f * f11);
        int i12 = (int) (0.0f * f11);
        this.f15028b = (int) (3.5f * f11);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R$styleable.SwipeRefreshLayout);
        this.f15029c = obtainStyledAttributes.getColor(R$styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        obtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f11 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0131a(this, this.f15028b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f15028b, i12, i11, 503316480);
            int i13 = this.f15028b;
            setPadding(i13, i13, i13, i13);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f15029c);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f15027a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f15027a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f15027a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f15028b * 2), getMeasuredHeight() + (this.f15028b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i11);
            this.f15029c = i11;
        }
    }
}
