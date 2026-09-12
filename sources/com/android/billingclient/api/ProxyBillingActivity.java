package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;

@UsedByReflection("PlatformActivityProxy")
/* loaded from: classes2.dex */
public class ProxyBillingActivity extends ComponentActivity {

    /* renamed from: a, reason: collision with root package name */
    private androidx.activity.result.b f19110a;

    /* renamed from: b, reason: collision with root package name */
    private ResultReceiver f19111b;

    /* renamed from: c, reason: collision with root package name */
    private ResultReceiver f19112c;

    /* renamed from: d, reason: collision with root package name */
    private ResultReceiver f19113d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f19114e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f19115f;

    private Intent F(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent G() {
        getApplicationContext().getPackageName();
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ActivityResult activityResult) {
        Intent data = activityResult.getData();
        int zzc = zzb.zzc(data, "ProxyBillingActivity");
        ResultReceiver resultReceiver = this.f19113d;
        if (resultReceiver != null) {
            resultReceiver.send(zzc, data == null ? null : data.getExtras());
        }
        if (activityResult.getResultCode() != -1 || zzc != 0) {
            zzb.zzk("ProxyBillingActivity", "Alternative billing only dialog finished with resultCode " + activityResult.getResultCode() + " and billing's responseCode: " + zzc);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i11;
        PendingIntent pendingIntent;
        int i12;
        super.onCreate(bundle);
        this.f19110a = registerForActivityResult(new f.k(), new androidx.activity.result.a() { // from class: com.android.billingclient.api.d1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ProxyBillingActivity.this.H((ActivityResult) obj);
            }
        });
        if (bundle != null) {
            zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f19114e = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.f19111b = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f19112c = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            } else if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.f19113d = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
            }
            this.f19115f = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            return;
        }
        zzb.zzj("ProxyBillingActivity", "Launching Play Store billing flow");
        if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
            PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
            this.f19113d = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
            this.f19110a.a(new IntentSenderRequest.a(pendingIntent2).a());
            return;
        }
        if (getIntent().hasExtra("BUY_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                this.f19115f = true;
                i12 = 110;
                i11 = i12;
            }
            i11 = 100;
        } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
            this.f19111b = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            i11 = 100;
        } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
            pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
            this.f19112c = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
            i12 = 101;
            i11 = i12;
        } else {
            i11 = 100;
            pendingIntent = null;
        }
        try {
            this.f19114e = true;
            startIntentSenderForResult(pendingIntent.getIntentSender(), i11, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e11) {
            zzb.zzl("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e11);
            ResultReceiver resultReceiver = this.f19111b;
            if (resultReceiver != null) {
                resultReceiver.send(6, null);
            } else {
                ResultReceiver resultReceiver2 = this.f19112c;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(0, null);
                } else {
                    Intent G = G();
                    if (this.f19115f) {
                        G.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    G.putExtra("RESPONSE_CODE", 6);
                    G.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(G);
                }
            }
            this.f19114e = false;
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f19114e) {
            Intent G = G();
            G.putExtra("RESPONSE_CODE", 1);
            G.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(G);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.f19111b;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f19112c;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.f19113d;
        if (resultReceiver3 != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver3);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f19114e);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f19115f);
    }
}
