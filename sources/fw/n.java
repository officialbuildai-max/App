package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FragmentContainerView f62939a;

    /* renamed from: b, reason: collision with root package name */
    public final FragmentContainerView f62940b;

    private n(FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2) {
        this.f62939a = fragmentContainerView;
        this.f62940b = fragmentContainerView2;
    }

    public static n a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view;
        return new n(fragmentContainerView, fragmentContainerView);
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_tv_download_web_link, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FragmentContainerView getRoot() {
        return this.f62939a;
    }
}
