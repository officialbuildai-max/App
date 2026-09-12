package com.transsion.ad.scene;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ti.p;

/* loaded from: classes5.dex */
public final class AdSceneDisplayLimitManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AdSceneDisplayLimitManager f42253a = new AdSceneDisplayLimitManager();

    private AdSceneDisplayLimitManager() {
    }

    public final Object a(String str, Continuation continuation) {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).v0().b(str, p.f76389a.c(), System.currentTimeMillis(), r0.f(str) * 1000, a.f42255a.d(str), continuation);
    }

    public final void b(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        k.d(o0.a(y0.b()), null, null, new AdSceneDisplayLimitManager$recordDisplay$1(sceneId, null), 3, null);
    }
}
