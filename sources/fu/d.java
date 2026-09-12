package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: classes7.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62607a;

    /* renamed from: b, reason: collision with root package name */
    public final EditTextWithClear f62608b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f62609c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f62610d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayoutCompat f62611e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f62612f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f62613g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f62614h;

    private d(ConstraintLayout constraintLayout, EditTextWithClear editTextWithClear, AppCompatImageView appCompatImageView, ImageView imageView, LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3) {
        this.f62607a = constraintLayout;
        this.f62608b = editTextWithClear;
        this.f62609c = appCompatImageView;
        this.f62610d = imageView;
        this.f62611e = linearLayoutCompat;
        this.f62612f = textView;
        this.f62613g = textView2;
        this.f62614h = textView3;
    }

    public static d a(View view) {
        int i11 = R$id.et_search_keyword;
        EditTextWithClear editTextWithClear = (EditTextWithClear) g4.b.a(view, i11);
        if (editTextWithClear != null) {
            i11 = R$id.iv_search_keyword;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_select;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.ll_select;
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                    if (linearLayoutCompat != null) {
                        i11 = R$id.tv_download;
                        TextView textView = (TextView) g4.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.tv_tips;
                            TextView textView2 = (TextView) g4.b.a(view, i11);
                            if (textView2 != null) {
                                i11 = R$id.tv_title;
                                TextView textView3 = (TextView) g4.b.a(view, i11);
                                if (textView3 != null) {
                                    return new d((ConstraintLayout) view, editTextWithClear, appCompatImageView, imageView, linearLayoutCompat, textView, textView2, textView3);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_no_subtitle_tips, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62607a;
    }
}
