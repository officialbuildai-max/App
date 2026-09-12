package com.transsion.member;

import android.app.Application;
import androidx.view.LiveData;
import com.transsion.member.bean.request.MemberPromoCodeReq;
import com.transsion.member.bean.request.MemberPromoCodeRes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vm.a;

/* loaded from: classes5.dex */
public final class n0 extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f46646b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f46647c;

    /* loaded from: classes5.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            n0.this.f46647c.q(new y0(false, str, str2, null));
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberPromoCodeRes memberPromoCodeRes) {
            super.c(memberPromoCodeRes);
            n0.this.f46647c.q(new y0(true, null, null, memberPromoCodeRes));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f46646b = LazyKt.b(new Function0() { // from class: com.transsion.member.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                vm.a g11;
                g11 = n0.g();
                return g11;
            }
        });
        this.f46647c = new androidx.view.b0();
    }

    private final vm.a f() {
        return (vm.a) this.f46646b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vm.a g() {
        return (vm.a) zg.c.f79537e.a().h(vm.a.class);
    }

    public final LiveData e() {
        return this.f46647c;
    }

    public final void h(String code) {
        Intrinsics.h(code, "code");
        a.C0979a.l(f(), null, new MemberPromoCodeReq(code), 1, null).f(sg.d.f75472a.c()).subscribe(new a());
    }
}
