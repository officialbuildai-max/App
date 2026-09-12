package com.google.android.gms.internal.gcm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
final class zzs {
    private final ConcurrentHashMap<zzt, List<Throwable>> zzdt = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzdu = new ReferenceQueue<>();

    public final List<Throwable> zzd(Throwable th2, boolean z10) {
        Reference<? extends Throwable> poll = this.zzdu.poll();
        while (poll != null) {
            this.zzdt.remove(poll);
            poll = this.zzdu.poll();
        }
        List<Throwable> list = this.zzdt.get(new zzt(th2, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzdt.putIfAbsent(new zzt(th2, this.zzdu), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
