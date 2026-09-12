package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class i0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f72880a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f72881b;

    /* renamed from: c, reason: collision with root package name */
    public final TnTextView f72882c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f72883d;

    /* renamed from: e, reason: collision with root package name */
    public final View f72884e;

    private i0(ConstraintLayout constraintLayout, RecyclerView recyclerView, TnTextView tnTextView, TnTextView tnTextView2, View view) {
        this.f72880a = constraintLayout;
        this.f72881b = recyclerView;
        this.f72882c = tnTextView;
        this.f72883d = tnTextView2;
        this.f72884e = view;
    }

    public static i0 a(View view) {
        View a11;
        int i11 = R$id.historyRv;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tvAll;
            TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
            if (tnTextView != null) {
                i11 = R$id.tvTitle;
                TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                if (tnTextView2 != null && (a11 = g4.b.a(view, (i11 = R$id.vLine))) != null) {
                    return new i0((ConstraintLayout) view, recyclerView, tnTextView, tnTextView2, a11);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static i0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_history_play_record_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72880a;
    }
}
