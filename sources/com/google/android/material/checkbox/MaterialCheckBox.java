package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.j0;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.d;
import com.google.android.material.internal.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED = 0;

    /* renamed from: u, reason: collision with root package name */
    private static final int f28700u = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: v, reason: collision with root package name */
    private static final int[] f28701v = {R$attr.state_indeterminate};

    /* renamed from: w, reason: collision with root package name */
    private static final int[] f28702w;

    /* renamed from: x, reason: collision with root package name */
    private static final int[][] f28703x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f28704y;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f28705a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f28706b;

    /* renamed from: c, reason: collision with root package name */
    private ColorStateList f28707c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f28708d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f28709e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28710f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f28711g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f28712h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f28713i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28714j;

    /* renamed from: k, reason: collision with root package name */
    ColorStateList f28715k;

    /* renamed from: l, reason: collision with root package name */
    ColorStateList f28716l;

    /* renamed from: m, reason: collision with root package name */
    private PorterDuff.Mode f28717m;

    /* renamed from: n, reason: collision with root package name */
    private int f28718n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f28719o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f28720p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f28721q;

    /* renamed from: r, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f28722r;

    /* renamed from: s, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.c f28723s;

    /* renamed from: t, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f28724t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {

        @NonNull
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f28725a;

        /* loaded from: classes4.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f28725a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private String a() {
            int i11 = this.f28725a;
            return i11 != 1 ? i11 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeValue(Integer.valueOf(this.f28725a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends androidx.vectordrawable.graphics.drawable.b {
        a() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f28715k;
            if (colorStateList != null) {
                a1.a.o(drawable, colorStateList);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f28715k;
            if (colorStateList != null) {
                a1.a.n(drawable, colorStateList.getColorForState(materialCheckBox.f28719o, MaterialCheckBox.this.f28715k.getDefaultColor()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    /* loaded from: classes4.dex */
    public interface c {
    }

    static {
        int i11 = R$attr.state_error;
        f28702w = new int[]{i11};
        f28703x = new int[][]{new int[]{R.attr.state_enabled, i11}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f28704y = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialCheckBox(android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.checkbox.MaterialCheckBox.f28700u
            android.content.Context r9 = bb.a.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f28705a = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f28706b = r9
            android.content.Context r9 = r8.getContext()
            int r0 = com.google.android.material.R$drawable.mtrl_checkbox_button_checked_unchecked
            androidx.vectordrawable.graphics.drawable.c r9 = androidx.vectordrawable.graphics.drawable.c.a(r9, r0)
            r8.f28723s = r9
            com.google.android.material.checkbox.MaterialCheckBox$a r9 = new com.google.android.material.checkbox.MaterialCheckBox$a
            r9.<init>()
            r8.f28724t = r9
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.c.a(r8)
            r8.f28712h = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.f28715k = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = com.google.android.material.R$styleable.MaterialCheckBox
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.j0 r10 = com.google.android.material.internal.b0.j(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R$styleable.MaterialCheckBox_buttonIcon
            android.graphics.drawable.Drawable r11 = r10.g(r11)
            r8.f28713i = r11
            android.graphics.drawable.Drawable r11 = r8.f28712h
            r0 = 1
            if (r11 == 0) goto L7c
            boolean r11 = com.google.android.material.internal.b0.g(r9)
            if (r11 == 0) goto L7c
            boolean r11 = r8.b(r10)
            if (r11 == 0) goto L7c
            super.setButtonDrawable(r6)
            int r11 = com.google.android.material.R$drawable.mtrl_checkbox_button
            android.graphics.drawable.Drawable r11 = g.a.b(r9, r11)
            r8.f28712h = r11
            r8.f28714j = r0
            android.graphics.drawable.Drawable r11 = r8.f28713i
            if (r11 != 0) goto L7c
            int r11 = com.google.android.material.R$drawable.mtrl_checkbox_button_icon
            android.graphics.drawable.Drawable r11 = g.a.b(r9, r11)
            r8.f28713i = r11
        L7c:
            int r11 = com.google.android.material.R$styleable.MaterialCheckBox_buttonIconTint
            android.content.res.ColorStateList r9 = xa.c.b(r9, r10, r11)
            r8.f28716l = r9
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_buttonIconTintMode
            r11 = -1
            int r9 = r10.k(r9, r11)
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r9 = com.google.android.material.internal.f0.r(r9, r11)
            r8.f28717m = r9
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_useMaterialThemeColors
            boolean r9 = r10.a(r9, r7)
            r8.f28708d = r9
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_centerIfNoTextEnabled
            boolean r9 = r10.a(r9, r0)
            r8.f28709e = r9
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_errorShown
            boolean r9 = r10.a(r9, r7)
            r8.f28710f = r9
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_errorAccessibilityLabel
            java.lang.CharSequence r9 = r10.p(r9)
            r8.f28711g = r9
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_checkedState
            boolean r9 = r10.s(r9)
            if (r9 == 0) goto Lc4
            int r9 = com.google.android.material.R$styleable.MaterialCheckBox_checkedState
            int r9 = r10.k(r9, r7)
            r8.setCheckedState(r9)
        Lc4:
            r10.x()
            r8.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.checkbox.MaterialCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private boolean b(j0 j0Var) {
        return j0Var.n(R$styleable.MaterialCheckBox_android_button, 0) == f28704y && j0Var.n(R$styleable.MaterialCheckBox_buttonCompat, 0) == 0;
    }

    private void c() {
        this.f28712h = d.d(this.f28712h, this.f28715k, androidx.core.widget.c.c(this));
        this.f28713i = d.d(this.f28713i, this.f28716l, this.f28717m);
        e();
        f();
        super.setButtonDrawable(d.a(this.f28712h, this.f28713i));
        refreshDrawableState();
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 30 || this.f28721q != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    private void e() {
        androidx.vectordrawable.graphics.drawable.c cVar;
        if (this.f28714j) {
            androidx.vectordrawable.graphics.drawable.c cVar2 = this.f28723s;
            if (cVar2 != null) {
                cVar2.g(this.f28724t);
                this.f28723s.c(this.f28724t);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.f28712h;
                if (!(drawable instanceof AnimatedStateListDrawable) || (cVar = this.f28723s) == null) {
                    return;
                }
                ((AnimatedStateListDrawable) drawable).addTransition(R$id.checked, R$id.unchecked, cVar, false);
                ((AnimatedStateListDrawable) this.f28712h).addTransition(R$id.indeterminate, R$id.unchecked, this.f28723s, false);
            }
        }
    }

    private void f() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f28712h;
        if (drawable != null && (colorStateList2 = this.f28715k) != null) {
            a1.a.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f28713i;
        if (drawable2 == null || (colorStateList = this.f28716l) == null) {
            return;
        }
        a1.a.o(drawable2, colorStateList);
    }

    private void g() {
    }

    @NonNull
    private String getButtonStateDescription() {
        int i11 = this.f28718n;
        return i11 == 1 ? getResources().getString(R$string.mtrl_checkbox_state_description_checked) : i11 == 0 ? getResources().getString(R$string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R$string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f28707c == null) {
            int[][] iArr = f28703x;
            int[] iArr2 = new int[iArr.length];
            int d11 = com.google.android.material.color.b.d(this, R$attr.colorControlActivated);
            int d12 = com.google.android.material.color.b.d(this, R$attr.colorError);
            int d13 = com.google.android.material.color.b.d(this, R$attr.colorSurface);
            int d14 = com.google.android.material.color.b.d(this, R$attr.colorOnSurface);
            iArr2[0] = com.google.android.material.color.b.j(d13, d12, 1.0f);
            iArr2[1] = com.google.android.material.color.b.j(d13, d11, 1.0f);
            iArr2[2] = com.google.android.material.color.b.j(d13, d14, 0.54f);
            iArr2[3] = com.google.android.material.color.b.j(d13, d14, 0.38f);
            iArr2[4] = com.google.android.material.color.b.j(d13, d14, 0.38f);
            this.f28707c = new ColorStateList(iArr, iArr2);
        }
        return this.f28707c;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f28715k;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public void addOnCheckedStateChangedListener(@NonNull b bVar) {
        this.f28706b.add(bVar);
    }

    public void addOnErrorChangedListener(@NonNull c cVar) {
        this.f28705a.add(cVar);
    }

    public void clearOnCheckedStateChangedListeners() {
        this.f28706b.clear();
    }

    public void clearOnErrorChangedListeners() {
        this.f28705a.clear();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.f28712h;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f28713i;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.f28716l;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f28717m;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.f28715k;
    }

    public int getCheckedState() {
        return this.f28718n;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f28711g;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.f28709e;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f28718n == 1;
    }

    public boolean isErrorShown() {
        return this.f28710f;
    }

    public boolean isUseMaterialThemeColors() {
        return this.f28708d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f28708d && this.f28715k == null && this.f28716l == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f28701v);
        }
        if (isErrorShown()) {
            View.mergeDrawableStates(onCreateDrawableState, f28702w);
        }
        this.f28719o = d.f(onCreateDrawableState);
        g();
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable a11;
        if (!this.f28709e || !TextUtils.isEmpty(getText()) || (a11 = androidx.core.widget.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - a11.getIntrinsicWidth()) / 2) * (f0.p(this) ? -1 : 1);
        int save = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a11.getBounds();
            a1.a.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && isErrorShown()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f28711g));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.f28725a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f28725a = getCheckedState();
        return savedState;
    }

    public void removeOnCheckedStateChangedListener(@NonNull b bVar) {
        this.f28706b.remove(bVar);
    }

    public void removeOnErrorChangedListener(@NonNull c cVar) {
        this.f28705a.remove(cVar);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i11) {
        setButtonDrawable(g.a.b(getContext(), i11));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f28712h = drawable;
        this.f28714j = false;
        c();
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f28713i = drawable;
        c();
    }

    public void setButtonIconDrawableResource(int i11) {
        setButtonIconDrawable(g.a.b(getContext(), i11));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f28716l == colorStateList) {
            return;
        }
        this.f28716l = colorStateList;
        c();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f28717m == mode) {
            return;
        }
        this.f28717m = mode;
        c();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f28715k == colorStateList) {
            return;
        }
        this.f28715k = colorStateList;
        c();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        c();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f28709e = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i11) {
        AutofillManager a11;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f28718n != i11) {
            this.f28718n = i11;
            super.setChecked(i11 == 1);
            refreshDrawableState();
            d();
            if (this.f28720p) {
                return;
            }
            this.f28720p = true;
            LinkedHashSet linkedHashSet = this.f28706b;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(it.next());
                    throw null;
                }
            }
            if (this.f28718n != 2 && (onCheckedChangeListener = this.f28722r) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (Build.VERSION.SDK_INT >= 26 && (a11 = x.b.a(getContext().getSystemService(x.a.a()))) != null) {
                a11.notifyValueChanged(this);
            }
            this.f28720p = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        g();
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.f28711g = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i11) {
        setErrorAccessibilityLabel(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f28710f == z10) {
            return;
        }
        this.f28710f = z10;
        refreshDrawableState();
        Iterator it = this.f28705a.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f28722r = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f28721q = charSequence;
        if (charSequence == null) {
            d();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f28708d = z10;
        if (z10) {
            androidx.core.widget.c.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
