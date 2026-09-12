package com.cloud.hisavana.sdk;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.HSChronometer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class u1 extends o0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u1(Activity activity, View rootView, g4 helper) {
        super(activity, rootView, helper);
        Intrinsics.h(activity, "activity");
        Intrinsics.h(rootView, "rootView");
        Intrinsics.h(helper, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(u1 this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        try {
            this$0.f().a(2);
            this$0.f().b(false, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(u1 this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        g4 f11 = this$0.f();
        if (f11 != null) {
            f11.b(false, null);
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void b(ImageView imageView, float f11) {
        if (imageView != null) {
            imageView.setImageResource(0.0f == f11 ? R$drawable.hisavana_volume_close : R$drawable.hisavana_volume_open);
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void c(HSChronometer hSChronometer) {
        if (hSChronometer != null) {
            hSChronometer.setTickStringFormat(hSChronometer.getResources().getString(R$string.reward_before_tip));
            hSChronometer.setFinishedString(hSChronometer.getResources().getString(R$string.reward_after_tip));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.cloud.hisavana.sdk.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(com.cloud.hisavana.sdk.data.bean.response.AdsDTO r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.g()
            int r1 = com.cloud.hisavana.sdk.R$id.ad_description
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.view.View r1 = r6.g()
            int r2 = com.cloud.hisavana.sdk.R$id.source_size
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.cloud.hisavana.sdk.common.util.r r2 = com.cloud.hisavana.sdk.common.util.r.f22275a
            java.lang.String r2 = r2.k(r7)
            com.cloud.hisavana.sdk.g4 r3 = r6.f()
            boolean r3 = r3.c()
            r4 = 0
            if (r3 == 0) goto L40
            if (r7 == 0) goto L30
            java.lang.String r3 = r7.getScale()
            goto L31
        L30:
            r3 = r4
        L31:
            java.lang.String r5 = "9:16"
            boolean r3 = kotlin.jvm.internal.Intrinsics.c(r3, r5)
            if (r3 == 0) goto L40
            if (r1 != 0) goto L3c
            goto L6e
        L3c:
            r1.setText(r2)
            goto L6e
        L40:
            if (r7 == 0) goto L4d
            com.cloud.hisavana.sdk.data.bean.response.NativeBean r1 = r7.getNativeObject()
            if (r1 == 0) goto L4d
            java.lang.String r1 = r1.getDescriptionTxt()
            goto L4e
        L4d:
            r1 = r4
        L4e:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L68
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " · "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L68:
            if (r0 != 0) goto L6b
            goto L6e
        L6b:
            r0.setText(r1)
        L6e:
            android.view.View r0 = r6.g()
            int r1 = com.cloud.hisavana.sdk.R$id.ad_btn
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L7d
            goto L90
        L7d:
            if (r7 == 0) goto L8d
            int r1 = r7.getInstallApk()
            com.cloud.hisavana.sdk.data.bean.response.NativeBean r7 = r7.getNativeObject()
            if (r7 == 0) goto L8d
            java.lang.String r4 = r7.getButtonTxt(r1)
        L8d:
            r0.setText(r4)
        L90:
            if (r0 != 0) goto L93
            goto La6
        L93:
            java.lang.CharSequence r7 = r0.getText()
            if (r7 == 0) goto La1
            int r7 = r7.length()
            if (r7 <= 0) goto La1
            r7 = 0
            goto La3
        La1:
            r7 = 8
        La3:
            r0.setVisibility(r7)
        La6:
            if (r0 == 0) goto Lb0
            com.cloud.hisavana.sdk.s1 r7 = new com.cloud.hisavana.sdk.s1
            r7.<init>()
            r0.setOnClickListener(r7)
        Lb0:
            android.view.View r7 = r6.g()
            int r0 = com.cloud.hisavana.sdk.R$id.ad_float_container
            android.view.View r7 = r7.findViewById(r0)
            if (r7 == 0) goto Lc4
            com.cloud.hisavana.sdk.t1 r0 = new com.cloud.hisavana.sdk.t1
            r0.<init>()
            r7.setOnClickListener(r0)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.u1.d(com.cloud.hisavana.sdk.data.bean.response.AdsDTO):void");
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void e(boolean z10, DownUpPointBean downUpPointBean, View view) {
        f().a(1);
        f().b(z10, downUpPointBean);
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void h() {
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void i() {
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void j() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (r1.length() > 0) goto L26;
     */
    @Override // com.cloud.hisavana.sdk.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k() {
        /*
            r5 = this;
            com.cloud.hisavana.sdk.g4 r0 = r5.f()
            boolean r0 = r0.c()
            if (r0 != 0) goto L14
            android.app.Activity r0 = r5.a()
            int r1 = com.cloud.hisavana.sdk.R$layout.activity_rewarded_r01
            r0.setContentView(r1)
            return
        L14:
            com.cloud.hisavana.sdk.g4 r0 = r5.f()
            com.cloud.hisavana.sdk.data.bean.response.AdsDTO r0 = r0.f()
            if (r0 == 0) goto Lb6
            java.lang.String r1 = r0.getScale()
            if (r1 == 0) goto Lac
            int r1 = r1.length()
            if (r1 != 0) goto L2c
            goto Lac
        L2c:
            int r1 = r0.getInstallApk()
            com.cloud.hisavana.sdk.data.bean.response.NativeBean r2 = r0.getNativeObject()
            if (r2 == 0) goto La2
            kotlin.jvm.internal.Intrinsics.e(r2)
            java.lang.String r3 = r2.getLogoUrl()
            java.lang.String r4 = "getLogoUrl(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            int r3 = r3.length()
            if (r3 <= 0) goto L49
            goto L78
        L49:
            java.lang.String r3 = r2.getTitleTxt()
            java.lang.String r4 = "getTitleTxt(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            int r3 = r3.length()
            if (r3 <= 0) goto L59
            goto L78
        L59:
            java.lang.String r3 = r2.getDescriptionTxt()
            java.lang.String r4 = "getDescriptionTxt(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            int r3 = r3.length()
            if (r3 <= 0) goto L69
            goto L78
        L69:
            java.lang.String r1 = r2.getButtonTxt(r1)
            java.lang.String r2 = "getButtonTxt(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            int r1 = r1.length()
            if (r1 <= 0) goto La2
        L78:
            java.lang.String r0 = r0.getScale()
            java.lang.String r1 = "9:16"
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)
            if (r0 == 0) goto L96
            com.cloud.hisavana.sdk.g4 r0 = r5.f()
            r1 = 1
            r0.a(r1)
            android.app.Activity r0 = r5.a()
            int r1 = com.cloud.hisavana.sdk.R$layout.activity_rewarded_r01_916
            r0.setContentView(r1)
            goto L9f
        L96:
            android.app.Activity r0 = r5.a()
            int r1 = com.cloud.hisavana.sdk.R$layout.activity_rewarded_r01
            r0.setContentView(r1)
        L9f:
            kotlin.Unit r0 = kotlin.Unit.f67184a
            goto Lb7
        La2:
            android.app.Activity r0 = r5.a()
            int r1 = com.cloud.hisavana.sdk.R$layout.activity_rewarded_r01_expose
            r0.setContentView(r1)
            return
        Lac:
            android.app.Activity r0 = r5.a()
            int r1 = com.cloud.hisavana.sdk.R$layout.activity_rewarded_r01
            r0.setContentView(r1)
            return
        Lb6:
            r0 = 0
        Lb7:
            if (r0 != 0) goto Lc2
            android.app.Activity r0 = r5.a()
            int r1 = com.cloud.hisavana.sdk.R$layout.activity_rewarded_r01
            r0.setContentView(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.u1.k():void");
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void l() {
    }
}
