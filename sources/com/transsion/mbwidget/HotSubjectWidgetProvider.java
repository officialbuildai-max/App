package com.transsion.mbwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/transsion/mbwidget/HotSubjectWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "", "refreshId", "", "widgetId", "", "e", "(Landroid/content/Context;Ljava/lang/String;I)V", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onDeleted", "(Landroid/content/Context;[I)V", "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "a", "Companion", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class HotSubjectWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final List f46283b = CollectionsKt.o(Integer.valueOf(R$id.work_title1), Integer.valueOf(R$id.work_title2), Integer.valueOf(R$id.work_title3));

    /* renamed from: c, reason: collision with root package name */
    private static final List f46284c = CollectionsKt.o(Integer.valueOf(R$id.work_img1), Integer.valueOf(R$id.work_img2), Integer.valueOf(R$id.work_img3));

    /* renamed from: d, reason: collision with root package name */
    private static final List f46285d = CollectionsKt.o(Integer.valueOf(R$id.work_root1), Integer.valueOf(R$id.work_root2), Integer.valueOf(R$id.work_root3));

    /* renamed from: e, reason: collision with root package name */
    private static final List f46286e = CollectionsKt.o(Integer.valueOf(R$id.work_tag1), Integer.valueOf(R$id.work_tag2), Integer.valueOf(R$id.work_tag3));

    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0138, code lost:
        
            r14 = r12.b();
            r12 = r12.a();
            r1.setTextViewText(((java.lang.Number) com.transsion.mbwidget.HotSubjectWidgetProvider.f46283b.get(r12)).intValue(), r14.getTitle());
            r1.setTextViewText(((java.lang.Number) com.transsion.mbwidget.HotSubjectWidgetProvider.f46286e.get(r12)).intValue(), r14.getCorner());
            r9 = ((java.lang.Number) com.transsion.mbwidget.HotSubjectWidgetProvider.f46286e.get(r12)).intValue();
            r15 = r14.getCorner();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x017c, code lost:
        
            if (r15 == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0182, code lost:
        
            if (r15.length() != 0) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0185, code lost:
        
            r15 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0189, code lost:
        
            r1.setViewVisibility(r9, r15);
            r9 = com.transsion.mbwidget.HotSubjectWidgetProvider.INSTANCE;
            r15 = r14.getCover();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0192, code lost:
        
            if (r15 == null) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0194, code lost:
        
            r13 = r15.getUrl();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0198, code lost:
        
            r3.L$0 = r11;
            r3.L$1 = r1;
            r3.L$2 = r6;
            r3.L$3 = r2;
            r3.L$4 = r14;
            r3.I$0 = r0;
            r3.I$1 = r12;
            r3.label = 3;
            r9 = r9.d(r13, r12, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x01ac, code lost:
        
            if (r9 != r5) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x01ae, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x01af, code lost:
        
            r13 = r1;
            r1 = r0;
            r0 = r12;
            r12 = r6;
            r6 = r14;
            r14 = r11;
            r11 = r2;
            r2 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0187, code lost:
        
            r15 = 8;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00fa A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:61:0x0227, B:23:0x0123, B:25:0x012a, B:30:0x0138, B:32:0x017e, B:36:0x0189, B:38:0x0194, B:39:0x0198, B:57:0x0200, B:21:0x011b, B:15:0x00f6, B:17:0x00fa, B:18:0x0104, B:10:0x00da), top: B:9:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x011a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x012a A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:61:0x0227, B:23:0x0123, B:25:0x012a, B:30:0x0138, B:32:0x017e, B:36:0x0189, B:38:0x0194, B:39:0x0198, B:57:0x0200, B:21:0x011b, B:15:0x00f6, B:17:0x00fa, B:18:0x0104, B:10:0x00da), top: B:9:0x00da }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0267  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0200 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00ae  */
        /* JADX WARN: Type inference failed for: r6v0, types: [int] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(android.content.Context r19, android.widget.RemoteViews r20, int r21, java.lang.String r22, kotlin.coroutines.Continuation r23) {
            /*
                Method dump skipped, instructions count: 670
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.HotSubjectWidgetProvider.Companion.c(android.content.Context, android.widget.RemoteViews, int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object d(java.lang.String r11, int r12, kotlin.coroutines.Continuation r13) {
            /*
                r10 = this;
                boolean r0 = r13 instanceof com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$getCoverBitmap$1
                if (r0 == 0) goto L13
                r0 = r13
                com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$getCoverBitmap$1 r0 = (com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$getCoverBitmap$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$getCoverBitmap$1 r0 = new com.transsion.mbwidget.HotSubjectWidgetProvider$Companion$getCoverBitmap$1
                r0.<init>(r10, r13)
            L18:
                java.lang.Object r13 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 68
                r4 = 1
                if (r2 == 0) goto L35
                if (r2 != r4) goto L2d
                int r12 = r0.I$0
                kotlin.ResultKt.b(r13)
                goto L49
            L2d:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L35:
                kotlin.ResultKt.b(r13)
                com.transsion.mbwidget.data.WidgetDataManager r13 = com.transsion.mbwidget.data.WidgetDataManager.f46309a
                int r2 = dk.a.b(r3)
                r0.I$0 = r12
                r0.label = r4
                java.lang.Object r13 = r13.k(r11, r2, r0)
                if (r13 != r1) goto L49
                return r1
            L49:
                android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13
                lg.a$a r11 = lg.a.f68962a
                if (r13 == 0) goto L58
                int r0 = r13.getByteCount()
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.d(r0)
                goto L59
            L58:
                r0 = 0
            L59:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "bindList, i:"
                r1.append(r2)
                r1.append(r12)
                java.lang.String r12 = ", bitmap:"
                r1.append(r12)
                r1.append(r0)
                java.lang.String r12 = r1.toString()
                java.lang.String r0 = "DeskWidget_"
                r11.c(r0, r12, r4)
                if (r13 == 0) goto L7f
                int r11 = r13.getByteCount()
                if (r11 != 0) goto L85
            L7f:
                com.transsion.mbwidget.utils.BitmapUtils r11 = com.transsion.mbwidget.utils.BitmapUtils.f46336a
                android.graphics.Bitmap r13 = r11.c()
            L85:
                android.app.Application r4 = com.blankj.utilcode.util.Utils.a()
                int r6 = dk.a.b(r3)
                r11 = 95
                int r7 = dk.a.b(r11)
                r11 = 5
                int r9 = dk.a.b(r11)
                r8 = 0
                r5 = r13
                android.graphics.Bitmap r11 = kg.a.a(r4, r5, r6, r7, r8, r9)
                if (r11 != 0) goto La1
                goto La2
            La1:
                r13 = r11
            La2:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.HotSubjectWidgetProvider.Companion.d(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static /* synthetic */ void f(Companion companion, Context context, AppWidgetManager appWidgetManager, int i11, String str, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                str = null;
            }
            companion.e(context, appWidgetManager, i11, str);
        }

        public final void e(Context context, AppWidgetManager appWidgetManager, int i11, String str) {
            Intrinsics.h(context, "context");
            Intrinsics.h(appWidgetManager, "appWidgetManager");
            k.d(o0.a(y0.b()), null, null, new HotSubjectWidgetProvider$Companion$updateWidget$1(i11, str, context, appWidgetManager, null), 3, null);
        }
    }

    private final void e(Context context, String refreshId, int widgetId) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        if (widgetId == 0) {
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) HotSubjectWidgetProvider.class));
            Intrinsics.g(appWidgetIds, "getAppWidgetIds(...)");
            Integer W = ArraysKt.W(appWidgetIds);
            widgetId = W != null ? W.intValue() : 0;
        }
        Companion companion = INSTANCE;
        Intrinsics.e(appWidgetManager);
        companion.e(context, appWidgetManager, widgetId, refreshId);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        lg.a.f68962a.c("DeskWidget_", "HotSubjectWidgetProvider_onDeleted: " + appWidgetIds, true);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        lg.a.f68962a.c("DeskWidget_", "HotSubjectWidgetProvider-onDisabled: Hot", true);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.f46337a, "hot_desk_widget", false, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        lg.a.f68962a.c("DeskWidget_", "HotSubjectWidgetProvider-onEnabled: Hot", true);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.f46337a, "hot_desk_widget", true, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        super.onReceive(context, intent);
        lg.a.f68962a.c("DeskWidget_", "HotSubjectWidgetProvider onReceive:" + intent.getAction() + ", moduleName:" + intent.getStringExtra("key_module_name"), true);
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("appWidgetId", 0);
        if (Intrinsics.c("com.transsion.mbwidget.hot.ACTION_CLICK", action)) {
            e(context, intent.getStringExtra("key_subject_id_widget"), intExtra);
            com.transsion.mbwidget.utils.a.f46337a.h(intent);
            String stringExtra = intent.getStringExtra("key_deeplink_widget");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(ASTNode.DEOP);
            intent2.setData(Uri.parse(stringExtra));
            context.startActivity(intent2);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Object m1185constructorimpl;
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(appWidgetIds, "appWidgetIds");
        for (int i11 : appWidgetIds) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion.f(INSTANCE, context, appWidgetManager, i11, null, 8, null);
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.l(lg.a.f68962a, "DeskWidget_", "HotSubjectWidgetProvider,error:" + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
            }
        }
    }
}
