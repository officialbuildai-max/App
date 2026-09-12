package so;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: classes6.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f75676a;

    /* renamed from: b, reason: collision with root package name */
    public final View f75677b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f75678c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f75679d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f75680e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f75681f;

    /* renamed from: g, reason: collision with root package name */
    public final ProgressBar f75682g;

    private j(LinearLayoutCompat linearLayoutCompat, View view, RecyclerView recyclerView, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ProgressBar progressBar) {
        this.f75676a = linearLayoutCompat;
        this.f75677b = view;
        this.f75678c = recyclerView;
        this.f75679d = linearLayout;
        this.f75680e = appCompatTextView;
        this.f75681f = appCompatTextView2;
        this.f75682g = progressBar;
    }

    public static j a(View view) {
        int i11 = R$id.comment_input_bg;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.comment_list;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.ll_loading;
                LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.tv_comment;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_loading;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.view_load;
                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                            if (progressBar != null) {
                                return new j((LinearLayoutCompat) view, a11, recyclerView, linearLayout, appCompatTextView, appCompatTextView2, progressBar);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_comment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f75676a;
    }
}
