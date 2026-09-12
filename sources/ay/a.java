package ay;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sm.f;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16253a = new a();

    private a() {
    }

    private final JSONObject a() {
        Object m1185constructorimpl;
        ConfigBean c11;
        String value;
        try {
            Result.Companion companion = Result.INSTANCE;
            c11 = f.f75530c.a().c("mb_ad_config", true);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (c11 != null && (value = c11.getValue()) != null) {
            m1185constructorimpl = Result.m1185constructorimpl(new JSONObject(value));
            return (JSONObject) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
        }
        return null;
    }

    public final String b() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject a11 = a();
            m1185constructorimpl = Result.m1185constructorimpl(a11 != null ? a11.optString("trendingSceneId", "") : null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        String str = (String) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
        return Intrinsics.c(str, "TrendingScene_1") ? "TrendingScene_1" : Intrinsics.c(str, "TrendingScene_2") ? "TrendingScene_2" : "TrendingScene";
    }
}
