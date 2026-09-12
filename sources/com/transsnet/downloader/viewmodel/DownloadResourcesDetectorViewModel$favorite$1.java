package com.transsnet.downloader.viewmodel;

import com.cloud.tmc.integration.event.EventConstants;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import qy.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel$favorite$1", f = "DownloadResourcesDetectorViewModel.kt", l = {228}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadResourcesDetectorViewModel$favorite$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $favorite;
    final /* synthetic */ ShortTVFavInfo $favoriteInfo;
    final /* synthetic */ Subject $shortTvInfo;
    int label;
    final /* synthetic */ DownloadResourcesDetectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadResourcesDetectorViewModel$favorite$1(Subject subject, boolean z10, DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel, ShortTVFavInfo shortTVFavInfo, Continuation<? super DownloadResourcesDetectorViewModel$favorite$1> continuation) {
        super(2, continuation);
        this.$shortTvInfo = subject;
        this.$favorite = z10;
        this.this$0 = downloadResourcesDetectorViewModel;
        this.$favoriteInfo = shortTVFavInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadResourcesDetectorViewModel$favorite$1(this.$shortTvInfo, this.$favorite, this.this$0, this.$favoriteInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadResourcesDetectorViewModel$favorite$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        qy.a C;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                Subject subject = this.$shortTvInfo;
                boolean z10 = this.$favorite;
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subjectId", subject.getSubjectId());
                jSONObject.put(EventConstants.KEY_ACTION, !z10 ? 1 : 0);
                C = downloadResourcesDetectorViewModel.C();
                RequestBody.Companion companion2 = RequestBody.INSTANCE;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.g(jSONObject2, "toString(...)");
                RequestBody create = companion2.create(jSONObject2, MediaType.INSTANCE.parse("application/json"));
                this.label = 1;
                obj = a.C0925a.a(C, create, null, this, 2, null);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            m1185constructorimpl = Result.m1185constructorimpl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        ShortTVFavInfo shortTVFavInfo = this.$favoriteInfo;
        boolean z11 = this.$favorite;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel2 = this.this$0;
        Subject subject2 = this.$shortTvInfo;
        if (Result.m1192isSuccessimpl(m1185constructorimpl)) {
            if (shortTVFavInfo.getHasFavorite() != (!z11)) {
                shortTVFavInfo.setHasFavorite(!z11);
                if (z11) {
                    String favoriteNum = shortTVFavInfo.getFavoriteNum();
                    shortTVFavInfo.setFavoriteNum(String.valueOf((favoriteNum != null ? Long.parseLong(favoriteNum) : 1L) - 1));
                } else {
                    String favoriteNum2 = shortTVFavInfo.getFavoriteNum();
                    shortTVFavInfo.setFavoriteNum(String.valueOf((favoriteNum2 != null ? Long.parseLong(favoriteNum2) : 0L) + 1));
                }
                downloadResourcesDetectorViewModel2.E().q(!z11 ? Boxing.d(1) : Boxing.d(2));
                String subjectId = subject2.getSubjectId();
                if (subjectId == null) {
                    subjectId = "";
                }
                uy.c cVar = new uy.c(subjectId, true ^ z11, String.valueOf(shortTVFavInfo.getFavoriteNum()));
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = uy.c.class.getName();
                Intrinsics.g(name, "getName(...)");
                flowEventBus.postEvent(name, cVar, 0L);
            }
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel3 = this.this$0;
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            downloadResourcesDetectorViewModel3.E().q(Boxing.d(0));
        }
        return Unit.f67184a;
    }
}
