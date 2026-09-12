package com.tn.tranpay.activity;

import ai.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPayClient;
import com.tn.tranpay.c;
import com.tn.tranpay.d;
import com.tn.tranpay.fragment.PayFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/tn/tranpay/activity/TranPayTransparentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "onDestroy", "", "a", "Ljava/lang/String;", "callbackId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "lib_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class TranPayTransparentActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f41564c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String callbackId;

    /* renamed from: com.tn.tranpay.activity.TranPayTransparentActivity$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, BillingParams params, d callback) {
            Intrinsics.h(context, "context");
            Intrinsics.h(params, "params");
            Intrinsics.h(callback, "callback");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "randomUUID().toString()");
            TranPayTransparentActivity.f41564c.put(uuid, callback);
            Intent intent = new Intent(context, (Class<?>) TranPayTransparentActivity.class);
            intent.putExtra("extra_billing_params", params);
            intent.putExtra("extra_callback_id", uuid);
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f41567b;

        b(d dVar) {
            this.f41567b = dVar;
        }

        @Override // com.tn.tranpay.d
        public void a(com.tn.tranpay.b result, c cVar) {
            Intrinsics.h(result, "result");
            a.g(a.f694a, "TranPayTransparentActivity: callback received, code=" + result.b(), null, 2, null);
            TranPayClient.f41542a.e();
            TypeIntrinsics.d(TranPayTransparentActivity.f41564c).remove(TranPayTransparentActivity.this.callbackId);
            this.f41567b.a(result, cVar);
            TranPayTransparentActivity.this.finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment k02 = getSupportFragmentManager().k0("pay_fragment");
        PayFragment payFragment = k02 instanceof PayFragment ? (PayFragment) k02 : null;
        if (payFragment != null && payFragment.isAdded()) {
            payFragment.o0();
            return;
        }
        a.g(a.f694a, "TranPayTransparentActivity: back pressed in loading stage, cancelling", null, 2, null);
        TranPayClient.f41542a.e();
        d dVar = (d) TypeIntrinsics.d(f41564c).remove(this.callbackId);
        if (dVar != null) {
            dVar.a(new com.tn.tranpay.b(1, ""), null);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            window.setFlags(67108864, 67108864);
            window.addFlags(128);
        }
        a aVar = a.f694a;
        a.g(aVar, "TranPayTransparentActivity: onCreate", null, 2, null);
        BillingParams billingParams = (BillingParams) getIntent().getParcelableExtra("extra_billing_params");
        String stringExtra = getIntent().getStringExtra("extra_callback_id");
        this.callbackId = stringExtra;
        d dVar = stringExtra != null ? (d) f41564c.get(stringExtra) : null;
        if (billingParams != null && dVar != null) {
            TranPayClient.f41542a.d(this, billingParams, new b(dVar));
        } else {
            a.e(aVar, "TranPayTransparentActivity: callback not found (process may have been killed), finishing immediately", null, 2, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d dVar;
        super.onDestroy();
        String str = this.callbackId;
        if (str == null || (dVar = (d) f41564c.remove(str)) == null) {
            return;
        }
        a.e(a.f694a, "TranPayTransparentActivity: onDestroy without callback delivery, possible unexpected destruction!", null, 2, null);
        TranPayClient.f41542a.e();
        dVar.a(new com.tn.tranpay.b(-1, "Payment interrupted"), null);
    }
}
