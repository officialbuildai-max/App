package com.transsion.shorttv_pugc.base.widget.toast.core;

import android.app.Application;
import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f54023a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static Application f54024b;

    /* renamed from: c, reason: collision with root package name */
    private static lt.b f54025c;

    /* renamed from: d, reason: collision with root package name */
    private static lt.c f54026d;

    private h() {
    }

    public static /* synthetic */ void b(h hVar, Application application, lt.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cVar = f54026d;
        }
        hVar.a(application, cVar);
    }

    public final void a(Application application, lt.c cVar) {
        f54024b = application;
        if (f54025c == null) {
            e(new g());
        }
        if (cVar == null) {
            cVar = new mt.a();
        }
        f54023a.f(cVar);
    }

    public final void c(int i11, int i12, int i13) {
        d(i11, i12, i13, 0.0f, 0.0f);
    }

    public final void d(int i11, int i12, int i13, float f11, float f12) {
        lt.b bVar = f54025c;
        Intrinsics.e(bVar);
        lt.c cVar = f54026d;
        Intrinsics.e(cVar);
        bVar.b(new mt.b(cVar, i11, i12, i13, f11, f12));
    }

    public final void e(lt.b bVar) {
        f54025c = bVar;
        Intrinsics.e(bVar);
        bVar.registerStrategy(f54024b);
    }

    public final void f(lt.c cVar) {
        f54026d = cVar;
        lt.b bVar = f54025c;
        Intrinsics.e(bVar);
        bVar.b(cVar);
    }

    public final void g(int i11) {
        if (i11 <= 0) {
            return;
        }
        f(new mt.c(i11, f54026d));
    }

    public final void h(int i11) {
        try {
            Application application = f54024b;
            Intrinsics.e(application);
            i(application.getResources().getText(i11));
        } catch (Resources.NotFoundException unused) {
            i(String.valueOf(i11));
        }
    }

    public final void i(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        lt.b bVar = f54025c;
        Intrinsics.e(bVar);
        bVar.a(charSequence);
    }
}
