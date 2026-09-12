package tv;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.ThreadUtils;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.ugcvideodetail.api.bean.UGCImmVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoPlayStream;
import com.transsion.ugcvideodetail.fragment.UGCImmVideoDetailFragment;
import com.transsion.ugcvideodetail.hepler.subtitle.b;
import com.transsion.ugcvideodetail.hepler.subtitle.manager.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import qv.r;

/* loaded from: classes7.dex */
public final class n implements com.transsion.subtitle_download.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f76522a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.ugcvideodetail.hepler.subtitle.b f76523b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f76524c;

    /* renamed from: d, reason: collision with root package name */
    private String f76525d;

    /* renamed from: e, reason: collision with root package name */
    private eu.a f76526e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f76527f;

    /* loaded from: classes6.dex */
    public interface a {
        r a();

        com.transsion.ugcvideodetail.hepler.subtitle.a b();

        UGCImmVideoDetailFragment c();

        UGCImmVideo getData();

        String getLogTag();
    }

    public n(a host) {
        Intrinsics.h(host, "host");
        this.f76522a = host;
    }

    private final void h(eu.a aVar) {
        if (this.f76527f) {
            uh.b.f76876a.d(R$string.subtitle_is_downloading);
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        b.a aVar2 = com.transsion.ugcvideodetail.hepler.subtitle.manager.b.f56525a;
        aVar2.b().b(this);
        aVar.b().setStatus(2);
        this.f76527f = true;
        a.C0856a.f(lg.a.f68962a, this.f76522a.getLogTag(), n.class.getSimpleName() + " --> downloadSubtitle() --> 内置字幕列表，下载字幕，name = " + aVar.b().getName() + ", subtype = " + aVar.b().getType() + ",download subtitleName = " + aVar.b().getSubtitleName() + ", subResourceId = " + aVar.b().getResourceId() + "~", false, 4, null);
        aVar.b().setAutoDownload(false);
        this.f76526e = aVar;
        aVar2.b().h(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(n nVar, boolean z10) {
        nVar.f76524c = z10;
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(n nVar, eu.a aVar) {
        SubtitleDownloadTable b11;
        SubtitleDownloadTable b12;
        String str = null;
        String lanName = (aVar == null || (b12 = aVar.b()) == null) ? null : b12.getLanName();
        nVar.f76524c = !(lanName == null || lanName.length() == 0);
        if (aVar != null && (b11 = aVar.b()) != null) {
            str = b11.getLanName();
        }
        nVar.f76525d = str;
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(n nVar, SubtitleDownloadTable subtitleDownloadTable) {
        SubtitleDownloadTable b11;
        eu.a aVar = nVar.f76526e;
        if (aVar != null) {
            if (Intrinsics.c((aVar == null || (b11 = aVar.b()) == null) ? null : b11.getLan(), subtitleDownloadTable.getLan())) {
                a.C0856a.f(lg.a.f68962a, nVar.f76522a.getLogTag(), "内置字幕点击下载成功，name = " + subtitleDownloadTable.getName() + ", videoResourceId = " + subtitleDownloadTable.getResourceId() + ", download subtitleName = " + subtitleDownloadTable.getName() + ", lan = " + subtitleDownloadTable.getLan() + "， status:" + subtitleDownloadTable.getStatus() + "~", false, 4, null);
                eu.a aVar2 = nVar.f76526e;
                Intrinsics.e(aVar2);
                nVar.o(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(n nVar, SubtitleDownloadTable subtitleDownloadTable) {
        eu.a aVar = nVar.f76526e;
        if (aVar != null) {
            aVar.h(subtitleDownloadTable);
        }
        a.C0856a.f(lg.a.f68962a, nVar.f76522a.getLogTag(), n.class.getSimpleName() + " --> onFail() --> 内置字幕点击下载失败TnT，name = " + subtitleDownloadTable.getName() + ", videoResourceId = " + subtitleDownloadTable.getResourceId() + ", download subtitleName = " + subtitleDownloadTable.getName() + ", lan = " + subtitleDownloadTable.getLan() + "， status:" + subtitleDownloadTable.getStatus() + "~", false, 4, null);
    }

    public final void e() {
        com.transsion.ugcvideodetail.hepler.subtitle.manager.b.f56525a.b().b(this);
    }

    public final void f() {
        com.transsion.ugcvideodetail.hepler.subtitle.b bVar = this.f76523b;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final void g() {
        com.transsion.ugcvideodetail.hepler.subtitle.manager.b.f56525a.b().c(this);
    }

    public final void i(UGCVideoPlayStream uGCVideoPlayStream) {
        FragmentActivity activity;
        a.C0856a.f(lg.a.f68962a, this.f76522a.getLogTag(), ">>>>>>>--------------------initLanguage subtitle, position:", false, 4, null);
        UGCImmVideoDetailFragment c11 = this.f76522a.c();
        if (c11 == null || (activity = c11.getActivity()) == null || activity.isDestroyed() || activity.isFinishing() || this.f76522a.getData() == null) {
            return;
        }
        b.a aVar = com.transsion.ugcvideodetail.hepler.subtitle.b.f56515g1;
        FrameLayout flUgcImmSubtitle = this.f76522a.a().f73982g;
        Intrinsics.g(flUgcImmSubtitle, "flUgcImmSubtitle");
        SimpleSubtitleView vUgcImmSubtitle = this.f76522a.a().M;
        Intrinsics.g(vUgcImmSubtitle, "vUgcImmSubtitle");
        com.transsion.ugcvideodetail.hepler.subtitle.b a11 = aVar.a(activity, "/ugc_video/immersive_detail", flUgcImmSubtitle, vUgcImmSubtitle, this.f76522a.b(), this.f76522a.getData(), uGCVideoPlayStream);
        a11.e();
        a11.a(new Function1() { // from class: tv.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = n.j(n.this, ((Boolean) obj).booleanValue());
                return j11;
            }
        });
        a11.b(new Function1() { // from class: tv.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = n.k(n.this, (eu.a) obj);
                return k11;
            }
        });
        this.f76523b = a11;
    }

    public final void n() {
        com.transsion.ugcvideodetail.hepler.subtitle.b bVar = this.f76523b;
        if (bVar != null) {
            bVar.onDestroy();
        }
        this.f76523b = null;
    }

    public final void o(eu.a item) {
        Intrinsics.h(item, "item");
        a.C0856a.f(lg.a.f68962a, this.f76522a.getLogTag(), "onSubtitleSelect", false, 4, null);
        if (!item.d()) {
            h(item);
            return;
        }
        com.transsion.ugcvideodetail.hepler.subtitle.b bVar = this.f76523b;
        if (bVar != null) {
            bVar.f(item);
        }
        this.f76526e = null;
    }

    @Override // com.transsion.subtitle_download.a
    public void onComplete(final SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        this.f76527f = false;
        ThreadUtils.k(new Runnable() { // from class: tv.l
            @Override // java.lang.Runnable
            public final void run() {
                n.l(n.this, stDownloadTable);
            }
        });
    }

    @Override // com.transsion.subtitle_download.a
    public void onDownloading(int i11, SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
    }

    @Override // com.transsion.subtitle_download.a
    public void onFail(Exception e11, final SubtitleDownloadTable dbBean) {
        Intrinsics.h(e11, "e");
        Intrinsics.h(dbBean, "dbBean");
        this.f76527f = false;
        ThreadUtils.k(new Runnable() { // from class: tv.m
            @Override // java.lang.Runnable
            public final void run() {
                n.m(n.this, dbBean);
            }
        });
    }

    @Override // com.transsion.subtitle_download.a
    public void onSaveDownload(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.a(this, subtitleDownloadTable);
    }

    @Override // com.transsion.subtitle_download.a
    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.b(this, subtitleDownloadTable);
    }

    public final void p(boolean z10) {
        com.transsion.ugcvideodetail.hepler.subtitle.b bVar = this.f76523b;
        if (bVar != null) {
            bVar.c(z10);
        }
    }

    public final void q(long j11) {
        com.transsion.ugcvideodetail.hepler.subtitle.b bVar = this.f76523b;
        if (bVar != null) {
            bVar.d(j11);
        }
    }
}
