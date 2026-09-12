package com.transsnet.downloader.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PowerManager;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.dialog.RequestAuthorizationDialog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import sm.f;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f60047a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f60048b;

    private d() {
    }

    public static /* synthetic */ void f(d dVar, Context context, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        dVar.e(context, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Ref.BooleanRef booleanRef, Context context, String str, Function0 function0) {
        booleanRef.element = true;
        f60047a.l(context, str, function0);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.BooleanRef booleanRef, Context context, DialogInterface dialogInterface) {
        if (booleanRef.element) {
            return;
        }
        bf.c.f16548a.c(context);
    }

    public static /* synthetic */ void m(d dVar, Context context, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        dVar.l(context, str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f67184a;
    }

    public final void d() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        bVar.b().putLong("key_showed_times", bVar.b().getLong("key_showed_times", 0L) + 1);
        bVar.b().putLong("key_show_last_time", System.currentTimeMillis());
    }

    public final void e(final Context context, final String pageFrom, final Function0 function0) {
        String value;
        Integer v11;
        String value2;
        Long x10;
        Intrinsics.h(context, "context");
        Intrinsics.h(pageFrom, "pageFrom");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        long j11 = 0;
        long j12 = bVar.b().getLong("key_show_last_time", 0L);
        long j13 = bVar.b().getLong("key_showed_times", 0L);
        f.a aVar = sm.f.f75530c;
        ConfigBean c11 = aVar.a().c("key_total_show_times", false);
        long longValue = (c11 == null || (value2 = c11.getValue()) == null || (x10 = StringsKt.x(value2)) == null) ? 3L : x10.longValue();
        long j14 = longValue > 0 ? longValue : 3L;
        ConfigBean c12 = aVar.a().c("sb_battery_interval_day", false);
        int intValue = (c12 == null || (value = c12.getValue()) == null || (v11 = StringsKt.v(value)) == null) ? 10 : v11.intValue();
        int i11 = intValue > 0 ? intValue : 10;
        boolean f11 = com.blankj.utilcode.util.c0.f(j12);
        if (TimeUtilKt.c() - TimeUtilKt.d(j12) > i11) {
            bVar.b().putLong("key_showed_times", 0L);
        } else {
            j11 = j13;
        }
        if (f11 || j14 <= j11) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (j(context)) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        RequestAuthorizationDialog a11 = RequestAuthorizationDialog.INSTANCE.a();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        a11.t0(new Function0() { // from class: com.transsnet.downloader.util.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g11;
                g11 = d.g(Ref.BooleanRef.this, context, pageFrom, function0);
                return g11;
            }
        });
        Dialog dialog = a11.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        a11.j0(new DialogInterface.OnDismissListener() { // from class: com.transsnet.downloader.util.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                d.h(Ref.BooleanRef.this, context, dialogInterface);
            }
        });
        if (bf.c.f16548a.b(a11, "authorization_dialog")) {
            a11.k0(context, "authorization_dialog");
        }
    }

    public final void i(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        Activity b11 = com.blankj.utilcode.util.a.b();
        if (b11 == null || b11.isFinishing() || b11.isDestroyed()) {
            return;
        }
        f(f60047a, b11, pageFrom, null, 4, null);
    }

    public final boolean j(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        boolean isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(Utils.a().getPackageName());
        if (!f60048b) {
            HashMap hashMap = new HashMap();
            hashMap.put("battery_opt", String.valueOf(isIgnoringBatteryOptimizations));
            hj.i.f64628a.s("battery_opt", "app_perf", hashMap);
            f60048b = true;
        }
        return isIgnoringBatteryOptimizations;
    }

    public final void k(Context context) {
        Intrinsics.h(context, "context");
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            context.startActivity(intent);
            HashMap hashMap = new HashMap();
            hashMap.put(EventConstants.KEY_ACTION, "system_battery_page_show");
            hj.i.f64628a.D("download_authorization", hashMap);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void l(Context context, String pageFrom, final Function0 function0) {
        Intrinsics.h(context, "context");
        Intrinsics.h(pageFrom, "pageFrom");
        try {
            ActivityPermissionUtil.f43427a.d("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "android.settings.APPLICATION_DETAILS_SETTINGS", 11101, new Function0() { // from class: com.transsnet.downloader.util.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit n11;
                    n11 = d.n(Function0.this);
                    return n11;
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put(EventConstants.KEY_ACTION, "system_dialog_show");
            hashMap.put(WebConstants.PAGE_FROM, pageFrom);
            hj.i.f64628a.D("download_authorization", hashMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
