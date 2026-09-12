package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.b0;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f2082b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    private static f f2083c;

    /* renamed from: a, reason: collision with root package name */
    private b0 f2084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b0.f {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f2085a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        private final int[] f2086b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        private final int[] f2087c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        private final int[] f2088d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        private final int[] f2089e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        private final int[] f2090f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i11) {
            for (int i12 : iArr) {
                if (i12 == i11) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i11) {
            int c11 = f0.c(context, R$attr.colorControlHighlight);
            return new ColorStateList(new int[][]{f0.f2092b, f0.f2095e, f0.f2093c, f0.f2099i}, new int[]{f0.b(context, R$attr.colorButtonNormal), z0.b.k(c11, i11), z0.b.k(c11, i11), i11});
        }

        private ColorStateList i(Context context) {
            return h(context, f0.c(context, R$attr.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, f0.c(context, R$attr.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList e11 = f0.e(context, R$attr.colorSwitchThumbNormal);
            if (e11 == null || !e11.isStateful()) {
                iArr[0] = f0.f2092b;
                iArr2[0] = f0.b(context, R$attr.colorSwitchThumbNormal);
                iArr[1] = f0.f2096f;
                iArr2[1] = f0.c(context, R$attr.colorControlActivated);
                iArr[2] = f0.f2099i;
                iArr2[2] = f0.c(context, R$attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = f0.f2092b;
                iArr[0] = iArr3;
                iArr2[0] = e11.getColorForState(iArr3, 0);
                iArr[1] = f0.f2096f;
                iArr2[1] = f0.c(context, R$attr.colorControlActivated);
                iArr[2] = f0.f2099i;
                iArr2[2] = e11.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(b0 b0Var, Context context, int i11) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i11);
            Drawable j11 = b0Var.j(context, R$drawable.abc_star_black_48dp);
            Drawable j12 = b0Var.j(context, R$drawable.abc_star_half_black_48dp);
            if ((j11 instanceof BitmapDrawable) && j11.getIntrinsicWidth() == dimensionPixelSize && j11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) j11;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j11.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((j12 instanceof BitmapDrawable) && j12.getIntrinsicWidth() == dimensionPixelSize && j12.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j12;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j12.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j12.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i11, PorterDuff.Mode mode) {
            Drawable mutate = drawable.mutate();
            if (mode == null) {
                mode = f.f2082b;
            }
            mutate.setColorFilter(f.e(i11, mode));
        }

        @Override // androidx.appcompat.widget.b0.f
        public Drawable a(b0 b0Var, Context context, int i11) {
            if (i11 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{b0Var.j(context, R$drawable.abc_cab_background_internal_bg), b0Var.j(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i11 == R$drawable.abc_ratingbar_material) {
                return l(b0Var, context, R$dimen.abc_star_big);
            }
            if (i11 == R$drawable.abc_ratingbar_indicator_material) {
                return l(b0Var, context, R$dimen.abc_star_medium);
            }
            if (i11 == R$drawable.abc_ratingbar_small_material) {
                return l(b0Var, context, R$dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.b0.f
        public ColorStateList b(Context context, int i11) {
            if (i11 == R$drawable.abc_edit_text_material) {
                return g.a.a(context, R$color.abc_tint_edittext);
            }
            if (i11 == R$drawable.abc_switch_track_mtrl_alpha) {
                return g.a.a(context, R$color.abc_tint_switch_track);
            }
            if (i11 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i11 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i11 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i11 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i11 == R$drawable.abc_spinner_mtrl_am_alpha || i11 == R$drawable.abc_spinner_textfield_background_material) {
                return g.a.a(context, R$color.abc_tint_spinner);
            }
            if (f(this.f2086b, i11)) {
                return f0.e(context, R$attr.colorControlNormal);
            }
            if (f(this.f2089e, i11)) {
                return g.a.a(context, R$color.abc_tint_default);
            }
            if (f(this.f2090f, i11)) {
                return g.a.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i11 == R$drawable.abc_seekbar_thumb_material) {
                return g.a.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0051  */
        @Override // androidx.appcompat.widget.b0.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
            /*
                r7 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.f.a()
                int[] r1 = r7.f2085a
                boolean r1 = r7.f(r1, r9)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r9 = androidx.appcompat.R$attr.colorControlNormal
            L11:
                r1 = r0
                r5 = r2
            L13:
                r0 = r4
                goto L4f
            L15:
                int[] r1 = r7.f2087c
                boolean r1 = r7.f(r1, r9)
                if (r1 == 0) goto L20
                int r9 = androidx.appcompat.R$attr.colorControlActivated
                goto L11
            L20:
                int[] r1 = r7.f2088d
                boolean r1 = r7.f(r1, r9)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r0 = r4
                r9 = r5
                r5 = r2
                goto L4f
            L32:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r9 != r1) goto L46
                r9 = 1109603123(0x42233333, float:40.8)
                int r9 = java.lang.Math.round(r9)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r5 = r2
                r6 = r0
                r0 = r9
                r9 = r1
                r1 = r6
                goto L4f
            L46:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r9 != r1) goto L4b
                goto L2d
            L4b:
                r1 = r0
                r9 = r3
                r5 = r9
                goto L13
            L4f:
                if (r5 == 0) goto L66
                android.graphics.drawable.Drawable r10 = r10.mutate()
                int r8 = androidx.appcompat.widget.f0.c(r8, r9)
                android.graphics.PorterDuffColorFilter r8 = androidx.appcompat.widget.f.e(r8, r1)
                r10.setColorFilter(r8)
                if (r0 == r4) goto L65
                r10.setAlpha(r0)
            L65:
                return r2
            L66:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f.a.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.b0.f
        public PorterDuff.Mode d(int i11) {
            if (i11 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.b0.f
        public boolean e(Context context, int i11, Drawable drawable) {
            if (i11 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(R.id.background), f0.c(context, R$attr.colorControlNormal), f.f2082b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), f0.c(context, R$attr.colorControlNormal), f.f2082b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), f0.c(context, R$attr.colorControlActivated), f.f2082b);
                return true;
            }
            if (i11 != R$drawable.abc_ratingbar_material && i11 != R$drawable.abc_ratingbar_indicator_material && i11 != R$drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), f0.b(context, R$attr.colorControlNormal), f.f2082b);
            m(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), f0.c(context, R$attr.colorControlActivated), f.f2082b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), f0.c(context, R$attr.colorControlActivated), f.f2082b);
            return true;
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f2083c == null) {
                    h();
                }
                fVar = f2083c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    public static synchronized PorterDuffColorFilter e(int i11, PorterDuff.Mode mode) {
        PorterDuffColorFilter l11;
        synchronized (f.class) {
            l11 = b0.l(i11, mode);
        }
        return l11;
    }

    public static synchronized void h() {
        synchronized (f.class) {
            if (f2083c == null) {
                f fVar = new f();
                f2083c = fVar;
                fVar.f2084a = b0.h();
                f2083c.f2084a.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, h0 h0Var, int[] iArr) {
        b0.w(drawable, h0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i11) {
        return this.f2084a.j(context, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i11, boolean z10) {
        return this.f2084a.k(context, i11, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i11) {
        return this.f2084a.m(context, i11);
    }

    public synchronized void g(Context context) {
        this.f2084a.s(context);
    }
}
