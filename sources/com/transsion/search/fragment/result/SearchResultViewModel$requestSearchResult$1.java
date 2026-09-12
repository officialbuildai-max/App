package com.transsion.search.fragment.result;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.dns.or.CacheIpPool;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.net.RequestSearchResultEntity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search.fragment.result.SearchResultViewModel$requestSearchResult$1", f = "SearchResultViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VISIBILITY_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class SearchResultViewModel$requestSearchResult$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $tabId;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ SearchResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultViewModel$requestSearchResult$1(SearchResultViewModel searchResultViewModel, String str, String str2, boolean z10, Continuation<? super SearchResultViewModel$requestSearchResult$1> continuation) {
        super(2, continuation);
        this.this$0 = searchResultViewModel;
        this.$keyword = str;
        this.$tabId = str2;
        this.$isLoadMore = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchResultViewModel$requestSearchResult$1 searchResultViewModel$requestSearchResult$1 = new SearchResultViewModel$requestSearchResult$1(this.this$0, this.$keyword, this.$tabId, this.$isLoadMore, continuation);
        searchResultViewModel$requestSearchResult$1.L$0 = obj;
        return searchResultViewModel$requestSearchResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SearchResultViewModel$requestSearchResult$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        int i11;
        SearchResultViewModel searchResultViewModel;
        yq.g l11;
        boolean z10;
        int i12;
        List<ResultWrapData> h11;
        Object f11 = IntrinsicsKt.f();
        int i13 = this.label;
        try {
            if (i13 == 0) {
                ResultKt.b(obj);
                i11 = this.this$0.f52171f;
                RequestSearchResultEntity requestSearchResultEntity = new RequestSearchResultEntity(i11, 10, this.$keyword);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("page", Boxing.d(requestSearchResultEntity.getPage()));
                jsonObject.addProperty("perPage", Boxing.d(requestSearchResultEntity.getPerPage()));
                jsonObject.addProperty("keyword", requestSearchResultEntity.getKeyword());
                String str = this.$tabId;
                if (str != null && str.length() != 0) {
                    jsonObject.addProperty("tabId", this.$tabId);
                }
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String jsonElement = jsonObject.toString();
                Intrinsics.g(jsonElement, "toString(...)");
                RequestBody create = companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
                searchResultViewModel = this.this$0;
                boolean z11 = this.$isLoadMore;
                Result.Companion companion2 = Result.INSTANCE;
                l11 = searchResultViewModel.l();
                String l12 = CacheIpPool.f40879a.l();
                this.L$0 = searchResultViewModel;
                this.Z$0 = z11;
                this.label = 1;
                obj = l11.c(l12, create, this);
                if (obj == f11) {
                    return f11;
                }
                z10 = z11;
            } else {
                if (i13 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z10 = this.Z$0;
                searchResultViewModel = (SearchResultViewModel) this.L$0;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            SearchResultEntity searchResultEntity = (SearchResultEntity) baseDto.getData();
            if (searchResultEntity != null) {
                SearchResultEntity searchResultEntity2 = (SearchResultEntity) baseDto.getData();
                h11 = searchResultViewModel.h(searchResultEntity2 != null ? searchResultEntity2.getResults() : null);
                searchResultEntity.setConvertData(h11);
            }
            if (z10) {
                searchResultViewModel.j().n(baseDto.getData());
            } else {
                searchResultViewModel.k().n(baseDto.getData());
            }
            i12 = searchResultViewModel.f52171f;
            searchResultViewModel.f52171f = 1 + i12;
            m1185constructorimpl = Result.m1185constructorimpl(Boxing.d(i12));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        SearchResultViewModel searchResultViewModel2 = this.this$0;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            searchResultViewModel2.k().n(null);
            a.C0856a.l(lg.a.f68962a, "SearchResultViewModel", "requestSearchResult error: " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
        return Unit.f67184a;
    }
}
