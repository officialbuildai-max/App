package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes4.dex */
public class zzbwv {
    public static final zzbwu zzb = new zzbwu(null);

    @JvmField
    public static final zzbwv zzc = new zzbwt();

    public static final void zzb() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
    }
}
