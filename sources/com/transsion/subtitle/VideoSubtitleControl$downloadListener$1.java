package com.transsion.subtitle;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class VideoSubtitleControl$downloadListener$1 implements com.transsion.subtitle_download.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoSubtitleControl f54853a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoSubtitleControl$downloadListener$1(VideoSubtitleControl videoSubtitleControl) {
        this.f54853a = videoSubtitleControl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(eu.a aVar) {
        String str;
        SimpleSubtitleView simpleSubtitleView;
        Iterator it = this.f54853a.f54835l.iterator();
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            str = "1st";
            if (!it.hasNext()) {
                break;
            }
            eu.a aVar2 = (eu.a) it.next();
            if (TextUtils.equals(aVar2.a(), "1st")) {
                z11 = true;
            }
            if (TextUtils.equals(aVar2.a(), "2nd")) {
                z12 = true;
            }
        }
        if (z11) {
            if (z12) {
                str = "";
                if (z12) {
                    List<eu.a> list = this.f54853a.f54835l;
                    VideoSubtitleControl videoSubtitleControl = this.f54853a;
                    for (eu.a aVar3 : list) {
                        if (aVar3.f() && TextUtils.equals(aVar3.a(), "2nd")) {
                            aVar3.l(false);
                            aVar3.g("");
                            videoSubtitleControl.F.remove(aVar3);
                        }
                    }
                    a.f54861a.a(this.f54853a.getClass().getSimpleName() + " --> subtitleSelectFromSearch() --> 有第二个 --> 替换");
                    simpleSubtitleView = (SimpleSubtitleView) this.f54853a.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT);
                } else {
                    simpleSubtitleView = null;
                }
            } else {
                a.f54861a.a(this.f54853a.getClass().getSimpleName() + " --> subtitleSelectFromSearch() --> 没有第二个 --> 直接添加到第二个");
                simpleSubtitleView = (SimpleSubtitleView) this.f54853a.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT);
            }
            str = "2nd";
        } else {
            a.f54861a.a(this.f54853a.getClass().getSimpleName() + " --> subtitleSelectFromSearch() --> 一个都没有 --> 直接添加到第一个");
            this.f54853a.F.clear();
            simpleSubtitleView = (SimpleSubtitleView) this.f54853a.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP);
            z10 = true;
        }
        aVar.l(true);
        aVar.g(str);
        this.f54853a.F.add(aVar);
        List<eu.a> list2 = this.f54853a.f54835l;
        VideoSubtitleControl videoSubtitleControl2 = this.f54853a;
        for (eu.a aVar4 : list2) {
            if (TextUtils.equals(aVar4.b().getId(), aVar.b().getId())) {
                aVar4.l(true);
                aVar4.b().setStatus(aVar.b().getStatus());
                aVar4.g(aVar.a());
                a.f54861a.a(videoSubtitleControl2.getClass().getSimpleName() + " --> handleSetImmediately() --> 双语字幕模式 --> 列表字幕下载处理 -- 下载状态处理");
            }
        }
        this.f54853a.f0(aVar, simpleSubtitleView, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SubtitleDownloadTable subtitleDownloadTable, VideoSubtitleControl videoSubtitleControl) {
        Function1 function1;
        if (subtitleDownloadTable.getIsSetImmediately()) {
            DownloadBean downloadBean = videoSubtitleControl.f54839p;
            if (!TextUtils.equals(downloadBean != null ? downloadBean.getResourceId() : null, subtitleDownloadTable.getResourceId()) || (function1 = videoSubtitleControl.f54833j) == null) {
                return;
            }
            function1.invoke(Utils.a().getString(R$string.subtitle_download_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        String str = "";
        String str2 = str;
        for (eu.a aVar : this.f54853a.F) {
            if (TextUtils.equals(aVar.a(), "1st")) {
                str = aVar.b().getLan();
                if (str == null) {
                    str = "";
                }
            } else if (TextUtils.equals(aVar.a(), "2nd") && (str2 = aVar.b().getLan()) == null) {
                str2 = "";
            }
        }
        this.f54853a.f54834k.invoke(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(eu.a aVar) {
        List<eu.a> list = this.f54853a.f54835l;
        VideoSubtitleControl videoSubtitleControl = this.f54853a;
        for (eu.a aVar2 : list) {
            aVar2.l(false);
            if (TextUtils.equals(aVar2.b().getId(), aVar.b().getId())) {
                aVar2.l(true);
                aVar2.b().setStatus(5);
                a.f54861a.a(videoSubtitleControl.getClass().getSimpleName() + " --> handleSetImmediately() --> 单字幕模式 --> 如果是单语字幕仅需要将之前设置的全部置空 当前设置选中");
            }
        }
        this.f54853a.F.clear();
        this.f54853a.F.add(aVar);
        VideoSubtitleControl videoSubtitleControl2 = this.f54853a;
        videoSubtitleControl2.f0(aVar, (SimpleSubtitleView) videoSubtitleControl2.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP), true);
    }

    @Override // com.transsion.subtitle_download.a
    public void onComplete(SubtitleDownloadTable stDownloadTable) {
        n0 n0Var;
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        n0Var = this.f54853a.f54842s;
        kotlinx.coroutines.k.d(n0Var, null, null, new VideoSubtitleControl$downloadListener$1$onComplete$1(stDownloadTable, this.f54853a, this, null), 3, null);
    }

    @Override // com.transsion.subtitle_download.a
    public void onDownloading(int i11, SubtitleDownloadTable stDownloadTable) {
        Intrinsics.h(stDownloadTable, "stDownloadTable");
    }

    @Override // com.transsion.subtitle_download.a
    public void onFail(Exception e11, final SubtitleDownloadTable dbBean) {
        FragmentActivity fragmentActivity;
        Intrinsics.h(e11, "e");
        Intrinsics.h(dbBean, "dbBean");
        fragmentActivity = this.f54853a.f54824a;
        final VideoSubtitleControl videoSubtitleControl = this.f54853a;
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.transsion.subtitle.f
            @Override // java.lang.Runnable
            public final void run() {
                VideoSubtitleControl$downloadListener$1.f(SubtitleDownloadTable.this, videoSubtitleControl);
            }
        });
    }

    @Override // com.transsion.subtitle_download.a
    public void onSaveDownload(SubtitleDownloadTable bean) {
        n0 n0Var;
        Intrinsics.h(bean, "bean");
        String resourceId = bean.getResourceId();
        DownloadBean downloadBean = this.f54853a.f54839p;
        if (Intrinsics.c(resourceId, downloadBean != null ? downloadBean.getSubtitleResId() : null)) {
            n0Var = this.f54853a.f54842s;
            kotlinx.coroutines.k.d(n0Var, null, null, new VideoSubtitleControl$downloadListener$1$onSaveDownload$1(this.f54853a, bean, null), 3, null);
            return;
        }
        a.f54861a.a(this.f54853a.getClass().getSimpleName() + " --> -------- onSaveDownload，不是当前视频，不做处理");
    }

    @Override // com.transsion.subtitle_download.a
    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.b(this, subtitleDownloadTable);
    }
}
