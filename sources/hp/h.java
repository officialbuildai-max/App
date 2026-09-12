package hp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.LoadingAnimView;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.publish.view.operation.OperationBarView;
import com.transsion.publish.view.operation.OperationVerticalBarView;

/* loaded from: classes6.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f64901a;

    /* renamed from: b, reason: collision with root package name */
    public final BubbleTextView f64902b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f64903c;

    /* renamed from: d, reason: collision with root package name */
    public final EditText f64904d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f64905e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f64906f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f64907g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f64908h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f64909i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f64910j;

    /* renamed from: k, reason: collision with root package name */
    public final LoadingAnimView f64911k;

    /* renamed from: l, reason: collision with root package name */
    public final OperationVerticalBarView f64912l;

    /* renamed from: m, reason: collision with root package name */
    public final OperationBarView f64913m;

    /* renamed from: n, reason: collision with root package name */
    public final RatingBar f64914n;

    /* renamed from: o, reason: collision with root package name */
    public final RelativeLayout f64915o;

    /* renamed from: p, reason: collision with root package name */
    public final RelativeLayout f64916p;

    /* renamed from: q, reason: collision with root package name */
    public final RelativeLayout f64917q;

    /* renamed from: r, reason: collision with root package name */
    public final RecyclerView f64918r;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f64919s;

    /* renamed from: t, reason: collision with root package name */
    public final ObservableScrollView f64920t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f64921u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f64922v;

    /* renamed from: w, reason: collision with root package name */
    public final TextView f64923w;

    /* renamed from: x, reason: collision with root package name */
    public final View f64924x;

    private h(RelativeLayout relativeLayout, BubbleTextView bubbleTextView, EditText editText, EditText editText2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, LinearLayout linearLayout, LoadingAnimView loadingAnimView, OperationVerticalBarView operationVerticalBarView, OperationBarView operationBarView, RatingBar ratingBar, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RecyclerView recyclerView, RecyclerView recyclerView2, ObservableScrollView observableScrollView, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f64901a = relativeLayout;
        this.f64902b = bubbleTextView;
        this.f64903c = editText;
        this.f64904d = editText2;
        this.f64905e = frameLayout;
        this.f64906f = frameLayout2;
        this.f64907g = imageView;
        this.f64908h = imageView2;
        this.f64909i = relativeLayout2;
        this.f64910j = linearLayout;
        this.f64911k = loadingAnimView;
        this.f64912l = operationVerticalBarView;
        this.f64913m = operationBarView;
        this.f64914n = ratingBar;
        this.f64915o = relativeLayout3;
        this.f64916p = relativeLayout4;
        this.f64917q = relativeLayout5;
        this.f64918r = recyclerView;
        this.f64919s = recyclerView2;
        this.f64920t = observableScrollView;
        this.f64921u = textView;
        this.f64922v = textView2;
        this.f64923w = textView3;
        this.f64924x = view;
    }

    public static h a(View view) {
        View a11;
        int i11 = R$id.activity_tip;
        BubbleTextView bubbleTextView = (BubbleTextView) g4.b.a(view, i11);
        if (bubbleTextView != null) {
            i11 = R$id.et_des;
            EditText editText = (EditText) g4.b.a(view, i11);
            if (editText != null) {
                i11 = R$id.et_title;
                EditText editText2 = (EditText) g4.b.a(view, i11);
                if (editText2 != null) {
                    i11 = R$id.fl_top;
                    FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.fr_title;
                        FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                        if (frameLayout2 != null) {
                            i11 = R$id.iv_cover;
                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.iv_cover_ic;
                                ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                if (imageView2 != null) {
                                    i11 = R$id.ll_list;
                                    RelativeLayout relativeLayout = (RelativeLayout) g4.b.a(view, i11);
                                    if (relativeLayout != null) {
                                        i11 = R$id.ll_top;
                                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                        if (linearLayout != null) {
                                            i11 = R$id.loading_view;
                                            LoadingAnimView loadingAnimView = (LoadingAnimView) g4.b.a(view, i11);
                                            if (loadingAnimView != null) {
                                                i11 = R$id.oper_vertical_view;
                                                OperationVerticalBarView operationVerticalBarView = (OperationVerticalBarView) g4.b.a(view, i11);
                                                if (operationVerticalBarView != null) {
                                                    i11 = R$id.oper_view;
                                                    OperationBarView operationBarView = (OperationBarView) g4.b.a(view, i11);
                                                    if (operationBarView != null) {
                                                        i11 = R$id.rb_star;
                                                        RatingBar ratingBar = (RatingBar) g4.b.a(view, i11);
                                                        if (ratingBar != null) {
                                                            i11 = R$id.rl_add_cover;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) g4.b.a(view, i11);
                                                            if (relativeLayout2 != null) {
                                                                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                                                i11 = R$id.rl_star;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) g4.b.a(view, i11);
                                                                if (relativeLayout4 != null) {
                                                                    i11 = R$id.rv_link;
                                                                    RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                                    if (recyclerView != null) {
                                                                        i11 = R$id.rv_select;
                                                                        RecyclerView recyclerView2 = (RecyclerView) g4.b.a(view, i11);
                                                                        if (recyclerView2 != null) {
                                                                            i11 = R$id.scrollView;
                                                                            ObservableScrollView observableScrollView = (ObservableScrollView) g4.b.a(view, i11);
                                                                            if (observableScrollView != null) {
                                                                                i11 = R$id.tv_click_stars;
                                                                                TextView textView = (TextView) g4.b.a(view, i11);
                                                                                if (textView != null) {
                                                                                    i11 = R$id.tv_star_tips;
                                                                                    TextView textView2 = (TextView) g4.b.a(view, i11);
                                                                                    if (textView2 != null) {
                                                                                        i11 = R$id.tv_title_tips;
                                                                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                                                                        if (textView3 != null && (a11 = g4.b.a(view, (i11 = R$id.view_line2))) != null) {
                                                                                            return new h(relativeLayout3, bubbleTextView, editText, editText2, frameLayout, frameLayout2, imageView, imageView2, relativeLayout, linearLayout, loadingAnimView, operationVerticalBarView, operationBarView, ratingBar, relativeLayout2, relativeLayout3, relativeLayout4, recyclerView, recyclerView2, observableScrollView, textView, textView2, textView3, a11);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_film_review, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f64901a;
    }
}
