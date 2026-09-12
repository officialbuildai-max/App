package ak;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f707a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f708b = new HashMap();

    private d() {
    }

    public static final String c(Context context) {
        Intrinsics.h(context, "context");
        ArrayList d11 = f707a.d(context, "SHA1");
        if (d11 == null || d11.isEmpty()) {
            return "";
        }
        Object obj = d11.get(0);
        Intrinsics.g(obj, "get(...)");
        return (String) obj;
    }

    private final String e(Signature signature, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(signature.toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                String hexString = Integer.toHexString((b11 & 255) | 256);
                Intrinsics.g(hexString, "toHexString(...)");
                String substring = hexString.substring(1, 3);
                Intrinsics.g(substring, "substring(...)");
                String upperCase = substring.toUpperCase(Locale.ROOT);
                Intrinsics.g(upperCase, "toUpperCase(...)");
                sb2.append(upperCase);
                sb2.append(":");
            }
            return sb2.substring(0, sb2.length() - 1).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r3 = Abdullah.hook.a.getApkContentsSigners(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.content.pm.Signature[] f(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            r4 = 0
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Exception -> L26
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L26
            r1 = 28
            if (r0 < r1) goto L2b
            android.app.Application r0 = com.blankj.utilcode.util.Utils.a()     // Catch: java.lang.Exception -> L26
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Exception -> L26
            r1 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r0, r1)     // Catch: java.lang.Exception -> L26
            android.content.pm.SigningInfo r3 = com.cloud.tmc.miniutils.util.a.a(r3)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L28
            android.content.pm.Signature[] r3 = com.cloud.tmc.miniutils.util.c.a(r3)     // Catch: java.lang.Exception -> L26
            if (r3 != 0) goto L2a
            goto L28
        L26:
            r3 = move-exception
            goto L40
        L28:
            android.content.pm.Signature[] r3 = new android.content.pm.Signature[r4]     // Catch: java.lang.Exception -> L26
        L2a:
            return r3
        L2b:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.a()     // Catch: java.lang.Exception -> L26
            java.lang.String r0 = r0.getPackageName()     // Catch: java.lang.Exception -> L26
            r1 = 64
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r0, r1)     // Catch: java.lang.Exception -> L26
            android.content.pm.Signature[] r3 = r3.signatures     // Catch: java.lang.Exception -> L26
            if (r3 != 0) goto L3f
            android.content.pm.Signature[] r3 = new android.content.pm.Signature[r4]     // Catch: java.lang.Exception -> L26
        L3f:
            return r3
        L40:
            r3.printStackTrace()
            android.content.pm.Signature[] r3 = new android.content.pm.Signature[r4]
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ak.d.f(android.content.Context, java.lang.String):android.content.pm.Signature[]");
    }

    public final String a(Context context) {
        Intrinsics.h(context, "context");
        ArrayList d11 = d(context, "MD5");
        if (d11 == null || d11.isEmpty()) {
            return "";
        }
        Object obj = d11.get(0);
        Intrinsics.g(obj, "get(...)");
        return (String) obj;
    }

    public final String b(Context context) {
        Intrinsics.h(context, "context");
        ArrayList d11 = d(context, "SHA256");
        if (d11 == null || d11.isEmpty()) {
            return "";
        }
        Object obj = d11.get(0);
        Intrinsics.g(obj, "get(...)");
        return (String) obj;
    }

    public final ArrayList d(Context context, String str) {
        String e11;
        ArrayList arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            ArrayList arrayList2 = (ArrayList) f708b.get(str);
            if (arrayList2 != null) {
                return arrayList2;
            }
            arrayList = new ArrayList();
            try {
                for (Signature signature : f(context, packageName)) {
                    int hashCode = str.hashCode();
                    if (hashCode == -1850268089) {
                        if (str.equals("SHA256")) {
                            e11 = e(signature, "SHA256");
                            arrayList.add(e11);
                        }
                        e11 = "error!";
                        arrayList.add(e11);
                    } else if (hashCode != 76158) {
                        if (hashCode == 2543909 && str.equals("SHA1")) {
                            e11 = e(signature, "SHA1");
                            arrayList.add(e11);
                        }
                        e11 = "error!";
                        arrayList.add(e11);
                    } else {
                        if (str.equals("MD5")) {
                            e11 = e(signature, "MD5");
                            arrayList.add(e11);
                        }
                        e11 = "error!";
                        arrayList.add(e11);
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
            f708b.put(str, arrayList);
        }
        return arrayList;
    }
}
