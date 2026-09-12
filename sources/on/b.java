package on;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.ninegridview.preview.HackyViewPager;

/* loaded from: classes6.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f71170a;

    /* renamed from: b, reason: collision with root package name */
    public final BLView f71171b;

    /* renamed from: c, reason: collision with root package name */
    public final BLView f71172c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f71173d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f71174e;

    /* renamed from: f, reason: collision with root package name */
    public final View f71175f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f71176g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f71177h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f71178i;

    /* renamed from: j, reason: collision with root package name */
    public final HackyViewPager f71179j;

    private b(ConstraintLayout constraintLayout, BLView bLView, BLView bLView2, ImageView imageView, ConstraintLayout constraintLayout2, View view, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, HackyViewPager hackyViewPager) {
        this.f71170a = constraintLayout;
        this.f71171b = bLView;
        this.f71172c = bLView2;
        this.f71173d = imageView;
        this.f71174e = constraintLayout2;
        this.f71175f = view;
        this.f71176g = appCompatTextView;
        this.f71177h = textView;
        this.f71178i = appCompatTextView2;
        this.f71179j = hackyViewPager;
    }

    public static b a(View view) {
        int i11 = R$id.bg_download;
        BLView bLView = (BLView) g4.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.bg_share;
            BLView bLView2 = (BLView) g4.b.a(view, i11);
            if (bLView2 != null) {
                i11 = R$id.iv_back;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R$id.statusSpace;
                    View a11 = g4.b.a(view, i11);
                    if (a11 != null) {
                        i11 = R$id.tv_download;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_pager;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.tv_share;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.viewPager;
                                    HackyViewPager hackyViewPager = (HackyViewPager) g4.b.a(view, i11);
                                    if (hackyViewPager != null) {
                                        return new b(constraintLayout, bLView, bLView2, imageView, constraintLayout, a11, appCompatTextView, textView, appCompatTextView2, hackyViewPager);
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

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_preview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f71170a;
    }
}
