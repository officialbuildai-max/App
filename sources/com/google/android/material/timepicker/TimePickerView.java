package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class TimePickerView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Chip f30155a;

    /* renamed from: b, reason: collision with root package name */
    private final Chip f30156b;

    /* renamed from: c, reason: collision with root package name */
    private final ClockHandView f30157c;

    /* renamed from: d, reason: collision with root package name */
    private final ClockFaceView f30158d;

    /* renamed from: e, reason: collision with root package name */
    private final MaterialButtonToggleGroup f30159e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnClickListener f30160f;

    /* renamed from: g, reason: collision with root package name */
    private e f30161g;

    /* renamed from: h, reason: collision with root package name */
    private f f30162h;

    /* renamed from: i, reason: collision with root package name */
    private d f30163i;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.f30162h != null) {
                TimePickerView.this.f30162h.c(((Integer) view.getTag(R$id.selection_type)).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            d dVar = TimePickerView.this.f30163i;
            if (dVar == null) {
                return false;
            }
            dVar.l();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f30166a;

        c(GestureDetector gestureDetector) {
            this.f30166a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f30166a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    interface d {
        void l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface e {
        void b(int i11);
    }

    /* loaded from: classes4.dex */
    interface f {
        void c(int i11);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f30160f = new a();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.f30158d = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f30159e = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.c() { // from class: com.google.android.material.timepicker.m
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.c
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i12, boolean z10) {
                TimePickerView.this.m(materialButtonToggleGroup2, i12, z10);
            }
        });
        this.f30155a = (Chip) findViewById(R$id.material_minute_tv);
        this.f30156b = (Chip) findViewById(R$id.material_hour_tv);
        this.f30157c = (ClockHandView) findViewById(R$id.material_clock_hand);
        z();
        x();
    }

    private void B(Chip chip, boolean z10) {
        chip.setChecked(z10);
        ViewCompat.setAccessibilityLiveRegion(chip, z10 ? 2 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z10) {
        e eVar;
        if (z10 && (eVar = this.f30161g) != null) {
            eVar.b(i11 == R$id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    private void x() {
        this.f30155a.setTag(R$id.selection_type, 12);
        this.f30156b.setTag(R$id.selection_type, 10);
        this.f30155a.setOnClickListener(this.f30160f);
        this.f30156b.setOnClickListener(this.f30160f);
        this.f30155a.setAccessibilityClassName("android.view.View");
        this.f30156b.setAccessibilityClassName("android.view.View");
    }

    private void z() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f30155a.setOnTouchListener(cVar);
        this.f30156b.setOnTouchListener(cVar);
    }

    public void A() {
        this.f30159e.setVisibility(0);
    }

    public void C(int i11, int i12, int i13) {
        this.f30159e.check(i11 == 1 ? R$id.material_clock_period_pm_button : R$id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i13));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i12));
        if (!TextUtils.equals(this.f30155a.getText(), format)) {
            this.f30155a.setText(format);
        }
        if (TextUtils.equals(this.f30156b.getText(), format2)) {
            return;
        }
        this.f30156b.setText(format2);
    }

    public void k(ClockHandView.c cVar) {
        this.f30157c.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f30158d.u();
    }

    public void n(int i11) {
        B(this.f30155a, i11 == 12);
        B(this.f30156b, i11 == 10);
    }

    public void o(boolean z10) {
        this.f30157c.n(z10);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (view == this && i11 == 0) {
            this.f30156b.sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i11) {
        this.f30158d.y(i11);
    }

    public void q(float f11, boolean z10) {
        this.f30157c.r(f11, z10);
    }

    public void r(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f30155a, accessibilityDelegateCompat);
    }

    public void s(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.f30156b, accessibilityDelegateCompat);
    }

    public void t(ClockHandView.b bVar) {
        this.f30157c.u(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(d dVar) {
        this.f30163i = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(e eVar) {
        this.f30161g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(f fVar) {
        this.f30162h = fVar;
    }

    public void y(String[] strArr, int i11) {
        this.f30158d.z(strArr, i11);
    }
}
