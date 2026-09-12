package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.autofill.AutofillId;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int C0 = R$style.Widget_Design_TextInputLayout;
    private static final int[][] D0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private ColorStateList A;
    private boolean A0;
    private ColorStateList B;
    private boolean B0;
    private boolean C;
    private CharSequence D;
    private boolean E;
    private ab.i F;
    private ab.i G;
    private StateListDrawable H;
    private boolean I;
    private ab.i J;
    private ab.i K;
    private ab.n L;
    private boolean M;
    private final int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private final Rect V;
    private final Rect W;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f29899a;

    /* renamed from: a0, reason: collision with root package name */
    private final RectF f29900a0;

    /* renamed from: b, reason: collision with root package name */
    private final y f29901b;

    /* renamed from: b0, reason: collision with root package name */
    private Typeface f29902b0;

    /* renamed from: c, reason: collision with root package name */
    private final r f29903c;

    /* renamed from: c0, reason: collision with root package name */
    private Drawable f29904c0;

    /* renamed from: d, reason: collision with root package name */
    EditText f29905d;

    /* renamed from: d0, reason: collision with root package name */
    private int f29906d0;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f29907e;

    /* renamed from: e0, reason: collision with root package name */
    private final LinkedHashSet f29908e0;

    /* renamed from: f, reason: collision with root package name */
    private int f29909f;

    /* renamed from: f0, reason: collision with root package name */
    private Drawable f29910f0;

    /* renamed from: g, reason: collision with root package name */
    private int f29911g;

    /* renamed from: g0, reason: collision with root package name */
    private int f29912g0;

    /* renamed from: h, reason: collision with root package name */
    private int f29913h;

    /* renamed from: h0, reason: collision with root package name */
    private Drawable f29914h0;

    /* renamed from: i, reason: collision with root package name */
    private int f29915i;

    /* renamed from: i0, reason: collision with root package name */
    private ColorStateList f29916i0;

    /* renamed from: j, reason: collision with root package name */
    private final u f29917j;

    /* renamed from: j0, reason: collision with root package name */
    private ColorStateList f29918j0;

    /* renamed from: k, reason: collision with root package name */
    boolean f29919k;

    /* renamed from: k0, reason: collision with root package name */
    private int f29920k0;

    /* renamed from: l, reason: collision with root package name */
    private int f29921l;

    /* renamed from: l0, reason: collision with root package name */
    private int f29922l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29923m;

    /* renamed from: m0, reason: collision with root package name */
    private int f29924m0;

    /* renamed from: n, reason: collision with root package name */
    private d f29925n;

    /* renamed from: n0, reason: collision with root package name */
    private ColorStateList f29926n0;

    /* renamed from: o, reason: collision with root package name */
    private TextView f29927o;

    /* renamed from: o0, reason: collision with root package name */
    private int f29928o0;

    /* renamed from: p, reason: collision with root package name */
    private int f29929p;

    /* renamed from: p0, reason: collision with root package name */
    private int f29930p0;

    /* renamed from: q, reason: collision with root package name */
    private int f29931q;

    /* renamed from: q0, reason: collision with root package name */
    private int f29932q0;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f29933r;

    /* renamed from: r0, reason: collision with root package name */
    private int f29934r0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f29935s;

    /* renamed from: s0, reason: collision with root package name */
    private int f29936s0;

    /* renamed from: t, reason: collision with root package name */
    private TextView f29937t;

    /* renamed from: t0, reason: collision with root package name */
    int f29938t0;

    /* renamed from: u, reason: collision with root package name */
    private ColorStateList f29939u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f29940u0;

    /* renamed from: v, reason: collision with root package name */
    private int f29941v;

    /* renamed from: v0, reason: collision with root package name */
    final com.google.android.material.internal.b f29942v0;

    /* renamed from: w, reason: collision with root package name */
    private androidx.transition.c f29943w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f29944w0;

    /* renamed from: x, reason: collision with root package name */
    private androidx.transition.c f29945x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f29946x0;

    /* renamed from: y, reason: collision with root package name */
    private ColorStateList f29947y;

    /* renamed from: y0, reason: collision with root package name */
    private ValueAnimator f29948y0;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f29949z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f29950z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        CharSequence f29951a;

        /* renamed from: b, reason: collision with root package name */
        boolean f29952b;

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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f29951a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f29952b = parcel.readInt() == 1;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f29951a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            TextUtils.writeToParcel(this.f29951a, parcel, i11);
            parcel.writeInt(this.f29952b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        int f29953a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f29954b;

        a(EditText editText) {
            this.f29954b = editText;
            this.f29953a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.o0(!r0.A0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f29919k) {
                textInputLayout.e0(editable);
            }
            if (TextInputLayout.this.f29935s) {
                TextInputLayout.this.s0(editable);
            }
            int lineCount = this.f29954b.getLineCount();
            int i11 = this.f29953a;
            if (lineCount != i11) {
                if (lineCount < i11) {
                    int minimumHeight = ViewCompat.getMinimumHeight(this.f29954b);
                    int i12 = TextInputLayout.this.f29938t0;
                    if (minimumHeight != i12) {
                        this.f29954b.setMinimumHeight(i12);
                    }
                }
                this.f29953a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f29942v0.z0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        private final TextInputLayout f29957a;

        public c(TextInputLayout textInputLayout) {
            this.f29957a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f29957a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f29957a.getHint();
            CharSequence error = this.f29957a.getError();
            CharSequence placeholderText = this.f29957a.getPlaceholderText();
            int counterMaxLength = this.f29957a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f29957a.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(text);
            boolean isEmpty2 = TextUtils.isEmpty(hint);
            boolean L = this.f29957a.L();
            boolean isEmpty3 = TextUtils.isEmpty(error);
            boolean z10 = (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String charSequence = !isEmpty2 ? hint.toString() : "";
            this.f29957a.f29901b.B(accessibilityNodeInfoCompat);
            if (!isEmpty) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (!L && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (!isEmpty) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(isEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z10) {
                if (isEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            View t11 = this.f29957a.f29917j.t();
            if (t11 != null) {
                accessibilityNodeInfoCompat.setLabelFor(t11);
            }
            this.f29957a.f29903c.o().o(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f29957a.f29903c.o().p(view, accessibilityEvent);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        int a(Editable editable);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes4.dex */
    public interface f {
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private boolean A() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof h);
    }

    private void B() {
        Iterator it = this.f29908e0.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(this);
        }
    }

    private void C(Canvas canvas) {
        ab.i iVar;
        if (this.K == null || (iVar = this.J) == null) {
            return;
        }
        iVar.draw(canvas);
        if (this.f29905d.isFocused()) {
            Rect bounds = this.K.getBounds();
            Rect bounds2 = this.J.getBounds();
            float F = this.f29942v0.F();
            int centerX = bounds2.centerX();
            bounds.left = oa.a.c(centerX, bounds2.left, F);
            bounds.right = oa.a.c(centerX, bounds2.right, F);
            this.K.draw(canvas);
        }
    }

    private void D(Canvas canvas) {
        if (this.C) {
            this.f29942v0.l(canvas);
        }
    }

    private void E(boolean z10) {
        ValueAnimator valueAnimator = this.f29948y0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f29948y0.cancel();
        }
        if (z10 && this.f29946x0) {
            k(0.0f);
        } else {
            this.f29942v0.z0(0.0f);
        }
        if (A() && ((h) this.F).v0()) {
            x();
        }
        this.f29940u0 = true;
        K();
        this.f29901b.m(true);
        this.f29903c.L(true);
    }

    private ab.i F(boolean z10) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float f11 = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f29905d;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R$dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ab.n m11 = ab.n.a().H(f11).M(f11).w(dimensionPixelOffset).B(dimensionPixelOffset).m();
        EditText editText2 = this.f29905d;
        ab.i o11 = ab.i.o(getContext(), popupElevation, editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null);
        o11.setShapeAppearanceModel(m11);
        o11.f0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return o11;
    }

    private static Drawable G(ab.i iVar, int i11, int i12, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{com.google.android.material.color.b.j(i12, i11, 0.1f), i11}), iVar, iVar);
    }

    private int H(int i11, boolean z10) {
        return i11 + ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.f29905d.getCompoundPaddingLeft() : this.f29903c.A() : this.f29901b.c());
    }

    private int I(int i11, boolean z10) {
        return i11 - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.f29905d.getCompoundPaddingRight() : this.f29901b.c() : this.f29903c.A());
    }

    private static Drawable J(Context context, ab.i iVar, int i11, int[][] iArr) {
        int c11 = com.google.android.material.color.b.c(context, R$attr.colorSurface, "TextInputLayout");
        ab.i iVar2 = new ab.i(iVar.G());
        int j11 = com.google.android.material.color.b.j(i11, c11, 0.1f);
        iVar2.d0(new ColorStateList(iArr, new int[]{j11, 0}));
        iVar2.setTint(c11);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{j11, c11});
        ab.i iVar3 = new ab.i(iVar.G());
        iVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar2, iVar3), iVar});
    }

    private void K() {
        TextView textView = this.f29937t;
        if (textView == null || !this.f29935s) {
            return;
        }
        textView.setText((CharSequence) null);
        androidx.transition.s.a(this.f29899a, this.f29945x);
        this.f29937t.setVisibility(4);
    }

    private boolean M() {
        return X() || (this.f29927o != null && this.f29923m);
    }

    private boolean N() {
        return this.O == 1 && this.f29905d.getMinLines() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int O(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        this.f29905d.requestLayout();
    }

    private void Q() {
        o();
        l0();
        u0();
        b0();
        j();
        if (this.O != 0) {
            n0();
        }
        V();
    }

    private void R() {
        if (A()) {
            RectF rectF = this.f29900a0;
            this.f29942v0.o(rectF, this.f29905d.getWidth(), this.f29905d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.Q);
            ((h) this.F).y0(rectF);
        }
    }

    private void S() {
        if (!A() || this.f29940u0) {
            return;
        }
        x();
        R();
    }

    private static void T(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                T((ViewGroup) childAt, z10);
            }
        }
    }

    private void U() {
        TextView textView = this.f29937t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void V() {
        EditText editText = this.f29905d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i11 = this.O;
                if (i11 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i11 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    private boolean Y() {
        return (this.f29903c.J() || ((this.f29903c.C() && isEndIconVisible()) || this.f29903c.y() != null)) && this.f29903c.getMeasuredWidth() > 0;
    }

    private boolean Z() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f29901b.getMeasuredWidth() > 0;
    }

    private void a0() {
        if (this.f29937t == null || !this.f29935s || TextUtils.isEmpty(this.f29933r)) {
            return;
        }
        this.f29937t.setText(this.f29933r);
        androidx.transition.s.a(this.f29899a, this.f29943w);
        this.f29937t.setVisibility(0);
        this.f29937t.bringToFront();
        announceForAccessibility(this.f29933r);
    }

    private void b0() {
        if (this.O == 1) {
            if (xa.c.k(getContext())) {
                this.P = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (xa.c.j(getContext())) {
                this.P = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void c0(Rect rect) {
        ab.i iVar = this.J;
        if (iVar != null) {
            int i11 = rect.bottom;
            iVar.setBounds(rect.left, i11 - this.R, rect.right, i11);
        }
        ab.i iVar2 = this.K;
        if (iVar2 != null) {
            int i12 = rect.bottom;
            iVar2.setBounds(rect.left, i12 - this.S, rect.right, i12);
        }
    }

    private void d0() {
        if (this.f29927o != null) {
            EditText editText = this.f29905d;
            e0(editText == null ? null : editText.getText());
        }
    }

    private static void f0(Context context, TextView textView, int i11, int i12, boolean z10) {
        textView.setContentDescription(context.getString(z10 ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i11), Integer.valueOf(i12)));
    }

    private void g0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f29927o;
        if (textView != null) {
            W(textView, this.f29923m ? this.f29929p : this.f29931q);
            if (!this.f29923m && (colorStateList2 = this.f29947y) != null) {
                this.f29927o.setTextColor(colorStateList2);
            }
            if (!this.f29923m || (colorStateList = this.f29949z) == null) {
                return;
            }
            this.f29927o.setTextColor(colorStateList);
        }
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f29905d;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.F;
        }
        int d11 = com.google.android.material.color.b.d(this.f29905d, R$attr.colorControlHighlight);
        int i11 = this.O;
        if (i11 == 2) {
            return J(getContext(), this.F, d11, D0);
        }
        if (i11 == 1) {
            return G(this.F, this.U, d11, D0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.H == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.H = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.H.addState(new int[0], F(false));
        }
        return this.H;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.G == null) {
            this.G = F(true);
        }
        return this.G;
    }

    private void h0() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.A;
        if (colorStateList2 == null) {
            colorStateList2 = com.google.android.material.color.b.g(getContext(), R$attr.colorControlActivated);
        }
        EditText editText = this.f29905d;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable == null) {
                return;
            }
            textCursorDrawable2 = this.f29905d.getTextCursorDrawable();
            Drawable mutate = a1.a.r(textCursorDrawable2).mutate();
            if (M() && (colorStateList = this.B) != null) {
                colorStateList2 = colorStateList;
            }
            a1.a.o(mutate, colorStateList2);
        }
    }

    private void i() {
        TextView textView = this.f29937t;
        if (textView != null) {
            this.f29899a.addView(textView);
            this.f29937t.setVisibility(0);
        }
    }

    private void j() {
        if (this.f29905d == null || this.O != 1) {
            return;
        }
        if (xa.c.k(getContext())) {
            EditText editText = this.f29905d;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f29905d), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (xa.c.j(getContext())) {
            EditText editText2 = this.f29905d;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f29905d), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private void k0() {
        ViewCompat.setBackground(this.f29905d, getEditTextBoxBackground());
    }

    private void l() {
        ab.i iVar = this.F;
        if (iVar == null) {
            return;
        }
        ab.n G = iVar.G();
        ab.n nVar = this.L;
        if (G != nVar) {
            this.F.setShapeAppearanceModel(nVar);
        }
        if (v()) {
            this.F.l0(this.Q, this.T);
        }
        int p11 = p();
        this.U = p11;
        this.F.d0(ColorStateList.valueOf(p11));
        m();
        l0();
    }

    private void m() {
        if (this.J == null || this.K == null) {
            return;
        }
        if (w()) {
            this.J.d0(this.f29905d.isFocused() ? ColorStateList.valueOf(this.f29920k0) : ColorStateList.valueOf(this.T));
            this.K.d0(ColorStateList.valueOf(this.T));
        }
        invalidate();
    }

    private boolean m0() {
        int max;
        if (this.f29905d == null || this.f29905d.getMeasuredHeight() >= (max = Math.max(this.f29903c.getMeasuredHeight(), this.f29901b.getMeasuredHeight()))) {
            return false;
        }
        this.f29905d.setMinimumHeight(max);
        return true;
    }

    private void n(RectF rectF) {
        float f11 = rectF.left;
        int i11 = this.N;
        rectF.left = f11 - i11;
        rectF.right += i11;
    }

    private void n0() {
        if (this.O != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f29899a.getLayoutParams();
            int u11 = u();
            if (u11 != layoutParams.topMargin) {
                layoutParams.topMargin = u11;
                this.f29899a.requestLayout();
            }
        }
    }

    private void o() {
        int i11 = this.O;
        if (i11 == 0) {
            this.F = null;
            this.J = null;
            this.K = null;
            return;
        }
        if (i11 == 1) {
            this.F = new ab.i(this.L);
            this.J = new ab.i();
            this.K = new ab.i();
        } else {
            if (i11 != 2) {
                throw new IllegalArgumentException(this.O + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.C || (this.F instanceof h)) {
                this.F = new ab.i(this.L);
            } else {
                this.F = h.t0(this.L);
            }
            this.J = null;
            this.K = null;
        }
    }

    private int p() {
        return this.O == 1 ? com.google.android.material.color.b.i(com.google.android.material.color.b.e(this, R$attr.colorSurface, 0), this.U) : this.U;
    }

    private void p0(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f29905d;
        boolean z12 = false;
        boolean z13 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f29905d;
        if (editText2 != null && editText2.hasFocus()) {
            z12 = true;
        }
        ColorStateList colorStateList2 = this.f29916i0;
        if (colorStateList2 != null) {
            this.f29942v0.e0(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f29916i0;
            this.f29942v0.e0(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f29936s0) : this.f29936s0));
        } else if (X()) {
            this.f29942v0.e0(this.f29917j.r());
        } else if (this.f29923m && (textView = this.f29927o) != null) {
            this.f29942v0.e0(textView.getTextColors());
        } else if (z12 && (colorStateList = this.f29918j0) != null) {
            this.f29942v0.j0(colorStateList);
        }
        if (z13 || !this.f29944w0 || (isEnabled() && z12)) {
            if (z11 || this.f29940u0) {
                y(z10);
                return;
            }
            return;
        }
        if (z11 || !this.f29940u0) {
            E(z10);
        }
    }

    private Rect q(Rect rect) {
        if (this.f29905d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.W;
        boolean p11 = com.google.android.material.internal.f0.p(this);
        rect2.bottom = rect.bottom;
        int i11 = this.O;
        if (i11 == 1) {
            rect2.left = H(rect.left, p11);
            rect2.top = rect.top + this.P;
            rect2.right = I(rect.right, p11);
            return rect2;
        }
        if (i11 != 2) {
            rect2.left = H(rect.left, p11);
            rect2.top = getPaddingTop();
            rect2.right = I(rect.right, p11);
            return rect2;
        }
        rect2.left = rect.left + this.f29905d.getPaddingLeft();
        rect2.top = rect.top - u();
        rect2.right = rect.right - this.f29905d.getPaddingRight();
        return rect2;
    }

    private void q0() {
        EditText editText;
        if (this.f29937t == null || (editText = this.f29905d) == null) {
            return;
        }
        this.f29937t.setGravity(editText.getGravity());
        this.f29937t.setPadding(this.f29905d.getCompoundPaddingLeft(), this.f29905d.getCompoundPaddingTop(), this.f29905d.getCompoundPaddingRight(), this.f29905d.getCompoundPaddingBottom());
    }

    private int r(Rect rect, Rect rect2, float f11) {
        return N() ? (int) (rect2.top + f11) : rect.bottom - this.f29905d.getCompoundPaddingBottom();
    }

    private void r0() {
        EditText editText = this.f29905d;
        s0(editText == null ? null : editText.getText());
    }

    private int s(Rect rect, float f11) {
        return N() ? (int) (rect.centerY() - (f11 / 2.0f)) : rect.top + this.f29905d.getCompoundPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Editable editable) {
        if (this.f29925n.a(editable) != 0 || this.f29940u0) {
            K();
        } else {
            a0();
        }
    }

    private void setEditText(EditText editText) {
        if (this.f29905d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3) {
            boolean z10 = editText instanceof TextInputEditText;
        }
        this.f29905d = editText;
        int i11 = this.f29909f;
        if (i11 != -1) {
            setMinEms(i11);
        } else {
            setMinWidth(this.f29913h);
        }
        int i12 = this.f29911g;
        if (i12 != -1) {
            setMaxEms(i12);
        } else {
            setMaxWidth(this.f29915i);
        }
        this.I = false;
        Q();
        setTextInputAccessibilityDelegate(new c(this));
        this.f29942v0.O0(this.f29905d.getTypeface());
        this.f29942v0.w0(this.f29905d.getTextSize());
        int i13 = Build.VERSION.SDK_INT;
        this.f29942v0.r0(this.f29905d.getLetterSpacing());
        int gravity = this.f29905d.getGravity();
        this.f29942v0.k0((gravity & (-113)) | 48);
        this.f29942v0.v0(gravity);
        this.f29938t0 = ViewCompat.getMinimumHeight(editText);
        this.f29905d.addTextChangedListener(new a(editText));
        if (this.f29916i0 == null) {
            this.f29916i0 = this.f29905d.getHintTextColors();
        }
        if (this.C) {
            if (TextUtils.isEmpty(this.D)) {
                CharSequence hint = this.f29905d.getHint();
                this.f29907e = hint;
                setHint(hint);
                this.f29905d.setHint((CharSequence) null);
            }
            this.E = true;
        }
        if (i13 >= 29) {
            h0();
        }
        if (this.f29927o != null) {
            e0(this.f29905d.getText());
        }
        j0();
        this.f29917j.f();
        this.f29901b.bringToFront();
        this.f29903c.bringToFront();
        B();
        this.f29903c.D0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        p0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.D)) {
            return;
        }
        this.D = charSequence;
        this.f29942v0.L0(charSequence);
        if (this.f29940u0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f29935s == z10) {
            return;
        }
        if (z10) {
            i();
        } else {
            U();
            this.f29937t = null;
        }
        this.f29935s = z10;
    }

    private Rect t(Rect rect) {
        if (this.f29905d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.W;
        float C = this.f29942v0.C();
        rect2.left = rect.left + this.f29905d.getCompoundPaddingLeft();
        rect2.top = s(rect, C);
        rect2.right = rect.right - this.f29905d.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, C);
        return rect2;
    }

    private void t0(boolean z10, boolean z11) {
        int defaultColor = this.f29926n0.getDefaultColor();
        int colorForState = this.f29926n0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f29926n0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.T = colorForState2;
        } else if (z11) {
            this.T = colorForState;
        } else {
            this.T = defaultColor;
        }
    }

    private int u() {
        float r11;
        if (!this.C) {
            return 0;
        }
        int i11 = this.O;
        if (i11 == 0) {
            r11 = this.f29942v0.r();
        } else {
            if (i11 != 2) {
                return 0;
            }
            r11 = this.f29942v0.r() / 2.0f;
        }
        return (int) r11;
    }

    private boolean v() {
        return this.O == 2 && w();
    }

    private boolean w() {
        return this.Q > -1 && this.T != 0;
    }

    private void x() {
        if (A()) {
            ((h) this.F).w0();
        }
    }

    private void y(boolean z10) {
        ValueAnimator valueAnimator = this.f29948y0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f29948y0.cancel();
        }
        if (z10 && this.f29946x0) {
            k(1.0f);
        } else {
            this.f29942v0.z0(1.0f);
        }
        this.f29940u0 = false;
        if (A()) {
            R();
        }
        r0();
        this.f29901b.m(false);
        this.f29903c.L(false);
    }

    private androidx.transition.c z() {
        androidx.transition.c cVar = new androidx.transition.c();
        cVar.X(wa.j.f(getContext(), R$attr.motionDurationShort2, 87));
        cVar.Z(wa.j.g(getContext(), R$attr.motionEasingLinearInterpolator, oa.a.f71041a));
        return cVar;
    }

    final boolean L() {
        return this.f29940u0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(TextView textView, int i11) {
        try {
            androidx.core.widget.m.q(textView, i11);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.m.q(textView, R$style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(androidx.core.content.b.getColor(getContext(), R$color.design_error));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean X() {
        return this.f29917j.l();
    }

    public void addOnEditTextAttachedListener(@NonNull e eVar) {
        this.f29908e0.add(eVar);
        if (this.f29905d != null) {
            eVar.a(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull f fVar) {
        this.f29903c.g(fVar);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i11, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i11, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f29899a.addView(view, layoutParams2);
        this.f29899a.setLayoutParams(layoutParams);
        n0();
        setEditText((EditText) view);
    }

    public void clearOnEditTextAttachedListeners() {
        this.f29908e0.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.f29903c.j();
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i11) {
        AutofillId autofillId;
        EditText editText = this.f29905d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i11);
            return;
        }
        if (this.f29907e != null) {
            boolean z10 = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.f29905d.setHint(this.f29907e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i11);
                return;
            } finally {
                this.f29905d.setHint(hint);
                this.E = z10;
            }
        }
        autofillId = getAutofillId();
        viewStructure.setAutofillId(autofillId);
        onProvideAutofillStructure(viewStructure, i11);
        onProvideAutofillVirtualStructure(viewStructure, i11);
        viewStructure.setChildCount(this.f29899a.getChildCount());
        for (int i12 = 0; i12 < this.f29899a.getChildCount(); i12++) {
            View childAt = this.f29899a.getChildAt(i12);
            ViewStructure newChild = viewStructure.newChild(i12);
            childAt.dispatchProvideAutofillStructure(newChild, i11);
            if (childAt == this.f29905d) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.A0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.A0 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f29950z0) {
            return;
        }
        this.f29950z0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.b bVar = this.f29942v0;
        boolean J0 = bVar != null ? bVar.J0(drawableState) : false;
        if (this.f29905d != null) {
            o0(ViewCompat.isLaidOut(this) && isEnabled());
        }
        j0();
        u0();
        if (J0) {
            invalidate();
        }
        this.f29950z0 = false;
    }

    void e0(Editable editable) {
        int a11 = this.f29925n.a(editable);
        boolean z10 = this.f29923m;
        int i11 = this.f29921l;
        if (i11 == -1) {
            this.f29927o.setText(String.valueOf(a11));
            this.f29927o.setContentDescription(null);
            this.f29923m = false;
        } else {
            this.f29923m = a11 > i11;
            f0(getContext(), this.f29927o, a11, this.f29921l, this.f29923m);
            if (z10 != this.f29923m) {
                g0();
            }
            this.f29927o.setText(androidx.core.text.a.c().l(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(a11), Integer.valueOf(this.f29921l))));
        }
        if (this.f29905d == null || z10 == this.f29923m) {
            return;
        }
        o0(false);
        u0();
        j0();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f29905d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    @NonNull
    ab.i getBoxBackground() {
        int i11 = this.O;
        if (i11 == 1 || i11 == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.U;
    }

    public int getBoxBackgroundMode() {
        return this.O;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.P;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.f0.p(this) ? this.L.j().a(this.f29900a0) : this.L.l().a(this.f29900a0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.f0.p(this) ? this.L.l().a(this.f29900a0) : this.L.j().a(this.f29900a0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.f0.p(this) ? this.L.r().a(this.f29900a0) : this.L.t().a(this.f29900a0);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.f0.p(this) ? this.L.t().a(this.f29900a0) : this.L.r().a(this.f29900a0);
    }

    public int getBoxStrokeColor() {
        return this.f29924m0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f29926n0;
    }

    public int getBoxStrokeWidth() {
        return this.R;
    }

    public int getBoxStrokeWidthFocused() {
        return this.S;
    }

    public int getCounterMaxLength() {
        return this.f29921l;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f29919k && this.f29923m && (textView = this.f29927o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f29949z;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f29947y;
    }

    @Nullable
    public ColorStateList getCursorColor() {
        return this.A;
    }

    @Nullable
    public ColorStateList getCursorErrorColor() {
        return this.B;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f29916i0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f29905d;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f29903c.n();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f29903c.p();
    }

    public int getEndIconMinSize() {
        return this.f29903c.q();
    }

    public int getEndIconMode() {
        return this.f29903c.r();
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f29903c.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f29903c.t();
    }

    @Nullable
    public CharSequence getError() {
        if (this.f29917j.A()) {
            return this.f29917j.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f29917j.n();
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f29917j.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f29917j.q();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f29903c.u();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f29917j.B()) {
            return this.f29917j.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f29917j.u();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f29942v0.r();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f29942v0.w();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f29918j0;
    }

    @NonNull
    public d getLengthCounter() {
        return this.f29925n;
    }

    public int getMaxEms() {
        return this.f29911g;
    }

    public int getMaxWidth() {
        return this.f29915i;
    }

    public int getMinEms() {
        return this.f29909f;
    }

    public int getMinWidth() {
        return this.f29913h;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f29903c.w();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f29903c.x();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f29935s) {
            return this.f29933r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f29941v;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f29939u;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f29901b.a();
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f29901b.b();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f29901b.d();
    }

    @NonNull
    public ab.n getShapeAppearanceModel() {
        return this.L;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f29901b.e();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f29901b.f();
    }

    public int getStartIconMinSize() {
        return this.f29901b.g();
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f29901b.h();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f29903c.y();
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f29903c.z();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f29903c.B();
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f29902b0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i0() {
        boolean z10;
        if (this.f29905d == null) {
            return false;
        }
        boolean z11 = true;
        if (Z()) {
            int measuredWidth = this.f29901b.getMeasuredWidth() - this.f29905d.getPaddingLeft();
            if (this.f29904c0 == null || this.f29906d0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f29904c0 = colorDrawable;
                this.f29906d0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a11 = androidx.core.widget.m.a(this.f29905d);
            Drawable drawable = a11[0];
            Drawable drawable2 = this.f29904c0;
            if (drawable != drawable2) {
                androidx.core.widget.m.k(this.f29905d, drawable2, a11[1], a11[2], a11[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f29904c0 != null) {
                Drawable[] a12 = androidx.core.widget.m.a(this.f29905d);
                androidx.core.widget.m.k(this.f29905d, null, a12[1], a12[2], a12[3]);
                this.f29904c0 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (Y()) {
            int measuredWidth2 = this.f29903c.B().getMeasuredWidth() - this.f29905d.getPaddingRight();
            CheckableImageButton m11 = this.f29903c.m();
            if (m11 != null) {
                measuredWidth2 = measuredWidth2 + m11.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) m11.getLayoutParams());
            }
            Drawable[] a13 = androidx.core.widget.m.a(this.f29905d);
            Drawable drawable3 = this.f29910f0;
            if (drawable3 == null || this.f29912g0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f29910f0 = colorDrawable2;
                    this.f29912g0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a13[2];
                Drawable drawable5 = this.f29910f0;
                if (drawable4 != drawable5) {
                    this.f29914h0 = drawable4;
                    androidx.core.widget.m.k(this.f29905d, a13[0], a13[1], drawable5, a13[3]);
                } else {
                    z11 = z10;
                }
            } else {
                this.f29912g0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.m.k(this.f29905d, a13[0], a13[1], this.f29910f0, a13[3]);
            }
        } else {
            if (this.f29910f0 == null) {
                return z10;
            }
            Drawable[] a14 = androidx.core.widget.m.a(this.f29905d);
            if (a14[2] == this.f29910f0) {
                androidx.core.widget.m.k(this.f29905d, a14[0], a14[1], this.f29914h0, a14[3]);
            } else {
                z11 = z10;
            }
            this.f29910f0 = null;
        }
        return z11;
    }

    public boolean isCounterEnabled() {
        return this.f29919k;
    }

    public boolean isEndIconCheckable() {
        return this.f29903c.G();
    }

    public boolean isEndIconVisible() {
        return this.f29903c.I();
    }

    public boolean isErrorEnabled() {
        return this.f29917j.A();
    }

    public boolean isExpandedHintEnabled() {
        return this.f29944w0;
    }

    public boolean isHelperTextEnabled() {
        return this.f29917j.B();
    }

    public boolean isHintAnimationEnabled() {
        return this.f29946x0;
    }

    public boolean isHintEnabled() {
        return this.C;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.f29903c.K();
    }

    public boolean isProvidingHint() {
        return this.E;
    }

    public boolean isStartIconCheckable() {
        return this.f29901b.k();
    }

    public boolean isStartIconVisible() {
        return this.f29901b.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f29905d;
        if (editText == null || this.O != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.y.a(background)) {
            background = background.mutate();
        }
        if (X()) {
            background.setColorFilter(androidx.appcompat.widget.f.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f29923m && (textView = this.f29927o) != null) {
            background.setColorFilter(androidx.appcompat.widget.f.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            a1.a.c(background);
            this.f29905d.refreshDrawableState();
        }
    }

    void k(float f11) {
        if (this.f29942v0.F() == f11) {
            return;
        }
        if (this.f29948y0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f29948y0 = valueAnimator;
            valueAnimator.setInterpolator(wa.j.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, oa.a.f71042b));
            this.f29948y0.setDuration(wa.j.f(getContext(), R$attr.motionDurationMedium4, 167));
            this.f29948y0.addUpdateListener(new b());
        }
        this.f29948y0.setFloatValues(this.f29942v0.F(), f11);
        this.f29948y0.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0() {
        EditText editText = this.f29905d;
        if (editText == null || this.F == null) {
            return;
        }
        if ((this.I || editText.getBackground() == null) && this.O != 0) {
            k0();
            this.I = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(boolean z10) {
        p0(z10, false);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f29942v0.Z(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f29903c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.B0 = false;
        boolean m02 = m0();
        boolean i02 = i0();
        if (m02 || i02) {
            this.f29905d.post(new Runnable() { // from class: com.google.android.material.textfield.f0
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout.this.P();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        EditText editText = this.f29905d;
        if (editText != null) {
            Rect rect = this.V;
            com.google.android.material.internal.d.a(this, editText, rect);
            c0(rect);
            if (this.C) {
                this.f29942v0.w0(this.f29905d.getTextSize());
                int gravity = this.f29905d.getGravity();
                this.f29942v0.k0((gravity & (-113)) | 48);
                this.f29942v0.v0(gravity);
                this.f29942v0.g0(q(rect));
                this.f29942v0.q0(t(rect));
                this.f29942v0.b0();
                if (!A() || this.f29940u0) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!this.B0) {
            this.f29903c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.B0 = true;
        }
        q0();
        this.f29903c.D0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f29951a);
        if (savedState.f29952b) {
            post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f29903c.i();
                }
            });
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i11) {
        super.onRtlPropertiesChanged(i11);
        boolean z10 = i11 == 1;
        if (z10 != this.M) {
            float a11 = this.L.r().a(this.f29900a0);
            float a12 = this.L.t().a(this.f29900a0);
            ab.n m11 = ab.n.a().G(this.L.s()).L(this.L.q()).v(this.L.k()).A(this.L.i()).H(a12).M(a11).w(this.L.l().a(this.f29900a0)).B(this.L.j().a(this.f29900a0)).m();
            this.M = z10;
            setShapeAppearanceModel(m11);
        }
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (X()) {
            savedState.f29951a = getError();
        }
        savedState.f29952b = this.f29903c.H();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z10) {
        this.f29903c.A0(z10);
    }

    public void refreshEndIconDrawableState() {
        this.f29903c.N();
    }

    public void refreshErrorIconDrawableState() {
        this.f29903c.O();
    }

    public void refreshStartIconDrawableState() {
        this.f29901b.n();
    }

    public void removeOnEditTextAttachedListener(@NonNull e eVar) {
        this.f29908e0.remove(eVar);
    }

    public void removeOnEndIconChangedListener(@NonNull f fVar) {
        this.f29903c.Q(fVar);
    }

    public void setBoxBackgroundColor(int i11) {
        if (this.U != i11) {
            this.U = i11;
            this.f29928o0 = i11;
            this.f29932q0 = i11;
            this.f29934r0 = i11;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i11) {
        setBoxBackgroundColor(androidx.core.content.b.getColor(getContext(), i11));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f29928o0 = defaultColor;
        this.U = defaultColor;
        this.f29930p0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f29932q0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f29934r0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i11) {
        if (i11 == this.O) {
            return;
        }
        this.O = i11;
        if (this.f29905d != null) {
            Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i11) {
        this.P = i11;
    }

    public void setBoxCornerFamily(int i11) {
        this.L = this.L.v().F(i11, this.L.r()).K(i11, this.L.t()).u(i11, this.L.j()).z(i11, this.L.l()).m();
        l();
    }

    public void setBoxCornerRadii(float f11, float f12, float f13, float f14) {
        boolean p11 = com.google.android.material.internal.f0.p(this);
        this.M = p11;
        float f15 = p11 ? f12 : f11;
        if (!p11) {
            f11 = f12;
        }
        float f16 = p11 ? f14 : f13;
        if (!p11) {
            f13 = f14;
        }
        ab.i iVar = this.F;
        if (iVar != null && iVar.L() == f15 && this.F.M() == f11 && this.F.u() == f16 && this.F.v() == f13) {
            return;
        }
        this.L = this.L.v().H(f15).M(f11).w(f16).B(f13).m();
        l();
    }

    public void setBoxCornerRadiiResources(int i11, int i12, int i13, int i14) {
        setBoxCornerRadii(getContext().getResources().getDimension(i11), getContext().getResources().getDimension(i12), getContext().getResources().getDimension(i14), getContext().getResources().getDimension(i13));
    }

    public void setBoxStrokeColor(int i11) {
        if (this.f29924m0 != i11) {
            this.f29924m0 = i11;
            u0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f29920k0 = colorStateList.getDefaultColor();
            this.f29936s0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f29922l0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f29924m0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f29924m0 != colorStateList.getDefaultColor()) {
            this.f29924m0 = colorStateList.getDefaultColor();
        }
        u0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f29926n0 != colorStateList) {
            this.f29926n0 = colorStateList;
            u0();
        }
    }

    public void setBoxStrokeWidth(int i11) {
        this.R = i11;
        u0();
    }

    public void setBoxStrokeWidthFocused(int i11) {
        this.S = i11;
        u0();
    }

    public void setBoxStrokeWidthFocusedResource(int i11) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i11));
    }

    public void setBoxStrokeWidthResource(int i11) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i11));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f29919k != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f29927o = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.f29902b0;
                if (typeface != null) {
                    this.f29927o.setTypeface(typeface);
                }
                this.f29927o.setMaxLines(1);
                this.f29917j.e(this.f29927o, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f29927o.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                g0();
                d0();
            } else {
                this.f29917j.C(this.f29927o, 2);
                this.f29927o = null;
            }
            this.f29919k = z10;
        }
    }

    public void setCounterMaxLength(int i11) {
        if (this.f29921l != i11) {
            if (i11 > 0) {
                this.f29921l = i11;
            } else {
                this.f29921l = -1;
            }
            if (this.f29919k) {
                d0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i11) {
        if (this.f29929p != i11) {
            this.f29929p = i11;
            g0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f29949z != colorStateList) {
            this.f29949z = colorStateList;
            g0();
        }
    }

    public void setCounterTextAppearance(int i11) {
        if (this.f29931q != i11) {
            this.f29931q = i11;
            g0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f29947y != colorStateList) {
            this.f29947y = colorStateList;
            g0();
        }
    }

    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            h0();
        }
    }

    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            if (M()) {
                h0();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f29916i0 = colorStateList;
        this.f29918j0 = colorStateList;
        if (this.f29905d != null) {
            o0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        T(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f29903c.S(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f29903c.T(z10);
    }

    public void setEndIconContentDescription(int i11) {
        this.f29903c.U(i11);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        this.f29903c.V(charSequence);
    }

    public void setEndIconDrawable(int i11) {
        this.f29903c.W(i11);
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.f29903c.X(drawable);
    }

    public void setEndIconMinSize(int i11) {
        this.f29903c.Y(i11);
    }

    public void setEndIconMode(int i11) {
        this.f29903c.Z(i11);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f29903c.a0(onClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f29903c.b0(onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f29903c.c0(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29903c.d0(colorStateList);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f29903c.e0(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f29903c.f0(z10);
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f29917j.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f29917j.w();
        } else {
            this.f29917j.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i11) {
        this.f29917j.E(i11);
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f29917j.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f29917j.G(z10);
    }

    public void setErrorIconDrawable(int i11) {
        this.f29903c.g0(i11);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f29903c.h0(drawable);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f29903c.i0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f29903c.j0(onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29903c.k0(colorStateList);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f29903c.l0(mode);
    }

    public void setErrorTextAppearance(int i11) {
        this.f29917j.H(i11);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f29917j.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f29944w0 != z10) {
            this.f29944w0 = z10;
            o0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.f29917j.R(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f29917j.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f29917j.K(z10);
    }

    public void setHelperTextTextAppearance(int i11) {
        this.f29917j.J(i11);
    }

    public void setHint(int i11) {
        setHint(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f29946x0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.C) {
            this.C = z10;
            if (z10) {
                CharSequence hint = this.f29905d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f29905d.setHint((CharSequence) null);
                }
                this.E = true;
            } else {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f29905d.getHint())) {
                    this.f29905d.setHint(this.D);
                }
                setHintInternal(null);
            }
            if (this.f29905d != null) {
                n0();
            }
        }
    }

    public void setHintTextAppearance(int i11) {
        this.f29942v0.h0(i11);
        this.f29918j0 = this.f29942v0.p();
        if (this.f29905d != null) {
            o0(false);
            n0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f29918j0 != colorStateList) {
            if (this.f29916i0 == null) {
                this.f29942v0.j0(colorStateList);
            }
            this.f29918j0 = colorStateList;
            if (this.f29905d != null) {
                o0(false);
            }
        }
    }

    public void setLengthCounter(@NonNull d dVar) {
        this.f29925n = dVar;
    }

    public void setMaxEms(int i11) {
        this.f29911g = i11;
        EditText editText = this.f29905d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMaxEms(i11);
    }

    public void setMaxWidth(int i11) {
        this.f29915i = i11;
        EditText editText = this.f29905d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMaxWidth(i11);
    }

    public void setMaxWidthResource(int i11) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i11));
    }

    public void setMinEms(int i11) {
        this.f29909f = i11;
        EditText editText = this.f29905d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMinEms(i11);
    }

    public void setMinWidth(int i11) {
        this.f29913h = i11;
        EditText editText = this.f29905d;
        if (editText == null || i11 == -1) {
            return;
        }
        editText.setMinWidth(i11);
    }

    public void setMinWidthResource(int i11) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i11));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i11) {
        this.f29903c.n0(i11);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f29903c.o0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i11) {
        this.f29903c.p0(i11);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f29903c.q0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f29903c.r0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.f29903c.s0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.f29903c.t0(mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f29937t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f29937t = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            ViewCompat.setImportantForAccessibility(this.f29937t, 2);
            androidx.transition.c z10 = z();
            this.f29943w = z10;
            z10.c0(67L);
            this.f29945x = z();
            setPlaceholderTextAppearance(this.f29941v);
            setPlaceholderTextColor(this.f29939u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f29935s) {
                setPlaceholderTextEnabled(true);
            }
            this.f29933r = charSequence;
        }
        r0();
    }

    public void setPlaceholderTextAppearance(int i11) {
        this.f29941v = i11;
        TextView textView = this.f29937t;
        if (textView != null) {
            androidx.core.widget.m.q(textView, i11);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f29939u != colorStateList) {
            this.f29939u = colorStateList;
            TextView textView = this.f29937t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.f29901b.o(charSequence);
    }

    public void setPrefixTextAppearance(int i11) {
        this.f29901b.p(i11);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f29901b.q(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull ab.n nVar) {
        ab.i iVar = this.F;
        if (iVar == null || iVar.G() == nVar) {
            return;
        }
        this.L = nVar;
        l();
    }

    public void setStartIconCheckable(boolean z10) {
        this.f29901b.r(z10);
    }

    public void setStartIconContentDescription(int i11) {
        setStartIconContentDescription(i11 != 0 ? getResources().getText(i11) : null);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.f29901b.s(charSequence);
    }

    public void setStartIconDrawable(int i11) {
        setStartIconDrawable(i11 != 0 ? g.a.b(getContext(), i11) : null);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f29901b.t(drawable);
    }

    public void setStartIconMinSize(int i11) {
        this.f29901b.u(i11);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f29901b.v(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f29901b.w(onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f29901b.x(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.f29901b.y(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f29901b.z(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f29901b.A(z10);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.f29903c.u0(charSequence);
    }

    public void setSuffixTextAppearance(int i11) {
        this.f29903c.v0(i11);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f29903c.w0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable c cVar) {
        EditText editText = this.f29905d;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, cVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f29902b0) {
            this.f29902b0 = typeface;
            this.f29942v0.O0(typeface);
            this.f29917j.N(typeface);
            TextView textView = this.f29927o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.F == null || this.O == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f29905d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f29905d) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.T = this.f29936s0;
        } else if (X()) {
            if (this.f29926n0 != null) {
                t0(z11, z10);
            } else {
                this.T = getErrorCurrentTextColors();
            }
        } else if (!this.f29923m || (textView = this.f29927o) == null) {
            if (z11) {
                this.T = this.f29924m0;
            } else if (z10) {
                this.T = this.f29922l0;
            } else {
                this.T = this.f29920k0;
            }
        } else if (this.f29926n0 != null) {
            t0(z11, z10);
        } else {
            this.T = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            h0();
        }
        this.f29903c.M();
        refreshStartIconDrawableState();
        if (this.O == 2) {
            int i11 = this.Q;
            if (z11 && isEnabled()) {
                this.Q = this.S;
            } else {
                this.Q = this.R;
            }
            if (this.Q != i11) {
                S();
            }
        }
        if (this.O == 1) {
            if (!isEnabled()) {
                this.U = this.f29930p0;
            } else if (z10 && !z11) {
                this.U = this.f29934r0;
            } else if (z11) {
                this.U = this.f29932q0;
            } else {
                this.U = this.f29928o0;
            }
        }
        l();
    }
}
