package com.transsion.shorttv_pugc.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv_pugc.base.widget.HorizontalRecyclerview2;
import com.transsion.shorttv_pugc.base.widget.NpaLinearLayoutManager;
import com.transsion.shorttv_pugc.base.widget.TnTextView;
import com.transsion.shorttv_pugc.bean.Pager;
import com.transsion.shorttv_pugc.bean.ShortTVRespData;
import com.transsion.shorttv_pugc.bean.Subject;
import com.transsion.shorttv_pugc.ui.activity.ShortTvListActivity;
import com.transsion.shorttv_pugc.ui.adapter.ShortTVHeaderViewAdapter;
import com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0001!B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u0010B3\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0012¢\u0006\u0004\b \u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010(R\u0014\u0010,\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010;R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010$¨\u0006?"}, d2 = {"Lcom/transsion/shorttv_pugc/ui/widget/ShortTVFavoriteView;", "Landroid/widget/LinearLayout;", "Landroidx/fragment/app/Fragment;", "fragment", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "Lut/b;", "recReport", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lut/b;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lut/b;Landroid/content/Context;)V", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lut/b;Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "d", "()V", be.g.f16474b, "", "Lcom/transsion/shorttv_pugc/bean/Subject;", "list", com.mbridge.msdk.foundation.same.report.j.f35620b, "(Ljava/util/List;)V", "subject", "i", "(Lcom/transsion/shorttv_pugc/bean/Subject;)V", "getItemOptType", "()Ljava/lang/String;", "clearExposureCache", "a", "Landroidx/fragment/app/Fragment;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "c", "Lut/b;", "", "Z", "isRTL", "e", "I", "dp8", "Lms/g;", "f", "Lms/g;", "viewBinding", "Lcom/transsion/shorttv_pugc/viewmodel/ShortTvViewModel;", "Lkotlin/Lazy;", "getViewModel", "()Lcom/transsion/shorttv_pugc/viewmodel/ShortTvViewModel;", "viewModel", "Lcom/transsion/shorttv_pugc/ui/adapter/ShortTVHeaderViewAdapter;", "h", "Lcom/transsion/shorttv_pugc/ui/adapter/ShortTVHeaderViewAdapter;", "headerAdapter", "Lbt/b;", "Lbt/b;", "exposureHelper", "nextPage", "Companion", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTVFavoriteView extends LinearLayout {
    public static final String TYPE_COLLECTION = "collection";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Fragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ut.b recReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isRTL;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int dp8;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ms.g viewBinding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ShortTVHeaderViewAdapter headerAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bt.b exposureHelper;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String nextPage;

    /* loaded from: classes6.dex */
    public static final class b implements bt.a {
        b() {
        }

        @Override // bt.a
        public void a(int i11, long j11, View view) {
            List<Object> data;
            List<Object> data2;
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = ShortTVFavoriteView.this.headerAdapter;
            if (((shortTVHeaderViewAdapter == null || (data2 = shortTVHeaderViewAdapter.getData()) == null) ? 0 : data2.size()) <= i11) {
                return;
            }
            ShortTVHeaderViewAdapter shortTVHeaderViewAdapter2 = ShortTVFavoriteView.this.headerAdapter;
            Subject subject = (shortTVHeaderViewAdapter2 == null || (data = shortTVHeaderViewAdapter2.getData()) == null) ? null : (Subject) data.get(i11);
            if (subject != null) {
                ShortTVFavoriteView.this.recReport.a("minitv_explore", subject, i11, j11, ShortTVFavoriteView.this.getItemOptType());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends RecyclerView.l {
        c() {
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
                    if (ShortTVFavoriteView.this.isRTL) {
                        outRect.right = ShortTVFavoriteView.this.dp8 * 2;
                        return;
                    } else {
                        outRect.left = ShortTVFavoriteView.this.dp8 * 2;
                        return;
                    }
                }
                if (childAdapterPosition == r4.getItemCount() - 1) {
                    outRect.right = ShortTVFavoriteView.this.dp8;
                    outRect.left = ShortTVFavoriteView.this.dp8;
                } else if (ShortTVFavoriteView.this.isRTL) {
                    outRect.right = ShortTVFavoriteView.this.dp8;
                } else {
                    outRect.left = ShortTVFavoriteView.this.dp8;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f54365a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f54365a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f54365a;
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
            this.f54365a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVFavoriteView(Fragment fragment, String type, ut.b recReport, Context context) {
        this(fragment, type, recReport, context, null);
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(type, "type");
        Intrinsics.h(recReport, "recReport");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTVFavoriteView(Fragment fragment, String type, ut.b recReport, Context context, AttributeSet attributeSet) {
        this(fragment, type, recReport, context, attributeSet, 0);
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(type, "type");
        Intrinsics.h(recReport, "recReport");
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVFavoriteView(final Fragment fragment, String type, ut.b recReport, Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(type, "type");
        Intrinsics.h(recReport, "recReport");
        Intrinsics.h(context, "context");
        this.fragment = fragment;
        this.type = type;
        this.recReport = recReport;
        this.isRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.dp8 = com.blankj.utilcode.util.a0.a(8.0f);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.shorttv_pugc.ui.widget.ShortTVFavoriteView$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvViewModel.class), new Function0<x0>() { // from class: com.transsion.shorttv_pugc.ui.widget.ShortTVFavoriteView$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.shorttv_pugc.ui.widget.ShortTVFavoriteView$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.nextPage = "0";
        View.inflate(context, R$layout.pugc_short_tv_layout_favorite, this);
        ms.g a11 = ms.g.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        setOrientation(1);
        d();
        g();
    }

    private final void d() {
        this.exposureHelper = new bt.b(0.6f, new b(), false, 4, null);
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter = new ShortTVHeaderViewAdapter(null, 1, null);
        shortTVHeaderViewAdapter.w1(new p6.d() { // from class: com.transsion.shorttv_pugc.ui.widget.e
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVFavoriteView.e(ShortTVFavoriteView.this, baseQuickAdapter, view, i11);
            }
        });
        this.headerAdapter = shortTVHeaderViewAdapter;
        HorizontalRecyclerview2 horizontalRecyclerview2 = this.viewBinding.f69899b;
        horizontalRecyclerview2.setLayoutManager(new NpaLinearLayoutManager(horizontalRecyclerview2.getContext(), 0, false));
        horizontalRecyclerview2.addItemDecoration(new c());
        horizontalRecyclerview2.setAdapter(this.headerAdapter);
        bt.b bVar = this.exposureHelper;
        Intrinsics.e(bVar);
        horizontalRecyclerview2.addOnScrollListener(bVar);
        this.viewBinding.f69902e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv_pugc.ui.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTVFavoriteView.f(ShortTVFavoriteView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ShortTVFavoriteView shortTVFavoriteView, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "<unused var>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            shortTVFavoriteView.recReport.b("minitv_explore", subject, i11, shortTVFavoriteView.getItemOptType());
            shortTVFavoriteView.i(subject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ShortTVFavoriteView shortTVFavoriteView, View view) {
        a.C0856a.g(lg.a.f68962a, "Click view all", false, 2, null);
        Navigator.x(TheRouter.c(ls.a.f69157a.c()), shortTVFavoriteView.getContext(), null, 2, null);
    }

    private final void g() {
        if (Intrinsics.c(this.type, "collection")) {
            TnTextView tvTitleTrending = this.viewBinding.f69901d;
            Intrinsics.g(tvTitleTrending, "tvTitleTrending");
            tvTitleTrending.setVisibility(8);
            AppCompatTextView appCompatTextView = this.viewBinding.f69900c;
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R$string.short_tv_my_list) : null);
            getViewModel().x().j(this.fragment, new d(new Function1() { // from class: com.transsion.shorttv_pugc.ui.widget.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h11;
                    h11 = ShortTVFavoriteView.h(ShortTVFavoriteView.this, (ShortTVRespData) obj);
                    return h11;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getItemOptType() {
        return Intrinsics.c(this.type, "collection") ? "collection" : "continue_watching";
    }

    private final ShortTvViewModel getViewModel() {
        return (ShortTvViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(ShortTVFavoriteView shortTVFavoriteView, ShortTVRespData shortTVRespData) {
        String str;
        if (shortTVRespData == null) {
            return Unit.f67184a;
        }
        Pager pager = shortTVRespData.getPager();
        if (pager == null || (str = pager.getNextPage()) == null) {
            str = "0";
        }
        shortTVFavoriteView.nextPage = str;
        shortTVFavoriteView.j(shortTVRespData.getItems());
        return Unit.f67184a;
    }

    private final void i(Subject subject) {
        Context context = getContext();
        if (context != null) {
            if (Intrinsics.c(getItemOptType(), "collection")) {
                qt.a.f73823a.a((FragmentActivity) context, "minitv_explore", subject.getOps(), (r21 & 8) != 0 ? null : "download_subject", (r21 & 16) != 0 ? false : false, (r21 & 32) != 0 ? null : subject, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? Boolean.FALSE : null);
                return;
            }
            String subjectId = subject.getSubjectId();
            if (subjectId != null) {
                ShortTvListActivity.Companion.b(ShortTvListActivity.INSTANCE, context, subjectId, null, 0L, false, 28, null);
            }
        }
    }

    private final void j(List list) {
        ShortTVHeaderViewAdapter shortTVHeaderViewAdapter;
        a.C0856a.f(lg.a.f68962a, "ShortTVCollectionView", "updateList, type:" + this.type + "，size:" + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        List list2 = list;
        if (list2 == null || list2.isEmpty() || (shortTVHeaderViewAdapter = this.headerAdapter) == null) {
            return;
        }
        shortTVHeaderViewAdapter.n1(list2);
    }

    public final void clearExposureCache() {
        bt.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.e();
        }
    }
}
