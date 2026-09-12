package com.pgl.ssdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.tools.zip.UnixStat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class t0 {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f40262a = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f40263a;

        /* renamed from: b, reason: collision with root package name */
        public String f40264b;

        public a(int i11, String... strArr) {
            this.f40263a = i11;
            JSONArray jSONArray = new JSONArray();
            for (String str : strArr) {
                jSONArray.put(str);
            }
            this.f40264b = jSONArray.toString();
        }
    }

    private static a a(Context context, String str, File file) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                ZipEntry a11 = a(zipFile2, Build.CPU_ABI, str);
                if (a11 == null) {
                    try {
                        a11 = a(zipFile2, Build.CPU_ABI2, str);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        fileOutputStream = null;
                        zipFile = zipFile2;
                        try {
                            return new a(3, th.getMessage());
                        } finally {
                            p0.a(fileOutputStream);
                            p0.a(inputStream);
                            p0.a(zipFile);
                        }
                    }
                }
                if (a11 == null) {
                    a aVar = new a(2, a(zipFile2, str));
                    p0.a((Closeable) null);
                    p0.a((Closeable) null);
                    p0.a(zipFile2);
                    return aVar;
                }
                file.createNewFile();
                InputStream inputStream2 = zipFile2.getInputStream(a11);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read <= 0) {
                                p0.a(file.getAbsolutePath(), UnixStat.DEFAULT_DIR_PERM);
                                p0.a(fileOutputStream2);
                                p0.a(inputStream2);
                                p0.a(zipFile2);
                                return null;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                    } catch (Throwable th3) {
                        zipFile = zipFile2;
                        inputStream = inputStream2;
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        return new a(3, th.getMessage());
                    }
                } catch (Throwable th4) {
                    inputStream = inputStream2;
                    th = th4;
                    fileOutputStream = null;
                    zipFile = zipFile2;
                    return new a(3, th.getMessage());
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            fileOutputStream = null;
        }
    }

    private static File a(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "libso");
        if (!file.exists()) {
            p0.a(file.getAbsolutePath());
        }
        return file;
    }

    private static File a(Context context, String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File a11 = a(context);
        if (a11 != null) {
            return new File(a11, mapLibraryName);
        }
        return null;
    }

    private static String a(ZipFile zipFile, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"armeabi-v7a", "arm64-v8a", "x86", "x86_64", "armeabi"};
        for (int i11 = 0; i11 < 5; i11++) {
            String str2 = strArr[i11];
            if (a(zipFile, str2, str) != null) {
                arrayList.add(str2);
            }
        }
        List asList = Arrays.asList(Build.SUPPORTED_ABIS);
        ArrayList arrayList2 = new ArrayList();
        String str3 = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str3)) {
            arrayList2.add(str3);
        }
        String str4 = Build.CPU_ABI2;
        if (!TextUtils.isEmpty(str4)) {
            arrayList2.add(str4);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("supportedABIS", asList);
            jSONObject.put("curABIs", arrayList2);
            jSONObject.put("apkABIS", arrayList);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static ZipEntry a(ZipFile zipFile, String str, String str2) {
        ZipEntry entry = zipFile.getEntry("lib/" + str + "/" + System.mapLibraryName(str2));
        if (entry != null) {
            return entry;
        }
        int indexOf = str.indexOf(45);
        StringBuilder sb2 = new StringBuilder("lib/");
        if (indexOf <= 0) {
            indexOf = str.length();
        }
        sb2.append(str.substring(0, indexOf));
        sb2.append("/");
        sb2.append(System.mapLibraryName(str2));
        return zipFile.getEntry(sb2.toString());
    }

    public static synchronized a b(Context context, String str) {
        synchronized (t0.class) {
            if (f40262a.contains(str)) {
                return null;
            }
            try {
                System.loadLibrary(str);
                f40262a.add(str);
            } catch (UnsatisfiedLinkError e11) {
                File a11 = a(context, str);
                if (a11 == null) {
                    return new a(3, e11.getMessage(), "output null");
                }
                if (a11.exists()) {
                    a11.delete();
                }
                a a12 = a(context, str, a11);
                if (a12 != null) {
                    return a12;
                }
                try {
                    System.load(a11.getAbsolutePath());
                    f40262a.add(str);
                } catch (Throwable th2) {
                    return new a(3, e11.getMessage(), th2.getMessage());
                }
            } catch (Throwable th3) {
                return new a(3, th3.getMessage());
            }
            return null;
        }
    }
}
