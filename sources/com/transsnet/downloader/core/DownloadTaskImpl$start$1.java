package com.transsnet.downloader.core;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.core.DownloadTaskImpl$start$1", f = "DownloadTaskImpl.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadTaskImpl$start$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DownloadTaskImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTaskImpl$start$1(DownloadTaskImpl downloadTaskImpl, Continuation<? super DownloadTaskImpl$start$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadTaskImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadTaskImpl$start$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadTaskImpl$start$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadBean downloadBean;
        lj.n0 n0Var;
        DownloadTaskImpl downloadTaskImpl;
        DownloadBean downloadBean2;
        DownloadBean downloadBean3;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            downloadBean = this.this$0.f58702c;
            String resourceId = downloadBean.getResourceId();
            if (resourceId != null) {
                DownloadTaskImpl downloadTaskImpl2 = this.this$0;
                n0Var = downloadTaskImpl2.f58707h;
                this.L$0 = downloadTaskImpl2;
                this.label = 1;
                obj = n0Var.c(resourceId, this);
                if (obj == f11) {
                    return f11;
                }
                downloadTaskImpl = downloadTaskImpl2;
            }
            this.this$0.E();
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        downloadTaskImpl = (DownloadTaskImpl) this.L$0;
        ResultKt.b(obj);
        List list = (List) obj;
        a.C0856a.f(lg.a.f68962a, "Download_VideoCache", "ranges size = " + (list != null ? Boxing.d(list.size()) : null), false, 4, null);
        if (list != null) {
            downloadBean2 = downloadTaskImpl.f58702c;
            downloadBean2.getDownloadRanges().clear();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            downloadTaskImpl.t(arrayList);
            downloadBean3 = downloadTaskImpl.f58702c;
            Boxing.a(downloadBean3.getDownloadRanges().addAll(arrayList));
        }
        this.this$0.E();
        return Unit.f67184a;
    }
}
