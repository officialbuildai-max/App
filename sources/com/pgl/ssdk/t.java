package com.pgl.ssdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f40252a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f40253b = null;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f40254c = false;

    /* renamed from: d, reason: collision with root package name */
    private static String f40255d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f40256e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f40257f = null;

    /* renamed from: g, reason: collision with root package name */
    private static int f40258g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static long f40259h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static long f40260i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f40261j = -1;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @com.pgl.ssdk.ces.out.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.pgl.ssdk.e a(java.io.File r6) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1e com.pgl.ssdk.f.a -> L25
            java.lang.String r2 = "r"
            r1.<init>(r6, r2)     // Catch: java.lang.Throwable -> L1e com.pgl.ssdk.f.a -> L25
            long r2 = r1.length()     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.f.a -> L26
            r4 = 0
            com.pgl.ssdk.o r2 = com.pgl.ssdk.p.a(r1, r4, r2)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.f.a -> L26
            com.pgl.ssdk.c$a r3 = com.pgl.ssdk.c.a(r2)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.f.a -> L26
            java.util.List r2 = com.pgl.ssdk.k.a(r2, r3)     // Catch: java.lang.Throwable -> L1f com.pgl.ssdk.f.a -> L26
            r1.close()     // Catch: java.io.IOException -> L2c
            goto L2c
        L1e:
            r1 = r0
        L1f:
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L2b
            goto L2b
        L25:
            r1 = r0
        L26:
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L2b
        L2b:
            r2 = r0
        L2c:
            if (r2 == 0) goto L34
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L38
        L34:
            java.util.List r2 = com.pgl.ssdk.j.a(r6)
        L38:
            if (r2 == 0) goto L48
            boolean r6 = r2.isEmpty()
            if (r6 != 0) goto L48
            r6 = 0
            java.lang.Object r6 = r2.get(r6)
            com.pgl.ssdk.e r6 = (com.pgl.ssdk.e) r6
            return r6
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.t.a(java.io.File):com.pgl.ssdk.e");
    }

    public static String a(RandomAccessFile randomAccessFile) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0".concat(bigInteger);
            }
            return bigInteger;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3).toUpperCase());
                sb2.append(":");
            }
            return sb2.substring(0, sb2.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static void a() {
        SharedPreferences a11 = u0.a(x.b());
        if (a11 != null) {
            if (!TextUtils.isEmpty(f40252a)) {
                a11.edit().putString("sa", f40252a).apply();
            }
            if (!TextUtils.isEmpty(f40256e)) {
                a11.edit().putString("md5", f40256e).apply();
            }
            if (!TextUtils.isEmpty(f40255d)) {
                a11.edit().putString("sj", f40255d).apply();
            }
            if (f40259h != 0) {
                a11.edit().putLong("as", f40259h).apply();
            }
            if (f40260i != 0) {
                a11.edit().putLong("ds", f40260i).apply();
            }
            if (f40261j != -1) {
                a11.edit().putLong("mt", f40261j).apply();
            }
            if (f40258g != -1) {
                a11.edit().putInt("cpc", f40258g).apply();
            }
            if (TextUtils.isEmpty(f40257f)) {
                return;
            }
            a11.edit().putString("ap", f40257f).apply();
        }
    }

    public static void a(File file, boolean z10) {
        RandomAccessFile randomAccessFile;
        e a11;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
            } catch (IOException unused) {
                return;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (TextUtils.isEmpty(f40252a) && (a11 = a(file)) != null) {
                f40252a = a(a11.a());
                f40255d = a11.b();
                if (z10) {
                    a();
                    try {
                        randomAccessFile.close();
                        return;
                    } catch (IOException unused4) {
                        return;
                    }
                }
            }
            if (TextUtils.isEmpty(f40256e)) {
                f40256e = a(randomAccessFile);
            }
            if (f40259h == 0) {
                f40259h = randomAccessFile.length() / 1024;
            }
            if (f40260i == 0) {
                f40260i = b(file);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException unused5) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
        } catch (IOException unused6) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused7) {
                }
            }
            throw th;
        }
    }

    public static long b(File file) {
        String format;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (i11 == 0) {
                        format = "classes.dex";
                    } else {
                        format = String.format(Locale.getDefault(), "classes%d.dex", Integer.valueOf(i11));
                    }
                    ZipEntry entry = zipFile2.getEntry(format);
                    if (entry == null) {
                        break;
                    }
                    try {
                        i12 = (int) (i12 + entry.getSize());
                        i11++;
                    } catch (ZipException unused) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (IOException unused2) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                long j11 = i12 / 1000;
                try {
                    zipFile2.close();
                } catch (IOException unused4) {
                }
                return j11;
            } catch (IOException unused5) {
                return 0L;
            }
        } catch (ZipException unused6) {
        } catch (IOException unused7) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String b() {
        String str;
        String str2;
        String str3;
        String str4;
        int i11;
        long j11;
        long j12;
        if (TextUtils.isEmpty(f40252a) || TextUtils.isEmpty(f40256e) || f40258g == -1) {
            SharedPreferences a11 = u0.a(x.b());
            long j13 = -1;
            if (a11 != null) {
                j13 = a11.getLong("mt", -1L);
                str2 = a11.getString("sa", null);
                str3 = a11.getString("sj", null);
                str4 = a11.getString("md5", null);
                j11 = a11.getLong("as", 0L);
                j12 = a11.getLong("ds", 0L);
                i11 = a11.getInt("cpc", -1);
                str = a11.getString("ap", null);
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                i11 = 0;
                j11 = 0;
                j12 = 0;
            }
            String c11 = c();
            if (c11 == null) {
                return null;
            }
            File file = new File(c11);
            Object[] objArr = (Object[]) com.pgl.ssdk.ces.a.meta(158, x.b(), c11);
            Integer num = (Integer) objArr[0];
            String str5 = (String) objArr[1];
            long lastModified = file.lastModified();
            if (lastModified != j13 || str2 == null || i11 == -1) {
                f40261j = lastModified;
                if (str5 != null) {
                    f40257f = str5;
                }
                if (num != null) {
                    f40258g = num.intValue();
                }
                a(file, false);
                a();
            } else {
                f40252a = str2;
                f40255d = str3;
                f40259h = j11;
                f40260i = j12;
                f40256e = str4;
                f40258g = i11;
                f40257f = str;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f40252a)) {
                jSONObject.put(TmcConstants.EXTRA_APP_DEV_TOKEN, f40252a);
            }
            if (!TextUtils.isEmpty(f40255d)) {
                jSONObject.put("subject", f40255d);
            }
            if (!TextUtils.isEmpty(f40256e)) {
                jSONObject.put("md5", f40256e);
            }
            if (!TextUtils.isEmpty(f40257f)) {
                jSONObject.put("path", f40257f);
            }
            long j14 = f40259h;
            if (j14 != 0) {
                jSONObject.put("apkSize", j14);
            }
            long j15 = f40260i;
            if (j15 != 0) {
                jSONObject.put("dexSize", j15);
            }
            int i12 = f40258g;
            if (i12 != -1) {
                jSONObject.put("code", i12);
            }
            f();
            jSONObject.put("signpm", f40253b);
            if (!TextUtils.isEmpty(f40253b) && !TextUtils.isEmpty(f40252a)) {
                if (!f40253b.equals(f40252a)) {
                    f40254c = true;
                }
                jSONObject.put("rebud", f40254c);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String c() {
        if (x.b() == null) {
            return null;
        }
        String packageCodePath = x.b().getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public static void d() {
        if (TextUtils.isEmpty(f40252a)) {
            SharedPreferences a11 = u0.a(x.b());
            String str = null;
            long j11 = -1;
            if (a11 != null) {
                j11 = a11.getLong("mt", -1L);
                str = a11.getString("sa", null);
            }
            String c11 = c();
            if (TextUtils.isEmpty(c11)) {
                return;
            }
            File file = new File(c11);
            long lastModified = file.lastModified();
            if (lastModified != j11 || str == null) {
                f40261j = lastModified;
                a(file, true);
                a();
            } else {
                f40252a = str;
            }
        }
        f();
        if (TextUtils.isEmpty(f40253b) || TextUtils.isEmpty(f40252a) || f40253b.equals(f40252a)) {
            return;
        }
        f40254c = true;
    }

    public static String e() {
        d();
        return f40252a;
    }

    public static String f() {
        if (!TextUtils.isEmpty(f40253b)) {
            return f40253b;
        }
        try {
            String a11 = a(x.b().getPackageManager().getPackageInfo(x.b().getPackageName(), 64).signatures[0].toByteArray());
            f40253b = a11;
            return a11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        d();
        return f40254c;
    }
}
