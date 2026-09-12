package androidx.navigation;

import androidx.navigation.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private boolean f14012b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14013c;

    /* renamed from: e, reason: collision with root package name */
    private String f14015e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14016f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14017g;

    /* renamed from: a, reason: collision with root package name */
    private final l.a f14011a = new l.a();

    /* renamed from: d, reason: collision with root package name */
    private int f14014d = -1;

    private final void j(String str) {
        if (str != null) {
            if (StringsKt.q0(str)) {
                throw new IllegalArgumentException("Cannot pop up to an empty route");
            }
            this.f14015e = str;
            this.f14016f = false;
        }
    }

    public final void a(Function1 animBuilder) {
        Intrinsics.h(animBuilder, "animBuilder");
        a aVar = new a();
        animBuilder.invoke(aVar);
        this.f14011a.b(aVar.a()).c(aVar.b()).e(aVar.c()).f(aVar.d());
    }

    public final l b() {
        l.a aVar = this.f14011a;
        aVar.d(c());
        aVar.j(f());
        if (e() != null) {
            aVar.h(e(), this.f14016f, this.f14017g);
        } else {
            aVar.g(d(), this.f14016f, this.f14017g);
        }
        return aVar.a();
    }

    public final boolean c() {
        return this.f14012b;
    }

    public final int d() {
        return this.f14014d;
    }

    public final String e() {
        return this.f14015e;
    }

    public final boolean f() {
        return this.f14013c;
    }

    public final void g(int i11, Function1 popUpToBuilder) {
        Intrinsics.h(popUpToBuilder, "popUpToBuilder");
        i(i11);
        j(null);
        s sVar = new s();
        popUpToBuilder.invoke(sVar);
        this.f14016f = sVar.a();
        this.f14017g = sVar.b();
    }

    public final void h(boolean z10) {
        this.f14012b = z10;
    }

    public final void i(int i11) {
        this.f14014d = i11;
        this.f14016f = false;
    }
}
