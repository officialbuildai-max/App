package com.google.android.material.chip;

import ab.j;
import ab.n;
import ab.q;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.a;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.f0;
import com.google.android.material.internal.l;
import java.util.List;
import oa.h;
import xa.d;
import xa.f;

/* loaded from: classes4.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0394a, q, l {

    /* renamed from: t, reason: collision with root package name */
    private static final int f28727t = R$style.Widget_MaterialComponents_Chip_Action;

    /* renamed from: u, reason: collision with root package name */
    private static final Rect f28728u = new Rect();

    /* renamed from: v, reason: collision with root package name */
    private static final int[] f28729v = {R.attr.state_selected};

    /* renamed from: w, reason: collision with root package name */
    private static final int[] f28730w = {R.attr.state_checkable};

    /* renamed from: a, reason: collision with root package name */
    private com.google.android.material.chip.a f28731a;

    /* renamed from: b, reason: collision with root package name */
    private InsetDrawable f28732b;

    /* renamed from: c, reason: collision with root package name */
    private RippleDrawable f28733c;

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f28734d;

    /* renamed from: e, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f28735e;

    /* renamed from: f, reason: collision with root package name */
    private l.a f28736f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28737g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f28738h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f28739i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f28740j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f28741k;

    /* renamed from: l, reason: collision with root package name */
    private int f28742l;

    /* renamed from: m, reason: collision with root package name */
    private int f28743m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f28744n;

    /* renamed from: o, reason: collision with root package name */
    private final c f28745o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f28746p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f28747q;

    /* renamed from: r, reason: collision with root package name */
    private final RectF f28748r;

    /* renamed from: s, reason: collision with root package name */
    private final f f28749s;

    /* loaded from: classes4.dex */
    class a extends f {
        a() {
        }

        @Override // xa.f
        public void a(int i11) {
        }

        @Override // xa.f
        public void b(Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            chip.setText(chip.f28731a.W2() ? Chip.this.f28731a.p1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f28731a != null) {
                Chip.this.f28731a.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends androidx.customview.widget.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.a
        protected void B(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.isCheckable());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            accessibilityNodeInfoCompat.setClassName(Chip.this.getAccessibilityClassName());
            accessibilityNodeInfoCompat.setText(Chip.this.getText());
        }

        @Override // androidx.customview.widget.a
        protected void C(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i11 != 1) {
                accessibilityNodeInfoCompat.setContentDescription("");
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.f28728u);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                accessibilityNodeInfoCompat.setContentDescription(Chip.this.getContext().getString(R$string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.a
        protected void D(int i11, boolean z10) {
            if (i11 == 1) {
                Chip.this.f28740j = z10;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // androidx.customview.widget.a
        protected int o(float f11, float f12) {
            return (Chip.this.l() && Chip.this.getCloseIconTouchBounds().contains(f11, f12)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.a
        protected void p(List list) {
            list.add(0);
            if (Chip.this.l() && Chip.this.isCloseIconVisible() && Chip.this.f28734d != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.a
        protected boolean y(int i11, int i12, Bundle bundle) {
            if (i12 != 16) {
                return false;
            }
            if (i11 == 0) {
                return Chip.this.performClick();
            }
            if (i11 == 1) {
                return Chip.this.performCloseIconClick();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.chip.Chip.f28727t
            android.content.Context r7 = bb.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r6.f28747q = r7
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>()
            r6.f28748r = r7
            com.google.android.material.chip.Chip$a r7 = new com.google.android.material.chip.Chip$a
            r7.<init>()
            r6.f28749s = r7
            android.content.Context r0 = r6.getContext()
            r6.x(r8)
            com.google.android.material.chip.a r7 = com.google.android.material.chip.a.D0(r0, r8, r9, r4)
            r6.m(r0, r8, r9)
            r6.setChipDrawable(r7)
            float r1 = androidx.core.view.ViewCompat.getElevation(r6)
            r7.c0(r1)
            int[] r2 = com.google.android.material.R$styleable.Chip
            r1 = 0
            int[] r5 = new int[r1]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.Chip_shapeAppearance
            boolean r9 = r8.hasValue(r9)
            r8.recycle()
            com.google.android.material.chip.Chip$c r8 = new com.google.android.material.chip.Chip$c
            r8.<init>(r6)
            r6.f28745o = r8
            r6.s()
            if (r9 != 0) goto L59
            r6.n()
        L59:
            boolean r8 = r6.f28737g
            r6.setChecked(r8)
            java.lang.CharSequence r8 = r7.p1()
            r6.setText(r8)
            android.text.TextUtils$TruncateAt r7 = r7.j1()
            r6.setEllipsize(r7)
            r6.w()
            com.google.android.material.chip.a r7 = r6.f28731a
            boolean r7 = r7.W2()
            if (r7 != 0) goto L7e
            r7 = 1
            r6.setLines(r7)
            r6.setHorizontallyScrolling(r7)
        L7e:
            r7 = 8388627(0x800013, float:1.175497E-38)
            r6.setGravity(r7)
            r6.v()
            boolean r7 = r6.shouldEnsureMinTouchTargetSize()
            if (r7 == 0) goto L92
            int r7 = r6.f28743m
            r6.setMinHeight(r7)
        L92:
            int r7 = androidx.core.view.ViewCompat.getLayoutDirection(r6)
            r6.f28742l = r7
            ra.b r7 = new ra.b
            r7.<init>()
            super.setOnCheckedChangeListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.f28748r.setEmpty();
        if (l() && this.f28734d != null) {
            this.f28731a.g1(this.f28748r);
        }
        return this.f28748r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f28747q.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f28747q;
    }

    @Nullable
    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.q1();
        }
        return null;
    }

    private void i(com.google.android.material.chip.a aVar) {
        aVar.z2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    private int[] j() {
        ?? isEnabled = isEnabled();
        int i11 = isEnabled;
        if (this.f28740j) {
            i11 = isEnabled + 1;
        }
        int i12 = i11;
        if (this.f28739i) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (this.f28738h) {
            i13 = i12 + 1;
        }
        int i14 = i13;
        if (isChecked()) {
            i14 = i13 + 1;
        }
        int[] iArr = new int[i14];
        int i15 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i15 = 1;
        }
        if (this.f28740j) {
            iArr[i15] = 16842908;
            i15++;
        }
        if (this.f28739i) {
            iArr[i15] = 16843623;
            i15++;
        }
        if (this.f28738h) {
            iArr[i15] = 16842919;
            i15++;
        }
        if (isChecked()) {
            iArr[i15] = 16842913;
        }
        return iArr;
    }

    private void k() {
        if (getBackgroundDrawable() == this.f28732b && this.f28731a.getCallback() == null) {
            this.f28731a.setCallback(this.f28732b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        com.google.android.material.chip.a aVar = this.f28731a;
        return (aVar == null || aVar.Z0() == null) ? false : true;
    }

    private void m(Context context, AttributeSet attributeSet, int i11) {
        TypedArray i12 = b0.i(context, attributeSet, R$styleable.Chip, i11, f28727t, new int[0]);
        this.f28741k = i12.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.f28743m = (int) Math.ceil(i12.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(f0.g(getContext(), 48))));
        i12.recycle();
    }

    private void n() {
        setOutlineProvider(new b());
    }

    private void o(int i11, int i12, int i13, int i14) {
        this.f28732b = new InsetDrawable((Drawable) this.f28731a, i11, i12, i13, i14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(CompoundButton compoundButton, boolean z10) {
        l.a aVar = this.f28736f;
        if (aVar != null) {
            aVar.a(this, z10);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f28735e;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
        }
    }

    private void q() {
        if (this.f28732b != null) {
            this.f28732b = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            t();
        }
    }

    private void r(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.z2(null);
        }
    }

    private void s() {
        if (l() && isCloseIconVisible() && this.f28734d != null) {
            ViewCompat.setAccessibilityDelegate(this, this.f28745o);
            this.f28746p = true;
        } else {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.f28746p = false;
        }
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f28739i != z10) {
            this.f28739i = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f28738h != z10) {
            this.f28738h = z10;
            refreshDrawableState();
        }
    }

    private void t() {
        if (ya.b.f79079a) {
            u();
            return;
        }
        this.f28731a.V2(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        v();
        k();
    }

    private void u() {
        this.f28733c = new RippleDrawable(ya.b.d(this.f28731a.n1()), getBackgroundDrawable(), null);
        this.f28731a.V2(false);
        ViewCompat.setBackground(this, this.f28733c);
        v();
    }

    private void v() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f28731a) == null) {
            return;
        }
        int R0 = (int) (aVar.R0() + this.f28731a.r1() + this.f28731a.y0());
        int W0 = (int) (this.f28731a.W0() + this.f28731a.s1() + this.f28731a.u0());
        if (this.f28732b != null) {
            Rect rect = new Rect();
            this.f28732b.getPadding(rect);
            W0 += rect.left;
            R0 += rect.right;
        }
        ViewCompat.setPaddingRelative(this, W0, getPaddingTop(), R0, getPaddingBottom());
    }

    private void w() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f28749s);
        }
    }

    private void x(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f28746p ? super.dispatchHoverEvent(motionEvent) : this.f28745o.i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f28746p) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f28745o.j(keyEvent) || this.f28745o.n() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f28731a;
        if ((aVar == null || !aVar.z1()) ? false : this.f28731a.v2(j())) {
            invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(int i11) {
        this.f28743m = i11;
        if (!shouldEnsureMinTouchTargetSize()) {
            if (this.f28732b != null) {
                q();
            } else {
                t();
            }
            return false;
        }
        int max = Math.max(0, i11 - this.f28731a.getIntrinsicHeight());
        int max2 = Math.max(0, i11 - this.f28731a.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f28732b != null) {
                q();
            } else {
                t();
            }
            return false;
        }
        int i12 = max2 > 0 ? max2 / 2 : 0;
        int i13 = max > 0 ? max / 2 : 0;
        if (this.f28732b != null) {
            Rect rect = new Rect();
            this.f28732b.getPadding(rect);
            if (rect.top == i13 && rect.bottom == i13 && rect.left == i12 && rect.right == i12) {
                t();
                return true;
            }
        }
        if (getMinHeight() != i11) {
            setMinHeight(i11);
        }
        if (getMinWidth() != i11) {
            setMinWidth(i11);
        }
        o(i12, i13, i12, i13);
        t();
        return true;
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f28744n)) {
            return this.f28744n;
        }
        if (!isCheckable()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).isSingleSelection()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f28732b;
        return insetDrawable == null ? this.f28731a : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.P0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return Math.max(0.0f, aVar.Q0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f28731a;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.T0();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.U0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.V0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.W0();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.X0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.Y0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.Z0();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.b1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.d1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.j1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.f28746p && (this.f28745o.n() == 1 || this.f28745o.k() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Nullable
    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.k1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.l1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.m1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.n1();
        }
        return null;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        return this.f28731a.G();
    }

    @Nullable
    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.o1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.r1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            return aVar.s1();
        }
        return 0.0f;
    }

    public boolean isCheckable() {
        com.google.android.material.chip.a aVar = this.f28731a;
        return aVar != null && aVar.w1();
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        com.google.android.material.chip.a aVar = this.f28731a;
        return aVar != null && aVar.x1();
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        com.google.android.material.chip.a aVar = this.f28731a;
        return aVar != null && aVar.y1();
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        com.google.android.material.chip.a aVar = this.f28731a;
        return aVar != null && aVar.A1();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.f(this, this.f28731a);
    }

    @Override // com.google.android.material.chip.a.InterfaceC0394a
    public void onChipDrawableSizeChange() {
        ensureAccessibleTouchTarget(this.f28743m);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f28729v);
        }
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, f28730w);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i11, Rect rect) {
        super.onFocusChanged(z10, i11, rect);
        if (this.f28746p) {
            this.f28745o.x(z10, i11, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.getRowIndex(this), 1, chipGroup.isSingleLine() ? chipGroup.e(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i11) {
        PointerIcon systemIcon;
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return super.onResolvePointerIcon(motionEvent, i11);
        }
        systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
        return systemIcon;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i11) {
        super.onRtlPropertiesChanged(i11);
        if (this.f28742l != i11) {
            this.f28742l = i11;
            v();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L35
            goto L40
        L21:
            boolean r0 = r5.f28738h
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L41
        L2c:
            boolean r0 = r5.f28738h
            if (r0 == 0) goto L35
            r5.performCloseIconClick()
            r0 = r2
            goto L36
        L35:
            r0 = r3
        L36:
            r5.setCloseIconPressed(r3)
            goto L41
        L3a:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
            goto L2a
        L40:
            r0 = r3
        L41:
            if (r0 != 0) goto L4b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
            goto L4b
        L4a:
            r2 = r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performCloseIconClick() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f28734d;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f28746p) {
            this.f28745o.J(1, 1);
        }
        return z10;
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.f28744n = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f28733c) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f28733c) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i11) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.H1(z10);
        }
    }

    public void setCheckableResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.I1(i11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar == null) {
            this.f28737g = z10;
        } else if (aVar.w1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.J1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i11) {
        setCheckedIconVisible(i11);
    }

    public void setCheckedIconResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.K1(i11);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.L1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.M1(i11);
        }
    }

    public void setCheckedIconVisible(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.N1(i11);
        }
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.O1(z10);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.P1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.Q1(i11);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.R1(f11);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.S1(i11);
        }
    }

    public void setChipDrawable(@NonNull com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f28731a;
        if (aVar2 != aVar) {
            r(aVar2);
            this.f28731a = aVar;
            aVar.K2(false);
            i(this.f28731a);
            ensureAccessibleTouchTarget(this.f28743m);
        }
    }

    public void setChipEndPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.T1(f11);
        }
    }

    public void setChipEndPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.U1(i11);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.V1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i11) {
        setChipIconVisible(i11);
    }

    public void setChipIconResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.W1(i11);
        }
    }

    public void setChipIconSize(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.X1(f11);
        }
    }

    public void setChipIconSizeResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.Y1(i11);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.Z1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.a2(i11);
        }
    }

    public void setChipIconVisible(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.b2(i11);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.c2(z10);
        }
    }

    public void setChipMinHeight(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.d2(f11);
        }
    }

    public void setChipMinHeightResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.e2(i11);
        }
    }

    public void setChipStartPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.f2(f11);
        }
    }

    public void setChipStartPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.g2(i11);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.h2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.i2(i11);
        }
    }

    public void setChipStrokeWidth(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.j2(f11);
        }
    }

    public void setChipStrokeWidthResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.k2(i11);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i11) {
        setText(getResources().getString(i11));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.m2(drawable);
        }
        s();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.n2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i11) {
        setCloseIconVisible(i11);
    }

    public void setCloseIconEndPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.o2(f11);
        }
    }

    public void setCloseIconEndPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.p2(i11);
        }
    }

    public void setCloseIconResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.q2(i11);
        }
        s();
    }

    public void setCloseIconSize(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.r2(f11);
        }
    }

    public void setCloseIconSizeResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.s2(i11);
        }
    }

    public void setCloseIconStartPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.t2(f11);
        }
    }

    public void setCloseIconStartPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.u2(i11);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.w2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.x2(i11);
        }
    }

    public void setCloseIconVisible(int i11) {
        setCloseIconVisible(getResources().getBoolean(i11));
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.y2(z10);
        }
        s();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i13 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i11, i12, i13, i14);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i11, int i12, int i13, int i14) {
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i13 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i11, i12, i13, i14);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void setElevation(float f11) {
        super.setElevation(f11);
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.c0(f11);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f28731a == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.A2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f28741k = z10;
        ensureAccessibleTouchTarget(this.f28743m);
    }

    @Override // android.widget.TextView
    public void setGravity(int i11) {
        if (i11 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i11);
        }
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.B2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.C2(i11);
        }
    }

    public void setIconEndPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.D2(f11);
        }
    }

    public void setIconEndPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.E2(i11);
        }
    }

    public void setIconStartPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.F2(f11);
        }
    }

    public void setIconStartPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.G2(i11);
        }
    }

    @Override // com.google.android.material.internal.l
    public void setInternalOnCheckedChangeListener(@Nullable l.a aVar) {
        this.f28736f = aVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i11) {
        if (this.f28731a == null) {
            return;
        }
        super.setLayoutDirection(i11);
    }

    @Override // android.widget.TextView
    public void setLines(int i11) {
        if (i11 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i11);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i11) {
        if (i11 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i11);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i11) {
        super.setMaxWidth(i11);
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.H2(i11);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i11) {
        if (i11 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i11);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f28735e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f28734d = onClickListener;
        s();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.I2(colorStateList);
        }
        if (this.f28731a.u1()) {
            return;
        }
        u();
    }

    public void setRippleColorResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.J2(i11);
            if (this.f28731a.u1()) {
                return;
            }
            u();
        }
    }

    @Override // ab.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        this.f28731a.setShapeAppearanceModel(nVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.L2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.M2(i11);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.W2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f28731a;
        if (aVar2 != null) {
            aVar2.N2(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i11) {
        super.setTextAppearance(i11);
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.P2(i11);
        }
        w();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i11) {
        super.setTextAppearance(context, i11);
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.P2(i11);
        }
        w();
    }

    public void setTextAppearance(@Nullable d dVar) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.O2(dVar);
        }
        w();
    }

    public void setTextAppearanceResource(int i11) {
        setTextAppearance(getContext(), i11);
    }

    public void setTextEndPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.Q2(f11);
        }
    }

    public void setTextEndPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.R2(i11);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i11, float f11) {
        super.setTextSize(i11, f11);
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.S2(TypedValue.applyDimension(i11, f11, getResources().getDisplayMetrics()));
        }
        w();
    }

    public void setTextStartPadding(float f11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.T2(f11);
        }
    }

    public void setTextStartPaddingResource(int i11) {
        com.google.android.material.chip.a aVar = this.f28731a;
        if (aVar != null) {
            aVar.U2(i11);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.f28741k;
    }
}
