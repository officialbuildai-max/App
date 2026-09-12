package com.transsion.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes6.dex */
public class PhotoViewAttachment implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f47916h;

    /* renamed from: i, reason: collision with root package name */
    private GestureDetector f47917i;

    /* renamed from: j, reason: collision with root package name */
    private com.transsion.photoview.b f47918j;

    /* renamed from: k, reason: collision with root package name */
    private n f47919k;

    /* renamed from: q, reason: collision with root package name */
    private View.OnClickListener f47925q;

    /* renamed from: r, reason: collision with root package name */
    private View.OnLongClickListener f47926r;

    /* renamed from: s, reason: collision with root package name */
    private FlingRunnable f47927s;

    /* renamed from: v, reason: collision with root package name */
    private float f47930v;

    /* renamed from: y, reason: collision with root package name */
    private final com.transsion.photoview.c f47933y;

    /* renamed from: a, reason: collision with root package name */
    private Interpolator f47909a = new AccelerateDecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    private int f47910b = 200;

    /* renamed from: c, reason: collision with root package name */
    private float f47911c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f47912d = 1.75f;

    /* renamed from: e, reason: collision with root package name */
    private float f47913e = 3.0f;

    /* renamed from: f, reason: collision with root package name */
    private boolean f47914f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f47915g = false;

    /* renamed from: l, reason: collision with root package name */
    private final Matrix f47920l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f47921m = new Matrix();

    /* renamed from: n, reason: collision with root package name */
    private final Matrix f47922n = new Matrix();

    /* renamed from: o, reason: collision with root package name */
    private final RectF f47923o = new RectF();

    /* renamed from: p, reason: collision with root package name */
    private final float[] f47924p = new float[9];

    /* renamed from: t, reason: collision with root package name */
    private int f47928t = 2;

    /* renamed from: u, reason: collision with root package name */
    private int f47929u = 2;

    /* renamed from: w, reason: collision with root package name */
    private boolean f47931w = true;

    /* renamed from: x, reason: collision with root package name */
    private ImageView.ScaleType f47932x = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f11, float f12, float f13, float f14) {
            this.mFocalX = f13;
            this.mFocalY = f14;
            this.mZoomStart = f11;
            this.mZoomEnd = f12;
        }

        private float interpolate() {
            return PhotoViewAttachment.this.f47909a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / PhotoViewAttachment.this.f47910b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolate = interpolate();
            float f11 = this.mZoomStart;
            PhotoViewAttachment.this.f47933y.d((f11 + ((this.mZoomEnd - f11) * interpolate)) / PhotoViewAttachment.this.M(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                com.transsion.photoview.a.a(PhotoViewAttachment.this.f47916h, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i11, int i12, int i13, int i14) {
            int i15;
            int i16;
            int i17;
            int i18;
            RectF D = PhotoViewAttachment.this.D();
            if (D == null) {
                return;
            }
            int round = Math.round(-D.left);
            float f11 = i11;
            if (f11 < D.width()) {
                i16 = Math.round(D.width() - f11);
                i15 = 0;
            } else {
                i15 = round;
                i16 = i15;
            }
            int round2 = Math.round(-D.top);
            float f12 = i12;
            if (f12 < D.height()) {
                i18 = Math.round(D.height() - f12);
                i17 = 0;
            } else {
                i17 = round2;
                i18 = i17;
            }
            this.mCurrentX = round;
            this.mCurrentY = round2;
            if (round == i16 && round2 == i18) {
                return;
            }
            this.mScroller.fling(round, round2, i13, i14, i15, i16, i17, i18, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttachment.this.f47922n.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttachment.this.A();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                com.transsion.photoview.a.a(PhotoViewAttachment.this.f47916h, this);
            }
        }
    }

    /* loaded from: classes6.dex */
    class a implements com.transsion.photoview.c {
        a() {
        }

        @Override // com.transsion.photoview.c
        public void b(float f11, float f12) {
            if (PhotoViewAttachment.this.f47918j.g()) {
                return;
            }
            PhotoViewAttachment.j(PhotoViewAttachment.this);
            PhotoViewAttachment.this.f47922n.postTranslate(f11, f12);
            PhotoViewAttachment.this.A();
            ViewParent parent = PhotoViewAttachment.this.f47916h.getParent();
            if (!PhotoViewAttachment.this.f47914f || PhotoViewAttachment.this.f47918j.g() || PhotoViewAttachment.this.f47915g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((PhotoViewAttachment.this.f47928t == 2 || ((PhotoViewAttachment.this.f47928t == 0 && f11 >= 1.0f) || ((PhotoViewAttachment.this.f47928t == 1 && f11 <= -1.0f) || ((PhotoViewAttachment.this.f47929u == 0 && f12 >= 1.0f) || (PhotoViewAttachment.this.f47929u == 1 && f12 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
                PhotoViewAttachment.this.f47919k.e(PhotoViewAttachment.this.M(), PhotoViewAttachment.this.f47918j.d(), PhotoViewAttachment.this.f47918j.e());
            }
        }

        @Override // com.transsion.photoview.c
        public void c(float f11, float f12, float f13, float f14, float f15) {
            if (PhotoViewAttachment.this.f47919k.h()) {
                return;
            }
            if (PhotoViewAttachment.this.M() < PhotoViewAttachment.this.f47913e || f11 < 1.0f) {
                PhotoViewAttachment.m(PhotoViewAttachment.this);
                PhotoViewAttachment.this.f47922n.postScale(f11, f11, f12, f13);
                PhotoViewAttachment.this.f47922n.postTranslate(f14, f15);
                PhotoViewAttachment.this.A();
            }
        }

        @Override // com.transsion.photoview.c
        public void d(float f11, float f12, float f13) {
            c(f11, f12, f13, 0.0f, 0.0f);
        }

        @Override // com.transsion.photoview.c
        public void e(float f11, float f12, float f13, float f14) {
            PhotoViewAttachment photoViewAttachment = PhotoViewAttachment.this;
            photoViewAttachment.f47927s = new FlingRunnable(photoViewAttachment.f47916h.getContext());
            FlingRunnable flingRunnable = PhotoViewAttachment.this.f47927s;
            PhotoViewAttachment photoViewAttachment2 = PhotoViewAttachment.this;
            int I = photoViewAttachment2.I(photoViewAttachment2.f47916h);
            PhotoViewAttachment photoViewAttachment3 = PhotoViewAttachment.this;
            flingRunnable.fling(I, photoViewAttachment3.H(photoViewAttachment3.f47916h), (int) f13, (int) f14);
            PhotoViewAttachment.this.f47916h.post(PhotoViewAttachment.this.f47927s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            PhotoViewAttachment.o(PhotoViewAttachment.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttachment.this.f47926r != null) {
                PhotoViewAttachment.this.f47926r.onLongClick(PhotoViewAttachment.this.f47916h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float M = PhotoViewAttachment.this.M();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (M < PhotoViewAttachment.this.K()) {
                    PhotoViewAttachment photoViewAttachment = PhotoViewAttachment.this;
                    photoViewAttachment.m0(photoViewAttachment.K(), x10, y10, true);
                } else if (M < PhotoViewAttachment.this.K() || M >= PhotoViewAttachment.this.J()) {
                    PhotoViewAttachment photoViewAttachment2 = PhotoViewAttachment.this;
                    photoViewAttachment2.m0(photoViewAttachment2.L(), x10, y10, true);
                } else {
                    PhotoViewAttachment photoViewAttachment3 = PhotoViewAttachment.this;
                    photoViewAttachment3.m0(photoViewAttachment3.J(), x10, y10, true);
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
            if (PhotoViewAttachment.this.f47925q != null) {
                PhotoViewAttachment.this.f47925q.onClick(PhotoViewAttachment.this.f47916h);
            }
            RectF D = PhotoViewAttachment.this.D();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            PhotoViewAttachment.r(PhotoViewAttachment.this);
            if (D == null) {
                return false;
            }
            if (!D.contains(x10, y10)) {
                PhotoViewAttachment.k(PhotoViewAttachment.this);
                return false;
            }
            D.width();
            D.height();
            PhotoViewAttachment.l(PhotoViewAttachment.this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f47937a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f47937a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47937a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47937a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47937a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PhotoViewAttachment(ImageView imageView) {
        a aVar = new a();
        this.f47933y = aVar;
        this.f47916h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f47930v = 0.0f;
        this.f47918j = new com.transsion.photoview.b(imageView.getContext(), aVar);
        Q(imageView);
        this.f47919k = new n(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (B()) {
            V(F());
        }
    }

    private boolean B() {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        RectF E = E(F());
        if (E == null) {
            return false;
        }
        float height = E.height();
        float width = E.width();
        float H = H(this.f47916h);
        float f16 = 0.0f;
        if (height <= H) {
            int i11 = d.f47937a[this.f47932x.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f14 = (H - height) / 2.0f;
                    f15 = E.top;
                } else {
                    f14 = H - height;
                    f15 = E.top;
                }
                f11 = f14 - f15;
            } else {
                f11 = -E.top;
            }
            this.f47929u = 2;
        } else {
            float f17 = E.top;
            if (f17 > 0.0f) {
                this.f47929u = 0;
                f11 = -f17;
            } else {
                float f18 = E.bottom;
                if (f18 < H) {
                    this.f47929u = 1;
                    f11 = H - f18;
                } else {
                    this.f47929u = -1;
                    f11 = 0.0f;
                }
            }
        }
        float I = I(this.f47916h);
        if (width <= I) {
            int i12 = d.f47937a[this.f47932x.ordinal()];
            if (i12 != 2) {
                if (i12 != 3) {
                    f12 = (I - width) / 2.0f;
                    f13 = E.left;
                } else {
                    f12 = I - width;
                    f13 = E.left;
                }
                f16 = f12 - f13;
            } else {
                f16 = -E.left;
            }
            this.f47928t = 2;
        } else {
            float f19 = E.left;
            if (f19 > 0.0f) {
                this.f47928t = 0;
                f16 = -f19;
            } else {
                float f20 = E.right;
                if (f20 < I) {
                    f16 = I - f20;
                    this.f47928t = 1;
                } else {
                    this.f47928t = -1;
                }
            }
        }
        this.f47922n.postTranslate(f16, f11);
        return true;
    }

    private RectF E(Matrix matrix) {
        if (this.f47916h.getDrawable() == null) {
            return null;
        }
        this.f47923o.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f47923o);
        return this.f47923o;
    }

    private Matrix F() {
        this.f47921m.set(this.f47920l);
        this.f47921m.postConcat(this.f47922n);
        return this.f47921m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingStart()) - imageView.getPaddingEnd();
    }

    private float P(Matrix matrix, int i11) {
        matrix.getValues(this.f47924p);
        return this.f47924p[i11];
    }

    private void Q(ImageView imageView) {
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f47917i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private void S() {
        this.f47922n.reset();
        j0(this.f47930v);
        V(F());
        B();
    }

    private void V(Matrix matrix) {
        this.f47916h.setImageMatrix(matrix);
    }

    static /* bridge */ /* synthetic */ j j(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ e k(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ f l(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ g m(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ h o(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ k r(PhotoViewAttachment photoViewAttachment) {
        photoViewAttachment.getClass();
        return null;
    }

    private void u0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float I = I(this.f47916h);
        float H = H(this.f47916h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f47920l.reset();
        float f11 = intrinsicWidth;
        float f12 = I / f11;
        float f13 = intrinsicHeight;
        float f14 = H / f13;
        ImageView.ScaleType scaleType = this.f47932x;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f47920l.postTranslate((I - f11) / 2.0f, (H - f13) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f12, f14);
            this.f47920l.postScale(max, max);
            this.f47920l.postTranslate((I - (f11 * max)) / 2.0f, (H - (f13 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f12, f14));
            this.f47920l.postScale(min, min);
            this.f47920l.postTranslate((I - (f11 * min)) / 2.0f, (H - (f13 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f11, f13);
            RectF rectF2 = new RectF(0.0f, 0.0f, I, H);
            if (((int) this.f47930v) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f13, f11);
            }
            int i11 = d.f47937a[this.f47932x.ordinal()];
            if (i11 == 1) {
                this.f47920l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i11 == 2) {
                this.f47920l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i11 == 3) {
                this.f47920l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i11 == 4) {
                this.f47920l.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        S();
    }

    private void z() {
        FlingRunnable flingRunnable = this.f47927s;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.f47927s = null;
        }
    }

    public void C(Matrix matrix) {
        matrix.set(F());
    }

    public RectF D() {
        B();
        return E(F());
    }

    public Matrix G() {
        return this.f47921m;
    }

    public float J() {
        return this.f47913e;
    }

    public float K() {
        return this.f47912d;
    }

    public float L() {
        return this.f47911c;
    }

    public float M() {
        return (float) Math.sqrt(((float) Math.pow(P(this.f47922n, 0), 2.0d)) + ((float) Math.pow(P(this.f47922n, 3), 2.0d)));
    }

    public ImageView.ScaleType N() {
        return this.f47932x;
    }

    public void O(Matrix matrix) {
        matrix.set(this.f47922n);
    }

    public boolean R() {
        return this.f47931w;
    }

    public void T(boolean z10) {
        this.f47914f = z10;
    }

    public boolean U(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f47916h.getDrawable() == null) {
            return false;
        }
        this.f47922n.set(matrix);
        A();
        return true;
    }

    public void W(float f11) {
        o.a(this.f47911c, this.f47912d, f11);
        this.f47913e = f11;
    }

    public void X(float f11) {
        o.a(this.f47911c, f11, this.f47913e);
        this.f47912d = f11;
    }

    public void Y(float f11) {
        o.a(f11, this.f47912d, this.f47913e);
        this.f47911c = f11;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.f47925q = onClickListener;
    }

    public void a0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f47917i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void b0(View.OnLongClickListener onLongClickListener) {
        this.f47926r = onLongClickListener;
    }

    public void c0(com.transsion.photoview.d dVar) {
    }

    public void d0(e eVar) {
    }

    public void e0(f fVar) {
    }

    public void f0(g gVar) {
    }

    public void g0(h hVar) {
    }

    public void h0(j jVar) {
    }

    public void i0(k kVar) {
    }

    public void j0(float f11) {
        this.f47922n.postRotate(f11 % 360.0f);
        A();
    }

    public void k0(float f11) {
        this.f47922n.setRotate(f11 % 360.0f);
        A();
    }

    public void l0(float f11) {
        n0(f11, false);
    }

    public void m0(float f11, float f12, float f13, boolean z10) {
        if (f11 < this.f47911c || f11 > this.f47913e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.f47916h.post(new AnimatedZoomRunnable(M(), f11, f12, f13));
        } else {
            this.f47922n.setScale(f11, f11, f12, f13);
            A();
        }
    }

    public void n0(float f11, boolean z10) {
        m0(f11, this.f47916h.getRight() / 2.0f, this.f47916h.getBottom() / 2.0f, z10);
    }

    public void o0(float f11, float f12, float f13) {
        o.a(f11, f12, f13);
        this.f47911c = f11;
        this.f47912d = f12;
        this.f47913e = f13;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 == i15 && i12 == i16 && i13 == i17 && i14 == i18) {
            return;
        }
        u0(this.f47916h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.f47931w
            r1 = 0
            if (r0 == 0) goto Lc6
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.transsion.photoview.o.d(r0)
            if (r0 == 0) goto Lc6
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L76
            if (r0 == r2) goto L1c
            r3 = 3
            if (r0 == r3) goto L1c
            goto L82
        L1c:
            float r0 = r10.M()
            float r3 = r10.f47911c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L45
            android.graphics.RectF r0 = r10.D()
            if (r0 == 0) goto L6f
            com.transsion.photoview.PhotoViewAttachment$AnimatedZoomRunnable r9 = new com.transsion.photoview.PhotoViewAttachment$AnimatedZoomRunnable
            float r5 = r10.M()
            float r6 = r10.f47911c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6d
        L45:
            float r0 = r10.M()
            float r3 = r10.f47913e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L6f
            android.graphics.RectF r0 = r10.D()
            if (r0 == 0) goto L6f
            com.transsion.photoview.PhotoViewAttachment$AnimatedZoomRunnable r9 = new com.transsion.photoview.PhotoViewAttachment$AnimatedZoomRunnable
            float r5 = r10.M()
            float r6 = r10.f47913e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6d:
            r11 = r2
            goto L70
        L6f:
            r11 = r1
        L70:
            com.transsion.photoview.n r0 = r10.f47919k
            r0.d()
            goto L83
        L76:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L7f
            r11.requestDisallowInterceptTouchEvent(r2)
        L7f:
            r10.z()
        L82:
            r11 = r1
        L83:
            com.transsion.photoview.b r0 = r10.f47918j
            if (r0 == 0) goto Lba
            boolean r11 = r0.g()
            com.transsion.photoview.b r0 = r10.f47918j
            boolean r0 = r0.f()
            com.transsion.photoview.b r3 = r10.f47918j
            boolean r3 = r3.h(r12)
            if (r11 != 0) goto La3
            com.transsion.photoview.b r11 = r10.f47918j
            boolean r11 = r11.g()
            if (r11 != 0) goto La3
            r11 = r2
            goto La4
        La3:
            r11 = r1
        La4:
            if (r0 != 0) goto Lb0
            com.transsion.photoview.b r0 = r10.f47918j
            boolean r0 = r0.f()
            if (r0 != 0) goto Lb0
            r0 = r2
            goto Lb1
        Lb0:
            r0 = r1
        Lb1:
            if (r11 == 0) goto Lb6
            if (r0 == 0) goto Lb6
            r1 = r2
        Lb6:
            r10.f47915g = r1
            r1 = r3
            goto Lbb
        Lba:
            r1 = r11
        Lbb:
            android.view.GestureDetector r11 = r10.f47917i
            if (r11 == 0) goto Lc6
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lc6
            r1 = r2
        Lc6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.photoview.PhotoViewAttachment.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p0(ImageView.ScaleType scaleType) {
        if (!o.e(scaleType) || scaleType == this.f47932x) {
            return;
        }
        this.f47932x = scaleType;
        t0();
    }

    public void q0(i iVar) {
        n nVar = this.f47919k;
        if (nVar != null) {
            nVar.k(iVar);
        }
    }

    public void r0(int i11) {
        this.f47910b = i11;
    }

    public void s0(boolean z10) {
        this.f47931w = z10;
        t0();
    }

    public void t0() {
        if (this.f47931w) {
            u0(this.f47916h.getDrawable());
        } else {
            S();
        }
    }
}
