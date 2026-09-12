package com.transsion.usercenter.laboratory;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$style;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ph.c;
import yg.b;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabInfoDialog;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "keyColor", "valueColor", "Lph/c;", "p0", "(II)Lph/c;", "", "q0", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LabInfoDialog extends BaseDialog {
    public LabInfoDialog() {
        super(R$layout.dialog_lab_info);
    }

    private final ph.c p0(int keyColor, int valueColor) {
        UserInfo i11;
        c.a c11 = ph.c.e().e("user_id = ").c(keyColor);
        ILoginApi iLoginApi = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        c.a c12 = c11.e(((iLoginApi == null || (i11 = iLoginApi.i()) == null) ? null : i11.getUserId()) + "\n").c(valueColor).e("device_id = ").c(keyColor);
        ih.b bVar = ih.b.f65364a;
        c.a c13 = c12.e(bVar.h() + "\n").c(valueColor).e("version_name = ").c(keyColor).e(com.blankj.utilcode.util.c.h() + "\n").c(valueColor).e("version_code = ").c(keyColor).e(com.blankj.utilcode.util.c.f() + "\n").c(valueColor).e("os_version = ").c(keyColor).e(bVar.n() + "\n").c(valueColor).e("model = ").c(keyColor).e(bVar.l() + "\n").c(valueColor).e("install_ch = ").c(keyColor).e(bh.a.f16551a.a() + "\n").c(valueColor).e("gaid = ").c(keyColor).e(bVar.i() + "\n").c(valueColor).e("net = ").c(keyColor).e(nh.m.f70597a.d() + "\n").c(valueColor).e("region = ").c(keyColor).e(Locale.getDefault().getCountry() + "\n").c(valueColor).e("timezone = ").c(keyColor).e(TimeZone.getDefault().getID() + "\n").c(valueColor).e("sp_code = ").c(keyColor).e(q0() + "\n").c(valueColor).e("channel = ").c(keyColor);
        b.a aVar = yg.b.f79132a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        c.a c14 = c13.e(aVar.e(a11) + "\n").c(valueColor).e("package = ").c(keyColor).e(com.blankj.utilcode.util.c.e() + "\n").c(valueColor).e("SignatureMD5 = ").c(keyColor);
        ak.d dVar = ak.d.f707a;
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        c.a c15 = c14.e(dVar.a(a12) + "\n").c(valueColor).e("SignatureSha1 = ").c(keyColor);
        Application a13 = Utils.a();
        Intrinsics.g(a13, "getApp(...)");
        c.a c16 = c15.e(ak.d.c(a13) + "\n").c(valueColor).e("SignatureSHA256 = ").c(keyColor);
        Application a14 = Utils.a();
        Intrinsics.g(a14, "getApp(...)");
        ph.c b11 = c16.e(dVar.b(a14) + "\n").c(valueColor).b();
        Intrinsics.g(b11, "build(...)");
        return b11;
    }

    private final String q0() {
        String string;
        MMKV c11 = bh.a.f16551a.c();
        String str = "";
        if (c11 != null && (string = c11.getString("sp_code", "")) != null) {
            str = string;
        }
        return TextUtils.isEmpty(str) ? ih.b.f65364a.o() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(LabInfoDialog labInfoDialog, View view) {
        labInfoDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(fw.x xVar, LabInfoDialog labInfoDialog, View view) {
        com.blankj.utilcode.util.g.a(xVar.f63104d.getText().toString());
        Toast.makeText(labInfoDialog.getContext(), "copy success", 1).show();
        labInfoDialog.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R$style.BaseDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final fw.x a11 = fw.x.a(view);
        Intrinsics.g(a11, "bind(...)");
        a11.f63104d.setText(p0(androidx.core.content.b.getColor(view.getContext(), R$color.main), androidx.core.content.b.getColor(view.getContext(), R$color.text_02)));
        a11.f63102b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabInfoDialog.r0(LabInfoDialog.this, view2);
            }
        });
        a11.f63103c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabInfoDialog.s0(fw.x.this, this, view2);
            }
        });
    }
}
