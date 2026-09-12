package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzme extends zzmh {
    final /* synthetic */ zzmh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzme(zzmh zzmhVar, zzmh zzmhVar2) {
        super(zzmhVar2, null);
        this.zza = zzmhVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmh
    public final Appendable zza(Appendable appendable, Iterator it) throws IOException {
        String str;
        zzmt.zzc(it, "parts");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                appendable.append(zzmh.zzh(next));
                break;
            }
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                str = this.zza.zza;
                appendable.append(str);
                appendable.append(zzmh.zzh(next2));
            }
        }
        return appendable;
    }
}
