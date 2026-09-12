package org.chromium.net;

/* loaded from: classes.dex */
public abstract class QuicException extends NetworkException {
    protected QuicException(String str, Throwable th2) {
        super(str, th2);
    }

    public abstract int getQuicDetailedErrorCode();
}
