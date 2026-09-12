package com.transsion.lib_web.cache;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Z"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$3", f = "TWebViewAdCacheManager.kt", l = {325}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class TWebViewAdCacheManager$isWebviewLoaded$3 extends SuspendLambda implements Function2<n0, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TWebViewAdCacheManager$isWebviewLoaded$3(Continuation<? super TWebViewAdCacheManager$isWebviewLoaded$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TWebViewAdCacheManager$isWebviewLoaded$3 tWebViewAdCacheManager$isWebviewLoaded$3 = new TWebViewAdCacheManager$isWebviewLoaded$3(continuation);
        tWebViewAdCacheManager$isWebviewLoaded$3.L$0 = obj;
        return tWebViewAdCacheManager$isWebviewLoaded$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Boolean> continuation) {
        return ((TWebViewAdCacheManager$isWebviewLoaded$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final n0 n0Var = (n0) this.L$0;
            this.L$0 = n0Var;
            this.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.initCancellability();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$3$1$1

                /* loaded from: classes5.dex */
                static final class a implements ValueCallback {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ n f46195a;

                    a(n nVar) {
                        this.f46195a = nVar;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0027, code lost:
                    
                        r0 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c;
                     */
                    @Override // android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void onReceiveValue(java.lang.String r4) {
                        /*
                            r3 = this;
                            kotlin.jvm.internal.Intrinsics.e(r4)
                            java.lang.String r0 = "\""
                            java.lang.String r4 = kotlin.text.StringsKt.K0(r4, r0)
                            com.transsion.lib_web.cache.b r0 = com.transsion.lib_web.cache.b.f46199a
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r2 = "isWebviewLoaded adStatus = "
                            r1.append(r2)
                            r1.append(r4)
                            java.lang.String r1 = r1.toString()
                            r0.g(r1)
                            java.lang.String r0 = "fail"
                            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r4)
                            if (r0 == 0) goto L30
                            com.github.lzyzsd.jsbridge.BridgeWebView r0 = com.transsion.lib_web.cache.TWebViewAdCacheManager.a()
                            if (r0 == 0) goto L30
                            r0.reload()
                        L30:
                            kotlinx.coroutines.n r0 = r3.f46195a
                            boolean r0 = r0.isActive()
                            if (r0 == 0) goto L4d
                            kotlinx.coroutines.n r0 = r3.f46195a
                            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
                            java.lang.String r1 = "success"
                            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r1, r4)
                            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                            java.lang.Object r4 = kotlin.Result.m1185constructorimpl(r4)
                            r0.resumeWith(r4)
                        L4d:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$3$1$1.a.onReceiveValue(java.lang.String):void");
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BridgeWebView bridgeWebView;
                    bridgeWebView = TWebViewAdCacheManager.f46192c;
                    if (bridgeWebView != null) {
                        bridgeWebView.evaluateJavascript("window.getAdStatus()", new a(cancellableContinuationImpl));
                        return;
                    }
                    n nVar = cancellableContinuationImpl;
                    if (nVar.isActive()) {
                        Result.Companion companion = Result.INSTANCE;
                        nVar.resumeWith(Result.m1185constructorimpl(Boolean.FALSE));
                    }
                }
            });
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
