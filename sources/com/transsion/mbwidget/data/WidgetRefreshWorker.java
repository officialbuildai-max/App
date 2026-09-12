package com.transsion.mbwidget.data;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.s;
import com.transsion.gslb.GslbSdk;
import com.transsion.mbwidget.HotSubjectWidgetProvider;
import com.transsion.mbwidget.PlayWidgetProvider;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/transsion/mbwidget/data/WidgetRefreshWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/s$a;", "n", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", be.g.f16474b, "a", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class WidgetRefreshWorker extends CoroutineWorker {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.mbwidget.data.WidgetRefreshWorker$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            try {
                Result.Companion companion = Result.INSTANCE;
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(GslbSdk.context);
                if (WidgetDataManager.f46309a.y()) {
                    int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(GslbSdk.context, (Class<?>) HotSubjectWidgetProvider.class));
                    Intrinsics.e(appWidgetIds);
                    if (!(appWidgetIds.length == 0)) {
                        for (int i11 : appWidgetIds) {
                            HotSubjectWidgetProvider.Companion companion2 = HotSubjectWidgetProvider.INSTANCE;
                            Context context = GslbSdk.context;
                            Intrinsics.g(context, "context");
                            Intrinsics.e(appWidgetManager);
                            HotSubjectWidgetProvider.Companion.f(companion2, context, appWidgetManager, i11, null, 8, null);
                        }
                    }
                }
                int[] appWidgetIds2 = appWidgetManager.getAppWidgetIds(new ComponentName(GslbSdk.context, (Class<?>) PlayWidgetProvider.class));
                Intrinsics.e(appWidgetIds2);
                if (!(appWidgetIds2.length == 0)) {
                    for (int i12 : appWidgetIds2) {
                        PlayWidgetProvider.Companion companion3 = PlayWidgetProvider.INSTANCE;
                        Context context2 = GslbSdk.context;
                        Intrinsics.g(context2, "context");
                        Intrinsics.e(appWidgetManager);
                        companion3.c(context2, appWidgetManager, i12);
                    }
                }
                a.C0856a.f(lg.a.f68962a, "DeskWidget_", "doWork, refresh completed", false, 4, null);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRefreshWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.h(context, "context");
        Intrinsics.h(params, "params");
    }

    @Override // androidx.work.CoroutineWorker
    public Object n(Continuation continuation) {
        a.C0856a.f(lg.a.f68962a, "DeskWidget_", "doWork, refresh:" + WidgetDataManager.f46309a.y(), false, 4, null);
        INSTANCE.a();
        s.a c11 = s.a.c();
        Intrinsics.g(c11, "success(...)");
        return c11;
    }
}
