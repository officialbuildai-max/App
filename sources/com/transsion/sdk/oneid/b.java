package com.transsion.sdk.oneid;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.api.gateway.utils.EncoderUtil;
import com.transsion.core.log.ObjectLogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static ObjectLogUtils f51966a;

    public static String a() {
        try {
            return UUID.nameUUIDFromBytes(String.valueOf(Os.statvfs(Environment.getExternalStorageDirectory().getPath()).f_fsid).getBytes()).toString();
        } catch (Exception e11) {
            m(Log.getStackTraceString(e11));
            return "";
        }
    }

    public static String b(long j11) {
        try {
            if (j11 >= 1073741824) {
                return String.format(Locale.ENGLISH, "%.1fGB", Float.valueOf(((float) j11) / ((float) 1073741824)));
            }
            if (j11 >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                float f11 = ((float) j11) / ((float) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                return String.format(Locale.ENGLISH, f11 > 100.0f ? "%.0fMB" : "%.1fMB", Float.valueOf(f11));
            }
            if (j11 < 1024) {
                return String.format(Locale.ENGLISH, "%dB", Long.valueOf(j11));
            }
            float f12 = ((float) j11) / ((float) 1024);
            return String.format(Locale.ENGLISH, f12 > 100.0f ? "%.0fKB" : "%.1fKB", Float.valueOf(f12));
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String c(Context context) {
        double d11;
        try {
            d11 = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), null)).doubleValue();
        } catch (Throwable unused) {
            d11 = 0.0d;
        }
        return String.valueOf(d11);
    }

    public static String d(Context context, Handler.Callback callback) {
        Cursor cursor = null;
        try {
            try {
                if (callback == null) {
                    cursor = context.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/property"), null, "prop_key = ?", new String[]{"oneid"}, null);
                    if (cursor != null && cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        cursor.close();
                        return string;
                    }
                } else {
                    new d(context, callback).b();
                }
            } catch (Exception e11) {
                throw e11;
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    public static String e(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException e11) {
            throw e11;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            int read = fileInputStream.read(bArr);
            String str = read > 0 ? new String(bArr, 0, read) : null;
            fileInputStream.close();
            return str;
        } catch (Throwable th2) {
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                String hexString = Integer.toHexString(b11 & 255);
                if (hexString.length() == 1) {
                    sb2.append('0');
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(android.content.Context r14, java.util.List r15) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.sdk.oneid.b.h(android.content.Context, java.util.List):void");
    }

    public static void i(Object obj) {
        ObjectLogUtils objectLogUtils = f51966a;
        if (objectLogUtils != null) {
            objectLogUtils.g(obj);
        }
    }

    public static String j() {
        try {
            long totalSpace = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();
            long j11 = 1;
            long j12 = 1;
            while (true) {
                long j13 = j11 * j12;
                if (j13 >= totalSpace) {
                    return b(j13);
                }
                j11 <<= 1;
                if (j11 > 512) {
                    j12 *= 1000;
                    j11 = 1;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            return "0";
        }
    }

    public static String k(Context context) {
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
            } else {
                int myPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            str = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return TextUtils.isEmpty(str) ? context.getPackageName() : str;
    }

    public static String l(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return "";
            }
            byte[] digest = messageDigest.digest(signatureArr[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3));
            }
            return sb2.toString().toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void m(Object obj) {
        ObjectLogUtils objectLogUtils = f51966a;
        if (objectLogUtils != null) {
            objectLogUtils.i(obj);
        }
    }

    public static String n(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return b(memoryInfo.totalMem);
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static void o() {
        f51966a = new ObjectLogUtils.a().p("OneID").q(true).n(false).m();
    }

    public static boolean p(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(4)) {
                    if (!networkCapabilities.hasTransport(3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return false;
    }

    public static boolean q(Context context) {
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

    public static boolean r(Context context) {
        Bundle bundle;
        String string;
        try {
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(new ComponentName("com.hoffnung", "com.transsion.dataservice.provider.DCSProvider"), 128);
            if (providerInfo == null || (bundle = providerInfo.metaData) == null || (string = bundle.getString("tran_dcs_version")) == null) {
                return false;
            }
            return string.compareTo("1.0.2.1") >= 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
