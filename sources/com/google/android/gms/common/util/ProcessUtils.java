package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@KeepForSdk
/* loaded from: classes3.dex */
public class ProcessUtils {
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    @Nullable
    @KeepForSdk
    public static String getMyProcessName() {
        BufferedReader bufferedReader;
        String processName;
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                zza = processName;
            } else {
                int i11 = zzb;
                if (i11 == 0) {
                    i11 = Process.myPid();
                    zzb = i11;
                }
                String str = null;
                str = null;
                str = null;
                BufferedReader bufferedReader2 = null;
                if (i11 > 0) {
                    try {
                        String str2 = "/proc/" + i11 + "/cmdline";
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str2));
                            try {
                                String readLine = bufferedReader.readLine();
                                Preconditions.checkNotNull(readLine);
                                str = readLine.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader2 = bufferedReader;
                                IOUtils.closeQuietly(bufferedReader2);
                                throw th;
                            }
                        } finally {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    IOUtils.closeQuietly(bufferedReader);
                }
                zza = str;
            }
        }
        return zza;
    }
}
