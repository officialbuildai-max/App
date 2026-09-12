package com.transsion.commercialization.gameres.ps;

import android.content.Context;
import android.view.View;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.ad.ps.model.RecommendInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1", f = "PSGameResLoader.kt", l = {62}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
final class PSGameResLoader$loadGameInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<View, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $itemId;
    final /* synthetic */ String $pageName;
    int label;
    final /* synthetic */ PSGameResLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/c;", "", "Lcom/transsion/ad/ps/model/RecommendInfo;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$3", f = "PSGameResLoader.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE, Sdk$SDKMetric.SDKMetricType.AD_BACKGROUND_BEFORE_IMPRESSION_VALUE, 57}, m = "invokeSuspend")
    /* renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ RequestBody $body;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PSGameResLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PSGameResLoader pSGameResLoader, RequestBody requestBody, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = pSGameResLoader;
            this.$body = requestBody;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$body, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.c cVar;
            a g11;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                g11 = this.this$0.g();
                RequestBody requestBody = this.$body;
                String f12 = this.this$0.f();
                this.L$0 = cVar;
                this.label = 1;
                obj = g11.a(requestBody, f12, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2 && i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f67184a;
                }
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                ResultKt.b(obj);
            }
            PsLinkDto psLinkDto = (PsLinkDto) obj;
            if (psLinkDto.getCode() == 0) {
                List<RecommendInfo> data = psLinkDto.getData();
                this.L$0 = null;
                this.label = 2;
                if (cVar.emit(data, this) == f11) {
                    return f11;
                }
            } else {
                lg.a.f68962a.c("GameResLoader", "PSGameRes fail, code:" + psLinkDto.getCode() + ", msg:" + psLinkDto.getMsg(), true);
                this.L$0 = null;
                this.label = 3;
                if (cVar.emit(null, this) == f11) {
                    return f11;
                }
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/c;", "", "Lcom/transsion/ad/ps/model/RecommendInfo;", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$4", f = "PSGameResLoader.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = cVar;
            anonymousClass4.L$1 = th2;
            return anonymousClass4.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.c cVar = (kotlinx.coroutines.flow.c) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                lg.a.f68962a.c("GameResLoader", "PSGameRes error:" + th2, true);
                this.L$0 = null;
                this.label = 1;
                if (cVar.emit(null, this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PSGameResLoader$loadGameInfo$1(String str, PSGameResLoader pSGameResLoader, Function1<? super View, Unit> function1, Context context, String str2, Continuation<? super PSGameResLoader$loadGameInfo$1> continuation) {
        super(2, continuation);
        this.$itemId = str;
        this.this$0 = pSGameResLoader;
        this.$callback = function1;
        this.$context = context;
        this.$pageName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PSGameResLoader$loadGameInfo$1(this.$itemId, this.this$0, this.$callback, this.$context, this.$pageName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PSGameResLoader$loadGameInfo$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.$itemId);
            Unit unit = Unit.f67184a;
            jSONObject.put("itemIds", jSONArray);
            for (Map.Entry entry : qi.a.INSTANCE.a(System.currentTimeMillis()).entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.g(jSONObject2, "toString(...)");
            lg.a.f68962a.c("GameResLoader", "PSGameRes loadGameInfo,bodyStr:" + jSONObject2 + " ", true);
            kotlinx.coroutines.flow.b f12 = d.f(d.s(new AnonymousClass3(this.this$0, bh.b.f16553a.a(jSONObject2), null)), new AnonymousClass4(null));
            final Function1<View, Unit> function1 = this.$callback;
            final PSGameResLoader pSGameResLoader = this.this$0;
            final Context context = this.$context;
            final String str = this.$pageName;
            final String str2 = this.$itemId;
            kotlinx.coroutines.flow.c cVar = new kotlinx.coroutines.flow.c() { // from class: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1.5

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
                @DebugMetadata(c = "com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$5$1", f = "PSGameResLoader.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.transsion.commercialization.gameres.ps.PSGameResLoader$loadGameInfo$1$5$1, reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<View, Unit> $callback;
                    final /* synthetic */ Context $context;
                    final /* synthetic */ String $itemId;
                    final /* synthetic */ String $pageName;
                    final /* synthetic */ List<RecommendInfo> $response;
                    int label;
                    final /* synthetic */ PSGameResLoader this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(List<RecommendInfo> list, Function1<? super View, Unit> function1, PSGameResLoader pSGameResLoader, Context context, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$response = list;
                        this.$callback = function1;
                        this.this$0 = pSGameResLoader;
                        this.$context = context;
                        this.$pageName = str;
                        this.$itemId = str2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$response, this.$callback, this.this$0, this.$context, this.$pageName, this.$itemId, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        List<RecommendInfo> list = this.$response;
                        if (list != null && !list.isEmpty()) {
                            RecommendInfo recommendInfo = (RecommendInfo) CollectionsKt.k0(this.$response);
                            if (recommendInfo != null ? Intrinsics.c(recommendInfo.getExists(), Boxing.a(true)) : false) {
                                RecommendInfo recommendInfo2 = (RecommendInfo) CollectionsKt.k0(this.$response);
                                if (recommendInfo2 != null) {
                                    Function1<View, Unit> function1 = this.$callback;
                                    PSGameResLoader pSGameResLoader = this.this$0;
                                    Context context = this.$context;
                                    String str = this.$pageName;
                                    String str2 = this.$itemId;
                                    a.C0856a.f(lg.a.f68962a, "GameResLoader", "PSGameRes getGameInfo, success:" + recommendInfo2, false, 4, null);
                                    function1.invoke(pSGameResLoader.e(context, pSGameResLoader.d(str, str2, recommendInfo2)));
                                } else {
                                    this.$callback.invoke(null);
                                }
                                return Unit.f67184a;
                            }
                        }
                        this.$callback.invoke(null);
                        return Unit.f67184a;
                    }
                }

                @Override // kotlinx.coroutines.flow.c
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(List list, Continuation continuation) {
                    Object g11 = i.g(y0.c(), new AnonymousClass1(list, Function1.this, pSGameResLoader, context, str, str2, null), continuation);
                    return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
                }
            };
            this.label = 1;
            if (f12.a(cVar, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
