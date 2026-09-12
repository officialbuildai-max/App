package com.transsion.member;

import android.app.Application;
import androidx.view.LiveData;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vm.a;

/* loaded from: classes5.dex */
public final class f extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f46608b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f46609c;

    /* loaded from: classes5.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            f.this.f46609c.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
            super.c(memberTaskSubmitCheckInRes);
            f.this.f46609c.q(memberTaskSubmitCheckInRes);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f46608b = LazyKt.b(new Function0() { // from class: com.transsion.member.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                vm.a h11;
                h11 = f.h();
                return h11;
            }
        });
        this.f46609c = new androidx.view.b0();
    }

    private final vm.a g() {
        return (vm.a) this.f46608b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vm.a h() {
        return (vm.a) zg.c.f79537e.a().h(vm.a.class);
    }

    public final void e() {
        a.C0979a.m(g(), null, null, 3, null).f(sg.d.f75472a.c()).subscribe(new a());
    }

    public final LiveData f() {
        return this.f46609c;
    }
}
