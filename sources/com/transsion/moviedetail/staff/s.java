package com.transsion.moviedetail.staff;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.R$mipmap;
import com.transsion.moviedetail.R$string;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.s;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.moviedetailapi.bean.Subject;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0018\u0019\u001a\u001bBS\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/transsion/moviedetail/staff/s;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "", "", "staffId", "", "staffType", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstPosition", "lastPosition", "", "staffScrollCallback", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)V", "", "data", RequestParameters.POSITION, "N1", "(Ljava/util/List;I)I", "G", "Ljava/lang/Integer;", "H", "a", "d", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "MovieDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class s extends BaseProviderMultiAdapter<Object> {
    public static final int I = 1;
    public static final int J = 2;
    public static final int K = 3;

    /* renamed from: G, reason: from kotlin metadata */
    private final Integer staffType;

    /* loaded from: classes6.dex */
    private static final class b extends BaseItemProvider {
        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public void b(BaseViewHolder helper, Object item) {
            Intrinsics.h(helper, "helper");
            Intrinsics.h(item, "item");
            if (item instanceof hn.a) {
                hn.a aVar = (hn.a) item;
                if (aVar.a() >= aVar.c()) {
                    helper.setText(R$id.tv_load, R$string.movie_staff_show_less);
                    helper.setImageResource(R$id.iv_arrow, R$mipmap.movie_arrow_up);
                } else {
                    helper.setText(R$id.tv_load, R$string.movie_staff_show_more);
                    helper.setImageResource(R$id.iv_arrow, R$mipmap.movie_arrow_down);
                }
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int l() {
            return 2;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int m() {
            return R$layout.movie_staff_item_more;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c extends BaseItemProvider {

        /* renamed from: e, reason: collision with root package name */
        private final String f47381e;

        /* renamed from: f, reason: collision with root package name */
        private final Function2 f47382f;

        /* loaded from: classes6.dex */
        public static final class a extends RecyclerView.r {
            a() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.r
            public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                Intrinsics.h(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i11, i12);
                RecyclerView.m layoutManager = recyclerView.getLayoutManager();
                Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition != null) {
                    Rect rect = new Rect();
                    findViewByPosition.getLocalVisibleRect(rect);
                    if ((rect.width() * 100) / findViewByPosition.getWidth() < 70) {
                        findFirstVisibleItemPosition++;
                    }
                }
                View findViewByPosition2 = linearLayoutManager.findViewByPosition(findLastVisibleItemPosition);
                if (findViewByPosition2 != null) {
                    Rect rect2 = new Rect();
                    findViewByPosition2.getLocalVisibleRect(rect2);
                    if ((rect2.width() * 100) / findViewByPosition2.getWidth() < 70) {
                        findLastVisibleItemPosition--;
                    }
                }
                c.this.A().invoke(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(findLastVisibleItemPosition));
            }
        }

        public c(String str, Function2 callback) {
            Intrinsics.h(callback, "callback");
            this.f47381e = str;
            this.f47382f = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(c cVar, BaseQuickAdapter adapter, View v11, int i11) {
            Intrinsics.h(adapter, "adapter");
            Intrinsics.h(v11, "v");
            Object item = adapter.getItem(i11);
            Intrinsics.f(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Staff");
            Staff staff = (Staff) item;
            Navigator.x(TheRouter.c("/movie/staff").J("staff", staff), v11.getContext(), null, 2, null);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "staff");
            String str = cVar.f47381e;
            if (str == null) {
                str = "";
            }
            hashMap.put("staff_id", str);
            String staffId = staff.getStaffId();
            hashMap.put("related_staff_id", staffId != null ? staffId : "");
            com.transsion.baselib.helper.a.f43316a.i("staff_info", hashMap);
        }

        public final Function2 A() {
            return this.f47382f;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public void b(BaseViewHolder helper, Object item) {
            Intrinsics.h(helper, "helper");
            Intrinsics.h(item, "item");
            RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.f46969rv);
            if (item instanceof MovieStaffList) {
                if (recyclerView.getLayoutManager() == null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(k(), 0, false));
                }
                if (recyclerView.getItemDecorationCount() <= 0) {
                    recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
                }
                if (recyclerView.getAdapter() == null) {
                    List<Staff> items = ((MovieStaffList) item).getItems();
                    if (items == null) {
                        items = Collections.emptyList();
                        Intrinsics.g(items, "emptyList(...)");
                    }
                    com.transsion.moviedetail.adapter.b bVar = new com.transsion.moviedetail.adapter.b(items);
                    bVar.w1(new p6.d() { // from class: com.transsion.moviedetail.staff.t
                        @Override // p6.d
                        public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                            s.c.z(s.c.this, baseQuickAdapter, view, i11);
                        }
                    });
                    recyclerView.setAdapter(bVar);
                    recyclerView.addOnScrollListener(new a());
                }
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int l() {
            return 3;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int m() {
            return R$layout.movie_staff_item_related;
        }
    }

    /* loaded from: classes6.dex */
    private static final class d extends BaseItemProvider {

        /* renamed from: e, reason: collision with root package name */
        private final Integer f47384e;

        public d(Integer num) {
            this.f47384e = num;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public void b(BaseViewHolder helper, Object item) {
            String str;
            String thumbnail;
            Intrinsics.h(helper, "helper");
            Intrinsics.h(item, "item");
            if (item instanceof Subject) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
                if (shapeableImageView != null) {
                    Integer num = this.f47384e;
                    if (num != null && num.intValue() == 6) {
                        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
                        ConstraintLayout.b bVar = null;
                        ConstraintLayout.b bVar2 = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
                        if (bVar2 != null) {
                            bVar2.I = "h,160:90";
                            bVar = bVar2;
                        }
                        shapeableImageView.setLayoutParams(bVar);
                    }
                    f.a aVar = ej.f.f62005a;
                    Context context = shapeableImageView.getContext();
                    Intrinsics.g(context, "getContext(...)");
                    f.b m11 = aVar.m(context);
                    Subject subject = (Subject) item;
                    Cover cover = subject.getCover();
                    String str2 = "";
                    if (cover == null || (str = cover.getUrl()) == null) {
                        str = "";
                    }
                    f.b g11 = m11.g(str);
                    Cover cover2 = subject.getCover();
                    if (cover2 != null && (thumbnail = cover2.getThumbnail()) != null) {
                        str2 = thumbnail;
                    }
                    g11.l(str2).d(shapeableImageView);
                }
                AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tv_title);
                if (appCompatTextView != null) {
                    appCompatTextView.setText(((Subject) item).getTitle());
                }
            }
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int l() {
            return 1;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int m() {
            return R$layout.movie_staff_item_subject;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String str, Integer num, Function2<? super Integer, ? super Integer, Unit> staffScrollCallback) {
        super(null, 1, null);
        Intrinsics.h(staffScrollCallback, "staffScrollCallback");
        this.staffType = num;
        F1(new b());
        F1(new c(str, staffScrollCallback));
        F1(new d(num));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    protected int N1(List<? extends Object> data, int position) {
        Intrinsics.h(data, "data");
        if (data.get(position) instanceof Subject) {
            return 1;
        }
        return data.get(position) instanceof hn.a ? 2 : 3;
    }
}
