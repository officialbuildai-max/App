package com.transsion.home.viewmodel;

import android.app.Application;
import android.net.Uri;
import androidx.view.u0;
import com.transsion.edcation.CourseManager;
import com.transsion.home.bean.DisplayMeta;
import com.transsion.home.bean.FeedsLayoutType;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.home.bean.TrendingRespItemType;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class SubTabViewModel extends androidx.view.b {

    /* renamed from: h, reason: collision with root package name */
    public static final a f45881h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f45882i = 8;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f45883b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f45884c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f45885d;

    /* renamed from: e, reason: collision with root package name */
    private final ol.e f45886e;

    /* renamed from: f, reason: collision with root package name */
    private int f45887f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f45888g;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45883b = new androidx.view.b0();
        this.f45884c = new androidx.view.b0();
        this.f45885d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 x10;
                x10 = SubTabViewModel.x();
                return x10;
            }
        });
        this.f45886e = (ol.e) zg.c.f79537e.a().h(ol.e.class);
        this.f45887f = 1;
        this.f45888g = ak.g.f714a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List l(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it.next();
            Integer type = trendingRespItem.getType();
            int value = TrendingRespItemType.SUBJECT.getValue();
            if (type != null && type.intValue() == value && trendingRespItem.getSubject() != null) {
                OperateItem operateItem = new OperateItem(null, PostItemType.SUBJECT.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483645, null);
                operateItem.setFeedsSubject(trendingRespItem.getSubject());
                arrayList.add(operateItem);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List m(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TrendingRespItem trendingRespItem = (TrendingRespItem) it.next();
            UGCContent content = trendingRespItem.getContent();
            if ((content != null ? content.getVideo() : null) != null) {
                DisplayMeta displayMeta = trendingRespItem.getDisplayMeta();
                if (Intrinsics.c(displayMeta != null ? displayMeta.getLayoutType() : null, FeedsLayoutType.FULL.getValue())) {
                    String value = PostItemType.TRENDING_FEES_BIG.getValue();
                    UGCContent content2 = trendingRespItem.getContent();
                    arrayList.add(new OperateItem(null, value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content2 != null ? content2.getVideo() : null, null, null, null, null, null, null, null, null, null, null, 2146435069, null));
                } else {
                    String value2 = PostItemType.TRENDING_FEES_GRID.getValue();
                    UGCContent content3 = trendingRespItem.getContent();
                    arrayList.add(new OperateItem(null, value2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, content3 != null ? content3.getVideo() : null, null, null, null, null, null, null, null, null, null, null, 2146435069, null));
                }
            }
        }
        return arrayList;
    }

    private final String o(String str, int i11) {
        return str + "_" + i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(int r16, java.lang.String r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.SubTabViewModel.r(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(SubOperateData subOperateData) {
        List<OperateItem> items;
        if (subOperateData == null || (items = subOperateData.getItems()) == null) {
            return;
        }
        for (OperateItem operateItem : items) {
            if (Intrinsics.c(operateItem.getType(), PostItemType.UGC_SUBJECT_LIST.getValue()) && Intrinsics.c(operateItem.getStyleTemplate(), com.transsion.home.adapter.operateUGC.b.O)) {
                operateItem.setType(PostItemType.UGC_VERTICAL_OPT_LIST.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i11, SubOperateData subOperateData) {
        List<OperateItem> items;
        List<OperateItem> items2;
        if (HomeTabId.INSTANCE.h(Integer.valueOf(i11), true) && !ak.o.f721a.i()) {
            CourseManager.s(CourseManager.f44139a, null, null, 3, null);
            if (subOperateData != null && (items2 = subOperateData.getItems()) != null) {
                items2.add(1, new OperateItem(null, PostItemType.MY_COURSE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483645, null));
            }
        }
        String trendingTitle = subOperateData != null ? subOperateData.getTrendingTitle() : null;
        if (trendingTitle == null || trendingTitle.length() == 0 || subOperateData == null || (items = subOperateData.getItems()) == null) {
            return;
        }
        items.add(new OperateItem(subOperateData.getTrendingTitle(), PostItemType.FEEDS_TITLE.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483644, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 x() {
        return new androidx.view.b0();
    }

    public final void n(int i11, boolean z10, String str) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new SubTabViewModel$fetchOperateData$1(z10, this, new Ref.ObjectRef(), i11, str, null), 2, null);
    }

    public final androidx.view.b0 p() {
        return this.f45883b;
    }

    public final androidx.view.b0 q() {
        return this.f45884c;
    }

    public final androidx.view.b0 s() {
        return (androidx.view.b0) this.f45885d.getValue();
    }

    public final void t(int i11, String str, boolean z10) {
        String str2;
        if (z10) {
            this.f45887f = 1;
        }
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        int i12 = this.f45887f;
        this.f45887f = i12 + 1;
        trendingRequestEntity.setPage(String.valueOf(i12));
        trendingRequestEntity.setPerPage(this.f45888g ? 14 : 12);
        trendingRequestEntity.setSessionId(yg.b.f79132a.h());
        Uri c11 = com.transsion.baselib.report.h.f43402a.c();
        if (c11 == null || (str2 = c11.toString()) == null) {
            str2 = "";
        }
        trendingRequestEntity.setDeepLink(str2);
        trendingRequestEntity.setLatest_events(new wj.a(wj.b.f77816a.e()));
        ak.o oVar = ak.o.f721a;
        if (oVar.i()) {
            trendingRequestEntity.setGrade(oVar.e());
        }
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new SubTabViewModel$getTrendingList$1(trendingRequestEntity, this, str, i11, null), 2, null);
    }

    public final void w(boolean z10) {
        this.f45888g = z10;
    }
}
