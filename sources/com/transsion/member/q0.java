package com.transsion.member;

import com.transsion.memberapi.TaskRewards;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final /* synthetic */ class q0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MemberProvider f46773a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f46774b;

    public /* synthetic */ q0(MemberProvider memberProvider, Function0 function0) {
        this.f46773a = memberProvider;
        this.f46774b = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Unit U;
        U = MemberProvider.U(this.f46773a, this.f46774b, (TaskRewards) obj);
        return U;
    }
}
