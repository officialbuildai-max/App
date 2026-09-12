package fu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.view.SwitchButton;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.warkiz.widget.IndicatorSeekBar;

/* loaded from: classes7.dex */
public final class i implements g4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final BLTextView F;
    public final AppCompatTextView G;
    public final AppCompatTextView H;

    /* renamed from: a, reason: collision with root package name */
    private final View f62646a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f62647b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f62648c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f62649d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f62650e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f62651f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f62652g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f62653h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f62654i;

    /* renamed from: j, reason: collision with root package name */
    public final SecondariesSeekBar f62655j;

    /* renamed from: k, reason: collision with root package name */
    public final SecondariesSeekBar f62656k;

    /* renamed from: l, reason: collision with root package name */
    public final RadioButton f62657l;

    /* renamed from: m, reason: collision with root package name */
    public final RadioButton f62658m;

    /* renamed from: n, reason: collision with root package name */
    public final RadioButton f62659n;

    /* renamed from: o, reason: collision with root package name */
    public final RadioButton f62660o;

    /* renamed from: p, reason: collision with root package name */
    public final RadioButton f62661p;

    /* renamed from: q, reason: collision with root package name */
    public final RadioButton f62662q;

    /* renamed from: r, reason: collision with root package name */
    public final RadioButton f62663r;

    /* renamed from: s, reason: collision with root package name */
    public final RadioButton f62664s;

    /* renamed from: t, reason: collision with root package name */
    public final RadioGroup f62665t;

    /* renamed from: u, reason: collision with root package name */
    public final RadioGroup f62666u;

    /* renamed from: v, reason: collision with root package name */
    public final IndicatorSeekBar f62667v;

    /* renamed from: w, reason: collision with root package name */
    public final SecondariesSeekBar f62668w;

    /* renamed from: x, reason: collision with root package name */
    public final IndicatorSeekBar f62669x;

    /* renamed from: y, reason: collision with root package name */
    public final SwitchButton f62670y;

    /* renamed from: z, reason: collision with root package name */
    public final SwitchButton f62671z;

    private i(View view, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, SecondariesSeekBar secondariesSeekBar, SecondariesSeekBar secondariesSeekBar2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioGroup radioGroup, RadioGroup radioGroup2, IndicatorSeekBar indicatorSeekBar, SecondariesSeekBar secondariesSeekBar3, IndicatorSeekBar indicatorSeekBar2, SwitchButton switchButton, SwitchButton switchButton2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7) {
        this.f62646a = view;
        this.f62647b = group;
        this.f62648c = appCompatImageView;
        this.f62649d = appCompatImageView2;
        this.f62650e = appCompatImageView3;
        this.f62651f = appCompatImageView4;
        this.f62652g = appCompatImageView5;
        this.f62653h = appCompatImageView6;
        this.f62654i = appCompatImageView7;
        this.f62655j = secondariesSeekBar;
        this.f62656k = secondariesSeekBar2;
        this.f62657l = radioButton;
        this.f62658m = radioButton2;
        this.f62659n = radioButton3;
        this.f62660o = radioButton4;
        this.f62661p = radioButton5;
        this.f62662q = radioButton6;
        this.f62663r = radioButton7;
        this.f62664s = radioButton8;
        this.f62665t = radioGroup;
        this.f62666u = radioGroup2;
        this.f62667v = indicatorSeekBar;
        this.f62668w = secondariesSeekBar3;
        this.f62669x = indicatorSeekBar2;
        this.f62670y = switchButton;
        this.f62671z = switchButton2;
        this.A = appCompatTextView;
        this.B = appCompatTextView2;
        this.C = appCompatTextView3;
        this.D = appCompatTextView4;
        this.E = appCompatTextView5;
        this.F = bLTextView;
        this.G = appCompatTextView6;
        this.H = appCompatTextView7;
    }

    public static i a(View view) {
        int i11 = R$id.group_background;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.ivBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_background_add;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_background_minus;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.iv_font_size_add;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView4 != null) {
                            i11 = R$id.iv_font_size_minus;
                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView5 != null) {
                                i11 = R$id.iv_position_down;
                                AppCompatImageView appCompatImageView6 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView6 != null) {
                                    i11 = R$id.iv_position_up;
                                    AppCompatImageView appCompatImageView7 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView7 != null) {
                                        i11 = R$id.progress_bar_background;
                                        SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) g4.b.a(view, i11);
                                        if (secondariesSeekBar != null) {
                                            i11 = R$id.progress_bar_font_size;
                                            SecondariesSeekBar secondariesSeekBar2 = (SecondariesSeekBar) g4.b.a(view, i11);
                                            if (secondariesSeekBar2 != null) {
                                                i11 = R$id.rb_background_black;
                                                RadioButton radioButton = (RadioButton) g4.b.a(view, i11);
                                                if (radioButton != null) {
                                                    i11 = R$id.rb_background_green;
                                                    RadioButton radioButton2 = (RadioButton) g4.b.a(view, i11);
                                                    if (radioButton2 != null) {
                                                        i11 = R$id.rb_background_white;
                                                        RadioButton radioButton3 = (RadioButton) g4.b.a(view, i11);
                                                        if (radioButton3 != null) {
                                                            i11 = R$id.rb_background_yellor;
                                                            RadioButton radioButton4 = (RadioButton) g4.b.a(view, i11);
                                                            if (radioButton4 != null) {
                                                                i11 = R$id.rb_font_color_black;
                                                                RadioButton radioButton5 = (RadioButton) g4.b.a(view, i11);
                                                                if (radioButton5 != null) {
                                                                    i11 = R$id.rb_font_color_green;
                                                                    RadioButton radioButton6 = (RadioButton) g4.b.a(view, i11);
                                                                    if (radioButton6 != null) {
                                                                        i11 = R$id.rb_font_color_white;
                                                                        RadioButton radioButton7 = (RadioButton) g4.b.a(view, i11);
                                                                        if (radioButton7 != null) {
                                                                            i11 = R$id.rb_font_color_yellor;
                                                                            RadioButton radioButton8 = (RadioButton) g4.b.a(view, i11);
                                                                            if (radioButton8 != null) {
                                                                                i11 = R$id.rg_background;
                                                                                RadioGroup radioGroup = (RadioGroup) g4.b.a(view, i11);
                                                                                if (radioGroup != null) {
                                                                                    i11 = R$id.rg_font_color;
                                                                                    RadioGroup radioGroup2 = (RadioGroup) g4.b.a(view, i11);
                                                                                    if (radioGroup2 != null) {
                                                                                        i11 = R$id.seek_bar_font_size;
                                                                                        IndicatorSeekBar indicatorSeekBar = (IndicatorSeekBar) g4.b.a(view, i11);
                                                                                        if (indicatorSeekBar != null) {
                                                                                            i11 = R$id.seek_bar_position;
                                                                                            SecondariesSeekBar secondariesSeekBar3 = (SecondariesSeekBar) g4.b.a(view, i11);
                                                                                            if (secondariesSeekBar3 != null) {
                                                                                                i11 = R$id.seek_bart_background;
                                                                                                IndicatorSeekBar indicatorSeekBar2 = (IndicatorSeekBar) g4.b.a(view, i11);
                                                                                                if (indicatorSeekBar2 != null) {
                                                                                                    i11 = R$id.switch_background;
                                                                                                    SwitchButton switchButton = (SwitchButton) g4.b.a(view, i11);
                                                                                                    if (switchButton != null) {
                                                                                                        i11 = R$id.switch_shadow;
                                                                                                        SwitchButton switchButton2 = (SwitchButton) g4.b.a(view, i11);
                                                                                                        if (switchButton2 != null) {
                                                                                                            i11 = R$id.tv_background_opacity_title;
                                                                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                            if (appCompatTextView != null) {
                                                                                                                i11 = R$id.tv_background_title;
                                                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                if (appCompatTextView2 != null) {
                                                                                                                    i11 = R$id.tvFontColorTitle;
                                                                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                    if (appCompatTextView3 != null) {
                                                                                                                        i11 = R$id.tv_font_size_title;
                                                                                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                        if (appCompatTextView4 != null) {
                                                                                                                            i11 = R$id.tv_position_title;
                                                                                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                            if (appCompatTextView5 != null) {
                                                                                                                                i11 = R$id.tv_reset;
                                                                                                                                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                                                                                                                                if (bLTextView != null) {
                                                                                                                                    i11 = R$id.tv_shadow_title;
                                                                                                                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                                    if (appCompatTextView6 != null) {
                                                                                                                                        i11 = R$id.tvStyle;
                                                                                                                                        AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                                                        if (appCompatTextView7 != null) {
                                                                                                                                            return new i(view, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, appCompatImageView6, appCompatImageView7, secondariesSeekBar, secondariesSeekBar2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioGroup, radioGroup2, indicatorSeekBar, secondariesSeekBar3, indicatorSeekBar2, switchButton, switchButton2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, bLTextView, appCompatTextView6, appCompatTextView7);
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

    public static i b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_subtitle_options, viewGroup);
        return a(viewGroup);
    }

    @Override // g4.a
    public View getRoot() {
        return this.f62646a;
    }
}
