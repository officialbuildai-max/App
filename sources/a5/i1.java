package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    protected List f321a = null;

    /* renamed from: b, reason: collision with root package name */
    protected List f322b = null;

    /* renamed from: c, reason: collision with root package name */
    protected List f323c = null;

    /* renamed from: d, reason: collision with root package name */
    protected List f324d = null;

    /* renamed from: e, reason: collision with root package name */
    protected List f325e = null;

    /* renamed from: f, reason: collision with root package name */
    protected List f326f = null;

    /* renamed from: g, reason: collision with root package name */
    protected List f327g = null;

    /* renamed from: h, reason: collision with root package name */
    protected List f328h = null;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f329i = true;

    public void b(h1 h1Var) {
        if (h1Var == null) {
            return;
        }
        if (h1Var instanceof q) {
            g().add((q) h1Var);
        }
        if (h1Var instanceof i) {
            f().add((i) h1Var);
        }
    }

    public boolean c(o0 o0Var, Object obj, String str, Object obj2) {
        List list = o0Var.f323c;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        List list2 = this.f323c;
        if (list2 == null) {
            return true;
        }
        Iterator it2 = list2.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        android.support.v4.media.session.c.a(it2.next());
        throw null;
    }

    public boolean e(o0 o0Var, Object obj, String str) {
        List list = o0Var.f326f;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        List list2 = this.f326f;
        if (list2 == null) {
            return true;
        }
        Iterator it2 = list2.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        android.support.v4.media.session.c.a(it2.next());
        throw null;
    }

    public List f() {
        if (this.f322b == null) {
            this.f322b = new ArrayList();
            this.f329i = false;
        }
        return this.f322b;
    }

    public List g() {
        if (this.f321a == null) {
            this.f321a = new ArrayList();
            this.f329i = false;
        }
        return this.f321a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h(o0 o0Var, Object obj, String str, Object obj2) {
        List list = o0Var.f325e;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        List list2 = this.f325e;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.c.a(it2.next());
                throw null;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object i(o0 o0Var, p pVar, Object obj, String str, Object obj2, int i11) {
        boolean z10;
        if (obj2 != null) {
            int i12 = o0Var.f371k.f344c;
            SerializerFeature serializerFeature = SerializerFeature.WriteNonStringValueAsString;
            if ((SerializerFeature.isEnabled(i12, i11, serializerFeature) || !(pVar == null || (pVar.a() & serializerFeature.mask) == 0)) && (((z10 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String b11 = (!z10 || pVar == null) ? null : pVar.b();
                obj2 = b11 != null ? new DecimalFormat(b11).format(obj2) : obj2.toString();
            } else if (pVar != null && pVar.c()) {
                obj2 = com.alibaba.fastjson.a.parse((String) obj2);
            }
        }
        List list = o0Var.f324d;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        List list2 = this.f324d;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            if (it2.hasNext()) {
                android.support.v4.media.session.c.a(it2.next());
                throw null;
            }
        }
        List list3 = o0Var.f328h;
        if (list3 != null) {
            Iterator it3 = list3.iterator();
            if (it3.hasNext()) {
                android.support.v4.media.session.c.a(it3.next());
                throw null;
            }
        }
        List list4 = this.f328h;
        if (list4 != null) {
            Iterator it4 = list4.iterator();
            if (it4.hasNext()) {
                android.support.v4.media.session.c.a(it4.next());
                throw null;
            }
        }
        return obj2;
    }
}
