package com.transsion.usercenter.laboratory;

import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.transsion.baseui.activity.BaseNewActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/transsion/usercenter/laboratory/LabMiniAppSDKTestActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lfw/d;", "<init>", "()V", "H0", "()Lfw/d;", "", "i0", "()Ljava/lang/String;", "", "o0", "p0", "n0", "s0", "retryLoadData", "i", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LabMiniAppSDKTestActivity extends BaseNewActivity<fw.d> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void I0(LabMiniAppSDKTestActivity labMiniAppSDKTestActivity, View view) {
        String str;
        String obj;
        Editable text = ((fw.d) labMiniAppSDKTestActivity.getMViewBinding()).f62729c.getText();
        String str2 = "";
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            Toast.makeText(labMiniAppSDKTestActivity, "appId is empty", 1).show();
            return;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        bVar.b().putString("KEY_TEST_MIN_APP_SDK_APP_ID", str);
        Editable text2 = ((fw.d) labMiniAppSDKTestActivity.getMViewBinding()).f62730d.getText();
        if (text2 != null && (obj = text2.toString()) != null) {
            str2 = obj;
        }
        if (str2.length() > 0) {
            bVar.b().putString("KEY_TEST_MIN_APP_SDK_SCENE_ID", str);
        }
        uj.a.f76883a.c(labMiniAppSDKTestActivity, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void J0(LabMiniAppSDKTestActivity labMiniAppSDKTestActivity, View view) {
        String str;
        Editable text = ((fw.d) labMiniAppSDKTestActivity.getMViewBinding()).f62728b.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            Toast.makeText(labMiniAppSDKTestActivity, "deeplink is empty", 1).show();
        } else {
            com.transsion.baselib.report.launch.b.f43424a.b().putString("KEY_TEST_MIN_APP_SDK_DEEPLINK", str);
            ak.k.h(str, null, 1, null);
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public fw.d getViewBinding() {
        fw.d c11 = fw.d.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String i0() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void n0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void o0() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("KEY_TEST_MIN_APP_SDK_APP_ID", "");
        if (string == null) {
            string = "";
        }
        if (string.length() > 0) {
            ((fw.d) getMViewBinding()).f62729c.setText(string);
        }
        String string2 = bVar.b().getString("KEY_TEST_MIN_APP_SDK_SCENE_ID", "");
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() > 0) {
            ((fw.d) getMViewBinding()).f62730d.setText(string2);
        }
        String string3 = bVar.b().getString("KEY_TEST_MIN_APP_SDK_DEEPLINK", "");
        String str = string3 != null ? string3 : "";
        if (str.length() > 0) {
            ((fw.d) getMViewBinding()).f62728b.setText(str);
        }
        ((fw.d) getMViewBinding()).f62731e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabMiniAppSDKTestActivity.I0(LabMiniAppSDKTestActivity.this, view);
            }
        });
        ((fw.d) getMViewBinding()).f62732f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.laboratory.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LabMiniAppSDKTestActivity.J0(LabMiniAppSDKTestActivity.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void p0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void s0() {
    }
}
