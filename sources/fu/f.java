package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62617a;

    /* renamed from: b, reason: collision with root package name */
    public final EditTextWithClear f62618b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f62619c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f62620d;

    /* renamed from: e, reason: collision with root package name */
    public final MagicIndicator f62621e;

    /* renamed from: f, reason: collision with root package name */
    public final NestedScrollableHost f62622f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f62623g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f62624h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewPager2 f62625i;

    private f(ConstraintLayout constraintLayout, EditTextWithClear editTextWithClear, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, MagicIndicator magicIndicator, NestedScrollableHost nestedScrollableHost, TextView textView, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.f62617a = constraintLayout;
        this.f62618b = editTextWithClear;
        this.f62619c = appCompatImageView;
        this.f62620d = appCompatImageView2;
        this.f62621e = magicIndicator;
        this.f62622f = nestedScrollableHost;
        this.f62623g = textView;
        this.f62624h = appCompatTextView;
        this.f62625i = viewPager2;
    }

    public static f a(View view) {
        int i11 = R$id.et_search_keyword;
        EditTextWithClear editTextWithClear = (EditTextWithClear) g4.b.a(view, i11);
        if (editTextWithClear != null) {
            i11 = R$id.ivBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_search_keyword;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.magic_indicator;
                    MagicIndicator magicIndicator = (MagicIndicator) g4.b.a(view, i11);
                    if (magicIndicator != null) {
                        i11 = R$id.nsh_content;
                        NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) g4.b.a(view, i11);
                        if (nestedScrollableHost != null) {
                            i11 = R$id.tv_search;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.tvStyle;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.view_pager;
                                    ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                                    if (viewPager2 != null) {
                                        return new f((ConstraintLayout) view, editTextWithClear, appCompatImageView, appCompatImageView2, magicIndicator, nestedScrollableHost, textView, appCompatTextView, viewPager2);
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

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subtitle_search_download, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62617a;
    }
}
