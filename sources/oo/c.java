package oo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final View f71191a;

    /* renamed from: b, reason: collision with root package name */
    private final View f71192b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f71193c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f71194d;

    public c(View startView, View endView) {
        Intrinsics.h(startView, "startView");
        Intrinsics.h(endView, "endView");
        this.f71191a = startView;
        this.f71192b = endView;
        this.f71194d = LazyKt.b(new Function0() { // from class: oo.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                g g11;
                g11 = c.g(c.this);
                return g11;
            }
        });
    }

    private final g e() {
        return (g) this.f71194d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g g(final c cVar) {
        Context context = cVar.f71191a.getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        return new g((Activity) context, new Function1() { // from class: oo.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h11;
                h11 = c.h(c.this, ((Integer) obj).intValue());
                return h11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(c cVar, int i11) {
        if (i11 == 0 || i11 == 1 || i11 == 3) {
            cVar.i(cVar.f71193c, i11);
        }
        return Unit.f67184a;
    }

    private final void i(boolean z10, int i11) {
        int c11 = com.blankj.utilcode.util.d.c();
        int i12 = (z10 && i11 == 1) ? c11 : 0;
        if (!z10 || i11 != 3) {
            c11 = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.f71191a.getLayoutParams();
        layoutParams.width = i12;
        this.f71191a.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f71192b.getLayoutParams();
        layoutParams2.width = c11;
        this.f71192b.setLayoutParams(layoutParams2);
    }

    public final void c() {
        g e11 = e();
        if (e11 != null) {
            e11.disable();
        }
    }

    public final void d() {
        g e11 = e();
        if (e11 != null) {
            e11.enable();
        }
    }

    public final void f(boolean z10) {
        this.f71193c = z10;
        i(z10, z10 ? 1 : 0);
    }
}
