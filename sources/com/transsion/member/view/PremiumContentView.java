package com.transsion.member.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.transsion.member.z0;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberAgreement;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberFeatureData;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberPriceItem;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.memberapi.SkuPromotionItem;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0016J1\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J9\u0010)\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010#¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b/\u0010\u0016J\u0015\u00100\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b0\u0010\u0016J\u0015\u00101\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b1\u0010\u0016J\u0017\u00104\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J!\u00108\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u00010\u00192\b\u00107\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\n¢\u0006\u0004\b:\u0010\fJ\u001d\u0010=\u001a\u00020\n2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010#¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\n¢\u0006\u0004\b?\u0010\fJ\u001d\u0010@\u001a\u00020\n2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010#¢\u0006\u0004\b@\u0010>J\u001d\u0010A\u001a\u00020\n2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010#¢\u0006\u0004\bA\u0010>R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010N\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010K\u001a\u0004\bU\u0010V\"\u0004\bW\u0010\u0016¨\u0006X"}, d2 = {"Lcom/transsion/member/view/PremiumContentView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "i", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnPromoCodeClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnFeedbackClickListener", "setOnBasicRenewClickListener", "", "isVisible", "setFeedbackContainerVisible", "(Z)V", "setFeedbackVisible", "setPromoCodeVisible", "", "sceneId", "pageName", "traceId", "subjectId", "setTrackerInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lzm/f;", "setOnPurchaseListener", "(Lzm/f;)V", "", "Lcom/transsion/memberapi/MemberPriceItem;", "proMembers", "basicMembers", "Lcom/transsion/memberapi/SkuPromotionItem;", "promotionItems", "setMemberGoodsData", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "Landroid/app/Activity;", "activity", "initMemberCard", "(Landroid/app/Activity;)V", "setProVisible", "setBasicVisible", "setBasicStatusVisible", "Lcom/transsion/memberapi/MemberDetail;", "memberDetail", "setMemberDetail", "(Lcom/transsion/memberapi/MemberDetail;)V", CampaignEx.JSON_KEY_TITLE, "content", "setAgreement", "(Ljava/lang/String;Ljava/lang/String;)V", "hideAgreement", "Lcom/transsion/memberapi/MemberFeatureData;", "data", "refreshFeaturesList", "(Ljava/util/List;)V", "checkVisible", "setBasicFeatureData", "setProFeatureData", "Lwm/v;", "a", "Lwm/v;", "binding", "Lcom/transsion/member/adapter/c;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/member/adapter/c;", "memberFeatureAdapter", "c", "Z", "hasExpRv", "d", "Ljava/lang/String;", "e", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "f", "isActivity", "()Z", "setActivity", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class PremiumContentView extends LinearLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final wm.v binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.transsion.member.adapter.c memberFeatureAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasExpRv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String sceneId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isActivity;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PremiumContentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PremiumContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PremiumContentView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        wm.v c11 = wm.v.c(LayoutInflater.from(context), this, true);
        Intrinsics.g(c11, "inflate(...)");
        this.binding = c11;
        setOrientation(1);
        this.pageName = "";
        this.sceneId = "";
    }

    public /* synthetic */ PremiumContentView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PremiumContentView premiumContentView) {
        premiumContentView.checkVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0, View it) {
        Intrinsics.h(it, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function0 function0, View it) {
        Intrinsics.h(it, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function0 function0, View it) {
        Intrinsics.h(it, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i() {
        /*
            r4 = this;
            wm.v r0 = r4.binding
            android.view.View r0 = r0.f78039m
            java.lang.String r1 = "viewFeedbackDivider"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            wm.v r1 = r4.binding
            android.widget.TextView r1 = r1.f78037k
            java.lang.String r2 = "tvFeedback"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            int r1 = r1.getVisibility()
            r2 = 0
            if (r1 != 0) goto L2a
            wm.v r1 = r4.binding
            android.widget.TextView r1 = r1.f78038l
            java.lang.String r3 = "tvPromoCode"
            kotlin.jvm.internal.Intrinsics.g(r1, r3)
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L2a
            r1 = 1
            goto L2b
        L2a:
            r1 = r2
        L2b:
            if (r1 == 0) goto L2e
            goto L30
        L2e:
            r2 = 8
        L30:
            r0.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.view.PremiumContentView.i():void");
    }

    public static /* synthetic */ void setTrackerInfo$default(PremiumContentView premiumContentView, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str4 = null;
        }
        premiumContentView.setTrackerInfo(str, str2, str3, str4);
    }

    public final void checkVisible() {
        List<Object> data;
        if (this.hasExpRv) {
            return;
        }
        com.transsion.member.adapter.c cVar = this.memberFeatureAdapter;
        this.hasExpRv = z0.f46962a.a((LinearLayoutManager) this.binding.f78028b.getLayoutManager(), (cVar == null || (data = cVar.getData()) == null) ? 0 : data.size(), this.pageName);
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final void hideAgreement() {
        TextView tvAgreementTitle = this.binding.f78035i;
        Intrinsics.g(tvAgreementTitle, "tvAgreementTitle");
        tvAgreementTitle.setVisibility(8);
        TextView tvAgreementContent = this.binding.f78034h;
        Intrinsics.g(tvAgreementContent, "tvAgreementContent");
        tvAgreementContent.setVisibility(8);
    }

    public final void initMemberCard(Activity activity) {
        Intrinsics.h(activity, "activity");
        this.binding.f78031e.setActivity(activity);
        this.binding.f78030d.setActivity(activity);
        MemberProView.init$default(this.binding.f78031e, null, null, null, null, 15, null);
        MemberBasicView.init$default(this.binding.f78030d, null, null, null, null, 15, null);
    }

    /* renamed from: isActivity, reason: from getter */
    public final boolean getIsActivity() {
        return this.isActivity;
    }

    public final void refreshFeaturesList(List<MemberFeatureData> data) {
        List a11 = com.transsion.member.g.f46612a.a(data);
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean f11 = iMemberApi != null ? iMemberApi.f() : false;
        LinearLayout llFeatureRights = this.binding.f78033g;
        Intrinsics.g(llFeatureRights, "llFeatureRights");
        llFeatureRights.setVisibility(!a11.isEmpty() && f11 ? 0 : 8);
        if (a11.isEmpty() || !f11) {
            return;
        }
        if (this.binding.f78028b.getLayoutManager() == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setSmoothScrollbarEnabled(false);
            this.binding.f78028b.setLayoutManager(linearLayoutManager);
        }
        com.transsion.member.adapter.c cVar = this.memberFeatureAdapter;
        if (cVar == null) {
            com.transsion.member.adapter.c cVar2 = new com.transsion.member.adapter.c(CollectionsKt.U0(a11));
            this.memberFeatureAdapter = cVar2;
            this.binding.f78028b.setAdapter(cVar2);
            this.binding.f78028b.setNestedScrollingEnabled(false);
        } else {
            cVar.n1(a11);
        }
        this.binding.f78028b.postDelayed(new Runnable() { // from class: com.transsion.member.view.h0
            @Override // java.lang.Runnable
            public final void run() {
                PremiumContentView.e(PremiumContentView.this);
            }
        }, 500L);
    }

    public final void setActivity(boolean z10) {
        this.isActivity = z10;
    }

    public final void setAgreement(String title, String content) {
        if (this.isActivity) {
            TextView tvAgreementTitle = this.binding.f78035i;
            Intrinsics.g(tvAgreementTitle, "tvAgreementTitle");
            tvAgreementTitle.setVisibility(0);
            TextView tvAgreementContent = this.binding.f78034h;
            Intrinsics.g(tvAgreementContent, "tvAgreementContent");
            tvAgreementContent.setVisibility(0);
            this.binding.f78035i.setText(title);
            this.binding.f78034h.setText(content);
        }
    }

    public final void setBasicFeatureData(List<MemberFeatureData> data) {
        MemberBasicView memberBasicView = this.binding.f78030d;
        if (data == null) {
            data = CollectionsKt.l();
        }
        memberBasicView.setFeatureData(data);
    }

    public final void setBasicStatusVisible(boolean isVisible) {
        LinearLayout layoutUserBasicStatus = this.binding.f78032f;
        Intrinsics.g(layoutUserBasicStatus, "layoutUserBasicStatus");
        layoutUserBasicStatus.setVisibility(isVisible ? 0 : 8);
    }

    public final void setBasicVisible(boolean isVisible) {
        MemberBasicView layoutPremiumBasic = this.binding.f78030d;
        Intrinsics.g(layoutPremiumBasic, "layoutPremiumBasic");
        layoutPremiumBasic.setVisibility(isVisible ? 0 : 8);
    }

    public final void setFeedbackContainerVisible(boolean isVisible) {
        LinearLayout layoutFeedback = this.binding.f78029c;
        Intrinsics.g(layoutFeedback, "layoutFeedback");
        layoutFeedback.setVisibility(isVisible ? 0 : 8);
    }

    public final void setFeedbackVisible(boolean isVisible) {
        TextView tvFeedback = this.binding.f78037k;
        Intrinsics.g(tvFeedback, "tvFeedback");
        tvFeedback.setVisibility(isVisible ? 0 : 8);
        i();
    }

    public final void setMemberDetail(MemberDetail memberDetail) {
        MemberInfo memberInfo;
        List<MemberAgreement> memberAgreements;
        setBasicStatusVisible(false);
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        boolean f11 = iMemberApi != null ? iMemberApi.f() : false;
        setProVisible(f11);
        MembershipDetailType a11 = memberDetail != null ? MembershipDetailType.INSTANCE.a(memberDetail.getMemberInfo()) : MembershipDetailType.GUEST;
        MemberAgreement memberAgreement = null;
        if (a11 == MembershipDetailType.TRIAL || a11 == MembershipDetailType.FINANCIAL_MEMBER || a11 == MembershipDetailType.SUBSCRIPTION_MEMBER) {
            Integer valueOf = (memberDetail == null || (memberInfo = memberDetail.getMemberInfo()) == null) ? null : Integer.valueOf(memberInfo.getVipLevel());
            if (valueOf != null && valueOf.intValue() == 1) {
                if (f11) {
                    setBasicVisible(false);
                    setBasicStatusVisible(true);
                } else {
                    setProVisible(false);
                    setBasicVisible(true);
                    setBasicStatusVisible(false);
                }
            } else if (valueOf != null && valueOf.intValue() == 2) {
                if (f11) {
                    setBasicVisible(false);
                } else {
                    setBasicVisible(true);
                }
                setBasicStatusVisible(false);
            } else {
                setBasicVisible(true);
            }
        } else {
            setBasicVisible(true);
        }
        if (memberDetail != null && (memberAgreements = memberDetail.getMemberAgreements()) != null) {
            memberAgreement = (MemberAgreement) CollectionsKt.k0(memberAgreements);
        }
        if (memberAgreement != null) {
            setAgreement(memberAgreement.getTitle(), memberAgreement.getContent());
        } else {
            hideAgreement();
        }
    }

    public final void setMemberGoodsData(List<MemberPriceItem> proMembers, List<MemberPriceItem> basicMembers, List<SkuPromotionItem> promotionItems) {
        Intrinsics.h(proMembers, "proMembers");
        Intrinsics.h(basicMembers, "basicMembers");
        a.C0856a.f(lg.a.f68962a, "liyang", "setMemberGoodsData: proMembers ->" + proMembers + ", basicMembers -> " + basicMembers, false, 4, null);
        this.binding.f78031e.setMemberGoodsData(proMembers, promotionItems);
        this.binding.f78030d.setMemberGoodsData(basicMembers, promotionItems);
    }

    public final void setOnBasicRenewClickListener(final Function0<Unit> listener) {
        TextView tvBasicRenew = this.binding.f78036j;
        Intrinsics.g(tvBasicRenew, "tvBasicRenew");
        jg.c.c(tvBasicRenew, 0L, new Function1() { // from class: com.transsion.member.view.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f11;
                f11 = PremiumContentView.f(Function0.this, (View) obj);
                return f11;
            }
        }, 1, null);
    }

    public final void setOnFeedbackClickListener(final Function0<Unit> listener) {
        TextView tvFeedback = this.binding.f78037k;
        Intrinsics.g(tvFeedback, "tvFeedback");
        jg.c.c(tvFeedback, 0L, new Function1() { // from class: com.transsion.member.view.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g11;
                g11 = PremiumContentView.g(Function0.this, (View) obj);
                return g11;
            }
        }, 1, null);
    }

    public final void setOnPromoCodeClickListener(final Function0<Unit> listener) {
        TextView tvPromoCode = this.binding.f78038l;
        Intrinsics.g(tvPromoCode, "tvPromoCode");
        jg.c.c(tvPromoCode, 0L, new Function1() { // from class: com.transsion.member.view.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h11;
                h11 = PremiumContentView.h(Function0.this, (View) obj);
                return h11;
            }
        }, 1, null);
    }

    public final void setOnPurchaseListener(zm.f listener) {
        Intrinsics.h(listener, "listener");
        this.binding.f78031e.setOnPurchaseListener(listener);
        this.binding.f78030d.setOnPurchaseListener(listener);
    }

    public final void setProFeatureData(List<MemberFeatureData> data) {
        MemberProView memberProView = this.binding.f78031e;
        if (data == null) {
            data = CollectionsKt.l();
        }
        memberProView.setFeatureData(data);
    }

    public final void setProVisible(boolean isVisible) {
        MemberProView layoutPremiumPro = this.binding.f78031e;
        Intrinsics.g(layoutPremiumPro, "layoutPremiumPro");
        layoutPremiumPro.setVisibility(isVisible ? 0 : 8);
    }

    public final void setPromoCodeVisible(boolean isVisible) {
        TextView tvPromoCode = this.binding.f78038l;
        Intrinsics.g(tvPromoCode, "tvPromoCode");
        tvPromoCode.setVisibility(isVisible ? 0 : 8);
        i();
    }

    public final void setSceneId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.sceneId = str;
    }

    public final void setTrackerInfo(String sceneId, String pageName, String traceId, String subjectId) {
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(traceId, "traceId");
        this.binding.f78031e.setModuleName("pro");
        this.binding.f78030d.setModuleName("basic");
        this.pageName = pageName;
        this.binding.f78031e.setPageName(pageName);
        this.binding.f78030d.setPageName(pageName);
        this.sceneId = sceneId;
        this.binding.f78031e.setSceneId(sceneId);
        this.binding.f78030d.setSceneId(sceneId);
        this.binding.f78031e.setTraceId(traceId);
        this.binding.f78030d.setTraceId(traceId);
        this.binding.f78031e.setSubjectId(subjectId == null ? "" : subjectId);
        MemberBasicView memberBasicView = this.binding.f78030d;
        if (subjectId == null) {
            subjectId = "";
        }
        memberBasicView.setSubjectId(subjectId);
        TextView tvAgreementTitle = this.binding.f78035i;
        Intrinsics.g(tvAgreementTitle, "tvAgreementTitle");
        tvAgreementTitle.setVisibility(this.isActivity ? 0 : 8);
        TextView tvAgreementContent = this.binding.f78034h;
        Intrinsics.g(tvAgreementContent, "tvAgreementContent");
        tvAgreementContent.setVisibility(this.isActivity ? 0 : 8);
        LinearLayout layoutFeedback = this.binding.f78029c;
        Intrinsics.g(layoutFeedback, "layoutFeedback");
        layoutFeedback.setVisibility(this.isActivity ? 0 : 8);
    }
}
