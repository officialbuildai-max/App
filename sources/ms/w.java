package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class w implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f70067a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f70068b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f70069c;

    private w(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView) {
        this.f70067a = frameLayout;
        this.f70068b = frameLayout2;
        this.f70069c = recyclerView;
    }

    public static w a(View view) {
        int i11 = R$id.loading;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.f52626rv;
            RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
            if (recyclerView != null) {
                return new w((FrameLayout) view, frameLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_fragment_dialog_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f70067a;
    }
}
