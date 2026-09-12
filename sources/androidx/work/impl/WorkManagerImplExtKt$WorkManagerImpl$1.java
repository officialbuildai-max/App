package androidx.work.impl;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final /* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends FunctionReferenceImpl implements Function6<Context, androidx.work.b, j4.c, WorkDatabase, i4.n, s, List<? extends u>> {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    @Override // kotlin.jvm.functions.Function6
    public final List<u> invoke(Context p02, androidx.work.b p12, j4.c p22, WorkDatabase p32, i4.n p42, s p52) {
        List<u> b11;
        Intrinsics.h(p02, "p0");
        Intrinsics.h(p12, "p1");
        Intrinsics.h(p22, "p2");
        Intrinsics.h(p32, "p3");
        Intrinsics.h(p42, "p4");
        Intrinsics.h(p52, "p5");
        b11 = WorkManagerImplExtKt.b(p02, p12, p22, p32, p42, p52);
        return b11;
    }
}
