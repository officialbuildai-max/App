package com.transsion.subtitle.helper;

import android.content.Context;
import android.view.ViewGroup;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.y;
import com.tn.lib.widget.R$color;
import com.transsion.subtitle.R$id;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: n, reason: collision with root package name */
    public static final a f55024n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Context f55025a;

    /* renamed from: b, reason: collision with root package name */
    private final int f55026b;

    /* renamed from: c, reason: collision with root package name */
    private final int f55027c;

    /* renamed from: d, reason: collision with root package name */
    private final int f55028d;

    /* renamed from: e, reason: collision with root package name */
    private final int f55029e;

    /* renamed from: f, reason: collision with root package name */
    private final int f55030f;

    /* renamed from: g, reason: collision with root package name */
    private final int f55031g;

    /* renamed from: h, reason: collision with root package name */
    private final int f55032h;

    /* renamed from: i, reason: collision with root package name */
    private final int f55033i;

    /* renamed from: j, reason: collision with root package name */
    private final int f55034j;

    /* renamed from: k, reason: collision with root package name */
    private final int f55035k;

    /* renamed from: l, reason: collision with root package name */
    private final int f55036l;

    /* renamed from: m, reason: collision with root package name */
    private final int f55037m;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55038a;

        static {
            int[] iArr = new int[LocalVideoUiType.values().length];
            try {
                iArr[LocalVideoUiType.MIDDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalVideoUiType.LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalVideoUiType.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f55038a = iArr;
        }
    }

    public f(Context context) {
        Intrinsics.h(context, "context");
        this.f55025a = context;
        this.f55030f = a0.a(66.0f);
        this.f55031g = a0.a(24.0f);
        this.f55032h = a0.a(24.0f);
        this.f55033i = a0.a(68.0f);
        this.f55034j = y.e();
        int c11 = y.c();
        this.f55035k = c11;
        int c12 = com.blankj.utilcode.util.d.c();
        this.f55036l = c12;
        this.f55037m = c11 - c12;
        this.f55026b = androidx.core.content.b.getColor(context, R$color.black);
        this.f55027c = androidx.core.content.b.getColor(context, R$color.white);
        this.f55028d = androidx.core.content.b.getColor(context, com.transsion.subtitle.R$color.subtitle_color_yellow);
        this.f55029e = androidx.core.content.b.getColor(context, com.transsion.subtitle.R$color.subtitle_color_green);
    }

    public final String a(int i11) {
        return i11 == R$id.rb_background_black ? "color_black" : i11 == R$id.rb_background_white ? "color_white" : i11 == R$id.rb_background_yellor ? "color_yellow" : i11 == R$id.rb_background_green ? "color_green" : "color_black";
    }

    public final int b(String bgColorType) {
        Intrinsics.h(bgColorType, "bgColorType");
        switch (bgColorType.hashCode()) {
            case -1720275760:
                if (bgColorType.equals("color_yellow")) {
                    return R$id.rb_background_yellor;
                }
                break;
            case 1308937251:
                if (bgColorType.equals("color_black")) {
                    return R$id.rb_background_black;
                }
                break;
            case 1313737511:
                if (bgColorType.equals("color_green")) {
                    return R$id.rb_background_green;
                }
                break;
            case 1328220237:
                if (bgColorType.equals("color_white")) {
                    return R$id.rb_background_white;
                }
                break;
        }
        return R$id.rb_background_white;
    }

    public final float c(int i11) {
        if (i11 == 0) {
            return 0.1f;
        }
        if (i11 == 1) {
            return 0.25f;
        }
        if (i11 != 2) {
            return (i11 == 3 || i11 != 4) ? 0.75f : 1.0f;
        }
        return 0.5f;
    }

    public final int d(String colorType) {
        Intrinsics.h(colorType, "colorType");
        switch (colorType.hashCode()) {
            case -1720275760:
                if (colorType.equals("color_yellow")) {
                    return this.f55028d;
                }
                break;
            case 1308937251:
                if (colorType.equals("color_black")) {
                    return this.f55026b;
                }
                break;
            case 1313737511:
                if (colorType.equals("color_green")) {
                    return this.f55029e;
                }
                break;
            case 1328220237:
                if (colorType.equals("color_white")) {
                    return this.f55027c;
                }
                break;
        }
        return this.f55027c;
    }

    public final String e(int i11) {
        if (i11 == R$id.rb_font_color_black) {
            return "color_black";
        }
        if (i11 != R$id.rb_font_color_white) {
            if (i11 == R$id.rb_font_color_yellor) {
                return "color_yellow";
            }
            if (i11 == R$id.rb_font_color_green) {
                return "color_green";
            }
        }
        return "color_white";
    }

    public final int f(String fontColorType) {
        Intrinsics.h(fontColorType, "fontColorType");
        switch (fontColorType.hashCode()) {
            case -1720275760:
                if (fontColorType.equals("color_yellow")) {
                    return R$id.rb_font_color_yellor;
                }
                break;
            case 1308937251:
                if (fontColorType.equals("color_black")) {
                    return R$id.rb_font_color_black;
                }
                break;
            case 1313737511:
                if (fontColorType.equals("color_green")) {
                    return R$id.rb_font_color_green;
                }
                break;
            case 1328220237:
                if (fontColorType.equals("color_white")) {
                    return R$id.rb_font_color_white;
                }
                break;
        }
        return R$id.rb_font_color_white;
    }

    public final float g(int i11) {
        switch (i11) {
            case 0:
                return 0.5f;
            case 1:
                return 0.75f;
            case 2:
            default:
                return 1.0f;
            case 3:
                return 1.5f;
            case 4:
                return 2.0f;
            case 5:
                return 3.0f;
            case 6:
                return 4.0f;
        }
    }

    public final int h(LocalVideoUiType uiType) {
        Intrinsics.h(uiType, "uiType");
        y.c();
        int i11 = b.f55038a[uiType.ordinal()];
        if (i11 == 1) {
            return (this.f55034j * 9) / 16;
        }
        if (i11 == 2) {
            return this.f55034j;
        }
        if (i11 == 3) {
            return this.f55035k;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void i(SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, LocalVideoUiType uiType, ViewGroup viewGroup) {
        Intrinsics.h(uiType, "uiType");
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("subtitle_options_font_color", "color_white");
        String str = string != null ? string : "color_white";
        int d11 = d(str);
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextColor(d11);
        }
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextColor(d11);
        }
        float g11 = g(bVar.b().getInt("subtitle_options_font_size_progress", 2));
        int i11 = com.transsion.baseui.util.b.a(this.f55025a) ? uiType == LocalVideoUiType.MIDDLE ? 18 : 30 : uiType == LocalVideoUiType.MIDDLE ? 12 : 20;
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setTextSize(i11 * g11);
        }
        if (simpleSubtitleView2 != null) {
            simpleSubtitleView2.setTextSize(i11 * g11);
        }
        int i12 = bVar.b().getInt("subtitle_options_position", 10);
        j(uiType, viewGroup, i12);
        boolean z10 = bVar.b().getBoolean("subtitle_options_shadow_enabled", true);
        if (z10) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(1.0f, 3.0f, 2.0f, androidx.core.content.b.getColor(simpleSubtitleView.getContext(), R$color.black_90));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(1.0f, 3.0f, 2.0f, androidx.core.content.b.getColor(simpleSubtitleView2.getContext(), R$color.black_90));
            }
        } else {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        boolean z11 = bVar.b().getBoolean("subtitle_options_bg_enabled", false);
        String string2 = bVar.b().getString("subtitle_options_bg_color", "color_black");
        String str2 = string2 != null ? string2 : "color_black";
        int i13 = bVar.b().getInt("subtitle_options_bg_opacity_progress", 3);
        if (z11) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.openBg();
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.openBg();
            }
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgdRadius(a0.a(4.0f));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgdRadius(a0.a(4.0f));
            }
            int d12 = d(str2);
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgColor(d12);
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgColor(d12);
            }
            float c11 = c(i13);
            if (simpleSubtitleView != null) {
                simpleSubtitleView.setBgAlpha((int) (255 * c11));
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setBgAlpha((int) (255 * c11));
            }
        } else {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.closeBg();
            }
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.closeBg();
            }
        }
        a.C0856a.v(lg.a.f68962a, "SubtitleOptionsView", StringsKt.n("\n            initSubtitleOptions, fontColorType= " + str + "， fontSizePercent = " + g11 + "\n                positionPercent = " + i12 + ", openShadow =" + z10 + "\n                openBackground = " + z11 + ", bgColorType = " + str2 + ", bgOpacityProgress = " + i13 + "\n        "), false, 4, null);
    }

    public final void j(LocalVideoUiType uiType, ViewGroup viewGroup, int i11) {
        Intrinsics.h(uiType, "uiType");
        int h11 = h(uiType);
        int a11 = a0.a(40.0f);
        int i12 = h11 - a11;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i13 = (i11 * i12) / 100;
        if (i13 >= 0) {
            if (i13 > i12 - a11) {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = i12 - a0.a(40.0f);
                }
            } else if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = i13;
            }
            int height = viewGroup != null ? viewGroup.getHeight() : 0;
            if ((marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0) + height > h11 && marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = h11 - height;
            }
        }
        if (viewGroup != null) {
            viewGroup.requestLayout();
        }
    }
}
