package com.google.android.libraries.places.widget.internal.ui;

import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzln;

/* loaded from: classes4.dex */
final class zzg extends RecyclerView.r {
    final /* synthetic */ AutocompleteImplFragment zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(AutocompleteImplFragment autocompleteImplFragment) {
        this.zza = autocompleteImplFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public final void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        zzln zzlnVar;
        EditText editText;
        if (i11 == 1) {
            try {
                zzlnVar = this.zza.zze;
                zzlnVar.zzg();
                editText = this.zza.zzg;
                editText.clearFocus();
            } catch (Error | RuntimeException e11) {
                zzkd.zzb(e11);
                throw e11;
            }
        }
    }
}
