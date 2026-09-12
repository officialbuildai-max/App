package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes4.dex */
class i0 {

    /* renamed from: a, reason: collision with root package name */
    private String f31242a;

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        try {
            if (this.f31242a == null) {
                this.f31242a = b(context);
            }
        } finally {
        }
        return "".equals(this.f31242a) ? null : this.f31242a;
    }
}
