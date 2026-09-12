package com.transsnet.downloader.viewmodel;

import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getOutsideLocalFileList$1", f = "HistoricalPlayRecordViewModel.kt", l = {241}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class HistoricalPlayRecordViewModel$getOutsideLocalFileList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$getOutsideLocalFileList$1(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, Continuation<? super HistoricalPlayRecordViewModel$getOutsideLocalFileList$1> continuation) {
        super(2, continuation);
        this.this$0 = historicalPlayRecordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$getOutsideLocalFileList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$getOutsideLocalFileList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object O;
        long j11;
        List list;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            long currentTimeMillis = System.currentTimeMillis();
            a0.f60208a.t("获取本地视频列表 --> 开始 开始 开始 ");
            ArrayList arrayList = new ArrayList();
            HistoricalPlayRecordViewModel historicalPlayRecordViewModel = this.this$0;
            this.L$0 = arrayList;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            O = historicalPlayRecordViewModel.O(arrayList, this);
            if (O == f11) {
                return f11;
            }
            j11 = currentTimeMillis;
            list = arrayList;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j11 = this.J$0;
            list = (List) this.L$0;
            ResultKt.b(obj);
        }
        if (list.size() > 1) {
            CollectionsKt.A(list, new Comparator() { // from class: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$getOutsideLocalFileList$1$invokeSuspend$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(((HistoricalPlayRecordBean) t12).getUpdateTimeStamp(), ((HistoricalPlayRecordBean) t11).getUpdateTimeStamp());
                }
            });
        }
        List A = HistoricalPlayRecordViewModel.A(this.this$0, list, false, 2, null);
        this.this$0.J().n(A);
        a0.f60208a.t("获取本地视频列表 --> 结束 结束 结束 耗时 = " + (System.currentTimeMillis() - j11) + "， orginalSize:" + list.size() + ",size：" + A.size());
        return Unit.f67184a;
    }
}
