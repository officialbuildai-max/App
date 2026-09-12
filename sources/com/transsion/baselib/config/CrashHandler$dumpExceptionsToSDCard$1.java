package com.transsion.baselib.config;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baselib.config.CrashHandler$dumpExceptionsToSDCard$1", f = "CrashHandler.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class CrashHandler$dumpExceptionsToSDCard$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $e;
    int label;
    final /* synthetic */ CrashHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrashHandler$dumpExceptionsToSDCard$1(CrashHandler crashHandler, Throwable th2, Continuation<? super CrashHandler$dumpExceptionsToSDCard$1> continuation) {
        super(2, continuation);
        this.this$0 = crashHandler;
        this.$e = th2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CrashHandler$dumpExceptionsToSDCard$1(this.this$0, this.$e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CrashHandler$dumpExceptionsToSDCard$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00af, code lost:
    
        if (r8 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b1, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c1, code lost:
    
        return kotlin.Unit.f67184a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.PrintWriter, T] */
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
            if (r0 != 0) goto Lcc
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            com.transsion.baselib.config.CrashHandler r0 = r7.this$0     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            android.app.Application r0 = com.transsion.baselib.config.CrashHandler.d(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            if (r0 == 0) goto Lab
            java.lang.Throwable r1 = r7.$e     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            mg.c$a r2 = mg.c.f69683a     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r0 = r2.c(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            if (r3 != 0) goto L34
            r2.mkdirs()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            goto L34
        L2e:
            r0 = move-exception
            goto Lc2
        L31:
            r0 = move-exception
            goto Lb5
        L34:
            java.util.Date r2 = new java.util.Date     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r4 = "yyyy-MM-dd"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r3 = r3.format(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r6.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r6.append(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r6.append(r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r0 = "crash"
            r6.append(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r6.append(r3)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r0 = ".txt"
            r6.append(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.FileWriter r5 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r6 = 1
            r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r8.element = r0     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r4 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r2 = r3.format(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r3.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r4 = "begin crash "
            r3.append(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r3.append(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r0.println(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            T r0 = r8.element     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            java.io.PrintWriter r0 = (java.io.PrintWriter) r0     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r1.printStackTrace(r0)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
        Lab:
            T r8 = r8.element
            java.io.PrintWriter r8 = (java.io.PrintWriter) r8
            if (r8 == 0) goto Lbf
        Lb1:
            r8.close()
            goto Lbf
        Lb5:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            T r8 = r8.element
            java.io.PrintWriter r8 = (java.io.PrintWriter) r8
            if (r8 == 0) goto Lbf
            goto Lb1
        Lbf:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        Lc2:
            T r8 = r8.element
            java.io.PrintWriter r8 = (java.io.PrintWriter) r8
            if (r8 == 0) goto Lcb
            r8.close()
        Lcb:
            throw r0
        Lcc:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.config.CrashHandler$dumpExceptionsToSDCard$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
