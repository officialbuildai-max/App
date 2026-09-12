package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.TnTextView;
import com.transsion.moviedetailapi.bean.PlayListDeepLink;
import com.transsion.moviedetailapi.bean.PlayListItemBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.shorttv.adapter.ShortTVHeaderViewAdapter;
import com.transsnet.downloader.DownloadManagerApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import so.j0;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\fB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u00104¨\u00066"}, d2 = {"Lcom/transsion/postdetail/shorttv/widget/ShortTVDiscoverHeaderView;", "Landroid/widget/LinearLayout;", "Lcom/transsion/moviedetailapi/bean/PlayListItemBean;", "playListBean", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Lcom/transsion/moviedetailapi/bean/PlayListItemBean;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Lcom/transsion/moviedetailapi/bean/PlayListItemBean;Landroid/content/Context;)V", "(Lcom/transsion/moviedetailapi/bean/PlayListItemBean;Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "c", "()V", "f", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", be.g.f16474b, "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "", "getItemOptType", "()Ljava/lang/String;", "", "list", "updateList", "(Ljava/util/List;)V", "clearExposureCache", "a", "Lcom/transsion/moviedetailapi/bean/PlayListItemBean;", "getPlayListBean", "()Lcom/transsion/moviedetailapi/bean/PlayListItemBean;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "isRTL", "I", "dp8", "Lso/j0;", "d", "Lso/j0;", "viewBinding", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "e", "Lcom/transsion/postdetail/shorttv/adapter/ShortTVHeaderViewAdapter;", "headerAdapter", "Lsj/b;", "Lsj/b;", "exposureHelper", "Lcom/transsion/postdetail/shorttv/j;", "Lcom/transsion/postdetail/shorttv/j;", "recReport", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTVDiscoverHeaderView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PlayListItemBean playListBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isRTL;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int dp8;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final j0 viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ShortTVHeaderViewAdapter headerAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final com.transsion.postdetail.shorttv.j recReport;

    /* loaded from: classes6.dex */
    public static final class a implements sj.a {
        a() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            List<Object> data;
            List<Object> data2;
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = ShortTVDiscoverHeaderView.this.headerAdapter;
            if (((shortTVHeaderViewAdapter == null || (data2 = shortTVHeaderViewAdapter.getData()) == null) ? 0 : data2.size()) <= i11) {
                return;
            }
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter2 = ShortTVDiscoverHeaderView.this.headerAdapter;
            Subject subject = (shortTVHeaderViewAdapter2 == null || (data = shortTVHeaderViewAdapter2.getData()) == null) ? null : (Subject) data.get(i11);
            if (subject != null) {
                ShortTVDiscoverHeaderView.this.recReport.a("minitv_explore", subject, i11, j11, ShortTVDiscoverHeaderView.this.getItemOptType());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.l {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            Intrinsics.h(outRect, "outRect");
            Intrinsics.h(view, "view");
            Intrinsics.h(parent, "parent");
            Intrinsics.h(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                if (childAdapterPosition == 0) {
                    if (ShortTVDiscoverHeaderView.this.isRTL) {
                        outRect.right = ShortTVDiscoverHeaderView.this.dp8 * 2;
                        return;
                    } else {
                        outRect.left = ShortTVDiscoverHeaderView.this.dp8 * 2;
                        return;
                    }
                }
                if (childAdapterPosition == r4.getItemCount() - 1) {
                    outRect.right = ShortTVDiscoverHeaderView.this.dp8;
                    outRect.left = ShortTVDiscoverHeaderView.this.dp8;
                } else if (ShortTVDiscoverHeaderView.this.isRTL) {
                    outRect.right = ShortTVDiscoverHeaderView.this.dp8;
                } else {
                    outRect.left = ShortTVDiscoverHeaderView.this.dp8;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListBean, Context context) {
        this(playListBean, context, null);
        Intrinsics.h(playListBean, "playListBean");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListBean, Context context, AttributeSet attributeSet) {
        this(playListBean, context, attributeSet, 0);
        Intrinsics.h(playListBean, "playListBean");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverHeaderView(PlayListItemBean playListBean, Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(playListBean, "playListBean");
        Intrinsics.h(context, "context");
        this.playListBean = playListBean;
        this.isRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.dp8 = a0.a(8.0f);
        this.recReport = new com.transsion.postdetail.shorttv.j();
        View.inflate(context, R$layout.layout_short_tv_discover_header, this);
        j0 a11 = j0.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        setOrientation(1);
        c();
        f();
    }

    private final void c() {
        this.exposureHelper = new sj.b(0.6f, new a(), false, 4, null);
        this.viewBinding.f75687e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVDiscoverHeaderView.d(ShortTVDiscoverHeaderView.this, view);
            }
        });
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = new ShortTVHeaderViewAdapter(this.exposureHelper);
        shortTVHeaderViewAdapter.w1(new p6.d() { // from class: com.transsion.postdetail.shorttv.widget.f
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVDiscoverHeaderView.e(ShortTVDiscoverHeaderView.this, baseQuickAdapter, view, i11);
            }
        });
        this.headerAdapter = shortTVHeaderViewAdapter;
        RecyclerView recyclerView = this.viewBinding.f75684b;
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new b());
        recyclerView.setAdapter(this.headerAdapter);
        sj.b bVar = this.exposureHelper;
        Intrinsics.e(bVar);
        recyclerView.addOnScrollListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ShortTVDiscoverHeaderView shortTVDiscoverHeaderView, View view) {
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.g(c0856a, "Click view all", false, 2, null);
        PlayListDeepLink a11 = PlayListDeepLink.INSTANCE.a(shortTVDiscoverHeaderView.playListBean.getDeepLink());
        if (a11 != null) {
            Navigator.x(TheRouter.c("/home/playlist").K("label", a11.getLabel()).K("category", a11.getCategory()).K("recType", a11.getRecType()).K("topIds", null), shortTVDiscoverHeaderView.getContext(), null, 2, null);
            return;
        }
        a.C0856a.m(c0856a, "Invalid deeplink for " + shortTVDiscoverHeaderView.playListBean.getTitle() + ", " + shortTVDiscoverHeaderView.playListBean.getDeepLink(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ShortTVDiscoverHeaderView shortTVDiscoverHeaderView, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            shortTVDiscoverHeaderView.recReport.b("minitv_explore", subject, i11, shortTVDiscoverHeaderView.getItemOptType());
            shortTVDiscoverHeaderView.g(subject);
        }
    }

    private final void f() {
        if (this.playListBean.isLastOne()) {
            TnTextView tvTitleTrending = this.viewBinding.f75686d;
            Intrinsics.g(tvTitleTrending, "tvTitleTrending");
            tvTitleTrending.setVisibility(0);
        }
        this.viewBinding.f75685c.setText(this.playListBean.getTitle());
        updateList(this.playListBean.getSubjects());
    }

    private final void g(Subject subject) {
        Context context = getContext();
        if (context != null) {
            String itemOptType = getItemOptType();
            if (Intrinsics.c(itemOptType, "new_release") || Intrinsics.c(itemOptType, "playlist")) {
                DownloadManagerApi.f58521j.a().d0((FragmentActivity) context, "minitv_explore", (r22 & 4) != 0 ? "" : "", subject.getOps(), (r22 & 16) != 0 ? null : "download_subject", (r22 & 32) != 0 ? false : false, (r22 & 64) != 0 ? null : subject, (r22 & 128) != 0 ? null : null, (r22 & 256) != 0 ? Boolean.FALSE : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getItemOptType() {
        return Intrinsics.c(this.playListBean.getId(), "10000000000") ? "new_release" : "playlist";
    }

    public final void clearExposureCache() {
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final PlayListItemBean getPlayListBean() {
        return this.playListBean;
    }

    public final void updateList(List<? extends Subject> list) {
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter;
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty() || (shortTVHeaderViewAdapter = this.headerAdapter) == null) {
            return;
        }
        shortTVHeaderViewAdapter.n1(list2);
    }
}
