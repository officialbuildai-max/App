package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class zzaup extends zzaut {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzaup() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaup(zzauo zzauoVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j11, int i11) {
        zzaum zzaumVar;
        List list = (List) zzawx.zzf(obj, j11);
        if (list.isEmpty()) {
            List zzaumVar2 = list instanceof zzaun ? new zzaum(i11) : ((list instanceof zzavo) && (list instanceof zzauc)) ? ((zzauc) list).zzd(i11) : new ArrayList(i11);
            zzawx.zzs(obj, j11, zzaumVar2);
            return zzaumVar2;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i11);
            arrayList.addAll(list);
            zzawx.zzs(obj, j11, arrayList);
            zzaumVar = arrayList;
        } else {
            if (!(list instanceof zzaws)) {
                if (!(list instanceof zzavo) || !(list instanceof zzauc)) {
                    return list;
                }
                zzauc zzaucVar = (zzauc) list;
                if (zzaucVar.zzc()) {
                    return list;
                }
                zzauc zzd = zzaucVar.zzd(list.size() + i11);
                zzawx.zzs(obj, j11, zzd);
                return zzd;
            }
            zzaum zzaumVar3 = new zzaum(list.size() + i11);
            zzaumVar3.addAll(zzaumVar3.size(), (zzaws) list);
            zzawx.zzs(obj, j11, zzaumVar3);
            zzaumVar = zzaumVar3;
        }
        return zzaumVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzaut
    public final List zza(Object obj, long j11) {
        return zzf(obj, j11, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzaut
    public final void zzb(Object obj, long j11) {
        Object unmodifiableList;
        List list = (List) zzawx.zzf(obj, j11);
        if (list instanceof zzaun) {
            unmodifiableList = ((zzaun) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzavo) && (list instanceof zzauc)) {
                zzauc zzaucVar = (zzauc) list;
                if (zzaucVar.zzc()) {
                    zzaucVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzawx.zzs(obj, j11, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.libraries.places.internal.zzaut
    public final void zzc(Object obj, Object obj2, long j11) {
        List list = (List) zzawx.zzf(obj2, j11);
        List zzf = zzf(obj, j11, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzawx.zzs(obj, j11, list);
    }
}
