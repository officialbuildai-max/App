package tz;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tz.c;
import tz.e;
import tz.f;
import tz.g;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    private static final List f76542j;

    /* renamed from: b, reason: collision with root package name */
    int f76544b;

    /* renamed from: e, reason: collision with root package name */
    byte[] f76547e;

    /* renamed from: f, reason: collision with root package name */
    int f76548f;

    /* renamed from: g, reason: collision with root package name */
    InputStream f76549g;

    /* renamed from: i, reason: collision with root package name */
    private boolean[] f76551i;

    /* renamed from: a, reason: collision with root package name */
    byte[] f76543a = new byte[8000];

    /* renamed from: c, reason: collision with root package name */
    short[] f76545c = new short[256];

    /* renamed from: d, reason: collision with root package name */
    boolean f76546d = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76550h = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tz.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0956a {

        /* renamed from: a, reason: collision with root package name */
        h f76552a;

        /* renamed from: b, reason: collision with root package name */
        boolean f76553b;

        C0956a(h hVar, boolean z10) {
            this.f76552a = hVar;
            this.f76553b = z10;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0956a(new d(), true));
        arrayList.add(new C0956a(new e.a(), true));
        arrayList.add(new C0956a(new e.b(), true));
        arrayList.add(new C0956a(new e.d(), true));
        arrayList.add(new C0956a(new e.C0958e(), true));
        arrayList.add(new C0956a(new f.d(), true));
        arrayList.add(new C0956a(new c.b(), true));
        arrayList.add(new C0956a(new c.a(), true));
        arrayList.add(new C0956a(new c.C0957c(), true));
        arrayList.add(new C0956a(new f.c(), true));
        arrayList.add(new C0956a(new f.b.a(), true));
        arrayList.add(new C0956a(new f.b.C0959b(), true));
        arrayList.add(new C0956a(new f.a(), true));
        arrayList.add(new C0956a(new g.a(), true));
        arrayList.add(new C0956a(new g.b(), true));
        arrayList.add(new C0956a(new g.d(), true));
        arrayList.add(new C0956a(new g.f(), true));
        arrayList.add(new C0956a(new g.h(), true));
        arrayList.add(new C0956a(new g.j(), true));
        arrayList.add(new C0956a(new g.k(), true));
        arrayList.add(new C0956a(new g.u(), true));
        arrayList.add(new C0956a(new g.v(), true));
        arrayList.add(new C0956a(new g.t(), true));
        arrayList.add(new C0956a(new g.m(), true));
        arrayList.add(new C0956a(new g.s(), false));
        arrayList.add(new C0956a(new g.r(), false));
        arrayList.add(new C0956a(new g.p(), false));
        arrayList.add(new C0956a(new g.o(), false));
        f76542j = Collections.unmodifiableList(arrayList);
    }

    private void a() {
        int i11;
        int i12;
        if (this.f76550h) {
            int i13 = 0;
            i11 = 0;
            i12 = 0;
            boolean z10 = false;
            for (int i14 = 0; i14 < this.f76548f; i14++) {
                byte[] bArr = this.f76543a;
                if (i13 >= bArr.length) {
                    break;
                }
                byte b11 = this.f76547e[i14];
                if (b11 == 60) {
                    if (z10) {
                        i12++;
                    }
                    i11++;
                    z10 = true;
                }
                if (!z10) {
                    bArr[i13] = b11;
                    i13++;
                }
                if (b11 == 62) {
                    z10 = false;
                }
            }
            this.f76544b = i13;
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (i11 < 5 || i11 / 5 < i12 || (this.f76544b < 100 && this.f76548f > 600)) {
            int i15 = this.f76548f;
            if (i15 > 8000) {
                i15 = 8000;
            }
            int i16 = 0;
            while (i16 < i15) {
                this.f76543a[i16] = this.f76547e[i16];
                i16++;
            }
            this.f76544b = i16;
        }
        Arrays.fill(this.f76545c, (short) 0);
        for (int i17 = 0; i17 < this.f76544b; i17++) {
            int i18 = this.f76543a[i17] & 255;
            short[] sArr = this.f76545c;
            sArr[i18] = (short) (sArr[i18] + 1);
        }
        this.f76546d = false;
        for (int i19 = 128; i19 <= 159; i19++) {
            if (this.f76545c[i19] != 0) {
                this.f76546d = true;
                return;
            }
        }
    }

    public b b() {
        b[] c11 = c();
        if (c11 == null || c11.length == 0) {
            return null;
        }
        return c11[0];
    }

    public b[] c() {
        b c11;
        ArrayList arrayList = new ArrayList();
        a();
        int i11 = 0;
        while (true) {
            List list = f76542j;
            if (i11 >= list.size()) {
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                return (b[]) arrayList.toArray(new b[arrayList.size()]);
            }
            C0956a c0956a = (C0956a) list.get(i11);
            boolean[] zArr = this.f76551i;
            if ((zArr != null ? zArr[i11] : c0956a.f76553b) && (c11 = c0956a.f76552a.c(this)) != null) {
                arrayList.add(c11);
            }
            i11++;
        }
    }

    public a d(byte[] bArr) {
        this.f76547e = bArr;
        this.f76548f = bArr.length;
        return this;
    }
}
