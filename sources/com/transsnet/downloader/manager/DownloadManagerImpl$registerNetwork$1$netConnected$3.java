package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$registerNetwork$1$netConnected$3", f = "DownloadManagerImpl.kt", l = {1323}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadManagerImpl$registerNetwork$1$netConnected$3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerImpl$registerNetwork$1$netConnected$3(DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$registerNetwork$1$netConnected$3> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$registerNetwork$1$netConnected$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$registerNetwork$1$netConnected$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadManagerImpl downloadManagerImpl = this.this$0;
            this.label = 1;
            obj = downloadManagerImpl.o0(this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List<DownloadBean> list2 = (List) obj;
        if (list2 != null) {
            DownloadManagerImpl downloadManagerImpl2 = this.this$0;
            for (DownloadBean downloadBean : list2) {
                list = downloadManagerImpl2.f59560c;
                if (!list.contains(downloadBean)) {
                    a.C0856a c0856a = lg.a.f68962a;
                    str = downloadManagerImpl2.f59558a;
                    a.C0856a.f(c0856a, str, "onConnected, db, name = " + downloadBean.getName() + ", epse = " + downloadBean.getEpse() + ",  cur status = " + downloadBean.getStatus(), false, 4, null);
                    downloadManagerImpl2.t(downloadBean, true);
                }
            }
        }
        return Unit.f67184a;
    }
}
