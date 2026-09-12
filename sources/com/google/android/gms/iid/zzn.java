package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.content.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzn {
    @Nullable
    private static zzo zzd(SharedPreferences sharedPreferences, String str) throws zzp {
        String string = sharedPreferences.getString(zzak.zzh(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzak.zzh(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzo(zzg(string, string2), zze(sharedPreferences, str));
    }

    @Nullable
    private static zzo zzd(File file) throws zzp, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property != null && property2 != null) {
                try {
                    zzo zzoVar = new zzo(zzg(property, property2), Long.parseLong(properties.getProperty("cre")));
                    zzd((Throwable) null, fileInputStream);
                    return zzoVar;
                } catch (NumberFormatException e11) {
                    throw new zzp(e11);
                }
            }
            zzd((Throwable) null, fileInputStream);
            return null;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                zzd(th2, fileInputStream);
                throw th3;
            }
        }
    }

    private static void zzd(Context context, String str, zzo zzoVar) {
        String zzq;
        String zzr;
        long j11;
        try {
            Log.isLoggable("InstanceID", 3);
            File zzj = zzj(context, str);
            zzj.createNewFile();
            Properties properties = new Properties();
            zzq = zzoVar.zzq();
            properties.setProperty("pub", zzq);
            zzr = zzoVar.zzr();
            properties.setProperty("pri", zzr);
            j11 = zzoVar.zzcc;
            properties.setProperty("cre", String.valueOf(j11));
            FileOutputStream fileOutputStream = new FileOutputStream(zzj);
            try {
                properties.store(fileOutputStream, (String) null);
                zzd((Throwable) null, fileOutputStream);
            } finally {
            }
        } catch (IOException e11) {
            String valueOf = String.valueOf(e11);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf);
            Log.w("InstanceID", sb2.toString());
        }
    }

    private static /* synthetic */ void zzd(Throwable th2, FileInputStream fileInputStream) {
        if (th2 == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th3) {
            com.google.android.gms.internal.gcm.zzq.zzd(th2, th3);
        }
    }

    private static /* synthetic */ void zzd(Throwable th2, FileOutputStream fileOutputStream) {
        if (th2 == null) {
            fileOutputStream.close();
            return;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable th3) {
            com.google.android.gms.internal.gcm.zzq.zzd(th2, th3);
        }
    }

    private static long zze(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzak.zzh(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private final void zze(Context context, String str, zzo zzoVar) {
        String zzq;
        String zzr;
        long j11;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzoVar.equals(zzd(sharedPreferences, str))) {
                return;
            }
        } catch (zzp unused) {
        }
        Log.isLoggable("InstanceID", 3);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String zzh = zzak.zzh(str, "|P|");
        zzq = zzoVar.zzq();
        edit.putString(zzh, zzq);
        String zzh2 = zzak.zzh(str, "|K|");
        zzr = zzoVar.zzr();
        edit.putString(zzh2, zzr);
        String zzh3 = zzak.zzh(str, "cre");
        j11 = zzoVar.zzcc;
        edit.putString(zzh3, String.valueOf(j11));
        edit.commit();
    }

    private static KeyPair zzg(String str, String str2) throws zzp {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(decode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e11) {
                String valueOf = String.valueOf(e11);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
                sb2.append("Invalid key stored ");
                sb2.append(valueOf);
                Log.w("InstanceID", sb2.toString());
                throw new zzp(e11);
            }
        } catch (IllegalArgumentException e12) {
            throw new zzp(e12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzg(Context context, String str) {
        File zzj = zzj(context, str);
        if (zzj.exists()) {
            zzj.delete();
        }
    }

    @Nullable
    private final zzo zzh(Context context, String str) throws zzp {
        zzo zzi;
        try {
            zzi = zzi(context, str);
        } catch (zzp e11) {
            e = e11;
        }
        if (zzi != null) {
            zze(context, str, zzi);
            return zzi;
        }
        e = null;
        try {
            zzo zzd = zzd(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (zzd != null) {
                zzd(context, str, zzd);
                return zzd;
            }
        } catch (zzp e12) {
            e = e12;
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    @Nullable
    private final zzo zzi(Context context, String str) throws zzp {
        File zzj = zzj(context, str);
        if (!zzj.exists()) {
            return null;
        }
        try {
            return zzd(zzj);
        } catch (IOException e11) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(e11);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 40);
                sb2.append("Failed to read key from file, retrying: ");
                sb2.append(valueOf);
            }
            try {
                return zzd(zzj);
            } catch (IOException e12) {
                String valueOf2 = String.valueOf(e12);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 45);
                sb3.append("IID file exists, but failed to read from it: ");
                sb3.append(valueOf2);
                Log.w("InstanceID", sb3.toString());
                throw new zzp(e12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzi(Context context) {
        for (File file : zzj(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static File zzj(Context context) {
        File noBackupFilesDir = b.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zzj(Context context, String str) {
        String sb2;
        if (TextUtils.isEmpty(str)) {
            sb2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb3 = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb3.append("com.google.InstanceId_");
                sb3.append(encodeToString);
                sb3.append(".properties");
                sb2 = sb3.toString();
            } catch (UnsupportedEncodingException e11) {
                throw new AssertionError(e11);
            }
        }
        return new File(zzj(context), sb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzo zze(Context context, String str) throws zzp {
        zzo zzh = zzh(context, str);
        return zzh != null ? zzh : zzf(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzo zzf(Context context, String str) {
        zzo zzoVar = new zzo(zzd.zzl(), System.currentTimeMillis());
        try {
            zzo zzh = zzh(context, str);
            if (zzh != null) {
                Log.isLoggable("InstanceID", 3);
                return zzh;
            }
        } catch (zzp unused) {
        }
        Log.isLoggable("InstanceID", 3);
        zzd(context, str, zzoVar);
        zze(context, str, zzoVar);
        return zzoVar;
    }
}
