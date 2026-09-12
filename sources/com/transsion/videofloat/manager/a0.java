package com.transsion.videofloat.manager;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f58056a = new a0();

    /* renamed from: b, reason: collision with root package name */
    private static final Map f58057b = new LinkedHashMap();

    private a0() {
    }

    public final void a(String tag, com.transsion.player.orplayer.g player) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(player, "player");
        a.C0856a.r(lg.a.f68962a, "VideoFloat", new String[]{"PlayerView-----addPlayerView," + tag}, false, 4, null);
        f58057b.put(tag, player);
    }

    public final com.transsion.player.orplayer.g b(String tag) {
        Intrinsics.h(tag, "tag");
        Map map = f58057b;
        com.transsion.player.orplayer.g gVar = (com.transsion.player.orplayer.g) map.remove(tag);
        if (gVar == null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                com.transsion.player.orplayer.g gVar2 = (com.transsion.player.orplayer.g) entry.getValue();
                lg.a.f68962a.x("VideoFloat", "PlayerView---player null clear. release, tag:" + tag + ", curTag:" + str, true);
                gVar2.release();
            }
            f58057b.clear();
        }
        return gVar;
    }

    public final boolean c(com.transsion.player.orplayer.g gVar) {
        for (com.transsion.player.orplayer.g gVar2 : f58057b.values()) {
            if (Intrinsics.c(gVar2, gVar)) {
                lg.a.f68962a.c("VideoFloat", "hasPlayerCache，true player:" + gVar, true);
                return true;
            }
            lg.a.f68962a.c("VideoFloat", "hasPlayerCache，false player:" + gVar + ", cachePayer:" + gVar2, true);
        }
        return false;
    }

    public final void d() {
        f58057b.clear();
    }

    public final void e(String tag) {
        Intrinsics.h(tag, "tag");
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "PlayerView-----removePlayerView", false, 4, null);
        f58057b.remove(tag);
    }
}
