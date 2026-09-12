package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.x0;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzhg {

    /* loaded from: classes4.dex */
    public static class zza {
        private static volatile Optional<zzhh> zza;

        private zza() {
        }

        public static Optional<zzhh> zza(Context context) {
            Optional<zzhh> zza2;
            boolean isDeviceProtectedStorage;
            Optional<zzhh> optional = zza;
            if (optional == null) {
                synchronized (zza.class) {
                    try {
                        optional = zza;
                        if (optional == null) {
                            new zzhg();
                            if (zzhk.zza(Build.TYPE, Build.TAGS)) {
                                if (zzgs.zza()) {
                                    isDeviceProtectedStorage = context.isDeviceProtectedStorage();
                                    if (!isDeviceProtectedStorage) {
                                        context = context.createDeviceProtectedStorageContext();
                                    }
                                }
                                zza2 = zzhg.zza(context);
                            } else {
                                zza2 = Optional.absent();
                            }
                            zza = zza2;
                            optional = zza2;
                        }
                    } finally {
                    }
                }
            }
            return optional;
        }
    }

    private static zzhh zza(Context context, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                x0 x0Var = new x0();
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        zzgy zzgyVar = new zzgy(x0Var);
                        bufferedReader.close();
                        return zzgyVar;
                    }
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                    } else {
                        String zza2 = zza(split[0]);
                        String decode = Uri.decode(zza(split[1]));
                        String str = (String) hashMap.get(split[2]);
                        if (str == null) {
                            String zza3 = zza(split[2]);
                            str = Uri.decode(zza3);
                            if (str.length() < 1024 || str == zza3) {
                                hashMap.put(zza3, str);
                            }
                        }
                        x0 x0Var2 = (x0) x0Var.get(zza2);
                        if (x0Var2 == null) {
                            x0Var2 = new x0();
                            x0Var.put(zza2, x0Var2);
                        }
                        x0Var2.put(decode, str);
                    }
                }
            } finally {
            }
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    static Optional<zzhh> zza(Context context) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> zzb = zzb(context);
            Optional<zzhh> of2 = zzb.isPresent() ? Optional.of(zza(context, zzb.get())) : Optional.absent();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return of2;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }

    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.of(file) : Optional.absent();
        } catch (RuntimeException e11) {
            Log.e("HermeticFileOverrides", "no data dir", e11);
            return Optional.absent();
        }
    }
}
