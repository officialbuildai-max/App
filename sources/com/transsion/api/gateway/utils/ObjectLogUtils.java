package com.transsion.api.gateway.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ObjectLogUtils {
    public static final int A = 7;
    public static final int D = 3;
    public static final int E = 6;
    public static final int I = 4;
    public static final int V = 2;
    public static final int W = 5;
    private final String ARGS;
    private final String BOTTOM_BORDER;
    private final int FILE;
    private final Format FORMAT;
    private final int JSON;
    private final String LEFT_BORDER;
    private final int MAX_LEN;
    private final String NULL;
    private final String NULL_TIPS;
    private final String TOP_BORDER;
    private final int XML;
    public Builder builder;
    private ExecutorService executor;
    private int invokeLayer;
    private static final char[] T = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String LINE_SEP = System.getProperty("line.separator");

    /* loaded from: classes.dex */
    public static class Builder {
        private String defaultDir;
        private String dir;
        private boolean sLogSwitch = false;
        private boolean sLog2ConsoleSwitch = true;
        private String sGlobalTag = null;
        private boolean sTagIsSpace = true;
        private boolean sLogHeadSwitch = true;
        private boolean sLog2FileSwitch = false;
        private boolean sLogBorderSwitch = true;
        private int sConsoleFilter = 2;
        private int sFileFilter = 2;

        public ObjectLogUtils create() {
            return new ObjectLogUtils(this);
        }

        public Builder setBorderSwitch(boolean z10) {
            this.sLogBorderSwitch = z10;
            return this;
        }

        public Builder setConsoleFilter(int i11) {
            this.sConsoleFilter = i11;
            return this;
        }

        public Builder setConsoleSwitch(boolean z10) {
            this.sLog2ConsoleSwitch = z10;
            return this;
        }

        public Builder setDir(File file) {
            String str;
            if (file == null) {
                str = null;
            } else {
                str = file.getAbsolutePath() + ObjectLogUtils.FILE_SEP;
            }
            this.dir = str;
            return this;
        }

        public Builder setDir(String str) {
            if (ObjectLogUtils.isSpace(str)) {
                this.dir = null;
            } else {
                if (!str.endsWith(ObjectLogUtils.FILE_SEP)) {
                    str = str + ObjectLogUtils.FILE_SEP;
                }
                this.dir = str;
            }
            return this;
        }

        public Builder setFileFilter(int i11) {
            this.sFileFilter = i11;
            return this;
        }

        public Builder setGlobalTag(String str) {
            if (ObjectLogUtils.isSpace(str)) {
                this.sGlobalTag = "";
                this.sTagIsSpace = true;
            } else {
                this.sGlobalTag = str;
                this.sTagIsSpace = false;
            }
            return this;
        }

        public Builder setLog2FileSwitch(boolean z10) {
            this.sLog2FileSwitch = z10;
            return this;
        }

        public Builder setLogHeadSwitch(boolean z10) {
            this.sLogHeadSwitch = z10;
            return this;
        }

        public Builder setLogSwitch(boolean z10) {
            this.sLogSwitch = z10;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("switch: ");
            sb2.append(this.sLogSwitch);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("console: ");
            sb2.append(this.sLog2ConsoleSwitch);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("tag: ");
            sb2.append(this.sTagIsSpace ? "null" : this.sGlobalTag);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("head: ");
            sb2.append(this.sLogHeadSwitch);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("file: ");
            sb2.append(this.sLog2FileSwitch);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("dir: ");
            String str = this.dir;
            if (str == null) {
                str = this.defaultDir;
            }
            sb2.append(str);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("border: ");
            sb2.append(this.sLogBorderSwitch);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("consoleFilter: ");
            sb2.append(ObjectLogUtils.T[this.sConsoleFilter - 2]);
            sb2.append(ObjectLogUtils.LINE_SEP);
            sb2.append("fileFilter: ");
            sb2.append(ObjectLogUtils.T[this.sFileFilter - 2]);
            return sb2.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface TYPE {
    }

    private ObjectLogUtils(Builder builder) {
        this.FILE = 16;
        this.JSON = 32;
        this.XML = 48;
        this.TOP_BORDER = "|---------------------------------------------------------------------------------------------------";
        this.LEFT_BORDER = "| ";
        this.BOTTOM_BORDER = "|---------------------------------------------------------------------------------------------------";
        this.MAX_LEN = 4000;
        this.FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.NULL_TIPS = "Log with null object.";
        this.NULL = "null";
        this.ARGS = NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS;
        new Builder();
        this.invokeLayer = 0;
        this.builder = builder;
    }

    private String addLeftBorder(String str) {
        if (!this.builder.sLogBorderSwitch) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(LINE_SEP)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(LINE_SEP);
        }
        return sb2.toString();
    }

    public static byte[] compress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(1);
        try {
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[2048];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            deflater.end();
            throw th2;
        }
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean createOrExistsFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private static String formatJson(String str) {
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

    private String formatXml(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + LINE_SEP);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static File getExternalCacheDir(Context context) {
        boolean z10 = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z10 = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (!z10) {
            try {
                return context.getExternalCacheDir();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpace(String str) {
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

    private void log(int i11, String str, Object... objArr) {
        if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
            if (!this.builder.sLogSwitch) {
                return;
            }
            if (!this.builder.sLog2ConsoleSwitch && !this.builder.sLog2FileSwitch) {
                return;
            }
        }
        int i12 = i11 & 15;
        int i13 = i11 & 240;
        if (i12 >= this.builder.sConsoleFilter || i12 >= this.builder.sFileFilter) {
            String[] processTagAndHead = processTagAndHead(str);
            String processBody = processBody(i13, objArr);
            if (this.builder.sLog2ConsoleSwitch && i12 >= this.builder.sConsoleFilter) {
                print2Console(i12, processTagAndHead[0], processTagAndHead[1], processBody);
            }
            if ((this.builder.sLog2FileSwitch || i13 == 16) && i12 >= this.builder.sFileFilter) {
                print2File(i12, processTagAndHead[0], processTagAndHead[2] + processBody);
            }
        }
    }

    private static void print(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    private void print2Console(int i11, String str, String str2, String str3) {
        if (this.builder.sLogHeadSwitch) {
            print(i11, str, "\n" + str2);
        } else {
            print(i11, str, " \n");
        }
        if (this.builder.sLogBorderSwitch) {
            print(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = addLeftBorder(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            print(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String substring = str3.substring(i13, i15);
                if (this.builder.sLogBorderSwitch) {
                    substring = "| " + substring;
                }
                print(i11, str, substring);
                i14++;
                i13 = i15;
            }
            String substring2 = str3.substring(i13, length);
            if (this.builder.sLogBorderSwitch) {
                substring2 = "| " + substring2;
            }
            print(i11, str, substring2);
        } else {
            print(i11, str, str3);
        }
        if (this.builder.sLogBorderSwitch) {
            print(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private void print2File(int i11, final String str, String str2) {
        String format = this.FORMAT.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        if (this.builder.defaultDir == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || getExternalCacheDir(ContextUtils.getContext()) == null) {
                Builder builder = this.builder;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ContextUtils.getContext().getCacheDir());
                String str3 = FILE_SEP;
                sb2.append(str3);
                sb2.append("log");
                sb2.append(str3);
                builder.defaultDir = sb2.toString();
            } else {
                Builder builder2 = this.builder;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(getExternalCacheDir(ContextUtils.getContext()));
                String str4 = FILE_SEP;
                sb3.append(str4);
                sb3.append("log");
                sb3.append(str4);
                builder2.defaultDir = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.builder.dir == null ? this.builder.defaultDir : this.builder.dir);
        sb4.append(substring);
        sb4.append(".txt");
        final String sb5 = sb4.toString();
        if (!createOrExistsFile(sb5)) {
            Log.e(str, "log to " + sb5 + " failed!");
            return;
        }
        final String str5 = substring2 + T[i11 - 2] + "/" + str + str2 + LINE_SEP;
        if (this.executor == null) {
            this.executor = Executors.newSingleThreadExecutor();
        }
        this.executor.execute(new Runnable() { // from class: com.transsion.api.gateway.utils.ObjectLogUtils.1
            /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
                    java.lang.String r4 = r2     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
                    r5 = 1
                    r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    r2.write(r1)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    r1.<init>()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    r1.append(r0)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    java.lang.String r3 = r2     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    r1.append(r3)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    java.lang.String r3 = " success!"
                    r1.append(r3)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
                    r2.close()     // Catch: java.io.IOException -> L2b
                    goto L5f
                L2b:
                    r0 = move-exception
                    goto L5c
                L2d:
                    r0 = move-exception
                    r1 = r2
                    goto L60
                L30:
                    r1 = move-exception
                    goto L38
                L32:
                    r0 = move-exception
                    goto L60
                L34:
                    r2 = move-exception
                    r6 = r2
                    r2 = r1
                    r1 = r6
                L38:
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L2d
                    java.lang.String r1 = r4     // Catch: java.lang.Throwable -> L2d
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
                    r3.<init>()     // Catch: java.lang.Throwable -> L2d
                    r3.append(r0)     // Catch: java.lang.Throwable -> L2d
                    java.lang.String r0 = r2     // Catch: java.lang.Throwable -> L2d
                    r3.append(r0)     // Catch: java.lang.Throwable -> L2d
                    java.lang.String r0 = " failed!"
                    r3.append(r0)     // Catch: java.lang.Throwable -> L2d
                    java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L2d
                    android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L2d
                    if (r2 == 0) goto L5f
                    r2.close()     // Catch: java.io.IOException -> L2b
                    goto L5f
                L5c:
                    r0.printStackTrace()
                L5f:
                    return
                L60:
                    if (r1 == 0) goto L6a
                    r1.close()     // Catch: java.io.IOException -> L66
                    goto L6a
                L66:
                    r1 = move-exception
                    r1.printStackTrace()
                L6a:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.api.gateway.utils.ObjectLogUtils.AnonymousClass1.run():void");
            }
        });
    }

    private String processBody(int i11, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String obj2 = obj != null ? obj.toString() : "null";
            return i11 == 32 ? formatJson(obj2) : i11 == 48 ? formatXml(obj2) : obj2;
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
            sb2.append(LINE_SEP);
        }
        return sb2.toString();
    }

    private String[] processTagAndHead(String str) {
        if (this.builder.sTagIsSpace || this.builder.sLogHeadSwitch) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.invokeLayer + 5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.builder.sTagIsSpace && isSpace(str)) {
                str = className;
            }
            if (this.builder.sLogHeadSwitch) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + LINE_SEP, " [" + formatter + "]: "};
            }
        } else {
            str = this.builder.sGlobalTag;
        }
        return new String[]{str, "", ": "};
    }

    public static byte[] uncompress(byte[] bArr) {
        int i11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Inflater inflater = new Inflater();
        try {
            inflater.setInput(bArr);
            byte[] bArr2 = new byte[2048];
            while (!inflater.finished()) {
                try {
                    i11 = inflater.inflate(bArr2);
                } catch (DataFormatException e11) {
                    e11.printStackTrace();
                    i11 = 0;
                }
                byteArrayOutputStream.write(bArr2, 0, i11);
            }
            inflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            inflater.end();
            throw th2;
        }
    }

    public void a(Object obj) {
        log(7, this.builder.sGlobalTag, obj);
    }

    public void a(String str, Object... objArr) {
        log(7, str, objArr);
    }

    public void d(Object obj) {
        log(3, this.builder.sGlobalTag, obj);
    }

    public void d(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public void e(Object obj) {
        log(6, this.builder.sGlobalTag, obj);
    }

    public void e(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public void file(int i11, Object obj) {
        log(i11 | 16, this.builder.sGlobalTag, obj);
    }

    public void file(int i11, String str, Object obj) {
        log(i11 | 16, str, obj);
    }

    public void file(Object obj) {
        log(19, this.builder.sGlobalTag, obj);
    }

    public void file(String str, Object obj) {
        log(19, str, obj);
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public void i(Object obj) {
        log(4, this.builder.sGlobalTag, obj);
    }

    public void i(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public void json(int i11, String str) {
        log(i11 | 32, this.builder.sGlobalTag, str);
    }

    public void json(int i11, String str, String str2) {
        log(i11 | 32, str, str2);
    }

    public void json(String str) {
        log(35, this.builder.sGlobalTag, str);
    }

    public void json(String str, String str2) {
        log(35, str, str2);
    }

    public void setInvokeLayer(int i11) {
        this.invokeLayer = i11;
    }

    public void v(Object obj) {
        log(2, this.builder.sGlobalTag, obj);
    }

    public void v(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public void w(Object obj) {
        log(5, this.builder.sGlobalTag, obj);
    }

    public void w(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public void xml(int i11, String str) {
        log(i11 | 48, this.builder.sGlobalTag, str);
    }

    public void xml(int i11, String str, String str2) {
        log(i11 | 48, str, str2);
    }

    public void xml(String str) {
        log(51, this.builder.sGlobalTag, str);
    }

    public void xml(String str, String str2) {
        log(51, str, str2);
    }
}
