package com.transsion.web.fragment;

import bh.b;
import com.transsion.web.bean.ApiRequestData;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.j0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1", f = "WebFragmentV2.kt", l = {374}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class WebFragmentV2$addJsInterface$2$1$request$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callbackId;
    final /* synthetic */ ApiRequestData $requestData;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ WebFragmentV2 this$0;
    final /* synthetic */ WebFragmentV2$addJsInterface$2$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$1", f = "WebFragmentV2.kt", l = {356, 360, 367, 369}, m = "invokeSuspend")
    /* renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApiRequestData $requestData;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WebFragmentV2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ApiRequestData apiRequestData, WebFragmentV2 webFragmentV2, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestData = apiRequestData;
            this.this$0 = webFragmentV2;
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestData, this.this$0, this.$url, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.c cVar;
            wx.a o12;
            RequestBody requestBody;
            wx.a o13;
            j0 j0Var;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                String upperCase = this.$requestData.getMethods().toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                if (Intrinsics.c(upperCase, "POST")) {
                    if (this.$requestData.getQueryParams() != null) {
                        b.a aVar = bh.b.f16553a;
                        String j11 = com.blankj.utilcode.util.o.j(this.$requestData.getQueryParams());
                        Intrinsics.g(j11, "toJson(...)");
                        requestBody = aVar.a(j11);
                    } else {
                        requestBody = null;
                    }
                    o13 = this.this$0.o1();
                    String str = this.$url;
                    Map<String, String> headers = this.$requestData.getHeaders();
                    if (headers == null) {
                        headers = new LinkedHashMap<>();
                    }
                    this.L$0 = cVar;
                    this.label = 1;
                    obj = o13.a(str, headers, requestBody, this);
                    if (obj == f11) {
                        return f11;
                    }
                    j0Var = (j0) obj;
                } else {
                    o12 = this.this$0.o1();
                    String str2 = this.$url;
                    Map<String, String> headers2 = this.$requestData.getHeaders();
                    if (headers2 == null) {
                        headers2 = new LinkedHashMap<>();
                    }
                    Map<String, Object> queryParams = this.$requestData.getQueryParams();
                    if (queryParams == null) {
                        queryParams = new LinkedHashMap<>();
                    }
                    this.L$0 = cVar;
                    this.label = 2;
                    obj = o12.b(str2, headers2, queryParams, this);
                    if (obj == f11) {
                        return f11;
                    }
                    j0Var = (j0) obj;
                }
            } else if (i11 == 1) {
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                ResultKt.b(obj);
                j0Var = (j0) obj;
            } else {
                if (i11 != 2) {
                    if (i11 != 3 && i11 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f67184a;
                }
                cVar = (kotlinx.coroutines.flow.c) this.L$0;
                ResultKt.b(obj);
                j0Var = (j0) obj;
            }
            if (!j0Var.e() || j0Var.a() == null) {
                this.L$0 = null;
                this.label = 4;
                if (cVar.emit(null, this) == f11) {
                    return f11;
                }
            } else {
                Object a11 = j0Var.a();
                Intrinsics.e(a11);
                String string = ((ResponseBody) a11).string();
                this.L$0 = null;
                this.label = 3;
                if (cVar.emit(string, this) == f11) {
                    return f11;
                }
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/c;", "", "", "it", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$2", f = "WebFragmentV2.kt", l = {373}, m = "invokeSuspend")
    /* renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.c, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ WebFragmentV2$addJsInterface$2$1 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WebFragmentV2$addJsInterface$2$1 webFragmentV2$addJsInterface$2$1, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = webFragmentV2$addJsInterface$2$1;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.c cVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = cVar;
            anonymousClass2.L$1 = th2;
            return anonymousClass2.invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.c cVar = (kotlinx.coroutines.flow.c) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                lg.a.f68962a.c(this.this$0.getTAG(), "requestApiData, error :" + th2, true);
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
    /* renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass3 implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebFragmentV2 f58193a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f58194b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WebFragmentV2$addJsInterface$2$1 f58195c;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
        @DebugMetadata(c = "com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$1", f = "WebFragmentV2.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$1, reason: invalid class name */
        /* loaded from: classes7.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
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
                return Unit.f67184a;
            }
        }

        AnonymousClass3(WebFragmentV2 webFragmentV2, String str, WebFragmentV2$addJsInterface$2$1 webFragmentV2$addJsInterface$2$1) {
            this.f58193a = webFragmentV2;
            this.f58194b = str;
            this.f58195c = webFragmentV2$addJsInterface$2$1;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.String r6, kotlin.coroutines.Continuation r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$emit$1 r0 = (com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$emit$1 r0 = new com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r6 = r0.L$0
                java.lang.String r6 = (java.lang.String) r6
                kotlin.ResultKt.b(r7)
                goto L4d
            L2d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L35:
                kotlin.ResultKt.b(r7)
                kotlinx.coroutines.a2 r7 = kotlinx.coroutines.y0.c()
                com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$1 r2 = new com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1$3$1
                r4 = 0
                r2.<init>(r4)
                r0.L$0 = r6
                r0.label = r3
                java.lang.Object r7 = kotlinx.coroutines.i.g(r7, r2, r0)
                if (r7 != r1) goto L4d
                return r1
            L4d:
                if (r6 == 0) goto L80
                int r7 = r6.length()
                if (r7 != 0) goto L56
                goto L80
            L56:
                lg.a$a r7 = lg.a.f68962a
                com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1 r0 = r5.f58195c
                java.lang.String r0 = r0.getTAG()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "requestApiData, success :"
                r1.append(r2)
                r1.append(r6)
                java.lang.String r1 = r1.toString()
                r7.c(r0, r1, r3)
                com.transsion.web.fragment.WebFragmentV2 r7 = r5.f58193a
                com.github.lzyzsd.jsbridge.BridgeWebView r7 = r7.o0()
                if (r7 == 0) goto L8f
                java.lang.String r0 = r5.f58194b
                r7.sendResponse(r6, r0)
                goto L8f
            L80:
                com.transsion.web.fragment.WebFragmentV2 r6 = r5.f58193a
                com.github.lzyzsd.jsbridge.BridgeWebView r6 = r6.o0()
                if (r6 == 0) goto L8f
                java.lang.String r7 = ""
                java.lang.String r0 = r5.f58194b
                r6.sendResponse(r7, r0)
            L8f:
                kotlin.Unit r6 = kotlin.Unit.f67184a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1$request$1.AnonymousClass3.emit(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragmentV2$addJsInterface$2$1$request$1(ApiRequestData apiRequestData, WebFragmentV2 webFragmentV2, String str, WebFragmentV2$addJsInterface$2$1 webFragmentV2$addJsInterface$2$1, String str2, Continuation<? super WebFragmentV2$addJsInterface$2$1$request$1> continuation) {
        super(2, continuation);
        this.$requestData = apiRequestData;
        this.this$0 = webFragmentV2;
        this.$url = str;
        this.this$1 = webFragmentV2$addJsInterface$2$1;
        this.$callbackId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebFragmentV2$addJsInterface$2$1$request$1(this.$requestData, this.this$0, this.$url, this.this$1, this.$callbackId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((WebFragmentV2$addJsInterface$2$1$request$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.b f12 = kotlinx.coroutines.flow.d.f(kotlinx.coroutines.flow.d.s(new AnonymousClass1(this.$requestData, this.this$0, this.$url, null)), new AnonymousClass2(this.this$1, null));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, this.$callbackId, this.this$1);
            this.label = 1;
            if (f12.a(anonymousClass3, this) == f11) {
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
