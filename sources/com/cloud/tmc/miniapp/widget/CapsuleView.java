package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.cloud.tmc.integration.utils.FastClickUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniutils.util.SystemUtils;
import com.cloud.tmc.miniutils.util.ViewUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CapsuleView extends LinearLayoutCompat {
    public final Lazy OooO;
    public final HashMap<Integer, HashMap<Integer, Integer>> OooO00o;
    public final HashMap<Integer, HashMap<Integer, Integer>> OooO0O0;
    public final HashMap<Integer, Integer> OooO0OO;
    public final HashMap<Integer, Integer> OooO0Oo;
    public Function0<Unit> OooO0o;
    public Function0<Unit> OooO0o0;
    public final Lazy OooO0oO;
    public final Lazy OooO0oo;
    public final Lazy OooOO0;
    public HashMap<Integer, HashMap<Integer, Integer>> OooOO0O;

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function0<AppCompatImageView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (AppCompatImageView) CapsuleView.this.findViewById(R.id.iv_left);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o implements ImageLoadCallback<Drawable> {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadFailed(String str) {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadSuccess(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 != null) {
                CapsuleView.this.getIvLeft().setForeground(drawable2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 implements ImageLoadCallback<Drawable> {
        public OooO0O0() {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadFailed(String str) {
        }

        @Override // com.cloud.tmc.kernel.proxy.imageloader.ImageLoadCallback
        public void onLoadSuccess(Drawable drawable) {
            Drawable drawable2 = drawable;
            if (drawable2 != null) {
                CapsuleView.this.getIvRight().setForeground(drawable2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function0<LinearLayoutCompat> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (LinearLayoutCompat) CapsuleView.this.findViewById(R.id.capsule_layout);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o extends Lambda implements Function0<View> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return CapsuleView.this.findViewById(R.id.view_center_line);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (AppCompatImageView) CapsuleView.this.findViewById(R.id.iv_right);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapsuleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.h(context, "context");
        HashMap<Integer, HashMap<Integer, Integer>> j11 = MapsKt.j(TuplesKt.a(0, MapsKt.j(TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_title_more_white_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_title_close_white_mode)))), TuplesKt.a(1, MapsKt.j(TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_title_more_black_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_title_close_black_mode)))));
        this.OooO00o = j11;
        HashMap<Integer, HashMap<Integer, Integer>> j12 = MapsKt.j(TuplesKt.a(0, MapsKt.j(TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_title_back_white_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_title_home_white_mode)))), TuplesKt.a(1, MapsKt.j(TuplesKt.a(Integer.valueOf(R.id.iv_left), Integer.valueOf(R.drawable.mini_ic_immersive_title_bar_back_black_mode)), TuplesKt.a(Integer.valueOf(R.id.iv_right), Integer.valueOf(R.drawable.mini_ic_immersive_title_bar_home_black_mode)))));
        this.OooO0O0 = j12;
        this.OooO0OO = MapsKt.j(TuplesKt.a(0, Integer.valueOf(R.color.mini_color_capsule_line_white_mode_bg)), TuplesKt.a(1, Integer.valueOf(R.color.mini_color_border_capsule)));
        this.OooO0Oo = MapsKt.j(TuplesKt.a(0, Integer.valueOf(R.drawable.shape_bg_capsule_white_mode)), TuplesKt.a(1, Integer.valueOf(R.drawable.shape_bg_capsule_black_mode)));
        this.OooO0oO = LazyKt.b(new OooO0OO());
        this.OooO0oo = LazyKt.b(new OooO());
        this.OooO = LazyKt.b(new OooO0o());
        this.OooOO0 = LazyKt.b(new OooOO0());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Mini_CapsuleView);
        Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…yleable.Mini_CapsuleView)");
        int i11 = obtainStyledAttributes.getInt(R.styleable.Mini_CapsuleView_capsule_style, 0);
        if (i11 != 1 && i11 == 2) {
            j11 = j12;
        }
        this.OooOO0O = j11;
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.layout_mini_capsule, this);
        if (!isInEditMode()) {
            getIvLeft().setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
            getIvRight().setRotationY(ViewUtils.isLayoutRtl() ? 180.0f : 0.0f);
        }
        getIvLeft().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CapsuleView.OooO00o(CapsuleView.this, view);
            }
        });
        getIvRight().setOnClickListener(new View.OnClickListener() { // from class: com.cloud.tmc.miniapp.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CapsuleView.OooO0O0(CapsuleView.this, view);
            }
        });
        int i12 = !SystemUtils.darkThemeIsEnabled(context) ? 1 : 0;
        try {
            ImageLoaderProxy imageLoaderProxy = (ImageLoaderProxy) TmcProxy.get(ImageLoaderProxy.class);
            imageLoaderProxy.loadImg(context, R.drawable.shape_fg_capsule_left_click, 0, getIvLeft(), new OooO00o());
            imageLoaderProxy.loadImg(context, R.drawable.shape_fg_capsule_right_click, 0, getIvRight(), new OooO0O0());
        } catch (Throwable th2) {
            TmcLogger.e("", th2);
        }
        OooO00o(this, i12, null, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: all -> 0x0058, TryCatch #1 {all -> 0x0058, blocks: (B:46:0x0049, B:15:0x005e, B:17:0x0064, B:44:0x0070, B:14:0x005a), top: B:45:0x0049, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[Catch: all -> 0x008c, TryCatch #3 {all -> 0x008c, blocks: (B:38:0x007d, B:20:0x0092, B:22:0x0098, B:36:0x00a4, B:19:0x008e), top: B:37:0x007d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6 A[Catch: all -> 0x00cb, TryCatch #2 {all -> 0x00cb, blocks: (B:24:0x00b4, B:26:0x00c6, B:27:0x00cf, B:31:0x00cd), top: B:23:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[Catch: all -> 0x00cb, TryCatch #2 {all -> 0x00cb, blocks: (B:24:0x00b4, B:26:0x00c6, B:27:0x00cf, B:31:0x00cd), top: B:23:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4 A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #3 {all -> 0x008c, blocks: (B:38:0x007d, B:20:0x0092, B:22:0x0098, B:36:0x00a4, B:19:0x008e), top: B:37:0x007d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #1 {all -> 0x0058, blocks: (B:46:0x0049, B:15:0x005e, B:17:0x0064, B:44:0x0070, B:14:0x005a), top: B:45:0x0049, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void OooO00o(com.cloud.tmc.miniapp.widget.CapsuleView r5, int r6, java.util.HashMap r7, int r8) {
        /*
            java.lang.String r7 = ""
            r8 = r8 & 2
            if (r8 == 0) goto L9
            java.util.HashMap<java.lang.Integer, java.util.HashMap<java.lang.Integer, java.lang.Integer>> r8 = r5.OooOO0O
            goto La
        L9:
            r8 = 0
        La:
            r5.getClass()
            java.lang.String r0 = "style"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.Integer r0 = com.cloud.tmc.integration.utils.MiniAppConfigUtils.getTitleBarNodeMode()
            if (r0 != 0) goto L1d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L21
        L1d:
            java.lang.Integer r6 = com.cloud.tmc.integration.utils.MiniAppConfigUtils.getTitleBarNodeMode()
        L21:
            androidx.appcompat.widget.LinearLayoutCompat r0 = r5.getCapsuleLayout()
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r1 = r5.OooO0Oo
            java.lang.Object r1 = r1.get(r6)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r2 = 0
            if (r1 == 0) goto L35
            int r1 = r1.intValue()
            goto L36
        L35:
            r1 = r2
        L36:
            r0.setBackgroundResource(r1)
            java.lang.Object r8 = r8.get(r6)
            java.util.HashMap r8 = (java.util.HashMap) r8
            java.lang.Class<com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy> r0 = com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)     // Catch: java.lang.Throwable -> Lb0
            com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy r0 = (com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy) r0     // Catch: java.lang.Throwable -> Lb0
            if (r8 == 0) goto L5a
            int r1 = com.cloud.tmc.miniapp.R.id.iv_left     // Catch: java.lang.Throwable -> L58
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L58
            java.lang.Object r1 = r8.get(r1)     // Catch: java.lang.Throwable -> L58
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L5e
            goto L5a
        L58:
            r1 = move-exception
            goto L78
        L5a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L58
        L5e:
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L70
            android.content.Context r3 = r5.getContext()     // Catch: java.lang.Throwable -> L58
            androidx.appcompat.widget.AppCompatImageView r4 = r5.getIvLeft()     // Catch: java.lang.Throwable -> L58
            r0.loadImg(r3, r1, r1, r4)     // Catch: java.lang.Throwable -> L58
            goto L7b
        L70:
            androidx.appcompat.widget.AppCompatImageView r3 = r5.getIvLeft()     // Catch: java.lang.Throwable -> L58
            r3.setImageResource(r1)     // Catch: java.lang.Throwable -> L58
            goto L7b
        L78:
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r1)     // Catch: java.lang.Throwable -> Lb0
        L7b:
            if (r8 == 0) goto L8e
            int r1 = com.cloud.tmc.miniapp.R.id.iv_right     // Catch: java.lang.Throwable -> L8c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r8 = r8.get(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.Throwable -> L8c
            if (r8 != 0) goto L92
            goto L8e
        L8c:
            r8 = move-exception
            goto Lac
        L8e:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L8c
        L92:
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L8c
            if (r8 == 0) goto La4
            android.content.Context r1 = r5.getContext()     // Catch: java.lang.Throwable -> L8c
            androidx.appcompat.widget.AppCompatImageView r2 = r5.getIvRight()     // Catch: java.lang.Throwable -> L8c
            r0.loadImg(r1, r8, r8, r2)     // Catch: java.lang.Throwable -> L8c
            goto Lb4
        La4:
            androidx.appcompat.widget.AppCompatImageView r0 = r5.getIvRight()     // Catch: java.lang.Throwable -> L8c
            r0.setImageResource(r8)     // Catch: java.lang.Throwable -> L8c
            goto Lb4
        Lac:
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r8)     // Catch: java.lang.Throwable -> Lb0
            goto Lb4
        Lb0:
            r8 = move-exception
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r8)
        Lb4:
            android.view.View r8 = r5.getCenterLineView()     // Catch: java.lang.Throwable -> Lcb
            android.content.Context r0 = r5.getContext()     // Catch: java.lang.Throwable -> Lcb
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r5 = r5.OooO0OO     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> Lcb
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> Lcb
            if (r5 == 0) goto Lcd
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> Lcb
            goto Lcf
        Lcb:
            r5 = move-exception
            goto Ld7
        Lcd:
            int r5 = com.cloud.tmc.miniapp.R.color.mini_color_border_capsule     // Catch: java.lang.Throwable -> Lcb
        Lcf:
            int r5 = androidx.core.content.b.getColor(r0, r5)     // Catch: java.lang.Throwable -> Lcb
            r8.setBackgroundColor(r5)     // Catch: java.lang.Throwable -> Lcb
            goto Lda
        Ld7:
            com.cloud.tmc.kernel.log.TmcLogger.e(r7, r5)
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.CapsuleView.OooO00o(com.cloud.tmc.miniapp.widget.CapsuleView, int, java.util.HashMap, int):void");
    }

    public static final void OooO00o(CapsuleView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.h(this$0, "this$0");
        if (FastClickUtil.isFastDoubleClick() || (function0 = this$0.OooO0o0) == null) {
            return;
        }
        function0.invoke();
    }

    public static final void OooO0O0(CapsuleView this$0, View view) {
        Function0<Unit> function0;
        Intrinsics.h(this$0, "this$0");
        if (FastClickUtil.isFastDoubleClick() || (function0 = this$0.OooO0o) == null) {
            return;
        }
        function0.invoke();
    }

    private final LinearLayoutCompat getCapsuleLayout() {
        Object value = this.OooO0oO.getValue();
        Intrinsics.g(value, "<get-capsuleLayout>(...)");
        return (LinearLayoutCompat) value;
    }

    private final View getCenterLineView() {
        Object value = this.OooO.getValue();
        Intrinsics.g(value, "<get-centerLineView>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvLeft() {
        Object value = this.OooO0oo.getValue();
        Intrinsics.g(value, "<get-ivLeft>(...)");
        return (AppCompatImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatImageView getIvRight() {
        Object value = this.OooOO0.getValue();
        Intrinsics.g(value, "<get-ivRight>(...)");
        return (AppCompatImageView) value;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getBackAndHome() {
        return this.OooO0O0;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getCapsuleStyle() {
        return this.OooOO0O;
    }

    public final HashMap<Integer, HashMap<Integer, Integer>> getMoreAndClose() {
        return this.OooO00o;
    }

    public final void setCapsuleStyle(HashMap<Integer, HashMap<Integer, Integer>> hashMap) {
        Intrinsics.h(hashMap, "<set-?>");
        this.OooOO0O = hashMap;
    }

    public final void setOnLeftClickListener(Function0<Unit> cb2) {
        Intrinsics.h(cb2, "cb");
        this.OooO0o0 = cb2;
    }

    public final void setOnRightClickListener(Function0<Unit> cb2) {
        Intrinsics.h(cb2, "cb");
        this.OooO0o = cb2;
    }
}
