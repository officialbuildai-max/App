package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1630a;

    /* renamed from: b, reason: collision with root package name */
    private View f1631b;

    /* renamed from: c, reason: collision with root package name */
    private View f1632c;

    /* renamed from: d, reason: collision with root package name */
    private View f1633d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f1634e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f1635f;

    /* renamed from: g, reason: collision with root package name */
    Drawable f1636g;

    /* renamed from: h, reason: collision with root package name */
    boolean f1637h;

    /* renamed from: i, reason: collision with root package name */
    boolean f1638i;

    /* renamed from: j, reason: collision with root package name */
    private int f1639j;

    /* loaded from: classes.dex */
    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new androidx.appcompat.widget.a(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f1634e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f1635f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f1639j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R$id.split_action_bar) {
            this.f1637h = true;
            this.f1636g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1637h ? this.f1634e != null || this.f1635f != null : this.f1636g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1634e;
        if (drawable != null && drawable.isStateful()) {
            this.f1634e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1635f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1635f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1636g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1636g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1631b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1634e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1635f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1636g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1632c = findViewById(R$id.action_bar);
        this.f1633d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1630a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        Drawable drawable;
        super.onLayout(z10, i11, i12, i13, i14);
        View view = this.f1631b;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i15 = layoutParams.bottomMargin;
            view.layout(i11, measuredHeight2 - i15, i13, measuredHeight - i15);
        }
        if (this.f1637h) {
            Drawable drawable2 = this.f1636g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z11 = z12;
        } else {
            if (this.f1634e != null) {
                if (this.f1632c.getVisibility() == 0) {
                    this.f1634e.setBounds(this.f1632c.getLeft(), this.f1632c.getTop(), this.f1632c.getRight(), this.f1632c.getBottom());
                } else {
                    View view2 = this.f1633d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f1634e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1634e.setBounds(this.f1633d.getLeft(), this.f1633d.getTop(), this.f1633d.getRight(), this.f1633d.getBottom());
                    }
                }
                z12 = true;
            }
            this.f1638i = z13;
            if (z13 && (drawable = this.f1635f) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            z11 = z12;
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        if (this.f1632c == null && View.MeasureSpec.getMode(i12) == Integer.MIN_VALUE && (i13 = this.f1639j) >= 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(Math.min(i13, View.MeasureSpec.getSize(i12)), Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i12);
        if (this.f1632c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i12);
        View view = this.f1631b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f1632c) ? a(this.f1632c) : !b(this.f1633d) ? a(this.f1633d) : 0) + a(this.f1631b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i12) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1634e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1634e);
        }
        this.f1634e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1632c;
            if (view != null) {
                this.f1634e.setBounds(view.getLeft(), this.f1632c.getTop(), this.f1632c.getRight(), this.f1632c.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f1637h ? !(this.f1634e != null || this.f1635f != null) : this.f1636g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1636g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1636g);
        }
        this.f1636g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1637h && (drawable2 = this.f1636g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1637h ? !(this.f1634e != null || this.f1635f != null) : this.f1636g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1635f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1635f);
        }
        this.f1635f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1638i && (drawable2 = this.f1635f) != null) {
                drawable2.setBounds(this.f1631b.getLeft(), this.f1631b.getTop(), this.f1631b.getRight(), this.f1631b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f1637h ? !(this.f1634e != null || this.f1635f != null) : this.f1636g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1631b;
        if (view != null) {
            removeView(view);
        }
        this.f1631b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f1630a = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z10 = i11 == 0;
        Drawable drawable = this.f1634e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1635f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1636g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i11) {
        if (i11 != 0) {
            return super.startActionModeForChild(view, callback, i11);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1634e && !this.f1637h) || (drawable == this.f1635f && this.f1638i) || ((drawable == this.f1636g && this.f1637h) || super.verifyDrawable(drawable));
    }
}
