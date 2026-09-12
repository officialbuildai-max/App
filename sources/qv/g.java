package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.view.SwitchButton;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73854a;

    /* renamed from: b, reason: collision with root package name */
    public final BLConstraintLayout f73855b;

    /* renamed from: c, reason: collision with root package name */
    public final BLConstraintLayout f73856c;

    /* renamed from: d, reason: collision with root package name */
    public final BLConstraintLayout f73857d;

    /* renamed from: e, reason: collision with root package name */
    public final BLConstraintLayout f73858e;

    /* renamed from: f, reason: collision with root package name */
    public final BLConstraintLayout f73859f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f73860g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f73861h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f73862i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f73863j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f73864k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f73865l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f73866m;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f73867n;

    /* renamed from: o, reason: collision with root package name */
    public final SwitchButton f73868o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f73869p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f73870q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f73871r;

    /* renamed from: s, reason: collision with root package name */
    public final GradientTextView f73872s;

    /* renamed from: t, reason: collision with root package name */
    public final GradientTextView f73873t;

    /* renamed from: u, reason: collision with root package name */
    public final GradientTextView f73874u;

    /* renamed from: v, reason: collision with root package name */
    public final GradientTextView f73875v;

    /* renamed from: w, reason: collision with root package name */
    public final GradientTextView f73876w;

    /* renamed from: x, reason: collision with root package name */
    public final GradientTextView f73877x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f73878y;

    /* renamed from: z, reason: collision with root package name */
    public final TextView f73879z;

    private g(ConstraintLayout constraintLayout, BLConstraintLayout bLConstraintLayout, BLConstraintLayout bLConstraintLayout2, BLConstraintLayout bLConstraintLayout3, BLConstraintLayout bLConstraintLayout4, BLConstraintLayout bLConstraintLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, RecyclerView recyclerView, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, GradientTextView gradientTextView, GradientTextView gradientTextView2, GradientTextView gradientTextView3, GradientTextView gradientTextView4, GradientTextView gradientTextView5, GradientTextView gradientTextView6, TextView textView4, TextView textView5) {
        this.f73854a = constraintLayout;
        this.f73855b = bLConstraintLayout;
        this.f73856c = bLConstraintLayout2;
        this.f73857d = bLConstraintLayout3;
        this.f73858e = bLConstraintLayout4;
        this.f73859f = bLConstraintLayout5;
        this.f73860g = imageView;
        this.f73861h = imageView2;
        this.f73862i = imageView3;
        this.f73863j = imageView4;
        this.f73864k = imageView5;
        this.f73865l = imageView6;
        this.f73866m = linearLayout;
        this.f73867n = recyclerView;
        this.f73868o = switchButton;
        this.f73869p = textView;
        this.f73870q = textView2;
        this.f73871r = textView3;
        this.f73872s = gradientTextView;
        this.f73873t = gradientTextView2;
        this.f73874u = gradientTextView3;
        this.f73875v = gradientTextView4;
        this.f73876w = gradientTextView5;
        this.f73877x = gradientTextView6;
        this.f73878y = textView4;
        this.f73879z = textView5;
    }

    public static g a(View view) {
        int i11 = R$id.clAutoplay;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) g4.b.a(view, i11);
        if (bLConstraintLayout != null) {
            i11 = R$id.clCleanMode;
            BLConstraintLayout bLConstraintLayout2 = (BLConstraintLayout) g4.b.a(view, i11);
            if (bLConstraintLayout2 != null) {
                i11 = R$id.clQuality;
                BLConstraintLayout bLConstraintLayout3 = (BLConstraintLayout) g4.b.a(view, i11);
                if (bLConstraintLayout3 != null) {
                    i11 = R$id.clSpeed;
                    BLConstraintLayout bLConstraintLayout4 = (BLConstraintLayout) g4.b.a(view, i11);
                    if (bLConstraintLayout4 != null) {
                        i11 = R$id.clSubtitle;
                        BLConstraintLayout bLConstraintLayout5 = (BLConstraintLayout) g4.b.a(view, i11);
                        if (bLConstraintLayout5 != null) {
                            i11 = R$id.ivAutoplayIcon;
                            ImageView imageView = (ImageView) g4.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.ivCleanModeIcon;
                                ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                                if (imageView2 != null) {
                                    i11 = R$id.ivQualityIcon;
                                    ImageView imageView3 = (ImageView) g4.b.a(view, i11);
                                    if (imageView3 != null) {
                                        i11 = R$id.ivSpeedIcon;
                                        ImageView imageView4 = (ImageView) g4.b.a(view, i11);
                                        if (imageView4 != null) {
                                            i11 = R$id.ivSubtitleArrow;
                                            ImageView imageView5 = (ImageView) g4.b.a(view, i11);
                                            if (imageView5 != null) {
                                                i11 = R$id.ivSubtitleIcon;
                                                ImageView imageView6 = (ImageView) g4.b.a(view, i11);
                                                if (imageView6 != null) {
                                                    i11 = R$id.llSpeedOptions;
                                                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                                    if (linearLayout != null) {
                                                        i11 = R$id.rvQuality;
                                                        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                        if (recyclerView != null) {
                                                            i11 = R$id.switchAutoplay;
                                                            SwitchButton switchButton = (SwitchButton) g4.b.a(view, i11);
                                                            if (switchButton != null) {
                                                                i11 = R$id.tvAutoplayTitle;
                                                                TextView textView = (TextView) g4.b.a(view, i11);
                                                                if (textView != null) {
                                                                    i11 = R$id.tvCleanModeTitle;
                                                                    TextView textView2 = (TextView) g4.b.a(view, i11);
                                                                    if (textView2 != null) {
                                                                        i11 = R$id.tvQualityTitle;
                                                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                                                        if (textView3 != null) {
                                                                            i11 = R$id.tvSpeed05;
                                                                            GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
                                                                            if (gradientTextView != null) {
                                                                                i11 = R$id.tvSpeed075;
                                                                                GradientTextView gradientTextView2 = (GradientTextView) g4.b.a(view, i11);
                                                                                if (gradientTextView2 != null) {
                                                                                    i11 = R$id.tvSpeed1;
                                                                                    GradientTextView gradientTextView3 = (GradientTextView) g4.b.a(view, i11);
                                                                                    if (gradientTextView3 != null) {
                                                                                        i11 = R$id.tvSpeed125;
                                                                                        GradientTextView gradientTextView4 = (GradientTextView) g4.b.a(view, i11);
                                                                                        if (gradientTextView4 != null) {
                                                                                            i11 = R$id.tvSpeed15;
                                                                                            GradientTextView gradientTextView5 = (GradientTextView) g4.b.a(view, i11);
                                                                                            if (gradientTextView5 != null) {
                                                                                                i11 = R$id.tvSpeed2;
                                                                                                GradientTextView gradientTextView6 = (GradientTextView) g4.b.a(view, i11);
                                                                                                if (gradientTextView6 != null) {
                                                                                                    i11 = R$id.tvSpeedTitle;
                                                                                                    TextView textView4 = (TextView) g4.b.a(view, i11);
                                                                                                    if (textView4 != null) {
                                                                                                        i11 = R$id.tvSubtitleTitle;
                                                                                                        TextView textView5 = (TextView) g4.b.a(view, i11);
                                                                                                        if (textView5 != null) {
                                                                                                            return new g((ConstraintLayout) view, bLConstraintLayout, bLConstraintLayout2, bLConstraintLayout3, bLConstraintLayout4, bLConstraintLayout5, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, recyclerView, switchButton, textView, textView2, textView3, gradientTextView, gradientTextView2, gradientTextView3, gradientTextView4, gradientTextView5, gradientTextView6, textView4, textView5);
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
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_imm_video_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73854a;
    }
}
