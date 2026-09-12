package hp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.MatchParentVideoView;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64884a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f64885b;

    /* renamed from: c, reason: collision with root package name */
    public final View f64886c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageButton f64887d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f64888e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f64889f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f64890g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f64891h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f64892i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f64893j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f64894k;

    /* renamed from: l, reason: collision with root package name */
    public final ConstraintLayout f64895l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f64896m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f64897n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f64898o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f64899p;

    /* renamed from: q, reason: collision with root package name */
    public final MatchParentVideoView f64900q;

    private g(ConstraintLayout constraintLayout, Group group, View view, AppCompatImageButton appCompatImageButton, RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, MatchParentVideoView matchParentVideoView) {
        this.f64884a = constraintLayout;
        this.f64885b = group;
        this.f64886c = view;
        this.f64887d = appCompatImageButton;
        this.f64888e = relativeLayout;
        this.f64889f = progressBar;
        this.f64890g = textView;
        this.f64891h = imageView;
        this.f64892i = frameLayout;
        this.f64893j = linearLayout;
        this.f64894k = imageView2;
        this.f64895l = constraintLayout2;
        this.f64896m = textView2;
        this.f64897n = textView3;
        this.f64898o = textView4;
        this.f64899p = textView5;
        this.f64900q = matchParentVideoView;
    }

    public static g a(View view) {
        View a11;
        int i11 = R$id.bottomGroup;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null && (a11 = g4.b.a(view, (i11 = R$id.bottomLine))) != null) {
            i11 = R$id.btn_back;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) g4.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.clTitle;
                RelativeLayout relativeLayout = (RelativeLayout) g4.b.a(view, i11);
                if (relativeLayout != null) {
                    i11 = R$id.clip_loading;
                    ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.confirmTV;
                        TextView textView = (TextView) g4.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.coverIV;
                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.fl_clear;
                                FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                if (frameLayout != null) {
                                    i11 = R$id.llSelect;
                                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                    if (linearLayout != null) {
                                        i11 = R$id.playIV;
                                        ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                        if (imageView2 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i11 = R$id.selectNumTV;
                                            TextView textView2 = (TextView) g4.b.a(view, i11);
                                            if (textView2 != null) {
                                                i11 = R$id.tv_delete;
                                                TextView textView3 = (TextView) g4.b.a(view, i11);
                                                if (textView3 != null) {
                                                    i11 = R$id.tvNumber;
                                                    TextView textView4 = (TextView) g4.b.a(view, i11);
                                                    if (textView4 != null) {
                                                        i11 = R$id.tvSelect;
                                                        TextView textView5 = (TextView) g4.b.a(view, i11);
                                                        if (textView5 != null) {
                                                            i11 = R$id.vv_video;
                                                            MatchParentVideoView matchParentVideoView = (MatchParentVideoView) g4.b.a(view, i11);
                                                            if (matchParentVideoView != null) {
                                                                return new g(constraintLayout, group, a11, appCompatImageButton, relativeLayout, progressBar, textView, imageView, frameLayout, linearLayout, imageView2, constraintLayout, textView2, textView3, textView4, textView5, matchParentVideoView);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_video_preview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64884a;
    }
}
