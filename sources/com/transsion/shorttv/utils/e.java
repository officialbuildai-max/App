package com.transsion.shorttv.utils;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.a0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final a f53703c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f53704d = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.utils.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            e g11;
            g11 = e.g();
            return g11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private List f53705a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f53706b;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return (e) e.f53704d.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FragmentActivity fragmentActivity, e eVar) {
        int i11;
        int i12;
        View decorView;
        WindowInsets rootWindowInsets;
        if (fragmentActivity.isFinishing()) {
            return;
        }
        Window window = fragmentActivity.getWindow();
        Insets mandatorySystemGestureInsets = (window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : rootWindowInsets.getMandatorySystemGestureInsets();
        if (mandatorySystemGestureInsets != null) {
            i11 = mandatorySystemGestureInsets.bottom;
            if (i11 <= a0.a(40.0f)) {
                i12 = mandatorySystemGestureInsets.bottom;
                eVar.f53706b = i12;
                a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "on get navigation gesture height = " + i12, false, 4, null);
                return;
            }
        }
        a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "is open navigation bar 2", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e g() {
        return new e();
    }

    public final List d() {
        return this.f53705a;
    }

    public final void e(final FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.f53706b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "is open navigation bar", false, 4, null);
            this.f53706b = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.shorttv.utils.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.f(FragmentActivity.this, this);
                }
            });
        }
    }
}
