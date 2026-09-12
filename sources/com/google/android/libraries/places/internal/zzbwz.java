package com.google.android.libraries.places.internal;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@JvmName
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class zzbwz {
    public static final int zza(zzbwp zzbwpVar, int i11) {
        int i12;
        Intrinsics.h(zzbwpVar, "<this>");
        int[] zzq = zzbwpVar.zzq();
        int length = zzbwpVar.zzr().length;
        Intrinsics.h(zzq, "<this>");
        int i13 = length - 1;
        int i14 = 0;
        while (true) {
            if (i14 <= i13) {
                int i15 = i11 + 1;
                i12 = (i14 + i13) >>> 1;
                int i16 = zzq[i12];
                if (i16 >= i15) {
                    if (i16 <= i15) {
                        break;
                    }
                    i13 = i12 - 1;
                } else {
                    i14 = i12 + 1;
                }
            } else {
                i12 = (-i14) - 1;
                break;
            }
        }
        return i12 >= 0 ? i12 : ~i12;
    }
}
