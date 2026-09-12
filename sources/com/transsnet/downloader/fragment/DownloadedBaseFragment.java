package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.popup.PopupManager;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import okhttp3.internal.http2.Settings;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJO\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010*J'\u0010,\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010*J'\u0010-\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\b2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u0011\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u00107J\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\u0003R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001d\u0010P\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001d\u0010U\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bS\u0010TR\u001d\u0010Z\u001a\u0004\u0018\u00010V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010M\u001a\u0004\bX\u0010Y¨\u0006["}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadedBaseFragment;", "Lcom/transsnet/downloader/fragment/DownloadListBaseFragment;", "<init>", "()V", "Lcom/transsion/baselib/db/download/DownloadBean;", "bean", "", RequestParameters.POSITION, "", "b1", "(Lcom/transsion/baselib/db/download/DownloadBean;I)V", WebConstants.FIELD_ITEM, "Z0", "", "path", "resourceId", "url", "name", "postId", "subjectId", "a1", "(Lcom/transsion/baselib/db/download/DownloadBean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/transsnet/downloader/bean/MovieRecBean;", "movieRecBean", "g1", "(Lcom/transsnet/downloader/bean/MovieRecBean;)V", "V0", "c1", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViewData", "initViewModel", "Lcom/transsnet/downloader/adapter/k;", "adapter", "o0", "(Lcom/transsnet/downloader/adapter/k;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "B0", "(Lcom/transsnet/downloader/adapter/k;Landroid/view/View;I)V", "A0", "C0", "X0", "(Lcom/transsion/baselib/db/download/DownloadBean;Landroid/view/View;I)V", "", "list", "D0", "(Ljava/util/List;)V", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "q0", "()Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "e1", "()I", "getScreenType", "h1", "d", "I", "movieRecPage", "e", "Lcom/transsnet/downloader/viewmodel/DownloadViewModel;", "mForYouViewModel", "f", "Landroid/view/View;", "R0", "()Landroid/view/View;", "f1", "(Landroid/view/View;)V", "mEmptyView", "", be.g.f16474b, "J", "lastRecLoadTime", "Lcom/transsion/room/api/IAudioApi;", "h", "Lkotlin/Lazy;", "getMAudioApi", "()Lcom/transsion/room/api/IAudioApi;", "mAudioApi", "Lcom/transsion/room/api/IFloatingApi;", "i", "getMFloatApi", "()Lcom/transsion/room/api/IFloatingApi;", "mFloatApi", "Ljj/a;", com.mbridge.msdk.foundation.same.report.j.f35620b, "Q0", "()Ljj/a;", "audioDao", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public abstract class DownloadedBaseFragment extends DownloadListBaseFragment {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private DownloadViewModel mForYouViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mEmptyView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lastRecLoadTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int movieRecPage = 1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mAudioApi = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.e5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IAudioApi mAudioApi_delegate$lambda$0;
            mAudioApi_delegate$lambda$0 = DownloadedBaseFragment.mAudioApi_delegate$lambda$0();
            return mAudioApi_delegate$lambda$0;
        }
    });

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mFloatApi = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.f5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IFloatingApi W0;
            W0 = DownloadedBaseFragment.W0();
            return W0;
        }
    });

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy audioDao = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.g5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            jj.a P0;
            P0 = DownloadedBaseFragment.P0();
            return P0;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a implements u0.b {
        a() {
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void a(int i11, int i12) {
            if (i12 == 4 || i12 == 5) {
                Fragment parentFragment = DownloadedBaseFragment.this.getParentFragment();
                FileManagerFragment fileManagerFragment = parentFragment instanceof FileManagerFragment ? (FileManagerFragment) parentFragment : null;
                if (fileManagerFragment != null) {
                    fileManagerFragment.b1();
                }
            }
        }

        @Override // com.transsnet.downloader.adapter.u0.b
        public void b(int i11, int i12, int i13, boolean z10) {
            u0.b.a.a(this, i11, i12, i13, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59157a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59157a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59157a;
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
            this.f59157a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a P0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jj.a Q0() {
        return (jj.a) this.audioDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(DownloadedBaseFragment downloadedBaseFragment) {
        if (nh.m.f70597a.e()) {
            downloadedBaseFragment.V0();
            return Unit.f67184a;
        }
        uh.b.f76876a.d(R$string.no_network_toast);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(DownloadedBaseFragment downloadedBaseFragment, BaseDto baseDto) {
        downloadedBaseFragment.g1((MovieRecBean) baseDto.getData());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(DownloadedBaseFragment downloadedBaseFragment, String str) {
        if (str != null && str.length() != 0) {
            downloadedBaseFragment.c1(str);
        }
        return Unit.f67184a;
    }

    private final void V0() {
        DownloadViewModel downloadViewModel = this.mForYouViewModel;
        if (downloadViewModel != null) {
            downloadViewModel.S(this.movieRecPage, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFloatingApi W0() {
        return (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(DownloadedBaseFragment downloadedBaseFragment) {
        Navigator.x(TheRouter.c("/download/transfer"), downloadedBaseFragment.getContext(), null, 2, null);
        return Unit.f67184a;
    }

    private final void Z0(DownloadBean item, int position) {
        String name;
        String subjectName;
        if (item.getType() == 1) {
            if (item.isFileExist()) {
                kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), null, null, new DownloadedBaseFragment$openMedia$1(this, item, null), 3, null);
                return;
            }
            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f60027a;
            View view = getView();
            Intrinsics.e(view);
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            localVideoNotExistUtil.v(context, item, position);
            return;
        }
        String path = item.getPath();
        String str = path == null ? "" : path;
        String resourceId = item.getResourceId();
        if (resourceId == null) {
            resourceId = item.getUrl();
        }
        String str2 = resourceId;
        String url = item.getUrl();
        String str3 = (!item.isSeries() || (subjectName = item.getSubjectName()) == null || subjectName.length() <= 0 ? (name = item.getName()) != null : (name = item.getSubjectName()) != null) ? name : "";
        String postId = item.getPostId();
        if (postId == null) {
            postId = item.getUrl();
        }
        String str4 = postId;
        String subjectId = item.getSubjectId();
        a1(item, str, str2, url, str3, str4, subjectId == null ? "" : subjectId, position);
    }

    private final void a1(DownloadBean item, String path, String resourceId, String url, String name, String postId, String subjectId, int position) {
        Collection l11;
        String postId2;
        if (item.isShotTV()) {
            Navigator.x(TheRouter.c(ls.a.f69157a.b()).K("id", item.getSubjectId()).F("ep", item.getEp()).K("ops", item.getOps()).G("ms", item.getReadProgress()), getContext(), null, 2, null);
            return;
        }
        if (!item.isShorts()) {
            View view = getView();
            Context context = view != null ? view.getContext() : null;
            AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity == null) {
                return;
            }
            Navigator.x(TheRouter.c("/video/detail").F("subject_type", item.getSubjectType()).K("id", subjectId).K("extra_local_path", path).K("extra_url", url).K("extra_resource_id", resourceId).K("extra_subject_id", subjectId).K("extra_name", name).K("extra_post_id", postId).z("extra_completed", true).z("extra_is_series", item.isSeries()).K("extra_page_from", getPageName()).F("extra_height", item.getVideoHeight()).F("extra_width", item.getVideoWidth()).F("extra_position", position).F("extra_parent_position", getParentPosition()).F("extra_series_position", item.isSeries() ? position : -1), appCompatActivity, null, 2, null);
            return;
        }
        View view2 = getView();
        Context context2 = view2 != null ? view2.getContext() : null;
        AppCompatActivity appCompatActivity2 = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
        if (appCompatActivity2 == null) {
            return;
        }
        List list = (List) s0().O().f();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                DownloadBean downloadBean = (DownloadBean) obj;
                if (downloadBean.isShorts() && (postId2 = downloadBean.getPostId()) != null && postId2.length() != 0) {
                    arrayList.add(obj);
                }
            }
            List I0 = CollectionsKt.I0(arrayList, new Comparator() { // from class: com.transsnet.downloader.fragment.DownloadedBaseFragment$openMp4File$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(Long.valueOf(((DownloadBean) t12).getCreateAt()), Long.valueOf(((DownloadBean) t11).getCreateAt()));
                }
            });
            if (I0 != null) {
                List list2 = I0;
                l11 = new ArrayList(CollectionsKt.v(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    l11.add(DownloadUtil.f60023a.l((DownloadBean) it.next()));
                }
                Navigator.x(TheRouter.c("/post/detailVideo").K("id", item.getPostId()).K(WebConstants.PAGE_FROM, "download_list").z("video_load_more", true).J("downloaded_shorts_list", new ArrayList(l11)).z("prioritize_downloaded", true).z("is_from_downloaded", true).K("media_type", MediaType.VIDEO.getValue()).J("item_object", DownloadUtil.f60023a.l(item)), appCompatActivity2, null, 2, null);
            }
        }
        l11 = CollectionsKt.l();
        Navigator.x(TheRouter.c("/post/detailVideo").K("id", item.getPostId()).K(WebConstants.PAGE_FROM, "download_list").z("video_load_more", true).J("downloaded_shorts_list", new ArrayList(l11)).z("prioritize_downloaded", true).z("is_from_downloaded", true).K("media_type", MediaType.VIDEO.getValue()).J("item_object", DownloadUtil.f60023a.l(item)), appCompatActivity2, null, 2, null);
    }

    private final void b1(DownloadBean bean, int position) {
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Navigator c11 = TheRouter.c("/download/series_list");
        String subjectName = bean.getSubjectName();
        if (subjectName == null) {
            subjectName = "Series";
        }
        Navigator.x(c11.K("extra_name", subjectName).K("extra_subject_id", bean.getSubjectId()).F("extra_parent_position", position), appCompatActivity, null, 2, null);
    }

    private final void c1(String resourceId) {
        py.v mViewBinding;
        RecyclerView recyclerView;
        com.transsnet.downloader.adapter.k mAdapter = getMAdapter();
        if (mAdapter == null) {
            return;
        }
        Iterator<Object> it = mAdapter.getData().iterator();
        final int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            DownloadBean downloadBean = (DownloadBean) it.next();
            if (Intrinsics.c(downloadBean.getResourceId(), resourceId) || Intrinsics.c(downloadBean.getPostId(), resourceId)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0 || (mViewBinding = getMViewBinding()) == null || (recyclerView = mViewBinding.f73068e) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsnet.downloader.fragment.j5
            @Override // java.lang.Runnable
            public final void run() {
                DownloadedBaseFragment.d1(DownloadedBaseFragment.this, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(DownloadedBaseFragment downloadedBaseFragment, int i11) {
        RecyclerView recyclerView;
        py.v mViewBinding = downloadedBaseFragment.getMViewBinding();
        RecyclerView.m layoutManager = (mViewBinding == null || (recyclerView = mViewBinding.f73068e) == null) ? null : recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(i11, 0);
        }
        downloadedBaseFragment.s0().R().q(null);
    }

    private final void g1(MovieRecBean movieRecBean) {
        Object m1185constructorimpl;
        com.transsnet.downloader.adapter.k mAdapter;
        List<Object> data;
        List<Object> data2;
        List<Object> data3;
        com.transsnet.downloader.adapter.k mAdapter2;
        List<Object> data4;
        List<Object> data5;
        NestedScrollView nestedScrollView;
        List<Subject> items;
        DownloadPanelForYouFootView downloadPanelForYouFootView;
        DownloadPanelForYouFootView downloadPanelForYouFootView2;
        DownloadPanelForYouFootView downloadPanelForYouFootView3;
        List<Subject> items2;
        Pager pager;
        String nextPage;
        Integer v11;
        boolean z10 = true;
        this.movieRecPage = (movieRecBean == null || (pager = movieRecBean.getPager()) == null || (nextPage = pager.getNextPage()) == null || (v11 = StringsKt.v(nextPage)) == null) ? 1 : v11.intValue();
        a.C0856a c0856a = lg.a.f68962a;
        Integer num = null;
        num = null;
        a.C0856a.r(c0856a, getTAG(), new String[]{"----------showFootMovieRec,empty  movieRecPage:" + this.movieRecPage + ", size:" + ((movieRecBean == null || (items2 = movieRecBean.getItems()) == null) ? null : Integer.valueOf(items2.size()))}, false, 4, null);
        py.v mViewBinding = getMViewBinding();
        if (mViewBinding != null && (nestedScrollView = mViewBinding.f73069f) != null && nestedScrollView.getVisibility() == 0) {
            a.C0856a.r(c0856a, getTAG(), new String[]{"----------showFootMovieRec,empty  "}, false, 4, null);
            py.v mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (downloadPanelForYouFootView3 = mViewBinding2.f73066c) != null) {
                List<Subject> items3 = movieRecBean != null ? movieRecBean.getItems() : null;
                if (items3 != null && !items3.isEmpty()) {
                    z10 = false;
                }
                downloadPanelForYouFootView3.setVisibility(z10 ? 8 : 0);
            }
            if (movieRecBean == null || (items = movieRecBean.getItems()) == null) {
                return;
            }
            py.v mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (downloadPanelForYouFootView2 = mViewBinding3.f73066c) != null) {
                py.v mViewBinding4 = getMViewBinding();
                downloadPanelForYouFootView2.initBrowseReport(mViewBinding4 != null ? mViewBinding4.f73068e : null);
            }
            py.v mViewBinding5 = getMViewBinding();
            if (mViewBinding5 == null || (downloadPanelForYouFootView = mViewBinding5.f73066c) == null) {
                return;
            }
            downloadPanelForYouFootView.setData(items);
            return;
        }
        List<Subject> items4 = movieRecBean != null ? movieRecBean.getItems() : null;
        if (items4 == null || items4.isEmpty()) {
            return;
        }
        com.transsnet.downloader.adapter.k mAdapter3 = getMAdapter();
        DownloadBean downloadBean = (mAdapter3 == null || (data5 = mAdapter3.getData()) == null) ? null : (DownloadBean) CollectionsKt.v0(data5);
        if (downloadBean != null && downloadBean.getIsFroYouList()) {
            a.C0856a.r(c0856a, getTAG(), new String[]{"----------2showFootMovieRec, data refresh  "}, false, 4, null);
            com.transsnet.downloader.adapter.k mAdapter4 = getMAdapter();
            int i11 = -1;
            if (mAdapter4 != null && (data4 = mAdapter4.getData()) != null) {
                Iterator<Object> it = data4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((DownloadBean) it.next()).getIsFroYouList()) {
                        i11 = r10;
                        break;
                    }
                    r10++;
                }
            }
            if (i11 < 0 || (mAdapter2 = getMAdapter()) == null) {
                return;
            }
            mAdapter2.notifyItemChanged(i11);
            return;
        }
        String tag = getTAG();
        com.transsnet.downloader.adapter.k mAdapter5 = getMAdapter();
        if (mAdapter5 != null && (data3 = mAdapter5.getData()) != null) {
            num = Integer.valueOf(data3.size());
        }
        a.C0856a.r(c0856a, tag, new String[]{"----------3showFootMovieRec, data add  size:" + num}, false, 4, null);
        com.transsnet.downloader.adapter.k mAdapter6 = getMAdapter();
        if (mAdapter6 != null) {
            DownloadBean downloadBean2 = new DownloadBean("", "", "", "", 0L, null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -32, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            downloadBean2.setFroYouList(true);
            mAdapter6.p(downloadBean2);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsnet.downloader.adapter.k mAdapter7 = getMAdapter();
            if (((mAdapter7 == null || (data2 = mAdapter7.getData()) == null) ? 0 : data2.size()) - 2 >= 0 && (mAdapter = getMAdapter()) != null) {
                com.transsnet.downloader.adapter.k mAdapter8 = getMAdapter();
                if (mAdapter8 != null && (data = mAdapter8.getData()) != null) {
                    r10 = data.size();
                }
                mAdapter.notifyItemChanged(r10 - 2);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Result.m1184boximpl(m1185constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi getMAudioApi() {
        return (IAudioApi) this.mAudioApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi getMFloatApi() {
        return (IFloatingApi) this.mFloatApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAudioApi mAudioApi_delegate$lambda$0() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void A0(com.transsnet.downloader.adapter.k adapter, View view, int position) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        DownloadBean downloadBean = (DownloadBean) adapter.getItem(position);
        if (view.getId() == R$id.iv_more) {
            X0(downloadBean, view, position);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void B0(com.transsnet.downloader.adapter.k adapter, View view, int position) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        DownloadBean downloadBean = (DownloadBean) adapter.getItem(position);
        if (downloadBean.getIsFroYouList() || downloadBean.getStatus() == 14) {
            return;
        }
        if (downloadBean.getStatus() == 10) {
            b1(downloadBean, position);
        } else {
            Z0(downloadBean, position);
        }
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void C0(com.transsnet.downloader.adapter.k adapter, View view, int position) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        X0((DownloadBean) adapter.getItem(position), view, position);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void D0(List list) {
        androidx.view.b0 T;
        androidx.view.b0 T2;
        androidx.view.b0 T3;
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            h1();
        } else {
            py.v mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView = mViewBinding.f73068e) != null) {
                jg.c.k(recyclerView);
            }
            py.v mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (nestedScrollView = mViewBinding2.f73069f) != null) {
                jg.c.g(nestedScrollView);
            }
            super.D0(list);
            String str = (String) s0().R().f();
            if (str != null && str.length() != 0) {
                c1(str);
            }
        }
        if (this instanceof DownloadEpisodesListFragment) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DownloadViewModel downloadViewModel = this.mForYouViewModel;
        BaseDto baseDto = null;
        BaseDto baseDto2 = (downloadViewModel == null || (T3 = downloadViewModel.T()) == null) ? null : (BaseDto) T3.f();
        if (baseDto2 != null) {
            MovieRecBean movieRecBean = (MovieRecBean) baseDto2.getData();
            List<Subject> items = movieRecBean != null ? movieRecBean.getItems() : null;
            if (items != null && !items.isEmpty() && currentTimeMillis - this.lastRecLoadTime < 180000) {
                DownloadViewModel downloadViewModel2 = this.mForYouViewModel;
                if (downloadViewModel2 == null || (T = downloadViewModel2.T()) == null) {
                    return;
                }
                DownloadViewModel downloadViewModel3 = this.mForYouViewModel;
                if (downloadViewModel3 != null && (T2 = downloadViewModel3.T()) != null) {
                    baseDto = (BaseDto) T2.f();
                }
                T.q(baseDto);
                return;
            }
        }
        this.lastRecLoadTime = currentTimeMillis;
        V0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: R0, reason: from getter */
    public final View getMEmptyView() {
        return this.mEmptyView;
    }

    public void X0(DownloadBean bean, View view, int position) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(view, "view");
        PopupManager popupManager = new PopupManager(position, bean);
        popupManager.J(view, 1);
        popupManager.C(new Function0() { // from class: com.transsnet.downloader.fragment.i5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Y0;
                Y0 = DownloadedBaseFragment.Y0(DownloadedBaseFragment.this);
                return Y0;
            }
        });
        popupManager.B(new a());
    }

    /* renamed from: e1 */
    public int getParentPosition() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f1(View view) {
        this.mEmptyView = view;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public int getScreenType() {
        return 6;
    }

    public void h1() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        NestedScrollView nestedScrollView;
        RecyclerView recyclerView;
        com.transsnet.downloader.adapter.k mAdapter = getMAdapter();
        if (mAdapter != null) {
            mAdapter.n1(null);
        }
        py.v mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f73068e) != null) {
            jg.c.g(recyclerView);
        }
        py.v mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (nestedScrollView = mViewBinding2.f73069f) != null) {
            jg.c.k(nestedScrollView);
        }
        py.v mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (frameLayout2 = mViewBinding3.f73065b) != null) {
            frameLayout2.removeAllViews();
        }
        py.v mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (frameLayout = mViewBinding4.f73065b) == null) {
            return;
        }
        frameLayout.addView(getEmptyView(false));
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        DownloadPanelForYouFootView downloadPanelForYouFootView;
        super.initViewData();
        py.v mViewBinding = getMViewBinding();
        if (mViewBinding == null || (downloadPanelForYouFootView = mViewBinding.f73066c) == null) {
            return;
        }
        downloadPanelForYouFootView.setRefreshClickCallback(new Function0() { // from class: com.transsnet.downloader.fragment.h5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit S0;
                S0 = DownloadedBaseFragment.S0(DownloadedBaseFragment.this);
                return S0;
            }
        });
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.view.b0 T;
        super.initViewModel();
        DownloadViewModel downloadViewModel = this.mForYouViewModel;
        if (downloadViewModel != null && (T = downloadViewModel.T()) != null) {
            T.j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.c5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit T0;
                    T0 = DownloadedBaseFragment.T0(DownloadedBaseFragment.this, (BaseDto) obj);
                    return T0;
                }
            }));
        }
        s0().R().j(this, new b(new Function1() { // from class: com.transsnet.downloader.fragment.d5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = DownloadedBaseFragment.U0(DownloadedBaseFragment.this, (String) obj);
                return U0;
            }
        }));
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    public void o0(com.transsnet.downloader.adapter.k adapter) {
        Intrinsics.h(adapter, "adapter");
        adapter.l(R$id.iv_more);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mForYouViewModel = (DownloadViewModel) new androidx.view.v0(this).a(DownloadViewModel.class);
    }

    @Override // com.transsnet.downloader.fragment.DownloadListBaseFragment
    /* renamed from: q0, reason: from getter */
    public DownloadViewModel getMForYouViewModel() {
        return this.mForYouViewModel;
    }
}
