package com.google.android.gms.ads.identifier;

import android.util.Log;
import com.google.android.gms.internal.ads_identifier.zzi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
public final class zzc {
    public static final void zza(String str) {
        try {
            try {
                zzi.zzb(263);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
                        sb2.append("Received non-success response code ");
                        sb2.append(responseCode);
                        sb2.append(" from pinging URL: ");
                        sb2.append(str);
                        Log.w("HttpUrlPinger", sb2.toString());
                    }
                    zzi.zza();
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e11) {
                e = e11;
                String message = e.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
                sb3.append("Error while pinging URL: ");
                sb3.append(str);
                sb3.append(". ");
                sb3.append(message);
                Log.w("HttpUrlPinger", sb3.toString(), e);
                zzi.zza();
            } catch (IndexOutOfBoundsException e12) {
                String message2 = e12.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length());
                sb4.append("Error while parsing ping URL: ");
                sb4.append(str);
                sb4.append(". ");
                sb4.append(message2);
                Log.w("HttpUrlPinger", sb4.toString(), e12);
                zzi.zza();
            } catch (RuntimeException e13) {
                e = e13;
                String message3 = e.getMessage();
                StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
                sb32.append("Error while pinging URL: ");
                sb32.append(str);
                sb32.append(". ");
                sb32.append(message3);
                Log.w("HttpUrlPinger", sb32.toString(), e);
                zzi.zza();
            }
        } catch (Throwable th2) {
            zzi.zza();
            throw th2;
        }
    }
}
