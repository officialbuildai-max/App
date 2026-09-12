package com.cloud.tmc.miniapp.ui;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;

@DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$hideCustomView$1", f = "MiniFragment.kt", l = {822, 823}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MiniFragment$hideCustomView$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ MiniFragment this$0;

    @DebugMetadata(c = "com.cloud.tmc.miniapp.ui.MiniFragment$hideCustomView$1$1", f = "MiniFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.cloud.tmc.miniapp.ui.MiniFragment$hideCustomView$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ MiniFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MiniFragment miniFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = miniFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            View view;
            View view2;
            int i11;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            view = this.this$0.contextView;
            if (view == null) {
                Intrinsics.z("contextView");
            }
            view2 = this.this$0.contextView;
            if (view2 == null) {
                Intrinsics.z("contextView");
                view2 = null;
            }
            i11 = this.this$0.mScrollY;
            view2.scrollTo(0, i11);
            return Unit.f67184a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniFragment$hideCustomView$1(MiniFragment miniFragment, Continuation<? super MiniFragment$hideCustomView$1> continuation) {
        super(2, continuation);
        this.this$0 = miniFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniFragment$hideCustomView$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MiniFragment$hideCustomView$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (kotlinx.coroutines.u0.a(500L, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        a2 c11 = kotlinx.coroutines.y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (kotlinx.coroutines.i.g(c11, anonymousClass1, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
