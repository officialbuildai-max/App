package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f1826a;

    /* renamed from: b, reason: collision with root package name */
    private int f1827b;

    /* renamed from: c, reason: collision with root package name */
    private int f1828c;

    /* renamed from: d, reason: collision with root package name */
    private int f1829d;

    /* renamed from: e, reason: collision with root package name */
    private int f1830e;

    /* renamed from: f, reason: collision with root package name */
    private int f1831f;

    /* renamed from: g, reason: collision with root package name */
    private d f1832g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1833h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1834i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1835j;

    /* renamed from: k, reason: collision with root package name */
    private ViewPropertyAnimatorCompat f1836k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.core.widget.j f1837l;

    /* renamed from: m, reason: collision with root package name */
    ResolveHoverRunnable f1838m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void cancel() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1838m = null;
            dropDownListView.removeCallbacks(this);
        }

        public void post() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1838m = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static void a(View view, float f11, float f12) {
            view.drawableHotspotChanged(f11, f12);
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f1839a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f1840b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f1841c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f1842d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1839a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1840b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1841c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1842d = true;
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }

        static boolean a() {
            return f1842d;
        }

        static void b(DropDownListView dropDownListView, int i11, View view) {
            try {
                f1839a.invoke(dropDownListView, Integer.valueOf(i11), view, Boolean.FALSE, -1, -1);
                f1840b.invoke(dropDownListView, Integer.valueOf(i11));
                f1841c.invoke(dropDownListView, Integer.valueOf(i11));
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends androidx.appcompat.graphics.drawable.b {

        /* renamed from: b, reason: collision with root package name */
        private boolean f1843b;

        d(Drawable drawable) {
            super(drawable);
            this.f1843b = true;
        }

        void b(boolean z10) {
            this.f1843b = z10;
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1843b) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public void setHotspot(float f11, float f12) {
            if (this.f1843b) {
                super.setHotspot(f11, f12);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i11, int i12, int i13, int i14) {
            if (this.f1843b) {
                super.setHotspotBounds(i11, i12, i13, i14);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1843b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1843b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Field f1844a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
            f1844a = field;
        }

        static boolean a(AbsListView absListView) {
            Field field = f1844a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z10) {
            Field field = f1844a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z10));
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropDownListView(Context context, boolean z10) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1826a = new Rect();
        this.f1827b = 0;
        this.f1828c = 0;
        this.f1829d = 0;
        this.f1830e = 0;
        this.f1834i = z10;
        setCacheColorHint(0);
    }

    private void a() {
        this.f1835j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1831f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1836k;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.f1836k = null;
        }
    }

    private void b(View view, int i11) {
        performItemClick(view, i11, getItemIdAtPosition(i11));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f1826a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1826a);
        selector.draw(canvas);
    }

    private void d(int i11, View view) {
        Rect rect = this.f1826a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1827b;
        rect.top -= this.f1828c;
        rect.right += this.f1829d;
        rect.bottom += this.f1830e;
        boolean i12 = i();
        if (view.isEnabled() != i12) {
            j(!i12);
            if (i11 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void e(int i11, View view) {
        Drawable selector = getSelector();
        boolean z10 = (selector == null || i11 == -1) ? false : true;
        if (z10) {
            selector.setVisible(false, false);
        }
        d(i11, view);
        if (z10) {
            Rect rect = this.f1826a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            a1.a.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void f(int i11, View view, float f11, float f12) {
        e(i11, view);
        Drawable selector = getSelector();
        if (selector == null || i11 == -1) {
            return;
        }
        a1.a.k(selector, f11, f12);
    }

    private void g(View view, int i11, float f11, float f12) {
        View childAt;
        this.f1835j = true;
        a.a(this, f11, f12);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.f1831f;
        if (i12 != -1 && (childAt = getChildAt(i12 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1831f = i11;
        a.a(view, f11 - view.getLeft(), f12 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        f(i11, view, f11, f12);
        h(false);
        refreshDrawableState();
    }

    private void h(boolean z10) {
        d dVar = this.f1832g;
        if (dVar != null) {
            dVar.b(z10);
        }
    }

    private boolean i() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this) : e.a(this);
    }

    private void j(boolean z10) {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b(this, z10);
        } else {
            e.b(this, z10);
        }
    }

    private boolean k() {
        return this.f1835j;
    }

    private void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1838m != null) {
            return;
        }
        super.drawableStateChanged();
        h(true);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1834i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1834i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1834i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1834i && this.f1833h) || super.isInTouchMode();
    }

    public int lookForSelectablePosition(int i11, boolean z10) {
        int min;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z10) {
                    min = Math.max(0, i11);
                    while (min < count && !adapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i11, count - 1);
                    while (min >= 0 && !adapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            }
            if (i11 >= 0 && i11 < count) {
                return i11;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i11, int i12, int i13, int i14, int i15) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i16 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        View view = null;
        while (i17 < count) {
            int itemViewType = adapter.getItemViewType(i17);
            if (itemViewType != i18) {
                view = null;
                i18 = itemViewType;
            }
            view = adapter.getView(i17, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i20 = layoutParams.height;
            view.measure(i11, i20 > 0 ? View.MeasureSpec.makeMeasureSpec(i20, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i17 > 0) {
                i16 += dividerHeight;
            }
            i16 += view.getMeasuredHeight();
            if (i16 >= i14) {
                return (i15 < 0 || i17 <= i15 || i19 <= 0 || i16 == i14) ? i14 : i19;
            }
            if (i15 >= 0 && i17 >= i15) {
                i19 = i16;
            }
            i17++;
        }
        return i16;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1838m = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onForwardedEvent(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.g(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.j r9 = r7.f1837l
            if (r9 != 0) goto L5a
            androidx.core.widget.j r9 = new androidx.core.widget.j
            r9.<init>(r7)
            r7.f1837l = r9
        L5a:
            androidx.core.widget.j r9 = r7.f1837l
            r9.m(r1)
            androidx.core.widget.j r9 = r7.f1837l
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.j r8 = r7.f1837l
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1838m == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.f1838m = resolveHoverRunnable;
            resolveHoverRunnable.post();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i11 < 30 || !b.a()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, pointToPosition, childAt);
                    }
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1831f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.f1838m;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z10) {
        this.f1833h = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f1832g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1827b = rect.left;
        this.f1828c = rect.top;
        this.f1829d = rect.right;
        this.f1830e = rect.bottom;
    }
}
