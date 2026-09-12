package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzato;
import com.google.android.libraries.places.internal.zzatu;

/* loaded from: classes4.dex */
public class zzato<MessageType extends zzatu<MessageType, BuilderType>, BuilderType extends zzato<MessageType, BuilderType>> extends zzars<MessageType, BuilderType> {
    protected zzatu zza;
    private final zzatu zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzato(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaH()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzat();
    }

    private static void zza(Object obj, Object obj2) {
        zzavp.zza().zzb(obj.getClass()).zze(obj, obj2);
    }

    @Override // com.google.android.libraries.places.internal.zzavg
    public final /* synthetic */ zzavf zzaL() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzavg
    public final boolean zzaM() {
        return zzatu.zzaG(this.zza, false);
    }

    @Override // com.google.android.libraries.places.internal.zzars
    /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public final zzato clone() {
        zzato zzatoVar = (zzato) this.zzb.zzb(5, null, null);
        zzatoVar.zza = zzu();
        return zzatoVar;
    }

    public final zzato zzq(zzatu zzatuVar) {
        if (!this.zzb.equals(zzatuVar)) {
            if (!this.zza.zzaH()) {
                zzx();
            }
            zza(this.zza, zzatuVar);
        }
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzave
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public final MessageType zzt() {
        MessageType zzu = zzu();
        if (zzu.zzaM()) {
            return zzu;
        }
        throw new zzawm(zzu);
    }

    @Override // com.google.android.libraries.places.internal.zzave
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    public MessageType zzu() {
        if (!this.zza.zzaH()) {
            return (MessageType) this.zza;
        }
        this.zza.zzaC();
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw() {
        if (this.zza.zzaH()) {
            return;
        }
        zzx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzx() {
        zzatu zzat = this.zzb.zzat();
        zza(zzat, this.zza);
        this.zza = zzat;
    }
}
