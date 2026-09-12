package com.transsion.mpush.core.trigger;

import android.content.Context;
import android.os.Build;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import androidx.work.b0;
import androidx.work.d;
import be.g;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/mpush/core/trigger/PushWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/s$a;", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", g.f16474b, "a", "MBPush_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class PushWorker extends CoroutineWorker {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.mpush.core.trigger.PushWorker$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.h(context, "context");
            b0 b0Var = (b0) ((b0.a) ((b0.a) new b0.a(PushWorker.class, Random.INSTANCE.nextLong(15L, 30L), TimeUnit.MINUTES).i(new d.a().b(NetworkType.CONNECTED).a())).a("pull")).b();
            try {
                Result.Companion companion = Result.INSTANCE;
                if (Build.VERSION.SDK_INT >= 24) {
                    context = context.createDeviceProtectedStorageContext();
                }
                Result.m1185constructorimpl(WorkManager.f(context).e("new_sdk_push_pull_worker", ExistingPeriodicWorkPolicy.KEEP, b0Var));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(1:(1:9)(2:18|19))(2:20|(1:22))|10|11|12|13))|23|6|(0)(0)|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0093, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
    
        lg.a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【PushWorker】doWork -> Failed with error " + r13.getMessage(), false, 4, null);
        r13.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.transsion.mpush.core.trigger.PushWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r13
            com.transsion.mpush.core.trigger.PushWorker$doWork$1 r0 = (com.transsion.mpush.core.trigger.PushWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.mpush.core.trigger.PushWorker$doWork$1 r0 = new com.transsion.mpush.core.trigger.PushWorker$doWork$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r13)
            goto L74
        L29:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L31:
            kotlin.ResultKt.b(r13)
            lg.a$a r13 = lg.a.f68962a
            r8 = 4
            r9 = 0
            java.lang.String r5 = "M_PUSH_SDK"
            java.lang.String r6 = "【PushWorker】 doWork -> Started"
            r7 = 0
            r4 = r13
            lg.a.C0856a.f(r4, r5, r6, r7, r8, r9)
            kotlin.random.Random$Default r2 = kotlin.random.Random.INSTANCE
            r4 = 0
            r6 = 60
            long r10 = r2.nextLong(r4, r6)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "【PushWorker】doWork -> Delaying for "
            r2.append(r4)
            r2.append(r10)
            java.lang.String r4 = "s"
            r2.append(r4)
            java.lang.String r6 = r2.toString()
            java.lang.String r5 = "M_PUSH_SDK"
            r7 = 0
            r4 = r13
            lg.a.C0856a.f(r4, r5, r6, r7, r8, r9)
            r4 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r4
            r0.label = r3
            java.lang.Object r13 = kotlinx.coroutines.u0.a(r10, r0)
            if (r13 != r1) goto L74
            return r1
        L74:
            lg.a$a r13 = lg.a.f68962a     // Catch: java.lang.Exception -> L93
            java.lang.String r3 = "M_PUSH_SDK"
            java.lang.String r4 = "【PushWorker】doWork -> Triggering TIMER event"
            r6 = 4
            r7 = 0
            r5 = 0
            r2 = r13
            lg.a.C0856a.f(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L93
            ln.a r0 = ln.a.f69101a     // Catch: java.lang.Exception -> L93
            r1 = 4
            r0.m(r1)     // Catch: java.lang.Exception -> L93
            java.lang.String r3 = "M_PUSH_SDK"
            java.lang.String r4 = "【PushWorker】doWork -> Success"
            r6 = 4
            r7 = 0
            r5 = 0
            r2 = r13
            lg.a.C0856a.f(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L93
            goto Lb6
        L93:
            r13 = move-exception
            lg.a$a r0 = lg.a.f68962a
            java.lang.String r1 = r13.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "【PushWorker】doWork -> Failed with error "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "M_PUSH_SDK"
            r3 = 0
            lg.a.C0856a.l(r0, r1, r2, r3, r4, r5)
            r13.printStackTrace()
        Lb6:
            androidx.work.s$a r13 = androidx.work.s.a.c()
            java.lang.String r0 = "success(...)"
            kotlin.jvm.internal.Intrinsics.g(r13, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.trigger.PushWorker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
