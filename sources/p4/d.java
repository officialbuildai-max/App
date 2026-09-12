package p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f72419c = new d("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    private final List f72420a;

    /* renamed from: b, reason: collision with root package name */
    private e f72421b;

    private d(d dVar) {
        this.f72420a = new ArrayList(dVar.f72420a);
        this.f72421b = dVar.f72421b;
    }

    public d(String... strArr) {
        this.f72420a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.f72420a.get(r0.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public d a(String str) {
        d dVar = new d(this);
        dVar.f72420a.add(str);
        return dVar;
    }

    public boolean c(String str, int i11) {
        if (i11 >= this.f72420a.size()) {
            return false;
        }
        boolean z10 = i11 == this.f72420a.size() - 1;
        String str2 = (String) this.f72420a.get(i11);
        if (!str2.equals("**")) {
            return (z10 || (i11 == this.f72420a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z10 && ((String) this.f72420a.get(i11 + 1)).equals(str)) {
            return i11 == this.f72420a.size() + (-2) || (i11 == this.f72420a.size() + (-3) && b());
        }
        if (z10) {
            return true;
        }
        int i12 = i11 + 1;
        if (i12 < this.f72420a.size() - 1) {
            return false;
        }
        return ((String) this.f72420a.get(i12)).equals(str);
    }

    public e d() {
        return this.f72421b;
    }

    public int e(String str, int i11) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.f72420a.get(i11)).equals("**")) {
            return (i11 != this.f72420a.size() - 1 && ((String) this.f72420a.get(i11 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f72420a.equals(dVar.f72420a)) {
            return false;
        }
        e eVar = this.f72421b;
        e eVar2 = dVar.f72421b;
        return eVar != null ? eVar.equals(eVar2) : eVar2 == null;
    }

    public boolean g(String str, int i11) {
        if (f(str)) {
            return true;
        }
        if (i11 >= this.f72420a.size()) {
            return false;
        }
        return ((String) this.f72420a.get(i11)).equals(str) || ((String) this.f72420a.get(i11)).equals("**") || ((String) this.f72420a.get(i11)).equals("*");
    }

    public boolean h(String str, int i11) {
        return "__container".equals(str) || i11 < this.f72420a.size() - 1 || ((String) this.f72420a.get(i11)).equals("**");
    }

    public int hashCode() {
        int hashCode = this.f72420a.hashCode() * 31;
        e eVar = this.f72421b;
        return hashCode + (eVar != null ? eVar.hashCode() : 0);
    }

    public d i(e eVar) {
        d dVar = new d(this);
        dVar.f72421b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.f72420a);
        sb2.append(",resolved=");
        sb2.append(this.f72421b != null);
        sb2.append('}');
        return sb2.toString();
    }
}
