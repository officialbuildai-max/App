package com.airbnb.lottie;

import android.os.Build;
import java.util.HashSet;

/* loaded from: classes2.dex */
class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f17841a = new HashSet();

    public boolean a(LottieFeatureFlag lottieFeatureFlag, boolean z10) {
        if (!z10) {
            return this.f17841a.remove(lottieFeatureFlag);
        }
        if (Build.VERSION.SDK_INT >= lottieFeatureFlag.minRequiredSdkVersion) {
            return this.f17841a.add(lottieFeatureFlag);
        }
        v4.f.c(String.format("%s is not supported pre SDK %d", lottieFeatureFlag.name(), Integer.valueOf(lottieFeatureFlag.minRequiredSdkVersion)));
        return false;
    }

    public boolean b(LottieFeatureFlag lottieFeatureFlag) {
        return this.f17841a.contains(lottieFeatureFlag);
    }
}
