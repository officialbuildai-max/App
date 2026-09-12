package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.ProfileSettingTitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f62873a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f62874b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f62875c;

    /* renamed from: d, reason: collision with root package name */
    public final ProfileSettingTitleLayout f62876d;

    /* renamed from: e, reason: collision with root package name */
    public final ProfileSettingTitleLayout f62877e;

    /* renamed from: f, reason: collision with root package name */
    public final TitleLayout f62878f;

    /* renamed from: g, reason: collision with root package name */
    public final ProfileSettingTitleLayout f62879g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f62880h;

    private l(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ProfileSettingTitleLayout profileSettingTitleLayout, ProfileSettingTitleLayout profileSettingTitleLayout2, TitleLayout titleLayout, ProfileSettingTitleLayout profileSettingTitleLayout3, TextView textView) {
        this.f62873a = constraintLayout;
        this.f62874b = imageView;
        this.f62875c = imageView2;
        this.f62876d = profileSettingTitleLayout;
        this.f62877e = profileSettingTitleLayout2;
        this.f62878f = titleLayout;
        this.f62879g = profileSettingTitleLayout3;
        this.f62880h = textView;
    }

    public static l a(View view) {
        int i11 = R$id.ivAvatar;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.ivRight;
            ImageView imageView2 = (ImageView) g4.b.a(view, i11);
            if (imageView2 != null) {
                i11 = R$id.titleBirth;
                ProfileSettingTitleLayout profileSettingTitleLayout = (ProfileSettingTitleLayout) g4.b.a(view, i11);
                if (profileSettingTitleLayout != null) {
                    i11 = R$id.titleGender;
                    ProfileSettingTitleLayout profileSettingTitleLayout2 = (ProfileSettingTitleLayout) g4.b.a(view, i11);
                    if (profileSettingTitleLayout2 != null) {
                        i11 = R$id.titleLayout;
                        TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                        if (titleLayout != null) {
                            i11 = R$id.titleRegion;
                            ProfileSettingTitleLayout profileSettingTitleLayout3 = (ProfileSettingTitleLayout) g4.b.a(view, i11);
                            if (profileSettingTitleLayout3 != null) {
                                i11 = R$id.tvNickName;
                                TextView textView = (TextView) g4.b.a(view, i11);
                                if (textView != null) {
                                    return new l((ConstraintLayout) view, imageView, imageView2, profileSettingTitleLayout, profileSettingTitleLayout2, titleLayout, profileSettingTitleLayout3, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_profile_edit, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f62873a;
    }
}
