package ko;

import com.transsion.player.mediasession.MediaBrowserCompatHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: c, reason: collision with root package name */
    private static Function0 f67093c;

    /* renamed from: d, reason: collision with root package name */
    private static Function0 f67094d;

    /* renamed from: e, reason: collision with root package name */
    private static Function0 f67095e;

    /* renamed from: f, reason: collision with root package name */
    private static Function0 f67096f;

    /* renamed from: k, reason: collision with root package name */
    private static Function0 f67101k;

    /* renamed from: l, reason: collision with root package name */
    private static volatile o0 f67102l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile com.transsion.player.orplayer.g f67103m;

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f67091a = new l0();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f67092b = LazyKt.b(new Function0() { // from class: ko.g0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            f0 H;
            H = l0.H();
            return H;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private static final Lazy f67097g = LazyKt.b(new Function0() { // from class: ko.h0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean n11;
            n11 = l0.n();
            return Boolean.valueOf(n11);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f67098h = LazyKt.b(new Function0() { // from class: ko.i0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean q11;
            q11 = l0.q();
            return Boolean.valueOf(q11);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f67099i = LazyKt.b(new Function0() { // from class: ko.j0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int k11;
            k11 = l0.k();
            return Integer.valueOf(k11);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f67100j = LazyKt.b(new Function0() { // from class: ko.k0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean g11;
            g11 = l0.g();
            return Boolean.valueOf(g11);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    private static final CopyOnWriteArrayList f67104n = new CopyOnWriteArrayList();

    /* renamed from: o, reason: collision with root package name */
    private static final CopyOnWriteArrayList f67105o = new CopyOnWriteArrayList();

    private l0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f0 H() {
        return new f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g() {
        Function0 function0 = f67095e;
        boolean booleanValue = function0 != null ? ((Boolean) function0.invoke()).booleanValue() : false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isMultiplePlayer:");
        sb2.append(booleanValue);
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k() {
        Function0 function0 = f67094d;
        int intValue = function0 != null ? ((Number) function0.invoke()).intValue() : 5000;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isMultiplePlayer:");
        sb2.append(intValue);
        return intValue;
    }

    private final f0 l() {
        return (f0) f67092b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n() {
        Function0 function0 = f67096f;
        boolean booleanValue = function0 != null ? ((Boolean) function0.invoke()).booleanValue() : false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isASyncPlayer:");
        sb2.append(booleanValue);
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q() {
        Function0 function0 = f67093c;
        boolean booleanValue = function0 != null ? ((Boolean) function0.invoke()).booleanValue() : true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isMultiplePlayer:");
        sb2.append(booleanValue);
        return booleanValue;
    }

    private final void t(com.transsion.player.orplayer.g gVar, com.transsion.player.orplayer.g gVar2) {
        Iterator it = f67105o.iterator();
        Intrinsics.g(it, "iterator(...)");
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            throw null;
        }
    }

    private final void w(com.transsion.player.orplayer.g gVar) {
        Iterator it = f67104n.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.c(((WeakReference) it.next()).get(), gVar)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            f67104n.remove(i11);
        }
    }

    public final void A(o0 tnPlayer) {
        Intrinsics.h(tnPlayer, "tnPlayer");
        if (o() || Intrinsics.c(f67102l, tnPlayer)) {
            return;
        }
        synchronized (this) {
            try {
                if (!Intrinsics.c(f67102l, tnPlayer)) {
                    oo.e.f71197a.a("TnPlayer", "换boss啦:" + f67102l + "  to " + tnPlayer, true);
                    o0 o0Var = f67102l;
                    if (o0Var != null) {
                        o0Var.d(true);
                    }
                    tnPlayer.d(false);
                    o0 o0Var2 = f67102l;
                    if (o0Var2 != null) {
                        o0Var2.f(null);
                    }
                    tnPlayer.f(f67091a.l());
                    f67102l = tnPlayer;
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void B(com.transsion.player.orplayer.g orPlayer, ao.e eVar) {
        Intrinsics.h(orPlayer, "orPlayer");
    }

    public final void C(Function0 function0) {
        f67096f = function0;
    }

    public final void D(Function0 function0) {
        f67095e = function0;
    }

    public final void E(Function0 function0) {
        f67094d = function0;
    }

    public final void F(Function0 function0) {
        f67093c = function0;
    }

    public final void G(Function0 function0) {
        f67101k = function0;
    }

    public final com.transsion.player.orplayer.g f(String mediaId) {
        String str;
        com.transsion.player.orplayer.g gVar;
        ao.e currentMediaSource;
        Intrinsics.h(mediaId, "mediaId");
        Iterator it = f67104n.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                return null;
            }
            gVar = (com.transsion.player.orplayer.g) ((WeakReference) it.next()).get();
            if (gVar != null && (currentMediaSource = gVar.currentMediaSource()) != null) {
                str = currentMediaSource.e();
            }
        } while (!Intrinsics.c(str, mediaId));
        return gVar;
    }

    public final com.transsion.player.orplayer.g h() {
        return f67103m;
    }

    public final boolean i() {
        return ((Boolean) f67100j.getValue()).booleanValue();
    }

    public final int j() {
        return ((Number) f67099i.getValue()).intValue();
    }

    public final boolean m() {
        return ((Boolean) f67097g.getValue()).booleanValue();
    }

    public final boolean o() {
        return ((Boolean) f67098h.getValue()).booleanValue();
    }

    public final Function0 p() {
        return f67093c;
    }

    public final int r() {
        Function0 function0 = f67101k;
        if (function0 != null) {
            return ((Number) function0.invoke()).intValue();
        }
        return 1;
    }

    public final com.transsion.player.orplayer.g s() {
        com.transsion.player.orplayer.g f0Var = o() ? new f0() : new o0();
        f67104n.add(new WeakReference(f0Var));
        return f0Var;
    }

    public final void u(com.transsion.player.orplayer.g orPlayer, ao.e eVar) {
        Intrinsics.h(orPlayer, "orPlayer");
    }

    public final void v(com.transsion.player.orplayer.g orPlayer, ao.e eVar) {
        Intrinsics.h(orPlayer, "orPlayer");
    }

    public final void x(com.transsion.player.orplayer.g orPlayer) {
        Intrinsics.h(orPlayer, "orPlayer");
        if (Intrinsics.c(f67103m, orPlayer)) {
            f67103m = null;
            t(null, orPlayer);
            oo.e.b(oo.e.f71197a, "TnPlayerManager", "releaseFocus  orPlayer:" + orPlayer, false, 4, null);
        }
        w(orPlayer);
    }

    public final void y(String mediaId) {
        Intrinsics.h(mediaId, "mediaId");
        MediaBrowserCompatHelper.f48435h.a().v(mediaId);
    }

    public final void z(com.transsion.player.orplayer.g orPlayer, String reason) {
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(reason, "reason");
        if (Intrinsics.c(f67103m, orPlayer)) {
            return;
        }
        com.transsion.player.orplayer.g gVar = f67103m;
        if (gVar != null && gVar.isPlaying()) {
            gVar.pause();
        }
        f67103m = orPlayer;
        t(gVar, orPlayer);
        oo.e.b(oo.e.f71197a, "TnPlayerManager", "requestFocus  orPlayer:" + orPlayer + "  reason:" + reason, false, 4, null);
    }
}
