package com.transsion.athena.config.data.model;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.util.j;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.core.log.ObjectLogUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class anehat {
    public static <E> int a(Collection<E> collection, j jVar) {
        int i11 = 0;
        if (a((Collection<?>) collection)) {
            return 0;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (jVar.a(it.next())) {
                i11++;
            }
        }
        return i11;
    }

    public static Boolean a(Context context, String str, boolean z10) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Boolean) loadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(loadClass, str, Boolean.valueOf(z10));
        } catch (IllegalArgumentException e11) {
            throw e11;
        } catch (Exception unused) {
            return Boolean.valueOf(z10);
        }
    }

    public static Long a(Context context, String str, long j11) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Long) loadClass.getMethod("getLong", String.class, Long.TYPE).invoke(loadClass, str, Long.valueOf(j11));
        } catch (IllegalArgumentException e11) {
            throw e11;
        } catch (Exception unused) {
            return Long.valueOf(j11);
        }
    }

    public static String a(InputStream inputStream) {
        try {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStream.close();
                    return sb2.toString();
                }
                sb2.append(readLine);
            }
        } catch (IOException e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static String a(Collection<? extends Object> collection, String str) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Object obj : collection) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(str);
            }
            sb2.append(obj.toString());
        }
        return sb2.toString();
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                int i11 = b11 & 255;
                if (Integer.toHexString(i11).length() == 1) {
                    sb2.append("0");
                    sb2.append(Integer.toHexString(i11));
                } else {
                    sb2.append(Integer.toHexString(i11));
                }
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("appver", String.valueOf(com.transsion.athena.taaneh.athena.i(context)));
            jSONObject.put("anver", Build.VERSION.RELEASE);
            jSONObject.put("apppkg", com.transsion.athena.taaneh.athena.h(context));
            jSONObject.put(UrlKt.KEY_MINI_GAID, com.transsion.athena.taaneh.anehat.a());
            jSONObject.put("mcc", com.transsion.athena.taaneh.athena.f(context));
            jSONObject.put("lang", Locale.getDefault().getLanguage());
            jSONObject.put("installer", com.transsion.athena.taaneh.athena.e(context));
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
        return jSONObject;
    }

    public static void a(StringBuilder sb2, Object obj) {
        if (sb2.length() == 0) {
            sb2.append(obj);
        } else {
            sb2.append(",");
            sb2.append(obj);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!next.contains(UrlUtils.AND_MARK)) {
                jSONObject2.put(next, obj);
            } else if (!jSONObject2.has(next)) {
                jSONObject2.put(next, obj);
            } else if (next.endsWith("&add")) {
                jSONObject2.put(next, Long.parseLong(obj.toString()) + jSONObject2.getLong(next));
            } else if (next.endsWith("&append")) {
                Object obj2 = jSONObject2.get(next);
                if (obj2 instanceof JSONArray) {
                    ((JSONArray) obj2).put(obj);
                } else {
                    obj2 = new JSONArray().put(obj2).put(obj);
                }
                jSONObject2.put(next, obj2);
            }
        }
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static byte[] a(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i11 = 0; i11 < str.length() / 2; i11++) {
            int i12 = i11 * 2;
            int i13 = i12 + 1;
            bArr[i11] = (byte) ((Integer.parseInt(str.substring(i12, i13), 16) * 16) + Integer.parseInt(str.substring(i13, i12 + 2), 16));
        }
        return bArr;
    }

    public static int b(Context context) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String e11 = com.transsion.athena.taaneh.athena.e(context);
            sb2.append(Build.MODEL);
            sb2.append(Build.BRAND);
            sb2.append(com.transsion.athena.taaneh.athena.i(context));
            sb2.append(Build.VERSION.RELEASE);
            sb2.append(com.transsion.athena.taaneh.athena.h(context));
            sb2.append(com.transsion.athena.taaneh.athena.f(context));
            sb2.append(Locale.getDefault().getLanguage());
            if (e11 == null) {
                e11 = "";
            }
            sb2.append(e11);
        } catch (Exception e12) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e12));
        }
        return sb2.toString().hashCode();
    }

    public static boolean b(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            byteArrayOutputStream.reset();
            return byteArray;
        } catch (Exception e11) {
            ObjectLogUtils objectLogUtils = com.transsion.athena.taaneh.aethna.f42852a;
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static boolean c(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isScreenOn();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0027: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x0027 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0065 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #2 {Exception -> 0x0069, blocks: (B:39:0x0060, B:41:0x0065), top: B:38:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] d(byte[] r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L74
            int r1 = r5.length
            if (r1 != 0) goto L8
            goto L74
        L8:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
        L1b:
            int r3 = r2.read(r5)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            if (r3 < 0) goto L2b
            r4 = 0
            r1.write(r5, r4, r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            goto L1b
        L26:
            r5 = move-exception
            r0 = r2
            goto L60
        L29:
            r5 = move-exception
            goto L45
        L2b:
            byte[] r5 = r1.toByteArray()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            r1.close()     // Catch: java.lang.Exception -> L36
            r2.close()     // Catch: java.lang.Exception -> L36
            goto L40
        L36:
            r0 = move-exception
            com.transsion.core.log.ObjectLogUtils r1 = com.transsion.athena.taaneh.aethna.f42852a
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            com.transsion.athena.taaneh.aethna.b(r0)
        L40:
            return r5
        L41:
            r5 = move-exception
            goto L60
        L43:
            r5 = move-exception
            r2 = r0
        L45:
            com.transsion.core.log.ObjectLogUtils r3 = com.transsion.athena.taaneh.aethna.f42852a     // Catch: java.lang.Throwable -> L26
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)     // Catch: java.lang.Throwable -> L26
            com.transsion.athena.taaneh.aethna.b(r5)     // Catch: java.lang.Throwable -> L26
            r1.close()     // Catch: java.lang.Exception -> L57
            if (r2 == 0) goto L5f
            r2.close()     // Catch: java.lang.Exception -> L57
            goto L5f
        L57:
            r5 = move-exception
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)
            com.transsion.athena.taaneh.aethna.b(r5)
        L5f:
            return r0
        L60:
            r1.close()     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.lang.Exception -> L69
            goto L73
        L69:
            r0 = move-exception
            com.transsion.core.log.ObjectLogUtils r1 = com.transsion.athena.taaneh.aethna.f42852a
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            com.transsion.athena.taaneh.aethna.b(r0)
        L73:
            throw r5
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.config.data.model.anehat.d(byte[]):byte[]");
    }
}
