package com.transsnet.downloader.ugc.fragment;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import androidx.view.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.MBridgeConstans;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredAdapter;
import com.transsnet.downloader.ugc.adapter.c;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J'\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/transsnet/downloader/ugc/fragment/UGCDownloadedListFragment;", "Lcom/transsnet/downloader/ugc/fragment/UGCStaggeredListBaseFragment;", "<init>", "()V", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "list", "", "w1", "(Ljava/util/List;)V", "q1", "", "tabTitle", "p1", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "receiveArguments", "initViewModel", "initListener", "bean", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", RequestParameters.POSITION, "S0", "(Lcom/transsion/baselib/db/download/DownloadBean;Landroid/view/View;I)V", "E0", "()Ljava/lang/String;", "l", "Ljava/lang/String;", "tabTitleArg", "m", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class UGCDownloadedListFragment extends UGCStaggeredListBaseFragment {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String tabTitleArg;

    /* renamed from: com.transsnet.downloader.ugc.fragment.UGCDownloadedListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UGCDownloadedListFragment a(String tabTitle) {
            Intrinsics.h(tabTitle, "tabTitle");
            UGCDownloadedListFragment uGCDownloadedListFragment = new UGCDownloadedListFragment();
            uGCDownloadedListFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("arg_tab_title", tabTitle)));
            return uGCDownloadedListFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements u0.b {
        b() {
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void a(int i11, int i12) {
            if (i12 == 4) {
                DownloadViewModel.N(UGCDownloadedListFragment.this.x0(), false, 1, null);
            }
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void b(int i11, int i12, int i13, boolean z10) {
            u0.b.a.a(this, i11, i12, i13, z10);
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59849a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59849a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59849a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59849a.invoke(obj);
        }
    }

    private final String p1(String tabTitle) {
        Application a11 = Utils.a();
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_video))) {
            return "video";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_music))) {
            return "music";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_education))) {
            return "education";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_short_tv))) {
            return "short_tv";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_sport))) {
            return "sport";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_room))) {
            return PlaceTypes.ROOM;
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_novel))) {
            return "novel";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_live))) {
            return "live";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_kids))) {
            return "kids";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_recreation))) {
            return "recreation";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_movie))) {
            return "movie";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_tv))) {
            return "tv";
        }
        if (Intrinsics.c(tabTitle, a11.getString(R$string.ugc_tab_post))) {
            return "post";
        }
        if (Intrinsics.c(tabTitle, "TAB_ALL")) {
            return IntegrationConstants.NAVIGATION_BAR_ALL_ACTION;
        }
        String lowerCase = tabTitle.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return StringsKt.Q(lowerCase, " ", "_", false, 4, null);
    }

    private final void q1() {
        Function1 function1 = new Function1() { // from class: com.transsnet.downloader.ugc.fragment.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r12;
                r12 = UGCDownloadedListFragment.r1(UGCDownloadedListFragment.this, (my.a) obj);
                return r12;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = my.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsnet.downloader.ugc.fragment.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s12;
                s12 = UGCDownloadedListFragment.s1(UGCDownloadedListFragment.this, (my.g) obj);
                return s12;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = my.g.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(UGCDownloadedListFragment uGCDownloadedListFragment, my.a it) {
        Intrinsics.h(it, "it");
        try {
            DownloadViewModel.N(uGCDownloadedListFragment.x0(), false, 1, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:3:0x0005, B:5:0x0010, B:7:0x0016, B:8:0x001e, B:10:0x0024, B:12:0x002c, B:13:0x0033, B:15:0x0039, B:17:0x0046, B:22:0x0052, B:24:0x0060, B:28:0x007f, B:33:0x0071, B:37:0x0088, B:38:0x008c, B:40:0x0092), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:3:0x0005, B:5:0x0010, B:7:0x0016, B:8:0x001e, B:10:0x0024, B:12:0x002c, B:13:0x0033, B:15:0x0039, B:17:0x0046, B:22:0x0052, B:24:0x0060, B:28:0x007f, B:33:0x0071, B:37:0x0088, B:38:0x008c, B:40:0x0092), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:3:0x0005, B:5:0x0010, B:7:0x0016, B:8:0x001e, B:10:0x0024, B:12:0x002c, B:13:0x0033, B:15:0x0039, B:17:0x0046, B:22:0x0052, B:24:0x0060, B:28:0x007f, B:33:0x0071, B:37:0x0088, B:38:0x008c, B:40:0x0092), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit s1(com.transsnet.downloader.ugc.fragment.UGCDownloadedListFragment r9, my.g r10) {
        /*
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r0.<init>()     // Catch: java.lang.Throwable -> L30
            com.transsnet.downloader.ugc.adapter.UGCDownloadStaggeredAdapter r1 = r9.getStaggeredAdapter()     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L88
            java.util.List r1 = r1.getData()     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L88
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L30
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L30
            r2 = 0
            r3 = r2
        L1e:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L88
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L30
            int r5 = r3 + 1
            if (r3 >= 0) goto L33
            kotlin.collections.CollectionsKt.u()     // Catch: java.lang.Throwable -> L30
            goto L33
        L30:
            r9 = move-exception
            goto La4
        L33:
            com.transsnet.downloader.ugc.adapter.c r4 = (com.transsnet.downloader.ugc.adapter.c) r4     // Catch: java.lang.Throwable -> L30
            boolean r6 = r4 instanceof com.transsnet.downloader.ugc.adapter.c.b     // Catch: java.lang.Throwable -> L30
            if (r6 == 0) goto L86
            com.transsnet.downloader.ugc.adapter.c$b r4 = (com.transsnet.downloader.ugc.adapter.c.b) r4     // Catch: java.lang.Throwable -> L30
            com.transsion.baselib.db.download.DownloadBean r4 = r4.b()     // Catch: java.lang.Throwable -> L30
            java.lang.String r6 = r4.getUgcVideoCollectionId()     // Catch: java.lang.Throwable -> L30
            r7 = 1
            if (r6 == 0) goto L4f
            int r6 = r6.length()     // Catch: java.lang.Throwable -> L30
            if (r6 != 0) goto L4d
            goto L4f
        L4d:
            r6 = r2
            goto L50
        L4f:
            r6 = r7
        L50:
            if (r6 != 0) goto L71
            java.lang.String r6 = r4.getUgcVideoCollectionId()     // Catch: java.lang.Throwable -> L30
            java.lang.String r8 = r10.a()     // Catch: java.lang.Throwable -> L30
            boolean r6 = kotlin.jvm.internal.Intrinsics.c(r6, r8)     // Catch: java.lang.Throwable -> L30
            if (r6 == 0) goto L6f
            java.lang.String r4 = r4.getUgcVideoId()     // Catch: java.lang.Throwable -> L30
            java.lang.String r6 = r10.c()     // Catch: java.lang.Throwable -> L30
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r4, r6)     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L6f
            goto L7d
        L6f:
            r7 = r2
            goto L7d
        L71:
            java.lang.String r4 = r4.getUgcVideoId()     // Catch: java.lang.Throwable -> L30
            java.lang.String r6 = r10.c()     // Catch: java.lang.Throwable -> L30
            boolean r7 = kotlin.jvm.internal.Intrinsics.c(r4, r6)     // Catch: java.lang.Throwable -> L30
        L7d:
            if (r7 == 0) goto L86
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L30
            r0.add(r3)     // Catch: java.lang.Throwable -> L30
        L86:
            r3 = r5
            goto L1e
        L88:
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L30
        L8c:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto La7
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L30
            java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Throwable -> L30
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L30
            long r2 = r10.b()     // Catch: java.lang.Throwable -> L30
            r9.g1(r1, r2)     // Catch: java.lang.Throwable -> L30
            goto L8c
        La4:
            r9.printStackTrace()
        La7:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.ugc.fragment.UGCDownloadedListFragment.s1(com.transsnet.downloader.ugc.fragment.UGCDownloadedListFragment, my.g):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(UGCDownloadedListFragment uGCDownloadedListFragment, Map map) {
        List l11;
        Collection values;
        if (Intrinsics.c(uGCDownloadedListFragment.tabTitleArg, "TAB_ALL")) {
            if (map == null || (values = map.values()) == null || (l11 = CollectionsKt.x(values)) == null) {
                l11 = CollectionsKt.l();
            }
        } else if (map == null || (l11 = (List) map.get(uGCDownloadedListFragment.tabTitleArg)) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.size() > 3) {
            l11 = l11.subList(0, 3);
        }
        uGCDownloadedListFragment.w1(l11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(UGCDownloadedListFragment uGCDownloadedListFragment, Map map) {
        Collection values;
        List list = null;
        if (Intrinsics.c(uGCDownloadedListFragment.tabTitleArg, "TAB_ALL")) {
            if (map != null && (values = map.values()) != null) {
                list = CollectionsKt.x(values);
            }
        } else if (map != null) {
            list = (List) map.get(uGCDownloadedListFragment.tabTitleArg);
        }
        uGCDownloadedListFragment.w1(list);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(UGCDownloadedListFragment uGCDownloadedListFragment) {
        Navigator.x(TheRouter.c("/download/transfer"), uGCDownloadedListFragment.requireContext(), null, 2, null);
        return Unit.f67184a;
    }

    private final void w1(List list) {
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            arrayList.add(c.d.f59740a);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new c.b((DownloadBean) it.next()));
            }
        }
        a1(arrayList);
        UGCDownloadStaggeredAdapter staggeredAdapter = getStaggeredAdapter();
        if (staggeredAdapter != null) {
            staggeredAdapter.n1(arrayList);
        }
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || !logViewConfig.i()) {
            u0();
            hj.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.k(true);
            }
        }
        b1();
    }

    @Override // com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment
    public String E0() {
        String str;
        String str2 = Intrinsics.c(getModeArg(), "ugc_sub") ? "/download/ugc_my_downloaded" : "/download/ugc_downloaded";
        String str3 = this.tabTitleArg;
        if (str3 == null || (str = p1(str3)) == null) {
            str = "";
        }
        if (str.length() <= 0) {
            return str2;
        }
        return str2 + "_" + str;
    }

    @Override // com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment
    public void S0(DownloadBean bean, View view, int position) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(view, "view");
        DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
        String resourceId = bean.getResourceId();
        if (resourceId == null) {
            resourceId = bean.getUrl();
        }
        DownloadBean q11 = a11.q(resourceId);
        if (q11 != null) {
            bean = q11;
        }
        PopupManager popupManager = new PopupManager(position, bean);
        popupManager.J(view, 1);
        popupManager.C(new Function0() { // from class: com.transsnet.downloader.ugc.fragment.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit v12;
                v12 = UGCDownloadedListFragment.v1(UGCDownloadedListFragment.this);
                return v12;
            }
        });
        popupManager.B(new b());
    }

    @Override // com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        q1();
    }

    @Override // com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        String modeArg = getModeArg();
        if (Intrinsics.c(modeArg, "ugc_home")) {
            x0().L().j(this, new c(new Function1() { // from class: com.transsnet.downloader.ugc.fragment.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit t12;
                    t12 = UGCDownloadedListFragment.t1(UGCDownloadedListFragment.this, (Map) obj);
                    return t12;
                }
            }));
        } else if (Intrinsics.c(modeArg, "ugc_sub")) {
            x0().L().j(this, new c(new Function1() { // from class: com.transsnet.downloader.ugc.fragment.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit u12;
                    u12 = UGCDownloadedListFragment.u1(UGCDownloadedListFragment.this, (Map) obj);
                    return u12;
                }
            }));
        }
    }

    @Override // com.transsnet.downloader.ugc.fragment.UGCStaggeredListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.tabTitleArg = arguments.getString("arg_tab_title");
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void receiveArguments() {
        super.receiveArguments();
    }
}
