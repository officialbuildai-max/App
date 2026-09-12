package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.List;

/* loaded from: classes4.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: e, reason: collision with root package name */
    private final ListPopupWindow f29885e;

    /* renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f29886f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f29887g;

    /* renamed from: h, reason: collision with root package name */
    private final int f29888h;

    /* renamed from: i, reason: collision with root package name */
    private final float f29889i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f29890j;

    /* renamed from: k, reason: collision with root package name */
    private int f29891k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f29892l;

    /* loaded from: classes4.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            MaterialAutoCompleteTextView.this.l(i11 < 0 ? materialAutoCompleteTextView.f29885e.u() : materialAutoCompleteTextView.getAdapter().getItem(i11));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i11 < 0) {
                    view = MaterialAutoCompleteTextView.this.f29885e.x();
                    i11 = MaterialAutoCompleteTextView.this.f29885e.w();
                    j11 = MaterialAutoCompleteTextView.this.f29885e.v();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f29885e.o(), view, i11, j11);
            }
            MaterialAutoCompleteTextView.this.f29885e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends ArrayAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ColorStateList f29894a;

        /* renamed from: b, reason: collision with root package name */
        private ColorStateList f29895b;

        b(Context context, int i11, String[] strArr) {
            super(context, i11, strArr);
            f();
        }

        private ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{com.google.android.material.color.b.i(MaterialAutoCompleteTextView.this.f29891k, MaterialAutoCompleteTextView.this.f29892l.getColorForState(iArr2, 0)), com.google.android.material.color.b.i(MaterialAutoCompleteTextView.this.f29891k, MaterialAutoCompleteTextView.this.f29892l.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.f29891k});
        }

        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f29891k);
            if (this.f29895b == null) {
                return colorDrawable;
            }
            a1.a.o(colorDrawable, this.f29894a);
            return new RippleDrawable(this.f29895b, colorDrawable, null);
        }

        private boolean c() {
            return MaterialAutoCompleteTextView.this.f29891k != 0;
        }

        private boolean d() {
            return MaterialAutoCompleteTextView.this.f29892l != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f29892l.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f29895b = e();
            this.f29894a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i11, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                ViewCompat.setBackground(textView, MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(bb.a.c(context, attributeSet, i11, 0), attributeSet, i11);
        this.f29887g = new Rect();
        Context context2 = getContext();
        TypedArray i12 = com.google.android.material.internal.b0.i(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i11, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (i12.hasValue(R$styleable.MaterialAutoCompleteTextView_android_inputType) && i12.getInt(R$styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f29888h = i12.getResourceId(R$styleable.MaterialAutoCompleteTextView_simpleItemLayout, R$layout.mtrl_auto_complete_simple_item);
        this.f29889i = i12.getDimensionPixelOffset(R$styleable.MaterialAutoCompleteTextView_android_popupElevation, R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (i12.hasValue(R$styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint)) {
            this.f29890j = ColorStateList.valueOf(i12.getColor(R$styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint, 0));
        }
        this.f29891k = i12.getColor(R$styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f29892l = xa.c.a(context2, i12, R$styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f29886f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f29885e = listPopupWindow;
        listPopupWindow.I(true);
        listPopupWindow.C(this);
        listPopupWindow.H(2);
        listPopupWindow.m(getAdapter());
        listPopupWindow.K(new a());
        if (i12.hasValue(R$styleable.MaterialAutoCompleteTextView_simpleItems)) {
            setSimpleItems(i12.getResourceId(R$styleable.MaterialAutoCompleteTextView_simpleItems, 0));
        }
        i12.recycle();
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        return i() || h();
    }

    private boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f29886f;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f29886f.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean i() {
        AccessibilityManager accessibilityManager = this.f29886f;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int j() {
        ListAdapter adapter = getAdapter();
        TextInputLayout f11 = f();
        int i11 = 0;
        if (adapter == null || f11 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f29885e.w()) + 15);
        View view = null;
        int i12 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(max, view, f11);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i12 = Math.max(i12, view.getMeasuredWidth());
        }
        Drawable g11 = this.f29885e.g();
        if (g11 != null) {
            g11.getPadding(this.f29887g);
            Rect rect = this.f29887g;
            i12 += rect.left + rect.right;
        }
        return i12 + f11.getEndIconView().getMeasuredWidth();
    }

    private void k() {
        TextInputLayout f11 = f();
        if (f11 != null) {
            f11.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f29885e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.f29890j;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout f11 = f();
        return (f11 == null || !f11.isProvidingHint()) ? super.getHint() : f11.getHint();
    }

    public float getPopupElevation() {
        return this.f29889i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f29891k;
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f29892l;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout f11 = f();
        if (f11 != null && f11.isProvidingHint() && super.getHint() == null && com.google.android.material.internal.k.d()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29885e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j()), View.MeasureSpec.getSize(i11)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t11) {
        super.setAdapter(t11);
        this.f29885e.m(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f29885e;
        if (listPopupWindow != null) {
            listPopupWindow.b(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i11) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i11));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.f29890j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof ab.i) {
            ((ab.i) dropDownBackground).d0(this.f29890j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f29885e.L(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i11) {
        super.setRawInputType(i11);
        k();
    }

    public void setSimpleItemSelectedColor(int i11) {
        this.f29891k = i11;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList colorStateList) {
        this.f29892l = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i11) {
        setSimpleItems(getResources().getStringArray(i11));
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new b(getContext(), this.f29888h, strArr));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f29885e.show();
        } else {
            super.showDropDown();
        }
    }
}
