package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.k;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent3, NestedScrollingParent2, NestedScrollingChild3, NestedScrollingChild2, NestedScrollingParent, NestedScrollingChild {
    public static final int DEFAULT = 1;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    public static final int LARGE = 0;
    private static final String P = "SwipeRefreshLayout";
    private static final int[] Q = {R.attr.enabled};
    int A;
    int B;
    androidx.swiperefreshlayout.widget.b C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    boolean I;
    private int J;
    boolean K;
    private boolean L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;

    /* renamed from: a, reason: collision with root package name */
    private View f14990a;

    /* renamed from: b, reason: collision with root package name */
    j f14991b;

    /* renamed from: c, reason: collision with root package name */
    boolean f14992c;

    /* renamed from: d, reason: collision with root package name */
    private int f14993d;

    /* renamed from: e, reason: collision with root package name */
    private float f14994e;

    /* renamed from: f, reason: collision with root package name */
    private float f14995f;

    /* renamed from: g, reason: collision with root package name */
    private final NestedScrollingParentHelper f14996g;

    /* renamed from: h, reason: collision with root package name */
    private final NestedScrollingChildHelper f14997h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f14998i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f14999j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f15000k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f15001l;

    /* renamed from: m, reason: collision with root package name */
    private int f15002m;

    /* renamed from: n, reason: collision with root package name */
    int f15003n;

    /* renamed from: o, reason: collision with root package name */
    private float f15004o;

    /* renamed from: p, reason: collision with root package name */
    private float f15005p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f15006q;

    /* renamed from: r, reason: collision with root package name */
    private int f15007r;

    /* renamed from: s, reason: collision with root package name */
    boolean f15008s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f15009t;

    /* renamed from: u, reason: collision with root package name */
    private final DecelerateInterpolator f15010u;

    /* renamed from: v, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.a f15011v;

    /* renamed from: w, reason: collision with root package name */
    private int f15012w;

    /* renamed from: x, reason: collision with root package name */
    protected int f15013x;

    /* renamed from: y, reason: collision with root package name */
    float f15014y;

    /* renamed from: z, reason: collision with root package name */
    protected int f15015z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        final boolean f15016a;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f15016a = parcel.readByte() != 0;
        }

        SavedState(Parcelable parcelable, boolean z10) {
            super(parcelable);
            this.f15016a = z10;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeByte(this.f15016a ? (byte) 1 : (byte) 0);
        }
    }

    /* loaded from: classes2.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f14992c) {
                swipeRefreshLayout.j();
                return;
            }
            swipeRefreshLayout.C.setAlpha(255);
            SwipeRefreshLayout.this.C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.I && (jVar = swipeRefreshLayout2.f14991b) != null) {
                jVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f15003n = swipeRefreshLayout3.f15011v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends Animation {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f15020a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f15021b;

        d(int i11, int i12) {
            this.f15020a = i11;
            this.f15021b = i12;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.C.setAlpha((int) (this.f15020a + ((this.f15021b - r0) * f11)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f15008s) {
                return;
            }
            swipeRefreshLayout.p(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int abs = !swipeRefreshLayout.K ? swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.f15015z) : swipeRefreshLayout.A;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f15013x + ((int) ((abs - r1) * f11))) - swipeRefreshLayout2.f15011v.getTop());
            SwipeRefreshLayout.this.C.e(1.0f - f11);
        }
    }

    /* loaded from: classes2.dex */
    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout.this.h(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f11, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f12 = swipeRefreshLayout.f15014y;
            swipeRefreshLayout.setAnimationProgress(f12 + ((-f12) * f11));
            SwipeRefreshLayout.this.h(f11);
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14992c = false;
        this.f14994e = -1.0f;
        this.f14998i = new int[2];
        this.f14999j = new int[2];
        this.f15000k = new int[2];
        this.f15007r = -1;
        this.f15012w = -1;
        this.M = new a();
        this.N = new f();
        this.O = new g();
        this.f14993d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f15002m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f15010u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        int i11 = (int) (displayMetrics.density * 64.0f);
        this.A = i11;
        this.f14994e = i11;
        this.f14996g = new NestedScrollingParentHelper(this);
        this.f14997h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i12 = -this.J;
        this.f15003n = i12;
        this.f15015z = i12;
        h(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Q);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void a(int i11, Animation.AnimationListener animationListener) {
        this.f15013x = i11;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.f15010u);
        if (animationListener != null) {
            this.f15011v.b(animationListener);
        }
        this.f15011v.clearAnimation();
        this.f15011v.startAnimation(this.N);
    }

    private void b(int i11, Animation.AnimationListener animationListener) {
        if (this.f15008s) {
            q(i11, animationListener);
            return;
        }
        this.f15013x = i11;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.f15010u);
        if (animationListener != null) {
            this.f15011v.b(animationListener);
        }
        this.f15011v.clearAnimation();
        this.f15011v.startAnimation(this.O);
    }

    private void c() {
        this.f15011v = new androidx.swiperefreshlayout.widget.a(getContext());
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.C = bVar;
        bVar.l(1);
        this.f15011v.setImageDrawable(this.C);
        this.f15011v.setVisibility(8);
        addView(this.f15011v);
    }

    private void d() {
        if (this.f14990a == null) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (!childAt.equals(this.f15011v)) {
                    this.f14990a = childAt;
                    return;
                }
            }
        }
    }

    private void e(float f11) {
        if (f11 > this.f14994e) {
            k(true, true);
            return;
        }
        this.f14992c = false;
        this.C.j(0.0f, 0.0f);
        b(this.f15003n, !this.f15008s ? new e() : null);
        this.C.d(false);
    }

    private boolean f(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void g(float f11) {
        this.C.d(true);
        float min = Math.min(1.0f, Math.abs(f11 / this.f14994e));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f11) - this.f14994e;
        int i11 = this.B;
        if (i11 <= 0) {
            i11 = this.K ? this.A - this.f15015z : this.A;
        }
        float f12 = i11;
        double max2 = Math.max(0.0f, Math.min(abs, f12 * 2.0f) / f12) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i12 = this.f15015z + ((int) ((f12 * min) + (f12 * pow * 2.0f)));
        if (this.f15011v.getVisibility() != 0) {
            this.f15011v.setVisibility(0);
        }
        if (!this.f15008s) {
            this.f15011v.setScaleX(1.0f);
            this.f15011v.setScaleY(1.0f);
        }
        if (this.f15008s) {
            setAnimationProgress(Math.min(1.0f, f11 / this.f14994e));
        }
        if (f11 < this.f14994e) {
            if (this.C.getAlpha() > 76 && !f(this.F)) {
                o();
            }
        } else if (this.C.getAlpha() < 255 && !f(this.G)) {
            n();
        }
        this.C.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.e(Math.min(1.0f, max));
        this.C.g((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i12 - this.f15003n);
    }

    private void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f15007r) {
            this.f15007r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void k(boolean z10, boolean z11) {
        if (this.f14992c != z10) {
            this.I = z11;
            d();
            this.f14992c = z10;
            if (z10) {
                a(this.f15003n, this.M);
            } else {
                p(this.M);
            }
        }
    }

    private Animation l(int i11, int i12) {
        d dVar = new d(i11, i12);
        dVar.setDuration(300L);
        this.f15011v.b(null);
        this.f15011v.clearAnimation();
        this.f15011v.startAnimation(dVar);
        return dVar;
    }

    private void m(float f11) {
        float f12 = this.f15005p;
        float f13 = f11 - f12;
        int i11 = this.f14993d;
        if (f13 <= i11 || this.f15006q) {
            return;
        }
        this.f15004o = f12 + i11;
        this.f15006q = true;
        this.C.setAlpha(76);
    }

    private void n() {
        this.G = l(this.C.getAlpha(), 255);
    }

    private void o() {
        this.F = l(this.C.getAlpha(), 76);
    }

    private void q(int i11, Animation.AnimationListener animationListener) {
        this.f15013x = i11;
        this.f15014y = this.f15011v.getScaleX();
        h hVar = new h();
        this.H = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f15011v.b(animationListener);
        }
        this.f15011v.clearAnimation();
        this.f15011v.startAnimation(this.H);
    }

    private void r(Animation.AnimationListener animationListener) {
        this.f15011v.setVisibility(0);
        this.C.setAlpha(255);
        b bVar = new b();
        this.D = bVar;
        bVar.setDuration(this.f15002m);
        if (animationListener != null) {
            this.f15011v.b(animationListener);
        }
        this.f15011v.clearAnimation();
        this.f15011v.startAnimation(this.D);
    }

    private void setColorViewAlpha(int i11) {
        this.f15011v.getBackground().setAlpha(i11);
        this.C.setAlpha(i11);
    }

    public boolean canChildScrollUp() {
        View view = this.f14990a;
        return view instanceof ListView ? k.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f11, float f12, boolean z10) {
        return this.f14997h.dispatchNestedFling(f11, f12, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f11, float f12) {
        return this.f14997h.dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return this.f14997h.dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return i13 == 0 && dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @NonNull int[] iArr2) {
        if (i15 == 0) {
            this.f14997h.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return this.f14997h.dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return i15 == 0 && this.f14997h.dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i11, int i12) {
        int i13 = this.f15012w;
        return i13 < 0 ? i12 : i12 == i11 + (-1) ? i13 : i12 >= i13 ? i12 + 1 : i12;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f14996g.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.f15015z;
    }

    void h(float f11) {
        setTargetOffsetTopAndBottom((this.f15013x + ((int) ((this.f15015z - r0) * f11))) - this.f15011v.getTop());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f14997h.hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i11) {
        return i11 == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f14997h.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.f14992c;
    }

    void j() {
        this.f15011v.clearAnimation();
        this.C.stop();
        this.f15011v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f15008s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f15015z - this.f15003n);
        }
        this.f15003n = this.f15011v.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f15009t && actionMasked == 0) {
            this.f15009t = false;
        }
        if (!isEnabled() || this.f15009t || canChildScrollUp() || this.f14992c || this.f15001l) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i11 = this.f15007r;
                    if (i11 == -1) {
                        Log.e(P, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i11);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    m(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        i(motionEvent);
                    }
                }
            }
            this.f15006q = false;
            this.f15007r = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f15015z - this.f15011v.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f15007r = pointerId;
            this.f15006q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f15005p = motionEvent.getY(findPointerIndex2);
        }
        return this.f15006q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f14990a == null) {
            d();
        }
        View view = this.f14990a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f15011v.getMeasuredWidth();
        int measuredHeight2 = this.f15011v.getMeasuredHeight();
        int i15 = measuredWidth / 2;
        int i16 = measuredWidth2 / 2;
        int i17 = this.f15003n;
        this.f15011v.layout(i15 - i16, i17, i15 + i16, measuredHeight2 + i17);
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f14990a == null) {
            d();
        }
        View view = this.f14990a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f15011v.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
        this.f15012w = -1;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            if (getChildAt(i13) == this.f15011v) {
                this.f15012w = i13;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z10) {
        return dispatchNestedFling(f11, f12, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        return dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        if (i12 > 0) {
            float f11 = this.f14995f;
            if (f11 > 0.0f) {
                float f12 = i12;
                if (f12 > f11) {
                    iArr[1] = (int) f11;
                    this.f14995f = 0.0f;
                } else {
                    this.f14995f = f11 - f12;
                    iArr[1] = i12;
                }
                g(this.f14995f);
            }
        }
        if (this.K && i12 > 0 && this.f14995f == 0.0f && Math.abs(i12 - iArr[1]) > 0) {
            this.f15011v.setVisibility(8);
        }
        int[] iArr2 = this.f14998i;
        if (dispatchNestedPreScroll(i11 - iArr[0], i12 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.f15000k);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, i15, this.f15000k);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        if (i15 != 0) {
            return;
        }
        int i16 = iArr[1];
        dispatchNestedScroll(i11, i12, i13, i14, this.f14999j, i15, iArr);
        int i17 = i14 - (iArr[1] - i16);
        if ((i17 == 0 ? i14 + this.f14999j[1] : i17) >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.f14995f + Math.abs(r1);
        this.f14995f = abs;
        g(abs);
        iArr[1] = iArr[1] + i17;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.f14996g.onNestedScrollAccepted(view, view2, i11);
        startNestedScroll(i11 & 2);
        this.f14995f = 0.0f;
        this.f15001l = true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f15016a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f14992c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return (!isEnabled() || this.f15009t || this.f14992c || (i11 & 2) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            return onStartNestedScroll(view, view2, i11);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f14996g.onStopNestedScroll(view);
        this.f15001l = false;
        float f11 = this.f14995f;
        if (f11 > 0.0f) {
            e(f11);
            this.f14995f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f15009t && actionMasked == 0) {
            this.f15009t = false;
        }
        if (!isEnabled() || this.f15009t || canChildScrollUp() || this.f14992c || this.f15001l) {
            return false;
        }
        if (actionMasked == 0) {
            this.f15007r = motionEvent.getPointerId(0);
            this.f15006q = false;
        } else {
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f15007r);
                if (findPointerIndex < 0) {
                    Log.e(P, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f15006q) {
                    float y10 = (motionEvent.getY(findPointerIndex) - this.f15004o) * 0.5f;
                    this.f15006q = false;
                    e(y10);
                }
                this.f15007r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f15007r);
                if (findPointerIndex2 < 0) {
                    Log.e(P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y11 = motionEvent.getY(findPointerIndex2);
                m(y11);
                if (this.f15006q) {
                    float f11 = (y11 - this.f15004o) * 0.5f;
                    if (f11 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    g(f11);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f15007r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    i(motionEvent);
                }
            }
        }
        return true;
    }

    void p(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.E = cVar;
        cVar.setDuration(150L);
        this.f15011v.b(animationListener);
        this.f15011v.clearAnimation();
        this.f15011v.startAnimation(this.E);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent;
        View view = this.f14990a;
        if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z10);
        } else {
            if (this.L || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    void setAnimationProgress(float f11) {
        this.f15011v.setScaleX(f11);
        this.f15011v.setScaleY(f11);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.C.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr2[i11] = androidx.core.content.b.getColor(context, iArr[i11]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i11) {
        this.f14994e = i11;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        j();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.L = z10;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.f14997h.setNestedScrollingEnabled(z10);
    }

    public void setOnChildScrollUpCallback(@Nullable i iVar) {
    }

    public void setOnRefreshListener(@Nullable j jVar) {
        this.f14991b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i11) {
        setProgressBackgroundColorSchemeResource(i11);
    }

    public void setProgressBackgroundColorSchemeColor(int i11) {
        this.f15011v.setBackgroundColor(i11);
    }

    public void setProgressBackgroundColorSchemeResource(int i11) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(getContext(), i11));
    }

    public void setProgressViewEndTarget(boolean z10, int i11) {
        this.A = i11;
        this.f15008s = z10;
        this.f15011v.invalidate();
    }

    public void setProgressViewOffset(boolean z10, int i11, int i12) {
        this.f15008s = z10;
        this.f15015z = i11;
        this.A = i12;
        this.K = true;
        j();
        this.f14992c = false;
    }

    public void setRefreshing(boolean z10) {
        if (!z10 || this.f14992c == z10) {
            k(z10, false);
            return;
        }
        this.f14992c = z10;
        setTargetOffsetTopAndBottom((!this.K ? this.A + this.f15015z : this.A) - this.f15003n);
        this.I = false;
        r(this.M);
    }

    public void setSize(int i11) {
        if (i11 == 0 || i11 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i11 == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.f15011v.setImageDrawable(null);
            this.C.l(i11);
            this.f15011v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i11) {
        this.B = i11;
    }

    void setTargetOffsetTopAndBottom(int i11) {
        this.f15011v.bringToFront();
        ViewCompat.offsetTopAndBottom(this.f15011v, i11);
        this.f15003n = this.f15011v.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i11) {
        return this.f14997h.startNestedScroll(i11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i11, int i12) {
        return i12 == 0 && startNestedScroll(i11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f14997h.stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i11) {
        if (i11 == 0) {
            stopNestedScroll();
        }
    }
}
