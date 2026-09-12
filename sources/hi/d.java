package hi;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f64592a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static String f64593b = "";

    private d() {
    }

    public final String a() {
        return f64593b;
    }

    public final boolean b() {
        if (!TextUtils.isEmpty(f64593b)) {
            return true;
        }
        oi.a.f71145a.n("ad_int", "HotSceneManager --> loadHotSplashAd() --> 没有配置热启动场景ID，拒绝加载广告", 6, false);
        return false;
    }

    public final void c(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        f64593b = sceneId;
    }
}
