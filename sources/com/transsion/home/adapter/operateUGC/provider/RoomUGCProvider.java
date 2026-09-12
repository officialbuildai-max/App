package com.transsion.home.adapter.operateUGC.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.viewmodel.TrendingUGCViewModel;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gl.k0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class RoomUGCProvider extends BaseItemProvider {

    /* renamed from: h, reason: collision with root package name */
    public static final a f44367h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f44368i = 8;

    /* renamed from: e, reason: collision with root package name */
    private final int f44369e;

    /* renamed from: f, reason: collision with root package name */
    private final BaseHomeSubFragment f44370f;

    /* renamed from: g, reason: collision with root package name */
    private final TrendingUGCViewModel f44371g;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/provider/RoomUGCProvider$PostAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "", "tabId", "Lcom/transsion/home/bean/OperateItem;", "operateItem", "<init>", "(ILcom/transsion/home/bean/OperateItem;)V", "", "data", RequestParameters.POSITION, "N1", "(Ljava/util/List;I)I", "G", "I", "PostItemProvider", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class PostAdapter extends BaseProviderMultiAdapter<PostSubjectItem> {
        public static final int H = 8;

        /* renamed from: G, reason: from kotlin metadata */
        private final int tabId;

        /* loaded from: classes5.dex */
        public static final class PostItemProvider extends BaseItemProvider {

            /* renamed from: e, reason: collision with root package name */
            private final int f44372e;

            /* renamed from: f, reason: collision with root package name */
            private final OperateItem f44373f;

            /* renamed from: g, reason: collision with root package name */
            private final int f44374g;

            /* renamed from: h, reason: collision with root package name */
            private final int f44375h;

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/operateUGC/provider/RoomUGCProvider$PostAdapter$PostItemProvider$PostItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lgl/k0;", "viewBinding", "<init>", "(Lgl/k0;)V", "a", "Lgl/k0;", "f", "()Lgl/k0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
            /* loaded from: classes5.dex */
            public static final class PostItemVH extends BaseViewHolder {

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                private final k0 viewBinding;

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public PostItemVH(gl.k0 r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "viewBinding"
                        kotlin.jvm.internal.Intrinsics.h(r3, r0)
                        com.noober.background.view.BLConstraintLayout r0 = r3.getRoot()
                        java.lang.String r1 = "getRoot(...)"
                        kotlin.jvm.internal.Intrinsics.g(r0, r1)
                        r2.<init>(r0)
                        r2.viewBinding = r3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.operateUGC.provider.RoomUGCProvider.PostAdapter.PostItemProvider.PostItemVH.<init>(gl.k0):void");
                }

                /* renamed from: f, reason: from getter */
                public final k0 getViewBinding() {
                    return this.viewBinding;
                }
            }

            public PostItemProvider(int i11, OperateItem operateItem) {
                this.f44372e = i11;
                this.f44373f = operateItem;
                int e11 = (com.blankj.utilcode.util.y.e() - dk.a.b(40)) / 3;
                this.f44374g = e11;
                this.f44375h = (e11 * 150) / 107;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void A(PostItemProvider postItemProvider, PostSubjectItem postSubjectItem, PostItemVH postItemVH, View view) {
                postItemProvider.C(postSubjectItem, postItemVH.getAdapterPosition());
            }

            private final void C(PostSubjectItem postSubjectItem, int i11) {
                D(i11, this.f44373f, postSubjectItem);
                aq.h.k(aq.h.f16175a, postSubjectItem, postSubjectItem.getOps(), "UgcTrending", false, 8, null);
            }

            private final void D(int i11, OperateItem operateItem, PostSubjectItem postSubjectItem) {
                String str;
                String str2;
                String str3;
                String str4;
                String value;
                String ops;
                Integer subjectType;
                String postId = postSubjectItem.getPostId();
                String str5 = "";
                if (postId == null) {
                    postId = "";
                }
                Pair a11 = TuplesKt.a("post_id", postId);
                Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
                Pair a13 = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
                Pair a14 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
                User user = postSubjectItem.getUser();
                if (user == null || (str = user.getUserId()) == null) {
                    str = "";
                }
                Pair a15 = TuplesKt.a("user_id", str);
                Group group = postSubjectItem.getGroup();
                if (group == null || (str2 = group.getGroupId()) == null) {
                    str2 = "";
                }
                Pair a16 = TuplesKt.a("group_id", str2);
                Subject subject = postSubjectItem.getSubject();
                if (subject == null || (str3 = subject.getSubjectId()) == null) {
                    str3 = "";
                }
                Pair a17 = TuplesKt.a("subject_id", str3);
                Subject subject2 = postSubjectItem.getSubject();
                if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
                    str4 = "";
                }
                Pair a18 = TuplesKt.a("subject_type", str4);
                Pair a19 = TuplesKt.a("builtin", postSubjectItem.getBuiltIn() ? "1" : "0");
                Media media = postSubjectItem.getMedia();
                if (media == null || (value = media.getMediaType()) == null) {
                    value = MediaType.TEXT.getValue();
                }
                Pair a20 = TuplesKt.a("post_media_type", value);
                Pair a21 = TuplesKt.a("tabId", String.valueOf(this.f44372e));
                if (operateItem == null || (ops = operateItem.getOps()) == null) {
                    String ops2 = postSubjectItem.getOps();
                    if (ops2 != null) {
                        str5 = ops2;
                    }
                } else {
                    str5 = ops;
                }
                Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, TuplesKt.a("ops", str5));
                if (operateItem != null) {
                    il.b.a(operateItem, m11);
                }
                hj.i.f64628a.p("UgcTrending", m11);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            public PostItemVH r(ViewGroup parent, int i11) {
                Intrinsics.h(parent, "parent");
                k0 c11 = k0.c(LayoutInflater.from(k()), parent, false);
                Intrinsics.g(c11, "inflate(...)");
                ShapeableImageView ivCover = c11.f63883b;
                Intrinsics.g(ivCover, "ivCover");
                ViewGroup.LayoutParams layoutParams = ivCover.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = this.f44375h;
                ivCover.setLayoutParams(layoutParams);
                return new PostItemVH(c11);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int l() {
                return 1;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int m() {
                return R$layout.item_ugc_vertical_content;
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x014b  */
            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void b(com.chad.library.adapter.base.viewholder.BaseViewHolder r6, final com.transsion.moviedetailapi.bean.PostSubjectItem r7) {
                /*
                    Method dump skipped, instructions count: 351
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.operateUGC.provider.RoomUGCProvider.PostAdapter.PostItemProvider.b(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.transsion.moviedetailapi.bean.PostSubjectItem):void");
            }
        }

        public PostAdapter(int i11, OperateItem operateItem) {
            super(null, 1, null);
            this.tabId = i11;
            F1(new PostItemProvider(i11, operateItem));
        }

        @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
        protected int N1(List<? extends PostSubjectItem> data, int position) {
            Intrinsics.h(data, "data");
            return data.get(position).isMore() ? 2 : 1;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f44377a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f44377a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f44377a;
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
            this.f44377a.invoke(obj);
        }
    }

    public RoomUGCProvider(int i11, BaseHomeSubFragment fragment, TrendingUGCViewModel trendingUGCViewModel) {
        Intrinsics.h(fragment, "fragment");
        this.f44369e = i11;
        this.f44370f = fragment;
        this.f44371g = trendingUGCViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(RoomUGCProvider roomUGCProvider, OperateItem operateItem) {
        roomUGCProvider.I(operateItem);
        aq.h.i(aq.h.f16175a, null, null, "UgcTrending", false, 11, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function0 function0, View view) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(OperateItem operateItem, BaseViewHolder baseViewHolder, PostAdapter postAdapter, RoomUGCProvider roomUGCProvider, RoomEntranceResponse roomEntranceResponse) {
        operateItem.setTitle(roomEntranceResponse.getTitle());
        baseViewHolder.setText(R$id.tvProviderVerticalTitle, roomEntranceResponse.getTitle());
        List<PostSubjectItem> posts = roomEntranceResponse.getPosts();
        if (posts == null || posts.isEmpty()) {
            View itemView = baseViewHolder.itemView;
            Intrinsics.g(itemView, "itemView");
            jg.c.g(itemView);
        } else {
            View itemView2 = baseViewHolder.itemView;
            Intrinsics.g(itemView2, "itemView");
            jg.c.k(itemView2);
            ArrayList arrayList = new ArrayList();
            List<PostSubjectItem> posts2 = roomEntranceResponse.getPosts();
            Intrinsics.e(posts2);
            arrayList.addAll(posts2);
            postAdapter.n1(arrayList);
            int i11 = 0;
            for (Object obj : arrayList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                roomUGCProvider.J(i11, operateItem, (PostSubjectItem) obj);
                i11 = i12;
            }
        }
        return Unit.f67184a;
    }

    private final void H(OperateItem operateItem) {
        List<Object> data;
        Pair a11 = TuplesKt.a("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        BaseProviderMultiAdapter g11 = g();
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        Pair a13 = TuplesKt.a("tabId", String.valueOf(this.f44369e));
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        Map m11 = MapsKt.m(a11, a12, a13, TuplesKt.a(CampaignEx.JSON_KEY_TITLE, title));
        il.b.a(operateItem, m11);
        hj.i.f64628a.D("UgcTrending", m11);
    }

    private final void I(OperateItem operateItem) {
        List<Object> data;
        Pair a11 = TuplesKt.a("module_name", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION);
        BaseProviderMultiAdapter g11 = g();
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf((g11 == null || (data = g11.getData()) == null) ? null : Integer.valueOf(data.indexOf(operateItem))));
        Pair a13 = TuplesKt.a("tabId", String.valueOf(this.f44369e));
        String title = operateItem.getTitle();
        if (title == null) {
            title = "";
        }
        Map m11 = MapsKt.m(a11, a12, a13, TuplesKt.a(CampaignEx.JSON_KEY_TITLE, title));
        il.b.a(operateItem, m11);
        hj.i.f64628a.p("UgcTrending", m11);
    }

    private final void J(int i11, OperateItem operateItem, PostSubjectItem postSubjectItem) {
        String str;
        String str2;
        String str3;
        String str4;
        String value;
        String ops;
        Integer subjectType;
        String postId = postSubjectItem.getPostId();
        String str5 = "";
        if (postId == null) {
            postId = "";
        }
        Pair a11 = TuplesKt.a("post_id", postId);
        Pair a12 = TuplesKt.a(RequestParameters.POSITION, String.valueOf(i11));
        Pair a13 = TuplesKt.a("module_name", WebConstants.FIELD_ITEM);
        Pair a14 = TuplesKt.a("is_cache_post", String.valueOf(postSubjectItem.isRoomCache()));
        User user = postSubjectItem.getUser();
        if (user == null || (str = user.getUserId()) == null) {
            str = "";
        }
        Pair a15 = TuplesKt.a("user_id", str);
        Group group = postSubjectItem.getGroup();
        if (group == null || (str2 = group.getGroupId()) == null) {
            str2 = "";
        }
        Pair a16 = TuplesKt.a("group_id", str2);
        Subject subject = postSubjectItem.getSubject();
        if (subject == null || (str3 = subject.getSubjectId()) == null) {
            str3 = "";
        }
        Pair a17 = TuplesKt.a("subject_id", str3);
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 == null || (subjectType = subject2.getSubjectType()) == null || (str4 = subjectType.toString()) == null) {
            str4 = "";
        }
        Pair a18 = TuplesKt.a("subject_type", str4);
        Pair a19 = TuplesKt.a("builtin", postSubjectItem.getBuiltIn() ? "1" : "0");
        Media media = postSubjectItem.getMedia();
        if (media == null || (value = media.getMediaType()) == null) {
            value = MediaType.TEXT.getValue();
        }
        Pair a20 = TuplesKt.a("post_media_type", value);
        Pair a21 = TuplesKt.a("tabId", String.valueOf(this.f44369e));
        if (operateItem == null || (ops = operateItem.getOps()) == null) {
            String ops2 = postSubjectItem.getOps();
            if (ops2 != null) {
                str5 = ops2;
            }
        } else {
            str5 = ops;
        }
        Map m11 = MapsKt.m(a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, TuplesKt.a("ops", str5));
        if (operateItem != null) {
            il.b.a(operateItem, m11);
        }
        hj.i.f64628a.D("UgcTrending", m11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder helper, final OperateItem item) {
        androidx.view.b0 B;
        androidx.view.b0 B2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        final Function0 function0 = new Function0() { // from class: com.transsion.home.adapter.operateUGC.provider.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D;
                D = RoomUGCProvider.D(RoomUGCProvider.this, item);
                return D;
            }
        };
        ((TextView) helper.getView(R$id.tvProviderVerticalTitle)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomUGCProvider.E(Function0.this, view);
            }
        });
        ((TextView) helper.getView(R$id.tvProviderVerticalMore)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.operateUGC.provider.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomUGCProvider.F(Function0.this, view);
            }
        });
        H(item);
        String title = item.getTitle();
        if (title != null && title.length() != 0) {
            ((TextView) helper.getView(R$id.tvProviderVerticalTitle)).setText(item.getTitle());
        }
        final PostAdapter postAdapter = new PostAdapter(this.f44369e, item);
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.rvProviderVerticalPost);
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.a(dk.a.b(8), 0, 0, 0));
        }
        recyclerView.setAdapter(postAdapter);
        TrendingUGCViewModel trendingUGCViewModel = this.f44371g;
        if (trendingUGCViewModel != null && (B2 = trendingUGCViewModel.B()) != null) {
            B2.p(this.f44370f);
        }
        TrendingUGCViewModel trendingUGCViewModel2 = this.f44371g;
        if (trendingUGCViewModel2 == null || (B = trendingUGCViewModel2.B()) == null) {
            return;
        }
        B.j(this.f44370f, new b(new Function1() { // from class: com.transsion.home.adapter.operateUGC.provider.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = RoomUGCProvider.G(OperateItem.this, helper, postAdapter, this, (RoomEntranceResponse) obj);
                return G;
            }
        }));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.ROOM.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.provider_ugc_vertical_content;
    }
}
