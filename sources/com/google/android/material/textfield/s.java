package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    final TextInputLayout f30030a;

    /* renamed from: b, reason: collision with root package name */
    final r f30031b;

    /* renamed from: c, reason: collision with root package name */
    final Context f30032c;

    /* renamed from: d, reason: collision with root package name */
    final CheckableImageButton f30033d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.f30030a = rVar.f30000a;
        this.f30031b = rVar;
        this.f30032c = rVar.getContext();
        this.f30033d = rVar.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Editable editable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i11, int i12, int i13) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i11) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(EditText editText) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        this.f30031b.P(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
    }
}
