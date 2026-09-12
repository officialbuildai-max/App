package au;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.tabs.TabLayout;
import com.transsion.subroom.R$id;
import com.transsion.subroom.R$layout;
import com.transsion.wrapperad.view.secondfloor.SecondFloorArcCoverView;
import com.transsion.wrapperad.view.secondfloor.TrendingTwoLevelIrregularView;

/* loaded from: classes6.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16208a;

    /* renamed from: b, reason: collision with root package name */
    public final SecondFloorArcCoverView f16209b;

    /* renamed from: c, reason: collision with root package name */
    public final View f16210c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f16211d;

    /* renamed from: e, reason: collision with root package name */
    public final Group f16212e;

    /* renamed from: f, reason: collision with root package name */
    public final View f16213f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f16214g;

    /* renamed from: h, reason: collision with root package name */
    public final View f16215h;

    /* renamed from: i, reason: collision with root package name */
    public final View f16216i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f16217j;

    /* renamed from: k, reason: collision with root package name */
    public final TrendingTwoLevelIrregularView f16218k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f16219l;

    /* renamed from: m, reason: collision with root package name */
    public final TabLayout f16220m;

    private a(ConstraintLayout constraintLayout, SecondFloorArcCoverView secondFloorArcCoverView, View view, FrameLayout frameLayout, Group group, View view2, ImageView imageView, View view3, View view4, ImageView imageView2, TrendingTwoLevelIrregularView trendingTwoLevelIrregularView, ImageView imageView3, TabLayout tabLayout) {
        this.f16208a = constraintLayout;
        this.f16209b = secondFloorArcCoverView;
        this.f16210c = view;
        this.f16211d = frameLayout;
        this.f16212e = group;
        this.f16213f = view2;
        this.f16214g = imageView;
        this.f16215h = view3;
        this.f16216i = view4;
        this.f16217j = imageView2;
        this.f16218k = trendingTwoLevelIrregularView;
        this.f16219l = imageView3;
        this.f16220m = tabLayout;
    }

    public static a a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        int i11 = R$id.arcCover;
        SecondFloorArcCoverView secondFloorArcCoverView = (SecondFloorArcCoverView) g4.b.a(view, i11);
        if (secondFloorArcCoverView != null && (a11 = g4.b.a(view, (i11 = R$id.centerBg))) != null) {
            i11 = R$id.container;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.largeBottomBg;
                Group group = (Group) g4.b.a(view, i11);
                if (group != null && (a12 = g4.b.a(view, (i11 = R$id.leftBg))) != null) {
                    i11 = R$id.leftTwoBg;
                    ImageView imageView = (ImageView) g4.b.a(view, i11);
                    if (imageView != null && (a13 = g4.b.a(view, (i11 = R$id.main_bottom_view))) != null && (a14 = g4.b.a(view, (i11 = R$id.rightBg))) != null) {
                        i11 = R$id.rightTwoBg;
                        ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                        if (imageView2 != null) {
                            i11 = R$id.secondFloorAdView;
                            TrendingTwoLevelIrregularView trendingTwoLevelIrregularView = (TrendingTwoLevelIrregularView) g4.b.a(view, i11);
                            if (trendingTwoLevelIrregularView != null) {
                                i11 = R$id.tabBg;
                                ImageView imageView3 = (ImageView) g4.b.a(view, i11);
                                if (imageView3 != null) {
                                    i11 = R$id.tab_bottom;
                                    TabLayout tabLayout = (TabLayout) g4.b.a(view, i11);
                                    if (tabLayout != null) {
                                        return new a((ConstraintLayout) view, secondFloorArcCoverView, a11, frameLayout, group, a12, imageView, a13, a14, imageView2, trendingTwoLevelIrregularView, imageView3, tabLayout);
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

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16208a;
    }
}
