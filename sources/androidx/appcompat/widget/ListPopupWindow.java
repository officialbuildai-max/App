package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.o {
    private static Method G;
    private static Method H;
    private static Method I;
    private Runnable A;
    final Handler B;
    private final Rect C;
    private Rect D;
    private boolean E;
    PopupWindow F;

    /* renamed from: a, reason: collision with root package name */
    private Context f1856a;

    /* renamed from: b, reason: collision with root package name */
    private ListAdapter f1857b;

    /* renamed from: c, reason: collision with root package name */
    DropDownListView f1858c;

    /* renamed from: d, reason: collision with root package name */
    private int f1859d;

    /* renamed from: e, reason: collision with root package name */
    private int f1860e;

    /* renamed from: f, reason: collision with root package name */
    private int f1861f;

    /* renamed from: g, reason: collision with root package name */
    private int f1862g;

    /* renamed from: h, reason: collision with root package name */
    private int f1863h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1864i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1865j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1866k;

    /* renamed from: l, reason: collision with root package name */
    private int f1867l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1868m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1869n;

    /* renamed from: o, reason: collision with root package name */
    int f1870o;

    /* renamed from: p, reason: collision with root package name */
    private View f1871p;

    /* renamed from: q, reason: collision with root package name */
    private int f1872q;

    /* renamed from: r, reason: collision with root package name */
    private DataSetObserver f1873r;

    /* renamed from: s, reason: collision with root package name */
    private View f1874s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f1875t;

    /* renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f1876u;

    /* renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1877v;

    /* renamed from: w, reason: collision with root package name */
    final ResizePopupRunnable f1878w;

    /* renamed from: x, reason: collision with root package name */
    private final f f1879x;

    /* renamed from: y, reason: collision with root package name */
    private final e f1880y;

    /* renamed from: z, reason: collision with root package name */
    private final ListSelectorHider f1881z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f1858c;
            if (dropDownListView == null || !dropDownListView.isAttachedToWindow() || ListPopupWindow.this.f1858c.getCount() <= ListPopupWindow.this.f1858c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f1858c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.f1870o) {
                listPopupWindow.F.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i11, long j11) {
            DropDownListView dropDownListView;
            if (i11 == -1 || (dropDownListView = ListPopupWindow.this.f1858c) == null) {
                return;
            }
            dropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static int a(PopupWindow popupWindow, View view, int i11, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i11, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* loaded from: classes.dex */
    private class d extends DataSetObserver {
        d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.a()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i11) {
            if (i11 != 1 || ListPopupWindow.this.z() || ListPopupWindow.this.F.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.B.removeCallbacks(listPopupWindow.f1878w);
            ListPopupWindow.this.f1878w.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.F) != null && popupWindow.isShowing() && x10 >= 0 && x10 < ListPopupWindow.this.F.getWidth() && y10 >= 0 && y10 < ListPopupWindow.this.F.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.B.postDelayed(listPopupWindow.f1878w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.B.removeCallbacks(listPopupWindow2.f1878w);
            return false;
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f1859d = -2;
        this.f1860e = -2;
        this.f1863h = 1002;
        this.f1867l = 0;
        this.f1868m = false;
        this.f1869n = false;
        this.f1870o = Integer.MAX_VALUE;
        this.f1872q = 0;
        this.f1878w = new ResizePopupRunnable();
        this.f1879x = new f();
        this.f1880y = new e();
        this.f1881z = new ListSelectorHider();
        this.C = new Rect();
        this.f1856a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i11, i12);
        this.f1861f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1862g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1864i = true;
        }
        obtainStyledAttributes.recycle();
        k kVar = new k(context, attributeSet, i11, i12);
        this.F = kVar;
        kVar.setInputMethodMode(1);
    }

    private void B() {
        View view = this.f1871p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1871p);
            }
        }
    }

    private void N(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            c.b(this.F, z10);
            return;
        }
        Method method = G;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    private int p() {
        int i11;
        int i12;
        int makeMeasureSpec;
        int i13;
        if (this.f1858c == null) {
            Context context = this.f1856a;
            this.A = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View s11 = ListPopupWindow.this.s();
                    if (s11 == null || s11.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.show();
                }
            };
            DropDownListView r11 = r(context, !this.E);
            this.f1858c = r11;
            Drawable drawable = this.f1875t;
            if (drawable != null) {
                r11.setSelector(drawable);
            }
            this.f1858c.setAdapter(this.f1857b);
            this.f1858c.setOnItemClickListener(this.f1876u);
            this.f1858c.setFocusable(true);
            this.f1858c.setFocusableInTouchMode(true);
            this.f1858c.setOnItemSelectedListener(new a());
            this.f1858c.setOnScrollListener(this.f1880y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1877v;
            if (onItemSelectedListener != null) {
                this.f1858c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f1858c;
            View view2 = this.f1871p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i14 = this.f1872q;
                if (i14 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i14 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f1872q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i15 = this.f1860e;
                if (i15 >= 0) {
                    i13 = Integer.MIN_VALUE;
                } else {
                    i15 = 0;
                    i13 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i15, i13), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i11 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i11 = 0;
            }
            this.F.setContentView(view);
        } else {
            View view3 = this.f1871p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i11 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i11 = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i16 = rect.top;
            i12 = rect.bottom + i16;
            if (!this.f1864i) {
                this.f1862g = -i16;
            }
        } else {
            this.C.setEmpty();
            i12 = 0;
        }
        int t11 = t(s(), this.f1862g, this.F.getInputMethodMode() == 2);
        if (this.f1868m || this.f1859d == -1) {
            return t11 + i12;
        }
        int i17 = this.f1860e;
        if (i17 == -2) {
            int i18 = this.f1856a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i17 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        } else {
            int i19 = this.f1856a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - (rect3.left + rect3.right), 1073741824);
        }
        int measureHeightOfChildrenCompat = this.f1858c.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, t11 - i11, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i11 += i12 + this.f1858c.getPaddingTop() + this.f1858c.getPaddingBottom();
        }
        return measureHeightOfChildrenCompat + i11;
    }

    private int t(View view, int i11, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return b.a(this.F, view, i11, z10);
        }
        Method method = H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.F, view, Integer.valueOf(i11), Boolean.valueOf(z10))).intValue();
            } catch (Exception unused) {
            }
        }
        return this.F.getMaxAvailableHeight(view, i11);
    }

    public boolean A() {
        return this.E;
    }

    public void C(View view) {
        this.f1874s = view;
    }

    public void D(int i11) {
        this.F.setAnimationStyle(i11);
    }

    public void E(int i11) {
        Drawable background = this.F.getBackground();
        if (background == null) {
            Q(i11);
            return;
        }
        background.getPadding(this.C);
        Rect rect = this.C;
        this.f1860e = rect.left + rect.right + i11;
    }

    public void F(int i11) {
        this.f1867l = i11;
    }

    public void G(Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    public void H(int i11) {
        this.F.setInputMethodMode(i11);
    }

    public void I(boolean z10) {
        this.E = z10;
        this.F.setFocusable(z10);
    }

    public void J(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void K(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1876u = onItemClickListener;
    }

    public void L(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f1877v = onItemSelectedListener;
    }

    public void M(boolean z10) {
        this.f1866k = true;
        this.f1865j = z10;
    }

    public void O(int i11) {
        this.f1872q = i11;
    }

    public void P(int i11) {
        DropDownListView dropDownListView = this.f1858c;
        if (!a() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i11);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i11, true);
        }
    }

    public void Q(int i11) {
        this.f1860e = i11;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a() {
        return this.F.isShowing();
    }

    public void b(Drawable drawable) {
        this.F.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.f1861f;
    }

    @Override // androidx.appcompat.view.menu.o
    public void dismiss() {
        this.F.dismiss();
        B();
        this.F.setContentView(null);
        this.f1858c = null;
        this.B.removeCallbacks(this.f1878w);
    }

    public void e(int i11) {
        this.f1861f = i11;
    }

    public Drawable g() {
        return this.F.getBackground();
    }

    public void i(int i11) {
        this.f1862g = i11;
        this.f1864i = true;
    }

    public int l() {
        if (this.f1864i) {
            return this.f1862g;
        }
        return 0;
    }

    public void m(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1873r;
        if (dataSetObserver == null) {
            this.f1873r = new d();
        } else {
            ListAdapter listAdapter2 = this.f1857b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1857b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1873r);
        }
        DropDownListView dropDownListView = this.f1858c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f1857b);
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public ListView o() {
        return this.f1858c;
    }

    public void q() {
        DropDownListView dropDownListView = this.f1858c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    DropDownListView r(Context context, boolean z10) {
        return new DropDownListView(context, z10);
    }

    public View s() {
        return this.f1874s;
    }

    @Override // androidx.appcompat.view.menu.o
    public void show() {
        int p11 = p();
        boolean z10 = z();
        androidx.core.widget.l.b(this.F, this.f1863h);
        if (this.F.isShowing()) {
            if (s().isAttachedToWindow()) {
                int i11 = this.f1860e;
                if (i11 == -1) {
                    i11 = -1;
                } else if (i11 == -2) {
                    i11 = s().getWidth();
                }
                int i12 = this.f1859d;
                if (i12 == -1) {
                    if (!z10) {
                        p11 = -1;
                    }
                    if (z10) {
                        this.F.setWidth(this.f1860e == -1 ? -1 : 0);
                        this.F.setHeight(0);
                    } else {
                        this.F.setWidth(this.f1860e == -1 ? -1 : 0);
                        this.F.setHeight(-1);
                    }
                } else if (i12 != -2) {
                    p11 = i12;
                }
                this.F.setOutsideTouchable((this.f1869n || this.f1868m) ? false : true);
                this.F.update(s(), this.f1861f, this.f1862g, i11 < 0 ? -1 : i11, p11 < 0 ? -1 : p11);
                return;
            }
            return;
        }
        int i13 = this.f1860e;
        if (i13 == -1) {
            i13 = -1;
        } else if (i13 == -2) {
            i13 = s().getWidth();
        }
        int i14 = this.f1859d;
        if (i14 == -1) {
            p11 = -1;
        } else if (i14 != -2) {
            p11 = i14;
        }
        this.F.setWidth(i13);
        this.F.setHeight(p11);
        N(true);
        this.F.setOutsideTouchable((this.f1869n || this.f1868m) ? false : true);
        this.F.setTouchInterceptor(this.f1879x);
        if (this.f1866k) {
            androidx.core.widget.l.a(this.F, this.f1865j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e11) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e11);
                }
            }
        } else {
            c.a(this.F, this.D);
        }
        androidx.core.widget.l.c(this.F, s(), this.f1861f, this.f1862g, this.f1867l);
        this.f1858c.setSelection(-1);
        if (!this.E || this.f1858c.isInTouchMode()) {
            q();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.f1881z);
    }

    public Object u() {
        if (a()) {
            return this.f1858c.getSelectedItem();
        }
        return null;
    }

    public long v() {
        if (a()) {
            return this.f1858c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int w() {
        if (a()) {
            return this.f1858c.getSelectedItemPosition();
        }
        return -1;
    }

    public View x() {
        if (a()) {
            return this.f1858c.getSelectedView();
        }
        return null;
    }

    public int y() {
        return this.f1860e;
    }

    public boolean z() {
        return this.F.getInputMethodMode() == 2;
    }
}
