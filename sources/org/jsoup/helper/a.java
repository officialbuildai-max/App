package org.jsoup.helper;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.m;
import org.jsoup.parser.e;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f71810a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f71811b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.jsoup.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0895a {

        /* renamed from: a, reason: collision with root package name */
        private final String f71812a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f71813b;

        public C0895a(String str, boolean z10) {
            this.f71812a = str;
            this.f71813b = z10;
        }
    }

    private static C0895a a(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b11 = bArr[0];
        if ((b11 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b11 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new C0895a("UTF-32", false);
        }
        if ((b11 == -2 && bArr[1] == -1) || (b11 == -1 && bArr[1] == -2)) {
            return new C0895a(C.UTF16_NAME, false);
        }
        if (b11 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new C0895a("UTF-8", true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer b() {
        return ByteBuffer.allocate(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f71810a.matcher(str);
        if (matcher.find()) {
            return g(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        StringBuilder sb2 = new StringBuilder(32);
        Random random = new Random();
        for (int i11 = 0; i11 < 32; i11++) {
            char[] cArr = f71811b;
            sb2.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Document e(InputStream inputStream, String str, String str2, e eVar) {
        if (inputStream == null) {
            return new Document(str2);
        }
        e10.a k11 = e10.a.k(inputStream, 32768, 0);
        k11.mark(32768);
        ByteBuffer f11 = f(k11, 5119);
        boolean z10 = k11.read() == -1;
        k11.reset();
        C0895a a11 = a(f11);
        if (a11 != null) {
            str = a11.f71812a;
        }
        Document document = null;
        if (str == null) {
            Document f12 = eVar.f(Charset.forName("UTF-8").decode(f11).toString(), str2);
            Iterator<Element> it = f12.R0("meta[http-equiv=content-type], meta[charset]").iterator();
            String str3 = null;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.w("http-equiv")) {
                    str3 = c(next.f("content"));
                }
                if (str3 == null && next.w("charset")) {
                    str3 = next.f("charset");
                }
                if (str3 != null) {
                    break;
                }
            }
            if (str3 == null && f12.n() > 0 && (f12.m(0) instanceof m)) {
                m mVar = (m) f12.m(0);
                if (mVar.d0().equals("xml")) {
                    str3 = mVar.f("encoding");
                }
            }
            String g11 = g(str3);
            if (g11 != null && !g11.equalsIgnoreCase("UTF-8")) {
                str = g11.trim().replaceAll("[\"']", "");
            } else if (z10) {
                document = f12;
            }
        } else {
            d.i(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (document == null) {
            String str4 = str != null ? str : "UTF-8";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(k11, str4), 32768);
            if (a11 != null && a11.f71813b) {
                bufferedReader.skip(1L);
            }
            try {
                document = eVar.e(bufferedReader, str2);
                document.g1().b(str4);
            } catch (UncheckedIOException e11) {
                throw e11.ioException();
            }
        }
        k11.close();
        return document;
    }

    public static ByteBuffer f(InputStream inputStream, int i11) {
        d.e(i11 >= 0, "maxSize must be 0 (unlimited) or larger");
        return e10.a.k(inputStream, 32768, i11).h(i11);
    }

    private static String g(String str) {
        if (str != null && str.length() != 0) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }
}
