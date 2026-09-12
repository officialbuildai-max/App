package com.transsion.startup.work;

import ak.a0;
import android.content.Context;
import android.os.Build;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import androidx.work.b0;
import androidx.work.d;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sm.f;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f54599a = new a();

    private a() {
    }

    public final void a(Context context) {
        Object m1185constructorimpl;
        String value;
        Boolean m12;
        Intrinsics.h(context, "context");
        ConfigBean d11 = f.d(f.f75530c.a(), "key_report_request_off", false, 2, null);
        if ((d11 == null || (value = d11.getValue()) == null || (m12 = StringsKt.m1(value)) == null) ? false : m12.booleanValue()) {
            return;
        }
        if (!a0.f702a.a(context)) {
            lg.a.f68962a.x("NetworkDataSourceManager", "Skip network data source work because storage or WorkManager is unavailable", false);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (Build.VERSION.SDK_INT >= 24) {
                context = context.createDeviceProtectedStorageContext();
            }
            d a11 = new d.a().b(NetworkType.CONNECTED).a();
            TimeUnit timeUnit = TimeUnit.HOURS;
            b0 b0Var = (b0) ((b0.a) ((b0.a) ((b0.a) new b0.a(NetworkDataSourceWorker.class, 1L, timeUnit).i(a11)).a("NetworkDataSourceWorker")).k(1L, timeUnit)).b();
            WorkManager.a aVar = WorkManager.f15481a;
            Intrinsics.e(context);
            m1185constructorimpl = Result.m1185constructorimpl(aVar.a(context).e("NetworkDataSourceWorker", ExistingPeriodicWorkPolicy.REPLACE, b0Var));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a0.f702a.g(m1188exceptionOrNullimpl);
            lg.a.f68962a.x("NetworkDataSourceManager", "Failed to schedule network data source work: " + m1188exceptionOrNullimpl.getMessage(), false);
        }
    }
}
