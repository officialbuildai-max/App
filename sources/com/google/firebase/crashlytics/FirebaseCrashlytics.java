package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.d0;
import com.google.firebase.crashlytics.internal.common.g0;
import com.google.firebase.crashlytics.internal.common.k;
import com.google.firebase.crashlytics.internal.common.x;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.f;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import ic.a;
import java.util.List;
import java.util.concurrent.ExecutorService;
import jc.e;
import ob.d;
import ob.g;
import ob.l;
import ub.b;

/* loaded from: classes.dex */
public class FirebaseCrashlytics {

    /* renamed from: a, reason: collision with root package name */
    final x f31186a;

    private FirebaseCrashlytics(x xVar) {
        this.f31186a = xVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FirebaseCrashlytics b(f fVar, e eVar, a aVar, a aVar2, a aVar3, ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3) {
        Context k11 = fVar.k();
        String packageName = k11.getPackageName();
        g.f().g("Initializing Firebase Crashlytics " + x.q() + " for " + packageName);
        CrashlyticsWorkers crashlyticsWorkers = new CrashlyticsWorkers(executorService, executorService2);
        vb.g gVar = new vb.g(k11);
        d0 d0Var = new d0(fVar);
        g0 g0Var = new g0(k11, packageName, eVar, d0Var);
        d dVar = new d(aVar);
        nb.d dVar2 = new nb.d(aVar2);
        k kVar = new k(d0Var, gVar);
        FirebaseSessionsDependencies.e(kVar);
        x xVar = new x(fVar, g0Var, dVar, d0Var, dVar2.e(), dVar2.d(), gVar, kVar, new l(aVar3), crashlyticsWorkers);
        String c11 = fVar.n().c();
        String m11 = CommonUtils.m(k11);
        List<com.google.firebase.crashlytics.internal.common.e> j11 = CommonUtils.j(k11);
        g.f().b("Mapping file ID is: " + m11);
        for (com.google.firebase.crashlytics.internal.common.e eVar2 : j11) {
            g.f().b(String.format("Build id for %s on %s: %s", eVar2.c(), eVar2.a(), eVar2.b()));
        }
        try {
            com.google.firebase.crashlytics.internal.common.a a11 = com.google.firebase.crashlytics.internal.common.a.a(k11, g0Var, c11, m11, j11, new ob.f(k11));
            g.f().i("Installer package name is: " + a11.f31194d);
            com.google.firebase.crashlytics.internal.settings.e l11 = com.google.firebase.crashlytics.internal.settings.e.l(k11, c11, g0Var, new b(), a11.f31196f, a11.f31197g, gVar, d0Var);
            l11.o(crashlyticsWorkers).addOnFailureListener(executorService3, new OnFailureListener() { // from class: nb.h
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    FirebaseCrashlytics.c(exc);
                }
            });
            if (xVar.F(a11, l11)) {
                xVar.o(l11);
            }
            return new FirebaseCrashlytics(xVar);
        } catch (PackageManager.NameNotFoundException e11) {
            g.f().e("Error retrieving app package info.", e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
        g.f().e("Error fetching settings.", exc);
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) f.l().j(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.f31186a.j();
    }

    public void deleteUnsentReports() {
        this.f31186a.k();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.f31186a.l();
    }

    public boolean isCrashlyticsCollectionEnabled() {
        return this.f31186a.s();
    }

    public void log(@NonNull String str) {
        this.f31186a.B(str);
    }

    public void recordException(@NonNull Throwable th2) {
        if (th2 == null) {
            g.f().k("A null value was passed to recordException. Ignoring.");
        } else {
            this.f31186a.C(th2);
        }
    }

    public void sendUnsentReports() {
        this.f31186a.G();
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.f31186a.H(bool);
    }

    public void setCrashlyticsCollectionEnabled(boolean z10) {
        this.f31186a.H(Boolean.valueOf(z10));
    }

    public void setCustomKey(@NonNull String str, double d11) {
        this.f31186a.I(str, Double.toString(d11));
    }

    public void setCustomKey(@NonNull String str, float f11) {
        this.f31186a.I(str, Float.toString(f11));
    }

    public void setCustomKey(@NonNull String str, int i11) {
        this.f31186a.I(str, Integer.toString(i11));
    }

    public void setCustomKey(@NonNull String str, long j11) {
        this.f31186a.I(str, Long.toString(j11));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.f31186a.I(str, str2);
    }

    public void setCustomKey(@NonNull String str, boolean z10) {
        this.f31186a.I(str, Boolean.toString(z10));
    }

    public void setCustomKeys(@NonNull nb.g gVar) {
        throw null;
    }

    public void setUserId(@NonNull String str) {
        this.f31186a.J(str);
    }
}
