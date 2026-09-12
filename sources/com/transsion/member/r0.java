package com.transsion.member;

import com.transsion.memberapi.MemberCheckResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final /* synthetic */ class r0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MemberProvider f46776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f46777b;

    public /* synthetic */ r0(MemberProvider memberProvider, Function0 function0) {
        this.f46776a = memberProvider;
        this.f46777b = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Unit d11;
        d11 = MemberProvider$checkShowAdState$1.d(this.f46776a, this.f46777b, (MemberCheckResult) obj);
        return d11;
    }
}
