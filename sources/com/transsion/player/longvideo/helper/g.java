package com.transsion.player.longvideo.helper;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import fo.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g extends d {

    /* renamed from: d, reason: collision with root package name */
    private boolean f48046d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(g gVar, ho.j jVar, View view) {
        gVar.f48046d = true;
        FrameLayout gameContainer = jVar.f64741h.f64765g;
        Intrinsics.g(gameContainer, "gameContainer");
        jg.c.g(gameContainer);
        AppCompatImageView ivGameClose = jVar.f64741h.f64768j;
        Intrinsics.g(ivGameClose, "ivGameClose");
        jg.c.g(ivGameClose);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(g gVar) {
        ho.k kVar;
        AppCompatImageView appCompatImageView;
        ho.j b11 = gVar.b();
        if (b11 == null || (kVar = b11.f64741h) == null || (appCompatImageView = kVar.f64768j) == null) {
            return;
        }
        jg.c.k(appCompatImageView);
    }

    @Override // com.transsion.player.longvideo.helper.d
    public void c(String str, final ho.j viewBinding) {
        Intrinsics.h(viewBinding, "viewBinding");
        super.c(str, viewBinding);
        viewBinding.f64741h.f64768j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.g(g.this, viewBinding, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(LongVodUiType uiType) {
        a.b a11;
        View e11;
        ho.k kVar;
        FrameLayout frameLayout;
        ho.k kVar2;
        FrameLayout frameLayout2;
        ho.k kVar3;
        FrameLayout frameLayout3;
        ho.k kVar4;
        AppCompatImageView appCompatImageView;
        ho.k kVar5;
        FrameLayout frameLayout4;
        Intrinsics.h(uiType, "uiType");
        a.b a12 = a();
        if (a12 != null) {
            a12.d(uiType);
        }
        if (uiType == LongVodUiType.MIDDLE || this.f48046d || (a11 = a()) == null || (e11 = a11.e()) == 0) {
            return;
        }
        ViewParent parent = e11.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(e11);
        }
        ok.a aVar = e11 instanceof ok.a ? (ok.a) e11 : null;
        if (aVar != null) {
            aVar.setPageStyle("fullscreen");
        }
        ho.j b11 = b();
        if (b11 != null && (kVar5 = b11.f64741h) != null && (frameLayout4 = kVar5.f64765g) != null) {
            jg.c.k(frameLayout4);
        }
        ho.j b12 = b();
        if (b12 != null && (kVar4 = b12.f64741h) != null && (appCompatImageView = kVar4.f64768j) != null) {
            jg.c.g(appCompatImageView);
        }
        ho.j b13 = b();
        if (b13 != null && (kVar3 = b13.f64741h) != null && (frameLayout3 = kVar3.f64765g) != null) {
            frameLayout3.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.i(g.this);
                }
            }, 3000L);
        }
        ho.j b14 = b();
        if (b14 != null && (kVar2 = b14.f64741h) != null && (frameLayout2 = kVar2.f64765g) != null) {
            frameLayout2.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ho.j b15 = b();
        if (b15 == null || (kVar = b15.f64741h) == null || (frameLayout = kVar.f64765g) == null) {
            return;
        }
        frameLayout.addView(e11, layoutParams);
    }
}
