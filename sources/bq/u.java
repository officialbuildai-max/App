package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class u implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f16950a;

    /* renamed from: b, reason: collision with root package name */
    public final View f16951b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f16952c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f16953d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f16954e;

    /* renamed from: f, reason: collision with root package name */
    public final SwipeRefreshLayout f16955f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f16956g;

    private u(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, ImageView imageView, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        this.f16950a = constraintLayout;
        this.f16951b = view;
        this.f16952c = recyclerView;
        this.f16953d = imageView;
        this.f16954e = constraintLayout2;
        this.f16955f = swipeRefreshLayout;
        this.f16956g = textView;
    }

    public static u a(View view) {
        int i11 = R$id.divider_line;
        View a11 = g4.b.a(view, i11);
        if (a11 != null) {
            i11 = R$id.followingsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.iv_back;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.mTitleLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                    if (constraintLayout != null) {
                        i11 = R$id.swipe_refresh;
                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) g4.b.a(view, i11);
                        if (swipeRefreshLayout != null) {
                            i11 = R$id.tv_title;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                return new u((ConstraintLayout) view, a11, recyclerView, imageView, constraintLayout, swipeRefreshLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subscription_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f16950a;
    }
}
