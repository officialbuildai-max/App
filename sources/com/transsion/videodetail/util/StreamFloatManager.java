package com.transsion.videodetail.util;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import ao.e;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.push.api.IPushProvider;
import com.transsion.videodetail.bean.VideoDetailStream;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public final class StreamFloatManager extends com.transsion.videofloat.manager.b {

    /* renamed from: b, reason: collision with root package name */
    public static final StreamFloatManager f57996b = new StreamFloatManager();

    /* renamed from: c, reason: collision with root package name */
    private static Map f57997c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f57998d = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.util.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            VideoDetailPlayDao x10;
            x10 = StreamFloatManager.x();
            return x10;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f57999e = LazyKt.b(new Function0() { // from class: com.transsion.videodetail.util.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.videodetail.b w11;
            w11 = StreamFloatManager.w();
            return w11;
        }
    });

    private StreamFloatManager() {
    }

    private final MediaItem h(go.a aVar, VideoDetailStream videoDetailStream, int i11, int i12) {
        return new MediaItem(aVar != null ? aVar.t() : null, "", aVar != null ? aVar.c() : null, null, null, null, i(aVar, videoDetailStream.getId(), i11, i12), null, aVar != null ? aVar.o() : null, videoDetailStream.getId(), null, null, null, null, 15544, null);
    }

    private final PendingIntent i(go.a aVar, String str, int i11, int i12) {
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/playvideo/detail");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_resource_id");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(str);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("subject_type");
        sb2.append(UrlUtils.EQUAL_MARK);
        Intent intent = null;
        sb2.append(aVar != null ? aVar.r() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("season");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(i11);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("episode");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(i12);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("id");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.o() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("ops");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.q() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_page_from");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append("media_notification");
        sb2.append(UrlUtils.AND_MARK);
        if (iPushProvider != null) {
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            Intent a12 = iPushProvider.a(a11);
            if (a12 != null) {
                a12.addFlags(603979776);
                a12.setData(Uri.parse(sb2.toString()));
                intent = a12;
            }
        }
        return PendingIntent.getActivity(Utils.a(), 0, intent, k());
    }

    private final PlayMimeType j(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        return Intrinsics.c(upperCase, "DASH") ? PlayMimeType.DASH : Intrinsics.c(upperCase, "HLS") ? PlayMimeType.HLS : PlayMimeType.DEFAULT;
    }

    private final int k() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    private final void l(String str, int i11, int i12, Function1 function1) {
        k.d(o0.a(y0.b()), null, null, new StreamFloatManager$getPlayInfo$1(str, i11, i12, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.videodetail.b m() {
        return (com.transsion.videodetail.b) f57999e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao n() {
        return (VideoDetailPlayDao) f57998d.getValue();
    }

    private final void o(px.a aVar, go.a aVar2, int i11, int i12, VideoDetailStreamList videoDetailStreamList) {
        Object obj;
        VideoDetailStream videoDetailStream = (VideoDetailStream) CollectionsKt.k0(videoDetailStreamList.getStreams());
        if (videoDetailStream == null) {
            return;
        }
        LinkedHashMap linkedHashMap = null;
        if (Intrinsics.c(videoDetailStream.getFormat(), "DEFAULT") || (Intrinsics.c(videoDetailStream.getFormat(), "HLS") && videoDetailStreamList.getStreams().size() > 1)) {
            Iterator<T> it = videoDetailStreamList.getStreams().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(((VideoDetailStream) obj).getResolutions(), aVar.o())) {
                        break;
                    }
                }
            }
            VideoDetailStream videoDetailStream2 = (VideoDetailStream) obj;
            if (videoDetailStream2 != null) {
                videoDetailStream = videoDetailStream2;
            }
        }
        if (videoDetailStream.getSignCookie().length() > 0) {
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("cookie", videoDetailStream.getSignCookie());
        }
        lg.a.f68962a.c("VideoFloat", "stream-----getPlayInfoSuccess,开始播放, se:" + i11 + ",ep:" + i12, true);
        e eVar = new e(String.valueOf(videoDetailStream.getUrl().hashCode()), videoDetailStream.getUrl(), 0, j(videoDetailStream.getFormat()), h(aVar2, videoDetailStream, i11, i12), 4, null);
        eVar.q(linkedHashMap);
        aVar.z(i12);
        aVar.H(i11);
        aVar.F(0L);
        aVar.f().reset();
        aVar.f().setDataSource(eVar);
        aVar.f().prepare();
        aVar.f().play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(go.a aVar, px.a aVar2, go.a aVar3, VideoDetailStreamList videoDetailStreamList) {
        if (videoDetailStreamList != null) {
            f57996b.o(aVar2, aVar3, aVar.l(), aVar.e(), videoDetailStreamList);
            return Unit.f67184a;
        }
        lg.a.f68962a.c("VideoFloat", "stream-----playNext,nextSe:" + aVar.l() + ",nextEp:" + aVar.e() + " 下一集数据为空，无法播放", true);
        return Unit.f67184a;
    }

    private final void u(px.a aVar) {
        if (aVar != null) {
            String str = aVar.r() + "+" + aVar.q() + "+" + aVar.c();
            a.C0856a.f(lg.a.f68962a, "VideoFloat", "saveHistory--key:" + str + ", value:" + aVar.n(), false, 4, null);
            f57997c.put(str, Long.valueOf(aVar.n()));
        }
        k.d(o0.a(y0.b()), null, null, new StreamFloatManager$saveHistoryInner$2(aVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.videodetail.b w() {
        return (com.transsion.videodetail.b) zg.c.f79537e.a().h(com.transsion.videodetail.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao x() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    public final Long g(String key) {
        Intrinsics.h(key, "key");
        return (Long) f57997c.remove(key);
    }

    public void p() {
        a().clear();
    }

    public void q(px.a aVar) {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "VideoFloat", "openDetail--1", false, 4, null);
        u(aVar);
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=/playvideo/detail");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("id");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.r() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("season");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.q() : 0);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("episode");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(aVar != null ? aVar.c() : 0);
        sb2.append(UrlUtils.AND_MARK);
        a.C0856a.f(c0856a, "VideoFloat", "openDetail--end", false, 4, null);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(sb2.toString()));
        intent.setFlags(ASTNode.DEOP);
        Utils.a().startActivity(intent);
    }

    public boolean r(final px.a aVar) {
        Object obj;
        Iterator it = a().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            go.a aVar2 = (go.a) it.next();
            if (aVar != null && aVar2.e() == aVar.c()) {
                break;
            }
            i11++;
        }
        Iterator it2 = a().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            go.a aVar3 = (go.a) obj;
            if (aVar != null && aVar3.e() == aVar.c()) {
                break;
            }
        }
        final go.a aVar4 = (go.a) obj;
        int i12 = i11 + 1;
        if (i12 >= a().size()) {
            return false;
        }
        final go.a aVar5 = (go.a) a().get(i12);
        lg.a.f68962a.c("VideoFloat", "stream-----playNext, name:" + aVar5.p() + ",nextSe:" + aVar5.l() + ",nextEp:" + aVar5.e(), true);
        if (aVar == null) {
            return false;
        }
        l(aVar.r(), aVar5.l(), aVar5.e(), new Function1() { // from class: com.transsion.videodetail.util.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit s11;
                s11 = StreamFloatManager.s(go.a.this, aVar, aVar4, (VideoDetailStreamList) obj2);
                return s11;
            }
        });
        return true;
    }

    public void t(px.a aVar) {
        u(aVar);
    }

    public void v(List list) {
        Intrinsics.h(list, "list");
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "stream-----setPlayList:" + list.size(), false, 4, null);
        a().clear();
        a().addAll(list);
    }
}
