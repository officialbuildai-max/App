package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    static final boolean N;
    private static final boolean O;
    private static boolean P = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private CharSequence A;
    private Object B;
    private boolean C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private final ArrayList H;
    private Rect I;
    private Matrix J;
    private final AccessibilityViewCommand K;

    /* renamed from: a, reason: collision with root package name */
    private final d f9024a;

    /* renamed from: b, reason: collision with root package name */
    private float f9025b;

    /* renamed from: c, reason: collision with root package name */
    private int f9026c;

    /* renamed from: d, reason: collision with root package name */
    private int f9027d;

    /* renamed from: e, reason: collision with root package name */
    private float f9028e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f9029f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewDragHelper f9030g;

    /* renamed from: h, reason: collision with root package name */
    private final ViewDragHelper f9031h;

    /* renamed from: i, reason: collision with root package name */
    private final ViewDragCallback f9032i;

    /* renamed from: j, reason: collision with root package name */
    private final ViewDragCallback f9033j;

    /* renamed from: k, reason: collision with root package name */
    private int f9034k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9035l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9036m;

    /* renamed from: n, reason: collision with root package name */
    private int f9037n;

    /* renamed from: o, reason: collision with root package name */
    private int f9038o;

    /* renamed from: p, reason: collision with root package name */
    private int f9039p;

    /* renamed from: q, reason: collision with root package name */
    private int f9040q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9041r;

    /* renamed from: s, reason: collision with root package name */
    private e f9042s;

    /* renamed from: t, reason: collision with root package name */
    private List f9043t;

    /* renamed from: u, reason: collision with root package name */
    private float f9044u;

    /* renamed from: v, reason: collision with root package name */
    private float f9045v;

    /* renamed from: w, reason: collision with root package name */
    private Drawable f9046w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f9047x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f9048y;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence f9049z;
    private static final int[] L = {R.attr.colorPrimaryDark};
    static final int[] M = {R.attr.layout_gravity};

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        /* loaded from: classes.dex */
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

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ViewDragCallback extends ViewDragHelper.b {

        /* renamed from: a, reason: collision with root package name */
        private final int f9050a;

        /* renamed from: b, reason: collision with root package name */
        private ViewDragHelper f9051b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f9052c = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDragCallback.this.b();
            }
        };

        ViewDragCallback(int i11) {
            this.f9050a = i11;
        }

        private void a() {
            View h11 = DrawerLayout.this.h(this.f9050a == 3 ? 5 : 3);
            if (h11 != null) {
                DrawerLayout.this.closeDrawer(h11);
            }
        }

        void b() {
            View h11;
            int width;
            int edgeSize = this.f9051b.getEdgeSize();
            boolean z10 = this.f9050a == 3;
            if (z10) {
                h11 = DrawerLayout.this.h(3);
                width = (h11 != null ? -h11.getWidth() : 0) + edgeSize;
            } else {
                h11 = DrawerLayout.this.h(5);
                width = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (h11 != null) {
                if (((!z10 || h11.getLeft() >= width) && (z10 || h11.getLeft() <= width)) || DrawerLayout.this.getDrawerLockMode(h11) != 0) {
                    return;
                }
                f fVar = (f) h11.getLayoutParams();
                this.f9051b.smoothSlideViewTo(h11, width, h11.getTop());
                fVar.f9060c = true;
                DrawerLayout.this.invalidate();
                a();
                DrawerLayout.this.a();
            }
        }

        public void c() {
            DrawerLayout.this.removeCallbacks(this.f9052c);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            if (DrawerLayout.this.b(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i11, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i11, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        public void d(ViewDragHelper viewDragHelper) {
            this.f9051b = viewDragHelper;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.t(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onEdgeDragStarted(int i11, int i12) {
            View h11 = (i11 & 1) == 1 ? DrawerLayout.this.h(3) : DrawerLayout.this.h(5);
            if (h11 == null || DrawerLayout.this.getDrawerLockMode(h11) != 0) {
                return;
            }
            this.f9051b.captureChildView(h11, i12);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean onEdgeLock(int i11) {
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onEdgeTouched(int i11, int i12) {
            DrawerLayout.this.postDelayed(this.f9052c, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewCaptured(View view, int i11) {
            ((f) view.getLayoutParams()).f9060c = false;
            a();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewDragStateChanged(int i11) {
            DrawerLayout.this.D(i11, this.f9051b.getCapturedView());
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            float width = (DrawerLayout.this.b(view, 3) ? i11 + r3 : DrawerLayout.this.getWidth() - i11) / view.getWidth();
            DrawerLayout.this.A(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            float l11 = DrawerLayout.this.l(view);
            int width = view.getWidth();
            if (DrawerLayout.this.b(view, 3)) {
                i11 = (f11 > 0.0f || (f11 == 0.0f && l11 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f11 < 0.0f || (f11 == 0.0f && l11 > 0.5f)) {
                    width2 -= width;
                }
                i11 = width2;
            }
            this.f9051b.settleCapturedViewAt(i11, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.b
        public boolean tryCaptureView(View view, int i11) {
            return DrawerLayout.this.t(view) && DrawerLayout.this.b(view, this.f9050a) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }
    }

    /* loaded from: classes.dex */
    class a implements AccessibilityViewCommand {
        a() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            if (!DrawerLayout.this.isDrawerOpen(view) || DrawerLayout.this.getDrawerLockMode(view) == 2) {
                return false;
            }
            DrawerLayout.this.closeDrawer(view);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnApplyWindowInsetsListener {
        b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* loaded from: classes.dex */
    class c extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f9056a = new Rect();

        c() {
        }

        private void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (DrawerLayout.r(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        private void b(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f9056a;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View j11 = DrawerLayout.this.j();
            if (j11 == null) {
                return true;
            }
            CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.k(j11));
            if (drawerTitle == null) {
                return true;
            }
            text.add(drawerTitle);
            return true;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.N) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, obtain);
                accessibilityNodeInfoCompat.setSource(view);
                Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                b(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.N || DrawerLayout.r(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends AccessibilityDelegateCompat {
        d() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (DrawerLayout.r(view)) {
                return;
            }
            accessibilityNodeInfoCompat.setParent(null);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view);

        void b(View view);

        void c(int i11);

        void d(View view, float f11);
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f9058a;

        /* renamed from: b, reason: collision with root package name */
        float f9059b;

        /* renamed from: c, reason: collision with root package name */
        boolean f9060c;

        /* renamed from: d, reason: collision with root package name */
        int f9061d;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f9058a = 0;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9058a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f9058a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9058a = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9058a = 0;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f9058a = 0;
            this.f9058a = fVar.f9058a;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int i11) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View view, float f11) {
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        N = true;
        O = true;
        P = i11 >= 29;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.drawerLayoutStyle);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f9024a = new d();
        this.f9027d = -1728053248;
        this.f9029f = new Paint();
        this.f9036m = true;
        this.f9037n = 3;
        this.f9038o = 3;
        this.f9039p = 3;
        this.f9040q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a();
        setDescendantFocusability(262144);
        float f11 = getResources().getDisplayMetrics().density;
        this.f9026c = (int) ((64.0f * f11) + 0.5f);
        float f12 = f11 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.f9032i = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.f9033j = viewDragCallback2;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, viewDragCallback);
        this.f9030g = create;
        create.setEdgeTrackingEnabled(1);
        create.setMinVelocity(f12);
        viewDragCallback.d(create);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, viewDragCallback2);
        this.f9031h = create2;
        create2.setEdgeTrackingEnabled(2);
        create2.setMinVelocity(f12);
        viewDragCallback2.d(create2);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new c());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
            try {
                this.f9046w = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i11, 0);
        try {
            if (obtainStyledAttributes2.hasValue(R$styleable.DrawerLayout_elevation)) {
                this.f9025b = obtainStyledAttributes2.getDimension(R$styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.f9025b = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.H = new ArrayList();
        } catch (Throwable th2) {
            obtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    private void B(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS;
        ViewCompat.removeAccessibilityAction(view, accessibilityActionCompat.getId());
        if (!isDrawerOpen(view) || getDrawerLockMode(view) == 2) {
            return;
        }
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, this.K);
    }

    private void C(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((z10 || t(childAt)) && !(z10 && childAt == view)) {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            }
        }
    }

    private boolean g(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent m11 = m(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(m11);
            m11.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent m(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.J == null) {
                this.J = new Matrix();
            }
            matrix.invert(this.J);
            obtain.transform(this.J);
        }
        return obtain;
    }

    static String n(int i11) {
        return (i11 & 3) == 3 ? "LEFT" : (i11 & 5) == 5 ? "RIGHT" : Integer.toHexString(i11);
    }

    private static boolean o(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean p() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (((f) getChildAt(i11).getLayoutParams()).f9060c) {
                return true;
            }
        }
        return false;
    }

    private boolean q() {
        return j() != null;
    }

    static boolean r(View view) {
        return (ViewCompat.getImportantForAccessibility(view) == 4 || ViewCompat.getImportantForAccessibility(view) == 2) ? false : true;
    }

    private boolean u(float f11, float f12, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f11, (int) f12);
    }

    private void v(Drawable drawable, int i11) {
        if (drawable == null || !a1.a.h(drawable)) {
            return;
        }
        a1.a.m(drawable, i11);
    }

    private Drawable x() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                v(drawable, layoutDirection);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                v(drawable2, layoutDirection);
                return this.E;
            }
        }
        return this.F;
    }

    private Drawable y() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                v(drawable, layoutDirection);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                v(drawable2, layoutDirection);
                return this.D;
            }
        }
        return this.G;
    }

    private void z() {
        if (O) {
            return;
        }
        this.f9047x = x();
        this.f9048y = y();
    }

    void A(View view, float f11) {
        f fVar = (f) view.getLayoutParams();
        if (f11 == fVar.f9059b) {
            return;
        }
        fVar.f9059b = f11;
        f(view, f11);
    }

    void D(int i11, View view) {
        int i12;
        int viewDragState = this.f9030g.getViewDragState();
        int viewDragState2 = this.f9031h.getViewDragState();
        if (viewDragState == 1 || viewDragState2 == 1) {
            i12 = 1;
        } else {
            i12 = 2;
            if (viewDragState != 2 && viewDragState2 != 2) {
                i12 = 0;
            }
        }
        if (view != null && i11 == 0) {
            float f11 = ((f) view.getLayoutParams()).f9059b;
            if (f11 == 0.0f) {
                d(view);
            } else if (f11 == 1.0f) {
                e(view);
            }
        }
        if (i12 != this.f9034k) {
            this.f9034k = i12;
            List list = this.f9043t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.f9043t.get(size)).c(i12);
                }
            }
        }
    }

    void a() {
        if (this.f9041r) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            getChildAt(i11).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.f9041r = true;
    }

    public void addDrawerListener(@NonNull e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.f9043t == null) {
            this.f9043t = new ArrayList();
        }
        this.f9043t.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (!t(childAt)) {
                this.H.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i11, i12);
                z10 = true;
            }
        }
        if (!z10) {
            int size = this.H.size();
            for (int i14 = 0; i14 < size; i14++) {
                View view = (View) this.H.get(i14);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i11, i12);
                }
            }
        }
        this.H.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (i() != null || t(view)) {
            ViewCompat.setImportantForAccessibility(view, 4);
        } else {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
        if (N) {
            return;
        }
        ViewCompat.setAccessibilityDelegate(view, this.f9024a);
    }

    boolean b(View view, int i11) {
        return (k(view) & i11) == i11;
    }

    void c(boolean z10) {
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (t(childAt) && (!z10 || fVar.f9060c)) {
                z11 |= b(childAt, 3) ? this.f9030g.smoothSlideViewTo(childAt, -childAt.getWidth(), childAt.getTop()) : this.f9031h.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                fVar.f9060c = false;
            }
        }
        this.f9032i.c();
        this.f9033j.c();
        if (z11) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        closeDrawer(GravityCompat.START);
    }

    public void closeDrawer(int i11) {
        closeDrawer(i11, true);
    }

    public void closeDrawer(int i11, boolean z10) {
        View h11 = h(i11);
        if (h11 != null) {
            closeDrawer(h11, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + n(i11));
    }

    public void closeDrawer(@NonNull View view) {
        closeDrawer(view, true);
    }

    public void closeDrawer(@NonNull View view, boolean z10) {
        if (!t(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f9036m) {
            fVar.f9059b = 0.0f;
            fVar.f9061d = 0;
        } else if (z10) {
            fVar.f9061d |= 4;
            if (b(view, 3)) {
                this.f9030g.smoothSlideViewTo(view, -view.getWidth(), view.getTop());
            } else {
                this.f9031h.smoothSlideViewTo(view, getWidth(), view.getTop());
            }
        } else {
            w(view, 0.0f);
            D(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void closeDrawers() {
        c(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < childCount; i11++) {
            f11 = Math.max(f11, ((f) getChildAt(i11).getLayoutParams()).f9059b);
        }
        this.f9028e = f11;
        boolean continueSettling = this.f9030g.continueSettling(true);
        boolean continueSettling2 = this.f9031h.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void d(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f9061d & 1) == 1) {
            fVar.f9061d = 0;
            List list = this.f9043t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.f9043t.get(size)).b(view);
                }
            }
            C(view, false);
            B(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f9028e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            View childAt = getChildAt(i11);
            if (u(x10, y10, childAt) && !s(childAt) && g(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j11) {
        int height = getHeight();
        boolean s11 = s(view);
        int width = getWidth();
        int save = canvas.save();
        int i11 = 0;
        if (s11) {
            int childCount = getChildCount();
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt != view && childAt.getVisibility() == 0 && o(childAt) && t(childAt) && childAt.getHeight() >= height) {
                    if (b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i12) {
                            i12 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i12, 0, width, getHeight());
            i11 = i12;
        }
        boolean drawChild = super.drawChild(canvas, view, j11);
        canvas.restoreToCount(save);
        float f11 = this.f9028e;
        if (f11 > 0.0f && s11) {
            this.f9029f.setColor((this.f9027d & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f11)) << 24));
            canvas.drawRect(i11, 0.0f, width, getHeight(), this.f9029f);
        } else if (this.f9047x != null && b(view, 3)) {
            int intrinsicWidth = this.f9047x.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f9030g.getEdgeSize(), 1.0f));
            this.f9047x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f9047x.setAlpha((int) (max * 255.0f));
            this.f9047x.draw(canvas);
        } else if (this.f9048y != null && b(view, 5)) {
            int intrinsicWidth2 = this.f9048y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f9031h.getEdgeSize(), 1.0f));
            this.f9048y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f9048y.setAlpha((int) (max2 * 255.0f));
            this.f9048y.draw(canvas);
        }
        return drawChild;
    }

    void e(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f9061d & 1) == 0) {
            fVar.f9061d = 1;
            List list = this.f9043t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.f9043t.get(size)).a(view);
                }
            }
            C(view, true);
            B(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void f(View view, float f11) {
        List list = this.f9043t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((e) this.f9043t.get(size)).d(view, f11);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.f9025b;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int i11) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i11 == 3) {
            int i12 = this.f9037n;
            if (i12 != 3) {
                return i12;
            }
            int i13 = layoutDirection == 0 ? this.f9039p : this.f9040q;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        }
        if (i11 == 5) {
            int i14 = this.f9038o;
            if (i14 != 3) {
                return i14;
            }
            int i15 = layoutDirection == 0 ? this.f9040q : this.f9039p;
            if (i15 != 3) {
                return i15;
            }
            return 0;
        }
        if (i11 == 8388611) {
            int i16 = this.f9039p;
            if (i16 != 3) {
                return i16;
            }
            int i17 = layoutDirection == 0 ? this.f9037n : this.f9038o;
            if (i17 != 3) {
                return i17;
            }
            return 0;
        }
        if (i11 != 8388613) {
            return 0;
        }
        int i18 = this.f9040q;
        if (i18 != 3) {
            return i18;
        }
        int i19 = layoutDirection == 0 ? this.f9038o : this.f9037n;
        if (i19 != 3) {
            return i19;
        }
        return 0;
    }

    public int getDrawerLockMode(@NonNull View view) {
        if (t(view)) {
            return getDrawerLockMode(((f) view.getLayoutParams()).f9058a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Nullable
    public CharSequence getDrawerTitle(int i11) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.f9049z;
        }
        if (absoluteGravity == 5) {
            return this.A;
        }
        return null;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f9046w;
    }

    View h(int i11) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if ((k(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    View i() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((((f) childAt.getLayoutParams()).f9061d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public boolean isDrawerOpen(int i11) {
        View h11 = h(i11);
        if (h11 != null) {
            return isDrawerOpen(h11);
        }
        return false;
    }

    public boolean isDrawerOpen(@NonNull View view) {
        if (t(view)) {
            return (((f) view.getLayoutParams()).f9061d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isDrawerVisible(int i11) {
        View h11 = h(i11);
        if (h11 != null) {
            return isDrawerVisible(h11);
        }
        return false;
    }

    public boolean isDrawerVisible(@NonNull View view) {
        if (t(view)) {
            return ((f) view.getLayoutParams()).f9059b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    View j() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (t(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    int k(View view) {
        return GravityCompat.getAbsoluteGravity(((f) view.getLayoutParams()).f9058a, ViewCompat.getLayoutDirection(this));
    }

    float l(View view) {
        return ((f) view.getLayoutParams()).f9059b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9036m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9036m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C || this.f9046w == null) {
            return;
        }
        Object obj = this.B;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f9046w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f9046w.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.f9030g
            boolean r1 = r1.shouldInterceptTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.f9031h
            boolean r2 = r2.shouldInterceptTouchEvent(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            androidx.customview.widget.ViewDragHelper r7 = r6.f9030g
            boolean r7 = r7.checkTouchSlop(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f9032i
            r7.c()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f9033j
            r7.c()
            goto L36
        L31:
            r6.c(r2)
            r6.f9041r = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f9044u = r0
            r6.f9045v = r7
            float r4 = r6.f9028e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            androidx.customview.widget.ViewDragHelper r4 = r6.f9030g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.findTopChildUnder(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.s(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.f9041r = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.p()
            if (r7 != 0) goto L70
            boolean r7 = r6.f9041r
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !q()) {
            return super.onKeyDown(i11, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyUp(i11, keyEvent);
        }
        View j11 = j();
        if (j11 != null && getDrawerLockMode(j11) == 0) {
            closeDrawers();
        }
        return j11 != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        WindowInsets rootWindowInsets;
        float f11;
        int i15;
        boolean z11 = true;
        this.f9035l = true;
        int i16 = i13 - i11;
        int childCount = getChildCount();
        int i17 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (s(childAt)) {
                    int i18 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f12 = measuredWidth;
                        i15 = (-measuredWidth) + ((int) (fVar.f9059b * f12));
                        f11 = (measuredWidth + i15) / f12;
                    } else {
                        float f13 = measuredWidth;
                        f11 = (i16 - r11) / f13;
                        i15 = i16 - ((int) (fVar.f9059b * f13));
                    }
                    boolean z12 = f11 != fVar.f9059b ? z11 : false;
                    int i19 = fVar.f9058a & 112;
                    if (i19 == 16) {
                        int i20 = i14 - i12;
                        int i21 = (i20 - measuredHeight) / 2;
                        int i22 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i21 < i22) {
                            i21 = i22;
                        } else {
                            int i23 = i21 + measuredHeight;
                            int i24 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i23 > i20 - i24) {
                                i21 = (i20 - i24) - measuredHeight;
                            }
                        }
                        childAt.layout(i15, i21, measuredWidth + i15, measuredHeight + i21);
                    } else if (i19 != 80) {
                        int i25 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i15, i25, measuredWidth + i15, measuredHeight + i25);
                    } else {
                        int i26 = i14 - i12;
                        childAt.layout(i15, (i26 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i15, i26 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z12) {
                        A(childAt, f11);
                    }
                    int i27 = fVar.f9059b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i27) {
                        childAt.setVisibility(i27);
                    }
                }
            }
            i17++;
            z11 = true;
        }
        if (P && (rootWindowInsets = getRootWindowInsets()) != null) {
            z0.c systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.f9030g;
            viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.f79248a));
            ViewDragHelper viewDragHelper2 = this.f9031h;
            viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.f79250c));
        }
        this.f9035l = false;
        this.f9036m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z10 = this.B != null && ViewCompat.getFitsSystemWindows(this);
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        boolean z11 = false;
        boolean z12 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z10) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(fVar.f9058a, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.B;
                        if (absoluteGravity == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.B;
                        if (absoluteGravity == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (s(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else {
                    if (!t(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (O) {
                        float elevation = ViewCompat.getElevation(childAt);
                        float f11 = this.f9025b;
                        if (elevation != f11) {
                            ViewCompat.setElevation(childAt, f11);
                        }
                    }
                    int k11 = k(childAt) & 7;
                    boolean z13 = k11 == 3;
                    if ((z13 && z11) || (!z13 && z12)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + n(k11) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z13) {
                        z11 = true;
                    } else {
                        z12 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i11, this.f9026c + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i12, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View h11;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i11 = savedState.openDrawerGravity;
        if (i11 != 0 && (h11 = h(i11)) != null) {
            openDrawer(h11);
        }
        int i12 = savedState.lockModeLeft;
        if (i12 != 3) {
            setDrawerLockMode(i12, 3);
        }
        int i13 = savedState.lockModeRight;
        if (i13 != 3) {
            setDrawerLockMode(i13, 5);
        }
        int i14 = savedState.lockModeStart;
        if (i14 != 3) {
            setDrawerLockMode(i14, GravityCompat.START);
        }
        int i15 = savedState.lockModeEnd;
        if (i15 != 3) {
            setDrawerLockMode(i15, GravityCompat.END);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        z();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            f fVar = (f) getChildAt(i11).getLayoutParams();
            int i12 = fVar.f9061d;
            boolean z10 = i12 == 1;
            boolean z11 = i12 == 2;
            if (z10 || z11) {
                savedState.openDrawerGravity = fVar.f9058a;
                break;
            }
        }
        savedState.lockModeLeft = this.f9037n;
        savedState.lockModeRight = this.f9038o;
        savedState.lockModeStart = this.f9039p;
        savedState.lockModeEnd = this.f9040q;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (getDrawerLockMode(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f9030g
            r0.processTouchEvent(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.f9031h
            r0.processTouchEvent(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5f
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6d
        L1a:
            r6.c(r2)
            r6.f9041r = r1
            goto L6d
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.f9030g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.findTopChildUnder(r4, r5)
            if (r3 == 0) goto L5a
            boolean r3 = r6.s(r3)
            if (r3 == 0) goto L5a
            float r3 = r6.f9044u
            float r0 = r0 - r3
            float r3 = r6.f9045v
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.f9030g
            int r3 = r3.getTouchSlop()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5a
            android.view.View r7 = r6.i()
            if (r7 == 0) goto L5a
            int r7 = r6.getDrawerLockMode(r7)
            r0 = 2
            if (r7 != r0) goto L5b
        L5a:
            r1 = r2
        L5b:
            r6.c(r1)
            goto L6d
        L5f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f9044u = r0
            r6.f9045v = r7
            r6.f9041r = r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open() {
        openDrawer(GravityCompat.START);
    }

    public void openDrawer(int i11) {
        openDrawer(i11, true);
    }

    public void openDrawer(int i11, boolean z10) {
        View h11 = h(i11);
        if (h11 != null) {
            openDrawer(h11, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + n(i11));
    }

    public void openDrawer(@NonNull View view) {
        openDrawer(view, true);
    }

    public void openDrawer(@NonNull View view, boolean z10) {
        if (!t(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f9036m) {
            fVar.f9059b = 1.0f;
            fVar.f9061d = 1;
            C(view, true);
            B(view);
        } else if (z10) {
            fVar.f9061d |= 2;
            if (b(view, 3)) {
                this.f9030g.smoothSlideViewTo(view, 0, view.getTop());
            } else {
                this.f9031h.smoothSlideViewTo(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            w(view, 1.0f);
            D(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void removeDrawerListener(@NonNull e eVar) {
        List list;
        if (eVar == null || (list = this.f9043t) == null) {
            return;
        }
        list.remove(eVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f9035l) {
            return;
        }
        super.requestLayout();
    }

    boolean s(View view) {
        return ((f) view.getLayoutParams()).f9058a == 0;
    }

    public void setChildInsets(Object obj, boolean z10) {
        this.B = obj;
        this.C = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f11) {
        this.f9025b = f11;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (t(childAt)) {
                ViewCompat.setElevation(childAt, this.f9025b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f9042s;
        if (eVar2 != null) {
            removeDrawerListener(eVar2);
        }
        if (eVar != null) {
            addDrawerListener(eVar);
        }
        this.f9042s = eVar;
    }

    public void setDrawerLockMode(int i11) {
        setDrawerLockMode(i11, 3);
        setDrawerLockMode(i11, 5);
    }

    public void setDrawerLockMode(int i11, int i12) {
        View h11;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, ViewCompat.getLayoutDirection(this));
        if (i12 == 3) {
            this.f9037n = i11;
        } else if (i12 == 5) {
            this.f9038o = i11;
        } else if (i12 == 8388611) {
            this.f9039p = i11;
        } else if (i12 == 8388613) {
            this.f9040q = i11;
        }
        if (i11 != 0) {
            (absoluteGravity == 3 ? this.f9030g : this.f9031h).cancel();
        }
        if (i11 != 1) {
            if (i11 == 2 && (h11 = h(absoluteGravity)) != null) {
                openDrawer(h11);
                return;
            }
            return;
        }
        View h12 = h(absoluteGravity);
        if (h12 != null) {
            closeDrawer(h12);
        }
    }

    public void setDrawerLockMode(int i11, @NonNull View view) {
        if (t(view)) {
            setDrawerLockMode(i11, ((f) view.getLayoutParams()).f9058a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int i11, int i12) {
        setDrawerShadow(androidx.core.content.b.getDrawable(getContext(), i11), i12);
    }

    public void setDrawerShadow(Drawable drawable, int i11) {
        if (O) {
            return;
        }
        if ((i11 & GravityCompat.START) == 8388611) {
            this.D = drawable;
        } else if ((i11 & GravityCompat.END) == 8388613) {
            this.E = drawable;
        } else if ((i11 & 3) == 3) {
            this.F = drawable;
        } else if ((i11 & 5) != 5) {
            return;
        } else {
            this.G = drawable;
        }
        z();
        invalidate();
    }

    public void setDrawerTitle(int i11, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.f9049z = charSequence;
        } else if (absoluteGravity == 5) {
            this.A = charSequence;
        }
    }

    public void setScrimColor(int i11) {
        this.f9027d = i11;
        invalidate();
    }

    public void setStatusBarBackground(int i11) {
        this.f9046w = i11 != 0 ? androidx.core.content.b.getDrawable(getContext(), i11) : null;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.f9046w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i11) {
        this.f9046w = new ColorDrawable(i11);
        invalidate();
    }

    boolean t(View view) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((f) view.getLayoutParams()).f9058a, ViewCompat.getLayoutDirection(view));
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    void w(View view, float f11) {
        float l11 = l(view);
        float width = view.getWidth();
        int i11 = ((int) (width * f11)) - ((int) (l11 * width));
        if (!b(view, 3)) {
            i11 = -i11;
        }
        view.offsetLeftAndRight(i11);
        A(view, f11);
    }
}
