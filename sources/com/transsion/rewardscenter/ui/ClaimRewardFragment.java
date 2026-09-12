package com.transsion.rewardscenter.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baseui.R$color;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.rewardscenter.R$drawable;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.model.ClaimRewardViewModel;
import com.transsion.rewardscenterapi.ClaimReceiverRequest;
import com.transsion.rewardscenterapi.PhoneInfo;
import com.transsnet.loginapi.bean.Country;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ%\u0010\u0015\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010\u0004J)\u00100\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010\u0004R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010?R\u0014\u0010I\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010!R\u0014\u0010K\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010!¨\u0006N"}, d2 = {"Lcom/transsion/rewardscenter/ui/ClaimRewardFragment;", "Lcom/transsion/rewardscenter/ui/FitStatusBarFragment;", "Lvp/c;", "<init>", "()V", "", "M0", "Lcom/transsnet/loginapi/bean/Country;", PlaceTypes.COUNTRY, "c1", "(Lcom/transsnet/loginapi/bean/Country;)V", "d1", "", "f1", "()Z", "g1", "e1", "Landroid/view/View;", "containerView", "Landroid/widget/EditText;", "hintView", "Z0", "(Landroid/view/View;Landroid/widget/EditText;)V", "E0", "b1", "showLoading", "G0", "Landroid/view/LayoutInflater;", "inflater", "K0", "(Landroid/view/LayoutInflater;)Lvp/c;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "n0", "()Landroid/view/View;", "o0", "initViewData", "initListener", "initViewModel", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "retryLoadData", "Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "I0", "()Lcom/transsion/baseui/dialog/BaseMemberLoadingDialog;", "loadingDialog", "Lcom/transsion/rewardscenter/model/ClaimRewardViewModel;", "c", "L0", "()Lcom/transsion/rewardscenter/model/ClaimRewardViewModel;", "viewModel", "d", "Ljava/lang/String;", "prizeId", "e", "Lcom/transsnet/loginapi/bean/Country;", "mainCountry", "f", "altCountry", be.g.f16474b, "mainPhoneCCArg", "J0", "mainPhoneCC", "H0", "altPhoneCC", "h", "a", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ClaimRewardFragment extends FitStatusBarFragment<vp.c> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f51261i = 8;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadingDialog = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.ui.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BaseMemberLoadingDialog Y0;
            Y0 = ClaimRewardFragment.Y0();
            return Y0;
        }
    });

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String prizeId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Country mainCountry;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Country altCountry;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String mainPhoneCCArg;

    /* renamed from: com.transsion.rewardscenter.ui.ClaimRewardFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClaimRewardFragment a(String prizeId) {
            Intrinsics.h(prizeId, "prizeId");
            ClaimRewardFragment claimRewardFragment = new ClaimRewardFragment();
            Bundle bundle = new Bundle();
            bundle.putString("prize_id", prizeId);
            claimRewardFragment.setArguments(bundle);
            return claimRewardFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4 f51268a;

        public b(Function4 function4) {
            this.f51268a = function4;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f51268a.invoke(charSequence, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4 f51269a;

        public c(Function4 function4) {
            this.f51269a = function4;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f51269a.invoke(charSequence, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4 f51270a;

        public d(Function4 function4) {
            this.f51270a = function4;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f51270a.invoke(charSequence, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        }
    }

    /* loaded from: classes6.dex */
    static final class e implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f51271a;

        e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f51271a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f51271a;
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
            this.f51271a.invoke(obj);
        }
    }

    public ClaimRewardFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.rewardscenter.ui.ClaimRewardFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.a(this, Reflection.b(ClaimRewardViewModel.class), new Function0<x0>() { // from class: com.transsion.rewardscenter.ui.ClaimRewardFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.rewardscenter.ui.ClaimRewardFragment$special$$inlined$viewModels$default$3
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
        this.prizeId = "";
        this.mainCountry = new Country();
        this.altCountry = new Country();
        this.mainPhoneCCArg = "";
    }

    private final void E0(View containerView, EditText hintView) {
        if (containerView != null) {
            containerView.setBackgroundResource(R$drawable.phone_input_bg);
        }
        if (hintView != null) {
            hintView.setHintTextColor(androidx.core.content.b.getColor(requireContext(), R$color.base_white_30_p));
        }
    }

    static /* synthetic */ void F0(ClaimRewardFragment claimRewardFragment, View view, EditText editText, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            editText = view instanceof EditText ? (EditText) view : null;
        }
        claimRewardFragment.E0(view, editText);
    }

    private final void G0() {
        try {
            Result.Companion companion = Result.INSTANCE;
            I0().dismissAllowingStateLoss();
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final String H0() {
        String code;
        Country country = this.altCountry;
        return (country == null || (code = country.getCode()) == null) ? J0() : code;
    }

    private final BaseMemberLoadingDialog I0() {
        return (BaseMemberLoadingDialog) this.loadingDialog.getValue();
    }

    private final String J0() {
        String code;
        Country country = this.mainCountry;
        return (country == null || (code = country.getCode()) == null) ? this.mainPhoneCCArg : code;
    }

    private final ClaimRewardViewModel L0() {
        return (ClaimRewardViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0() {
        vp.c cVar;
        EditText editText;
        Triple a11 = com.transsion.rewardscenter.utils.c.f51352a.a();
        Country country = this.mainCountry;
        country.setCode((String) a11.getFirst());
        country.setCountry_s((String) a11.getSecond());
        c1(this.mainCountry);
        if (StringsKt.q0((CharSequence) a11.getThird()) || (cVar = (vp.c) getMViewBinding()) == null || (editText = cVar.f77476g) == null) {
            return;
        }
        editText.setText((CharSequence) a11.getThird());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(ClaimRewardFragment claimRewardFragment, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        FragmentActivity activity = claimRewardFragment.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(ClaimRewardFragment claimRewardFragment, View view) {
        Navigator.y(TheRouter.c("/loginapi/select_country"), claimRewardFragment, 1001, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(ClaimRewardFragment claimRewardFragment, View view) {
        Navigator.y(TheRouter.c("/loginapi/select_country"), claimRewardFragment, 1002, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(ClaimRewardFragment claimRewardFragment, CharSequence charSequence, int i11, int i12, int i13) {
        claimRewardFragment.d1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void R0(ClaimRewardFragment claimRewardFragment, View view, boolean z10) {
        if (!z10) {
            claimRewardFragment.f1();
        } else {
            vp.c cVar = (vp.c) claimRewardFragment.getMViewBinding();
            F0(claimRewardFragment, cVar != null ? cVar.f77475f : null, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void S0(ClaimRewardFragment claimRewardFragment, View view, boolean z10) {
        if (!z10) {
            claimRewardFragment.g1();
            return;
        }
        vp.c cVar = (vp.c) claimRewardFragment.getMViewBinding();
        LinearLayout linearLayout = cVar != null ? cVar.f77481l : null;
        vp.c cVar2 = (vp.c) claimRewardFragment.getMViewBinding();
        claimRewardFragment.E0(linearLayout, cVar2 != null ? cVar2.f77476g : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void T0(ClaimRewardFragment claimRewardFragment, View view, boolean z10) {
        if (!z10) {
            claimRewardFragment.e1();
        } else {
            vp.c cVar = (vp.c) claimRewardFragment.getMViewBinding();
            F0(claimRewardFragment, cVar != null ? cVar.f77472c : null, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(ClaimRewardFragment claimRewardFragment, View it) {
        Intrinsics.h(it, "it");
        KeyboardUtils.d(claimRewardFragment.requireActivity());
        claimRewardFragment.b1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(ClaimRewardFragment claimRewardFragment, Boolean bool) {
        if (bool.booleanValue()) {
            claimRewardFragment.showLoading();
        } else {
            claimRewardFragment.G0();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(ClaimRewardFragment claimRewardFragment, Pair pair) {
        String string;
        if (Intrinsics.c((String) pair.getFirst(), "400")) {
            string = (String) pair.getSecond();
            if (string == null) {
                string = claimRewardFragment.getString(R$string.claim_failed);
                Intrinsics.g(string, "getString(...)");
            }
        } else {
            string = claimRewardFragment.getString(R$string.claim_failed);
            Intrinsics.g(string, "getString(...)");
        }
        com.transsion.rewardscenter.utils.p.a(false, string);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(ClaimRewardFragment claimRewardFragment, Boolean bool) {
        if (Intrinsics.c(bool, Boolean.TRUE)) {
            FragmentActivity activity = claimRewardFragment.getActivity();
            ClaimRewardActivity claimRewardActivity = activity instanceof ClaimRewardActivity ? (ClaimRewardActivity) activity : null;
            if (claimRewardActivity != null) {
                claimRewardActivity.G0();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseMemberLoadingDialog Y0() {
        return new BaseMemberLoadingDialog();
    }

    private final void Z0(View containerView, EditText hintView) {
        if (containerView != null) {
            containerView.setBackgroundResource(R$drawable.phone_input_error_bg);
        }
        if (hintView != null) {
            hintView.setHintTextColor(androidx.core.content.b.getColor(requireContext(), com.transsion.rewardscenter.R$color.input_error_hint));
        }
    }

    static /* synthetic */ void a1(ClaimRewardFragment claimRewardFragment, View view, EditText editText, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            editText = view instanceof EditText ? (EditText) view : null;
        }
        claimRewardFragment.Z0(view, editText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b1() {
        EditText editText;
        Editable text;
        EditText editText2;
        Editable text2;
        EditText editText3;
        Editable text3;
        EditText editText4;
        Editable text4;
        EditText editText5;
        Editable text5;
        EditText editText6;
        Editable text6;
        boolean f12 = f1();
        boolean g12 = g1();
        boolean e12 = e1();
        if (f12 && g12 && e12) {
            vp.c cVar = (vp.c) getMViewBinding();
            String obj = (cVar == null || (editText6 = cVar.f77475f) == null || (text6 = editText6.getText()) == null) ? null : text6.toString();
            String str = obj == null ? "" : obj;
            vp.c cVar2 = (vp.c) getMViewBinding();
            String obj2 = (cVar2 == null || (editText5 = cVar2.f77476g) == null || (text5 = editText5.getText()) == null) ? null : text5.toString();
            if (obj2 == null) {
                obj2 = "";
            }
            vp.c cVar3 = (vp.c) getMViewBinding();
            String obj3 = (cVar3 == null || (editText4 = cVar3.f77473d) == null || (text4 = editText4.getText()) == null) ? null : text4.toString();
            if (obj3 == null) {
                obj3 = "";
            }
            if (StringsKt.q0(obj3)) {
                obj3 = null;
            }
            vp.c cVar4 = (vp.c) getMViewBinding();
            String obj4 = (cVar4 == null || (editText3 = cVar4.f77472c) == null || (text3 = editText3.getText()) == null) ? null : text3.toString();
            String str2 = obj4 == null ? "" : obj4;
            vp.c cVar5 = (vp.c) getMViewBinding();
            String obj5 = (cVar5 == null || (editText2 = cVar5.f77477h) == null || (text2 = editText2.getText()) == null) ? null : text2.toString();
            if (obj5 == null) {
                obj5 = "";
            }
            String str3 = StringsKt.q0(obj5) ? null : obj5;
            vp.c cVar6 = (vp.c) getMViewBinding();
            String obj6 = (cVar6 == null || (editText = cVar6.f77474e) == null || (text = editText.getText()) == null) ? null : text.toString();
            String str4 = obj6 != null ? obj6 : "";
            String str5 = StringsKt.q0(str4) ? null : str4;
            List c11 = CollectionsKt.c();
            c11.add(new PhoneInfo(J0(), obj2, this.mainCountry.getCountry_s()));
            if (obj3 != null) {
                c11.add(new PhoneInfo(H0(), obj3, this.altCountry.getCountry_s()));
            }
            L0().h(new ClaimReceiverRequest(this.prizeId, str, CollectionsKt.a(c11), str5, str2, str3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c1(Country country) {
        TextView textView;
        TextView textView2;
        this.altCountry = country;
        String code = country.getCode();
        if (code == null) {
            code = "";
        }
        String str = "+" + code;
        vp.c cVar = (vp.c) getMViewBinding();
        if (cVar != null && (textView2 = cVar.f77486q) != null) {
            textView2.setText(str);
        }
        String code2 = country.getCode();
        String str2 = "+" + (code2 != null ? code2 : "");
        vp.c cVar2 = (vp.c) getMViewBinding();
        if (cVar2 == null || (textView = cVar2.f77485p) == null) {
            return;
        }
        textView.setText(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d1() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        Editable text;
        EditText editText2;
        Editable text2;
        EditText editText3;
        Editable text3;
        vp.c cVar = (vp.c) getMViewBinding();
        String str = null;
        String obj = (cVar == null || (editText3 = cVar.f77475f) == null || (text3 = editText3.getText()) == null) ? null : text3.toString();
        if (obj == null) {
            obj = "";
        }
        vp.c cVar2 = (vp.c) getMViewBinding();
        String obj2 = (cVar2 == null || (editText2 = cVar2.f77476g) == null || (text2 = editText2.getText()) == null) ? null : text2.toString();
        if (obj2 == null) {
            obj2 = "";
        }
        vp.c cVar3 = (vp.c) getMViewBinding();
        if (cVar3 != null && (editText = cVar3.f77472c) != null && (text = editText.getText()) != null) {
            str = text.toString();
        }
        boolean z10 = (StringsKt.q0(obj) || StringsKt.q0(J0()) || !com.transsion.rewardscenter.utils.c.f51352a.b(obj2) || StringsKt.q0(str != null ? str : "")) ? false : true;
        vp.c cVar4 = (vp.c) getMViewBinding();
        if (cVar4 == null || (appCompatTextView = cVar4.f77471b) == null) {
            return;
        }
        appCompatTextView.setAlpha(z10 ? 1.0f : 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean e1() {
        EditText editText;
        Editable text;
        String obj;
        vp.c cVar = (vp.c) getMViewBinding();
        boolean z10 = false;
        if (cVar != null && (editText = cVar.f77472c) != null && (text = editText.getText()) != null && (obj = text.toString()) != null && (!StringsKt.q0(obj))) {
            z10 = true;
        }
        if (z10) {
            vp.c cVar2 = (vp.c) getMViewBinding();
            F0(this, cVar2 != null ? cVar2.f77472c : null, null, 2, null);
        } else {
            vp.c cVar3 = (vp.c) getMViewBinding();
            a1(this, cVar3 != null ? cVar3.f77472c : null, null, 2, null);
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean f1() {
        EditText editText;
        Editable text;
        String obj;
        vp.c cVar = (vp.c) getMViewBinding();
        boolean z10 = false;
        if (cVar != null && (editText = cVar.f77475f) != null && (text = editText.getText()) != null && (obj = text.toString()) != null && (!StringsKt.q0(obj))) {
            z10 = true;
        }
        if (z10) {
            vp.c cVar2 = (vp.c) getMViewBinding();
            F0(this, cVar2 != null ? cVar2.f77475f : null, null, 2, null);
        } else {
            vp.c cVar3 = (vp.c) getMViewBinding();
            a1(this, cVar3 != null ? cVar3.f77475f : null, null, 2, null);
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean g1() {
        EditText editText;
        Editable text;
        boolean q02 = StringsKt.q0(J0());
        com.transsion.rewardscenter.utils.c cVar = com.transsion.rewardscenter.utils.c.f51352a;
        vp.c cVar2 = (vp.c) getMViewBinding();
        String obj = (cVar2 == null || (editText = cVar2.f77476g) == null || (text = editText.getText()) == null) ? null : text.toString();
        if (obj == null) {
            obj = "";
        }
        boolean b11 = cVar.b(obj);
        boolean z10 = !q02 && b11;
        if (z10) {
            vp.c cVar3 = (vp.c) getMViewBinding();
            LinearLayout linearLayout = cVar3 != null ? cVar3.f77481l : null;
            vp.c cVar4 = (vp.c) getMViewBinding();
            E0(linearLayout, cVar4 != null ? cVar4.f77476g : null);
            vp.c cVar5 = (vp.c) getMViewBinding();
            F0(this, cVar5 != null ? cVar5.f77486q : null, null, 2, null);
        } else {
            if (q02) {
                vp.c cVar6 = (vp.c) getMViewBinding();
                a1(this, cVar6 != null ? cVar6.f77486q : null, null, 2, null);
            }
            if (!b11) {
                vp.c cVar7 = (vp.c) getMViewBinding();
                LinearLayout linearLayout2 = cVar7 != null ? cVar7.f77481l : null;
                vp.c cVar8 = (vp.c) getMViewBinding();
                Z0(linearLayout2, cVar8 != null ? cVar8.f77476g : null);
            }
        }
        return z10;
    }

    private final void showLoading() {
        I0().l0(this, "loading");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public vp.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        vp.c c11 = vp.c.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        AppCompatImageView appCompatImageView;
        vp.c cVar = (vp.c) getMViewBinding();
        if (cVar != null && (appCompatImageView = cVar.f77478i) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClaimRewardFragment.N0(ClaimRewardFragment.this, view);
                }
            });
        }
        vp.c cVar2 = (vp.c) getMViewBinding();
        if (cVar2 != null && (linearLayout2 = cVar2.f77480k) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClaimRewardFragment.O0(ClaimRewardFragment.this, view);
                }
            });
        }
        vp.c cVar3 = (vp.c) getMViewBinding();
        if (cVar3 != null && (linearLayout = cVar3.f77479j) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.rewardscenter.ui.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClaimRewardFragment.P0(ClaimRewardFragment.this, view);
                }
            });
        }
        Function4 function4 = new Function4() { // from class: com.transsion.rewardscenter.ui.f
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit Q0;
                Q0 = ClaimRewardFragment.Q0(ClaimRewardFragment.this, (CharSequence) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
                return Q0;
            }
        };
        vp.c cVar4 = (vp.c) getMViewBinding();
        if (cVar4 != null && (editText6 = cVar4.f77475f) != null) {
            editText6.addTextChangedListener(new b(function4));
        }
        vp.c cVar5 = (vp.c) getMViewBinding();
        if (cVar5 != null && (editText5 = cVar5.f77476g) != null) {
            editText5.addTextChangedListener(new c(function4));
        }
        vp.c cVar6 = (vp.c) getMViewBinding();
        if (cVar6 != null && (editText4 = cVar6.f77472c) != null) {
            editText4.addTextChangedListener(new d(function4));
        }
        vp.c cVar7 = (vp.c) getMViewBinding();
        if (cVar7 != null && (editText3 = cVar7.f77475f) != null) {
            editText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.rewardscenter.ui.g
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    ClaimRewardFragment.R0(ClaimRewardFragment.this, view, z10);
                }
            });
        }
        vp.c cVar8 = (vp.c) getMViewBinding();
        if (cVar8 != null && (editText2 = cVar8.f77476g) != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.rewardscenter.ui.h
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    ClaimRewardFragment.S0(ClaimRewardFragment.this, view, z10);
                }
            });
        }
        vp.c cVar9 = (vp.c) getMViewBinding();
        if (cVar9 != null && (editText = cVar9.f77472c) != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.rewardscenter.ui.i
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    ClaimRewardFragment.T0(ClaimRewardFragment.this, view, z10);
                }
            });
        }
        vp.c cVar10 = (vp.c) getMViewBinding();
        if (cVar10 == null || (appCompatTextView = cVar10.f77471b) == null) {
            return;
        }
        jg.c.c(appCompatTextView, 0L, new Function1() { // from class: com.transsion.rewardscenter.ui.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = ClaimRewardFragment.U0(ClaimRewardFragment.this, (View) obj);
                return U0;
            }
        }, 1, null);
    }

    @Override // com.transsion.rewardscenter.ui.FitStatusBarFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        super.initViewData();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("prize_id", "");
            Intrinsics.g(string, "getString(...)");
            this.prizeId = string;
        }
        M0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        L0().g().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.rewardscenter.ui.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit V0;
                V0 = ClaimRewardFragment.V0(ClaimRewardFragment.this, (Boolean) obj);
                return V0;
            }
        }));
        L0().f().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.rewardscenter.ui.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = ClaimRewardFragment.W0(ClaimRewardFragment.this, (Pair) obj);
                return W0;
            }
        }));
        L0().e().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.rewardscenter.ui.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit X0;
                X0 = ClaimRewardFragment.X0(ClaimRewardFragment.this, (Boolean) obj);
                return X0;
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.rewardscenter.ui.FitStatusBarFragment
    protected View n0() {
        vp.c cVar = (vp.c) getMViewBinding();
        if (cVar != null) {
            return cVar.f77484o;
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("claim_reward", false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.rewardscenter.ui.FitStatusBarFragment
    protected View o0() {
        vp.c cVar = (vp.c) getMViewBinding();
        if (cVar != null) {
            return cVar.f77482m;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView textView;
        TextView textView2;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            return;
        }
        Serializable serializableExtra = data != null ? data.getSerializableExtra("countryCode") : null;
        Country country = serializableExtra instanceof Country ? (Country) serializableExtra : null;
        if (country == null) {
            return;
        }
        if (requestCode == 1001) {
            this.mainCountry = country;
            vp.c cVar = (vp.c) getMViewBinding();
            if (cVar == null || (textView = cVar.f77486q) == null) {
                return;
            }
            textView.setText("+" + country.getCode());
            return;
        }
        if (requestCode != 1002) {
            return;
        }
        this.altCountry = country;
        vp.c cVar2 = (vp.c) getMViewBinding();
        if (cVar2 == null || (textView2 = cVar2.f77485p) == null) {
            return;
        }
        textView2.setText("+" + country.getCode());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
