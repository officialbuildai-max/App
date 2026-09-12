package com.bytedance.sdk.component.Sj;

import android.text.TextUtils;

/* loaded from: classes2.dex */
class kF {
    private static boolean Sj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Sj() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String substring = Sj ? str.substring(1, str.length() - 1) : "";
        String concat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (substring.isEmpty()) {
            return concat + "}";
        }
        return concat + "," + substring + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Sj(Throwable th2) {
        StringBuilder sb2 = new StringBuilder("{\"code\":");
        sb2.append(th2 instanceof TzV ? ((TzV) th2).Sj : 0);
        sb2.append("}");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Sj(boolean z10) {
        Sj = z10;
    }
}
