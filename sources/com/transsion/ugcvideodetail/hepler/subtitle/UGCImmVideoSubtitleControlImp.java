package com.transsion.ugcvideodetail.hepler.subtitle;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.view.b0;
import androidx.view.v;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle.helper.e;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.ugcvideodetail.R$string;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream;
import com.transsion.ugcvideodetail.hepler.subtitle.manager.b;
import hu.c;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import lg.a;

/* loaded from: classes6.dex */
public final class UGCImmVideoSubtitleControlImp implements b, hu.c {

    /* renamed from: a, reason: collision with root package name */
    private final FragmentActivity f56494a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56495b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewGroup f56496c;

    /* renamed from: d, reason: collision with root package name */
    private final SimpleSubtitleView f56497d;

    /* renamed from: e, reason: collision with root package name */
    private final com.transsion.ugcvideodetail.hepler.subtitle.a f56498e;

    /* renamed from: f, reason: collision with root package name */
    private final UGCImmVideo f56499f;

    /* renamed from: g, reason: collision with root package name */
    private final UGCVideoPlayStream f56500g;

    /* renamed from: h, reason: collision with root package name */
    private final String f56501h;

    /* renamed from: i, reason: collision with root package name */
    private Function1 f56502i;

    /* renamed from: j, reason: collision with root package name */
    private Function1 f56503j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f56504k;

    /* renamed from: l, reason: collision with root package name */
    private long f56505l;

    /* renamed from: m, reason: collision with root package name */
    private float f56506m;

    /* renamed from: n, reason: collision with root package name */
    private final String f56507n;

    /* renamed from: o, reason: collision with root package name */
    private final UGCImmVideoSubtitleControlImp$downloadListener$1 f56508o;

    /* loaded from: classes6.dex */
    public static final class a implements i5.a {
        a() {
        }

        @Override // i5.a
        public long getCurrentPosition() {
            return UGCImmVideoSubtitleControlImp.this.f56505l;
        }

        @Override // i5.a
        public Float getSpeed() {
            return Float.valueOf(UGCImmVideoSubtitleControlImp.this.f56506m);
        }

        @Override // i5.a
        public boolean isPlaying() {
            return UGCImmVideoSubtitleControlImp.this.f56504k;
        }
    }

    public UGCImmVideoSubtitleControlImp(FragmentActivity activity, String pageName, ViewGroup subtitleLayout, SimpleSubtitleView subtitleView, com.transsion.ugcvideodetail.hepler.subtitle.a aVar, UGCImmVideo uGCImmVideo, UGCVideoPlayStream uGCVideoPlayStream) {
        UGCVideo ugcVideo;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(subtitleLayout, "subtitleLayout");
        Intrinsics.h(subtitleView, "subtitleView");
        this.f56494a = activity;
        this.f56495b = pageName;
        this.f56496c = subtitleLayout;
        this.f56497d = subtitleView;
        this.f56498e = aVar;
        this.f56499f = uGCImmVideo;
        this.f56500g = uGCVideoPlayStream;
        this.f56501h = "UGCVideoSubtitleCtr";
        this.f56504k = true;
        this.f56506m = 1.0f;
        this.f56507n = ((uGCImmVideo == null || (ugcVideo = uGCImmVideo.getUgcVideo()) == null) ? null : ugcVideo.getUgcVideoId()) + "_" + (uGCVideoPlayStream != null ? uGCVideoPlayStream.getIdType() : null);
        UGCImmVideoSubtitleControlImp$downloadListener$1 uGCImmVideoSubtitleControlImp$downloadListener$1 = new UGCImmVideoSubtitleControlImp$downloadListener$1(this);
        this.f56508o = uGCImmVideoSubtitleControlImp$downloadListener$1;
        if (aVar != null) {
            aVar.b();
        }
        b.a aVar2 = com.transsion.ugcvideodetail.hepler.subtitle.manager.b.f56525a;
        aVar2.b().b(uGCImmVideoSubtitleControlImp$downloadListener$1);
        aVar2.b().d(this);
        w(subtitleView);
    }

