package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class e implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62740a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f62741b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatButton f62742c;

    /* renamed from: d, reason: collision with root package name */
    public final TitleLayout f62743d;

    private e(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatButton appCompatButton, TitleLayout titleLayout) {
        this.f62740a = constraintLayout;
        this.f62741b = recyclerView;
        this.f62742c = appCompatButton;
        this.f62743d = titleLayout;
    }

    public static e a(View view) {
        int i11 = R$id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.submitButton;
            AppCompatButton appCompatButton = (AppCompatButton) g4.b.a(view, i11);
            if (appCompatButton != null) {
                i11 = R$id.toolbar;
                TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                if (titleLayout != null) {
                    return new e((ConstraintLayout) view, recyclerView, appCompatButton, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_labels_feedback, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62740a;
    }
}
