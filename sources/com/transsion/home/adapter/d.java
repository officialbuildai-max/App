package com.transsion.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.a0;
import com.blankj.utilcode.util.i;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.home.R$string;
import gl.j;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes5.dex */
public final class d extends j00.a {

    /* renamed from: b, reason: collision with root package name */
    private final j f44319b;

    /* loaded from: classes5.dex */
    public static final class a extends com.transsion.baseui.util.f {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f44321f;

        a(int i11) {
            this.f44321f = i11;
        }

        @Override // com.transsion.baseui.util.f
        public void c(View view) {
        }

        @Override // com.transsion.baseui.util.f
        public void d(View view) {
            MagicIndicator magicIndicator;
            ViewPager2 viewPager2;
            j jVar = d.this.f44319b;
            if (jVar != null && (viewPager2 = jVar.f63868k) != null) {
                viewPager2.setCurrentItem(this.f44321f, true);
            }
            j jVar2 = d.this.f44319b;
            if (jVar2 == null || (magicIndicator = jVar2.f63865h) == null) {
                return;
            }
            magicIndicator.onPageScrolled(this.f44321f, 0.0f, 0);
        }
    }

    public d(j jVar) {
        this.f44319b = jVar;
    }

    @Override // j00.a
    public int a() {
        return 2;
    }

    @Override // j00.a
    public j00.c b(Context context) {
        Intrinsics.h(context, "context");
        GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
        gradientLinePagerIndicator.setMode(2);
        gradientLinePagerIndicator.setLineHeight(i.e(3.0f));
        gradientLinePagerIndicator.setLineWidth(i.e(24.0f));
        gradientLinePagerIndicator.setRoundRadius(i.e(1.5f));
        gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
        gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        int color = androidx.core.content.b.getColor(context, R$color.transparent);
        gradientLinePagerIndicator.setColors(color, color, color);
        return gradientLinePagerIndicator;
    }

    @Override // j00.a
    public j00.d c(Context context, int i11) {
        Intrinsics.h(context, "context");
        CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context, 17, a0.a(10.0f));
        customPagerTitleView.setText(i11 != 0 ? i11 != 1 ? "default" : context.getResources().getString(R$string.music_tab_liked_music) : context.getResources().getString(R$string.music_tab_discover));
        customPagerTitleView.setTextSize(18.0f);
        customPagerTitleView.setOnClickListener(new a(i11));
        return customPagerTitleView;
    }
}
