package com.transsion.room.helper;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.transsion.room.R$layout;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f51689a = new n();

    private n() {
    }

    private final ObjectAnimator b(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -dk.a.b(12));
        ofFloat.setDuration(500L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        Intrinsics.g(ofFloat, "apply(...)");
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ObjectAnimator objectAnimator, FrameLayout frameLayout, View view) {
        try {
            Result.Companion companion = Result.INSTANCE;
            objectAnimator.cancel();
            frameLayout.removeView(view);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void c(Activity activity) {
        Intrinsics.h(activity, "activity");
        final FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
        final View inflate = LayoutInflater.from(activity).inflate(R$layout.layout_room_tab_refresh, (ViewGroup) null);
        Intrinsics.e(inflate);
        final ObjectAnimator b11 = b(inflate);
        b11.start();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = dk.a.b(80);
        frameLayout.addView(inflate, layoutParams);
        hj.i.f64628a.D("room_home", MapsKt.m(TuplesKt.a("opt_type", "refresh_float")));
        frameLayout.postDelayed(new Runnable() { // from class: com.transsion.room.helper.m
            @Override // java.lang.Runnable
            public final void run() {
                n.d(b11, frameLayout, inflate);
            }
        }, 3000L);
    }
}
