package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    final a f14485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        a.b a(int i11, int i12, int i13, Object obj);

        void b(a.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.f14485a = aVar;
    }

    private int a(List list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).f14426a != 8) {
                z10 = true;
            } else if (z10) {
                return size;
            }
        }
        return -1;
    }

    private void c(List list, int i11, a.b bVar, int i12, a.b bVar2) {
        int i13 = bVar.f14429d;
        int i14 = bVar2.f14427b;
        int i15 = i13 < i14 ? -1 : 0;
        int i16 = bVar.f14427b;
        if (i16 < i14) {
            i15++;
        }
        if (i14 <= i16) {
            bVar.f14427b = i16 + bVar2.f14429d;
        }
        int i17 = bVar2.f14427b;
        if (i17 <= i13) {
            bVar.f14429d = i13 + bVar2.f14429d;
        }
        bVar2.f14427b = i17 + i15;
        list.set(i11, bVar2);
        list.set(i12, bVar);
    }

    private void d(List list, int i11, int i12) {
        a.b bVar = (a.b) list.get(i11);
        a.b bVar2 = (a.b) list.get(i12);
        int i13 = bVar2.f14426a;
        if (i13 == 1) {
            c(list, i11, bVar, i12, bVar2);
        } else if (i13 == 2) {
            e(list, i11, bVar, i12, bVar2);
        } else {
            if (i13 != 4) {
                return;
            }
            f(list, i11, bVar, i12, bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List list) {
        while (true) {
            int a11 = a(list);
            if (a11 == -1) {
                return;
            } else {
                d(list, a11, a11 + 1);
            }
        }
    }

    void e(List list, int i11, a.b bVar, int i12, a.b bVar2) {
        boolean z10;
        int i13 = bVar.f14427b;
        int i14 = bVar.f14429d;
        boolean z11 = false;
        if (i13 < i14) {
            if (bVar2.f14427b == i13 && bVar2.f14429d == i14 - i13) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (bVar2.f14427b == i14 + 1 && bVar2.f14429d == i13 - i14) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i15 = bVar2.f14427b;
        if (i14 < i15) {
            bVar2.f14427b = i15 - 1;
        } else {
            int i16 = bVar2.f14429d;
            if (i14 < i15 + i16) {
                bVar2.f14429d = i16 - 1;
                bVar.f14426a = 2;
                bVar.f14429d = 1;
                if (bVar2.f14429d == 0) {
                    list.remove(i12);
                    this.f14485a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i17 = bVar.f14427b;
        int i18 = bVar2.f14427b;
        a.b bVar3 = null;
        if (i17 <= i18) {
            bVar2.f14427b = i18 + 1;
        } else {
            int i19 = bVar2.f14429d;
            if (i17 < i18 + i19) {
                bVar3 = this.f14485a.a(2, i17 + 1, (i18 + i19) - i17, null);
                bVar2.f14429d = bVar.f14427b - bVar2.f14427b;
            }
        }
        if (z11) {
            list.set(i11, bVar2);
            list.remove(i12);
            this.f14485a.b(bVar);
            return;
        }
        if (z10) {
            if (bVar3 != null) {
                int i20 = bVar.f14427b;
                if (i20 > bVar3.f14427b) {
                    bVar.f14427b = i20 - bVar3.f14429d;
                }
                int i21 = bVar.f14429d;
                if (i21 > bVar3.f14427b) {
                    bVar.f14429d = i21 - bVar3.f14429d;
                }
            }
            int i22 = bVar.f14427b;
            if (i22 > bVar2.f14427b) {
                bVar.f14427b = i22 - bVar2.f14429d;
            }
            int i23 = bVar.f14429d;
            if (i23 > bVar2.f14427b) {
                bVar.f14429d = i23 - bVar2.f14429d;
            }
        } else {
            if (bVar3 != null) {
                int i24 = bVar.f14427b;
                if (i24 >= bVar3.f14427b) {
                    bVar.f14427b = i24 - bVar3.f14429d;
                }
                int i25 = bVar.f14429d;
                if (i25 >= bVar3.f14427b) {
                    bVar.f14429d = i25 - bVar3.f14429d;
                }
            }
            int i26 = bVar.f14427b;
            if (i26 >= bVar2.f14427b) {
                bVar.f14427b = i26 - bVar2.f14429d;
            }
            int i27 = bVar.f14429d;
            if (i27 >= bVar2.f14427b) {
                bVar.f14429d = i27 - bVar2.f14429d;
            }
        }
        list.set(i11, bVar2);
        if (bVar.f14427b != bVar.f14429d) {
            list.set(i12, bVar);
        } else {
            list.remove(i12);
        }
        if (bVar3 != null) {
            list.add(i11, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void f(java.util.List r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f14429d
            int r1 = r13.f14427b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f14427b = r1
            goto L20
        Ld:
            int r5 = r13.f14429d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f14429d = r5
            androidx.recyclerview.widget.l$a r0 = r8.f14485a
            int r1 = r11.f14427b
            java.lang.Object r5 = r13.f14428c
            androidx.recyclerview.widget.a$b r0 = r0.a(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f14427b
            int r5 = r13.f14427b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f14427b = r5
            goto L41
        L2b:
            int r6 = r13.f14429d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.l$a r4 = r8.f14485a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f14428c
            androidx.recyclerview.widget.a$b r4 = r4.a(r2, r1, r5, r3)
            int r1 = r13.f14429d
            int r1 = r1 - r5
            r13.f14429d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f14429d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.l$a r11 = r8.f14485a
            r11.b(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.l.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
