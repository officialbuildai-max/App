package com.cloud.hisavana.sdk;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final class k5 {

    /* renamed from: a, reason: collision with root package name */
    public static final k5 f22688a = new k5();

    /* renamed from: b, reason: collision with root package name */
    private static Integer f22689b;

    /* renamed from: c, reason: collision with root package name */
    private static Integer f22690c;

    private k5() {
    }

    public static final void b(Integer num, Integer num2) {
        if (num != null) {
            f22689b = num;
            j7.a.e().p("show_data_sync_time_interval", num.intValue());
        }
        if (num2 != null) {
            f22690c = num2;
            j7.a.e().p("click_data_sync_time_interval", num2.intValue());
        }
        e4.b().i("AttrDataManager", "showDataSyncTimeInterval = " + num + "，clickDataSyncTimeInterval = " + num2);
        y.f23172a.h();
    }

    public final int a() {
        if (f22690c == null) {
            f22690c = Integer.valueOf(j7.a.e().g("click_data_sync_time_interval", -1));
        }
        Integer num = f22690c;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final void c(Function1 function1, Function0 function0, Function0 function02) {
        int a11 = a();
        e4.b().i("AttrDataManager", "clickDataSyncAction timeInterval = " + a11);
        if (a11 > 0) {
            if (function1 != null) {
                function1.invoke(Integer.valueOf(a11));
            }
        } else if (a11 == 0) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (function02 != null) {
            function02.invoke();
        }
    }

    public final int d() {
        if (f22689b == null) {
            f22689b = Integer.valueOf(j7.a.e().g("show_data_sync_time_interval", -1));
        }
        Integer num = f22689b;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
