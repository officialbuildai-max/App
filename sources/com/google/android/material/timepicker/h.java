package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.material.R$string;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;

/* loaded from: classes4.dex */
class h implements ClockHandView.c, TimePickerView.f, TimePickerView.e, ClockHandView.b, i {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f30176f = {"12", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "10", PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f30177g = {"00", "1", "2", "3", "4", "5", PrepareException.ERROR_NO_URL, "7", PrepareException.ERROR_MANIFEST_INFO, PrepareException.ERROR_MINI_APP_CLOSE, "10", PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, "12", PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION, "14", PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, "16", "17", "18", "19", "20", ChainPoint.ROUTE_PAGE, "22", "23"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f30178h = {"00", "5", "10", PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: a, reason: collision with root package name */
    private final TimePickerView f30179a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeModel f30180b;

    /* renamed from: c, reason: collision with root package name */
    private float f30181c;

    /* renamed from: d, reason: collision with root package name */
    private float f30182d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f30183e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends com.google.android.material.timepicker.b {
        a(Context context, int i11) {
            super(context, i11);
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(h.this.f30180b.c(), String.valueOf(h.this.f30180b.d())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends com.google.android.material.timepicker.b {
        b(Context context, int i11) {
            super(context, i11);
        }

        @Override // com.google.android.material.timepicker.b, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R$string.material_minute_suffix, String.valueOf(h.this.f30180b.f30152c)));
        }
    }

    public h(TimePickerView timePickerView, TimeModel timeModel) {
        this.f30179a = timePickerView;
        this.f30180b = timeModel;
        h();
    }

    private String[] f() {
        return this.f30180b.f30150a == 1 ? f30177g : f30176f;
    }

    private int g() {
        return (this.f30180b.d() * 30) % 360;
    }

    private void i(int i11, int i12) {
        TimeModel timeModel = this.f30180b;
        if (timeModel.f30152c == i12 && timeModel.f30151b == i11) {
            return;
        }
        this.f30179a.performHapticFeedback(4);
    }

    private void k() {
        TimeModel timeModel = this.f30180b;
        int i11 = 1;
        if (timeModel.f30153d == 10 && timeModel.f30150a == 1 && timeModel.f30151b >= 12) {
            i11 = 2;
        }
        this.f30179a.p(i11);
    }

    private void l() {
        TimePickerView timePickerView = this.f30179a;
        TimeModel timeModel = this.f30180b;
        timePickerView.C(timeModel.f30154e, timeModel.d(), this.f30180b.f30152c);
    }

    private void m() {
        n(f30176f, TimeModel.NUMBER_FORMAT);
        n(f30178h, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void n(String[] strArr, String str) {
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr[i11] = TimeModel.b(this.f30179a.getResources(), strArr[i11], str);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void a(float f11, boolean z10) {
        this.f30183e = true;
        TimeModel timeModel = this.f30180b;
        int i11 = timeModel.f30152c;
        int i12 = timeModel.f30151b;
        if (timeModel.f30153d == 10) {
            this.f30179a.q(this.f30182d, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) androidx.core.content.b.getSystemService(this.f30179a.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                j(12, true);
            }
        } else {
            int round = Math.round(f11);
            if (!z10) {
                this.f30180b.i(((round + 15) / 30) * 5);
                this.f30181c = this.f30180b.f30152c * 6;
            }
            this.f30179a.q(this.f30181c, z10);
        }
        this.f30183e = false;
        l();
        i(i12, i11);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.e
    public void b(int i11) {
        this.f30180b.j(i11);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void c(int i11) {
        j(i11, true);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void d(float f11, boolean z10) {
        if (this.f30183e) {
            return;
        }
        TimeModel timeModel = this.f30180b;
        int i11 = timeModel.f30151b;
        int i12 = timeModel.f30152c;
        int round = Math.round(f11);
        TimeModel timeModel2 = this.f30180b;
        if (timeModel2.f30153d == 12) {
            timeModel2.i((round + 3) / 6);
            this.f30181c = (float) Math.floor(this.f30180b.f30152c * 6);
        } else {
            int i13 = (round + 15) / 30;
            if (timeModel2.f30150a == 1) {
                i13 %= 12;
                if (this.f30179a.l() == 2) {
                    i13 += 12;
                }
            }
            this.f30180b.h(i13);
            this.f30182d = g();
        }
        if (z10) {
            return;
        }
        l();
        i(i11, i12);
    }

    public void h() {
        if (this.f30180b.f30150a == 0) {
            this.f30179a.A();
        }
        this.f30179a.k(this);
        this.f30179a.w(this);
        this.f30179a.v(this);
        this.f30179a.t(this);
        m();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.i
    public void hide() {
        this.f30179a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.i
    public void invalidate() {
        this.f30182d = g();
        TimeModel timeModel = this.f30180b;
        this.f30181c = timeModel.f30152c * 6;
        j(timeModel.f30153d, false);
        l();
    }

    void j(int i11, boolean z10) {
        boolean z11 = i11 == 12;
        this.f30179a.o(z11);
        this.f30180b.f30153d = i11;
        this.f30179a.y(z11 ? f30178h : f(), z11 ? R$string.material_minute_suffix : this.f30180b.c());
        k();
        this.f30179a.q(z11 ? this.f30181c : this.f30182d, z10);
        this.f30179a.n(i11);
        this.f30179a.s(new a(this.f30179a.getContext(), R$string.material_hour_selection));
        this.f30179a.r(new b(this.f30179a.getContext(), R$string.material_minute_selection));
    }

    @Override // com.google.android.material.timepicker.i
    public void show() {
        this.f30179a.setVisibility(0);
    }
}
