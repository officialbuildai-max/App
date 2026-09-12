package com.transsnet.downloader.manager;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.fissionapi.IFissionProvider;
import com.transsnet.downloader.fragment.DownloadedShortsDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class FinishDownloadHelper extends lj.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f59594a = "FinishDownloadHelper";

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f59595b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.v
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a o11;
            o11 = FinishDownloadHelper.o();
            return o11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f59596c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.w
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IFissionProvider l11;
            l11 = FinishDownloadHelper.l();
            return l11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFissionProvider l() {
        return (IFissionProvider) TheRouter.d(IFissionProvider.class, new Object[0]);
    }

    private final IFissionProvider m() {
        return (IFissionProvider) this.f59596c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qy.a n() {
        return (qy.a) this.f59595b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a o() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    private final void p(DownloadBean downloadBean) {
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null && (resourceId = downloadBean.getPostId()) == null) {
            resourceId = downloadBean.getUrl();
        }
        if (resourceId == null || resourceId.length() == 0) {
            return;
        }
        String str = "SHORTS_DIALOG_SHOWN_" + resourceId;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        if (bVar.b().getBoolean(str, false)) {
            return;
        }
        Activity b11 = com.blankj.utilcode.util.a.b();
        if (com.blankj.utilcode.util.c.l() && (b11 instanceof FragmentActivity)) {
            FragmentActivity fragmentActivity = (FragmentActivity) b11;
            if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
                return;
            }
            try {
                FragmentManager supportFragmentManager = ((FragmentActivity) b11).getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                Fragment k02 = supportFragmentManager.k0("DownloadedShortsDialog");
                if (k02 instanceof DialogFragment) {
                    ((DialogFragment) k02).dismissAllowingStateLoss();
                }
                DownloadedShortsDialog.INSTANCE.a(resourceId).k0(b11, "DownloadedShortsDialog");
                com.transsion.baselib.helper.a.f43316a.c("", "short_download_view");
                bVar.b().putBoolean(str, true);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // lj.a, lj.m0
    public void e(DownloadBean bean, String str) {
        Intrinsics.h(bean, "bean");
        super.e(bean, str);
        IFissionProvider m11 = m();
        if (m11 != null && m11.enable()) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new FinishDownloadHelper$onDownloadSuccess$1(bean, this, null), 3, null);
        }
        if (bean.isShorts()) {
            p(bean);
        }
    }
}
