package com.bytedance.adsdk.Sj.sP.TKC.Sj;

import java.util.Deque;

/* loaded from: classes2.dex */
public class HiB extends vS {
    @Override // com.bytedance.adsdk.Sj.sP.TKC.Sj.vS
    public int Sj(String str, int i11, Deque<com.bytedance.adsdk.Sj.sP.sP.Sj> deque, com.bytedance.adsdk.Sj.sP.TKC.Sj sj2) {
        char Sj;
        int i12 = i11;
        while (true) {
            Sj = Sj(i12, str);
            if (!com.bytedance.adsdk.Sj.sP.HiB.Sj.sP(Sj) && !com.bytedance.adsdk.Sj.sP.HiB.Sj.TKC(Sj)) {
                break;
            }
            i12++;
        }
        if (Sj != '(') {
            return sj2.Sj(str, i11, deque);
        }
        deque.push(new com.bytedance.adsdk.Sj.sP.sP.Sj.TEQ(str.substring(i11, i12)));
        return i12 + 1;
    }
}