    private final void A() {
        this.f56497d.turnOff(false);
        jg.c.k(this.f56496c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c8 A[LOOP:1: B:41:0x01c2->B:43:0x01c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.util.List r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp.v(java.util.List, java.lang.String):void");
    }

    private final void w(SimpleSubtitleView simpleSubtitleView) {
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setBgColor(Utils.a().getResources().getColor(R$color.black_80));
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setBgdRadius(dk.a.b(8));
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.initSubtitle(new a(), false);
        } else {
            a.C0856a.f(lg.a.f68962a, this.f56501h, " vdSubtitle --> initSubtitle() --> null", false, 4, null);
        }
    }

    private final void x(eu.a aVar) {
    }

    private final void y() {
        b0 e11;
        b0 d11;
        com.transsion.ugcvideodetail.hepler.subtitle.a aVar = this.f56498e;
        if (aVar != null && (d11 = aVar.d()) != null) {
            d11.q(null);
        }
        com.transsion.ugcvideodetail.hepler.subtitle.a aVar2 = this.f56498e;
        if (aVar2 != null && (e11 = aVar2.e()) != null) {
            e11.q(null);
        }
        this.f56497d.reset();
        a.C0856a.f(lg.a.f68962a, this.f56501h, " reset() --> 重置资源", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(boolean z10) {
    }

    @Override // hu.c
    public void J(boolean z10, DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        a.C0856a.f(lg.a.f68962a, this.f56501h, " checkResult --> " + z10, false, 4, null);
        Function1 function1 = this.f56502i;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z10));
        }
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void a(Function1 function1) {
        this.f56502i = function1;
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void b(Function1 function1) {
        this.f56503j = function1;
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void c(boolean z10) {
        this.f56504k = z10;
        if (z10) {
            this.f56497d.resume();
        } else {
            this.f56497d.pause();
        }
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void d(long j11) {
        this.f56505l = j11;
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void e() {
        k.d(v.a(this.f56494a), null, null, new UGCImmVideoSubtitleControlImp$checkSubtitle$1(this, null), 3, null);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void f(eu.a aVar) {
        SubtitleDownloadTable b11;
        SubtitleDownloadTable b12;
        Long delay;
        SubtitleDownloadTable b13;
        SubtitleDownloadTable b14;
        SubtitleDownloadTable b15;
        SubtitleDownloadTable b16;
        String path;
        b0 c11;
        b0 d11;
        List<eu.a> list;
        SubtitleDownloadTable b17;
        com.transsion.ugcvideodetail.hepler.subtitle.a aVar2 = this.f56498e;
        if (aVar2 != null && (d11 = aVar2.d()) != null && (list = (List) d11.f()) != null) {
            for (eu.a aVar3 : list) {
                aVar3.l(Intrinsics.c(aVar3.b().getId(), (aVar == null || (b17 = aVar.b()) == null) ? null : b17.getId()));
            }
        }
        Function1 function1 = this.f56503j;
        if (function1 != null) {
            function1.invoke(aVar);
        }
        com.transsion.ugcvideodetail.hepler.subtitle.a aVar4 = this.f56498e;
        if (aVar4 != null && (c11 = aVar4.c()) != null) {
            c11.q(aVar);
        }
        if (aVar != null && (b16 = aVar.b()) != null && (path = b16.getPath()) != null) {
            A();
            this.f56497d.selectSubtitle(path, e.b(aVar), new i5.b() { // from class: com.transsion.ugcvideodetail.hepler.subtitle.c
                @Override // i5.b
                public final void a(boolean z10) {
                    UGCImmVideoSubtitleControlImp.z(z10);
                }
            });
        }
        lg.a.f68962a.c(this.f56501h, "selectSubtitle delayDuration:" + ((aVar == null || (b15 = aVar.b()) == null) ? null : b15.getDelay()) + ", name:" + ((aVar == null || (b14 = aVar.b()) == null) ? null : b14.getLanName()) + ", isAutoDownload:" + ((aVar == null || (b13 = aVar.b()) == null) ? null : Boolean.valueOf(b13.getIsAutoDownload())), true);
        if (aVar != null && (b12 = aVar.b()) != null && (delay = b12.getDelay()) != null) {
            this.f56497d.subtitleDelay(delay.longValue());
        }
        if (aVar != null && (b11 = aVar.b()) != null) {
            if (!b11.getIsAutoDownload()) {
                com.transsion.baselib.report.launch.b.f43424a.b().putString("k_subtitle_language", b11.getLanName());
                com.transsion.subtitle_download.utils.d.f55168a.b().putString("k_subtitle_select_lan", b11.getLan());
            }
            uh.b.f76876a.e(Utils.a().getString(R$string.ugc_imm_video_enable_toast, b11.getName()));
        }
        if (aVar != null) {
            x(aVar);
        }
        k.d(v.a(this.f56494a), null, null, new UGCImmVideoSubtitleControlImp$selectSubtitle$6(aVar, this, null), 3, null);
    }

    @Override // hu.c
    public void g(eu.a aVar) {
        c.a.b(this, aVar);
    }

    @Override // com.transsion.ugcvideodetail.hepler.subtitle.b
    public void onDestroy() {
        y();
        jg.c.g(this.f56496c);
        this.f56497d.stop();
        this.f56497d.destroy();
        b.a aVar = com.transsion.ugcvideodetail.hepler.subtitle.manager.b.f56525a;
        aVar.b().f(this);
        aVar.b().c(this.f56508o);
        a.C0856a.f(lg.a.f68962a, this.f56501h, " onDestroy()", false, 4, null);
    }

    public final String u() {
        return this.f56507n;
    }
}
