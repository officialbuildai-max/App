package ox;

import com.transsion.player.orplayer.g;
import kotlin.jvm.internal.Intrinsics;
import ox.b;
import ox.e;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f72319a = new c();

    private c() {
    }

    public final void a() {
        b.C0906b.a(b.f72314a.c(), false, 1, null);
        e.b.a(e.f72320a.b(), false, 1, null);
    }

    public final boolean b(String tag) {
        Intrinsics.h(tag, "tag");
        return b.f72314a.c().b(tag) || e.f72320a.b().b(tag);
    }

    public final boolean c(g gVar) {
        return b.f72314a.c().c(gVar) || e.f72320a.b().f(gVar);
    }

    public final boolean d() {
        return b.f72314a.c().isPlaying() || e.f72320a.b().isPlaying();
    }
}
