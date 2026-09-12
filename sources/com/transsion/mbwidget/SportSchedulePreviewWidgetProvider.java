package com.transsion.mbwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.SizeF;
import android.widget.RemoteViews;
import com.transsion.mbwidget.data.SportType;
import com.transsion.mbwidget.data.SportWidgetDataManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/transsion/mbwidget/SportSchedulePreviewWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/appwidget/AppWidgetManager;", "appWidgetManager", "", "appWidgetIds", "", "onUpdate", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V", "", "appWidgetId", "Landroid/os/Bundle;", "newOptions", "onAppWidgetOptionsChanged", "(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;ILandroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "onDisabled", "(Landroid/content/Context;)V", "onEnabled", "a", "Companion", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class SportSchedulePreviewWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* loaded from: classes5.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private final String f46289a;

            /* renamed from: b, reason: collision with root package name */
            private final int f46290b;

            /* renamed from: c, reason: collision with root package name */
            private final int f46291c;

            public a(String name, int i11, int i12) {
                Intrinsics.h(name, "name");
                this.f46289a = name;
                this.f46290b = i11;
                this.f46291c = i12;
            }

            public final int a() {
                return this.f46291c;
            }

            public final String b() {
                return this.f46289a;
            }

            public final int c() {
                return this.f46290b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics.c(this.f46289a, aVar.f46289a) && this.f46290b == aVar.f46290b && this.f46291c == aVar.f46291c;
            }

            public int hashCode() {
                return (((this.f46289a.hashCode() * 31) + this.f46290b) * 31) + this.f46291c;
            }

            public String toString() {
                return "ReferenceSize(name=" + this.f46289a + ", widthDp=" + this.f46290b + ", heightDp=" + this.f46291c + ")";
            }
        }

        /* loaded from: classes5.dex */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f46292a;

            static {
                int[] iArr = new int[SportType.values().length];
                try {
                    iArr[SportType.FOOTBALL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SportType.BASKETBALL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SportType.CRICKET.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f46292a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(RemoteViews remoteViews, int i11, int i12) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            float f11 = i11;
            remoteViews.setViewLayoutWidth(R$id.widget_upcoming_container, f11, 1);
            float f12 = i12;
            remoteViews.setViewLayoutHeight(R$id.widget_upcoming_container, f12, 1);
            remoteViews.setViewLayoutWidth(R$id.widget_default_container, f11, 1);
            remoteViews.setViewLayoutHeight(R$id.widget_default_container, f12, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0156 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(android.content.Context r21, android.widget.RemoteViews r22, int r23, com.transsion.mbwidget.data.SportMatch r24, kotlin.coroutines.Continuation r25) {
            /*
                Method dump skipped, instructions count: 389
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.SportSchedulePreviewWidgetProvider.Companion.f(android.content.Context, android.widget.RemoteViews, int, com.transsion.mbwidget.data.SportMatch, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final String g(long j11) {
            long currentTimeMillis = System.currentTimeMillis();
            Date date = new Date(j11);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int i11 = calendar.get(6);
            calendar.setTime(new Date(currentTimeMillis));
            if (i11 == calendar.get(6)) {
                String format = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(date);
                Intrinsics.e(format);
                return format;
            }
            String format2 = new SimpleDateFormat("MM/dd HH:mm", Locale.ENGLISH).format(date);
            Intrinsics.e(format2);
            return format2;
        }

        private final Pair h(Bundle bundle) {
            int i11 = bundle.getInt("appWidgetMinWidth", 0);
            int i12 = bundle.getInt("appWidgetMinHeight", 0);
            int i13 = bundle.getInt("appWidgetMaxHeight", 0);
            if (i11 <= 0) {
                i11 = 138;
            }
            int i14 = i12 > 0 ? i12 : 145;
            if (Build.VERSION.SDK_INT >= 31) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("appWidgetSizes");
                if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                    Iterator it = parcelableArrayList.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object next = it.next();
                    if (it.hasNext()) {
                        float f11 = i11;
                        float abs = Math.abs(((SizeF) next).getWidth() - f11);
                        do {
                            Object next2 = it.next();
                            float abs2 = Math.abs(((SizeF) next2).getWidth() - f11);
                            if (Float.compare(abs, abs2) > 0) {
                                next = next2;
                                abs = abs2;
                            }
                        } while (it.hasNext());
                    }
                    SizeF sizeF = (SizeF) next;
                    i11 = (int) sizeF.getWidth();
                    i13 = (int) sizeF.getHeight();
                } else if (i13 <= 0) {
                    i13 = i14;
                }
            } else {
                if (i13 > 0) {
                    i12 = i13;
                } else if (i12 <= 0) {
                    i12 = 145;
                }
                i13 = i12;
            }
            return TuplesKt.a(Integer.valueOf(i11), Integer.valueOf(i13));
        }

        private final PendingIntent i(Context context, int i11) {
            return j(context, i11, "", null, "root");
        }

        private final PendingIntent j(Context context, int i11, String str, String str2, String str3) {
            Intent intent = new Intent(context, (Class<?>) SportSchedulePreviewWidgetProvider.class);
            intent.setAction("com.transsion.mbwidget.sport.ACTION_CLICK");
            intent.putExtra("appWidgetId", i11);
            intent.putExtra("key_deeplink_widget", str);
            intent.putExtra("key_module_name", str3);
            if (str2 != null && str2.length() != 0) {
                intent.putExtra("key_match_id_widget", str2);
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : ASTNode.NOJIT);
            Intrinsics.g(broadcast, "getBroadcast(...)");
            return broadcast;
        }

        private final int k(Context context, String str, String str2) {
            return context.getResources().getIdentifier(str, str2, context.getPackageName());
        }

        static /* synthetic */ int l(Companion companion, Context context, String str, String str2, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                str2 = "mipmap";
            }
            return companion.k(context, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(2:10|11)(2:21|22))(2:23|(2:30|31)(2:27|(1:29)))|12|(1:20)(1:16)|17|18))|35|6|7|(0)(0)|12|(1:14)|20|17|18) */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0034, code lost:
        
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        
            lg.a.C0856a.k(lg.a.f68962a, "SportWidget_", "Error loading team logo (" + r10 + "): " + r8.getMessage(), r8, false, 8, null);
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object m(android.widget.RemoteViews r8, int r9, java.lang.String r10, int r11, kotlin.coroutines.Continuation r12) {
            /*
                r7 = this;
                boolean r0 = r12 instanceof com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1
                if (r0 == 0) goto L13
                r0 = r12
                com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1 r0 = (com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1 r0 = new com.transsion.mbwidget.SportSchedulePreviewWidgetProvider$Companion$loadTeamLogo$1
                r0.<init>(r7, r12)
            L18:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3f
                if (r2 != r3) goto L37
                int r9 = r0.I$0
                java.lang.Object r8 = r0.L$1
                r10 = r8
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r8 = r0.L$0
                android.widget.RemoteViews r8 = (android.widget.RemoteViews) r8
                kotlin.ResultKt.b(r12)     // Catch: java.lang.Exception -> L34
                goto L5c
            L34:
                r8 = move-exception
                r3 = r8
                goto L86
            L37:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3f:
                kotlin.ResultKt.b(r12)
                if (r10 == 0) goto Lb1
                int r12 = r10.length()
                if (r12 != 0) goto L4b
                goto Lb1
            L4b:
                com.transsion.mbwidget.data.WidgetDataManager r12 = com.transsion.mbwidget.data.WidgetDataManager.f46309a     // Catch: java.lang.Exception -> L34
                r0.L$0 = r8     // Catch: java.lang.Exception -> L34
                r0.L$1 = r10     // Catch: java.lang.Exception -> L34
                r0.I$0 = r9     // Catch: java.lang.Exception -> L34
                r0.label = r3     // Catch: java.lang.Exception -> L34
                java.lang.Object r12 = r12.k(r10, r11, r0)     // Catch: java.lang.Exception -> L34
                if (r12 != r1) goto L5c
                return r1
            L5c:
                android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12     // Catch: java.lang.Exception -> L34
                if (r12 == 0) goto L6a
                boolean r11 = r12.isRecycled()     // Catch: java.lang.Exception -> L34
                if (r11 != 0) goto L6a
                r8.setImageViewBitmap(r9, r12)     // Catch: java.lang.Exception -> L34
                goto Lae
            L6a:
                lg.a$a r0 = lg.a.f68962a     // Catch: java.lang.Exception -> L34
                java.lang.String r1 = "SportWidget_"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34
                r8.<init>()     // Catch: java.lang.Exception -> L34
                java.lang.String r9 = "Failed to load team logo: "
                r8.append(r9)     // Catch: java.lang.Exception -> L34
                r8.append(r10)     // Catch: java.lang.Exception -> L34
                java.lang.String r2 = r8.toString()     // Catch: java.lang.Exception -> L34
                r4 = 4
                r5 = 0
                r3 = 0
                lg.a.C0856a.l(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L34
                goto Lae
            L86:
                lg.a$a r0 = lg.a.f68962a
                java.lang.String r8 = r3.getMessage()
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r11 = "Error loading team logo ("
                r9.append(r11)
                r9.append(r10)
                java.lang.String r10 = "): "
                r9.append(r10)
                r9.append(r8)
                java.lang.String r2 = r9.toString()
                r5 = 8
                r6 = 0
                java.lang.String r1 = "SportWidget_"
                r4 = 0
                lg.a.C0856a.k(r0, r1, r2, r3, r4, r5, r6)
            Lae:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            Lb1:
                kotlin.Unit r8 = kotlin.Unit.f67184a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.mbwidget.SportSchedulePreviewWidgetProvider.Companion.m(android.widget.RemoteViews, int, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final void n(Context context, RemoteViews remoteViews, int i11, int i12, String str) {
            try {
                int l11 = l(this, context, "bg_" + str + "_layer1", null, 4, null);
                if (l11 != 0) {
                    remoteViews.setInt(i11, "setBackgroundResource", l11);
                }
                int l12 = l(this, context, "bg_" + str + "_layer2", null, 4, null);
                if (l12 != 0) {
                    remoteViews.setImageViewResource(i12, l12);
                }
            } catch (Exception e11) {
                a.C0856a.k(lg.a.f68962a, "SportWidget_", "Error in dual layer rendering (" + str + "): " + e11.getMessage(), e11, false, 8, null);
            }
        }

        private final a o(int i11, int i12) {
            List<a> o11 = CollectionsKt.o(new a("4x6", 138, 145), new a("4x7", 138, 139), new a("5x6", Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, 138), new a("5x9", 176, 174));
            a aVar = (a) CollectionsKt.i0(o11);
            int i13 = Integer.MAX_VALUE;
            int i14 = Integer.MAX_VALUE;
            for (a aVar2 : o11) {
                int abs = Math.abs(aVar2.c() - i11);
                int abs2 = Math.abs(aVar2.a() - i12);
                if (abs < i13 || (abs == i13 && abs2 < i14)) {
                    aVar = aVar2;
                    i13 = abs;
                    i14 = abs2;
                }
            }
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void p(Context context, RemoteViews remoteViews, int i11) {
            remoteViews.setViewVisibility(R$id.widget_upcoming_container, 8);
            remoteViews.setViewVisibility(R$id.widget_default_container, 0);
            n(context, remoteViews, R$id.widget_default_container, R$id.widget_fallback_layer2, "default");
            PendingIntent i12 = i(context, i11);
            remoteViews.setOnClickPendingIntent(R$id.widget_watch_now_btn, i12);
            remoteViews.setOnClickPendingIntent(R$id.widget_root, i12);
        }

        public static /* synthetic */ void r(Companion companion, Context context, AppWidgetManager appWidgetManager, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                z10 = true;
            }
            companion.q(context, appWidgetManager, i11, z10);
        }

        public final void q(Context context, AppWidgetManager appWidgetManager, int i11, boolean z10) {
            Intrinsics.h(context, "context");
            Intrinsics.h(appWidgetManager, "appWidgetManager");
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i11);
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "SportWidget_", "=== Widget Size Debug ===", false, 4, null);
            c0856a.c("SportWidget_", "Raw size from system: " + appWidgetOptions.getInt("appWidgetMinWidth", 0) + "dp x " + appWidgetOptions.getInt("appWidgetMinHeight", 0) + "dp", true);
            a.C0856a.f(c0856a, "SportWidget_", "Design table standard (4x6): 138dp x 145dp", false, 4, null);
            a.C0856a.f(c0856a, "SportWidget_", "Max size from system: " + appWidgetOptions.getInt("appWidgetMaxWidth", 0) + "dp x " + appWidgetOptions.getInt("appWidgetMaxHeight", 0) + "dp", false, 4, null);
            if (Build.VERSION.SDK_INT >= 31) {
                a.C0856a.f(c0856a, "SportWidget_", "SizeF options: " + appWidgetOptions.getParcelableArrayList("appWidgetSizes"), false, 4, null);
            }
            Intrinsics.e(appWidgetOptions);
            Pair h11 = h(appWidgetOptions);
            int intValue = ((Number) h11.component1()).intValue();
            int intValue2 = ((Number) h11.component2()).intValue();
            a o11 = o(intValue, intValue2);
            int min = Math.min(intValue, o11.c());
            int a11 = (int) (o11.a() * 0.75f);
            int m11 = RangesKt.m(intValue2, a11, o11.a());
            a.C0856a.f(c0856a, "SportWidget_", "Base size: " + intValue + "dp x " + intValue2 + "dp", false, 4, null);
            c0856a.c("SportWidget_", "Reference size: " + o11.b() + " (" + o11.c() + "dp x " + o11.a() + "dp)", true);
            c0856a.c("SportWidget_", "Applied size: " + min + "dp x " + m11 + "dp (minContentHeight=" + a11 + ")", true);
            a.C0856a.f(c0856a, "SportWidget_", "========================", false, 4, null);
            k.d(o0.a(y0.b()), null, null, new SportSchedulePreviewWidgetProvider$Companion$updateWidget$1(context, min, m11, i11, z10, appWidgetManager, null), 3, null);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(newOptions, "newOptions");
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        a.C0856a.f(lg.a.f68962a, "SportWidget_", "SportWidgetProvider onAppWidgetOptionsChanged: appWidgetId=" + appWidgetId, false, 4, null);
        Companion.r(INSTANCE, context, appWidgetManager, appWidgetId, false, 8, null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.f46337a, "sport_desk_widget", false, null, 4, null);
        SportWidgetDataManager.f46300a.o();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        com.transsion.mbwidget.utils.a.l(com.transsion.mbwidget.utils.a.f46337a, "sport_desk_widget", true, null, 4, null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.h(context, "context");
        Intrinsics.h(intent, "intent");
        super.onReceive(context, intent);
        if (Intrinsics.c("android.intent.action.LOCALE_CHANGED", intent.getAction())) {
            a.C0856a.f(lg.a.f68962a, "SportWidget_", "Locale changed, refresh all sport widgets", false, 4, null);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) SportSchedulePreviewWidgetProvider.class));
            Intrinsics.e(appWidgetIds);
            for (int i11 : appWidgetIds) {
                Companion companion = INSTANCE;
                Intrinsics.e(appWidgetManager);
                companion.q(context, appWidgetManager, i11, false);
            }
            return;
        }
        if (Intrinsics.c("com.transsion.mbwidget.sport.ACTION_CLICK", intent.getAction())) {
            com.transsion.mbwidget.utils.a.f46337a.f(intent);
            SportWidgetDataManager.f46300a.p();
            String stringExtra = intent.getStringExtra("key_deeplink_widget");
            a.C0856a.f(lg.a.f68962a, "SportWidget_", "Sport widget clicked, deeplink: " + stringExtra, false, 4, null);
            if (stringExtra != null && stringExtra.length() != 0) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setFlags(ASTNode.DEOP);
                intent2.setData(Uri.parse(stringExtra));
                context.startActivity(intent2);
                return;
            }
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                return;
            }
            launchIntentForPackage.addFlags(ASTNode.DEOP);
            context.startActivity(launchIntentForPackage);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.h(context, "context");
        Intrinsics.h(appWidgetManager, "appWidgetManager");
        Intrinsics.h(appWidgetIds, "appWidgetIds");
        int[] appWidgetIds2 = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) SportSchedulePreviewWidgetProvider.class));
        Intrinsics.e(appWidgetIds2);
        if (appWidgetIds2.length == 0) {
            return;
        }
        Set P0 = ArraysKt.P0(appWidgetIds);
        if (P0.size() == 1) {
            SportWidgetDataManager.f46300a.e();
        }
        for (int i11 : appWidgetIds2) {
            boolean contains = P0.contains(Integer.valueOf(i11));
            a.C0856a.f(lg.a.f68962a, "SportWidget_", "SportWidgetProvider onUpdate: appWidgetId=" + i11 + " reportExposure=" + contains, false, 4, null);
            INSTANCE.q(context, appWidgetManager, i11, contains);
        }
    }
}
