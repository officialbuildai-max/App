package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class t0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f63033a;

    /* renamed from: b, reason: collision with root package name */
    public final BLView f63034b;

    /* renamed from: c, reason: collision with root package name */
    public final TnTextView f63035c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f63036d;

    /* renamed from: e, reason: collision with root package name */
    public final TnTextView f63037e;

    /* renamed from: f, reason: collision with root package name */
    public final BLView f63038f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f63039g;

    /* renamed from: h, reason: collision with root package name */
    public final GradientTextView f63040h;

    /* renamed from: i, reason: collision with root package name */
    public final TnTextView f63041i;

    /* renamed from: j, reason: collision with root package name */
    public final TnTextView f63042j;

    /* renamed from: k, reason: collision with root package name */
    public final TnTextView f63043k;

    /* renamed from: l, reason: collision with root package name */
    public final Guideline f63044l;

    /* renamed from: m, reason: collision with root package name */
    public final BLView f63045m;

    /* renamed from: n, reason: collision with root package name */
    public final TnTextView f63046n;

    /* renamed from: o, reason: collision with root package name */
    public final TnTextView f63047o;

    /* renamed from: p, reason: collision with root package name */
    public final TnTextView f63048p;

    /* renamed from: q, reason: collision with root package name */
    public final BLView f63049q;

    /* renamed from: r, reason: collision with root package name */
    public final GradientBorderView f63050r;

    /* renamed from: s, reason: collision with root package name */
    public final TnTextView f63051s;

    /* renamed from: t, reason: collision with root package name */
    public final GradientTextView f63052t;

    /* renamed from: u, reason: collision with root package name */
    public final RecyclerView f63053u;

    /* renamed from: v, reason: collision with root package name */
    public final GradientBorderView f63054v;

    /* renamed from: w, reason: collision with root package name */
    public final BLView f63055w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatImageView f63056x;

    /* renamed from: y, reason: collision with root package name */
    public final TnTextView f63057y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatImageView f63058z;

    private t0(BLConstraintLayout bLConstraintLayout, BLView bLView, TnTextView tnTextView, TnTextView tnTextView2, TnTextView tnTextView3, BLView bLView2, TnTextView tnTextView4, GradientTextView gradientTextView, TnTextView tnTextView5, TnTextView tnTextView6, TnTextView tnTextView7, Guideline guideline, BLView bLView3, TnTextView tnTextView8, TnTextView tnTextView9, TnTextView tnTextView10, BLView bLView4, GradientBorderView gradientBorderView, TnTextView tnTextView11, GradientTextView gradientTextView2, RecyclerView recyclerView, GradientBorderView gradientBorderView2, BLView bLView5, AppCompatImageView appCompatImageView, TnTextView tnTextView12, AppCompatImageView appCompatImageView2) {
        this.f63033a = bLConstraintLayout;
        this.f63034b = bLView;
        this.f63035c = tnTextView;
        this.f63036d = tnTextView2;
        this.f63037e = tnTextView3;
        this.f63038f = bLView2;
        this.f63039g = tnTextView4;
        this.f63040h = gradientTextView;
        this.f63041i = tnTextView5;
        this.f63042j = tnTextView6;
        this.f63043k = tnTextView7;
        this.f63044l = guideline;
        this.f63045m = bLView3;
        this.f63046n = tnTextView8;
        this.f63047o = tnTextView9;
        this.f63048p = tnTextView10;
        this.f63049q = bLView4;
        this.f63050r = gradientBorderView;
        this.f63051s = tnTextView11;
        this.f63052t = gradientTextView2;
        this.f63053u = recyclerView;
        this.f63054v = gradientBorderView2;
        this.f63055w = bLView5;
        this.f63056x = appCompatImageView;
        this.f63057y = tnTextView12;
        this.f63058z = appCompatImageView2;
    }

    public static t0 a(View view) {
        int i11 = R$id.basicColumnBackground;
        BLView bLView = (BLView) g4.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.basicColumnTitle;
            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
            if (tnTextView != null) {
                i11 = R$id.basicLinkedCount;
                TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                if (tnTextView2 != null) {
                    i11 = R$id.basicLinkedLabel;
                    TnTextView tnTextView3 = (TnTextView) g4.b.a(view, i11);
                    if (tnTextView3 != null) {
                        i11 = R$id.basicPlanBackground;
                        BLView bLView2 = (BLView) g4.b.a(view, i11);
                        if (bLView2 != null) {
                            i11 = R$id.basicPlanSubtitle;
                            TnTextView tnTextView4 = (TnTextView) g4.b.a(view, i11);
                            if (tnTextView4 != null) {
                                i11 = R$id.basicPlanTitle;
                                GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                if (gradientTextView != null) {
                                    i11 = R$id.basicSubtitle;
                                    TnTextView tnTextView5 = (TnTextView) g4.b.a(view, i11);
                                    if (tnTextView5 != null) {
                                        i11 = R$id.basicTitle;
                                        TnTextView tnTextView6 = (TnTextView) g4.b.a(view, i11);
                                        if (tnTextView6 != null) {
                                            i11 = R$id.featuresTitle;
                                            TnTextView tnTextView7 = (TnTextView) g4.b.a(view, i11);
                                            if (tnTextView7 != null) {
                                                i11 = R$id.planDivider;
                                                Guideline guideline = (Guideline) g4.b.a(view, i11);
                                                if (guideline != null) {
                                                    i11 = R$id.proColumnBackground;
                                                    BLView bLView3 = (BLView) g4.b.a(view, i11);
                                                    if (bLView3 != null) {
                                                        i11 = R$id.proColumnTitle;
                                                        TnTextView tnTextView8 = (TnTextView) g4.b.a(view, i11);
                                                        if (tnTextView8 != null) {
                                                            i11 = R$id.proLinkedCount;
                                                            TnTextView tnTextView9 = (TnTextView) g4.b.a(view, i11);
                                                            if (tnTextView9 != null) {
                                                                i11 = R$id.proLinkedLabel;
                                                                TnTextView tnTextView10 = (TnTextView) g4.b.a(view, i11);
                                                                if (tnTextView10 != null) {
                                                                    i11 = R$id.proPlanBackground;
                                                                    BLView bLView4 = (BLView) g4.b.a(view, i11);
                                                                    if (bLView4 != null) {
                                                                        i11 = R$id.proPlanBorder;
                                                                        GradientBorderView gradientBorderView = (GradientBorderView) g4.b.a(view, i11);
                                                                        if (gradientBorderView != null) {
                                                                            i11 = R$id.proPlanSubtitle;
                                                                            TnTextView tnTextView11 = (TnTextView) g4.b.a(view, i11);
                                                                            if (tnTextView11 != null) {
                                                                                i11 = R$id.proPlanTitle;
                                                                                GradientTextView gradientTextView2 = (GradientTextView) g4.b.a(view, i11);
                                                                                if (gradientTextView2 != null) {
                                                                                    i11 = R$id.rightsList;
                                                                                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                                                    if (recyclerView != null) {
                                                                                        i11 = R$id.scanButtonBorder;
                                                                                        GradientBorderView gradientBorderView2 = (GradientBorderView) g4.b.a(view, i11);
                                                                                        if (gradientBorderView2 != null) {
                                                                                            i11 = R$id.unlockProButton;
                                                                                            BLView bLView5 = (BLView) g4.b.a(view, i11);
                                                                                            if (bLView5 != null) {
                                                                                                i11 = R$id.unlockProIcon;
                                                                                                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                                                                                if (appCompatImageView != null) {
                                                                                                    i11 = R$id.unlockProText;
                                                                                                    TnTextView tnTextView12 = (TnTextView) g4.b.a(view, i11);
                                                                                                    if (tnTextView12 != null) {
                                                                                                        i11 = R$id.upgradeArrow;
                                                                                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                                                                                        if (appCompatImageView2 != null) {
                                                                                                            return new t0((BLConstraintLayout) view, bLView, tnTextView, tnTextView2, tnTextView3, bLView2, tnTextView4, gradientTextView, tnTextView5, tnTextView6, tnTextView7, guideline, bLView3, tnTextView8, tnTextView9, tnTextView10, bLView4, gradientBorderView, tnTextView11, gradientTextView2, recyclerView, gradientBorderView2, bLView5, appCompatImageView, tnTextView12, appCompatImageView2);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static t0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.item_device_management_basic_rights, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f63033a;
    }
}
