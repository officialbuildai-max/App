package com.transsion.usercenter.edit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class u {

    /* renamed from: b, reason: collision with root package name */
    public static final a f56849b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f56850c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.usercenter.edit.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            u b11;
            b11 = u.b();
            return b11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f56851a;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final u a() {
            return (u) u.f56850c.getValue();
        }
    }

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u b() {
        return new u();
    }

    public final Bitmap d() {
        return this.f56851a;
    }

    public final void e(Bitmap bitmap) {
        this.f56851a = bitmap;
    }

    public final void f(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Intrinsics.g(createBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            this.f56851a = createBitmap;
        } catch (Exception e11) {
            e11.getMessage();
        }
    }
}
