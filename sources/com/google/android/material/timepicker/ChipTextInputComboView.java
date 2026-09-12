package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.a0;
import com.google.android.material.internal.f0;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    private final Chip f30080a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f30081b;

    /* renamed from: c, reason: collision with root package name */
    private final EditText f30082c;

    /* renamed from: d, reason: collision with root package name */
    private TextWatcher f30083d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f30084e;

    /* loaded from: classes4.dex */
    private class b extends a0 {
        private b() {
        }

        @Override // com.google.android.material.internal.a0, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f30080a.setText(ChipTextInputComboView.this.d("00"));
                return;
            }
            String d11 = ChipTextInputComboView.this.d(editable);
            Chip chip = ChipTextInputComboView.this.f30080a;
            if (TextUtils.isEmpty(d11)) {
                d11 = ChipTextInputComboView.this.d("00");
            }
            chip.setText(d11);
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.f30080a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.f30081b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f30082c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f30083d = bVar;
        editText.addTextChangedListener(bVar);
        h();
        addView(chip);
        addView(textInputLayout);
        this.f30084e = (TextView) findViewById(R$id.material_label);
        editText.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.f30084e, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void h() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f30082c.setImeHintLocales(locales);
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f30082c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f30082c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f30081b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f30080a, accessibilityDelegateCompat);
    }

    public void g(CharSequence charSequence) {
        String d11 = d(charSequence);
        this.f30080a.setText(d11);
        if (TextUtils.isEmpty(d11)) {
            return;
        }
        this.f30082c.removeTextChangedListener(this.f30083d);
        this.f30082c.setText(d11);
        this.f30082c.addTextChangedListener(this.f30083d);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f30080a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        this.f30080a.setChecked(z10);
        this.f30082c.setVisibility(z10 ? 0 : 4);
        this.f30080a.setVisibility(z10 ? 8 : 0);
        if (isChecked()) {
            f0.t(this.f30082c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f30080a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i11, Object obj) {
        this.f30080a.setTag(i11, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f30080a.toggle();
    }
}
