package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes6.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63858a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63859b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f63860c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f63861d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f63862e;

    /* renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f63863f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f63864g;

    /* renamed from: h, reason: collision with root package name */
    public final MagicIndicator f63865h;

    /* renamed from: i, reason: collision with root package name */
    public final BlurredSectorView f63866i;

    /* renamed from: j, reason: collision with root package name */
    public final View f63867j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewPager2 f63868k;

    private j(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, TnTextView tnTextView, MagicIndicator magicIndicator, BlurredSectorView blurredSectorView, View view, ViewPager2 viewPager2) {
        this.f63858a = constraintLayout;
        this.f63859b = frameLayout;
        this.f63860c = appCompatImageView;
        this.f63861d = appCompatImageView2;
        this.f63862e = frameLayout2;
        this.f63863f = constraintLayout2;
        this.f63864g = tnTextView;
        this.f63865h = magicIndicator;
        this.f63866i = blurredSectorView;
        this.f63867j = view;
        this.f63868k = viewPager2;
    }

    public static j a(View view) {
        View a11;
        int i11 = R$id.bottom_op_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.bottom_op_mb_logo;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.bottom_op_search_appstore;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.bottom_op_search_gamestore;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.bottom_op_search_liner;
                        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                        if (constraintLayout != null) {
                            i11 = R$id.bottom_op_search_text;
                            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                            if (tnTextView != null) {
                                i11 = R$id.magicIndicator;
                                MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                                if (magicIndicator != null) {
                                    i11 = R$id.trending_bottom_bg;
                                    BlurredSectorView blurredSectorView = (BlurredSectorView) g4.b.a(view, i11);
                                    if (blurredSectorView != null && (a11 = g4.b.a(view, (i11 = R$id.viewLine))) != null) {
                                        i11 = R$id.viewPager;
                                        ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                        if (viewPager2 != null) {
                                            return new j((ConstraintLayout) view, frameLayout, appCompatImageView, appCompatImageView2, frameLayout2, constraintLayout, tnTextView, magicIndicator, blurredSectorView, a11, viewPager2);
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

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_bottom_op, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63858a;
    }
}
