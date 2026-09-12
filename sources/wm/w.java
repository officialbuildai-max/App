package wm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.member.R$layout;

/* loaded from: classes6.dex */
public final class w implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f78040a;

    private w(ConstraintLayout constraintLayout) {
        this.f78040a = constraintLayout;
    }

    public static w a(View view) {
        if (view != null) {
            return new w((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static w c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_premium_half_screen_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f78040a;
    }
}
