package com.transsnet.downloader.manager;

import bh.b;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.bean.StartRequestBean;
import com.transsnet.downloader.bean.StartlDownloadBean;
import java.util.Collections;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lg.a;
import okhttp3.RequestBody;
import qy.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.FinishDownloadHelper$onDownloadSuccess$1", f = "FinishDownloadHelper.kt", l = {57, 68}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class FinishDownloadHelper$onDownloadSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    int label;
    final /* synthetic */ FinishDownloadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishDownloadHelper$onDownloadSuccess$1(DownloadBean downloadBean, FinishDownloadHelper finishDownloadHelper, Continuation<? super FinishDownloadHelper$onDownloadSuccess$1> continuation) {
        super(2, continuation);
        this.$bean = downloadBean;
        this.this$0 = finishDownloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinishDownloadHelper$onDownloadSuccess$1(this.$bean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((FinishDownloadHelper$onDownloadSuccess$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        qy.a n11;
        String str3;
        String resourceId;
        String str4;
        qy.a n12;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Exception e11) {
            a.C0856a c0856a = lg.a.f68962a;
            str = this.this$0.f59594a;
            a.C0856a.k(c0856a, str, "onDownloadSuccess error", e11, false, 8, null);
            e11.printStackTrace();
        }
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f67184a;
        }
        ResultKt.b(obj);
        if (!this.$bean.isUGCVideo()) {
            List singletonList = Collections.singletonList(new StartlDownloadBean(this.$bean.getSubjectId(), this.$bean.getResourceId(), Boxing.d(this.$bean.getEpse())));
            a.C0856a c0856a2 = lg.a.f68962a;
            str2 = this.this$0.f59594a;
            a.C0856a.f(c0856a2, str2, "onDownloadSuccess, name = " + this.$bean.getName() + ", subjectId = " + this.$bean.getSubjectId() + ", resourceId = " + this.$bean.getResourceId() + ", episode = " + this.$bean.getEpse(), false, 4, null);
            n11 = this.this$0.n();
            b.a aVar = bh.b.f16553a;
            String j11 = com.blankj.utilcode.util.o.j(new StartRequestBean(singletonList));
            Intrinsics.g(j11, "toJson(...)");
            RequestBody a11 = aVar.a(j11);
            this.label = 2;
            obj = a.C0925a.b(n11, null, a11, this, 1, null);
            if (obj == f11) {
                return f11;
            }
            return Unit.f67184a;
        }
        String ugcVideoId = this.$bean.getUgcVideoId();
        if (ugcVideoId != null && ugcVideoId.length() != 0 && (resourceId = this.$bean.getResourceId()) != null && resourceId.length() != 0) {
            List singletonList2 = Collections.singletonList(new UGCStartDownloadBean(this.$bean.getUgcVideoId(), this.$bean.getResourceId(), this.$bean.getSubtitleIdType()));
            a.C0856a c0856a3 = lg.a.f68962a;
            str4 = this.this$0.f59594a;
            a.C0856a.f(c0856a3, str4, "onDownloadSuccess UGC, name = " + this.$bean.getName() + ", ugcVideoId = " + this.$bean.getUgcVideoId() + ", resourceId = " + this.$bean.getResourceId() + ", idType = " + this.$bean.getSubtitleIdType(), false, 4, null);
            n12 = this.this$0.n();
            String a12 = vg.a.f77447a.a();
            b.a aVar2 = bh.b.f16553a;
            String j12 = com.blankj.utilcode.util.o.j(new UGCStartRequestBean(singletonList2));
            Intrinsics.g(j12, "toJson(...)");
            RequestBody a13 = aVar2.a(j12);
            this.label = 1;
            obj = n12.j(a12, a13, this);
            if (obj == f11) {
                return f11;
            }
            return Unit.f67184a;
        }
        a.C0856a c0856a4 = lg.a.f68962a;
        str3 = this.this$0.f59594a;
        a.C0856a.f(c0856a4, str3, "onDownloadSuccess UGC fail, has no ugcVideoId or resourceId, name = " + this.$bean.getName(), false, 4, null);
        return Unit.f67184a;
    }
}
