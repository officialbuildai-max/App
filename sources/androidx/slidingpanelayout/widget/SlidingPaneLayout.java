package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.s;
import androidx.window.layout.r;
import androidx.window.layout.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class SlidingPaneLayout extends ViewGroup {
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;

    /* renamed from: y, reason: collision with root package name */
    private static boolean f14929y;

    /* renamed from: a, reason: collision with root package name */
    private int f14930a;

    /* renamed from: b, reason: collision with root package name */
    private int f14931b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f14932c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f14933d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14934e;

    /* renamed from: f, reason: collision with root package name */
    View f14935f;

    /* renamed from: g, reason: collision with root package name */
    float f14936g;

    /* renamed from: h, reason: collision with root package name */
    private float f14937h;

    /* renamed from: i, reason: collision with root package name */
    int f14938i;

    /* renamed from: j, reason: collision with root package name */
    boolean f14939j;

    /* renamed from: k, reason: collision with root package name */
    private int f14940k;

    /* renamed from: l, reason: collision with root package name */
    private float f14941l;

    /* renamed from: m, reason: collision with root package name */
    private float f14942m;

    /* renamed from: n, reason: collision with root package name */
    private final List f14943n;

    /* renamed from: o, reason: collision with root package name */
    private e f14944o;

    /* renamed from: p, reason: collision with root package name */
    final ViewDragHelper f14945p;

    /* renamed from: q, reason: collision with root package name */
    boolean f14946q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f14947r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f14948s;

    /* renamed from: t, reason: collision with root package name */
    final ArrayList f14949t;

    /* renamed from: u, reason: collision with root package name */
    private int f14950u;

    /* renamed from: v, reason: collision with root package name */
    r f14951v;

    /* renamed from: w, reason: collision with root package name */
    private FoldingFeatureObserver.a f14952w;

    /* renamed from: x, reason: collision with root package name */
    private FoldingFeatureObserver f14953x;

    /* loaded from: classes2.dex */
    private class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                SlidingPaneLayout.this.h(this.mChildView);
            }
            SlidingPaneLayout.this.f14949t.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f14954a;

        /* renamed from: b, reason: collision with root package name */
        int f14955b;

        /* loaded from: classes2.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f14954a = parcel.readInt() != 0;
            this.f14955b = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f14954a ? 1 : 0);
            parcel.writeInt(this.f14955b);
        }
    }

    /* loaded from: classes2.dex */
    class a implements FoldingFeatureObserver.a {
        a() {
        }

        @Override // androidx.slidingpanelayout.widget.FoldingFeatureObserver.a
        public void a(r rVar) {
            SlidingPaneLayout.this.f14951v = rVar;
            androidx.transition.b bVar = new androidx.transition.b();
            bVar.X(300L);
            bVar.Z(PathInterpolatorCompat.create(0.2f, 0.0f, 0.0f, 1.0f));
            s.a(SlidingPaneLayout.this, bVar);
            SlidingPaneLayout.this.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    class b extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f14957a = new Rect();

        b() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f14957a;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.i(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            a(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.setSource(view);
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i11);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (b(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* loaded from: classes2.dex */
    private class c extends ViewDragHelper.b {
        c() {
        }

        private boolean a() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f14939j || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            return SlidingPaneLayout.this.isOpen() || SlidingPaneLayout.this.getLockMode() != 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            d dVar = (d) SlidingPaneLayout.this.f14935f.getLayoutParams();
            if (SlidingPaneLayout.this.j()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + SlidingPaneLayout.this.f14935f.getWidth());
                return Math.max(Math.min(i11, width), width - SlidingPaneLayout.this.f14938i);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            return Math.min(Math.max(i11, paddingLeft), SlidingPaneLayout.this.f14938i + paddingLeft);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f14938i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onEdgeDragStarted(int i11, int i12) {
            if (a()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f14945p.captureChildView(slidingPaneLayout.f14935f, i12);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onEdgeTouched(int i11, int i12) {
            if (a()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f14945p.captureChildView(slidingPaneLayout.f14935f, i12);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewCaptured(View view, int i11) {
            SlidingPaneLayout.this.o();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewDragStateChanged(int i11) {
            if (SlidingPaneLayout.this.f14945p.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f14936g != 1.0f) {
                    slidingPaneLayout.c(slidingPaneLayout.f14935f);
                    SlidingPaneLayout.this.f14946q = true;
                } else {
                    slidingPaneLayout.r(slidingPaneLayout.f14935f);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.b(slidingPaneLayout2.f14935f);
                    SlidingPaneLayout.this.f14946q = false;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            SlidingPaneLayout.this.l(i11);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewReleased(View view, float f11, float f12) {
            int paddingLeft;
            d dVar = (d) view.getLayoutParams();
            if (SlidingPaneLayout.this.j()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                if (f11 < 0.0f || (f11 == 0.0f && SlidingPaneLayout.this.f14936g > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f14938i;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f14935f.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f11 > 0.0f || (f11 == 0.0f && SlidingPaneLayout.this.f14936g > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f14938i;
                }
            }
            SlidingPaneLayout.this.f14945p.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean tryCaptureView(View view, int i11) {
            if (a()) {
                return ((d) view.getLayoutParams()).f14962b;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: e, reason: collision with root package name */
        private static final int[] f14960e = {R.attr.layout_weight};

        /* renamed from: a, reason: collision with root package name */
        public float f14961a;

        /* renamed from: b, reason: collision with root package name */
        boolean f14962b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14963c;

        /* renamed from: d, reason: collision with root package name */
        Paint f14964d;

        public d() {
            super(-1, -1);
            this.f14961a = 0.0f;
        }

        public d(int i11, int i12) {
            super(i11, i12);
            this.f14961a = 0.0f;
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f14961a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f14960e);
            this.f14961a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f14961a = 0.0f;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f14961a = 0.0f;
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(View view);

        void b(View view);

        void c(View view, float f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends FrameLayout {
        f(View view) {
            super(view.getContext());
            addView(view);
        }

        @Override // android.view.View
        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    static {
        f14929y = Build.VERSION.SDK_INT >= 29;
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f14930a = 0;
        this.f14936g = 1.0f;
        this.f14943n = new CopyOnWriteArrayList();
        this.f14947r = true;
        this.f14948s = new Rect();
        this.f14949t = new ArrayList();
        this.f14952w = new a();
        float f11 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new b());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new c());
        this.f14945p = create;
        create.setMinVelocity(f11 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(w.a(context), androidx.core.content.b.getMainExecutor(context)));
    }

    private boolean a(int i11) {
        if (!this.f14934e) {
            this.f14946q = false;
        }
        if (!this.f14947r && !p(1.0f, i11)) {
            return false;
        }
        this.f14946q = false;
        return true;
    }

    private static Activity e(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private static Rect f(r rVar, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        Rect rect = new Rect(i11, iArr[1], view.getWidth() + i11, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(rVar.getBounds());
        boolean intersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !intersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    private static int g(View view) {
        return view instanceof f ? ViewCompat.getMinimumWidth(((f) view).getChildAt(0)) : ViewCompat.getMinimumWidth(view);
    }

    private z0.c getSystemGestureInsets() {
        WindowInsetsCompat rootWindowInsets;
        if (!f14929y || (rootWindowInsets = ViewCompat.getRootWindowInsets(this)) == null) {
            return null;
        }
        return rootWindowInsets.getSystemGestureInsets();
    }

    private static int k(View view, int i11, int i12) {
        d dVar = (d) view.getLayoutParams();
        return (((ViewGroup.MarginLayoutParams) dVar).width != 0 || dVar.f14961a <= 0.0f) ? View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824) : ViewGroup.getChildMeasureSpec(i11, i12, ((ViewGroup.MarginLayoutParams) dVar).height);
    }

    private boolean m(int i11) {
        if (!this.f14934e) {
            this.f14946q = true;
        }
        if (!this.f14947r && !p(0.0f, i11)) {
            return false;
        }
        this.f14946q = true;
        return true;
    }

    private void n(float f11) {
        boolean j11 = j();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != this.f14935f) {
                float f12 = 1.0f - this.f14937h;
                int i12 = this.f14940k;
                this.f14937h = f11;
                int i13 = ((int) (f12 * i12)) - ((int) ((1.0f - f11) * i12));
                if (j11) {
                    i13 = -i13;
                }
                childAt.offsetLeftAndRight(i13);
            }
        }
    }

    private ArrayList q() {
        Rect f11;
        r rVar = this.f14951v;
        if (rVar == null || !rVar.isSeparating() || this.f14951v.getBounds().left == 0 || this.f14951v.getBounds().top != 0 || (f11 = f(this.f14951v, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), f11.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList(Arrays.asList(rect, new Rect(Math.min(width, f11.right), getPaddingTop(), width, getHeight() - getPaddingBottom())));
    }

    private static boolean s(View view) {
        return view.isOpaque();
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.f14953x = foldingFeatureObserver;
        foldingFeatureObserver.f(this.f14952w);
    }

    public void addPanelSlideListener(@NonNull e eVar) {
        this.f14943n.add(eVar);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i11, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new f(view), i11, layoutParams);
        } else {
            super.addView(view, i11, layoutParams);
        }
    }

    void b(View view) {
        Iterator it = this.f14943n.iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(view);
        }
        sendAccessibilityEvent(32);
    }

    void c(View view) {
        Iterator it = this.f14943n.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(view);
        }
        sendAccessibilityEvent(32);
    }

    @Deprecated
    public boolean canSlide() {
        return this.f14934e;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closePane();
    }

    public boolean closePane() {
        return a(0);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f14945p.continueSettling(true)) {
            if (this.f14934e) {
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.f14945p.abort();
            }
        }
    }

    void d(View view) {
        Iterator it = this.f14943n.iterator();
        while (it.hasNext()) {
            ((e) it.next()).c(view, this.f14936g);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i11;
        int i12;
        super.draw(canvas);
        Drawable drawable = j() ? this.f14933d : this.f14932c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (j()) {
            i12 = childAt.getRight();
            i11 = intrinsicWidth + i12;
        } else {
            int left = childAt.getLeft();
            int i13 = left - intrinsicWidth;
            i11 = left;
            i12 = i13;
        }
        drawable.setBounds(i12, top, i11, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j11) {
        if (j() ^ isOpen()) {
            this.f14945p.setEdgeTrackingEnabled(1);
            z0.c systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.f14945p;
                viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.f79248a));
            }
        } else {
            this.f14945p.setEdgeTrackingEnabled(2);
            z0.c systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.f14945p;
                viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets2.f79250c));
            }
        }
        d dVar = (d) view.getLayoutParams();
        int save = canvas.save();
        if (this.f14934e && !dVar.f14962b && this.f14935f != null) {
            canvas.getClipBounds(this.f14948s);
            if (j()) {
                Rect rect = this.f14948s;
                rect.left = Math.max(rect.left, this.f14935f.getRight());
            } else {
                Rect rect2 = this.f14948s;
                rect2.right = Math.min(rect2.right, this.f14935f.getLeft());
            }
            canvas.clipRect(this.f14948s);
        }
        boolean drawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f14931b;
    }

    public final int getLockMode() {
        return this.f14950u;
    }

    public int getParallaxDistance() {
        return this.f14940k;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.f14930a;
    }

    void h(View view) {
        ViewCompat.setLayerPaint(view, ((d) view.getLayoutParams()).f14964d);
    }

    boolean i(View view) {
        if (view == null) {
            return false;
        }
        return this.f14934e && ((d) view.getLayoutParams()).f14963c && this.f14936g > 0.0f;
    }

    public boolean isOpen() {
        return !this.f14934e || this.f14936g == 0.0f;
    }

    public boolean isSlideable() {
        return this.f14934e;
    }

    boolean j() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    void l(int i11) {
        if (this.f14935f == null) {
            this.f14936g = 0.0f;
            return;
        }
        boolean j11 = j();
        d dVar = (d) this.f14935f.getLayoutParams();
        int width = this.f14935f.getWidth();
        if (j11) {
            i11 = (getWidth() - i11) - width;
        }
        float paddingRight = (i11 - ((j11 ? getPaddingRight() : getPaddingLeft()) + (j11 ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin))) / this.f14938i;
        this.f14936g = paddingRight;
        if (this.f14940k != 0) {
            n(paddingRight);
        }
        d(this.f14935f);
    }

    void o() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity e11;
        super.onAttachedToWindow();
        this.f14947r = true;
        if (this.f14953x == null || (e11 = e(getContext())) == null) {
            return;
        }
        this.f14953x.e(e11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f14947r = true;
        FoldingFeatureObserver foldingFeatureObserver = this.f14953x;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.g();
        }
        int size = this.f14949t.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((DisableLayerRunnable) this.f14949t.get(i11)).run();
        }
        this.f14949t.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f14934e && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f14946q = this.f14945p.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f14934e || (this.f14939j && actionMasked != 0)) {
            this.f14945p.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f14945p.cancel();
            return false;
        }
        if (actionMasked == 0) {
            this.f14939j = false;
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f14941l = x10;
            this.f14942m = y10;
            if (this.f14945p.isViewUnder(this.f14935f, (int) x10, (int) y10) && i(this.f14935f)) {
                z10 = true;
                return this.f14945p.shouldInterceptTouchEvent(motionEvent) || z10;
            }
        } else if (actionMasked == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float abs = Math.abs(x11 - this.f14941l);
            float abs2 = Math.abs(y11 - this.f14942m);
            if (abs > this.f14945p.getTouchSlop() && abs2 > abs) {
                this.f14945p.cancel();
                this.f14939j = true;
                return false;
            }
        }
        z10 = false;
        if (this.f14945p.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean j11 = j();
        int i20 = i13 - i11;
        int paddingRight = j11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = j11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f14947r) {
            this.f14936g = (this.f14934e && this.f14946q) ? 0.0f : 1.0f;
        }
        int i21 = paddingRight;
        int i22 = 0;
        while (i22 < childCount) {
            View childAt = getChildAt(i22);
            if (childAt.getVisibility() == 8) {
                i15 = i21;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.f14962b) {
                    int i23 = i20 - paddingLeft;
                    int min = (Math.min(paddingRight, i23) - i21) - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin);
                    this.f14938i = min;
                    int i24 = j11 ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    dVar.f14963c = ((i21 + i24) + min) + (measuredWidth / 2) > i23;
                    int i25 = (int) (min * this.f14936g);
                    this.f14936g = i25 / min;
                    i15 = i21 + i24 + i25;
                    i16 = 0;
                } else if (!this.f14934e || (i17 = this.f14940k) == 0) {
                    i15 = paddingRight;
                    i16 = 0;
                } else {
                    i16 = (int) ((1.0f - this.f14936g) * i17);
                    i15 = paddingRight;
                }
                if (j11) {
                    i19 = (i20 - i15) + i16;
                    i18 = i19 - measuredWidth;
                } else {
                    i18 = i15 - i16;
                    i19 = i18 + measuredWidth;
                }
                childAt.layout(i18, paddingTop, i19, childAt.getMeasuredHeight() + paddingTop);
                r rVar = this.f14951v;
                paddingRight += childAt.getWidth() + Math.abs((rVar != null && rVar.getOrientation() == r.b.f15438c && this.f14951v.isSeparating()) ? this.f14951v.getBounds().width() : 0);
            }
            i22++;
            i21 = i15;
        }
        if (this.f14947r) {
            if (this.f14934e && this.f14940k != 0) {
                n(this.f14936g);
            }
            r(this.f14935f);
        }
        this.f14947r = false;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int paddingTop;
        int i13;
        int i14;
        int i15;
        int i16;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        ?? r82 = 0;
        if (mode2 != Integer.MIN_VALUE) {
            i13 = mode2 != 1073741824 ? 0 : (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = i13;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i13 = 0;
        }
        int max = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f14935f = null;
        int i17 = 0;
        boolean z10 = false;
        int i18 = max;
        float f11 = 0.0f;
        while (true) {
            i14 = 8;
            if (i17 >= childCount) {
                break;
            }
            View childAt = getChildAt(i17);
            d dVar = (d) childAt.getLayoutParams();
            int i19 = size;
            if (childAt.getVisibility() == 8) {
                dVar.f14963c = r82;
            } else {
                float f12 = dVar.f14961a;
                if (f12 > 0.0f) {
                    f11 += f12;
                    if (((ViewGroup.MarginLayoutParams) dVar).width == 0) {
                    }
                }
                int max2 = Math.max(max - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin), (int) r82);
                int i20 = ((ViewGroup.MarginLayoutParams) dVar).width;
                childAt.measure(i20 == -2 ? View.MeasureSpec.makeMeasureSpec(max2, mode == 0 ? mode : Integer.MIN_VALUE) : i20 == -1 ? View.MeasureSpec.makeMeasureSpec(max2, mode) : View.MeasureSpec.makeMeasureSpec(i20, 1073741824), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) dVar).height));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i13) {
                    if (mode2 == Integer.MIN_VALUE) {
                        i13 = Math.min(measuredHeight, paddingTop);
                    } else if (mode2 == 0) {
                        i13 = measuredHeight;
                    }
                }
                i18 -= measuredWidth;
                if (i17 != 0) {
                    boolean z11 = i18 < 0;
                    dVar.f14962b = z11;
                    z10 |= z11;
                    if (z11) {
                        this.f14935f = childAt;
                    }
                }
            }
            i17++;
            size = i19;
            r82 = 0;
        }
        int i21 = size;
        int i22 = i18;
        if (z10 || f11 > 0.0f) {
            int i23 = 0;
            while (i23 < childCount) {
                View childAt2 = getChildAt(i23);
                if (childAt2.getVisibility() != i14) {
                    d dVar2 = (d) childAt2.getLayoutParams();
                    int measuredWidth2 = (((ViewGroup.MarginLayoutParams) dVar2).width != 0 || dVar2.f14961a <= 0.0f) ? childAt2.getMeasuredWidth() : 0;
                    if (z10) {
                        i15 = max - (((ViewGroup.MarginLayoutParams) dVar2).leftMargin + ((ViewGroup.MarginLayoutParams) dVar2).rightMargin);
                        i16 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                    } else if (dVar2.f14961a > 0.0f) {
                        i15 = measuredWidth2 + ((int) ((dVar2.f14961a * Math.max(0, i22)) / f11));
                        i16 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                    } else {
                        i15 = measuredWidth2;
                        i16 = 0;
                    }
                    int k11 = k(childAt2, i12, getPaddingTop() + getPaddingBottom());
                    if (measuredWidth2 != i15) {
                        childAt2.measure(i16, k11);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > i13) {
                            if (mode2 == Integer.MIN_VALUE) {
                                measuredHeight2 = Math.min(measuredHeight2, paddingTop);
                            } else if (mode2 != 0) {
                            }
                            i13 = measuredHeight2;
                        }
                    }
                }
                i23++;
                i14 = 8;
            }
        }
        ArrayList q11 = q();
        if (q11 != null && !z10) {
            for (int i24 = 0; i24 < childCount; i24++) {
                View childAt3 = getChildAt(i24);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = (Rect) q11.get(i24);
                    d dVar3 = (d) childAt3.getLayoutParams();
                    int i25 = ((ViewGroup.MarginLayoutParams) dVar3).leftMargin + ((ViewGroup.MarginLayoutParams) dVar3).rightMargin;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), makeMeasureSpec);
                    if ((childAt3.getMeasuredWidthAndState() & 16777216) == 1 || (g(childAt3) != 0 && rect.width() < g(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(max - i25, 1073741824), makeMeasureSpec);
                        if (i24 != 0) {
                            dVar3.f14962b = true;
                            this.f14935f = childAt3;
                            z10 = true;
                        }
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), makeMeasureSpec);
                    }
                }
            }
        }
        setMeasuredDimension(i21, i13 + getPaddingTop() + getPaddingBottom());
        this.f14934e = z10;
        if (this.f14945p.getViewDragState() == 0 || z10) {
            return;
        }
        this.f14945p.abort();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f14954a) {
            openPane();
        } else {
            closePane();
        }
        this.f14946q = savedState.f14954a;
        setLockMode(savedState.f14955b);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14954a = isSlideable() ? isOpen() : this.f14946q;
        savedState.f14955b = this.f14950u;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            this.f14947r = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f14934e) {
            return super.onTouchEvent(motionEvent);
        }
        this.f14945p.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f14941l = x10;
            this.f14942m = y10;
        } else if (actionMasked == 1 && i(this.f14935f)) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float f11 = x11 - this.f14941l;
            float f12 = y11 - this.f14942m;
            int touchSlop = this.f14945p.getTouchSlop();
            if ((f11 * f11) + (f12 * f12) < touchSlop * touchSlop && this.f14945p.isViewUnder(this.f14935f, (int) x11, (int) y11)) {
                a(0);
            }
        }
        return true;
    }

    public void open() {
        openPane();
    }

    public boolean openPane() {
        return m(0);
    }

    boolean p(float f11, int i11) {
        int paddingLeft;
        if (!this.f14934e) {
            return false;
        }
        boolean j11 = j();
        d dVar = (d) this.f14935f.getLayoutParams();
        if (j11) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + (f11 * this.f14938i)) + this.f14935f.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + (f11 * this.f14938i));
        }
        ViewDragHelper viewDragHelper = this.f14945p;
        View view = this.f14935f;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        o();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    void r(View view) {
        int i11;
        int i12;
        int i13;
        int i14;
        View childAt;
        boolean z10;
        View view2 = view;
        boolean j11 = j();
        int width = j11 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = j11 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !s(view)) {
            i11 = 0;
            i12 = 0;
            i13 = 0;
            i14 = 0;
        } else {
            i11 = view.getLeft();
            i12 = view.getRight();
            i13 = view.getTop();
            i14 = view.getBottom();
        }
        int childCount = getChildCount();
        int i15 = 0;
        while (i15 < childCount && (childAt = getChildAt(i15)) != view2) {
            if (childAt.getVisibility() == 8) {
                z10 = j11;
            } else {
                z10 = j11;
                childAt.setVisibility((Math.max(j11 ? paddingLeft : width, childAt.getLeft()) < i11 || Math.max(paddingTop, childAt.getTop()) < i13 || Math.min(j11 ? width : paddingLeft, childAt.getRight()) > i12 || Math.min(height, childAt.getBottom()) > i14) ? 0 : 4);
            }
            i15++;
            view2 = view;
            j11 = z10;
        }
    }

    public void removePanelSlideListener(@NonNull e eVar) {
        this.f14943n.remove(eVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View view) {
        if (view.getParent() instanceof f) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f14934e) {
            return;
        }
        this.f14946q = view == this.f14935f;
    }

    @Deprecated
    public void setCoveredFadeColor(int i11) {
        this.f14931b = i11;
    }

    public final void setLockMode(int i11) {
        this.f14950u = i11;
    }

    @Deprecated
    public void setPanelSlideListener(@Nullable e eVar) {
        e eVar2 = this.f14944o;
        if (eVar2 != null) {
            removePanelSlideListener(eVar2);
        }
        if (eVar != null) {
            addPanelSlideListener(eVar);
        }
        this.f14944o = eVar;
    }

    public void setParallaxDistance(int i11) {
        this.f14940k = i11;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.f14932c = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.f14933d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i11) {
        setShadowDrawableLeft(getResources().getDrawable(i11));
    }

    public void setShadowResourceLeft(int i11) {
        setShadowDrawableLeft(androidx.core.content.b.getDrawable(getContext(), i11));
    }

    public void setShadowResourceRight(int i11) {
        setShadowDrawableRight(androidx.core.content.b.getDrawable(getContext(), i11));
    }

    @Deprecated
    public void setSliderFadeColor(int i11) {
        this.f14930a = i11;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }
}
