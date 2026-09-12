package ms;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R$id;

/* loaded from: classes7.dex */
public final class i implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f69914a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f69915b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f69916c;

    private i(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.f69914a = constraintLayout;
        this.f69915b = recyclerView;
        this.f69916c = textView;
    }

    public static i a(View view) {
        int i11 = R$id.sub_operation_variable_recycle;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.sub_operation_variable_title;
            TextView textView = (TextView) g4.b.a(view, i11);
            if (textView != null) {
                return new i((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f69914a;
    }
}
