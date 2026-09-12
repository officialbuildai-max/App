package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.d {

    /* renamed from: e, reason: collision with root package name */
    private TimePickerView f30129e;

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f30130f;

    /* renamed from: g, reason: collision with root package name */
    private h f30131g;

    /* renamed from: h, reason: collision with root package name */
    private l f30132h;

    /* renamed from: i, reason: collision with root package name */
    private i f30133i;

    /* renamed from: j, reason: collision with root package name */
    private int f30134j;

    /* renamed from: k, reason: collision with root package name */
    private int f30135k;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f30137m;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f30139o;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f30141q;

    /* renamed from: r, reason: collision with root package name */
    private MaterialButton f30142r;

    /* renamed from: s, reason: collision with root package name */
    private Button f30143s;

    /* renamed from: u, reason: collision with root package name */
    private TimeModel f30145u;

    /* renamed from: a, reason: collision with root package name */
    private final Set f30125a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    private final Set f30126b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set f30127c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    private final Set f30128d = new LinkedHashSet();

    /* renamed from: l, reason: collision with root package name */
    private int f30136l = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f30138n = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f30140p = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f30144t = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f30146v = 0;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.f30125a.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.f30126b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.f30144t = materialTimePicker.f30144t == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.k0(materialTimePicker2.f30142r);
        }
    }

    private Pair e0(int i11) {
        if (i11 == 0) {
            return new Pair(Integer.valueOf(this.f30134j), Integer.valueOf(R$string.material_timepicker_text_input_mode_description));
        }
        if (i11 == 1) {
            return new Pair(Integer.valueOf(this.f30135k), Integer.valueOf(R$string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i11);
    }

    private int f0() {
        int i11 = this.f30146v;
        if (i11 != 0) {
            return i11;
        }
        TypedValue a11 = xa.b.a(requireContext(), R$attr.materialTimePickerTheme);
        if (a11 == null) {
            return 0;
        }
        return a11.data;
    }

    private i g0(int i11, TimePickerView timePickerView, ViewStub viewStub) {
        if (i11 != 0) {
            if (this.f30132h == null) {
                this.f30132h = new l((LinearLayout) viewStub.inflate(), this.f30145u);
            }
            this.f30132h.e();
            return this.f30132h;
        }
        h hVar = this.f30131g;
        if (hVar == null) {
            hVar = new h(timePickerView, this.f30145u);
        }
        this.f30131g = hVar;
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        i iVar = this.f30133i;
        if (iVar instanceof l) {
            ((l) iVar).i();
        }
    }

    private void i0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
        this.f30145u = timeModel;
        if (timeModel == null) {
            this.f30145u = new TimeModel();
        }
        this.f30144t = bundle.getInt("TIME_PICKER_INPUT_MODE", this.f30145u.f30150a != 1 ? 0 : 1);
        this.f30136l = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
        this.f30137m = bundle.getCharSequence("TIME_PICKER_TITLE_TEXT");
        this.f30138n = bundle.getInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", 0);
        this.f30139o = bundle.getCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT");
        this.f30140p = bundle.getInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", 0);
        this.f30141q = bundle.getCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT");
        this.f30146v = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
    }

    private void j0() {
        Button button = this.f30143s;
        if (button != null) {
            button.setVisibility(isCancelable() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(MaterialButton materialButton) {
        if (materialButton == null || this.f30129e == null || this.f30130f == null) {
            return;
        }
        i iVar = this.f30133i;
        if (iVar != null) {
            iVar.hide();
        }
        i g02 = g0(this.f30144t, this.f30129e, this.f30130f);
        this.f30133i = g02;
        g02.show();
        this.f30133i.invalidate();
        Pair e02 = e0(this.f30144t);
        materialButton.setIconResource(((Integer) e02.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) e02.second).intValue()));
        materialButton.sendAccessibilityEvent(4);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void l() {
        this.f30144t = 1;
        k0(this.f30142r);
        this.f30132h.i();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f30127c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        i0(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), f0());
        Context context = dialog.getContext();
        ab.i iVar = new ab.i(context, null, R$attr.materialTimePickerStyle, R$style.Widget_MaterialComponents_TimePicker);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialTimePicker, R$attr.materialTimePickerStyle, R$style.Widget_MaterialComponents_TimePicker);
        this.f30135k = obtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_clockIcon, 0);
        this.f30134j = obtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_keyboardIcon, 0);
        int color = obtainStyledAttributes.getColor(R$styleable.MaterialTimePicker_backgroundTint, 0);
        obtainStyledAttributes.recycle();
        iVar.S(context);
        iVar.d0(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(iVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        iVar.c0(ViewCompat.getElevation(window.getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R$id.material_timepicker_view);
        this.f30129e = timePickerView;
        timePickerView.u(this);
        this.f30130f = (ViewStub) viewGroup2.findViewById(R$id.material_textinput_timepicker);
        this.f30142r = (MaterialButton) viewGroup2.findViewById(R$id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R$id.header_title);
        int i11 = this.f30136l;
        if (i11 != 0) {
            textView.setText(i11);
        } else if (!TextUtils.isEmpty(this.f30137m)) {
            textView.setText(this.f30137m);
        }
        k0(this.f30142r);
        Button button = (Button) viewGroup2.findViewById(R$id.material_timepicker_ok_button);
        button.setOnClickListener(new a());
        int i12 = this.f30138n;
        if (i12 != 0) {
            button.setText(i12);
        } else if (!TextUtils.isEmpty(this.f30139o)) {
            button.setText(this.f30139o);
        }
        Button button2 = (Button) viewGroup2.findViewById(R$id.material_timepicker_cancel_button);
        this.f30143s = button2;
        button2.setOnClickListener(new b());
        int i13 = this.f30140p;
        if (i13 != 0) {
            this.f30143s.setText(i13);
        } else if (!TextUtils.isEmpty(this.f30141q)) {
            this.f30143s.setText(this.f30141q);
        }
        j0();
        this.f30142r.setOnClickListener(new c());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f30133i = null;
        this.f30131g = null;
        this.f30132h = null;
        TimePickerView timePickerView = this.f30129e;
        if (timePickerView != null) {
            timePickerView.u(null);
            this.f30129e = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f30128d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.f30145u);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.f30144t);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f30136l);
        bundle.putCharSequence("TIME_PICKER_TITLE_TEXT", this.f30137m);
        bundle.putInt("TIME_PICKER_POSITIVE_BUTTON_TEXT_RES", this.f30138n);
        bundle.putCharSequence("TIME_PICKER_POSITIVE_BUTTON_TEXT", this.f30139o);
        bundle.putInt("TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES", this.f30140p);
        bundle.putCharSequence("TIME_PICKER_NEGATIVE_BUTTON_TEXT", this.f30141q);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.f30146v);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f30133i instanceof l) {
            view.postDelayed(new Runnable() { // from class: com.google.android.material.timepicker.d
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialTimePicker.this.h0();
                }
            }, 100L);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        j0();
    }
}
