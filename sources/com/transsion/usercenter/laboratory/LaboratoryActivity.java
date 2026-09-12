package com.transsion.usercenter.laboratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.meituan.android.walle.ChannelReader;
import com.transsion.ad.test.TestAdActivity;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.mbwidget.data.SportWidgetDataManager;
import com.transsion.mbwidget.data.WidgetRefreshWorker;
import com.transsion.push.PushTestActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/transsion/usercenter/laboratory/LaboratoryActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfw/f;", "<init>", "()V", "w0", "()Lfw/f;", "", "isStatusDark", "()Z", "isTranslucent", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "P0", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LaboratoryActivity extends BaseActivity<fw.f> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(LaboratoryActivity laboratoryActivity, View view) {
        laboratoryActivity.startActivity(new Intent(laboratoryActivity, (Class<?>) PushTestActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(View view) {
        com.tn.lib.widget.toast.core.h.f41533a.l("Refresh Widget + 体育Widget强制刷新");
        WidgetRefreshWorker.INSTANCE.a();
        SportWidgetDataManager.f46300a.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(LaboratoryActivity laboratoryActivity, View view) {
        new LabLocationDialog().k0(laboratoryActivity, RequestParameters.SUBRESOURCE_LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(LaboratoryActivity laboratoryActivity, View view) {
        laboratoryActivity.startActivity(new Intent(laboratoryActivity, (Class<?>) LabMiniAppSDKTestActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(LaboratoryActivity laboratoryActivity, View view) {
        new LabFpsDialog().k0(laboratoryActivity, LauncherMiniAppConfigHelper.KEY_FPS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(LaboratoryActivity laboratoryActivity, View view) {
        TestAdActivity.INSTANCE.a(laboratoryActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(LaboratoryActivity laboratoryActivity, View view) {
        new LabContentModeDialog().k0(laboratoryActivity, "LabContentModeDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(LaboratoryActivity laboratoryActivity, View view) {
        new LabPhoneBrandDialog().k0(laboratoryActivity, "brand");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(LaboratoryActivity laboratoryActivity, View view) {
        new LabInfoDialog().k0(laboratoryActivity, "info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(LaboratoryActivity laboratoryActivity, View view) {
        laboratoryActivity.startActivity(new Intent(laboratoryActivity, (Class<?>) MccActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(LaboratoryActivity laboratoryActivity, View view) {
        new LabChannelDialog().k0(laboratoryActivity, ChannelReader.CHANNEL_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(LaboratoryActivity laboratoryActivity, View view) {
        new LabStreamingDialog().k0(laboratoryActivity, "stream");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(LaboratoryActivity laboratoryActivity, View view) {
        new LabHttpHostDialog().k0(laboratoryActivity, "host");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(LaboratoryActivity laboratoryActivity, View view) {
        com.tn.lib.widget.toast.core.h.f41533a.l("Cold start coming");
        kotlinx.coroutines.k.d(androidx.view.v.a(laboratoryActivity), null, null, new LaboratoryActivity$onCreate$9$1(laboratoryActivity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(View view) {
        com.tn.lib.widget.toast.core.h.f41533a.l("js调试ON 当次进程有效");
        WebView.setWebContentsDebuggingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(LaboratoryActivity laboratoryActivity, View view) {
        laboratoryActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(LaboratoryActivity laboratoryActivity, View view) {
        new LabLaneDialog().k0(laboratoryActivity, "lane");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(LaboratoryActivity laboratoryActivity, View view) {
        new LabWebTestDialog().k0(laboratoryActivity, "webTest");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P0(android.content.Context r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.usercenter.laboratory.LaboratoryActivity$restartApp$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.usercenter.laboratory.LaboratoryActivity$restartApp$1 r0 = (com.transsion.usercenter.laboratory.LaboratoryActivity$restartApp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.usercenter.laboratory.LaboratoryActivity$restartApp$1 r0 = new com.transsion.usercenter.laboratory.LaboratoryActivity$restartApp$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            r0.L$0 = r5
            r0.label = r3
            r2 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r6 = kotlinx.coroutines.u0.a(r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            com.transsion.baselib.report.l r6 = com.transsion.baselib.report.l.f43413a
            r6.l()
            android.content.pm.PackageManager r6 = r5.getPackageManager()
            java.lang.String r0 = r5.getPackageName()
            android.content.Intent r6 = r6.getLaunchIntentForPackage(r0)
            kotlin.jvm.internal.Intrinsics.e(r6)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r6.addFlags(r0)
            r5.startActivity(r6)
            int r5 = android.os.Process.myPid()
            android.os.Process.killProcess(r5)
            r5 = 0
            java.lang.System.exit(r5)
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.laboratory.LaboratoryActivity.P0(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((fw.f) getMViewBinding()).f62755b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.x0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62764k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.y0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62768o.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.H0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62756c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.I0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62762i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.J0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62757d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.K0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62769p.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.L0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62761h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.M0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62763j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.N0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62759f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.O0(view);
            }
        });
        ((fw.f) getMViewBinding()).f62771r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.z0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62767n.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.A0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62772s.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.B0(view);
            }
        });
        ((fw.f) getMViewBinding()).f62765l.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.C0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62766m.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.D0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62760g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.E0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62770q.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.F0(LaboratoryActivity.this, view);
            }
        });
        ((fw.f) getMViewBinding()).f62758e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LaboratoryActivity.G0(LaboratoryActivity.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public fw.f getViewBinding() {
        fw.f c11 = fw.f.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
