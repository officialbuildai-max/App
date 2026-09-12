package com.transsnet.downloader.fragment;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1", f = "LocalFileSingleTabFragment.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class LocalFileSingleTabFragment$initViewModel$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocalFileSingleTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalFileSingleTabFragment$initViewModel$1(LocalFileSingleTabFragment localFileSingleTabFragment, Continuation<? super LocalFileSingleTabFragment$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = localFileSingleTabFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalFileSingleTabFragment$initViewModel$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LocalFileSingleTabFragment$initViewModel$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.y0 P = this.this$0.G0().P();
            final LocalFileSingleTabFragment localFileSingleTabFragment = this.this$0;
            kotlinx.coroutines.flow.c cVar = new kotlinx.coroutines.flow.c() { // from class: com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1.1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
                @DebugMetadata(c = "com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1$1$1", f = "LocalFileSingleTabFragment.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes7.dex */
                public static final class C07151 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ int $it;
                    int label;
                    final /* synthetic */ LocalFileSingleTabFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C07151(int i11, LocalFileSingleTabFragment localFileSingleTabFragment, Continuation<? super C07151> continuation) {
                        super(2, continuation);
                        this.$it = i11;
                        this.this$0 = localFileSingleTabFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C07151(this.$it, this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
                        return ((C07151) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        int i11 = this.$it;
                        if (i11 >= 0) {
                            com.transsnet.downloader.adapter.a mAllHistoricalPlayRecordAdapter = this.this$0.getMAllHistoricalPlayRecordAdapter();
                            if (mAllHistoricalPlayRecordAdapter != null) {
                                mAllHistoricalPlayRecordAdapter.notifyItemChanged(this.$it);
                            }
                            com.transsnet.downloader.viewmodel.a0.f60208a.t("刷新UI index = " + this.$it);
                        } else {
                            com.transsnet.downloader.viewmodel.a0.f60208a.t(" 异常  index = " + i11);
                        }
                        return Unit.f67184a;
                    }
                }

                public final Object a(int i12, Continuation continuation) {
                    Object g11 = kotlinx.coroutines.i.g(kotlinx.coroutines.y0.c(), new C07151(i12, LocalFileSingleTabFragment.this, null), continuation);
                    return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
                }

                @Override // kotlinx.coroutines.flow.c
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return a(((Number) obj2).intValue(), continuation);
                }
            };
            this.label = 1;
            if (P.a(cVar, this) == f11) {
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
