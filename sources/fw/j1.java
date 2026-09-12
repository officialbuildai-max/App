package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class j1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62848a;

    /* renamed from: b, reason: collision with root package name */
    public final SwitchButton f62849b;

    /* renamed from: c, reason: collision with root package name */
    public final TitleLayout f62850c;

    /* renamed from: d, reason: collision with root package name */
    public final View f62851d;

    private j1(ConstraintLayout constraintLayout, SwitchButton switchButton, TitleLayout titleLayout, View view) {
        this.f62848a = constraintLayout;
        this.f62849b = switchButton;
        this.f62850c = titleLayout;
        this.f62851d = view;
    }

    public static j1 a(View view) {
        View a11;
        int i11 = R$id.switch_button;
        SwitchButton switchButton = (SwitchButton) g4.b.a(view, i11);
        if (switchButton != null) {
            i11 = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
            if (titleLayout != null && (a11 = g4.b.a(view, (i11 = R$id.v_notice_bg))) != null) {
                return new j1((ConstraintLayout) view, switchButton, titleLayout, a11);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static j1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.user_activity_setting_notice, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62848a;
    }
}
