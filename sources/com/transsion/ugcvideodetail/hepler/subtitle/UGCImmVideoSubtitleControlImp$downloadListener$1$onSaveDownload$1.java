package com.transsion.ugcvideodetail.hepler.subtitle;

import androidx.view.b0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.subtitle.helper.e;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1", f = "UGCImmVideoSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
final class UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleDownloadTable $bean;
    int label;
    final /* synthetic */ UGCImmVideoSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1(UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp, SubtitleDownloadTable subtitleDownloadTable, Continuation<? super UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoSubtitleControlImp;
        this.$bean = subtitleDownloadTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1(this.this$0, this.$bean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        List arrayList;
        Object obj2;
        String str;
        a aVar2;
        SimpleSubtitleView simpleSubtitleView;
        String str2;
        b0 d11;
        b0 d12;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        aVar = this.this$0.f56498e;
        if (aVar == null || (d12 = aVar.d()) == null || (arrayList = (List) d12.f()) == null) {
            arrayList = new ArrayList();
        }
        SubtitleDownloadTable subtitleDownloadTable = this.$bean;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            eu.a aVar3 = (eu.a) obj2;
            if (Intrinsics.c(aVar3.b().getId(), subtitleDownloadTable.getId()) && aVar3.b().getResourceStreamType() == subtitleDownloadTable.getResourceStreamType()) {
                break;
            }
        }
        SubtitleDownloadTable subtitleDownloadTable2 = this.$bean;
        UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp = this.this$0;
        if (((eu.a) obj2) == null) {
            eu.a aVar4 = new eu.a(subtitleDownloadTable2);
            arrayList.add(aVar4);
            aVar2 = uGCImmVideoSubtitleControlImp.f56498e;
            if (aVar2 != null && (d11 = aVar2.d()) != null) {
                d11.q(arrayList);
            }
            simpleSubtitleView = uGCImmVideoSubtitleControlImp.f56497d;
            simpleSubtitleView.setSubtitlePath(subtitleDownloadTable2.getPath(), e.b(aVar4));
            a.C0856a c0856a = lg.a.f68962a;
            str2 = uGCImmVideoSubtitleControlImp.f56501h;
            a.C0856a.f(c0856a, str2, " onSaveDownload() --> " + arrayList.size() + ",  设置字幕：" + subtitleDownloadTable2.getName() + "," + subtitleDownloadTable2.getLanName(), false, 4, null);
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        str = this.this$0.f56501h;
        a.C0856a.f(c0856a2, str, " onSaveDownload() --> 添加到数据库", false, 4, null);
        return Unit.f67184a;
    }
}
