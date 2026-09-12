package com.amazonaws.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class SdkDigestInputStream extends DigestInputStream implements MetricAware {
    public SdkDigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream, messageDigest);
    }

    @Override // com.amazonaws.internal.MetricAware
    public final boolean d() {
        if (((DigestInputStream) this).in instanceof MetricAware) {
            return ((MetricAware) ((DigestInputStream) this).in).d();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j11) {
        if (j11 <= 0) {
            return j11;
        }
        int min = (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, j11);
        byte[] bArr = new byte[min];
        long j12 = j11;
        while (j12 > 0) {
            int read = read(bArr, 0, (int) Math.min(j12, min));
            if (read == -1) {
                if (j12 == j11) {
                    return -1L;
                }
                return j11 - j12;
            }
            j12 -= read;
        }
        return j11;
    }
}
