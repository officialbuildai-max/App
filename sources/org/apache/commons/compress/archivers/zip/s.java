package org.apache.commons.compress.archivers.zip;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;

/* loaded from: classes7.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    static final r f71312a = a("UTF8");

    public static r a(String str) {
        Charset defaultCharset = Charset.defaultCharset();
        if (str != null) {
            try {
                defaultCharset = Charset.forName(str);
            } catch (UnsupportedCharsetException unused) {
            }
        }
        return new e(defaultCharset, b(defaultCharset.name()));
    }

    static boolean b(String str) {
        if (str == null) {
            str = Charset.defaultCharset().name();
        }
        Charset charset = StandardCharsets.UTF_8;
        if (charset.name().equalsIgnoreCase(str)) {
            return true;
        }
        Iterator<String> it = charset.aliases().iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
