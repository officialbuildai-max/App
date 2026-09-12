package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzars;
import com.google.android.libraries.places.internal.zzart;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzart<MessageType extends zzart<MessageType, BuilderType>, BuilderType extends zzars<MessageType, BuilderType>> implements zzavf {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static void zzam(Iterable iterable, List list) {
        byte[] bArr = zzaud.zzd;
        if (iterable instanceof zzaun) {
            List zzh = ((zzaun) iterable).zzh();
            zzaun zzaunVar = (zzaun) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzaunVar.size() - size) + " is null.";
                    int size2 = zzaunVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            break;
                        } else {
                            zzaunVar.remove(size2);
                        }
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzask) {
                    zzaunVar.zzi((zzask) obj);
                } else {
                    zzaunVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzavo) {
            list.addAll(iterable);
            return;
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        break;
                    } else {
                        list.remove(size4);
                    }
                }
                throw new NullPointerException(str2);
            }
            list.add(obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzak(zzavt zzavtVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzavf
    public final zzask zzal() {
        try {
            int zzaq = zzaq();
            zzask zzaskVar = zzask.zzb;
            byte[] bArr = new byte[zzaq];
            zzast zzastVar = new zzast(bArr, 0, zzaq);
            zzaK(zzastVar);
            zzastVar.zzE();
            return new zzash(bArr);
        } catch (IOException e11) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e11);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavf
    public final void zzan(OutputStream outputStream) throws IOException {
        int zzaq = zzaq();
        int i11 = zzasx.zzf;
        if (zzaq > 4096) {
            zzaq = 4096;
        }
        zzasv zzasvVar = new zzasv(outputStream, zzaq);
        zzaK(zzasvVar);
        zzasvVar.zzJ();
    }

    @Override // com.google.android.libraries.places.internal.zzavf
    public final byte[] zzao() {
        try {
            int zzaq = zzaq();
            byte[] bArr = new byte[zzaq];
            zzast zzastVar = new zzast(bArr, 0, zzaq);
            zzaK(zzastVar);
            zzastVar.zzE();
            return bArr;
        } catch (IOException e11) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e11);
        }
    }
}
