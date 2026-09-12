package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DataSourceException extends IOException {

    @Deprecated
    public static final int POSITION_OUT_OF_RANGE = 2008;
    public final int reason;

    public DataSourceException(int i11) {
        this.reason = i11;
    }

    public DataSourceException(@Nullable String str, int i11) {
        super(str);
        this.reason = i11;
    }

    public DataSourceException(@Nullable String str, @Nullable Throwable th2, int i11) {
        super(str, th2);
        this.reason = i11;
    }

    public DataSourceException(@Nullable Throwable th2, int i11) {
        super(th2);
        this.reason = i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isCausedByPositionOutOfRange(java.io.IOException r2) {
        /*
        L0:
            if (r2 == 0) goto L16
            boolean r0 = r2 instanceof com.google.android.exoplayer2.upstream.DataSourceException
            if (r0 == 0) goto L11
            r0 = r2
            com.google.android.exoplayer2.upstream.DataSourceException r0 = (com.google.android.exoplayer2.upstream.DataSourceException) r0
            int r0 = r0.reason
            r1 = 2008(0x7d8, float:2.814E-42)
            if (r0 != r1) goto L11
            r2 = 1
            return r2
        L11:
            java.lang.Throwable r2 = r2.getCause()
            goto L0
        L16:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DataSourceException.isCausedByPositionOutOfRange(java.io.IOException):boolean");
    }
}
