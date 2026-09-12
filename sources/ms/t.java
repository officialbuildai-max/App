package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class t implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f70050a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f70051b;

    /* renamed from: c, reason: collision with root package name */
    public final ProgressBar f70052c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f70053d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f70054e;

    private t(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.f70050a = bLConstraintLayout;
        this.f70051b = appCompatImageView;
        this.f70052c = progressBar;
        this.f70053d = recyclerView;
        this.f70054e = appCompatTextView;
    }

    public static t a(View view) {
        int i11 = R$id.iv_close;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.pb_loading;
            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.f52626rv;
                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new t((BLConstraintLayout) view, appCompatImageView, progressBar, recyclerView, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static t c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_dialog_language_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f70050a;
    }
}
