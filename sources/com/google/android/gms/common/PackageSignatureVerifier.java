package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;

@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes3.dex */
public class PackageSignatureVerifier {

    @Nullable
    static volatile zzac zza;

    @Nullable
    private static zzad zzb;

    private static zzad zza(Context context) {
        zzad zzadVar;
        synchronized (PackageSignatureVerifier.class) {
            try {
                if (zzb == null) {
                    zzb = new zzad(context);
                }
                zzadVar = zzb;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzadVar;
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(@NonNull Context context, @NonNull String str) {
        PackageVerificationResult packageVerificationResult;
        String str2;
        PackageVerificationResult packageVerificationResult2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        if (!zzn.zzf()) {
            throw new zzae();
        }
        String concat = String.valueOf(str).concat(true != honorsDebugCertificates ? "-0" : TmcConstants.COLD_OPEN_TYPE);
        if (zza != null) {
            str2 = zza.zza;
            if (str2.equals(concat)) {
                packageVerificationResult2 = zza.zzb;
                return packageVerificationResult2;
            }
        }
        zza(context);
        zzx zzc = zzn.zzc(str, honorsDebugCertificates, false, false);
        if (!zzc.zza) {
            Preconditions.checkNotNull(zzc.zzb);
            return PackageVerificationResult.zza(str, zzc.zzb, zzc.zzc);
        }
        zza = new zzac(concat, PackageVerificationResult.zzd(str, zzc.zzd));
        packageVerificationResult = zza.zzb;
        return packageVerificationResult;
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(@NonNull Context context, @NonNull String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e11) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!queryPackageSignatureVerified2.zzc()) {
                return queryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e11);
            return queryPackageSignatureVerified2;
        }
    }
}
