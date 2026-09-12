package dy;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.transsion.ad.scene.d;
import ii.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f61583a = new a();

    private a() {
    }

    public final long a(String sceneId, int i11) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        Intrinsics.h(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = d.f42258a.b(sceneId);
            m1185constructorimpl = Result.m1185constructorimpl(Long.valueOf(((b11 == null || (jsonElement = b11.get("coordinatorInterval")) == null) ? i11 : jsonElement.getAsInt()) * 1000));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Long.valueOf(i11 * 1000);
        }
        return ((Number) m1185constructorimpl).longValue();
    }

    public final int b(String sceneId, int i11) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        Intrinsics.h(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = d.f42258a.b(sceneId);
            m1185constructorimpl = Result.m1185constructorimpl(Integer.valueOf((b11 == null || (jsonElement = b11.get("coordinatorPriority")) == null) ? i11 : jsonElement.getAsInt()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Integer.valueOf(i11);
        }
        return ((Number) m1185constructorimpl).intValue();
    }

    public final void c() {
        a.C0856a.f(lg.a.f68962a, "AdSceneCoordinator", "initCoordinatorAdScenes", false, 4, null);
        b.f65371a.i(MapsKt.l(TuplesKt.a("TrendingTwoLevelloftScene", new ii.a(b("TrendingTwoLevelloftScene", 0), a("TrendingTwoLevelloftScene", 0))), TuplesKt.a("MainDialogInterstitialScene", new ii.a(b("MainDialogInterstitialScene", 1), a("MainDialogInterstitialScene", 0))), TuplesKt.a("HotStartScene", new ii.a(b("HotStartScene", 1), a("HotStartScene", 0))), TuplesKt.a("LocalVideoBackInterstitialV2Scene", new ii.a(b("LocalVideoBackInterstitialV2Scene", 1), a("LocalVideoBackInterstitialV2Scene", 0))), TuplesKt.a("AppInstallTip", new ii.a(b("AppInstallTip", 2), a("AppInstallTip", 300))), TuplesKt.a("MemberActivateTip", new ii.a(b("MemberActivateTip", 3), a("MemberActivateTip", 300))), TuplesKt.a("MemberPUSH", new ii.a(b("MemberPUSH", 4), a("MemberPUSH", 0))), TuplesKt.a("StreamerIconAdScene", new ii.a(b("StreamerIconAdScene", 5), a("StreamerIconAdScene", 300)))));
    }
}
