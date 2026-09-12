package com.bytedance.adsdk.Sj.sP.TKC.Sj;

import com.bytedance.adsdk.Sj.sP.sP.Sj.zR;
import java.util.Deque;

/* loaded from: classes2.dex */
public class TKC extends vS {
    private int Sj(String str, int i11, Deque<com.bytedance.adsdk.Sj.sP.sP.Sj> deque) {
        int i12;
        int i13 = 0;
        while (true) {
            i12 = i13 + i11;
            char Sj = Sj(i12, str);
            if (!com.bytedance.adsdk.Sj.sP.HiB.Sj.sP(Sj) && !com.bytedance.adsdk.Sj.sP.HiB.Sj.TKC(Sj) && '.' != Sj && '[' != Sj && ']' != Sj && '_' != Sj && '-' != Sj && '$' != Sj) {
                break;
            }
            i13++;
        }
        String substring = str.substring(i11, i12);
        if (com.bytedance.adsdk.Sj.sP.EjP.Sj.Sj(substring) != null) {
            deque.push(new com.bytedance.adsdk.Sj.sP.sP.Sj.Jcg(substring));
        } else {
            deque.push(new zR(substring));
        }
        return i12;
    }

    @Override // com.bytedance.adsdk.Sj.sP.TKC.Sj.vS
    public int Sj(String str, int i11, Deque<com.bytedance.adsdk.Sj.sP.sP.Sj> deque, com.bytedance.adsdk.Sj.sP.TKC.Sj sj2) {
        char Sj = Sj(i11, str);
        return (com.bytedance.adsdk.Sj.sP.HiB.Sj.sP(Sj) || Sj == '$') ? Sj(str, i11, deque) : sj2.Sj(str, i11, deque);
    }
}
