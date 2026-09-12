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
@DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1", f = "UGCImmVideoSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
final class UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleDownloadTable $stDownloadTable;
    int label;
    final /* synthetic */ UGCImmVideoSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1(UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp, SubtitleDownloadTable subtitleDownloadTable, Continuation<? super UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoSubtitleControlImp;
        this.$stDownloadTable = subtitleDownloadTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1(this.this$0, this.$stDownloadTable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        a aVar;
        List arrayList;
        Object obj2;
        Object obj3;
        a aVar2;
        SimpleSubtitleView simpleSubtitleView;
        b0 d11;
        Object obj4;
        String str;
        SimpleSubtitleView simpleSubtitleView2;
        b0 d12;
        String str2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!Intrinsics.c(this.this$0.u(), this.$stDownloadTable.getResourceId())) {
            a.C0856a c0856a = lg.a.f68962a;
            str2 = this.this$0.f56501h;
            a.C0856a.f(c0856a, str2, " onComplete() --> 字幕下载成功，不是当前视频，不做处理", false, 4, null);
            return Unit.f67184a;
        }
        aVar = this.this$0.f56498e;
        if (aVar == null || (d12 = aVar.d()) == null || (arrayList = (List) d12.f()) == null) {
            arrayList = new ArrayList();
        }
        List list = arrayList;
        SubtitleDownloadTable subtitleDownloadTable = this.$stDownloadTable;
        Iterator it = list.iterator();
        while (true) {
            obj2 = null;
            if (!it.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it.next();
            eu.a aVar3 = (eu.a) obj3;
            if (Intrinsics.c(aVar3.b().getId(), subtitleDownloadTable.getId()) && aVar3.b().getResourceStreamType() == subtitleDownloadTable.getResourceStreamType()) {
                break;
            }
        }
        SubtitleDownloadTable subtitleDownloadTable2 = this.$stDownloadTable;
        UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp = this.this$0;
        eu.a aVar4 = (eu.a) obj3;
        if (aVar4 != null) {
            aVar4.h(subtitleDownloadTable2);
        } else {
            eu.a aVar5 = new eu.a(subtitleDownloadTable2);
            arrayList.add(aVar5);
            aVar2 = uGCImmVideoSubtitleControlImp.f56498e;
            if (aVar2 != null && (d11 = aVar2.d()) != null) {
                d11.q(arrayList);
            }
            simpleSubtitleView = uGCImmVideoSubtitleControlImp.f56497d;
            simpleSubtitleView.setSubtitlePath(subtitleDownloadTable2.getPath(), e.b(aVar5));
        }
        SubtitleDownloadTable subtitleDownloadTable3 = this.$stDownloadTable;
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it2.next();
            if (Intrinsics.c(((eu.a) obj4).b().getId(), subtitleDownloadTable3.getId())) {
                break;
            }
        }
        eu.a aVar6 = (eu.a) obj4;
        if (aVar6 == null) {
            aVar6 = new eu.a(this.$stDownloadTable);
        }
        if (this.$stDownloadTable.getIsAutoDownload()) {
            String string = com.transsion.subtitle_download.utils.d.f55168a.b().getString("k_subtitle_select_lan", null);
            Iterator it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (Intrinsics.c(((eu.a) next).b().getLan(), string)) {
                    obj2 = next;
                    break;
                }
            }
            if (((eu.a) obj2) == null || string == null || string.length() == 0 || Intrinsics.c(string, this.$stDownloadTable.getLan())) {
                aVar6.l(true);
            }
        } else {
            aVar6.l(true);
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        str = this.this$0.f56501h;
        a.C0856a.r(c0856a2, str, new String[]{" onComplete() --> 字幕下载成功：" + this.$stDownloadTable.getName() + "," + this.$stDownloadTable.getLanName() + ", isSelect:" + aVar6.f()}, false, 4, null);
        simpleSubtitleView2 = this.this$0.f56497d;
        simpleSubtitleView2.setSubtitlePath(this.$stDownloadTable.getPath(), e.b(aVar6));
        if (aVar6.f()) {
            this.this$0.f(aVar6);
        }
        return Unit.f67184a;
    }
}
