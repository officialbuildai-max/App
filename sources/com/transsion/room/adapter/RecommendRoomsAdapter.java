package com.transsion.room.adapter;

import ak.k;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import bq.x;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.tn.lib.view.RoomJoinStatus;
import com.tn.lib.widget.R$drawable;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.room.R$layout;
import com.transsion.room.R$string;
import com.transsion.room.api.RoomsViewType;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010#\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0014¢\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/transsion/room/adapter/RecommendRoomsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;", "<init>", "()V", "holder", "", "hasJoin", "", "E1", "(Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;Z)V", WebConstants.FIELD_ITEM, "", "newCount", "F1", "(Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;J)V", "isMatchParent", "H1", "(Z)V", "Lcom/transsion/room/api/RoomsViewType;", NativeComponentConstants.KEY_COMPONENT_TYPE, "G1", "(Lcom/transsion/room/api/RoomsViewType;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "D1", "(Landroid/view/ViewGroup;I)Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;", "B1", "(Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;)V", "", "", "payloads", "C1", "(Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;Lcom/transsion/moviedetailapi/bean/RoomItem;Ljava/util/List;)V", "F", "I", "coverSize", "G", "Lcom/transsion/room/api/RoomsViewType;", "roomsViewType", "H", "Z", "RecommendRoomsItemVH", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RecommendRoomsAdapter extends BaseQuickAdapter {

    /* renamed from: F, reason: from kotlin metadata */
    private final int coverSize;

    /* renamed from: G, reason: from kotlin metadata */
    private RoomsViewType roomsViewType;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isMatchParent;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/transsion/room/adapter/RecommendRoomsAdapter$RecommendRoomsItemVH;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lbq/x;", "viewBinding", "<init>", "(Lbq/x;)V", "a", "Lbq/x;", "f", "()Lbq/x;", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes6.dex */
    public static final class RecommendRoomsItemVH extends BaseViewHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final x viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public RecommendRoomsItemVH(bq.x r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.room.adapter.RecommendRoomsAdapter.RecommendRoomsItemVH.<init>(bq.x):void");
        }

        /* renamed from: f, reason: from getter */
        public final x getViewBinding() {
            return this.viewBinding;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51431a;

        static {
            int[] iArr = new int[RoomsViewType.values().length];
            try {
                iArr[RoomsViewType.TYPE_ROOM_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomsViewType.TYPE_TRENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoomsViewType.TYPE_SUBJECT_DETAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f51431a = iArr;
        }
    }

    public RecommendRoomsAdapter() {
        super(R$layout.item_recommend_rooms, null, 2, null);
        this.coverSize = a0.a(30.0f);
        this.roomsViewType = RoomsViewType.TYPE_ROOM_HOME;
    }

    private final void E1(RecommendRoomsItemVH holder, boolean hasJoin) {
        holder.getViewBinding().f16976h.setStatus(hasJoin ? RoomJoinStatus.JOINED : RoomJoinStatus.JOIN);
    }

    private final void F1(RecommendRoomsItemVH holder, RoomItem item, long newCount) {
        String str;
        if (this.roomsViewType != RoomsViewType.TYPE_ROOM_HOME) {
            Long newPostCount = item.getNewPostCount();
            if ((newPostCount != null ? newPostCount.longValue() : 0L) > 0) {
                holder.getViewBinding().f16973e.setText(Utils.a().getString(R$string.x_new, newCount > 99 ? "99+" : String.valueOf(newCount)));
                holder.getViewBinding().f16973e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
        }
        if (item.getUserCount() != null) {
            Long userCount = item.getUserCount();
            Intrinsics.e(userCount);
            str = k.d(userCount.longValue());
        } else {
            str = "0";
        }
        holder.getViewBinding().f16973e.setText(str);
        holder.getViewBinding().f16973e.setCompoundDrawablesWithIntrinsicBounds(R$drawable.ic_room_member, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void F(RecommendRoomsItemVH holder, RoomItem item) {
        List<String> tags;
        String str;
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        ViewGroup.LayoutParams layoutParams = holder.getViewBinding().getRoot().getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = this.isMatchParent ? -1 : dk.a.b(104);
        holder.getViewBinding().getRoot().setLayoutParams(marginLayoutParams);
        String avatar = item.getAvatar();
        if (avatar != null) {
            f.a aVar = f.f62005a;
            f.b a11 = aVar.m(getContext()).g(avatar).m(this.coverSize).c(this.coverSize).a(30);
            ShapeableImageView ivCoverBg = holder.getViewBinding().f16972d;
            Intrinsics.g(ivCoverBg, "ivCoverBg");
            a11.d(ivCoverBg);
            f.b c11 = aVar.m(getContext()).g(avatar).m(this.coverSize).c(this.coverSize);
            ShapeableImageView ivCover = holder.getViewBinding().f16971c;
            Intrinsics.g(ivCover, "ivCover");
            c11.d(ivCover);
        }
        holder.getViewBinding().f16975g.setText(item.getName());
        Long newPostCount = item.getNewPostCount();
        F1(holder, item, newPostCount != null ? newPostCount.longValue() : 0L);
        List<String> tags2 = item.getTags();
        if (tags2 != null && !tags2.isEmpty() && (tags = item.getTags()) != null && (str = (String) CollectionsKt.k0(tags)) != null) {
            holder.getViewBinding().f16974f.setText(str);
        }
        Boolean hasJoin = item.getHasJoin();
        E1(holder, hasJoin != null ? hasJoin.booleanValue() : false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void G(RecommendRoomsItemVH holder, RoomItem item, List<? extends Object> payloads) {
        Intrinsics.h(holder, "holder");
        Intrinsics.h(item, "item");
        Intrinsics.h(payloads, "payloads");
        super.G(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            E1(holder, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            F1(holder, item, ((Number) obj).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public RecommendRoomsItemVH y0(ViewGroup parent, int viewType) {
        Intrinsics.h(parent, "parent");
        x c11 = x.c(LayoutInflater.from(getContext()), parent, false);
        Intrinsics.g(c11, "inflate(...)");
        int i11 = a.f51431a[this.roomsViewType.ordinal()];
        if (i11 == 1) {
            c11.f16975g.setTextSize(13.0f);
            c11.f16974f.setTextSize(13.0f);
            c11.f16973e.setTextSize(13.0f);
        } else {
            if (i11 != 2 && i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            c11.f16975g.setTextSize(12.0f);
            c11.f16974f.setTextSize(11.0f);
            c11.f16973e.setTextSize(11.0f);
            ViewGroup.LayoutParams layoutParams = c11.f16970b.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.width = -1;
            }
            c11.f16970b.setLayoutParams(marginLayoutParams);
        }
        BLView vStroke = c11.f16977i;
        Intrinsics.g(vStroke, "vStroke");
        vStroke.setVisibility(this.roomsViewType == RoomsViewType.TYPE_ROOM_HOME ? 0 : 8);
        return new RecommendRoomsItemVH(c11);
    }

    public final void G1(RoomsViewType type) {
        Intrinsics.h(type, "type");
        this.roomsViewType = type;
    }

    public final void H1(boolean isMatchParent) {
        this.isMatchParent = isMatchParent;
    }
}
