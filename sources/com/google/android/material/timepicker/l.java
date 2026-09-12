package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.a0;
import com.google.android.material.internal.f0;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class l implements TimePickerView.f, i {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f30191a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeModel f30192b;

    /* renamed from: c, reason: collision with root package name */
    private final TextWatcher f30193c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final TextWatcher f30194d = new b();

    /* renamed from: e, reason: collision with root package name */
    private final ChipTextInputComboView f30195e;

    /* renamed from: f, reason: collision with root package name */
    private final ChipTextInputComboView f30196f;

    /* renamed from: g, reason: collision with root package name */
    private final j f30197g;

    /* renamed from: h, reason: collision with root package name */
    private final EditText f30198h;

    /* renamed from: i, reason: collision with root package name */
    private final EditText f30199i;

    /* renamed from: j, reason: collision with root package name */
    private MaterialButtonToggleGroup f30200j;

    /* loaded from: classes4.dex */
    class a extends a0 {
        a() {
        }

        @Override // com.google.android.material.internal.a0, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    l.this.f30192b.i(0);
                } else {
                    l.this.f30192b.i(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    class b extends a0 {
        b() {
        }

        @Override // com.google.android.material.internal.a0, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    l.this.f30192b.h(0);
                } else {
                    l.this.f30192b.h(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.c(((Integer) view.getTag(R$id.selection_type)).intValue());
        }
    }

    /* loaded from: classes4.dex */
    class d extends com.google.android.material.timepicker.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TimeModel f30204b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i11, TimeModel timeModel) {
            super(context, i11);
            this.f30204b = timeModel;
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(this.f30204b.c(), String.valueOf(this.f30204b.d())));
        }
    }

    /* loaded from: classes4.dex */
    class e extends com.google.android.material.timepicker.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TimeModel f30206b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Context context, int i11, TimeModel timeModel) {
            super(context, i11);
            this.f30206b = timeModel;
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R$string.material_minute_suffix, String.valueOf(this.f30206b.f30152c)));
        }
    }

    public l(LinearLayout linearLayout, TimeModel timeModel) {
        this.f30191a = linearLayout;
        this.f30192b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_minute_text_input);
        this.f30195e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_hour_text_input);
        this.f30196f = chipTextInputComboView2;
        TextView textView = (TextView) chipTextInputComboView.findViewById(R$id.material_label);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(R$id.material_label);
        textView.setText(resources.getString(R$string.material_timepicker_minute));
        textView2.setText(resources.getString(R$string.material_timepicker_hour));
        chipTextInputComboView.setTag(R$id.selection_type, 12);
        chipTextInputComboView2.setTag(R$id.selection_type, 10);
        if (timeModel.f30150a == 0) {
            k();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.e());
        chipTextInputComboView.c(timeModel.f());
        this.f30198h = chipTextInputComboView2.e().getEditText();
        this.f30199i = chipTextInputComboView.e().getEditText();
        this.f30197g = new j(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new d(linearLayout.getContext(), R$string.material_hour_selection, timeModel));
        chipTextInputComboView.f(new e(linearLayout.getContext(), R$string.material_minute_selection, timeModel));
        f();
    }

    private void d() {
        this.f30198h.addTextChangedListener(this.f30194d);
        this.f30199i.addTextChangedListener(this.f30193c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z10) {
        if (z10) {
            this.f30192b.j(i11 == R$id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    private void h() {
        this.f30198h.removeTextChangedListener(this.f30194d);
        this.f30199i.removeTextChangedListener(this.f30193c);
    }

    private void j(TimeModel timeModel) {
        h();
        Locale locale = this.f30191a.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.f30152c));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.d()));
        this.f30195e.g(format);
        this.f30196f.g(format2);
        d();
        l();
    }

    private void k() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f30191a.findViewById(R$id.material_clock_period_toggle);
        this.f30200j = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.c() { // from class: com.google.android.material.timepicker.k
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.c
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z10) {
                l.this.g(materialButtonToggleGroup2, i11, z10);
            }
        });
        this.f30200j.setVisibility(0);
        l();
    }

    private void l() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f30200j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.check(this.f30192b.f30154e == 0 ? R$id.material_clock_period_am_button : R$id.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void c(int i11) {
        this.f30192b.f30153d = i11;
        this.f30195e.setChecked(i11 == 12);
        this.f30196f.setChecked(i11 == 10);
        l();
    }

    public void e() {
        this.f30195e.setChecked(false);
        this.f30196f.setChecked(false);
    }

    public void f() {
        d();
        j(this.f30192b);
        this.f30197g.a();
    }

    @Override // com.google.android.material.timepicker.i
    public void hide() {
        View focusedChild = this.f30191a.getFocusedChild();
        if (focusedChild != null) {
            f0.o(focusedChild, false);
        }
        this.f30191a.setVisibility(8);
    }

    public void i() {
        this.f30195e.setChecked(this.f30192b.f30153d == 12);
        this.f30196f.setChecked(this.f30192b.f30153d == 10);
    }

    @Override // com.google.android.material.timepicker.i
    public void invalidate() {
        j(this.f30192b);
    }

    @Override // com.google.android.material.timepicker.i
    public void show() {
        this.f30191a.setVisibility(0);
        c(this.f30192b.f30153d);
    }
}
