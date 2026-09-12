package n10;

import java.util.Iterator;
import java.util.LinkedList;
import org.mvel2.util.k;

/* loaded from: classes7.dex */
public class b extends ClassLoader implements k {

    /* renamed from: a, reason: collision with root package name */
    private int f70210a;

    /* renamed from: b, reason: collision with root package name */
    private int f70211b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList f70212c;

    public b(ClassLoader classLoader, int i11) {
        super(classLoader);
        this.f70212c = new LinkedList();
        this.f70211b = i11;
    }

    @Override // org.mvel2.util.k
    public Class a(String str, byte[] bArr, int i11, int i12) {
        this.f70210a++;
        return super.defineClass(str, bArr, i11, i12);
    }

    public void b() {
        synchronized (this.f70212c) {
            try {
                Iterator it = this.f70212c.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar != null) {
                        aVar.a();
                    }
                }
                this.f70212c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int c() {
        return this.f70210a;
    }

    public boolean d() {
        return this.f70211b < this.f70210a;
    }

    public a e(a aVar) {
        synchronized (this.f70212c) {
            try {
                this.f70212c.add(aVar);
                while (this.f70212c.size() > this.f70211b) {
                    a aVar2 = (a) this.f70212c.removeFirst();
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }
}
