package androidx.work.impl;

import android.content.Context;
import androidx.work.R$bool;
import androidx.work.impl.WorkDatabase;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class WorkManagerImplExtKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List b(Context context, androidx.work.b bVar, j4.c cVar, WorkDatabase workDatabase, i4.n nVar, s sVar) {
        u c11 = x.c(context, workDatabase, bVar);
        Intrinsics.g(c11, "createBestAvailableBackgroundScheduler(...)");
        return CollectionsKt.o(c11, new androidx.work.impl.background.greedy.a(context, bVar, nVar, sVar, new d1(sVar, cVar), cVar));
    }

    public static final f1 c(Context context, androidx.work.b configuration) {
        Intrinsics.h(context, "context");
        Intrinsics.h(configuration, "configuration");
        return e(context, configuration, null, null, null, null, null, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
    }

    public static final f1 d(Context context, androidx.work.b configuration, j4.c workTaskExecutor, WorkDatabase workDatabase, i4.n trackers, s processor, Function6 schedulersCreator) {
        Intrinsics.h(context, "context");
        Intrinsics.h(configuration, "configuration");
        Intrinsics.h(workTaskExecutor, "workTaskExecutor");
        Intrinsics.h(workDatabase, "workDatabase");
        Intrinsics.h(trackers, "trackers");
        Intrinsics.h(processor, "processor");
        Intrinsics.h(schedulersCreator, "schedulersCreator");
        return new f1(context.getApplicationContext(), configuration, workTaskExecutor, workDatabase, (List) schedulersCreator.invoke(context, configuration, workTaskExecutor, workDatabase, trackers, processor), processor, trackers);
    }

    public static /* synthetic */ f1 e(Context context, androidx.work.b bVar, j4.c cVar, WorkDatabase workDatabase, i4.n nVar, s sVar, Function6 function6, int i11, Object obj) {
        WorkDatabase workDatabase2;
        i4.n nVar2;
        j4.c dVar = (i11 & 4) != 0 ? new j4.d(bVar.m()) : cVar;
        if ((i11 & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            j4.a c11 = dVar.c();
            Intrinsics.g(c11, "getSerialTaskExecutor(...)");
            workDatabase2 = companion.b(applicationContext, c11, bVar.a(), context.getResources().getBoolean(R$bool.workmanager_test_configuration));
        } else {
            workDatabase2 = workDatabase;
        }
        if ((i11 & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.g(applicationContext2, "getApplicationContext(...)");
            nVar2 = new i4.n(applicationContext2, dVar, null, null, null, null, 60, null);
        } else {
            nVar2 = nVar;
        }
        return d(context, bVar, dVar, workDatabase2, nVar2, (i11 & 32) != 0 ? new s(context.getApplicationContext(), bVar, dVar, workDatabase2) : sVar, (i11 & 64) != 0 ? WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE : function6);
    }

    public static final kotlinx.coroutines.n0 f(j4.c taskExecutor) {
        Intrinsics.h(taskExecutor, "taskExecutor");
        kotlinx.coroutines.i0 b11 = taskExecutor.b();
        Intrinsics.g(b11, "getTaskCoroutineDispatcher(...)");
        return kotlinx.coroutines.o0.a(b11);
    }
}
