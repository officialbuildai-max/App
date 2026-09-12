package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/* loaded from: classes4.dex */
final class zzbsj extends zzbsk {
    private static final zzbtf zzb;
    private static final zzbtf zzc;
    private static final zzbtf zzd;
    private static final zzbtf zze;
    private static final zzbtf zzf;
    private static final zzbtf zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static final Method zzj;
    private static final Method zzk;
    private static final Method zzl;
    private static final Method zzm;
    private static final Constructor zzn;

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(5:2|3|4|5|(5:7|8|9|10|11))|(2:12|13)|14|15|16|18|19|20|21|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|2|3|4|5|(5:7|8|9|10|11)|(2:12|13)|14|15|16|18|19|20|21|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0120, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0124, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0140, code lost:
    
        r1 = com.google.android.libraries.places.internal.zzbsk.zzb;
        r1.logp(java.util.logging.Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (java.lang.Throwable) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x011e, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0122, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x012e, code lost:
    
        r1 = com.google.android.libraries.places.internal.zzbsk.zzb;
        r1.logp(java.util.logging.Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "<clinit>", "Failed to find Android 7.0+ APIs", (java.lang.Throwable) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0129, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x013e, code lost:
    
        r6 = r0;
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0126, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x012c, code lost:
    
        r6 = r0;
        r0 = null;
     */
    static {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbsj.<clinit>():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsj(zzbtl zzbtlVar) {
        super(zzbtlVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final String zza(SSLSocket sSLSocket) {
        Logger logger;
        Logger logger2;
        Logger logger3;
        Method method = zzl;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, null);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                if (!(e12.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e12);
                }
                logger = zzbsk.zzb;
                logger.logp(Level.FINER, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        if (this.zza.zzc() == 1) {
            try {
                byte[] bArr = (byte[]) zzd.zzb(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, zzbto.zzb);
                }
            } catch (Exception e13) {
                logger2 = zzbsk.zzb;
                logger2.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getAlpnSelectedProtocol()", (Throwable) e13);
            }
        }
        if (this.zza.zzc() != 3) {
            try {
                byte[] bArr2 = (byte[]) zzf.zzb(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, zzbto.zzb);
                }
            } catch (Exception e14) {
                logger3 = zzbsk.zzb;
                logger3.logp(Level.FINE, "io.grpc.okhttp.OkHttpProtocolNegotiator$AndroidNegotiator", "getSelectedProtocol", "Failed calling getNpnSelectedProtocol()", (Throwable) e14);
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzbsk
    public final String zzb(SSLSocket sSLSocket, String str, List list) throws IOException {
        String zza = zza(sSLSocket);
        return zza == null ? super.zzb(sSLSocket, str, list) : zza;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0119  */
    @Override // com.google.android.libraries.places.internal.zzbsk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzc(javax.net.ssl.SSLSocket r10, java.lang.String r11, java.util.List r12) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbsj.zzc(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
    }
}
