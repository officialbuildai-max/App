package com.cloud.hisavana.sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;
import com.cloud.hisavana.sdk.common.activity.MiniAppSchemeActivity;
import com.cloud.hisavana.sdk.common.bean.MiniAppInfo;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.tmc.kernel.constants.TmcConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes3.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static final y0 f23189a = new y0();

    /* renamed from: b, reason: collision with root package name */
    private static z0 f23190b;

    /* renamed from: c, reason: collision with root package name */
    private static Function1 f23191c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "result", "", "a", "(I)V"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f23192a = new a();

        a() {
            super(1);
        }

        public final void a(int i11) {
            y0.f23189a.k();
            Function1 function1 = y0.f23191c;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i11));
            }
            y0.f23191c = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.f67184a;
        }
    }

    private y0() {
    }

    private final void e(String str) {
        k();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_add_item_result_receiver");
        f23190b = new z0(str, a.f23192a);
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                j().registerReceiver(f23190b, intentFilter, 2);
            } else {
                j().registerReceiver(f23190b, intentFilter);
            }
        } catch (Throwable th2) {
            e4.b().e(TmcConstants.DIR_BYTEAPP, "Failed to register broadcast receiver: " + Log.getStackTraceString(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r7 == null) goto L9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(java.lang.String r7, final android.content.pm.ShortcutInfo.Builder r8, final android.content.pm.ShortcutManager r9, final com.cloud.hisavana.sdk.common.bean.MiniAppInfo r10, final kotlin.jvm.functions.Function1 r11) {
        /*
            java.lang.String r0 = "$builder"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            java.lang.String r0 = "$onAddResult"
            kotlin.jvm.internal.Intrinsics.h(r11, r0)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            if (r7 == 0) goto L16
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeFile(r7)     // Catch: java.lang.Exception -> L2d
            goto L17
        L16:
            r7 = 0
        L17:
            if (r7 == 0) goto L1f
            android.graphics.drawable.Icon r7 = android.graphics.drawable.Icon.createWithBitmap(r7)     // Catch: java.lang.Exception -> L2d
            if (r7 != 0) goto L2b
        L1f:
            com.cloud.hisavana.sdk.y0 r7 = com.cloud.hisavana.sdk.y0.f23189a     // Catch: java.lang.Exception -> L2d
            android.content.Context r7 = r7.j()     // Catch: java.lang.Exception -> L2d
            int r0 = com.cloud.hisavana.sdk.R$drawable.hs_ad_miniapp_default_icon     // Catch: java.lang.Exception -> L2d
            android.graphics.drawable.Icon r7 = android.graphics.drawable.Icon.createWithResource(r7, r0)     // Catch: java.lang.Exception -> L2d
        L2b:
            r2.element = r7     // Catch: java.lang.Exception -> L2d
        L2d:
            com.cloud.hisavana.sdk.b6 r7 = new com.cloud.hisavana.sdk.b6
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r1.<init>()
            com.cloud.sdk.commonutil.util.Preconditions.d(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.y0.f(java.lang.String, android.content.pm.ShortcutInfo$Builder, android.content.pm.ShortcutManager, com.cloud.hisavana.sdk.common.bean.MiniAppInfo, kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Ref.ObjectRef icon, ShortcutInfo.Builder builder, ShortcutManager shortcutManager, MiniAppInfo miniAppInfo, Function1 onAddResult) {
        ShortcutInfo build;
        Intent createShortcutResultIntent;
        Intrinsics.h(icon, "$icon");
        Intrinsics.h(builder, "$builder");
        Intrinsics.h(onAddResult, "$onAddResult");
        try {
            Icon icon2 = (Icon) icon.element;
            if (icon2 != null) {
                builder.setIcon(icon2);
            }
            build = builder.build();
            Intrinsics.g(build, "build(...)");
            createShortcutResultIntent = shortcutManager.createShortcutResultIntent(build);
            y0 y0Var = f23189a;
            PendingIntent broadcast = PendingIntent.getBroadcast(y0Var.j(), 99, createShortcutResultIntent, 67108864);
            String appId = miniAppInfo.getAppId();
            Intrinsics.g(appId, "getAppId(...)");
            y0Var.e(appId);
            shortcutManager.requestPinShortcut(build, broadcast != null ? broadcast.getIntentSender() : null);
        } catch (Exception e11) {
            e4.b().e(TmcConstants.DIR_BYTEAPP, "Failed to add to homescreen: " + Log.getStackTraceString(e11));
            onAddResult.invoke(-1);
        }
    }

    private final Context j() {
        return com.cloud.sdk.commonutil.util.e.a().getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        z0 z0Var = f23190b;
        if (z0Var != null) {
            try {
                f23189a.j().unregisterReceiver(z0Var);
            } catch (Throwable th2) {
                e4.b().e(TmcConstants.DIR_BYTEAPP, "Failed to unregister broadcast receiver: " + Log.getStackTraceString(th2));
            }
        }
        f23190b = null;
    }

    public final void g(final String str, final MiniAppInfo miniAppInfo, final Function1 onAddResult) {
        boolean isRequestPinShortcutSupported;
        List pinnedShortcuts;
        Object obj;
        ShortcutInfo.Builder intent;
        ShortcutInfo.Builder shortLabel;
        final ShortcutInfo.Builder extras;
        String id2;
        Intrinsics.h(onAddResult, "onAddResult");
        if (j() == null || miniAppInfo == null) {
            onAddResult.invoke(-1);
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            onAddResult.invoke(-1);
            return;
        }
        try {
            final ShortcutManager a11 = com.bytedance.sdk.openadsdk.api.init.b.a(j().getSystemService(com.bytedance.sdk.openadsdk.api.init.a.a()));
            if (a11 != null) {
                isRequestPinShortcutSupported = a11.isRequestPinShortcutSupported();
                if (isRequestPinShortcutSupported) {
                    pinnedShortcuts = a11.getPinnedShortcuts();
                    Intrinsics.g(pinnedShortcuts, "getPinnedShortcuts(...)");
                    Iterator it = pinnedShortcuts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        id2 = t5.a(obj).getId();
                        if (Intrinsics.c(id2, miniAppInfo.getAppId())) {
                            break;
                        }
                    }
                    if (t5.a(obj) != null) {
                        onAddResult.invoke(2);
                        return;
                    }
                    f23191c = onAddResult;
                    r5.a();
                    ShortcutInfo.Builder a12 = o5.a(j(), miniAppInfo.getAppId());
                    Intent intent2 = new Intent(j(), (Class<?>) MiniAppSchemeActivity.class);
                    intent2.setAction(miniAppInfo.getAppId());
                    intent2.putExtra("deeplink", miniAppInfo.getDeepLinkUrl());
                    intent = a12.setIntent(intent2);
                    shortLabel = intent.setShortLabel(miniAppInfo.getName());
                    PersistableBundle persistableBundle = new PersistableBundle();
                    persistableBundle.putString("appId", miniAppInfo.getAppId());
                    persistableBundle.putBoolean(TmcConstants.EXTRA_ADD_HOME_SHOW_SYSTEM_DIALOG, false);
                    extras = shortLabel.setExtras(persistableBundle);
                    Intrinsics.g(extras, "setExtras(...)");
                    HSScopeHelper.f23249a.g(new Runnable() { // from class: com.cloud.hisavana.sdk.a6
                        @Override // java.lang.Runnable
                        public final void run() {
                            y0.f(str, extras, a11, miniAppInfo, onAddResult);
                        }
                    });
                    return;
                }
            }
            onAddResult.invoke(-1);
        } catch (Throwable th2) {
            e4.b().e(TmcConstants.DIR_BYTEAPP, "Failed to create shortcut: " + Log.getStackTraceString(th2));
            onAddResult.invoke(-1);
        }
    }
}
