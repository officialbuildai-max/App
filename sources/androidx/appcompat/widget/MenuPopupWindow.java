package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements a0 {
    private static Method K;
    private a0 J;

    /* loaded from: classes.dex */
    public static class MenuDropDownListView extends DropDownListView {

        /* renamed from: n, reason: collision with root package name */
        final int f1886n;

        /* renamed from: o, reason: collision with root package name */
        final int f1887o;

        /* renamed from: p, reason: collision with root package name */
        private a0 f1888p;

        /* renamed from: q, reason: collision with root package name */
        private MenuItem f1889q;

        public MenuDropDownListView(Context context, boolean z10) {
            super(context, z10);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1886n = 21;
                this.f1887o = 22;
            } else {
                this.f1886n = 22;
                this.f1887o = 21;
            }
        }

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int i11, boolean z10) {
            return super.lookForSelectablePosition(i11, z10);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int i11, int i12, int i13, int i14, int i15) {
            return super.measureHeightOfChildrenCompat(i11, i12, i13, i14, i15);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent motionEvent, int i11) {
            return super.onForwardedEvent(motionEvent, i11);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.e eVar;
            int i11;
            int pointToPosition;
            int i12;
            if (this.f1888p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i11 = headerViewListAdapter.getHeadersCount();
                    eVar = (androidx.appcompat.view.menu.e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (androidx.appcompat.view.menu.e) adapter;
                    i11 = 0;
                }
                androidx.appcompat.view.menu.h item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i12 = pointToPosition - i11) < 0 || i12 >= eVar.getCount()) ? null : eVar.getItem(i12);
                MenuItem menuItem = this.f1889q;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.f b11 = eVar.b();
                    if (menuItem != null) {
                        this.f1888p.n(b11, menuItem);
                    }
                    this.f1889q = item;
                    if (item != null) {
                        this.f1888p.d(b11, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i11, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i11 == this.f1886n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i11 != this.f1887o) {
                return super.onKeyDown(i11, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.e) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.e) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(a0 a0Var) {
            this.f1888p = a0Var;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    /* loaded from: classes.dex */
    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static void a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public void R(Object obj) {
        a.a(this.F, (Transition) obj);
    }

    public void S(Object obj) {
        a.b(this.F, (Transition) obj);
    }

    public void T(a0 a0Var) {
        this.J = a0Var;
    }

    public void U(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.F, z10);
            return;
        }
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.widget.a0
    public void d(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        a0 a0Var = this.J;
        if (a0Var != null) {
            a0Var.d(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.a0
    public void n(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        a0 a0Var = this.J;
        if (a0Var != null) {
            a0Var.n(fVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    DropDownListView r(Context context, boolean z10) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z10);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
