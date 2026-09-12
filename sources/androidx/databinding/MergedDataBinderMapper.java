package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MergedDataBinderMapper extends e {

    /* renamed from: a, reason: collision with root package name */
    private Set f8612a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private List f8613b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List f8614c = new CopyOnWriteArrayList();

    private boolean e() {
        boolean z10 = false;
        for (String str : this.f8614c) {
            try {
                Class<?> cls = Class.forName(str);
                if (e.class.isAssignableFrom(cls)) {
                    d((e) cls.newInstance());
                    this.f8614c.remove(str);
                    z10 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e11) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e11);
            } catch (InstantiationException e12) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e12);
            }
        }
        return z10;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding b(f fVar, View view, int i11) {
        Iterator it = this.f8613b.iterator();
        while (it.hasNext()) {
            ((e) it.next()).b(fVar, view, i11);
        }
        if (e()) {
            b(fVar, view, i11);
        }
        return null;
    }

    @Override // androidx.databinding.e
    public int c(String str) {
        Iterator it = this.f8613b.iterator();
        while (it.hasNext()) {
            int c11 = ((e) it.next()).c(str);
            if (c11 != 0) {
                return c11;
            }
        }
        if (e()) {
            return c(str);
        }
        return 0;
    }

    public void d(e eVar) {
        if (this.f8612a.add(eVar.getClass())) {
            this.f8613b.add(eVar);
            Iterator it = eVar.a().iterator();
            while (it.hasNext()) {
                d((e) it.next());
            }
        }
    }
}
