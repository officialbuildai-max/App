package com.transsion.postdetail.util;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class UGCShortTVFloatManager extends com.transsion.videofloat.manager.b {

    /* renamed from: b, reason: collision with root package name */
    public static final UGCShortTVFloatManager f50207b = new UGCShortTVFloatManager();

    /* renamed from: c, reason: collision with root package name */
    private static final os.a f50208c = (os.a) zg.c.f79537e.a().h(os.a.class);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f50209d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g g11;
            g11 = UGCShortTVFloatManager.g();
            return g11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f50210e = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UGCVideoDetailPlayDao s11;
            s11 = UGCShortTVFloatManager.s();
            return s11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f50211f = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ShortTVPlayDao r11;
            r11 = UGCShortTVFloatManager.r();
            return r11;
        }
    });

    private UGCShortTVFloatManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g g() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao i() {
        return (UGCVideoDetailPlayDao) f50210e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(px.a aVar) {
        UGCVideo v11;
        f50207b.j();
        if (aVar != null && (v11 = aVar.v()) != null) {
            pv.b.b(v11, null, 1, null);
        }
        return Unit.f67184a;
    }

    private final void o(px.a aVar, Function0 function0) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new UGCShortTVFloatManager$saveHistoryInner$1(aVar, function0, null), 3, null);
    }

    static /* synthetic */ void p(UGCShortTVFloatManager uGCShortTVFloatManager, px.a aVar, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        uGCShortTVFloatManager.o(aVar, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao r() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao s() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).C1();
    }

    public final String h(String ugcVideoId) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        return "SHORT_TV" + ugcVideoId;
    }

    public void j() {
        a().clear();
    }

    public void k(final px.a aVar) {
        o(aVar, new Function0() { // from class: com.transsion.postdetail.util.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit l11;
                l11 = UGCShortTVFloatManager.l(px.a.this);
                return l11;
            }
        });
    }

    public boolean m(px.a aVar) {
        ShorttvModel.UGCVideo uGCVideo;
        Iterator it = a().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            ShorttvModel.UGCVideo uGCVideo2 = (ShorttvModel.UGCVideo) it.next();
            if (!(uGCVideo2 instanceof ShorttvModel.UGCVideo)) {
                uGCVideo2 = null;
            }
            if (Intrinsics.c(uGCVideo2 != null ? Integer.valueOf(uGCVideo2.getEp()) : null, aVar != null ? Integer.valueOf(aVar.c()) : null)) {
                break;
            }
            i11++;
        }
        int size = a().size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i12 = 0;
                uGCVideo = null;
                break;
            }
            uGCVideo = (ShorttvModel.UGCVideo) a().get(i12);
            if (i12 > i11 && (uGCVideo instanceof ShorttvModel.UGCVideo)) {
                break;
            }
            i12++;
        }
        lg.a.f68962a.c("VideoFloat", "shorttv-----playNext, size:" + a().size() + ", ep:" + (aVar != null ? Integer.valueOf(aVar.c()) : null) + " nextEp:" + (uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null), true);
        if (uGCVideo == null) {
            return false;
        }
        int i13 = i12 + 5;
        if (a().size() > i13) {
            ShorttvModel.UGCVideo uGCVideo3 = (ShorttvModel.UGCVideo) a().get(i13);
            if (uGCVideo3 instanceof ShorttvModel.UGCVideo) {
                uGCVideo3.isDataNotComplete();
            }
        }
        if (aVar != null) {
            aVar.z(uGCVideo.getEp());
            aVar.F(0L);
            com.transsion.player.orplayer.g f11 = aVar.f();
            String playUrl = uGCVideo.getPlayUrl();
            if (playUrl == null) {
                playUrl = "";
            }
            f11.seekTo(playUrl, 0L);
            aVar.f().play();
        }
        return true;
    }

    public void n(px.a aVar) {
        p(this, aVar, null, 2, null);
    }

    public void q(List list) {
        Intrinsics.h(list, "list");
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "shorttv-----setPlayList:" + list.size(), false, 4, null);
        a().clear();
        a().addAll(list);
    }
}
