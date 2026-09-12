package w00;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.StringCharacterIterator;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean[] f77616a = new boolean[128];

    /* renamed from: b, reason: collision with root package name */
    private static char[] f77617b = new char[128];

    /* renamed from: c, reason: collision with root package name */
    private static char[] f77618c = new char[128];

    /* renamed from: d, reason: collision with root package name */
    private static char[] f77619d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static {
        for (int i11 = 0; i11 < 32; i11++) {
            f77616a[i11] = true;
            char[] cArr = f77617b;
            char[] cArr2 = f77619d;
            cArr[i11] = cArr2[i11 >> 4];
            f77618c[i11] = cArr2[i11 & 15];
        }
        f77616a[127] = true;
        f77617b[127] = '7';
        f77618c[127] = 'F';
        char[] cArr3 = {' ', '<', '>', '#', '%', '\"', '{', '}', '|', '\\', '^', '~', '[', ']', '`'};
        for (int i12 = 0; i12 < 15; i12++) {
            char c11 = cArr3[i12];
            f77616a[c11] = true;
            char[] cArr4 = f77617b;
            char[] cArr5 = f77619d;
            cArr4[c11] = cArr5[c11 >> 4];
            f77618c[c11] = cArr5[c11 & 15];
        }
    }

    public static String a(String str) {
        if (str.indexOf(37) == -1) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '%') {
                char next = stringCharacterIterator.next();
                if (next != 65535) {
                    int digit = Character.digit(next, 16);
                    char next2 = stringCharacterIterator.next();
                    if (next2 != 65535) {
                        byteArrayOutputStream.write((char) ((digit << 4) + Character.digit(next2, 16)));
                    }
                }
            } else {
                byteArrayOutputStream.write(first);
            }
        }
        return byteArrayOutputStream.toString("UTF-8");
    }

    public static String b(String str) {
        char charAt;
        int length = str.length();
        StringBuffer stringBuffer = null;
        int i11 = 0;
        while (i11 < length && (charAt = str.charAt(i11)) < 128) {
            if (f77616a[charAt]) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(str.substring(0, i11));
                }
                stringBuffer.append('%');
                stringBuffer.append(f77617b[charAt]);
                stringBuffer.append(f77618c[charAt]);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
            i11++;
        }
        if (i11 < length) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer(str.substring(0, i11));
            }
            for (byte b11 : str.substring(i11).getBytes("UTF-8")) {
                if (b11 < 0) {
                    int i12 = b11 + 256;
                    stringBuffer.append('%');
                    stringBuffer.append(f77619d[i12 >> 4]);
                    stringBuffer.append(f77619d[i12 & 15]);
                } else if (f77616a[b11]) {
                    stringBuffer.append('%');
                    stringBuffer.append(f77617b[b11]);
                    stringBuffer.append(f77618c[b11]);
                } else {
                    stringBuffer.append((char) b11);
                }
            }
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    public static String c(String str) {
        return d(str);
    }

    static String d(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null || !OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE.equals(url.getProtocol())) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can only handle valid file: URIs, not ");
            stringBuffer.append(str);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer(url.getHost());
        if (stringBuffer2.length() > 0) {
            char c11 = File.separatorChar;
            stringBuffer2.insert(0, c11).insert(0, c11);
        }
        String file = url.getFile();
        int indexOf = file.indexOf(63);
        if (indexOf >= 0) {
            file = file.substring(0, indexOf);
        }
        stringBuffer2.append(file);
        String replace = stringBuffer2.toString().replace('/', File.separatorChar);
        if (File.pathSeparatorChar == ';' && replace.startsWith("\\") && replace.length() > 2 && Character.isLetter(replace.charAt(1)) && replace.lastIndexOf(58) > -1) {
            replace = replace.substring(1);
        }
        try {
            String a11 = a(replace);
            String property = System.getProperty("user.dir");
            int indexOf2 = property.indexOf(":");
            if (indexOf2 <= 0 || !a11.startsWith(File.separator)) {
                return a11;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(property.substring(0, indexOf2 + 1));
            stringBuffer3.append(a11);
            return stringBuffer3.toString();
        } catch (UnsupportedEncodingException e11) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not convert URI ");
            stringBuffer4.append(replace);
            stringBuffer4.append(" to path: ");
            stringBuffer4.append(e11.getMessage());
            throw new IllegalStateException(stringBuffer4.toString());
        }
    }
}
