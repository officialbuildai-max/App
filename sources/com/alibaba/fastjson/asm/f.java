package com.alibaba.fastjson.asm;

import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    int f18192a;

    /* renamed from: b, reason: collision with root package name */
    int f18193b;

    /* renamed from: c, reason: collision with root package name */
    private int f18194c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f18195d;

    private void a(int i11, int i12, int i13) {
        if (this.f18195d == null) {
            this.f18195d = new int[6];
        }
        int i14 = this.f18194c;
        int[] iArr = this.f18195d;
        if (i14 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f18195d = iArr2;
        }
        int[] iArr3 = this.f18195d;
        int i15 = this.f18194c;
        int i16 = i15 + 1;
        this.f18194c = i16;
        iArr3[i15] = i11;
        this.f18194c = i15 + 2;
        iArr3[i16] = i12 | i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar, a aVar, int i11, boolean z10) {
        if ((this.f18192a & 2) != 0) {
            if (z10) {
                aVar.f(this.f18193b - i11);
                return;
            } else {
                aVar.g(this.f18193b - i11);
                return;
            }
        }
        if (z10) {
            a(i11, aVar.f18154b, ASTNode.DISCARD);
            aVar.f(-1);
        } else {
            a(i11, aVar.f18154b, ASTNode.DEOP);
            aVar.g(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(i iVar, int i11, byte[] bArr) {
        this.f18192a |= 2;
        this.f18193b = i11;
        int i12 = 0;
        while (i12 < this.f18194c) {
            int[] iArr = this.f18195d;
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            i12 += 2;
            int i15 = iArr[i13];
            int i16 = 268435455 & i15;
            int i17 = i11 - i14;
            if ((i15 & (-268435456)) == 268435456) {
                bArr[i16] = (byte) (i17 >>> 8);
                bArr[i16 + 1] = (byte) i17;
            } else {
                bArr[i16] = (byte) (i17 >>> 24);
                bArr[i16 + 1] = (byte) (i17 >>> 16);
                bArr[i16 + 2] = (byte) (i17 >>> 8);
                bArr[i16 + 3] = (byte) i17;
            }
        }
    }
}
