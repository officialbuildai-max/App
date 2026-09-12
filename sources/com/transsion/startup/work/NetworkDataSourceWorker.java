package com.transsion.startup.work;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import be.g;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/startup/work/NetworkDataSourceWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/s$a;", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", g.f16474b, "Companion", "Startup_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class NetworkDataSourceWorker extends CoroutineWorker {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(kotlin.coroutines.Continuation r12) {
            /*
                r11 = this;
                boolean r0 = r12 instanceof com.transsion.startup.work.NetworkDataSourceWorker$Companion$realWork$1
                if (r0 == 0) goto L14
                r0 = r12
                com.transsion.startup.work.NetworkDataSourceWorker$Companion$realWork$1 r0 = (com.transsion.startup.work.NetworkDataSourceWorker$Companion$realWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.label = r1
            L12:
                r4 = r0
                goto L1a
            L14:
                com.transsion.startup.work.NetworkDataSourceWorker$Companion$realWork$1 r0 = new com.transsion.startup.work.NetworkDataSourceWorker$Companion$realWork$1
                r0.<init>(r11, r12)
                goto L12
            L1a:
                java.lang.Object r12 = r4.result
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3a
                if (r1 == r3) goto L36
                if (r1 != r2) goto L2e
                kotlin.ResultKt.b(r12)
                goto L7e
            L2e:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L36:
                kotlin.ResultKt.b(r12)
                goto L6e
            L3a:
                kotlin.ResultKt.b(r12)
                kotlin.random.Random$Default r12 = kotlin.random.Random.INSTANCE
                r1 = 0
                r5 = 60
                int r12 = r12.nextInt(r1, r5)
                lg.a$a r5 = lg.a.f68962a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r6 = "doWork random * "
                r1.append(r6)
                r1.append(r12)
                java.lang.String r7 = r1.toString()
                r9 = 4
                r10 = 0
                java.lang.String r6 = "NetworkDataSourceWorker"
                r8 = 0
                lg.a.C0856a.f(r5, r6, r7, r8, r9, r10)
                long r5 = (long) r12
                r7 = 1000(0x3e8, double:4.94E-321)
                long r5 = r5 * r7
                r4.label = r3
                java.lang.Object r12 = kotlinx.coroutines.u0.a(r5, r4)
                if (r12 != r0) goto L6e
                return r0
            L6e:
                com.transsion.ad.monopoly.manager.AdPlansRequestManager r1 = com.transsion.ad.monopoly.manager.AdPlansRequestManager.f42204a
                r4.label = r2
                java.lang.String r2 = "/wefeed-mobile-bff/ad/config"
                r3 = 0
                r5 = 2
                r6 = 0
                java.lang.Object r12 = com.transsion.ad.monopoly.manager.AdPlansRequestManager.u(r1, r2, r3, r4, r5, r6)
                if (r12 != r0) goto L7e
                return r0
            L7e:
                rm.e r12 = rm.e.f74689a
                r0 = 3
                r1 = 0
                rm.e.p(r12, r1, r1, r0, r1)
                kotlin.Unit r12 = kotlin.Unit.f67184a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.startup.work.NetworkDataSourceWorker.Companion.a(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkDataSourceWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.transsion.startup.work.NetworkDataSourceWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r5
            com.transsion.startup.work.NetworkDataSourceWorker$doWork$1 r0 = (com.transsion.startup.work.NetworkDataSourceWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.startup.work.NetworkDataSourceWorker$doWork$1 r0 = new com.transsion.startup.work.NetworkDataSourceWorker$doWork$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Exception -> L29
            goto L41
        L29:
            r5 = move-exception
            goto L4b
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.b(r5)
            com.transsion.startup.work.NetworkDataSourceWorker$Companion r5 = com.transsion.startup.work.NetworkDataSourceWorker.INSTANCE     // Catch: java.lang.Exception -> L29
            r0.label = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r5 = r5.a(r0)     // Catch: java.lang.Exception -> L29
            if (r5 != r1) goto L41
            return r1
        L41:
            androidx.work.s$a r5 = androidx.work.s.a.c()
            java.lang.String r0 = "success(...)"
            kotlin.jvm.internal.Intrinsics.g(r5, r0)
            return r5
        L4b:
            r5.printStackTrace()
            androidx.work.s$a r5 = androidx.work.s.a.a()
            java.lang.String r0 = "failure(...)"
            kotlin.jvm.internal.Intrinsics.g(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.startup.work.NetworkDataSourceWorker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
