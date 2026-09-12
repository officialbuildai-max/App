package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.f1;
import androidx.work.impl.model.k0;
import androidx.work.impl.model.q;
import androidx.work.impl.model.v1;
import androidx.work.impl.model.z;
import androidx.work.s;
import androidx.work.t;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/s$a;", TtmlNode.TAG_P, "()Landroidx/work/s$a;", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes2.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.h(context, "context");
        Intrinsics.h(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    public s.a p() {
        String str;
        String str2;
        String d11;
        String str3;
        String str4;
        String d12;
        String str5;
        String str6;
        String d13;
        f1 o11 = f1.o(a());
        Intrinsics.g(o11, "getInstance(...)");
        WorkDatabase t11 = o11.t();
        Intrinsics.g(t11, "getWorkDatabase(...)");
        k0 l02 = t11.l0();
        z j02 = t11.j0();
        v1 m02 = t11.m0();
        q i02 = t11.i0();
        List e11 = l02.e(o11.m().a().currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List v11 = l02.v();
        List m11 = l02.m(200);
        if (!e11.isEmpty()) {
            t e12 = t.e();
            str5 = a.f16098a;
            e12.f(str5, "Recently completed work:\n\n");
            t e13 = t.e();
            str6 = a.f16098a;
            d13 = a.d(j02, m02, i02, e11);
            e13.f(str6, d13);
        }
        if (!v11.isEmpty()) {
            t e14 = t.e();
            str3 = a.f16098a;
            e14.f(str3, "Running work:\n\n");
            t e15 = t.e();
            str4 = a.f16098a;
            d12 = a.d(j02, m02, i02, v11);
            e15.f(str4, d12);
        }
        if (!m11.isEmpty()) {
            t e16 = t.e();
            str = a.f16098a;
            e16.f(str, "Enqueued work:\n\n");
            t e17 = t.e();
            str2 = a.f16098a;
            d11 = a.d(j02, m02, i02, m11);
            e17.f(str2, d11);
        }
        s.a c11 = s.a.c();
        Intrinsics.g(c11, "success(...)");
        return c11;
    }
}
