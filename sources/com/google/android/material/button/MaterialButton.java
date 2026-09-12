package com.google.android.material.button;

import ab.j;
import ab.n;
import ab.q;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.c;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.m;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class MaterialButton extends AppCompatButton implements Checkable, q {
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f28533o = {R.attr.state_checkable};

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f28534p = {R.attr.state_checked};

    /* renamed from: q, reason: collision with root package name */
    private static final int f28535q = R$style.Widget_MaterialComponents_Button;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.material.button.a f28536a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f28537b;

    /* renamed from: c, reason: collision with root package name */
    private b f28538c;

    /* renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f28539d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f28540e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f28541f;

    /* renamed from: g, reason: collision with root package name */
    private String f28542g;

    /* renamed from: h, reason: collision with root package name */
    private int f28543h;

    /* renamed from: i, reason: collision with root package name */
    private int f28544i;

    /* renamed from: j, reason: collision with root package name */
    private int f28545j;

    /* renamed from: k, reason: collision with root package name */
    private int f28546k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f28547l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28548m;

    /* renamed from: n, reason: collision with root package name */
    private int f28549n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f28550a;

        /* loaded from: classes4.dex */
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            this.f28550a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.f28550a ? 1 : 0);
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f28535q
            android.content.Context r9 = bb.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f28537b = r9
            r9 = 0
            r8.f28547l = r9
            r8.f28548m = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R$styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f28546k = r1
            int r1 = com.google.android.material.R$styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.f0.r(r1, r2)
            r8.f28539d = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R$styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = xa.c.a(r1, r0, r2)
            r8.f28540e = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R$styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = xa.c.e(r1, r0, r2)
            r8.f28541f = r1
            int r1 = com.google.android.material.R$styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f28549n = r1
            int r1 = com.google.android.material.R$styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f28543h = r1
            ab.n$b r10 = ab.n.e(r7, r10, r11, r6)
            ab.n r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.f28536a = r11
            r11.r(r0)
            r0.recycle()
            int r10 = r8.f28546k
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f28541f
            if (r10 == 0) goto L84
            r9 = r2
        L84:
            r8.g(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private boolean a() {
        int i11 = this.f28549n;
        return i11 == 3 || i11 == 4;
    }

    private boolean b() {
        int i11 = this.f28549n;
        return i11 == 1 || i11 == 2;
    }

    private boolean c() {
        int i11 = this.f28549n;
        return i11 == 16 || i11 == 32;
    }

    private boolean d() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean e() {
        com.google.android.material.button.a aVar = this.f28536a;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private void f() {
        if (b()) {
            m.k(this, this.f28541f, null, null, null);
        } else if (a()) {
            m.k(this, null, null, this.f28541f, null);
        } else if (c()) {
            m.k(this, null, this.f28541f, null, null);
        }
    }

    private void g(boolean z10) {
        Drawable drawable = this.f28541f;
        if (drawable != null) {
            Drawable mutate = a1.a.r(drawable).mutate();
            this.f28541f = mutate;
            a1.a.o(mutate, this.f28540e);
            PorterDuff.Mode mode = this.f28539d;
            if (mode != null) {
                a1.a.p(this.f28541f, mode);
            }
            int i11 = this.f28543h;
            if (i11 == 0) {
                i11 = this.f28541f.getIntrinsicWidth();
            }
            int i12 = this.f28543h;
            if (i12 == 0) {
                i12 = this.f28541f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f28541f;
            int i13 = this.f28544i;
            int i14 = this.f28545j;
            drawable2.setBounds(i13, i14, i11 + i13, i12 + i14);
            this.f28541f.setVisible(true, z10);
        }
        if (z10) {
            f();
            return;
        }
        Drawable[] a11 = m.a(this);
        Drawable drawable3 = a11[0];
        Drawable drawable4 = a11[1];
        Drawable drawable5 = a11[2];
        if ((!b() || drawable3 == this.f28541f) && ((!a() || drawable5 == this.f28541f) && (!c() || drawable4 == this.f28541f))) {
            return;
        }
        f();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < lineCount; i11++) {
            f11 = Math.max(f11, getLayout().getLineWidth(i11));
        }
        return (int) Math.ceil(f11);
    }

    private void h(int i11, int i12) {
        if (this.f28541f == null || getLayout() == null) {
            return;
        }
        if (!b() && !a()) {
            if (c()) {
                this.f28544i = 0;
                if (this.f28549n == 16) {
                    this.f28545j = 0;
                    g(false);
                    return;
                }
                int i13 = this.f28543h;
                if (i13 == 0) {
                    i13 = this.f28541f.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i12 - getTextHeight()) - getPaddingTop()) - i13) - this.f28546k) - getPaddingBottom()) / 2);
                if (this.f28545j != max) {
                    this.f28545j = max;
                    g(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f28545j = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i14 = this.f28549n;
        if (i14 == 1 || i14 == 3 || ((i14 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i14 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f28544i = 0;
            g(false);
            return;
        }
        int i15 = this.f28543h;
        if (i15 == 0) {
            i15 = this.f28541f.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i11 - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - i15) - this.f28546k) - ViewCompat.getPaddingStart(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (d() != (this.f28549n == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f28544i != textLayoutWidth) {
            this.f28544i = textLayoutWidth;
            g(false);
        }
    }

    public void addOnCheckedChangeListener(@NonNull a aVar) {
        this.f28537b.add(aVar);
    }

    public void clearOnCheckedChangeListeners() {
        this.f28537b.clear();
    }

    @NonNull
    String getA11yClassName() {
        if (TextUtils.isEmpty(this.f28542g)) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return this.f28542g;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.f28536a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f28541f;
    }

    public int getIconGravity() {
        return this.f28549n;
    }

    public int getIconPadding() {
        return this.f28546k;
    }

    public int getIconSize() {
        return this.f28543h;
    }

    public ColorStateList getIconTint() {
        return this.f28540e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f28539d;
    }

    public int getInsetBottom() {
        return this.f28536a.c();
    }

    public int getInsetTop() {
        return this.f28536a.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f28536a.h();
        }
        return null;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        if (e()) {
            return this.f28536a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f28536a.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f28536a.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f28536a.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f28536a.m() : super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        com.google.android.material.button.a aVar = this.f28536a;
        return aVar != null && aVar.p();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f28547l;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.f28536a.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            j.f(this, this.f28536a.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, f28533o);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f28534p);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f28550a);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f28550a = this.f28547l;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        super.onTextChanged(charSequence, i11, i12, i13);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f28536a.q()) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f28541f != null) {
            if (this.f28541f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(@NonNull a aVar) {
        this.f28537b.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setA11yClassName(@Nullable String str) {
        this.f28542g = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        if (e()) {
            this.f28536a.s(i11);
        } else {
            super.setBackgroundColor(i11);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f28536a.t();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i11) {
        setBackgroundDrawable(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (e()) {
            this.f28536a.u(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (isCheckable() && isEnabled() && this.f28547l != z10) {
            this.f28547l = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).j(this, this.f28547l);
            }
            if (this.f28548m) {
                return;
            }
            this.f28548m = true;
            Iterator it = this.f28537b.iterator();
            if (it.hasNext()) {
                c.a(it.next());
                throw null;
            }
            this.f28548m = false;
        }
    }

    public void setCornerRadius(int i11) {
        if (e()) {
            this.f28536a.v(i11);
        }
    }

    public void setCornerRadiusResource(int i11) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i11));
        }
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        if (e()) {
            this.f28536a.f().c0(f11);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f28541f != drawable) {
            this.f28541f = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i11) {
        if (this.f28549n != i11) {
            this.f28549n = i11;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i11) {
        if (this.f28546k != i11) {
            this.f28546k = i11;
            setCompoundDrawablePadding(i11);
        }
    }

    public void setIconResource(int i11) {
        setIcon(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    public void setIconSize(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f28543h != i11) {
            this.f28543h = i11;
            g(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f28540e != colorStateList) {
            this.f28540e = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f28539d != mode) {
            this.f28539d = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i11) {
        setIconTint(g.a.a(getContext(), i11));
    }

    public void setInsetBottom(int i11) {
        this.f28536a.w(i11);
    }

    public void setInsetTop(int i11) {
        this.f28536a.x(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.f28538c = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.f28538c;
        if (bVar != null) {
            bVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f28536a.y(colorStateList);
        }
    }

    public void setRippleColorResource(int i11) {
        if (e()) {
            setRippleColor(g.a.a(getContext(), i11));
        }
    }

    @Override // ab.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f28536a.z(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (e()) {
            this.f28536a.A(z10);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f28536a.B(colorStateList);
        }
    }

    public void setStrokeColorResource(int i11) {
        if (e()) {
            setStrokeColor(g.a.a(getContext(), i11));
        }
    }

    public void setStrokeWidth(int i11) {
        if (e()) {
            this.f28536a.C(i11);
        }
    }

    public void setStrokeWidthResource(int i11) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i11));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (e()) {
            this.f28536a.D(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (e()) {
            this.f28536a.E(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i11) {
        super.setTextAlignment(i11);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f28536a.F(z10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f28547l);
    }
}
