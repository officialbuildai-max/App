package com.google.android.material.bottomsheet;

import ab.i;
import ab.n;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.f0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c implements wa.b {

    /* renamed from: i0, reason: collision with root package name */
    private static final int f28446i0 = R$style.Widget_Design_BottomSheet_Modal;
    private boolean A;
    private final StateSettlingTracker B;
    private ValueAnimator C;
    int D;
    int E;
    int F;
    float G;
    int H;
    float I;
    boolean J;
    private boolean K;
    private boolean L;
    int M;
    int N;
    ViewDragHelper O;
    private boolean P;
    private int Q;
    private boolean R;
    private float S;
    private int T;
    int U;
    int V;
    WeakReference W;
    WeakReference X;
    WeakReference Y;
    private final ArrayList Z;

    /* renamed from: a, reason: collision with root package name */
    private int f28447a;

    /* renamed from: a0, reason: collision with root package name */
    private VelocityTracker f28448a0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f28449b;

    /* renamed from: b0, reason: collision with root package name */
    wa.f f28450b0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f28451c;

    /* renamed from: c0, reason: collision with root package name */
    int f28452c0;

    /* renamed from: d, reason: collision with root package name */
    private float f28453d;

    /* renamed from: d0, reason: collision with root package name */
    private int f28454d0;

    /* renamed from: e, reason: collision with root package name */
    private int f28455e;

    /* renamed from: e0, reason: collision with root package name */
    boolean f28456e0;

    /* renamed from: f, reason: collision with root package name */
    private int f28457f;

    /* renamed from: f0, reason: collision with root package name */
    private Map f28458f0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28459g;

    /* renamed from: g0, reason: collision with root package name */
    final SparseIntArray f28460g0;

    /* renamed from: h, reason: collision with root package name */
    private int f28461h;

    /* renamed from: h0, reason: collision with root package name */
    private final ViewDragHelper.b f28462h0;

    /* renamed from: i, reason: collision with root package name */
    private int f28463i;

    /* renamed from: j, reason: collision with root package name */
    private i f28464j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f28465k;

    /* renamed from: l, reason: collision with root package name */
    private int f28466l;

    /* renamed from: m, reason: collision with root package name */
    private int f28467m;

    /* renamed from: n, reason: collision with root package name */
    private int f28468n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f28469o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f28470p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f28471q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28472r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f28473s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f28474t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f28475u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f28476v;

    /* renamed from: w, reason: collision with root package name */
    private int f28477w;

    /* renamed from: x, reason: collision with root package name */
    private int f28478x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f28479y;

    /* renamed from: z, reason: collision with root package name */
    private n f28480z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        /* loaded from: classes4.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i11) {
            super(parcelable);
            this.state = i11;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.M;
            this.peekHeight = ((BottomSheetBehavior) bottomSheetBehavior).f28457f;
            this.fitToContents = ((BottomSheetBehavior) bottomSheetBehavior).f28449b;
            this.hideable = bottomSheetBehavior.J;
            this.skipCollapsed = ((BottomSheetBehavior) bottomSheetBehavior).K;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class StateSettlingTracker {

        /* renamed from: a, reason: collision with root package name */
        private int f28481a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f28482b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f28483c;

        private StateSettlingTracker() {
            this.f28483c = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    StateSettlingTracker.this.f28482b = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.O;
                    if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        stateSettlingTracker.c(stateSettlingTracker.f28481a);
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.M == 2) {
                        bottomSheetBehavior.V0(stateSettlingTracker2.f28481a);
                    }
                }
            };
        }

        void c(int i11) {
            WeakReference weakReference = BottomSheetBehavior.this.W;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f28481a = i11;
            if (this.f28482b) {
                return;
            }
            ViewCompat.postOnAnimation((View) BottomSheetBehavior.this.W.get(), this.f28483c);
            this.f28482b = true;
        }
    }

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.V0(5);
            WeakReference weakReference = BottomSheetBehavior.this.W;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((View) BottomSheetBehavior.this.W.get()).requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f28464j != null) {
                BottomSheetBehavior.this.f28464j.e0(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements f0.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f28487a;

        c(boolean z10) {
            this.f28487a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
        @Override // com.google.android.material.internal.f0.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.WindowInsetsCompat a(android.view.View r11, androidx.core.view.WindowInsetsCompat r12, com.google.android.material.internal.f0.e r13) {
            /*
                r10 = this;
                int r0 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
                z0.c r0 = r12.getInsets(r0)
                int r1 = androidx.core.view.WindowInsetsCompat.Type.mandatorySystemGestures()
                z0.c r1 = r12.getInsets(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.f79249b
                com.google.android.material.bottomsheet.BottomSheetBehavior.P(r2, r3)
                boolean r2 = com.google.android.material.internal.f0.p(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.Q(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.getSystemWindowInsetBottom()
                com.google.android.material.bottomsheet.BottomSheetBehavior.S(r3, r6)
                int r3 = r13.f29264d
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.R(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.T(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.f29263c
                goto L50
            L4e:
                int r4 = r13.f29261a
            L50:
                int r6 = r0.f79248a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.U(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.f29261a
                goto L62
            L60:
                int r13 = r13.f29263c
            L62:
                int r2 = r0.f79250c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.V(r2)
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.f79248a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r7
                goto L81
            L80:
                r2 = r6
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.W(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.f79250c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                r2 = r7
            L92:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.F(r8)
                if (r8 == 0) goto La3
                int r8 = r13.topMargin
                int r0 = r0.f79249b
                if (r8 == r0) goto La3
                r13.topMargin = r0
                goto La4
            La3:
                r7 = r2
            La4:
                if (r7 == 0) goto La9
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.f28487a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.f79251d
                com.google.android.material.bottomsheet.BottomSheetBehavior.G(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.Q(r11)
                if (r11 != 0) goto Lc7
                boolean r11 = r10.f28487a
                if (r11 == 0) goto Lcc
            Lc7:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.H(r11, r6)
            Lcc:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.a(android.view.View, androidx.core.view.WindowInsetsCompat, com.google.android.material.internal.f0$e):androidx.core.view.WindowInsetsCompat");
        }
    }

    /* loaded from: classes4.dex */
    class d extends ViewDragHelper.b {

        /* renamed from: a, reason: collision with root package name */
        private long f28489a;

        d() {
        }

        private boolean a(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.V + bottomSheetBehavior.o0()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionVertical(View view, int i11, int i12) {
            return d1.a.b(i11, BottomSheetBehavior.this.o0(), getViewVerticalDragRange(view));
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int getViewVerticalDragRange(View view) {
            return BottomSheetBehavior.this.f0() ? BottomSheetBehavior.this.V : BottomSheetBehavior.this.H;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewDragStateChanged(int i11) {
            if (i11 == 1 && BottomSheetBehavior.this.L) {
                BottomSheetBehavior.this.V0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            BottomSheetBehavior.this.k0(i12);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        
            if (r7.f28490b.X0(r0, (r9 * 100.0f) / r10.V) != false) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        
            if (r9 > r7.f28490b.F) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0090, code lost:
        
            if (java.lang.Math.abs(r8.getTop() - r7.f28490b.o0()) < java.lang.Math.abs(r8.getTop() - r7.f28490b.F)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00cf, code lost:
        
            if (r7.f28490b.a1() == false) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f1, code lost:
        
            if (java.lang.Math.abs(r9 - r7.f28490b.E) < java.lang.Math.abs(r9 - r7.f28490b.H)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x010d, code lost:
        
            if (r7.f28490b.a1() != false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0127, code lost:
        
            if (r7.f28490b.a1() == false) goto L63;
         */
        @Override // androidx.customview.widget.ViewDragHelper.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean tryCaptureView(View view, int i11) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i12 = bottomSheetBehavior.M;
            if (i12 == 1 || bottomSheetBehavior.f28456e0) {
                return false;
            }
            if (i12 == 3 && bottomSheetBehavior.f28452c0 == i11) {
                WeakReference weakReference = bottomSheetBehavior.Y;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f28489a = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.W;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements AccessibilityViewCommand {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28491a;

        e(int i11) {
            this.f28491a = i11;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.U0(this.f28491a);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f {
        void onLayout(@NonNull View view) {
        }

        public abstract void onSlide(View view, float f11);

        public abstract void onStateChanged(View view, int i11);
    }

    public BottomSheetBehavior() {
        this.f28447a = 0;
        this.f28449b = true;
        this.f28451c = false;
        this.f28466l = -1;
        this.f28467m = -1;
        this.B = new StateSettlingTracker();
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = 4;
        this.N = 4;
        this.S = 0.1f;
        this.Z = new ArrayList();
        this.f28454d0 = -1;
        this.f28460g0 = new SparseIntArray();
        this.f28462h0 = new d();
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i11;
        this.f28447a = 0;
        this.f28449b = true;
        this.f28451c = false;
        this.f28466l = -1;
        this.f28467m = -1;
        this.B = new StateSettlingTracker();
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = 4;
        this.N = 4;
        this.S = 0.1f;
        this.Z = new ArrayList();
        this.f28454d0 = -1;
        this.f28460g0 = new SparseIntArray();
        this.f28462h0 = new d();
        this.f28463i = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.f28465k = xa.c.a(context, obtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.f28480z = n.e(context, attributeSet, R$attr.bottomSheetStyle, f28446i0).m();
        }
        i0(context);
        j0();
        this.I = obtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            O0(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            N0(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || (i11 = peekValue.data) != -1) {
            P0(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            P0(i11);
        }
        M0(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        K0(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        J0(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        T0(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        H0(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        R0(obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        L0(obtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            I0(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            I0(peekValue2.data);
        }
        S0(obtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.f28470p = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f28471q = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f28472r = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f28473s = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f28474t = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f28475u = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f28476v = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.f28479y = obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        obtainStyledAttributes.recycle();
        this.f28453d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void C0(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i11) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, h0(i11));
    }

    private void D0() {
        this.f28452c0 = -1;
        this.f28454d0 = -1;
        VelocityTracker velocityTracker = this.f28448a0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f28448a0 = null;
        }
    }

    private void E0(SavedState savedState) {
        int i11 = this.f28447a;
        if (i11 == 0) {
            return;
        }
        if (i11 == -1 || (i11 & 1) == 1) {
            this.f28457f = savedState.peekHeight;
        }
        if (i11 == -1 || (i11 & 2) == 2) {
            this.f28449b = savedState.fitToContents;
        }
        if (i11 == -1 || (i11 & 4) == 4) {
            this.J = savedState.hideable;
        }
        if (i11 == -1 || (i11 & 8) == 8) {
            this.K = savedState.skipCollapsed;
        }
    }

    private void F0(View view, Runnable runnable) {
        if (z0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void W0(View view) {
        boolean z10 = (Build.VERSION.SDK_INT < 29 || w0() || this.f28459g) ? false : true;
        if (this.f28470p || this.f28471q || this.f28472r || this.f28474t || this.f28475u || this.f28476v || z10) {
            f0.f(view, new c(z10));
        }
    }

    private int X(View view, int i11, int i12) {
        return ViewCompat.addAccessibilityAction(view, view.getResources().getString(i11), h0(i12));
    }

    private boolean Y0() {
        return this.O != null && (this.L || this.M == 1);
    }

    private void Z() {
        int d02 = d0();
        if (this.f28449b) {
            this.H = Math.max(this.V - d02, this.E);
        } else {
            this.H = this.V - d02;
        }
    }

    private float a0(float f11, RoundedCorner roundedCorner) {
        int radius;
        if (roundedCorner != null) {
            radius = roundedCorner.getRadius();
            float f12 = radius;
            if (f12 > 0.0f && f11 > 0.0f) {
                return f12 / f11;
            }
        }
        return 0.0f;
    }

    private void b0() {
        this.F = (int) (this.V * (1.0f - this.G));
    }

    private float c0() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        RoundedCorner roundedCorner;
        RoundedCorner roundedCorner2;
        if (this.f28464j == null || (weakReference = this.W) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.W.get();
        if (!t0() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        float L = this.f28464j.L();
        roundedCorner = rootWindowInsets.getRoundedCorner(0);
        float a02 = a0(L, roundedCorner);
        float M = this.f28464j.M();
        roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
        return Math.max(a02, a0(M, roundedCorner2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(View view, int i11, boolean z10) {
        int r02 = r0(i11);
        ViewDragHelper viewDragHelper = this.O;
        if (viewDragHelper == null || (!z10 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), r02) : viewDragHelper.settleCapturedViewAt(view.getLeft(), r02))) {
            V0(i11);
            return;
        }
        V0(2);
        f1(i11, true);
        this.B.c(i11);
    }

    private int d0() {
        int i11;
        return this.f28459g ? Math.min(Math.max(this.f28461h, this.V - ((this.U * 9) / 16)), this.T) + this.f28477w : (this.f28469o || this.f28470p || (i11 = this.f28468n) <= 0) ? this.f28457f + this.f28477w : Math.max(this.f28457f, i11 + this.f28463i);
    }

    private void d1() {
        WeakReference weakReference = this.W;
        if (weakReference != null) {
            e1((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.X;
        if (weakReference2 != null) {
            e1((View) weakReference2.get(), 1);
        }
    }

    private float e0(int i11) {
        float f11;
        float f12;
        int i12 = this.H;
        if (i11 > i12 || i12 == o0()) {
            int i13 = this.H;
            f11 = i13 - i11;
            f12 = this.V - i13;
        } else {
            int i14 = this.H;
            f11 = i14 - i11;
            f12 = i14 - o0();
        }
        return f11 / f12;
    }

    private void e1(View view, int i11) {
        if (view == null) {
            return;
        }
        g0(view, i11);
        if (!this.f28449b && this.M != 6) {
            this.f28460g0.put(i11, X(view, R$string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.J && y0() && this.M != 5) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i12 = this.M;
        if (i12 == 3) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.f28449b ? 4 : 6);
            return;
        }
        if (i12 == 4) {
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.f28449b ? 3 : 6);
        } else {
            if (i12 != 6) {
                return;
            }
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            C0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0() {
        return x0() && y0();
    }

    private void f1(int i11, boolean z10) {
        boolean u02;
        ValueAnimator valueAnimator;
        if (i11 == 2 || this.A == (u02 = u0()) || this.f28464j == null) {
            return;
        }
        this.A = u02;
        if (!z10 || (valueAnimator = this.C) == null) {
            ValueAnimator valueAnimator2 = this.C;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.C.cancel();
            }
            this.f28464j.e0(this.A ? c0() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.C.reverse();
        } else {
            this.C.setFloatValues(this.f28464j.A(), u02 ? c0() : 1.0f);
            this.C.start();
        }
    }

    private void g0(View view, int i11) {
        if (view == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        int i12 = this.f28460g0.get(i11, -1);
        if (i12 != -1) {
            ViewCompat.removeAccessibilityAction(view, i12);
            this.f28460g0.delete(i11);
        }
    }

    private void g1(boolean z10) {
        Map map;
        WeakReference weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f28458f0 != null) {
                    return;
                } else {
                    this.f28458f0 = new HashMap(childCount);
                }
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if (childAt != this.W.get()) {
                    if (z10) {
                        this.f28458f0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f28451c) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.f28451c && (map = this.f28458f0) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, ((Integer) this.f28458f0.get(childAt)).intValue());
                    }
                }
            }
            if (!z10) {
                this.f28458f0 = null;
            } else if (this.f28451c) {
                ((View) this.W.get()).sendAccessibilityEvent(8);
            }
        }
    }

    private AccessibilityViewCommand h0(int i11) {
        return new e(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(boolean z10) {
        View view;
        if (this.W != null) {
            Z();
            if (this.M != 4 || (view = (View) this.W.get()) == null) {
                return;
            }
            if (z10) {
                U0(4);
            } else {
                view.requestLayout();
            }
        }
    }

    private void i0(Context context) {
        if (this.f28480z == null) {
            return;
        }
        i iVar = new i(this.f28480z);
        this.f28464j = iVar;
        iVar.S(context);
        ColorStateList colorStateList = this.f28465k;
        if (colorStateList != null) {
            this.f28464j.d0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f28464j.setTint(typedValue.data);
    }

    private void j0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(c0(), 1.0f);
        this.C = ofFloat;
        ofFloat.setDuration(500L);
        this.C.addUpdateListener(new b());
    }

    public static BottomSheetBehavior m0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c f11 = ((CoordinatorLayout.f) layoutParams).f();
        if (f11 instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) f11;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int n0(int i11, int i12, int i13, int i14) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, i12, i14);
        if (i13 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i13), 1073741824);
        }
        if (size != 0) {
            i13 = Math.min(size, i13);
        }
        return View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
    }

    private int r0(int i11) {
        if (i11 == 3) {
            return o0();
        }
        if (i11 == 4) {
            return this.H;
        }
        if (i11 == 5) {
            return this.V;
        }
        if (i11 == 6) {
            return this.F;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i11);
    }

    private float s0() {
        VelocityTracker velocityTracker = this.f28448a0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f28453d);
        return this.f28448a0.getYVelocity(this.f28452c0);
    }

    private boolean t0() {
        WeakReference weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.W.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private boolean u0() {
        return this.M == 3 && (this.f28479y || t0());
    }

    private boolean z0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11, int i12) {
        this.Q = 0;
        this.R = false;
        return (i11 & 2) != 0;
    }

    public boolean A0() {
        return true;
    }

    public void B0(f fVar) {
        this.Z.remove(fVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r4.getTop() <= r2.F) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        r0 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
    
        if (java.lang.Math.abs(r3 - r2.E) < java.lang.Math.abs(r3 - r2.H)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (a1() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.H)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        if (java.lang.Math.abs(r3 - r2.F) < java.lang.Math.abs(r3 - r2.H)) goto L51;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.o0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.V0(r0)
            return
        Lf:
            boolean r3 = r2.A0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference r3 = r2.Y
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.R
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.Q
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f28449b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.F
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.J
            if (r3 == 0) goto L49
            float r3 = r2.s0()
            boolean r3 = r2.Z0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.Q
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f28449b
            if (r1 == 0) goto L68
            int r5 = r2.E
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.F
            if (r3 >= r1) goto L7e
            int r1 = r2.H
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.a1()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f28449b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.F
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.H
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.c1(r4, r0, r3)
            r2.R = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.M == 1 && actionMasked == 0) {
            return true;
        }
        if (Y0()) {
            this.O.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            D0();
        }
        if (this.f28448a0 == null) {
            this.f28448a0 = VelocityTracker.obtain();
        }
        this.f28448a0.addMovement(motionEvent);
        if (Y0() && actionMasked == 2 && !this.P && Math.abs(this.f28454d0 - motionEvent.getY()) > this.O.getTouchSlop()) {
            this.O.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(View view) {
        WeakReference weakReference;
        if (view != null || (weakReference = this.X) == null) {
            this.X = new WeakReference(view);
            e1(view, 1);
        } else {
            g0((View) weakReference.get(), 1);
            this.X = null;
        }
    }

    public void H0(boolean z10) {
        this.L = z10;
    }

    public void I0(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.D = i11;
        f1(this.M, true);
    }

    public void J0(boolean z10) {
        if (this.f28449b == z10) {
            return;
        }
        this.f28449b = z10;
        if (this.W != null) {
            Z();
        }
        V0((this.f28449b && this.M == 6) ? 3 : this.M);
        f1(this.M, true);
        d1();
    }

    public void K0(boolean z10) {
        this.f28469o = z10;
    }

    public void L0(float f11) {
        if (f11 <= 0.0f || f11 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.G = f11;
        if (this.W != null) {
            b0();
        }
    }

    public void M0(boolean z10) {
        if (this.J != z10) {
            this.J = z10;
            if (!z10 && this.M == 5) {
                U0(4);
            }
            d1();
        }
    }

    public void N0(int i11) {
        this.f28467m = i11;
    }

    public void O0(int i11) {
        this.f28466l = i11;
    }

    public void P0(int i11) {
        Q0(i11, false);
    }

    public final void Q0(int i11, boolean z10) {
        if (i11 == -1) {
            if (this.f28459g) {
                return;
            } else {
                this.f28459g = true;
            }
        } else {
            if (!this.f28459g && this.f28457f == i11) {
                return;
            }
            this.f28459g = false;
            this.f28457f = Math.max(0, i11);
        }
        h1(z10);
    }

    public void R0(int i11) {
        this.f28447a = i11;
    }

    public void S0(int i11) {
        this.f28455e = i11;
    }

    public void T0(boolean z10) {
        this.K = z10;
    }

    public void U0(int i11) {
        if (i11 == 1 || i11 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i11 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!this.J && i11 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i11);
            return;
        }
        final int i12 = (i11 == 6 && this.f28449b && r0(i11) <= this.E) ? 3 : i11;
        WeakReference weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            V0(i11);
        } else {
            final View view = (View) this.W.get();
            F0(view, new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.c1(view, i12, false);
                }
            });
        }
    }

    void V0(int i11) {
        View view;
        if (this.M == i11) {
            return;
        }
        this.M = i11;
        if (i11 == 4 || i11 == 3 || i11 == 6 || (this.J && i11 == 5)) {
            this.N = i11;
        }
        WeakReference weakReference = this.W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i11 == 3) {
            g1(true);
        } else if (i11 == 6 || i11 == 5 || i11 == 4) {
            g1(false);
        }
        f1(i11, true);
        for (int i12 = 0; i12 < this.Z.size(); i12++) {
            ((f) this.Z.get(i12)).onStateChanged(view, i11);
        }
        d1();
    }

    public boolean X0(long j11, float f11) {
        return false;
    }

    public void Y(f fVar) {
        if (this.Z.contains(fVar)) {
            return;
        }
        this.Z.add(fVar);
    }

    boolean Z0(View view, float f11) {
        if (this.K) {
            return true;
        }
        if (y0() && view.getTop() >= this.H) {
            return Math.abs((((float) view.getTop()) + (f11 * this.S)) - ((float) this.H)) / ((float) d0()) > 0.5f;
        }
        return false;
    }

    public boolean a1() {
        return false;
    }

    public boolean b1() {
        return true;
    }

    @Override // wa.b
    public void cancelBackProgress() {
        wa.f fVar = this.f28450b0;
        if (fVar == null) {
            return;
        }
        fVar.f();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.W = null;
        this.O = null;
        this.f28450b0 = null;
    }

    @Override // wa.b
    public void handleBackInvoked() {
        wa.f fVar = this.f28450b0;
        if (fVar == null) {
            return;
        }
        androidx.activity.b c11 = fVar.c();
        if (c11 == null || Build.VERSION.SDK_INT < 34) {
            U0(this.J ? 5 : 4);
        } else if (this.J) {
            this.f28450b0.h(c11, new a());
        } else {
            this.f28450b0.i(c11, null);
            U0(4);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.W = null;
        this.O = null;
        this.f28450b0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i11;
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.L) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D0();
        }
        if (this.f28448a0 == null) {
            this.f28448a0 = VelocityTracker.obtain();
        }
        this.f28448a0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f28454d0 = (int) motionEvent.getY();
            if (this.M != 2) {
                WeakReference weakReference = this.Y;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x10, this.f28454d0)) {
                    this.f28452c0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f28456e0 = true;
                }
            }
            this.P = this.f28452c0 == -1 && !coordinatorLayout.isPointInChildBounds(view, x10, this.f28454d0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f28456e0 = false;
            this.f28452c0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (!this.P && (viewDragHelper = this.O) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.Y;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.P || this.M == 1 || coordinatorLayout.isPointInChildBounds(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || (i11 = this.f28454d0) == -1 || Math.abs(((float) i11) - motionEvent.getY()) <= ((float) this.O.getTouchSlop())) ? false : true;
    }

    void k0(int i11) {
        View view = (View) this.W.get();
        if (view == null || this.Z.isEmpty()) {
            return;
        }
        float e02 = e0(i11);
        for (int i12 = 0; i12 < this.Z.size(); i12++) {
            ((f) this.Z.get(i12)).onSlide(view, e02);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.f28461h = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            W0(view);
            ViewCompat.setWindowInsetsAnimationCallback(view, new com.google.android.material.bottomsheet.e(view));
            this.W = new WeakReference(view);
            this.f28450b0 = new wa.f(view);
            i iVar = this.f28464j;
            if (iVar != null) {
                ViewCompat.setBackground(view, iVar);
                i iVar2 = this.f28464j;
                float f11 = this.I;
                if (f11 == -1.0f) {
                    f11 = ViewCompat.getElevation(view);
                }
                iVar2.c0(f11);
            } else {
                ColorStateList colorStateList = this.f28465k;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            d1();
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
        }
        if (this.O == null) {
            this.O = ViewDragHelper.create(coordinatorLayout, this.f28462h0);
        }
        int top = view.getTop();
        coordinatorLayout.onLayoutChild(view, i11);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.T = height;
        int i12 = this.V;
        int i13 = i12 - height;
        int i14 = this.f28478x;
        if (i13 < i14) {
            if (this.f28473s) {
                int i15 = this.f28467m;
                if (i15 != -1) {
                    i12 = Math.min(i12, i15);
                }
                this.T = i12;
            } else {
                int i16 = i12 - i14;
                int i17 = this.f28467m;
                if (i17 != -1) {
                    i16 = Math.min(i16, i17);
                }
                this.T = i16;
            }
        }
        this.E = Math.max(0, this.V - this.T);
        b0();
        Z();
        int i18 = this.M;
        if (i18 == 3) {
            ViewCompat.offsetTopAndBottom(view, o0());
        } else if (i18 == 6) {
            ViewCompat.offsetTopAndBottom(view, this.F);
        } else if (this.J && i18 == 5) {
            ViewCompat.offsetTopAndBottom(view, this.V);
        } else if (i18 == 4) {
            ViewCompat.offsetTopAndBottom(view, this.H);
        } else if (i18 == 1 || i18 == 2) {
            ViewCompat.offsetTopAndBottom(view, top - view.getTop());
        }
        f1(this.M, false);
        this.Y = new WeakReference(l0(view));
        for (int i19 = 0; i19 < this.Z.size(); i19++) {
            ((f) this.Z.get(i19)).onLayout(view);
        }
        return true;
    }

    View l0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View l02 = l0(viewGroup.getChildAt(i11));
                if (l02 != null) {
                    return l02;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(n0(i11, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, this.f28466l, marginLayoutParams.width), n0(i13, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, this.f28467m, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f11, float f12) {
        WeakReference weakReference;
        if (A0() && (weakReference = this.Y) != null && view2 == weakReference.get()) {
            return this.M != 3 || super.o(coordinatorLayout, view, view2, f11, f12);
        }
        return false;
    }

    public int o0() {
        if (this.f28449b) {
            return this.E;
        }
        return Math.max(this.D, this.f28473s ? 0 : this.f28478x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i p0() {
        return this.f28464j;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 1) {
            return;
        }
        WeakReference weakReference = this.Y;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!A0() || view2 == view3) {
            int top = view.getTop();
            int i14 = top - i12;
            if (i12 > 0) {
                if (i14 < o0()) {
                    int o02 = top - o0();
                    iArr[1] = o02;
                    ViewCompat.offsetTopAndBottom(view, -o02);
                    V0(3);
                } else {
                    if (!this.L) {
                        return;
                    }
                    iArr[1] = i12;
                    ViewCompat.offsetTopAndBottom(view, -i12);
                    V0(1);
                }
            } else if (i12 < 0 && !view2.canScrollVertically(-1)) {
                if (i14 > this.H && !f0()) {
                    int i15 = top - this.H;
                    iArr[1] = i15;
                    ViewCompat.offsetTopAndBottom(view, -i15);
                    V0(4);
                } else {
                    if (!this.L) {
                        return;
                    }
                    iArr[1] = i12;
                    ViewCompat.offsetTopAndBottom(view, -i12);
                    V0(1);
                }
            }
            k0(view.getTop());
            this.Q = i12;
            this.R = true;
        }
    }

    public int q0() {
        return this.M;
    }

    @Override // wa.b
    public void startBackProgress(androidx.activity.b bVar) {
        wa.f fVar = this.f28450b0;
        if (fVar == null) {
            return;
        }
        fVar.j(bVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
    }

    @Override // wa.b
    public void updateBackProgress(androidx.activity.b bVar) {
        wa.f fVar = this.f28450b0;
        if (fVar == null) {
            return;
        }
        fVar.l(bVar);
    }

    public boolean v0() {
        return this.f28449b;
    }

    public boolean w0() {
        return this.f28469o;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.x(coordinatorLayout, view, savedState.getSuperState());
        E0(savedState);
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            this.M = 4;
            this.N = 4;
        } else {
            this.M = i11;
            this.N = i11;
        }
    }

    public boolean x0() {
        return this.J;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.y(coordinatorLayout, view), (BottomSheetBehavior<?>) this);
    }

    public boolean y0() {
        return true;
    }
}
