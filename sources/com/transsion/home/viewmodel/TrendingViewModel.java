package com.transsion.home.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import androidx.view.u0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.p006enum.PostListSource;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes.dex */
public final class TrendingViewModel extends AbsSubjectListViewModel {

    /* renamed from: p, reason: collision with root package name */
    public static final a f45902p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f45903q = 8;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f45904k;

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f45905l;

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f45906m;

    /* renamed from: n, reason: collision with root package name */
    private int f45907n;

    /* renamed from: o, reason: collision with root package name */
    private final ol.e f45908o;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45904k = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 c02;
                c02 = TrendingViewModel.c0();
                return c02;
            }
        });
        this.f45905l = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 Z;
                Z = TrendingViewModel.Z();
                return Z;
            }
        });
        this.f45906m = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                androidx.view.b0 b02;
                b02 = TrendingViewModel.b0();
                return b02;
            }
        });
        this.f45907n = 12;
        this.f45908o = (ol.e) zg.c.f79537e.a().h(ol.e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(TrendingViewModel trendingViewModel) {
        String string = rl.e.f74676a.b().getString("trending_room_entrance_cache_v2", "");
        if (string == null || string.length() == 0) {
            lg.a.f68962a.c("TrendingViewModel", "fetchGroupInfo failed without cache", true);
        } else {
            trendingViewModel.W().n((RoomEntranceResponse) com.blankj.utilcode.util.o.d(string, RoomEntranceResponse.class));
            lg.a.f68962a.c("TrendingViewModel", "fetchGroupInfo use cache", true);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 Z() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 b0() {
        return new androidx.view.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 c0() {
        return new androidx.view.b0();
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public PostListSource A() {
        return PostListSource.POSTLIST;
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void E(boolean z10) {
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public void F(Bundle bundle) {
    }

    public final void T(boolean z10) {
        Function0 function0 = new Function0() { // from class: com.transsion.home.viewmodel.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit U;
                U = TrendingViewModel.U(TrendingViewModel.this);
                return U;
            }
        };
        if (z10) {
            function0.invoke();
        } else {
            kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new TrendingViewModel$fetchGroupInfo$1(this, function0, null), 2, null);
        }
    }

    public final androidx.view.b0 V() {
        return (androidx.view.b0) this.f45905l.getValue();
    }

    public final androidx.view.b0 W() {
        return (androidx.view.b0) this.f45906m.getValue();
    }

    public final androidx.view.b0 X() {
        return (androidx.view.b0) this.f45904k.getValue();
    }

    public final void Y(String nextPage, int i11, boolean z10) {
        String str;
        Intrinsics.h(nextPage, "nextPage");
        TrendingRequestEntity trendingRequestEntity = new TrendingRequestEntity();
        trendingRequestEntity.setPage(nextPage);
        trendingRequestEntity.setPerPage(i11);
        trendingRequestEntity.setSessionId(yg.b.f79132a.h());
        Uri c11 = com.transsion.baselib.report.h.f43402a.c();
        if (c11 == null || (str = c11.toString()) == null) {
            str = "";
        }
        trendingRequestEntity.setDeepLink(str);
        trendingRequestEntity.setLatest_events(new wj.a(wj.b.f77816a.e()));
        trendingRequestEntity.setTabId(String.valueOf(HomeTabId.Trending.getValue()));
        trendingRequestEntity.setDisablePlaylist(Boolean.valueOf(z10));
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new TrendingViewModel$getTrendingList$1(trendingRequestEntity, this, nextPage, null), 2, null);
    }

    public final void a0(Subject subject, int i11, String moduleName) {
        Intrinsics.h(subject, "subject");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        hashMap.put("subject_id", subjectId);
        hashMap.put("has_resource", String.valueOf(subject.getHasResource()));
        hashMap.put("item_type", "rec");
        String title = subject.getTitle();
        if (title == null) {
            title = "";
        }
        hashMap.put(CampaignEx.JSON_KEY_TITLE, title);
        String ops = subject.getOps();
        if (ops == null) {
            ops = "";
        }
        hashMap.put("ops", ops);
        hashMap.put(WebConstants.PAGE_FROM, v());
        hashMap.put("sequence", String.valueOf(i11));
        Map u11 = u(t().ordinal());
        if (u11 != null) {
            for (Map.Entry entry : u11.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str2 == null) {
                    str2 = "";
                }
                hashMap.put(str, str2);
            }
        }
        com.transsion.baselib.helper.a.f43316a.g(w(t().ordinal()), hashMap);
    }

    @Override // com.transsion.moviedetailapi.AbsSubjectListViewModel
    public String w(int i11) {
        return "Trending";
    }
}
