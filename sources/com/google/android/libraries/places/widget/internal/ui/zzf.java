package com.google.android.libraries.places.widget.internal.ui;

import androidx.activity.u;
import com.google.android.libraries.places.internal.zzln;

/* loaded from: classes4.dex */
final class zzf extends u {
    final /* synthetic */ AutocompleteImplFragment zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(AutocompleteImplFragment autocompleteImplFragment, boolean z10) {
        super(true);
        this.zza = autocompleteImplFragment;
    }

    @Override // androidx.activity.u
    public final void handleOnBackPressed() {
        zzln zzlnVar;
        zzlnVar = this.zza.zze;
        zzlnVar.zzj();
    }
}
