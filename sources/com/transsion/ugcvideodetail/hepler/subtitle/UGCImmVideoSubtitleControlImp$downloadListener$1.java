package com.transsion.ugcvideodetail.hepler.subtitle;

import androidx.fragment.app.FragmentActivity;
import androidx.view.v;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle_download.a;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import lg.a;

/* loaded from: classes6.dex */
public final class UGCImmVideoSubtitleControlImp$downloadListener$1 implements com.transsion.subtitle_download.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UGCImmVideoSubtitleControlImp f56510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UGCImmVideoSubtitleControlImp$downloadListener$1(UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp) {
        this.f56510a = uGCImmVideoSubtitleControlImp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SubtitleDownloadTable subtitleDownloadTable, UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp) {
        if (subtitleDownloadTable.getIsSetImmediately() && Intrinsics.c(uGCImmVideoSubtitleControlImp.u(), subtitleDownloadTable.getResourceId())) {
            uh.b.f76876a.d(R$string.subtitle_download_failed);
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void onComplete(SubtitleDownloadTable stDownloadTable) {
        FragmentActivity fragmentActivity;
        Intrinsics.h(stDownloadTable, "stDownloadTable");
        fragmentActivity = this.f56510a.f56494a;
        k.d(v.a(fragmentActivity), null, null, new UGCImmVideoSubtitleControlImp$downloadListener$1$onComplete$1(this.f56510a, stDownloadTable, null), 3, null);
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
        fragmentActivity = this.f56510a.f56494a;
        final UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp = this.f56510a;
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.transsion.ugcvideodetail.hepler.subtitle.d
            @Override // java.lang.Runnable
            public final void run() {
                UGCImmVideoSubtitleControlImp$downloadListener$1.b(SubtitleDownloadTable.this, uGCImmVideoSubtitleControlImp);
            }
        });
    }

    @Override // com.transsion.subtitle_download.a
    public void onSaveDownload(SubtitleDownloadTable bean) {
        FragmentActivity fragmentActivity;
        String str;
        Intrinsics.h(bean, "bean");
        if (Intrinsics.c(bean.getResourceId(), this.f56510a.u())) {
            fragmentActivity = this.f56510a.f56494a;
            k.d(v.a(fragmentActivity), null, null, new UGCImmVideoSubtitleControlImp$downloadListener$1$onSaveDownload$1(this.f56510a, bean, null), 3, null);
        } else {
            a.C0856a c0856a = lg.a.f68962a;
            str = this.f56510a.f56501h;
            a.C0856a.f(c0856a, str, " -------- onSaveDownload，不是当前视频，不做处理", false, 4, null);
        }
    }

    @Override // com.transsion.subtitle_download.a
    public void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable) {
        a.C0697a.b(this, subtitleDownloadTable);
    }
}
