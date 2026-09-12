package com.cloud.tmc.miniapp.ui;

import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom1PopUpWindowView;
import com.cloud.tmc.miniapp.widget.popupview.AddHomeCustom2PopUpWindowView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class MiniAppActivity$checkAndShowAddHomeCustomToast$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ long $closeAddHomeDelayTime;
    public final /* synthetic */ String $iconUrl;
    public final /* synthetic */ String $showToastMessage;
    public final /* synthetic */ int $showType;
    public final /* synthetic */ MiniAppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppActivity$checkAndShowAddHomeCustomToast$1(int i11, MiniAppActivity miniAppActivity, String str, String str2, long j11) {
        super(0);
        this.$showType = i11;
        this.this$0 = miniAppActivity;
        this.$showToastMessage = str;
        this.$iconUrl = str2;
        this.$closeAddHomeDelayTime = j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(final MiniAppActivity this$0, String str, String str2, long j11) {
        AddHomeCustom1PopUpWindowView pvAddHomeCustom1;
        AddHomeCustom1PopUpWindowView pvAddHomeCustom12;
        Intrinsics.h(this$0, "this$0");
        pvAddHomeCustom1 = this$0.getPvAddHomeCustom1();
        if (pvAddHomeCustom1 != null) {
            ViewExtKt.toVisible(pvAddHomeCustom1.OooO00o(str).OooO00o(this$0.getAppId(), str2));
        }
        pvAddHomeCustom12 = this$0.getPvAddHomeCustom1();
        this$0.postDelayed(pvAddHomeCustom12, j11, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.f0
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity$checkAndShowAddHomeCustomToast$1.invoke$lambda$1$lambda$0(MiniAppActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(MiniAppActivity this$0) {
        AddHomeCustom1PopUpWindowView pvAddHomeCustom1;
        Intrinsics.h(this$0, "this$0");
        pvAddHomeCustom1 = this$0.getPvAddHomeCustom1();
        if (pvAddHomeCustom1 != null) {
            ViewExtKt.toGone(pvAddHomeCustom1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(final MiniAppActivity this$0, String str, String str2, long j11) {
        AddHomeCustom2PopUpWindowView pvAddHomeCustom2;
        AddHomeCustom2PopUpWindowView pvAddHomeCustom22;
        Intrinsics.h(this$0, "this$0");
        pvAddHomeCustom2 = this$0.getPvAddHomeCustom2();
        if (pvAddHomeCustom2 != null) {
            ViewExtKt.toVisible(pvAddHomeCustom2.OooO00o(str).OooO00o(this$0.getAppId(), str2));
        }
        pvAddHomeCustom22 = this$0.getPvAddHomeCustom2();
        this$0.postDelayed(pvAddHomeCustom22, j11, new Runnable() { // from class: com.cloud.tmc.miniapp.ui.g0
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity$checkAndShowAddHomeCustomToast$1.invoke$lambda$3$lambda$2(MiniAppActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2(MiniAppActivity this$0) {
        AddHomeCustom2PopUpWindowView pvAddHomeCustom2;
        Intrinsics.h(this$0, "this$0");
        pvAddHomeCustom2 = this$0.getPvAddHomeCustom2();
        if (pvAddHomeCustom2 != null) {
            ViewExtKt.toGone(pvAddHomeCustom2);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m700invoke();
        return Unit.f67184a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m700invoke() {
        AddHomeCustom1PopUpWindowView pvAddHomeCustom1;
        AddHomeCustom2PopUpWindowView pvAddHomeCustom2;
        int i11 = this.$showType;
        if (i11 == 1) {
            MiniAppActivity miniAppActivity = this.this$0;
            pvAddHomeCustom1 = miniAppActivity.getPvAddHomeCustom1();
            miniAppActivity.removeCallbacksAndMessages(pvAddHomeCustom1);
            final MiniAppActivity miniAppActivity2 = this.this$0;
            final String str = this.$showToastMessage;
            final String str2 = this.$iconUrl;
            final long j11 = this.$closeAddHomeDelayTime;
            miniAppActivity2.post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.i0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppActivity$checkAndShowAddHomeCustomToast$1.invoke$lambda$1(MiniAppActivity.this, str, str2, j11);
                }
            });
            return;
        }
        if (i11 != 2) {
            return;
        }
        MiniAppActivity miniAppActivity3 = this.this$0;
        pvAddHomeCustom2 = miniAppActivity3.getPvAddHomeCustom2();
        miniAppActivity3.removeCallbacksAndMessages(pvAddHomeCustom2);
        final MiniAppActivity miniAppActivity4 = this.this$0;
        final String str3 = this.$showToastMessage;
        final String str4 = this.$iconUrl;
        final long j12 = this.$closeAddHomeDelayTime;
        miniAppActivity4.post(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.h0
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppActivity$checkAndShowAddHomeCustomToast$1.invoke$lambda$3(MiniAppActivity.this, str3, str4, j12);
            }
        });
    }
}
