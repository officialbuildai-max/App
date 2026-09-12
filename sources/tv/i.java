package tv;

import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final a f76515a;

    /* loaded from: classes6.dex */
    public interface a {
        String d();

        String e();

        String f();
    }

    public i(a host) {
        Intrinsics.h(host, "host");
        this.f76515a = host;
    }

    public final void a(String moduleName, UGCVideo uGCVideo, Boolean bool, String str, Integer num) {
        Intrinsics.h(moduleName, "moduleName");
        if (uGCVideo == null) {
            return;
        }
        com.transsion.ugcvideodetail.hepler.h.f56490a.a("/ugc_video/immersive_detail", moduleName, uGCVideo, str, this.f76515a.d(), this.f76515a.f(), this.f76515a.e(), bool, num);
    }
}
