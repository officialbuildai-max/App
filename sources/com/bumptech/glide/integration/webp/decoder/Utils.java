package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
class Utils {
    private static final String TAG = "Utils";

    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSampleSize(int i11, int i12, int i13, int i14) {
        int min = Math.min(i12 / i14, i11 / i13);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(TAG, 2) && max > 1) {
            Log.v(TAG, "Downsampling WEBP, sampleSize: " + max + ", target dimens: [" + i13 + "x" + i14 + "], actual dimens: [" + i11 + "x" + i12 + "]");
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e11) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Error reading data from stream", e11);
            return null;
        }
    }
}
