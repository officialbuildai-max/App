package hx;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public final class a {
    private final boolean b(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", str != null ? Uri.parse(str) : null);
            intent.addFlags(ASTNode.DEOP);
            if (context == null) {
                return true;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r8, android.content.Context r9, com.transsion.version.update.RemoteVersionInfo r10) {
        /*
            r7 = this;
            java.lang.String r0 = "fromPage"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            r0 = 0
            if (r10 == 0) goto Ld
            java.lang.String r1 = r10.getAppStoreUrl()
            goto Le
        Ld:
            r1 = r0
        Le:
            if (r10 == 0) goto L15
            java.lang.String r10 = r10.getWebDownloadUrl()
            goto L16
        L15:
            r10 = r0
        L16:
            r2 = 1
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = "android.intent.action.VIEW"
            if (r1 == 0) goto L24
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch: java.lang.Exception -> L22
            goto L25
        L22:
            r0 = move-exception
            goto L48
        L24:
            r5 = r0
        L25:
            r3.<init>(r4, r5)     // Catch: java.lang.Exception -> L22
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r3.addFlags(r4)     // Catch: java.lang.Exception -> L22
            if (r9 == 0) goto L39
            android.content.pm.PackageManager r4 = r9.getPackageManager()     // Catch: java.lang.Exception -> L22
            if (r4 == 0) goto L39
            android.content.ComponentName r0 = r3.resolveActivity(r4)     // Catch: java.lang.Exception -> L22
        L39:
            if (r0 == 0) goto L40
            r9.startActivity(r3)     // Catch: java.lang.Exception -> L22
            r9 = 0
            goto L50
        L40:
            boolean r9 = r7.b(r9, r10)     // Catch: java.lang.Exception -> L22
        L44:
            r6 = r2
            r2 = r9
            r9 = r6
            goto L50
        L48:
            r0.printStackTrace()
            boolean r9 = r7.b(r9, r10)
            goto L44
        L50:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.lang.String r3 = "action"
            java.lang.String r4 = "jump"
            r0.put(r3, r4)
            java.lang.String r3 = ""
            if (r1 != 0) goto L61
            r1 = r3
        L61:
            java.lang.String r4 = "store_uri"
            r0.put(r4, r1)
            if (r10 != 0) goto L69
            r10 = r3
        L69:
            java.lang.String r1 = "web_uri"
            r0.put(r1, r10)
            java.lang.String r10 = "action_result"
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.put(r10, r1)
            if (r9 != 0) goto L7c
            java.lang.String r9 = "store"
            goto L7e
        L7c:
            java.lang.String r9 = "web"
        L7e:
            java.lang.String r10 = "type"
            r0.put(r10, r9)
            java.lang.String r9 = "page_from"
            r0.put(r9, r8)
            java.lang.String r8 = "dialog_type"
            java.lang.String r9 = "mb"
            r0.put(r8, r9)
            com.transsion.version.update.e r8 = com.transsion.version.update.e.f57661a
            r8.b(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: hx.a.a(java.lang.String, android.content.Context, com.transsion.version.update.RemoteVersionInfo):boolean");
    }
}
