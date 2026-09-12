package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.util.h;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.card.MaterialCardView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {

    /* renamed from: u, reason: collision with root package name */
    static final String f7955u;

    /* renamed from: v, reason: collision with root package name */
    static final Class[] f7956v;

    /* renamed from: w, reason: collision with root package name */
    static final ThreadLocal f7957w;

    /* renamed from: x, reason: collision with root package name */
    static final Comparator f7958x;

    /* renamed from: y, reason: collision with root package name */
    private static final androidx.core.util.f f7959y;

    /* renamed from: a, reason: collision with root package name */
    private final List f7960a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.b f7961b;

    /* renamed from: c, reason: collision with root package name */
    private final List f7962c;

    /* renamed from: d, reason: collision with root package name */
    private final List f7963d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f7964e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f7965f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f7966g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7967h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7968i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f7969j;

    /* renamed from: k, reason: collision with root package name */
    private View f7970k;

    /* renamed from: l, reason: collision with root package name */
    private View f7971l;

    /* renamed from: m, reason: collision with root package name */
    private g f7972m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7973n;

    /* renamed from: o, reason: collision with root package name */
    private WindowInsetsCompat f7974o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7975p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f7976q;

    /* renamed from: r, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f7977r;

    /* renamed from: s, reason: collision with root package name */
    private OnApplyWindowInsetsListener f7978s;

    /* renamed from: t, reason: collision with root package name */
    private final NestedScrollingParentHelper f7979t;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        SparseArray<Parcelable> behaviorStates;

        /* loaded from: classes.dex */
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                this.behaviorStates.append(iArr[i11], readParcelableArray[i11]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr[i12] = this.behaviorStates.keyAt(i12);
                parcelableArr[i12] = this.behaviorStates.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i11);
        }
    }

    /* loaded from: classes.dex */
    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            float z10 = ViewCompat.getZ(view);
            float z11 = ViewCompat.getZ(view2);
            if (z10 > z11) {
                return -1;
            }
            return z10 < z11 ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return CoordinatorLayout.this.J(windowInsetsCompat);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        c getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11, int i12) {
            if (i12 == 0) {
                return z(coordinatorLayout, view, view2, view3, i11);
            }
            return false;
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void C(CoordinatorLayout coordinatorLayout, View view, View view2, int i11) {
            if (i11 == 0) {
                B(coordinatorLayout, view, view2);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return ViewCompat.MEASURED_STATE_MASK;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public WindowInsetsCompat f(CoordinatorLayout coordinatorLayout, View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13, int i14) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f11, float f12, boolean z10) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f11, float f12) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int[] iArr, int i13) {
            if (i13 == 0) {
                p(coordinatorLayout, view, view2, i11, i12, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int i13, int i14) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int i13, int i14, int i15) {
            if (i15 == 0) {
                r(coordinatorLayout, view, view2, i11, i12, i13, i14);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
            s(coordinatorLayout, view, view2, i11, i12, i13, i14, i15);
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11) {
        }

        public void v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11, int i12) {
            if (i12 == 0) {
                u(coordinatorLayout, view, view2, view3, i11);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i11) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface d {
        Class value();
    }

    /* loaded from: classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7977r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.w(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f7977r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        c f7982a;

        /* renamed from: b, reason: collision with root package name */
        boolean f7983b;

        /* renamed from: c, reason: collision with root package name */
        public int f7984c;

        /* renamed from: d, reason: collision with root package name */
        public int f7985d;

        /* renamed from: e, reason: collision with root package name */
        public int f7986e;

        /* renamed from: f, reason: collision with root package name */
        int f7987f;

        /* renamed from: g, reason: collision with root package name */
        public int f7988g;

        /* renamed from: h, reason: collision with root package name */
        public int f7989h;

        /* renamed from: i, reason: collision with root package name */
        int f7990i;

        /* renamed from: j, reason: collision with root package name */
        int f7991j;

        /* renamed from: k, reason: collision with root package name */
        View f7992k;

        /* renamed from: l, reason: collision with root package name */
        View f7993l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f7994m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f7995n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f7996o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f7997p;

        /* renamed from: q, reason: collision with root package name */
        final Rect f7998q;

        /* renamed from: r, reason: collision with root package name */
        Object f7999r;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f7983b = false;
            this.f7984c = 0;
            this.f7985d = 0;
            this.f7986e = -1;
            this.f7987f = -1;
            this.f7988g = 0;
            this.f7989h = 0;
            this.f7998q = new Rect();
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7983b = false;
            this.f7984c = 0;
            this.f7985d = 0;
            this.f7986e = -1;
            this.f7987f = -1;
            this.f7988g = 0;
            this.f7989h = 0;
            this.f7998q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f7984c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f7987f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f7985d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f7986e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f7988g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f7989h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f7983b = hasValue;
            if (hasValue) {
                this.f7982a = CoordinatorLayout.x(context, attributeSet, obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f7982a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7983b = false;
            this.f7984c = 0;
            this.f7985d = 0;
            this.f7986e = -1;
            this.f7987f = -1;
            this.f7988g = 0;
            this.f7989h = 0;
            this.f7998q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7983b = false;
            this.f7984c = 0;
            this.f7985d = 0;
            this.f7986e = -1;
            this.f7987f = -1;
            this.f7988g = 0;
            this.f7989h = 0;
            this.f7998q = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f7983b = false;
            this.f7984c = 0;
            this.f7985d = 0;
            this.f7986e = -1;
            this.f7987f = -1;
            this.f7988g = 0;
            this.f7989h = 0;
            this.f7998q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f7987f);
            this.f7992k = findViewById;
            if (findViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f7993l = null;
                    this.f7992k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f7987f) + " to anchor view " + view);
            }
            if (findViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f7993l = null;
                this.f7992k = null;
                return;
            }
            for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f7993l = null;
                    this.f7992k = null;
                    return;
                }
                if (parent instanceof View) {
                    findViewById = parent;
                }
            }
            this.f7993l = findViewById;
        }

        private boolean s(View view, int i11) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(((f) view.getLayoutParams()).f7988g, i11);
            return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.f7989h, i11) & absoluteGravity) == absoluteGravity;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f7992k.getId() != this.f7987f) {
                return false;
            }
            View view2 = this.f7992k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f7993l = null;
                    this.f7992k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f7993l = view2;
            return true;
        }

        boolean a() {
            return this.f7992k == null && this.f7987f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f7993l || s(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((cVar = this.f7982a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f7982a == null) {
                this.f7994m = false;
            }
            return this.f7994m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f7987f == -1) {
                this.f7993l = null;
                this.f7992k = null;
                return null;
            }
            if (this.f7992k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f7992k;
        }

        public int e() {
            return this.f7987f;
        }

        public c f() {
            return this.f7982a;
        }

        boolean g() {
            return this.f7997p;
        }

        Rect h() {
            return this.f7998q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10 = this.f7994m;
            if (z10) {
                return true;
            }
            c cVar = this.f7982a;
            boolean a11 = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z10;
            this.f7994m = a11;
            return a11;
        }

        boolean j(int i11) {
            if (i11 == 0) {
                return this.f7995n;
            }
            if (i11 != 1) {
                return false;
            }
            return this.f7996o;
        }

        void k() {
            this.f7997p = false;
        }

        void l(int i11) {
            r(i11, false);
        }

        void m() {
            this.f7994m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f7982a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f7982a = cVar;
                this.f7999r = null;
                this.f7983b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        void p(boolean z10) {
            this.f7997p = z10;
        }

        void q(Rect rect) {
            this.f7998q.set(rect);
        }

        void r(int i11, boolean z10) {
            if (i11 == 0) {
                this.f7995n = z10;
            } else {
                if (i11 != 1) {
                    return;
                }
                this.f7996o = z10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.w(0);
            return true;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f7955u = r02 != null ? r02.getName() : null;
        f7958x = new ViewElevationComparator();
        f7956v = new Class[]{Context.class, AttributeSet.class};
        f7957w = new ThreadLocal();
        f7959y = new h(12);
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7960a = new ArrayList();
        this.f7961b = new androidx.coordinatorlayout.widget.b();
        this.f7962c = new ArrayList();
        this.f7963d = new ArrayList();
        this.f7965f = new int[2];
        this.f7966g = new int[2];
        this.f7979t = new NestedScrollingParentHelper(this);
        TypedArray obtainStyledAttributes = i11 == 0 ? context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i11, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i11 == 0) {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R$style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, i11, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f7969j = resources.getIntArray(resourceId);
            float f11 = resources.getDisplayMetrics().density;
            int length = this.f7969j.length;
            for (int i12 = 0; i12 < length; i12++) {
                this.f7969j[i12] = (int) (r12[i12] * f11);
            }
        }
        this.f7976q = obtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        K();
        super.setOnHierarchyChangeListener(new e());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    private static void B(Rect rect) {
        rect.setEmpty();
        f7959y.release(rect);
    }

    private void D(boolean z10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            c f11 = ((f) childAt.getLayoutParams()).f();
            if (f11 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    f11.k(this, childAt, obtain);
                } else {
                    f11.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            ((f) getChildAt(i12).getLayoutParams()).m();
        }
        this.f7970k = null;
        this.f7967h = false;
    }

    private static int E(int i11) {
        if (i11 == 0) {
            return 17;
        }
        return i11;
    }

    private static int F(int i11) {
        if ((i11 & 7) == 0) {
            i11 |= GravityCompat.START;
        }
        return (i11 & 112) == 0 ? i11 | 48 : i11;
    }

    private static int G(int i11) {
        return i11 == 0 ? MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END : i11;
    }

    private void H(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        int i12 = fVar.f7990i;
        if (i12 != i11) {
            ViewCompat.offsetLeftAndRight(view, i11 - i12);
            fVar.f7990i = i11;
        }
    }

    private void I(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        int i12 = fVar.f7991j;
        if (i12 != i11) {
            ViewCompat.offsetTopAndBottom(view, i11 - i12);
            fVar.f7991j = i11;
        }
    }

    private void K() {
        if (!ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
            return;
        }
        if (this.f7978s == null) {
            this.f7978s = new a();
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, this.f7978s);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect rect = (Rect) f7959y.acquire();
        return rect == null ? new Rect() : rect;
    }

    private static int c(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }

    private void d(f fVar, Rect rect, int i11, int i12) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i11) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i12) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i11 + max, i12 + max2);
    }

    private WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat) {
        c f11;
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (ViewCompat.getFitsSystemWindows(childAt) && (f11 = ((f) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = f11.f(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.isConsumed()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    private void l(View view, int i11, Rect rect, Rect rect2, f fVar, int i12, int i13) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(E(fVar.f7984c), i11);
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(F(fVar.f7985d), i11);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        int width = i16 != 1 ? i16 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i17 != 16 ? i17 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i14 == 1) {
            width -= i12 / 2;
        } else if (i14 != 5) {
            width -= i12;
        }
        if (i15 == 16) {
            height -= i13 / 2;
        } else if (i15 != 80) {
            height -= i13;
        }
        rect2.set(width, height, i12 + width, i13 + height);
    }

    private int m(int i11) {
        int[] iArr = this.f7969j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i11);
            return 0;
        }
        if (i11 >= 0 && i11 < iArr.length) {
            return iArr[i11];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i11 + " out of range for " + this);
        return 0;
    }

    private void p(List list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i11) : i11));
        }
        Comparator comparator = f7958x;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean q(View view) {
        return this.f7961b.j(view);
    }

    private void r(View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        Rect a11 = a();
        a11.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f7974o != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
            a11.left += this.f7974o.getSystemWindowInsetLeft();
            a11.top += this.f7974o.getSystemWindowInsetTop();
            a11.right -= this.f7974o.getSystemWindowInsetRight();
            a11.bottom -= this.f7974o.getSystemWindowInsetBottom();
        }
        Rect a12 = a();
        GravityCompat.apply(F(fVar.f7984c), view.getMeasuredWidth(), view.getMeasuredHeight(), a11, a12, i11);
        view.layout(a12.left, a12.top, a12.right, a12.bottom);
        B(a11);
        B(a12);
    }

    private void s(View view, View view2, int i11) {
        Rect a11 = a();
        Rect a12 = a();
        try {
            j(view2, a11);
            k(view, i11, a11, a12);
            view.layout(a12.left, a12.top, a12.right, a12.bottom);
        } finally {
            B(a11);
            B(a12);
        }
    }

    private void t(View view, int i11, int i12) {
        f fVar = (f) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(G(fVar.f7984c), i12);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i12 == 1) {
            i11 = width - i11;
        }
        int m11 = m(i11) - measuredWidth;
        if (i13 == 1) {
            m11 += measuredWidth / 2;
        } else if (i13 == 5) {
            m11 += measuredWidth;
        }
        int i15 = i14 != 16 ? i14 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(m11, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i15, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void u(View view, Rect rect, int i11) {
        boolean z10;
        boolean z11;
        int width;
        int i12;
        int i13;
        int i14;
        int height;
        int i15;
        int i16;
        int i17;
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c f11 = fVar.f();
            Rect a11 = a();
            Rect a12 = a();
            a12.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f11 == null || !f11.b(this, view, a11)) {
                a11.set(a12);
            } else if (!a12.contains(a11)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a11.toShortString() + " | Bounds:" + a12.toShortString());
            }
            B(a12);
            if (a11.isEmpty()) {
                B(a11);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(fVar.f7989h, i11);
            boolean z12 = true;
            if ((absoluteGravity & 48) != 48 || (i16 = (a11.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f7991j) >= (i17 = rect.top)) {
                z10 = false;
            } else {
                I(view, i17 - i16);
                z10 = true;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - a11.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f7991j) < (i15 = rect.bottom)) {
                I(view, height - i15);
                z10 = true;
            }
            if (!z10) {
                I(view, 0);
            }
            if ((absoluteGravity & 3) != 3 || (i13 = (a11.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f7990i) >= (i14 = rect.left)) {
                z11 = false;
            } else {
                H(view, i14 - i13);
                z11 = true;
            }
            if ((absoluteGravity & 5) != 5 || (width = ((getWidth() - a11.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f7990i) >= (i12 = rect.right)) {
                z12 = z11;
            } else {
                H(view, width - i12);
            }
            if (!z12) {
                H(view, 0);
            }
            B(a11);
        }
    }

    static c x(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f7955u;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f7957w;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f7956v);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(context, attributeSet);
        } catch (Exception e11) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e11);
        }
    }

    private boolean y(MotionEvent motionEvent, int i11) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f7962c;
        p(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z10 = false;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) list.get(i12);
            f fVar = (f) view.getLayoutParams();
            c f11 = fVar.f();
            if (!(z10 || z11) || actionMasked == 0) {
                if (!z10 && f11 != null) {
                    if (i11 == 0) {
                        z10 = f11.k(this, view, motionEvent);
                    } else if (i11 == 1) {
                        z10 = f11.D(this, view, motionEvent);
                    }
                    if (z10) {
                        this.f7970k = view;
                    }
                }
                boolean c11 = fVar.c();
                boolean i13 = fVar.i(this, view);
                z11 = i13 && !c11;
                if (i13 && !z11) {
                    break;
                }
            } else if (f11 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i11 == 0) {
                    f11.k(this, view, motionEvent2);
                } else if (i11 == 1) {
                    f11.D(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z10;
    }

    private void z() {
        this.f7960a.clear();
        this.f7961b.c();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f o11 = o(childAt);
            o11.d(this, childAt);
            this.f7961b.b(childAt);
            for (int i12 = 0; i12 < childCount; i12++) {
                if (i12 != i11) {
                    View childAt2 = getChildAt(i12);
                    if (o11.b(this, childAt, childAt2)) {
                        if (!this.f7961b.d(childAt2)) {
                            this.f7961b.b(childAt2);
                        }
                        this.f7961b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f7960a.addAll(this.f7961b.i());
        Collections.reverse(this.f7960a);
    }

    void A(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    void C() {
        if (this.f7968i && this.f7972m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7972m);
        }
        this.f7973n = false;
    }

    final WindowInsetsCompat J(WindowInsetsCompat windowInsetsCompat) {
        if (androidx.core.util.d.a(this.f7974o, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.f7974o = windowInsetsCompat;
        boolean z10 = false;
        boolean z11 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        this.f7975p = z11;
        if (!z11 && getBackground() == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        WindowInsetsCompat e11 = e(windowInsetsCompat);
        requestLayout();
        return e11;
    }

    void b() {
        if (this.f7968i) {
            if (this.f7972m == null) {
                this.f7972m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7972m);
        }
        this.f7973n = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void dispatchDependentViewsChanged(@NonNull View view) {
        List g11 = this.f7961b.g(view);
        if (g11 == null || g11.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < g11.size(); i11++) {
            View view2 = (View) g11.get(i11);
            c f11 = ((f) view2.getLayoutParams()).f();
            if (f11 != null) {
                f11.h(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(@NonNull View view, @NonNull View view2) {
        boolean z10 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect a11 = a();
        i(view, view.getParent() != this, a11);
        Rect a12 = a();
        i(view2, view2.getParent() != this, a12);
        try {
            if (a11.left <= a12.right && a11.top <= a12.bottom && a11.right >= a12.left) {
                if (a11.bottom >= a12.top) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            B(a11);
            B(a12);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j11) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f7982a;
        if (cVar != null) {
            float d11 = cVar.d(this, view);
            if (d11 > 0.0f) {
                if (this.f7964e == null) {
                    this.f7964e = new Paint();
                }
                this.f7964e.setColor(fVar.f7982a.c(this, view));
                this.f7964e.setAlpha(c(Math.round(d11 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f7964e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7976q;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    void f() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            if (q(getChildAt(i11))) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10 != this.f7973n) {
            if (z10) {
                b();
            } else {
                C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        List h11 = this.f7961b.h(view);
        this.f7963d.clear();
        if (h11 != null) {
            this.f7963d.addAll(h11);
        }
        return this.f7963d;
    }

    final List<View> getDependencySortedChildren() {
        z();
        return Collections.unmodifiableList(this.f7960a);
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        List g11 = this.f7961b.g(view);
        this.f7963d.clear();
        if (g11 != null) {
            this.f7963d.addAll(g11);
        }
        return this.f7963d;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f7974o;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f7979t.getNestedScrollAxes();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.f7976q;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void i(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            j(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean isPointInChildBounds(@NonNull View view, int i11, int i12) {
        Rect a11 = a();
        j(view, a11);
        try {
            return a11.contains(i11, i12);
        } finally {
            B(a11);
        }
    }

    void j(View view, Rect rect) {
        androidx.coordinatorlayout.widget.c.a(this, view, rect);
    }

    void k(View view, int i11, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        l(view, i11, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    void n(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f o(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f7983b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f7983b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o((c) dVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e11) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e11);
                    }
                }
                fVar.f7983b = true;
            }
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        D(false);
        if (this.f7973n) {
            if (this.f7972m == null) {
                this.f7972m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f7972m);
        }
        if (this.f7974o == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.f7968i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D(false);
        if (this.f7973n && this.f7972m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f7972m);
        }
        View view = this.f7971l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f7968i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f7975p || this.f7976q == null) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.f7974o;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f7976q.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f7976q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            D(true);
        }
        boolean y10 = y(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            D(true);
        }
        return y10;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        c f11;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f7960a.size();
        for (int i15 = 0; i15 < size; i15++) {
            View view = (View) this.f7960a.get(i15);
            if (view.getVisibility() != 8 && ((f11 = ((f) view.getLayoutParams()).f()) == null || !f11.l(this, view, layoutDirection))) {
                onLayoutChild(view, layoutDirection);
            }
        }
    }

    public void onLayoutChild(@NonNull View view, int i11) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f7992k;
        if (view2 != null) {
            s(view, view2, i11);
            return;
        }
        int i12 = fVar.f7986e;
        if (i12 >= 0) {
            t(view, i12, i11);
        } else {
            r(view, i11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011c, code lost:
    
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f11, float f12, boolean z10) {
        c f13;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f13 = fVar.f()) != null) {
                    z11 |= f13.n(this, childAt, view, f11, f12, z10);
                }
            }
        }
        if (z11) {
            w(1);
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f11, float f12) {
        c f13;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f13 = fVar.f()) != null) {
                    z10 |= f13.o(this, childAt, view, f11, f12);
                }
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
        onNestedPreScroll(view, i11, i12, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        c f11;
        int childCount = getChildCount();
        boolean z10 = false;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i13) && (f11 = fVar.f()) != null) {
                    int[] iArr2 = this.f7965f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f11.q(this, childAt, view, i11, i12, iArr2, i13);
                    int[] iArr3 = this.f7965f;
                    i14 = i11 > 0 ? Math.max(i14, iArr3[0]) : Math.min(i14, iArr3[0]);
                    int[] iArr4 = this.f7965f;
                    i15 = i12 > 0 ? Math.max(i15, iArr4[1]) : Math.min(i15, iArr4[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = i14;
        iArr[1] = i15;
        if (z10) {
            w(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i11, i12, i13, i14, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        onNestedScroll(view, i11, i12, i13, i14, 0, this.f7966g);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, @NonNull int[] iArr) {
        c f11;
        boolean z10;
        int min;
        int childCount = getChildCount();
        boolean z11 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i15) && (f11 = fVar.f()) != null) {
                    int[] iArr2 = this.f7965f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f11.t(this, childAt, view, i11, i12, i13, i14, i15, iArr2);
                    int[] iArr3 = this.f7965f;
                    i16 = i13 > 0 ? Math.max(i16, iArr3[0]) : Math.min(i16, iArr3[0]);
                    if (i14 > 0) {
                        z10 = true;
                        min = Math.max(i17, this.f7965f[1]);
                    } else {
                        z10 = true;
                        min = Math.min(i17, this.f7965f[1]);
                    }
                    i17 = min;
                    z11 = z10;
                }
            }
        }
        iArr[0] = iArr[0] + i16;
        iArr[1] = iArr[1] + i17;
        if (z11) {
            w(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i11) {
        onNestedScrollAccepted(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        c f11;
        this.f7979t.onNestedScrollAccepted(view, view2, i11, i12);
        this.f7971l = view2;
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i12) && (f11 = fVar.f()) != null) {
                f11.v(this, childAt, view, view2, i11, i12);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            c f11 = o(childAt).f();
            if (id2 != -1 && f11 != null && (parcelable2 = sparseArray.get(id2)) != null) {
                f11.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable y10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            c f11 = ((f) childAt.getLayoutParams()).f();
            if (id2 != -1 && f11 != null && (y10 = f11.y(this, childAt)) != null) {
                sparseArray.append(id2, y10);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i11) {
        return onStartNestedScroll(view, view2, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c f11 = fVar.f();
                if (f11 != null) {
                    boolean A = f11.A(this, childAt, view, view2, i11, i12);
                    z10 |= A;
                    fVar.r(i12, A);
                } else {
                    fVar.r(i12, false);
                }
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i11) {
        this.f7979t.onStopNestedScroll(view, i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i11)) {
                c f11 = fVar.f();
                if (f11 != null) {
                    f11.C(this, childAt, view, i11);
                }
                fVar.l(i11);
                fVar.k();
            }
        }
        this.f7971l = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f7970k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.y(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f7970k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f7970k
            boolean r6 = r6.D(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f7970k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.D(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        c f11 = ((f) view.getLayoutParams()).f();
        if (f11 == null || !f11.w(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f7967h) {
            return;
        }
        D(false);
        this.f7967h = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        K();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f7977r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f7976q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f7976q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f7976q.setState(getDrawableState());
                }
                a1.a.m(this.f7976q, ViewCompat.getLayoutDirection(this));
                this.f7976q.setVisible(getVisibility() == 0, false);
                this.f7976q.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarBackgroundColor(int i11) {
        setStatusBarBackground(new ColorDrawable(i11));
    }

    public void setStatusBarBackgroundResource(int i11) {
        setStatusBarBackground(i11 != 0 ? androidx.core.content.b.getDrawable(getContext(), i11) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z10 = i11 == 0;
        Drawable drawable = this.f7976q;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.f7976q.setVisible(z10, false);
    }

    void v(View view, int i11) {
        c f11;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f7992k != null) {
            Rect a11 = a();
            Rect a12 = a();
            Rect a13 = a();
            j(fVar.f7992k, a11);
            i(view, false, a12);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            l(view, i11, a11, a13, fVar, measuredWidth, measuredHeight);
            boolean z10 = (a13.left == a12.left && a13.top == a12.top) ? false : true;
            d(fVar, a13, measuredWidth, measuredHeight);
            int i12 = a13.left - a12.left;
            int i13 = a13.top - a12.top;
            if (i12 != 0) {
                ViewCompat.offsetLeftAndRight(view, i12);
            }
            if (i13 != 0) {
                ViewCompat.offsetTopAndBottom(view, i13);
            }
            if (z10 && (f11 = fVar.f()) != null) {
                f11.h(this, view, fVar.f7992k);
            }
            B(a11);
            B(a12);
            B(a13);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7976q;
    }

    final void w(int i11) {
        boolean z10;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.f7960a.size();
        Rect a11 = a();
        Rect a12 = a();
        Rect a13 = a();
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) this.f7960a.get(i12);
            f fVar = (f) view.getLayoutParams();
            if (i11 != 0 || view.getVisibility() != 8) {
                for (int i13 = 0; i13 < i12; i13++) {
                    if (fVar.f7993l == ((View) this.f7960a.get(i13))) {
                        v(view, layoutDirection);
                    }
                }
                i(view, true, a12);
                if (fVar.f7988g != 0 && !a12.isEmpty()) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(fVar.f7988g, layoutDirection);
                    int i14 = absoluteGravity & 112;
                    if (i14 == 48) {
                        a11.top = Math.max(a11.top, a12.bottom);
                    } else if (i14 == 80) {
                        a11.bottom = Math.max(a11.bottom, getHeight() - a12.top);
                    }
                    int i15 = absoluteGravity & 7;
                    if (i15 == 3) {
                        a11.left = Math.max(a11.left, a12.right);
                    } else if (i15 == 5) {
                        a11.right = Math.max(a11.right, getWidth() - a12.left);
                    }
                }
                if (fVar.f7989h != 0 && view.getVisibility() == 0) {
                    u(view, a11, layoutDirection);
                }
                if (i11 != 2) {
                    n(view, a13);
                    if (!a13.equals(a12)) {
                        A(view, a12);
                    }
                }
                for (int i16 = i12 + 1; i16 < size; i16++) {
                    View view2 = (View) this.f7960a.get(i16);
                    f fVar2 = (f) view2.getLayoutParams();
                    c f11 = fVar2.f();
                    if (f11 != null && f11.e(this, view2, view)) {
                        if (i11 == 0 && fVar2.g()) {
                            fVar2.k();
                        } else {
                            if (i11 != 2) {
                                z10 = f11.h(this, view2, view);
                            } else {
                                f11.i(this, view2, view);
                                z10 = true;
                            }
                            if (i11 == 1) {
                                fVar2.p(z10);
                            }
                        }
                    }
                }
            }
        }
        B(a11);
        B(a12);
        B(a13);
    }
}
