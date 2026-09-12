package com.vungle.ads.internal.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes7.dex */
public final class l {
    public static final l INSTANCE = new l();

    private l() {
    }

    public final String convertForSending(String stringToConvert) throws IOException {
        Intrinsics.h(stringToConvert, "stringToConvert");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(stringToConvert.length());
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                byte[] bytes = stringToConvert.getBytes(Charsets.UTF_8);
                Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                Intrinsics.g(encodeToString, "encodeToString(compressed, Base64.NO_WRAP)");
                CloseableKt.a(gZIPOutputStream, null);
                CloseableKt.a(byteArrayOutputStream, null);
                return encodeToString;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(byteArrayOutputStream, th2);
                throw th3;
            }
        }
    }
}
