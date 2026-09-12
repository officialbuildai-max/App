package com.google.android.libraries.places.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzaum extends zzarw implements RandomAccess, zzaun {

    @Deprecated
    public static final zzaun zza;
    private static final zzaum zzb;
    private final List zzc;

    static {
        zzaum zzaumVar = new zzaum(false);
        zzb = zzaumVar;
        zza = zzaumVar;
    }

    public zzaum() {
        this(10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaum(int i11) {
        super(true);
        ArrayList arrayList = new ArrayList(i11);
        this.zzc = arrayList;
    }

    private zzaum(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzaum(boolean z10) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzask ? ((zzask) obj).zzm(zzaud.zzb) : zzaud.zzd((byte[]) obj);
    }

    @Override // com.google.android.libraries.places.internal.zzarw, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zza();
        this.zzc.add(i11, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzarw, java.util.AbstractList, java.util.List
    public final boolean addAll(int i11, Collection collection) {
        zza();
        if (collection instanceof zzaun) {
            collection = ((zzaun) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i11, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.libraries.places.internal.zzarw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.libraries.places.internal.zzarw, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzarw, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zza();
        Object remove = this.zzc.remove(i11);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.libraries.places.internal.zzarw, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zza();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.libraries.places.internal.zzauc
    public final /* bridge */ /* synthetic */ zzauc zzd(int i11) {
        if (i11 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i11);
        arrayList.addAll(this.zzc);
        return new zzaum(arrayList);
    }

    @Override // com.google.android.libraries.places.internal.zzaun
    public final zzaun zze() {
        return zzc() ? new zzaws(this) : this;
    }

    @Override // com.google.android.libraries.places.internal.zzaun
    public final Object zzf(int i11) {
        return this.zzc.get(i11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i11) {
        Object obj = this.zzc.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzask) {
            zzask zzaskVar = (zzask) obj;
            String zzm = zzaskVar.zzm(zzaud.zzb);
            if (zzaskVar.zzi()) {
                this.zzc.set(i11, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzaud.zzd(bArr);
        if (zzaxc.zze(bArr)) {
            this.zzc.set(i11, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.libraries.places.internal.zzaun
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.libraries.places.internal.zzaun
    public final void zzi(zzask zzaskVar) {
        zza();
        this.zzc.add(zzaskVar);
        ((AbstractList) this).modCount++;
    }
}
