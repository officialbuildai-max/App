package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes4.dex */
abstract class b extends AccessibilityDelegateCompat {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat f30168a;

    public b(Context context, int i11) {
        this.f30168a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i11));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.f30168a);
    }
}
