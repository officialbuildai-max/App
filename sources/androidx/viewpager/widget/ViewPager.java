package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List<g> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private h mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<d> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private j mObserver;
    private int mOffscreenPageLimit;
    private h mOnPageChangeListener;
    private List<h> mOnPageChangeListeners;
    private int mPageMargin;
    private i mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final d mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<d> COMPARATOR = new Comparator<d>() { // from class: androidx.viewpager.widget.ViewPager.1
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return dVar.f15347b - dVar2.f15347b;
        }
    };
    private static final Interpolator sInterpolator = new a();
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator {
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
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            e eVar = (e) view.getLayoutParams();
            e eVar2 = (e) view2.getLayoutParams();
            boolean z10 = eVar.f15351a;
            return z10 != eVar2.f15351a ? z10 ? 1 : -1 : eVar.f15355e - eVar2.f15355e;
        }
    }

    /* loaded from: classes2.dex */
    static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f15344a = new Rect();

        b() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (onApplyWindowInsets.isConsumed()) {
                return onApplyWindowInsets;
            }
            Rect rect = this.f15344a;
            rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = ViewPager.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i11), onApplyWindowInsets);
                rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        Object f15346a;

        /* renamed from: b, reason: collision with root package name */
        int f15347b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15348c;

        /* renamed from: d, reason: collision with root package name */
        float f15349d;

        /* renamed from: e, reason: collision with root package name */
        float f15350e;

        d() {
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f15351a;

        /* renamed from: b, reason: collision with root package name */
        public int f15352b;

        /* renamed from: c, reason: collision with root package name */
        float f15353c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15354d;

        /* renamed from: e, reason: collision with root package name */
        int f15355e;

        /* renamed from: f, reason: collision with root package name */
        int f15356f;

        public e() {
            super(-1, -1);
            this.f15353c = 0.0f;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f15353c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f15352b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends AccessibilityDelegateCompat {
        f() {
        }

        private boolean a() {
            PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
            return pagerAdapter != null && pagerAdapter.getCount() > 1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(a());
            if (accessibilityEvent.getEventType() != 4096 || (pagerAdapter = ViewPager.this.mAdapter) == null) {
                return;
            }
            accessibilityEvent.setItemCount(pagerAdapter.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
            accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            if (super.performAccessibilityAction(view, i11, bundle)) {
                return true;
            }
            if (i11 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem + 1);
                return true;
            }
            if (i11 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.mCurItem - 1);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void onPageScrollStateChanged(int i11);

        void onPageScrolled(int i11, float f11, int i12);

        void onPageSelected(int i11);
    }

    /* loaded from: classes2.dex */
    public interface i {
    }

    /* loaded from: classes2.dex */
    private class j extends DataSetObserver {
        j() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    public static class k implements h {
        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrollStateChanged(int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrolled(int i11, float f11, int i12) {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageSelected(int i11) {
        }
    }

    public ViewPager(@NonNull Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new d();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new d();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: androidx.viewpager.widget.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void a(d dVar, int i11, d dVar2) {
        int i12;
        int i13;
        d dVar3;
        d dVar4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f11 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        if (dVar2 != null) {
            int i14 = dVar2.f15347b;
            int i15 = dVar.f15347b;
            if (i14 < i15) {
                float f12 = dVar2.f15350e + dVar2.f15349d + f11;
                int i16 = i14 + 1;
                int i17 = 0;
                while (i16 <= dVar.f15347b && i17 < this.mItems.size()) {
                    d dVar5 = this.mItems.get(i17);
                    while (true) {
                        dVar4 = dVar5;
                        if (i16 <= dVar4.f15347b || i17 >= this.mItems.size() - 1) {
                            break;
                        }
                        i17++;
                        dVar5 = this.mItems.get(i17);
                    }
                    while (i16 < dVar4.f15347b) {
                        f12 += this.mAdapter.getPageWidth(i16) + f11;
                        i16++;
                    }
                    dVar4.f15350e = f12;
                    f12 += dVar4.f15349d + f11;
                    i16++;
                }
            } else if (i14 > i15) {
                int size = this.mItems.size() - 1;
                float f13 = dVar2.f15350e;
                while (true) {
                    i14--;
                    if (i14 < dVar.f15347b || size < 0) {
                        break;
                    }
                    d dVar6 = this.mItems.get(size);
                    while (true) {
                        dVar3 = dVar6;
                        if (i14 >= dVar3.f15347b || size <= 0) {
                            break;
                        }
                        size--;
                        dVar6 = this.mItems.get(size);
                    }
                    while (i14 > dVar3.f15347b) {
                        f13 -= this.mAdapter.getPageWidth(i14) + f11;
                        i14--;
                    }
                    f13 -= dVar3.f15349d + f11;
                    dVar3.f15350e = f13;
                }
            }
        }
        int size2 = this.mItems.size();
        float f14 = dVar.f15350e;
        int i18 = dVar.f15347b;
        int i19 = i18 - 1;
        this.mFirstOffset = i18 == 0 ? f14 : -3.4028235E38f;
        int i20 = count - 1;
        this.mLastOffset = i18 == i20 ? (dVar.f15349d + f14) - 1.0f : Float.MAX_VALUE;
        int i21 = i11 - 1;
        while (i21 >= 0) {
            d dVar7 = this.mItems.get(i21);
            while (true) {
                i13 = dVar7.f15347b;
                if (i19 <= i13) {
                    break;
                }
                f14 -= this.mAdapter.getPageWidth(i19) + f11;
                i19--;
            }
            f14 -= dVar7.f15349d + f11;
            dVar7.f15350e = f14;
            if (i13 == 0) {
                this.mFirstOffset = f14;
            }
            i21--;
            i19--;
        }
        float f15 = dVar.f15350e + dVar.f15349d + f11;
        int i22 = dVar.f15347b + 1;
        int i23 = i11 + 1;
        while (i23 < size2) {
            d dVar8 = this.mItems.get(i23);
            while (true) {
                i12 = dVar8.f15347b;
                if (i22 >= i12) {
                    break;
                }
                f15 += this.mAdapter.getPageWidth(i22) + f11;
                i22++;
            }
            if (i12 == i20) {
                this.mLastOffset = (dVar8.f15349d + f15) - 1.0f;
            }
            dVar8.f15350e = f15;
            f15 += dVar8.f15349d + f11;
            i23++;
            i22++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void b(boolean z10) {
        boolean z11 = this.mScrollState == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            d dVar = this.mItems.get(i11);
            if (dVar.f15348c) {
                dVar.f15348c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int c(int i11, float f11, int i12, int i13) {
        if (Math.abs(i13) <= this.mFlingDistance || Math.abs(i12) <= this.mMinimumVelocity) {
            i11 += (int) (f11 + (i11 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i12 <= 0) {
            i11++;
        }
        if (this.mItems.size() <= 0) {
            return i11;
        }
        return Math.max(this.mItems.get(0).f15347b, Math.min(i11, this.mItems.get(r4.size() - 1).f15347b));
    }

    private void d(int i11, float f11, int i12) {
        h hVar = this.mOnPageChangeListener;
        if (hVar != null) {
            hVar.onPageScrolled(i11, f11, i12);
        }
        List<h> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                h hVar2 = this.mOnPageChangeListeners.get(i13);
                if (hVar2 != null) {
                    hVar2.onPageScrolled(i11, f11, i12);
                }
            }
        }
        h hVar3 = this.mInternalPageChangeListener;
        if (hVar3 != null) {
            hVar3.onPageScrolled(i11, f11, i12);
        }
    }

    private void e(int i11) {
        h hVar = this.mOnPageChangeListener;
        if (hVar != null) {
            hVar.onPageSelected(i11);
        }
        List<h> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                h hVar2 = this.mOnPageChangeListeners.get(i12);
                if (hVar2 != null) {
                    hVar2.onPageSelected(i11);
                }
            }
        }
        h hVar3 = this.mInternalPageChangeListener;
        if (hVar3 != null) {
            hVar3.onPageSelected(i11);
        }
    }

    private void f(int i11) {
        h hVar = this.mOnPageChangeListener;
        if (hVar != null) {
            hVar.onPageScrollStateChanged(i11);
        }
        List<h> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                h hVar2 = this.mOnPageChangeListeners.get(i12);
                if (hVar2 != null) {
                    hVar2.onPageScrollStateChanged(i11);
                }
            }
        }
        h hVar3 = this.mInternalPageChangeListener;
        if (hVar3 != null) {
            hVar3.onPageScrollStateChanged(i11);
        }
    }

    private void g() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private Rect h(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private d i() {
        int i11;
        int clientWidth = getClientWidth();
        float f11 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f12 = clientWidth > 0 ? this.mPageMargin / clientWidth : 0.0f;
        int i12 = 0;
        boolean z10 = true;
        d dVar = null;
        int i13 = -1;
        float f13 = 0.0f;
        while (i12 < this.mItems.size()) {
            d dVar2 = this.mItems.get(i12);
            if (!z10 && dVar2.f15347b != (i11 = i13 + 1)) {
                dVar2 = this.mTempItem;
                dVar2.f15350e = f11 + f13 + f12;
                dVar2.f15347b = i11;
                dVar2.f15349d = this.mAdapter.getPageWidth(i11);
                i12--;
            }
            d dVar3 = dVar2;
            f11 = dVar3.f15350e;
            float f14 = dVar3.f15349d + f11 + f12;
            if (!z10 && scrollX < f11) {
                return dVar;
            }
            if (scrollX < f14 || i12 == this.mItems.size() - 1) {
                return dVar3;
            }
            int i14 = dVar3.f15347b;
            float f15 = dVar3.f15349d;
            i12++;
            z10 = false;
            i13 = i14;
            f13 = f15;
            dVar = dVar3;
        }
        return dVar;
    }

    private static boolean j(View view) {
        return view.getClass().getAnnotation(c.class) != null;
    }

    private boolean k(float f11, float f12) {
        return (f11 < ((float) this.mGutterSize) && f12 > 0.0f) || (f11 > ((float) (getWidth() - this.mGutterSize)) && f12 < 0.0f);
    }

    private void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i11);
            this.mActivePointerId = motionEvent.getPointerId(i11);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean m(int i11) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        d i12 = i();
        int clientWidth = getClientWidth();
        int i13 = this.mPageMargin;
        int i14 = clientWidth + i13;
        float f11 = clientWidth;
        int i15 = i12.f15347b;
        float f12 = ((i11 / f11) - i12.f15350e) / (i12.f15349d + (i13 / f11));
        this.mCalledSuper = false;
        onPageScrolled(i15, f12, (int) (i14 * f12));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean n(float f11) {
        boolean z10;
        boolean z11;
        float f12 = this.mLastMotionX - f11;
        this.mLastMotionX = f11;
        float scrollX = getScrollX() + f12;
        float clientWidth = getClientWidth();
        float f13 = this.mFirstOffset * clientWidth;
        float f14 = this.mLastOffset * clientWidth;
        boolean z12 = false;
        d dVar = this.mItems.get(0);
        ArrayList<d> arrayList = this.mItems;
        d dVar2 = arrayList.get(arrayList.size() - 1);
        if (dVar.f15347b != 0) {
            f13 = dVar.f15350e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (dVar2.f15347b != this.mAdapter.getCount() - 1) {
            f14 = dVar2.f15350e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f13) {
            if (z10) {
                this.mLeftEdge.onPull(Math.abs(f13 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        } else if (scrollX > f14) {
            if (z11) {
                this.mRightEdge.onPull(Math.abs(scrollX - f14) / clientWidth);
                z12 = true;
            }
            scrollX = f14;
        }
        int i11 = (int) scrollX;
        this.mLastMotionX += scrollX - i11;
        scrollTo(i11, getScrollY());
        m(i11);
        return z12;
    }

    private void o(int i11, int i12, int i13, int i14) {
        if (i12 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i12 - getPaddingLeft()) - getPaddingRight()) + i14)) * (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)), getScrollY());
                return;
            }
        }
        d infoForPosition = infoForPosition(this.mCurItem);
        int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.f15350e, this.mLastOffset) : 0.0f) * ((i11 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            b(false);
            scrollTo(min, getScrollY());
        }
    }

    private void p() {
        int i11 = 0;
        while (i11 < getChildCount()) {
            if (!((e) getChildAt(i11).getLayoutParams()).f15351a) {
                removeViewAt(i11);
                i11--;
            }
            i11++;
        }
    }

    private void q(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean r() {
        this.mActivePointerId = -1;
        g();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void s(int i11, boolean z10, int i12, boolean z11) {
        d infoForPosition = infoForPosition(i11);
        int clientWidth = infoForPosition != null ? (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(infoForPosition.f15350e, this.mLastOffset))) : 0;
        if (z10) {
            smoothScrollTo(clientWidth, 0, i12);
            if (z11) {
                e(i11);
                return;
            }
            return;
        }
        if (z11) {
            e(i11);
        }
        b(false);
        scrollTo(clientWidth, 0);
        m(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.mScrollingCacheEnabled != z10) {
            this.mScrollingCacheEnabled = z10;
        }
    }

    private void t() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                this.mDrawingOrderedChildren.add(getChildAt(i11));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        d infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f15347b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i11, i12);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i12 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    d addNewItem(int i11, int i12) {
        d dVar = new d();
        dVar.f15347b = i11;
        dVar.f15346a = this.mAdapter.instantiateItem((ViewGroup) this, i11);
        dVar.f15349d = this.mAdapter.getPageWidth(i11);
        if (i12 < 0 || i12 >= this.mItems.size()) {
            this.mItems.add(dVar);
        } else {
            this.mItems.add(i12, dVar);
        }
        return dVar;
    }

    public void addOnAdapterChangeListener(@NonNull g gVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(gVar);
    }

    public void addOnPageChangeListener(@NonNull h hVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(hVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d infoForChild;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f15347b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        e eVar = (e) layoutParams;
        boolean j11 = eVar.f15351a | j(view);
        eVar.f15351a = j11;
        if (!this.mInLayout) {
            super.addView(view, i11, layoutParams);
        } else {
            if (j11) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            eVar.f15354d = true;
            addViewInLayout(view, i11, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean arrowScroll(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            if (r5 != r3) goto L93
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.h(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.h(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.pageLeft()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.mTempRect
            android.graphics.Rect r2 = r4.h(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.mTempRect
            android.graphics.Rect r3 = r4.h(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.pageRight()
            goto Lca
        Lae:
            boolean r0 = r1.requestFocus()
            goto Lca
        Lb3:
            if (r5 == r3) goto Lc6
            r0 = 1
            if (r5 != r0) goto Lb9
            goto Lc6
        Lb9:
            if (r5 == r2) goto Lc1
            r0 = 2
            if (r5 != r0) goto Lbf
            goto Lc1
        Lbf:
            r0 = 0
            goto Lca
        Lc1:
            boolean r0 = r4.pageRight()
            goto Lca
        Lc6:
            boolean r0 = r4.pageLeft()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z10, int i11, int i12, int i13) {
        int i14;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i12 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i13 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom() && canScroll(childAt, true, i11, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i11);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i11) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i11 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i11 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<h> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            b(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!m(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z10 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i11 = this.mCurItem;
        int i12 = 0;
        boolean z11 = false;
        while (i12 < this.mItems.size()) {
            d dVar = this.mItems.get(i12);
            int itemPosition = this.mAdapter.getItemPosition(dVar.f15346a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i12);
                    i12--;
                    if (!z11) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, dVar.f15347b, dVar.f15346a);
                    int i13 = this.mCurItem;
                    if (i13 == dVar.f15347b) {
                        i11 = Math.max(0, Math.min(i13, count - 1));
                    }
                } else {
                    int i14 = dVar.f15347b;
                    if (i14 != itemPosition) {
                        if (i14 == this.mCurItem) {
                            i11 = itemPosition;
                        }
                        dVar.f15347b = itemPosition;
                    }
                }
                z10 = true;
            }
            i12++;
        }
        if (z11) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z10) {
            int childCount = getChildCount();
            for (int i15 = 0; i15 < childCount; i15++) {
                e eVar = (e) getChildAt(i15).getLayoutParams();
                if (!eVar.f15351a) {
                    eVar.f15353c = 0.0f;
                }
            }
            setCurrentItemInternal(i11, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        d infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f15347b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f11) {
        return (float) Math.sin((f11 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z10 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z10 = this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                z10 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z10) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            d i11 = i();
            setCurrentItemInternal(c(i11.f15347b, ((scrollX / clientWidth) - i11.f15350e) / i11.f15349d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        g();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f11) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f11;
        float scrollX = getScrollX() - f11;
        float clientWidth = getClientWidth();
        float f12 = this.mFirstOffset * clientWidth;
        float f13 = this.mLastOffset * clientWidth;
        d dVar = this.mItems.get(0);
        d dVar2 = this.mItems.get(r4.size() - 1);
        if (dVar.f15347b != 0) {
            f12 = dVar.f15350e * clientWidth;
        }
        if (dVar2.f15347b != this.mAdapter.getCount() - 1) {
            f13 = dVar2.f15350e * clientWidth;
        }
        if (scrollX < f12) {
            scrollX = f12;
        } else if (scrollX > f13) {
            scrollX = f13;
        }
        int i11 = (int) scrollX;
        this.mLastMotionX += scrollX - i11;
        scrollTo(i11, getScrollY());
        m(i11);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i11, int i12) {
        if (this.mDrawingOrder == 2) {
            i12 = (i11 - 1) - i12;
        }
        return ((e) this.mDrawingOrderedChildren.get(i12).getLayoutParams()).f15356f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    d infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    d infoForChild(View view) {
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            d dVar = this.mItems.get(i11);
            if (this.mAdapter.isViewFromObject(view, dVar.f15346a)) {
                return dVar;
            }
        }
        return null;
    }

    d infoForPosition(int i11) {
        for (int i12 = 0; i12 < this.mItems.size(); i12++) {
            d dVar = this.mItems.get(i12);
            if (dVar.f15347b == i11) {
                return dVar;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f11);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f11);
        this.mCloseEnough = (int) (2.0f * f11);
        this.mDefaultGutterSize = (int) (f11 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new b());
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i11;
        float f11;
        float f12;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f13 = this.mPageMargin / width;
        int i12 = 0;
        d dVar = this.mItems.get(0);
        float f14 = dVar.f15350e;
        int size = this.mItems.size();
        int i13 = dVar.f15347b;
        int i14 = this.mItems.get(size - 1).f15347b;
        while (i13 < i14) {
            while (true) {
                i11 = dVar.f15347b;
                if (i13 <= i11 || i12 >= size) {
                    break;
                }
                i12++;
                dVar = this.mItems.get(i12);
            }
            if (i13 == i11) {
                float f15 = dVar.f15350e;
                float f16 = dVar.f15349d;
                f11 = (f15 + f16) * width;
                f14 = f15 + f16 + f13;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i13);
                f11 = (f14 + pageWidth) * width;
                f14 += pageWidth + f13;
            }
            if (this.mPageMargin + f11 > scrollX) {
                f12 = f13;
                this.mMarginDrawable.setBounds(Math.round(f11), this.mTopPageBounds, Math.round(this.mPageMargin + f11), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                f12 = f13;
            }
            if (f11 > scrollX + r2) {
                return;
            }
            i13++;
            f13 = f12;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            r();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                b(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                q(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i11 = this.mActivePointerId;
            if (i11 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i11);
                float x11 = motionEvent.getX(findPointerIndex);
                float f11 = x11 - this.mLastMotionX;
                float abs = Math.abs(f11);
                float y11 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y11 - this.mInitialMotionY);
                if (f11 != 0.0f && !k(this.mLastMotionX, f11) && canScroll(this, false, (int) f11, (int) x11, (int) y11)) {
                    this.mLastMotionX = x11;
                    this.mLastMotionY = y11;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                int i12 = this.mTouchSlop;
                if (abs > i12 && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    q(true);
                    setScrollState(1);
                    float f12 = this.mInitialMotionX;
                    float f13 = this.mTouchSlop;
                    this.mLastMotionX = f11 > 0.0f ? f12 + f13 : f12 - f13;
                    this.mLastMotionY = y11;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i12) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && n(x11)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        e eVar;
        e eVar2;
        int i13;
        setMeasuredDimension(View.getDefaultSize(0, i11), View.getDefaultSize(0, i12));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            boolean z10 = true;
            int i15 = 1073741824;
            if (i14 >= childCount) {
                break;
            }
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8 && (eVar2 = (e) childAt.getLayoutParams()) != null && eVar2.f15351a) {
                int i16 = eVar2.f15352b;
                int i17 = i16 & 7;
                int i18 = i16 & 112;
                boolean z11 = i18 == 48 || i18 == 80;
                if (i17 != 3 && i17 != 5) {
                    z10 = false;
                }
                int i19 = Integer.MIN_VALUE;
                if (z11) {
                    i13 = Integer.MIN_VALUE;
                    i19 = 1073741824;
                } else {
                    i13 = z10 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i20 = ((ViewGroup.LayoutParams) eVar2).width;
                if (i20 != -2) {
                    if (i20 == -1) {
                        i20 = paddingLeft;
                    }
                    i19 = 1073741824;
                } else {
                    i20 = paddingLeft;
                }
                int i21 = ((ViewGroup.LayoutParams) eVar2).height;
                if (i21 == -2) {
                    i21 = measuredHeight;
                    i15 = i13;
                } else if (i21 == -1) {
                    i21 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i20, i19), View.MeasureSpec.makeMeasureSpec(i21, i15));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i14++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i22 = 0; i22 < childCount2; i22++) {
            View childAt2 = getChildAt(i22);
            if (childAt2.getVisibility() != 8 && ((eVar = (e) childAt2.getLayoutParams()) == null || !eVar.f15351a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * eVar.f15353c), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onPageScrolled(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.mDecorChildCount
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$e r8 = (androidx.viewpager.widget.ViewPager.e) r8
            boolean r9 = r8.f15351a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f15352b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.d(r12, r13, r14)
            r11.mCalledSuper = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i11, Rect rect) {
        int i12;
        int i13;
        int i14;
        d infoForChild;
        int childCount = getChildCount();
        if ((i11 & 2) != 0) {
            i13 = childCount;
            i12 = 0;
            i14 = 1;
        } else {
            i12 = childCount - 1;
            i13 = -1;
            i14 = -1;
        }
        while (i12 != i13) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f15347b == this.mCurItem && childAt.requestFocus(i11, rect)) {
                return true;
            }
            i12 += i14;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.adapterState = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            int i15 = this.mPageMargin;
            o(i11, i13, i15, i15);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z10 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z10 = r();
                    } else {
                        float x11 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x11 - this.mLastMotionX);
                        float y11 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y11 - this.mLastMotionY);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.mIsBeingDragged = true;
                            q(true);
                            float f11 = this.mInitialMotionX;
                            this.mLastMotionX = x11 - f11 > 0.0f ? f11 + this.mTouchSlop : f11 - this.mTouchSlop;
                            this.mLastMotionY = y11;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z10 = n(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    l(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                s(this.mCurItem, true, 0, false);
                z10 = r();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            d i11 = i();
            float f12 = clientWidth;
            setCurrentItemInternal(c(i11.f15347b, ((scrollX / f12) - i11.f15350e) / (i11.f15349d + (this.mPageMargin / f12)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z10 = r();
        }
        if (z10) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    boolean pageLeft() {
        int i11 = this.mCurItem;
        if (i11 <= 0) {
            return false;
        }
        setCurrentItem(i11 - 1, true);
        return true;
    }

    boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r9 == r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void populate(int r18) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    public void removeOnAdapterChangeListener(@NonNull g gVar) {
        List<g> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(gVar);
        }
    }

    public void removeOnPageChangeListener(@NonNull h hVar) {
        List<h> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(hVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i11 = 0; i11 < this.mItems.size(); i11++) {
                d dVar = this.mItems.get(i11);
                this.mAdapter.destroyItem((ViewGroup) this, dVar.f15347b, dVar.f15346a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            p();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new j();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z10 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z10) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<g> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i12 = 0; i12 < size; i12++) {
            this.mAdapterChangeListeners.get(i12).a(this, pagerAdapter3, pagerAdapter);
        }
    }

    public void setCurrentItem(int i11) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i11, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i11, boolean z10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i11, z10, false);
    }

    void setCurrentItemInternal(int i11, boolean z10, boolean z11) {
        setCurrentItemInternal(i11, z10, z11, 0);
    }

    void setCurrentItemInternal(int i11, boolean z10, boolean z11, int i12) {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z11 && this.mCurItem == i11 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 >= this.mAdapter.getCount()) {
            i11 = this.mAdapter.getCount() - 1;
        }
        int i13 = this.mOffscreenPageLimit;
        int i14 = this.mCurItem;
        if (i11 > i14 + i13 || i11 < i14 - i13) {
            for (int i15 = 0; i15 < this.mItems.size(); i15++) {
                this.mItems.get(i15).f15348c = true;
            }
        }
        boolean z12 = this.mCurItem != i11;
        if (!this.mFirstLayout) {
            populate(i11);
            s(i11, z10, i12, z12);
        } else {
            this.mCurItem = i11;
            if (z12) {
                e(i11);
            }
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h setInternalPageChangeListener(h hVar) {
        h hVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = hVar;
        return hVar2;
    }

    public void setOffscreenPageLimit(int i11) {
        if (i11 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i11 + " too small; defaulting to 1");
            i11 = 1;
        }
        if (i11 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i11;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(h hVar) {
        this.mOnPageChangeListener = hVar;
    }

    public void setPageMargin(int i11) {
        int i12 = this.mPageMargin;
        this.mPageMargin = i11;
        int width = getWidth();
        o(width, width, i11, i12);
        requestLayout();
    }

    public void setPageMarginDrawable(int i11) {
        setPageMarginDrawable(androidx.core.content.b.getDrawable(getContext(), i11));
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z10, @Nullable i iVar) {
        setPageTransformer(z10, iVar, 2);
    }

    public void setPageTransformer(boolean z10, @Nullable i iVar, int i11) {
        boolean z11 = iVar != null;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            this.mDrawingOrder = z10 ? 2 : 1;
            this.mPageTransformerLayerType = i11;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z11) {
            populate();
        }
    }

    void setScrollState(int i11) {
        if (this.mScrollState == i11) {
            return;
        }
        this.mScrollState = i11;
        f(i11);
    }

    void smoothScrollTo(int i11, int i12) {
        smoothScrollTo(i11, i12, 0);
    }

    void smoothScrollTo(int i11, int i12, int i13) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i14 = scrollX;
        int scrollY = getScrollY();
        int i15 = i11 - i14;
        int i16 = i12 - scrollY;
        if (i15 == 0 && i16 == 0) {
            b(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i17 = clientWidth / 2;
        float f11 = clientWidth;
        float f12 = i17;
        float distanceInfluenceForSnapDuration = f12 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i15) * 1.0f) / f11)) * f12);
        int abs = Math.abs(i13);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / abs) * 1000.0f) * 4 : (int) (((Math.abs(i15) / ((f11 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f), 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i14, scrollY, i15, i16, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }
}
