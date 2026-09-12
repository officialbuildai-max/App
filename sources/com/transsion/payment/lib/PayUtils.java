package com.transsion.payment.lib;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class PayUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final PayUtils f47822a = new PayUtils();

    private PayUtils() {
    }

    public static /* synthetic */ Object b(PayUtils payUtils, long j11, int i11, Function1 function1, Continuation continuation, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j11 = 3000;
        }
        return payUtils.a(j11, (i12 & 2) != 0 ? 2 : i11, function1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a6 -> B:11:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r10, int r12, kotlin.jvm.functions.Function1 r13, kotlin.coroutines.Continuation r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.transsion.payment.lib.PayUtils$retryWithBackoff$1
            if (r0 == 0) goto L13
            r0 = r14
            com.transsion.payment.lib.PayUtils$retryWithBackoff$1 r0 = (com.transsion.payment.lib.PayUtils$retryWithBackoff$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.payment.lib.PayUtils$retryWithBackoff$1 r0 = new com.transsion.payment.lib.PayUtils$retryWithBackoff$1
            r0.<init>(r9, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L4b
            if (r2 == r3) goto L3d
            if (r2 != r4) goto L35
            int r10 = r0.I$0
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            kotlin.ResultKt.b(r14)
            goto La9
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3d:
            int r10 = r0.I$0
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Exception -> L49
            goto L6a
        L49:
            r14 = move-exception
            goto L76
        L4b:
            kotlin.ResultKt.b(r14)
        L4e:
            kotlinx.coroutines.i0 r14 = kotlinx.coroutines.y0.a()     // Catch: java.lang.Exception -> L72
            com.transsion.payment.lib.PayUtils$retryWithBackoff$2 r2 = new com.transsion.payment.lib.PayUtils$retryWithBackoff$2     // Catch: java.lang.Exception -> L72
            r5 = 0
            r2.<init>(r13, r5)     // Catch: java.lang.Exception -> L72
            r0.L$0 = r13     // Catch: java.lang.Exception -> L72
            r0.J$0 = r10     // Catch: java.lang.Exception -> L72
            r0.I$0 = r12     // Catch: java.lang.Exception -> L72
            r0.label = r3     // Catch: java.lang.Exception -> L72
            java.lang.Object r14 = kotlinx.coroutines.i.g(r14, r2, r0)     // Catch: java.lang.Exception -> L72
            if (r14 != r1) goto L67
            return r1
        L67:
            r7 = r10
            r10 = r12
            r11 = r7
        L6a:
            java.lang.String r2 = "Action succeeded"
            java.io.PrintStream r5 = java.lang.System.out     // Catch: java.lang.Exception -> L49
            r5.println(r2)     // Catch: java.lang.Exception -> L49
            return r14
        L72:
            r14 = move-exception
            r7 = r10
            r10 = r12
            r11 = r7
        L76:
            if (r10 <= 0) goto Lb1
            java.lang.String r14 = r14.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Action failed: "
            r2.append(r5)
            r2.append(r14)
            java.lang.String r14 = ". Retries left: "
            r2.append(r14)
            r2.append(r10)
            java.lang.String r14 = r2.toString()
            java.io.PrintStream r2 = java.lang.System.out
            r2.println(r14)
            r0.L$0 = r13
            r0.J$0 = r11
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r14 = kotlinx.coroutines.u0.a(r11, r0)
            if (r14 != r1) goto La9
            return r1
        La9:
            long r5 = (long) r4
            long r11 = r11 * r5
            int r10 = r10 + (-1)
            r7 = r11
            r12 = r10
            r10 = r7
            goto L4e
        Lb1:
            java.lang.String r10 = "All retry attempts exhausted"
            java.io.PrintStream r11 = java.lang.System.out
            r11.println(r10)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.PayUtils.a(long, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
