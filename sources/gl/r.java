package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes6.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63938a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageButton f63939b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f63940c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f63941d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f63942e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f63943f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f63944g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f63945h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f63946i;

    /* renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f63947j;

    /* renamed from: k, reason: collision with root package name */
    public final MagicIndicator f63948k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f63949l;

    /* renamed from: m, reason: collision with root package name */
    public final TextSwitcher f63950m;

    /* renamed from: n, reason: collision with root package name */
    public final BlurredSectorView f63951n;

    /* renamed from: o, reason: collision with root package name */
    public final TnTextView f63952o;

    /* renamed from: p, reason: collision with root package name */
    public final TnTextView f63953p;

    /* renamed from: q, reason: collision with root package name */
    public final TnTextView f63954q;

    /* renamed from: r, reason: collision with root package name */
    public final ConstraintLayout f63955r;

    /* renamed from: s, reason: collision with root package name */
    public final ViewPager2 f63956s;

    private r(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout3, MagicIndicator magicIndicator, FrameLayout frameLayout3, TextSwitcher textSwitcher, BlurredSectorView blurredSectorView, TnTextView tnTextView, TnTextView tnTextView2, TnTextView tnTextView3, ConstraintLayout constraintLayout4, ViewPager2 viewPager2) {
        this.f63938a = constraintLayout;
        this.f63939b = appCompatImageButton;
        this.f63940c = frameLayout;
        this.f63941d = frameLayout2;
        this.f63942e = constraintLayout2;
        this.f63943f = appCompatImageView;
        this.f63944g = appCompatImageView2;
        this.f63945h = appCompatImageView3;
        this.f63946i = appCompatImageView4;
        this.f63947j = constraintLayout3;
        this.f63948k = magicIndicator;
        this.f63949l = frameLayout3;
        this.f63950m = textSwitcher;
        this.f63951n = blurredSectorView;
        this.f63952o = tnTextView;
        this.f63953p = tnTextView2;
        this.f63954q = tnTextView3;
        this.f63955r = constraintLayout4;
        this.f63956s = viewPager2;
    }

    public static r a(View view) {
        int i11 = R$id.btn_tab_menu;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) g4.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.flGameCenter;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.flPhoneCenter;
                FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                if (frameLayout2 != null) {
                    i11 = R$id.gradeSelectorContainer;
                    ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                    if (constraintLayout != null) {
                        i11 = R$id.ivGradeArrow;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.iv_mb_logo;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.ivNovelEnter;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.ivUpdateApp;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView4 != null) {
                                        i11 = R$id.ll_tab;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) g4.b.a(view, i11);
                                        if (constraintLayout2 != null) {
                                            i11 = R$id.magic_indicator;
                                            MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                            if (magicIndicator != null) {
                                                i11 = R$id.search_left_container;
                                                FrameLayout frameLayout3 = (FrameLayout) g4.b.a(view, i11);
                                                if (frameLayout3 != null) {
                                                    i11 = R$id.text_switcher;
                                                    TextSwitcher textSwitcher = (TextSwitcher) g4.b.a(view, i11);
                                                    if (textSwitcher != null) {
                                                        i11 = R$id.trending_bottom_bg;
                                                        BlurredSectorView blurredSectorView = (BlurredSectorView) g4.b.a(view, i11);
                                                        if (blurredSectorView != null) {
                                                            i11 = R$id.tvGradeName;
                                                            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                                                            if (tnTextView != null) {
                                                                i11 = R$id.tv_search;
                                                                TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                                                                if (tnTextView2 != null) {
                                                                    i11 = R$id.tv_search_button;
                                                                    TnTextView tnTextView3 = (TnTextView) g4.b.a(view, i11);
                                                                    if (tnTextView3 != null) {
                                                                        i11 = R$id.tv_search_container;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) g4.b.a(view, i11);
                                                                        if (constraintLayout3 != null) {
                                                                            i11 = R$id.view_pager;
                                                                            ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                                                            if (viewPager2 != null) {
                                                                                return new r((ConstraintLayout) view, appCompatImageButton, frameLayout, frameLayout2, constraintLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, constraintLayout2, magicIndicator, frameLayout3, textSwitcher, blurredSectorView, tnTextView, tnTextView2, tnTextView3, constraintLayout3, viewPager2);
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

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63938a;
    }
}
