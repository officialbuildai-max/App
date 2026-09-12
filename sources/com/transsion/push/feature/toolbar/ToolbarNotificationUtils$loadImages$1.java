package com.transsion.push.feature.toolbar;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.push.feature.toolbar.ToolbarNotificationUtils$loadImages$1", f = "ToolbarNotificationUtils.kt", l = {297, 298}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ToolbarNotificationUtils$loadImages$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Bitmap, Bitmap, Unit> $callback;
    final /* synthetic */ Pair<ToolbarNoticeItem, ToolbarNoticeItem> $pair;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ToolbarNotificationUtils$loadImages$1(Function2<? super Bitmap, ? super Bitmap, Unit> function2, Pair<ToolbarNoticeItem, ToolbarNoticeItem> pair, Continuation<? super ToolbarNotificationUtils$loadImages$1> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.$pair = pair;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ToolbarNotificationUtils$loadImages$1 toolbarNotificationUtils$loadImages$1 = new ToolbarNotificationUtils$loadImages$1(this.$callback, this.$pair, continuation);
        toolbarNotificationUtils$loadImages$1.L$0 = obj;
        return toolbarNotificationUtils$loadImages$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ToolbarNotificationUtils$loadImages$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        r0 b11;
        r0 b12;
        r0 r0Var;
        Bitmap bitmap;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (TimeoutCancellationException unused) {
            this.$callback.invoke(null, null);
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            n0 n0Var = (n0) this.L$0;
            b11 = k.b(n0Var, y0.b(), null, new ToolbarNotificationUtils$loadImages$1$image1Deferred$1(this.$pair, null), 2, null);
            b12 = k.b(n0Var, y0.b(), null, new ToolbarNotificationUtils$loadImages$1$image2Deferred$1(this.$pair, null), 2, null);
            this.L$0 = b12;
            this.label = 1;
            Object i12 = b11.i(this);
            if (i12 == f11) {
                return f11;
            }
            r0Var = b12;
            obj = i12;
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bitmap = (Bitmap) this.L$0;
                ResultKt.b(obj);
                this.$callback.invoke(bitmap, (Bitmap) obj);
                return Unit.f67184a;
            }
            r0Var = (r0) this.L$0;
            ResultKt.b(obj);
        }
        Bitmap bitmap2 = (Bitmap) obj;
        this.L$0 = bitmap2;
        this.label = 2;
        Object i13 = r0Var.i(this);
        if (i13 == f11) {
            return f11;
        }
        bitmap = bitmap2;
        obj = i13;
        this.$callback.invoke(bitmap, (Bitmap) obj);
        return Unit.f67184a;
    }
}
