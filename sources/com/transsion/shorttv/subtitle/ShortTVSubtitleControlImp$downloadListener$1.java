package com.transsion.shorttv.subtitle;

import androidx.fragment.app.FragmentActivity;
import androidx.view.v;
import com.transsion.shorttv.R$string;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import js.e;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import lg.a;

/* loaded from: classes6.dex */
public final class ShortTVSubtitleControlImp$downloadListener$1 implements com.transsion.subtitle_download.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShortTVSubtitleControlImp f53128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortTVSubtitleControlImp$downloadListener$1(ShortTVSubtitleControlImp shortTVSubtitleControlImp) {
        this.f53128a = shortTVSubtitleControlImp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SubtitleDownloadTable subtitleDownloadTable, ShortTVSubtitleControlImp shortTVSubtitleControlImp) {
        e eVar;
        if (subtitleDownloadTable.getIsSetImmediately()) {
            eVar = shortTVSubtitleControlImp.f53116e;
            if (Intrinsics.c(eVar.f(), subtitleDownloadTable.getResourceId())) {
                fs.b.f62582a.d(R$string.short_tv_subtitle_download_failed);
            }
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void onComplete(SubtitleDownloadTable stDownloadTable) {
        FragmentActivity fragmentActivity;
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        fragmentActivity = this.f53128a.f53113b;
        k.d(v.a(fragmentActivity), null, null, new ShortTVSubtitleControlImp$downloadListener$1$onComplete$1(this.f53128a, stDownloadTable, null), 3, null);
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
        fragmentActivity = this.f53128a.f53113b;
        final ShortTVSubtitleControlImp shortTVSubtitleControlImp = this.f53128a;
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.transsion.shorttv.subtitle.d
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVSubtitleControlImp$downloadListener$1.b(SubtitleDownloadTable.this, shortTVSubtitleControlImp);
            }
        });
    }

    @Override // com.transsion.subtitle_download.a
    public void onSaveDownload(SubtitleDownloadTable bean) {
        e eVar;
        FragmentActivity fragmentActivity;
        String str;
        Intrinsics.h(bean, "bean");
        String resourceId = bean.getResourceId();
        eVar = this.f53128a.f53116e;
        if (Intrinsics.c(resourceId, eVar.f())) {
            fragmentActivity = this.f53128a.f53113b;
            k.d(v.a(fragmentActivity), null, null, new ShortTVSubtitleControlImp$downloadListener$1$onSaveDownload$1(this.f53128a, bean, null), 3, null);
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        str = this.f53128a.f53118g;
        a.C0856a.g(c0856a, str + " --> -------- onSaveDownload，不是当前视频，不做处理", false, 2, null);
    }

    @Override // com.transsion.subtitle_download.a
    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.b(this, subtitleDownloadTable);
    }
}
