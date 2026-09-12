package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.t;
import androidx.recyclerview.widget.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled;
    static final z sDefaultEdgeEffectFactory;
    static final Interpolator sQuinticInterpolator;
    static boolean sVerboseLoggingEnabled;
    androidx.recyclerview.widget.o mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private h mChildDrawingOrderCallback;
    androidx.recyclerview.widget.e mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;

    @NonNull
    private i mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private q mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    j mItemAnimator;
    private j.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<l> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    m mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final v mObserver;
    private List<o> mOnChildAttachStateListeners;
    private p mOnFlingListener;
    private final ArrayList<q> mOnItemTouchListeners;
    final List<b0> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final t mRecycler;
    u mRecyclerListener;
    final List<u> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private r mScrollListener;
    private List<r> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final y mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final u.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.u mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    /* loaded from: classes.dex */
    public static abstract class Adapter {
        private final f mObservable = new f();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* loaded from: classes.dex */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(@NonNull b0 b0Var, int i11) {
            boolean z10 = b0Var.mBindingAdapter == null;
            if (z10) {
                b0Var.mPosition = i11;
                if (hasStableIds()) {
                    b0Var.mItemId = getItemId(i11);
                }
                b0Var.setFlags(1, 519);
                androidx.core.os.s.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            b0Var.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (b0Var.itemView.getParent() == null && ViewCompat.isAttachedToWindow(b0Var.itemView) != b0Var.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + b0Var.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(b0Var.itemView) + ", holder: " + b0Var);
                }
                if (b0Var.itemView.getParent() == null && ViewCompat.isAttachedToWindow(b0Var.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + b0Var);
                }
            }
            onBindViewHolder(b0Var, i11, b0Var.getUnmodifiedPayloads());
            if (z10) {
                b0Var.clearPayload();
                ViewGroup.LayoutParams layoutParams = b0Var.itemView.getLayoutParams();
                if (layoutParams instanceof n) {
                    ((n) layoutParams).mInsetsDirty = true;
                }
                androidx.core.os.s.b();
            }
        }

        boolean canRestoreState() {
            int i11 = e.f14312a[this.mStateRestorationPolicy.ordinal()];
            if (i11 != 1) {
                return i11 != 2 || getItemCount() > 0;
            }
            return false;
        }

        @NonNull
        public final b0 createViewHolder(@NonNull ViewGroup viewGroup, int i11) {
            try {
                androidx.core.os.s.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                b0 onCreateViewHolder = onCreateViewHolder(viewGroup, i11);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.mItemViewType = i11;
                return onCreateViewHolder;
            } finally {
                androidx.core.os.s.b();
            }
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter adapter, @NonNull b0 b0Var, int i11) {
            if (adapter == this) {
                return i11;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i11) {
            return -1L;
        }

        public int getItemViewType(int i11) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i11) {
            this.mObservable.d(i11, 1);
        }

        public final void notifyItemChanged(int i11, @Nullable Object obj) {
            this.mObservable.e(i11, 1, obj);
        }

        public final void notifyItemInserted(int i11) {
            this.mObservable.f(i11, 1);
        }

        public final void notifyItemMoved(int i11, int i12) {
            this.mObservable.c(i11, i12);
        }

        public final void notifyItemRangeChanged(int i11, int i12) {
            this.mObservable.d(i11, i12);
        }

        public final void notifyItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            this.mObservable.e(i11, i12, obj);
        }

        public final void notifyItemRangeInserted(int i11, int i12) {
            this.mObservable.f(i11, i12);
        }

        public final void notifyItemRangeRemoved(int i11, int i12) {
            this.mObservable.g(i11, i12);
        }

        public final void notifyItemRemoved(int i11) {
            this.mObservable.g(i11, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(b0 b0Var, int i11);

        public void onBindViewHolder(@NonNull b0 b0Var, int i11, @NonNull List<Object> list) {
            onBindViewHolder(b0Var, i11);
        }

        @NonNull
        public abstract b0 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull b0 b0Var) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull b0 b0Var) {
        }

        public void onViewDetachedFromWindow(@NonNull b0 b0Var) {
        }

        public void onViewRecycled(@NonNull b0 b0Var) {
        }

        public void registerAdapterDataObserver(@NonNull g gVar) {
            this.mObservable.registerObserver(gVar);
        }

        public void setHasStableIds(boolean z10) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z10;
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(@NonNull g gVar) {
            this.mObservable.unregisterObserver(gVar);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Parcelable mLayoutState;

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
            this.mLayoutState = parcel.readParcelable(classLoader == null ? m.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeParcelable(this.mLayoutState, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;

        ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int computeScrollDuration(int i11, int i12) {
            int abs = Math.abs(i11);
            int abs2 = Math.abs(i12);
            boolean z10 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                abs = abs2;
            }
            return Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i11, int i12) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.mOverScroller.fling(0, 0, i11, i12, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i11;
            int i12;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i13 = currX - this.mLastFlingX;
                int i14 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int consumeFlingInHorizontalStretch = RecyclerView.this.consumeFlingInHorizontalStretch(i13);
                int consumeFlingInVerticalStretch = RecyclerView.this.consumeFlingInVerticalStretch(i14);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    consumeFlingInHorizontalStretch -= iArr2[0];
                    consumeFlingInVerticalStretch -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i12 = iArr4[0];
                    i11 = iArr4[1];
                    consumeFlingInHorizontalStretch -= i12;
                    consumeFlingInVerticalStretch -= i11;
                    x xVar = recyclerView4.mLayout.mSmoothScroller;
                    if (xVar != null && !xVar.g() && xVar.h()) {
                        int b11 = RecyclerView.this.mState.b();
                        if (b11 == 0) {
                            xVar.r();
                        } else if (xVar.f() >= b11) {
                            xVar.p(b11 - 1);
                            xVar.j(i12, i11);
                        } else {
                            xVar.j(i12, i11);
                        }
                    }
                } else {
                    i11 = 0;
                    i12 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i12, i11, consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i15 = consumeFlingInHorizontalStretch - iArr6[0];
                int i16 = consumeFlingInVerticalStretch - iArr6[1];
                if (i12 != 0 || i11 != 0) {
                    recyclerView6.dispatchOnScrolled(i12, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i15 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i16 != 0));
                x xVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((xVar2 == null || !xVar2.g()) && z10) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i17 = i15 < 0 ? -currVelocity : i15 > 0 ? currVelocity : 0;
                        if (i16 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i16 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i17, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                } else {
                    postOnAnimation();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView7, i12, i11);
                    }
                }
            }
            x xVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (xVar3 != null && xVar3.g()) {
                xVar3.j(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i11, int i12, int i13, @Nullable Interpolator interpolator) {
            if (i13 == Integer.MIN_VALUE) {
                i13 = computeScrollDuration(i11, i12);
            }
            int i14 = i13;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i11, i12, i14);
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    /* loaded from: classes2.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a0 {
        public abstract View a(t tVar, int i11, int i12);
    }

    /* loaded from: classes2.dex */
    class b implements u.b {
        b() {
        }

        @Override // androidx.recyclerview.widget.u.b
        public void a(b0 b0Var, j.c cVar, j.c cVar2) {
            RecyclerView.this.animateAppearance(b0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.u.b
        public void b(b0 b0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.removeAndRecycleView(b0Var.itemView, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.u.b
        public void c(b0 b0Var, j.c cVar, j.c cVar2) {
            RecyclerView.this.mRecycler.O(b0Var);
            RecyclerView.this.animateDisappearance(b0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.u.b
        public void d(b0 b0Var, j.c cVar, j.c cVar2) {
            b0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.animateChange(b0Var, b0Var, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.animatePersistence(b0Var, cVar, cVar2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        Adapter mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        b0 mShadowedHolder = null;
        b0 mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        t mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public b0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void e() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                e();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i11) {
            this.mFlags = i11 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i11, int i12, boolean z10) {
            addFlags(8);
            offsetPosition(i12, z10);
            this.mPosition = i11;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i11 = this.mPreLayoutPosition;
            return i11 == -1 ? this.mPosition : i11;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i11 = this.mPreLayoutPosition;
            return i11 == -1 ? this.mPosition : i11;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        boolean hasAnyOfTheFlags(int i11) {
            return (i11 & this.mFlags) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i11, boolean z10) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z10) {
                this.mPreLayoutPosition += i11;
            }
            this.mPosition += i11;
            if (this.itemView.getLayoutParams() != null) {
                ((n) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i11 = this.mPendingAccessibilityState;
            if (i11 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i11;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            if (RecyclerView.sDebugAssertionsEnabled && isTmpDetached()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i11, int i12) {
            this.mFlags = (i11 & i12) | (this.mFlags & (~i12));
        }

        public final void setIsRecyclable(boolean z10) {
            int i11 = this.mIsRecyclableCount;
            int i12 = z10 ? i11 - 1 : i11 + 1;
            this.mIsRecyclableCount = i12;
            if (i12 < 0) {
                this.mIsRecyclableCount = 0;
                if (RecyclerView.sDebugAssertionsEnabled) {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z10 && i12 == 1) {
                this.mFlags |= 16;
            } else if (z10 && i12 == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setIsRecyclable val:");
                sb2.append(z10);
                sb2.append(":");
                sb2.append(this);
            }
        }

        void setScrapContainer(t tVar, boolean z10) {
            this.mScrapContainer = tVar;
            this.mInChangeScrap = z10;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        void unScrap() {
            this.mScrapContainer.O(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements e.b {
        c() {
        }

        @Override // androidx.recyclerview.widget.e.b
        public void a(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.b
        public b0 b(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void c(int i11) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("tmpDetach ");
                        sb2.append(childViewHolderInt);
                    }
                    childViewHolderInt.addFlags(256);
                }
            } else if (RecyclerView.sDebugAssertionsEnabled) {
                throw new IllegalArgumentException("No view at offset " + i11 + RecyclerView.this.exceptionLabel());
            }
            RecyclerView.this.detachViewFromParent(i11);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void d(View view, int i11) {
            RecyclerView.this.addView(view, i11);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void e() {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.e.b
        public int f(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void g(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.b
        public View getChildAt(int i11) {
            return RecyclerView.this.getChildAt(i11);
        }

        @Override // androidx.recyclerview.widget.e.b
        public int getChildCount() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.e.b
        public void h(int i11) {
            View childAt = RecyclerView.this.getChildAt(i11);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i11);
        }

        @Override // androidx.recyclerview.widget.e.b
        public void i(View view, int i11, ViewGroup.LayoutParams layoutParams) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("reAttach ");
                    sb2.append(childViewHolderInt);
                }
                childViewHolderInt.clearTmpDetachFlag();
            } else if (RecyclerView.sDebugAssertionsEnabled) {
                throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i11 + RecyclerView.this.exceptionLabel());
            }
            RecyclerView.this.attachViewToParent(view, i11, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements a.InterfaceC0119a {
        d() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void a(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForMove(i11, i12);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void c(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void d(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForRemove(i11, i12, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void e(int i11, int i12, Object obj) {
            RecyclerView.this.viewRangeUpdate(i11, i12, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public b0 f(int i11) {
            b0 findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i11, true);
            if (findViewHolderForPosition == null) {
                return null;
            }
            if (!RecyclerView.this.mChildHelper.n(findViewHolderForPosition.itemView)) {
                return findViewHolderForPosition;
            }
            int i12 = RecyclerView.HORIZONTAL;
            return null;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void g(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForInsert(i11, i12);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0119a
        public void h(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForRemove(i11, i12, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f14359d += i12;
        }

        void i(a.b bVar) {
            int i11 = bVar.f14426a;
            if (i11 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, bVar.f14427b, bVar.f14429d);
                return;
            }
            if (i11 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, bVar.f14427b, bVar.f14429d);
            } else if (i11 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, bVar.f14427b, bVar.f14429d, bVar.f14428c);
            } else {
                if (i11 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, bVar.f14427b, bVar.f14429d, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14312a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f14312a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14312a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f extends Observable {
        f() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void c(int i11, int i12) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i11, i12, 1);
            }
        }

        public void d(int i11, int i12) {
            e(i11, i12, null);
        }

        public void e(int i11, int i12, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i11, i12, obj);
            }
        }

        public void f(int i11, int i12) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i11, i12);
            }
        }

        public void g(int i11, int i12) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i11, i12);
            }
        }

        public void h() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class g {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i11, int i12) {
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            onItemRangeChanged(i11, i12);
        }

        public void onItemRangeInserted(int i11, int i12) {
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
        }

        public void onItemRangeRemoved(int i11, int i12) {
        }

        public void onStateRestorationPolicyChanged() {
        }
    }

    /* loaded from: classes2.dex */
    public interface h {
    }

    /* loaded from: classes2.dex */
    public static class i {
        protected EdgeEffect a(RecyclerView recyclerView, int i11) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class j {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private b mListener = null;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        /* loaded from: classes2.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface b {
            void a(b0 b0Var);
        }

        /* loaded from: classes2.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f14313a;

            /* renamed from: b, reason: collision with root package name */
            public int f14314b;

            /* renamed from: c, reason: collision with root package name */
            public int f14315c;

            /* renamed from: d, reason: collision with root package name */
            public int f14316d;

            public c a(b0 b0Var) {
                return b(b0Var, 0);
            }

            public c b(b0 b0Var, int i11) {
                View view = b0Var.itemView;
                this.f14313a = view.getLeft();
                this.f14314b = view.getTop();
                this.f14315c = view.getRight();
                this.f14316d = view.getBottom();
                return this;
            }
        }

        static int buildAdapterChangeFlagsForAnimations(b0 b0Var) {
            int i11 = b0Var.mFlags;
            int i12 = i11 & 14;
            if (b0Var.isInvalid()) {
                return 4;
            }
            if ((i11 & 4) != 0) {
                return i12;
            }
            int oldPosition = b0Var.getOldPosition();
            int absoluteAdapterPosition = b0Var.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i12 : i12 | 2048;
        }

        public abstract boolean animateAppearance(b0 b0Var, c cVar, c cVar2);

        public abstract boolean animateChange(b0 b0Var, b0 b0Var2, c cVar, c cVar2);

        public abstract boolean animateDisappearance(b0 b0Var, c cVar, c cVar2);

        public abstract boolean animatePersistence(b0 b0Var, c cVar, c cVar2);

        public boolean canReuseUpdatedViewHolder(b0 b0Var) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(b0 b0Var, List list) {
            return canReuseUpdatedViewHolder(b0Var);
        }

        public final void dispatchAnimationFinished(@NonNull b0 b0Var) {
            onAnimationFinished(b0Var);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.a(b0Var);
            }
        }

        public final void dispatchAnimationStarted(@NonNull b0 b0Var) {
            onAnimationStarted(b0Var);
        }

        public final void dispatchAnimationsFinished() {
            if (this.mFinishedListeners.size() <= 0) {
                this.mFinishedListeners.clear();
            } else {
                android.support.v4.media.session.c.a(this.mFinishedListeners.get(0));
                throw null;
            }
        }

        public abstract void endAnimation(b0 b0Var);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (isRunning) {
                    this.mFinishedListeners.add(aVar);
                } else {
                    aVar.a();
                }
            }
            return isRunning;
        }

        @NonNull
        public c obtainHolderInfo() {
            return new c();
        }

        public void onAnimationFinished(@NonNull b0 b0Var) {
        }

        public void onAnimationStarted(@NonNull b0 b0Var) {
        }

        @NonNull
        public c recordPostLayoutInformation(@NonNull y yVar, @NonNull b0 b0Var) {
            return obtainHolderInfo().a(b0Var);
        }

        @NonNull
        public c recordPreLayoutInformation(@NonNull y yVar, @NonNull b0 b0Var, int i11, @NonNull List<Object> list) {
            return obtainHolderInfo().a(b0Var);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j11) {
            this.mAddDuration = j11;
        }

        public void setChangeDuration(long j11) {
            this.mChangeDuration = j11;
        }

        void setListener(b bVar) {
            this.mListener = bVar;
        }

        public void setMoveDuration(long j11) {
            this.mMoveDuration = j11;
        }

        public void setRemoveDuration(long j11) {
            this.mRemoveDuration = j11;
        }
    }

    /* loaded from: classes2.dex */
    private class k implements j.b {
        k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j.b
        public void a(b0 b0Var) {
            b0Var.setIsRecyclable(true);
            if (b0Var.mShadowedHolder != null && b0Var.mShadowingHolder == null) {
                b0Var.mShadowedHolder = null;
            }
            b0Var.mShadowingHolder = null;
            if (b0Var.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(b0Var.itemView) || !b0Var.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(b0Var.itemView, false);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class l {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i11, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, y yVar) {
            getItemOffsets(rect, ((n) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, y yVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull y yVar) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class m {
        boolean mAutoMeasure;
        androidx.recyclerview.widget.e mChildHelper;
        private int mHeight;
        private int mHeightMode;
        androidx.recyclerview.widget.t mHorizontalBoundCheck;
        private final t.b mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        x mSmoothScroller;
        androidx.recyclerview.widget.t mVerticalBoundCheck;
        private final t.b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* loaded from: classes2.dex */
        class a implements t.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.t.b
            public int a(View view) {
                return m.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.t.b
            public int b() {
                return m.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int c() {
                return m.this.getWidth() - m.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int d(View view) {
                return m.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.t.b
            public View getChildAt(int i11) {
                return m.this.getChildAt(i11);
            }
        }

        /* loaded from: classes2.dex */
        class b implements t.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.t.b
            public int a(View view) {
                return m.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.t.b
            public int b() {
                return m.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int c() {
                return m.this.getHeight() - m.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.t.b
            public int d(View view) {
                return m.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.t.b
            public View getChildAt(int i11) {
                return m.this.getChildAt(i11);
            }
        }

        /* loaded from: classes2.dex */
        public interface c {
            void a(int i11, int i12);
        }

        /* loaded from: classes2.dex */
        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f14320a;

            /* renamed from: b, reason: collision with root package name */
            public int f14321b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f14322c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f14323d;
        }

        public m() {
            a aVar = new a();
            this.mHorizontalBoundCheckCallback = aVar;
            b bVar = new b();
            this.mVerticalBoundCheckCallback = bVar;
            this.mHorizontalBoundCheck = new androidx.recyclerview.widget.t(aVar);
            this.mVerticalBoundCheck = new androidx.recyclerview.widget.t(bVar);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        public static int chooseSize(int i11, int i12, int i13) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i12, i13) : size : Math.min(size, Math.max(i12, i13));
        }

        private void e(View view, int i11, boolean z10) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z10 || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            n nVar = (n) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.c(view, i11, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int m11 = this.mChildHelper.m(view);
                if (i11 == -1) {
                    i11 = this.mChildHelper.g();
                }
                if (m11 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (m11 != i11) {
                    this.mRecyclerView.mLayout.moveView(m11, i11);
                }
            } else {
                this.mChildHelper.a(view, i11, false);
                nVar.mInsetsDirty = true;
                x xVar = this.mSmoothScroller;
                if (xVar != null && xVar.h()) {
                    this.mSmoothScroller.k(view);
                }
            }
            if (nVar.mPendingInvalidate) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("consuming pending invalidate on child ");
                    sb2.append(nVar.mViewHolder);
                }
                childViewHolderInt.itemView.invalidate();
                nVar.mPendingInvalidate = false;
            }
        }

        private void f(int i11, View view) {
            this.mChildHelper.d(i11);
        }

        private int[] g(View view, Rect rect) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i11 = left - paddingLeft;
            int min = Math.min(0, i11);
            int i12 = top - paddingTop;
            int min2 = Math.min(0, i12);
            int i13 = width2 - width;
            int max = Math.max(0, i13);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i11, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i13);
            }
            if (min2 == 0) {
                min2 = Math.min(i12, max2);
            }
            return new int[]{max, min2};
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            if (r3 >= 0) goto L5;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L10
                if (r3 < 0) goto Le
            Lc:
                r2 = r0
                goto L1e
            Le:
                r3 = r2
                goto L1e
            L10:
                if (r3 < 0) goto L13
                goto Lc
            L13:
                r4 = -1
                if (r3 != r4) goto L18
                r3 = r1
                goto Lc
            L18:
                r4 = -2
                if (r3 != r4) goto Le
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m.getChildMeasureSpec(int, int, int, boolean):int");
        }

        public static d getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i11, i12);
            dVar.f14320a = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            dVar.f14321b = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            dVar.f14322c = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            dVar.f14323d = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        private boolean h(RecyclerView recyclerView, int i11, int i12) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i11 < width && rect.right - i11 > paddingLeft && rect.top - i12 < height && rect.bottom - i12 > paddingTop;
        }

        private static boolean i(int i11, int i12, int i13) {
            int mode = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            if (i13 > 0 && i11 != i13) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i11;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i11;
            }
            return true;
        }

        private void j(t tVar, int i11, View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ignoring view ");
                    sb2.append(childViewHolderInt);
                    return;
                }
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i11);
                tVar.H(childViewHolderInt);
            } else {
                detachViewAt(i11);
                tVar.I(view);
                this.mRecyclerView.mViewInfoStore.k(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i11) {
            e(view, i11, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i11) {
            e(view, i11, false);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        public void attachView(@NonNull View view, int i11) {
            attachView(view, i11, (n) view.getLayoutParams());
        }

        public void attachView(@NonNull View view, int i11, n nVar) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            this.mChildHelper.c(view, i11, nVar, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(n nVar) {
            return nVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i11, int i12, y yVar, c cVar) {
        }

        public void collectInitialPrefetchPositions(int i11, c cVar) {
        }

        public int computeHorizontalScrollExtent(y yVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(y yVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(y yVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(y yVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(y yVar) {
            return 0;
        }

        public int computeVerticalScrollRange(y yVar) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull t tVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                j(tVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull t tVar) {
            j(tVar, this.mChildHelper.m(view), view);
        }

        public void detachAndScrapViewAt(int i11, @NonNull t tVar) {
            j(tVar, i11, getChildAt(i11));
        }

        public void detachView(@NonNull View view) {
            int m11 = this.mChildHelper.m(view);
            if (m11 >= 0) {
                f(m11, view);
            }
        }

        public void detachViewAt(int i11) {
            f(i11, getChildAt(i11));
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, t tVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, tVar);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            j jVar = this.mRecyclerView.mItemAnimator;
            if (jVar != null) {
                jVar.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i11) {
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i11 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.e() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract n generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public n generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new n(context, attributeSet);
        }

        @SuppressLint({"UnknownNullness"})
        public n generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof n ? new n((n) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new n((ViewGroup.MarginLayoutParams) layoutParams) : new n(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int i11) {
            androidx.recyclerview.widget.e eVar = this.mChildHelper;
            if (eVar != null) {
                return eVar.f(i11);
            }
            return null;
        }

        public int getChildCount() {
            androidx.recyclerview.widget.e eVar = this.mChildHelper;
            if (eVar != null) {
                return eVar.g();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(@NonNull t tVar, @NonNull y yVar) {
            return -1;
        }

        public int getDecoratedBottom(@NonNull View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((n) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((n) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((n) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull t tVar, @NonNull y yVar) {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull t tVar, @NonNull y yVar) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((n) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z10, @NonNull Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((n) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i11).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.q(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull t tVar, @NonNull y yVar) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            x xVar = this.mSmoothScroller;
            return xVar != null && xVar.h();
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z10, boolean z11) {
            boolean z12 = this.mHorizontalBoundCheck.b(view, 24579) && this.mVerticalBoundCheck.b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public void layoutDecorated(@NonNull View view, int i11, int i12, int i13, int i14) {
            Rect rect = ((n) view.getLayoutParams()).mDecorInsets;
            view.layout(i11 + rect.left, i12 + rect.top, i13 - rect.right, i14 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i11, int i12, int i13, int i14) {
            n nVar = (n) view.getLayoutParams();
            Rect rect = nVar.mDecorInsets;
            view.layout(i11 + rect.left + ((ViewGroup.MarginLayoutParams) nVar).leftMargin, i12 + rect.top + ((ViewGroup.MarginLayoutParams) nVar).topMargin, (i13 - rect.right) - ((ViewGroup.MarginLayoutParams) nVar).rightMargin, (i14 - rect.bottom) - ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        public void measureChild(@NonNull View view, int i11, int i12) {
            n nVar = (n) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i13 = i11 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i14 = i12 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i13, ((ViewGroup.MarginLayoutParams) nVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i14, ((ViewGroup.MarginLayoutParams) nVar).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, nVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i11, int i12) {
            n nVar = (n) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i13 = i11 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i14 = i12 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin + i13, ((ViewGroup.MarginLayoutParams) nVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin + i14, ((ViewGroup.MarginLayoutParams) nVar).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, nVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i11, int i12) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                detachViewAt(i11);
                attachView(childAt, i12);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i11 + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int i11) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i11);
            }
        }

        public void offsetChildrenVertical(int i11) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i11);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i11, int i12) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, t tVar) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i11, t tVar, y yVar) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(@NonNull t tVar, @NonNull y yVar, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            Adapter adapter = this.mRecyclerView.mAdapter;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(t tVar, y yVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(tVar, yVar), getColumnCountForAccessibility(tVar, yVar), isLayoutHierarchical(tVar, yVar), getSelectionModeForAccessibility(tVar, yVar)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.n(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(t tVar, y yVar, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i11) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i11, int i12, int i13) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i11, int i12, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i11, i12);
        }

        public void onLayoutChildren(t tVar, y yVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(y yVar) {
        }

        public void onMeasure(@NonNull t tVar, @NonNull y yVar, int i11, int i12) {
            this.mRecyclerView.defaultOnMeasure(i11, i12);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull y yVar, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i11) {
        }

        void onSmoothScrollerStopped(x xVar) {
            if (this.mSmoothScroller == xVar) {
                this.mSmoothScroller = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i11, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i11, bundle);
        }

        public boolean performAccessibilityAction(t tVar, y yVar, int i11, Bundle bundle) {
            int paddingTop;
            int paddingLeft;
            int i12;
            int i13;
            if (this.mRecyclerView == null) {
                return false;
            }
            int height = getHeight();
            int width = getWidth();
            Rect rect = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() && this.mRecyclerView.getGlobalVisibleRect(rect)) {
                height = rect.height();
                width = rect.width();
            }
            if (i11 == 4096) {
                paddingTop = this.mRecyclerView.canScrollVertically(1) ? (height - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
                    i12 = paddingTop;
                    i13 = paddingLeft;
                }
                i12 = paddingTop;
                i13 = 0;
            } else if (i11 != 8192) {
                i13 = 0;
                i12 = 0;
            } else {
                paddingTop = this.mRecyclerView.canScrollVertically(-1) ? -((height - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    paddingLeft = -((width - getPaddingLeft()) - getPaddingRight());
                    i12 = paddingTop;
                    i13 = paddingLeft;
                }
                i12 = paddingTop;
                i13 = 0;
            }
            if (i12 == 0 && i13 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i13, i12, null, Integer.MIN_VALUE, true);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(@NonNull View view, int i11, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i11, bundle);
        }

        public boolean performAccessibilityActionForItem(@NonNull t tVar, @NonNull y yVar, @NonNull View view, int i11, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.q(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull t tVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, tVar);
                }
            }
        }

        void removeAndRecycleScrapInt(t tVar) {
            int j11 = tVar.j();
            for (int i11 = j11 - 1; i11 >= 0; i11--) {
                View n11 = tVar.n(i11);
                b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(n11);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(n11, false);
                    }
                    j jVar = this.mRecyclerView.mItemAnimator;
                    if (jVar != null) {
                        jVar.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    tVar.D(n11);
                }
            }
            tVar.e();
            if (j11 > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull t tVar) {
            removeView(view);
            tVar.G(view);
        }

        public void removeAndRecycleViewAt(int i11, @NonNull t tVar) {
            View childAt = getChildAt(i11);
            removeViewAt(i11);
            tVar.G(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            this.mChildHelper.p(view);
        }

        public void removeViewAt(int i11) {
            if (getChildAt(i11) != null) {
                this.mChildHelper.q(i11);
            }
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z10, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] g11 = g(view, rect);
            int i11 = g11[0];
            int i12 = g11[1];
            if ((z11 && !h(recyclerView, i11, i12)) || (i11 == 0 && i12 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i11, i12);
            } else {
                recyclerView.smoothScrollBy(i11, i12);
            }
            return true;
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i11, t tVar, y yVar) {
            return 0;
        }

        public void scrollToPosition(int i11) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        public int scrollVerticallyBy(int i11, t tVar, y yVar) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z10) {
            this.mAutoMeasure = z10;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z10) {
            if (z10 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z10;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.P();
                }
            }
        }

        void setMeasureSpecs(int i11, int i12) {
            this.mWidth = View.MeasureSpec.getSize(i11);
            int mode = View.MeasureSpec.getMode(i11);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i12);
            int mode2 = View.MeasureSpec.getMode(i12);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(int i11, int i12) {
            this.mRecyclerView.setMeasuredDimension(i11, i12);
        }

        public void setMeasuredDimension(Rect rect, int i11, int i12) {
            setMeasuredDimension(chooseSize(i11, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i12, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        void setMeasuredDimensionFromChildren(int i11, int i12) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i11, i12);
                return;
            }
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MIN_VALUE;
            int i16 = Integer.MAX_VALUE;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i18 = rect.left;
                if (i18 < i16) {
                    i16 = i18;
                }
                int i19 = rect.right;
                if (i19 > i13) {
                    i13 = i19;
                }
                int i20 = rect.top;
                if (i20 < i14) {
                    i14 = i20;
                }
                int i21 = rect.bottom;
                if (i21 > i15) {
                    i15 = i21;
                }
            }
            this.mRecyclerView.mTempRect.set(i16, i14, i13, i15);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i11, i12);
        }

        public void setMeasurementCacheEnabled(boolean z10) {
            this.mMeasurementCacheEnabled = z10;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i11, int i12, n nVar) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && i(view.getWidth(), i11, ((ViewGroup.MarginLayoutParams) nVar).width) && i(view.getHeight(), i12, ((ViewGroup.MarginLayoutParams) nVar).height)) ? false : true;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i11, int i12, n nVar) {
            return (this.mMeasurementCacheEnabled && i(view.getMeasuredWidth(), i11, ((ViewGroup.MarginLayoutParams) nVar).width) && i(view.getMeasuredHeight(), i12, ((ViewGroup.MarginLayoutParams) nVar).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, y yVar, int i11) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(x xVar) {
            x xVar2 = this.mSmoothScroller;
            if (xVar2 != null && xVar != xVar2 && xVar2.h()) {
                this.mSmoothScroller.r();
            }
            this.mSmoothScroller = xVar;
            xVar.q(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        void stopSmoothScroller() {
            x xVar = this.mSmoothScroller;
            if (xVar != null) {
                xVar.r();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class n extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        b0 mViewHolder;

        public n(int i11, int i12) {
            super(i11, i12);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public n(n nVar) {
            super((ViewGroup.LayoutParams) nVar);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }
    }

    /* loaded from: classes2.dex */
    public interface o {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* loaded from: classes2.dex */
    public static abstract class p {
        public abstract boolean onFling(int i11, int i12);
    }

    /* loaded from: classes2.dex */
    public interface q {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z10);
    }

    /* loaded from: classes2.dex */
    public static abstract class r {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i11) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i11, int i12) {
        }
    }

    /* loaded from: classes2.dex */
    public static class s {

        /* renamed from: a, reason: collision with root package name */
        SparseArray f14324a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        int f14325b = 0;

        /* renamed from: c, reason: collision with root package name */
        Set f14326c = Collections.newSetFromMap(new IdentityHashMap());

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList f14327a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            int f14328b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f14329c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f14330d = 0;

            a() {
            }
        }

        private a i(int i11) {
            a aVar = (a) this.f14324a.get(i11);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f14324a.put(i11, aVar2);
            return aVar2;
        }

        void a() {
            this.f14325b++;
        }

        void b(Adapter adapter) {
            this.f14326c.add(adapter);
        }

        public void c() {
            for (int i11 = 0; i11 < this.f14324a.size(); i11++) {
                a aVar = (a) this.f14324a.valueAt(i11);
                Iterator it = aVar.f14327a.iterator();
                while (it.hasNext()) {
                    h1.a.b(((b0) it.next()).itemView);
                }
                aVar.f14327a.clear();
            }
        }

        void d() {
            this.f14325b--;
        }

        void e(Adapter adapter, boolean z10) {
            this.f14326c.remove(adapter);
            if (this.f14326c.size() != 0 || z10) {
                return;
            }
            for (int i11 = 0; i11 < this.f14324a.size(); i11++) {
                SparseArray sparseArray = this.f14324a;
                ArrayList arrayList = ((a) sparseArray.get(sparseArray.keyAt(i11))).f14327a;
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    h1.a.b(((b0) arrayList.get(i12)).itemView);
                }
            }
        }

        void f(int i11, long j11) {
            a i12 = i(i11);
            i12.f14330d = l(i12.f14330d, j11);
        }

        void g(int i11, long j11) {
            a i12 = i(i11);
            i12.f14329c = l(i12.f14329c, j11);
        }

        public b0 h(int i11) {
            a aVar = (a) this.f14324a.get(i11);
            if (aVar == null || aVar.f14327a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f14327a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((b0) arrayList.get(size)).isAttachedToTransitionOverlay()) {
                    return (b0) arrayList.remove(size);
                }
            }
            return null;
        }

        void j(Adapter adapter, Adapter adapter2, boolean z10) {
            if (adapter != null) {
                d();
            }
            if (!z10 && this.f14325b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void k(b0 b0Var) {
            int itemViewType = b0Var.getItemViewType();
            ArrayList arrayList = i(itemViewType).f14327a;
            if (((a) this.f14324a.get(itemViewType)).f14328b <= arrayList.size()) {
                h1.a.b(b0Var.itemView);
            } else {
                if (RecyclerView.sDebugAssertionsEnabled && arrayList.contains(b0Var)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                b0Var.resetInternal();
                arrayList.add(b0Var);
            }
        }

        long l(long j11, long j12) {
            return j11 == 0 ? j12 : ((j11 / 4) * 3) + (j12 / 4);
        }

        public void m(int i11, int i12) {
            a i13 = i(i11);
            i13.f14328b = i12;
            ArrayList arrayList = i13.f14327a;
            while (arrayList.size() > i12) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        boolean n(int i11, long j11, long j12) {
            long j13 = i(i11).f14330d;
            return j13 == 0 || j11 + j13 < j12;
        }

        boolean o(int i11, long j11, long j12) {
            long j13 = i(i11).f14329c;
            return j13 == 0 || j11 + j13 < j12;
        }
    }

    /* loaded from: classes2.dex */
    public final class t {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList f14331a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f14332b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList f14333c;

        /* renamed from: d, reason: collision with root package name */
        private final List f14334d;

        /* renamed from: e, reason: collision with root package name */
        private int f14335e;

        /* renamed from: f, reason: collision with root package name */
        int f14336f;

        /* renamed from: g, reason: collision with root package name */
        s f14337g;

        /* renamed from: h, reason: collision with root package name */
        private a0 f14338h;

        public t() {
            ArrayList arrayList = new ArrayList();
            this.f14331a = arrayList;
            this.f14332b = null;
            this.f14333c = new ArrayList();
            this.f14334d = Collections.unmodifiableList(arrayList);
            this.f14335e = 2;
            this.f14336f = 2;
        }

        private void B(Adapter adapter) {
            C(adapter, false);
        }

        private void C(Adapter adapter, boolean z10) {
            s sVar = this.f14337g;
            if (sVar != null) {
                sVar.e(adapter, z10);
            }
        }

        private boolean M(b0 b0Var, int i11, int i12, long j11) {
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = b0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z10 = false;
            if (j11 != Long.MAX_VALUE && !this.f14337g.n(itemViewType, nanoTime, j11)) {
                return false;
            }
            if (b0Var.isTmpDetached()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(b0Var.itemView, recyclerView.getChildCount(), b0Var.itemView.getLayoutParams());
                z10 = true;
            }
            RecyclerView.this.mAdapter.bindViewHolder(b0Var, i11);
            if (z10) {
                RecyclerView.this.detachViewFromParent(b0Var.itemView);
            }
            this.f14337g.f(b0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(b0Var);
            if (RecyclerView.this.mState.e()) {
                b0Var.mPreLayoutPosition = i12;
            }
            return true;
        }

        private void b(b0 b0Var) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = b0Var.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                androidx.recyclerview.widget.o oVar = RecyclerView.this.mAccessibilityDelegate;
                if (oVar == null) {
                    return;
                }
                AccessibilityDelegateCompat a11 = oVar.a();
                if (a11 instanceof o.a) {
                    ((o.a) a11).b(view);
                }
                ViewCompat.setAccessibilityDelegate(view, a11);
            }
        }

        private void q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(b0 b0Var) {
            View view = b0Var.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        private void u() {
            if (this.f14337g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                this.f14337g.b(RecyclerView.this.mAdapter);
            }
        }

        void A() {
            for (int i11 = 0; i11 < this.f14333c.size(); i11++) {
                h1.a.b(((b0) this.f14333c.get(i11)).itemView);
            }
            B(RecyclerView.this.mAdapter);
        }

        void D(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            H(childViewHolderInt);
        }

        void E() {
            for (int size = this.f14333c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.f14333c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }

        void F(int i11) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Recycling cached view at index ");
                sb2.append(i11);
            }
            b0 b0Var = (b0) this.f14333c.get(i11);
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CachedViewHolder to be recycled: ");
                sb3.append(b0Var);
            }
            a(b0Var, true);
            this.f14333c.remove(i11);
        }

        public void G(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            H(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
        }

        void H(b0 b0Var) {
            boolean z10;
            boolean z11 = true;
            if (b0Var.isScrap() || b0Var.itemView.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(b0Var.isScrap());
                sb2.append(" isAttached:");
                sb2.append(b0Var.itemView.getParent() != null);
                sb2.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (b0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + b0Var + RecyclerView.this.exceptionLabel());
            }
            if (b0Var.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean doesTransientStatePreventRecycling = b0Var.doesTransientStatePreventRecycling();
            Adapter adapter = RecyclerView.this.mAdapter;
            boolean z12 = adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(b0Var);
            if (RecyclerView.sDebugAssertionsEnabled && this.f14333c.contains(b0Var)) {
                throw new IllegalArgumentException("cached view received recycle internal? " + b0Var + RecyclerView.this.exceptionLabel());
            }
            if (z12 || b0Var.isRecyclable()) {
                if (this.f14336f <= 0 || b0Var.hasAnyOfTheFlags(526)) {
                    z10 = false;
                } else {
                    int size = this.f14333c.size();
                    if (size >= this.f14336f && size > 0) {
                        F(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(b0Var.mPosition)) {
                        int i11 = size - 1;
                        while (i11 >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.d(((b0) this.f14333c.get(i11)).mPosition)) {
                                break;
                            } else {
                                i11--;
                            }
                        }
                        size = i11 + 1;
                    }
                    this.f14333c.add(size, b0Var);
                    z10 = true;
                }
                if (z10) {
                    z11 = false;
                } else {
                    a(b0Var, true);
                }
                r1 = z10;
            } else {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists");
                    sb3.append(RecyclerView.this.exceptionLabel());
                }
                z11 = false;
            }
            RecyclerView.this.mViewInfoStore.q(b0Var);
            if (r1 || z11 || !doesTransientStatePreventRecycling) {
                return;
            }
            h1.a.b(b0Var.itemView);
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = null;
        }

        void I(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f14332b == null) {
                    this.f14332b = new ArrayList();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f14332b.add(childViewHolderInt);
                return;
            }
            if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f14331a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        void J(s sVar) {
            B(RecyclerView.this.mAdapter);
            s sVar2 = this.f14337g;
            if (sVar2 != null) {
                sVar2.d();
            }
            this.f14337g = sVar;
            if (sVar != null && RecyclerView.this.getAdapter() != null) {
                this.f14337g.a();
            }
            u();
        }

        void K(a0 a0Var) {
            this.f14338h = a0Var;
        }

        public void L(int i11) {
            this.f14335e = i11;
            P();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:101:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0200  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x019e  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01de  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0242  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x026c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0250  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.b0 N(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 683
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.t.N(int, boolean, long):androidx.recyclerview.widget.RecyclerView$b0");
        }

        void O(b0 b0Var) {
            if (b0Var.mInChangeScrap) {
                this.f14332b.remove(b0Var);
            } else {
                this.f14331a.remove(b0Var);
            }
            b0Var.mScrapContainer = null;
            b0Var.mInChangeScrap = false;
            b0Var.clearReturnedFromScrapFlag();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void P() {
            m mVar = RecyclerView.this.mLayout;
            this.f14336f = this.f14335e + (mVar != null ? mVar.mPrefetchMaxCountObserved : 0);
            for (int size = this.f14333c.size() - 1; size >= 0 && this.f14333c.size() > this.f14336f; size--) {
                F(size);
            }
        }

        boolean Q(b0 b0Var) {
            if (b0Var.isRemoved()) {
                if (!RecyclerView.sDebugAssertionsEnabled || RecyclerView.this.mState.e()) {
                    return RecyclerView.this.mState.e();
                }
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.exceptionLabel());
            }
            int i11 = b0Var.mPosition;
            if (i11 >= 0 && i11 < RecyclerView.this.mAdapter.getItemCount()) {
                if (RecyclerView.this.mState.e() || RecyclerView.this.mAdapter.getItemViewType(b0Var.mPosition) == b0Var.getItemViewType()) {
                    return !RecyclerView.this.mAdapter.hasStableIds() || b0Var.getItemId() == RecyclerView.this.mAdapter.getItemId(b0Var.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + b0Var + RecyclerView.this.exceptionLabel());
        }

        void R(int i11, int i12) {
            int i13;
            int i14 = i12 + i11;
            for (int size = this.f14333c.size() - 1; size >= 0; size--) {
                b0 b0Var = (b0) this.f14333c.get(size);
                if (b0Var != null && (i13 = b0Var.mPosition) >= i11 && i13 < i14) {
                    b0Var.addFlags(2);
                    F(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(b0 b0Var, boolean z10) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(b0Var);
            View view = b0Var.itemView;
            androidx.recyclerview.widget.o oVar = RecyclerView.this.mAccessibilityDelegate;
            if (oVar != null) {
                AccessibilityDelegateCompat a11 = oVar.a();
                ViewCompat.setAccessibilityDelegate(view, a11 instanceof o.a ? ((o.a) a11).a(view) : null);
            }
            if (z10) {
                g(b0Var);
            }
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = null;
            i().k(b0Var);
        }

        public void c() {
            this.f14331a.clear();
            E();
        }

        void d() {
            int size = this.f14333c.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((b0) this.f14333c.get(i11)).clearOldPosition();
            }
            int size2 = this.f14331a.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((b0) this.f14331a.get(i12)).clearOldPosition();
            }
            ArrayList arrayList = this.f14332b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    ((b0) this.f14332b.get(i13)).clearOldPosition();
                }
            }
        }

        void e() {
            this.f14331a.clear();
            ArrayList arrayList = this.f14332b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i11) {
            if (i11 >= 0 && i11 < RecyclerView.this.mState.b()) {
                return !RecyclerView.this.mState.e() ? i11 : RecyclerView.this.mAdapterHelper.m(i11);
            }
            throw new IndexOutOfBoundsException("invalid position " + i11 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
        }

        void g(b0 b0Var) {
            RecyclerView.this.getClass();
            if (RecyclerView.this.mRecyclerListeners.size() > 0) {
                android.support.v4.media.session.c.a(RecyclerView.this.mRecyclerListeners.get(0));
                throw null;
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(b0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(b0Var);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("dispatchViewRecycled: ");
                sb2.append(b0Var);
            }
        }

        b0 h(int i11) {
            int size;
            int m11;
            ArrayList arrayList = this.f14332b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    b0 b0Var = (b0) this.f14332b.get(i12);
                    if (!b0Var.wasReturnedFromScrap() && b0Var.getLayoutPosition() == i11) {
                        b0Var.addFlags(32);
                        return b0Var;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (m11 = RecyclerView.this.mAdapterHelper.m(i11)) > 0 && m11 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(m11);
                    for (int i13 = 0; i13 < size; i13++) {
                        b0 b0Var2 = (b0) this.f14332b.get(i13);
                        if (!b0Var2.wasReturnedFromScrap() && b0Var2.getItemId() == itemId) {
                            b0Var2.addFlags(32);
                            return b0Var2;
                        }
                    }
                }
            }
            return null;
        }

        s i() {
            if (this.f14337g == null) {
                this.f14337g = new s();
                u();
            }
            return this.f14337g;
        }

        int j() {
            return this.f14331a.size();
        }

        public List k() {
            return this.f14334d;
        }

        b0 l(long j11, int i11, boolean z10) {
            for (int size = this.f14331a.size() - 1; size >= 0; size--) {
                b0 b0Var = (b0) this.f14331a.get(size);
                if (b0Var.getItemId() == j11 && !b0Var.wasReturnedFromScrap()) {
                    if (i11 == b0Var.getItemViewType()) {
                        b0Var.addFlags(32);
                        if (b0Var.isRemoved() && !RecyclerView.this.mState.e()) {
                            b0Var.setFlags(2, 14);
                        }
                        return b0Var;
                    }
                    if (!z10) {
                        this.f14331a.remove(size);
                        RecyclerView.this.removeDetachedView(b0Var.itemView, false);
                        D(b0Var.itemView);
                    }
                }
            }
            int size2 = this.f14333c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                b0 b0Var2 = (b0) this.f14333c.get(size2);
                if (b0Var2.getItemId() == j11 && !b0Var2.isAttachedToTransitionOverlay()) {
                    if (i11 == b0Var2.getItemViewType()) {
                        if (!z10) {
                            this.f14333c.remove(size2);
                        }
                        return b0Var2;
                    }
                    if (!z10) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        b0 m(int i11, boolean z10) {
            View e11;
            int size = this.f14331a.size();
            for (int i12 = 0; i12 < size; i12++) {
                b0 b0Var = (b0) this.f14331a.get(i12);
                if (!b0Var.wasReturnedFromScrap() && b0Var.getLayoutPosition() == i11 && !b0Var.isInvalid() && (RecyclerView.this.mState.f14363h || !b0Var.isRemoved())) {
                    b0Var.addFlags(32);
                    return b0Var;
                }
            }
            if (!z10 && (e11 = RecyclerView.this.mChildHelper.e(i11)) != null) {
                b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(e11);
                RecyclerView.this.mChildHelper.s(e11);
                int m11 = RecyclerView.this.mChildHelper.m(e11);
                if (m11 != -1) {
                    RecyclerView.this.mChildHelper.d(m11);
                    I(e11);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.f14333c.size();
            for (int i13 = 0; i13 < size2; i13++) {
                b0 b0Var2 = (b0) this.f14333c.get(i13);
                if (!b0Var2.isInvalid() && b0Var2.getLayoutPosition() == i11 && !b0Var2.isAttachedToTransitionOverlay()) {
                    if (!z10) {
                        this.f14333c.remove(i13);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("getScrapOrHiddenOrCachedHolderForPosition(");
                        sb2.append(i11);
                        sb2.append(") found match in cache: ");
                        sb2.append(b0Var2);
                    }
                    return b0Var2;
                }
            }
            return null;
        }

        View n(int i11) {
            return ((b0) this.f14331a.get(i11)).itemView;
        }

        public View o(int i11) {
            return p(i11, false);
        }

        View p(int i11, boolean z10) {
            return N(i11, z10, Long.MAX_VALUE).itemView;
        }

        void s() {
            int size = this.f14333c.size();
            for (int i11 = 0; i11 < size; i11++) {
                n nVar = (n) ((b0) this.f14333c.get(i11)).itemView.getLayoutParams();
                if (nVar != null) {
                    nVar.mInsetsDirty = true;
                }
            }
        }

        void t() {
            int size = this.f14333c.size();
            for (int i11 = 0; i11 < size; i11++) {
                b0 b0Var = (b0) this.f14333c.get(i11);
                if (b0Var != null) {
                    b0Var.addFlags(6);
                    b0Var.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                E();
            }
        }

        void v(int i11, int i12) {
            int size = this.f14333c.size();
            for (int i13 = 0; i13 < size; i13++) {
                b0 b0Var = (b0) this.f14333c.get(i13);
                if (b0Var != null && b0Var.mPosition >= i11) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("offsetPositionRecordsForInsert cached ");
                        sb2.append(i13);
                        sb2.append(" holder ");
                        sb2.append(b0Var);
                        sb2.append(" now at position ");
                        sb2.append(b0Var.mPosition + i12);
                    }
                    b0Var.offsetPosition(i12, false);
                }
            }
        }

        void w(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int i16;
            if (i11 < i12) {
                i13 = -1;
                i15 = i11;
                i14 = i12;
            } else {
                i13 = 1;
                i14 = i11;
                i15 = i12;
            }
            int size = this.f14333c.size();
            for (int i17 = 0; i17 < size; i17++) {
                b0 b0Var = (b0) this.f14333c.get(i17);
                if (b0Var != null && (i16 = b0Var.mPosition) >= i15 && i16 <= i14) {
                    if (i16 == i11) {
                        b0Var.offsetPosition(i12 - i11, false);
                    } else {
                        b0Var.offsetPosition(i13, false);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("offsetPositionRecordsForMove cached child ");
                        sb2.append(i17);
                        sb2.append(" holder ");
                        sb2.append(b0Var);
                    }
                }
            }
        }

        void x(int i11, int i12, boolean z10) {
            int i13 = i11 + i12;
            for (int size = this.f14333c.size() - 1; size >= 0; size--) {
                b0 b0Var = (b0) this.f14333c.get(size);
                if (b0Var != null) {
                    int i14 = b0Var.mPosition;
                    if (i14 >= i13) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("offsetPositionRecordsForRemove cached ");
                            sb2.append(size);
                            sb2.append(" holder ");
                            sb2.append(b0Var);
                            sb2.append(" now at position ");
                            sb2.append(b0Var.mPosition - i12);
                        }
                        b0Var.offsetPosition(-i12, z10);
                    } else if (i14 >= i11) {
                        b0Var.addFlags(8);
                        F(size);
                    }
                }
            }
        }

        void y(Adapter adapter, Adapter adapter2, boolean z10) {
            c();
            C(adapter, true);
            i().j(adapter, adapter2, z10);
            u();
        }

        void z() {
            u();
        }
    }

    /* loaded from: classes2.dex */
    public interface u {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class v extends g {
        v() {
        }

        void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f14362g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeChanged(int i11, int i12, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.r(i11, i12, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeInserted(int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.s(i11, i12)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeMoved(int i11, int i12, int i13) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.t(i11, i12, i13)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onItemRangeRemoved(int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.u(i11, i12)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState == null || (adapter = recyclerView.mAdapter) == null || !adapter.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static class w implements q {
        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void c(boolean z10) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class x {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f14342b;

        /* renamed from: c, reason: collision with root package name */
        private m f14343c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f14344d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f14345e;

        /* renamed from: f, reason: collision with root package name */
        private View f14346f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f14348h;

        /* renamed from: a, reason: collision with root package name */
        private int f14341a = -1;

        /* renamed from: g, reason: collision with root package name */
        private final a f14347g = new a(0, 0);

        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f14349a;

            /* renamed from: b, reason: collision with root package name */
            private int f14350b;

            /* renamed from: c, reason: collision with root package name */
            private int f14351c;

            /* renamed from: d, reason: collision with root package name */
            private int f14352d;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f14353e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f14354f;

            /* renamed from: g, reason: collision with root package name */
            private int f14355g;

            public a(int i11, int i12) {
                this(i11, i12, Integer.MIN_VALUE, null);
            }

            public a(int i11, int i12, int i13, Interpolator interpolator) {
                this.f14352d = -1;
                this.f14354f = false;
                this.f14355g = 0;
                this.f14349a = i11;
                this.f14350b = i12;
                this.f14351c = i13;
                this.f14353e = interpolator;
            }

            private void e() {
                if (this.f14353e != null && this.f14351c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f14351c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f14352d >= 0;
            }

            public void b(int i11) {
                this.f14352d = i11;
            }

            void c(RecyclerView recyclerView) {
                int i11 = this.f14352d;
                if (i11 >= 0) {
                    this.f14352d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i11);
                    this.f14354f = false;
                } else {
                    if (!this.f14354f) {
                        this.f14355g = 0;
                        return;
                    }
                    e();
                    recyclerView.mViewFlinger.smoothScrollBy(this.f14349a, this.f14350b, this.f14351c, this.f14353e);
                    int i12 = this.f14355g + 1;
                    this.f14355g = i12;
                    if (i12 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f14354f = false;
                }
            }

            public void d(int i11, int i12, int i13, Interpolator interpolator) {
                this.f14349a = i11;
                this.f14350b = i12;
                this.f14351c = i13;
                this.f14353e = interpolator;
                this.f14354f = true;
            }
        }

        /* loaded from: classes2.dex */
        public interface b {
            PointF computeScrollVectorForPosition(int i11);
        }

        public PointF a(int i11) {
            Object e11 = e();
            if (e11 instanceof b) {
                return ((b) e11).computeScrollVectorForPosition(i11);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i11) {
            return this.f14342b.mLayout.findViewByPosition(i11);
        }

        public int c() {
            return this.f14342b.mLayout.getChildCount();
        }

        public int d(View view) {
            return this.f14342b.getChildLayoutPosition(view);
        }

        public m e() {
            return this.f14343c;
        }

        public int f() {
            return this.f14341a;
        }

        public boolean g() {
            return this.f14344d;
        }

        public boolean h() {
            return this.f14345e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f11 = pointF.x;
            float f12 = pointF.y;
            float sqrt = (float) Math.sqrt((f11 * f11) + (f12 * f12));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i11, int i12) {
            PointF a11;
            RecyclerView recyclerView = this.f14342b;
            if (this.f14341a == -1 || recyclerView == null) {
                r();
            }
            if (this.f14344d && this.f14346f == null && this.f14343c != null && (a11 = a(this.f14341a)) != null) {
                float f11 = a11.x;
                if (f11 != 0.0f || a11.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f11), (int) Math.signum(a11.y), null);
                }
            }
            this.f14344d = false;
            View view = this.f14346f;
            if (view != null) {
                if (d(view) == this.f14341a) {
                    o(this.f14346f, recyclerView.mState, this.f14347g);
                    this.f14347g.c(recyclerView);
                    r();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f14346f = null;
                }
            }
            if (this.f14345e) {
                l(i11, i12, recyclerView.mState, this.f14347g);
                boolean a12 = this.f14347g.a();
                this.f14347g.c(recyclerView);
                if (a12 && this.f14345e) {
                    this.f14344d = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f14346f = view;
                int i11 = RecyclerView.HORIZONTAL;
            }
        }

        protected abstract void l(int i11, int i12, y yVar, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, y yVar, a aVar);

        public void p(int i11) {
            this.f14341a = i11;
        }

        void q(RecyclerView recyclerView, m mVar) {
            recyclerView.mViewFlinger.stop();
            if (this.f14348h) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f14342b = recyclerView;
            this.f14343c = mVar;
            int i11 = this.f14341a;
            if (i11 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f14356a = i11;
            this.f14345e = true;
            this.f14344d = true;
            this.f14346f = b(f());
            m();
            this.f14342b.mViewFlinger.postOnAnimation();
            this.f14348h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f14345e) {
                this.f14345e = false;
                n();
                this.f14342b.mState.f14356a = -1;
                this.f14346f = null;
                this.f14341a = -1;
                this.f14344d = false;
                this.f14343c.onSmoothScrollerStopped(this);
                this.f14343c = null;
                this.f14342b = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class y {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray f14357b;

        /* renamed from: m, reason: collision with root package name */
        int f14368m;

        /* renamed from: n, reason: collision with root package name */
        long f14369n;

        /* renamed from: o, reason: collision with root package name */
        int f14370o;

        /* renamed from: p, reason: collision with root package name */
        int f14371p;

        /* renamed from: q, reason: collision with root package name */
        int f14372q;

        /* renamed from: a, reason: collision with root package name */
        int f14356a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f14358c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f14359d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f14360e = 1;

        /* renamed from: f, reason: collision with root package name */
        int f14361f = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f14362g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f14363h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f14364i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f14365j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f14366k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f14367l = false;

        void a(int i11) {
            if ((this.f14360e & i11) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i11) + " but it is " + Integer.toBinaryString(this.f14360e));
        }

        public int b() {
            return this.f14363h ? this.f14358c - this.f14359d : this.f14361f;
        }

        public int c() {
            return this.f14356a;
        }

        public boolean d() {
            return this.f14356a != -1;
        }

        public boolean e() {
            return this.f14363h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(Adapter adapter) {
            this.f14360e = 1;
            this.f14361f = adapter.getItemCount();
            this.f14363h = false;
            this.f14364i = false;
            this.f14365j = false;
        }

        public boolean g() {
            return this.f14367l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f14356a + ", mData=" + this.f14357b + ", mItemCount=" + this.f14361f + ", mIsMeasuring=" + this.f14365j + ", mPreviousLayoutItemCount=" + this.f14358c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f14359d + ", mStructureChanged=" + this.f14362g + ", mInPreLayout=" + this.f14363h + ", mRunSimpleAnimations=" + this.f14366k + ", mRunPredictiveAnimations=" + this.f14367l + '}';
        }
    }

    /* loaded from: classes2.dex */
    static class z extends i {
        z() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        protected EdgeEffect a(RecyclerView recyclerView, int i11) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new a();
        sDefaultEdgeEffectFactory = new z();
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mObserver = new v();
        this.mRecycler = new t();
        this.mViewInfoStore = new androidx.recyclerview.widget.u();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.mIsAttached) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.mLayoutSuppressed) {
                    recyclerView2.mLayoutWasDefered = true;
                } else {
                    recyclerView2.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.a() : null;
        this.mState = new y();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new k();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                j jVar = RecyclerView.this.mItemAnimator;
                if (jVar != null) {
                    jVar.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new b();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.o(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i11, 0);
        String string = obtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z10 = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z10;
        if (z10) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i11, 0);
        int[] iArr = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes2, i11, 0);
        boolean z11 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z11);
        h1.a.h(this, true);
    }

    private void addAnimatingView(b0 b0Var) {
        View view = b0Var.itemView;
        boolean z10 = view.getParent() == this;
        this.mRecycler.O(getChildViewHolder(view));
        if (b0Var.isTmpDetached()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
        } else if (z10) {
            this.mChildHelper.k(view);
        } else {
            this.mChildHelper.b(view, true);
        }
    }

    private void animateChange(@NonNull b0 b0Var, @NonNull b0 b0Var2, @NonNull j.c cVar, @NonNull j.c cVar2, boolean z10, boolean z11) {
        b0Var.setIsRecyclable(false);
        if (z10) {
            addAnimatingView(b0Var);
        }
        if (b0Var != b0Var2) {
            if (z11) {
                addAnimatingView(b0Var2);
            }
            b0Var.mShadowedHolder = b0Var2;
            addAnimatingView(b0Var);
            this.mRecycler.O(b0Var);
            b0Var2.setIsRecyclable(false);
            b0Var2.mShadowingHolder = b0Var;
        }
        if (this.mItemAnimator.animateChange(b0Var, b0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(@NonNull b0 b0Var) {
        WeakReference<RecyclerView> weakReference = b0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == b0Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            b0Var.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i11, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i12) {
        if (i11 > 0 && edgeEffect != null && androidx.core.widget.h.b(edgeEffect) != 0.0f) {
            int round = Math.round(((-i12) / FLING_DESTRETCH_FACTOR) * androidx.core.widget.h.d(edgeEffect, ((-i11) * FLING_DESTRETCH_FACTOR) / i12, 0.5f));
            if (round != i11) {
                edgeEffect.finish();
            }
            return i11 - round;
        }
        if (i11 >= 0 || edgeEffect2 == null || androidx.core.widget.h.b(edgeEffect2) == 0.0f) {
            return i11;
        }
        float f11 = i12;
        int round2 = Math.round((f11 / FLING_DESTRETCH_FACTOR) * androidx.core.widget.h.d(edgeEffect2, (i11 * FLING_DESTRETCH_FACTOR) / f11, 0.5f));
        if (round2 != i11) {
            edgeEffect2.finish();
        }
        return i11 - round2;
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i11, int i12) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(m.class);
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i11), Integer.valueOf(i12)};
                } catch (NoSuchMethodException e11) {
                    objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e12) {
                        e12.initCause(e11);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e12);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((m) constructor.newInstance(objArr));
            } catch (ClassCastException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e13);
            } catch (ClassNotFoundException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e14);
            } catch (IllegalAccessException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e15);
            } catch (InstantiationException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e16);
            } catch (InvocationTargetException e17) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e17);
            }
        }
    }

    private boolean didChildRangeChange(int i11, int i12) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i11 && iArr[1] == i12) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i11 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i11 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(obtain, i11);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f14365j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        y yVar = this.mState;
        yVar.f14364i = yVar.f14366k && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        yVar.f14363h = yVar.f14367l;
        yVar.f14361f = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f14366k) {
            int g11 = this.mChildHelper.g();
            for (int i11 = 0; i11 < g11; i11++) {
                b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, j.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f14364i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f14367l) {
            saveOldPositions();
            y yVar2 = this.mState;
            boolean z10 = yVar2.f14362g;
            yVar2.f14362g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, yVar2);
            this.mState.f14362g = z10;
            for (int i12 = 0; i12 < this.mChildHelper.g(); i12++) {
                b0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i12));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = j.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    j.c recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f14360e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f14361f = this.mAdapter.getItemCount();
        this.mState.f14359d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        y yVar = this.mState;
        yVar.f14363h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, yVar);
        y yVar2 = this.mState;
        yVar2.f14362g = false;
        yVar2.f14366k = yVar2.f14366k && this.mItemAnimator != null;
        yVar2.f14360e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        y yVar = this.mState;
        yVar.f14360e = 1;
        if (yVar.f14366k) {
            for (int g11 = this.mChildHelper.g() - 1; g11 >= 0; g11--) {
                b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(g11));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    j.c recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    b0 g12 = this.mViewInfoStore.g(changedHolderKey);
                    if (g12 == null || g12.shouldIgnore()) {
                        this.mViewInfoStore.d(childViewHolderInt, recordPostLayoutInformation);
                    } else {
                        boolean h11 = this.mViewInfoStore.h(g12);
                        boolean h12 = this.mViewInfoStore.h(childViewHolderInt);
                        if (h11 && g12 == childViewHolderInt) {
                            this.mViewInfoStore.d(childViewHolderInt, recordPostLayoutInformation);
                        } else {
                            j.c n11 = this.mViewInfoStore.n(g12);
                            this.mViewInfoStore.d(childViewHolderInt, recordPostLayoutInformation);
                            j.c m11 = this.mViewInfoStore.m(childViewHolderInt);
                            if (n11 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, g12);
                            } else {
                                animateChange(g12, childViewHolderInt, n11, m11, h11, h12);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        y yVar2 = this.mState;
        yVar2.f14358c = yVar2.f14361f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        yVar2.f14366k = false;
        yVar2.f14367l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList arrayList = this.mRecycler.f14332b;
        if (arrayList != null) {
            arrayList.clear();
        }
        m mVar = this.mLayout;
        if (mVar.mPrefetchMaxObservedInInitialPrefetch) {
            mVar.mPrefetchMaxCountObserved = 0;
            mVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.P();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        q qVar = this.mInterceptingOnItemTouchListener;
        if (qVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        qVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = this.mOnItemTouchListeners.get(i11);
            if (qVar.b(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = qVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int g11 = this.mChildHelper.g();
        if (g11 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        for (int i13 = 0; i13 < g11; i13++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i13));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i11) {
                    i11 = layoutPosition;
                }
                if (layoutPosition > i12) {
                    i12 = layoutPosition;
                }
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
    }

    @Nullable
    static RecyclerView findNestedRecyclerView(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i11));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    @Nullable
    private View findNextViewToFocus() {
        b0 findViewHolderForAdapterPosition;
        y yVar = this.mState;
        int i11 = yVar.f14368m;
        if (i11 == -1) {
            i11 = 0;
        }
        int b11 = yVar.b();
        for (int i12 = i11; i12 < b11; i12++) {
            b0 findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i12);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(b11, i11);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((n) view.getLayoutParams()).mViewHolder;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        n nVar = (n) view.getLayoutParams();
        Rect rect2 = nVar.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i11) {
        double log = Math.log((Math.abs(i11) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float f11 = DECELERATION_RATE;
        return (float) (this.mPhysicalCoef * SCROLL_FRICTION * Math.exp((f11 / (f11 - 1.0d)) * log));
    }

    private void handleMissingPreInfoForChangeError(long j11, b0 b0Var, b0 b0Var2) {
        int g11 = this.mChildHelper.g();
        for (int i11 = 0; i11 < g11; i11++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
            if (childViewHolderInt != b0Var && getChangedHolderKey(childViewHolderInt) == j11) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + b0Var + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + b0Var + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + b0Var2 + " cannot be found but it is necessary for " + b0Var + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int g11 = this.mChildHelper.g();
        for (int i11 = 0; i11 < g11; i11++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.e(new c());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i11) {
        int i12;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c11 = 65535;
        int i13 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i14 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i15 = rect2.left;
        if ((i14 < i15 || rect.right <= i15) && rect.right < rect2.right) {
            i12 = 1;
        } else {
            int i16 = rect.right;
            int i17 = rect2.right;
            i12 = ((i16 > i17 || i14 >= i17) && i14 > i15) ? -1 : 0;
        }
        int i18 = rect.top;
        int i19 = rect2.top;
        if ((i18 < i19 || rect.bottom <= i19) && rect.bottom < rect2.bottom) {
            c11 = 1;
        } else {
            int i20 = rect.bottom;
            int i21 = rect2.bottom;
            if ((i20 <= i21 && i18 < i21) || i18 <= i19) {
                c11 = 0;
            }
        }
        if (i11 == 1) {
            return c11 < 0 || (c11 == 0 && i12 * i13 < 0);
        }
        if (i11 == 2) {
            return c11 > 0 || (c11 == 0 && i12 * i13 > 0);
        }
        if (i11 == 17) {
            return i12 < 0;
        }
        if (i11 == 33) {
            return c11 < 0;
        }
        if (i11 == 66) {
            return i12 > 0;
        }
        if (i11 == 130) {
            return c11 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i11 + exceptionLabel());
    }

    private void nestedScrollByInternal(int i11, int i12, @Nullable MotionEvent motionEvent, int i13) {
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean canScrollHorizontally = mVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        int i14 = canScrollVertically ? (canScrollHorizontally ? 1 : 0) | 2 : canScrollHorizontally ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int releaseHorizontalGlow = i11 - releaseHorizontalGlow(i11, height);
        int releaseVerticalGlow = i12 - releaseVerticalGlow(i12, width);
        startNestedScroll(i14, i13);
        if (dispatchNestedPreScroll(canScrollHorizontally ? releaseHorizontalGlow : 0, canScrollVertically ? releaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, i13)) {
            int[] iArr2 = this.mReusableIntPair;
            releaseHorizontalGlow -= iArr2[0];
            releaseVerticalGlow -= iArr2[1];
        }
        scrollByInternal(canScrollHorizontally ? releaseHorizontalGlow : 0, canScrollVertically ? releaseVerticalGlow : 0, motionEvent, i13);
        GapWorker gapWorker = this.mGapWorker;
        if (gapWorker != null && (releaseHorizontalGlow != 0 || releaseVerticalGlow != 0)) {
            gapWorker.postFromTraversal(this, releaseHorizontalGlow, releaseVerticalGlow);
        }
        stopNestedScroll(i13);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i11);
            int x10 = (int) (motionEvent.getX(i11) + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY(i11) + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z10;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.w();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z11 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f14366k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z10 = this.mDataSetHasChangedAfterLayout) || z11 || this.mLayout.mRequestedSimpleAnimations) && (!z10 || this.mAdapter.hasStableIds());
        y yVar = this.mState;
        yVar.f14367l = yVar.f14366k && z11 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.h.d(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.h.d(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.h.d(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.h.d(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.n(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        b0 findViewHolderForItemId = (this.mState.f14369n == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f14369n);
        if (findViewHolderForItemId != null && !this.mChildHelper.n(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
            view = findViewHolderForItemId.itemView;
        } else if (this.mChildHelper.g() > 0) {
            view = findNextViewToFocus();
        }
        if (view != null) {
            int i11 = this.mState.f14370o;
            if (i11 != -1 && (findViewById = view.findViewById(i11)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean z10;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.mLeftGlow.isFinished();
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.mBottomGlow.isFinished();
        }
        if (z10) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private int releaseHorizontalGlow(int i11, float f11) {
        float height = f11 / getHeight();
        float width = i11 / getWidth();
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f12 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.h.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (edgeEffect2 != null && androidx.core.widget.h.b(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float d11 = androidx.core.widget.h.d(this.mRightGlow, width, height);
                    if (androidx.core.widget.h.b(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f12 = d11;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f13 = -androidx.core.widget.h.d(this.mLeftGlow, -width, 1.0f - height);
                if (androidx.core.widget.h.b(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f12 = f13;
            }
            invalidate();
        }
        return Math.round(f12 * getWidth());
    }

    private int releaseVerticalGlow(int i11, float f11) {
        float width = f11 / getWidth();
        float height = i11 / getHeight();
        EdgeEffect edgeEffect = this.mTopGlow;
        float f12 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.h.b(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (edgeEffect2 != null && androidx.core.widget.h.b(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float d11 = androidx.core.widget.h.d(this.mBottomGlow, height, 1.0f - width);
                    if (androidx.core.widget.h.b(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f12 = d11;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f13 = -androidx.core.widget.h.d(this.mTopGlow, -height, width);
                if (androidx.core.widget.h.b(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f12 = f13;
            }
            invalidate();
        }
        return Math.round(f12 * getHeight());
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof n) {
            n nVar = (n) layoutParams;
            if (!nVar.mInsetsDirty) {
                Rect rect = nVar.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        y yVar = this.mState;
        yVar.f14369n = -1L;
        yVar.f14368m = -1;
        yVar.f14370o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        b0 findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f14369n = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        this.mState.f14368m = this.mDataSetHasChangedAfterLayout ? -1 : findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAbsoluteAdapterPosition();
        this.mState.f14370o = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void setAdapterInternal(@Nullable Adapter adapter, boolean z10, boolean z11) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z10 || z11) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.y(adapter3, this.mAdapter, z10);
        this.mState.f14362g = true;
    }

    public static void setDebugAssertionsEnabled(boolean z10) {
        sDebugAssertionsEnabled = z10;
    }

    public static void setVerboseLoggingEnabled(boolean z10) {
        sVerboseLoggingEnabled = z10;
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect edgeEffect, int i11, int i12) {
        if (i11 > 0) {
            return true;
        }
        return getSplineFlingDistance(-i11) < androidx.core.widget.h.b(edgeEffect) * ((float) i12);
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z10;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || androidx.core.widget.h.b(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z10 = false;
        } else {
            androidx.core.widget.h.d(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z10 = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && androidx.core.widget.h.b(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            androidx.core.widget.h.d(this.mRightGlow, 0.0f, motionEvent.getY() / getHeight());
            z10 = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && androidx.core.widget.h.b(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            androidx.core.widget.h.d(this.mTopGlow, 0.0f, motionEvent.getX() / getWidth());
            z10 = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || androidx.core.widget.h.b(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z10;
        }
        androidx.core.widget.h.d(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.stopSmoothScroller();
        }
    }

    void absorbGlows(int i11, int i12) {
        if (i11 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i11);
            }
        }
        if (i12 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i12);
            }
        } else if (i12 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i12);
            }
        }
        if (i11 == 0 && i12 == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        m mVar = this.mLayout;
        if (mVar == null || !mVar.onAddFocusables(this, arrayList, i11, i12)) {
            super.addFocusables(arrayList, i11, i12);
        }
    }

    public void addItemDecoration(@NonNull l lVar) {
        addItemDecoration(lVar, -1);
    }

    public void addItemDecoration(@NonNull l lVar, int i11) {
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i11 < 0) {
            this.mItemDecorations.add(lVar);
        } else {
            this.mItemDecorations.add(i11, lVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull o oVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(oVar);
    }

    public void addOnItemTouchListener(@NonNull q qVar) {
        this.mOnItemTouchListeners.add(qVar);
    }

    public void addOnScrollListener(@NonNull r rVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(rVar);
    }

    public void addRecyclerListener(@NonNull u uVar) {
        androidx.core.util.i.b(uVar != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(uVar);
    }

    void animateAppearance(@NonNull b0 b0Var, @Nullable j.c cVar, @NonNull j.c cVar2) {
        b0Var.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(b0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(@NonNull b0 b0Var, @NonNull j.c cVar, @Nullable j.c cVar2) {
        addAnimatingView(b0Var);
        b0Var.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(b0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(b0 b0Var) {
        j jVar = this.mItemAnimator;
        return jVar == null || jVar.canReuseUpdatedViewHolder(b0Var, b0Var.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof n) && this.mLayout.checkLayoutParams((n) layoutParams);
    }

    void clearOldPositions() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<o> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<r> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        m mVar = this.mLayout;
        if (mVar != null && mVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    void considerReleasingGlowsOnScroll(int i11, int i12) {
        boolean z10;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i11 <= 0) {
            z10 = false;
        } else {
            this.mLeftGlow.onRelease();
            z10 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i11 < 0) {
            this.mRightGlow.onRelease();
            z10 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i12 > 0) {
            this.mTopGlow.onRelease();
            z10 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i12 < 0) {
            this.mBottomGlow.onRelease();
            z10 |= this.mBottomGlow.isFinished();
        }
        if (z10) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int consumeFlingInHorizontalStretch(int i11) {
        return consumeFlingInStretch(i11, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    int consumeFlingInVerticalStretch(int i11) {
        return consumeFlingInStretch(i11, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.s.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.os.s.b();
            return;
        }
        if (this.mAdapterHelper.p()) {
            if (!this.mAdapterHelper.o(4) || this.mAdapterHelper.o(11)) {
                if (this.mAdapterHelper.p()) {
                    androidx.core.os.s.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    androidx.core.os.s.b();
                    return;
                }
                return;
            }
            androidx.core.os.s.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.w();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.i();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            androidx.core.os.s.b();
        }
    }

    void defaultOnMeasure(int i11, int i12) {
        setMeasuredDimension(m.chooseSize(i11, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), m.chooseSize(i12, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    void dispatchChildAttached(View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<o> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    void dispatchChildDetached(View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<o> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.f14365j = false;
        boolean z10 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f14360e == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.q() || z10 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f11, float f12, boolean z10) {
        return getScrollingChildHelper().dispatchNestedFling(f11, f12, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f11, float f12) {
        return getScrollingChildHelper().dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i11, i12, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i11, i12, iArr, iArr2, i13);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i11, i12, i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return getScrollingChildHelper().dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
    }

    void dispatchOnScrollStateChanged(int i11) {
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.onScrollStateChanged(i11);
        }
        onScrollStateChanged(i11);
        r rVar = this.mScrollListener;
        if (rVar != null) {
            rVar.onScrollStateChanged(this, i11);
        }
        List<r> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i11);
            }
        }
    }

    void dispatchOnScrolled(int i11, int i12) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i11, scrollY - i12);
        onScrolled(i11, i12);
        r rVar = this.mScrollListener;
        if (rVar != null) {
            rVar.onScrolled(this, i11, i12);
        }
        List<r> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i11, i12);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i11;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            b0 b0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (b0Var.itemView.getParent() == this && !b0Var.shouldIgnore() && (i11 = b0Var.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(b0Var.itemView, i11);
                b0Var.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            this.mItemDecorations.get(i11).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save4);
        }
        if ((z10 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) ? z10 : true) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        return super.drawChild(canvas, view, j11);
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = a11;
        if (this.mClipToPadding) {
            a11.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a11.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = a11;
        if (this.mClipToPadding) {
            a11.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a11.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = a11;
        if (this.mClipToPadding) {
            a11.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            a11.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = a11;
        if (this.mClipToPadding) {
            a11.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            a11.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(y yVar) {
        if (getScrollState() != 2) {
            yVar.f14371p = 0;
            yVar.f14372q = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            yVar.f14371p = overScroller.getFinalX() - overScroller.getCurrX();
            yVar.f14372q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    @Nullable
    public View findChildViewUnder(float f11, float f12) {
        for (int g11 = this.mChildHelper.g() - 1; g11 >= 0; g11--) {
            View f13 = this.mChildHelper.f(g11);
            float translationX = f13.getTranslationX();
            float translationY = f13.getTranslationY();
            if (f11 >= f13.getLeft() + translationX && f11 <= f13.getRight() + translationX && f12 >= f13.getTop() + translationY && f12 <= f13.getBottom() + translationY) {
                return f13;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(@androidx.annotation.NonNull android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    @Nullable
    public b0 findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public b0 findViewHolderForAdapterPosition(int i11) {
        b0 b0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int j11 = this.mChildHelper.j();
        for (int i12 = 0; i12 < j11; i12++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i12));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i11) {
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                b0Var = childViewHolderInt;
            }
        }
        return b0Var;
    }

    public b0 findViewHolderForItemId(long j11) {
        Adapter adapter = this.mAdapter;
        b0 b0Var = null;
        if (adapter != null && adapter.hasStableIds()) {
            int j12 = this.mChildHelper.j();
            for (int i11 = 0; i11 < j12; i11++) {
                b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j11) {
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    b0Var = childViewHolderInt;
                }
            }
        }
        return b0Var;
    }

    @Nullable
    public b0 findViewHolderForLayoutPosition(int i11) {
        return findViewHolderForPosition(i11, false);
    }

    @Nullable
    @Deprecated
    public b0 findViewHolderForPosition(int i11) {
        return findViewHolderForPosition(i11, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.b0 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.e r0 = r5.mChildHelper
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.e r3 = r5.mChildHelper
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$b0 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.e r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$b0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean fling(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i11) {
        View view2;
        boolean z10;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i11);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z11 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z11 && (i11 == 2 || i11 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i12 = i11 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i12) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i11 = i12;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.mLayout.canScrollHorizontally()) {
                int i13 = (this.mLayout.getLayoutDirection() == 1) ^ (i11 == 2) ? 66 : 17;
                boolean z12 = focusFinder.findNextFocus(this, view, i13) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i11 = i13;
                }
                z10 = z12;
            }
            if (z10) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i11, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i11);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i11);
            if (findNextFocus == null && z11) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i11, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i11) ? view2 : super.focusSearch(view, i11);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i11);
        }
        requestChildOnScreen(view2, null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        m mVar = this.mLayout;
        if (mVar != null) {
            return mVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        m mVar = this.mLayout;
        if (mVar != null) {
            return mVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        m mVar = this.mLayout;
        if (mVar != null) {
            return mVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionInRecyclerView(b0 b0Var) {
        if (b0Var.hasAnyOfTheFlags(524) || !b0Var.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.e(b0Var.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        m mVar = this.mLayout;
        return mVar != null ? mVar.getBaseline() : super.getBaseline();
    }

    long getChangedHolderKey(b0 b0Var) {
        return this.mAdapter.hasStableIds() ? b0Var.getItemId() : b0Var.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i11, int i12) {
        return super.getChildDrawingOrder(i11, i12);
    }

    public long getChildItemId(@NonNull View view) {
        b0 childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public b0 getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public androidx.recyclerview.widget.o getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    @NonNull
    public i getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public j getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        n nVar = (n) view.getLayoutParams();
        if (!nVar.mInsetsDirty) {
            return nVar.mDecorInsets;
        }
        if (this.mState.e() && (nVar.isItemChanged() || nVar.isViewInvalid())) {
            return nVar.mDecorInsets;
        }
        Rect rect = nVar.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i11).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i12 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i12 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        nVar.mInsetsDirty = false;
        return rect;
    }

    @NonNull
    public l getItemDecorationAt(int i11) {
        int itemDecorationCount = getItemDecorationCount();
        if (i11 >= 0 && i11 < itemDecorationCount) {
            return this.mItemDecorations.get(i11);
        }
        throw new IndexOutOfBoundsException(i11 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public m getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public p getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public s getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i11) {
        return getScrollingChildHelper().hasNestedScrollingParent(i11);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new d());
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        j jVar = this.mItemAnimator;
        return jVar != null && jVar.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void jumpToPositionForSmoothScroller(int i11) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i11);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            ((n) this.mChildHelper.i(i11).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.s();
    }

    void markKnownViewsInvalid() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void nestedScrollBy(int i11, int i12) {
        nestedScrollByInternal(i11, i12, null, 1);
    }

    public void offsetChildrenHorizontal(int i11) {
        int g11 = this.mChildHelper.g();
        for (int i12 = 0; i12 < g11; i12++) {
            this.mChildHelper.f(i12).offsetLeftAndRight(i11);
        }
    }

    public void offsetChildrenVertical(int i11) {
        int g11 = this.mChildHelper.g();
        for (int i12 = 0; i12 < g11; i12++) {
            this.mChildHelper.f(i12).offsetTopAndBottom(i11);
        }
    }

    void offsetPositionRecordsForInsert(int i11, int i12) {
        int j11 = this.mChildHelper.j();
        for (int i13 = 0; i13 < j11; i13++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i13));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i11) {
                if (sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("offsetPositionRecordsForInsert attached child ");
                    sb2.append(i13);
                    sb2.append(" holder ");
                    sb2.append(childViewHolderInt);
                    sb2.append(" now at position ");
                    sb2.append(childViewHolderInt.mPosition + i12);
                }
                childViewHolderInt.offsetPosition(i12, false);
                this.mState.f14362g = true;
            }
        }
        this.mRecycler.v(i11, i12);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int j11 = this.mChildHelper.j();
        if (i11 < i12) {
            i15 = -1;
            i14 = i11;
            i13 = i12;
        } else {
            i13 = i11;
            i14 = i12;
            i15 = 1;
        }
        for (int i17 = 0; i17 < j11; i17++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i17));
            if (childViewHolderInt != null && (i16 = childViewHolderInt.mPosition) >= i14 && i16 <= i13) {
                if (sVerboseLoggingEnabled) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("offsetPositionRecordsForMove attached child ");
                    sb2.append(i17);
                    sb2.append(" holder ");
                    sb2.append(childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i11) {
                    childViewHolderInt.offsetPosition(i12 - i11, false);
                } else {
                    childViewHolderInt.offsetPosition(i15, false);
                }
                this.mState.f14362g = true;
            }
        }
        this.mRecycler.w(i11, i12);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i11, int i12, boolean z10) {
        int i13 = i11 + i12;
        int j11 = this.mChildHelper.j();
        for (int i14 = 0; i14 < j11; i14++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i14));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i15 = childViewHolderInt.mPosition;
                if (i15 >= i13) {
                    if (sVerboseLoggingEnabled) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("offsetPositionRecordsForRemove attached child ");
                        sb2.append(i14);
                        sb2.append(" holder ");
                        sb2.append(childViewHolderInt);
                        sb2.append(" now at position ");
                        sb2.append(childViewHolderInt.mPosition - i12);
                    }
                    childViewHolderInt.offsetPosition(-i12, z10);
                    this.mState.f14362g = true;
                } else if (i15 >= i11) {
                    if (sVerboseLoggingEnabled) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("offsetPositionRecordsForRemove attached child ");
                        sb3.append(i14);
                        sb3.append(" holder ");
                        sb3.append(childViewHolderInt);
                        sb3.append(" now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i11 - 1, -i12, z10);
                    this.mState.f14362g = true;
                }
            }
        }
        this.mRecycler.x(i11, i12, z10);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$t r1 = r5.mRecycler
            r1.z()
            androidx.recyclerview.widget.RecyclerView$m r1 = r5.mLayout
            if (r1 == 0) goto L23
            r1.dispatchAttachedToWindow(r5)
        L23:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L66
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.sGapWorker
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L61
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.mGapWorker = r1
            android.view.Display r1 = androidx.core.view.ViewCompat.getDisplay(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L53
            if (r1 == 0) goto L53
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L53
            goto L55
        L53:
            r1 = 1114636288(0x42700000, float:60.0)
        L55:
            androidx.recyclerview.widget.GapWorker r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.mFrameIntervalNs = r3
            r0.set(r2)
        L61:
            androidx.recyclerview.widget.GapWorker r0 = r5.mGapWorker
            r0.add(r5)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        j jVar = this.mItemAnimator;
        if (jVar != null) {
            jVar.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        this.mRecycler.A();
        h1.a.c(this);
        if (!ALLOW_THREAD_GAP_WORK || (gapWorker = this.mGapWorker) == null) {
            return;
        }
        gapWorker.remove(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mItemDecorations.get(i11).onDraw(canvas, this, this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z10) {
        int i11 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i11;
        if (i11 < 1) {
            if (sDebugAssertionsEnabled && i11 < 0) {
                throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
            }
            this.mLayoutOrScrollCounter = 0;
            if (z10) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$m r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$m r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$m r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$m r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$m r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.nestedScrollByInternal(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        m mVar = this.mLayout;
        if (mVar == null) {
            return false;
        }
        boolean canScrollHorizontally = mVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
            if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i11 = canScrollHorizontally;
            if (canScrollVertically) {
                i11 = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i11, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i12 = x11 - this.mInitialTouchX;
                int i13 = y11 - this.mInitialTouchY;
                if (canScrollHorizontally == 0 || Math.abs(i12) <= this.mTouchSlop) {
                    z10 = false;
                } else {
                    this.mLastTouchX = x11;
                    z10 = true;
                }
                if (canScrollVertically && Math.abs(i13) > this.mTouchSlop) {
                    this.mLastTouchY = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x12;
            this.mInitialTouchX = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y12;
            this.mInitialTouchY = y12;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        androidx.core.os.s.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.s.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        m mVar = this.mLayout;
        if (mVar == null) {
            defaultOnMeasure(i11, i12);
            return;
        }
        boolean z10 = false;
        if (mVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z10;
            if (z10 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f14360e == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i11, i12);
            this.mState.f14365j = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i11, i12);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f14365j = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i11, i12);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            y yVar = this.mState;
            if (yVar.f14367l) {
                yVar.f14363h = true;
            } else {
                this.mAdapterHelper.j();
                this.mState.f14363h = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f14367l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.f14361f = adapter.getItemCount();
        } else {
            this.mState.f14361f = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
        stopInterceptRequestLayout(false);
        this.mState.f14363h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i11, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i11, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            m mVar = this.mLayout;
            if (mVar != null) {
                savedState.mLayoutState = mVar.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i11) {
    }

    public void onScrolled(int i11, int i12) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 == i13 && i12 == i14) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    void processDataSetCompletelyChanged(boolean z10) {
        this.mDispatchItemsChangedEvent = z10 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(b0 b0Var, j.c cVar) {
        b0Var.setFlags(0, 8192);
        if (this.mState.f14364i && b0Var.isUpdated() && !b0Var.isRemoved() && !b0Var.shouldIgnore()) {
            this.mViewInfoStore.c(getChangedHolderKey(b0Var), b0Var);
        }
        this.mViewInfoStore.e(b0Var, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        j jVar = this.mItemAnimator;
        if (jVar != null) {
            jVar.endAnimations();
        }
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.c();
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean r11 = this.mChildHelper.r(view);
        if (r11) {
            b0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.O(childViewHolderInt);
            this.mRecycler.H(childViewHolderInt);
            if (sVerboseLoggingEnabled) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("after removing animated view: ");
                sb2.append(view);
                sb2.append(", ");
                sb2.append(this);
            }
        }
        stopInterceptRequestLayout(!r11);
        return r11;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z10) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        } else if (sDebugAssertionsEnabled) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + exceptionLabel());
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z10);
    }

    public void removeItemDecoration(@NonNull l lVar) {
        m mVar = this.mLayout;
        if (mVar != null) {
            mVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(lVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i11) {
        int itemDecorationCount = getItemDecorationCount();
        if (i11 >= 0 && i11 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i11));
            return;
        }
        throw new IndexOutOfBoundsException(i11 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull o oVar) {
        List<o> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(oVar);
    }

    public void removeOnItemTouchListener(@NonNull q qVar) {
        this.mOnItemTouchListeners.remove(qVar);
        if (this.mInterceptingOnItemTouchListener == qVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull r rVar) {
        List<r> list = this.mScrollListeners;
        if (list != null) {
            list.remove(rVar);
        }
    }

    public void removeRecyclerListener(@NonNull u uVar) {
        this.mRecyclerListeners.remove(uVar);
    }

    void repositionShadowingViews() {
        b0 b0Var;
        int g11 = this.mChildHelper.g();
        for (int i11 = 0; i11 < g11; i11++) {
            View f11 = this.mChildHelper.f(i11);
            b0 childViewHolder = getChildViewHolder(f11);
            if (childViewHolder != null && (b0Var = childViewHolder.mShadowingHolder) != null) {
                View view = b0Var.itemView;
                int left = f11.getLeft();
                int top = f11.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.mOnItemTouchListeners.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mOnItemTouchListeners.get(i11).c(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    void saveOldPositions() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (sDebugAssertionsEnabled && childViewHolderInt.mPosition == -1 && !childViewHolderInt.isRemoved()) {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
            }
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i11, int i12) {
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean canScrollHorizontally = mVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i11 = 0;
            }
            if (!canScrollVertically) {
                i12 = 0;
            }
            scrollByInternal(i11, i12, null, 0);
        }
    }

    boolean scrollByInternal(int i11, int i12, MotionEvent motionEvent, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i11, i12, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i18 = iArr2[0];
            int i19 = iArr2[1];
            i14 = i19;
            i15 = i18;
            i16 = i11 - i18;
            i17 = i12 - i19;
        } else {
            i14 = 0;
            i15 = 0;
            i16 = 0;
            i17 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i15, i14, i16, i17, this.mScrollOffset, i13, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i20 = iArr4[0];
        int i21 = i16 - i20;
        int i22 = iArr4[1];
        int i23 = i17 - i22;
        boolean z10 = (i20 == 0 && i22 == 0) ? false : true;
        int i24 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i25 = iArr5[0];
        this.mLastTouchX = i24 - i25;
        int i26 = this.mLastTouchY;
        int i27 = iArr5[1];
        this.mLastTouchY = i26 - i27;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i25;
        iArr6[1] = iArr6[1] + i27;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, InputDeviceCompat.SOURCE_MOUSE)) {
                pullGlows(motionEvent.getX(), i21, motionEvent.getY(), i23);
            }
            considerReleasingGlowsOnScroll(i11, i12);
        }
        if (i15 != 0 || i14 != 0) {
            dispatchOnScrolled(i15, i14);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z10 && i15 == 0 && i14 == 0) ? false : true;
    }

    void scrollStep(int i11, int i12, @Nullable int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.s.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i11 != 0 ? this.mLayout.scrollHorizontallyBy(i11, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i12 != 0 ? this.mLayout.scrollVerticallyBy(i12, this.mRecycler, this.mState) : 0;
        androidx.core.os.s.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i11, int i12) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i11) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            mVar.scrollToPosition(i11);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable androidx.recyclerview.widget.o oVar) {
        this.mAccessibilityDelegate = oVar;
        ViewCompat.setAccessibilityDelegate(this, oVar);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable h hVar) {
        if (hVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    boolean setChildImportantForAccessibilityInternal(b0 b0Var, int i11) {
        if (!isComputingLayout()) {
            ViewCompat.setImportantForAccessibility(b0Var.itemView, i11);
            return true;
        }
        b0Var.mPendingAccessibilityState = i11;
        this.mPendingAccessibilityImportanceChange.add(b0Var);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z10;
        super.setClipToPadding(z10);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull i iVar) {
        androidx.core.util.i.g(iVar);
        this.mEdgeEffectFactory = iVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z10) {
        this.mHasFixedSize = z10;
    }

    public void setItemAnimator(@Nullable j jVar) {
        j jVar2 = this.mItemAnimator;
        if (jVar2 != null) {
            jVar2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = jVar;
        if (jVar != null) {
            jVar.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i11) {
        this.mRecycler.L(i11);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(@Nullable m mVar) {
        if (mVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            j jVar = this.mItemAnimator;
            if (jVar != null) {
                jVar.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.c();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.c();
        }
        this.mChildHelper.o();
        this.mLayout = mVar;
        if (mVar != null) {
            if (mVar.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + mVar + " is already attached to a RecyclerView:" + mVar.mRecyclerView.exceptionLabel());
            }
            mVar.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.P();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().setNestedScrollingEnabled(z10);
    }

    public void setOnFlingListener(@Nullable p pVar) {
        this.mOnFlingListener = pVar;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable r rVar) {
        this.mScrollListener = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.mPreserveFocusAfterLayout = z10;
    }

    public void setRecycledViewPool(@Nullable s sVar) {
        this.mRecycler.J(sVar);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable u uVar) {
    }

    void setScrollState(int i11) {
        if (i11 == this.mScrollState) {
            return;
        }
        if (sVerboseLoggingEnabled) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setting scroll state to ");
            sb2.append(i11);
            sb2.append(" from ");
            sb2.append(this.mScrollState);
            new Exception();
        }
        this.mScrollState = i11;
        if (i11 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i11);
    }

    public void setScrollingTouchSlop(int i11) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i11 != 0) {
            if (i11 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i11 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable a0 a0Var) {
        this.mRecycler.K(a0Var);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        return true;
    }

    public void smoothScrollBy(int i11, int i12) {
        smoothScrollBy(i11, i12, null);
    }

    public void smoothScrollBy(int i11, int i12, @Nullable Interpolator interpolator) {
        smoothScrollBy(i11, i12, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i11, int i12, @Nullable Interpolator interpolator, int i13) {
        smoothScrollBy(i11, i12, interpolator, i13, false);
    }

    void smoothScrollBy(int i11, int i12, @Nullable Interpolator interpolator, int i13, boolean z10) {
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!mVar.canScrollHorizontally()) {
            i11 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i12 = 0;
        }
        if (i11 == 0 && i12 == 0) {
            return;
        }
        if (i13 != Integer.MIN_VALUE && i13 <= 0) {
            scrollBy(i11, i12);
            return;
        }
        if (z10) {
            int i14 = i11 != 0 ? 1 : 0;
            if (i12 != 0) {
                i14 |= 2;
            }
            startNestedScroll(i14, 1);
        }
        this.mViewFlinger.smoothScrollBy(i11, i12, i13, interpolator);
    }

    public void smoothScrollToPosition(int i11) {
        if (this.mLayoutSuppressed) {
            return;
        }
        m mVar = this.mLayout;
        if (mVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            mVar.smoothScrollToPosition(this, this.mState, i11);
        }
    }

    void startInterceptRequestLayout() {
        int i11 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i11;
        if (i11 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i11) {
        return getScrollingChildHelper().startNestedScroll(i11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i11, int i12) {
        return getScrollingChildHelper().startNestedScroll(i11, i12);
    }

    void stopInterceptRequestLayout(boolean z10) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (sDebugAssertionsEnabled) {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
            }
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z10 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z10 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i11) {
        getScrollingChildHelper().stopNestedScroll(i11);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z10) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z10);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int i11, int i12, Object obj) {
        int i13;
        int j11 = this.mChildHelper.j();
        int i14 = i11 + i12;
        for (int i15 = 0; i15 < j11; i15++) {
            View i16 = this.mChildHelper.i(i15);
            b0 childViewHolderInt = getChildViewHolderInt(i16);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i13 = childViewHolderInt.mPosition) >= i11 && i13 < i14) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((n) i16.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.R(i11, i12);
    }
}
