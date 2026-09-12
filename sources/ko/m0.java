package ko;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f67107a = new m0();

    /* renamed from: b, reason: collision with root package name */
    private static final String f67108b = "TnPlayerPool";

    private m0() {
    }

    public final boolean a(com.transsion.player.orplayer.g gVar) {
        return true;
    }

    public final d0 b(Context context) {
        Intrinsics.h(context, "context");
        return d0.f67047m.a();
    }

    public final co.h c(Context context) {
        Intrinsics.h(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return new co.h(applicationContext, null, false, 6, null);
    }

    public final co.h d(Context context, co.m config) {
        Intrinsics.h(context, "context");
        Intrinsics.h(config, "config");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return new co.h(applicationContext, config, false, 4, null);
    }
}
