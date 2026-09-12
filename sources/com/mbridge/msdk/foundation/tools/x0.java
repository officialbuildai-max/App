package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class x0 implements FastKV.b<Set<String>> {

    /* renamed from: a, reason: collision with root package name */
    static final x0 f35884a = new x0();

    private x0() {
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    public String a() {
        return "StringSet";
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    public byte[] a(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i11 = 0;
        int i12 = 0;
        for (String str : set) {
            if (str == null) {
                i11 += 5;
                iArr[i12] = -1;
            } else {
                int b11 = z.b(str);
                strArr[i12] = str;
                iArr[i12] = b11;
                i11 += z.f(b11) + b11;
            }
            i12++;
        }
        z zVar = new z(i11);
        for (int i13 = 0; i13 < size; i13++) {
            int i14 = iArr[i13];
            zVar.h(i14);
            if (i14 >= 0) {
                zVar.c(strArr[i13]);
            }
        }
        return zVar.f35885a;
    }

    @Override // com.mbridge.msdk.foundation.tools.FastKV.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<String> a(byte[] bArr, int i11, int i12) {
        int i13;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i12 > 0) {
            z zVar = new z(bArr, i11);
            int i14 = i11 + i12;
            while (true) {
                i13 = zVar.f35886b;
                if (i13 >= i14) {
                    break;
                }
                linkedHashSet.add(zVar.e(zVar.g()));
            }
            if (i13 != i14) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
