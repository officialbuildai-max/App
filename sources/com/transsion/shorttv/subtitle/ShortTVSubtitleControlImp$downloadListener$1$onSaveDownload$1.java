package com.transsion.shorttv.subtitle;

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
import ms.k0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1", f = "ShortTVSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
final class ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleDownloadTable $bean;
    int label;
    final /* synthetic */ ShortTVSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1(ShortTVSubtitleControlImp shortTVSubtitleControlImp, SubtitleDownloadTable subtitleDownloadTable, Continuation<? super ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVSubtitleControlImp;
        this.$bean = subtitleDownloadTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1(this.this$0, this.$bean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ws.a aVar;
        Object obj2;
        String str;
        ws.a aVar2;
        k0 k0Var;
        String str2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        aVar = this.this$0.f53119h;
        List list = (List) aVar.d().f();
        if (list == null) {
            list = new ArrayList();
        }
        SubtitleDownloadTable subtitleDownloadTable = this.$bean;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            ts.b bVar = (ts.b) obj2;
            if (Intrinsics.c(bVar.a().getId(), subtitleDownloadTable.getId()) && bVar.a().getResourceStreamType() == subtitleDownloadTable.getResourceStreamType()) {
                break;
            }
        }
        SubtitleDownloadTable subtitleDownloadTable2 = this.$bean;
        ShortTVSubtitleControlImp shortTVSubtitleControlImp = this.this$0;
        if (((ts.b) obj2) == null) {
            ts.b bVar2 = new ts.b(subtitleDownloadTable2);
            list.add(bVar2);
            aVar2 = shortTVSubtitleControlImp.f53119h;
            aVar2.d().q(list);
            k0Var = shortTVSubtitleControlImp.f53114c;
            k0Var.K.setSubtitlePath(subtitleDownloadTable2.getPath(), us.a.b(bVar2));
            a.C0856a c0856a = lg.a.f68962a;
            str2 = shortTVSubtitleControlImp.f53118g;
            a.C0856a.g(c0856a, str2 + " --> onSaveDownload() --> " + list.size() + ",  设置字幕：" + subtitleDownloadTable2.getName() + "," + subtitleDownloadTable2.getLanName(), false, 2, null);
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        str = this.this$0.f53118g;
        a.C0856a.g(c0856a2, str + " --> onSaveDownload() --> 添加到数据库", false, 2, null);
        return Unit.f67184a;
    }
}
