package com.transsnet.downloader;

import android.R;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.downloadapi.IDownloadApiProvider;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.fragment.DownloadReDetectorMainDialog;
import com.transsnet.downloader.fragment.TransferInnerMainFragment;
import com.transsnet.downloader.ugc.dialog.UGCDownloadDialog;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.view.DownloadingTipsDialogFragment;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes.dex */
public final class DownloadManagerApi implements IDownloadApiProvider {

    /* renamed from: j */
    public static final a f58521j = new a(null);

    /* renamed from: k */
    private static final Lazy f58522k = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DownloadManagerApi u11;
            u11 = DownloadManagerApi.u();
            return u11;
        }
    });

    /* renamed from: e */
    private DownloadBean f58527e;

    /* renamed from: a */
    private final Set f58523a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private final Set f58524b = new CopyOnWriteArraySet();

    /* renamed from: c */
    private final Set f58525c = new CopyOnWriteArraySet();

    /* renamed from: d */
    private final Lazy f58526d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a C0;
            C0 = DownloadManagerApi.C0();
            return C0;
        }
    });

    /* renamed from: f */
    private final Lazy f58528f = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g c02;
            c02 = DownloadManagerApi.c0();
            return c02;
        }
    });

    /* renamed from: g */
    private final Lazy f58529g = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.n
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IAudioApi q02;
            q02 = DownloadManagerApi.q0();
            return q02;
        }
    });

    /* renamed from: h */
    private final Lazy f58530h = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IFloatingApi r02;
            r02 = DownloadManagerApi.r0();
            return r02;
        }
    });

    /* renamed from: i */
    private final Lazy f58531i = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            jj.a W;
            W = DownloadManagerApi.W();
            return W;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadManagerApi a() {
            return (DownloadManagerApi) DownloadManagerApi.f58522k.getValue();
        }
    }

    public static /* synthetic */ void B0(DownloadManagerApi downloadManagerApi, String str, String str2, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        boolean z13 = z11;
        if ((i11 & 16) != 0) {
            z12 = false;
        }
        downloadManagerApi.A0(str, str2, z10, z13, z12);
    }

    public static final qy.a C0() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    private final void D0(final FragmentActivity fragmentActivity, final int i11, String str, final DownloadBean downloadBean, boolean z10, final String str2) {
        if (((FrameLayout) fragmentActivity.findViewById(R.id.content)) != null) {
            a.C0856a.f(lg.a.f68962a, "downloadAna", "downloadBean.size = " + downloadBean.getSize() + "， formatSize = " + str + ", fileCount = " + i11, false, 4, null);
            if (z10) {
                boolean z11 = ((ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0) instanceof ViewGroup;
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsnet.downloader.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadManagerApi.E0(DownloadBean.this, str2, i11, fragmentActivity);
                    }
                }, 300L);
            }
        }
    }

    public static final void E0(DownloadBean downloadBean, String str, int i11, FragmentActivity fragmentActivity) {
        downloadBean.setPageFrom(str);
        DownloadingTipsDialogFragment a11 = DownloadingTipsDialogFragment.INSTANCE.a(i11);
        a11.O0(downloadBean);
        a11.k0(fragmentActivity, "DownloadingTipsDialogFragment");
    }

    private final void G(final FragmentActivity fragmentActivity, final Subject subject, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, String str7, boolean z10, final int i11, final boolean z11) {
        Integer type;
        final FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        final String i12 = hj.i.f64628a.i();
        ResourceDetectors resourceDetector = subject.getResourceDetector();
        if (resourceDetector == null || (type = resourceDetector.getType()) == null || type.intValue() != 1) {
            com.transsnet.downloader.manager.f.f59601a.a().j(fragmentActivity, subject, new Function0() { // from class: com.transsnet.downloader.s
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit I;
                    I = DownloadManagerApi.I(str, i12, subject, str2, str3, str4, str5, str6, i11, z11, supportFragmentManager, this, fragmentActivity);
                    return I;
                }
            });
            return;
        }
        DownloadReDetectorMainDialog a11 = DownloadReDetectorMainDialog.INSTANCE.a(str, i12, subject, str2, str3, str4, str5, str6, i11, z11);
        a11.show(supportFragmentManager, "download");
        a11.z0(new Function4() { // from class: com.transsnet.downloader.r
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit H;
                H = DownloadManagerApi.H(DownloadManagerApi.this, fragmentActivity, str, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
                return H;
            }
        });
    }

    public static final Unit H(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i11, String formatSize, DownloadBean downloadBean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        downloadManagerApi.D0(fragmentActivity, i11, formatSize, downloadBean, z10, str);
        a.C0856a.f(lg.a.f68962a, "downloadAna", "group get success, show anima", false, 4, null);
        return Unit.f67184a;
    }

    public static final Unit I(final String str, String str2, Subject subject, String str3, String str4, String str5, String str6, String str7, int i11, boolean z10, FragmentManager fragmentManager, DownloadManagerApi downloadManagerApi, final FragmentActivity fragmentActivity) {
        DownloadReDetectorMainDialog a11 = DownloadReDetectorMainDialog.INSTANCE.a(str, str2, subject, str3, str4, str5, str6, str7, i11, z10);
        a11.show(fragmentManager, "download_anima");
        a11.z0(new Function4() { // from class: com.transsnet.downloader.g
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit J;
                J = DownloadManagerApi.J(DownloadManagerApi.this, fragmentActivity, str, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
                return J;
            }
        });
        return Unit.f67184a;
    }

    public static final Unit J(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i11, String formatSize, DownloadBean bean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(bean, "bean");
        downloadManagerApi.D0(fragmentActivity, i11, formatSize, bean, z10, str);
        return Unit.f67184a;
    }

    public static /* synthetic */ void N(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, int i11, boolean z11, int i12, Object obj) {
        downloadManagerApi.L(fragmentActivity, subject, str, (i12 & 8) != 0 ? "" : str2, str3, str4, (i12 & 64) != 0 ? "" : str5, (i12 & 128) != 0 ? null : str6, (i12 & 256) != 0 ? null : str7, (i12 & 512) != 0 ? false : z10, (i12 & 1024) != 0 ? 0 : i11, (i12 & 2048) != 0 ? true : z11);
    }

    public static final Unit Q(DownloadManagerApi downloadManagerApi, final FragmentActivity fragmentActivity, final DownloadBean downloadBean, final String str, final Ref.ObjectRef objectRef, final String str2, final String str3) {
        downloadManagerApi.X(fragmentActivity, new Function0() { // from class: com.transsnet.downloader.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit R;
                R = DownloadManagerApi.R(DownloadManagerApi.this, fragmentActivity, downloadBean, str, objectRef, str2, str3);
                return R;
            }
        });
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit R(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, Ref.ObjectRef objectRef, String str2, String str3) {
        downloadManagerApi.i0(fragmentActivity, downloadBean, str, (String) objectRef.element, str2, str3);
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit S(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, DownloadBean downloadBean, String str, Ref.ObjectRef objectRef, String str2, String str3) {
        downloadManagerApi.i0(fragmentActivity, downloadBean, str, (String) objectRef.element, str2, str3);
        return Unit.f67184a;
    }

    public static final Unit V(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5) {
        Z(downloadManagerApi, fragmentActivity, subject, str, str2, str3, str4, str5, null, 128, null);
        return Unit.f67184a;
    }

    public static final jj.a W() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).o1();
    }

    private final void X(FragmentActivity fragmentActivity, Function0 function0) {
        function0.invoke();
    }

    private final void Y(final FragmentActivity fragmentActivity, final Subject subject, final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        X(fragmentActivity, new Function0() { // from class: com.transsnet.downloader.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit a02;
                a02 = DownloadManagerApi.a0(FragmentActivity.this, str, str2, subject, str3, str4, str5, str6, this);
                return a02;
            }
        });
    }

    static /* synthetic */ void Z(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, Subject subject, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        downloadManagerApi.Y(fragmentActivity, subject, str, str2, str3, str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6);
    }

    public static final Unit a0(final FragmentActivity fragmentActivity, String str, final String str2, Subject subject, String str3, String str4, String str5, String str6, DownloadManagerApi downloadManagerApi) {
        String i11 = hj.i.f64628a.i();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        DownloadReDetectorMainDialog b11 = DownloadReDetectorMainDialog.INSTANCE.b(str, str2, i11, subject, str3, str4, str5);
        b11.show(supportFragmentManager, "download_anima");
        b11.z0(new Function4() { // from class: com.transsnet.downloader.j
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit b02;
                b02 = DownloadManagerApi.b0(DownloadManagerApi.this, fragmentActivity, str2, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
                return b02;
            }
        });
        DownloadListManager.f60117m.a().p(DownloadUtil.f60023a.j(subject, str2, i11, str3, "", str6));
        return Unit.f67184a;
    }

    public static final Unit b0(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i11, String formatSize, DownloadBean downloadBean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        downloadManagerApi.D0(fragmentActivity, i11, formatSize, downloadBean, z10, str);
        return Unit.f67184a;
    }

    public static final com.transsnet.downloader.manager.g c0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    public static final Unit h0(Function4 function4, DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i11, String formatSize, DownloadBean downloadBean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        if (function4 != null) {
            function4.invoke(Integer.valueOf(i11), formatSize, downloadBean, Boolean.valueOf(z10));
        } else {
            downloadManagerApi.D0(fragmentActivity, i11, formatSize, downloadBean, z10, str);
        }
        return Unit.f67184a;
    }

    private final void i0(final FragmentActivity fragmentActivity, final DownloadBean downloadBean, final String str, final String str2, final String str3, final String str4) {
        com.transsnet.downloader.manager.p.f59623a.a(Utils.a()).s(downloadBean != null ? downloadBean.getResourceId() : null, new Function1() { // from class: com.transsnet.downloader.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j02;
                j02 = DownloadManagerApi.j0(FragmentActivity.this, str3, str4, downloadBean, this, str, str2, (DownloadBean) obj);
                return j02;
            }
        });
    }

    public static final Unit j0(final FragmentActivity fragmentActivity, String str, String str2, DownloadBean downloadBean, DownloadManagerApi downloadManagerApi, final String str3, String str4, DownloadBean downloadBean2) {
        if (downloadBean2 != null) {
            uh.b.f76876a.d(R$string.already_in_downloads);
        } else {
            String i11 = hj.i.f64628a.i();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            DownloadReDetectorMainDialog d11 = DownloadReDetectorMainDialog.INSTANCE.d(str, str2);
            d11.show(supportFragmentManager, "download_anima");
            d11.z0(new Function4() { // from class: com.transsnet.downloader.h
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit k02;
                    k02 = DownloadManagerApi.k0(DownloadManagerApi.this, fragmentActivity, str3, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
                    return k02;
                }
            });
            if (downloadBean != null) {
                downloadBean.setPageFrom(str3);
                downloadBean.setLastPageFrom(i11);
                downloadBean.setOps(str4);
                DownloadListManager.f60117m.a().p(downloadBean);
            }
        }
        return Unit.f67184a;
    }

    public static final Unit k0(DownloadManagerApi downloadManagerApi, FragmentActivity fragmentActivity, String str, int i11, String formatSize, DownloadBean downloadBean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        downloadManagerApi.D0(fragmentActivity, i11, formatSize, downloadBean, z10, str);
        return Unit.f67184a;
    }

    public final jj.a m0() {
        return (jj.a) this.f58531i.getValue();
    }

    public final com.transsnet.downloader.manager.g n0() {
        return (com.transsnet.downloader.manager.g) this.f58528f.getValue();
    }

    public final IAudioApi o0() {
        return (IAudioApi) this.f58529g.getValue();
    }

    public final IFloatingApi p0() {
        return (IFloatingApi) this.f58530h.getValue();
    }

    public static final IAudioApi q0() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    public static final IFloatingApi r0() {
        return (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0]);
    }

    public static final DownloadManagerApi u() {
        Object d11 = TheRouter.d(IDownloadApiProvider.class, new Object[0]);
        Intrinsics.f(d11, "null cannot be cast to non-null type com.transsnet.downloader.DownloadManagerApi");
        return (DownloadManagerApi) d11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
    
        if (r1.isCompleted() == true) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            com.transsion.baselib.db.download.DownloadBean r0 = r5.f58527e
            if (r0 != 0) goto L5
            return
        L5:
            com.transsnet.downloader.manager.g r0 = r5.n0()
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            kotlin.jvm.internal.Intrinsics.e(r1)
            r0.k(r1)
            com.transsnet.downloader.manager.p$a r0 = com.transsnet.downloader.manager.p.f59623a
            android.app.Application r1 = com.blankj.utilcode.util.Utils.a()
            com.transsnet.downloader.manager.g r0 = r0.a(r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            kotlin.jvm.internal.Intrinsics.e(r1)
            java.lang.String r0 = r0.h(r1)
            java.lang.String r1 = "/video/detail"
            com.therouter.router.Navigator r1 = com.therouter.TheRouter.c(r1)
            com.transsion.baselib.db.download.DownloadBean r2 = r5.f58527e
            r3 = 0
            if (r2 == 0) goto L34
            java.lang.String r2 = r2.getPath()
            goto L35
        L34:
            r2 = r3
        L35:
            java.lang.String r4 = "extra_local_path"
            com.therouter.router.Navigator r1 = r1.K(r4, r2)
            com.transsion.baselib.db.download.DownloadBean r2 = r5.f58527e
            if (r2 == 0) goto L44
            java.lang.String r2 = r2.getUrl()
            goto L45
        L44:
            r2 = r3
        L45:
            java.lang.String r4 = "extra_url"
            com.therouter.router.Navigator r1 = r1.K(r4, r2)
            java.lang.String r2 = "extra_proxy_url"
            com.therouter.router.Navigator r0 = r1.K(r2, r0)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            if (r1 == 0) goto L5a
            java.lang.String r1 = r1.getResourceId()
            goto L5b
        L5a:
            r1 = r3
        L5b:
            java.lang.String r2 = "extra_resource_id"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            if (r1 == 0) goto L6a
            java.lang.String r1 = r1.getSubjectId()
            goto L6b
        L6a:
            r1 = r3
        L6b:
            java.lang.String r2 = "extra_subject_id"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            if (r1 == 0) goto L7a
            java.lang.String r1 = r1.getName()
            goto L7b
        L7a:
            r1 = r3
        L7b:
            java.lang.String r2 = "extra_name"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            if (r1 == 0) goto L8a
            java.lang.String r1 = r1.getPostId()
            goto L8b
        L8a:
            r1 = r3
        L8b:
            java.lang.String r2 = "extra_post_id"
            com.therouter.router.Navigator r0 = r0.K(r2, r1)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            r2 = 0
            if (r1 == 0) goto L9e
            boolean r1 = r1.isCompleted()
            r4 = 1
            if (r1 != r4) goto L9e
            goto L9f
        L9e:
            r4 = r2
        L9f:
            java.lang.String r1 = "extra_completed"
            com.therouter.router.Navigator r0 = r0.z(r1, r4)
            com.transsion.baselib.db.download.DownloadBean r1 = r5.f58527e
            if (r1 == 0) goto Lad
            boolean r2 = r1.isSeries()
        Lad:
            java.lang.String r1 = "extra_is_series"
            com.therouter.router.Navigator r0 = r0.z(r1, r2)
            java.lang.String r1 = "extra_page_from"
            com.therouter.router.Navigator r7 = r0.K(r1, r7)
            r0 = 2
            com.therouter.router.Navigator.x(r7, r6, r3, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.DownloadManagerApi.u0(android.content.Context, java.lang.String):void");
    }

    public final void v0(Context context) {
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new DownloadManagerApi$opnAudio$1(this, context, null), 3, null);
    }

    public static /* synthetic */ boolean x0(DownloadManagerApi downloadManagerApi, String str, String str2, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        return downloadManagerApi.w0(str, str2, z10, z11);
    }

    public static /* synthetic */ void z0(DownloadManagerApi downloadManagerApi, String str, Context context, String str2, String str3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str3 = null;
        }
        downloadManagerApi.y0(str, context, str2, str3);
    }

    public final void A0(String str, String str2, boolean z10, boolean z11, boolean z12) {
        TypeIntrinsics.a(this.f58523a).remove(str2);
        TypeIntrinsics.a(this.f58524b).remove(str);
        if (z11) {
            AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(str, str2, false, z10);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = AddToDownloadEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, addToDownloadEvent, 0L);
        }
        if (z12) {
            kotlinx.coroutines.j.b(null, new DownloadManagerApi$removePlayAvailable$1(str, this, z11, str2, z10, null), 1, null);
        }
    }

    public final void K(FragmentActivity activity, Subject subject, String str, String str2, String str3, String resource, String str4, String str5, String str6, boolean z10) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(resource, "resource");
        N(this, activity, subject, str, str2, str3, resource, str4, str5, str6, z10, 0, false, 2048, null);
    }

    public final void L(FragmentActivity activity, Subject subject, String str, String str2, String str3, String resource, String str4, String str5, String str6, boolean z10, int i11, boolean z11) {
        String string;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(resource, "resource");
        if (subject == null) {
            return;
        }
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.f43558a;
        String subjectId = subject.getSubjectId();
        if (cVar.a(subjectId != null ? subjectId.hashCode() : 9527, 2000L)) {
            return;
        }
        if (str3 == null || str3.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            string = extras != null ? extras.getString("ops") : null;
        } else {
            string = str3;
        }
        if (nh.m.f70597a.e()) {
            G(activity, subject, str, str2, string, resource, str4, str5, str6, z10, i11, z11);
        } else {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O(final FragmentActivity activity, final DownloadBean downloadBean, final String str, String str2, final String resource, Subject subject, final String str3) {
        String resourceId;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(resource, "resource");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str2;
        String str4 = str2;
        if (str4 == null || str4.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            objectRef.element = extras != null ? extras.getString("ops") : 0;
        }
        if (com.transsion.baseui.util.c.f43558a.a((downloadBean == null || (resourceId = downloadBean.getResourceId()) == null) ? 9526 : resourceId.hashCode(), 2000L)) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
        } else if (subject != null) {
            com.transsnet.downloader.manager.f.f59601a.a().j(activity, subject, new Function0() { // from class: com.transsnet.downloader.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Q;
                    Q = DownloadManagerApi.Q(DownloadManagerApi.this, activity, downloadBean, str, objectRef, resource, str3);
                    return Q;
                }
            });
        } else {
            X(activity, new Function0() { // from class: com.transsnet.downloader.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit S;
                    S = DownloadManagerApi.S(DownloadManagerApi.this, activity, downloadBean, str, objectRef, resource, str3);
                    return S;
                }
            });
        }
    }

    public final void T(String str, String str2, boolean z10, int i11, boolean z11, boolean z12) {
        Object b11;
        if (z12 && str != null) {
            this.f58525c.add(str);
        }
        if (z10) {
            if (str2 != null) {
                this.f58523a.add(str2);
                AddToDownloadEvent addToDownloadEvent = new AddToDownloadEvent(null, str2, true, z10);
                FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name = AddToDownloadEvent.class.getName();
                Intrinsics.g(name, "getName(...)");
                flowEventBus.postEvent(name, addToDownloadEvent, 0L);
            }
            if (!CollectionsKt.b0(this.f58524b, str) || z11) {
                b11 = kotlinx.coroutines.j.b(null, new DownloadManagerApi$addPlayAvailable$1(str, i11, this, z11, str2, null), 1, null);
                return;
            }
            return;
        }
        if (str2 != null) {
            this.f58523a.add(str2);
            if (str != null) {
                this.f58524b.add(str);
            }
            if (z11) {
                AddToDownloadEvent addToDownloadEvent2 = new AddToDownloadEvent(str, str2, true, z10);
                FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                String name2 = AddToDownloadEvent.class.getName();
                Intrinsics.g(name2, "getName(...)");
                flowEventBus2.postEvent(name2, addToDownloadEvent2, 0L);
            }
        }
    }

    public final void U(final FragmentActivity activity, final Subject subject, final String linkUrl, final String str, final String str2, final String resource, final String str3) {
        Bundle extras;
        String subjectId;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(linkUrl, "linkUrl");
        Intrinsics.h(resource, "resource");
        if (com.transsion.baseui.util.c.f43558a.a((subject == null || (subjectId = subject.getSubjectId()) == null) ? 9528 : subjectId.hashCode(), 2000L)) {
            return;
        }
        if ((str2 == null || str2.length() == 0) && (extras = activity.getIntent().getExtras()) != null) {
            extras.getString("ops");
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(com.tn.lib.widget.R$string.no_network_toast);
        } else if (subject != null) {
            com.transsnet.downloader.manager.f.f59601a.a().j(activity, subject, new Function0() { // from class: com.transsnet.downloader.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit V;
                    V = DownloadManagerApi.V(DownloadManagerApi.this, activity, subject, linkUrl, str, str2, resource, str3);
                    return V;
                }
            });
        } else {
            Z(this, activity, subject, linkUrl, str, str2, resource, str3, null, 128, null);
        }
    }

    @Override // com.transsion.downloadapi.IDownloadApiProvider
    public Fragment a() {
        return TransferInnerMainFragment.INSTANCE.a();
    }

    public final void d0(FragmentActivity activity, String str, String str2, String str3, String str4, boolean z10, Subject subject, String str5, Boolean bool) {
        String string;
        String ops;
        Intrinsics.h(activity, "activity");
        if (str3 == null || str3.length() == 0) {
            Bundle extras = activity.getIntent().getExtras();
            string = extras != null ? extras.getString("ops") : null;
        } else {
            string = str3;
        }
        ns.a.f70665a.a(activity, str, str3, str4, z10, new com.transsion.shorttv.bean.Subject(subject != null ? subject.getSubjectId() : null, subject != null ? subject.getSubjectType() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (subject == null || (ops = subject.getOps()) == null) ? string : ops, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -524292, 1073741823, null), str5, bool);
    }

    public final void f0(final FragmentActivity activity, String str, String str2, String str3, String str4, final String str5, String str6, String str7, String str8, String str9, String str10, boolean z10, final Function4 function4) {
        UGCDownloadDialog b11;
        Intrinsics.h(activity, "activity");
        String i11 = hj.i.f64628a.i();
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        if (str != null && str.length() != 0) {
            b11 = UGCDownloadDialog.INSTANCE.a(str, str3, str4, str5, i11, str6, str7, str2, str8, str9, str10, z10);
        } else if (str2 == null || str2.length() == 0) {
            return;
        } else {
            b11 = UGCDownloadDialog.INSTANCE.b(str2, str4, str5, i11, str6, str7, str8, str9, str10, z10);
        }
        b11.s1(new Function4() { // from class: com.transsnet.downloader.d
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit h02;
                h02 = DownloadManagerApi.h0(Function4.this, this, activity, str5, ((Integer) obj).intValue(), (String) obj2, (DownloadBean) obj3, ((Boolean) obj4).booleanValue());
                return h02;
            }
        });
        b11.show(supportFragmentManager, "download_anima");
    }

    public final Object l0(Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new DownloadManagerApi$fetchLatestDownloadData$2(null), continuation);
    }

    public final void s0(FragmentActivity activity, DownloadBean downloadBean, String str) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(downloadBean, "downloadBean");
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        t0(activity, resourceId, str);
    }

    public final void t0(FragmentActivity activity, String resourceId, String str) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(resourceId, "resourceId");
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new DownloadManagerApi$openDownloadVideo$1(resourceId, str, activity, null), 3, null);
    }

    public final boolean w0(String str, String str2, boolean z10, boolean z11) {
        boolean z12 = CollectionsKt.b0(this.f58523a, str2) || CollectionsKt.b0(this.f58524b, str);
        return z10 ? str != null ? this.f58524b.contains(str) : z12 : (!z11 || str == null) ? z12 : this.f58525c.contains(str);
    }

    public final void y0(String str, Context context, String str2, String str3) {
        Intrinsics.h(context, "context");
        kotlinx.coroutines.j.b(null, new DownloadManagerApi$playNow$1(str, this, context, str2, str3, null), 1, null);
    }
}
