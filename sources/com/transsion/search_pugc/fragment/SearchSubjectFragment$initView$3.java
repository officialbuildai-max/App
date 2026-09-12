package com.transsion.search_pugc.fragment;

import com.transsion.search_pugc.k;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search_pugc.fragment.SearchSubjectFragment$initView$3", f = "SearchSubjectFragment.kt", l = {Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class SearchSubjectFragment$initView$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f52390a = new a();

        a() {
        }

        public final Object a(k.a aVar, Continuation continuation) {
            throw new NoWhenBranchMatchedException();
        }

        @Override // kotlinx.coroutines.flow.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            android.support.v4.media.session.c.a(obj);
            return a(null, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchSubjectFragment$initView$3(Continuation<? super SearchSubjectFragment$initView$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchSubjectFragment$initView$3(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SearchSubjectFragment$initView$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            x0 a11 = com.transsion.search_pugc.k.f52547a.a();
            a aVar = a.f52390a;
            this.label = 1;
            if (a11.a(aVar, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
