package com.alibaba.fastjson.asm;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes2.dex */
public class i implements h {

    /* renamed from: a, reason: collision with root package name */
    i f18201a;

    /* renamed from: b, reason: collision with root package name */
    final c f18202b;

    /* renamed from: c, reason: collision with root package name */
    private int f18203c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18204d;

    /* renamed from: e, reason: collision with root package name */
    private final int f18205e;

    /* renamed from: f, reason: collision with root package name */
    int f18206f;

    /* renamed from: g, reason: collision with root package name */
    int[] f18207g;

    /* renamed from: h, reason: collision with root package name */
    private a f18208h = new a();

    /* renamed from: i, reason: collision with root package name */
    private int f18209i;

    /* renamed from: j, reason: collision with root package name */
    private int f18210j;

    public i(c cVar, int i11, String str, String str2, String str3, String[] strArr) {
        if (cVar.f18177q == null) {
            cVar.f18177q = this;
        } else {
            cVar.f18178r.f18201a = this;
        }
        cVar.f18178r = this;
        this.f18202b = cVar;
        this.f18203c = i11;
        this.f18204d = cVar.h(str);
        this.f18205e = cVar.h(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f18206f = length;
        this.f18207g = new int[length];
        for (int i12 = 0; i12 < this.f18206f; i12++) {
            this.f18207g[i12] = cVar.b(strArr[i12]).f18183a;
        }
    }

    @Override // com.alibaba.fastjson.asm.h
    public void a(int i11, f fVar) {
        if ((fVar.f18192a & 2) != 0 && fVar.f18193b - this.f18208h.f18154b < -32768) {
            throw new UnsupportedOperationException();
        }
        this.f18208h.d(i11);
        a aVar = this.f18208h;
        fVar.b(this, aVar, aVar.f18154b - 1, i11 == 200);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void b(int i11, String str, String str2, String str3) {
        this.f18208h.c(i11, this.f18202b.d(str, str2, str3).f18183a);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void c(int i11, int i12) {
        if (i12 < 4 && i11 != 169) {
            this.f18208h.d((i11 < 54 ? ((i11 - 21) << 2) + 26 : ((i11 - 54) << 2) + 59) + i12);
        } else if (i12 >= 256) {
            this.f18208h.d(196).c(i11, i12);
        } else {
            this.f18208h.b(i11, i12);
        }
    }

    @Override // com.alibaba.fastjson.asm.h
    public void d(Object obj) {
        e c11 = this.f18202b.c(obj);
        int i11 = c11.f18183a;
        int i12 = c11.f18184b;
        if (i12 == 5 || i12 == 6) {
            this.f18208h.c(20, i11);
        } else if (i11 >= 256) {
            this.f18208h.c(19, i11);
        } else {
            this.f18208h.b(18, i11);
        }
    }

    @Override // com.alibaba.fastjson.asm.h
    public void e(int i11, int i12) {
        this.f18208h.d(Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE).b(i11, i12);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void f(int i11, String str) {
        this.f18208h.c(i11, this.f18202b.b(str).f18183a);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void g(int i11, int i12) {
        this.f18208h.b(i11, i12);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void h(int i11) {
        this.f18208h.d(i11);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void i(int i11, int i12) {
        this.f18209i = i11;
        this.f18210j = i12;
    }

    @Override // com.alibaba.fastjson.asm.h
    public void j(int i11, String str, String str2, String str3) {
        boolean z10 = i11 == 185;
        e e11 = this.f18202b.e(str, str2, str3, z10);
        int i12 = e11.f18185c;
        if (!z10) {
            this.f18208h.c(i11, e11.f18183a);
            return;
        }
        if (i12 == 0) {
            i12 = j.b(str3);
            e11.f18185c = i12;
        }
        this.f18208h.c(185, e11.f18183a).b(i12 >> 2, 0);
    }

    @Override // com.alibaba.fastjson.asm.h
    public void k() {
    }

    @Override // com.alibaba.fastjson.asm.h
    public void l(f fVar) {
        a aVar = this.f18208h;
        fVar.c(this, aVar.f18154b, aVar.f18153a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int m() {
        int i11;
        if (this.f18208h.f18154b > 0) {
            this.f18202b.h("Code");
            i11 = this.f18208h.f18154b + 26;
        } else {
            i11 = 8;
        }
        if (this.f18206f <= 0) {
            return i11;
        }
        this.f18202b.h("Exceptions");
        return i11 + (this.f18206f * 2) + 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(a aVar) {
        aVar.g(this.f18203c & (-393217)).g(this.f18204d).g(this.f18205e);
        int i11 = this.f18208h.f18154b > 0 ? 1 : 0;
        if (this.f18206f > 0) {
            i11++;
        }
        aVar.g(i11);
        int i12 = this.f18208h.f18154b;
        if (i12 > 0) {
            aVar.g(this.f18202b.h("Code")).f(i12 + 12);
            aVar.g(this.f18209i).g(this.f18210j);
            a f11 = aVar.f(this.f18208h.f18154b);
            a aVar2 = this.f18208h;
            f11.e(aVar2.f18153a, 0, aVar2.f18154b);
            aVar.g(0);
            aVar.g(0);
        }
        if (this.f18206f > 0) {
            aVar.g(this.f18202b.h("Exceptions")).f((this.f18206f * 2) + 2);
            aVar.g(this.f18206f);
            for (int i13 = 0; i13 < this.f18206f; i13++) {
                aVar.g(this.f18207g[i13]);
            }
        }
    }
}
