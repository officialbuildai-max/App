package com.transsnet.downloader.manager;

import com.transsnet.downloader.callback.DownloadTaskStat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadStatusIconManager$onChange$1", f = "DownloadStatusIconManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DownloadStatusIconManager$onChange$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadTaskStat $downloadTaskStat;
    int label;
    final /* synthetic */ DownloadStatusIconManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadStatusIconManager$onChange$1(DownloadStatusIconManager downloadStatusIconManager, DownloadTaskStat downloadTaskStat, Continuation<? super DownloadStatusIconManager$onChange$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadStatusIconManager;
        this.$downloadTaskStat = downloadTaskStat;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadStatusIconManager$onChange$1(this.this$0, this.$downloadTaskStat, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadStatusIconManager$onChange$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.f59591e = this.$downloadTaskStat.getLoadingCount();
        this.this$0.f59589c = this.$downloadTaskStat.getErrorCount();
        this.this$0.f59590d = this.$downloadTaskStat.getDoneCount();
        this.this$0.f59592f = this.$downloadTaskStat.getWaitCount();
        z10 = this.this$0.f59593g;
        if (z10) {
            this.this$0.f59590d = 0;
        }
        i11 = this.this$0.f59591e;
        i12 = this.this$0.f59592f;
        int i29 = i11 + i12;
        a.C0856a c0856a = lg.a.f68962a;
        i13 = this.this$0.f59589c;
        i14 = this.this$0.f59590d;
        i15 = this.this$0.f59591e;
        a.C0856a.f(c0856a, "DownloadStatus", "on download change, errorCount = " + i13 + ", doneCount = " + i14 + ", loadingCount = " + i15 + ",  waitCount = " + this.$downloadTaskStat.getWaitCount(), false, 4, null);
        if (nh.m.f70597a.e()) {
            i16 = this.this$0.f59589c;
            if (i16 > 0) {
                DownloadStatusIconManager downloadStatusIconManager = this.this$0;
                i22 = downloadStatusIconManager.f59591e;
                DownloadStatusIconManager.u(downloadStatusIconManager, i22 > 0 ? 3 : 2, 0, 2, null);
            } else if (i29 > 0) {
                DownloadStatusIconManager downloadStatusIconManager2 = this.this$0;
                i21 = downloadStatusIconManager2.f59591e;
                downloadStatusIconManager2.t(i21 > 0 ? 5 : 4, i29);
            } else {
                i17 = this.this$0.f59590d;
                if (i17 > 0) {
                    DownloadStatusIconManager.u(this.this$0, 1, 0, 2, null);
                } else {
                    i18 = this.this$0.f59589c;
                    if (i18 == 0) {
                        i19 = this.this$0.f59590d;
                        if (i19 == 0) {
                            i20 = this.this$0.f59591e;
                            if (i20 == 0) {
                                DownloadStatusIconManager.u(this.this$0, 0, 0, 2, null);
                            }
                        }
                    }
                }
            }
            return Unit.f67184a;
        }
        i23 = this.this$0.f59592f;
        if (i23 > 0) {
            i28 = this.this$0.f59589c;
            if (i28 == 0) {
                this.this$0.t(4, i29);
                a.C0856a.f(c0856a, "DownloadStatus", "no net, show error~", false, 4, null);
                return Unit.f67184a;
            }
        }
        DownloadStatusIconManager downloadStatusIconManager3 = this.this$0;
        i24 = downloadStatusIconManager3.f59589c;
        if (i24 == 0) {
            i26 = this.this$0.f59590d;
            if (i26 == 0) {
                i27 = this.this$0.f59591e;
                if (i27 == 0) {
                    i25 = 0;
                    DownloadStatusIconManager.u(downloadStatusIconManager3, i25, 0, 2, null);
                    a.C0856a.f(c0856a, "DownloadStatus", "no net, show error~", false, 4, null);
                    return Unit.f67184a;
                }
            }
        }
        i25 = 2;
        DownloadStatusIconManager.u(downloadStatusIconManager3, i25, 0, 2, null);
        a.C0856a.f(c0856a, "DownloadStatus", "no net, show error~", false, 4, null);
        return Unit.f67184a;
    }
}
