package com.bytedance.sdk.component.Sj;

import android.net.Uri;
import com.bytedance.sdk.component.Sj.Ym;
import com.bytedance.sdk.component.Sj.dx;
import com.bytedance.sdk.component.Sj.zR;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class sU {
    private final dx EjP;
    private Ym.Sj HiB;
    private final Set<String> Sj;
    private final zR TKC = dNu.Sj;
    private final Set<String> sP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sU(dx dxVar, Set<String> set, Set<String> set2) {
        this.EjP = dxVar;
        if (set == null || set.isEmpty()) {
            this.Sj = new LinkedHashSet();
        } else {
            this.Sj = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.sP = new LinkedHashSet();
        } else {
            this.sP = new LinkedHashSet(set2);
        }
    }

    private ib Sj(String str, sP sPVar, boolean z10) {
        if (!z10 || this.EjP == null) {
            return null;
        }
        throw null;
    }

    final synchronized ib Sj(String str, sP sPVar) throws dx.Sj {
        return Sj(str, sPVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized ib Sj(boolean z10, String str, sP sPVar) throws dx.Sj {
        Ym.Sj sj2;
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host == null) {
                return null;
            }
            ib ibVar = this.sP.contains(sPVar.Sj()) ? ib.PUBLIC : null;
            for (String str2 : this.Sj) {
                if (parse.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                    ibVar = ib.PRIVATE;
                    break;
                }
            }
            if (ibVar == null && (sj2 = this.HiB) != null && sj2.Sj(str)) {
                if (this.HiB.Sj(str, sPVar.Sj())) {
                    return null;
                }
                ibVar = ib.PRIVATE;
            }
            ib Sj = z10 ? Sj(str, sPVar) : sP(str, sPVar);
            return Sj != null ? Sj : ibVar;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(Ym.Sj sj2) {
        this.HiB = sj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(zR.Sj sj2) {
        if (this.TKC != null) {
            throw null;
        }
    }

    final synchronized ib sP(String str, sP sPVar) {
        return Sj(str, sPVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sP(zR.Sj sj2) {
        if (this.TKC != null) {
            throw null;
        }
    }
}
