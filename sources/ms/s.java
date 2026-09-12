package ms;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.transsion.shorttv.R$id;

/* loaded from: classes7.dex */
public final class s implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f70039a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f70040b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f70041c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f70042d;

    /* renamed from: e, reason: collision with root package name */
    public final TabLayout f70043e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f70044f;

    /* renamed from: g, reason: collision with root package name */
    public final View f70045g;

    private s(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, TabLayout tabLayout, AppCompatTextView appCompatTextView, View view) {
        this.f70039a = constraintLayout;
        this.f70040b = appCompatImageView;
        this.f70041c = progressBar;
        this.f70042d = recyclerView;
        this.f70043e = tabLayout;
        this.f70044f = appCompatTextView;
        this.f70045g = view;
    }

    public static s a(View view) {
        View a11;
        int i11 = R$id.iv_close;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.f52626rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tab;
                    TabLayout tabLayout = (TabLayout) g4.b.a(view, i11);
                    if (tabLayout != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.view_line))) != null) {
                            return new s((ConstraintLayout) view, appCompatImageView, progressBar, recyclerView, tabLayout, appCompatTextView, a11);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70039a;
    }
}
