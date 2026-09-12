package com.wecloud.load.lib;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.google.gson.Gson;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.wecloud.load.lib.bean.SoLoadControlConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/wecloud/load/lib/ExitCheckWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/s$a;", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", be.g.f16474b, "a", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class ExitCheckWorker extends CoroutineWorker {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.wecloud.load.lib.ExitCheckWorker$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context) {
            Intrinsics.h(context, "context");
            String l11 = gz.b.f64159a.b().l("so_load_control_config", null);
            if (l11 == null || StringsKt.q0(l11)) {
                a.C0856a.f(lg.a.f68962a, "ExitCheckWorker", "ExitCheckWorker: MMKV 中无配置，跳过", false, 4, null);
                return false;
            }
            SoLoadControlConfig soLoadControlConfig = (SoLoadControlConfig) new Gson().fromJson(l11, SoLoadControlConfig.class);
            if (soLoadControlConfig == null || !soLoadControlConfig.getExitProcess()) {
                a.C0856a.f(lg.a.f68962a, "ExitCheckWorker", "ExitCheckWorker: exitProcess 为 false，跳过", false, 4, null);
                return false;
            }
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "ExitCheckWorker", "ExitCheckWorker: 检测到 exitProcess 为 true，清空配置并尝试通知 SoLoadService 退出", false, 4, null);
            DySoLoadManager.f60929a.i(context, "");
            p pVar = p.f60997a;
            if (!pVar.a()) {
                a.C0856a.f(c0856a, "ExitCheckWorker", "ExitCheckWorker: SoLoadService 已停止，跳过", false, 4, null);
                return false;
            }
            a.C0856a.f(c0856a, "ExitCheckWorker", "ExitCheckWorker: SoLoadService 存活，触发退出检查", false, 4, null);
            pVar.c();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExitCheckWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.wecloud.load.lib.ExitCheckWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r6
            com.wecloud.load.lib.ExitCheckWorker$doWork$1 r0 = (com.wecloud.load.lib.ExitCheckWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wecloud.load.lib.ExitCheckWorker$doWork$1 r0 = new com.wecloud.load.lib.ExitCheckWorker$doWork$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.i0 r6 = kotlinx.coroutines.y0.b()
            com.wecloud.load.lib.ExitCheckWorker$doWork$2 r2 = new com.wecloud.load.lib.ExitCheckWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.i.g(r6, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.lang.String r0 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.ExitCheckWorker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
