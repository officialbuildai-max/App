package mf;

import com.tencent.tinker.android.dex.j;
import com.tencent.tinker.android.dex.v;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class g extends j {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.tinker.android.dex.j f69654d;

    /* renamed from: e, reason: collision with root package name */
    private v.a f69655e;

    /* renamed from: f, reason: collision with root package name */
    private j.h f69656f;

    /* renamed from: g, reason: collision with root package name */
    private List f69657g;

    public g(nf.a aVar, com.tencent.tinker.android.dex.j jVar, com.tencent.tinker.android.dex.j jVar2, of.c cVar) {
        super(aVar, jVar, cVar);
        this.f69654d = null;
        this.f69655e = null;
        this.f69656f = null;
        this.f69657g = null;
        if (jVar2 != null) {
            this.f69654d = jVar2;
            v.a aVar2 = jVar2.h().f40714g;
            this.f69655e = aVar2;
            this.f69656f = jVar2.m(aVar2);
            this.f69657g = new ArrayList(512);
        }
    }

    private List n(List list) {
        int i11;
        HashMap hashMap = new HashMap(list.size() + 8);
        HashMap hashMap2 = new HashMap(list.size() + 8);
        jf.a aVar = new jf.a(list.size() + 8);
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.tinker.android.dex.g gVar = (com.tencent.tinker.android.dex.g) it.next();
            hashMap.put(Integer.valueOf(gVar.f40641b), gVar);
            hashMap2.put(Integer.valueOf(gVar.f40641b), new ArrayList(8));
            aVar.n(gVar.f40641b, 0);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.tencent.tinker.android.dex.g gVar2 = (com.tencent.tinker.android.dex.g) it2.next();
            if (hashMap.containsKey(Integer.valueOf(gVar2.f40643d))) {
                ((List) hashMap2.get(Integer.valueOf(gVar2.f40643d))).add(Integer.valueOf(gVar2.f40641b));
                int i12 = gVar2.f40641b;
                aVar.n(i12, aVar.g(i12) + 1);
            }
            for (short s11 : this.f69654d.i(gVar2)) {
                if (hashMap.containsKey(Integer.valueOf(s11))) {
                    ((List) hashMap2.get(Integer.valueOf(s11))).add(Integer.valueOf(gVar2.f40641b));
                    int i13 = gVar2.f40641b;
                    aVar.n(i13, aVar.g(i13) + 1);
                }
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(64);
        for (i11 = 0; i11 < aVar.o(); i11++) {
            int m11 = aVar.m(i11);
            if (aVar.p(i11) == 0) {
                arrayDeque.offer(Integer.valueOf(m11));
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            Integer num = (Integer) arrayDeque.poll();
            num.intValue();
            arrayList.add((com.tencent.tinker.android.dex.g) hashMap.get(num));
            for (Integer num2 : (List) hashMap2.get(num)) {
                int intValue = num2.intValue();
                int g11 = aVar.g(intValue) - 1;
                aVar.n(intValue, g11);
                if (g11 == 0) {
                    arrayDeque.offer(num2);
                }
            }
        }
        if (arrayList.size() == list.size()) {
            return arrayList;
        }
        throw new IllegalStateException("Illegal dex format, there's at least one loop in class inheritance graph.");
    }

    @Override // mf.j
    protected v.a e(com.tencent.tinker.android.dex.j jVar) {
        return jVar.h().f40714g;
    }

    @Override // mf.j
    protected void h() {
        List n11 = n(this.f69657g);
        this.f69657g = n11;
        Iterator it = n11.iterator();
        while (it.hasNext()) {
            this.f69656f.W((com.tencent.tinker.android.dex.g) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.g a(of.a aVar, com.tencent.tinker.android.dex.g gVar) {
        return aVar.g(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.tinker.android.dex.g g(ff.a aVar) {
        return aVar.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mf.j
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public int k(com.tencent.tinker.android.dex.g gVar) {
        this.f69655e.f40736c++;
        this.f69657g.add(gVar);
        return 0;
    }
}
