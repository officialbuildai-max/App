package com.google.android.libraries.places.internal;

import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes4.dex */
public final class zzbwe {
    private zzbwe() {
        throw null;
    }

    public /* synthetic */ zzbwe(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @JvmStatic
    public static final zzbwf zza(String str) {
        Intrinsics.h(str, "<this>");
        zzbwf zzbwfVar = new zzbwf(zzbww.zzb(str));
        zzbwfVar.zzi(str);
        return zzbwfVar;
    }

    @JvmStatic
    public static final zzbwf zzb(byte... data) {
        Intrinsics.h(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.g(copyOf, "copyOf(...)");
        return new zzbwf(copyOf);
    }
}
