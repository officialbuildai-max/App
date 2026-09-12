package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.MemberGuideBannerView;
import com.transsion.home.R$dimen;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.OperateItem;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberRemindData;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.RewardsCenterData;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h extends BaseItemProvider {

    /* renamed from: g, reason: collision with root package name */
    public static final a f44815g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final int f44816h = 8;

    /* renamed from: e, reason: collision with root package name */
    private final String f44817e;

    /* renamed from: f, reason: collision with root package name */
    private final String f44818f;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.f44817e = sceneId;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        this.f44818f = uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(h hVar, OperateItem operateItem, MemberGuideBannerView memberGuideBannerView) {
        String str = hVar.f44817e;
        Subject feedsSubject = operateItem.getFeedsSubject();
        String subjectId = feedsSubject != null ? feedsSubject.getSubjectId() : null;
        String str2 = hVar.f44818f;
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Boolean valueOf = iPremiumApi != null ? Boolean.valueOf(iPremiumApi.c()) : null;
        IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        Integer o11 = iPremiumApi2 != null ? iPremiumApi2.o() : null;
        IPremiumApi iPremiumApi3 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        memberGuideBannerView.setMemberInfo("stream_detail", str, str2, subjectId, true, valueOf, o11, iPremiumApi3 != null ? Boolean.valueOf(iPremiumApi3.u()) : null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(h hVar, View view) {
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null ? iMemberApi.f() : false) {
            Navigator.x(TheRouter.c("/member/MemberActivity").K("scene_id", hVar.f44817e).K("trace_id", hVar.f44818f), null, null, 3, null);
        } else {
            Navigator.x(TheRouter.c("/rewards/center"), null, null, 3, null);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final OperateItem item) {
        String str;
        boolean z10;
        MemberGuideBannerView memberInfo;
        Lottery lottery;
        Lottery lottery2;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        final MemberGuideBannerView memberGuideBannerView = (MemberGuideBannerView) helper.getView(R$id.member_guide_banner);
        memberGuideBannerView.setRefreshMemberInfo(new Function0() { // from class: com.transsion.home.adapter.trending.provider.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit B;
                B = h.B(h.this, item, memberGuideBannerView);
                return B;
            }
        });
        MemberRemindData remindData = item.getRemindData();
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        RewardsCenterData a11 = iRewardsCenterApi != null ? iRewardsCenterApi.a() : null;
        if (a11 == null || (lottery2 = a11.getLottery()) == null || (str = lottery2.getActivityId()) == null) {
            str = "0";
        }
        boolean z11 = Integer.parseInt(str) > 0;
        String bgImage = (a11 == null || (lottery = a11.getLottery()) == null) ? null : lottery.getBgImage();
        Context context = helper.itemView.getContext();
        ViewGroup.LayoutParams layoutParams = memberGuideBannerView.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar != null) {
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = 0;
            if (z11) {
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = context.getResources().getDimensionPixelSize(R$dimen.dp_20) * (-1);
            }
            memberGuideBannerView.setLayoutParams(bVar);
        }
        if (remindData == null) {
            String str2 = this.f44817e;
            Subject feedsSubject = item.getFeedsSubject();
            String subjectId = feedsSubject != null ? feedsSubject.getSubjectId() : null;
            String str3 = this.f44818f;
            IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            Boolean valueOf = iPremiumApi != null ? Boolean.valueOf(iPremiumApi.c()) : null;
            IPremiumApi iPremiumApi2 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            Integer o11 = iPremiumApi2 != null ? iPremiumApi2.o() : null;
            IPremiumApi iPremiumApi3 = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            memberInfo = memberGuideBannerView.setMemberInfo("stream_detail", str2, str3, subjectId, (r19 & 16) != 0 ? false : false, valueOf, o11, iPremiumApi3 != null ? Boolean.valueOf(iPremiumApi3.u()) : null);
            z10 = z11;
            MemberGuideBannerView.setZeroTreasureVisible$default(memberInfo, z10, false, 2, null).setBtnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.C(h.this, view);
                }
            });
        } else {
            z10 = z11;
        }
        if (z10) {
            if (bgImage == null) {
                bgImage = "";
            }
            memberGuideBannerView.setZeroTreasureIcon(bgImage);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.MEMBER_BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_member_banner;
    }
}
