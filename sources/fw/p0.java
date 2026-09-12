package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class p0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62963a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientBorderView f62964b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f62965c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeableImageView f62966d;

    /* renamed from: e, reason: collision with root package name */
    public final TnTextView f62967e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f62968f;

    /* renamed from: g, reason: collision with root package name */
    public final Group f62969g;

    /* renamed from: h, reason: collision with root package name */
    public final View f62970h;

    /* renamed from: i, reason: collision with root package name */
    public final TabLayout f62971i;

    /* renamed from: j, reason: collision with root package name */
    public final TitleLayout f62972j;

    /* renamed from: k, reason: collision with root package name */
    public final FragmentContainerView f62973k;

    private p0(ConstraintLayout constraintLayout, GradientBorderView gradientBorderView, BLTextView bLTextView, ShapeableImageView shapeableImageView, TnTextView tnTextView, AppCompatImageView appCompatImageView, Group group, View view, TabLayout tabLayout, TitleLayout titleLayout, FragmentContainerView fragmentContainerView) {
        this.f62963a = constraintLayout;
        this.f62964b = gradientBorderView;
        this.f62965c = bLTextView;
        this.f62966d = shapeableImageView;
        this.f62967e = tnTextView;
        this.f62968f = appCompatImageView;
        this.f62969g = group;
        this.f62970h = view;
        this.f62971i = tabLayout;
        this.f62972j = titleLayout;
        this.f62973k = fragmentContainerView;
    }

    public static p0 a(View view) {
        View a11;
        int i11 = R$id.scanButton;
        GradientBorderView gradientBorderView = (GradientBorderView) g4.b.a(view, i11);
        if (gradientBorderView != null) {
            i11 = R$id.scanButtonBackground;
            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.scanCard;
                ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.scanDescription;
                    TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                    if (tnTextView != null) {
                        i11 = R$id.scanDeviceImage;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.scanModuleGroup;
                            Group group = (Group) g4.b.a(view, i11);
                            if (group != null && (a11 = g4.b.a(view, (i11 = R$id.tabDivider))) != null) {
                                i11 = R$id.tabLayout;
                                TabLayout tabLayout = (TabLayout) g4.b.a(view, i11);
                                if (tabLayout != null) {
                                    i11 = R$id.titleLayout;
                                    TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                                    if (titleLayout != null) {
                                        i11 = R$id.webFragmentContainer;
                                        FragmentContainerView fragmentContainerView = (FragmentContainerView) g4.b.a(view, i11);
                                        if (fragmentContainerView != null) {
                                            return new p0((ConstraintLayout) view, gradientBorderView, bLTextView, shapeableImageView, tnTextView, appCompatImageView, group, a11, tabLayout, titleLayout, fragmentContainerView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static p0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_tv_download_web_link, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62963a;
    }
}
