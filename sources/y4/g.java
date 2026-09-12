package y4;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public Object f78989a;

    /* renamed from: b, reason: collision with root package name */
    public final g f78990b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f78991c;

    /* renamed from: d, reason: collision with root package name */
    public final int f78992d;

    /* renamed from: e, reason: collision with root package name */
    public Type f78993e;

    /* renamed from: f, reason: collision with root package name */
    private transient String f78994f;

    public g(g gVar, Object obj, Object obj2) {
        this.f78990b = gVar;
        this.f78989a = obj;
        this.f78991c = obj2;
        this.f78992d = gVar == null ? 0 : gVar.f78992d + 1;
    }

    public String toString() {
        if (this.f78994f == null) {
            if (this.f78990b == null) {
                this.f78994f = "$";
            } else if (this.f78991c instanceof Integer) {
                this.f78994f = this.f78990b.toString() + "[" + this.f78991c + "]";
            } else {
                this.f78994f = this.f78990b.toString() + "." + this.f78991c;
            }
        }
        return this.f78994f;
    }
}
