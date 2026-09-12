package com.transsion.mpush.core.activity;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u001f\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/transsion/mpush/core/activity/SdkPushClickActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "c", "(Landroid/content/Intent;)V", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/Object;)Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "onDestroy", "Landroid/content/Context;", "context", "", "notificationId", "a", "(Landroid/content/Context;I)V", "Lkotlinx/coroutines/n0;", "Lkotlinx/coroutines/n0;", "activityScope", "MBPush_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SdkPushClickActivity extends Activity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n0 activityScope = o0.a(l2.b(null, 1, null).plus(y0.b()));

    private final String b(Object value) {
        if (value instanceof String) {
            return (String) value;
        }
        if ((value instanceof CharSequence) || (value instanceof Number) || (value instanceof Boolean) || (value instanceof Character)) {
            return value.toString();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02b2 A[Catch: Exception -> 0x02c8, TryCatch #2 {Exception -> 0x02c8, blocks: (B:59:0x027f, B:61:0x02b2, B:65:0x02ce, B:68:0x02d5, B:69:0x02fd, B:71:0x0303, B:73:0x0319, B:75:0x031d), top: B:58:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c(android.content.Intent r35) {
        /*
            Method dump skipped, instructions count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.activity.SdkPushClickActivity.c(android.content.Intent):void");
    }

    public final void a(Context context, int notificationId) {
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return;
        }
        try {
            notificationManager.cancel(notificationId);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intrinsics.g(intent, "getIntent(...)");
        c(intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        o0.d(this.activityScope, null, 1, null);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            c(intent);
        }
        finish();
    }
}
