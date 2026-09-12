package yq;

import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.search.net.GoogleSuggestConfig;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f79175a = new h();

    private h() {
    }

    private final Map b() {
        return MapsKt.l(TuplesKt.a("hl", a()), TuplesKt.a("client", "android"));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:2:0x0000, B:4:0x0015, B:7:0x001c, B:8:0x0027, B:10:0x002f, B:11:0x0033, B:19:0x0023), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.transsion.search.net.GoogleSuggestConfig d(java.lang.String r3) {
        /*
            r2 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L21
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L21
            r0.<init>()     // Catch: java.lang.Throwable -> L21
            java.lang.Class<com.transsion.search.net.GoogleSuggestConfig> r1 = com.transsion.search.net.GoogleSuggestConfig.class
            java.lang.Object r3 = r0.fromJson(r3, r1)     // Catch: java.lang.Throwable -> L21
            com.transsion.search.net.GoogleSuggestConfig r3 = (com.transsion.search.net.GoogleSuggestConfig) r3     // Catch: java.lang.Throwable -> L21
            java.util.Map r0 = r3.getQueryParams()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L23
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L1c
            goto L23
        L1c:
            java.util.Map r0 = r3.getQueryParams()     // Catch: java.lang.Throwable -> L21
            goto L27
        L21:
            r3 = move-exception
            goto L3b
        L23:
            java.util.Map r0 = kotlin.collections.MapsKt.h()     // Catch: java.lang.Throwable -> L21
        L27:
            com.transsion.search.net.GoogleSuggestConfig r1 = new com.transsion.search.net.GoogleSuggestConfig     // Catch: java.lang.Throwable -> L21
            java.util.Map r3 = r3.getHeaders()     // Catch: java.lang.Throwable -> L21
            if (r3 != 0) goto L33
            java.util.Map r3 = kotlin.collections.MapsKt.h()     // Catch: java.lang.Throwable -> L21
        L33:
            r1.<init>(r3, r0)     // Catch: java.lang.Throwable -> L21
            java.lang.Object r3 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> L21
            goto L45
        L3b:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.ResultKt.a(r3)
            java.lang.Object r3 = kotlin.Result.m1185constructorimpl(r3)
        L45:
            java.lang.Throwable r0 = kotlin.Result.m1188exceptionOrNullimpl(r3)
            if (r0 != 0) goto L4c
            goto L5b
        L4c:
            com.transsion.search.net.GoogleSuggestConfig r3 = new com.transsion.search.net.GoogleSuggestConfig
            java.util.Map r0 = kotlin.collections.MapsKt.h()
            yq.h r1 = yq.h.f79175a
            java.util.Map r1 = r1.b()
            r3.<init>(r0, r1)
        L5b:
            com.transsion.search.net.GoogleSuggestConfig r3 = (com.transsion.search.net.GoogleSuggestConfig) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: yq.h.d(java.lang.String):com.transsion.search.net.GoogleSuggestConfig");
    }

    public final String a() {
        String g11 = yg.b.f79132a.g();
        if (g11 == null) {
            g11 = Locale.getDefault().getLanguage();
        }
        return StringsKt.q0(g11) ? "en" : g11;
    }

    public final GoogleSuggestConfig c() {
        Object obj;
        try {
            Result.Companion companion = Result.INSTANCE;
            ConfigBean c11 = sm.f.f75530c.a().c(ak.g.f714a.b() ? "google_suggest_api_config_for_showbox" : "google_suggest_api_config", false);
            obj = Result.m1185constructorimpl(c11 != null ? c11.getValue() : null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        String str = (String) (Result.m1191isFailureimpl(obj) ? null : obj);
        return (str == null || StringsKt.q0(str)) ? new GoogleSuggestConfig(MapsKt.h(), b()) : d(str);
    }
}
