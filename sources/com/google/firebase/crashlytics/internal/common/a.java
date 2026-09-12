package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f31191a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31192b;

    /* renamed from: c, reason: collision with root package name */
    public final List f31193c;

    /* renamed from: d, reason: collision with root package name */
    public final String f31194d;

    /* renamed from: e, reason: collision with root package name */
    public final String f31195e;

    /* renamed from: f, reason: collision with root package name */
    public final String f31196f;

    /* renamed from: g, reason: collision with root package name */
    public final String f31197g;

    /* renamed from: h, reason: collision with root package name */
    public final ob.f f31198h;

    public a(String str, String str2, List list, String str3, String str4, String str5, String str6, ob.f fVar) {
        this.f31191a = str;
        this.f31192b = str2;
        this.f31193c = list;
        this.f31194d = str3;
        this.f31195e = str4;
        this.f31196f = str5;
        this.f31197g = str6;
        this.f31198h = fVar;
    }

    public static a a(Context context, g0 g0Var, String str, String str2, List list, ob.f fVar) {
        String packageName = context.getPackageName();
        String g11 = g0Var.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b11 = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, list, g11, packageName, b11, str3, fVar);
    }

    private static String b(PackageInfo packageInfo) {
        long longVersionCode;
        if (Build.VERSION.SDK_INT < 28) {
            return Integer.toString(packageInfo.versionCode);
        }
        longVersionCode = packageInfo.getLongVersionCode();
        return Long.toString(longVersionCode);
    }
}
