package com.google.accompanist.systemuicontroller;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final View f24230a;

    /* renamed from: b, reason: collision with root package name */
    private final Window f24231b;

    /* renamed from: c, reason: collision with root package name */
    private final WindowInsetsControllerCompat f24232c;

    public a(View view, Window window) {
        Intrinsics.h(view, "view");
        this.f24230a = view;
        this.f24231b = window;
        this.f24232c = window != null ? WindowCompat.getInsetsController(window, view) : null;
    }

    @Override // com.google.accompanist.systemuicontroller.c
    public void a(long j11, boolean z10, Function1 transformColorForLightContent) {
        WindowInsetsControllerCompat windowInsetsControllerCompat;
        Intrinsics.h(transformColorForLightContent, "transformColorForLightContent");
        f(z10);
        Window window = this.f24231b;
        if (window == null) {
            return;
        }
        if (z10 && ((windowInsetsControllerCompat = this.f24232c) == null || !windowInsetsControllerCompat.isAppearanceLightStatusBars())) {
            j11 = ((u1) transformColorForLightContent.invoke(u1.g(j11))).u();
        }
        window.setStatusBarColor(w1.j(j11));
    }

    @Override // com.google.accompanist.systemuicontroller.c
    public void b(long j11, boolean z10, boolean z11, Function1 transformColorForLightContent) {
        WindowInsetsControllerCompat windowInsetsControllerCompat;
        Intrinsics.h(transformColorForLightContent, "transformColorForLightContent");
        e(z10);
        d(z11);
        Window window = this.f24231b;
        if (window == null) {
            return;
        }
        if (z10 && ((windowInsetsControllerCompat = this.f24232c) == null || !windowInsetsControllerCompat.isAppearanceLightNavigationBars())) {
            j11 = ((u1) transformColorForLightContent.invoke(u1.g(j11))).u();
        }
        window.setNavigationBarColor(w1.j(j11));
    }

    @Override // com.google.accompanist.systemuicontroller.c
    public /* synthetic */ void c(long j11, boolean z10, boolean z11, Function1 function1) {
        b.a(this, j11, z10, z11, function1);
    }

    public void d(boolean z10) {
        Window window;
        if (Build.VERSION.SDK_INT < 29 || (window = this.f24231b) == null) {
            return;
        }
        window.setNavigationBarContrastEnforced(z10);
    }

    public void e(boolean z10) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.f24232c;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(z10);
    }

    public void f(boolean z10) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.f24232c;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z10);
    }
}
