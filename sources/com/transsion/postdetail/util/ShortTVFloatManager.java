package com.transsion.postdetail.util;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInfoEpisodeList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public final class ShortTVFloatManager extends com.transsion.videofloat.manager.b {

    /* renamed from: b, reason: collision with root package name */
    public static final ShortTVFloatManager f50203b = new ShortTVFloatManager();

    /* renamed from: c, reason: collision with root package name */
    private static final os.a f50204c = (os.a) zg.c.f79537e.a().h(os.a.class);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f50205d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g i11;
            i11 = ShortTVFloatManager.i();
            return i11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f50206e = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ShortTVPlayDao x10;
            x10 = ShortTVFloatManager.x();
            return x10;
        }
    });

    private ShortTVFloatManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g i() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.g j() {
        return (com.transsnet.downloader.manager.g) f50205d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTVPlayDao l() {
        return (ShortTVPlayDao) f50206e.getValue();
    }

    private final void m(String str, int i11, Function1 function1) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ShortTVFloatManager$getShortTvEpisodeList$1(i11, str, function1, null), 3, null);
    }

    private final void n(px.a aVar, List list) {
        Object obj;
        Map a11;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ShortTVItem shortTVItem = (ShortTVItem) it.next();
                Iterator it2 = f50203b.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    js.k kVar = (js.k) obj;
                    if ((kVar instanceof js.e) && ((js.e) kVar).c() == shortTVItem.getEp()) {
                        break;
                    }
                }
                js.k kVar2 = (js.k) obj;
                if (kVar2 != null && (kVar2 instanceof js.e)) {
                    js.e eVar = (js.e) kVar2;
                    ShortTVItem d11 = eVar.d();
                    String id2 = d11 != null ? d11.getId() : null;
                    if (id2 != null && id2.length() != 0) {
                        shortTVItem.setId(id2);
                    }
                    a.C0856a.f(lg.a.f68962a, "VideoFloat", "handleNewData----设置播放数据  ep:" + shortTVItem.getEp(), false, 4, null);
                    eVar.h(shortTVItem);
                }
                ao.e mediaSource = shortTVItem.toMediaSource();
                if (mediaSource != null) {
                    com.transsion.player.orplayer.g f11 = aVar.f();
                    lo.f fVar = f11 instanceof lo.f ? (lo.f) f11 : null;
                    boolean containsKey = (fVar == null || (a11 = fVar.a()) == null) ? false : a11.containsKey(mediaSource.e());
                    a.C0856a.f(lg.a.f68962a, "VideoFloat", "addDataSource----updateShortTvInfoList  ep:" + shortTVItem.getEp() + ",inPlayerList:" + containsKey, false, 4, null);
                    if (!containsKey) {
                        aVar.f().addDataSource(mediaSource);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(px.a aVar) {
        f50203b.o();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("oneroom://com.community.oneroom?type=/shorts/detail&id=" + (aVar != null ? aVar.r() : null) + "&ep=" + (aVar != null ? Integer.valueOf(aVar.c()) : null) + "&ms=" + (aVar != null ? Long.valueOf(aVar.n()) : null) + "&channel=video_float"));
        intent.setFlags(ASTNode.DEOP);
        Utils.a().startActivity(intent);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(px.a aVar, ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
        if (shortTvInfoEpisodeList != null) {
            f50203b.n(aVar, shortTvInfoEpisodeList.getItems());
        }
        return Unit.f67184a;
    }

    private final void u(px.a aVar, Function0 function0) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ShortTVFloatManager$saveHistoryInner$1(aVar, function0, null), 3, null);
    }

    static /* synthetic */ void v(ShortTVFloatManager shortTVFloatManager, px.a aVar, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        shortTVFloatManager.u(aVar, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao x() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).x1();
    }

    public final String k(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        return "SHORT_TV" + subjectId;
    }

    public void o() {
        a().clear();
    }

    public void p(final px.a aVar) {
        u(aVar, new Function0() { // from class: com.transsion.postdetail.util.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit q11;
                q11 = ShortTVFloatManager.q(px.a.this);
                return q11;
            }
        });
    }

    public boolean r(final px.a aVar) {
        js.k kVar;
        String str;
        Iterator it = a().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            js.k kVar2 = (js.k) it.next();
            js.e eVar = kVar2 instanceof js.e ? (js.e) kVar2 : null;
            if (Intrinsics.c(eVar != null ? Integer.valueOf(eVar.c()) : null, aVar != null ? Integer.valueOf(aVar.c()) : null)) {
                break;
            }
            i11++;
        }
        int size = a().size();
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                i12 = 0;
                kVar = null;
                break;
            }
            kVar = (js.k) a().get(i12);
            if (i12 > i11 && (kVar instanceof js.e)) {
                break;
            }
            i12++;
        }
        js.e eVar2 = (js.e) kVar;
        lg.a.f68962a.c("VideoFloat", "shorttv-----playNext, size:" + a().size() + ", ep:" + (aVar != null ? Integer.valueOf(aVar.c()) : null) + " nextEp:" + (eVar2 != null ? Integer.valueOf(eVar2.c()) : null), true);
        if (kVar == null) {
            return false;
        }
        int i13 = i12 + 5;
        if (a().size() > i13) {
            js.k kVar3 = (js.k) a().get(i13);
            if (kVar3 instanceof js.e) {
                js.e eVar3 = (js.e) kVar3;
                if (js.l.b(eVar3) && aVar != null) {
                    f50203b.m(aVar.r(), eVar3.c(), new Function1() { // from class: com.transsion.postdetail.util.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit s11;
                            s11 = ShortTVFloatManager.s(px.a.this, (ShortTvInfoEpisodeList) obj);
                            return s11;
                        }
                    });
                }
            }
        }
        if (aVar != null) {
            js.e eVar4 = (js.e) kVar;
            aVar.z(eVar4.c());
            aVar.F(0L);
            com.transsion.player.orplayer.g f11 = aVar.f();
            ShortTVItem d11 = eVar4.d();
            if (d11 == null || (str = d11.getId()) == null) {
                str = "";
            }
            f11.seekTo(str, 0L);
            aVar.f().play();
        }
        return true;
    }

    public void t(px.a aVar) {
        v(this, aVar, null, 2, null);
    }

    public void w(List list) {
        Intrinsics.h(list, "list");
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "shorttv-----setPlayList:" + list.size(), false, 4, null);
        a().clear();
        a().addAll(list);
    }
}
