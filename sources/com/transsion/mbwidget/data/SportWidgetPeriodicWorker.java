package com.transsion.mbwidget.data;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/mbwidget/data/SportWidgetPeriodicWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/s$a;", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", be.g.f16474b, "a", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class SportWidgetPeriodicWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportWidgetPeriodicWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:25|26))(3:27|28|(4:30|17|18|(1:23)(2:20|21))(2:31|(1:33)(1:34)))|12|(1:14)|15|16|17|18|(0)(0)))|37|6|7|(0)(0)|12|(0)|15|16|17|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r14 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r14));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: all -> 0x0037, LOOP:0: B:13:0x0089->B:14:0x008b, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:11:0x0033, B:12:0x0083, B:14:0x008b, B:16:0x00a5, B:17:0x00c5, B:28:0x0045, B:30:0x0064, B:31:0x0070), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.data.SportWidgetPeriodicWorker.n(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
