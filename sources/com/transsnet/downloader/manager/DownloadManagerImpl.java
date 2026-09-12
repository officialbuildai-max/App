package com.transsnet.downloader.manager;

import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsnet.downloader.callback.DownloadTaskStat;
import com.transsnet.downloader.core.DownloadResponseImpl;
import com.transsnet.downloader.core.DownloadTaskImpl;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.notification.DownloadNotificationUtils;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import lj.m0;
import lj.s0;

/* loaded from: classes.dex */
public final class DownloadManagerImpl implements g, com.transsnet.downloader.core.task.c {

    /* renamed from: y, reason: collision with root package name */
    public static final a f59556y = new a(null);

    /* renamed from: z, reason: collision with root package name */
    private static final Lazy f59557z = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.manager.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadManagerImpl p02;
            p02 = DownloadManagerImpl.p0();
            return p02;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private com.transsnet.downloader.core.c f59561d;

    /* renamed from: e, reason: collision with root package name */
    private oy.c f59562e;

    /* renamed from: f, reason: collision with root package name */
    private long f59563f;

    /* renamed from: g, reason: collision with root package name */
    private nh.n f59564g;

    /* renamed from: j, reason: collision with root package name */
    private ny.b f59567j;

    /* renamed from: t, reason: collision with root package name */
    private final com.transsnet.downloader.proxy.b f59577t;

    /* renamed from: a, reason: collision with root package name */
    private String f59558a = "DownloadImp";

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap f59559b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private List f59560c = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap f59565h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap f59566i = new ConcurrentHashMap();

    /* renamed from: k, reason: collision with root package name */
    private final Set f59568k = new CopyOnWriteArraySet();

    /* renamed from: l, reason: collision with root package name */
    private final Set f59569l = new CopyOnWriteArraySet();

    /* renamed from: m, reason: collision with root package name */
    private final Set f59570m = new CopyOnWriteArraySet();

    /* renamed from: n, reason: collision with root package name */
    private final Set f59571n = new CopyOnWriteArraySet();

