package com.transsion.push.helper;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f50918a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f50919b = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Integer c11;
            c11 = i.c();
            return c11;
        }
    });

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer c() {
        String value;
        ConfigBean c11 = sm.f.f75530c.a().c("push_remind_notification_time", true);
        Integer v11 = (c11 == null || (value = c11.getValue()) == null) ? null : StringsKt.v(value);
        a.C0856a.f(lg.a.f68962a, "PushConfigHelper", "remindTime:" + v11, false, 4, null);
        return v11;
    }

    public final Integer b() {
        return (Integer) f50919b.getValue();
    }
}
