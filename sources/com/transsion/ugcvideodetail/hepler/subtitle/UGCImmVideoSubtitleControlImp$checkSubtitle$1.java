package com.transsion.ugcvideodetail.hepler.subtitle;

import androidx.view.b0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayBean;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream;
import com.transsion.ugcvideodetail.hepler.subtitle.manager.b;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import lg.a;
import nh.m;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$checkSubtitle$1", f = "UGCImmVideoSubtitleControlImp.kt", l = {170, 171, 172, 177, 182}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class UGCImmVideoSubtitleControlImp$checkSubtitle$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UGCImmVideoSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$checkSubtitle$1$1", f = "UGCImmVideoSubtitleControlImp.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$checkSubtitle$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ UGCVideoDetailPlayBean $history;
        final /* synthetic */ List<eu.a> $list;
        int label;
        final /* synthetic */ UGCImmVideoSubtitleControlImp this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<eu.a> list, UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp, UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = uGCImmVideoSubtitleControlImp;
            this.$history = uGCVideoDetailPlayBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, this.$history, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            UGCVideoPlayStream uGCVideoPlayStream;
            String str;
            UGCVideoPlayStream uGCVideoPlayStream2;
            UGCImmVideo uGCImmVideo;
            UGCVideoPlayStream uGCVideoPlayStream3;
            UGCImmVideo uGCImmVideo2;
            String str2;
            UGCVideoPlayStream uGCVideoPlayStream4;
            UGCImmVideo uGCImmVideo3;
            UGCImmVideo uGCImmVideo4;
            UGCImmVideo uGCImmVideo5;
            UGCImmVideo uGCImmVideo6;
            UGCImmVideo uGCImmVideo7;
            UGCImmVideo uGCImmVideo8;
            UGCImmVideo uGCImmVideo9;
            UGCVideo ugcVideo;
            UGCVideo ugcVideo2;
            UGCVideo ugcVideo3;
            UGCVideoBelongToCollection belongToCollection;
            UGCVideo ugcVideo4;
            UGCVideo ugcVideo5;
            UGCVideoBelongToCollection belongToCollection2;
            UGCVideo ugcVideo6;
            UGCVideo ugcVideo7;
            UGCVideo ugcVideo8;
            UGCVideoBelongToCollection belongToCollection3;
            String size;
            UGCVideo ugcVideo9;
            UGCVideoBelongToCollection belongToCollection4;
            a aVar;
            List arrayList;
            a aVar2;
            b0 d11;
            b0 d12;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            List<eu.a> list = this.$list;
            if (list != null && !list.isEmpty()) {
                aVar = this.this$0.f56498e;
                if (aVar == null || (d12 = aVar.d()) == null || (arrayList = (List) d12.f()) == null) {
                    arrayList = new ArrayList();
                }
                arrayList.clear();
                arrayList.addAll(this.$list);
                a.C0856a.g(lg.a.f68962a, "checkSubtitle setList, size:" + arrayList.size(), false, 2, null);
                aVar2 = this.this$0.f56498e;
                if (aVar2 != null && (d11 = aVar2.d()) != null) {
                    d11.q(arrayList);
                }
                UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp = this.this$0;
                UGCVideoDetailPlayBean uGCVideoDetailPlayBean = this.$history;
                uGCImmVideoSubtitleControlImp.v(arrayList, uGCVideoDetailPlayBean != null ? uGCVideoDetailPlayBean.getSubtitleSelectId() : null);
            }
            if (m.f70597a.e()) {
                uGCVideoPlayStream = this.this$0.f56500g;
                if (uGCVideoPlayStream == null || (str = uGCVideoPlayStream.getUrl()) == null) {
                    str = "";
                }
                String str3 = str;
                uGCVideoPlayStream2 = this.this$0.f56500g;
                String id2 = uGCVideoPlayStream2 != null ? uGCVideoPlayStream2.getId() : null;
                uGCImmVideo = this.this$0.f56499f;
                String collectionName = (uGCImmVideo == null || (ugcVideo9 = uGCImmVideo.getUgcVideo()) == null || (belongToCollection4 = ugcVideo9.getBelongToCollection()) == null) ? null : belongToCollection4.getCollectionName();
                uGCVideoPlayStream3 = this.this$0.f56500g;
                Long x10 = (uGCVideoPlayStream3 == null || (size = uGCVideoPlayStream3.getSize()) == null) ? null : StringsKt.x(size);
                uGCImmVideo2 = this.this$0.f56499f;
                String collectionName2 = (uGCImmVideo2 == null || (ugcVideo8 = uGCImmVideo2.getUgcVideo()) == null || (belongToCollection3 = ugcVideo8.getBelongToCollection()) == null) ? null : belongToCollection3.getCollectionName();
                str2 = this.this$0.f56495b;
                uGCVideoPlayStream4 = this.this$0.f56500g;
                String idType = uGCVideoPlayStream4 != null ? uGCVideoPlayStream4.getIdType() : null;
                uGCImmVideo3 = this.this$0.f56499f;
                String ugcVideoId = (uGCImmVideo3 == null || (ugcVideo7 = uGCImmVideo3.getUgcVideo()) == null) ? null : ugcVideo7.getUgcVideoId();
                uGCImmVideo4 = this.this$0.f56499f;
                Integer d13 = (uGCImmVideo4 == null || (ugcVideo6 = uGCImmVideo4.getUgcVideo()) == null) ? null : Boxing.d(ugcVideo6.videoUGCPosition());
                uGCImmVideo5 = this.this$0.f56499f;
                String collectionId = (uGCImmVideo5 == null || (ugcVideo5 = uGCImmVideo5.getUgcVideo()) == null || (belongToCollection2 = ugcVideo5.getBelongToCollection()) == null) ? null : belongToCollection2.getCollectionId();
                uGCImmVideo6 = this.this$0.f56499f;
                String title = (uGCImmVideo6 == null || (ugcVideo4 = uGCImmVideo6.getUgcVideo()) == null) ? null : ugcVideo4.getTitle();
                uGCImmVideo7 = this.this$0.f56499f;
                String collectionName3 = (uGCImmVideo7 == null || (ugcVideo3 = uGCImmVideo7.getUgcVideo()) == null || (belongToCollection = ugcVideo3.getBelongToCollection()) == null) ? null : belongToCollection.getCollectionName();
                uGCImmVideo8 = this.this$0.f56499f;
                String category = (uGCImmVideo8 == null || (ugcVideo2 = uGCImmVideo8.getUgcVideo()) == null) ? null : ugcVideo2.getCategory();
                uGCImmVideo9 = this.this$0.f56499f;
                b.C0708b.a(com.transsion.ugcvideodetail.hepler.subtitle.manager.b.f56525a.b(), new DownloadBean(str3, id2, collectionName, "", x10, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", str2, null, collectionName2, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, (uGCImmVideo9 == null || (ugcVideo = uGCImmVideo9.getUgcVideo()) == null) ? null : ugcVideo.getOps(), null, null, null, null, null, null, null, null, idType, collectionId, ugcVideoId, title, collectionName3, d13, category, null, null, null, null, null, null, null, null, false, null, null, -1477181472, 1071644671, 65504, null), null, 2, null);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoSubtitleControlImp$checkSubtitle$1(UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp, Continuation<? super UGCImmVideoSubtitleControlImp$checkSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoSubtitleControlImp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoSubtitleControlImp$checkSubtitle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoSubtitleControlImp$checkSubtitle$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0130 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$checkSubtitle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
