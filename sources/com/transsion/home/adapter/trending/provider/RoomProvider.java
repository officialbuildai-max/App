package com.transsion.home.adapter.trending.provider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.v0;
import androidx.view.x0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.exposure.ExposureType;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.trending.provider.RoomProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.viewmodel.TrendingViewModel;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.web.api.WebConstants;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dz.a;
import ej.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import lg.a;

/* loaded from: classes5.dex */
public final class RoomProvider extends BaseItemProvider {

    /* renamed from: p, reason: collision with root package name */
    public static final a f44727p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f44728q = 8;

    /* renamed from: r, reason: collision with root package name */
    private static final String f44729r = "TrendingRoom";

    /* renamed from: s, reason: collision with root package name */
    private static final String f44730s = "Trending";

    /* renamed from: t, reason: collision with root package name */
    private static final String f44731t = "room_home_recommend";

    /* renamed from: u, reason: collision with root package name */
    private static final ConfigBean f44732u = sm.f.f75530c.a().c("room_entrance_enable", true);

    /* renamed from: e, reason: collision with root package name */
    private final BaseHomeSubFragment f44733e;

    /* renamed from: f, reason: collision with root package name */
    private final TrendingViewModel f44734f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f44735g;

    /* renamed from: h, reason: collision with root package name */
    private sj.b f44736h;

    /* renamed from: i, reason: collision with root package name */
    private sj.b f44737i;

    /* renamed from: j, reason: collision with root package name */
    private final String f44738j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f44739k;

    /* renamed from: l, reason: collision with root package name */
    private final e f44740l;

    /* renamed from: m, reason: collision with root package name */
    private final d f44741m;

    /* renamed from: n, reason: collision with root package name */
    private final Lazy f44742n;

