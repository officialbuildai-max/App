package org.apache.tools.ant.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static final d f71681d = new d();

    /* renamed from: e, reason: collision with root package name */
    private static Random f71682e = new Random(System.currentTimeMillis() + Runtime.getRuntime().freeMemory());

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f71683f = x00.a.a("netware");

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f71684g = x00.a.a("dos");

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f71685h = x00.a.a("win9x");

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f71686i = x00.a.a("windows");

    /* renamed from: j, reason: collision with root package name */
    static /* synthetic */ Class f71687j;

    /* renamed from: a, reason: collision with root package name */
    private Object f71688a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private String f71689b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f71690c = null;

    protected d() {
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void c(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void e(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void g(File file) {
        if (file != null) {
            file.delete();
        }
    }

    public static d k() {
        return f71681d;
    }

    public static boolean l(String str) {
        int indexOf;
        int length = str.length();
        if (length == 0) {
            return false;
        }
        char c11 = File.separatorChar;
        String replace = str.replace('/', c11).replace('\\', c11);
        char charAt = replace.charAt(0);
        boolean z10 = f71684g;
        if (!z10 && !f71683f) {
            return charAt == c11;
        }
        if (charAt == c11) {
            return z10 && length > 4 && replace.charAt(1) == c11 && (indexOf = replace.indexOf(c11, 2)) > 2 && indexOf + 1 < length;
        }
        int indexOf2 = replace.indexOf(58);
        return (Character.isLetter(charAt) && indexOf2 == 1 && replace.length() > 2 && replace.charAt(2) == c11) || (f71683f && indexOf2 > 0);
    }

    public static boolean m(String str) {
        if ((!f71684g && !f71683f) || str.length() == 0) {
            return false;
        }
        char c11 = File.separatorChar;
        String replace = str.replace('/', c11).replace('\\', c11);
        char charAt = replace.charAt(0);
        int length = replace.length();
        if (charAt != c11 || (length != 1 && replace.charAt(1) == c11)) {
            if (!Character.isLetter(charAt) || length <= 1 || replace.indexOf(58) != 1) {
                return false;
            }
            if (length != 2 && replace.charAt(2) == c11) {
                return false;
            }
        }
        return true;
    }

    public File f(String str, String str2, File file, boolean z10, boolean z11) {
        File createTempFile;
        File file2;
        String property = file == null ? System.getProperty("java.io.tmpdir") : file.getPath();
        if (z11) {
            try {
                createTempFile = File.createTempFile(str, str2, new File(property));
            } catch (IOException e11) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not create tempfile in ");
                stringBuffer.append(property);
                throw new BuildException(stringBuffer.toString(), e11);
            }
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#####");
            synchronized (f71682e) {
                do {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append(decimalFormat.format(Math.abs(f71682e.nextInt())));
                    stringBuffer2.append(str2);
                    file2 = new File(property, stringBuffer2.toString());
                } while (file2.exists());
            }
            createTempFile = file2;
        }
        if (z10) {
            createTempFile.deleteOnExit();
        }
        return createTempFile;
    }

    public String[] h(String str) {
        String str2;
        String substring;
        char c11 = File.separatorChar;
        String replace = str.replace('/', c11).replace('\\', c11);
        if (!l(replace)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(replace);
            stringBuffer.append(" is not an absolute path");
            throw new BuildException(stringBuffer.toString());
        }
        int indexOf = replace.indexOf(58);
        if (indexOf > 0 && (f71684g || f71683f)) {
            int i11 = indexOf + 1;
            String substring2 = replace.substring(0, i11);
            char[] charArray = replace.toCharArray();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(substring2);
            stringBuffer2.append(c11);
            str2 = stringBuffer2.toString();
            if (charArray[i11] == c11) {
                i11 = indexOf + 2;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            while (i11 < charArray.length) {
                char c12 = charArray[i11];
                if (c12 != c11 || charArray[i11 - 1] != c11) {
                    stringBuffer3.append(c12);
                }
                i11++;
            }
            substring = stringBuffer3.toString();
        } else if (replace.length() <= 1 || replace.charAt(1) != c11) {
            str2 = File.separator;
            substring = replace.substring(1);
        } else {
            int indexOf2 = replace.indexOf(c11, replace.indexOf(c11, 2) + 1);
            str2 = indexOf2 > 2 ? replace.substring(0, indexOf2 + 1) : replace;
            substring = replace.substring(str2.length());
        }
        return new String[]{str2, substring};
    }

    public String i(String str) {
        synchronized (this.f71688a) {
            try {
                if (str.equals(this.f71689b)) {
                    return this.f71690c;
                }
                String c11 = w00.b.c(str);
                if (l(c11)) {
                    c11 = o(c11).getAbsolutePath();
                }
                this.f71689b = str;
                this.f71690c = c11;
                return c11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public URL j(File file) {
        return new URL(r(file.getAbsolutePath()));
    }

    public boolean n(File file, File file2) {
        String absolutePath = o(file.getAbsolutePath()).getAbsolutePath();
        String absolutePath2 = o(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(absolutePath);
            stringBuffer.append(str);
            absolutePath = stringBuffer.toString();
        }
        return absolutePath2.startsWith(absolutePath);
    }

    public File o(String str) {
        Stack stack = new Stack();
        String[] h11 = h(str);
        stack.push(h11[0]);
        StringTokenizer stringTokenizer = new StringTokenizer(h11[1], File.separator);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!".".equals(nextToken)) {
                if (!"..".equals(nextToken)) {
                    stack.push(nextToken);
                } else {
                    if (stack.size() < 2) {
                        return new File(str);
                    }
                    stack.pop();
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < stack.size(); i11++) {
            if (i11 > 1) {
                stringBuffer.append(File.separatorChar);
            }
            stringBuffer.append(stack.elementAt(i11));
        }
        return new File(stringBuffer.toString());
    }

    public String p(File file, File file2) {
        String absolutePath = o(file.getAbsolutePath()).getAbsolutePath();
        String absolutePath2 = o(file2.getAbsolutePath()).getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return "";
        }
        String str = File.separator;
        if (!absolutePath.endsWith(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(absolutePath);
            stringBuffer.append(str);
            absolutePath = stringBuffer.toString();
        }
        return absolutePath2.startsWith(absolutePath) ? absolutePath2.substring(absolutePath.length()) : absolutePath2;
    }

    public File q(File file, String str) {
        if (!l(str)) {
            char c11 = File.separatorChar;
            String replace = str.replace('/', c11).replace('\\', c11);
            if (m(replace)) {
                String property = System.getProperty("user.dir");
                if (replace.charAt(0) == c11 && property.charAt(0) == c11) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(h(property)[0]);
                    stringBuffer.append(replace.substring(1));
                    replace = stringBuffer.toString();
                }
                file = null;
            }
            str = new File(file, replace).getAbsolutePath();
        }
        return o(str);
    }

    public String r(String str) {
        Class<?> cls;
        try {
            cls = Class.forName("java.net.URI");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                File absoluteFile = new File(str).getAbsoluteFile();
                Class cls2 = f71687j;
                if (cls2 == null) {
                    cls2 = a("java.io.File");
                    f71687j = cls2;
                }
                return (String) cls.getMethod("toASCIIString", null).invoke(cls2.getMethod("toURI", null).invoke(absoluteFile, null), null);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        boolean isDirectory = new File(str).isDirectory();
        StringBuffer stringBuffer = new StringBuffer("file:");
        String path = q(null, str).getPath();
        stringBuffer.append("//");
        if (!path.startsWith(File.separator)) {
            stringBuffer.append("/");
        }
        String replace = path.replace('\\', '/');
        try {
            stringBuffer.append(w00.b.b(replace));
            if (isDirectory && !replace.endsWith("/")) {
                stringBuffer.append('/');
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e12) {
            throw new BuildException(e12);
        }
    }
}
