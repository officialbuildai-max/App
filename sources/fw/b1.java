package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class b1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62713a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f62714b;

    private b1(ConstraintLayout constraintLayout, FrameLayout frameLayout) {
        this.f62713a = constraintLayout;
        this.f62714b = frameLayout;
    }

    public static b1 a(View view) {
        int i11 = R$id.flContent;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            return new b1((ConstraintLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static b1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.profile_activity_see, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62713a;
    }
}
