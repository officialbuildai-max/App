package com.tn.tranpay.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.helper.IPHelper$fetchIPFromService$2", f = "IPHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class IPHelper$fetchIPFromService$2 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    final /* synthetic */ String $serviceUrl;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPHelper$fetchIPFromService$2(String str, Continuation<? super IPHelper$fetchIPFromService$2> continuation) {
        super(2, continuation);
        this.$serviceUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IPHelper$fetchIPFromService$2(this.$serviceUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return ((IPHelper$fetchIPFromService$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
    
        if (r1 == null) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x006b */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r7.label
            if (r0 != 0) goto Lcb
            kotlin.ResultKt.b(r8)
            r8 = 2
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r2 = r7.$serviceUrl     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.f(r1, r2)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r2 = 5000(0x1388, float:7.006E-42)
            r1.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r1.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.String r2 = "User-Agent"
            java.lang.String r3 = "TranPay-Android"
            r1.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            int r2 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L75
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L64
            java.lang.String r4 = "readLine()"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)     // Catch: java.lang.Throwable -> L62
            java.lang.CharSequence r3 = kotlin.text.StringsKt.n1(r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L62
            goto L65
        L62:
            r3 = move-exception
            goto L6f
        L64:
            r3 = r0
        L65:
            kotlin.io.CloseableKt.a(r2, r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r0 = r3
            goto L95
        L6a:
            r8 = move-exception
            r0 = r1
            goto Lc5
        L6d:
            r2 = move-exception
            goto L9d
        L6f:
            throw r3     // Catch: java.lang.Throwable -> L70
        L70:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r2, r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            throw r4     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
        L75:
            ai.a r3 = ai.a.f694a     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.String r4 = r7.$serviceUrl     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r5.<init>()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.String r6 = "IP服务响应错误: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r5.append(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.String r4 = ", 响应码: "
            r5.append(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r5.append(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            ai.a.e(r3, r2, r0, r8, r0)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
        L95:
            r1.disconnect()
            goto Lc4
        L99:
            r8 = move-exception
            goto Lc5
        L9b:
            r2 = move-exception
            r1 = r0
        L9d:
            ai.a r3 = ai.a.f694a     // Catch: java.lang.Throwable -> L6a
            java.lang.String r4 = r7.$serviceUrl     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r5.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = "请求IP服务异常: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L6a
            r5.append(r4)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r4 = ", 错误: "
            r5.append(r4)     // Catch: java.lang.Throwable -> L6a
            r5.append(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L6a
            ai.a.e(r3, r2, r0, r8, r0)     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto Lc4
            goto L95
        Lc4:
            return r0
        Lc5:
            if (r0 == 0) goto Lca
            r0.disconnect()
        Lca:
            throw r8
        Lcb:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.helper.IPHelper$fetchIPFromService$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