    /* renamed from: o, reason: collision with root package name */
    private final Lazy f59572o = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            jj.a i02;
            i02 = DownloadManagerImpl.i0();
            return i02;
        }
    });

    /* renamed from: p, reason: collision with root package name */
    private DownloadTaskStat f59573p = new DownloadTaskStat(0, 0, 0, 0);

    /* renamed from: q, reason: collision with root package name */
    private Set f59574q = new CopyOnWriteArraySet();

    /* renamed from: r, reason: collision with root package name */
    private Set f59575r = new CopyOnWriteArraySet();

    /* renamed from: s, reason: collision with root package name */
    private final Lazy f59576s = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a Q0;
            Q0 = DownloadManagerImpl.Q0();
            return Q0;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    private final n0 f59578u = o0.a(y0.c());

    /* renamed from: v, reason: collision with root package name */
    private final n0 f59579v = o0.a(y0.b());

    /* renamed from: w, reason: collision with root package name */
    private final Lazy f59580w = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            lj.n0 G0;
            G0 = DownloadManagerImpl.G0();
            return G0;
        }
    });

    /* renamed from: x, reason: collision with root package name */
    private final Lazy f59581x = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IPostDetailApi A0;
            A0 = DownloadManagerImpl.A0();
            return A0;
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$3", f = "DownloadManagerImpl.kt", l = {1265}, m = "invokeSuspend")
    /* renamed from: com.transsnet.downloader.manager.DownloadManagerImpl$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                DownloadManagerImpl downloadManagerImpl = DownloadManagerImpl.this;
                this.label = 1;
                if (downloadManagerImpl.C(this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f67184a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return (g) DownloadManagerImpl.f59557z.getValue();
        }
    }

    public DownloadManagerImpl(oy.c cVar) {
        if (cVar == null) {
            this.f59562e = new oy.c();
        } else {
            this.f59562e = cVar;
        }
        com.transsnet.downloader.proxy.b bVar = new com.transsnet.downloader.proxy.b();
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        bVar.g(a11);
        m0 e11 = bVar.e();
        if (e11 != null) {
            e(e11);
        }
        this.f59577t = bVar;
        DownloadEsHelper.f59542m.a();
        this.f59561d = new DownloadResponseImpl(this, this.f59574q, this.f59562e);
        DownloadNotificationUtils.f59629a.E();
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new AnonymousClass3(null), 3, null);
        H0();
        DownloadListManager.I(DownloadListManager.f60117m.a(), false, false, null, 7, null);
        e(new FinishDownloadHelper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPostDetailApi A0() {
        return (IPostDetailApi) TheRouter.d(IPostDetailApi.class, new Object[0]);
    }

    private final boolean B0(DownloadBean downloadBean) {
        com.transsnet.downloader.core.c cVar;
        if (A(downloadBean) || downloadBean.isDownloading()) {
            lg.a.f68962a.p(this.f59558a, new String[]{"preDownload, isDownloading name = " + downloadBean.getName() + " "}, true);
            return false;
        }
        if (nh.m.f70597a.e() && downloadBean.isVideo()) {
            Long size = downloadBean.getSize();
            if ((size != null ? size.longValue() : 0L) >= 52428800) {
                if (downloadBean.getProgress() >= 5242880) {
                    lg.a.f68962a.p("download", new String[]{"preDownload, is downloaded do nothing, name = " + downloadBean.getTotalTitleName()}, true);
                    return false;
                }
                if (this.f59565h.size() > 0) {
                    ConcurrentHashMap concurrentHashMap = this.f59566i;
                    String resourceId = downloadBean.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean.getUrl();
                    }
                    concurrentHashMap.put(resourceId, downloadBean);
                    lg.a.f68962a.p("download", new String[]{"preDownload, 当前已有任务在预下载，加入等待队列, name = " + downloadBean.getTotalTitleName()}, true);
                    return false;
                }
                z0(downloadBean);
                downloadBean.setPreDownload(true);
                ConcurrentHashMap concurrentHashMap2 = this.f59566i;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                oy.c cVar2 = this.f59562e;
                com.transsnet.downloader.core.task.b bVar = null;
                if (cVar2 != null && (cVar = this.f59561d) != null) {
                    bVar = k0(cVar2, cVar, downloadBean);
                }
                lg.a.f68962a.p("download", new String[]{"start preDownload, name = " + downloadBean.getTotalTitleName()}, true);
                if (bVar != null) {
                    ConcurrentHashMap concurrentHashMap3 = this.f59565h;
                    String resourceId3 = downloadBean.getResourceId();
                    if (resourceId3 == null) {
                        resourceId3 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.put(resourceId3, bVar);
                }
                downloadBean.setStatus(1);
                com.transsnet.downloader.core.c cVar3 = this.f59561d;
                if (cVar3 != null) {
                    cVar3.a(downloadBean);
                }
                if (bVar != null) {
                    bVar.start();
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        if (nh.m.f70597a.e()) {
            a.C0856a.f(lg.a.f68962a, this.f59558a, "preDownloadNextTask, pool size = " + this.f59566i.size(), false, 4, null);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.f59566i.entrySet()) {
                String str = (String) entry.getKey();
                DownloadBean downloadBean = (DownloadBean) entry.getValue();
                if (downloadBean.getProgress() < 5242880) {
                    if (downloadBean.getStatus() == 6) {
                        if (downloadBean.getErrorCount() < 3) {
                            downloadBean.setErrorCount(downloadBean.getErrorCount() + 1);
                        }
                    }
                    lg.a.f68962a.p("download", new String[]{"preDownloadNextTask, try start, name = " + downloadBean.getTotalTitleName()}, true);
                    B0(downloadBean);
                    break;
                }
                a.C0856a.f(lg.a.f68962a, this.f59558a, "preDownloadNextTask, is downloaded do nothing, name = " + downloadBean.getName(), false, 4, null);
                arrayList.add(str);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f59566i.remove((String) it.next());
            }
        }
    }

    private final void D0(DownloadBean downloadBean) {
        if (ThreadUtils.j()) {
            E0(downloadBean);
        } else {
            kotlinx.coroutines.k.d(this.f59578u, null, null, new DownloadManagerImpl$prepareDownload$1(this, downloadBean, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(DownloadBean downloadBean) {
        com.transsnet.downloader.core.c cVar;
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("download", n0() + " --> prepareDownloadNext() --> 2- prepareDownload,name = " + downloadBean.getTotalTitleName() + ",resourceId = " + downloadBean.getResourceId() + "，subjectId = " + downloadBean.getSubjectId() + ", status = " + downloadBean.getStatus(), true);
        if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 1) {
            a.C0856a.f(c0856a, "download", n0() + " --> prepareDownloadNext() --> prepareDownload, status-- name = " + downloadBean.getName() + " ", false, 4, null);
            if (downloadBean.getIsPreDownload()) {
                downloadBean.setPreDownload(false);
                a.C0856a.f(c0856a, "download", n0() + " --> prepareDownloadNext() --> preDownload 预下载转正变成当前下载 = " + downloadBean.getName() + " , epse = " + downloadBean.getEpse(), false, 4, null);
                ConcurrentHashMap concurrentHashMap = this.f59565h;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                com.transsnet.downloader.core.task.b bVar = (com.transsnet.downloader.core.task.b) concurrentHashMap.get(resourceId);
                Set set = this.f59568k;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set.remove(resourceId2);
                Set set2 = this.f59570m;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set2.remove(resourceId3);
                Set set3 = this.f59569l;
                String resourceId4 = downloadBean.getResourceId();
                if (resourceId4 == null) {
                    resourceId4 = downloadBean.getUrl();
                }
                set3.add(resourceId4);
                downloadBean.setStatus(2);
                com.transsnet.downloader.core.c cVar2 = this.f59561d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean);
                }
                S0();
                if (bVar != null) {
                    R0();
                    ConcurrentHashMap concurrentHashMap2 = this.f59559b;
                    String resourceId5 = downloadBean.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean.getUrl();
                    }
                    concurrentHashMap2.put(resourceId5, bVar);
                    ConcurrentHashMap concurrentHashMap3 = this.f59565h;
                    String resourceId6 = downloadBean.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.remove(resourceId6);
                }
            }
            if (nh.m.f70597a.e()) {
                return;
            }
            c0856a.p("download", new String[]{n0() + " --> prepareDownloadNext() --> not net， 2 error"}, true);
            downloadBean.setStatus(6);
            downloadBean.setException(new DownloadException(9, DownloadException.EXCEPTION_MESSAGE_NO_NET));
            v(downloadBean);
            return;
        }
        downloadBean.setPreDownload(false);
        ConcurrentHashMap concurrentHashMap4 = this.f59559b;
        String resourceId7 = downloadBean.getResourceId();
        if (resourceId7 == null) {
            resourceId7 = downloadBean.getUrl();
        }
        if (concurrentHashMap4.containsKey(resourceId7)) {
            if (downloadBean.isDownloading()) {
                c0856a.p("download", new String[]{n0() + " --> prepareDownloadNext() --> prepareDownload, isDownloading name = " + downloadBean.getName()}, true);
                return;
            }
            ConcurrentHashMap concurrentHashMap5 = this.f59559b;
            String resourceId8 = downloadBean.getResourceId();
            if (resourceId8 == null) {
                resourceId8 = downloadBean.getUrl();
            }
            concurrentHashMap5.remove(resourceId8);
            a.C0856a.f(c0856a, "download", n0() + " --> prepareDownloadNext() --> prepareDownload, isDownloading, error status , remove  name = " + downloadBean.getName(), false, 4, null);
        }
        if (u0()) {
            if (!B0(downloadBean)) {
                downloadBean.setStatus(3);
                com.transsnet.downloader.core.c cVar3 = this.f59561d;
                if (cVar3 != null) {
                    cVar3.a(downloadBean);
                }
            }
            Set set4 = this.f59568k;
            String resourceId9 = downloadBean.getResourceId();
            if (resourceId9 == null) {
                resourceId9 = downloadBean.getUrl();
            }
            set4.add(resourceId9);
            c0856a.c("download", n0() + " --> prepareDownloadNext() --> 1--prepareDownload, name = " + downloadBean.getName() + ", add wait, status = " + downloadBean.getStatus() + ",loading  = " + this.f59569l.size() + ", error  = " + this.f59570m.size() + " , wait  = " + this.f59568k.size() + " ", true);
            S0();
            return;
        }
        ConcurrentHashMap concurrentHashMap6 = this.f59566i;
        String resourceId10 = downloadBean.getResourceId();
        if (resourceId10 == null) {
            resourceId10 = downloadBean.getUrl();
        }
        concurrentHashMap6.remove(resourceId10);
        ConcurrentHashMap concurrentHashMap7 = this.f59565h;
        String resourceId11 = downloadBean.getResourceId();
        if (resourceId11 == null) {
            resourceId11 = downloadBean.getUrl();
        }
        concurrentHashMap7.remove(resourceId11);
        if (this.f59565h.isEmpty() && !this.f59566i.isEmpty()) {
            C0();
        }
        oy.c cVar4 = this.f59562e;
        com.transsnet.downloader.core.task.b bVar2 = null;
        if (cVar4 != null && (cVar = this.f59561d) != null) {
            bVar2 = k0(cVar4, cVar, downloadBean);
        }
        com.transsnet.downloader.core.task.b bVar3 = bVar2;
        if (bVar3 != null) {
            ConcurrentHashMap concurrentHashMap8 = this.f59559b;
            String resourceId12 = downloadBean.getResourceId();
            if (resourceId12 == null) {
                resourceId12 = downloadBean.getUrl();
            }
            concurrentHashMap8.put(resourceId12, bVar3);
        }
        downloadBean.setStatus(1);
        com.transsnet.downloader.core.c cVar5 = this.f59561d;
        if (cVar5 != null) {
            cVar5.a(downloadBean);
        }
        j0(downloadBean);
        Set set5 = this.f59568k;
        String resourceId13 = downloadBean.getResourceId();
        if (resourceId13 == null) {
            resourceId13 = downloadBean.getUrl();
        }
        set5.remove(resourceId13);
        Set set6 = this.f59570m;
        String resourceId14 = downloadBean.getResourceId();
        if (resourceId14 == null) {
            resourceId14 = downloadBean.getUrl();
        }
        set6.remove(resourceId14);
        Set set7 = this.f59569l;
        String resourceId15 = downloadBean.getResourceId();
        if (resourceId15 == null) {
            resourceId15 = downloadBean.getUrl();
        }
        set7.add(resourceId15);
        a.C0856a.v(c0856a, "download", n0() + " --> prepareDownloadNext() --> 1--prepareDownload, name = " + downloadBean.getName() + ", add loading, loading  = " + this.f59569l.size() + ", error  = " + this.f59570m.size() + " , wait  = " + this.f59568k.size() + " ", false, 4, null);
        S0();
        if (bVar3 != null) {
            bVar3.start();
        }
    }

    private final void F0() {
        for (DownloadBean downloadBean : this.f59560c) {
            if (downloadBean.getStatus() == 3 || downloadBean.getStatus() == 6 || (downloadBean.isDownloading() && downloadBean.getIsPreDownload())) {
                if (downloadBean.getStatus() == 6) {
                    if (!nh.m.f70597a.e() || downloadBean.isNoNetError()) {
                        a.C0856a.f(lg.a.f68962a, this.f59558a, "prepareDownloadNextTask, no net，continue, name = " + downloadBean.getName(), false, 4, null);
                    } else if (downloadBean.getErrorCount() >= 3) {
                        lg.a.f68962a.c("download", "prepareDownloadNextTask, 失败超限~不再执行，name = " + downloadBean.getName(), true);
                    } else {
                        downloadBean.setErrorCount(downloadBean.getErrorCount() + 1);
                    }
                }
                lg.a.f68962a.c("download", "prepareDownloadNextTask, name = " + downloadBean.getName() + ", from next, status: " + downloadBean.getStatus() + ",isPreDownload:" + downloadBean.getIsPreDownload() + ", progress: " + downloadBean.getProgress() + ",size:" + downloadBean.getSize(), true);
                Set set = this.f59568k;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                set.remove(resourceId);
                Set set2 = this.f59570m;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set2.remove(resourceId2);
                D0(downloadBean);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lj.n0 G0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).q1();
    }

    private final void H0() {
        nh.n nVar = new nh.n() { // from class: com.transsnet.downloader.manager.DownloadManagerImpl$registerNetwork$1
            private final void a() {
                String str;
                com.transsnet.downloader.proxy.b bVar;
                List<DownloadBean> list;
                String str2;
                String str3;
                a.C0856a c0856a = lg.a.f68962a;
                str = DownloadManagerImpl.this.f59558a;
                a.C0856a.f(c0856a, str, "---------Download, Network onConnected", false, 4, null);
                bVar = DownloadManagerImpl.this.f59577t;
                DownloadBean d11 = bVar.d();
                if (d11 != null) {
                    DownloadManagerImpl downloadManagerImpl = DownloadManagerImpl.this;
                    if (!d11.isRemoved()) {
                        str3 = downloadManagerImpl.f59558a;
                        a.C0856a.f(c0856a, str3, "onConnected, start DownloadingPlay, name = " + d11.getName() + ",epse = " + d11.getEpse() + ",  cur status = " + d11.getStatus(), false, 4, null);
                        downloadManagerImpl.t(d11, true);
                    }
                }
                list = DownloadManagerImpl.this.f59560c;
                DownloadManagerImpl downloadManagerImpl2 = DownloadManagerImpl.this;
                for (DownloadBean downloadBean : list) {
                    if (downloadBean.getStatus() == 6 || downloadBean.getStatus() == 3 || downloadBean.isDownloading()) {
                        a.C0856a c0856a2 = lg.a.f68962a;
                        str2 = downloadManagerImpl2.f59558a;
                        c0856a2.c(str2, "onConnected, caches, name = " + downloadBean.getName() + ",epse = " + downloadBean.getEpse() + ",  cur status = " + downloadBean.getStatus(), true);
                        if (downloadBean.isDownloading()) {
                            downloadBean.setPreDownload(false);
                            downloadBean.setStatus(3);
                        }
                        downloadManagerImpl2.t(downloadBean, true);
                    }
                }
                kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadManagerImpl$registerNetwork$1$netConnected$3(DownloadManagerImpl.this, null), 3, null);
            }

            @Override // nh.n
            public void onConnected() {
                a();
            }

            @Override // nh.n
            public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
                Intrinsics.h(network, "network");
                Intrinsics.h(networkCapabilities, "networkCapabilities");
                a();
            }

            @Override // nh.n
            public void onDisconnected() {
                String str;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                a.C0856a c0856a = lg.a.f68962a;
                str = DownloadManagerImpl.this.f59558a;
                a.C0856a.f(c0856a, str, "---------Download, Network onDisconnected, cancel all request---------", false, 4, null);
                try {
                    com.transsnet.downloader.core.b.f58736c.a().c().dispatcher().cancelAll();
                } catch (Throwable unused) {
                }
                concurrentHashMap = DownloadManagerImpl.this.f59559b;
                concurrentHashMap.clear();
                concurrentHashMap2 = DownloadManagerImpl.this.f59566i;
                concurrentHashMap2.clear();
                concurrentHashMap3 = DownloadManagerImpl.this.f59565h;
                concurrentHashMap3.clear();
            }
        };
        this.f59564g = nVar;
        nh.m.f70597a.l(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, Function1 function1, String str, boolean z10) {
        downloadManagerImpl.K0(downloadBean);
        ConcurrentHashMap concurrentHashMap = downloadManagerImpl.f59559b;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = downloadManagerImpl.f59566i;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = downloadManagerImpl.f59565h;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        Iterator it = downloadManagerImpl.f59560c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadBean downloadBean2 = (DownloadBean) it.next();
            if (Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                downloadManagerImpl.f59560c.remove(downloadBean2);
                a.C0856a.f(lg.a.f68962a, downloadManagerImpl.f59558a, "remove ~~", false, 4, null);
                break;
            }
        }
        com.transsnet.downloader.core.c cVar = downloadManagerImpl.f59561d;
        if (cVar != null) {
            cVar.a(downloadBean);
        }
        kotlinx.coroutines.k.d(downloadManagerImpl.f59579v, null, null, new DownloadManagerImpl$remove$1$1(str, downloadBean, null), 3, null);
        downloadManagerImpl.F0();
        my.e eVar = new my.e(true, false);
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = my.e.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, eVar, 0L);
        my.a aVar = new my.a();
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = my.a.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.postEvent(name2, aVar, 0L);
        if (z10) {
            downloadManagerImpl.t0(downloadBean.getSubjectId() + downloadBean.getSe() + downloadBean.getEp());
        }
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z10));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(Function1 function1, DownloadManagerImpl downloadManagerImpl, boolean z10) {
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z10));
        }
        a.C0856a.f(lg.a.f68962a, downloadManagerImpl.f59558a, "remove success ,prepareDownloadNextTask", false, 4, null);
        downloadManagerImpl.S0();
        downloadManagerImpl.F0();
        return Unit.f67184a;
    }

    private final void K0(DownloadBean downloadBean) {
        Set set = this.f59569l;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.f59570m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        Set set3 = this.f59568k;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        set3.remove(resourceId3);
        Set set4 = this.f59571n;
        String resourceId4 = downloadBean.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean.getUrl();
        }
        set4.remove(resourceId4);
        S0();
    }

    private final void L0(final List list, final int i11, final Function1 function1) {
        final DownloadBean downloadBean = (DownloadBean) list.get(i11);
        final String path = downloadBean.getPath();
        l0(downloadBean, false, new Function1() { // from class: com.transsnet.downloader.manager.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = DownloadManagerImpl.M0(DownloadBean.this, this, i11, list, function1, path, ((Boolean) obj).booleanValue());
                return M0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(DownloadBean downloadBean, DownloadManagerImpl downloadManagerImpl, int i11, List list, Function1 function1, String str, boolean z10) {
        lg.a.f68962a.u("download", "removeDownload ,db success, remove file, name = " + downloadBean.getName() + ", resourceId：" + downloadBean.getResourceId(), true);
        downloadManagerImpl.K0(downloadBean);
        ConcurrentHashMap concurrentHashMap = downloadManagerImpl.f59559b;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = downloadManagerImpl.f59566i;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = downloadManagerImpl.f59565h;
        String resourceId3 = downloadBean.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        downloadManagerImpl.f59560c.remove(downloadBean);
        com.transsnet.downloader.core.c cVar = downloadManagerImpl.f59561d;
        if (cVar != null) {
            cVar.a(downloadBean);
        }
        kotlinx.coroutines.k.d(downloadManagerImpl.f59579v, null, null, new DownloadManagerImpl$removeDownload$1$1(str, downloadBean, null), 3, null);
        if (i11 >= list.size() - 1) {
            my.e eVar = new my.e(true, false);
            AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
            FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name = my.e.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, eVar, 0L);
            my.a aVar = new my.a();
            FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
            String name2 = my.a.class.getName();
            Intrinsics.g(name2, "getName(...)");
            flowEventBus2.postEvent(name2, aVar, 0L);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else {
            downloadManagerImpl.L0(list, i11 + 1, function1);
        }
        return Unit.f67184a;
    }

    private final void N0(DownloadBean downloadBean) {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadManagerImpl$requestNewSource$1(this, downloadBean, null), 3, null);
    }

    private final void O0(boolean z10) {
        if (v0()) {
            lg.a.f68962a.c("download", "resumeAll, " + z10, true);
            for (DownloadBean downloadBean : this.f59560c) {
                lg.a.f68962a.c("download", "resumeAll, " + z10 + ", pauseInner:" + downloadBean.getTotalTitleName() + ", isAutoPause:" + downloadBean.getIsAutoPause(), true);
                if (!z10) {
                    D0(downloadBean);
                } else if (downloadBean.getIsAutoPause() && !downloadBean.isDownloading()) {
                    if (this.f59559b.isEmpty()) {
                        D0(downloadBean);
                    } else {
                        downloadBean.setStatus(3);
                        com.transsnet.downloader.core.c cVar = this.f59561d;
                        if (cVar != null) {
                            cVar.a(downloadBean);
                        }
                    }
                }
            }
        }
    }

    private final void P0(List list) {
        boolean z10;
        DownloadBean downloadBean;
        DownloadBean downloadBean2;
        Iterator it;
        a.C0856a.f(lg.a.f68962a, this.f59558a, "resumeAllDownloading , uncomplete size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        int i11 = 4;
        int i12 = 2;
        int i13 = 3;
        int i14 = 1;
        if (list != null) {
            Iterator it2 = list.iterator();
            z10 = false;
            downloadBean = null;
            downloadBean2 = null;
            while (it2.hasNext()) {
                DownloadBean downloadBean3 = (DownloadBean) it2.next();
                int status = downloadBean3.getStatus();
                if (status == i14 || status == i12) {
                    it = it2;
                    Iterator it3 = this.f59560c.iterator();
                    boolean z11 = false;
                    while (it3.hasNext()) {
                        if (Intrinsics.c(downloadBean3.getResourceId(), ((DownloadBean) it3.next()).getResourceId())) {
                            z11 = true;
                        }
                    }
                    ConcurrentHashMap concurrentHashMap = this.f59559b;
                    String resourceId = downloadBean3.getResourceId();
                    if (resourceId == null) {
                        resourceId = downloadBean3.getUrl();
                    }
                    if (!concurrentHashMap.containsKey(resourceId)) {
                        z11 = false;
                    }
                    if (downloadBean3.getIsPreDownload()) {
                        z11 = false;
                    }
                    if (!z11) {
                        a.C0856a c0856a = lg.a.f68962a;
                        String resourceId2 = downloadBean3.getResourceId();
                        if (resourceId2 == null) {
                            resourceId2 = downloadBean3.getUrl();
                        }
                        a.C0856a.f(c0856a, "DownloadStatus", "init resume , resId = " + resourceId2, false, 4, null);
                        String str = this.f59558a;
                        String resourceId3 = downloadBean3.getResourceId();
                        if (resourceId3 == null) {
                            resourceId3 = downloadBean3.getUrl();
                        }
                        c0856a.c(str, "resumeAllDownloading init resume  , resId = " + resourceId3 + ", name = " + downloadBean3.getName(), true);
                        downloadBean3.setStatus(3);
                        t(downloadBean3, true);
                    }
                    z10 = true;
                } else if (status == i13 || status == i11) {
                    if (downloadBean == null) {
                        downloadBean = downloadBean3;
                    }
                    if (downloadBean3.getStatus() == i13 && downloadBean3.getProgress() < 5242880) {
                        a.C0856a.f(lg.a.f68962a, this.f59558a, "init-----preDownload ，add to pool, name = " + downloadBean3.getName() + ", epse = " + downloadBean3.getEpse(), false, 4, null);
                        ConcurrentHashMap concurrentHashMap2 = this.f59566i;
                        String resourceId4 = downloadBean3.getResourceId();
                        if (resourceId4 == null) {
                            resourceId4 = downloadBean3.getUrl();
                        }
                        concurrentHashMap2.put(resourceId4, downloadBean3);
                    }
                    a.C0856a c0856a2 = lg.a.f68962a;
                    a.C0856a.f(c0856a2, "DownloadStatus", "init add waitSet , resId = " + downloadBean3.getResourceId() + ", name = " + downloadBean3.getName(), false, 4, null);
                    it = it2;
                    a.C0856a.f(c0856a2, this.f59558a, "init add waitSet , resId = " + downloadBean3.getResourceId() + ", epse = " + downloadBean3.getEpse() + ", name = " + downloadBean3.getName() + ", status = " + downloadBean3.getStatus() + ",progress = " + downloadBean3.getProgress(), false, 4, null);
                    Set set = this.f59568k;
                    String resourceId5 = downloadBean3.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean3.getUrl();
                    }
                    set.add(resourceId5);
                } else {
                    if (status == 6) {
                        if (downloadBean2 == null) {
                            downloadBean2 = downloadBean3;
                        }
                        a.C0856a c0856a3 = lg.a.f68962a;
                        a.C0856a.f(c0856a3, "DownloadStatus", "init add errorSet , resId = " + downloadBean3.getResourceId() + ", name = " + downloadBean3.getName() + ", name = " + downloadBean3.getName(), false, 4, null);
                        String str2 = this.f59558a;
                        String resourceId6 = downloadBean3.getResourceId();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("init add errorSet , resId = ");
                        sb2.append(resourceId6);
                        a.C0856a.f(c0856a3, str2, sb2.toString(), false, 4, null);
                        Set set2 = this.f59570m;
                        String resourceId7 = downloadBean3.getResourceId();
                        if (resourceId7 == null) {
                            resourceId7 = downloadBean3.getUrl();
                        }
                        set2.add(resourceId7);
                    }
                    it = it2;
                }
                S0();
                if (!this.f59560c.contains(downloadBean3)) {
                    lg.a.f68962a.c(this.f59558a, "resumeAllDownloading， add 2 cache, name = " + downloadBean3.getName(), true);
                    this.f59560c.add(downloadBean3);
                }
                it2 = it;
                i11 = 4;
                i12 = 2;
                i13 = 3;
                i14 = 1;
            }
        } else {
            z10 = false;
            downloadBean = null;
            downloadBean2 = null;
        }
        if (z10) {
            return;
        }
        if (downloadBean != null) {
            if (!(downloadBean.getStatus() == 4)) {
                lg.a.f68962a.c(this.f59558a, "------ has no loading, use wait, name = " + downloadBean.getName(), true);
                Set set3 = this.f59568k;
                String resourceId8 = downloadBean.getResourceId();
                if (resourceId8 == null) {
                    resourceId8 = downloadBean.getUrl();
                }
                set3.remove(resourceId8);
                downloadBean.setStatus(3);
                g.a.a(this, downloadBean, false, 2, null);
                S0();
                return;
            }
        }
        if (downloadBean2 != null) {
            lg.a.f68962a.c(this.f59558a, "------ has no loading, use error, name = " + downloadBean2.getName(), true);
            Set set4 = this.f59570m;
            String resourceId9 = downloadBean2.getResourceId();
            if (resourceId9 == null) {
                resourceId9 = downloadBean2.getUrl();
            }
            set4.remove(resourceId9);
            downloadBean2.setStatus(3);
            g.a.a(this, downloadBean2, false, 2, null);
            S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a Q0() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    private final void R0() {
        String str;
        int size = this.f59559b.size();
        oy.c cVar = this.f59562e;
        if (size >= (cVar != null ? cVar.e() : 2)) {
            Iterator it = this.f59559b.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                str = (String) entry.getKey();
                DownloadBean b11 = ((com.transsnet.downloader.core.task.b) entry.getValue()).b();
                b11.setStatus(3);
                com.transsnet.downloader.core.c cVar2 = this.f59561d;
                if (cVar2 != null) {
                    cVar2.a(b11);
                }
                Set set = this.f59569l;
                String resourceId = b11.getResourceId();
                if (resourceId == null) {
                    resourceId = b11.getUrl();
                }
                set.remove(resourceId);
                Set set2 = this.f59568k;
                String resourceId2 = b11.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = b11.getUrl();
                }
                set2.add(resourceId2);
                lg.a.f68962a.c("download", "有其他资源进入边下边播 当前资源转换为waiting setCurDownloadingToWait() --> 2--downloading2wait,resourceId=" + b11.getResourceId() + ",name = " + b11.getTotalTitleName() + " ", true);
                S0();
            } else {
                str = null;
            }
            if (str != null) {
            }
        }
    }

    private final void S0() {
        ny.b bVar = this.f59567j;
        if (bVar != null) {
            this.f59573p.setWaitCount(this.f59568k.size());
            this.f59573p.setLoadingCount(this.f59569l.size());
            this.f59573p.setErrorCount(this.f59570m.size());
            this.f59573p.setDoneCount(this.f59571n.size());
            a.C0856a.f(lg.a.f68962a, this.f59558a, "-------- statChange, downloadStat = " + this.f59573p + " ", false, 4, null);
            bVar.a(this.f59573p);
        }
    }

    private final void T0(DownloadBean downloadBean) {
        if (downloadBean.getRootPathType() == 1) {
            downloadBean.setTransferFailed(false);
        } else {
            if (downloadBean.getType() == 1) {
                return;
            }
            kotlinx.coroutines.k.d(this.f59579v, null, null, new DownloadManagerImpl$transferFile$1(downloadBean, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(DownloadBean downloadBean) {
        Set set = this.f59570m;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.add(resourceId);
        Set set2 = this.f59569l;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        S0();
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(DownloadBean downloadBean) {
        Set set = this.f59568k;
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.f59570m;
        String resourceId2 = downloadBean.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean.getUrl();
        }
        set2.remove(resourceId2);
        D0(downloadBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(DownloadBean downloadBean) {
        DownloadBean downloadBean2;
        com.transsnet.downloader.core.c cVar;
        if (downloadBean.isCompleted() || downloadBean.isRemoved()) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.v(c0856a, this.f59558a, "1- waitDownloadingAndStartNewTask,进入边下边播 subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",name = " + downloadBean.getTotalTitleName() + ",status = " + downloadBean.getStatus(), false, 4, null);
        downloadBean.setDownloadingPlay(true);
        boolean z10 = false;
        if (downloadBean.getStatus() == 2 || downloadBean.getStatus() == 1) {
            c0856a.p("download", new String[]{"下载中的 变成当前边下边播的 waitDownloadingAndStartNewTask, subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",status-- name = " + downloadBean.getName() + " "}, true);
            if (downloadBean.getIsPreDownload()) {
                downloadBean.setPreDownload(false);
                c0856a.p("download", new String[]{"preDownload 预下载的 转正变成当前边下边播的 subjectId=" + downloadBean.getSubjectId() + ",resourceId=" + downloadBean.getResourceId() + ",name= " + downloadBean.getName() + " , epse = " + downloadBean.getEpse()}, true);
                Set set = this.f59568k;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                set.remove(resourceId);
                Set set2 = this.f59570m;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                set2.remove(resourceId2);
                Set set3 = this.f59569l;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set3.add(resourceId3);
                downloadBean.setStatus(2);
                com.transsnet.downloader.core.c cVar2 = this.f59561d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean);
                }
                S0();
                ConcurrentHashMap concurrentHashMap = this.f59565h;
                String resourceId4 = downloadBean.getResourceId();
                if (resourceId4 == null) {
                    resourceId4 = downloadBean.getUrl();
                }
                com.transsnet.downloader.core.task.b bVar = (com.transsnet.downloader.core.task.b) concurrentHashMap.get(resourceId4);
                if (bVar != null) {
                    R0();
                    ConcurrentHashMap concurrentHashMap2 = this.f59559b;
                    String resourceId5 = downloadBean.getResourceId();
                    if (resourceId5 == null) {
                        resourceId5 = downloadBean.getUrl();
                    }
                    concurrentHashMap2.put(resourceId5, bVar);
                    ConcurrentHashMap concurrentHashMap3 = this.f59565h;
                    String resourceId6 = downloadBean.getResourceId();
                    if (resourceId6 == null) {
                        resourceId6 = downloadBean.getUrl();
                    }
                    concurrentHashMap3.remove(resourceId6);
                    return;
                }
                return;
            }
            return;
        }
        ConcurrentHashMap concurrentHashMap4 = this.f59566i;
        String resourceId7 = downloadBean.getResourceId();
        if (resourceId7 == null) {
            resourceId7 = downloadBean.getUrl();
        }
        concurrentHashMap4.remove(resourceId7);
        ConcurrentHashMap concurrentHashMap5 = this.f59565h;
        String resourceId8 = downloadBean.getResourceId();
        if (resourceId8 == null) {
            resourceId8 = downloadBean.getUrl();
        }
        concurrentHashMap5.remove(resourceId8);
        downloadBean.setPreDownload(false);
        ConcurrentHashMap concurrentHashMap6 = this.f59559b;
        String resourceId9 = downloadBean.getResourceId();
        if (resourceId9 == null) {
            resourceId9 = downloadBean.getUrl();
        }
        if (concurrentHashMap6.containsKey(resourceId9)) {
            if (downloadBean.isDownloading()) {
                c0856a.p("download", new String[]{"waitDownloadingAndStartNewTask, isDownloading name = " + downloadBean.getName() + " "}, true);
                return;
            }
            ConcurrentHashMap concurrentHashMap7 = this.f59559b;
            String resourceId10 = downloadBean.getResourceId();
            if (resourceId10 == null) {
                resourceId10 = downloadBean.getUrl();
            }
            concurrentHashMap7.remove(resourceId10);
            a.C0856a.f(c0856a, this.f59558a, "waitDownloadingAndStartNewTask, isDownloading,error status , remove  name = " + downloadBean.getName(), false, 4, null);
        }
        R0();
        Iterator it = this.f59560c.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadBean2 = downloadBean;
                break;
            }
            downloadBean2 = (DownloadBean) it.next();
            if (Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                z10 = true;
                break;
            }
        }
        if (!z10) {
            this.f59560c.add(downloadBean2);
        }
        oy.c cVar3 = this.f59562e;
        com.transsnet.downloader.core.task.b bVar2 = null;
        if (cVar3 != null && (cVar = this.f59561d) != null) {
            bVar2 = k0(cVar3, cVar, downloadBean);
        }
        if (bVar2 != null) {
            ConcurrentHashMap concurrentHashMap8 = this.f59559b;
            String resourceId11 = downloadBean2.getResourceId();
            if (resourceId11 == null) {
                resourceId11 = downloadBean2.getUrl();
            }
            concurrentHashMap8.put(resourceId11, bVar2);
        }
        downloadBean2.setStatus(1);
        com.transsnet.downloader.core.c cVar4 = this.f59561d;
        if (cVar4 != null) {
            cVar4.a(downloadBean2);
        }
        j0(downloadBean2);
        Set set4 = this.f59568k;
        String resourceId12 = downloadBean2.getResourceId();
        if (resourceId12 == null) {
            resourceId12 = downloadBean2.getUrl();
        }
        set4.remove(resourceId12);
        Set set5 = this.f59570m;
        String resourceId13 = downloadBean2.getResourceId();
        if (resourceId13 == null) {
            resourceId13 = downloadBean2.getUrl();
        }
        set5.remove(resourceId13);
        Set set6 = this.f59569l;
        String resourceId14 = downloadBean2.getResourceId();
        if (resourceId14 == null) {
            resourceId14 = downloadBean2.getUrl();
        }
        set6.add(resourceId14);
        lg.a.f68962a.p("download", new String[]{"由边下边播触发的下载要开始了 2--prepareDownload, name = " + downloadBean2.getName() + ", add loading, loading  = " + this.f59569l.size() + ", error  = " + this.f59570m.size() + " , wait  = " + this.f59568k.size() + " "}, true);
        S0();
        if (bVar2 != null) {
            bVar2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a i0() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).o1();
        }
        return null;
    }

    private final void j0(DownloadBean downloadBean) {
        DownloadNotificationUtils.f59629a.n(downloadBean);
    }

    private final com.transsnet.downloader.core.task.b k0(oy.c cVar, com.transsnet.downloader.core.c cVar2, DownloadBean downloadBean) {
        return DownloadTaskUtil.f58752a.j() ? new DownloadTaskImpl2(cVar2, this.f59577t, downloadBean, cVar, this) : new DownloadTaskImpl(cVar2, this.f59577t, downloadBean, cVar, this);
    }

    private final void l0(DownloadBean downloadBean, boolean z10, Function1 function1) {
        kotlinx.coroutines.k.d(this.f59579v, null, null, new DownloadManagerImpl$deleteItem$1(downloadBean, this, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jj.a m0() {
        return (jj.a) this.f59572o.getValue();
    }

    private final String n0() {
        return DownloadManagerImpl.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadManagerImpl p0() {
        return new DownloadManagerImpl(null);
    }

    private final IPostDetailApi q0() {
        return (IPostDetailApi) this.f59581x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final lj.n0 r0() {
        return (lj.n0) this.f59580w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qy.a s0() {
        return (qy.a) this.f59576s.getValue();
    }

    private final void t0(String str) {
        IPostDetailApi q02 = q0();
        if (q02 != null) {
            q02.m(str);
        }
    }

    private final boolean u0() {
        String str;
        int size = this.f59559b.size();
        oy.c cVar = this.f59562e;
        boolean z10 = false;
        if (size >= (cVar != null ? cVar.e() : 2)) {
            Iterator it = this.f59559b.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                str = (String) entry.getKey();
                DownloadBean b11 = ((com.transsnet.downloader.core.task.b) entry.getValue()).b();
                a.C0856a.f(lg.a.f68962a, this.f59558a, "curTask, name = " + b11.getTotalTitleName() + ",status = " + b11.getStatus(), false, 4, null);
                z10 = b11.isDownloading();
            } else {
                str = "";
            }
            if (!z10 && str.length() > 0) {
                this.f59559b.remove(str);
            }
        }
        return z10;
    }

    private final boolean v0() {
        if (SystemClock.elapsedRealtime() - this.f59563f <= 500) {
            return false;
        }
        this.f59563f = SystemClock.elapsedRealtime();
        return true;
    }

    private final void w0(boolean z10) {
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c(this.f59558a, "isAutoPause, isAutoPause:" + z10, true);
        if (v0()) {
            c0856a.c("download", "pauseAll, " + z10, true);
            for (DownloadBean downloadBean : this.f59560c) {
                if (!z10) {
                    x0(downloadBean, false);
                } else if (downloadBean.getStatus() != 4) {
                    lg.a.f68962a.c("download", "pauseAll, pauseInner:" + downloadBean.getTotalTitleName(), true);
                    downloadBean.setAutoPause(true);
                    x0(downloadBean, false);
                }
            }
        }
    }

    private final void x0(DownloadBean downloadBean, boolean z10) {
        DownloadBean downloadBean2;
        downloadBean.setPreDownload(false);
        Iterator it = this.f59560c.iterator();
        while (true) {
            if (!it.hasNext()) {
                downloadBean2 = null;
                break;
            } else {
                downloadBean2 = (DownloadBean) it.next();
                if (Intrinsics.c(downloadBean2.getResourceId(), downloadBean.getResourceId())) {
                    break;
                }
            }
        }
        if (downloadBean2 == null) {
            this.f59560c.add(downloadBean);
            downloadBean2 = downloadBean;
        }
        com.transsnet.downloader.core.task.b bVar = (com.transsnet.downloader.core.task.b) this.f59559b.get(downloadBean.getResourceId());
        if (bVar != null && !Intrinsics.c(bVar.b(), downloadBean2)) {
            lg.a.f68962a.c(this.f59558a, "------pause, name: " + downloadBean2.getTotalTitleName() + ", info:" + bVar.b(), true);
            bVar.b().setStatus(4);
        }
        Set set = this.f59569l;
        String resourceId = downloadBean2.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean2.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.f59570m;
        String resourceId2 = downloadBean2.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadBean2.getUrl();
        }
        set2.remove(resourceId2);
        Set set3 = this.f59568k;
        String resourceId3 = downloadBean2.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadBean2.getUrl();
        }
        set3.add(resourceId3);
        lg.a.f68962a.c(this.f59558a, "pause, name: " + downloadBean2.getTotalTitleName() + ", downloadNext:" + z10 + "， info:" + downloadBean2, true);
        S0();
        downloadBean2.setStatus(4);
        ConcurrentHashMap concurrentHashMap = this.f59559b;
        String resourceId4 = downloadBean2.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadBean2.getUrl();
        }
        concurrentHashMap.remove(resourceId4);
        ConcurrentHashMap concurrentHashMap2 = this.f59565h;
        String resourceId5 = downloadBean2.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadBean2.getUrl();
        }
        concurrentHashMap2.remove(resourceId5);
        ConcurrentHashMap concurrentHashMap3 = this.f59566i;
        String resourceId6 = downloadBean2.getResourceId();
        if (resourceId6 == null) {
            resourceId6 = downloadBean2.getUrl();
        }
        concurrentHashMap3.remove(resourceId6);
        com.transsnet.downloader.core.c cVar = this.f59561d;
        if (cVar != null) {
            cVar.a(downloadBean2);
        }
        if (z10) {
            F0();
        }
    }

    static /* synthetic */ void y0(DownloadManagerImpl downloadManagerImpl, DownloadBean downloadBean, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        downloadManagerImpl.x0(downloadBean, z10);
    }

    private final void z0(DownloadBean downloadBean) {
        if (this.f59565h.isEmpty()) {
            return;
        }
        for (Map.Entry entry : this.f59565h.entrySet()) {
            String str = (String) entry.getKey();
            DownloadBean b11 = ((com.transsnet.downloader.core.task.b) entry.getValue()).b();
            lg.a.f68962a.c("download", "pause current preDownload, add to pool, name = " + b11.getTotalTitleName() + "，HashCode = " + System.identityHashCode(downloadBean) + " ", true);
            this.f59566i.put(str, b11);
            if (!Intrinsics.c(b11.getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                b11.setStatus(3);
            }
            this.f59565h.remove(str);
        }
    }

    @Override // com.transsnet.downloader.manager.g
    public boolean A(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        ConcurrentHashMap concurrentHashMap = this.f59559b;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        return concurrentHashMap.containsKey(resourceId);
    }

    @Override // com.transsnet.downloader.manager.g
    public void B() {
        z0(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.transsnet.downloader.manager.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object C(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1 r0 = (com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1 r0 = new com.transsnet.downloader.manager.DownloadManagerImpl$scheduleDownloadTask$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r12)
            goto L60
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L34:
            kotlin.ResultKt.b(r12)
            goto L4a
        L38:
            kotlin.ResultKt.b(r12)
            com.transsnet.downloader.manager.DownloadEsHelper$a r12 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r12 = r12.a()
            r0.label = r4
            java.lang.Object r12 = r12.C(r0)
            if (r12 != r1) goto L4a
            return r1
        L4a:
            java.util.List r12 = (java.util.List) r12
            r11.P0(r12)
            com.transsnet.downloader.manager.DownloadEsHelper$a r12 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r12 = r12.a()
            r0.label = r3
            r2 = 0
            r3 = 0
            java.lang.Object r12 = com.transsnet.downloader.manager.DownloadEsHelper.B(r12, r2, r0, r4, r3)
            if (r12 != r1) goto L60
            return r1
        L60:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto Lbb
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L6a:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto Lbb
            java.lang.Object r0 = r12.next()
            com.transsion.baselib.db.download.DownloadBean r0 = (com.transsion.baselib.db.download.DownloadBean) r0
            int r1 = r0.getIsRead()
            if (r1 == r4) goto L8f
            java.util.Set r1 = r11.f59571n
            java.lang.String r2 = r0.getResourceId()
            if (r2 != 0) goto L88
            java.lang.String r2 = r0.getUrl()
        L88:
            boolean r1 = r1.remove(r2)
            kotlin.coroutines.jvm.internal.Boxing.a(r1)
        L8f:
            lg.a$a r5 = lg.a.f68962a
            java.lang.String r1 = r0.getResourceId()
            int r0 = r0.getIsRead()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "init add doneSet, resId = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "， it.isRead = "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r7 = r2.toString()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "DownloadStatus"
            r8 = 0
            lg.a.C0856a.f(r5, r6, r7, r8, r9, r10)
            goto L6a
        Lbb:
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl.C(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsnet.downloader.manager.g
    public void D(List list) {
        Intrinsics.h(list, "list");
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            p((DownloadBean) list.get(0));
            return;
        }
        oy.c cVar = this.f59562e;
        int e11 = cVar != null ? cVar.e() : 1;
        for (int i11 = 0; i11 < e11; i11++) {
            if (i11 < list.size()) {
                p((DownloadBean) list.get(i11));
            }
        }
        int i12 = 0;
        for (Object obj : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            long j11 = i12;
            downloadBean.setUpdateTimeStamp(Long.valueOf(System.currentTimeMillis() + j11));
            downloadBean.setCreateAt(System.currentTimeMillis() + j11);
            if (i12 >= e11 && i12 != list.size() - 1) {
                ConcurrentHashMap concurrentHashMap = this.f59566i;
                String resourceId = downloadBean.getResourceId();
                if (resourceId == null) {
                    resourceId = downloadBean.getUrl();
                }
                concurrentHashMap.put(resourceId, downloadBean);
                ConcurrentHashMap concurrentHashMap2 = this.f59565h;
                String resourceId2 = downloadBean.getResourceId();
                if (resourceId2 == null) {
                    resourceId2 = downloadBean.getUrl();
                }
                concurrentHashMap2.remove(resourceId2);
                if (!this.f59560c.contains(downloadBean)) {
                    this.f59560c.add(downloadBean);
                }
                downloadBean.setPreDownload(false);
                downloadBean.setStatus(3);
                com.transsnet.downloader.core.c cVar2 = this.f59561d;
                if (cVar2 != null) {
                    cVar2.a(downloadBean);
                }
                Set set = this.f59568k;
                String resourceId3 = downloadBean.getResourceId();
                if (resourceId3 == null) {
                    resourceId3 = downloadBean.getUrl();
                }
                set.add(resourceId3);
                S0();
            }
            i12 = i13;
        }
        int size = list.size() - 1;
        if (size >= e11 - 1) {
            DownloadBean downloadBean2 = (DownloadBean) list.get(size);
            if (!this.f59560c.contains(downloadBean2)) {
                this.f59560c.add(downloadBean2);
            }
            if (!B0(downloadBean2)) {
                downloadBean2.setStatus(3);
                com.transsnet.downloader.core.c cVar3 = this.f59561d;
                if (cVar3 != null) {
                    cVar3.a(downloadBean2);
                }
            }
            Set set2 = this.f59568k;
            String resourceId4 = downloadBean2.getResourceId();
            if (resourceId4 == null) {
                resourceId4 = downloadBean2.getUrl();
            }
            set2.add(resourceId4);
        }
        S0();
    }

    @Override // com.transsnet.downloader.manager.g
    public void E() {
        S0();
    }

    @Override // com.transsnet.downloader.manager.g
    public void F(s0 listener) {
        Intrinsics.h(listener, "listener");
        this.f59575r.add(listener);
    }

    @Override // com.transsnet.downloader.manager.g
    public void G(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        if (v0()) {
            y0(this, downloadInfo, false, 2, null);
        }
    }

    @Override // com.transsnet.downloader.manager.g
    public void H() {
        this.f59577t.c();
    }

    @Override // com.transsnet.downloader.core.task.c
    public void I(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        kotlinx.coroutines.k.d(this.f59578u, null, null, new DownloadManagerImpl$onPreDownloadSuccess$1(this, downloadInfo, null), 3, null);
    }

    @Override // com.transsnet.downloader.manager.g
    public Object a(String str, int i11, String str2, Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new DownloadManagerImpl$transformDownloadPlayUrl$3(str, i11, str2, this, null), continuation);
    }

    @Override // com.transsnet.downloader.core.task.c
    public void b(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        T0(downloadInfo);
        ConcurrentHashMap concurrentHashMap = this.f59566i;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        ConcurrentHashMap concurrentHashMap2 = this.f59559b;
        String resourceId2 = downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadInfo.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = this.f59565h;
        String resourceId3 = downloadInfo.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadInfo.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        boolean remove = this.f59560c.remove(downloadInfo);
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.f59558a, "remove index " + remove, false, 4, null);
        Set set = this.f59571n;
        String resourceId4 = downloadInfo.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadInfo.getUrl();
        }
        set.add(resourceId4);
        Set set2 = this.f59568k;
        String resourceId5 = downloadInfo.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadInfo.getUrl();
        }
        set2.remove(resourceId5);
        DownloadStatusIconManager.f59585h.a().w(false);
        Set set3 = this.f59569l;
        String resourceId6 = downloadInfo.getResourceId();
        if (resourceId6 == null) {
            resourceId6 = downloadInfo.getUrl();
        }
        set3.remove(resourceId6);
        c0856a.p("download", new String[]{"onDownloadSuccess, name = " + downloadInfo.getName() + " subjectId=" + downloadInfo.getSubjectId() + " resourceId=" + downloadInfo.getResourceId() + ", status = " + downloadInfo.getStatus() + " "}, true);
        Iterator it = this.f59575r.iterator();
        while (it.hasNext()) {
            ((s0) it.next()).b(downloadInfo);
        }
        S0();
        F0();
    }

    @Override // com.transsnet.downloader.core.task.c
    public void c(DownloadBean downloadInfo, boolean z10) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        Iterator it = this.f59575r.iterator();
        while (it.hasNext()) {
            ((s0) it.next()).c(downloadInfo, z10);
        }
    }

    @Override // com.transsnet.downloader.manager.g
    public void d() {
        C0();
    }

    @Override // com.transsnet.downloader.manager.g
    public void e(m0 listener) {
        Intrinsics.h(listener, "listener");
        this.f59574q.add(listener);
    }

    @Override // com.transsnet.downloader.manager.g
    public Object f(String str, Continuation continuation) {
        return DownloadEsHelper.f59542m.a().o(str, continuation);
    }

    @Override // com.transsnet.downloader.core.task.c
    public void g(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        Set set = this.f59568k;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        set.remove(resourceId);
        Set set2 = this.f59570m;
        String resourceId2 = downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadInfo.getUrl();
        }
        set2.remove(resourceId2);
        D0(downloadInfo);
    }

    @Override // com.transsnet.downloader.manager.g
    public String h(DownloadBean bean) {
        Intrinsics.h(bean, "bean");
        return this.f59577t.f(bean);
    }

    @Override // com.transsnet.downloader.manager.g
    public boolean i() {
        return !this.f59559b.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsnet.downloader.manager.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2
            if (r0 == 0) goto L13
            r0 = r6
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2 r0 = (com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2 r0 = new com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$2
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r2 = r6.a()
            com.transsion.baselib.db.download.DownloadBean r2 = r2.S(r5)
            if (r2 != 0) goto L50
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            r0.label = r3
            java.lang.Object r6 = r6.R(r5, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r2 = r6
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2
        L50:
            if (r2 == 0) goto L65
            boolean r5 = r2.isCompleted()
            if (r5 != r3) goto L65
            java.lang.String r5 = r2.getPath()
            if (r5 == 0) goto L65
            int r5 = r5.length()
            if (r5 <= 0) goto L65
            goto L66
        L65:
            r2 = 0
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl.j(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsnet.downloader.manager.g
    public void k(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        if (ThreadUtils.j()) {
            W0(downloadInfo);
        } else {
            kotlinx.coroutines.k.d(this.f59578u, null, null, new DownloadManagerImpl$waitDownloadingAndStartNewTask$1(this, downloadInfo, null), 3, null);
        }
    }

    @Override // com.transsnet.downloader.manager.g
    public void l(final DownloadBean downloadInfo, final Function1 function1) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        final String path = downloadInfo.getPath();
        l0(downloadInfo, true, new Function1() { // from class: com.transsnet.downloader.manager.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I0;
                I0 = DownloadManagerImpl.I0(DownloadManagerImpl.this, downloadInfo, function1, path, ((Boolean) obj).booleanValue());
                return I0;
            }
        });
    }

    @Override // com.transsnet.downloader.manager.g
    public void m() {
        w0(false);
    }

    @Override // com.transsnet.downloader.manager.g
    public void n(ny.b listener) {
        Intrinsics.h(listener, "listener");
        this.f59573p.setWaitCount(this.f59568k.size());
        this.f59573p.setLoadingCount(this.f59569l.size());
        this.f59573p.setErrorCount(this.f59570m.size());
        this.f59573p.setDoneCount(this.f59571n.size());
        listener.a(this.f59573p);
        this.f59567j = listener;
    }

    @Override // com.transsnet.downloader.manager.g
    public void o() {
        this.f59577t.h();
    }

    public Object o0(Continuation continuation) {
        return DownloadEsHelper.f59542m.a().y(continuation);
    }

    @Override // com.transsnet.downloader.manager.g
    public void p(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("download", n0() + " --> download() --> downloadInfo = " + downloadInfo, false);
        if (A(downloadInfo)) {
            a.C0856a.f(c0856a, "download", n0() + " --> download() --> 任务已存在", false, 4, null);
            return;
        }
        DownloadEsHelper.f59542m.a().h();
        if (!this.f59560c.contains(downloadInfo)) {
            this.f59560c.add(downloadInfo);
        }
        c0856a.p("download", new String[]{n0() + " --> download() -->, 添加新的任务 -- name = " + downloadInfo.getName() + " "}, true);
        D0(downloadInfo);
    }

    @Override // com.transsnet.downloader.manager.g
    public void q() {
        this.f59577t.b();
    }

    @Override // com.transsnet.downloader.manager.g
    public void r(oy.c config) {
        Intrinsics.h(config, "config");
        oy.c cVar = this.f59562e;
        if (cVar == null || cVar == null || cVar.e() != config.e()) {
            if (config.e() > 1 && this.f59559b.size() < config.e()) {
                for (DownloadBean downloadBean : this.f59560c) {
                    if (!downloadBean.isDownloading() && downloadBean.getStatus() != 4 && config.e() - this.f59559b.size() > 0) {
                        lg.a.f68962a.p("download", new String[]{n0() + " --> set new config, start other task, task:" + config.e() + ", cur:" + this.f59559b.size() + " "}, true);
                        p(downloadBean);
                    }
                }
            } else if (this.f59559b.size() > 1 && this.f59559b.size() > config.e()) {
                for (int size = this.f59560c.size() - 1; size > 0; size--) {
                    DownloadBean downloadBean2 = (DownloadBean) this.f59560c.get(size);
                    if (downloadBean2.isDownloading() && config.e() <= this.f59559b.size()) {
                        x0(downloadBean2, false);
                        lg.a.f68962a.p("download", new String[]{n0() + " --> set new config, pause task, task:" + config.e() + ", cur:" + this.f59559b.size() + " "}, true);
                    }
                }
            }
        }
        this.f59562e = config;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object, com.transsion.baselib.db.download.DownloadBean] */
    @Override // com.transsnet.downloader.manager.g
    public void s(String str, Function1 callback) {
        Intrinsics.h(callback, "callback");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Iterator it = this.f59560c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ?? r12 = (DownloadBean) it.next();
            if (TextUtils.equals(r12.getResourceId(), str)) {
                objectRef.element = r12;
                callback.invoke(r12);
                break;
            }
        }
        if (objectRef.element == 0) {
            kotlinx.coroutines.k.d(this.f59578u, null, null, new DownloadManagerImpl$getDownloadByResId$2(objectRef, str, callback, this, null), 3, null);
        }
    }

    @Override // com.transsnet.downloader.manager.g
    public void t(DownloadBean downloadInfo, boolean z10) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        if (v0() || z10) {
            if (!this.f59560c.contains(downloadInfo)) {
                this.f59560c.add(downloadInfo);
            }
            lg.a.f68962a.c(this.f59558a, "resume, name = " + downloadInfo.getTotalTitleName() + ", cur status = " + downloadInfo.getStatus() + ", " + downloadInfo, true);
            Set set = this.f59568k;
            String resourceId = downloadInfo.getResourceId();
            if (resourceId == null) {
                resourceId = downloadInfo.getUrl();
            }
            set.remove(resourceId);
            Set set2 = this.f59570m;
            String resourceId2 = downloadInfo.getResourceId();
            if (resourceId2 == null) {
                resourceId2 = downloadInfo.getUrl();
            }
            set2.remove(resourceId2);
            D0(downloadInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsnet.downloader.manager.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(java.lang.String r5, int r6, int r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1 r0 = (com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1 r0 = new com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadedPlayBean$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r8)
            com.transsnet.downloader.manager.DownloadEsHelper$a r8 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r2 = r8.a()
            com.transsion.baselib.db.download.DownloadBean r2 = r2.K(r5, r6, r7)
            if (r2 != 0) goto L50
            com.transsnet.downloader.manager.DownloadEsHelper r8 = r8.a()
            r0.label = r3
            java.lang.Object r8 = r8.J(r5, r6, r7, r0)
            if (r8 != r1) goto L4d
            return r1
        L4d:
            r2 = r8
            com.transsion.baselib.db.download.DownloadBean r2 = (com.transsion.baselib.db.download.DownloadBean) r2
        L50:
            if (r2 == 0) goto L65
            boolean r5 = r2.isCompleted()
            if (r5 != r3) goto L65
            java.lang.String r5 = r2.getPath()
            if (r5 == 0) goto L65
            int r5 = r5.length()
            if (r5 <= 0) goto L65
            goto L66
        L65:
            r2 = 0
        L66:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl.u(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsnet.downloader.manager.g
    public void v(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        downloadInfo.setPreDownload(false);
        ConcurrentHashMap concurrentHashMap = this.f59559b;
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = downloadInfo.getUrl();
        }
        concurrentHashMap.remove(resourceId);
        com.transsnet.downloader.core.c cVar = this.f59561d;
        if (cVar != null) {
            cVar.a(downloadInfo);
        }
        ConcurrentHashMap concurrentHashMap2 = this.f59566i;
        String resourceId2 = downloadInfo.getResourceId();
        if (resourceId2 == null) {
            resourceId2 = downloadInfo.getUrl();
        }
        concurrentHashMap2.remove(resourceId2);
        ConcurrentHashMap concurrentHashMap3 = this.f59565h;
        String resourceId3 = downloadInfo.getResourceId();
        if (resourceId3 == null) {
            resourceId3 = downloadInfo.getUrl();
        }
        concurrentHashMap3.remove(resourceId3);
        if (DownloadUtil.f60023a.E(downloadInfo)) {
            N0(downloadInfo);
            return;
        }
        Set set = this.f59570m;
        String resourceId4 = downloadInfo.getResourceId();
        if (resourceId4 == null) {
            resourceId4 = downloadInfo.getUrl();
        }
        set.add(resourceId4);
        Set set2 = this.f59569l;
        String resourceId5 = downloadInfo.getResourceId();
        if (resourceId5 == null) {
            resourceId5 = downloadInfo.getUrl();
        }
        set2.remove(resourceId5);
        lg.a.f68962a.i("download", "Download Failed, name = " + downloadInfo.getName() + ", resourceId = " + downloadInfo.getResourceId() + "，subjectId = " + downloadInfo.getSubjectId() + "，remove from loading, add to error， loading  = " + this.f59569l.size() + ", error  = " + this.f59570m.size() + " , wait  = " + this.f59568k.size() + " ", true);
        S0();
        F0();
    }

    @Override // com.transsnet.downloader.manager.g
    public void w() {
        O0(false);
    }

    @Override // com.transsnet.downloader.manager.g
    public void x(m0 listener) {
        Intrinsics.h(listener, "listener");
        if (this.f59574q.contains(listener)) {
            this.f59574q.remove(listener);
        }
    }

    @Override // com.transsnet.downloader.manager.g
    public Long y() {
        Iterator it = this.f59560c.iterator();
        long j11 = 0;
        while (it.hasNext()) {
            j11 += ((DownloadBean) it.next()).getProgress();
        }
        return Long.valueOf(j11);
    }

    @Override // com.transsnet.downloader.manager.g
    public void z(List list, final Function1 function1) {
        a.C0856a.f(lg.a.f68962a, this.f59558a, "remove list ,size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        if (list != null) {
            L0(list, 0, new Function1() { // from class: com.transsnet.downloader.manager.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit J0;
                    J0 = DownloadManagerImpl.J0(Function1.this, this, ((Boolean) obj).booleanValue());
                    return J0;
                }
            });
        }
    }
}
