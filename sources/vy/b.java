package vy;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f77602a = new b();

    private b() {
    }

    public final int a() {
        Object m1185constructorimpl;
        String value;
        Integer v11;
        try {
            Result.Companion companion = Result.INSTANCE;
            ConfigBean c11 = sm.f.f75530c.a().c("login_method_config", true);
            m1185constructorimpl = Result.m1185constructorimpl(Integer.valueOf((c11 == null || (value = c11.getValue()) == null || (v11 = StringsKt.v(value)) == null) ? 0 : v11.intValue()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = 0;
        }
        return ((Number) m1185constructorimpl).intValue();
    }

    public final boolean b() {
        return a() == 1;
    }
}
