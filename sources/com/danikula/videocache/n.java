package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes3.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j11, int i11) {
        l.d(bArr, "Buffer must be not null!");
        boolean z10 = false;
        l.b(j11 >= 0, "Data offset must be positive!");
        if (i11 >= 0 && i11 <= bArr.length) {
            z10 = true;
        }
        l.b(z10, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }
}
