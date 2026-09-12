package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import xc.h;

/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(Context context) {
        int i11;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || Build.VERSION.SDK_INT < 24) {
            return "";
        }
        i11 = applicationInfo.minSdkVersion;
        return String.valueOf(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? "auto" : (Build.VERSION.SDK_INT < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? i(installerPackageName) : "";
    }

    private static String i(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(xc.c.b());
        arrayList.add(com.google.firebase.heartbeatinfo.a.g());
        arrayList.add(xc.h.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(xc.h.b("fire-core", "22.0.1"));
        arrayList.add(xc.h.b("device-name", i(Build.PRODUCT)));
        arrayList.add(xc.h.b("device-model", i(Build.DEVICE)));
        arrayList.add(xc.h.b("device-brand", i(Build.BRAND)));
        arrayList.add(xc.h.c("android-target-sdk", new h.a() { // from class: com.google.firebase.h
            @Override // xc.h.a
            public final String a(Object obj) {
                String e11;
                e11 = FirebaseCommonRegistrar.e((Context) obj);
                return e11;
            }
        }));
        arrayList.add(xc.h.c("android-min-sdk", new h.a() { // from class: com.google.firebase.i
            @Override // xc.h.a
            public final String a(Object obj) {
                String f11;
                f11 = FirebaseCommonRegistrar.f((Context) obj);
                return f11;
            }
        }));
        arrayList.add(xc.h.c("android-platform", new h.a() { // from class: com.google.firebase.j
            @Override // xc.h.a
            public final String a(Object obj) {
                String g11;
                g11 = FirebaseCommonRegistrar.g((Context) obj);
                return g11;
            }
        }));
        arrayList.add(xc.h.c("android-installer", new h.a() { // from class: com.google.firebase.k
            @Override // xc.h.a
            public final String a(Object obj) {
                String h11;
                h11 = FirebaseCommonRegistrar.h((Context) obj);
                return h11;
            }
        }));
        String a11 = xc.e.a();
        if (a11 != null) {
            arrayList.add(xc.h.b("kotlin", a11));
        }
        return arrayList;
    }
}
