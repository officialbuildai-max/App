package com.cloud.tmc.miniutils.util;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes3.dex */
public class HttpUtils {
    public static long getContentLength(String str) {
        long j11 = 0;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpURLConnection.setRequestMethod("HEAD");
            j11 = httpURLConnection.getContentLength();
            httpURLConnection.disconnect();
            return j11;
        } catch (Throwable unused) {
            return j11;
        }
    }
}
