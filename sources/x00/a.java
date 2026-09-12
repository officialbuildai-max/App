package x00;

import java.util.Locale;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f78128a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f78129b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f78130c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f78131d;

    static {
        String property = System.getProperty("os.name");
        Locale locale = Locale.US;
        f78128a = property.toLowerCase(locale);
        f78129b = System.getProperty("os.arch").toLowerCase(locale);
        f78130c = System.getProperty("os.version").toLowerCase(locale);
        f78131d = System.getProperty("path.separator");
    }

    public static boolean a(String str) {
        return c(str, null, null, null);
    }

    public static boolean b(String str) {
        return c(null, str, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r6 != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        if (r7 != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if (r2.indexOf("os/2") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        if (r2.indexOf("netware") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a2, code lost:
    
        if (a("netware") == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
    
        if (r2.indexOf("mac") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c4, code lost:
    
        if (r2.indexOf("nonstop_kernel") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ee, code lost:
    
        if (r2.endsWith("x") != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0105, code lost:
    
        if (r2.indexOf("os/390") <= (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0114, code lost:
    
        if (r2.indexOf("os/400") > (-1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0121, code lost:
    
        if (r2.indexOf("openvms") > (-1)) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x00.a.c(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
