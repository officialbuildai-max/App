package com.transsion.mbwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/transsion/mbwidget/PlayWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "a", "Companion", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class PlayWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|(1:(1:(14:10|11|12|13|(10:15|(1:17)|18|19|(1:21)|22|23|(1:25)|26|27)|30|18|19|(0)|22|23|(0)|26|27)(2:33|34))(1:35))(2:48|(1:50)(1:51))|36|37|38|(2:40|(1:42)(12:43|13|(0)|30|18|19|(0)|22|23|(0)|26|27))(7:45|(0)|22|23|(0)|26|27)))|52|6|(0)(0)|36|37|38|(0)(0)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010a, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x010b, code lost:
        
            r1 = r4;
            r4 = r10;
            r3 = r11;
            r10 = r6;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00bd A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0044, B:13:0x00b9, B:15:0x00bd, B:19:0x00cf, B:21:0x0116, B:22:0x0124, B:30:0x00c6), top: B:11:0x0044 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0116 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0044, B:13:0x00b9, B:15:0x00bd, B:19:0x00cf, B:21:0x0116, B:22:0x0124, B:30:0x00c6), top: B:11:0x0044 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x008a A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #1 {all -> 0x010a, blocks: (B:38:0x0086, B:40:0x008a), top: B:37:0x0086 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
        /* JADX WARN: Type inference failed for: r0v28, types: [T, android.app.PendingIntent] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object b(android.content.Context r19, android.widget.RemoteViews r20, int r21, kotlin.coroutines.Continuation r22) {
            /*
                Method dump skipped, instructions count: 353
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.PlayWidgetProvider.Companion.b(android.content.Context, android.widget.RemoteViews, int, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void c(Context context, AppWidgetManager appWidgetManager, int i11) {
            Intrinsics.h(context, "context");
            Intrinsics.h(appWidgetManager, "appWidgetManager");
            k.d(o0.a(y0.b()), null, null, new PlayWidgetProvider$Companion$updateWidget$1(i11, context, appWidgetManager, null), 3, null);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.f46337a, "history_desk_widget", false, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.f46337a, "history_desk_widget", true, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        super.onReceive(context, intent);
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Play onReceive:");
        sb2.append(action);
        sb2.append(", ");
        sb2.append(extras);
        if (Intrinsics.c("com.transsion.mbwidget.play.ACTION_CLICK", intent.getAction())) {
            com.transsion.mbwidget.utils.a.f46337a.c(intent);
            String stringExtra = intent.getStringExtra("key_deeplink_widget");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(ASTNode.DEOP);
            intent2.setData(Uri.parse(stringExtra));
            context.startActivity(intent2);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(appWidgetIds, "appWidgetIds");
        for (int i11 : appWidgetIds) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("appWidgetId:");
            sb2.append(i11);
            INSTANCE.c(context, appWidgetManager, i11);
        }
    }
}