    /* renamed from: o, reason: collision with root package name */
    private final Lazy f44743o;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$PostAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "", "pageFrom", "Laq/i;", "trendingRoomsViewModel", "<init>", "(Ljava/lang/String;Laq/i;)V", "", "data", "", RequestParameters.POSITION, "N1", "(Ljava/util/List;I)I", "PostItemProvider", "a", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class PostAdapter extends BaseProviderMultiAdapter<PostSubjectItem> {
        public static final int G = 8;

        /* loaded from: classes5.dex */
        public static final class PostItemProvider extends BaseItemProvider {

            /* renamed from: e, reason: collision with root package name */
            private final String f44744e;

            /* renamed from: f, reason: collision with root package name */
            private final aq.i f44745f;

            /* renamed from: g, reason: collision with root package name */
            private final int f44746g;

            /* renamed from: h, reason: collision with root package name */
            private final int f44747h;

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$PostAdapter$PostItemProvider$PostItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lgl/i0;", "viewBinding", "<init>", "(Lgl/i0;)V", "a", "Lgl/i0;", "f", "()Lgl/i0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
            /* loaded from: classes5.dex */
            public static final class PostItemVH extends BaseViewHolder {

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                private final gl.i0 viewBinding;

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public PostItemVH(gl.i0 r3) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.trending.provider.RoomProvider.PostAdapter.PostItemProvider.PostItemVH.<init>(gl.i0):void");
                }

                /* renamed from: f, reason: from getter */
                public final gl.i0 getViewBinding() {
                    return this.viewBinding;
                }
            }

            public PostItemProvider(String str, aq.i trendingRoomsViewModel) {
                Intrinsics.h(trendingRoomsViewModel, "trendingRoomsViewModel");
                this.f44744e = str;
                this.f44745f = trendingRoomsViewModel;
                this.f44746g = com.blankj.utilcode.util.a0.a(((com.blankj.utilcode.util.a0.b(RangesKt.i(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c())) - 60) * 1.0f) / 3);
                this.f44747h = dk.a.b(112);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void B(PostItemProvider postItemProvider, PostSubjectItem postSubjectItem, PostItemVH postItemVH, View view) {
                postItemProvider.E(postSubjectItem, postItemVH.getAdapterPosition());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void C(PostSubjectItem postSubjectItem, View view) {
                Group group = postSubjectItem.getGroup();
                Navigator.x(TheRouter.c("/room/detail").K("id", group != null ? group.getGroupId() : null).z("need_start_room_home", false), view.getContext(), null, 2, null);
                com.transsion.room.helper.l.f51685a.c(RoomProvider.f44730s, RoomProvider.f44731t, postSubjectItem);
            }

            private final void E(PostSubjectItem postSubjectItem, int i11) {
                com.transsion.postdetail.helper.a.f48920a.y(this.f44744e, RoomProvider.f44730s, "", i11, WebConstants.FIELD_ITEM, postSubjectItem, (r17 & 64) != 0 ? null : null);
                aq.h.k(aq.h.f16175a, postSubjectItem, postSubjectItem.getOps(), RoomProvider.f44730s, false, 8, null);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public void b(BaseViewHolder helper, final PostSubjectItem item) {
                Pair pair;
                String url;
                FirstFrame firstFrame;
                String str;
                Cover cover;
                Cover cover2;
                String avatar;
                CharSequence charSequence;
                List<Image> image;
                Image image2;
                List<Image> image3;
                Image image4;
                Intrinsics.h(helper, "helper");
                Intrinsics.h(item, "item");
                final PostItemVH postItemVH = (PostItemVH) helper;
                postItemVH.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomProvider.PostAdapter.PostItemProvider.B(RoomProvider.PostAdapter.PostItemProvider.this, item, postItemVH, view);
                    }
                });
                AppCompatImageView ivVideoPlay = postItemVH.getViewBinding().f63855e;
                Intrinsics.g(ivVideoPlay, "ivVideoPlay");
                Media media = item.getMedia();
                String mediaType = media != null ? media.getMediaType() : null;
                MediaType mediaType2 = MediaType.VIDEO;
                ivVideoPlay.setVisibility(Intrinsics.c(mediaType, mediaType2.getValue()) ? 0 : 8);
                Media media2 = item.getMedia();
                String mediaType3 = media2 != null ? media2.getMediaType() : null;
                String str2 = "";
                if (Intrinsics.c(mediaType3, MediaType.IMAGE.getValue())) {
                    Media media3 = item.getMedia();
                    String url2 = (media3 == null || (image3 = media3.getImage()) == null || (image4 = (Image) CollectionsKt.k0(image3)) == null) ? null : image4.getUrl();
                    Media media4 = item.getMedia();
                    pair = new Pair(url2, (media4 == null || (image = media4.getImage()) == null || (image2 = (Image) CollectionsKt.k0(image)) == null) ? null : image2.getThumbnail());
                } else if (Intrinsics.c(mediaType3, mediaType2.getValue())) {
                    Media media5 = item.getMedia();
                    if (media5 == null || (cover2 = media5.getCover()) == null || (url = cover2.getUrl()) == null) {
                        Media media6 = item.getMedia();
                        url = (media6 == null || (firstFrame = media6.getFirstFrame()) == null) ? null : firstFrame.getUrl();
                    }
                    Media media7 = item.getMedia();
                    if (media7 == null || (cover = media7.getCover()) == null || (str = cover.getThumbnail()) == null) {
                        str = "";
                    }
                    pair = new Pair(url, str);
                } else {
                    pair = null;
                }
                if (pair == null || (charSequence = (CharSequence) pair.getFirst()) == null || charSequence.length() == 0) {
                    ShapeableImageView ivCover = postItemVH.getViewBinding().f63853c;
                    Intrinsics.g(ivCover, "ivCover");
                    jg.c.g(ivCover);
                } else {
                    ShapeableImageView ivCover2 = postItemVH.getViewBinding().f63853c;
                    Intrinsics.g(ivCover2, "ivCover");
                    jg.c.k(ivCover2);
                    f.b m11 = ej.f.f62005a.m(k());
                    Object first = pair.getFirst();
                    Intrinsics.e(first);
                    f.b g11 = m11.g((String) first);
                    String str3 = (String) pair.getSecond();
                    if (str3 == null) {
                        str3 = "";
                    }
                    f.b l11 = g11.l(str3);
                    ShapeableImageView ivCover3 = postItemVH.getViewBinding().f63853c;
                    Intrinsics.g(ivCover3, "ivCover");
                    l11.d(ivCover3);
                }
                a aVar = RoomProvider.f44727p;
                if (!aVar.a()) {
                    TnTextView tnTextView = postItemVH.getViewBinding().f63856f;
                    Group group = item.getGroup();
                    tnTextView.setText(group != null ? group.getName() : null);
                    f.b m12 = ej.f.f62005a.m(k());
                    Group group2 = item.getGroup();
                    if (group2 != null && (avatar = group2.getAvatar()) != null) {
                        str2 = avatar;
                    }
                    f.b c11 = m12.g(str2).m(dk.a.b(24)).c(dk.a.b(24));
                    ShapeableImageView ivRoomCover = postItemVH.getViewBinding().f63854d;
                    Intrinsics.g(ivRoomCover, "ivRoomCover");
                    c11.d(ivRoomCover);
                    postItemVH.getViewBinding().f63857g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.y
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RoomProvider.PostAdapter.PostItemProvider.C(PostSubjectItem.this, view);
                        }
                    });
                }
                postItemVH.getViewBinding().f63852b.setVisibility(aVar.a() ? 8 : 0);
                postItemVH.getViewBinding().getRoot().getLayoutParams().height = dk.a.b(aVar.a() ? 182 : 168);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* renamed from: D, reason: merged with bridge method [inline-methods] */
            public PostItemVH r(ViewGroup parent, int i11) {
                Intrinsics.h(parent, "parent");
                gl.i0 c11 = gl.i0.c(LayoutInflater.from(k()), parent, false);
                Intrinsics.g(c11, "inflate(...)");
                c11.getRoot().getLayoutParams().width = this.f44746g;
                return new PostItemVH(c11);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int l() {
                return 1;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int m() {
                return R$layout.item_adapter_room_entrance_post;
            }
        }

        /* loaded from: classes5.dex */
        public static final class a extends BaseItemProvider {

            /* renamed from: e, reason: collision with root package name */
            private final String f44749e;

            /* renamed from: f, reason: collision with root package name */
            private final int f44750f;

            /* JADX WARN: Multi-variable type inference failed */
            public a() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public a(String str) {
                this.f44749e = str;
                this.f44750f = com.blankj.utilcode.util.a0.a(((com.blankj.utilcode.util.a0.b(RangesKt.i(com.blankj.utilcode.util.y.e(), com.blankj.utilcode.util.y.c())) - 60) * 1.0f) / 3);
            }

            public /* synthetic */ a(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i11 & 1) != 0 ? null : str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void A(a aVar, BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem, View view) {
                com.transsion.postdetail.helper.a.f48920a.y(aVar.f44749e, RoomProvider.f44730s, "", baseViewHolder.getBindingAdapterPosition(), WebConstants.FIELD_ITEM, postSubjectItem, (r17 & 64) != 0 ? null : null);
                hj.i.f64628a.p(RoomProvider.f44730s, MapsKt.m(TuplesKt.a(WebConstants.PAGE_FROM, aVar.f44749e), TuplesKt.a("module_name", "item_post_more")));
                aq.h.i(aq.h.f16175a, null, null, RoomProvider.f44730s, false, 11, null);
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int l() {
                return 2;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public int m() {
                return R$layout.item_adapter_room_entrance_post_more;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            public BaseViewHolder r(ViewGroup parent, int i11) {
                Intrinsics.h(parent, "parent");
                BaseViewHolder r11 = super.r(parent, i11);
                r11.itemView.getLayoutParams().width = this.f44750f;
                return r11;
            }

            @Override // com.chad.library.adapter.base.provider.BaseItemProvider
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public void b(final BaseViewHolder helper, final PostSubjectItem item) {
                Intrinsics.h(helper, "helper");
                Intrinsics.h(item, "item");
                helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomProvider.PostAdapter.a.A(RoomProvider.PostAdapter.a.this, helper, item, view);
                    }
                });
                helper.getView(R$id.root_view).getLayoutParams().height = dk.a.b(RoomProvider.f44727p.a() ? 182 : 168);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAdapter(String str, aq.i trendingRoomsViewModel) {
            super(null, 1, null);
            Intrinsics.h(trendingRoomsViewModel, "trendingRoomsViewModel");
            F1(new PostItemProvider(str, trendingRoomsViewModel));
            F1(new a(str));
        }

        public /* synthetic */ PostAdapter(String str, aq.i iVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, iVar);
        }

        @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
        protected int N1(List<? extends PostSubjectItem> data, int position) {
            Intrinsics.h(data, "data");
            return data.get(position).isMore() ? 2 : 1;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, WebConstants.FIELD_ITEM, "", "F1", "(Landroid/view/View;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "E1", "(Landroid/view/ViewGroup;I)Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;", "holder", "C1", "(Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "F", "I", "coverSize", "RoomItemVH", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final class RoomAdapter extends BaseQuickAdapter {
        public static final int G = 8;

        /* renamed from: F, reason: from kotlin metadata */
        private final int coverSize;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/home/adapter/trending/provider/RoomProvider$RoomAdapter$RoomItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lgl/h0;", "viewBinding", "<init>", "(Lgl/h0;)V", "a", "Lgl/h0;", "f", "()Lgl/h0;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
        /* loaded from: classes5.dex */
        public static final class RoomItemVH extends BaseViewHolder {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final gl.h0 viewBinding;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public RoomItemVH(gl.h0 r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "viewBinding"
                    kotlin.jvm.internal.Intrinsics.h(r3, r0)
                    androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
                    java.lang.String r1 = "getRoot(...)"
                    kotlin.jvm.internal.Intrinsics.g(r0, r1)
                    r2.<init>(r0)
                    r2.viewBinding = r3
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.trending.provider.RoomProvider.RoomAdapter.RoomItemVH.<init>(gl.h0):void");
            }

            /* renamed from: f, reason: from getter */
            public final gl.h0 getViewBinding() {
                return this.viewBinding;
            }
        }

        public RoomAdapter() {
            super(R$layout.item_adapter_room_entrance_group, null, 2, null);
            this.coverSize = dk.a.b(52);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D1(RoomAdapter roomAdapter, RoomItem roomItem, View view) {
            Intrinsics.e(view);
            roomAdapter.F1(view, roomItem);
        }

        private final void F1(View view, RoomItem item) {
            item.setNewPostCount(0L);
            com.transsion.room.helper.l.f51685a.g(RoomProvider.f44730s, RoomProvider.f44731t, item);
            Navigator.x(TheRouter.c("/room/detail").K("id", item.getGroupId()).z("need_start_room_home", false), view.getContext(), null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: C1, reason: merged with bridge method [inline-methods] */
        public void F(RoomItemVH holder, final RoomItem item) {
            String str;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(item, "item");
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomProvider.RoomAdapter.D1(RoomProvider.RoomAdapter.this, item, view);
                }
            });
            holder.getViewBinding().f63839e.setText(item.getName());
            if (item.getUserCount() != null) {
                Long userCount = item.getUserCount();
                Intrinsics.e(userCount);
                str = ak.k.d(userCount.longValue());
            } else {
                str = "0";
            }
            holder.getViewBinding().f63838d.setText(str);
            String avatar = item.getAvatar();
            if (avatar != null) {
                f.b c11 = ej.f.f62005a.m(getContext()).g(avatar).m(this.coverSize).c(this.coverSize);
                ShapeableImageView ivCover = holder.getViewBinding().f63837c;
                Intrinsics.g(ivCover, "ivCover");
                c11.d(ivCover);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: E1, reason: merged with bridge method [inline-methods] */
        public RoomItemVH y0(ViewGroup parent, int viewType) {
            Intrinsics.h(parent, "parent");
            gl.h0 c11 = gl.h0.c(LayoutInflater.from(getContext()), parent, false);
            Intrinsics.g(c11, "inflate(...)");
            return new RoomItemVH(c11);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            ConfigBean b11 = b();
            return Intrinsics.c(b11 != null ? b11.getValue() : null, "true");
        }

        public final ConfigBean b() {
            return RoomProvider.f44732u;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements sj.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RoomAdapter f44752a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RoomProvider f44753b;

        b(RoomAdapter roomAdapter, RoomProvider roomProvider) {
            this.f44752a = roomAdapter;
            this.f44753b = roomProvider;
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            RoomAdapter roomAdapter = this.f44752a;
            RoomProvider roomProvider = this.f44753b;
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.r(lg.a.f68962a, RoomProvider.f44729r, new String[]{"1----------room report, position:" + i11 + ", duration:" + j11}, false, 4, null);
                RoomItem roomItem = (RoomItem) roomAdapter.f0(i11);
                if (roomItem != null) {
                    com.transsion.room.helper.l.f51685a.i(roomProvider.f44738j, RoomProvider.f44730s, i11, j11, roomItem);
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements sj.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PostAdapter f44754a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RoomProvider f44755b;

        c(PostAdapter postAdapter, RoomProvider roomProvider) {
            this.f44754a = postAdapter;
            this.f44755b = roomProvider;
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            PostAdapter postAdapter = this.f44754a;
            RoomProvider roomProvider = this.f44755b;
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.f(lg.a.f68962a, RoomProvider.f44729r, "2-------post report, position:" + i11 + ", duration:" + j11, false, 4, null);
                PostSubjectItem postSubjectItem = (PostSubjectItem) postAdapter.f0(i11);
                if (postSubjectItem != null && !CollectionsKt.b0(roomProvider.N(), postSubjectItem.getPostId())) {
                    String postId = postSubjectItem.getPostId();
                    if (postId != null) {
                        roomProvider.N().add(postId);
                    }
                    com.transsion.postdetail.helper.a.f48920a.w(roomProvider.f44738j, RoomProvider.f44730s, "", i11, j11, postSubjectItem, (r19 & 64) != 0 ? null : null);
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements dz.a {
        d() {
        }

        @Override // dz.a
        public void onLogin(UserInfo user) {
            Intrinsics.h(user, "user");
            TrendingViewModel trendingViewModel = RoomProvider.this.f44734f;
            if (trendingViewModel != null) {
                trendingViewModel.T(false);
            }
        }

        @Override // dz.a
        public void onLogout() {
            TrendingViewModel trendingViewModel = RoomProvider.this.f44734f;
            if (trendingViewModel != null) {
                trendingViewModel.T(false);
            }
        }

        @Override // dz.a
        public void onUpdateUserInfo(UserInfo userInfo) {
            a.C0761a.c(this, userInfo);
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends RecyclerView.r {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends RecyclerView.s {
        f() {
            m(0, 10);
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends RecyclerView.s {
        g() {
            m(0, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f44757a;

        h(Function1 function) {
            Intrinsics.h(function, "function");
            this.f44757a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f44757a;
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
            this.f44757a.invoke(obj);
        }
    }

    public RoomProvider(final BaseHomeSubFragment fragment, TrendingViewModel trendingViewModel) {
        Intrinsics.h(fragment, "fragment");
        this.f44733e = fragment;
        this.f44734f = trendingViewModel;
        this.f44735g = FragmentViewModelLazyKt.a(fragment, Reflection.b(aq.i.class), new Function0<x0>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.home.adapter.trending.provider.RoomProvider$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f44738j = hj.i.f64628a.i();
        this.f44739k = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                HashSet S;
                S = RoomProvider.S();
                return S;
            }
        });
        this.f44740l = new e();
        this.f44741m = new d();
        this.f44742n = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoomProvider.g U;
                U = RoomProvider.U();
                return U;
            }
        });
        this.f44743o = LazyKt.b(new Function0() { // from class: com.transsion.home.adapter.trending.provider.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoomProvider.f T;
                T = RoomProvider.T();
                return T;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(BaseViewHolder baseViewHolder, RecyclerView recyclerView, RoomAdapter roomAdapter, RecyclerView recyclerView2, PostAdapter postAdapter, RoomEntranceResponse roomEntranceResponse) {
        baseViewHolder.setText(R$id.main_operation_room_title, roomEntranceResponse.getTitle());
        List<RoomItem> groups = roomEntranceResponse.getGroups();
        if (groups == null || groups.isEmpty() || !f44727p.a()) {
            recyclerView.setVisibility(8);
        } else {
            recyclerView.setVisibility(0);
            roomAdapter.n1(roomEntranceResponse.getGroups());
        }
        List<PostSubjectItem> posts = roomEntranceResponse.getPosts();
        if (posts == null || posts.isEmpty()) {
            recyclerView2.setVisibility(8);
        } else {
            recyclerView2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            List<PostSubjectItem> posts2 = roomEntranceResponse.getPosts();
            Intrinsics.e(posts2);
            arrayList.addAll(posts2);
            PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, false, null, false, false, false, false, null, -1, 1, null);
            postSubjectItem.setMore(true);
            arrayList.add(postSubjectItem);
            postAdapter.n1(arrayList);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(View view) {
        com.transsion.room.helper.l lVar = com.transsion.room.helper.l.f51685a;
        String str = f44730s;
        lVar.f(str, f44731t);
        aq.h.i(aq.h.f16175a, null, null, str, false, 11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet N() {
        return (HashSet) this.f44739k.getValue();
    }

    private final f O() {
        return (f) this.f44743o.getValue();
    }

    private final g P() {
        return (g) this.f44742n.getValue();
    }

    private final aq.i Q() {
        return (aq.i) this.f44735g.getValue();
    }

    private final void R(RecyclerView recyclerView, RecyclerView recyclerView2, RoomAdapter roomAdapter, PostAdapter postAdapter) {
        recyclerView.clearOnScrollListeners();
        recyclerView2.clearOnScrollListeners();
        sj.b bVar = new sj.b(0.6f, new b(roomAdapter, this), false, 4, null);
        bVar.n(1);
        ExposureType exposureType = ExposureType.NEST_HORIZONTAL;
        bVar.o(exposureType);
        recyclerView.addOnScrollListener(bVar);
        this.f44736h = bVar;
        sj.b bVar2 = new sj.b(0.6f, new c(postAdapter, this), false, 4, null);
        bVar2.n(1);
        bVar2.o(exposureType);
        recyclerView2.addOnScrollListener(bVar2);
        this.f44737i = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet S() {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f T() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g U() {
        return new g();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void b(final BaseViewHolder helper, OperateItem item) {
        androidx.view.b0 W;
        androidx.view.b0 W2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        final RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_room_group_recycler);
        final RecyclerView recyclerView2 = (RecyclerView) helper.getView(R$id.main_operation_room_post_recycler);
        ((TextView) helper.getView(R$id.main_operation_room_more_text)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomProvider.M(view);
            }
        });
        String title = item.getTitle();
        if (title != null && title.length() != 0) {
            ((TextView) helper.getView(R$id.main_operation_room_title)).setText(item.getTitle());
        }
        if (!Intrinsics.c(recyclerView.getRecycledViewPool(), P())) {
            recyclerView.setRecycledViewPool(P());
        }
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        RecyclerView.m linearLayoutManager = new LinearLayoutManager(this.f44733e.getContext(), 0, false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        final RoomAdapter roomAdapter = new RoomAdapter();
        recyclerView.setAdapter(roomAdapter);
        if (!Intrinsics.c(recyclerView2.getRecycledViewPool(), O())) {
            recyclerView2.setRecycledViewPool(O());
        }
        if (recyclerView2.getItemDecorationCount() == 0) {
            recyclerView2.addItemDecoration(new ig.f(8.0f, 0.0f, 12.0f, 2, null));
        }
        RecyclerView.m linearLayoutManager2 = new LinearLayoutManager(this.f44733e.getContext(), 0, false);
        linearLayoutManager2.setItemPrefetchEnabled(true);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        final PostAdapter postAdapter = new PostAdapter(this.f44738j, Q());
        recyclerView2.setAdapter(postAdapter);
        R(recyclerView, recyclerView2, roomAdapter, postAdapter);
        TrendingViewModel trendingViewModel = this.f44734f;
        if (trendingViewModel != null && (W2 = trendingViewModel.W()) != null) {
            W2.p(this.f44733e);
        }
        TrendingViewModel trendingViewModel2 = this.f44734f;
        if (trendingViewModel2 == null || (W = trendingViewModel2.W()) == null) {
            return;
        }
        W.j(this.f44733e, new h(new Function1() { // from class: com.transsion.home.adapter.trending.provider.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L;
                L = RoomProvider.L(BaseViewHolder.this, recyclerView, roomAdapter, recyclerView2, postAdapter, (RoomEntranceResponse) obj);
                return L;
            }
        }));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.ROOM.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.post_list_item_room;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder r(ViewGroup parent, int i11) {
        Intrinsics.h(parent, "parent");
        return super.r(parent, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void t(BaseViewHolder holder) {
        Unit unit;
        RecyclerView recyclerView;
        Intrinsics.h(holder, "holder");
        super.t(holder);
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseProviderMultiAdapter g11 = g();
            if (g11 == null || (recyclerView = g11.getRecyclerView()) == null) {
                unit = null;
            } else {
                recyclerView.addOnScrollListener(this.f44740l);
                unit = Unit.f67184a;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        Unit unit;
        RecyclerView recyclerView;
        Intrinsics.h(holder, "holder");
        super.u(holder);
        a.C0856a.v(lg.a.f68962a, f44729r, "room onViewDetachedFromWindow", false, 4, null);
        sj.b bVar = this.f44736h;
        if (bVar != null) {
            bVar.f();
        }
        sj.b bVar2 = this.f44737i;
        if (bVar2 != null) {
            bVar2.f();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseProviderMultiAdapter g11 = g();
            if (g11 == null || (recyclerView = g11.getRecyclerView()) == null) {
                unit = null;
            } else {
                recyclerView.removeOnScrollListener(this.f44740l);
                unit = Unit.f67184a;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }
}
