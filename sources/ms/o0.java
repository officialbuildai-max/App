package ms;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: classes7.dex */
public final class o0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f70002a;

    /* renamed from: b, reason: collision with root package name */
    public final TnTextView f70003b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f70004c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f70005d;

    private o0(ConstraintLayout constraintLayout, TnTextView tnTextView, RecyclerView recyclerView, TnTextView tnTextView2) {
        this.f70002a = constraintLayout;
        this.f70003b = tnTextView;
        this.f70004c = recyclerView;
        this.f70005d = tnTextView2;
    }

    public static o0 a(View view) {
        int i11 = R$id.main_operation_movie_more_text;
        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
        if (tnTextView != null) {
            i11 = R$id.main_operation_movie_rank_recycler;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.main_operation_movie_rank_title;
                TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                if (tnTextView2 != null) {
                    return new o0((ConstraintLayout) view, tnTextView, recyclerView, tnTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70002a;
    }
}
