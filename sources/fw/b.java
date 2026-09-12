package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FragmentContainerView f62705a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentContainerView f62706b;

    private b(FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2) {
        this.f62705a = fragmentContainerView;
        this.f62706b = fragmentContainerView2;
    }

    public static b a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view;
        return new b(fragmentContainerView, fragmentContainerView);
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_device_management, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FragmentContainerView getRoot() {
        return this.f62705a;
    }
}
