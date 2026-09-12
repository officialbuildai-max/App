package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.FilmListRequest;
import com.transsion.home.bean.FilmListResponse;
import com.transsion.home.bean.UgcGenreTopRespGenreItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCFilmListViewModel$getFilmList$1", f = "UGCFilmListViewModel.kt", l = {127}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class UGCFilmListViewModel$getFilmList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentPage;
    int label;
    final /* synthetic */ UGCFilmListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilmListViewModel$getFilmList$1(UGCFilmListViewModel uGCFilmListViewModel, int i11, Continuation<? super UGCFilmListViewModel$getFilmList$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCFilmListViewModel;
        this.$currentPage = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCFilmListViewModel$getFilmList$1(this.this$0, this.$currentPage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCFilmListViewModel$getFilmList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        ol.b bVar;
        List<UgcGenreTopRespGenreItem> l11;
        Pager pager;
        Pager pager2;
        boolean z10;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                str = this.this$0.f45912c;
                FilmListRequest filmListRequest = new FilmListRequest(str, this.$currentPage, 20);
                String j11 = com.blankj.utilcode.util.o.j(filmListRequest);
                a.C0856a.f(lg.a.f68962a, "FilmListViewModel", "getFilmList: request params=" + j11, false, 4, null);
                bVar = this.this$0.f45911b;
                String a11 = vg.a.f77447a.a();
                String type = filmListRequest.getType();
                int page = filmListRequest.getPage();
                int perPage = filmListRequest.getPerPage();
                this.label = 1;
                obj = bVar.b(a11, type, page, perPage, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "FilmListViewModel", "getFilmList: response code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), false, 4, null);
            if (!Intrinsics.c(baseDto.getCode(), "0") || baseDto.getData() == null) {
                this.this$0.k().n(null);
                a.C0856a.l(c0856a, "FilmListViewModel", "getFilmList failed: code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), false, 4, null);
            } else {
                FilmListResponse filmListResponse = (FilmListResponse) baseDto.getData();
                this.this$0.f45914e = filmListResponse != null ? filmListResponse.getPager() : null;
                if (filmListResponse == null || (l11 = filmListResponse.getItems()) == null) {
                    l11 = CollectionsKt.l();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : l11) {
                    UGCContent ugcContent = ((UgcGenreTopRespGenreItem) obj2).getUgcContent();
                    if (Intrinsics.c(ugcContent != null ? ugcContent.getTopicType() : null, "UGC_VIDEO") && ugcContent.getVideo() != null) {
                        arrayList.add(obj2);
                    }
                }
                a.C0856a c0856a2 = lg.a.f68962a;
                int size = arrayList.size();
                pager = this.this$0.f45914e;
                Boolean hasMore = pager != null ? pager.getHasMore() : null;
                pager2 = this.this$0.f45914e;
                a.C0856a.f(c0856a2, "FilmListViewModel", "getFilmList success, size=" + size + ", hasMore=" + hasMore + ", nextPage=" + (pager2 != null ? pager2.getNextPage() : null), false, 4, null);
                this.this$0.k().n(arrayList);
                String desc = filmListResponse != null ? filmListResponse.getDesc() : null;
                z10 = this.this$0.f45918i;
                if (!z10 && this.$currentPage == 1 && desc != null && desc.length() != 0) {
                    a.C0856a.f(c0856a2, "FilmListViewModel", "getFilmList: emit title desc='" + desc + "' for first load", false, 4, null);
                    this.this$0.j().n(desc);
                    this.this$0.f45918i = true;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            lg.a.f68962a.i("FilmListViewModel", "getFilmList exception: " + e11.getMessage(), true);
            this.this$0.k().n(null);
        }
        return Unit.f67184a;
    }
}
