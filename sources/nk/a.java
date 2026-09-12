package nk;

import com.cloud.tmc.integration.event.EventConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f70601a = new a();

    private a() {
    }

    private final void a(boolean z10, mk.a aVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(EventConstants.KEY_SOURCE, aVar.j().getValue());
        hashMap.put("module_name", str);
        hashMap.put(TrackingKey.GAME_NAME, aVar.d());
        String g11 = aVar.g();
        if (g11 != null) {
            hashMap.put("game_id", g11);
        }
        if (str2 != null) {
            hashMap.put("action_type", str2);
        }
        String h11 = aVar.h();
        if (h11 != null) {
            if (z10) {
                com.transsion.baselib.helper.a.f43316a.b(h11, hashMap);
            } else {
                com.transsion.baselib.helper.a.f43316a.a(h11, hashMap);
            }
        }
    }

    static /* synthetic */ void b(a aVar, boolean z10, mk.a aVar2, String str, String str2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        aVar.a(z10, aVar2, str, str2);
    }

    public final void c(mk.a info, String pageStyle) {
        Intrinsics.h(info, "info");
        Intrinsics.h(pageStyle, "pageStyle");
        b(this, false, info, pageStyle, null, 8, null);
    }

    public final void d(mk.a info, String pageStyle) {
        Intrinsics.h(info, "info");
        Intrinsics.h(pageStyle, "pageStyle");
        b(this, true, info, pageStyle, null, 8, null);
    }

    public final void e(mk.a info, String pageStyle, String actionType) {
        Intrinsics.h(info, "info");
        Intrinsics.h(pageStyle, "pageStyle");
        Intrinsics.h(actionType, "actionType");
        a(true, info, pageStyle, actionType);
    }
}
