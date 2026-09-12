package com.transsnet.downloader.util;

import android.app.Application;
import android.content.Context;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.fragment.DownloadReDetectorMainDialog;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import com.transsnet.flow.event.sync.event.LocalVideoEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.n0;

/* loaded from: classes7.dex */
public final class LocalVideoNotExistUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalVideoNotExistUtil f60027a = new LocalVideoNotExistUtil();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f60028b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            n0 q11;
            q11 = LocalVideoNotExistUtil.q();
            return q11;
        }
    });

    private LocalVideoNotExistUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Context context, String str, final DownloadBean downloadBean, final Function1 function1) {
        if (downloadBean == null) {
            downloadBean = DownloadEsHelper.f59542m.a().q(str);
        }
        if (downloadBean == null || downloadBean.getType() == 1) {
            function1.invoke(null);
            return;
        }
        DownloadReDetectorMainDialog c11 = DownloadReDetectorMainDialog.INSTANCE.c();
        c11.k0(context, "download_anima");
        c11.A0(new Function1() { // from class: com.transsnet.downloader.util.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l11;
                l11 = LocalVideoNotExistUtil.l(DownloadBean.this, function1, (my.b) obj);
                return l11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(DownloadBean downloadBean, Function1 function1, my.b it) {
        Intrinsics.h(it, "it");
        downloadBean.setPath(DownloadUtil.f60023a.s(downloadBean));
        function1.invoke(downloadBean.getPath());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str, String str2, final boolean z10, final int i11, String str3) {
        DownloadBean q11 = DownloadEsHelper.f59542m.a().q(str);
        if (q11 == null) {
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocalVideoNotExistUtil$delete$2(str, str2, z10, i11, str3, null), 3, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "LocalVideoNotExistUtil", "3 delete, resourceId = " + str, false, 4, null);
        com.transsnet.downloader.manager.p.f59623a.a(Utils.a()).l(q11, new Function1() { // from class: com.transsnet.downloader.util.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o11;
                o11 = LocalVideoNotExistUtil.o(z10, i11, ((Boolean) obj).booleanValue());
                return o11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(LocalVideoNotExistUtil localVideoNotExistUtil, String str, String str2, boolean z10, int i11, String str3, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            str3 = null;
        }
        localVideoNotExistUtil.m(str, str2, z10, i11, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z10, int i11, boolean z11) {
        if (z10) {
            f60027a.u(i11);
        }
        DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, null);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = DownloadRefreshEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String str, String str2, boolean z10, int i11) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocalVideoNotExistUtil$download$1(str, str2, z10, i11, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 q() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 r() {
        return (n0) f60028b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Context context, final String str, final List list) {
        DownloadBean downloadBean;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadBean = null;
                break;
            }
            downloadBean = (DownloadBean) it.next();
            if (downloadBean.getStatus() < 10) {
                a.C0856a.f(lg.a.f68962a, "LocalVideoNotExistUtil", "合集列表, 展示路径选择弹窗2", false, 4, null);
                break;
            }
        }
        if (downloadBean != null) {
            f60027a.k(context, str, downloadBean, new Function1() { // from class: com.transsnet.downloader.util.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit t11;
                    t11 = LocalVideoNotExistUtil.t(list, str, (String) obj);
                    return t11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(List list, String str, String str2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            if (downloadBean.getStatus() < 10) {
                if (str2 != null && str2.length() > 0) {
                    downloadBean.setPath(DownloadUtil.f60023a.s(downloadBean));
                }
                lg.a.f68962a.i("long_video_play", "剧集, 本地源文件不存在，开始重新下载, resourceId = " + str + ", path = " + str2, true);
                LocalVideoNotExistUtil localVideoNotExistUtil = f60027a;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                localVideoNotExistUtil.p(resourceId, downloadBean.getPath(), false, -1);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i11) {
        DownloadListManager a11;
        if (i11 < 0) {
            return;
        }
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        DownloadBean downloadBean = (DownloadBean) aVar.a().K().f();
        if (downloadBean != null) {
            try {
                List<DownloadBean> seriesList = downloadBean.getSeriesList();
                if (seriesList != null) {
                    seriesList.remove(i11);
                }
            } catch (Throwable unused) {
                a11 = DownloadListManager.f60117m.a();
            }
        }
        a11 = aVar.a();
        a11.K().n(downloadBean);
    }

    private final void x(Context context, boolean z10, List list, String str, String str2, boolean z11, int i11) {
        LocalVideoEvent localVideoEvent = new LocalVideoEvent(str, 0L, 0L, false, true, 14, null);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LocalVideoEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, localVideoEvent, 0L);
        my.e eVar = new my.e(true, false);
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = my.e.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.postEvent(name2, eVar, 0L);
        Context context2 = context;
        if (context2 instanceof Application) {
            context2 = com.transsion.baselib.report.l.f43413a.o();
        }
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new LocalVideoNotExistUtil$showErrorDialog$1(context2, z10, str, list, str2, z11, i11, null), 3, null);
    }

    public final void v(Context context, DownloadBean bean, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(bean, "bean");
        boolean z10 = bean.getStatus() == 10;
        List<DownloadBean> seriesList = bean.getSeriesList();
        String resourceId = bean.getResourceId();
        if (resourceId == null) {
            resourceId = bean.getUrl();
        }
        x(context, z10, seriesList, resourceId, bean.getPath(), bean.isSeries(), i11);
    }

    public final void w(Context context, String resourceId, String str, boolean z10, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(resourceId, "resourceId");
        x(context, false, null, resourceId, str, z10, i11);
    }
}
