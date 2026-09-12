package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* loaded from: classes7.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62603a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f62604b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f62605c;

    /* renamed from: d, reason: collision with root package name */
    public final View f62606d;

    private c(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, View view) {
        this.f62603a = constraintLayout;
        this.f62604b = recyclerView;
        this.f62605c = appCompatTextView;
        this.f62606d = view;
    }

    public static c a(View view) {
        View a11;
        int i11 = R$id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tv_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null && (a11 = g4.b.a(view, (i11 = R$id.v_bottom_line_line))) != null) {
                return new c((ConstraintLayout) view, recyclerView, appCompatTextView, a11);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_audio_select_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62603a;
    }
}
