package com.transsion.search.speech;

import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import java.util.LinkedHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f52281a = new q();

    /* renamed from: b, reason: collision with root package name */
    private static String f52282b;

    private q() {
    }

    public final void a() {
        com.transsion.baselib.helper.a.f43316a.b("sr_dialog_cancel_btn", MapsKt.h());
    }

    public final void b() {
        com.transsion.baselib.helper.a.f43316a.b("sr_mic_btn", MapsKt.h());
    }

    public final void c(String msg, int i11) {
        Intrinsics.h(msg, "msg");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventConstants.KEY_ACTION, "fail");
        linkedHashMap.put(NotificationCompat.CATEGORY_MESSAGE, msg);
        linkedHashMap.put("code", String.valueOf(i11));
        linkedHashMap.put(TrackingKey.TRIGGER_ID, String.valueOf(f52282b));
        com.transsion.baselib.helper.a.f43316a.a("sr_dialog_sr", linkedHashMap);
        f52282b = null;
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventConstants.KEY_ACTION, "trigger");
        String a11 = d.f52266a.a(10);
        f52282b = a11;
        linkedHashMap.put(TrackingKey.TRIGGER_ID, String.valueOf(a11));
        com.transsion.baselib.helper.a.f43316a.a("sr_dialog_sr", linkedHashMap);
    }

    public final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventConstants.KEY_ACTION, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS);
        linkedHashMap.put(TrackingKey.TRIGGER_ID, String.valueOf(f52282b));
        com.transsion.baselib.helper.a.f43316a.a("sr_dialog_sr", linkedHashMap);
        f52282b = null;
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(EventConstants.KEY_ACTION, "strategy");
        linkedHashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, "two");
        linkedHashMap.put("model", com.blankj.utilcode.util.k.a());
        com.transsion.baselib.helper.a.f43316a.b("sr_dialog_sr", MapsKt.h());
    }
}
