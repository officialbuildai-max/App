package com.transsion.ugcvideodetail.hepler.subtitle.manager;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.s0;

/* loaded from: classes6.dex */
public final class UGCVideoSubtitleManagerImp$resDownloadListener$1 implements s0 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UGCVideoSubtitleManagerImp f56524a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UGCVideoSubtitleManagerImp$resDownloadListener$1(UGCVideoSubtitleManagerImp uGCVideoSubtitleManagerImp) {
        this.f56524a = uGCVideoSubtitleManagerImp;
    }

    private final void e(DownloadBean downloadBean, boolean z10) {
        k.d(o0.a(y0.a()), null, null, new UGCVideoSubtitleManagerImp$resDownloadListener$1$downloadCheck$1(this.f56524a, downloadBean, z10, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            eu.a aVar = (eu.a) it.next();
            if (aVar.d() && aVar.b().getStatus() == 6) {
                return true;
            }
        }
        return false;
    }

    @Override // lj.s0
    public void a(String subtitleResId) {
        Intrinsics.h(subtitleResId, "subtitleResId");
        k.d(o0.a(y0.a()), null, null, new UGCVideoSubtitleManagerImp$resDownloadListener$1$deleteSubtitle$1(subtitleResId, null), 3, null);
    }

    @Override // lj.s0
    public void b(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        e(bean, true);
    }

    @Override // lj.s0
    public void c(DownloadBean bean, boolean z10) {
        String str;
        Intrinsics.h(bean, "bean");
        a.C0856a c0856a = lg.a.f68962a;
        String a11 = com.transsion.baselib.report.a.f43394a.a();
        str = this.f56524a.f56521c;
        c0856a.c(a11, str + " 开始下载，检测字幕 firstDownload:" + z10 + "，titleName:" + bean.getTitleName() + ", ep:" + bean.getEp() + " se:" + bean.getSe(), true);
        if (z10) {
            UGCVideoSubtitleManagerImp.l(this.f56524a, bean, null, 2, null);
        } else {
            e(bean, false);
        }
    }
}
