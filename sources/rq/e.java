package rq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: classes6.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f74755a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f74756b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f74757c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f74758d;

    /* renamed from: e, reason: collision with root package name */
    public final View f74759e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f74760f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f74761g;

    /* renamed from: h, reason: collision with root package name */
    public final RecyclerView f74762h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f74763i;

    private e(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, EditText editText, ImageView imageView, View view, ProgressBar progressBar, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.f74755a = constraintLayout;
        this.f74756b = appCompatImageView;
        this.f74757c = editText;
        this.f74758d = imageView;
        this.f74759e = view;
        this.f74760f = progressBar;
        this.f74761g = textView;
        this.f74762h = recyclerView;
        this.f74763i = textView2;
    }

    public static e a(View view) {
        View a11;
        int i11 = R$id.clearIV;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.inputET;
            EditText editText = (EditText) g4.b.a(view, i11);
            if (editText != null) {
                i11 = R$id.iv_cancel;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null && (a11 = g4.b.a(view, (i11 = R$id.line))) != null) {
                    i11 = R$id.loadView;
                    ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.recentTV;
                        TextView textView = (TextView) g4.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.f51993rv;
                            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.searchTV;
                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                if (textView2 != null) {
                                    return new e((ConstraintLayout) view, appCompatImageView, editText, imageView, a11, progressBar, textView, recyclerView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_publish_work, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f74755a;
    }
}
