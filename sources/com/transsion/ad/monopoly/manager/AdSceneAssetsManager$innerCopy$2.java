package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import com.transsion.ad.scene.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import oi.b;
import ti.f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdSceneAssetsManager$innerCopy$2", f = "AdSceneAssetsManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AdSceneAssetsManager$innerCopy$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSceneAssetsManager$innerCopy$2(Continuation<? super AdSceneAssetsManager$innerCopy$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdSceneAssetsManager$innerCopy$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AdSceneAssetsManager$innerCopy$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        d dVar;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            Result.Companion companion = Result.INSTANCE;
            dVar = d.f42258a;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (dVar.e()) {
            b.a.c(AdSceneAssetsManager.f42212b, 4, "innerCopy() --> 数据已经存在", null, false, 12, null);
            return Unit.f67184a;
        }
        String b11 = f.f76378a.b("assets_scene.json");
        if (TextUtils.isEmpty(b11)) {
            b.a.c(AdSceneAssetsManager.f42212b, 6, "innerCopy() --> assets数据 -- 保存数据库失败 -- fail fail fail -- readAssets = null", null, false, 12, null);
        } else {
            b.a.c(AdSceneAssetsManager.f42212b, 4, "innerCopy() --> readAssets = " + b11, null, false, 12, null);
            dVar.f(b11);
        }
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            b.a.c(AdSceneAssetsManager.f42212b, 6, "innerCopy() --> 保存本地数据异常 -- error error error --> it = " + m1188exceptionOrNullimpl, null, false, 12, null);
        }
        return Unit.f67184a;
    }
}
