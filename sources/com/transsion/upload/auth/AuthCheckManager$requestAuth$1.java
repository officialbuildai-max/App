package com.transsion.upload.auth;

import com.transsion.upload.bean.TstTokenEntity;
import cw.b;
import cw.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.transsion.upload.auth.AuthCheckManager$requestAuth$1", f = "AuthCheckManager.kt", l = {105}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class AuthCheckManager$requestAuth$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callBack;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthCheckManager$requestAuth$1(a aVar, Continuation<? super AuthCheckManager$requestAuth$1> continuation) {
        super(2, continuation);
        this.$callBack = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthCheckManager$requestAuth$1(this.$callBack, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AuthCheckManager$requestAuth$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Unit unit;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Throwable th2) {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            final a aVar = this.$callBack;
            Result.Companion companion2 = Result.INSTANCE;
            b c11 = c.f61054a.c();
            if (c11 == null) {
                unit = null;
                Result.m1185constructorimpl(unit);
                return Unit.f67184a;
            }
            Function1<TstTokenEntity, Unit> function1 = new Function1<TstTokenEntity, Unit>() { // from class: com.transsion.upload.auth.AuthCheckManager$requestAuth$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((TstTokenEntity) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(TstTokenEntity tstTokenEntity) {
                    String g11;
                    TstTokenEntity tstTokenEntity2;
                    if (tstTokenEntity != null) {
                        a aVar2 = a.this;
                        ew.a aVar3 = ew.a.f62155a;
                        AuthCheckManager authCheckManager = AuthCheckManager.f56755a;
                        g11 = authCheckManager.g();
                        tstTokenEntity2 = AuthCheckManager.f56756b;
                        aVar3.b(g11 + " --> requestAuth() --> tstToken = " + tstTokenEntity2);
                        if (aVar2 != null) {
                            aVar2.a(tstTokenEntity);
                        }
                        authCheckManager.i();
                    }
                }
            };
            Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.transsion.upload.auth.AuthCheckManager$requestAuth$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((String) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(String str) {
                    String g11;
                    ew.a aVar2 = ew.a.f62155a;
                    AuthCheckManager authCheckManager = AuthCheckManager.f56755a;
                    g11 = authCheckManager.g();
                    aVar2.c(g11 + " --> requestAuth() --> it = " + str);
                    AuthCheckManager.f56756b = null;
                    a aVar3 = a.this;
                    if (aVar3 != null) {
                        aVar3.onFail(str);
                    }
                    authCheckManager.i();
                }
            };
            this.label = 1;
            if (c11.f(function1, function12, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        unit = Unit.f67184a;
        Result.m1185constructorimpl(unit);
        return Unit.f67184a;
    }
}
