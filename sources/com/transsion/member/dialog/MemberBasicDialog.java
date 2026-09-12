package com.transsion.member.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$layout;
import com.transsion.member.promotion.PromotionManager;
import com.transsion.member.view.MemberBasicView;
import com.transsion.memberapi.AllMemberRightsData;
import com.transsion.memberapi.FeatureRights;
import com.transsion.memberapi.MemberFeatureData;
import com.transsion.memberapi.MemberPriceData;
import com.transsion.memberapi.MemberPriceItem;
import com.transsion.memberapi.RightsMapData;
import com.transsion.memberapi.SkuPromotionDto;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J)\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010,R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010,R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010 \u001a\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/transsion/member/dialog/MemberBasicDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "initView", "D0", "Lcom/transsion/memberapi/MemberPriceData;", "data", "", "Lcom/transsion/memberapi/SkuPromotionItem;", "promotionItems", "x0", "(Lcom/transsion/memberapi/MemberPriceData;Ljava/util/List;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lzm/f;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "F0", "(Lzm/f;)V", "", "sceneId", "G0", "(Ljava/lang/String;)V", "Lcom/transsion/member/MemberViewModel;", "c", "Lkotlin/Lazy;", "y0", "()Lcom/transsion/member/MemberViewModel;", "memberViewModel", "Lwm/f;", "d", "Lwm/f;", "bind", "e", "Lzm/f;", "onPurchaseListener", "f", "Ljava/lang/String;", "pageName", be.g.f16474b, "traceId", "h", "subjectId", "i", "Lcom/transsion/member/promotion/PromotionManager;", com.mbridge.msdk.foundation.same.report.j.f35620b, "z0", "()Lcom/transsion/member/promotion/PromotionManager;", "promotionManager", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/memberapi/MemberPriceData;", "pendingGoodsData", "Lcom/transsion/memberapi/SkuPromotionDto;", "l", "Lcom/transsion/memberapi/SkuPromotionDto;", "pendingSkuPromotionDto", "", "m", "Z", "promotionReady", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class MemberBasicDialog extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy memberViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private wm.f bind;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private zm.f onPurchaseListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String traceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String subjectId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String sceneId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy promotionManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private MemberPriceData pendingGoodsData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private SkuPromotionDto pendingSkuPromotionDto;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile boolean promotionReady;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f46507a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f46507a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f46507a;
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
            this.f46507a.invoke(obj);
        }
    }

    public MemberBasicDialog() {
        super(R$layout.dialog_member_basic_layout);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.dialog.MemberBasicDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.memberViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MemberViewModel.class), new Function0<x0>() { // from class: com.transsion.member.dialog.MemberBasicDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.dialog.MemberBasicDialog$special$$inlined$viewModels$default$3
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
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.pageName = "";
        this.traceId = "";
        this.subjectId = "";
        this.sceneId = "";
        this.promotionManager = LazyKt.b(new Function0() { // from class: com.transsion.member.dialog.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PromotionManager E0;
                E0 = MemberBasicDialog.E0();
                return E0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(MemberBasicDialog memberBasicDialog, MemberPriceData memberPriceData) {
        if (memberBasicDialog.promotionReady) {
            SkuPromotionDto skuPromotionDto = memberBasicDialog.pendingSkuPromotionDto;
            memberBasicDialog.x0(memberPriceData, skuPromotionDto != null ? skuPromotionDto.getItems() : null);
        } else {
            memberBasicDialog.pendingGoodsData = memberPriceData;
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(wm.f fVar, AllMemberRightsData allMemberRightsData) {
        RightsMapData rightsMap;
        FeatureRights basic;
        List<MemberFeatureData> rights;
        if (allMemberRightsData != null && (rightsMap = allMemberRightsData.getRightsMap()) != null && (basic = rightsMap.getBasic()) != null && (rights = basic.getRights()) != null) {
            fVar.f77867d.setFeatureData(rights);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(MemberBasicDialog memberBasicDialog, View it) {
        Intrinsics.h(it, "it");
        memberBasicDialog.dismissAllowingStateLoss();
        return Unit.f67184a;
    }

    private final void D0() {
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new MemberBasicDialog$loadPromotionConcurrently$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PromotionManager E0() {
        return new PromotionManager();
    }

    private final void initView() {
        final wm.f fVar = this.bind;
        if (fVar != null) {
            fVar.f77867d.setModuleName("basic_semi");
            fVar.f77867d.setSceneId(this.sceneId);
            MemberBasicView.init$default(fVar.f77867d, null, null, null, null, 15, null);
            zm.f fVar2 = this.onPurchaseListener;
            if (fVar2 != null) {
                MemberBasicView memberBasicView = fVar.f77867d;
                Intrinsics.e(fVar2);
                memberBasicView.setOnPurchaseListener(fVar2);
            }
            if (getActivity() != null) {
                MemberBasicView memberBasicView2 = fVar.f77867d;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.g(requireActivity, "requireActivity(...)");
                memberBasicView2.setActivity(requireActivity);
            }
            y0().x();
            y0().u();
            y0().E().j(this, new a(new Function1() { // from class: com.transsion.member.dialog.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A0;
                    A0 = MemberBasicDialog.A0(MemberBasicDialog.this, (MemberPriceData) obj);
                    return A0;
                }
            }));
            y0().A().j(this, new a(new Function1() { // from class: com.transsion.member.dialog.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B0;
                    B0 = MemberBasicDialog.B0(wm.f.this, (AllMemberRightsData) obj);
                    return B0;
                }
            }));
            ImageView ivMemberClose = fVar.f77865b;
            Intrinsics.g(ivMemberClose, "ivMemberClose");
            jg.c.c(ivMemberClose, 0L, new Function1() { // from class: com.transsion.member.dialog.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit C0;
                    C0 = MemberBasicDialog.C0(MemberBasicDialog.this, (View) obj);
                    return C0;
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(MemberPriceData data, List promotionItems) {
        MemberBasicView memberBasicView;
        List<MemberPriceItem> arrayList;
        wm.f fVar = this.bind;
        if (fVar == null || (memberBasicView = fVar.f77867d) == null) {
            return;
        }
        if (data == null || (arrayList = data.getBasicMember()) == null) {
            arrayList = new ArrayList<>();
        }
        memberBasicView.setMemberGoodsData(arrayList, promotionItems);
    }

    private final MemberViewModel y0() {
        return (MemberViewModel) this.memberViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PromotionManager z0() {
        return (PromotionManager) this.promotionManager.getValue();
    }

    public final void F0(zm.f listener) {
        this.onPurchaseListener = listener;
    }

    public final void G0(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.sceneId = sceneId;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        int i11;
        int i12;
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            boolean z10 = requireActivity().getRequestedOrientation() == 6;
            if (z10) {
                oh.h hVar = oh.h.f71144a;
                Context context = window.getContext();
                Intrinsics.g(context, "getContext(...)");
                i11 = hVar.e(context) / 2;
            } else {
                i11 = -1;
            }
            if (z10) {
                oh.h hVar2 = oh.h.f71144a;
                Context context2 = window.getContext();
                Intrinsics.g(context2, "getContext(...)");
                i12 = hVar2.c(context2);
            } else {
                i12 = -2;
            }
            window.setLayout(i11, i12);
            window.setGravity(z10 ? GravityCompat.END : 80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        this.bind = wm.f.a(view);
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(true);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCanceledOnTouchOutside(false);
        }
        y0().O();
        D0();
        initView();
    }
}
