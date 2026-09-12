package on;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;

/* loaded from: classes6.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f71163a;

    /* renamed from: b, reason: collision with root package name */
    public final View f71164b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f71165c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f71166d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f71167e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f71168f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewPager2 f71169g;

    private a(ConstraintLayout constraintLayout, View view, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, TextView textView, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.f71163a = constraintLayout;
        this.f71164b = view;
        this.f71165c = appCompatImageView;
        this.f71166d = constraintLayout2;
        this.f71167e = textView;
        this.f71168f = appCompatTextView;
        this.f71169g = viewPager2;
    }

    public static a a(View view) {
        int i11 = R$id.btn_top;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.iv_download;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R$id.tv_pager;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvSaved;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.viewPager;
                        ViewPager2 viewPager2 = (ViewPager2) g4.b.a(view, i11);
                        if (viewPager2 != null) {
                            return new a(constraintLayout, a11, appCompatImageView, constraintLayout, textView, appCompatTextView, viewPager2);
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
        View inflate = layoutInflater.inflate(R$layout.activity_gif_image_preview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f71163a;
    }
}
