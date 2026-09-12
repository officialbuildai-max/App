package com.google.accompanist.systemuicontroller;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class SystemUiControllerKt {

    /* renamed from: a, reason: collision with root package name */
    private static final long f24228a = w1.e(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null);

    /* renamed from: b, reason: collision with root package name */
    private static final Function1 f24229b = new Function1<u1, u1>() { // from class: com.google.accompanist.systemuicontroller.SystemUiControllerKt$BlackScrimmed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return u1.g(m727invokel2rxGTc(((u1) obj).u()));
        }

        /* renamed from: invoke-l2rxGTc, reason: not valid java name */
        public final long m727invokel2rxGTc(long j11) {
            long j12;
            j12 = SystemUiControllerKt.f24228a;
            return w1.h(j12, j11);
        }
    };

    private static final Window c(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.g(context, "getBaseContext(...)");
        }
        return ((Activity) context).getWindow();
    }

    private static final Window d(i iVar, int i11) {
        iVar.x(1009281237);
        if (k.H()) {
            k.Q(1009281237, i11, -1, "com.google.accompanist.systemuicontroller.findWindow (SystemUiController.kt:208)");
        }
        ViewParent parent = ((View) iVar.l(AndroidCompositionLocals_androidKt.j())).getParent();
        d dVar = parent instanceof d ? (d) parent : null;
        Window window = dVar != null ? dVar.getWindow() : null;
        if (window == null) {
            Context context = ((View) iVar.l(AndroidCompositionLocals_androidKt.j())).getContext();
            Intrinsics.g(context, "getContext(...)");
            window = c(context);
        }
        if (k.H()) {
            k.P();
        }
        iVar.N();
        return window;
    }

    public static final c e(Window window, i iVar, int i11, int i12) {
        iVar.x(-715745933);
        if ((i12 & 1) != 0) {
            window = d(iVar, 0);
        }
        if (k.H()) {
            k.Q(-715745933, i11, -1, "com.google.accompanist.systemuicontroller.rememberSystemUiController (SystemUiController.kt:201)");
        }
        View view = (View) iVar.l(AndroidCompositionLocals_androidKt.j());
        iVar.x(-1044852491);
        boolean O = iVar.O(view) | iVar.O(window);
        Object y10 = iVar.y();
        if (O || y10 == i.f3811a.a()) {
            y10 = new a(view, window);
            iVar.p(y10);
        }
        a aVar = (a) y10;
        iVar.N();
        if (k.H()) {
            k.P();
        }
        iVar.N();
        return aVar;
    }
}
