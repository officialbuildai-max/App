package com.transsnet.downloader.ugc.util;

import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsion.ugcvideodetail.api.UGCPageStyle;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.manager.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class UGCDownloadOpenUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final UGCDownloadOpenUtil f59965a = new UGCDownloadOpenUtil();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f59966b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.util.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g j11;
            j11 = UGCDownloadOpenUtil.j();
            return j11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f59967c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.util.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IAudioApi o11;
            o11 = UGCDownloadOpenUtil.o();
            return o11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f59968d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.util.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IFloatingApi p11;
            p11 = UGCDownloadOpenUtil.p();
            return p11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f59969e = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.util.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            jj.a i11;
            i11 = UGCDownloadOpenUtil.i();
            return i11;
        }
    });

    private UGCDownloadOpenUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a i() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g j() {
        return p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jj.a k() {
        return (jj.a) f59969e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.g l() {
        return (com.transsnet.downloader.manager.g) f59966b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi m() {
        return (IAudioApi) f59967c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi n() {
        return (IFloatingApi) f59968d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAudioApi o() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFloatingApi p() {
        return (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0]);
    }

    private final void q(AppCompatActivity appCompatActivity, DownloadBean downloadBean) {
        k.d(o0.a(y0.c()), null, null, new UGCDownloadOpenUtil$openSubjectAudio$1(downloadBean, appCompatActivity, null), 3, null);
    }

    public final void r(View view, String pageName, int i11, DownloadBean bean) {
        Intrinsics.h(view, "view");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(bean, "bean");
        Context context = view.getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        if (!bean.isVideo()) {
            q(appCompatActivity, bean);
            return;
        }
        if (bean.getUgcVideoIsVertical() || bean.isShotTV()) {
            a.C0856a.f(lg.a.f68962a, "UGCVideoOpen", "openUGCLocalVideoDetail vertical video~", false, 4, null);
            Navigator.x(TheRouter.c("/ugc_video/detail").K("id", bean.getUgcVideoId()).K("collection_id", bean.getUgcVideoCollectionId()).K("ops", bean.getOps()).K("videoStyle", UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue()), appCompatActivity, null, 2, null);
        } else {
            a.C0856a.f(lg.a.f68962a, "UGCVideoOpen", "openUGCLocalVideoDetail other", false, 4, null);
            Navigator.x(TheRouter.c("/ugc_video/local_detail").K("id", bean.getUgcVideoId()).K("resource_id", bean.getResourceId()).K("collection_id", bean.getUgcVideoCollectionId()).K("ops", bean.getOps()).K(WebConstants.PAGE_FROM, pageName), appCompatActivity, null, 2, null);
        }
    }
}
