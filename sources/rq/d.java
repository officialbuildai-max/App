package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f74745a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f74746b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f74747c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f74748d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f74749e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f74750f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f74751g;

    /* renamed from: h, reason: collision with root package name */
    public final RecyclerView f74752h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f74753i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f74754j;

    private d(RelativeLayout relativeLayout, EditText editText, ImageView imageView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ProgressBar progressBar, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f74745a = relativeLayout;
        this.f74746b = editText;
        this.f74747c = imageView;
        this.f74748d = appCompatImageView;
        this.f74749e = linearLayout;
        this.f74750f = progressBar;
        this.f74751g = relativeLayout2;
        this.f74752h = recyclerView;
        this.f74753i = textView;
        this.f74754j = textView2;
    }

    public static d a(View view) {
        int i11 = R$id.comment_input_edit_text;
        EditText editText = (EditText) g4.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.iv_cancel;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_clear;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_top;
                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.load_view;
                        ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                        if (progressBar != null) {
                            i11 = R$id.rl_tips;
                            RelativeLayout relativeLayout = (RelativeLayout) g4.b.a(view, i11);
                            if (relativeLayout != null) {
                                i11 = R$id.f51993rv;
                                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                if (recyclerView != null) {
                                    i11 = R$id.tv_clear;
                                    TextView textView = (TextView) g4.b.a(view, i11);
                                    if (textView != null) {
                                        i11 = R$id.tv_search;
                                        TextView textView2 = (TextView) g4.b.a(view, i11);
                                        if (textView2 != null) {
                                            return new d((RelativeLayout) view, editText, imageView, appCompatImageView, linearLayout, progressBar, relativeLayout, recyclerView, textView, textView2);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_publish_search, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f74745a;
    }
}
