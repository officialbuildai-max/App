package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.o0;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements m.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: a, reason: collision with root package name */
    h f1400a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f1401b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f1402c;

    /* renamed from: d, reason: collision with root package name */
    f.b f1403d;

    /* renamed from: e, reason: collision with root package name */
    private ForwardingListener f1404e;

    /* renamed from: f, reason: collision with root package name */
    b f1405f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1406g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1407h;

    /* renamed from: i, reason: collision with root package name */
    private int f1408i;

    /* renamed from: j, reason: collision with root package name */
    private int f1409j;

    /* renamed from: k, reason: collision with root package name */
    private int f1410k;

    /* loaded from: classes.dex */
    private class a extends ForwardingListener {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public o b() {
            b bVar = ActionMenuItemView.this.f1405f;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean c() {
            o b11;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.f1403d;
            return bVar != null && bVar.invokeItem(actionMenuItemView.f1400a) && (b11 = b()) != null && b11.a();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract o a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Resources resources = context.getResources();
        this.f1406g = b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i11, 0);
        this.f1408i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1410k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1409j = -1;
        setSaveEnabled(false);
    }

    private boolean b() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        return i11 >= 480 || (i11 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void c() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1401b);
        if (this.f1402c != null && (!this.f1400a.B() || (!this.f1406g && !this.f1407h))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f1401b : null);
        CharSequence contentDescription = this.f1400a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f1400a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1400a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            o0.a(this, z12 ? null : this.f1400a.getTitle());
        } else {
            o0.a(this, tooltipText);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public h getItemData() {
        return this.f1400a;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void initialize(h hVar, int i11) {
        this.f1400a = hVar;
        setIcon(hVar.getIcon());
        setTitle(hVar.i(this));
        setId(hVar.getItemId());
        setVisibility(hVar.isVisible() ? 0 : 8);
        setEnabled(hVar.isEnabled());
        if (hVar.hasSubMenu() && this.f1404e == null) {
            this.f1404e = new a();
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerBefore() {
        return hasText() && this.f1400a.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.b bVar = this.f1403d;
        if (bVar != null) {
            bVar.invokeItem(this.f1400a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1406g = b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        boolean hasText = hasText();
        if (hasText && (i13 = this.f1409j) >= 0) {
            super.setPadding(i13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f1408i) : this.f1408i;
        if (mode != 1073741824 && this.f1408i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i12);
        }
        if (hasText || this.f1402c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1402c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.f1400a.hasSubMenu() && (forwardingListener = this.f1404e) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f1407h != z10) {
            this.f1407h = z10;
            h hVar = this.f1400a;
            if (hVar != null) {
                hVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1402c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i11 = this.f1410k;
            if (intrinsicWidth > i11) {
                intrinsicHeight = (int) (intrinsicHeight * (i11 / intrinsicWidth));
                intrinsicWidth = i11;
            }
            if (intrinsicHeight > i11) {
                intrinsicWidth = (int) (intrinsicWidth * (i11 / intrinsicHeight));
            } else {
                i11 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i11);
        }
        setCompoundDrawables(drawable, null, null, null);
        c();
    }

    public void setItemInvoker(f.b bVar) {
        this.f1403d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i11, int i12, int i13, int i14) {
        this.f1409j = i11;
        super.setPadding(i11, i12, i13, i14);
    }

    public void setPopupCallback(b bVar) {
        this.f1405f = bVar;
    }

    public void setShortcut(boolean z10, char c11) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f1401b = charSequence;
        c();
    }

    public boolean showsIcon() {
        return true;
    }
}
