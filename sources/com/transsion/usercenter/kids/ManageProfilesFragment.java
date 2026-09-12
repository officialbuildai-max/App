package com.transsion.usercenter.kids;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.t;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLView;
import com.therouter.TheRouter;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.kids.KidsAccountManager;
import com.transsion.baselib.kids.KidsProfile;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.edit.ProfileEditCenterActivity;
import com.transsion.usercenter.kids.CreateKidsProfileDialog;
import com.transsion.usercenter.kids.ManageProfilesFragment;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import fw.j0;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/transsion/usercenter/kids/ManageProfilesFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lfw/j0;", "<init>", "()V", "", "h0", "", "dp", "k0", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "e0", "(Landroid/view/LayoutInflater;)Lfw/j0;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onResume", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ManageProfilesFragment extends BaseFragment<j0> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.usercenter.kids.ManageProfilesFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ManageProfilesFragment a() {
            return new ManageProfilesFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ManageProfilesFragment manageProfilesFragment, String str, Bundle bundle) {
        Intrinsics.h(str, "<unused var>");
        Intrinsics.h(bundle, "<unused var>");
        manageProfilesFragment.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ManageProfilesFragment manageProfilesFragment, View view) {
        a.C0856a.f(a.f68962a, "ManageProfilesFragment", "adult account edit.", false, 4, null);
        ProfileEditCenterActivity.Companion companion = ProfileEditCenterActivity.INSTANCE;
        Context requireContext = manageProfilesFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        companion.a(requireContext, null);
    }

    private final void h0() {
        LinearLayout linearLayout;
        BLLinearLayout bLLinearLayout;
        BLView bLView;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        ShapeableImageView shapeableImageView;
        LinearLayout linearLayout4;
        TnTextView tnTextView;
        ShapeableImageView shapeableImageView2;
        BLView bLView2;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        ShapeableImageView shapeableImageView3;
        TnTextView tnTextView2;
        LinearLayout linearLayout7;
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        boolean a11 = iLoginApi != null ? iLoginApi.a() : false;
        UserInfo i11 = iLoginApi != null ? iLoginApi.i() : null;
        if (a11) {
            j0 mViewBinding = getMViewBinding();
            if (mViewBinding != null && (linearLayout7 = mViewBinding.f62842i) != null) {
                linearLayout7.setVisibility(0);
            }
            j0 mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (tnTextView2 = mViewBinding2.f62844k) != null) {
                String nickname = i11 != null ? i11.getNickname() : null;
                if (nickname == null) {
                    nickname = "";
                }
                tnTextView2.setText(nickname);
            }
            j0 mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (shapeableImageView3 = mViewBinding3.f62836c) != null) {
                f.a aVar = f.f62005a;
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                aVar.m(requireContext).g(i11 != null ? i11.getAvatar() : null).i(R$drawable.ic_default_avatar).d(shapeableImageView3);
            }
            k0(72);
        } else {
            j0 mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (linearLayout = mViewBinding4.f62842i) != null) {
                linearLayout.setVisibility(8);
            }
            k0(0);
        }
        KidsProfile f11 = KidsAccountManager.f43340a.f();
        if (f11 == null) {
            j0 mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (linearLayout3 = mViewBinding5.f62843j) != null) {
                linearLayout3.setVisibility(8);
            }
            j0 mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (linearLayout2 = mViewBinding6.f62841h) != null) {
                linearLayout2.setVisibility(0);
            }
            j0 mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (bLView = mViewBinding7.f62847n) != null) {
                bLView.setVisibility(8);
            }
            j0 mViewBinding8 = getMViewBinding();
            if (mViewBinding8 == null || (bLLinearLayout = mViewBinding8.f62835b) == null) {
                return;
            }
            bLLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: pw.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageProfilesFragment.j0(ManageProfilesFragment.this, view);
                }
            });
            return;
        }
        j0 mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (linearLayout6 = mViewBinding9.f62843j) != null) {
            linearLayout6.setVisibility(0);
        }
        j0 mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (linearLayout5 = mViewBinding10.f62841h) != null) {
            linearLayout5.setVisibility(8);
        }
        j0 mViewBinding11 = getMViewBinding();
        if (mViewBinding11 != null && (bLView2 = mViewBinding11.f62847n) != null) {
            bLView2.setVisibility(0);
        }
        String avatarLocalPath = f11.getAvatarLocalPath();
        if (avatarLocalPath == null || avatarLocalPath.length() == 0) {
            j0 mViewBinding12 = getMViewBinding();
            if (mViewBinding12 != null && (shapeableImageView = mViewBinding12.f62839f) != null) {
                shapeableImageView.setImageResource(R$drawable.ic_kids_avatar);
            }
        } else {
            j0 mViewBinding13 = getMViewBinding();
            if (mViewBinding13 != null && (shapeableImageView2 = mViewBinding13.f62839f) != null) {
                Glide.with(requireContext()).load2(new File(avatarLocalPath)).into(shapeableImageView2);
            }
        }
        j0 mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (tnTextView = mViewBinding14.f62845l) != null) {
            tnTextView.setText(f11.getName());
        }
        j0 mViewBinding15 = getMViewBinding();
        if (mViewBinding15 == null || (linearLayout4 = mViewBinding15.f62843j) == null) {
            return;
        }
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: pw.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ManageProfilesFragment.i0(ManageProfilesFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ManageProfilesFragment manageProfilesFragment, View view) {
        a.C0856a.f(a.f68962a, "ManageProfilesFragment", "kids account edit.", false, 4, null);
        KidsProfile f11 = KidsAccountManager.f43340a.f();
        if (f11 != null) {
            ProfileEditCenterActivity.Companion companion = ProfileEditCenterActivity.INSTANCE;
            Context requireContext = manageProfilesFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            companion.b(requireContext, f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(ManageProfilesFragment manageProfilesFragment, View view) {
        a.C0856a.f(a.f68962a, "ManageProfilesFragment", "adult account create.", false, 4, null);
        FragmentActivity requireActivity = manageProfilesFragment.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        CreateKidsProfileDialog.Companion.b(CreateKidsProfileDialog.INSTANCE, false, false, false, 6, null).X(requireActivity, "CreateKidsProfileDialog");
    }

    private final void k0(int dp2) {
        int i11 = (int) ((dp2 * getResources().getDisplayMetrics().density) + 0.5f);
        j0 mViewBinding = getMViewBinding();
        LinearLayout linearLayout = mViewBinding != null ? mViewBinding.f62843j : null;
        j0 mViewBinding2 = getMViewBinding();
        for (LinearLayout linearLayout2 : CollectionsKt.p(linearLayout, mViewBinding2 != null ? mViewBinding2.f62841h : null)) {
            ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.setMarginStart(i11);
                linearLayout2.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public j0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        j0 c11 = j0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        LinearLayout linearLayout;
        Intrinsics.h(view, "view");
        getParentFragmentManager().G1("result_kids_created", getViewLifecycleOwner(), new t() { // from class: pw.t
            @Override // androidx.fragment.app.t
            public final void a(String str, Bundle bundle) {
                ManageProfilesFragment.f0(ManageProfilesFragment.this, str, bundle);
            }
        });
        j0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (linearLayout = mViewBinding.f62842i) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: pw.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ManageProfilesFragment.g0(ManageProfilesFragment.this, view2);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        h0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h0();
    }
}
