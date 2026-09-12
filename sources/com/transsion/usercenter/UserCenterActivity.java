package com.transsion.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baseui.activity.BaseActivity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/usercenter/UserCenterActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfw/o;", "<init>", "()V", "", "i0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "h0", "()Lfw/o;", "", "isTranslucent", "()Z", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class UserCenterActivity extends BaseActivity<fw.o> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void i0() {
        ((fw.o) getMViewBinding()).f62956b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterActivity.j0(UserCenterActivity.this, view);
            }
        });
        ((fw.o) getMViewBinding()).f62958d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterActivity.k0(UserCenterActivity.this, view);
            }
        });
        ((fw.o) getMViewBinding()).f62957c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterActivity.l0(UserCenterActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(UserCenterActivity userCenterActivity, View view) {
        userCenterActivity.startActivity(new Intent(userCenterActivity, (Class<?>) ProfileEditActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(UserCenterActivity userCenterActivity, View view) {
        Intent intent = new Intent(userCenterActivity, (Class<?>) FollowActivity.class);
        intent.putExtra("follow_type_key", 1);
        userCenterActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(UserCenterActivity userCenterActivity, View view) {
        Intent intent = new Intent(userCenterActivity, (Class<?>) FollowActivity.class);
        intent.putExtra("follow_type_key", 2);
        userCenterActivity.startActivity(intent);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public fw.o getViewBinding() {
        fw.o c11 = fw.o.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
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
        LinearLayoutCompat root = ((fw.o) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.e(root);
        i0();
    }
}
