package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.rewardscenter.R$id;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.prize.PrizeListView;
import com.transsion.rewardscenter.redeem.RedeemView;
import com.transsion.rewardscenter.view.PrizeFlowView;
import com.transsion.rewardscenter.view.RewardsCenterTaskView;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f77487a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f77488b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f77489c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f77490d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f77491e;

    /* renamed from: f, reason: collision with root package name */
    public final h f77492f;

    /* renamed from: g, reason: collision with root package name */
    public final PrizeFlowView f77493g;

    /* renamed from: h, reason: collision with root package name */
    public final CardView f77494h;

    /* renamed from: i, reason: collision with root package name */
    public final CardView f77495i;

    /* renamed from: j, reason: collision with root package name */
    public final PrizeListView f77496j;

    /* renamed from: k, reason: collision with root package name */
    public final ConstraintLayout f77497k;

    /* renamed from: l, reason: collision with root package name */
    public final CardView f77498l;

    /* renamed from: m, reason: collision with root package name */
    public final RedeemView f77499m;

    /* renamed from: n, reason: collision with root package name */
    public final CardView f77500n;

    /* renamed from: o, reason: collision with root package name */
    public final RewardsCenterTaskView f77501o;

    /* renamed from: p, reason: collision with root package name */
    public final CardView f77502p;

    /* renamed from: q, reason: collision with root package name */
    public final NestedScrollView f77503q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f77504r;

    /* renamed from: s, reason: collision with root package name */
    public final ConstraintLayout f77505s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f77506t;

    private d(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, RecyclerView recyclerView, h hVar, PrizeFlowView prizeFlowView, CardView cardView, CardView cardView2, PrizeListView prizeListView, ConstraintLayout constraintLayout2, CardView cardView3, RedeemView redeemView, CardView cardView4, RewardsCenterTaskView rewardsCenterTaskView, CardView cardView5, NestedScrollView nestedScrollView, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView2) {
        this.f77487a = constraintLayout;
        this.f77488b = appCompatImageView;
        this.f77489c = appCompatImageView2;
        this.f77490d = appCompatImageView3;
        this.f77491e = recyclerView;
        this.f77492f = hVar;
        this.f77493g = prizeFlowView;
        this.f77494h = cardView;
        this.f77495i = cardView2;
        this.f77496j = prizeListView;
        this.f77497k = constraintLayout2;
        this.f77498l = cardView3;
        this.f77499m = redeemView;
        this.f77500n = cardView4;
        this.f77501o = rewardsCenterTaskView;
        this.f77502p = cardView5;
        this.f77503q = nestedScrollView;
        this.f77504r = appCompatTextView;
        this.f77505s = constraintLayout3;
        this.f77506t = appCompatTextView2;
    }

    public static d a(View view) {
        View a11;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_banner;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.iv_prize_triangle;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.iv_task_list;
                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                    if (recyclerView != null && (a11 = g4.b.a(view, (i11 = R$id.member_info))) != null) {
                        h a12 = h.a(a11);
                        i11 = R$id.prize_flow;
                        PrizeFlowView prizeFlowView = (PrizeFlowView) g4.b.a(view, i11);
                        if (prizeFlowView != null) {
                            i11 = R$id.rc_banner_card;
                            CardView cardView = (CardView) g4.b.a(view, i11);
                            if (cardView != null) {
                                i11 = R$id.rc_prize_card;
                                CardView cardView2 = (CardView) g4.b.a(view, i11);
                                if (cardView2 != null) {
                                    i11 = R$id.rc_prize_list_view;
                                    PrizeListView prizeListView = (PrizeListView) g4.b.a(view, i11);
                                    if (prizeListView != null) {
                                        i11 = R$id.rc_prize_section;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                                        if (constraintLayout != null) {
                                            i11 = R$id.rc_redeem_card;
                                            CardView cardView3 = (CardView) g4.b.a(view, i11);
                                            if (cardView3 != null) {
                                                i11 = R$id.rc_redeem_view;
                                                RedeemView redeemView = (RedeemView) g4.b.a(view, i11);
                                                if (redeemView != null) {
                                                    i11 = R$id.rc_task_card;
                                                    CardView cardView4 = (CardView) g4.b.a(view, i11);
                                                    if (cardView4 != null) {
                                                        i11 = R$id.rc_task_view;
                                                        RewardsCenterTaskView rewardsCenterTaskView = (RewardsCenterTaskView) g4.b.a(view, i11);
                                                        if (rewardsCenterTaskView != null) {
                                                            i11 = R$id.rv_task_card;
                                                            CardView cardView5 = (CardView) g4.b.a(view, i11);
                                                            if (cardView5 != null) {
                                                                i11 = R$id.scroll_view;
                                                                NestedScrollView nestedScrollView = (NestedScrollView) g4.b.a(view, i11);
                                                                if (nestedScrollView != null) {
                                                                    i11 = R$id.title;
                                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView != null) {
                                                                        i11 = R$id.titleLayout;
                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                                                                        if (constraintLayout2 != null) {
                                                                            i11 = R$id.tv_terms;
                                                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView2 != null) {
                                                                                return new d((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, recyclerView, a12, prizeFlowView, cardView, cardView2, prizeListView, constraintLayout, cardView3, redeemView, cardView4, rewardsCenterTaskView, cardView5, nestedScrollView, appCompatTextView, constraintLayout2, appCompatTextView2);
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

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_rewards_center, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77487a;
    }
}
