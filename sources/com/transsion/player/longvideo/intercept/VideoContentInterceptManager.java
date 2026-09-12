package com.transsion.player.longvideo.intercept;

import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.VipInfo;
import com.transsion.baselib.db.video.PlaybackRecordDao;
import com.transsion.baselib.db.video.PlaybackRecordTable;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class VideoContentInterceptManager {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f48141a = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.intercept.i0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PlaybackRecordDao o11;
            o11 = VideoContentInterceptManager.o();
            return o11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
        String simpleName = VideoContentInterceptManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlaybackRecordDao i() {
        return (PlaybackRecordDao) this.f48141a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(go.a aVar, final PlaybackRecordTable playbackRecordTable, final ho.j jVar, final com.transsion.player.ui.longvideo.a aVar2, PlaybackInterceptionManager playbackInterceptionManager, final d dVar) {
        Subject m11;
        Subject m12;
        Subject m13;
        Subject m14;
        h0 h0Var = h0.f48193a;
        String str = null;
        r1 = null;
        VipInfo vipInfo = null;
        r1 = null;
        String str2 = null;
        str = null;
        boolean f11 = h0Var.f(aVar != null ? aVar.m() : null);
        final int a11 = h0Var.a(aVar != null ? aVar.m() : null);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "premium_p", h() + " --> intercept() --> 资源内容拦截 --> isVipResource = " + f11 + " --> vipInfo = " + ((aVar == null || (m14 = aVar.m()) == null) ? null : m14.getVipInfo()), false, 4, null);
        if (f11) {
            int ep2 = playbackRecordTable != null ? playbackRecordTable.getEp() : 0;
            String h11 = h();
            if (aVar != null && (m13 = aVar.m()) != null) {
                vipInfo = m13.getVipInfo();
            }
            a.C0856a.f(c0856a, "premium_p", h11 + " --> intercept() --> 资源内容拦截 --> vipInfo = " + vipInfo + " --> ep = " + ep2 + " --> freeEpisodeCount = " + a11, false, 4, null);
            if (ep2 <= a11 && ep2 > 0) {
                jVar.f64747n.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoContentInterceptManager.k(VideoContentInterceptManager.this, a11, playbackRecordTable, jVar, dVar, aVar2);
                    }
                }, 200L);
                return;
            }
            jVar.f64747n.onShowPremium(playbackInterceptionManager, aVar);
            jVar.f64748o.setVisibility(8);
            PlaybackInterceptionManager.X(playbackInterceptionManager, true, "vip_intercept_auto", ti.n.f76387a.b(), false, 8, null);
            return;
        }
        if (!e.f48177a.c()) {
            if (playbackRecordTable == null || !playbackRecordTable.getRewardUnlock()) {
                VideoContentInterceptView videoContentInterceptView = jVar.f64747n;
                if (aVar != null && (m11 = aVar.m()) != null) {
                    str = m11.getGenre();
                }
                videoContentInterceptView.onShowResolutionRatio(playbackRecordTable, str, playbackInterceptionManager, aVar, dVar);
                jVar.f64748o.setVisibility(8);
                return;
            }
            a.C0856a.f(c0856a, "premium_p", h() + " --> intercept() --> 已解锁", false, 4, null);
            jVar.f64747n.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.l0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoContentInterceptManager.m(ho.j.this, dVar, aVar2);
                }
            }, 200L);
            return;
        }
        a.C0856a.f(c0856a, "premium_p", h() + " --> intercept() --> 使用每日免费次数", false, 4, null);
        go.b c11 = dVar != null ? dVar.c() : null;
        int a12 = com.transsnet.downloader.util.b0.f60044a.a(c11 != null ? c11.d() : null);
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (a12 < (iPremiumApi != null ? iPremiumApi.t() : 720)) {
            jVar.f64747n.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.intercept.k0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoContentInterceptManager.l(ho.j.this, dVar, aVar2);
                }
            }, 200L);
            return;
        }
        VideoContentInterceptView videoContentInterceptView2 = jVar.f64747n;
        if (aVar != null && (m12 = aVar.m()) != null) {
            str2 = m12.getGenre();
        }
        videoContentInterceptView2.onShowResolutionRatio(playbackRecordTable, str2, playbackInterceptionManager, aVar, dVar);
        jVar.f64748o.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(VideoContentInterceptManager videoContentInterceptManager, int i11, PlaybackRecordTable playbackRecordTable, ho.j jVar, d dVar, com.transsion.player.ui.longvideo.a aVar) {
        a.C0856a.f(lg.a.f68962a, "premium_p", videoContentInterceptManager.h() + " --> intercept() --> freeEpisodeCount = " + i11 + " --> ep = " + (playbackRecordTable != null ? Integer.valueOf(playbackRecordTable.getEp()) : null) + " --> 当前可以免费播放", false, 4, null);
        jVar.f64747n.setVisibility(8);
        if (dVar != null) {
            dVar.d();
        }
        if (aVar != null) {
            aVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ho.j jVar, d dVar, com.transsion.player.ui.longvideo.a aVar) {
        jVar.f64747n.setVisibility(8);
        if (dVar != null) {
            dVar.d();
        }
        if (aVar != null) {
            aVar.play();
        }
        if (dVar != null) {
            dVar.e();
        }
        e.f48177a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ho.j jVar, d dVar, com.transsion.player.ui.longvideo.a aVar) {
        jVar.f64747n.setVisibility(8);
        if (dVar != null) {
            dVar.d();
        }
        if (aVar != null) {
            aVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaybackRecordDao o() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).v1();
    }

    public final void n(go.a aVar, ho.j viewBinding, com.transsion.player.ui.longvideo.a aVar2, PlaybackInterceptionManager interceptionManager, d dVar) {
        LifecycleCoroutineScope a11;
        Intrinsics.h(viewBinding, "viewBinding");
        Intrinsics.h(interceptionManager, "interceptionManager");
        if (aVar != null) {
            Context context = viewBinding.getRoot().getContext();
            AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity == null || (a11 = androidx.view.v.a(appCompatActivity)) == null) {
                return;
            }
            kotlinx.coroutines.k.d(a11, null, null, new VideoContentInterceptManager$intercept$1$1(this, aVar, aVar, viewBinding, aVar2, interceptionManager, dVar, null), 3, null);
        }
    }
}
