package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class m0 extends u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 == null) {
                    d11 = com.mbridge.msdk.setting.h.b().a();
                }
                m0.b(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_RES_MANAGER_DIR), d11.N());
                m0.a(System.currentTimeMillis() - (d11.e() * 1000));
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    m0.b(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC));
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements FileFilter {
        c() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isHidden() || file.isDirectory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Comparator<File> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }
    }

    public static String a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (!file.isDirectory()) {
                return "";
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    a(file2);
                }
                file.delete();
                return "";
            }
            file.delete();
            return "";
        } catch (Exception e11) {
            return e11.getMessage();
        }
    }

    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Exception e11) {
            o0.b("SameFileTool", e11.getMessage());
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str + File.separator + "template_config.json");
            if (file.isFile() && file.exists()) {
                String e12 = e(file);
                if (TextUtils.isEmpty(e12)) {
                    return arrayList;
                }
                try {
                    JSONArray jSONArray = new JSONArray(e12);
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i11);
                        if (jSONObject != null && str2.equals(jSONObject.optString("xml_type"))) {
                            arrayList.add(str + File.separator + jSONObject.optString("name"));
                            if (jSONObject.has("ext_template")) {
                                jSONObject.put("folder_dir", str);
                                arrayList.add(jSONObject.toString());
                            }
                        }
                    }
                    return arrayList;
                } catch (JSONException e13) {
                    o0.b("SameFileTool", e13.getMessage());
                    return arrayList;
                }
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    public static void a() {
        a aVar = new a();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
        } else {
            aVar.run();
        }
    }

    public static void a(long j11) {
        try {
            Iterator<File> it = b(new File(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j11 && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th2) {
            o0.b("SameFileTool", th2.getMessage(), th2);
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null) {
                d11 = com.mbridge.msdk.setting.h.b().a();
            }
            long currentTimeMillis = System.currentTimeMillis() - (d11.e() * 1000);
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                            a(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    a(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static boolean a(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e12) {
                e12.printStackTrace();
                return true;
            }
        } catch (Exception e13) {
            e = e13;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 == null) {
                return false;
            }
            try {
                fileOutputStream2.close();
                return false;
            } catch (IOException e14) {
                e14.printStackTrace();
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0102, code lost:
    
        if (r12 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0104, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0108, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0109, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b("SameFileTool", "unzip error", r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x012e, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0131, code lost:
    
        if (r12 == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0133, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0137, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0138, code lost:
    
        com.mbridge.msdk.foundation.tools.o0.b("SameFileTool", "unzip error", r12);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0154 A[Catch: all -> 0x0158, TryCatch #13 {all -> 0x0158, blocks: (B:59:0x0150, B:61:0x0154, B:62:0x015d), top: B:58:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.m0.b(java.lang.String, java.lang.String):java.lang.String");
    }

    private static ArrayList<File> b(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new c())) {
            if (file2.isDirectory()) {
                arrayList.addAll(b(file2));
            } else {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public static void b() {
        new Thread(new b()).start();
    }

    public static void b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : c(str)) {
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, int i11) {
        try {
            if (d(new File(str)) > i11 * 1048576) {
                f(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (Throwable unused) {
            o0.b("SameFileTool", "clean memory failed");
        }
    }

    private static long c(File file) throws Exception {
        FileInputStream fileInputStream;
        long j11 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            j11 = fileInputStream.available();
                            fileInputStream2 = fileInputStream;
                        } catch (Exception e11) {
                            e = e11;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return j11;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                        o0.b("获取文件大小", "文件不存在!");
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            } catch (Exception e14) {
                e = e14;
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return j11;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static File[] c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static long d(File file) throws Exception {
        File[] listFiles = file.listFiles();
        long j11 = 0;
        if (listFiles != null) {
            for (int i11 = 0; i11 < listFiles.length; i11++) {
                j11 += listFiles[i11].isDirectory() ? d(listFiles[i11]) : c(listFiles[i11]);
            }
        }
        return j11;
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(z0.b(str.trim())) : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3c
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L36
            r4.<init>()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L36
        L13:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            if (r2 == 0) goto L32
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r3.append(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.lang.String r2 = "\n"
            r3.append(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r4.append(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            goto L13
        L2e:
            r4 = move-exception
            goto L53
        L30:
            r2 = move-exception
            goto L40
        L32:
            r1.close()     // Catch: java.io.IOException -> L48
            goto L48
        L36:
            r4 = move-exception
            r2 = r4
            r4 = r0
            goto L40
        L3a:
            r4 = move-exception
            goto L52
        L3c:
            r4 = move-exception
            r2 = r4
            r4 = r0
            r1 = r4
        L40:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L50
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.io.IOException -> L48
        L48:
            if (r4 == 0) goto L4f
            java.lang.String r4 = r4.toString()
            return r4
        L4f:
            return r0
        L50:
            r4 = move-exception
            r0 = r1
        L52:
            r1 = r0
        L53:
            if (r1 == 0) goto L58
            r1.close()     // Catch: java.io.IOException -> L58
        L58:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.m0.e(java.io.File):java.lang.String");
    }

    public static boolean e(String str) {
        if (com.mbridge.msdk.foundation.same.image.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static void f(String str) {
        try {
            ArrayList<File> b11 = b(new File(str));
            Collections.sort(b11, new d());
            int size = (b11.size() - 1) / 2;
            for (int i11 = 0; i11 < size; i11++) {
                File file = b11.get(i11);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            o0.b("SameFileTool", "del memory failed");
        }
    }
}
