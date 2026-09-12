package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class w implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f63980a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63981b;

    /* renamed from: c, reason: collision with root package name */
    public final View f63982c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f63983d;

    private w(LinearLayout linearLayout, FrameLayout frameLayout, View view, ConstraintLayout constraintLayout) {
        this.f63980a = linearLayout;
        this.f63981b = frameLayout;
        this.f63982c = view;
        this.f63983d = constraintLayout;
    }

    public static w a(View view) {
        View a11;
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null && (a11 = g4.b.a(view, (i11 = R$id.sub_room_header_bg))) != null) {
            i11 = R$id.sub_room_title_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
            if (constraintLayout != null) {
                return new w((LinearLayout) view, frameLayout, a11, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f63980a;
    }
}
