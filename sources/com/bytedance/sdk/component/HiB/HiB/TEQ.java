package com.bytedance.sdk.component.HiB.HiB;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.HiB.dNu;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class TEQ extends Sj {
    private Bitmap TKC(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        return tkc.TzV().Sj(tkc.RiZ()).Sj(tkc.TEQ());
    }

    private Bitmap sP(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        Collection<dNu> Sj = tkc.TzV().Sj();
        Bitmap bitmap = null;
        if (Sj == null) {
            return null;
        }
        Iterator<dNu> it = Sj.iterator();
        while (it.hasNext() && (bitmap = it.next().Sj(tkc.TEQ())) == null) {
        }
        return bitmap;
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        int aa2 = tkc.aa();
        Bitmap sP = (aa2 == 2 || aa2 == 1) ? (tkc.sU() || tkc.RiZ().uA()) ? sP(tkc) : TKC(tkc) : null;
        if (sP == null) {
            tkc.Sj(new aa());
        } else {
            tkc.Sj(new Fmk(sP, null, false));
        }
    }
}
