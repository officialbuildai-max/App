package com.transsion.subroom.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.ViewModelLazy;
import androidx.view.v0;
import androidx.view.x0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.transsion.baselib.report.f;
import com.transsion.baseui.activity.k;
import com.transsion.push.api.IPushClickHandler;
import com.transsion.push.feature.toolbar.ToolbarNotificationUtils;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsion/subroom/deeplink/DeepLinkHandler;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/transsion/baselib/report/f;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "V", "(Landroid/content/Intent;)V", "T", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "onResume", "onPause", "onDestroy", "", "a", "Ljava/lang/String;", "TAG", "Lcom/transsion/subroom/deeplink/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "U", "()Lcom/transsion/subroom/deeplink/d;", "mLaunchViewModel", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class DeepLinkHandler extends AppCompatActivity implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "deeplink_Handler";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLaunchViewModel;

    public DeepLinkHandler() {
        final Function0 function0 = null;
        this.mLaunchViewModel = new ViewModelLazy(Reflection.b(d.class), new Function0<x0>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.subroom.deeplink.DeepLinkHandler$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p1.a invoke() {
                p1.a aVar;
                Function0 function02 = Function0.this;
                return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    private final void T() {
        IPushClickHandler iPushClickHandler = (IPushClickHandler) TheRouter.d(IPushClickHandler.class, new Object[0]);
        if (iPushClickHandler != null) {
            Intent intent = getIntent();
            Intrinsics.g(intent, "getIntent(...)");
            iPushClickHandler.a(this, intent);
        }
    }

    private final d U() {
        return (d) this.mLaunchViewModel.getValue();
    }

    private final void V(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, this.TAG, "appLinkData " + data + " type=" + intent.getType(), false, 4, null);
        try {
            T();
            ToolbarNotificationUtils.f50888a.v(intent);
            U().i(this, data, new Function0() { // from class: com.transsion.subroom.deeplink.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit W;
                    W = DeepLinkHandler.W(DeepLinkHandler.this);
                    return W;
                }
            });
            if (data.getBooleanQueryParameter("withoutAd", false)) {
                return;
            }
            overridePendingTransition(0, 0);
            finish();
        } catch (Exception e11) {
            a.C0856a.f(lg.a.f68962a, this.TAG, "处理 appLinkData " + data + " 异常:" + e11.getMessage(), false, 4, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(DeepLinkHandler deepLinkHandler) {
        deepLinkHandler.overridePendingTransition(0, 0);
        deepLinkHandler.finish();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intrinsics.g(intent, "getIntent(...)");
        V(intent);
        k.d(null, this, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k.f(null, this, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.h(intent, "intent");
        super.onNewIntent(intent);
        V(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        k.k(null, this, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        k.o(null, this, 1, null);
    }
}
