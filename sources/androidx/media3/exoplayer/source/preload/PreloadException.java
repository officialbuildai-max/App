package androidx.media3.exoplayer.source.preload;

import androidx.annotation.Nullable;
import androidx.media3.common.t;

/* loaded from: classes2.dex */
public final class PreloadException extends Exception {
    public final t mediaItem;

    public PreloadException(t tVar, @Nullable String str, @Nullable Throwable th2) {
        super(str, th2);
        this.mediaItem = tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        if (r3 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean errorInfoEquals(@androidx.annotation.Nullable androidx.media3.exoplayer.source.preload.PreloadException r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto L51
            java.lang.Throwable r2 = r6.getCause()
            java.lang.Throwable r3 = r7.getCause()
            if (r2 == 0) goto L31
            if (r3 == 0) goto L31
            java.lang.String r4 = r2.getMessage()
            java.lang.String r5 = r3.getMessage()
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 != 0) goto L22
            return r1
        L22:
            java.lang.Class r2 = r2.getClass()
            java.lang.Class r3 = r3.getClass()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L36
            return r1
        L31:
            if (r2 != 0) goto L51
            if (r3 == 0) goto L36
            goto L51
        L36:
            androidx.media3.common.t r2 = r6.mediaItem
            androidx.media3.common.t r3 = r7.mediaItem
            boolean r2 = java.util.Objects.equals(r2, r3)
            if (r2 == 0) goto L4f
            java.lang.String r2 = r6.getMessage()
            java.lang.String r7 = r7.getMessage()
            boolean r7 = java.util.Objects.equals(r2, r7)
            if (r7 == 0) goto L4f
            goto L50
        L4f:
            r0 = r1
        L50:
            return r0
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.preload.PreloadException.errorInfoEquals(androidx.media3.exoplayer.source.preload.PreloadException):boolean");
    }
}
