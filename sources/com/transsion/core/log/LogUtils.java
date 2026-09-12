package com.transsion.core.log;

import android.util.Log;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qk.a;

/* loaded from: classes.dex */
public abstract class LogUtils {

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f44074b;

    /* renamed from: c, reason: collision with root package name */
    private static String f44075c;

    /* renamed from: d, reason: collision with root package name */
    private static String f44076d;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f44073a = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* renamed from: e, reason: collision with root package name */
    private static boolean f44077e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f44078f = true;

    /* renamed from: g, reason: collision with root package name */
    private static String f44079g = "TAG";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f44080h = true;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f44081i = true;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f44082j = false;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f44083k = true;

    /* renamed from: l, reason: collision with root package name */
    private static int f44084l = 2;

    /* renamed from: m, reason: collision with root package name */
    private static int f44085m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final String f44086n = System.getProperty("file.separator");

    /* renamed from: o, reason: collision with root package name */
    private static final String f44087o = System.getProperty("line.separator");

    /* renamed from: p, reason: collision with root package name */
    private static final Format f44088p = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());

    private static String a(String str) {
        if (!f44083k) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f44087o)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(f44087o);
        }
        return sb2.toString();
    }

    private static boolean b(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static void d(String str, Object... objArr) {
        j(3, str, objArr);
    }

    private static String e(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return str;
    }

    private static String f(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f44087o);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static void g(Object obj) {
        j(4, f44079g, obj);
    }

    public static void h(String str, Object... objArr) {
        j(4, str, objArr);
    }

    private static boolean i(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    private static void j(int i11, String str, Object... objArr) {
        String substring = str.length() > 23 ? str.substring(0, 23) : str;
        if (!a.e() && !Log.isLoggable(substring, 3)) {
            if (!f44077e) {
                return;
            }
            if (!f44078f && !f44082j) {
                return;
            }
        }
        int i12 = i11 & 15;
        int i13 = i11 & 240;
        if (i12 >= f44084l || i12 >= f44085m) {
            String[] o11 = o(str);
            String n11 = n(i13, objArr);
            if (f44078f && i12 >= f44084l) {
                l(i12, o11[0], o11[1], n11);
            }
            if ((f44082j || i13 == 16) && i12 >= f44085m) {
                m(i12, o11[0], o11[2] + n11);
            }
        }
    }

    private static void k(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    private static void l(int i11, String str, String str2, String str3) {
        if (f44081i) {
            k(i11, str, "\n" + str2);
        } else {
            k(i11, str, " \n");
        }
        if (f44083k) {
            k(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = a(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            k(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String substring = str3.substring(i13, i15);
                if (f44083k) {
                    substring = "| " + substring;
                }
                k(i11, str, substring);
                i14++;
                i13 = i15;
            }
            String substring2 = str3.substring(i13, length);
            if (f44083k) {
                substring2 = "| " + substring2;
            }
            k(i11, str, substring2);
        } else {
            k(i11, str, str3);
        }
        if (f44083k) {
            k(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private static void m(int i11, final String str, String str2) {
        String format = f44088p.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        StringBuilder sb2 = new StringBuilder();
        String str3 = f44076d;
        if (str3 == null) {
            str3 = f44075c;
        }
        sb2.append(str3);
        sb2.append(substring);
        sb2.append(".txt");
        final String sb3 = sb2.toString();
        if (!c(sb3)) {
            Log.e(str, "log to " + sb3 + " failed!");
            return;
        }
        final String str4 = substring2 + f44073a[i11 - 2] + "/" + str + str2 + f44087o;
        if (f44074b == null) {
            f44074b = Executors.newSingleThreadExecutor();
        }
        f44074b.execute(new Runnable() { // from class: com.transsion.core.log.LogUtils.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x002c -> B:8:0x005e). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "log to "
                    r1 = 0
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    java.lang.String r4 = r1     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    r5 = 1
                    r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    java.lang.String r1 = r2     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r2.write(r1)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r1.<init>()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r1.append(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    java.lang.String r3 = r1     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r1.append(r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    java.lang.String r3 = " success!"
                    r1.append(r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r2.close()     // Catch: java.io.IOException -> L2b
                    goto L5e
                L2b:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto L5e
                L30:
                    r0 = move-exception
                    r1 = r2
                    goto L5f
                L33:
                    r1 = move-exception
                    goto L3b
                L35:
                    r0 = move-exception
                    goto L5f
                L37:
                    r2 = move-exception
                    r6 = r2
                    r2 = r1
                    r1 = r6
                L3b:
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L30
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> L30
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
                    r3.<init>()     // Catch: java.lang.Throwable -> L30
                    r3.append(r0)     // Catch: java.lang.Throwable -> L30
                    java.lang.String r0 = r1     // Catch: java.lang.Throwable -> L30
                    r3.append(r0)     // Catch: java.lang.Throwable -> L30
                    java.lang.String r0 = " failed!"
                    r3.append(r0)     // Catch: java.lang.Throwable -> L30
                    java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L30
                    android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L30
                    if (r2 == 0) goto L5e
                    r2.close()     // Catch: java.io.IOException -> L2b
                L5e:
                    return
                L5f:
                    if (r1 == 0) goto L69
                    r1.close()     // Catch: java.io.IOException -> L65
                    goto L69
                L65:
                    r1 = move-exception
                    r1.printStackTrace()
                L69:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.core.log.LogUtils.AnonymousClass1.run():void");
            }
        });
    }

    private static String n(int i11, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String obj2 = obj != null ? obj.toString() : "null";
            return i11 == 32 ? e(obj2) : i11 == 48 ? f(obj2) : obj2;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            Object obj3 = objArr[i12];
            sb2.append(NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS);
            sb2.append("[");
            sb2.append(i12);
            sb2.append("]");
            sb2.append(" = ");
            sb2.append(obj3 == null ? "null" : obj3.toString());
            sb2.append(f44087o);
        }
        return sb2.toString();
    }

    private static String[] o(String str) {
        if (f44080h || f44081i) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (f44080h && i(str)) {
                str = className;
            }
            if (f44081i) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + f44087o, " [" + formatter + "]: "};
            }
        } else {
            str = f44079g;
        }
        return new String[]{str, "", ": "};
    }
}
