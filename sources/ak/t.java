package ak;

import com.transsion.baselib.utils.PlayMode;
import com.transsion.mb.config.manager.ConfigBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f727a = new t();

    private t() {
    }

    private final PlayMode a() {
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("change_play_mode_by_debug", "");
        for (PlayMode playMode : PlayMode.values()) {
            if (Intrinsics.c(playMode.getValue(), string)) {
                return playMode;
            }
        }
        PlayMode playMode2 = PlayMode.DOWNLOAD;
        ConfigBean c11 = sm.f.f75530c.a().c("play_mode", true);
        if (c11 == null) {
            return playMode2;
        }
        String value = c11.getValue();
        return (!Intrinsics.c(value, "1") && Intrinsics.c(value, "2")) ? PlayMode.STREAM : playMode2;
    }

    public final boolean b() {
        return a() == PlayMode.STREAM;
    }

    public final void c(PlayMode playMode) {
        Intrinsics.h(playMode, "playMode");
        com.transsion.baselib.report.launch.b.f43424a.b().putString("change_play_mode_by_debug", playMode.getValue());
    }
}
